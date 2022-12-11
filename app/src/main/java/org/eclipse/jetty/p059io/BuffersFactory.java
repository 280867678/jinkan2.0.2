package org.eclipse.jetty.p059io;

import org.eclipse.jetty.p059io.Buffers;

/* renamed from: org.eclipse.jetty.io.BuffersFactory */
/* loaded from: classes4.dex */
public class BuffersFactory {
    public static Buffers newBuffers(Buffers.Type type, int i, Buffers.Type type2, int i2, Buffers.Type type3, int i3) {
        return i3 >= 0 ? new PooledBuffers(type, i, type2, i2, type3, i3) : new ThreadLocalBuffers(type, i, type2, i2, type3);
    }
}
