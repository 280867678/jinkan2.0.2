package me.tvspark;

/* loaded from: classes4.dex */
public abstract class c11<T> implements h11<T> {
    @Override // me.tvspark.h11
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d11 d11Var) {
        return null;
    }

    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f11 f11Var) {
        return (T) f11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.h11
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11 i11Var) {
        T t = null;
        int childCount = i11Var.getChildCount();
        for (int i = 0; i < childCount; i++) {
            t = (T) i11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        return t;
    }

    @Override // me.tvspark.h11
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k11 k11Var) {
        return null;
    }
}
