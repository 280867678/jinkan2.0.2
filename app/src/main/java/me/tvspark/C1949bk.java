package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* renamed from: me.tvspark.bk */
/* loaded from: classes4.dex */
public final class C1949bk {
    @Nullable
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1949bk(Uri uri, long j, int i, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i2, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j + j2 >= 0);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableMap(new HashMap(map));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    public C1949bk(Uri uri, long j, long j2) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j, j2, null, 0, null);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 1) {
            if (i == 2) {
                return "POST";
            }
            if (i != 3) {
                throw new IllegalStateException();
            }
            return "HEAD";
        }
        return "GET";
    }

    public String toString() {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        String valueOf = String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, valueOf.length() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() + 70));
        sb.append("DataSpec[");
        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        sb.append(StringUtils.SPACE);
        sb.append(valueOf);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
