package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.AbstractC1922au;
import me.tvspark.AbstractC1996cu;
import me.tvspark.AbstractC2050du;
import me.tvspark.AbstractC2124fu;
import me.tvspark.AbstractC2161gu;
import me.tvspark.AbstractC2198hu;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2457ou;
import me.tvspark.AbstractC2653tz;
import me.tvspark.AbstractC2799xt;
import me.tvspark.AbstractC2873zt;
import me.tvspark.AbstractFutureC2691uz;
import me.tvspark.AbstractRunnableC2388mz;
import me.tvspark.C1959bu;
import me.tvspark.C2647tt;
import me.tvspark.C2836yt;
import me.tvspark.C2879zz;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public Set<Map.Entry<K, V>> Www;
    public Collection<V> Wwww;
    public Set<K> Wwwww;
    public final CacheLoader<? super K, V> Wwwwww;
    public final AbstractC2873zt Wwwwwww;
    public final EntryFactory Wwwwwwww;
    public final AbstractC2799xt Wwwwwwwww;
    public final AbstractC2161gu<K, V> Wwwwwwwwww;
    public final Queue<RemovalNotification<K, V>> Wwwwwwwwwww;
    public final long Wwwwwwwwwwww;
    public final long Wwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwww;
    public final AbstractC2198hu<K, V> Wwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwww;
    public final Strength Wwwwwwwwwwwwwwwww;
    public final Strength Wwwwwwwwwwwwwwwwww;
    public final Equivalence<Object> Wwwwwwwwwwwwwwwwwww;
    public final Equivalence<Object> Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final Segment<K, V>[] Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final Logger Kkkkkkkkkkkkkkkkkkkkkkkkkk = Logger.getLogger(LocalCache.class.getName());
    public static final Wwwwwwwwwwwwwwww<Object, Object> Kkkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final Queue<?> Kkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwwwwwwwwwwwww(k, i, abstractC2124fu);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> copyEntry(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
                AbstractC2124fu<K, V> copyEntry = super.copyEntry(segment, abstractC2124fu, abstractC2124fu2);
                copyAccessEntry(abstractC2124fu, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwwwwwwwwwwwwwww(k, i, abstractC2124fu);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> copyEntry(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
                AbstractC2124fu<K, V> copyEntry = super.copyEntry(segment, abstractC2124fu, abstractC2124fu2);
                copyWriteEntry(abstractC2124fu, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwwwwwwwwwww(k, i, abstractC2124fu);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> copyEntry(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
                AbstractC2124fu<K, V> copyEntry = super.copyEntry(segment, abstractC2124fu, abstractC2124fu2);
                copyAccessEntry(abstractC2124fu, copyEntry);
                copyWriteEntry(abstractC2124fu, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwwwwwwwwwwwwww(k, i, abstractC2124fu);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwwwww(segment.keyReferenceQueue, k, i, abstractC2124fu);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> copyEntry(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
                AbstractC2124fu<K, V> copyEntry = super.copyEntry(segment, abstractC2124fu, abstractC2124fu2);
                copyAccessEntry(abstractC2124fu, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwwwwwww(segment.keyReferenceQueue, k, i, abstractC2124fu);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> copyEntry(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
                AbstractC2124fu<K, V> copyEntry = super.copyEntry(segment, abstractC2124fu, abstractC2124fu2);
                copyWriteEntry(abstractC2124fu, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwww(segment.keyReferenceQueue, k, i, abstractC2124fu);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> copyEntry(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
                AbstractC2124fu<K, V> copyEntry = super.copyEntry(segment, abstractC2124fu, abstractC2124fu2);
                copyAccessEntry(abstractC2124fu, copyEntry);
                copyWriteEntry(abstractC2124fu, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
                return new Wwwwwwwwwwwww(segment.keyReferenceQueue, k, i, abstractC2124fu);
            }
        };
        
        public static final int ACCESS_MASK = 1;
        public static final int WEAK_MASK = 4;
        public static final int WRITE_MASK = 2;
        public static final EntryFactory[] factories;

        static {
            EntryFactory entryFactory = WEAK_ACCESS_WRITE;
            factories = new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, entryFactory};
        }

        /* synthetic */ EntryFactory(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            int i = 0;
            int i2 = (strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0);
            if (z2) {
                i = 2;
            }
            return factories[i2 | i];
        }

        public <K, V> void copyAccessEntry(AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
            abstractC2124fu2.setAccessTime(abstractC2124fu.getAccessTime());
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu.getPreviousInAccessQueue(), abstractC2124fu2);
            AbstractC2124fu<K, V> nextInAccessQueue = abstractC2124fu.getNextInAccessQueue();
            abstractC2124fu2.setNextInAccessQueue(nextInAccessQueue);
            nextInAccessQueue.setPreviousInAccessQueue(abstractC2124fu2);
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2124fu) abstractC2124fu);
        }

        public <K, V> AbstractC2124fu<K, V> copyEntry(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
            return newEntry(segment, abstractC2124fu.getKey(), abstractC2124fu.getHash(), abstractC2124fu2);
        }

        public <K, V> void copyWriteEntry(AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
            abstractC2124fu2.setWriteTime(abstractC2124fu.getWriteTime());
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu.getPreviousInWriteQueue(), abstractC2124fu2);
            AbstractC2124fu<K, V> nextInWriteQueue = abstractC2124fu.getNextInWriteQueue();
            abstractC2124fu2.setNextInWriteQueue(nextInWriteQueue);
            nextInWriteQueue.setPreviousInWriteQueue(abstractC2124fu2);
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu);
        }

        public abstract <K, V> AbstractC2124fu<K, V> newEntry(Segment<K, V> segment, K k, int i, AbstractC2124fu<K, V> abstractC2124fu);
    }

    /* loaded from: classes3.dex */
    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements AbstractC2050du<K, V>, Serializable {
        public static final long serialVersionUID = 1;
        public transient AbstractC2050du<K, V> autoDelegate;

        public LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            CacheBuilder<K, V> recreateCacheBuilder = recreateCacheBuilder();
            CacheLoader<? super K, V> cacheLoader = this.loader;
            recreateCacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.autoDelegate = new LocalLoadingCache(recreateCacheBuilder, cacheLoader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // me.tvspark.AbstractC2050du, me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public final V mo4462apply(K k) {
            return this.autoDelegate.mo4462apply(k);
        }

        @Override // me.tvspark.AbstractC2050du
        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // me.tvspark.AbstractC2050du
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // me.tvspark.AbstractC2050du
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // me.tvspark.AbstractC2050du
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }
    }

    /* loaded from: classes3.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements AbstractC2050du<K, V> {
        public static final long serialVersionUID = 1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, cacheLoader), null);
            if (cacheLoader != null) {
                return;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2050du, me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public final V mo4462apply(K k) {
            return getUnchecked(k);
        }

        @Override // me.tvspark.AbstractC2050du
        public V get(K k) throws ExecutionException {
            LocalCache<K, V> localCache = this.localCache;
            return localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((LocalCache<K, V>) k, (CacheLoader<? super LocalCache<K, V>, V>) localCache.Wwwwww);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.AbstractC2050du
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            LocalCache<K, V> localCache = this.localCache;
            if (localCache != 0) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int i = 0;
                int i2 = 0;
                for (K k : iterable) {
                    Object obj = localCache.get(k);
                    if (!linkedHashMap.containsKey(k)) {
                        linkedHashMap.put(k, obj);
                        if (obj == null) {
                            i2++;
                            linkedHashSet.add(k);
                        } else {
                            i++;
                        }
                    }
                }
                try {
                    if (!linkedHashSet.isEmpty()) {
                        try {
                            Map Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set) linkedHashSet, (CacheLoader) localCache.Wwwwww);
                            Iterator it = linkedHashSet.iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                Object obj2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(next);
                                if (obj2 == null) {
                                    throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + next);
                                }
                                linkedHashMap.put(next, obj2);
                            }
                        } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                            Iterator it2 = linkedHashSet.iterator();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                i2--;
                                linkedHashMap.put(next2, localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((LocalCache<K, V>) next2, (CacheLoader<? super LocalCache<K, V>, Object>) localCache.Wwwwww));
                            }
                        }
                    }
                    return ImmutableMap.copyOf((Map) linkedHashMap);
                } finally {
                    localCache.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    localCache.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                }
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2050du
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // me.tvspark.AbstractC2050du
        public void refresh(K k) {
            LocalCache<K, V> localCache = this.localCache;
            if (k != null) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
                localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).refresh(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, localCache.Wwwwww, false);
                return;
            }
            throw null;
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* loaded from: classes3.dex */
    public static class LocalManualCache<K, V> implements AbstractC1922au<K, V>, Serializable {
        public static final long serialVersionUID = 1;
        public final LocalCache<K, V> localCache;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends CacheLoader<Object, V> {
            public final /* synthetic */ Callable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalManualCache localManualCache, Callable callable) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.call();
            }
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        public LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }

        public /* synthetic */ LocalManualCache(LocalCache localCache, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this(localCache);
        }

        @Override // me.tvspark.AbstractC1922au
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // me.tvspark.AbstractC1922au
        public void cleanUp() {
            for (Segment<K, V> segment : this.localCache.Wwwwwwwwwwwwwwwwwwwwww) {
                segment.cleanUp();
            }
        }

        @Override // me.tvspark.AbstractC1922au
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            if (callable != null) {
                LocalCache<K, V> localCache = this.localCache;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, callable);
                if (k != null) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
                    return localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).get(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                throw null;
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.AbstractC1922au
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            LocalCache<K, V> localCache = this.localCache;
            if (localCache != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i = 0;
                int i2 = 0;
                for (Object obj : iterable) {
                    V v = localCache.get(obj);
                    if (v == null) {
                        i2++;
                    } else {
                        linkedHashMap.put(obj, v);
                        i++;
                    }
                }
                localCache.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                localCache.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                return ImmutableMap.copyOf((Map) linkedHashMap);
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC1922au
        public V getIfPresent(Object obj) {
            LocalCache<K, V> localCache = this.localCache;
            if (obj != null) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                V v = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).get(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                AbstractC2873zt abstractC2873zt = localCache.Wwwwwww;
                if (v == null) {
                    abstractC2873zt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                } else {
                    abstractC2873zt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                }
                return v;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC1922au
        public void invalidate(Object obj) {
            if (obj != null) {
                this.localCache.remove(obj);
                return;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC1922au
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // me.tvspark.AbstractC1922au
        public void invalidateAll(Iterable<?> iterable) {
            LocalCache<K, V> localCache = this.localCache;
            if (localCache != null) {
                Iterator<?> it = iterable.iterator();
                while (it.hasNext()) {
                    localCache.remove(it.next());
                }
                return;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC1922au
        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        @Override // me.tvspark.AbstractC1922au
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // me.tvspark.AbstractC1922au
        public long size() {
            return this.localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.AbstractC1922au
        public C1959bu stats() {
            C2836yt c2836yt = new C2836yt();
            c2836yt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.localCache.Wwwwwww);
            for (Segment<K, V> segment : this.localCache.Wwwwwwwwwwwwwwwwwwwwww) {
                c2836yt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(segment.statsCounter);
            }
            return c2836yt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    /* loaded from: classes3.dex */
    public static class ManualSerializationProxy<K, V> extends AbstractC1996cu<K, V> implements Serializable {
        public static final long serialVersionUID = 1;
        public final int concurrencyLevel;
        public transient AbstractC1922au<K, V> delegate;
        public final long expireAfterAccessNanos;
        public final long expireAfterWriteNanos;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final CacheLoader<? super K, V> loader;
        public final long maxWeight;
        public final AbstractC2161gu<? super K, ? super V> removalListener;
        public final AbstractC2799xt ticker;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;
        public final AbstractC2198hu<K, V> weigher;

        public ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, AbstractC2198hu<K, V> abstractC2198hu, int i, AbstractC2161gu<? super K, ? super V> abstractC2161gu, AbstractC2799xt abstractC2799xt, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = abstractC2198hu;
            this.concurrencyLevel = i;
            this.removalListener = abstractC2161gu;
            this.ticker = (abstractC2799xt == AbstractC2799xt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || abstractC2799xt == CacheBuilder.Wwwwwwwwwwwwwwww) ? null : abstractC2799xt;
            this.loader = cacheLoader;
        }

        public ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.Wwwwwwwwwwwwwwwwww, localCache.Wwwwwwwwwwwwwwwww, localCache.Wwwwwwwwwwwwwwwwwwww, localCache.Wwwwwwwwwwwwwwwwwww, localCache.Wwwwwwwwwwwww, localCache.Wwwwwwwwwwwwww, localCache.Wwwwwwwwwwwwwwww, localCache.Wwwwwwwwwwwwwww, localCache.Wwwwwwwwwwwwwwwwwwwww, localCache.Wwwwwwwwww, localCache.Wwwwwwwww, localCache.Wwwwww);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            CacheBuilder<K, V> recreateCacheBuilder = recreateCacheBuilder();
            recreateCacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recreateCacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwww == -1, "refreshAfterWrite requires a LoadingCache");
            this.delegate = new LocalManualCache(recreateCacheBuilder);
        }

        private Object readResolve() {
            return this.delegate;
        }

        @Override // me.tvspark.AbstractC1996cu, me.tvspark.AbstractC2310kv
        /* renamed from: delegate  reason: collision with other method in class */
        public AbstractC1922au<K, V> mo4974delegate() {
            return this.delegate;
        }

        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = new CacheBuilder<>();
            Strength strength = this.keyStrength;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null, "Key strength was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (strength != null) {
                cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = strength;
                Strength strength2 = this.valueStrength;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null, "Value strength was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (strength2 != null) {
                    cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwww = strength2;
                    Equivalence<Object> equivalence = this.keyEquivalence;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwww == null, "key equivalence was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwww);
                    if (equivalence != null) {
                        cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwww = equivalence;
                        Equivalence<Object> equivalence2 = this.valueEquivalence;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwww == null, "value equivalence was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwww);
                        if (equivalence2 != null) {
                            cacheBuilder.Wwwwwwwwwwwwwwwwwwwwww = equivalence2;
                            int i = this.concurrencyLevel;
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "concurrency level was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0);
                            cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                            AbstractC2161gu<? super K, ? super V> abstractC2161gu = this.removalListener;
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwww == null);
                            if (abstractC2161gu != null) {
                                cacheBuilder.Wwwwwwwwwwwwwwwwwwwww = abstractC2161gu;
                                cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                                long j = this.expireAfterWriteNanos;
                                if (j > 0) {
                                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwww == -1, "expireAfterWrite was already set to %s ns", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
                                    cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwww = timeUnit.toNanos(j);
                                }
                                long j2 = this.expireAfterAccessNanos;
                                if (j2 > 0) {
                                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwww == -1, "expireAfterAccess was already set to %s ns", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwww);
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2 >= 0, "duration cannot be negative: %s %s", j2, timeUnit2);
                                    cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwww = timeUnit2.toNanos(j2);
                                }
                                AbstractC2198hu abstractC2198hu = (AbstractC2198hu<K, V>) this.weigher;
                                if (abstractC2198hu != CacheBuilder.OneWeigher.INSTANCE) {
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null);
                                    if (cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "weigher can not be combined with maximum size", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                    }
                                    if (abstractC2198hu != null) {
                                        cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2198hu;
                                        long j3 = this.maxWeight;
                                        if (j3 != -1) {
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "maximum weight was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "maximum size was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3 >= 0, "maximum weight must not be negative");
                                        }
                                    } else {
                                        throw null;
                                    }
                                } else {
                                    long j4 = this.maxWeight;
                                    if (j4 != -1) {
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "maximum size was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1, "maximum weight was already set to %s", cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null, "maximum size can not be combined with weigher");
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4 >= 0, "maximum size must not be negative");
                                        cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j4;
                                    }
                                }
                                AbstractC2799xt abstractC2799xt = this.ticker;
                                if (abstractC2799xt != null) {
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwww == null);
                                    if (abstractC2799xt == null) {
                                        throw null;
                                    }
                                    cacheBuilder.Wwwwwwwwwwwwwwwwwwww = abstractC2799xt;
                                }
                                return cacheBuilder;
                            }
                            throw null;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public enum NullEntry implements AbstractC2124fu<Object, Object> {
        INSTANCE;

        @Override // me.tvspark.AbstractC2124fu
        public long getAccessTime() {
            return 0L;
        }

        @Override // me.tvspark.AbstractC2124fu
        public int getHash() {
            return 0;
        }

        @Override // me.tvspark.AbstractC2124fu
        public Object getKey() {
            return null;
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<Object, Object> getNext() {
            return null;
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // me.tvspark.AbstractC2124fu
        public Wwwwwwwwwwwwwwww<Object, Object> getValueReference() {
            return null;
        }

        @Override // me.tvspark.AbstractC2124fu
        public long getWriteTime() {
            return 0L;
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setAccessTime(long j) {
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setNextInAccessQueue(AbstractC2124fu<Object, Object> abstractC2124fu) {
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setNextInWriteQueue(AbstractC2124fu<Object, Object> abstractC2124fu) {
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setPreviousInAccessQueue(AbstractC2124fu<Object, Object> abstractC2124fu) {
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setPreviousInWriteQueue(AbstractC2124fu<Object, Object> abstractC2124fu) {
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setValueReference(Wwwwwwwwwwwwwwww<Object, Object> wwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setWriteTime(long j) {
        }
    }

    /* loaded from: classes3.dex */
    public static class Segment<K, V> extends ReentrantLock {
        public final Queue<AbstractC2124fu<K, V>> accessQueue;
        public volatile int count;
        public final ReferenceQueue<K> keyReferenceQueue;
        public final LocalCache<K, V> map;
        public final long maxSegmentWeight;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public final Queue<AbstractC2124fu<K, V>> recencyQueue;
        public final AbstractC2873zt statsCounter;
        public volatile AtomicReferenceArray<AbstractC2124fu<K, V>> table;
        public int threshold;
        public long totalWeight;
        public final ReferenceQueue<V> valueReferenceQueue;
        public final Queue<AbstractC2124fu<K, V>> writeQueue;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ AbstractFutureC2691uz Wwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, AbstractFutureC2691uz abstractFutureC2691uz) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
                this.Wwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwww = abstractFutureC2691uz;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Segment.this.getAndRecordStats(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww);
                } catch (Throwable th) {
                    LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkkkk.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                }
            }
        }

        public Segment(LocalCache<K, V> localCache, int i, long j, AbstractC2873zt abstractC2873zt) {
            Wwwwww wwwwww;
            this.map = localCache;
            this.maxSegmentWeight = j;
            ReferenceQueue<V> referenceQueue = null;
            if (abstractC2873zt != null) {
                this.statsCounter = abstractC2873zt;
                initTable(newEntryArray(i));
                this.keyReferenceQueue = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwww() ? new ReferenceQueue<>() : null;
                this.valueReferenceQueue = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwww() ? new ReferenceQueue<>() : referenceQueue;
                this.recencyQueue = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? new ConcurrentLinkedQueue() : (Queue<AbstractC2124fu<K, V>>) LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkk;
                if (localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    wwwwww = new Wwwwww();
                } else {
                    wwwwww = (Queue<AbstractC2124fu<K, V>>) LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkk;
                }
                this.writeQueue = wwwwww;
                this.accessQueue = localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : (Queue<AbstractC2124fu<K, V>>) LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkk;
                return;
            }
            throw null;
        }

        public void cleanUp() {
            runLockedCleanup(this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            runUnlockedCleanup();
        }

        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(i); abstractC2124fu != null; abstractC2124fu = abstractC2124fu.getNext()) {
                            if (abstractC2124fu.getValueReference().isActive()) {
                                K key = abstractC2124fu.getKey();
                                V v = abstractC2124fu.getValueReference().get();
                                if (key != null && v != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, abstractC2124fu.getHash(), v, abstractC2124fu.getValueReference().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, abstractC2124fu.getHash(), v, abstractC2124fu.getValueReference().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        public void clearReferenceQueues() {
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                clearKeyReferenceQueue();
            }
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count == 0) {
                    return false;
                }
                AbstractC2124fu<K, V> liveEntry = getLiveEntry(obj, i, this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                if (liveEntry == null) {
                    return false;
                }
                if (liveEntry.getValueReference().get() != null) {
                    z = true;
                }
                return z;
            } finally {
                postReadCleanup();
            }
        }

        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(i); abstractC2124fu != null; abstractC2124fu = abstractC2124fu.getNext()) {
                            V liveValue = getLiveValue(abstractC2124fu, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            if (liveValue != null && this.map.Wwwwwwwwwwwwwwwwwww.equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public AbstractC2124fu<K, V> copyEntry(AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
            if (abstractC2124fu.getKey() == null) {
                return null;
            }
            Wwwwwwwwwwwwwwww<K, V> valueReference = abstractC2124fu.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            AbstractC2124fu<K, V> copyEntry = this.map.Wwwwwwww.copyEntry(this, abstractC2124fu, abstractC2124fu2);
            copyEntry.setValueReference(valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                AbstractC2124fu<K, V> abstractC2124fu = (AbstractC2124fu) poll;
                LocalCache<K, V> localCache = this.map;
                if (localCache == null) {
                    throw null;
                }
                int hash = abstractC2124fu.getHash();
                localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hash).reclaimKey(abstractC2124fu, hash);
                i++;
            } while (i != 16);
        }

        public void drainRecencyQueue() {
            while (true) {
                AbstractC2124fu<K, V> poll = this.recencyQueue.poll();
                if (poll != null) {
                    if (this.accessQueue.contains(poll)) {
                        this.accessQueue.add(poll);
                    }
                } else {
                    return;
                }
            }
        }

        public void drainReferenceQueues() {
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                drainKeyReferenceQueue();
            }
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                drainValueReferenceQueue();
            }
        }

        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwww) poll;
                LocalCache<K, V> localCache = this.map;
                if (localCache == null) {
                    throw null;
                }
                AbstractC2124fu<K, V> entry = wwwwwwwwwwwwwwww.getEntry();
                int hash = entry.getHash();
                localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hash).reclaimValue(entry.getKey(), hash, wwwwwwwwwwwwwwww);
                i++;
            } while (i != 16);
        }

        public void enqueueNotification(K k, int i, V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (this.map.Wwwwwwwwwww != LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                this.map.Wwwwwwwwwww.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        public void evictEntries(AbstractC2124fu<K, V> abstractC2124fu) {
            if (!this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            drainRecencyQueue();
            if (abstractC2124fu.getValueReference().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > this.maxSegmentWeight && !removeEntry(abstractC2124fu, abstractC2124fu.getHash(), RemovalCause.SIZE)) {
                throw new AssertionError();
            }
            while (this.totalWeight > this.maxSegmentWeight) {
                AbstractC2124fu<K, V> nextEvictable = getNextEvictable();
                if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
            }
        }

        public void expand() {
            AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<AbstractC2124fu<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(i2);
                if (abstractC2124fu != null) {
                    AbstractC2124fu<K, V> next = abstractC2124fu.getNext();
                    int hash = abstractC2124fu.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, abstractC2124fu);
                    } else {
                        AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                abstractC2124fu2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, abstractC2124fu2);
                        while (abstractC2124fu != abstractC2124fu2) {
                            int hash3 = abstractC2124fu.getHash() & length2;
                            AbstractC2124fu<K, V> copyEntry = copyEntry(abstractC2124fu, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(abstractC2124fu);
                                i--;
                            }
                            abstractC2124fu = abstractC2124fu.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i;
        }

        public void expireEntries(long j) {
            AbstractC2124fu<K, V> peek;
            AbstractC2124fu<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    AbstractC2124fu<K, V> liveEntry = getLiveEntry(obj, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.map.Wwwwww);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        public V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            AbstractC2124fu<K, V> entry;
            if (k != null) {
                try {
                    if (cacheLoader == null) {
                        throw null;
                    }
                    try {
                        if (this.count != 0 && (entry = getEntry(k, i)) != null) {
                            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            V liveValue = getLiveValue(entry, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            if (liveValue != null) {
                                recordRead(entry, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                this.statsCounter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                return scheduleRefresh(entry, k, i, liveValue, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, cacheLoader);
                            }
                            Wwwwwwwwwwwwwwww<K, V> valueReference = entry.getValueReference();
                            if (valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                return waitForLoadingValue(entry, k, valueReference);
                            }
                        }
                        return lockedGetOrLoad(k, i, cacheLoader);
                    } catch (ExecutionException e) {
                        Throwable cause = e.getCause();
                        if (cause instanceof Error) {
                            throw new ExecutionError((Error) cause);
                        }
                        if (!(cause instanceof RuntimeException)) {
                            throw e;
                        }
                        throw new UncheckedExecutionException(cause);
                    }
                } finally {
                    postReadCleanup();
                }
            }
            throw null;
        }

        public V getAndRecordStats(K k, int i, Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww, AbstractFutureC2691uz<V> abstractFutureC2691uz) throws ExecutionException {
            V v;
            try {
                v = (V) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<Object>) abstractFutureC2691uz);
            } catch (Throwable th) {
                th = th;
                v = null;
            }
            try {
                if (v != null) {
                    this.statsCounter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    storeLoadedValue(k, i, wwwwwwwwwwwwwwwwwwwwwwww, v);
                    return v;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
            } catch (Throwable th2) {
                th = th2;
                if (v == null) {
                    this.statsCounter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    removeLoadingValue(k, i, wwwwwwwwwwwwwwwwwwwwwwww);
                }
                throw th;
            }
        }

        public AbstractC2124fu<K, V> getEntry(Object obj, int i) {
            for (AbstractC2124fu<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public AbstractC2124fu<K, V> getFirst(int i) {
            AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        public AbstractC2124fu<K, V> getLiveEntry(Object obj, int i, long j) {
            AbstractC2124fu<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        public V getLiveValue(AbstractC2124fu<K, V> abstractC2124fu, long j) {
            if (abstractC2124fu.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = abstractC2124fu.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (!this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu, j)) {
                return v;
            } else {
                tryExpireEntries(j);
                return null;
            }
        }

        public AbstractC2124fu<K, V> getNextEvictable() {
            for (AbstractC2124fu<K, V> abstractC2124fu : this.accessQueue) {
                if (abstractC2124fu.getValueReference().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
                    return abstractC2124fu;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!(this.map.Wwwwwwwwwwwwwww != CacheBuilder.OneWeigher.INSTANCE)) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwww<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                preWriteCleanup(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                for (AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu; abstractC2124fu2 != null; abstractC2124fu2 = abstractC2124fu2.getNext()) {
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() == i && key != null && this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                        Wwwwwwwwwwwwwwww<K, V> valueReference = abstractC2124fu2.getValueReference();
                        if (!valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && (!z || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - abstractC2124fu2.getWriteTime() >= this.map.Wwwwwwwwwwww)) {
                            this.modCount++;
                            Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwww<>(valueReference);
                            abstractC2124fu2.setValueReference(wwwwwwwwwwwwwwwwwwwwwwww);
                            return wwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        return null;
                    }
                }
                this.modCount++;
                Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwww<>();
                AbstractC2124fu<K, V> newEntry = newEntry(k, i, abstractC2124fu);
                newEntry.setValueReference(wwwwwwwwwwwwwwwwwwwwwwww2);
                atomicReferenceArray.set(length, newEntry);
                return wwwwwwwwwwwwwwwwwwwwwwww2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public AbstractFutureC2691uz<V> loadAsync(K k, int i, Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww, CacheLoader<? super K, V> cacheLoader) {
            AbstractFutureC2691uz<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, cacheLoader);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, i, wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), DirectExecutor.INSTANCE);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }

        public V loadSync(K k, int i, Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, cacheLoader));
        }

        public V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww2;
            boolean z;
            V loadSync;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            RemovalCause removalCause;
            lock();
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                preWriteCleanup(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                int i2 = this.count - 1;
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    wwwwwwwwwwwwwwwwwwwwwwww = null;
                    if (abstractC2124fu2 == null) {
                        wwwwwwwwwwwwwwww = null;
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() != i || key == null || !this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                        abstractC2124fu2 = abstractC2124fu2.getNext();
                    } else {
                        wwwwwwwwwwwwwwww = abstractC2124fu2.getValueReference();
                        if (wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            z = false;
                            wwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwww;
                        } else {
                            V v = wwwwwwwwwwwwwwww.get();
                            if (v == null) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                removalCause = RemovalCause.COLLECTED;
                            } else if (!this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                                recordLockedRead(abstractC2124fu2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                this.statsCounter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                return v;
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                removalCause = RemovalCause.EXPIRED;
                            }
                            enqueueNotification(key, i, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, removalCause);
                            this.writeQueue.remove(abstractC2124fu2);
                            this.accessQueue.remove(abstractC2124fu2);
                            this.count = i2;
                        }
                    }
                }
                wwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwww;
                z = true;
                if (z) {
                    wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwww<>();
                    if (abstractC2124fu2 == null) {
                        abstractC2124fu2 = newEntry(k, i, abstractC2124fu);
                        abstractC2124fu2.setValueReference(wwwwwwwwwwwwwwwwwwwwwwww);
                        atomicReferenceArray.set(length, abstractC2124fu2);
                    } else {
                        abstractC2124fu2.setValueReference(wwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
                if (!z) {
                    return waitForLoadingValue(abstractC2124fu2, k, wwwwwwwwwwwwwwww2);
                }
                try {
                    synchronized (abstractC2124fu2) {
                        loadSync = loadSync(k, i, wwwwwwwwwwwwwwwwwwwwwwww, cacheLoader);
                    }
                    return loadSync;
                } finally {
                    this.statsCounter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public AbstractC2124fu<K, V> newEntry(K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            EntryFactory entryFactory = this.map.Wwwwwwww;
            if (k != null) {
                return entryFactory.newEntry(this, k, i, abstractC2124fu);
            }
            throw null;
        }

        public AtomicReferenceArray<AbstractC2124fu<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        public void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        public V put(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                preWriteCleanup(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    if (abstractC2124fu2 == null) {
                        this.modCount++;
                        abstractC2124fu2 = newEntry(k, i, abstractC2124fu);
                        setValue(abstractC2124fu2, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        atomicReferenceArray.set(length, abstractC2124fu2);
                        this.count++;
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() != i || key == null || !this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                        abstractC2124fu2 = abstractC2124fu2.getNext();
                    } else {
                        Wwwwwwwwwwwwwwww<K, V> valueReference = abstractC2124fu2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            if (z) {
                                recordLockedRead(abstractC2124fu2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            } else {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), RemovalCause.REPLACED);
                                setValue(abstractC2124fu2, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                evictEntries(abstractC2124fu2);
                            }
                            return v2;
                        }
                        this.modCount++;
                        if (valueReference.isActive()) {
                            enqueueNotification(k, i, v2, valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), RemovalCause.COLLECTED);
                            setValue(abstractC2124fu2, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            i2 = this.count;
                        } else {
                            setValue(abstractC2124fu2, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            i2 = this.count + 1;
                        }
                        this.count = i2;
                    }
                }
                evictEntries(abstractC2124fu2);
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimKey(AbstractC2124fu<K, V> abstractC2124fu, int i) {
            lock();
            try {
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                AbstractC2124fu<K, V> abstractC2124fu2 = atomicReferenceArray.get(length);
                for (AbstractC2124fu<K, V> abstractC2124fu3 = abstractC2124fu2; abstractC2124fu3 != null; abstractC2124fu3 = abstractC2124fu3.getNext()) {
                    if (abstractC2124fu3 == abstractC2124fu) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(abstractC2124fu2, abstractC2124fu3, abstractC2124fu3.getKey(), i, abstractC2124fu3.getValueReference().get(), abstractC2124fu3.getValueReference(), RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimValue(K k, int i, Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww) {
            lock();
            try {
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                for (AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu; abstractC2124fu2 != null; abstractC2124fu2 = abstractC2124fu2.getNext()) {
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() == i && key != null && this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                        if (abstractC2124fu2.getValueReference() != wwwwwwwwwwwwwwww) {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(abstractC2124fu, abstractC2124fu2, key, i, wwwwwwwwwwwwwwww.get(), wwwwwwwwwwwwwwww, RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        public void recordLockedRead(AbstractC2124fu<K, V> abstractC2124fu, long j) {
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                abstractC2124fu.setAccessTime(j);
            }
            this.accessQueue.add(abstractC2124fu);
        }

        public void recordRead(AbstractC2124fu<K, V> abstractC2124fu, long j) {
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                abstractC2124fu.setAccessTime(j);
            }
            this.recencyQueue.add(abstractC2124fu);
        }

        public void recordWrite(AbstractC2124fu<K, V> abstractC2124fu, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += i;
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                abstractC2124fu.setAccessTime(j);
            }
            if (this.map.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                abstractC2124fu.setWriteTime(j);
            }
            this.accessQueue.add(abstractC2124fu);
            this.writeQueue.add(abstractC2124fu);
        }

        public V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            Wwwwwwwwwwwwwwwwwwwwwwww<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            AbstractFutureC2691uz<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<Object>) loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
            if (r12 == null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
            r11.modCount++;
            r0.set(r1, removeValueFromChain(r4, r5, r6, r13, r12, r9, r10));
            r11.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
            return r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
            if (r9.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup(this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    if (abstractC2124fu2 == null) {
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() == i && key != null && this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(obj, key)) {
                        break;
                    }
                    abstractC2124fu2 = abstractC2124fu2.getNext();
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
            if (r12.map.Wwwwwwwwwwwwwwwwwww.equivalent(r15, r9) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
            r12.modCount++;
            r0.set(r1, removeValueFromChain(r5, r6, r7, r14, r9, r10, r13));
            r12.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
            if (r9 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
            if (r10.isActive() == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(Object obj, int i, Object obj2) {
            lock();
            try {
                preWriteCleanup(this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    if (abstractC2124fu2 == null) {
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() == i && key != null && this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(obj, key)) {
                        break;
                    }
                    abstractC2124fu2 = abstractC2124fu2.getNext();
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void removeCollectedEntry(AbstractC2124fu<K, V> abstractC2124fu) {
            enqueueNotification(abstractC2124fu.getKey(), abstractC2124fu.getHash(), abstractC2124fu.getValueReference().get(), abstractC2124fu.getValueReference().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), RemovalCause.COLLECTED);
            this.writeQueue.remove(abstractC2124fu);
            this.accessQueue.remove(abstractC2124fu);
        }

        public boolean removeEntry(AbstractC2124fu<K, V> abstractC2124fu, int i, RemovalCause removalCause) {
            AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            AbstractC2124fu<K, V> abstractC2124fu2 = atomicReferenceArray.get(length);
            for (AbstractC2124fu<K, V> abstractC2124fu3 = abstractC2124fu2; abstractC2124fu3 != null; abstractC2124fu3 = abstractC2124fu3.getNext()) {
                if (abstractC2124fu3 == abstractC2124fu) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeValueFromChain(abstractC2124fu2, abstractC2124fu3, abstractC2124fu3.getKey(), i, abstractC2124fu3.getValueReference().get(), abstractC2124fu3.getValueReference(), removalCause));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        public AbstractC2124fu<K, V> removeEntryFromChain(AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
            int i = this.count;
            AbstractC2124fu<K, V> next = abstractC2124fu2.getNext();
            while (abstractC2124fu != abstractC2124fu2) {
                AbstractC2124fu<K, V> copyEntry = copyEntry(abstractC2124fu, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(abstractC2124fu);
                    i--;
                }
                abstractC2124fu = abstractC2124fu.getNext();
            }
            this.count = i;
            return next;
        }

        public boolean removeLoadingValue(K k, int i, Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww) {
            lock();
            try {
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    if (abstractC2124fu2 == null) {
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() != i || key == null || !this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                        abstractC2124fu2 = abstractC2124fu2.getNext();
                    } else if (abstractC2124fu2.getValueReference() == wwwwwwwwwwwwwwwwwwwwwwww) {
                        if (wwwwwwwwwwwwwwwwwwwwwwww.isActive()) {
                            abstractC2124fu2.setValueReference(wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(abstractC2124fu, abstractC2124fu2));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public AbstractC2124fu<K, V> removeValueFromChain(AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2, K k, int i, V v, Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww, RemovalCause removalCause) {
            enqueueNotification(k, i, v, wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), removalCause);
            this.writeQueue.remove(abstractC2124fu2);
            this.accessQueue.remove(abstractC2124fu2);
            if (wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
                return abstractC2124fu;
            }
            return removeEntryFromChain(abstractC2124fu, abstractC2124fu2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V replace(K k, int i, V v) {
            lock();
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                preWriteCleanup(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    if (abstractC2124fu2 == null) {
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() == i && key != null) {
                        if (this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                            Wwwwwwwwwwwwwwww<K, V> valueReference = abstractC2124fu2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 != null) {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), RemovalCause.REPLACED);
                                setValue(abstractC2124fu2, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                evictEntries(abstractC2124fu2);
                                return v2;
                            } else if (valueReference.isActive()) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeValueFromChain(abstractC2124fu, abstractC2124fu2, key, i, v2, valueReference, RemovalCause.COLLECTED));
                                this.count--;
                            }
                        }
                    }
                    abstractC2124fu2 = abstractC2124fu2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                preWriteCleanup(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    if (abstractC2124fu2 == null) {
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() == i && key != null) {
                        if (this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                            Wwwwwwwwwwwwwwww<K, V> valueReference = abstractC2124fu2.getValueReference();
                            V v3 = valueReference.get();
                            if (v3 == null) {
                                if (valueReference.isActive()) {
                                    this.modCount++;
                                    atomicReferenceArray.set(length, removeValueFromChain(abstractC2124fu, abstractC2124fu2, key, i, v3, valueReference, RemovalCause.COLLECTED));
                                    this.count--;
                                }
                            } else if (this.map.Wwwwwwwwwwwwwwwwwww.equivalent(v, v3)) {
                                this.modCount++;
                                enqueueNotification(k, i, v3, valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), RemovalCause.REPLACED);
                                setValue(abstractC2124fu2, k, v2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                evictEntries(abstractC2124fu2);
                                return true;
                            } else {
                                recordLockedRead(abstractC2124fu2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            }
                        }
                    }
                    abstractC2124fu2 = abstractC2124fu2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                LocalCache<K, V> localCache = this.map;
                while (true) {
                    RemovalNotification<K, V> poll = localCache.Wwwwwwwwwww.poll();
                    if (poll == null) {
                        return;
                    }
                    try {
                        localCache.Wwwwwwwwww.onRemoval(poll);
                    } catch (Throwable th) {
                        LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkkkk.log(Level.WARNING, "Exception thrown by removal listener", th);
                    }
                }
            }
        }

        public V scheduleRefresh(AbstractC2124fu<K, V> abstractC2124fu, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!((this.map.Wwwwwwwwwwww > 0L ? 1 : (this.map.Wwwwwwwwwwww == 0L ? 0 : -1)) > 0) || j - abstractC2124fu.getWriteTime() <= this.map.Wwwwwwwwwwww || abstractC2124fu.getValueReference().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || (refresh = refresh(k, i, cacheLoader, true)) == null) ? v : refresh;
        }

        public void setValue(AbstractC2124fu<K, V> abstractC2124fu, K k, V v, long j) {
            Wwwwwwwwwwwwwwww<K, V> valueReference = abstractC2124fu.getValueReference();
            int weigh = this.map.Wwwwwwwwwwwwwww.weigh(k, v);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(weigh >= 0, "Weights must be non-negative");
            abstractC2124fu.setValueReference(this.map.Wwwwwwwwwwwwwwwww.referenceValue(this, abstractC2124fu, v, weigh));
            recordWrite(abstractC2124fu, weigh, j);
            valueReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v);
        }

        public boolean storeLoadedValue(K k, int i, Wwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwww, V v) {
            lock();
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                preWriteCleanup(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(length);
                AbstractC2124fu<K, V> abstractC2124fu2 = abstractC2124fu;
                while (true) {
                    if (abstractC2124fu2 == null) {
                        this.modCount++;
                        abstractC2124fu2 = newEntry(k, i, abstractC2124fu);
                        setValue(abstractC2124fu2, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        atomicReferenceArray.set(length, abstractC2124fu2);
                        this.count = i3;
                        break;
                    }
                    K key = abstractC2124fu2.getKey();
                    if (abstractC2124fu2.getHash() != i || key == null || !this.map.Wwwwwwwwwwwwwwwwwwww.equivalent(k, key)) {
                        abstractC2124fu2 = abstractC2124fu2.getNext();
                    } else {
                        Wwwwwwwwwwwwwwww<K, V> valueReference = abstractC2124fu2.getValueReference();
                        V v2 = valueReference.get();
                        if (wwwwwwwwwwwwwwwwwwwwwwww != valueReference && (v2 != null || valueReference == LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkkk)) {
                            enqueueNotification(k, i, v, 0, RemovalCause.REPLACED);
                            return false;
                        }
                        this.modCount++;
                        if (wwwwwwwwwwwwwwwwwwwwwwww.isActive()) {
                            enqueueNotification(k, i, v2, wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i3--;
                        }
                        setValue(abstractC2124fu2, k, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        this.count = i3;
                    }
                }
                evictEntries(abstractC2124fu2);
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(AbstractC2124fu<K, V> abstractC2124fu, K k, Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww) throws ExecutionException {
            if (wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!Thread.holdsLock(abstractC2124fu), "Recursive load of: %s", k);
                try {
                    V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        recordRead(abstractC2124fu, this.map.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                } finally {
                    this.statsCounter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                }
            }
            throw new AssertionError();
        }
    }

    /* loaded from: classes3.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> Wwwwwwwwwwwwwwww<K, V> referenceValue(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, V v, int i) {
                return i == 1 ? new Wwwwwwwwwwwwwwwwwww(v) : new Wwwwwwww(v, i);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> Wwwwwwwwwwwwwwww<K, V> referenceValue(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, V v, int i) {
                return i == 1 ? new Wwwwwwwwwwwwwwwwwwwwwww(segment.valueReferenceQueue, v, abstractC2124fu) : new Wwwwwwwww(segment.valueReferenceQueue, v, abstractC2124fu, i);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> Wwwwwwwwwwwwwwww<K, V> referenceValue(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, V v, int i) {
                return i == 1 ? new Wwwwwwwwwww(segment.valueReferenceQueue, v, abstractC2124fu) : new Wwwwwww(segment.valueReferenceQueue, v, abstractC2124fu, i);
            }
        };

        /* synthetic */ Strength(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> Wwwwwwwwwwwwwwww<K, V> referenceValue(Segment<K, V> segment, AbstractC2124fu<K, V> abstractC2124fu, V v, int i);
    }

    /* loaded from: classes3.dex */
    public final class Wwwww implements Map.Entry<K, V> {
        public V Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwww(K k, V v) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.equals(entry.getKey()) && this.Wwwwwwwwwwwwwwwwwwwwwww.equals(entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.hashCode() ^ this.Wwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.Wwwwwwwwwwwwwwwwwwwwwwww, v);
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
            return v2;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww + "=" + this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwww<K, V> extends AbstractQueue<AbstractC2124fu<K, V>> {
        public final AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2457ou<AbstractC2124fu<K, V>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu abstractC2124fu) {
                super(abstractC2124fu);
            }

            @Override // me.tvspark.AbstractC2457ou
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
                AbstractC2124fu<K, V> nextInWriteQueue = ((AbstractC2124fu) obj).getNextInWriteQueue();
                if (nextInWriteQueue == Wwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
            public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwwww = this;
            public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwww = this;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwww wwwwww) {
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public AbstractC2124fu<K, V> getNextInWriteQueue() {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public AbstractC2124fu<K, V> getPreviousInWriteQueue() {
                return this.Wwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public void setWriteTime(long j) {
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC2124fu<K, V> nextInWriteQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInWriteQueue();
            while (true) {
                AbstractC2124fu<K, V> abstractC2124fu = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (nextInWriteQueue == abstractC2124fu) {
                    abstractC2124fu.setNextInWriteQueue(abstractC2124fu);
                    AbstractC2124fu<K, V> abstractC2124fu2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    abstractC2124fu2.setPreviousInWriteQueue(abstractC2124fu2);
                    return;
                }
                AbstractC2124fu<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextInWriteQueue);
                nextInWriteQueue = nextInWriteQueue2;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((AbstractC2124fu) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInWriteQueue() == this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<AbstractC2124fu<K, V>> iterator() {
            AbstractC2124fu<K, V> nextInWriteQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInWriteQueue();
            if (nextInWriteQueue == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                nextInWriteQueue = null;
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextInWriteQueue);
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            AbstractC2124fu<K, V> abstractC2124fu = (AbstractC2124fu) obj;
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu.getPreviousInWriteQueue(), abstractC2124fu.getNextInWriteQueue());
            AbstractC2124fu<K, V> previousInWriteQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getPreviousInWriteQueue();
            previousInWriteQueue.setNextInWriteQueue(abstractC2124fu);
            abstractC2124fu.setPreviousInWriteQueue(previousInWriteQueue);
            AbstractC2124fu<K, V> abstractC2124fu2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            abstractC2124fu.setNextInWriteQueue(abstractC2124fu2);
            abstractC2124fu2.setPreviousInWriteQueue(abstractC2124fu);
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            AbstractC2124fu<K, V> nextInWriteQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInWriteQueue();
            if (nextInWriteQueue == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        public Object poll() {
            AbstractC2124fu<K, V> nextInWriteQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInWriteQueue();
            if (nextInWriteQueue == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            AbstractC2124fu abstractC2124fu = (AbstractC2124fu) obj;
            AbstractC2124fu<K, V> previousInWriteQueue = abstractC2124fu.getPreviousInWriteQueue();
            AbstractC2124fu<K, V> nextInWriteQueue = abstractC2124fu.getNextInWriteQueue();
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(previousInWriteQueue, nextInWriteQueue);
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (AbstractC2124fu<K, V> nextInWriteQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInWriteQueue(); nextInWriteQueue != this.Wwwwwwwwwwwwwwwwwwwwwwww; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwww<K, V> extends Wwwwwwwwwww<K, V> {
        public final int Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu, int i) {
            super(referenceQueue, v, abstractC2124fu);
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwww, com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwww, com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            return new Wwwwwww(referenceQueue, v, abstractC2124fu, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwww<K, V> {
        public final int Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwww(V v, int i) {
            super(v);
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwww, com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public final int Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu, int i) {
            super(referenceQueue, v, abstractC2124fu);
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwww, com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwww, com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            return new Wwwwwwwww(referenceQueue, v, abstractC2124fu, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwww<K, V> extends Wwwwwwwwwwww<K, V> {
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwwww = Long.MAX_VALUE;

        public Wwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            super(referenceQueue, k, i, abstractC2124fu);
            NullEntry nullEntry = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwwww = nullEntry;
            this.Wwwwwwwwwwwwwwwwwww = nullEntry;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInWriteQueue() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInWriteQueue() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getWriteTime() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setWriteTime(long j) {
            this.Wwwwwwwwwwwwwwwwwwwww = j;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwww<K, V> extends WeakReference<V> implements Wwwwwwwwwwwwwwww<K, V> {
        public final AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            super(v, referenceQueue);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return get();
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 1;
        }

        public Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            return new Wwwwwwwwwww(referenceQueue, v, abstractC2124fu);
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public AbstractC2124fu<K, V> getEntry() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean isActive() {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwww<K, V> extends WeakReference<K> implements AbstractC2124fu<K, V> {
        public volatile Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwww<K, V>) LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        public final AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            super(k, referenceQueue);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // me.tvspark.AbstractC2124fu
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public int getHash() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2124fu
        public K getKey() {
            return get();
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public AbstractC2124fu<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public AbstractC2124fu<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public Wwwwwwwwwwwwwwww<K, V> getValueReference() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setValueReference(Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwww;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwww<K, V> extends Wwwwwwwwwwww<K, V> {
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwwww = Long.MAX_VALUE;
        public volatile long Wwwwwwwwwwwwwwwwww = Long.MAX_VALUE;

        public Wwwwwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            super(referenceQueue, k, i, abstractC2124fu);
            NullEntry nullEntry = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwwww = nullEntry;
            this.Wwwwwwwwwwwwwwwwwww = nullEntry;
            NullEntry nullEntry2 = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwwww = nullEntry2;
            this.Wwwwwwwwwwwwwwww = nullEntry2;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getAccessTime() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInWriteQueue() {
            return this.Wwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInWriteQueue() {
            return this.Wwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getWriteTime() {
            return this.Wwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setAccessTime(long j) {
            this.Wwwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setWriteTime(long j) {
            this.Wwwwwwwwwwwwwwwwww = j;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwww<K, V> {
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwwww = Long.MAX_VALUE;

        public Wwwwwwwwwwwwww(ReferenceQueue<K> referenceQueue, K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            super(referenceQueue, k, i, abstractC2124fu);
            NullEntry nullEntry = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwwww = nullEntry;
            this.Wwwwwwwwwwwwwwwwwww = nullEntry;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getAccessTime() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setAccessTime(long j) {
            this.Wwwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwww extends AbstractCollection<V> {
        public final ConcurrentMap<?, ?> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwww(ConcurrentMap<?, ?> concurrentMap) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new Wwwwwwwwwwwwwwwww(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this).toArray(eArr);
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwww<K, V> {
        V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ExecutionException;

        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v);

        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        V get();

        AbstractC2124fu<K, V> getEntry();

        boolean isActive();
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwww extends LocalCache<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwww<V> {
        public Wwwwwwwwwwwwwwwww(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwww<K, V> {
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwww = Long.MAX_VALUE;

        public Wwwwwwwwwwwwwwwwww(K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            super(k, i, abstractC2124fu);
            NullEntry nullEntry = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwww = nullEntry;
            this.Wwwwwwwwwwwwwwwwww = nullEntry;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInWriteQueue() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInWriteQueue() {
            return this.Wwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getWriteTime() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setWriteTime(long j) {
            this.Wwwwwwwwwwwwwwwwwwww = j;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwww<K, V> implements Wwwwwwwwwwwwwwww<K, V> {
        public final V Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwww(V v) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = v;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public V get() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public AbstractC2124fu<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean isActive() {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public volatile Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwww<K, V>) LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        public final AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwww(K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public int getHash() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public K getKey() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public Wwwwwwwwwwwwwwww<K, V> getValueReference() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setValueReference(Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwww<K, V> {
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwww = Long.MAX_VALUE;
        public volatile long Wwwwwwwwwwwwwwwww = Long.MAX_VALUE;

        public Wwwwwwwwwwwwwwwwwwwww(K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            super(k, i, abstractC2124fu);
            NullEntry nullEntry = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwww = nullEntry;
            this.Wwwwwwwwwwwwwwwwww = nullEntry;
            NullEntry nullEntry2 = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwww = nullEntry2;
            this.Wwwwwwwwwwwwwww = nullEntry2;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getAccessTime() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInWriteQueue() {
            return this.Wwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInWriteQueue() {
            return this.Wwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getWriteTime() {
            return this.Wwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setAccessTime(long j) {
            this.Wwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setWriteTime(long j) {
            this.Wwwwwwwwwwwwwwwww = j;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwww<K, V> extends Wwwwwwwwwwwwwwwwwwww<K, V> {
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwww = Long.MAX_VALUE;

        public Wwwwwwwwwwwwwwwwwwwwww(K k, int i, AbstractC2124fu<K, V> abstractC2124fu) {
            super(k, i, abstractC2124fu);
            NullEntry nullEntry = NullEntry.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwww = nullEntry;
            this.Wwwwwwwwwwwwwwwwww = nullEntry;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public long getAccessTime() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInAccessQueue() {
            return this.Wwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setAccessTime(long j) {
            this.Wwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
        public void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            this.Wwwwwwwwwwwwwwwwww = abstractC2124fu;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwww<K, V> extends SoftReference<V> implements Wwwwwwwwwwwwwwww<K, V> {
        public final AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            super(v, referenceQueue);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return get();
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 1;
        }

        public Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            return new Wwwwwwwwwwwwwwwwwwwwwww(referenceQueue, v, abstractC2124fu);
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public AbstractC2124fu<K, V> getEntry() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean isActive() {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwww extends LocalCache<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwww(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwww(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(obj) != null;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwww extends LocalCache<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public LocalCache<K, V>.Wwwww Wwwwwwwwwwwwwwwwww;
        public LocalCache<K, V>.Wwwww Wwwwwwwwwwwwwwwwwww;
        public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwww;
        public AtomicReferenceArray<AbstractC2124fu<K, V>> Wwwwwwwwwwwwwwwwwwwww;
        public Segment<K, V> Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = LocalCache.this.Wwwwwwwwwwwwwwwwwwwwww.length - 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            while (true) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (i >= 0) {
                    AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwww = i - 1;
                    AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(i);
                    this.Wwwwwwwwwwwwwwwwwwww = abstractC2124fu;
                    if (abstractC2124fu != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            AbstractC2124fu<K, V> abstractC2124fu = this.Wwwwwwwwwwwwwwwwwwww;
            if (abstractC2124fu != null) {
                while (true) {
                    this.Wwwwwwwwwwwwwwwwwwww = abstractC2124fu.getNext();
                    AbstractC2124fu<K, V> abstractC2124fu2 = this.Wwwwwwwwwwwwwwwwwwww;
                    if (abstractC2124fu2 == null) {
                        return false;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu2)) {
                        return true;
                    }
                    abstractC2124fu = this.Wwwwwwwwwwwwwwwwwwww;
                }
            } else {
                return false;
            }
        }

        public LocalCache<K, V>.Wwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            LocalCache<K, V>.Wwwww wwwww = this.Wwwwwwwwwwwwwwwwwww;
            if (wwwww != null) {
                this.Wwwwwwwwwwwwwwwwww = wwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return this.Wwwwwwwwwwwwwwwwww;
            }
            throw new NoSuchElementException();
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwww = null;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                while (true) {
                    int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (i < 0) {
                        return;
                    }
                    Segment<K, V>[] segmentArr = LocalCache.this.Wwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = i - 1;
                    Segment<K, V> segment = segmentArr[i];
                    this.Wwwwwwwwwwwwwwwwwwwwww = segment;
                    if (segment.count != 0) {
                        AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwwwwwww.table;
                        this.Wwwwwwwwwwwwwwwwwwwww = atomicReferenceArray;
                        this.Wwwwwwwwwwwwwwwwwwwwwww = atomicReferenceArray.length() - 1;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            return;
                        }
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
            r6.Wwwwwwwwwwwwwwwwwww = new com.google.common.cache.LocalCache.Wwwww(r6.Wwwwwwwwwwwwwwwww, r2, r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
            r7 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu<K, V> abstractC2124fu) {
            V v;
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LocalCache.this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                K key = abstractC2124fu.getKey();
                LocalCache localCache = LocalCache.this;
                V v2 = null;
                if (localCache != null) {
                    if (abstractC2124fu.getKey() != null && (v = abstractC2124fu.getValueReference().get()) != null && !localCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        v2 = v;
                    }
                    boolean z = false;
                    return z;
                }
                throw null;
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwww.postReadCleanup();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwww != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww != null);
            LocalCache.this.remove(this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends LocalCache<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.Wwwwwwwwwwwwwwwwwww.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LocalCache<K, V>.Wwwwwwwwwwwwwwwwwwwwwwwwwww<Map.Entry<K, V>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends AbstractQueue<AbstractC2124fu<K, V>> {
        public final AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2457ou<AbstractC2124fu<K, V>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu abstractC2124fu) {
                super(abstractC2124fu);
            }

            @Override // me.tvspark.AbstractC2457ou
            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
                AbstractC2124fu<K, V> nextInAccessQueue = ((AbstractC2124fu) obj).getNextInAccessQueue();
                if (nextInAccessQueue == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
            public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwwww = this;
            public AbstractC2124fu<K, V> Wwwwwwwwwwwwwwwwwwwwwww = this;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public AbstractC2124fu<K, V> getNextInAccessQueue() {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public AbstractC2124fu<K, V> getPreviousInAccessQueue() {
                return this.Wwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
            }

            @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.AbstractC2124fu
            public void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2124fu;
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC2124fu<K, V> nextInAccessQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInAccessQueue();
            while (true) {
                AbstractC2124fu<K, V> abstractC2124fu = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (nextInAccessQueue == abstractC2124fu) {
                    abstractC2124fu.setNextInAccessQueue(abstractC2124fu);
                    AbstractC2124fu<K, V> abstractC2124fu2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    abstractC2124fu2.setPreviousInAccessQueue(abstractC2124fu2);
                    return;
                }
                AbstractC2124fu<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2124fu) nextInAccessQueue);
                nextInAccessQueue = nextInAccessQueue2;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((AbstractC2124fu) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInAccessQueue() == this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<AbstractC2124fu<K, V>> iterator() {
            AbstractC2124fu<K, V> nextInAccessQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInAccessQueue();
            if (nextInAccessQueue == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                nextInAccessQueue = null;
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextInAccessQueue);
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            AbstractC2124fu<K, V> abstractC2124fu = (AbstractC2124fu) obj;
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu.getPreviousInAccessQueue(), abstractC2124fu.getNextInAccessQueue());
            AbstractC2124fu<K, V> previousInAccessQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getPreviousInAccessQueue();
            previousInAccessQueue.setNextInAccessQueue(abstractC2124fu);
            abstractC2124fu.setPreviousInAccessQueue(previousInAccessQueue);
            AbstractC2124fu<K, V> abstractC2124fu2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            abstractC2124fu.setNextInAccessQueue(abstractC2124fu2);
            abstractC2124fu2.setPreviousInAccessQueue(abstractC2124fu);
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            AbstractC2124fu<K, V> nextInAccessQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInAccessQueue();
            if (nextInAccessQueue == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        public Object poll() {
            AbstractC2124fu<K, V> nextInAccessQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInAccessQueue();
            if (nextInAccessQueue == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            AbstractC2124fu abstractC2124fu = (AbstractC2124fu) obj;
            AbstractC2124fu<K, V> previousInAccessQueue = abstractC2124fu.getPreviousInAccessQueue();
            AbstractC2124fu<K, V> nextInAccessQueue = abstractC2124fu.getNextInAccessQueue();
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(previousInAccessQueue, nextInAccessQueue);
            LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2124fu);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (AbstractC2124fu<K, V> nextInAccessQueue = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNextInAccessQueue(); nextInAccessQueue != this.Wwwwwwwwwwwwwwwwwwwwwwww; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> implements AbstractC2124fu<K, V> {
        @Override // me.tvspark.AbstractC2124fu
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public AbstractC2124fu<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public Wwwwwwwwwwwwwwww<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setValueReference(Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww) {
            throw new UnsupportedOperationException();
        }

        @Override // me.tvspark.AbstractC2124fu
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends AbstractSet<T> {
        public final ConcurrentMap<?, ?> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this).toArray(eArr);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.m3877of().mo4735iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwww<Object, Object> {
        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwww<Object, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<Object> referenceQueue, Object obj, AbstractC2124fu<Object, Object> abstractC2124fu) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public AbstractC2124fu<Object, Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean isActive() {
            return false;
        }
    }

    public LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        AbstractC2799xt abstractC2799xt;
        int i = cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = Math.min(i == -1 ? 4 : i, 65536);
        this.Wwwwwwwwwwwwwwwwww = (Strength) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Strength.STRONG);
        this.Wwwwwwwwwwwwwwwww = (Strength) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwww, Strength.STRONG);
        this.Wwwwwwwwwwwwwwwwwwww = (Equivalence) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwww, ((Strength) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Strength.STRONG)).defaultEquivalence());
        this.Wwwwwwwwwwwwwwwwwww = (Equivalence) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwww, ((Strength) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwww, Strength.STRONG)).defaultEquivalence());
        long j = 0;
        this.Wwwwwwwwwwwwwwww = (cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwww == 0 || cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwww == 0) ? 0L : cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwww = (AbstractC2198hu) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, CacheBuilder.OneWeigher.INSTANCE);
        long j2 = cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwww = j2 == -1 ? 0L : j2;
        long j3 = cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwww = j3 == -1 ? 0L : j3;
        long j4 = cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwww = j4 != -1 ? j4 : j;
        AbstractC2161gu<K, V> abstractC2161gu = (AbstractC2161gu) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheBuilder.Wwwwwwwwwwwwwwwwwwwww, CacheBuilder.NullListener.INSTANCE);
        this.Wwwwwwwwww = abstractC2161gu;
        if (abstractC2161gu == CacheBuilder.NullListener.INSTANCE) {
            concurrentLinkedQueue = (Queue<RemovalNotification<K, V>>) Kkkkkkkkkkkkkkkkkkkkkkkk;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
        }
        this.Wwwwwwwwwww = concurrentLinkedQueue;
        boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        AbstractC2799xt abstractC2799xt2 = cacheBuilder.Wwwwwwwwwwwwwwwwwwww;
        if (abstractC2799xt2 == null) {
            if (z) {
                abstractC2799xt = AbstractC2799xt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                abstractC2799xt = CacheBuilder.Wwwwwwwwwwwwwwww;
            }
            abstractC2799xt2 = abstractC2799xt;
        }
        this.Wwwwwwwww = abstractC2799xt2;
        this.Wwwwwwww = EntryFactory.getFactory(this.Wwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwww = cacheBuilder.Wwwwwwwwwwwwwwwwwww.mo4804get();
        this.Wwwwww = cacheLoader;
        int i2 = cacheBuilder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int min = Math.min(i2 == -1 ? 16 : i2, 1073741824);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (!(this.Wwwwwwwwwwwwwww != CacheBuilder.OneWeigher.INSTANCE)) {
                min = (int) Math.min(min, this.Wwwwwwwwwwwwwwww);
            }
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.Wwwwwwwwwwwwwwwwwwwww && (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || i3 * 20 <= this.Wwwwwwwwwwwwwwww)) {
            i4++;
            i3 <<= 1;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = 32 - i4;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i3 - 1;
        this.Wwwwwwwwwwwwwwwwwwwwww = new Segment[i3];
        int i5 = min / i3;
        int i6 = 1;
        while (i6 < (i5 * i3 < min ? i5 + 1 : i5)) {
            i6 <<= 1;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            long j5 = this.Wwwwwwwwwwwwwwww;
            long j6 = i3;
            long j7 = j5 % j6;
            long j8 = (j5 / j6) + 1;
            int i7 = 0;
            while (i7 < this.Wwwwwwwwwwwwwwwwwwwwww.length) {
                if (i7 == j7) {
                    j8--;
                }
                long j9 = j8;
                this.Wwwwwwwwwwwwwwwwwwwwww[i7] = new Segment<>(this, i6, j9, cacheBuilder.Wwwwwwwwwwwwwwwwwww.mo4804get());
                i7++;
                j8 = j9;
            }
            return;
        }
        int i8 = 0;
        while (true) {
            Segment<K, V>[] segmentArr = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (i8 >= segmentArr.length) {
                return;
            }
            segmentArr[i8] = new Segment<>(this, i6, -1L, cacheBuilder.Wwwwwwwwwwwwwwwwwww.mo4804get());
            i8++;
        }
    }

    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu<K, V> abstractC2124fu) {
        NullEntry nullEntry = NullEntry.INSTANCE;
        abstractC2124fu.setNextInWriteQueue(nullEntry);
        abstractC2124fu.setPreviousInWriteQueue(nullEntry);
    }

    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
        abstractC2124fu.setNextInWriteQueue(abstractC2124fu2);
        abstractC2124fu2.setPreviousInWriteQueue(abstractC2124fu);
    }

    public static /* synthetic */ ArrayList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu<K, V> abstractC2124fu, AbstractC2124fu<K, V> abstractC2124fu2) {
        abstractC2124fu.setNextInAccessQueue(abstractC2124fu2);
        abstractC2124fu2.setPreviousInAccessQueue(abstractC2124fu);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwww != Strength.STRONG;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwww != Strength.STRONG;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return (this.Wwwwwwwwwwww > 0L ? 1 : (this.Wwwwwwwwwwww == 0L ? 0 : -1)) > 0;
        }
        return true;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j = 0;
        for (Segment<K, V> segment : this.Wwwwwwwwwwwwwwwwwwwwww) {
            j += Math.max(0, segment.count);
        }
        return j;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwww > 0;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwww > 0;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        int hash = this.Wwwwwwwwwwwwwwwwwwww.hash(obj);
        int i = hash + ((hash << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = (i4 << 2) + (i4 << 14) + i4;
        return (i5 >>> 16) ^ i5;
    }

    public Segment<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwww[(i >>> this.Wwwwwwwwwwwwwwwwwwwwwww) & this.Wwwwwwwwwwwwwwwwwwwwwwww];
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwww >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.Wwwwwwwwwwwwwwwwwwwwww) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).containsKey(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Segment<K, V>[] segmentArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        long j = -1;
        int i = 0;
        while (i < 3) {
            long j2 = 0;
            int length = segmentArr.length;
            int i2 = 0;
            while (i2 < length) {
                Segment<K, V> segment = segmentArr[i2];
                int i3 = segment.count;
                AtomicReferenceArray<AbstractC2124fu<K, V>> atomicReferenceArray = segment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    AbstractC2124fu<K, V> abstractC2124fu = atomicReferenceArray.get(i4);
                    while (abstractC2124fu != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(abstractC2124fu, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        long j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        if (liveValue != null && this.Wwwwwwwwwwwwwwwwwww.equivalent(obj, liveValue)) {
                            return true;
                        }
                        abstractC2124fu = abstractC2124fu.getNext();
                        segmentArr = segmentArr2;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = j3;
                    }
                }
                j2 += segment.modCount;
                i2++;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            long j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
            segmentArr = segmentArr3;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = j4;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.Www;
        if (set != null) {
            return set;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        this.Www = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).get(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += segmentArr[i].modCount;
        }
        if (j != 0) {
            for (int i2 = 0; i2 < segmentArr.length; i2++) {
                if (segmentArr[i2].count != 0) {
                    return false;
                }
                j -= segmentArr[i2].modCount;
            }
            return j == 0;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.Wwwww;
        if (set != null) {
            return set;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwww(this);
        this.Wwwww = wwwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            if (v == null) {
                throw null;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).put(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, v, false);
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        if (k != null) {
            if (v == null) {
                throw null;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).put(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, v, true);
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).remove(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).remove(obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        if (k != null) {
            if (v == null) {
                throw null;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).replace(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, v);
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.Wwww;
        if (collection != null) {
            return collection;
        }
        Wwwwwwwwwwwwwww wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwww(this);
        this.Wwww = wwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwww;
    }

    public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        if (k != null) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).get(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, cacheLoader);
        }
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        if (k != null) {
            if (v2 == null) {
                throw null;
            }
            if (v == null) {
                return false;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).replace(k, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, v, v2);
        }
        throw null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu<K, V> abstractC2124fu, long j) {
        if (abstractC2124fu != null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && j - abstractC2124fu.getAccessTime() >= this.Wwwwwwwwwwwwww) {
                return true;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && j - abstractC2124fu.getWriteTime() >= this.Wwwwwwwwwwwww;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        if (cacheLoader != null) {
            if (set != null) {
                C2647tt c2647tt = new C2647tt();
                c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                boolean z = false;
                try {
                    try {
                        try {
                            try {
                                Map map = (Map<? super K, V>) cacheLoader.loadAll(set);
                                if (map == null) {
                                    this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.NANOSECONDS));
                                    throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
                                }
                                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "This stopwatch is already stopped.");
                                c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                                c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                for (Map.Entry<K, V> entry : map.entrySet()) {
                                    K key = entry.getKey();
                                    V value = entry.getValue();
                                    if (key == null || value == null) {
                                        z = true;
                                    } else {
                                        put(key, value);
                                    }
                                }
                                if (!z) {
                                    this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.NANOSECONDS));
                                    return map;
                                }
                                this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.NANOSECONDS));
                                throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
                            } catch (Error e) {
                                throw new ExecutionError(e);
                            }
                        } catch (RuntimeException e2) {
                            throw new UncheckedExecutionException(e2);
                        } catch (Exception e3) {
                            throw new ExecutionException(e3);
                        }
                    } catch (CacheLoader.UnsupportedLoadingOperationException e4) {
                        try {
                            throw e4;
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            if (!z) {
                            }
                            throw th;
                        }
                    } catch (InterruptedException e5) {
                        Thread.currentThread().interrupt();
                        throw new ExecutionException(e5);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!z) {
                        this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2647tt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.NANOSECONDS));
                    }
                    throw th;
                }
            }
            throw null;
        }
        throw null;
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwww<K, V> implements Wwwwwwwwwwwwwwww<K, V> {
        public final C2647tt Wwwwwwwwwwwwwwwwwwwwww;
        public final C2879zz<V> Wwwwwwwwwwwwwwwwwwwwwww;
        public volatile Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<V, V> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.AbstractC2271jt
            /* renamed from: apply */
            public V mo4462apply(V v) {
                Wwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2879zz<V>) v);
                return v;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwww = new C2879zz<>();
            this.Wwwwwwwwwwwwwwwwwwwwww = new C2647tt();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwww<K, V>) LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        }

        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ExecutionException {
            return (V) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<Object>) this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2879zz<V>) v);
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwww<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ReferenceQueue<V> referenceQueue, V v, AbstractC2124fu<K, V> abstractC2124fu) {
            return this;
        }

        public AbstractFutureC2691uz<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, CacheLoader<? super K, V> cacheLoader) {
            AbstractFutureC2691uz<V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            try {
                this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                V v = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(load) ? this.Wwwwwwwwwwwwwwwwwwwwwww : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(load);
                }
                AbstractFutureC2691uz<V> reload = cacheLoader.reload(k, v);
                return reload == null ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) null) : AbstractRunnableC2388mz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(reload, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), DirectExecutor.INSTANCE);
            } catch (Throwable th) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th)) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2653tz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(th);
                }
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public V get() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public AbstractC2124fu<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public boolean isActive() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.isActive();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = new C2879zz<>();
            this.Wwwwwwwwwwwwwwwwwwwwww = new C2647tt();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.cache.LocalCache.Wwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
            if (v != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2879zz<V>) v);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwww<K, V>) LocalCache.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            }
        }
    }

    public static <K, V> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2124fu<K, V> abstractC2124fu) {
        NullEntry nullEntry = NullEntry.INSTANCE;
        abstractC2124fu.setNextInAccessQueue(nullEntry);
        abstractC2124fu.setPreviousInAccessQueue(nullEntry);
    }
}
