package me.tvspark;

import java.util.Iterator;
import java.util.Map;

/* renamed from: me.tvspark.fw */
/* loaded from: classes4.dex */
public final class C2126fw extends AbstractC2165gy<Map.Entry<K, V>, K> {
    public C2126fw(Iterator it) {
        super(it);
    }

    @Override // me.tvspark.AbstractC2165gy
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return ((Map.Entry) obj).getKey();
    }
}
