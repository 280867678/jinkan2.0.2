package com.google.common.hash;

import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.AbstractC2615sy;
import me.tvspark.AbstractC2684ut;

/* loaded from: classes3.dex */
public final class LongAddables {
    public static final AbstractC2684ut<AbstractC2615sy> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements AbstractC2615sy {
        public PureJavaLongAddable() {
        }

        public /* synthetic */ PureJavaLongAddable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        @Override // me.tvspark.AbstractC2615sy
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // me.tvspark.AbstractC2615sy
        public void increment() {
            getAndIncrement();
        }

        @Override // me.tvspark.AbstractC2615sy
        public long sum() {
            return get();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2684ut<AbstractC2615sy> {
        @Override // me.tvspark.AbstractC2684ut
        /* renamed from: get */
        public AbstractC2615sy mo4804get() {
            return new PureJavaLongAddable(null);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2684ut<AbstractC2615sy> {
        @Override // me.tvspark.AbstractC2684ut
        /* renamed from: get */
        public AbstractC2615sy mo4804get() {
            return new LongAdder();
        }
    }

    static {
        AbstractC2684ut<AbstractC2615sy> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            new LongAdder();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (Throwable unused) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
