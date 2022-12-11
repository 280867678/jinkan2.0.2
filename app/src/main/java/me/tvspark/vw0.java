package me.tvspark;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* loaded from: classes4.dex */
public interface vw0 extends kx0, WritableByteChannel {
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwww */
    vw0 mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws IOException;

    vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    vw0 mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws IOException;

    vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0 mx0Var) throws IOException;

    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    vw0 mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IOException;

    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    vw0 mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) throws IOException;

    @Override // me.tvspark.kx0, java.io.Flushable
    void flush() throws IOException;

    uw0 getBuffer();

    /* renamed from: write */
    vw0 mo4961write(byte[] bArr) throws IOException;

    /* renamed from: write */
    vw0 mo4962write(byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: writeByte */
    vw0 mo4963writeByte(int i) throws IOException;

    /* renamed from: writeInt */
    vw0 mo4964writeInt(int i) throws IOException;

    /* renamed from: writeShort */
    vw0 mo4965writeShort(int i) throws IOException;
}
