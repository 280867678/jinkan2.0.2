package me.tvspark;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.MediaDrmCallbackException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.tvspark.AbstractC2624t6;
import org.eclipse.jetty.http.MimeTypes;

/* renamed from: me.tvspark.w6 */
/* loaded from: classes4.dex */
public final class C2739w6 implements AbstractC2776x6 {
    public final Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2739w6(String str, boolean z, HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid, AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws MediaDrmCallbackException {
        String str = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || TextUtils.isEmpty(str)) {
            str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid) ? MimeTypes.TEXT_XML : C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid) ? "application/json" : "application/octet-stream");
        if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            hashMap.putAll(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
        r4 = r4 + 1;
        r8 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r0 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r6 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r10 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r11 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r13 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r15 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        r2 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        r3 = r3.Wwwwwwwwwwwwwwwwwwwwwwwww;
        r7 = android.net.Uri.parse(r7);
        r4 = r17;
        me.tvspark.Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r7, r4);
        r17 = new me.tvspark.C1949bk(r7, r8, r0, r6, r10, r11, r13, r15, r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b2, code lost:
        r5.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        Map<String, List<String>> map2;
        List<String> list;
        int i;
        Object obj;
        C1949bk c1949bk;
        C2373mk c2373mk = new C2373mk(((HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).mo4450Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Collections.emptyMap();
        Uri parse = Uri.parse(str);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parse, "The uri must be set.");
        Object obj2 = "The uri must be set.";
        C1949bk c1949bk2 = new C1949bk(parse, 0L, 2, bArr, map, 0L, -1L, null, 1, null);
        int i2 = 0;
        C1949bk c1949bk3 = c1949bk2;
        int i3 = 0;
        while (true) {
            try {
                C1912ak c1912ak = new C1912ak(c2373mk, c1949bk3);
                try {
                    byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((InputStream) c1912ak);
                    try {
                        c1912ak.close();
                    } catch (IOException unused) {
                    }
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } catch (HttpDataSource.InvalidResponseCodeException e) {
                    int i4 = e.responseCode;
                    String str2 = null;
                    if (((i4 == 307 || i4 == 308) && i3 < 5) && (map2 = e.headerFields) != null && (list = map2.get("Location")) != null && !list.isEmpty()) {
                        str2 = list.get(i2);
                    }
                    throw e;
                }
            } catch (Exception e2) {
                Uri uri = c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
                throw new MediaDrmCallbackException(c1949bk2, uri, c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), c2373mk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, e2);
            }
        }
        c1949bk3 = c1949bk;
        i2 = 0;
        obj2 = obj;
        i3 = i;
    }

    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid, AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws MediaDrmCallbackException {
        String str = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        StringBuilder sb = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 15));
        sb.append(str);
        sb.append("&signedRequest=");
        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, sb.toString(), null, Collections.emptyMap());
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                throw null;
            }
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, str2);
            }
            return;
        }
        throw null;
    }
}
