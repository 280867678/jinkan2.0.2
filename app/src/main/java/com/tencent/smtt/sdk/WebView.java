package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.stub.StubApp;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.stat.C1397b;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.C1436d;
import com.tencent.smtt.utils.C1460i;
import com.tencent.smtt.utils.C1468o;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.tvspark.outline;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";

    /* renamed from: a */
    public volatile int f2001a;

    /* renamed from: b */
    public final String f2002b;

    /* renamed from: e */
    public boolean f2003e;

    /* renamed from: f */
    public IX5WebViewBase f2004f;

    /* renamed from: g */
    public C1342a f2005g;

    /* renamed from: h */
    public WebSettings f2006h;

    /* renamed from: i */
    public Context f2007i;

    /* renamed from: k */
    public volatile boolean f2008k;

    /* renamed from: m */
    public boolean f2009m;
    public WebViewCallbackClient mWebViewCallbackClient;

    /* renamed from: o */
    public WebViewClient f2010o;

    /* renamed from: p */
    public WebChromeClient f2011p;

    /* renamed from: r */
    public final int f2012r;

    /* renamed from: s */
    public final int f2013s;

    /* renamed from: t */
    public final int f2014t;

    /* renamed from: u */
    public final String f2015u;

    /* renamed from: v */
    public final String f2016v;

    /* renamed from: y */
    public Object f2017y;

    /* renamed from: z */
    public View.OnLongClickListener f2018z;

    /* renamed from: c */
    public static final Lock f1993c = new ReentrantLock();

    /* renamed from: d */
    public static OutputStream f1994d = null;

    /* renamed from: j */
    public static Context f1995j = null;
    public static boolean mWebViewCreated = false;

    /* renamed from: l */
    public static C1468o f1996l = null;

    /* renamed from: n */
    public static Method f1997n = null;

    /* renamed from: q */
    public static String f1998q = null;
    public static boolean mSysWebviewCreated = false;

    /* renamed from: w */
    public static Paint f1999w = null;

    /* renamed from: x */
    public static boolean f2000x = true;
    public static int NIGHT_MODE_ALPHA = 153;

    /* loaded from: classes4.dex */
    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;

        /* renamed from: a */
        public IX5WebViewBase.HitTestResult f2030a;

        /* renamed from: b */
        public WebView.HitTestResult f2031b;

        public HitTestResult() {
            this.f2031b = null;
            this.f2030a = null;
            this.f2031b = null;
        }

        public HitTestResult(WebView.HitTestResult hitTestResult) {
            this.f2031b = null;
            this.f2030a = null;
            this.f2031b = hitTestResult;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.f2031b = null;
            this.f2030a = hitTestResult;
            this.f2031b = null;
        }

        public String getExtra() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f2030a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            WebView.HitTestResult hitTestResult2 = this.f2031b;
            return hitTestResult2 != null ? hitTestResult2.getExtra() : "";
        }

        public int getType() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f2030a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            WebView.HitTestResult hitTestResult2 = this.f2031b;
            if (hitTestResult2 == null) {
                return 0;
            }
            return hitTestResult2.getType();
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface PictureListener {
        @Deprecated
        void onNewPicture(WebView webView, Picture picture);
    }

    /* loaded from: classes4.dex */
    public class WebViewTransport {

        /* renamed from: b */
        public WebView f2033b;

        public WebViewTransport() {
        }

        public synchronized WebView getWebView() {
            return this.f2033b;
        }

        public synchronized void setWebView(WebView webView) {
            this.f2033b = webView;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.WebView$a */
    /* loaded from: classes4.dex */
    public class C1342a extends android.webkit.WebView {
        public C1342a(WebView webView, Context context) {
            this(context, null);
        }

        public C1342a(Context context, AttributeSet attributeSet) {
            super(WebView.this.m2684d(context), attributeSet);
            if (!QbSdk.getIsSysWebViewForcedByOuter() || !TbsShareManager.isThirdPartyApp(context)) {
                CookieSyncManager.createInstance(WebView.this.f2007i).startSync();
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                    declaredMethod.setAccessible(true);
                    ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new C1364h());
                    WebView.mSysWebviewCreated = true;
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: a */
        public void m2673a() {
            super.computeScroll();
        }

        /* renamed from: a */
        public void m2672a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        @TargetApi(9)
        /* renamed from: a */
        public void m2670a(int i, int i2, boolean z, boolean z2) {
            super.onOverScrolled(i, i2, z, z2);
        }

        @TargetApi(9)
        /* renamed from: a */
        public boolean m2671a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        /* renamed from: a */
        public boolean m2669a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        /* renamed from: b */
        public boolean m2668b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        /* renamed from: c */
        public boolean m2667c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public void computeScroll() {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (WebView.f2000x || WebView.f1999w == null) {
                    return;
                }
                canvas.save();
                canvas.drawPaint(WebView.f1999w);
                canvas.restore();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView
        public android.webkit.WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.invalidate();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            WebView.this.onScrollChanged(i, i2, i3, i4);
        }

        @Override // android.webkit.WebView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }

        @Override // android.view.View
        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this) : super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        @Override // android.webkit.WebView, android.view.View
        public void setOverScrollMode(int i) {
            try {
                super.setOverScrollMode(i);
            } catch (Exception unused) {
            }
        }
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.f2002b = "WebView";
        this.f2003e = false;
        this.f2006h = null;
        this.f2007i = null;
        this.f2001a = 0;
        this.f2008k = false;
        this.f2009m = false;
        this.f2010o = null;
        this.f2011p = null;
        this.f2012r = 1;
        this.f2013s = 2;
        this.f2014t = 3;
        this.f2015u = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f2016v = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f2017y = null;
        this.f2018z = null;
        mWebViewCreated = true;
        C1472q.m1985a("0");
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.f2007i = context;
            this.f2004f = null;
            this.f2003e = false;
            QbSdk.m2833a(context, "failed to createTBSWebview!");
            this.f2005g = new C1342a(context, attributeSet);
            CookieManager.getInstance().m2853a(context, true, false);
            CookieSyncManager.createInstance(this.f2007i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new C1364h());
                mSysWebviewCreated = true;
            } catch (Exception unused) {
            }
            CookieManager.getInstance().m2854a();
            this.f2005g.setFocusableInTouchMode(true);
            addView(this.f2005g, new FrameLayout.LayoutParams(-1, -1));
            TbsLog.m2155i("WebView", "SystemWebView Created Success! #3, SysWebViewForcedByOuter.");
            TbsLog.m2156e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().m2815a(context, 402);
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.setWriteLogJIT(true);
        } else {
            TbsLog.setWriteLogJIT(false);
        }
        TbsLog.initIfNeed(context);
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (f1996l == null) {
            f1996l = C1468o.m2005a(context);
        }
        if (f1996l.f2538a) {
            TbsLog.m2156e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.m2833a(context, "debug.conf force syswebview!");
        }
        m2688c(context);
        this.f2007i = context;
        f1995j = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (!this.f2003e || QbSdk.f1740a) {
            this.f2004f = null;
            if (TbsShareManager.isThirdPartyApp(this.f2007i)) {
                this.f2005g = new C1342a(context, attributeSet);
            } else {
                this.f2005g = new C1342a(this, context);
            }
            TbsLog.m2155i("WebView", "SystemWebView Created Success! #2");
            if (TbsShareManager.isThirdPartyApp(context)) {
                C1472q.m1986a(context, "x5_webview_fail", "");
            }
            CookieManager.getInstance().m2853a(context, true, false);
            CookieManager.getInstance().m2854a();
            this.f2005g.setFocusableInTouchMode(true);
            addView(this.f2005g, new FrameLayout.LayoutParams(-1, -1));
            setDownloadListener(null);
            TbsLog.writeLogToDisk();
            C1381p.m2501a(context);
        } else {
            IX5WebViewBase m2285a = C1416x.m2294a().m2292a(true).m2285a(context);
            this.f2004f = m2285a;
            if (m2285a == null || m2285a.getView() == null) {
                TbsLog.m2156e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.f2004f = null;
                this.f2003e = false;
                QbSdk.m2833a(context, "failed to createTBSWebview!");
                m2688c(context);
                if (TbsShareManager.isThirdPartyApp(this.f2007i)) {
                    this.f2005g = new C1342a(context, attributeSet);
                } else {
                    this.f2005g = new C1342a(this, context);
                }
                TbsLog.m2155i("WebView", "SystemWebView Created Success! #1");
                CookieManager.getInstance().m2853a(context, true, false);
                CookieManager.getInstance().m2854a();
                this.f2005g.setFocusableInTouchMode(true);
                addView(this.f2005g, new FrameLayout.LayoutParams(-1, -1));
                try {
                    removeJavascriptInterface("searchBoxJavaBridge_");
                    removeJavascriptInterface("accessibility");
                    removeJavascriptInterface("accessibilityTraversal");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                TbsLog.writeLogToDisk();
                C1381p.m2501a(context);
                return;
            }
            TbsLog.m2155i("WebView", "X5 WebView Created Success!!");
            if (TbsShareManager.isThirdPartyApp(context)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(QbSdk.getTbsVersion(context));
                C1472q.m1986a(context, "x5_webview_ok", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            C1472q.m1985a("20");
            this.f2004f.getView().setFocusableInTouchMode(true);
            m2705a(attributeSet);
            addView(this.f2004f.getView(), new FrameLayout.LayoutParams(-1, -1));
            this.f2004f.setDownloadListener(new C1355b(this, null, this.f2003e));
            this.f2004f.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(C1416x.m2294a().m2292a(true).m2241k()) { // from class: com.tencent.smtt.sdk.WebView.1
                @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                public void invalidate() {
                }

                @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                public void onScrollChanged(int i2, int i3, int i4, int i5) {
                    super.onScrollChanged(i2, i3, i4, i5);
                    WebView.this.onScrollChanged(i4, i5, i2, i3);
                }
            });
        }
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if ((TbsConfig.APP_QQ.equals(this.f2007i.getApplicationInfo().packageName) || TbsConfig.APP_WX.equals(this.f2007i.getApplicationInfo().packageName)) && C1363g.m2597a(true).m2588h()) {
            setLayerType(1, null);
        }
        if (this.f2004f != null) {
            TbsLog.writeLogToDisk();
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == C1381p.m2503a().m2448i(context) || i2 != C1381p.m2503a().m2446j(context)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("webview construction #1 deCoupleCoreVersion is ", i2, " getTbsCoreShareDecoupleCoreVersion is ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1381p.m2503a().m2448i(context));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" getTbsCoreInstalledVerInNolock is ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1381p.m2503a().m2446j(context));
                    TbsLog.m2155i("WebView", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else {
                    C1381p.m2503a().m2440o(context);
                }
            }
        }
        QbSdk.continueLoadSo(context);
    }

    @Deprecated
    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    public WebView(Context context, boolean z) {
        super(context);
        this.f2002b = "WebView";
        this.f2003e = false;
        this.f2006h = null;
        this.f2007i = null;
        this.f2001a = 0;
        this.f2008k = false;
        this.f2009m = false;
        this.f2010o = null;
        this.f2011p = null;
        this.f2012r = 1;
        this.f2013s = 2;
        this.f2014t = 3;
        this.f2015u = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f2016v = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f2017y = null;
        this.f2018z = null;
    }

    /* renamed from: a */
    private void m2705a(AttributeSet attributeSet) {
        View view;
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f2004f.getView().setVerticalScrollBarEnabled(false);
                            view = this.f2004f.getView();
                        } else if (attributeIntValue == intArray[2]) {
                            this.f2004f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            view = this.f2004f.getView();
                        }
                        view.setHorizontalScrollBarEnabled(false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2696a(boolean z) {
        boolean z2;
        C1472q.m1980b("old03");
        if (!this.f2008k && this.f2001a != 0) {
            C1472q.m1980b("old04");
            this.f2008k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.f2003e) {
                C1472q.m1980b("old05");
                Bundle sdkQBStatisticsInfo = this.f2004f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
                C1472q.m1980b("old06");
            }
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            if (TbsConfig.APP_QZONE.equals(this.f2007i.getApplicationInfo().packageName)) {
                int m2681e = m2681e(this.f2007i);
                if (m2681e == -1) {
                    m2681e = this.f2001a;
                }
                this.f2001a = m2681e;
                m2678f(this.f2007i);
            }
            try {
                C1472q.m1980b("old07");
                z2 = this.f2004f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.m2148w("tbsWebviewDestroy", "exception: " + th);
                z2 = false;
            }
            C1472q.m1980b("old08");
            C1397b.m2382a(this.f2007i, str4, str5, str6, this.f2001a, this.f2003e, m2675i(), z2);
            C1472q.m1980b("old09");
            this.f2001a = 0;
            this.f2008k = false;
        }
        C1472q.m1980b("old10");
        if (!this.f2003e) {
            try {
                C1472q.m1980b("old11");
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, this.f2005g);
                if (invoke != null) {
                    C1472q.m1980b("old12");
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(invoke);
                    if (obj != null) {
                        C1472q.m1980b("old13");
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception unused) {
            }
            C1472q.m1980b("old14");
            if (z) {
                this.f2005g.destroy();
            }
            try {
                C1472q.m1980b("old15");
                TbsLog.m2155i("sdkreport", "webview.tbsWebviewDestroy mQQMusicCrashFix is " + this.f2009m);
                if (this.f2009m) {
                    return;
                }
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    C1472q.m1980b("old16");
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
                C1472q.m1980b("old17");
            } catch (Exception unused2) {
            }
        } else {
            C1472q.m1980b("old18");
            if (z) {
                this.f2004f.destroy();
            }
            C1472q.m1980b("old19");
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("X5 GUID = ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(QbSdk.m2827b());
        TbsLog.m2155i("WebView", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    /* renamed from: a */
    private boolean m2704a(View view) {
        Object m2049a;
        Context context = this.f2007i;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (m2049a = C1460i.m2049a(this.f2017y, "onLongClick", new Class[]{View.class}, view)) != null) {
            return ((Boolean) m2049a).booleanValue();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m2701a(WebChromeClient webChromeClient) {
        if (webChromeClient == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (Class<?> cls = webChromeClient.getClass(); cls != WebChromeClient.class && (!z || !z2); cls = cls.getSuperclass()) {
            if (!z) {
                try {
                    cls.getDeclaredMethod("onShowCustomView", View.class, IX5WebChromeClient.CustomViewCallback.class);
                    z = true;
                } catch (NoSuchMethodException unused) {
                }
            }
            if (!z2) {
                try {
                    cls.getDeclaredMethod("onHideCustomView", new Class[0]);
                    z2 = true;
                } catch (NoSuchMethodException unused2) {
                }
            }
        }
        return z && z2;
    }

    /* renamed from: b */
    private boolean m2694b(Context context) {
        try {
            return context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public static void m2689c() {
        try {
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (WebView.f1995j == null) {
                        TbsLog.m2161d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    C1363g m2597a = C1363g.m2597a(true);
                    if (C1363g.f2114b) {
                        TbsLog.m2161d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                        return;
                    }
                    C1379n m2526a = C1379n.m2526a(WebView.f1995j);
                    int m2518c = m2526a.m2518c();
                    TbsLog.m2161d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + m2518c);
                    if (m2518c == 2) {
                        TbsLog.m2161d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                        m2597a.m2598a(String.valueOf(m2526a.m2522b()));
                        m2597a.m2594b(true);
                        return;
                    }
                    int m2519b = m2526a.m2519b("copy_status");
                    TbsLog.m2161d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + m2519b);
                    if (m2519b == 1) {
                        TbsLog.m2161d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                        m2597a.m2598a(String.valueOf(m2526a.m2515c("copy_core_ver")));
                        m2597a.m2594b(true);
                    } else if (C1416x.m2294a().m2291b()) {
                    } else {
                        if (m2518c != 3 && m2519b != 3) {
                            return;
                        }
                        TbsLog.m2161d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                        m2597a.m2598a(String.valueOf(C1363g.m2592d()));
                        m2597a.m2594b(true);
                    }
                }
            }).start();
        } catch (Throwable th) {
            TbsLog.m2158e("webview", "updateRebootStatus excpetion: " + th);
        }
    }

    /* renamed from: c */
    private void m2688c(Context context) {
        if (QbSdk.f1748i && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        C1416x m2294a = C1416x.m2294a();
        m2294a.m2293a(context);
        this.f2003e = m2294a.m2291b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Context m2684d(Context context) {
        return Build.VERSION.SDK_INT <= 22 ? context.createConfigurationContext(new Configuration()) : context;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!C1416x.m2294a().m2291b()) {
            C1460i.m2048a("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public int m2681e(Context context) {
        FileLock m2197a;
        FileInputStream fileInputStream;
        StringBuilder sb;
        FileOutputStream m2176b = FileUtil.m2176b(context, true, "tbslock.txt");
        if (m2176b == null || (m2197a = FileUtil.m2197a(context, m2176b)) == null) {
            return -1;
        }
        if (!f1993c.tryLock()) {
            FileUtil.m2179a(m2197a, m2176b);
            return -1;
        }
        FileInputStream fileInputStream2 = null;
        fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                File tbsFolderDir = QbSdk.getTbsFolderDir(context);
                File file = new File(tbsFolderDir + File.separator + "core_private", "pv.db");
                if (file.exists()) {
                    Properties properties = new Properties();
                    fileInputStream = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream);
                        fileInputStream.close();
                        String str = "PV";
                        String property = properties.getProperty(str);
                        if (property != null) {
                            int parseInt = Integer.parseInt(property);
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCorePV IOException=");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
                                TbsLog.m2158e("getTbsCorePV", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                            }
                            f1993c.unlock();
                            FileUtil.m2179a(m2197a, m2176b);
                            return parseInt;
                        }
                        try {
                            fileInputStream.close();
                            fileInputStream2 = str;
                        } catch (IOException e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("TbsInstaller--getTbsCorePV IOException=");
                            sb.append(e.toString());
                            TbsLog.m2158e("getTbsCorePV", sb.toString());
                            f1993c.unlock();
                            FileUtil.m2179a(m2197a, m2176b);
                            return -1;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream3 = fileInputStream;
                        TbsLog.m2158e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                        fileInputStream2 = fileInputStream3;
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                                fileInputStream2 = fileInputStream3;
                            } catch (IOException e4) {
                                e = e4;
                                sb = new StringBuilder();
                                sb.append("TbsInstaller--getTbsCorePV IOException=");
                                sb.append(e.toString());
                                TbsLog.m2158e("getTbsCorePV", sb.toString());
                                f1993c.unlock();
                                FileUtil.m2179a(m2197a, m2176b);
                                return -1;
                            }
                        }
                        f1993c.unlock();
                        FileUtil.m2179a(m2197a, m2176b);
                        return -1;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCorePV IOException=");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e5.toString());
                                TbsLog.m2158e("getTbsCorePV", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                            }
                        }
                        f1993c.unlock();
                        FileUtil.m2179a(m2197a, m2176b);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        f1993c.unlock();
        FileUtil.m2179a(m2197a, m2176b);
        return -1;
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!C1416x.m2294a().m2291b()) {
            C1460i.m2048a("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2678f(Context context) {
        try {
            File tbsFolderDir = QbSdk.getTbsFolderDir(context);
            File file = new File(tbsFolderDir + File.separator + "core_private", "pv.db");
            if (!file.exists()) {
                return;
            }
            file.delete();
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCorePV Exception=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
            TbsLog.m2155i("getTbsCorePV", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    @Deprecated
    public static String findAddress(String str) {
        if (!C1416x.m2294a().m2291b()) {
            return android.webkit.WebView.findAddress(str);
        }
        return null;
    }

    /* renamed from: g */
    private void m2677g() {
        String str;
        synchronized (WebView.class) {
            C1472q.m1980b("new01");
            if (!this.f2008k && this.f2001a != 0) {
                m2674j();
            }
            C1472q.m1980b("new02");
        }
        if (!this.f2003e) {
            C1472q.m1980b("new03");
            this.f2005g.destroy();
            C1472q.m1980b("new04");
            try {
                TbsLog.m2155i("sdkreport", "webview.destroyImplNow mQQMusicCrashFix is " + this.f2009m);
                if (this.f2009m) {
                    return;
                }
                Field declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
                C1472q.m1980b("new05");
                if (componentCallbacks != null) {
                    declaredField.set(null, null);
                    Field declaredField2 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(null);
                    if (obj != null) {
                        List list = (List) obj;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
                C1472q.m1980b("new06");
                return;
            } catch (Exception unused) {
                str = "new07";
            }
        } else {
            C1472q.m1980b("new08");
            this.f2004f.destroy();
            str = "new09";
        }
        C1472q.m1980b(str);
    }

    public static String getCrashExtraMessage(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return "";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tbs_core_version:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(QbSdk.getTbsVersionForCrash(context));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(";");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("tbs_sdk_version:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(44115);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(";");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        boolean z = false;
        if (TbsConfig.APP_WX.equals(context.getApplicationInfo().packageName)) {
            try {
                Class.forName("de.robv.android.xposed.XposedBridge");
                z = true;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z) {
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "isXposed=true;");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C1363g.m2597a(true).m2591e());
        sb2.append("\n");
        sb2.append(sb);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.f1754o) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f1754o.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("weapp_id:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(QbSdk.f1754o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(";");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(QbSdk.f1754o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(";");
            String sb3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            sb2.append("\n");
            sb2.append(sb3);
        }
        return sb2.length() > 8192 ? sb2.substring(sb2.length() - 8192) : sb2.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (C1416x.m2294a().m2291b() || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) C1460i.m2048a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        synchronized (WebView.class) {
            if (!C1416x.m2294a().m2291b()) {
                return C1460i.m2048a("android.webkit.WebView", "getPluginList");
            }
            return null;
        }
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        m2689c();
        return C1363g.m2597a(true).m2590f();
    }

    public static int getTbsSDKVersion(Context context) {
        return 44115;
    }

    /* renamed from: h */
    private void m2676h() {
        try {
            C1472q.m1980b("old01");
            if ("com.xunmeng.pinduoduo".equals(this.f2007i.getApplicationInfo().packageName)) {
                new Thread("WebviewDestroy") { // from class: com.tencent.smtt.sdk.WebView.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        WebView.this.m2696a(false);
                    }
                }.start();
                if (this.f2003e) {
                    this.f2004f.destroy();
                } else {
                    this.f2005g.destroy();
                }
            } else {
                C1472q.m1980b("old02");
                m2696a(true);
            }
        } catch (Throwable unused) {
            C1472q.m1980b("old30");
            m2696a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public long m2675i() {
        long j;
        synchronized (QbSdk.f1747h) {
            if (QbSdk.f1744e) {
                QbSdk.f1746g = (System.currentTimeMillis() - QbSdk.f1745f) + QbSdk.f1746g;
                TbsLog.m2161d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.f1746g);
            }
            j = QbSdk.f1746g / 1000;
            QbSdk.f1746g = 0L;
            QbSdk.f1745f = System.currentTimeMillis();
        }
        return j;
    }

    /* renamed from: j */
    private void m2674j() {
        new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.7
            @Override // java.lang.Runnable
            public void run() {
                Bundle sdkQBStatisticsInfo;
                if (WebView.this.f2008k || WebView.this.f2001a == 0) {
                    return;
                }
                synchronized (WebView.class) {
                    if (!WebView.this.f2008k && WebView.this.f2001a != 0) {
                        WebView.this.f2008k = true;
                        String str = "";
                        String str2 = "";
                        String str3 = "";
                        if (WebView.this.f2003e && (sdkQBStatisticsInfo = WebView.this.f2004f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                            str = sdkQBStatisticsInfo.getString("guid");
                            str2 = sdkQBStatisticsInfo.getString("qua2");
                            str3 = sdkQBStatisticsInfo.getString("lc");
                        }
                        String str4 = str2;
                        String str5 = str3;
                        String str6 = str;
                        if (TbsConfig.APP_QZONE.equals(WebView.this.f2007i.getApplicationInfo().packageName)) {
                            int m2681e = WebView.this.m2681e(WebView.this.f2007i);
                            WebView webView = WebView.this;
                            if (m2681e == -1) {
                                m2681e = WebView.this.f2001a;
                            }
                            webView.f2001a = m2681e;
                            WebView.this.m2678f(WebView.this.f2007i);
                        }
                        C1397b.m2382a(WebView.this.f2007i, str6, str4, str5, WebView.this.f2001a, WebView.this.f2003e, WebView.this.m2675i(), WebView.this.f2004f.getX5WebViewExtension().isX5CoreSandboxMode());
                        WebView.this.f2001a = 0;
                        WebView.this.f2008k = false;
                    }
                }
            }
        }).start();
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                C1460i.m2052a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", (Class<?>[]) new Class[]{String.class}, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data_directory_suffix", str);
        QbSdk.initTbsSettings(hashMap);
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        int i;
        Paint paint;
        synchronized (WebView.class) {
            if (z == f2000x) {
                return;
            }
            f2000x = z;
            if (f1999w == null) {
                Paint paint2 = new Paint();
                f1999w = paint2;
                paint2.setColor(-16777216);
            }
            if (!z) {
                if (f1999w.getAlpha() != NIGHT_MODE_ALPHA) {
                    paint = f1999w;
                    i = NIGHT_MODE_ALPHA;
                    paint.setAlpha(i);
                }
                return;
            }
            i = 255;
            if (f1999w.getAlpha() != 255) {
                paint = f1999w;
                paint.setAlpha(i);
            }
            return;
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a != null && m2294a.m2291b()) {
            m2294a.m2289c().m2273a(z);
            return;
        }
        try {
            Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
            f1997n = declaredMethod;
            if (declaredMethod == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            f1997n.invoke(null, Boolean.valueOf(z));
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Exception:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getStackTrace());
            TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public android.webkit.WebView m2707a() {
        if (!this.f2003e) {
            return this.f2005g;
        }
        return null;
    }

    /* renamed from: a */
    public void m2706a(Context context) {
        String str;
        int m2681e = m2681e(context);
        if (m2681e != -1) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PV=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(String.valueOf(m2681e + 1));
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        } else {
            str = "PV=1";
        }
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        StringBuilder sb = new StringBuilder();
        sb.append(tbsFolderDir);
        File file = new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, "core_private"), "pv.db");
        try {
            file.getParentFile().mkdirs();
            if (!file.isFile() || !file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            f1994d = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            if (f1994d == null) {
                return;
            }
            f1994d.flush();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m2703a(android.webkit.WebView webView) {
    }

    /* renamed from: a */
    public void m2702a(IX5WebViewBase iX5WebViewBase) {
        this.f2004f = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (!this.f2003e) {
            this.f2005g.addJavascriptInterface(obj, str);
        } else {
            this.f2004f.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (!this.f2003e) {
            this.f2005g.addView(view);
            return;
        }
        View view2 = this.f2004f.getView();
        try {
            Method m2050a = C1460i.m2050a(view2, "addView", View.class);
            m2050a.setAccessible(true);
            m2050a.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public IX5WebViewBase m2695b() {
        return this.f2004f;
    }

    public boolean canGoBack() {
        return !this.f2003e ? this.f2005g.canGoBack() : this.f2004f.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.f2003e ? this.f2005g.canGoBackOrForward(i) : this.f2004f.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.f2003e ? this.f2005g.canGoForward() : this.f2004f.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (!this.f2003e) {
            Object m2051a = C1460i.m2051a(this.f2005g, "canZoomIn");
            if (m2051a != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return this.f2004f.canZoomIn();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (!this.f2003e) {
            Object m2051a = C1460i.m2051a(this.f2005g, "canZoomOut");
            if (m2051a != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return this.f2004f.canZoomOut();
    }

    @Deprecated
    public Picture capturePicture() {
        if (!this.f2003e) {
            Object m2051a = C1460i.m2051a(this.f2005g, "capturePicture");
            if (m2051a != null) {
                return (Picture) m2051a;
            }
            return null;
        }
        return this.f2004f.capturePicture();
    }

    public void clearCache(boolean z) {
        if (!this.f2003e) {
            this.f2005g.clearCache(z);
        } else {
            this.f2004f.clearCache(z);
        }
    }

    public void clearFormData() {
        if (!this.f2003e) {
            this.f2005g.clearFormData();
        } else {
            this.f2004f.clearFormData();
        }
    }

    public void clearHistory() {
        if (!this.f2003e) {
            this.f2005g.clearHistory();
        } else {
            this.f2004f.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (!this.f2003e) {
            this.f2005g.clearMatches();
        } else {
            this.f2004f.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (!this.f2003e) {
            this.f2005g.clearSslPreferences();
        } else {
            this.f2004f.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (!this.f2003e) {
            C1460i.m2051a(this.f2005g, "clearView");
        } else {
            this.f2004f.clearView();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        try {
            if (this.f2003e) {
                Method m2050a = C1460i.m2050a(this.f2004f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                m2050a.setAccessible(true);
                return ((Integer) m2050a.invoke(this.f2004f.getView(), new Object[0])).intValue();
            }
            Method m2050a2 = C1460i.m2050a(this.f2005g, "computeHorizontalScrollExtent", new Class[0]);
            m2050a2.setAccessible(true);
            return ((Integer) m2050a2.invoke(this.f2005g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        try {
            if (this.f2003e) {
                Method m2050a = C1460i.m2050a(this.f2004f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                m2050a.setAccessible(true);
                return ((Integer) m2050a.invoke(this.f2004f.getView(), new Object[0])).intValue();
            }
            Method m2050a2 = C1460i.m2050a(this.f2005g, "computeHorizontalScrollOffset", new Class[0]);
            m2050a2.setAccessible(true);
            return ((Integer) m2050a2.invoke(this.f2005g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        try {
            if (this.f2003e) {
                return ((Integer) C1460i.m2049a(this.f2004f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method m2050a = C1460i.m2050a(this.f2005g, "computeHorizontalScrollRange", new Class[0]);
            m2050a.setAccessible(true);
            return ((Integer) m2050a.invoke(this.f2005g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f2003e) {
            this.f2005g.computeScroll();
        } else {
            this.f2004f.computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        try {
            if (this.f2003e) {
                Method m2050a = C1460i.m2050a(this.f2004f.getView(), "computeVerticalScrollExtent", new Class[0]);
                m2050a.setAccessible(true);
                return ((Integer) m2050a.invoke(this.f2004f.getView(), new Object[0])).intValue();
            }
            Method m2050a2 = C1460i.m2050a(this.f2005g, "computeVerticalScrollExtent", new Class[0]);
            m2050a2.setAccessible(true);
            return ((Integer) m2050a2.invoke(this.f2005g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        try {
            if (this.f2003e) {
                Method m2050a = C1460i.m2050a(this.f2004f.getView(), "computeVerticalScrollOffset", new Class[0]);
                m2050a.setAccessible(true);
                return ((Integer) m2050a.invoke(this.f2004f.getView(), new Object[0])).intValue();
            }
            Method m2050a2 = C1460i.m2050a(this.f2005g, "computeVerticalScrollOffset", new Class[0]);
            m2050a2.setAccessible(true);
            return ((Integer) m2050a2.invoke(this.f2005g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        try {
            if (this.f2003e) {
                return ((Integer) C1460i.m2049a(this.f2004f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method m2050a = C1460i.m2050a(this.f2005g, "computeVerticalScrollRange", new Class[0]);
            m2050a.setAccessible(true);
            return ((Integer) m2050a.invoke(this.f2005g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.f2003e ? WebBackForwardList.m2713a(this.f2004f.copyBackForwardList()) : WebBackForwardList.m2714a(this.f2005g.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        if (this.f2003e) {
            try {
                return this.f2004f.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return C1460i.m2049a(this.f2005g, "createPrintDocumentAdapter", new Class[]{String.class}, str);
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (!this.f2003e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z);
        bundle.putString("path", str);
        getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
    }

    public void destroy() {
        boolean z = false;
        this.f2009m = false;
        try {
            if (this.f2007i.getApplicationInfo().packageName.contains("com.tencent.qqmusic") && (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22)) {
                this.f2009m = true;
                if (!C1472q.m1974f(this.f2007i)) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "webview");
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("destroy forceDestoyOld is ", z, "webview");
        if (z) {
            m2676h();
        } else {
            m2677g();
        }
    }

    public void documentHasImages(Message message) {
        if (!this.f2003e) {
            this.f2005g.documentHasImages(message);
        } else {
            this.f2004f.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
        } else {
            this.f2004f.dumpViewHierarchyWithProperties(bufferedWriter, i);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.f2003e) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f2005g, str, valueCallback);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Method m2050a = C1460i.m2050a(this.f2004f.getView(), "evaluateJavascript", String.class, android.webkit.ValueCallback.class);
            m2050a.setAccessible(true);
            m2050a.invoke(this.f2004f.getView(), str, valueCallback);
        } catch (Exception e2) {
            e2.printStackTrace();
            loadUrl(str);
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (!this.f2003e) {
            Object m2049a = C1460i.m2049a(this.f2005g, "findAll", new Class[]{String.class}, str);
            if (m2049a != null) {
                return ((Integer) m2049a).intValue();
            }
            return 0;
        }
        return this.f2004f.findAll(str);
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "findAllAsync", new Class[]{String.class}, str);
        } else {
            this.f2004f.findAllAsync(str);
        }
    }

    public View findHierarchyView(String str, int i) {
        return !this.f2003e ? (View) C1460i.m2049a(this.f2005g, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i)) : this.f2004f.findHierarchyView(str, i);
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (!this.f2003e) {
            this.f2005g.findNext(z);
        } else {
            this.f2004f.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (!this.f2003e) {
            this.f2005g.flingScroll(i, i2);
        } else {
            this.f2004f.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (!this.f2003e) {
            C1460i.m2051a(this.f2005g, "freeMemory");
        } else {
            this.f2004f.freeMemory();
        }
    }

    public SslCertificate getCertificate() {
        return !this.f2003e ? this.f2005g.getCertificate() : this.f2004f.getCertificate();
    }

    public int getContentHeight() {
        return !this.f2003e ? this.f2005g.getContentHeight() : this.f2004f.getContentHeight();
    }

    public int getContentWidth() {
        if (!this.f2003e) {
            Object m2051a = C1460i.m2051a(this.f2005g, "getContentWidth");
            if (m2051a != null) {
                return ((Integer) m2051a).intValue();
            }
            return 0;
        }
        return this.f2004f.getContentWidth();
    }

    public Bitmap getFavicon() {
        return !this.f2003e ? this.f2005g.getFavicon() : this.f2004f.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.f2003e ? new HitTestResult(this.f2005g.getHitTestResult()) : new HitTestResult(this.f2004f.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.f2003e ? this.f2005g.getHttpAuthUsernamePassword(str, str2) : this.f2004f.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.f2003e ? this.f2005g.getOriginalUrl() : this.f2004f.getOriginalUrl();
    }

    public int getProgress() {
        return !this.f2003e ? this.f2005g.getProgress() : this.f2004f.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        Object m2051a;
        try {
            if (!this.f2003e && Build.VERSION.SDK_INT >= 26 && (m2051a = C1460i.m2051a(this.f2005g, "getRendererPriorityWaivedWhenNotVisible")) != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        Object m2051a;
        try {
            if (!this.f2003e && Build.VERSION.SDK_INT >= 26 && (m2051a = C1460i.m2051a(this.f2005g, "getRendererRequestedPriority")) != null) {
                return ((Integer) m2051a).intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (!this.f2003e) {
            Object m2051a = C1460i.m2051a(this.f2005g, "getScale");
            if (m2051a != null) {
                return ((Float) m2051a).floatValue();
            }
            return 0.0f;
        }
        return this.f2004f.getScale();
    }

    @Override // android.view.View
    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    @Override // android.view.View
    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    @Override // android.view.View
    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        WebSettings webSettings = this.f2006h;
        if (webSettings != null) {
            return webSettings;
        }
        WebSettings webSettings2 = this.f2003e ? new WebSettings(this.f2004f.getSettings()) : new WebSettings(this.f2005g.getSettings());
        this.f2006h = webSettings2;
        return webSettings2;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        if (!this.f2003e) {
            return null;
        }
        return this.f2004f.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.f2003e ? this.f2005g.getTitle() : this.f2004f.getTitle();
    }

    public String getUrl() {
        return !this.f2003e ? this.f2005g.getUrl() : this.f2004f.getUrl();
    }

    public View getView() {
        return !this.f2003e ? this.f2005g : this.f2004f.getView();
    }

    public int getVisibleTitleHeight() {
        if (!this.f2003e) {
            Object m2051a = C1460i.m2051a(this.f2005g, "getVisibleTitleHeight");
            if (m2051a != null) {
                return ((Integer) m2051a).intValue();
            }
            return 0;
        }
        return this.f2004f.getVisibleTitleHeight();
    }

    public WebChromeClient getWebChromeClient() {
        return this.f2011p;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (!this.f2003e) {
            return null;
        }
        return this.f2004f.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        return this.f2003e ? this.f2004f.getView().getScrollX() : this.f2005g.getScrollX();
    }

    public int getWebScrollY() {
        return this.f2003e ? this.f2004f.getView().getScrollY() : this.f2005g.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.f2010o;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        if (!this.f2003e) {
            return null;
        }
        return this.f2004f.getX5WebViewExtension().getWebViewClientExtension();
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (!this.f2003e) {
            return null;
        }
        return this.f2004f.getHitTestResult();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        if (!this.f2003e) {
            return null;
        }
        return this.f2004f.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        return !this.f2003e ? (View) C1460i.m2051a(this.f2005g, "getZoomControls") : this.f2004f.getZoomControls();
    }

    public void goBack() {
        if (!this.f2003e) {
            this.f2005g.goBack();
        } else {
            this.f2004f.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (!this.f2003e) {
            this.f2005g.goBackOrForward(i);
        } else {
            this.f2004f.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (!this.f2003e) {
            this.f2005g.goForward();
        } else {
            this.f2004f.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (!this.f2003e) {
            this.f2005g.invokeZoomPicker();
        } else {
            this.f2004f.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return f2000x;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (!this.f2003e) {
            Object m2051a = C1460i.m2051a(this.f2005g, "isPrivateBrowsingEnabled");
            if (m2051a != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return this.f2004f.isPrivateBrowsingEnable();
    }

    public void loadData(String str, String str2, String str3) {
        if (!this.f2003e) {
            this.f2005g.loadData(str, str2, str3);
        } else {
            this.f2004f.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.f2003e) {
            this.f2005g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f2004f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (!this.f2003e) {
            this.f2005g.loadUrl(str);
        } else {
            this.f2004f.loadUrl(str);
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (!this.f2003e) {
            this.f2005g.loadUrl(str, map);
        } else {
            this.f2004f.loadUrl(str, map);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2008k || this.f2001a == 0) {
            return;
        }
        m2674j();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        View.OnLongClickListener onLongClickListener = this.f2018z;
        if (onLongClickListener == null || !onLongClickListener.onLongClick(view)) {
            return m2704a(view);
        }
        return true;
    }

    public void onPause() {
        if (!this.f2003e) {
            C1460i.m2051a(this.f2005g, "onPause");
        } else {
            this.f2004f.onPause();
        }
    }

    public void onResume() {
        if (!this.f2003e) {
            C1460i.m2051a(this.f2005g, "onResume");
        } else {
            this.f2004f.onResume();
        }
    }

    @Override // android.view.View
    @TargetApi(11)
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!m2694b(this.f2007i) || !isHardwareAccelerated() || i <= 0 || i2 <= 0) {
            return;
        }
        getLayerType();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        Context context = this.f2007i;
        if (context == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (f1998q == null) {
            f1998q = context.getApplicationInfo().packageName;
        }
        String str = f1998q;
        if (str != null && (str.equals(TbsConfig.APP_WX) || f1998q.equals(TbsConfig.APP_QQ))) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (i != 0 && !this.f2008k && this.f2001a != 0) {
            m2674j();
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.f2003e ? this.f2005g.overlayHorizontalScrollbar() : this.f2004f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.f2003e ? this.f2004f.overlayVerticalScrollbar() : this.f2005g.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.f2003e ? this.f2005g.pageDown(z) : this.f2004f.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.f2003e ? this.f2005g.pageUp(z) : this.f2004f.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (!this.f2003e) {
            this.f2005g.pauseTimers();
        } else {
            this.f2004f.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (!this.f2003e) {
            this.f2005g.postUrl(str, bArr);
        } else {
            this.f2004f.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        } else {
            this.f2004f.refreshPlugins(z);
        }
    }

    public void reload() {
        if (!this.f2003e) {
            this.f2005g.reload();
        } else {
            this.f2004f.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "removeJavascriptInterface", new Class[]{String.class}, str);
        } else {
            this.f2004f.removeJavascriptInterface(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (!this.f2003e) {
            this.f2005g.removeView(view);
            return;
        }
        View view2 = this.f2004f.getView();
        try {
            Method m2050a = C1460i.m2050a(view2, "removeView", View.class);
            m2050a.setAccessible(true);
            m2050a.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public JSONObject reportInitPerformance(long j, int i, long j2, long j3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IS_X5", this.f2003e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (!this.f2003e) {
            C1342a c1342a = this.f2005g;
            if (view == this) {
                view = c1342a;
            }
            return c1342a.requestChildRectangleOnScreen(view, rect, z);
        }
        View view2 = this.f2004f.getView();
        if (!(view2 instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view2;
        if (view == this) {
            view = view2;
        }
        return viewGroup.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (!this.f2003e) {
            this.f2005g.requestFocusNodeHref(message);
        } else {
            this.f2004f.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (!this.f2003e) {
            this.f2005g.requestImageRef(message);
        } else {
            this.f2004f.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (!this.f2003e) {
            Object m2049a = C1460i.m2049a(this.f2005g, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
            if (m2049a != null) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        }
        return this.f2004f.restorePicture(bundle, file);
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.f2003e ? WebBackForwardList.m2714a(this.f2005g.restoreState(bundle)) : WebBackForwardList.m2713a(this.f2004f.restoreState(bundle));
    }

    public void resumeTimers() {
        if (!this.f2003e) {
            this.f2005g.resumeTimers();
        } else {
            this.f2004f.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        } else {
            this.f2004f.savePassword(str, str2, str3);
        }
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (!this.f2003e) {
            Object m2049a = C1460i.m2049a(this.f2005g, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
            if (m2049a != null) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        }
        return this.f2004f.savePicture(bundle, file);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.f2003e ? WebBackForwardList.m2714a(this.f2005g.saveState(bundle)) : WebBackForwardList.m2713a(this.f2004f.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "saveWebArchive", new Class[]{String.class}, str);
        } else {
            this.f2004f.saveWebArchive(str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, android.webkit.ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
        } else {
            this.f2004f.saveWebArchive(str, z, valueCallback);
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (!this.f2003e) {
                return;
            }
            getSettingsExtension().setARModeEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!this.f2003e) {
            this.f2005g.setBackgroundColor(i);
        } else {
            this.f2004f.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (!this.f2003e) {
            this.f2005g.setCertificate(sslCertificate);
        } else {
            this.f2004f.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.f2003e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        boolean z = this.f2003e;
        if (!z) {
            this.f2005g.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.tencent.smtt.sdk.WebView.4
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onDownloadStart(str, str2, str3, str4, j);
                        return;
                    }
                    ApplicationInfo applicationInfo = WebView.this.f2007i == null ? null : WebView.this.f2007i.getApplicationInfo();
                    if (applicationInfo != null && TbsConfig.APP_WX.equals(applicationInfo.packageName)) {
                        return;
                    }
                    MttLoader.loadUrl(WebView.this.f2007i, str, null, null);
                }
            });
        } else {
            this.f2004f.setDownloadListener(new C1355b(this, downloadListener, z));
        }
    }

    @TargetApi(16)
    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        if (!this.f2003e) {
            this.f2005g.setFindListener(new WebView.FindListener() { // from class: com.tencent.smtt.sdk.WebView.3
                @Override // android.webkit.WebView.FindListener
                public void onFindResultReceived(int i, int i2, boolean z) {
                    findListener.onFindResultReceived(i, i2, z);
                }
            });
        } else {
            this.f2004f.setFindListener(findListener);
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (!this.f2003e) {
            this.f2005g.setHorizontalScrollbarOverlay(z);
        } else {
            this.f2004f.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (!this.f2003e) {
            this.f2005g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f2004f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (!this.f2003e) {
            this.f2005g.setInitialScale(i);
        } else {
            this.f2004f.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (!this.f2003e) {
            C1460i.m2049a(this.f2005g, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        } else {
            this.f2004f.setMapTrackballToArrowKeys(z);
        }
    }

    public void setNetworkAvailable(boolean z) {
        if (!this.f2003e) {
            this.f2005g.setNetworkAvailable(z);
        } else {
            this.f2004f.setNetworkAvailable(z);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (!this.f2003e) {
            this.f2005g.setOnLongClickListener(onLongClickListener);
            return;
        }
        View view = this.f2004f.getView();
        try {
            if (this.f2017y == null) {
                Method m2050a = C1460i.m2050a(view, "getListenerInfo", new Class[0]);
                m2050a.setAccessible(true);
                Object invoke = m2050a.invoke(view, null);
                Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.f2017y = declaredField.get(invoke);
            }
            this.f2018z = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    @Deprecated
    public void setPictureListener(final PictureListener pictureListener) {
        if (!this.f2003e) {
            if (pictureListener == null) {
                this.f2005g.setPictureListener(null);
            } else {
                this.f2005g.setPictureListener(new WebView.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.5
                    @Override // android.webkit.WebView.PictureListener
                    public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                        WebView.this.m2703a(webView);
                        pictureListener.onNewPicture(WebView.this, picture);
                    }
                });
            }
        } else if (pictureListener == null) {
            this.f2004f.setPictureListener(null);
        } else {
            this.f2004f.setPictureListener(new IX5WebViewBase.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.6
                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
                    WebView.this.m2702a(iX5WebViewBase);
                    pictureListener.onNewPicture(WebView.this, picture);
                }

                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                }
            });
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        try {
            if (this.f2003e || Build.VERSION.SDK_INT < 26) {
                return;
            }
            C1460i.m2049a(this.f2005g, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (this.f2003e) {
            this.f2004f.getView().setScrollBarStyle(i);
        } else {
            this.f2005g.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (!this.f2003e) {
            this.f2005g.setVerticalScrollbarOverlay(z);
        } else {
            this.f2004f.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f2004f == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f2004f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() == null) {
            return;
        }
        getView().setVisibility(i);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        C1342a c1342a;
        android.webkit.WebChromeClient webChromeClient2 = null;
        C1365i c1365i = null;
        if (this.f2003e) {
            IX5WebViewBase iX5WebViewBase = this.f2004f;
            if (webChromeClient != null) {
                c1365i = new C1365i(C1416x.m2294a().m2292a(true).m2246i(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(c1365i);
        } else {
            if (webChromeClient == null) {
                c1342a = this.f2005g;
            } else if (m2701a(webChromeClient)) {
                c1342a = this.f2005g;
                webChromeClient2 = new C1361e(this, webChromeClient);
            } else {
                c1342a = this.f2005g;
                webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
            }
            c1342a.setWebChromeClient(webChromeClient2);
        }
        this.f2011p = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (!this.f2003e) {
            return;
        }
        this.f2004f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (!this.f2003e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("flag", true);
        getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        SystemWebViewClient systemWebViewClient = null;
        C1371j c1371j = null;
        if (this.f2003e) {
            IX5WebViewBase iX5WebViewBase = this.f2004f;
            if (webViewClient != null) {
                c1371j = new C1371j(C1416x.m2294a().m2292a(true).m2243j(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(c1371j);
        } else {
            C1342a c1342a = this.f2005g;
            if (webViewClient != null) {
                systemWebViewClient = new SystemWebViewClient(this, webViewClient);
            }
            c1342a.setWebViewClient(systemWebViewClient);
        }
        this.f2010o = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (!this.f2003e) {
            return;
        }
        this.f2004f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("https://debugtbs.qq.com")) {
            getView().setVisibility(4);
            C1436d.m2097a(this.f2007i).m2095a(lowerCase, this, this.f2007i, HandlerThreadC1380o.m2510a().getLooper());
            return true;
        } else if (!lowerCase.startsWith("https://debugx5.qq.com") || this.f2003e) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("<!DOCTYPE html><html><body>");
            sb.append("<head>");
            sb.append("<title>无法打开debugx5</title>");
            sb.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
            sb.append("</head>");
            loadDataWithBaseURL(null, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />", "尝试<a href=\"https://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>", "</body></html>"), "text/html", "utf-8", null);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (!this.f2003e) {
            this.f2005g.stopLoading();
        } else {
            this.f2004f.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (!this.f2003e) {
            this.f2005g.m2673a();
            return;
        }
        try {
            C1460i.m2051a(this.f2004f.getView(), "super_computeScroll");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f2003e) {
            return this.f2005g.m2668b(motionEvent);
        }
        try {
            Object m2049a = C1460i.m2049a(this.f2004f.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (m2049a != null) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f2003e) {
            return this.f2005g.m2667c(motionEvent);
        }
        try {
            Object m2049a = C1460i.m2049a(this.f2004f.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (m2049a != null) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!this.f2003e) {
            this.f2005g.m2670a(i, i2, z, z2);
            return;
        }
        try {
            C1460i.m2049a(this.f2004f.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (!this.f2003e) {
            this.f2005g.m2672a(i, i2, i3, i4);
            return;
        }
        try {
            C1460i.m2049a(this.f2004f.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.f2003e) {
            return this.f2005g.m2669a(motionEvent);
        }
        try {
            Object m2049a = C1460i.m2049a(this.f2004f.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (m2049a != null) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.f2003e) {
            return this.f2005g.m2671a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        try {
            Object m2049a = C1460i.m2049a(this.f2004f.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
            if (m2049a != null) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        String str;
        if (z == f2000x) {
            return;
        }
        f2000x = z;
        if (z) {
            TbsLog.m2158e("QB_SDK", "deleteNightMode");
            str = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        } else {
            TbsLog.m2158e("QB_SDK", "nightMode");
            str = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        }
        loadUrl(str);
    }

    public void switchToNightMode() {
        TbsLog.m2158e("QB_SDK", "switchToNightMode 01");
        if (!f2000x) {
            TbsLog.m2158e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        return !this.f2003e ? this.f2005g.zoomIn() : this.f2004f.zoomIn();
    }

    public boolean zoomOut() {
        return !this.f2003e ? this.f2005g.zoomOut() : this.f2004f.zoomOut();
    }
}
