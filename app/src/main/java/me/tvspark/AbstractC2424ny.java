package me.tvspark;

import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: me.tvspark.ny */
/* loaded from: classes4.dex */
public abstract class AbstractC2424ny extends AbstractC2387my {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2424ny(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i % i == 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteBuffer.allocate(i + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public final AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        int position = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position();
        for (int i = 0; i < position; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer.get());
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        while (byteBuffer.remaining() >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer);
        return this;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() < 8) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compact();
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer);

    public abstract HashCode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer);

    @Override // me.tvspark.AbstractC2504py
    public final HashCode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() > 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            byteBuffer.position(byteBuffer.limit());
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2387my
    public final AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putChar(c);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public final AbstractC2504py mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putInt(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public final AbstractC2504py mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putLong(j);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @Override // me.tvspark.AbstractC2504py
    public final AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
            return this;
        } finally {
            byteBuffer.order(order);
        }
    }

    @Override // me.tvspark.AbstractC2387my, me.tvspark.AbstractC2504py
    public final AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public AbstractC2652ty mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putInt(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public AbstractC2652ty mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putLong(j);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }
}
