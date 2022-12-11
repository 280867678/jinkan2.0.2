package me.tvspark;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.MimeTypeMap;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import java.util.Collections;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class nr0 implements sk0 {
    public boolean Wwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwww;
    public mr0 Wwwwwwwwwwwwww;
    public DialogParse.Wwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwww;
    public WebView Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww = 0;
    public SortedMap<String, lr0> Wwwwwwwwwwwwwww = Collections.synchronizedSortedMap(new TreeMap());
    public boolean Wwwwwwwwwwww = true;
    public rn0 Wwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10000, 1000);
    public HashMap<String, String> Wwwwwwwwww = new HashMap<>();

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebChromeClient {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            nr0.this.Wwwwwwwwwwwwwwww = i;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends rn0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
            super(j, j2);
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            nr0.this.Wwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            nr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nr0.this);
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            if (nr0.this.Wwwwwwwwwwwwwwwwwwwwwww.isFinishing()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                nr0.this.Wwwwwwwwwww = null;
            } else if (j / 1000 != 1) {
            } else {
                nr0.this.Wwwwwwwwwwww = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                nr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nr0.this);
            }
        }
    }

    public nr0(Activity activity, String str, String str2, String str3, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwww = str3;
        try {
            if (TextUtils.isEmpty(str) || !str.contains("<js>")) {
                this.Wwwwwwwwwwwwwwwwwwwwww = str;
                this.Wwwwwwwww = true;
            } else {
                String[] split = str.split("<js>");
                this.Wwwwwwwwwwwwwwwwwwwwww = split[0];
                this.Wwwwwwwwwwwwwwwwwwwww = split[1];
                this.Wwwwwwwww = false;
            }
        } catch (Exception unused) {
            this.Wwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwww = true;
        }
        this.Wwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        WebView webView = new WebView(this.Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webView;
        webView.setLayoutParams(new LinearLayout.LayoutParams(1, 1));
        ((ViewGroup) this.Wwwwwwwwwwwwwwwwwwwwwww.findViewById(16908290)).addView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.clearFocus();
        WebSettings settings = this.Wwwwwwwwwwwwwwwwwwwwwwww.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setCacheMode(-1);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setTextZoom(100);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDatabaseEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setAppCacheEnabled(true);
        settings.setUserAgentString(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww);
        settings.setLoadsImagesAutomatically(false);
        settings.setBlockNetworkImage(true);
        settings.setMixedContentMode(0);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAppCachePath(this.Wwwwwwwwwwwwwwwwwwwwwww.getCacheDir().getAbsolutePath());
        settings.setGeolocationDatabasePath(this.Wwwwwwwwwwwwwwwwwwwwwww.getDir("database", 0).getPath());
        settings.setGeolocationEnabled(false);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(this.Wwwwwwwwwwwwwwwwwwwwwwww, true);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setWebViewClient(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setWebChromeClient(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwww = new mr0(this.Wwwwwwwwwwwwwww);
        if (!o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nr0 nr0Var) {
        DialogParse.Wwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwww;
        if (nr0Var.Wwwwwwwwwwww) {
            nr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (!nr0Var.Wwwwwwwwwwww || (wwwwwwwwwwwwwwwwwwwwww = nr0Var.Wwwwwwwwwwwwwwwww) == null) {
            return;
        }
        ((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nr0Var.Wwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        tr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ApplicationC1880C.Wwwwwwwwww.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d9, code lost:
        if (r0 == null) goto L46;
     */
    @x11(threadMode = ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSnifferVideo(lr0 lr0Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str;
        if (lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !this.Wwwwwwwww) {
            lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwww = true;
        }
        if (lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            DialogParse.Wwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        if (this.Wwwwwwwwwwwww != null && !TextUtils.isEmpty(lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            ((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (!TextUtils.isEmpty(lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = kr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                if (!this.Wwwwwwwwww.containsKey(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    this.Wwwwwwwwww.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    LinkedBlockingQueue<hr0> linkedBlockingQueue = ApplicationC1880C.Wwwwwwwwww;
                    String str2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                    linkedBlockingQueue.add(new hr0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str2, this.Wwwwwwwwwwwwwwwwwwww + " - " + this.Wwwwwwwwwwwwwwwwwww));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        ((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                }
                if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    Matcher matcher = Pattern.compile("(https?://.*)(\\.m3u8)|(https?://.*)(\\.m3u)").matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (matcher.find()) {
                        str = matcher.group(0);
                        if (!TextUtils.isEmpty(str) && !this.Wwwwwwwwww.containsKey(str)) {
                            this.Wwwwwwwwww.put(str, str);
                            LinkedBlockingQueue<hr0> linkedBlockingQueue2 = ApplicationC1880C.Wwwwwwwwww;
                            String str3 = this.Wwwwwwwwwwwwwwwwwwwwww;
                            linkedBlockingQueue2.add(new hr0(str, str3, this.Wwwwwwwwwwwwwwwwwwww + " - " + this.Wwwwwwwwwwwwwwwwwww));
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww;
                        }
                    }
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                    this.Wwwwwwwwww.put(str, str);
                    LinkedBlockingQueue<hr0> linkedBlockingQueue22 = ApplicationC1880C.Wwwwwwwwww;
                    String str32 = this.Wwwwwwwwwwwwwwwwwwwwww;
                    linkedBlockingQueue22.add(new hr0(str, str32, this.Wwwwwwwwwwwwwwwwwwww + " - " + this.Wwwwwwwwwwwwwwwwwww));
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww;
                }
            } else if (!this.Wwwwwwwwww.containsKey(lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                HashMap<String, String> hashMap = this.Wwwwwwwwww;
                String str4 = lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                hashMap.put(str4, str4);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    str = lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    ((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                }
            }
        }
        if (this.Wwwwwwwwwwwwwwww != 100) {
            rn0 rn0Var = this.Wwwwwwwwwww;
            if (rn0Var == null) {
                return;
            }
            rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        rn0 rn0Var2 = this.Wwwwwwwwwww;
        if (rn0Var2 == null) {
            return;
        }
        rn0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        mr0 mr0Var = this.Wwwwwwwwwwwwww;
        if (mr0Var != null) {
            mr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwww = null;
        }
        rn0 rn0Var = this.Wwwwwwwwwww;
        if (rn0Var != null) {
            rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwww = null;
        }
        WebView webView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (webView != null) {
            try {
                webView.loadUrl("about:blank");
                this.Wwwwwwwwwwwwwwwwwwwwwwww.clearCache(true);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.clearHistory();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.setWebViewClient(null);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.setWebChromeClient(null);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.stopLoading();
                try {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getParent() != null) {
                        ((ViewGroup) this.Wwwwwwwwwwwwwwwwwwwwwwww.getParent()).removeView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww.destroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebViewClient {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            LinkedBlockingQueue<hr0> linkedBlockingQueue = ApplicationC1880C.Wwwwwwwwww;
            String str2 = nr0.this.Wwwwwwwwwwwwwwwwwwwwww;
            linkedBlockingQueue.add(new hr0(str, str2, nr0.this.Wwwwwwwwwwwwwwwwwwww + " - " + nr0.this.Wwwwwwwwwwwwwwwwwww));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!TextUtils.isEmpty(nr0.this.Wwwwwwwwwwwwwwwwwwwww)) {
                webView.evaluateJavascript("javascript: (function() {\n    window.addEventListener('load', function() {\n        <js>\n    })\n})();".replace("<js>", nr0.this.Wwwwwwwwwwwwwwwwwwwww), null);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if ((webResourceRequest.getUrl().toString().startsWith("http") || webResourceRequest.getUrl().toString().startsWith("https")) && !webResourceRequest.getUrl().toString().startsWith("intent")) {
                if (!kr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MimeTypeMap.getFileExtensionFromUrl(webResourceRequest.getUrl().toString()))) {
                    webView.loadUrl(webResourceRequest.getUrl().toString());
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                LinkedBlockingQueue<hr0> linkedBlockingQueue = ApplicationC1880C.Wwwwwwwwww;
                String uri = webResourceRequest.getUrl().toString();
                String str = nr0.this.Wwwwwwwwwwwwwwwwwwwwww;
                linkedBlockingQueue.add(new hr0(uri, str, nr0.this.Wwwwwwwwwwwwwwwwwwww + " - " + nr0.this.Wwwwwwwwwwwwwwwwwww));
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http") || str.startsWith("https")) {
                if (!kr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MimeTypeMap.getFileExtensionFromUrl(str))) {
                    webView.loadUrl(str);
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                LinkedBlockingQueue<hr0> linkedBlockingQueue = ApplicationC1880C.Wwwwwwwwww;
                String str2 = nr0.this.Wwwwwwwwwwwwwwwwwwwwww;
                linkedBlockingQueue.add(new hr0(str, str2, nr0.this.Wwwwwwwwwwwwwwwwwwww + " - " + nr0.this.Wwwwwwwwwwwwwwwwwww));
                return true;
            }
            return true;
        }
    }
}
