package kotlin.random;

import java.util.Random;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.ti0;
import org.eclipse.jetty.http.HttpHeaderValues;

@ef0
/* loaded from: classes4.dex */
public final class KotlinRandom extends Random {
    public final ti0 impl;
    public boolean seedInitialized;

    public KotlinRandom(ti0 ti0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ti0Var, "impl");
        this.impl = ti0Var;
    }

    public final ti0 getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    public int next(int i) {
        return this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, HttpHeaderValues.BYTES);
        this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }
}
