package me.tvspark;

import android.app.Activity;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import me.tvspark.widget.listener.BasicOnScrollListener;

/* loaded from: classes4.dex */
public class vu0 {
    public final /* synthetic */ BasicOnScrollListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
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
            vu0 vu0Var = vu0.this;
            vu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, vu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            try {
                vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.loadUrl("about:blank");
                vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearCache(true);
                vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearHistory();
                vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setWebChromeClient(null);
                vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.stopLoading();
                try {
                    if (vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent() != null) {
                        ((ViewGroup) vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getParent()).removeView(vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                vu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.destroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public vu0(BasicOnScrollListener basicOnScrollListener, WebView webView, Activity activity, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = basicOnScrollListener;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webView;
    }

    @JavascriptInterface
    public void processHTML(String str, String str2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }
}
