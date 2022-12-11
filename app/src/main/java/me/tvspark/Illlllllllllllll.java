package me.tvspark;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.Illllllllllllllll;

/* loaded from: classes4.dex */
public class Illlllllllllllll {
    public static final Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Map<Class<?>, Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illllllllllllllll<Object> {
        public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        }

        @Override // me.tvspark.Illllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Illllllllllllllll
        @NonNull
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Object mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Class<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Illllllllllllllll<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
    }

    @NonNull
    public synchronized <T> Illllllllllllllll<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t) {
        Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "Argument must not be null");
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(t.getClass());
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Iterator<Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> next = it.next();
                if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().isAssignableFrom(t.getClass())) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = next;
                    break;
                }
            }
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return (Illllllllllllllll<T>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
