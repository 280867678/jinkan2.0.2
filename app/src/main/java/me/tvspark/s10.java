package me.tvspark;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class s10 extends w10 {
    public final /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public s10(Method method, Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = method;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    @Override // me.tvspark.w10
    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<T> cls) throws Exception {
        w10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        return (T) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.invoke(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cls);
    }
}
