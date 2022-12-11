package me.tvspark;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public class t20<T> {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Class<? super T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public t20() {
        Type genericSuperclass = t20.class.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Class<? super T>) C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof t20) && C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((t20) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final String toString() {
        return C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public t20(Type type) {
        if (type != null) {
            Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Class<? super T>) C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
            return;
        }
        throw null;
    }
}
