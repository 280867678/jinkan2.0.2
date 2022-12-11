package me.tvspark.utils.web;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.InetAddress;
import me.tvspark.ao0;
import me.tvspark.sk0;
import me.tvspark.utils.web.WebService;
import me.tvspark.utils.wifitransfer.Defaults;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebService extends Service implements sk0 {
    public static boolean sIsRunning;
    public HttpServer httpServer;
    public String CHANNEL_NAME = "channel_web_source";
    public String CHANNEL_ID = "channel_web_source";

    private int getPort() {
        Defaults.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return 8590;
    }

    private PendingIntent getThisServicePendingIntent() {
        Intent intent = new Intent(this, WebService.class);
        intent.setAction("doneService");
        return PendingIntent.getService(this, 0, intent, 134217728);
    }

    public static boolean startThis(Context context) {
        if (sIsRunning) {
            return false;
        }
        Intent intent = new Intent(context, WebService.class);
        intent.setAction("startService");
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static void upHttpServer(Activity activity) {
        if (sIsRunning) {
            Intent intent = new Intent(activity, WebService.class);
            intent.setAction("startService");
            activity.startService(intent);
        }
    }

    private void upServer() {
        HttpServer httpServer = this.httpServer;
        if (httpServer != null && httpServer.isAlive()) {
            this.httpServer.stop();
        }
        int port = getPort();
        this.httpServer = new HttpServer(port);
        InetAddress Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ao0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            try {
                this.httpServer.start();
                sIsRunning = true;
                updateNotification(getString(R.string.http_ip, new Object[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHostAddress(), Integer.valueOf(port)}));
                return;
            } catch (IOException unused) {
            }
        }
        stopSelf();
    }

    private void updateNotification(String str) {
        Notification build;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(this.CHANNEL_ID, this.CHANNEL_NAME, 4);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
            build = new NotificationCompat.Builder(this, this.CHANNEL_ID).setContentTitle("自定义源Web服务").setContentText(str).setSmallIcon(R.drawable.ic_web_service_noti).setOngoing(true).addAction(R.drawable.ic_stop_black_24dp, "取消", getThisServicePendingIntent()).setContentIntent(getThisServicePendingIntent()).setVisibility(1).build();
        } else {
            build = new Notification.Builder(this).setContentTitle("自定义源Web服务").setContentText(str).setSmallIcon(R.drawable.ic_web_service_noti).setOngoing(true).addAction(R.drawable.ic_stop_black_24dp, "取消", getThisServicePendingIntent()).setVisibility(1).setContentIntent(getThisServicePendingIntent()).build();
        }
        Defaults.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        startForeground(8590, build);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Toast.makeText(this, "正在启动服务\n具体信息查看通知栏", 0).show();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        updateNotification("正在启动服务");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: me.tvspark.sr0
            @Override // java.lang.Runnable
            public final void run() {
                WebService.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        sIsRunning = false;
        HttpServer httpServer = this.httpServer;
        if (httpServer == null || !httpServer.isAlive()) {
            return;
        }
        this.httpServer.stop();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action;
        if (intent != null && (action = intent.getAction()) != null) {
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1612143405) {
                if (hashCode == 1849706483 && action.equals("startService")) {
                    c = 0;
                }
            } else if (action.equals("doneService")) {
                c = 1;
            }
            if (c == 0) {
                upServer();
            } else if (c == 1) {
                stopSelf();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
