package me.tvspark;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* loaded from: classes4.dex */
public abstract class ak0<T> {
    public abstract Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, mg0<? super of0> mg0Var);

    public abstract Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<? extends T> it, mg0<? super of0> mg0Var);

    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zj0<? extends T> zj0Var, mg0<? super of0> mg0Var) {
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) zj0Var.iterator(), mg0Var);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == CoroutineSingletons.COROUTINE_SUSPENDED ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
