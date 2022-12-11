package me.tvspark;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonIOException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes4.dex */
public final class k00 {
    public static final t20<?> Wwwwwwwwwwwwwwwwwwwwwwwww = new t20<>(Object.class);
    public final List<w00> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final a20 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final g10 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ThreadLocal<Map<t20<?>, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ThreadLocal<>();
    public final Map<t20<?>, v00<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends v00<T> {
        public v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @Override // me.tvspark.v00
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, T t) throws IOException {
            v00<T> v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (v00Var != null) {
                v00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public k00() {
        o10 o10Var = o10.Wwwwwwwwwwwwwwwwwww;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        Map emptyMap = Collections.emptyMap();
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        Collections.emptyList();
        Collections.emptyList();
        List emptyList = Collections.emptyList();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new g10(emptyMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add(l20.Kkkkkkkk);
        arrayList.add(e20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(o10Var);
        arrayList.addAll(emptyList);
        arrayList.add(l20.Wwwww);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwwwwwwwww);
        v00 h00Var = longSerializationPolicy == LongSerializationPolicy.DEFAULT ? l20.Wwwwwwwwwwwwwww : new h00();
        arrayList.add(new n20(Long.TYPE, Long.class, h00Var));
        arrayList.add(new n20(Double.TYPE, Double.class, new f00(this)));
        arrayList.add(new n20(Float.TYPE, Float.class, new g00(this)));
        arrayList.add(l20.Wwwwwwwwwww);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwwwww);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwww);
        arrayList.add(new m20(AtomicLong.class, new u00(new i00(h00Var))));
        arrayList.add(new m20(AtomicLongArray.class, new u00(new j00(h00Var))));
        arrayList.add(l20.Wwwwwwwwwwwwwwww);
        arrayList.add(l20.Wwwwwwwww);
        arrayList.add(l20.Www);
        arrayList.add(l20.Kkkkkkkkkkkkkkkkkkkkkkkkk);
        arrayList.add(new m20(BigDecimal.class, l20.Wwwwwww));
        arrayList.add(new m20(BigInteger.class, l20.Wwwwww));
        arrayList.add(l20.Kkkkkkkkkkkkkkkkkkkkkkk);
        arrayList.add(l20.Kkkkkkkkkkkkkkkkkkkkk);
        arrayList.add(l20.Kkkkkkkkkkkkkkkkk);
        arrayList.add(l20.Kkkkkkkkkkkkkkk);
        arrayList.add(l20.Kkkkkkkkkk);
        arrayList.add(l20.Kkkkkkkkkkkkkkkkkkk);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(z10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(l20.Kkkkkkkkkkkk);
        arrayList.add(i20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(h20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(l20.Kkkkkkkkkkkkkk);
        arrayList.add(x10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(l20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        arrayList.add(new y10(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        arrayList.add(new d20(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false));
        a20 a20Var = new a20(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a20Var;
        arrayList.add(a20Var);
        arrayList.add(l20.Kkkkkkk);
        arrayList.add(new g20(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, fieldNamingPolicy, o10Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(arrayList);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public JsonWriter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Writer writer) throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return jsonWriter;
    }

    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t20<T> t20Var) {
        v00<T> v00Var = (v00<T>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(t20Var == null ? Wwwwwwwwwwwwwwwwwwwwwwwww : t20Var);
        if (v00Var != null) {
            return v00Var;
        }
        Map<t20<?>, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> map = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(map);
            z = true;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map.get(t20Var);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
            map.put(t20Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            for (w00 w00Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = w00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, t20Var);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(t20Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + t20Var);
        } finally {
            map.remove(t20Var);
            if (z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove();
            }
        }
    }

    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(w00 w00Var, t20<T> t20Var) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(w00Var)) {
            w00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        boolean z = false;
        for (w00 w00Var2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (z) {
                v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = w00Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, t20Var);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            } else if (w00Var2 == w00Var) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + t20Var);
    }

    public String toString() {
        return "{serializeNulls:" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + ",factories:" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ",instanceCreators:" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + "}";
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (obj == null) {
            AbstractC3508o00 abstractC3508o00 = p00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            StringWriter stringWriter = new StringWriter();
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC3508o00, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Writer) stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        }
        Type type = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, type, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Writer) stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC3508o00 abstractC3508o00, JsonWriter jsonWriter) throws JsonIOException {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        try {
            try {
                try {
                    l20.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, abstractC3508o00);
                } catch (AssertionError e) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e.getMessage());
                    assertionError.initCause(e);
                    throw assertionError;
                }
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        v00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new t20(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        try {
            try {
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, obj);
                } catch (IOException e) {
                    throw new JsonIOException(e);
                }
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }
}
