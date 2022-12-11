package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.utils.C1460i;

/* loaded from: classes4.dex */
public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* renamed from: a */
    public IX5WebSettings f1988a;

    /* renamed from: b */
    public android.webkit.WebSettings f1989b;

    /* renamed from: c */
    public boolean f1990c;

    /* loaded from: classes4.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    /* loaded from: classes4.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* loaded from: classes4.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* loaded from: classes4.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);
        
        public int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        public int value;

        ZoomDensity(int i) {
            this.value = i;
        }
    }

    public WebSettings(android.webkit.WebSettings webSettings) {
        this.f1988a = null;
        this.f1989b = null;
        this.f1990c = false;
        this.f1988a = null;
        this.f1989b = webSettings;
        this.f1990c = false;
    }

    public WebSettings(IX5WebSettings iX5WebSettings) {
        this.f1988a = null;
        this.f1989b = null;
        this.f1990c = false;
        this.f1988a = iX5WebSettings;
        this.f1989b = null;
        this.f1990c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        if (C1416x.m2294a().m2291b()) {
            return C1416x.m2294a().m2289c().m2245i(context);
        }
        Object m2052a = C1460i.m2052a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context);
        if (m2052a != null) {
            return (String) m2052a;
        }
        return null;
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        android.webkit.WebSettings webSettings;
        Object m2051a;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null && (m2051a = C1460i.m2051a(webSettings, "enableSmoothTransition")) != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return iX5WebSettings.enableSmoothTransition();
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        android.webkit.WebSettings webSettings;
        Object m2051a;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null && (m2051a = C1460i.m2051a(webSettings, "getAllowContentAccess")) != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return iX5WebSettings.getAllowContentAccess();
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.getAllowFileAccess();
            }
            return false;
        }
        return iX5WebSettings.getAllowFileAccess();
    }

    public synchronized boolean getBlockNetworkImage() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getBlockNetworkImage();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getBlockNetworkImage();
        }
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getBlockNetworkLoads();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getBlockNetworkLoads();
        }
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.getBuiltInZoomControls();
            }
            return false;
        }
        return iX5WebSettings.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.getCacheMode();
            }
            return 0;
        }
        return iX5WebSettings.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getCursiveFontFamily();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getCursiveFontFamily();
        }
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getDatabaseEnabled();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getDatabaseEnabled();
        }
    }

    @TargetApi(5)
    @Deprecated
    public synchronized String getDatabasePath() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getDatabasePath();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getDatabasePath();
        }
    }

    public synchronized int getDefaultFixedFontSize() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getDefaultFixedFontSize();
        } else if (this.f1990c || this.f1989b == null) {
            return 0;
        } else {
            return this.f1989b.getDefaultFixedFontSize();
        }
    }

    public synchronized int getDefaultFontSize() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getDefaultFontSize();
        } else if (this.f1990c || this.f1989b == null) {
            return 0;
        } else {
            return this.f1989b.getDefaultFontSize();
        }
    }

    public synchronized String getDefaultTextEncodingName() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getDefaultTextEncodingName();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getDefaultTextEncodingName();
        }
    }

    @TargetApi(7)
    @Deprecated
    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        String name;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            name = iX5WebSettings.getDefaultZoom().name();
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
            return null;
        } else {
            name = webSettings.getDefaultZoom().name();
        }
        return ZoomDensity.valueOf(name);
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        android.webkit.WebSettings webSettings;
        Object m2051a;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null && (m2051a = C1460i.m2051a(webSettings, "getDisplayZoomControls")) != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return iX5WebSettings.getDisplayZoomControls();
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getDomStorageEnabled();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getDomStorageEnabled();
        }
    }

    public synchronized String getFantasyFontFamily() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getFantasyFontFamily();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getFantasyFontFamily();
        }
    }

    public synchronized String getFixedFontFamily() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getFixedFontFamily();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getFixedFontFamily();
        }
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getJavaScriptCanOpenWindowsAutomatically();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getJavaScriptCanOpenWindowsAutomatically();
        }
    }

    public synchronized boolean getJavaScriptEnabled() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getJavaScriptEnabled();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getJavaScriptEnabled();
        }
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        if (this.f1990c && this.f1988a != null) {
            return LayoutAlgorithm.valueOf(this.f1988a.getLayoutAlgorithm().name());
        } else if (this.f1990c || this.f1989b == null) {
            return null;
        } else {
            return LayoutAlgorithm.valueOf(this.f1989b.getLayoutAlgorithm().name());
        }
    }

    @Deprecated
    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.getLightTouchEnabled();
            }
            return false;
        }
        return iX5WebSettings.getLightTouchEnabled();
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.getLoadWithOverviewMode();
            }
            return false;
        }
        return iX5WebSettings.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getLoadsImagesAutomatically();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getLoadsImagesAutomatically();
        }
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        android.webkit.WebSettings webSettings;
        Object m2051a;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null && (m2051a = C1460i.m2051a(webSettings, "getMediaPlaybackRequiresUserGesture")) != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
    }

    public synchronized int getMinimumFontSize() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getMinimumFontSize();
        } else if (this.f1990c || this.f1989b == null) {
            return 0;
        } else {
            return this.f1989b.getMinimumFontSize();
        }
    }

    public synchronized int getMinimumLogicalFontSize() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getMinimumLogicalFontSize();
        } else if (this.f1990c || this.f1989b == null) {
            return 0;
        } else {
            return this.f1989b.getMinimumLogicalFontSize();
        }
    }

    public synchronized int getMixedContentMode() {
        int i = -1;
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getMixedContentMode();
        }
        Object m2049a = C1460i.m2049a(this.f1989b, "getMixedContentMode", new Class[0], new Object[0]);
        if (m2049a != null) {
            i = ((Integer) m2049a).intValue();
        }
        return i;
    }

    @Deprecated
    public boolean getNavDump() {
        android.webkit.WebSettings webSettings;
        Object m2051a;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null && (m2051a = C1460i.m2051a(webSettings, "getNavDump")) != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return iX5WebSettings.getNavDump();
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        if (this.f1990c && this.f1988a != null) {
            return PluginState.valueOf(this.f1988a.getPluginState().name());
        } else if (this.f1990c || this.f1989b == null) {
            return null;
        } else {
            Object m2051a = C1460i.m2051a(this.f1989b, "getPluginState");
            if (m2051a == null) {
                return null;
            }
            return PluginState.valueOf(((WebSettings.PluginState) m2051a).name());
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        if (!this.f1990c || this.f1988a == null) {
            return (this.f1990c || this.f1989b == null) ? false : false;
        }
        return this.f1988a.getPluginsEnabled();
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        if (!this.f1990c || this.f1988a == null) {
            return (this.f1990c || this.f1989b == null) ? "" : "";
        }
        return this.f1988a.getPluginsPath();
    }

    public boolean getSafeBrowsingEnabled() {
        IX5WebSettings iX5WebSettings;
        android.webkit.WebSettings webSettings;
        if (!this.f1990c && (webSettings = this.f1989b) != null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return webSettings.getSafeBrowsingEnabled();
        } else if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            return false;
        } else {
            try {
                return iX5WebSettings.getSafeBrowsingEnabled();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    public synchronized String getSansSerifFontFamily() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getSansSerifFontFamily();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getSansSerifFontFamily();
        }
    }

    @Deprecated
    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.getSaveFormData();
            }
            return false;
        }
        return iX5WebSettings.getSaveFormData();
    }

    @Deprecated
    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.getSavePassword();
            }
            return false;
        }
        return iX5WebSettings.getSavePassword();
    }

    public synchronized String getSerifFontFamily() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getSerifFontFamily();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getSerifFontFamily();
        }
    }

    public synchronized String getStandardFontFamily() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getStandardFontFamily();
        } else if (this.f1990c || this.f1989b == null) {
            return "";
        } else {
            return this.f1989b.getStandardFontFamily();
        }
    }

    @Deprecated
    public TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        String name;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            name = iX5WebSettings.getTextSize().name();
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
            return null;
        } else {
            name = webSettings.getTextSize().name();
        }
        return TextSize.valueOf(name);
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getTextZoom();
        } else if (this.f1990c || this.f1989b == null) {
            return 0;
        } else {
            try {
                return this.f1989b.getTextZoom();
            } catch (Exception unused) {
                Object m2051a = C1460i.m2051a(this.f1989b, "getTextZoom");
                if (m2051a != null) {
                    return ((Integer) m2051a).intValue();
                }
                return 0;
            }
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        android.webkit.WebSettings webSettings;
        Object m2051a;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null && (m2051a = C1460i.m2051a(webSettings, "getUseWebViewBackgroundForOverscrollBackground")) != null) {
                return ((Boolean) m2051a).booleanValue();
            }
            return false;
        }
        return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
    }

    public synchronized boolean getUseWideViewPort() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.getUseWideViewPort();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.getUseWideViewPort();
        }
    }

    @TargetApi(3)
    public String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        return (!this.f1990c || (iX5WebSettings = this.f1988a) == null) ? (this.f1990c || (webSettings = this.f1989b) == null) ? "" : webSettings.getUserAgentString() : iX5WebSettings.getUserAgentString();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setAllowContentAccess(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setAllowFileAccess(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setAllowFileAccess(z);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setAppCacheEnabled(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setAppCacheEnabled(z);
        }
    }

    @TargetApi(7)
    @Deprecated
    public void setAppCacheMaxSize(long j) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setAppCacheMaxSize(j);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setBlockNetworkImage(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setBlockNetworkImage(z);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setBlockNetworkLoads(z);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setBlockNetworkLoads(z);
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setBuiltInZoomControls(z);
        }
    }

    public void setCacheMode(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setCacheMode(i);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setCacheMode(i);
        }
    }

    public synchronized void setCursiveFontFamily(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setCursiveFontFamily(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setCursiveFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setDatabaseEnabled(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setDatabaseEnabled(z);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setDatabasePath", new Class[]{String.class}, str);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setDefaultFixedFontSize(i);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setDefaultFixedFontSize(i);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setDefaultFontSize(i);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setDefaultFontSize(i);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setDefaultTextEncodingName(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setDefaultTextEncodingName(str);
        }
    }

    @TargetApi(7)
    @Deprecated
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setDisplayZoomControls(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setDomStorageEnabled(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setDomStorageEnabled(z);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setFantasyFontFamily(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setFantasyFontFamily(str);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setFixedFontFamily(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setFixedFontFamily(str);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setGeolocationDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setGeolocationEnabled(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setGeolocationEnabled(z);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        try {
            if (this.f1990c && this.f1988a != null) {
                this.f1988a.setJavaScriptEnabled(z);
            } else if (this.f1990c || this.f1989b == null) {
            } else {
                this.f1989b.setJavaScriptEnabled(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    @Deprecated
    public void setLightTouchEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setLightTouchEnabled(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setLightTouchEnabled(z);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setLoadWithOverviewMode(z);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setLoadsImagesAutomatically(z);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setMinimumFontSize(i);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setMinimumFontSize(i);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setMinimumLogicalFontSize(i);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setMinimumLogicalFontSize(i);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        android.webkit.WebSettings webSettings;
        if ((!this.f1990c || this.f1988a == null) && !this.f1990c && (webSettings = this.f1989b) != null) {
            C1460i.m2049a(webSettings, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    @Deprecated
    public void setNavDump(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setNavDump(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setNeedInitialFocus(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setNeedInitialFocus(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setNeedInitialFocus(z);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            C1460i.m2049a(this.f1989b, "setPluginState", new Class[]{WebSettings.PluginState.class}, WebSettings.PluginState.valueOf(pluginState.name()));
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setPluginsEnabled(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setPluginsPath(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            C1460i.m2049a(this.f1989b, "setPluginsPath", new Class[]{String.class}, str);
        }
    }

    @Deprecated
    public void setRenderPriority(RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public void setSafeBrowsingEnabled(boolean z) {
        IX5WebSettings iX5WebSettings;
        android.webkit.WebSettings webSettings;
        if (!this.f1990c && (webSettings = this.f1989b) != null) {
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            webSettings.setSafeBrowsingEnabled(z);
        } else if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
        } else {
            try {
                iX5WebSettings.setSafeBrowsingEnabled(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setSansSerifFontFamily(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setSansSerifFontFamily(str);
        }
    }

    @Deprecated
    public void setSaveFormData(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setSaveFormData(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setSaveFormData(z);
        }
    }

    @Deprecated
    public void setSavePassword(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setSavePassword(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setSavePassword(z);
        }
    }

    public synchronized void setSerifFontFamily(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setSerifFontFamily(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setSerifFontFamily(str);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setStandardFontFamily(str);
        } else if (this.f1990c || this.f1989b == null) {
        } else {
            this.f1989b.setStandardFontFamily(str);
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setSupportMultipleWindows(z);
        }
    }

    public void setSupportZoom(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setSupportZoom(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setSupportZoom(z);
        }
    }

    @Deprecated
    public void setTextSize(TextSize textSize) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        if (this.f1990c && this.f1988a != null) {
            this.f1988a.setTextZoom(i);
        } else if (!this.f1990c && this.f1989b != null) {
            try {
                this.f1989b.setTextZoom(i);
            } catch (Exception unused) {
                C1460i.m2049a(this.f1989b, "setTextZoom", new Class[]{Integer.TYPE}, Integer.valueOf(i));
            }
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            C1460i.m2049a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setUseWideViewPort(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setUseWideViewPort(z);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setUseWideViewPort(z);
        }
    }

    public void setUserAgent(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setUserAgentString(str);
        }
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f1990c && (iX5WebSettings = this.f1988a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else if (this.f1990c || (webSettings = this.f1989b) == null) {
        } else {
            webSettings.setUserAgentString(str);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        if (this.f1990c && this.f1988a != null) {
            return this.f1988a.supportMultipleWindows();
        } else if (this.f1990c || this.f1989b == null) {
            return false;
        } else {
            return this.f1989b.supportMultipleWindows();
        }
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.f1990c || (iX5WebSettings = this.f1988a) == null) {
            if (!this.f1990c && (webSettings = this.f1989b) != null) {
                return webSettings.supportZoom();
            }
            return false;
        }
        return iX5WebSettings.supportZoom();
    }
}
