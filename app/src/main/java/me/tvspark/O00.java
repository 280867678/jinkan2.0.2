package me.tvspark;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import me.tvspark.AbstractC2734w1;
import me.tvspark.C2619t1;

/* loaded from: classes4.dex */
public final class O00<Z> implements AbstractC1886O0<Z>, C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Pools.Pool<O00<?>> Wwwwwwwwwwwwwwwwwwww = C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public AbstractC1886O0<Z> Wwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2734w1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<O00<?>> {
        @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public O00<?> create() {
            return new O00<>();
        }
    }

    @NonNull
    public static <Z> O00<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1886O0<Z> abstractC1886O0) {
        O00<Z> o00 = (O00<Z>) Wwwwwwwwwwwwwwwwwwww.acquire();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o00, "Argument must not be null");
        o00.Wwwwwwwwwwwwwwwwwwwww = false;
        o00.Wwwwwwwwwwwwwwwwwwwwww = true;
        o00.Wwwwwwwwwwwwwwwwwwwwwww = abstractC1886O0;
        return o00;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            throw new IllegalStateException("Already unlocked");
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = false;
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            recycle();
        }
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Class<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @NonNull
    public AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Z get() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.get();
    }

    @Override // me.tvspark.AbstractC1886O0
    public int getSize() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.getSize();
    }

    @Override // me.tvspark.AbstractC1886O0
    public synchronized void recycle() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.recycle();
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwww.release(this);
        }
    }
}
