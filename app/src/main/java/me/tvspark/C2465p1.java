package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: me.tvspark.p1 */
/* loaded from: classes4.dex */
public class C2465p1<T, Y> {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<T, Y> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinkedHashMap(100, 0.75f, true);

    public C2465p1(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Nullable
    public synchronized Y Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t) {
        Y remove;
        remove = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(t);
        if (remove != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(remove);
        }
        return remove;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Y y) {
        return 1;
    }

    @Nullable
    public synchronized Y Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t, @Nullable Y y) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, y);
            return null;
        }
        if (y != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        Y put = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(t, y);
        if (put != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(put);
            if (!put.equals(y)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, put);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return put;
    }

    public synchronized long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public synchronized Y Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(t);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j) {
            Iterator<Map.Entry<T, Y>> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(value);
            T key = next.getKey();
            it.remove();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key, value);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t, @Nullable Y y) {
    }
}
