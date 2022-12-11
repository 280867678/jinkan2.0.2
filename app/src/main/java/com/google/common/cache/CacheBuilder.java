package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers$SupplierOfInstance;
import com.google.common.cache.LocalCache;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.AbstractC2161gu;
import me.tvspark.AbstractC2198hu;
import me.tvspark.AbstractC2684ut;
import me.tvspark.AbstractC2799xt;
import me.tvspark.AbstractC2873zt;
import me.tvspark.C1959bu;
import me.tvspark.C2456ot;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class CacheBuilder<K, V> {
    public AbstractC2799xt Wwwwwwwwwwwwwwwwwwww;
    public AbstractC2161gu<? super K, ? super V> Wwwwwwwwwwwwwwwwwwwww;
    public Equivalence<Object> Wwwwwwwwwwwwwwwwwwwwww;
    public Equivalence<Object> Wwwwwwwwwwwwwwwwwwwwwww;
    public LocalCache.Strength Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LocalCache.Strength Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2198hu<? super K, ? super V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final AbstractC2684ut<? extends AbstractC2873zt> Wwwwwwwwwwwwwwwwww = new Suppliers$SupplierOfInstance(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    public static final C1959bu Wwwwwwwwwwwwwwwww = new C1959bu(0, 0, 0, 0, 0, 0);
    public static final AbstractC2799xt Wwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final Logger Wwwwwwwwwwwwwww = Logger.getLogger(CacheBuilder.class.getName());
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwwwwwwwwww = -1;
    public AbstractC2684ut<? extends AbstractC2873zt> Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public enum NullListener implements AbstractC2161gu<Object, Object> {
        INSTANCE;

        @Override // me.tvspark.AbstractC2161gu
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* loaded from: classes3.dex */
    public enum OneWeigher implements AbstractC2198hu<Object, Object> {
        INSTANCE;

        @Override // me.tvspark.AbstractC2198hu
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2799xt {
        @Override // me.tvspark.AbstractC2799xt
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 0L;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2873zt {
        @Override // me.tvspark.AbstractC2873zt
        public C1959bu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CacheBuilder.Wwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2873zt
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        }

        @Override // me.tvspark.AbstractC2873zt
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        }

        @Override // me.tvspark.AbstractC2873zt
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2873zt
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        }

        @Override // me.tvspark.AbstractC2873zt
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                z = false;
            }
            str = "maximumWeight requires weigher";
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                return;
            }
            Wwwwwwwwwwwwwww.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
            return;
        } else {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                z = false;
            }
            str = "weigher requires maximumWeight";
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, str);
    }

    public String toString() {
        C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("initialCapacity", i);
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("concurrencyLevel", i2);
        }
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("maximumSize", j);
        }
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j2 != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("maximumWeight", j2);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("expireAfterWrite", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.Wwwwwwwwwwwwwwwwwwwwwwwwww, "ns"));
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("expireAfterAccess", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.Wwwwwwwwwwwwwwwwwwwwwwwww, "ns"));
        }
        LocalCache.Strength strength = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (strength != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("keyStrength", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(strength.toString()));
        }
        LocalCache.Strength strength2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (strength2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("valueStrength", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(strength2.toString()));
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("keyEquivalence");
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("valueEquivalence");
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("removalListener");
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
