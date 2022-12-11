package me.tvspark;

import java.io.IOException;

/* renamed from: me.tvspark.i7 */
/* loaded from: classes4.dex */
public interface AbstractC2212i7 extends AbstractC2752wj {
    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws IOException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) throws IOException;

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, boolean z) throws IOException;

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) throws IOException;

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws IOException;

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) throws IOException;

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, boolean z) throws IOException;

    long getLength();

    long getPosition();

    @Override // me.tvspark.AbstractC2752wj
    int read(byte[] bArr, int i, int i2) throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;

    int skip(int i) throws IOException;
}
