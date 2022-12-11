package me.tvspark;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class g20 implements w00 {
    public final r20 Wwwwwwwwwwwwwwwwwwww = r20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final a20 Wwwwwwwwwwwwwwwwwwwww;
    public final o10 Wwwwwwwwwwwwwwwwwwwwww;
    public final e00 Wwwwwwwwwwwwwwwwwwwwwww;
    public final g10 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends v00<T> {
        public final Map<String, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r10<T> r10Var, Map<String, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> map) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
            r7.name(r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            r1 = (me.tvspark.f20) r1;
            r2 = r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
            if (r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
            r1 = r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
            r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r7, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
            r1 = new me.tvspark.k20(r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v7, types: [me.tvspark.v00] */
        /* JADX WARN: Type inference failed for: r1v8, types: [me.tvspark.v00] */
        @Override // me.tvspark.v00
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.values().iterator();
                while (it.hasNext()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                    f20 f20Var = (f20) next;
                    boolean z = false;
                    if (f20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && f20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(t) != t) {
                        z = true;
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public g20(g10 g10Var, e00 e00Var, o10 o10Var, a20 a20Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = g10Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = e00Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = o10Var;
        this.Wwwwwwwwwwwwwwwwwwwww = a20Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    @Override // me.tvspark.w00
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        int i2;
        ArrayList arrayList;
        int size;
        int i3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Field[] fieldArr;
        Class<? super T> cls;
        t20<T> t20Var2;
        LinkedHashMap linkedHashMap;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Class<? super T> cls2;
        r10<T> r10Var;
        Type type;
        Field field;
        v00<?> v00Var;
        ArrayList arrayList2;
        g20 g20Var = this;
        k00 k00Var2 = k00Var;
        Class<? super T> cls3 = Object.class;
        Class<? super T> cls4 = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!cls3.isAssignableFrom(cls4)) {
            return null;
        }
        r10<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = g20Var.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t20Var);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (!cls4.isInterface()) {
            Type type2 = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            t20<T> t20Var3 = t20Var;
            Class<? super T> cls5 = cls4;
            while (cls5 != cls3) {
                Field[] declaredFields = cls5.getDeclaredFields();
                int length = declaredFields.length;
                boolean z = false;
                int i4 = 0;
                while (i4 < length) {
                    Field field2 = declaredFields[i4];
                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = g20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(field2, true);
                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = g20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(field2, z);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) {
                        g20Var.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(field2);
                        Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t20Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cls5, field2.getGenericType());
                        y00 y00Var = (y00) field2.getAnnotation(y00.class);
                        if (y00Var == null) {
                            i = i4;
                            arrayList2 = Collections.singletonList(g20Var.Wwwwwwwwwwwwwwwwwwwwwww.translateName(field2));
                        } else {
                            String value = y00Var.value();
                            String[] alternate = y00Var.alternate();
                            i = i4;
                            if (alternate.length == 0) {
                                arrayList2 = Collections.singletonList(value);
                            } else {
                                i2 = length;
                                ArrayList arrayList3 = new ArrayList(alternate.length + 1);
                                arrayList3.add(value);
                                int i5 = 0;
                                for (int length2 = alternate.length; i5 < length2; length2 = length2) {
                                    arrayList3.add(alternate[i5]);
                                    i5++;
                                }
                                arrayList = arrayList3;
                                size = arrayList.size();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                i3 = 0;
                                while (i3 < size) {
                                    Class<? super T> cls6 = cls3;
                                    String str = (String) arrayList.get(i3);
                                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                                    if (i3 != 0) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = false;
                                    }
                                    t20<T> t20Var4 = new t20<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    Class<? super T> cls7 = t20Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i6 = i3;
                                    boolean z2 = (cls7 instanceof Class) && cls7.isPrimitive();
                                    x00 x00Var = (x00) field2.getAnnotation(x00.class);
                                    if (x00Var != null) {
                                        field = field2;
                                        v00Var = g20Var.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g20Var.Wwwwwwwwwwwwwwwwwwwwwwww, k00Var2, t20Var4, x00Var);
                                    } else {
                                        field = field2;
                                        v00Var = null;
                                    }
                                    boolean z3 = v00Var != null;
                                    if (v00Var == null) {
                                        v00Var = k00Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t20) t20Var4);
                                    }
                                    Field field3 = field;
                                    int i7 = size;
                                    ArrayList arrayList4 = arrayList;
                                    Field[] fieldArr2 = declaredFields;
                                    Class<? super T> cls8 = cls5;
                                    boolean z4 = z3;
                                    Type type3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                    t20<T> t20Var5 = t20Var3;
                                    r10<T> r10Var2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    Type type4 = type2;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) linkedHashMap3.put(str, new f20(this, str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, field3, z4, v00Var, k00Var, t20Var4, z2));
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                    }
                                    i3 = i6 + 1;
                                    g20Var = this;
                                    k00Var2 = k00Var;
                                    cls5 = cls8;
                                    linkedHashMap2 = linkedHashMap3;
                                    type2 = type4;
                                    cls3 = cls6;
                                    field2 = field3;
                                    size = i7;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = type3;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r10Var2;
                                    arrayList = arrayList4;
                                    declaredFields = fieldArr2;
                                    t20Var3 = t20Var5;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                fieldArr = declaredFields;
                                cls = cls5;
                                t20Var2 = t20Var3;
                                linkedHashMap = linkedHashMap2;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                cls2 = cls3;
                                r10Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                type = type2;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                    throw new IllegalArgumentException(type + " declares multiple JSON fields named " + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                            }
                        }
                        i2 = length;
                        arrayList = arrayList2;
                        size = arrayList.size();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = null;
                        i3 = 0;
                        while (i3 < size) {
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22;
                        fieldArr = declaredFields;
                        cls = cls5;
                        t20Var2 = t20Var3;
                        linkedHashMap = linkedHashMap2;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        cls2 = cls3;
                        r10Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        type = type2;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        }
                    } else {
                        i = i4;
                        i2 = length;
                        fieldArr = declaredFields;
                        cls = cls5;
                        t20Var2 = t20Var3;
                        linkedHashMap = linkedHashMap2;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        cls2 = cls3;
                        r10Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        type = type2;
                    }
                    i4 = i + 1;
                    g20Var = this;
                    k00Var2 = k00Var;
                    cls5 = cls;
                    linkedHashMap2 = linkedHashMap;
                    type2 = type;
                    length = i2;
                    cls3 = cls2;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r10Var;
                    declaredFields = fieldArr;
                    t20Var3 = t20Var2;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    z = false;
                }
                Class<? super T> cls9 = cls5;
                t20Var3 = new t20<>(C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t20Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cls9, cls9.getGenericSuperclass()));
                cls5 = t20Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                g20Var = this;
                k00Var2 = k00Var;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
        }
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, linkedHashMap2);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Field field, boolean z) {
        boolean z2;
        o10 o10Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        Class<?> type = field.getType();
        if (!(o10Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type) || o10Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, z))) {
            if ((o10Var.Wwwwwwwwwwwwwwwwwwwwwww & field.getModifiers()) != 0 || ((o10Var.Wwwwwwwwwwwwwwwwwwwwwwww != -1.0d && !o10Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((z00) field.getAnnotation(z00.class), (a10) field.getAnnotation(a10.class))) || field.isSynthetic() || ((!o10Var.Wwwwwwwwwwwwwwwwwwwwww && o10Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(field.getType())) || o10Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(field.getType())))) {
                z2 = true;
                break;
            }
            List<c00> list = z ? o10Var.Wwwwwwwwwwwwwwwwwwwww : o10Var.Wwwwwwwwwwwwwwwwwwww;
            if (!list.isEmpty()) {
                d00 d00Var = new d00(field);
                for (c00 c00Var : list) {
                    if (c00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d00Var)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                return true;
            }
        }
        return false;
    }
}
