package me.tvspark.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.tencent.smtt.sdk.WebView;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.common.view.BaseWebFragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebviewX5Fragment extends BaseWebFragment {
    public boolean Wwwwwwwwwwww = true;
    public String Wwwwwwwwwwwww;
    @BindView(R.id.iv_web_back)
    public ImageView ivWebBack;
    @BindView(R.id.iv_web_forward)
    public ImageView ivWebForward;
    @BindView(R.id.pbar)
    public ProgressBar pBar;
    @BindView(R.id.rlyt_web_back)
    public RelativeLayout rlytWebBack;
    @BindView(R.id.rlyt_web_forward)
    public RelativeLayout rlytWebForward;
    @BindView(R.id.webView)
    public WebView webView;

    public final void Wwwwwwwwwwwww() {
        ImageView imageView;
        int i;
        ImageView imageView2;
        int i2;
        WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        if (webView.canGoBack()) {
            this.rlytWebBack.setClickable(true);
            imageView = this.ivWebBack;
            i = R.drawable.ic_web_back_color;
        } else {
            this.rlytWebBack.setClickable(false);
            imageView = this.ivWebBack;
            i = R.drawable.ic_web_back_gray;
        }
        imageView.setImageResource(i);
        if (this.webView.canGoForward()) {
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

    public void Wwwwwwwwwwwwww() {
        if (!Wwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwwwwww = 0;
            this.webView.stopLoading();
            String str = this.Wwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwww()) {
                return;
            }
            this.Wwwwwwwwwwwwwwww = str;
            WebView webView = this.Wwwwwwwwwwwwwwwww;
            if (webView == null) {
                return;
            }
            webView.stopLoading();
            this.Wwwwwwwwwwwwwwwww.loadUrl(str);
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_webview_x5;
    }

    @Override // me.tvspark.common.view.BaseWebFragment, me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bundle);
        this.Wwwwwwwwwwwww = getArguments().getString("key_string");
        this.Wwwwwwwwwwww = getArguments().getBoolean("key_boolean");
        if (!Wwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwww();
        }
    }

    @OnClick({R.id.rlyt_web_back, R.id.rlyt_web_forward, R.id.rlyt_web_refresh, R.id.rlyt_web_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rlyt_web_back /* 2131362460 */:
                if (!this.webView.canGoBack()) {
                    return;
                }
                this.Wwwwwwwwwwwwwww = 0;
                this.webView.goBack();
                return;
            case R.id.rlyt_web_close /* 2131362461 */:
                if (!(getActivity() instanceof BaseActivity)) {
                    return;
                }
                getActivity().finish();
                return;
            case R.id.rlyt_web_collect /* 2131362462 */:
            case R.id.rlyt_web_down /* 2131362463 */:
            default:
                return;
            case R.id.rlyt_web_forward /* 2131362464 */:
                if (!this.webView.canGoForward()) {
                    return;
                }
                this.Wwwwwwwwwwwwwww = 0;
                this.webView.goForward();
                return;
            case R.id.rlyt_web_refresh /* 2131362465 */:
                Wwwwwwwwwwwwww();
                return;
        }
    }
}
