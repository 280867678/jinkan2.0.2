package me.tvspark.view.activity;

import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import butterknife.BindView;
import butterknife.OnClick;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.un0;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebviewAgentActivity extends BaseActivity {
    public String Wwwwwwwwwwwww;
    public String Wwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwww;
    public AgentWeb Wwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_content)
    public FrameLayout flytContent;
    @BindView(R.id.iv_web_back)
    public ImageView ivWebBack;
    @BindView(R.id.iv_web_forward)
    public ImageView ivWebForward;
    @BindView(R.id.llyt_navigation)
    public LinearLayout llytNavigation;
    @BindView(R.id.rlyt_adb)
    public RelativeLayout rlytADB;
    @BindView(R.id.rlyt_web_back)
    public RelativeLayout rlytWebBack;
    @BindView(R.id.rlyt_web_forward)
    public RelativeLayout rlytWebForward;
    @BindView(R.id.tv_adb)
    public TextView tvADB;
    @BindView(R.id.tv_web_url)
    public TextView tvWebUrl;
    public boolean Wwwwwwwwwwwwwwwwwww = true;
    public boolean Wwwwwwwwwwwwwwwwww = true;
    public int Wwwwwwwwwwww = 0;
    public WebChromeClient Wwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public WebViewClient Wwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebChromeClient {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                WebviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewAgentActivity.this, webView.getTitle(), webView.getUrl());
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebviewAgentActivity.this.Wwwwwwwwwwwww = str;
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewAgentActivity webviewAgentActivity, String str, String str2) {
        if (webviewAgentActivity != null) {
            TextUtils.isEmpty(str);
            webviewAgentActivity.Wwwwwwwwwwwwwww = str2;
            webviewAgentActivity.tvWebUrl.setText(str2);
            webviewAgentActivity.Wwwwwwwwwwwww();
            if (webviewAgentActivity.Wwwwwwwwwwww == 0) {
                webviewAgentActivity.rlytADB.setVisibility(8);
                return;
            }
            webviewAgentActivity.rlytADB.setVisibility(0);
            TextView textView = webviewAgentActivity.tvADB;
            textView.setText(webviewAgentActivity.Wwwwwwwwwwww + "");
            return;
        }
        throw null;
    }

    public final void Wwwwwwwwwwwww() {
        ImageView imageView;
        int i;
        ImageView imageView2;
        int i2;
        AgentWeb agentWeb = this.Wwwwwwwwwwwwwwwww;
        if (agentWeb == null) {
            return;
        }
        if (agentWeb.getWebCreator().getWebView().canGoBack()) {
            this.rlytWebBack.setClickable(true);
            imageView = this.ivWebBack;
            i = R.drawable.ic_web_back_color;
        } else {
            this.rlytWebBack.setClickable(false);
            imageView = this.ivWebBack;
            i = R.drawable.ic_web_back_gray;
        }
        imageView.setImageResource(i);
        if (this.Wwwwwwwwwwwwwwwww.getWebCreator().getWebView().canGoForward()) {
            this.rlytWebForward.setClickable(true);
            imageView2 = this.ivWebForward;
            i2 = R.drawable.ic_web_forward_color;
        } else {
            this.rlytWebForward.setClickable(false);
            imageView2 = this.ivWebForward;
            i2 = R.drawable.ic_web_forward_gray;
        }
        imageView2.setImageResource(i2);
    }

    public final void Wwwwwwwwwwwwww() {
        this.Wwwwwwwwwwww = 0;
        this.rlytADB.setVisibility(8);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_webview_agent;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, baseActivity.getResources().getColor(R.color.f5061white));
        this.Wwwwwwwwwwwwwwww = getIntent().getStringExtra("key_string");
        this.Wwwwwwwwwwwwwwwwwww = getIntent().getBooleanExtra("key_boolean", true);
        boolean booleanExtra = getIntent().getBooleanExtra("key_boolean_two", true);
        this.Wwwwwwwwwwwwwwwwww = booleanExtra;
        this.llytNavigation.setVisibility(booleanExtra ? 0 : 8);
        this.tvWebUrl.setText(this.Wwwwwwwwwwwwwwww);
        AgentWeb m3704go = AgentWeb.with(this).setAgentWebParent(this.flytContent, new LinearLayout.LayoutParams(-1, -1)).useDefaultIndicator().setWebViewClient(this.Wwwwwwwwww).setWebChromeClient(this.Wwwwwwwwwww).setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK).interceptUnkownUrl().setSecurityType(AgentWeb.SecurityType.STRICT_CHECK).createAgentWeb().ready().m3704go(this.Wwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww = m3704go;
        WebSettings webSettings = m3704go.getAgentWebSettings().getWebSettings();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDisplayZoomControls(false);
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AgentWeb agentWeb = this.Wwwwwwwwwwwwwwwww;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onDestroy();
            AgentWebConfig.clearDiskCache(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AgentWeb agentWeb = this.Wwwwwwwwwwwwwwwww;
        if (agentWeb == null || !agentWeb.handleKeyEvent(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        Wwwwwwwwwwwwww();
        return true;
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        AgentWeb agentWeb = this.Wwwwwwwwwwwwwwwww;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onPause();
        }
        super.onPause();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        AgentWeb agentWeb = this.Wwwwwwwwwwwwwwwww;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onResume();
        }
        super.onResume();
    }

    @OnClick({R.id.rlyt_adb, R.id.tv_web_url, R.id.rlyt_web_back, R.id.rlyt_web_forward, R.id.rlyt_web_refresh, R.id.rlyt_web_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rlyt_adb /* 2131362431 */:
                if (this.Wwwwwwwwwwww == 0) {
                    return;
                }
                BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已屏蔽");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("条广告");
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                return;
            case R.id.rlyt_web_back /* 2131362460 */:
                AgentWeb agentWeb = this.Wwwwwwwwwwwwwwwww;
                if (agentWeb != null && agentWeb.getWebCreator().getWebView().canGoBack()) {
                    this.Wwwwwwwwwwwwwwwww.getWebCreator().getWebView().goBack();
                    break;
                } else {
                    return;
                }
                break;
            case R.id.rlyt_web_close /* 2131362461 */:
                finish();
                return;
            case R.id.rlyt_web_forward /* 2131362464 */:
                AgentWeb agentWeb2 = this.Wwwwwwwwwwwwwwwww;
                if (agentWeb2 != null && agentWeb2.getWebCreator().getWebView().canGoForward()) {
                    this.Wwwwwwwwwwwwwwwww.getWebCreator().getWebView().goForward();
                    break;
                } else {
                    return;
                }
                break;
            case R.id.rlyt_web_refresh /* 2131362465 */:
                AgentWeb agentWeb3 = this.Wwwwwwwwwwwwwwwww;
                if (agentWeb3 == null) {
                    return;
                }
                agentWeb3.getWebCreator().getWebView().stopLoading();
                this.Wwwwwwwwwwwwwwwww.getWebCreator().getWebView().loadUrl(this.Wwwwwwwwwwwwwww);
                break;
            case R.id.tv_web_url /* 2131362763 */:
                ((ClipboardManager) this.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(this.tvWebUrl.getText().toString());
                BaseActivity baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已复制：");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.tvWebUrl.getText().toString());
                Toast.makeText(baseActivity2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), 0).show();
                return;
            default:
                return;
        }
        Wwwwwwwwwwwwww();
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewAgentActivity webviewAgentActivity, String str) {
        if (webviewAgentActivity != null) {
            if (!str.contains("thunder://") && !str.contains("magnet:?") && !str.contains("pan.baidu.com") && !str.contains("ed2k://")) {
                return false;
            }
            ((ClipboardManager) webviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(str);
            BaseActivity baseActivity = webviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
            Toast.makeText(baseActivity, "已复制：" + str, 0).show();
            return true;
        }
        throw null;
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebViewClient {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayInputStream(new byte[0]);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewAgentActivity.this, webView.getTitle(), str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String title = webView.getTitle();
            if (!TextUtils.isEmpty(title)) {
                WebviewAgentActivity.this.Wwwwwwwwwwwww = title;
            }
            WebviewAgentActivity webviewAgentActivity = WebviewAgentActivity.this;
            webviewAgentActivity.Wwwwwwwwwwwwww = "";
            webviewAgentActivity.Wwwwwwwwwwwwwww = str;
            webviewAgentActivity.tvWebUrl.setText(str);
            WebviewAgentActivity.this.Wwwwwwwwwwwww();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return !renderProcessGoneDetail.didCrash();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (ApplicationC1880C.Wwwwwwwwwwwwww != null) {
                if (webResourceRequest.isForMainFrame()) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webResourceRequest.getUrl().toString();
                }
                if (ApplicationC1880C.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webResourceRequest.getUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("※ blocked:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webResourceRequest.getUrl());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    WebviewAgentActivity.this.Wwwwwwwwwwww++;
                    return new WebResourceResponse("text/plain", "UTF-8", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  unblocked:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(webResourceRequest.getUrl());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!WebviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewAgentActivity.this, webResourceRequest.getUrl().toString())) {
                try {
                    if (webResourceRequest.getUrl().toString().startsWith("weixin://")) {
                        webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(webResourceRequest.getUrl().toString())));
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                WebviewAgentActivity webviewAgentActivity = WebviewAgentActivity.this;
                if (webviewAgentActivity.Wwwwwwwwwwwwwwwwwww) {
                    if (!un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webResourceRequest.getUrl().toString())) {
                        WebviewAgentActivity.this.Wwwwwwwwwwwwww();
                        webView.loadUrl(webResourceRequest.getUrl().toString());
                    }
                } else {
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(webviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwww, webResourceRequest.getUrl().toString());
                }
            }
            return true;
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!WebviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebviewAgentActivity.this, str)) {
                try {
                    if (str.startsWith("weixin://")) {
                        webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                WebviewAgentActivity webviewAgentActivity = WebviewAgentActivity.this;
                if (webviewAgentActivity.Wwwwwwwwwwwwwwwwwww) {
                    if (!un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
                        WebviewAgentActivity.this.Wwwwwwwwwwwwww();
                        webView.loadUrl(str);
                    }
                } else {
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(webviewAgentActivity.Wwwwwwwwwwwwwwwwwwwwwwww, str);
                }
            }
            return true;
        }
    }
}
