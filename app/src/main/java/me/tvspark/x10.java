package me.tvspark;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public final class x10<E> extends v00<Object> {
    public static final w00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final v00<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w00 {
        @Override // me.tvspark.w00
        public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
            Type type = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z = type instanceof GenericArrayType;
            if (z || ((type instanceof Class) && ((Class) type).isArray())) {
                Type genericComponentType = z ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
                return new x10(k00Var, k00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t20) new t20<>(genericComponentType)), C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(genericComponentType));
            }
            return null;
        }
    }

    public x10(k00 k00Var, v00<E> v00Var, Class<E> cls) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k20(k00Var, v00Var, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}
