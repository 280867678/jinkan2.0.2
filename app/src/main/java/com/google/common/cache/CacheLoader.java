package com.google.common.cache;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2684ut;
import me.tvspark.AbstractFutureC2691uz;
import me.tvspark.C2731vz;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class CacheLoader<K, V> {

    /* loaded from: classes3.dex */
    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final AbstractC2271jt<K, V> computingFunction;

        public FunctionToCacheLoader(AbstractC2271jt<K, V> abstractC2271jt) {
            if (abstractC2271jt != null) {
                this.computingFunction = abstractC2271jt;
                return;
            }
            throw null;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            AbstractC2271jt<K, V> abstractC2271jt = this.computingFunction;
            if (k != null) {
                return abstractC2271jt.mo4462apply(k);
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final AbstractC2684ut<V> computingSupplier;

        public SupplierToCacheLoader(AbstractC2684ut<V> abstractC2684ut) {
            if (abstractC2684ut != null) {
                this.computingSupplier = abstractC2684ut;
                return;
            }
            throw null;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            if (obj != null) {
                return this.computingSupplier.mo4804get();
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends CacheLoader<K, V> {
        public final /* synthetic */ Executor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: com.google.common.cache.CacheLoader$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class CallableC3454Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callable<V> {
            public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwww;

            public CallableC3454Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
                this.Wwwwwwwwwwwwwwwwwwwwwww = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return CacheLoader.this.reload(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww).get();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Executor executor) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) throws Exception {
            return (V) CacheLoader.this.load(k);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public AbstractFutureC2691uz<V> reload(K k, V v) throws Exception {
            C2731vz c2731vz = new C2731vz(new CallableC3454Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, v));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(c2731vz);
            return c2731vz;
        }
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        if (cacheLoader != null) {
            if (executor == null) {
                throw null;
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executor);
        }
        throw null;
    }

    public static <K, V> CacheLoader<K, V> from(AbstractC2271jt<K, V> abstractC2271jt) {
        return new FunctionToCacheLoader(abstractC2271jt);
    }

    public static <V> CacheLoader<Object, V> from(AbstractC2684ut<V> abstractC2684ut) {
        return new SupplierToCacheLoader(abstractC2684ut);
    }

    public abstract V load(K k) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    public AbstractFutureC2691uz<V> reload(K k, V v) throws Exception {
        if (k != null) {
            if (v == null) {
                throw null;
            }
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(load(k));
        }
        throw null;
    }
}
