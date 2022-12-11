package me.tvspark;

import java.util.NoSuchElementException;

/* renamed from: me.tvspark.xv */
/* loaded from: classes4.dex */
public final class C2801xv extends AbstractC2239iy<T> {
    public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2801xv(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public T next() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new NoSuchElementException();
    }
}
