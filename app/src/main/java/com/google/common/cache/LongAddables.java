package com.google.common.cache;

import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.AbstractC2087eu;
import me.tvspark.AbstractC2684ut;

/* loaded from: classes3.dex */
public final class LongAddables {
    public static final AbstractC2684ut<AbstractC2087eu> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements AbstractC2087eu {
        public PureJavaLongAddable() {
        }

        public /* synthetic */ PureJavaLongAddable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        @Override // me.tvspark.AbstractC2087eu
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // me.tvspark.AbstractC2087eu
        public void increment() {
            getAndIncrement();
        }

        @Override // me.tvspark.AbstractC2087eu
        public long sum() {
            return get();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2684ut<AbstractC2087eu> {
        @Override // me.tvspark.AbstractC2684ut
        /* renamed from: get */
        public AbstractC2087eu mo4804get() {
            return new PureJavaLongAddable(null);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2684ut<AbstractC2087eu> {
        @Override // me.tvspark.AbstractC2684ut
        /* renamed from: get */
        public AbstractC2087eu mo4804get() {
            return new LongAdder();
        }
    }

    static {
        AbstractC2684ut<AbstractC2087eu> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            new LongAdder();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (Throwable unused) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static AbstractC2087eu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4804get();
    }
}
