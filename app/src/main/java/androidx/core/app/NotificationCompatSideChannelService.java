package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.p000v4.app.INotificationSideChannel;

/* loaded from: classes3.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    /* loaded from: classes3.dex */
    public class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        public NotificationSideChannelStub() {
        }

        @Override // android.support.p000v4.app.INotificationSideChannel
        public void cancel(String str, int i, String str2) throws RemoteException {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancel(str, i, str2);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        @Override // android.support.p000v4.app.INotificationSideChannel
        public void cancelAll(String str) {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancelAll(str);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        @Override // android.support.p000v4.app.INotificationSideChannel
        public void notify(String str, int i, String str2, Notification notification) throws RemoteException {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.notify(str, i, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public abstract void cancel(String str, int i, String str2);

    public abstract void cancelAll(String str);

    public void checkPermission(int i, String str) {
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i + " is not authorized for package " + str);
    }

    public abstract void notify(String str, int i, String str2, Notification notification);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        intent.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL);
        return null;
    }
}