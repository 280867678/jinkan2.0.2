package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedRandomAccessList<E> extends Synchronized$SynchronizedList<E> implements RandomAccess {
    public static final long serialVersionUID = 0;

    public Synchronized$SynchronizedRandomAccessList(List<E> list, Object obj) {
        super(list, obj);
    }
}
