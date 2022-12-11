package me.tvspark;

import android.app.Activity;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* loaded from: classes4.dex */
public class vk0 {
    public final /* synthetic */ e60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public WebView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onNext(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onComplete();
            try {
                vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.loadUrl("about:blank");
                vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearCache(true);
                vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearHistory();
                vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setWebChromeClient(null);
                vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.stopLoading();
                try {
                    if (vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent() != null) {
                        ((ViewGroup) vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent()).removeView(vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                vk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.destroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public vk0(WebView webView, Activity activity, e60 e60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = e60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webView;
    }

    @JavascriptInterface
    public void processHTML(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }
}
