package me.tvspark;

/* loaded from: classes4.dex */
public final class QQOOOOOOOO implements OO0000<byte[]> {
    @Override // me.tvspark.OO0000
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 1;
    }

    @Override // me.tvspark.OO0000
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        return bArr.length;
    }

    @Override // me.tvspark.OO0000
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override // me.tvspark.OO0000
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
