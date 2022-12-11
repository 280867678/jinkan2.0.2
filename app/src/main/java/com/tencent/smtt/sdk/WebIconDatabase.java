package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
/* loaded from: classes4.dex */
public class WebIconDatabase {

    /* renamed from: a */
    public static WebIconDatabase f1983a;

    @Deprecated
    /* renamed from: com.tencent.smtt.sdk.WebIconDatabase$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1333a {
        /* renamed from: a */
        void m2709a(String str, Bitmap bitmap);
    }

    /* renamed from: a */
    public static synchronized WebIconDatabase m2710a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            if (f1983a == null) {
                f1983a = new WebIconDatabase();
            }
            webIconDatabase = f1983a;
        }
        return webIconDatabase;
    }

    public static WebIconDatabase getInstance() {
        return m2710a();
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, AbstractC1333a abstractC1333a) {
    }

    public void close() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebIconDatabase.getInstance().close();
        } else {
            m2294a.m2289c().m2237m();
        }
    }

    public void open(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
        } else {
            m2294a.m2289c().m2268b(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        } else {
            m2294a.m2289c().m2259d(str);
        }
    }

    public void removeAllIcons() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } else {
            m2294a.m2289c().m2239l();
        }
    }

    public void requestIconForPageUrl(String str, final AbstractC1333a abstractC1333a) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new WebIconDatabase.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.2
                @Override // android.webkit.WebIconDatabase.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    abstractC1333a.m2709a(str2, bitmap);
                }
            });
        } else {
            m2294a.m2289c().m2277a(str, new IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.1
                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    abstractC1333a.m2709a(str2, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        } else {
            m2294a.m2289c().m2263c(str);
        }
    }
}
