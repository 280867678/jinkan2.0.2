package me.tvspark;

/* loaded from: classes4.dex */
public final class ua0<T, U> implements f70<T, h60<U>> {
    public final f70<? super T, ? extends Iterable<? extends U>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public ua0(f70<? super T, ? extends Iterable<? extends U>> f70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.f70
    public Object apply(Object obj) throws Exception {
        return new ia0(this.Wwwwwwwwwwwwwwwwwwwwwwww.apply(obj));
    }
}
