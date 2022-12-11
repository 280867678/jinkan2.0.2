package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.just.agentweb.AgentActionFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes3.dex */
public class DefaultChromeClient extends MiddlewareWebChromeBase {
    public static final String ANDROID_WEBCHROMECLIENT_PATH = "android.webkit.WebChromeClient";
    public static final int FROM_CODE_INTENTION = 24;
    public static final int FROM_CODE_INTENTION_LOCATION = 96;
    public WeakReference<Activity> mActivityWeakReference;
    public WeakReference<AbsAgentWebUIController> mAgentWebUIController;
    public Object mFileChooser;
    public IVideo mIVideo;
    public IndicatorController mIndicatorController;
    public boolean mIsWrapper;
    public PermissionInterceptor mPermissionInterceptor;
    public android.webkit.WebChromeClient mWebChromeClient;
    public WebView mWebView;
    public String TAG = DefaultChromeClient.class.getSimpleName();
    public String mOrigin = null;
    public GeolocationPermissions.Callback mCallback = null;
    public AgentActionFragment.PermissionListener mPermissionListener = new AgentActionFragment.PermissionListener() { // from class: com.just.agentweb.DefaultChromeClient.1
        @Override // com.just.agentweb.AgentActionFragment.PermissionListener
        public void onRequestPermissionsResult(@NonNull String[] strArr, @NonNull int[] iArr, Bundle bundle) {
            if (bundle.getInt(AgentActionFragment.KEY_FROM_INTENTION) == 96) {
                boolean hasPermission = AgentWebUtils.hasPermission((Context) DefaultChromeClient.this.mActivityWeakReference.get(), strArr);
                if (DefaultChromeClient.this.mCallback != null) {
                    GeolocationPermissions.Callback callback = DefaultChromeClient.this.mCallback;
                    String str = DefaultChromeClient.this.mOrigin;
                    if (hasPermission) {
                        callback.invoke(str, true, false);
                    } else {
                        callback.invoke(str, false, false);
                    }
                    DefaultChromeClient.this.mCallback = null;
                    DefaultChromeClient.this.mOrigin = null;
                }
                if (hasPermission || DefaultChromeClient.this.mAgentWebUIController.get() == null) {
                    return;
                }
                ((AbsAgentWebUIController) DefaultChromeClient.this.mAgentWebUIController.get()).onPermissionsDeny(AgentWebPermissions.LOCATION, "Location", "Location");
            }
        }
    };

    public DefaultChromeClient(Activity activity, IndicatorController indicatorController, android.webkit.WebChromeClient webChromeClient, @Nullable IVideo iVideo, PermissionInterceptor permissionInterceptor, WebView webView) {
        super(webChromeClient);
        this.mActivityWeakReference = null;
        boolean z = false;
        this.mIsWrapper = false;
        this.mAgentWebUIController = null;
        this.mIndicatorController = indicatorController;
        this.mIsWrapper = webChromeClient != null ? true : z;
        this.mWebChromeClient = webChromeClient;
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mIVideo = iVideo;
        this.mPermissionInterceptor = permissionInterceptor;
        this.mWebView = webView;
        this.mAgentWebUIController = new WeakReference<>(AgentWebUtils.getAgentWebUIControllerByWebView(webView));
    }

    private void createAndOpenCommonFileChooser(ValueCallback valueCallback, String str) {
        if (valueCallback == null) {
            return;
        }
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            valueCallback.onReceiveValue(new Object());
        } else {
            AgentWebUtils.showFileChooserCompat(activity, this.mWebView, null, null, this.mPermissionInterceptor, valueCallback, str, null);
        }
    }

    private void onGeolocationPermissionsShowPromptInternal(String str, GeolocationPermissions.Callback callback) {
        PermissionInterceptor permissionInterceptor = this.mPermissionInterceptor;
        if (permissionInterceptor != null && permissionInterceptor.intercept(this.mWebView.getUrl(), AgentWebPermissions.LOCATION, "location")) {
            callback.invoke(str, false, false);
            return;
        }
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null) {
            callback.invoke(str, false, false);
            return;
        }
        List<String> deniedPermissions = AgentWebUtils.getDeniedPermissions(activity, AgentWebPermissions.LOCATION);
        if (deniedPermissions.isEmpty()) {
            LogUtils.m3701i(this.TAG, "onGeolocationPermissionsShowPromptInternal:true");
            callback.invoke(str, true, false);
            return;
        }
        Action createPermissionsAction = Action.createPermissionsAction((String[]) deniedPermissions.toArray(new String[0]));
        createPermissionsAction.setFromIntention(96);
        createPermissionsAction.setPermissionListener(this.mPermissionListener);
        this.mCallback = callback;
        this.mOrigin = str;
        AgentActionFragment.start(activity, createPermissionsAction);
    }

    @RequiresApi(api = 21)
    private boolean openFileChooserAboveL(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Activity activity;
        if (valueCallback == null || (activity = this.mActivityWeakReference.get()) == null || activity.isFinishing()) {
            return false;
        }
        return AgentWebUtils.showFileChooserCompat(activity, this.mWebView, valueCallback, fileChooserParams, this.mPermissionInterceptor, null, null, null);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        super.onConsoleMessage(consoleMessage);
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j3 * 2);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        onGeolocationPermissionsShowPromptInternal(str, callback);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onHideCustomView() {
        IVideo iVideo = this.mIVideo;
        if (iVideo != null) {
            iVideo.onHideCustomView();
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onJsAlert(webView, str, str2);
        }
        jsResult.confirm();
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onJsConfirm(webView, str, str2, jsResult);
            return true;
        }
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            if (this.mAgentWebUIController.get() == null) {
                return true;
            }
            this.mAgentWebUIController.get().onJsPrompt(this.mWebView, str, str2, str3, jsPromptResult);
            return true;
        } catch (Exception e) {
            if (!LogUtils.isDebug()) {
                return true;
            }
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    @RequiresApi(api = 21)
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (permissionRequest == null) {
            return;
        }
        String[] resources = permissionRequest.getResources();
        if (resources == null || resources.length <= 0) {
            permissionRequest.deny();
            return;
        }
        HashSet hashSet = new HashSet(Arrays.asList(resources));
        ArrayList arrayList = new ArrayList(hashSet.size());
        if (hashSet.contains(com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
            arrayList.add("android.permission.CAMERA");
        }
        if (hashSet.contains(com.tencent.smtt.export.external.interfaces.PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        PermissionInterceptor permissionInterceptor = this.mPermissionInterceptor;
        if ((permissionInterceptor != null && permissionInterceptor.intercept(this.mWebView.getUrl(), (String[]) arrayList.toArray(new String[0]), "onPermissionRequest")) || this.mAgentWebUIController.get() == null) {
            return;
        }
        this.mAgentWebUIController.get().onPermissionRequest(permissionRequest);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    @RequiresApi(api = 21)
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        super.onPermissionRequestCanceled(permissionRequest);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        IndicatorController indicatorController = this.mIndicatorController;
        if (indicatorController != null) {
            indicatorController.progress(webView, i);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j * 2);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.mIsWrapper) {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        IVideo iVideo = this.mIVideo;
        if (iVideo != null) {
            iVideo.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    @RequiresApi(api = 21)
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        LogUtils.m3701i(this.TAG, "openFileChooser>=5.0");
        return openFileChooserAboveL(webView, valueCallback, fileChooserParams);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        createAndOpenCommonFileChooser(valueCallback, "*/*");
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback valueCallback, String str) {
        createAndOpenCommonFileChooser(valueCallback, str);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        LogUtils.m3701i(this.TAG, "openFileChooser>=4.1");
        createAndOpenCommonFileChooser(valueCallback, str);
    }
}
