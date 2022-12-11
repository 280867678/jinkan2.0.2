package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.z2 */
/* loaded from: classes4.dex */
public abstract class AbstractC2846z2 implements AbstractC1896a4, AbstractC1970c4 {
    public boolean Wwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwww;
    @Nullable
    public C2245j3[] Wwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2183hf Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2007d4 Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;
    public final C2282k3 Wwwwwwwwwwwwwwwwwwwwwww = new C2282k3();
    public long Wwwwwwwwwwwwwwww = Long.MIN_VALUE;

    public AbstractC2846z2(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void Wwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwww() throws ExoPlaybackException {
    }

    public void Wwwwwwwwwwwwwwwwww() {
    }

    public abstract void Wwwwwwwwwwwwwwwwwww();

    public final C2245j3[] Wwwwwwwwwwwwwwwwwwww() {
        C2245j3[] c2245j3Arr = this.Wwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3Arr);
        return c2245j3Arr;
    }

    public final C2282k3 Wwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1896a4
    @Nullable
    public AbstractC1913al Wwwwwwwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final long Wwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void Wwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        AbstractC2183hf abstractC2183hf = this.Wwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2183hf);
        abstractC2183hf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC1896a4
    @Nullable
    public final AbstractC2183hf Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww() throws ExoPlaybackException {
        return 0;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final AbstractC1970c4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwww = true;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwww == Long.MIN_VALUE;
    }

    public final ExoPlaybackException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Exception exc, @Nullable C2245j3 c2245j3) {
        int i;
        if (c2245j3 != null && !this.Wwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwww = true;
            try {
                i = C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.Wwwwwwwwwwwwww = false;
            }
            return ExoPlaybackException.createForRenderer(exc, getName(), this.Wwwwwwwwwwwwwwwwwwwww, c2245j3, i);
        }
        i = 4;
        return ExoPlaybackException.createForRenderer(exc, getName(), this.Wwwwwwwwwwwwwwwwwwwww, c2245j3, i);
    }

    @Override // me.tvspark.AbstractC1896a4
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) throws ExoPlaybackException {
        C2847z3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, f);
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.C2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws ExoPlaybackException {
        this.Wwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwww = j;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, false);
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) throws ExoPlaybackException;

    @Override // me.tvspark.AbstractC1896a4
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2007d4 c2007d4, C2245j3[] c2245j3Arr, AbstractC2183hf abstractC2183hf, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww == 0);
        this.Wwwwwwwwwwwwwwwwwwwwww = c2007d4;
        this.Wwwwwwwwwwwwwwwwwwww = 1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3Arr, abstractC2183hf, j2, j3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, z);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) throws ExoPlaybackException {
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3[] c2245j3Arr, long j, long j2) throws ExoPlaybackException;

    @Override // me.tvspark.AbstractC1896a4
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3[] c2245j3Arr, AbstractC2183hf abstractC2183hf, long j, long j2) throws ExoPlaybackException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwww = abstractC2183hf;
        this.Wwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwww = c2245j3Arr;
        this.Wwwwwwwwwwwwwwwww = j2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3Arr, j, j2);
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void disable() {
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwwwww != 1) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwww = false;
        Wwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC1896a4
    public final int getState() {
        return this.Wwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final int getTrackType() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void reset() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww == 0);
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void start() throws ExoPlaybackException {
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwwwww != 1) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        this.Wwwwwwwwwwwwwwwwwwww = 2;
        Wwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC1896a4
    public final void stop() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww == 2);
        this.Wwwwwwwwwwwwwwwwwwww = 1;
        Wwwwwwwwwwwwwwww();
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3, C2738w5 c2738w5, boolean z) {
        AbstractC2183hf abstractC2183hf = this.Wwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2183hf);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2183hf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2282k3, c2738w5, z);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -4) {
            if (c2738w5.isEndOfStream()) {
                this.Wwwwwwwwwwwwwwww = Long.MIN_VALUE;
                return this.Wwwwwwwwwwwwwww ? -4 : -3;
            }
            long j = c2738w5.Wwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwww;
            c2738w5.Wwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwww = Math.max(this.Wwwwwwwwwwwwwwww, j);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -5) {
            C2245j3 c2245j3 = c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
            C2245j3 c2245j32 = c2245j3;
            if (c2245j32.Wwwwwwwww != Long.MAX_VALUE) {
                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = c2245j32.Wwwwwwwww + this.Wwwwwwwwwwwwwwwww;
                c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
