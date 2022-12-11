package me.tvspark;

import com.google.gson.JsonIOException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes4.dex */
public final class d20 implements w00 {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final g10 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> extends v00<Map<K, V>> {
        public final v00<V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final v00<K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, Type type, v00<K> v00Var, Type type2, v00<V> v00Var2, r10<? extends Map<K, V>> r10Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k20(k00Var, v00Var, type);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k20(k00Var, v00Var2, type2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.v00
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Object obj) throws IOException {
            String str;
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!d20.this.Wwwwwwwwwwwwwwwwwwwwwww) {
                jsonWriter.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, entry.getValue());
                }
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    v00<K> v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    K key = entry2.getKey();
                    if (v00Var == null) {
                        throw null;
                    }
                    try {
                        c20 c20Var = new c20();
                        v00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c20Var, key);
                        if (c20Var.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                            AbstractC3508o00 abstractC3508o00 = c20Var.Wwwwwwwwwwwwwwwwwwwwww;
                            arrayList.add(abstractC3508o00);
                            arrayList2.add(entry2.getValue());
                            if (abstractC3508o00 != null) {
                                z |= (abstractC3508o00 instanceof m00) || (abstractC3508o00 instanceof q00);
                            } else {
                                throw null;
                            }
                        } else {
                            throw new IllegalStateException("Expected one JSON element but was " + c20Var.Wwwwwwwwwwwwwwwwwwwwwwww);
                        }
                    } catch (IOException e) {
                        throw new JsonIOException(e);
                    }
                }
                if (z) {
                    jsonWriter.beginArray();
                    int size = arrayList.size();
                    while (i < size) {
                        jsonWriter.beginArray();
                        l20.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, (AbstractC3508o00) arrayList.get(i));
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, arrayList2.get(i));
                        jsonWriter.endArray();
                        i++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                int size2 = arrayList.size();
                while (i < size2) {
                    AbstractC3508o00 abstractC3508o002 = (AbstractC3508o00) arrayList.get(i);
                    if (abstractC3508o002 != null) {
                        if (abstractC3508o002 instanceof r00) {
                            r00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC3508o002.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            Object obj2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (obj2 instanceof Number) {
                                str = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            } else if (obj2 instanceof Boolean) {
                                str = Boolean.toString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            } else if (!(obj2 instanceof String)) {
                                throw new AssertionError();
                            } else {
                                str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                        } else if (!(abstractC3508o002 instanceof p00)) {
                            throw new AssertionError();
                        } else {
                            str = "null";
                        }
                        jsonWriter.name(str);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, arrayList2.get(i));
                        i++;
                    } else {
                        throw null;
                    }
                }
            }
            jsonWriter.endObject();
        }
    }

    public d20(g10 g10Var, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = g10Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.w00
    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
        Type[] actualTypeArguments;
        Type type = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!Map.class.isAssignableFrom(t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return null;
        }
        Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Map.class);
            actualTypeArguments = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof ParameterizedType ? ((ParameterizedType) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00Var, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? l20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww : k00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t20) new t20<>(type2)), actualTypeArguments[1], k00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t20) new t20<>(actualTypeArguments[1])), this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t20Var));
    }
}
