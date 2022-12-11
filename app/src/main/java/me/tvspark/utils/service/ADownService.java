package me.tvspark.utils.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.common.HttpOption;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.M3U8Entity;
import com.arialyy.aria.core.download.m3u8.M3U8VodOption;
import com.arialyy.aria.core.download.target.HttpBuilderTarget;
import com.arialyy.aria.core.download.target.HttpNormalTarget;
import com.arialyy.aria.core.processor.IBandWidthUrlConverter;
import com.arialyy.aria.core.processor.IHttpFileLenAdapter;
import com.arialyy.aria.core.processor.IKeyUrlConverter;
import com.arialyy.aria.core.processor.ITsMergeHandler;
import com.arialyy.aria.core.processor.IVodTsUrlConverter;
import com.arialyy.aria.util.FileUtil;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.tvspark.sk0;
import me.tvspark.view.activity.HomeActivity;
import me.tvspark.zn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class ADownService extends Service implements sk0 {
    public PowerManager.WakeLock Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements IVodTsUrlConverter {
        @Override // com.arialyy.aria.core.processor.IVodTsUrlConverter
        public List<String> convert(String str, List<String> list) {
            return zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, list);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ITsMergeHandler {
        /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
        @Override // com.arialyy.aria.core.processor.ITsMergeHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean merge(M3U8Entity m3U8Entity, List<String> list) {
            StringBuilder sb;
            boolean z;
            boolean z2 = !TextUtils.isEmpty(m3U8Entity.getKeyPath());
            if (z2) {
                z = false;
                list = zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m3U8Entity.keyPath, m3U8Entity.f163iv, list, false);
                if (!((ArrayList) list).isEmpty()) {
                    m3U8Entity.getFilePath();
                    sb = new StringBuilder();
                }
                if (!z) {
                    if (z2) {
                        File file = new File(m3U8Entity.keyPath);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    try {
                        File file2 = new File(m3U8Entity.getLocalM3u8Path());
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (z2) {
                    zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m3U8Entity.getLocalM3u8Path());
                }
                return z;
            }
            sb = new StringBuilder();
            sb.append(m3U8Entity.getFilePath());
            sb.append(".ts");
            z = FileUtil.mergeFile(sb.toString(), list);
            if (!z) {
            }
            return z;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements IKeyUrlConverter {
        @Override // com.arialyy.aria.core.processor.IKeyUrlConverter
        public String convert(String str, String str2) {
            return zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements IBandWidthUrlConverter {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // com.arialyy.aria.core.processor.IBandWidthUrlConverter
        public String convert(String str) {
            return zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements IHttpFileLenAdapter {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ADownService aDownService) {
        }

        @Override // com.arialyy.aria.core.processor.IHttpFileLenAdapter
        public long handleFileLen(Map<String, List<String>> map) {
            List<String> list = map.get("Content-Length");
            if (list == null || list.isEmpty()) {
                return -1L;
            }
            return Long.parseLong(list.get(0));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, List list) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwwwwwwwwww = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww[0] < this.Wwwwwwwwwwwwwwwwwwwwwww.size()) {
                ADownService.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((DownloadEntity) this.Wwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww[0])).getUrl(), ((DownloadEntity) this.Wwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww[0])).getId(), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww[0] + 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, List list) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwwwwwwwwww = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww[0] < this.Wwwwwwwwwwwwwwwwwwwwwww.size()) {
                ADownService.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((DownloadEntity) this.Wwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww[0])).getUrl(), ((DownloadEntity) this.Wwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww[0])).getId(), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww[0] + 1);
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_notify_download).setContentTitle("后台下载服务正在运行");
            Intent intent = new Intent(this, HomeActivity.class);
            TaskStackBuilder create = TaskStackBuilder.create(this);
            create.addParentStack(HomeActivity.class);
            create.addNextIntent(intent);
            contentTitle.setContentIntent(create.getPendingIntent(0, 134217728));
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("whale.down", "whale down", 4));
                contentTitle.setChannelId("whale.down");
            }
            Notification build = contentTitle.build();
            notificationManager.notify(1, build);
            startForeground(1, build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final HttpOption Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        HttpOption httpOption = new HttpOption();
        httpOption.addHeader("1", "@").useServerFileName(true).setFileLenAdapter(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        return httpOption;
    }

    public final M3U8VodOption Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        M3U8VodOption m3U8VodOption = new M3U8VodOption();
        m3U8VodOption.generateIndexFile().merge(true).setMergeHandler(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setKeyUrlConverter(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setVodTsUrlConvert(new Wwwwwwwwwwwwwwwwwwwwwwwwwwww()).setBandWidthUrlConverter(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        return m3U8VodOption;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, List<DownloadEntity> list, int i) {
        if (j != -1) {
            HttpNormalTarget load = Aria.download(StubApp.getOrigApplicationContext(getApplicationContext())).load(j);
            ((str.contains(".m3u8") || str.contains(".m3u")) ? load.m3u8VodOption(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) : load.option(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).ignoreCheckPermissions()).resume(false);
        }
        if (list == null || list.isEmpty() || i >= list.size()) {
            return;
        }
        int[] iArr = new int[1];
        switch (list.get(i).getState()) {
            case -1:
            case 0:
            case 2:
                int i2 = i == 0 ? 0 : 800;
                iArr[0] = i;
                new Handler().postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, list), i2);
                return;
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
                iArr[0] = i + 1;
                new Handler().postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, list), 800L);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (!((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations(getPackageName())) {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870913, "so:tita");
            this.Wwwwwwwwwwwwwwwwwwwwwwww = newWakeLock;
            newWakeLock.acquire();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        PowerManager.WakeLock wakeLock = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wakeLock != null) {
            wakeLock.release();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int intExtra = intent.getIntExtra("key_integer", -1);
        String stringExtra = intent.getStringExtra("key_string");
        long longExtra = intent.getLongExtra("key_long", -1L);
        boolean booleanExtra = intent.getBooleanExtra("key_boolean", false);
        switch (intExtra) {
            case 0:
                HttpBuilderTarget ignoreFilePathOccupy = Aria.download(StubApp.getOrigApplicationContext(getApplicationContext())).load(stringExtra).setFilePath(intent.getStringExtra("key_string_one")).ignoreFilePathOccupy();
                if (!stringExtra.contains(".m3u8") && !stringExtra.contains(".m3u")) {
                    ignoreFilePathOccupy.option(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).ignoreCheckPermissions().create();
                    break;
                } else {
                    ignoreFilePathOccupy.m3u8VodOption(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringExtra)).create();
                    break;
                }
            case 1:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringExtra, longExtra, null, -1);
                break;
            case 2:
                Aria.download(StubApp.getOrigApplicationContext(getApplicationContext())).load(longExtra).stop();
                break;
            case 3:
                Aria.download(StubApp.getOrigApplicationContext(getApplicationContext())).load(longExtra).cancel(true);
                break;
            case 4:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", -1L, Aria.download(this).getAllNotCompleteTask(), 0);
                break;
            case 5:
                Aria.download(StubApp.getOrigApplicationContext(getApplicationContext())).stopAllTask();
                break;
            case 6:
                if (!booleanExtra) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", -1L, Aria.download(this).getAllNotCompleteTask(), 0);
                }
                break;
            default:
                return 1;
        }
        return 1;
    }
}
