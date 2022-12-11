package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class WebParentLayout extends FrameLayout implements Provider<AbsAgentWebUIController> {
    public static final String TAG = WebParentLayout.class.getSimpleName();
    public AbsAgentWebUIController mAgentWebUIController;
    @IdRes
    public int mClickId;
    public FrameLayout mErrorLayout;
    @LayoutRes
    public int mErrorLayoutRes;
    public View mErrorView;
    public WebView mWebView;

    public WebParentLayout(@NonNull Context context) {
        this(context, null);
        LogUtils.m3701i(TAG, "WebParentLayout");
    }

    public WebParentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WebParentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAgentWebUIController = null;
        this.mClickId = -1;
        this.mErrorLayout = null;
        if (context instanceof Activity) {
            this.mErrorLayoutRes = C1020R.layout.agentweb_error_page;
            return;
        }
        throw new IllegalArgumentException("WebParentLayout context must be activity or activity sub class .");
    }

    private void createErrorLayout() {
        final FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(-1);
        frameLayout.setId(C1020R.C1021id.mainframe_error_container_id);
        View view = this.mErrorView;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            String str = TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mErrorLayoutRes:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mErrorLayoutRes);
            LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            from.inflate(this.mErrorLayoutRes, (ViewGroup) frameLayout, true);
        } else {
            frameLayout.addView(view);
        }
        View view2 = (ViewStub) findViewById(C1020R.C1021id.mainframe_error_viewsub_id);
        int indexOfChild = indexOfChild(view2);
        removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.mErrorLayout = frameLayout;
        if (layoutParams != null) {
            addView(frameLayout, indexOfChild, layoutParams);
        } else {
            addView(frameLayout, indexOfChild);
        }
        frameLayout.setVisibility(0);
        int i = this.mClickId;
        if (i != -1) {
            final View findViewById = frameLayout.findViewById(i);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.just.agentweb.WebParentLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (WebParentLayout.this.getWebView() != null) {
                            findViewById.setClickable(false);
                            WebParentLayout.this.getWebView().reload();
                        }
                    }
                });
                return;
            } else if (LogUtils.isDebug()) {
                LogUtils.m3703e(TAG, "ClickView is null , cannot bind accurate view to refresh or reload .");
            }
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.just.agentweb.WebParentLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (WebParentLayout.this.getWebView() != null) {
                    frameLayout.setClickable(false);
                    WebParentLayout.this.getWebView().reload();
                }
            }
        });
    }

    public void bindController(AbsAgentWebUIController absAgentWebUIController) {
        this.mAgentWebUIController = absAgentWebUIController;
        absAgentWebUIController.bindWebParent(this, (Activity) getContext());
    }

    public void bindWebView(WebView webView) {
        if (this.mWebView == null) {
            this.mWebView = webView;
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void hideErrorLayout() {
        View findViewById = findViewById(C1020R.C1021id.mainframe_error_container_id);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.just.agentweb.Provider
    /* renamed from: provide */
    public AbsAgentWebUIController mo4828provide() {
        return this.mAgentWebUIController;
    }

    public void setErrorLayoutRes(@LayoutRes int i, @IdRes int i2) {
        this.mClickId = i2;
        if (i2 <= 0) {
            this.mClickId = -1;
        }
        this.mErrorLayoutRes = i;
        if (i <= 0) {
            this.mErrorLayoutRes = C1020R.layout.agentweb_error_page;
        }
    }

    public void setErrorView(@NonNull View view) {
        this.mErrorView = view;
    }

    public void showPageMainFrameError() {
        View findViewById;
        FrameLayout frameLayout = this.mErrorLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        } else {
            createErrorLayout();
            frameLayout = this.mErrorLayout;
        }
        int i = this.mClickId;
        if (i == -1 || (findViewById = frameLayout.findViewById(i)) == null) {
            frameLayout.setClickable(true);
        } else {
            findViewById.setClickable(true);
        }
    }
}
