package me.tvspark;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: me.tvspark.te */
/* loaded from: classes4.dex */
public final class C2632te {
    public static final AtomicLong Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicLong();
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2632te(long j, C1949bk c1949bk, long j2) {
        Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Collections.emptyMap();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
    }

    public C2632te(long j, C1949bk c1949bk, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAndIncrement();
    }
}
