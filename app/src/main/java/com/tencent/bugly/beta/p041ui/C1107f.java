package com.tencent.bugly.beta.p041ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1249y;
import java.util.Locale;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.beta.ui.f */
/* loaded from: classes3.dex */
public class C1107f {

    /* renamed from: a */
    public static C1107f f819a = new C1107f();

    /* renamed from: c */
    public Notification f821c;

    /* renamed from: e */
    public DownloadTask f823e;

    /* renamed from: h */
    public long f826h;

    /* renamed from: i */
    public NotificationCompat.Builder f827i;

    /* renamed from: j */
    public C1177B f828j;

    /* renamed from: k */
    public AbstractC1106e f829k;

    /* renamed from: g */
    public boolean f825g = true;

    /* renamed from: d */
    public Context f822d = C1093e.f737b.f789v;

    /* renamed from: f */
    public String f824f = this.f822d.getPackageName() + ".beta.DOWNLOAD_NOTIFY";

    /* renamed from: b */
    public NotificationManager f820b = (NotificationManager) this.f822d.getSystemService("notification");

    public C1107f() {
        this.f822d.registerReceiver(new BetaReceiver(), new IntentFilter(this.f824f));
        m3590b();
    }

    /* renamed from: b */
    private void m3590b() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("001", "bugly_upgrade", 2);
            notificationChannel.setDescription("bugly upgrade");
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            this.f820b.createNotificationChannel(notificationChannel);
        }
    }

    /* renamed from: a */
    public void m3593a() {
        DownloadTask downloadTask;
        NotificationCompat.Builder contentTitle;
        String format;
        NotificationCompat.Builder contentText;
        String format2;
        if (!this.f825g || (downloadTask = this.f823e) == null || !C1093e.f737b.f757T) {
            return;
        }
        if (downloadTask.getSavedLength() - this.f826h <= 307200 && this.f823e.getStatus() != 1 && this.f823e.getStatus() != 5 && this.f823e.getStatus() != 3) {
            return;
        }
        this.f826h = this.f823e.getSavedLength();
        if (this.f823e.getStatus() == 1) {
            contentText = this.f827i.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall);
            format2 = String.format("%s %s", C1093e.f737b.f739B, Beta.strNotificationDownloadSucc);
        } else if (this.f823e.getStatus() != 5) {
            long j = 0;
            if (this.f823e.getStatus() != 2) {
                if (this.f823e.getStatus() == 3) {
                    contentTitle = this.f827i.setContentTitle(C1093e.f737b.f739B);
                    Locale locale = Locale.getDefault();
                    Object[] objArr = new Object[2];
                    objArr[0] = Beta.strNotificationClickToContinue;
                    if (this.f823e.getTotalLength() != 0) {
                        j = (this.f823e.getSavedLength() * 100) / this.f823e.getTotalLength();
                    }
                    objArr[1] = Integer.valueOf((int) j);
                    format = String.format(locale, "%s %d%%", objArr);
                }
                Notification build = this.f827i.build();
                this.f821c = build;
                this.f820b.notify(1000, build);
            }
            contentTitle = this.f827i.setContentTitle(C1093e.f737b.f739B);
            Locale locale2 = Locale.getDefault();
            Object[] objArr2 = new Object[2];
            objArr2[0] = Beta.strNotificationDownloading;
            if (this.f823e.getTotalLength() != 0) {
                j = (this.f823e.getSavedLength() * 100) / this.f823e.getTotalLength();
            }
            objArr2[1] = Integer.valueOf((int) j);
            format = String.format(locale2, "%s %d%%", objArr2);
            contentTitle.setContentText(format).setAutoCancel(false);
            Notification build2 = this.f827i.build();
            this.f821c = build2;
            this.f820b.notify(1000, build2);
        } else {
            contentText = this.f827i.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry);
            format2 = String.format("%s %s", C1093e.f737b.f739B, Beta.strNotificationDownloadError);
        }
        contentText.setContentTitle(format2);
        Notification build22 = this.f827i.build();
        this.f821c = build22;
        this.f820b.notify(1000, build22);
    }

    /* renamed from: a */
    public void m3592a(DownloadTask downloadTask) {
        ApplicationInfo applicationInfo;
        NotificationCompat.Builder builder;
        this.f823e = downloadTask;
        this.f826h = downloadTask.getSavedLength();
        boolean isNeededNotify = downloadTask.isNeededNotify();
        this.f825g = isNeededNotify;
        if (!isNeededNotify || !C1093e.f737b.f757T) {
            return;
        }
        this.f820b.cancel(1000);
        Intent intent = new Intent(this.f824f);
        intent.putExtra("request", 1);
        if (this.f827i == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.f827i = new NotificationCompat.Builder(this.f822d, "001");
                } catch (Throwable unused) {
                    builder = new NotificationCompat.Builder(this.f822d);
                }
            } else {
                builder = new NotificationCompat.Builder(this.f822d);
            }
            this.f827i = builder;
        }
        NotificationCompat.Builder builder2 = this.f827i;
        NotificationCompat.Builder contentTitle = builder2.setTicker(Beta.strNotificationDownloading + C1093e.f737b.f739B).setContentTitle(C1093e.f737b.f739B);
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[2];
        objArr[0] = Beta.strNotificationDownloading;
        long j = 0;
        if (this.f823e.getTotalLength() != 0) {
            j = (this.f823e.getSavedLength() * 100) / this.f823e.getTotalLength();
        }
        objArr[1] = Integer.valueOf((int) j);
        contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setContentIntent(PendingIntent.getBroadcast(this.f822d, 1, intent, 268435456)).setAutoCancel(false);
        C1093e c1093e = C1093e.f737b;
        int i = c1093e.f776i;
        if (i > 0) {
            this.f827i.setSmallIcon(i);
        } else {
            PackageInfo packageInfo = c1093e.f740C;
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                this.f827i.setSmallIcon(applicationInfo.icon);
            }
        }
        try {
            if (C1093e.f737b.f777j > 0 && this.f822d.getResources().getDrawable(C1093e.f737b.f777j) != null) {
                this.f827i.setLargeIcon(C1089a.m3620a(this.f822d.getResources().getDrawable(C1093e.f737b.f777j)));
            }
        } catch (Resources.NotFoundException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[initNotify] ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            C1199X.m3082b(C1107f.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        Notification build = this.f827i.build();
        this.f821c = build;
        this.f820b.notify(1000, build);
    }

    /* renamed from: a */
    public synchronized void m3591a(C1177B c1177b, AbstractC1106e abstractC1106e) {
        ApplicationInfo applicationInfo;
        this.f828j = c1177b;
        this.f829k = abstractC1106e;
        this.f820b.cancel(1001);
        Intent intent = new Intent(this.f824f);
        intent.putExtra("request", 2);
        if (this.f827i == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f827i = new NotificationCompat.Builder(this.f822d, "001");
            } else {
                this.f827i = new NotificationCompat.Builder(this.f822d);
            }
        }
        NotificationCompat.Builder builder = this.f827i;
        NotificationCompat.Builder autoCancel = builder.setTicker(C1093e.f737b.f739B + Beta.strNotificationHaveNewVersion).setContentTitle(String.format("%s %s", C1093e.f737b.f739B, Beta.strNotificationHaveNewVersion)).setContentIntent(PendingIntent.getBroadcast(this.f822d, 2, intent, 268435456)).setAutoCancel(true);
        C1249y c1249y = c1177b.f1332j;
        autoCancel.setContentText(String.format("%s.%s", c1249y.f1671e, Integer.valueOf(c1249y.f1670d)));
        C1093e c1093e = C1093e.f737b;
        int i = c1093e.f776i;
        if (i > 0) {
            this.f827i.setSmallIcon(i);
        } else {
            PackageInfo packageInfo = c1093e.f740C;
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                this.f827i.setSmallIcon(applicationInfo.icon);
            }
        }
        if (C1093e.f737b.f777j > 0 && this.f822d.getResources().getDrawable(C1093e.f737b.f777j) != null) {
            this.f827i.setLargeIcon(C1089a.m3620a(this.f822d.getResources().getDrawable(C1093e.f737b.f777j)));
        }
        Notification build = this.f827i.build();
        this.f821c = build;
        this.f820b.notify(1001, build);
    }
}
