package com.tencent.smtt.sdk;

/* loaded from: classes4.dex */
public class MimeTypeMap {

    /* renamed from: a */
    public static MimeTypeMap f1731a;

    public static String getFileExtensionFromUrl(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(str) : m2294a.m2289c().m2247h(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            if (f1731a == null) {
                f1731a = new MimeTypeMap();
            }
            mimeTypeMap = f1731a;
        }
        return mimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str) : m2294a.m2289c().m2238l(str);
    }

    public String getMimeTypeFromExtension(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : m2294a.m2289c().m2242j(str);
    }

    public boolean hasExtension(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.MimeTypeMap.getSingleton().hasExtension(str) : m2294a.m2289c().m2240k(str);
    }

    public boolean hasMimeType(String str) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? android.webkit.MimeTypeMap.getSingleton().hasMimeType(str) : m2294a.m2289c().m2244i(str);
    }
}
