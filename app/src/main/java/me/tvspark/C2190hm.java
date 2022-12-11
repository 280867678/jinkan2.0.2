package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.nio.ByteBuffer;

/* renamed from: me.tvspark.hm */
/* loaded from: classes4.dex */
public final class C2190hm extends AbstractC2846z2 {
    public long Wwwwwwwww;
    @Nullable
    public AbstractC2153gm Wwwwwwwwww;
    public long Wwwwwwwwwww;
    public final C2738w5 Wwwwwwwwwwwww = new C2738w5(1);
    public final C2078el Wwwwwwwwwwww = new C2078el();

    public C2190hm() {
        super(5);
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwww() {
        AbstractC2153gm abstractC2153gm = this.Wwwwwwwwww;
        if (abstractC2153gm != null) {
            abstractC2153gm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.AbstractC1970c4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("application/x-camera-motion".equals(c2245j3.Wwwwwwwwwwwww) ? 4 : 0);
    }

    @Override // me.tvspark.AbstractC2846z2, me.tvspark.C2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 7) {
            this.Wwwwwwwwww = (AbstractC2153gm) obj;
        }
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        this.Wwwwwwwww = Long.MIN_VALUE;
        AbstractC2153gm abstractC2153gm = this.Wwwwwwwwww;
        if (abstractC2153gm != null) {
            abstractC2153gm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3[] c2245j3Arr, long j, long j2) {
        this.Wwwwwwwwwww = j2;
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC1896a4, me.tvspark.AbstractC1970c4
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // me.tvspark.AbstractC1896a4
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        float[] fArr;
        while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwww < 100000 + j) {
            this.Wwwwwwwwwwwww.clear();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwww, false) != -4 || this.Wwwwwwwwwwwww.isEndOfStream()) {
                return;
            }
            C2738w5 c2738w5 = this.Wwwwwwwwwwwww;
            this.Wwwwwwwww = c2738w5.Wwwwwwwwwwwwwwwwwwwww;
            if (this.Wwwwwwwwww != null && !c2738w5.isDecodeOnly()) {
                this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ByteBuffer byteBuffer = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
                ByteBuffer byteBuffer2 = byteBuffer;
                if (byteBuffer2.remaining() != 16) {
                    fArr = null;
                } else {
                    this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2.array(), byteBuffer2.limit());
                    this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i = 0; i < 3; i++) {
                        fArr2[i] = Float.intBitsToFloat(this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwww - this.Wwwwwwwwwww, fArr);
                }
            }
        }
    }
}
