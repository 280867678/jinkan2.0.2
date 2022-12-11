package me.tvspark;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* loaded from: classes4.dex */
public class j10 implements r10<T> {
    public final /* synthetic */ Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public j10(g10 g10Var, Type type) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = type;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
    @Override // me.tvspark.r10
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Type type = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!(type instanceof ParameterizedType)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid EnumSet type: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            throw new JsonIOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid EnumSet type: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        throw new JsonIOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }
}
