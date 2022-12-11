package me.tvspark;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import com.p038qq.p039e.ads.ADActivity;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsVideo;
import com.tencent.smtt.sdk.WebView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.statistics.C1767b;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.VideoParcel;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class nn0 implements sk0 {
    public static Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TbsListener {
        public final /* synthetic */ BaseActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "内核安装失败！");
            }
        }

        /* renamed from: me.tvspark.nn0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3485Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {

            /* renamed from: me.tvspark.nn0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC3486Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
                public RunnableC3486Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1000);
                }
            }

            public RunnableC3485Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                new Handler().postDelayed(new RunnableC3486Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 3000L);
                AlertDialog.Builder builder = new AlertDialog.Builder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                builder.setTitle("X5 内核");
                builder.setMessage("X5 内核安装成功，即将进行重启...");
                builder.create().show();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity baseActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseActivity;
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i) {
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i) {
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i) {
            BaseActivity baseActivity;
            Runnable runnableC3485Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 200 || i == 220 || i == 221) {
                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                runnableC3485Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RunnableC3485Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                runnableC3485Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            baseActivity.runOnUiThread(runnableC3485Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("req_count") == -4;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return sk0.Wwwwwwwwwwwwwwwwwwwwwwwww.get(new Random().nextInt(sk0.Wwwwwwwwwwwwwwwwwwwwwwwww.size()));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("drama", str);
        MobclickAgent.onEventObject(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww, "searchDouban", hashMap);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        int port;
        String str;
        if (1 != 0) {
            str = System.getProperty("http.proxyHost");
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            port = Integer.parseInt(property);
        } else {
            String host = Proxy.getHost(context);
            port = Proxy.getPort(context);
            str = host;
        }
        return !TextUtils.isEmpty(str) && port != -1;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str = "x86";
        try {
            String readLine = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
            if (!readLine.contains(str)) {
                str = readLine.contains("arm64-v8a") ? "arm64-v8a" : readLine.contains("armeabi-v7a") ? "armeabi-v7a" : "armeabi";
            }
            return str;
        } catch (Exception unused) {
            return "armeabi";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        String str;
        f50 f50Var;
        HashMap hashMap;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ApplicationInfo applicationInfo;
        String str2 = null;
        try {
            applicationInfo = context.getApplicationInfo();
        } catch (Throwable unused) {
        }
        if (applicationInfo == null) {
            str = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    hashMap = null;
                    if (hashMap != null) {
                        hashMap.remove("channel");
                        f50Var = new f50((String) hashMap.get("channel"), hashMap);
                        if (f50Var != null) {
                            str2 = f50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        return TextUtils.isEmpty(str2) ? C1767b.f4025f : str2;
                    }
                } else {
                    JSONObject jSONObject = new JSONObject(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    Iterator<String> keys = jSONObject.keys();
                    hashMap = new HashMap();
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        hashMap.put(obj, jSONObject.getString(obj));
                    }
                    if (hashMap != null) {
                    }
                }
            }
            f50Var = null;
            if (f50Var != null) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } else {
            str = applicationInfo.sourceDir;
            if (!TextUtils.isEmpty(str)) {
            }
            f50Var = null;
            if (f50Var != null) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("playType", str);
        MobclickAgent.onEventObject(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww, "playType", hashMap);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity) {
        boolean z = false;
        try {
            WebView webView = new WebView(activity);
            if (webView.getX5WebViewExtension() != null) {
                z = true;
            }
            webView.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        new HashMap();
        MobclickAgent.onEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww, "rewardAD");
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        MobclickAgent.onEventObject(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww, "floatPlay", hashMap);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("drama", str);
        hashMap.put("webSite", str2);
        MobclickAgent.onEventObject(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww, "searchDrama", hashMap);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("webSite", str);
        hashMap.put("drama", str2);
        hashMap.put("episodeUrl", str3);
        MobclickAgent.onEventObject(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww, "playDrama", hashMap);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity baseActivity) {
        baseActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww("安装中...");
        QbSdk.reset(baseActivity);
        QbSdk.setTbsListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity));
        QbSdk.installLocalTbsCore(baseActivity, 45912, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, "45912.apk"));
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity baseActivity, int i) {
        try {
            ((AlarmManager) baseActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + i, PendingIntent.getActivity(baseActivity.getBaseContext(), 0, new Intent(baseActivity.getIntent()), baseActivity.getIntent().getFlags()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(34377);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity) {
        return TbsVideo.canUseTbsPlayer(activity);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        ActivityInfo activityInfo;
        try {
            activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(context, ADActivity.class), 128);
        } catch (Exception e) {
            e.printStackTrace();
            activityInfo = null;
        }
        return activityInfo == null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            synchronized (context) {
                context.getPackageManager().getApplicationInfo(str, 16);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<VideoParcel> list, List<VideoParcel> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null && list2 != null) {
            return false;
        }
        if (list != null && list2 == null) {
            return false;
        }
        if (list.isEmpty() && !list2.isEmpty()) {
            return false;
        }
        if ((!list.isEmpty() && list2.isEmpty()) || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        if (size == 1) {
            if (list.get(0).equals(list2.get(0))) {
                return true;
            }
        } else if (size == 2) {
            if (list.get(0).equals(list2.get(0)) && list.get(1).equals(list2.get(1))) {
                return true;
            }
        } else if (size > 2 && list.get(0).equals(list2.get(0)) && list.get(1).equals(list2.get(1))) {
            int i = size - 1;
            if (list.get(i).equals(list2.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Activity activity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        String str;
        if (Build.VERSION.SDK_INT >= 29 && activity != null) {
            activity.getWindow().getDecorView().post(new on0(activity, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip()) {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
            if (primaryClip != null && primaryClip.getItemCount() > 0 && primaryClip.getItemAt(0).getText() != null && (primaryClipDescription.hasMimeType("text/plain") || primaryClipDescription.hasMimeType("text/uri-list") || primaryClipDescription.hasMimeType("text/html"))) {
                str = primaryClip.getItemAt(0).getText().toString().trim();
            }
        }
        str = "";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }
}
