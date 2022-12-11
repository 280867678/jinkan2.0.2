package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public enum Iterators$EmptyModifiableIterator implements Iterator<Object> {
    INSTANCE;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, (Object) "no calls to next() since the last call to remove()");
    }
}
