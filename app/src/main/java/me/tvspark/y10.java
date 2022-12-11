package me.tvspark;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class y10 implements w00 {
    public final g10 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> extends v00<Collection<E>> {
        public final v00<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, Type type, v00<E> v00Var, r10<? extends Collection<E>> r10Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k20(k00Var, v00Var, type);
        }

        @Override // me.tvspark.v00
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Object obj) throws IOException {
            Collection<E> collection = (Collection) obj;
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (E e : collection) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, e);
            }
            jsonWriter.endArray();
        }
    }

    public y10(g10 g10Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = g10Var;
    }

    @Override // me.tvspark.w00
    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
        Type type = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class<? super T> cls = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, Collection.class);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof WildcardType) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((WildcardType) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getUpperBounds()[0];
        }
        Class cls2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof ParameterizedType ? ((ParameterizedType) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getActualTypeArguments()[0] : Object.class;
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00Var, cls2, k00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t20) new t20<>(cls2)), this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t20Var));
    }
}
