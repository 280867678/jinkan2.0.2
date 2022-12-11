package me.tvspark;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class iw0 {
    public static final kw0<nv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final kw0<nv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final kw0<lv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final kw0<kv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final kw0<Iterable<? extends Object>> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final kw0<Enum<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final kw0<Map<String, ? extends Object>> Wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final kw0<Object> Wwwwwwwwwwwwwwwwwwwwwwwww = new yv0();
    public static final kw0<Object> Wwwwwwwwwwwwwwwwwwwwwwww = new xv0();
    public static final kw0<Object> Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    public ConcurrentHashMap<Class<?>, kw0<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap<>();
    public LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinkedList<>();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww {
        public kw0<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls, kw0<?> kw0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kw0Var;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<Object> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            appendable.append(obj.toString());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<Map<String, ? extends Object>> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            Map map = (Map) obj;
            if (ov0Var != null) {
                appendable.append('{');
                boolean z = true;
                for (Map.Entry entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null || !ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (z) {
                            z = false;
                        } else {
                            appendable.append(',');
                        }
                        iw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getKey().toString(), value, appendable, ov0Var);
                    }
                }
                appendable.append('}');
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<Enum<?>> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appendable, ((Enum) obj).name());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<Iterable<? extends Object>> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            Iterable iterable = (Iterable) obj;
            if (ov0Var != null) {
                appendable.append('[');
                boolean z = true;
                for (Object obj2 : iterable) {
                    if (z) {
                        z = false;
                    } else {
                        appendable.append(',');
                    }
                    if (obj2 == null) {
                        appendable.append("null");
                    } else {
                        qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2, appendable, ov0Var);
                    }
                }
                appendable.append(']');
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<kv0> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            appendable.append(((kv0) obj).toJSONString());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<lv0> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            appendable.append(((lv0) obj).toJSONString(ov0Var));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<nv0> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            ((nv0) obj).writeJSONString(appendable, ov0Var);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements kw0<nv0> {
        @Override // me.tvspark.kw0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
            ((nv0) obj).writeJSONString(appendable);
        }
    }

    public iw0() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new jw0(this), String.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new zv0(this), Double.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new aw0(this), Date.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new bw0(this), Float.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww, Boolean.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new cw0(this), int[].class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new dw0(this), short[].class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ew0(this), long[].class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new fw0(this), float[].class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new gw0(this), double[].class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new hw0(this), boolean[].class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(nv0.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(mv0.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(lv0.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(kv0.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(Map.class, Wwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(Iterable.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(Enum.class, Wwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(new Wwwwwwwwwwwwwwwwwwwwwwwwww(Number.class, Wwwwwwwwwwwwwwwwwwwwwww));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        if (str == null) {
            str = "null";
        } else if (ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            appendable.append('\"');
            qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, appendable, ov0Var);
            appendable.append('\"');
            if (ov0Var == null) {
                appendable.append(':');
                if (obj instanceof String) {
                    ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appendable, (String) obj);
                    return;
                } else {
                    qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, appendable, ov0Var);
                    return;
                }
            }
            throw null;
        }
        appendable.append(str);
        if (ov0Var == null) {
        }
    }

    public <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kw0<T> kw0Var, Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, kw0Var);
        }
    }
}
