package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.utils.d */
/* loaded from: classes4.dex */
public class C1436d {

    /* renamed from: b */
    public static DexClassLoader f2410b;

    /* renamed from: c */
    public static Looper f2411c;

    /* renamed from: d */
    public static C1436d f2412d;

    /* renamed from: a */
    public String f2413a;

    /* renamed from: com.tencent.smtt.utils.d$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1442a {
        /* renamed from: a */
        void mo2093a();

        /* renamed from: a */
        void mo2092a(int i);

        /* renamed from: a */
        void mo2091a(Throwable th);
    }

    public C1436d(Context context) {
        this.f2413a = "";
        StringBuilder sb = new StringBuilder();
        sb.append(context.getDir("debugtbs", 0).getAbsolutePath());
        this.f2413a = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, "plugin");
    }

    /* renamed from: a */
    public static C1436d m2097a(Context context) {
        if (f2412d == null) {
            f2412d = new C1436d(context);
        }
        return f2412d;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m2094a(final String str, final AbstractC1442a abstractC1442a) {
        new Thread() { // from class: com.tencent.smtt.utils.d.2
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0077 -> B:14:0x007a). Please submit an issue!!! */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                FileOutputStream fileOutputStream;
                int contentLength;
                InputStream inputStream;
                InputStream inputStream2 = null;
                r0 = null;
                FileOutputStream fileOutputStream2 = null;
                inputStream2 = null;
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
                        contentLength = httpURLConnection.getContentLength();
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.connect();
                        inputStream = httpURLConnection.getInputStream();
                    } catch (Exception e) {
                        while (true) {
                            e.printStackTrace();
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    fileOutputStream2 = FileUtil.m2168d(new File(str));
                    byte[] bArr = new byte[8192];
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        i += read;
                        fileOutputStream2.write(bArr, 0, read);
                        abstractC1442a.mo2092a((i * 100) / contentLength);
                    }
                    abstractC1442a.mo2093a();
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    fileOutputStream2.close();
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    inputStream2 = inputStream;
                    try {
                        e.printStackTrace();
                        abstractC1442a.mo2091a(e);
                        try {
                            inputStream2.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            inputStream2.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    inputStream2 = inputStream;
                    inputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            }
        }.start();
    }

    /* renamed from: a */
    public void m2096a(final String str, final WebView webView, final Context context) {
        final RelativeLayout relativeLayout = new RelativeLayout(context);
        final TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setText("加载中，请稍后...");
        relativeLayout.addView(textView, layoutParams);
        webView.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2413a);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, "DebugPlugin.tbs");
        FileUtil.m2175b(new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        m2094a(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new AbstractC1442a() { // from class: com.tencent.smtt.utils.d.1
            @Override // com.tencent.smtt.utils.C1436d.AbstractC1442a
            /* renamed from: a */
            public void mo2093a() {
                webView.post(new Runnable() { // from class: com.tencent.smtt.utils.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "下载成功", 0).show();
                        relativeLayout.setVisibility(4);
                        C14371 c14371 = C14371.this;
                        C1436d.this.m2095a(str, webView, context, C1436d.f2411c);
                    }
                });
            }

            @Override // com.tencent.smtt.utils.C1436d.AbstractC1442a
            /* renamed from: a */
            public void mo2092a(final int i) {
                webView.post(new Runnable() { // from class: com.tencent.smtt.utils.d.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TextView textView2 = textView;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已下载");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(i);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("%");
                        textView2.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                });
            }

            @Override // com.tencent.smtt.utils.C1436d.AbstractC1442a
            /* renamed from: a */
            public void mo2091a(Throwable th) {
                webView.post(new Runnable() { // from class: com.tencent.smtt.utils.d.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "下载失败，请检查网络", 0).show();
                    }
                });
            }
        });
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m2095a(String str, WebView webView, Context context, Looper looper) {
        TbsLog.m2155i("debugtbs", "showPluginView -- url: " + str + "; webview: " + webView + "; context: " + context);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2413a);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, "DebugPlugin.tbs");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2413a);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, File.separator, "DebugPlugin.apk");
        File file = new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        File file2 = new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        f2411c = looper;
        if (file.exists()) {
            file2.delete();
            file.renameTo(file2);
        }
        if (!file2.exists()) {
            TbsLog.m2155i("debugtbs", "showPluginView - going to download plugin...");
            m2096a(str, webView, context);
            return;
        }
        try {
            String m2126a = C1429b.m2126a(context, true, new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
            if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(m2126a)) {
                TbsLog.m2158e("debugtbs", "verifyPlugin apk: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + " signature failed - sig: " + m2126a);
                Toast.makeText(context, "插件校验失败，请重试", 0).show();
                file.delete();
                file2.delete();
                return;
            }
            String str2 = this.f2413a + File.separator + "opt";
            File file3 = new File(str2);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            if (f2410b == null) {
                f2410b = new DexClassLoader(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str2, null, context.getClassLoader());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("tbs_version", "" + WebView.getTbsSDKVersion(context));
            hashMap.put("tbs_core_version", "" + WebView.getTbsCoreVersion(context));
            if (f2411c != null) {
                hashMap.put("looper", looper);
            }
            Object newInstance = f2410b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(Context.class, Map.class).newInstance(context, hashMap);
            if (!(newInstance instanceof FrameLayout)) {
                TbsLog.m2158e("debugtbs", "get debugview failure: " + newInstance);
                return;
            }
            FrameLayout frameLayout = (FrameLayout) newInstance;
            webView.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            TbsLog.m2155i("debugtbs", "show " + frameLayout + " successful in " + webView);
        } catch (Exception e) {
            FileUtil.m2175b(file2);
            e.printStackTrace();
        }
    }
}
