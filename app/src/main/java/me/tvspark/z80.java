package me.tvspark;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.a90;

/* loaded from: classes4.dex */
public class z80 implements Iterator<T> {
    public final /* synthetic */ a90.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public Object Wwwwwwwwwwwwwwwwwwwwwwww;

    public z80(a90.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
        return !NotificationLite.isComplete(obj);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public T next() {
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            }
            if (NotificationLite.isComplete(this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                throw new NoSuchElementException();
            }
            if (NotificationLite.isError(this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NotificationLite.getError(this.Wwwwwwwwwwwwwwwwwwwwwwww));
            }
            return NotificationLite.getValue(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Read only iterator");
    }
}
