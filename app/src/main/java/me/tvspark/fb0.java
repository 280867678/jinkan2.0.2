package me.tvspark;

import java.util.List;

/* loaded from: classes4.dex */
public final class fb0<T, R> implements f70<List<h60<? extends T>>, h60<? extends R>> {
    public final f70<? super Object[], ? extends R> Wwwwwwwwwwwwwwwwwwwwwwww;

    public fb0(f70<? super Object[], ? extends R> f70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.f70
    public Object apply(Object obj) throws Exception {
        return d60.zipIterable((List) obj, this.Wwwwwwwwwwwwwwwwwwwwwwww, false, d60.bufferSize());
    }
}
