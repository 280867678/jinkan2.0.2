package me.tvspark;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.m0 */
/* loaded from: classes4.dex */
public class C2353m0 {
    public final List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final Map<String, List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

    /* renamed from: me.tvspark.m0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> {
        public final Illlllllllllllllllllllll<T, R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<T> cls, @NonNull Class<R> cls2, Illlllllllllllllllllllll<T, R> illlllllllllllllllllllll) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllll;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls) && cls2.isAssignableFrom(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
            if (list != null) {
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : list) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2) && !arrayList.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Illlllllllllllllllllllll<T, R>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
            if (list != null) {
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : list) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2)) {
                        arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public final synchronized List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str) {
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> list;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(str)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(str);
        }
        list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str, @NonNull Illlllllllllllllllllllll<T, R> illlllllllllllllllllllll, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(cls, cls2, illlllllllllllllllllllll));
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        for (String str : list) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(str);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!list.contains(str2)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(str2);
            }
        }
    }
}
