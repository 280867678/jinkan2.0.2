package me.tvspark;

import com.google.common.cache.LocalCache;

/* renamed from: me.tvspark.fu */
/* loaded from: classes4.dex */
public interface AbstractC2124fu<K, V> {
    long getAccessTime();

    int getHash();

    K getKey();

    AbstractC2124fu<K, V> getNext();

    AbstractC2124fu<K, V> getNextInAccessQueue();

    AbstractC2124fu<K, V> getNextInWriteQueue();

    AbstractC2124fu<K, V> getPreviousInAccessQueue();

    AbstractC2124fu<K, V> getPreviousInWriteQueue();

    LocalCache.Wwwwwwwwwwwwwwww<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long j);

    void setNextInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu);

    void setNextInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu);

    void setPreviousInAccessQueue(AbstractC2124fu<K, V> abstractC2124fu);

    void setPreviousInWriteQueue(AbstractC2124fu<K, V> abstractC2124fu);

    void setValueReference(LocalCache.Wwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwww);

    void setWriteTime(long j);
}
