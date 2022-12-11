package me.tvspark;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.l */
/* loaded from: classes4.dex */
public class C2315l {
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* renamed from: me.tvspark.l$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Z, R> {
        public final AbstractC2278k<Z, R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull AbstractC2278k<Z, R> abstractC2278k) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2278k;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls) && cls2.isAssignableFrom(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Z, R> AbstractC2278k<Z, R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return C2352m.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2)) {
                return (AbstractC2278k<Z, R>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull AbstractC2278k<Z, R> abstractC2278k) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(cls, cls2, abstractC2278k));
    }
}
