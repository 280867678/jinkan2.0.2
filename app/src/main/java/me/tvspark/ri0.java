package me.tvspark;

import java.util.Random;

/* loaded from: classes4.dex */
public abstract class ri0 extends ti0 {
    public abstract Random Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // me.tvspark.ti0
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextLong();
    }

    @Override // me.tvspark.ti0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextInt();
    }

    @Override // me.tvspark.ti0
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextFloat();
    }

    @Override // me.tvspark.ti0
    public double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextDouble();
    }

    @Override // me.tvspark.ti0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextInt(i);
    }

    @Override // me.tvspark.ti0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return ((-i) >> 31) & (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextInt() >>> (32 - i));
    }

    @Override // me.tvspark.ti0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextBoolean();
    }

    @Override // me.tvspark.ti0
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "array");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().nextBytes(bArr);
        return bArr;
    }
}
