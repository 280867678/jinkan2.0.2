package com.arialyy.aria.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.PopupWindow;
import com.arialyy.aria.core.command.CommandManager;
import com.arialyy.aria.core.common.QueueMod;
import com.arialyy.aria.core.config.AppConfig;
import com.arialyy.aria.core.config.DGroupConfig;
import com.arialyy.aria.core.config.DownloadConfig;
import com.arialyy.aria.core.config.UploadConfig;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.download.DownloadReceiver;
import com.arialyy.aria.core.inf.AbsReceiver;
import com.arialyy.aria.core.inf.IReceiver;
import com.arialyy.aria.core.inf.ReceiverType;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.core.upload.UploadReceiver;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.orm.DelegateWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.AriaCrashHandler;
import com.arialyy.aria.util.DeleteURecord;
import com.arialyy.aria.util.RecordUtil;
import com.stub.StubApp;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(14)
/* loaded from: classes3.dex */
public class AriaManager {
    public static Context APP = null;
    public static final String TAG = "AriaManager";
    public AriaConfig mConfig;
    public DelegateWrapper mDbWrapper;
    public Map<String, AbsReceiver> mReceivers = new ConcurrentHashMap();
    public Map<String, List<String>> mSubClass = new ConcurrentHashMap();
    public static final Object LOCK = new Object();
    public static List<String> mFragmentClassName = new ArrayList();
    public static List<String> mDialogFragmentClassName = new ArrayList();
    @SuppressLint({"StaticFieldLeak"})
    public static volatile AriaManager INSTANCE = null;

    /* loaded from: classes3.dex */
    public class LifeCallback implements Application.ActivityLifecycleCallbacks {
        public LifeCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            AriaManager.this.removeReceiver(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        mFragmentClassName.add("androidx.fragment.app.Fragment");
        mFragmentClassName.add("androidx.fragment.app.DialogFragment");
        mFragmentClassName.add("android.app.Fragment");
        mFragmentClassName.add("android.app.DialogFragment");
        mFragmentClassName.add("android.support.v4.app.Fragment");
        mFragmentClassName.add("android.support.v4.app.DialogFragment");
        mDialogFragmentClassName.add("androidx.fragment.app.DialogFragment");
        mDialogFragmentClassName.add("android.app.DialogFragment");
        mDialogFragmentClassName.add("android.support.v4.app.DialogFragment");
    }

    public AriaManager(Context context) {
        APP = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private void amendTaskState() {
        Class[] clsArr = {DownloadEntity.class, UploadEntity.class, DownloadGroupEntity.class};
        for (int i = 0; i < 3; i++) {
            Class cls = clsArr[i];
            if (this.mDbWrapper.tableExists(cls)) {
                DbEntity.exeSql(String.format("UPDATE %s SET state=2 WHERE state IN (4,5,6)", cls.getSimpleName()));
            }
        }
    }

    private Dialog getDialog(Object obj) {
        try {
            return (Dialog) obj.getClass().getMethod("getDialog", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Activity getFragmentActivity(Object obj) {
        try {
            return (Activity) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static AriaManager getInstance() {
        return INSTANCE;
    }

    private String getKey(String str, Object obj) {
        return String.format("%s_%s_%s", obj.getClass().getName(), str, Integer.valueOf(obj.hashCode()));
    }

    public static AriaManager init(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new AriaManager(context);
                    INSTANCE.initData();
                }
            }
        }
        return INSTANCE;
    }

    private void initAria() {
        AppConfig aConfig = this.mConfig.getAConfig();
        if (aConfig.getUseAriaCrashHandler()) {
            Thread.setDefaultUncaughtExceptionHandler(new AriaCrashHandler());
        }
        aConfig.setLogLevel(aConfig.getLogLevel());
        CommandManager.init();
    }

    private void initData() {
        this.mConfig = AriaConfig.init(APP);
        initDb(APP);
        regAppLifeCallback(APP);
        initAria();
    }

    private void initDb(Context context) {
        File databasePath = context.getDatabasePath("AriaLyyDb");
        if (databasePath != null && databasePath.exists()) {
            File file = new File(String.format("%s/%s", databasePath.getParent(), "AriaLyyDb-journal"));
            databasePath.renameTo(new File(String.format("%s/%s", databasePath.getParent(), "AndroidAria.db")));
            if (file.exists()) {
                file.delete();
            }
        }
        this.mDbWrapper = DelegateWrapper.init(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        amendTaskState();
    }

    private boolean isDialogFragment(Class cls) {
        Class superclass = cls.getSuperclass();
        if (superclass == null) {
            return false;
        }
        if (!mDialogFragmentClassName.contains(superclass.getName())) {
            return isDialogFragment(superclass);
        }
        return true;
    }

    public static boolean isFragment(Class cls) {
        Class superclass = cls.getSuperclass();
        if (superclass == null) {
            return false;
        }
        if (!mFragmentClassName.contains(superclass.getName())) {
            return isFragment(superclass);
        }
        return true;
    }

    private IReceiver putReceiver(String str, Object obj) {
        Context context;
        String key = getKey(str, obj);
        AbsReceiver absReceiver = this.mReceivers.get(key);
        WidgetLiftManager widgetLiftManager = new WidgetLiftManager();
        boolean z = false;
        if (obj instanceof Dialog) {
            Dialog dialog = (Dialog) obj;
            z = widgetLiftManager.handleDialogLift(dialog);
            context = dialog.getOwnerActivity();
        } else if (obj instanceof PopupWindow) {
            PopupWindow popupWindow = (PopupWindow) obj;
            z = widgetLiftManager.handlePopupWindowLift(popupWindow);
            context = popupWindow.getContentView().getContext();
        } else {
            if (isDialogFragment(obj.getClass())) {
                z = widgetLiftManager.handleDialogFragmentLift(getDialog(obj));
            } else if (!isFragment(obj.getClass())) {
                context = null;
            }
            context = getFragmentActivity(obj);
        }
        if (context instanceof Activity) {
            relateSubClass(str, obj, (Activity) context);
        }
        if (absReceiver == null) {
            AbsReceiver downloadReceiver = str.equals(ReceiverType.DOWNLOAD) ? new DownloadReceiver() : new UploadReceiver();
            downloadReceiver.targetName = obj.getClass().getName();
            AbsReceiver.OBJ_MAP.put(downloadReceiver.getKey(), obj);
            downloadReceiver.needRmListener = z;
            this.mReceivers.put(key, downloadReceiver);
            return downloadReceiver;
        }
        return absReceiver;
    }

    private void regAppLifeCallback(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext instanceof Application) {
            ((Application) origApplicationContext).registerActivityLifecycleCallbacks(new LifeCallback());
        }
    }

    private void relateSubClass(String str, Object obj, Activity activity) {
        String key = getKey(str, activity);
        List<String> list = this.mSubClass.get(key);
        if (list == null) {
            list = new ArrayList<>();
            this.mSubClass.put(key, list);
        }
        list.add(getKey(str, obj));
        if (this.mReceivers.get(key) == null) {
            this.mReceivers.put(key, new DownloadReceiver());
        }
    }

    public void delRecord(int i, String str, boolean z) {
        if (i == 1) {
            RecordUtil.delTaskRecord(str, 1, z, true);
        } else if (i == 2) {
            RecordUtil.delGroupTaskRecordByHash(str, z);
        } else if (i != 3) {
        } else {
            DeleteURecord.getInstance().deleteRecord(str, z, true);
        }
    }

    public DownloadReceiver download(Object obj) {
        AbsReceiver absReceiver = this.mReceivers.get(getKey(ReceiverType.DOWNLOAD, obj));
        if (absReceiver == null) {
            absReceiver = putReceiver(ReceiverType.DOWNLOAD, obj);
        }
        if (absReceiver instanceof DownloadReceiver) {
            return (DownloadReceiver) absReceiver;
        }
        return null;
    }

    public Context getAPP() {
        return APP;
    }

    public AppConfig getAppConfig() {
        return this.mConfig.getAConfig();
    }

    public DGroupConfig getDGroupConfig() {
        return this.mConfig.getDGConfig();
    }

    public DownloadConfig getDownloadConfig() {
        return this.mConfig.getDConfig();
    }

    public Map<String, AbsReceiver> getReceiver() {
        return this.mReceivers;
    }

    public UploadConfig getUploadConfig() {
        return this.mConfig.getUConfig();
    }

    public void removeReceiver(Object obj) {
        if (obj == null) {
            ALog.m4191e(TAG, "target obj is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, AbsReceiver>> it = this.mReceivers.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.equals(getKey(ReceiverType.DOWNLOAD, obj)) || key.equals(getKey(ReceiverType.UPLOAD, obj))) {
                AbsReceiver absReceiver = this.mReceivers.get(key);
                List<String> list = this.mSubClass.get(key);
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
                if (absReceiver != null) {
                    absReceiver.destroy();
                }
                it.remove();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, AbsReceiver>> it2 = this.mReceivers.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, AbsReceiver> next = it2.next();
            if (arrayList.contains(next.getKey())) {
                AbsReceiver absReceiver2 = this.mReceivers.get(next.getKey());
                if (absReceiver2 != null) {
                    absReceiver2.destroy();
                }
                it2.remove();
            }
        }
    }

    @Deprecated
    public AriaManager setDownloadQueueMod(QueueMod queueMod) {
        this.mConfig.getDConfig().setQueueMod(queueMod.tag);
        return this;
    }

    @Deprecated
    public AriaManager setUploadQueueMod(QueueMod queueMod) {
        this.mConfig.getUConfig().setQueueMod(queueMod.tag);
        return this;
    }

    public UploadReceiver upload(Object obj) {
        AbsReceiver absReceiver = this.mReceivers.get(getKey(ReceiverType.UPLOAD, obj));
        if (absReceiver == null) {
            absReceiver = putReceiver(ReceiverType.UPLOAD, obj);
        }
        if (absReceiver instanceof UploadReceiver) {
            return (UploadReceiver) absReceiver;
        }
        return null;
    }
}
