package com.just.agentweb;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DefaultWebCreator implements WebCreator {
    public static final String TAG = "DefaultWebCreator";
    public Activity mActivity;
    public BaseIndicatorSpec mBaseIndicatorSpec;
    public int mColor;
    public FrameLayout mFrameLayout;
    public int mHeight;
    public IWebLayout mIWebLayout;
    public int mIndex;
    public boolean mIsCreated;
    public boolean mIsNeedDefaultProgress;
    public ViewGroup.LayoutParams mLayoutParams;
    public BaseIndicatorView mProgressView;
    public View mTargetProgress;
    public ViewGroup mViewGroup;
    public WebView mWebView;
    public int mWebViewType;

    public DefaultWebCreator(@NonNull Activity activity, @Nullable ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, int i3, WebView webView, IWebLayout iWebLayout) {
        this.mLayoutParams = null;
        this.mColor = -1;
        this.mIsCreated = false;
        this.mWebView = null;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = true;
        this.mIndex = i;
        this.mColor = i2;
        this.mLayoutParams = layoutParams;
        this.mHeight = i3;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    public DefaultWebCreator(@NonNull Activity activity, @Nullable ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, @Nullable WebView webView, IWebLayout iWebLayout) {
        this.mLayoutParams = null;
        this.mColor = -1;
        this.mIsCreated = false;
        this.mWebView = null;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = false;
        this.mIndex = i;
        this.mLayoutParams = layoutParams;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    public DefaultWebCreator(@NonNull Activity activity, @Nullable ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, BaseIndicatorView baseIndicatorView, WebView webView, IWebLayout iWebLayout) {
        this.mLayoutParams = null;
        this.mColor = -1;
        this.mIsCreated = false;
        this.mWebView = null;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = false;
        this.mIndex = i;
        this.mLayoutParams = layoutParams;
        this.mProgressView = baseIndicatorView;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    private ViewGroup createLayout() {
        View view;
        BaseIndicatorView baseIndicatorView;
        Activity activity = this.mActivity;
        WebParentLayout webParentLayout = new WebParentLayout(activity);
        webParentLayout.setId(C1020R.C1021id.web_parent_layout_id);
        webParentLayout.setBackgroundColor(-1);
        if (this.mIWebLayout == null) {
            WebView createWebView = createWebView();
            this.mWebView = createWebView;
            view = createWebView;
        } else {
            view = webLayout();
        }
        webParentLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        webParentLayout.bindWebView(this.mWebView);
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  instanceof  AgentWebView:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mWebView instanceof AgentWebView);
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (this.mWebView instanceof AgentWebView) {
            this.mWebViewType = 2;
        }
        ViewStub viewStub = new ViewStub(activity);
        viewStub.setId(C1020R.C1021id.mainframe_error_viewsub_id);
        webParentLayout.addView(viewStub, new FrameLayout.LayoutParams(-1, -1));
        boolean z = this.mIsNeedDefaultProgress;
        if (z) {
            WebIndicator webIndicator = new WebIndicator(activity);
            FrameLayout.LayoutParams layoutParams = this.mHeight > 0 ? new FrameLayout.LayoutParams(-2, AgentWebUtils.dp2px(activity, this.mHeight)) : webIndicator.offerLayoutParams();
            int i = this.mColor;
            if (i != -1) {
                webIndicator.setColor(i);
            }
            layoutParams.gravity = 48;
            this.mBaseIndicatorSpec = webIndicator;
            webParentLayout.addView(webIndicator, layoutParams);
            webIndicator.setVisibility(8);
        } else if (!z && (baseIndicatorView = this.mProgressView) != null) {
            this.mBaseIndicatorSpec = baseIndicatorView;
            webParentLayout.addView(baseIndicatorView, baseIndicatorView.offerLayoutParams());
            this.mProgressView.setVisibility(8);
        }
        return webParentLayout;
    }

    private WebView createWebView() {
        int i;
        WebView webView = this.mWebView;
        if (webView != null) {
            i = 3;
        } else if (AgentWebConfig.IS_KITKAT_OR_BELOW_KITKAT) {
            webView = new AgentWebView(this.mActivity);
            i = 2;
        } else {
            webView = new LollipopFixedWebView(this.mActivity);
            i = 1;
        }
        this.mWebViewType = i;
        return webView;
    }

    private View webLayout() {
        WebView webView = this.mIWebLayout.getWebView();
        if (webView == null) {
            webView = createWebView();
            this.mIWebLayout.getLayout().addView(webView, -1, -1);
            LogUtils.m3701i(TAG, "add webview");
        } else {
            this.mWebViewType = 3;
        }
        this.mWebView = webView;
        return this.mIWebLayout.getLayout();
    }

    @Override // com.just.agentweb.WebCreator
    /* renamed from: create */
    public DefaultWebCreator mo4827create() {
        if (this.mIsCreated) {
            return this;
        }
        this.mIsCreated = true;
        ViewGroup viewGroup = this.mViewGroup;
        if (viewGroup == null) {
            FrameLayout frameLayout = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout;
            this.mActivity.setContentView(frameLayout);
        } else if (this.mIndex == -1) {
            FrameLayout frameLayout2 = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout2;
            viewGroup.addView(frameLayout2, this.mLayoutParams);
        } else {
            FrameLayout frameLayout3 = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout3;
            viewGroup.addView(frameLayout3, this.mIndex, this.mLayoutParams);
        }
        return this;
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public View getTargetProgress() {
        return this.mTargetProgress;
    }

    @Override // com.just.agentweb.WebCreator
    public FrameLayout getWebParentLayout() {
        return this.mFrameLayout;
    }

    @Override // com.just.agentweb.WebCreator
    public WebView getWebView() {
        return this.mWebView;
    }

    @Override // com.just.agentweb.WebCreator
    public int getWebViewType() {
        return this.mWebViewType;
    }

    @Override // com.just.agentweb.IWebIndicator
    public BaseIndicatorSpec offer() {
        return this.mBaseIndicatorSpec;
    }

    public void setTargetProgress(View view) {
        this.mTargetProgress = view;
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }
}
