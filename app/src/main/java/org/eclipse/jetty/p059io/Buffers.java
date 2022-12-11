package org.eclipse.jetty.p059io;

/* renamed from: org.eclipse.jetty.io.Buffers */
/* loaded from: classes4.dex */
public interface Buffers {

    /* renamed from: org.eclipse.jetty.io.Buffers$Type */
    /* loaded from: classes4.dex */
    public enum Type {
        BYTE_ARRAY,
        DIRECT,
        INDIRECT
    }

    Buffer getBuffer();

    Buffer getBuffer(int i);

    Buffer getHeader();

    void returnBuffer(Buffer buffer);
}
