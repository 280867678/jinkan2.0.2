package me.tvspark;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: classes4.dex */
public interface ww0 extends mx0, ReadableByteChannel {
    long Wwwwwwwwwwwwwwwwwwwww() throws IOException;

    String Wwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws IOException;

    byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws IOException;

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws IOException;

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0 dx0Var) throws IOException;

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0 kx0Var) throws IOException;

    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Charset charset) throws IOException;

    ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws IOException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0 uw0Var, long j) throws IOException;

    uw0 getBuffer();

    InputStream inputStream();

    ww0 peek();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    boolean request(long j) throws IOException;

    void skip(long j) throws IOException;
}
