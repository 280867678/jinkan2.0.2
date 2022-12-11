package me.tvspark.utils.cast.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.stub.StubApp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import me.tvspark.op0;
import me.tvspark.view.activity.HomeActivity;
import white.whale.R;

/* loaded from: classes4.dex */
public class SystemService extends Service {
    public PowerManager.WakeLock Wwwwwwwwwwwwwwwwwwwww;
    public op0 Wwwwwwwwwwwwwwwwwwwwww;
    public Binder Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public ExecutorService Wwwwwwwwwwwwwwwwwwwwwww = Executors.newCachedThreadPool();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Binder {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    static {
        StubApp.interface11(10939);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        op0 op0Var = new op0();
        this.Wwwwwwwwwwwwwwwwwwwwww = op0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww.execute(op0Var);
        try {
            NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_notify_cast).setContentTitle("投屏服务正在运行");
            Intent intent = new Intent(this, HomeActivity.class);
            TaskStackBuilder create = TaskStackBuilder.create(this);
            create.addParentStack(HomeActivity.class);
            create.addNextIntent(intent);
            contentTitle.setContentIntent(create.getPendingIntent(0, 134217728));
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("so.tita.cast", "tita cast", 4));
                contentTitle.setChannelId("so.tita.cast");
            }
            Notification build = contentTitle.build();
            notificationManager.notify(2, build);
            startForeground(2, build);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (!((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations(getPackageName())) {
                    Intent intent2 = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent2.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(intent2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870913, "so:tita");
            this.Wwwwwwwwwwwwwwwwwwwww = newWakeLock;
            newWakeLock.acquire();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        PowerManager.WakeLock wakeLock = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wakeLock != null) {
            wakeLock.release();
        }
        super.onDestroy();
    }
}
