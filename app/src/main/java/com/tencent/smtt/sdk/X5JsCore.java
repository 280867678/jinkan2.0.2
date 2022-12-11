package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class X5JsCore {

    /* renamed from: a */
    public static EnumC1343a f2037a;

    /* renamed from: b */
    public static EnumC1343a f2038b;

    /* renamed from: c */
    public static EnumC1343a f2039c;

    /* renamed from: d */
    public final Context f2040d;

    /* renamed from: e */
    public Object f2041e;

    /* renamed from: f */
    public WebView f2042f;

    /* renamed from: com.tencent.smtt.sdk.X5JsCore$a */
    /* loaded from: classes4.dex */
    public enum EnumC1343a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE
    }

    static {
        EnumC1343a enumC1343a = EnumC1343a.UNINITIALIZED;
        f2037a = enumC1343a;
        f2038b = enumC1343a;
        f2039c = enumC1343a;
    }

    @Deprecated
    public X5JsCore(Context context) {
        Object m2663a;
        this.f2041e = null;
        this.f2042f = null;
        this.f2040d = context;
        if (canUseX5JsCore(context) && (m2663a = m2663a("createX5JavaBridge", new Class[]{Context.class}, context)) != null) {
            this.f2041e = m2663a;
            return;
        }
        WebView webView = new WebView(context);
        this.f2042f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
    }

    /* renamed from: a */
    public static IX5JsVirtualMachine m2664a(Context context, Looper looper) {
        Object m2663a;
        if (!canUseX5JsCore(context) || (m2663a = m2663a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper)) == null) {
            return null;
        }
        return (IX5JsVirtualMachine) m2663a;
    }

    /* renamed from: a */
    public static Object m2665a() {
        return m2663a("currentContextData", new Class[0], new Object[0]);
    }

    /* renamed from: a */
    public static Object m2663a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            C1416x m2294a = C1416x.m2294a();
            if (m2294a != null && m2294a.m2291b()) {
                return m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean canUseX5JsCore(Context context) {
        if (f2037a != EnumC1343a.UNINITIALIZED) {
            return f2037a == EnumC1343a.AVAILABLE;
        }
        f2037a = EnumC1343a.UNAVAILABLE;
        Object m2663a = m2663a("canUseX5JsCore", new Class[]{Context.class}, context);
        if (m2663a == null || !(m2663a instanceof Boolean) || !((Boolean) m2663a).booleanValue()) {
            return false;
        }
        m2663a("setJsValueFactory", new Class[]{Object.class}, JsValue.m2847a());
        f2037a = EnumC1343a.AVAILABLE;
        return true;
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        if (f2039c != EnumC1343a.UNINITIALIZED) {
            return f2039c == EnumC1343a.AVAILABLE;
        }
        f2039c = EnumC1343a.UNAVAILABLE;
        Object m2663a = m2663a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
        if (m2663a == null || !(m2663a instanceof Boolean) || !((Boolean) m2663a).booleanValue()) {
            return false;
        }
        f2039c = EnumC1343a.AVAILABLE;
        return true;
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        Object m2663a;
        if (f2038b != EnumC1343a.UNINITIALIZED) {
            return f2038b == EnumC1343a.AVAILABLE;
        }
        f2038b = EnumC1343a.UNAVAILABLE;
        if (!canUseX5JsCore(context) || (m2663a = m2663a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context)) == null || !(m2663a instanceof Boolean) || !((Boolean) m2663a).booleanValue()) {
            return false;
        }
        f2038b = EnumC1343a.AVAILABLE;
        return true;
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        Object obj2 = this.f2041e;
        if (obj2 != null) {
            m2663a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, obj2);
            return;
        }
        WebView webView = this.f2042f;
        if (webView == null) {
            return;
        }
        webView.addJavascriptInterface(obj, str);
        this.f2042f.loadUrl("about:blank");
    }

    @Deprecated
    public void destroy() {
        Object obj = this.f2041e;
        if (obj != null) {
            m2663a("destroyX5JsCore", new Class[]{Object.class}, obj);
            this.f2041e = null;
            return;
        }
        WebView webView = this.f2042f;
        if (webView == null) {
            return;
        }
        webView.clearHistory();
        this.f2042f.clearCache(true);
        this.f2042f.loadUrl("about:blank");
        this.f2042f.freeMemory();
        this.f2042f.pauseTimers();
        this.f2042f.destroy();
        this.f2042f = null;
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Object obj = this.f2041e;
        if (obj != null) {
            m2663a("evaluateJavascript", new Class[]{String.class, android.webkit.ValueCallback.class, Object.class}, str, valueCallback, obj);
            return;
        }
        WebView webView = this.f2042f;
        if (webView == null) {
            return;
        }
        webView.evaluateJavascript(str, valueCallback);
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i) {
        Object m2663a;
        if (this.f2041e == null || !canX5JsCoreUseNativeBuffer(this.f2040d) || (m2663a = m2663a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.f2041e, Integer.valueOf(i))) == null || !(m2663a instanceof ByteBuffer)) {
            return null;
        }
        return (ByteBuffer) m2663a;
    }

    @Deprecated
    public int getNativeBufferId() {
        Object m2663a;
        if (this.f2041e == null || !canX5JsCoreUseNativeBuffer(this.f2040d) || (m2663a = m2663a("getNativeBufferId", new Class[]{Object.class}, this.f2041e)) == null || !(m2663a instanceof Integer)) {
            return -1;
        }
        return ((Integer) m2663a).intValue();
    }

    @Deprecated
    public void pause() {
        Object obj = this.f2041e;
        if (obj != null) {
            m2663a("pause", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void pauseTimers() {
        Object obj = this.f2041e;
        if (obj != null) {
            m2663a("pauseTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        Object obj = this.f2041e;
        if (obj != null) {
            m2663a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, obj);
            return;
        }
        WebView webView = this.f2042f;
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface(str);
    }

    @Deprecated
    public void resume() {
        Object obj = this.f2041e;
        if (obj != null) {
            m2663a("resume", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void resumeTimers() {
        Object obj = this.f2041e;
        if (obj != null) {
            m2663a("resumeTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        if (this.f2041e == null || !canX5JsCoreUseNativeBuffer(this.f2040d)) {
            return;
        }
        m2663a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.f2041e, Integer.valueOf(i), byteBuffer);
    }
}
