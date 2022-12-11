package com.google.common.cache;

import java.util.AbstractMap;

/* loaded from: classes3.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    public static final long serialVersionUID = 0;
    public final RemovalCause cause;

    public RemovalNotification(K k, V v, RemovalCause removalCause) {
        super(k, v);
        if (removalCause != null) {
            this.cause = removalCause;
            return;
        }
        throw null;
    }

    public static <K, V> RemovalNotification<K, V> create(K k, V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
