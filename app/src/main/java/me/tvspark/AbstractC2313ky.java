package me.tvspark;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: me.tvspark.ky */
/* loaded from: classes4.dex */
public abstract class AbstractC2313ky extends AbstractC2387my {
    public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public final AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.array(), 0, i);
            return this;
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.get());
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2);

    @Override // me.tvspark.AbstractC2387my
    public AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putChar(c);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        return this;
    }

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public AbstractC2504py mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putInt(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        return this;
    }

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public AbstractC2504py mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putLong(j);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
        return this;
    }

    @Override // me.tvspark.AbstractC2504py
    public AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
        return this;
    }

    @Override // me.tvspark.AbstractC2387my, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public AbstractC2504py mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        if (bArr != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, bArr.length);
            return this;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2387my, me.tvspark.AbstractC2504py
    public AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i + i2, bArr.length);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2);
        return this;
    }

    @Override // me.tvspark.AbstractC2387my, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2652ty mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
        return this;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b);

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public AbstractC2652ty mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putInt(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        return this;
    }

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public AbstractC2652ty mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putLong(j);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
        return this;
    }
}
