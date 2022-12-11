package me.tvspark;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* renamed from: me.tvspark.w5 */
/* loaded from: classes4.dex */
public class C2738w5 extends AbstractC2586s5 {
    public final int Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public ByteBuffer Wwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2623t5 Wwwwwwwwwwwwwwwwwwwwwwww = new C2623t5();
    public final int Wwwwwwwwwwwwwwwwww = 0;

    public C2738w5(int i) {
        this.Wwwwwwwwwwwwwwwwwww = i;
    }

    @EnsuresNonNull({"data"})
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = i + this.Wwwwwwwwwwwwwwwwww;
        ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (byteBuffer == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
            return;
        }
        ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return getFlag(1073741824);
    }

    public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwww;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.Wwwwwwwwwwwwwwwwwwww;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    @Override // me.tvspark.AbstractC2586s5
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.Wwwwwwwwwwwwwwwwwwww;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = false;
    }
}
