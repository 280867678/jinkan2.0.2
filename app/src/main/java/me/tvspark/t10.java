package me.tvspark;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class t10 extends w10 {
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public t10(Method method, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = method;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.w10
    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<T> cls) throws Exception {
        w10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        return (T) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.invoke(null, cls, Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}
