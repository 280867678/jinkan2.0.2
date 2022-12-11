package com.just.agentweb;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.util.Pair;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class VideoImpl implements IVideo, EventInterceptor {
    public static final String TAG = "VideoImpl";
    public Activity mActivity;
    public WebChromeClient.CustomViewCallback mCallback;
    public Set<Pair<Integer, Integer>> mFlags;
    public WebView mWebView;
    public View mMoiveView = null;
    public ViewGroup mMoiveParentView = null;

    public VideoImpl(Activity activity, WebView webView) {
        this.mFlags = null;
        this.mActivity = activity;
        this.mWebView = webView;
        this.mFlags = new HashSet();
    }

    @Override // com.just.agentweb.EventInterceptor
    public boolean event() {
        if (isVideoState()) {
            onHideCustomView();
            return true;
        }
        return false;
    }

    @Override // com.just.agentweb.IVideo
    public boolean isVideoState() {
        return this.mMoiveView != null;
    }

    @Override // com.just.agentweb.IVideo
    public void onHideCustomView() {
        View view;
        if (this.mMoiveView == null) {
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && activity.getRequestedOrientation() != 1) {
            this.mActivity.setRequestedOrientation(1);
        }
        if (!this.mFlags.isEmpty()) {
            for (Pair<Integer, Integer> pair : this.mFlags) {
                this.mActivity.getWindow().setFlags(pair.second.intValue(), pair.first.intValue());
            }
            this.mFlags.clear();
        }
        this.mMoiveView.setVisibility(8);
        ViewGroup viewGroup = this.mMoiveParentView;
        if (viewGroup != null && (view = this.mMoiveView) != null) {
            viewGroup.removeView(view);
        }
        ViewGroup viewGroup2 = this.mMoiveParentView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.mCallback;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.mMoiveView = null;
        WebView webView = this.mWebView;
        if (webView == null) {
            return;
        }
        webView.setVisibility(0);
    }

    @Override // com.just.agentweb.IVideo
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.setRequestedOrientation(0);
        Window window = activity.getWindow();
        if ((window.getAttributes().flags & 128) == 0) {
            Pair<Integer, Integer> pair = new Pair<>(128, 0);
            window.setFlags(128, 128);
            this.mFlags.add(pair);
        }
        if ((window.getAttributes().flags & 16777216) == 0) {
            Pair<Integer, Integer> pair2 = new Pair<>(16777216, 0);
            window.setFlags(16777216, 16777216);
            this.mFlags.add(pair2);
        }
        if (this.mMoiveView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        if (this.mMoiveParentView == null) {
            FrameLayout frameLayout = new FrameLayout(activity);
            this.mMoiveParentView = frameLayout;
            frameLayout.setBackgroundColor(-16777216);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.mMoiveParentView);
        }
        this.mCallback = customViewCallback;
        ViewGroup viewGroup = this.mMoiveParentView;
        this.mMoiveView = view;
        viewGroup.addView(view);
        this.mMoiveParentView.setVisibility(0);
    }
}
