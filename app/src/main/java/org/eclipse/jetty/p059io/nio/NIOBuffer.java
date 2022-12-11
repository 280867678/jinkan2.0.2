package org.eclipse.jetty.p059io.nio;

import java.nio.ByteBuffer;
import org.eclipse.jetty.p059io.Buffer;

/* renamed from: org.eclipse.jetty.io.nio.NIOBuffer */
/* loaded from: classes4.dex */
public interface NIOBuffer extends Buffer {
    ByteBuffer getByteBuffer();

    boolean isDirect();
}
