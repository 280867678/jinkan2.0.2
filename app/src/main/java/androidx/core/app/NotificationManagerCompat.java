package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.p000v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    public static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    public static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    public static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    public static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    public static final String TAG = "NotifManCompat";
    @GuardedBy("sEnabledNotificationListenersLock")
    public static String sEnabledNotificationListeners;
    @GuardedBy("sLock")
    public static SideChannelManager sSideChannelManager;
    public final Context mContext;
    public final NotificationManager mNotificationManager;
    public static final Object sEnabledNotificationListenersLock = new Object();
    @GuardedBy("sEnabledNotificationListenersLock")
    public static Set<String> sEnabledNotificationListenerPackages = new HashSet();
    public static final Object sLock = new Object();

    /* loaded from: classes3.dex */
    public static class CancelTask implements Task {
        public final boolean all;

        /* renamed from: id */
        public final int f50id;
        public final String packageName;
        public final String tag;

        public CancelTask(String str) {
            this.packageName = str;
            this.f50id = 0;
            this.tag = null;
            this.all = true;
        }

        public CancelTask(String str, int i, String str2) {
            this.packageName = str;
            this.f50id = i;
            this.tag = str2;
            this.all = false;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.all) {
                iNotificationSideChannel.cancelAll(this.packageName);
            } else {
                iNotificationSideChannel.cancel(this.packageName, this.f50id, this.tag);
            }
        }

        @NonNull
        public String toString() {
            return "CancelTask[packageName:" + this.packageName + ", id:" + this.f50id + ", tag:" + this.tag + ", all:" + this.all + "]";
        }
    }

    /* loaded from: classes3.dex */
    public static class NotifyTask implements Task {

        /* renamed from: id */
        public final int f51id;
        public final Notification notif;
        public final String packageName;
        public final String tag;

        public NotifyTask(String str, int i, String str2, Notification notification) {
            this.packageName = str;
            this.f51id = i;
            this.tag = str2;
            this.notif = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.packageName, this.f51id, this.tag, this.notif);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:");
            sb.append(this.packageName);
            sb.append(", id:");
            sb.append(this.f51id);
            sb.append(", tag:");
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.tag, "]");
        }
    }

    /* loaded from: classes3.dex */
    public static class ServiceConnectedEvent {
        public final ComponentName componentName;
        public final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    /* loaded from: classes3.dex */
    public static class SideChannelManager implements Handler.Callback, ServiceConnection {
        public static final int MSG_QUEUE_TASK = 0;
        public static final int MSG_RETRY_LISTENER_QUEUE = 3;
        public static final int MSG_SERVICE_CONNECTED = 1;
        public static final int MSG_SERVICE_DISCONNECTED = 2;
        public final Context mContext;
        public final Handler mHandler;
        public final HandlerThread mHandlerThread;
        public final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap();
        public Set<String> mCachedEnabledPackages = new HashSet();

        /* loaded from: classes3.dex */
        public static class ListenerRecord {
            public final ComponentName componentName;
            public INotificationSideChannel service;
            public boolean bound = false;
            public ArrayDeque<Task> taskQueue = new ArrayDeque<>();
            public int retryCount = 0;

            public ListenerRecord(ComponentName componentName) {
                this.componentName = componentName;
            }
        }

        public SideChannelManager(Context context) {
            this.mContext = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        private boolean ensureServiceBound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                return true;
            }
            boolean bindService = this.mContext.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.componentName), this, 33);
            listenerRecord.bound = bindService;
            if (bindService) {
                listenerRecord.retryCount = 0;
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to bind to listener ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(listenerRecord.componentName);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                this.mContext.unbindService(this);
            }
            return listenerRecord.bound;
        }

        private void ensureServiceUnbound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                this.mContext.unbindService(this);
                listenerRecord.bound = false;
            }
            listenerRecord.service = null;
        }

        private void handleQueueTask(Task task) {
            updateListenerMap();
            for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
                listenerRecord.taskQueue.add(task);
                processListenerQueue(listenerRecord);
            }
        }

        private void handleRetryListenerQueue(ComponentName componentName) {
            ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.service = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.retryCount = 0;
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceDisconnected(ComponentName componentName) {
            ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                ensureServiceUnbound(listenerRecord);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void processListenerQueue(ListenerRecord listenerRecord) {
            StringBuilder sb;
            String str;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Processing component ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(listenerRecord.componentName);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(listenerRecord.taskQueue.size());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" queued tasks");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            if (!ensureServiceBound(listenerRecord) || listenerRecord.service == null) {
                scheduleListenerRetry(listenerRecord);
                return;
            }
            while (true) {
                Task peek = listenerRecord.taskQueue.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        String str2 = "Sending task " + peek;
                    }
                    peek.send(listenerRecord.service);
                    listenerRecord.taskQueue.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        sb = new StringBuilder();
                        str = "Remote service has died: ";
                        sb.append(str);
                        sb.append(listenerRecord.componentName);
                        sb.toString();
                    }
                } catch (RemoteException unused2) {
                    sb = new StringBuilder();
                    str = "RemoteException communicating with ";
                    sb.append(str);
                    sb.append(listenerRecord.componentName);
                    sb.toString();
                    if (!listenerRecord.taskQueue.isEmpty()) {
                    }
                }
            }
            if (!listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            scheduleListenerRetry(listenerRecord);
        }

        private void scheduleListenerRetry(ListenerRecord listenerRecord) {
            if (this.mHandler.hasMessages(3, listenerRecord.componentName)) {
                return;
            }
            int i = listenerRecord.retryCount + 1;
            listenerRecord.retryCount = i;
            if (i <= 6) {
                Log.isLoggable(NotificationManagerCompat.TAG, 3);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord.componentName), (1 << (i - 1)) * 1000);
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Giving up on delivering ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(listenerRecord.taskQueue.size());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" tasks to ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(listenerRecord.componentName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" after ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(listenerRecord.retryCount);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" retries");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            listenerRecord.taskQueue.clear();
        }

        private void updateListenerMap() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
                return;
            }
            this.mCachedEnabledPackages = enabledListenerPackages;
            List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        String str = "Permission present on component " + componentName + ", not adding listener record.";
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ComponentName componentName2 = (ComponentName) it.next();
                if (!this.mRecordMap.containsKey(componentName2)) {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        String str2 = "Adding listener record for " + componentName2;
                    }
                    this.mRecordMap.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, ListenerRecord>> it2 = this.mRecordMap.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<ComponentName, ListenerRecord> next = it2.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Removing listener record for ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(next.getKey());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    }
                    ensureServiceUnbound(next.getValue());
                    it2.remove();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                handleQueueTask((Task) message.obj);
                return true;
            } else if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                return true;
            } else if (i == 2) {
                handleServiceDisconnected((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                handleRetryListenerQueue((ComponentName) message.obj);
                return true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                String str = "Connected to service " + componentName;
            }
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                String str = "Disconnected from service " + componentName;
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        public void queueTask(Task task) {
            this.mHandler.obtainMessage(0, task).sendToTarget();
        }
    }

    /* loaded from: classes3.dex */
    public interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (sEnabledNotificationListenersLock) {
            if (string != null) {
                if (!string.equals(sEnabledNotificationListeners)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    sEnabledNotificationListenerPackages = hashSet;
                    sEnabledNotificationListeners = string;
                }
            }
            set = sEnabledNotificationListenerPackages;
        }
        return set;
    }

    private void pushSideChannelQueue(Task task) {
        synchronized (sLock) {
            if (sSideChannelManager == null) {
                sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());
            }
            sSideChannelManager.queueTask(task);
        }
    }

    public static boolean useSideChannelForNotification(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mNotificationManager.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        String packageName = this.mContext.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(@Nullable String str, int i) {
        this.mNotificationManager.cancel(str, i);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotificationChannel(@NonNull NotificationChannelCompat notificationChannelCompat) {
        createNotificationChannel(notificationChannelCompat.getNotificationChannel());
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroupCompat notificationChannelGroupCompat) {
        createNotificationChannelGroup(notificationChannelGroupCompat.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannelGroups(list);
        }
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<NotificationChannelGroupCompat> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (NotificationChannelGroupCompat notificationChannelGroupCompat : list) {
            arrayList.add(notificationChannelGroupCompat.getNotificationChannelGroup());
        }
        this.mNotificationManager.createNotificationChannelGroups(arrayList);
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannels(list);
        }
    }

    public void createNotificationChannelsCompat(@NonNull List<NotificationChannelCompat> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (NotificationChannelCompat notificationChannelCompat : list) {
            arrayList.add(notificationChannelCompat.getNotificationChannel());
        }
        this.mNotificationManager.createNotificationChannels(arrayList);
    }

    public void deleteNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.deleteNotificationChannel(str);
        }
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.deleteNotificationChannelGroup(str);
        }
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannel notificationChannel : this.mNotificationManager.getNotificationChannels()) {
                if (!collection.contains(notificationChannel.getId()) && (Build.VERSION.SDK_INT < 30 || !collection.contains(notificationChannel.getParentChannelId()))) {
                    this.mNotificationManager.deleteNotificationChannel(notificationChannel.getId());
                }
            }
        }
    }

    public int getImportance() {
        return Build.VERSION.SDK_INT >= 24 ? this.mNotificationManager.getImportance() : IMPORTANCE_UNSPECIFIED;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mNotificationManager.getNotificationChannel(str);
        }
        return null;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str, @NonNull String str2) {
        return Build.VERSION.SDK_INT >= 30 ? this.mNotificationManager.getNotificationChannel(str, str2) : getNotificationChannel(str);
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String str) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String str, @NonNull String str2) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str, str2)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return this.mNotificationManager.getNotificationChannelGroup(str);
        }
        if (i >= 26) {
            for (NotificationChannelGroup notificationChannelGroup : getNotificationChannelGroups()) {
                if (notificationChannelGroup.getId().equals(str)) {
                    return notificationChannelGroup;
                }
            }
        }
        return null;
    }

    @Nullable
    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(@NonNull String str) {
        NotificationChannelGroup notificationChannelGroup;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            NotificationChannelGroup notificationChannelGroup2 = getNotificationChannelGroup(str);
            if (notificationChannelGroup2 == null) {
                return null;
            }
            return new NotificationChannelGroupCompat(notificationChannelGroup2);
        } else if (i >= 26 && (notificationChannelGroup = getNotificationChannelGroup(str)) != null) {
            return new NotificationChannelGroupCompat(notificationChannelGroup, getNotificationChannels());
        } else {
            return null;
        }
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return Build.VERSION.SDK_INT >= 26 ? this.mNotificationManager.getNotificationChannelGroups() : Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannelGroup> notificationChannelGroups = getNotificationChannelGroups();
            if (!notificationChannelGroups.isEmpty()) {
                List<NotificationChannel> emptyList = Build.VERSION.SDK_INT >= 28 ? Collections.emptyList() : getNotificationChannels();
                ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
                for (NotificationChannelGroup notificationChannelGroup : notificationChannelGroups) {
                    arrayList.add(Build.VERSION.SDK_INT >= 28 ? new NotificationChannelGroupCompat(notificationChannelGroup) : new NotificationChannelGroupCompat(notificationChannelGroup, emptyList));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        return Build.VERSION.SDK_INT >= 26 ? this.mNotificationManager.getNotificationChannels() : Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = getNotificationChannels();
            if (!notificationChannels.isEmpty()) {
                ArrayList arrayList = new ArrayList(notificationChannels.size());
                for (NotificationChannel notificationChannel : notificationChannels) {
                    arrayList.add(new NotificationChannelCompat(notificationChannel));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public void notify(int i, @NonNull Notification notification) {
        notify(null, i, notification);
    }

    public void notify(@Nullable String str, int i, @NonNull Notification notification) {
        if (!useSideChannelForNotification(notification)) {
            this.mNotificationManager.notify(str, i, notification);
            return;
        }
        pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), i, str, notification));
        this.mNotificationManager.cancel(str, i);
    }
}
