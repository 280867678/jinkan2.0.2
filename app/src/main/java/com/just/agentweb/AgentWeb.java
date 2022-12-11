package com.just.agentweb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.just.agentweb.DefaultWebClient;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class AgentWeb {
    public static final int ACTIVITY_TAG = 0;
    public static final int FRAGMENT_TAG = 1;
    public static final String TAG = "AgentWeb";
    public Activity mActivity;
    public AgentWeb mAgentWeb;
    public AgentWebJsInterfaceCompat mAgentWebJsInterfaceCompat;
    public IAgentWebSettings mAgentWebSettings;
    public boolean mEnableIndicator;
    public EventInterceptor mEventInterceptor;
    public IEventHandler mIEventHandler;
    public IUrlLoader mIUrlLoader;
    public IVideo mIVideo;
    public IndicatorController mIndicatorController;
    public boolean mIsInterceptUnkownUrl;
    public ArrayMap<String, Object> mJavaObjects;
    public JsAccessEntrace mJsAccessEntrace;
    public JsInterfaceHolder mJsInterfaceHolder;
    public MiddlewareWebClientBase mMiddleWrareWebClientBaseHeader;
    public MiddlewareWebChromeBase mMiddlewareWebChromeBaseHeader;
    public PermissionInterceptor mPermissionInterceptor;
    public SecurityType mSecurityType;
    public int mTagTarget;
    public android.webkit.WebChromeClient mTargetChromeClient;
    public int mUrlHandleWays;
    public ViewGroup mViewGroup;
    public WebChromeClient mWebChromeClient;
    public boolean mWebClientHelper;
    public WebCreator mWebCreator;
    public WebLifeCycle mWebLifeCycle;
    public WebListenerManager mWebListenerManager;
    public WebSecurityCheckLogic mWebSecurityCheckLogic;
    public WebSecurityController<WebSecurityCheckLogic> mWebSecurityController;
    public WebViewClient mWebViewClient;

    /* loaded from: classes3.dex */
    public static final class AgentBuilder {
        public Activity mActivity;
        public IAgentWebSettings mAgentWebSettings;
        public AbsAgentWebUIController mAgentWebUIController;
        public BaseIndicatorView mBaseIndicatorView;
        public int mErrorLayout;
        public View mErrorView;
        public Fragment mFragment;
        public IEventHandler mIEventHandler;
        public boolean mIsNeedDefaultProgress;
        public ArrayMap<String, Object> mJavaObject;
        public MiddlewareWebClientBase mMiddlewareWebClientBaseHeader;
        public MiddlewareWebClientBase mMiddlewareWebClientBaseTail;
        public int mReloadId;
        public int mTag;
        public ViewGroup mViewGroup;
        public WebChromeClient mWebChromeClient;
        public WebCreator mWebCreator;
        public WebView mWebView;
        public WebViewClient mWebViewClient;
        public int mIndex = -1;
        public IndicatorController mIndicatorController = null;
        public boolean mEnableIndicator = true;
        public ViewGroup.LayoutParams mLayoutParams = null;
        public int mIndicatorColor = -1;
        public HttpHeaders mHttpHeaders = null;
        public int mHeight = -1;
        public SecurityType mSecurityType = SecurityType.DEFAULT_CHECK;
        public boolean mWebClientHelper = true;
        public IWebLayout mWebLayout = null;
        public PermissionInterceptor mPermissionInterceptor = null;
        public DefaultWebClient.OpenOtherPageWays mOpenOtherPage = null;
        public boolean mIsInterceptUnkownUrl = true;
        public MiddlewareWebChromeBase mChromeMiddleWareHeader = null;
        public MiddlewareWebChromeBase mChromeMiddleWareTail = null;

        public AgentBuilder(@NonNull Activity activity) {
            this.mTag = -1;
            this.mActivity = activity;
            this.mTag = 0;
        }

        public AgentBuilder(@NonNull Activity activity, @NonNull Fragment fragment) {
            this.mTag = -1;
            this.mActivity = activity;
            this.mFragment = fragment;
            this.mTag = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addHeader(String str, String str2, String str3) {
            if (this.mHttpHeaders == null) {
                this.mHttpHeaders = HttpHeaders.create();
            }
            this.mHttpHeaders.additionalHttpHeader(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addHeader(String str, Map<String, String> map) {
            if (this.mHttpHeaders == null) {
                this.mHttpHeaders = HttpHeaders.create();
            }
            this.mHttpHeaders.additionalHttpHeaders(str, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addJavaObject(String str, Object obj) {
            if (this.mJavaObject == null) {
                this.mJavaObject = new ArrayMap<>();
            }
            this.mJavaObject.put(str, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PreAgentWeb buildAgentWeb() {
            if (this.mTag == 1 && this.mViewGroup == null) {
                throw new NullPointerException("ViewGroup is null,Please check your parameters .");
            }
            return new PreAgentWeb(HookManager.hookAgentWeb(new AgentWeb(this), this));
        }

        public IndicatorBuilder setAgentWebParent(@NonNull ViewGroup viewGroup, int i, @NonNull ViewGroup.LayoutParams layoutParams) {
            this.mViewGroup = viewGroup;
            this.mLayoutParams = layoutParams;
            this.mIndex = i;
            return new IndicatorBuilder(this);
        }

        public IndicatorBuilder setAgentWebParent(@NonNull ViewGroup viewGroup, @NonNull ViewGroup.LayoutParams layoutParams) {
            this.mViewGroup = viewGroup;
            this.mLayoutParams = layoutParams;
            return new IndicatorBuilder(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class CommonBuilder {
        public AgentBuilder mAgentBuilder;

        public CommonBuilder(AgentBuilder agentBuilder) {
            this.mAgentBuilder = agentBuilder;
        }

        public CommonBuilder addJavascriptInterface(@NonNull String str, @NonNull Object obj) {
            this.mAgentBuilder.addJavaObject(str, obj);
            return this;
        }

        public CommonBuilder additionalHttpHeader(String str, String str2, String str3) {
            this.mAgentBuilder.addHeader(str, str2, str3);
            return this;
        }

        public CommonBuilder additionalHttpHeader(String str, Map<String, String> map) {
            this.mAgentBuilder.addHeader(str, map);
            return this;
        }

        public CommonBuilder closeWebViewClientHelper() {
            this.mAgentBuilder.mWebClientHelper = false;
            return this;
        }

        public PreAgentWeb createAgentWeb() {
            return this.mAgentBuilder.buildAgentWeb();
        }

        public CommonBuilder interceptUnkownUrl() {
            this.mAgentBuilder.mIsInterceptUnkownUrl = true;
            return this;
        }

        public CommonBuilder isInterceptUnkownUrl(boolean z) {
            this.mAgentBuilder.mIsInterceptUnkownUrl = z;
            return this;
        }

        public CommonBuilder setAgentWebUIController(@Nullable AgentWebUIControllerImplBase agentWebUIControllerImplBase) {
            this.mAgentBuilder.mAgentWebUIController = agentWebUIControllerImplBase;
            return this;
        }

        public CommonBuilder setAgentWebWebSettings(@Nullable IAgentWebSettings iAgentWebSettings) {
            this.mAgentBuilder.mAgentWebSettings = iAgentWebSettings;
            return this;
        }

        public CommonBuilder setEventHanadler(@Nullable IEventHandler iEventHandler) {
            this.mAgentBuilder.mIEventHandler = iEventHandler;
            return this;
        }

        public CommonBuilder setMainFrameErrorView(@LayoutRes int i, @IdRes int i2) {
            this.mAgentBuilder.mErrorLayout = i;
            this.mAgentBuilder.mReloadId = i2;
            return this;
        }

        public CommonBuilder setMainFrameErrorView(@NonNull View view) {
            this.mAgentBuilder.mErrorView = view;
            return this;
        }

        public CommonBuilder setOpenOtherPageWays(@Nullable DefaultWebClient.OpenOtherPageWays openOtherPageWays) {
            this.mAgentBuilder.mOpenOtherPage = openOtherPageWays;
            return this;
        }

        public CommonBuilder setPermissionInterceptor(@Nullable PermissionInterceptor permissionInterceptor) {
            this.mAgentBuilder.mPermissionInterceptor = permissionInterceptor;
            return this;
        }

        public CommonBuilder setSecurityType(@NonNull SecurityType securityType) {
            this.mAgentBuilder.mSecurityType = securityType;
            return this;
        }

        public CommonBuilder setWebChromeClient(@Nullable WebChromeClient webChromeClient) {
            this.mAgentBuilder.mWebChromeClient = webChromeClient;
            return this;
        }

        public CommonBuilder setWebLayout(@Nullable IWebLayout iWebLayout) {
            this.mAgentBuilder.mWebLayout = iWebLayout;
            return this;
        }

        public CommonBuilder setWebView(@Nullable WebView webView) {
            this.mAgentBuilder.mWebView = webView;
            return this;
        }

        public CommonBuilder setWebViewClient(@Nullable WebViewClient webViewClient) {
            this.mAgentBuilder.mWebViewClient = webViewClient;
            return this;
        }

        public CommonBuilder useMiddlewareWebChrome(@NonNull MiddlewareWebChromeBase middlewareWebChromeBase) {
            if (middlewareWebChromeBase == null) {
                return this;
            }
            if (this.mAgentBuilder.mChromeMiddleWareHeader == null) {
                AgentBuilder agentBuilder = this.mAgentBuilder;
                agentBuilder.mChromeMiddleWareHeader = agentBuilder.mChromeMiddleWareTail = middlewareWebChromeBase;
            } else {
                this.mAgentBuilder.mChromeMiddleWareTail.enq(middlewareWebChromeBase);
                this.mAgentBuilder.mChromeMiddleWareTail = middlewareWebChromeBase;
            }
            return this;
        }

        public CommonBuilder useMiddlewareWebClient(@NonNull MiddlewareWebClientBase middlewareWebClientBase) {
            if (middlewareWebClientBase == null) {
                return this;
            }
            if (this.mAgentBuilder.mMiddlewareWebClientBaseHeader == null) {
                AgentBuilder agentBuilder = this.mAgentBuilder;
                agentBuilder.mMiddlewareWebClientBaseHeader = agentBuilder.mMiddlewareWebClientBaseTail = middlewareWebClientBase;
            } else {
                this.mAgentBuilder.mMiddlewareWebClientBaseTail.enq(middlewareWebClientBase);
                this.mAgentBuilder.mMiddlewareWebClientBaseTail = middlewareWebClientBase;
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class IndicatorBuilder {
        public AgentBuilder mAgentBuilder;

        public IndicatorBuilder(AgentBuilder agentBuilder) {
            this.mAgentBuilder = null;
            this.mAgentBuilder = agentBuilder;
        }

        public CommonBuilder closeIndicator() {
            this.mAgentBuilder.mEnableIndicator = false;
            this.mAgentBuilder.mIndicatorColor = -1;
            this.mAgentBuilder.mHeight = -1;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder setCustomIndicator(@NonNull BaseIndicatorView baseIndicatorView) {
            AgentBuilder agentBuilder;
            boolean z = true;
            if (baseIndicatorView != null) {
                this.mAgentBuilder.mEnableIndicator = true;
                this.mAgentBuilder.mBaseIndicatorView = baseIndicatorView;
                agentBuilder = this.mAgentBuilder;
                z = false;
            } else {
                this.mAgentBuilder.mEnableIndicator = true;
                agentBuilder = this.mAgentBuilder;
            }
            agentBuilder.mIsNeedDefaultProgress = z;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator() {
            this.mAgentBuilder.mEnableIndicator = true;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator(int i) {
            this.mAgentBuilder.mEnableIndicator = true;
            this.mAgentBuilder.mIndicatorColor = i;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator(@ColorInt int i, int i2) {
            this.mAgentBuilder.mIndicatorColor = i;
            this.mAgentBuilder.mHeight = i2;
            return new CommonBuilder(this.mAgentBuilder);
        }
    }

    /* loaded from: classes3.dex */
    public static final class PermissionInterceptorWrapper implements PermissionInterceptor {
        public WeakReference<PermissionInterceptor> mWeakReference;

        public PermissionInterceptorWrapper(PermissionInterceptor permissionInterceptor) {
            this.mWeakReference = new WeakReference<>(permissionInterceptor);
        }

        @Override // com.just.agentweb.PermissionInterceptor
        public boolean intercept(String str, String[] strArr, String str2) {
            if (this.mWeakReference.get() == null) {
                return false;
            }
            return this.mWeakReference.get().intercept(str, strArr, str2);
        }
    }

    /* loaded from: classes3.dex */
    public static class PreAgentWeb {
        public boolean isReady = false;
        public AgentWeb mAgentWeb;

        public PreAgentWeb(AgentWeb agentWeb) {
            this.mAgentWeb = agentWeb;
        }

        public AgentWeb get() {
            ready();
            return this.mAgentWeb;
        }

        /* renamed from: go */
        public AgentWeb m3704go(@Nullable String str) {
            if (!this.isReady) {
                ready();
            }
            return this.mAgentWeb.m3705go(str);
        }

        public PreAgentWeb ready() {
            if (!this.isReady) {
                this.mAgentWeb.ready();
                this.isReady = true;
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public enum SecurityType {
        DEFAULT_CHECK,
        STRICT_CHECK
    }

    public AgentWeb(AgentBuilder agentBuilder) {
        PermissionInterceptorWrapper permissionInterceptorWrapper = null;
        this.mAgentWeb = null;
        this.mJavaObjects = new ArrayMap<>();
        this.mTagTarget = 0;
        this.mWebSecurityController = null;
        this.mWebSecurityCheckLogic = null;
        this.mSecurityType = SecurityType.DEFAULT_CHECK;
        this.mAgentWebJsInterfaceCompat = null;
        this.mJsAccessEntrace = null;
        this.mIUrlLoader = null;
        this.mIVideo = null;
        this.mWebClientHelper = true;
        this.mIsInterceptUnkownUrl = true;
        this.mUrlHandleWays = -1;
        this.mJsInterfaceHolder = null;
        this.mTagTarget = agentBuilder.mTag;
        this.mActivity = agentBuilder.mActivity;
        this.mViewGroup = agentBuilder.mViewGroup;
        this.mIEventHandler = agentBuilder.mIEventHandler;
        this.mEnableIndicator = agentBuilder.mEnableIndicator;
        this.mWebCreator = agentBuilder.mWebCreator == null ? configWebCreator(agentBuilder.mBaseIndicatorView, agentBuilder.mIndex, agentBuilder.mLayoutParams, agentBuilder.mIndicatorColor, agentBuilder.mHeight, agentBuilder.mWebView, agentBuilder.mWebLayout) : agentBuilder.mWebCreator;
        this.mIndicatorController = agentBuilder.mIndicatorController;
        this.mWebChromeClient = agentBuilder.mWebChromeClient;
        this.mWebViewClient = agentBuilder.mWebViewClient;
        this.mAgentWeb = this;
        this.mAgentWebSettings = agentBuilder.mAgentWebSettings;
        if (agentBuilder.mJavaObject != null && !agentBuilder.mJavaObject.isEmpty()) {
            this.mJavaObjects.putAll((Map<? extends String, ? extends Object>) agentBuilder.mJavaObject);
            String str = TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mJavaObject size:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mJavaObjects.size());
            LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        this.mPermissionInterceptor = agentBuilder.mPermissionInterceptor != null ? new PermissionInterceptorWrapper(agentBuilder.mPermissionInterceptor) : permissionInterceptorWrapper;
        this.mSecurityType = agentBuilder.mSecurityType;
        this.mIUrlLoader = new UrlLoaderImpl(this.mWebCreator.mo4827create().getWebView(), agentBuilder.mHttpHeaders);
        if (this.mWebCreator.getWebParentLayout() instanceof WebParentLayout) {
            WebParentLayout webParentLayout = (WebParentLayout) this.mWebCreator.getWebParentLayout();
            webParentLayout.bindController(agentBuilder.mAgentWebUIController == null ? AgentWebUIControllerImplBase.build() : agentBuilder.mAgentWebUIController);
            webParentLayout.setErrorLayoutRes(agentBuilder.mErrorLayout, agentBuilder.mReloadId);
            webParentLayout.setErrorView(agentBuilder.mErrorView);
        }
        this.mWebLifeCycle = new DefaultWebLifeCycleImpl(this.mWebCreator.getWebView());
        this.mWebSecurityController = new WebSecurityControllerImpl(this.mWebCreator.getWebView(), this.mAgentWeb.mJavaObjects, this.mSecurityType);
        this.mWebClientHelper = agentBuilder.mWebClientHelper;
        this.mIsInterceptUnkownUrl = agentBuilder.mIsInterceptUnkownUrl;
        if (agentBuilder.mOpenOtherPage != null) {
            this.mUrlHandleWays = agentBuilder.mOpenOtherPage.code;
        }
        this.mMiddleWrareWebClientBaseHeader = agentBuilder.mMiddlewareWebClientBaseHeader;
        this.mMiddlewareWebChromeBaseHeader = agentBuilder.mChromeMiddleWareHeader;
        init();
    }

    private WebCreator configWebCreator(BaseIndicatorView baseIndicatorView, int i, ViewGroup.LayoutParams layoutParams, int i2, int i3, WebView webView, IWebLayout iWebLayout) {
        return (baseIndicatorView == null || !this.mEnableIndicator) ? this.mEnableIndicator ? new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i, i2, i3, webView, iWebLayout) : new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i, webView, iWebLayout) : new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i, baseIndicatorView, webView, iWebLayout);
    }

    private void doCompat() {
        ArrayMap<String, Object> arrayMap = this.mJavaObjects;
        AgentWebJsInterfaceCompat agentWebJsInterfaceCompat = new AgentWebJsInterfaceCompat(this, this.mActivity);
        this.mAgentWebJsInterfaceCompat = agentWebJsInterfaceCompat;
        arrayMap.put("agentWeb", agentWebJsInterfaceCompat);
    }

    private void doSafeCheck() {
        WebSecurityCheckLogic webSecurityCheckLogic = this.mWebSecurityCheckLogic;
        if (webSecurityCheckLogic == null) {
            webSecurityCheckLogic = WebSecurityLogicImpl.getInstance(this.mWebCreator.getWebViewType());
            this.mWebSecurityCheckLogic = webSecurityCheckLogic;
        }
        this.mWebSecurityController.check(webSecurityCheckLogic);
    }

    private android.webkit.WebChromeClient getChromeClient() {
        IndicatorController indicatorController = this.mIndicatorController;
        if (indicatorController == null) {
            indicatorController = IndicatorHandler.getInstance().inJectIndicator(this.mWebCreator.offer());
        }
        IndicatorController indicatorController2 = indicatorController;
        Activity activity = this.mActivity;
        this.mIndicatorController = indicatorController2;
        IVideo iVideo = getIVideo();
        this.mIVideo = iVideo;
        DefaultChromeClient defaultChromeClient = new DefaultChromeClient(activity, indicatorController2, null, iVideo, this.mPermissionInterceptor, this.mWebCreator.getWebView());
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("WebChromeClient:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mWebChromeClient);
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        MiddlewareWebChromeBase middlewareWebChromeBase = this.mMiddlewareWebChromeBaseHeader;
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (webChromeClient != null) {
            webChromeClient.enq(middlewareWebChromeBase);
            middlewareWebChromeBase = this.mWebChromeClient;
        }
        if (middlewareWebChromeBase == null) {
            this.mTargetChromeClient = defaultChromeClient;
            return defaultChromeClient;
        }
        int i = 1;
        MiddlewareWebChromeBase middlewareWebChromeBase2 = middlewareWebChromeBase;
        while (middlewareWebChromeBase2.next() != null) {
            middlewareWebChromeBase2 = middlewareWebChromeBase2.next();
            i++;
        }
        String str2 = TAG;
        LogUtils.m3701i(str2, "MiddlewareWebClientBase middleware count:" + i);
        middlewareWebChromeBase2.setDelegate(defaultChromeClient);
        this.mTargetChromeClient = middlewareWebChromeBase;
        return middlewareWebChromeBase;
    }

    private IVideo getIVideo() {
        IVideo iVideo = this.mIVideo;
        return iVideo == null ? new VideoImpl(this.mActivity, this.mWebCreator.getWebView()) : iVideo;
    }

    private EventInterceptor getInterceptor() {
        EventInterceptor eventInterceptor = this.mEventInterceptor;
        if (eventInterceptor != null) {
            return eventInterceptor;
        }
        IVideo iVideo = this.mIVideo;
        if (!(iVideo instanceof VideoImpl)) {
            return null;
        }
        EventInterceptor eventInterceptor2 = (EventInterceptor) iVideo;
        this.mEventInterceptor = eventInterceptor2;
        return eventInterceptor2;
    }

    private android.webkit.WebViewClient getWebViewClient() {
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getDelegate:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mMiddleWrareWebClientBaseHeader);
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        DefaultWebClient build = DefaultWebClient.createBuilder().setActivity(this.mActivity).setWebClientHelper(this.mWebClientHelper).setPermissionInterceptor(this.mPermissionInterceptor).setWebView(this.mWebCreator.getWebView()).setInterceptUnkownUrl(this.mIsInterceptUnkownUrl).setUrlHandleWays(this.mUrlHandleWays).build();
        MiddlewareWebClientBase middlewareWebClientBase = this.mMiddleWrareWebClientBaseHeader;
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient != null) {
            webViewClient.enq(middlewareWebClientBase);
            middlewareWebClientBase = this.mWebViewClient;
        }
        if (middlewareWebClientBase != null) {
            int i = 1;
            MiddlewareWebClientBase middlewareWebClientBase2 = middlewareWebClientBase;
            while (middlewareWebClientBase2.next() != null) {
                middlewareWebClientBase2 = middlewareWebClientBase2.next();
                i++;
            }
            String str2 = TAG;
            LogUtils.m3701i(str2, "MiddlewareWebClientBase middleware count:" + i);
            middlewareWebClientBase2.setDelegate(build);
            return middlewareWebClientBase;
        }
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: go */
    public AgentWeb m3705go(String str) {
        IndicatorController indicatorController;
        getUrlLoader().loadUrl(str);
        if (!TextUtils.isEmpty(str) && (indicatorController = getIndicatorController()) != null && indicatorController.offerIndicator() != null) {
            getIndicatorController().offerIndicator().show();
        }
        return this;
    }

    private void init() {
        doCompat();
        doSafeCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AgentWeb ready() {
        AgentWebConfig.initCookiesManager(StubApp.getOrigApplicationContext(this.mActivity.getApplicationContext()));
        IAgentWebSettings iAgentWebSettings = this.mAgentWebSettings;
        if (iAgentWebSettings == null) {
            iAgentWebSettings = AbsAgentWebSettings.getInstance();
            this.mAgentWebSettings = iAgentWebSettings;
        }
        boolean z = iAgentWebSettings instanceof AbsAgentWebSettings;
        if (z) {
            ((AbsAgentWebSettings) iAgentWebSettings).bindAgentWeb(this);
        }
        if (this.mWebListenerManager == null && z) {
            this.mWebListenerManager = (WebListenerManager) iAgentWebSettings;
        }
        iAgentWebSettings.toSetting(this.mWebCreator.getWebView());
        if (this.mJsInterfaceHolder == null) {
            this.mJsInterfaceHolder = JsInterfaceHolderImpl.getJsInterfaceHolder(this.mWebCreator, this.mSecurityType);
        }
        String str = TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mJavaObjects:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mJavaObjects.size());
        LogUtils.m3701i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        ArrayMap<String, Object> arrayMap = this.mJavaObjects;
        if (arrayMap != null && !arrayMap.isEmpty()) {
            this.mJsInterfaceHolder.addJavaObjects(this.mJavaObjects);
        }
        WebListenerManager webListenerManager = this.mWebListenerManager;
        if (webListenerManager != null) {
            webListenerManager.setDownloader(this.mWebCreator.getWebView(), null);
            this.mWebListenerManager.setWebChromeClient(this.mWebCreator.getWebView(), getChromeClient());
            this.mWebListenerManager.setWebViewClient(this.mWebCreator.getWebView(), getWebViewClient());
        }
        return this;
    }

    public static AgentBuilder with(@NonNull Activity activity) {
        if (activity != null) {
            return new AgentBuilder(activity);
        }
        throw new NullPointerException("activity can not be null .");
    }

    public static AgentBuilder with(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return new AgentBuilder(activity, fragment);
        }
        throw new NullPointerException("activity can not be null .");
    }

    public boolean back() {
        if (this.mIEventHandler == null) {
            this.mIEventHandler = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        }
        return this.mIEventHandler.back();
    }

    public AgentWeb clearWebCache() {
        if (getWebCreator().getWebView() != null) {
            AgentWebUtils.clearWebViewAllCache(this.mActivity, getWebCreator().getWebView());
        } else {
            AgentWebUtils.clearWebViewAllCache(this.mActivity);
        }
        return this;
    }

    public void destroy() {
        this.mWebLifeCycle.onDestroy();
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public IAgentWebSettings getAgentWebSettings() {
        return this.mAgentWebSettings;
    }

    public IEventHandler getIEventHandler() {
        IEventHandler iEventHandler = this.mIEventHandler;
        if (iEventHandler == null) {
            EventHandlerImpl instantce = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
            this.mIEventHandler = instantce;
            return instantce;
        }
        return iEventHandler;
    }

    public IndicatorController getIndicatorController() {
        return this.mIndicatorController;
    }

    public JsAccessEntrace getJsAccessEntrace() {
        JsAccessEntrace jsAccessEntrace = this.mJsAccessEntrace;
        if (jsAccessEntrace == null) {
            JsAccessEntraceImpl jsAccessEntraceImpl = JsAccessEntraceImpl.getInstance(this.mWebCreator.getWebView());
            this.mJsAccessEntrace = jsAccessEntraceImpl;
            return jsAccessEntraceImpl;
        }
        return jsAccessEntrace;
    }

    public JsInterfaceHolder getJsInterfaceHolder() {
        return this.mJsInterfaceHolder;
    }

    public PermissionInterceptor getPermissionInterceptor() {
        return this.mPermissionInterceptor;
    }

    public IUrlLoader getUrlLoader() {
        return this.mIUrlLoader;
    }

    public WebCreator getWebCreator() {
        return this.mWebCreator;
    }

    public WebLifeCycle getWebLifeCycle() {
        return this.mWebLifeCycle;
    }

    public boolean handleKeyEvent(int i, KeyEvent keyEvent) {
        if (this.mIEventHandler == null) {
            this.mIEventHandler = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        }
        return this.mIEventHandler.onKeyDown(i, keyEvent);
    }
}
