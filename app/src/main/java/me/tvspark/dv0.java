package me.tvspark;

import com.tencent.smtt.sdk.TbsListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes4.dex */
public abstract class dv0<T> {
    public static ConcurrentHashMap<Class<?>, dv0<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap<>();
    public bv0[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public HashMap<String, bv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Removed duplicated region for block: B:156:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <P> dv0<P> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<P> cls, jv0 jv0Var) {
        int i;
        int i2;
        String str;
        LinkedList linkedList;
        Class<? extends Exception> cls2;
        String str2;
        String str3;
        String str4;
        c51 c51Var;
        boolean z;
        k51[] k51VarArr;
        k51 k51Var;
        bv0[] bv0VarArr;
        Method[] methods;
        Field[] declaredFields;
        dv0<P> dv0Var = (dv0<P>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        if (dv0Var != null) {
            return dv0Var;
        }
        HashMap hashMap = new HashMap();
        jv0 jv0Var2 = jv0Var == null ? cv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : jv0Var;
        Class<P> cls3 = cls;
        while (true) {
            i = 1;
            i2 = 0;
            if (cls3 == Object.class) {
                break;
            }
            for (Field field : cls3.getDeclaredFields()) {
                String name = field.getName();
                if (!hashMap.containsKey(name)) {
                    bv0 bv0Var = new bv0(cls3, field, jv0Var2);
                    if ((bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) ? false : true) {
                        hashMap.put(name, bv0Var);
                    }
                }
            }
            cls3 = cls3.getSuperclass();
        }
        bv0[] bv0VarArr2 = (bv0[]) hashMap.values().toArray(new bv0[hashMap.size()]);
        String name2 = cls.getName();
        String concat = name2.startsWith("java.util.") ? "net.minidev.asm." + name2 + "AccAccess" : name2.concat("AccAccess");
        iv0 iv0Var = new iv0(cls.getClassLoader());
        Class<?> cls4 = null;
        try {
            cls4 = iv0Var.loadClass(concat);
        } catch (ClassNotFoundException unused) {
        }
        LinkedList linkedList2 = new LinkedList();
        for (Class<P> cls5 = cls; cls5 != null && !cls5.equals(Object.class); cls5 = cls5.getSuperclass()) {
            linkedList2.addLast(cls5);
            for (Class<?> cls6 : cls5.getInterfaces()) {
                linkedList2.addLast(cls6);
            }
        }
        linkedList2.addLast(Object.class);
        if (cls4 == null) {
            ev0 ev0Var = new ev0(cls, bv0VarArr2, iv0Var);
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                String str5 = concat;
                LinkedList linkedList3 = linkedList2;
                LinkedHashSet<Class<?>> linkedHashSet = fv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get((Class) it.next());
                if (linkedHashSet != null) {
                    Iterator<T> it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        Class cls7 = (Class) it2.next();
                        if (cls7 != null) {
                            for (Method method : cls7.getMethods()) {
                                if ((method.getModifiers() & 8) != 0) {
                                    Class<?>[] parameterTypes = method.getParameterTypes();
                                    if (parameterTypes.length == 1 && parameterTypes[0].equals(Object.class)) {
                                        Class<?> returnType = method.getReturnType();
                                        if (!returnType.equals(Void.TYPE)) {
                                            ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.put(returnType, method);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i = 1;
                i2 = 0;
                concat = str5;
                linkedList2 = linkedList3;
            }
            c51 c51Var2 = new c51(i);
            boolean z2 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length > 10;
            c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(50, 33, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder("Lnet/minidev/asm/BeansAccess<L"), ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, ";>;"), ev0.Wwwwwwwwwwwwwwwwwwwwwwwwww, null);
            l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, "<init>", "()V", null, null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, ev0.Wwwwwwwwwwwwwwwwwwwwwwwwww, "<init>", "()V");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i);
            String str6 = "<init>";
            l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
            bv0[] bv0VarArr3 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bv0VarArr3.length != 0) {
                if (bv0VarArr3.length > 14) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, 2);
                    k51[] Wwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
                    k51 k51Var2 = new k51();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwww.length - i, k51Var2, Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                    bv0[] bv0VarArr4 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int length = bv0VarArr4.length;
                    int i3 = 0;
                    while (i2 < length) {
                        bv0 bv0Var2 = bv0VarArr4[i2];
                        int i4 = i3 + 1;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww[i3]);
                        if (!((bv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && bv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) ? false : true)) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
                        } else {
                            ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, bv0Var2);
                        }
                        i2++;
                        i3 = i4;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var2);
                } else {
                    k51[] Wwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(bv0VarArr3.length);
                    bv0[] bv0VarArr5 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int length2 = bv0VarArr5.length;
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < length2) {
                        bv0 bv0Var3 = bv0VarArr5[i5];
                        ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 2, i6, Wwwwwwwwwwwwwwwwwwwwwwwwwww2[i6]);
                        ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, bv0Var3);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww2[i6]);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 0, (Object[]) null, 0, (Object[]) null);
                        i6++;
                        i5++;
                        bv0VarArr5 = bv0VarArr5;
                    }
                }
            }
            Class<? extends Exception> cls8 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (cls8 != null) {
                ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, cls8);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
            l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
            bv0[] bv0VarArr6 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bv0VarArr6.length != 0) {
                if (bv0VarArr6.length > 14) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, 2);
                    k51[] Wwwwwwwwwwwwwwwwwwwwwwwwwww3 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
                    k51 k51Var3 = new k51();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, Wwwwwwwwwwwwwwwwwwwwwwwwwww3.length - 1, k51Var3, Wwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    bv0[] bv0VarArr7 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int length3 = bv0VarArr7.length;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < length3) {
                        bv0 bv0Var4 = bv0VarArr7[i7];
                        int i9 = i8 + 1;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww3[i8]);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 0, (Object[]) null, 0, (Object[]) null);
                        if (!((bv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && bv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) ? false : true)) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                            k51VarArr = Wwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            k51Var = k51Var3;
                            bv0VarArr = bv0VarArr7;
                        } else {
                            k51VarArr = Wwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 1);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            if (bv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                k51Var = k51Var3;
                                bv0VarArr = bv0VarArr7;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            } else {
                                k51Var = k51Var3;
                                bv0VarArr = bv0VarArr7;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName(), o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                            }
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                        }
                        i7++;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwww3 = k51VarArr;
                        i8 = i9;
                        k51Var3 = k51Var;
                        bv0VarArr7 = bv0VarArr;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var3);
                } else {
                    k51[] Wwwwwwwwwwwwwwwwwwwwwwwwwww4 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(bv0VarArr6.length);
                    bv0[] bv0VarArr8 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int length4 = bv0VarArr8.length;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < length4) {
                        String str7 = concat;
                        LinkedList linkedList4 = linkedList2;
                        String str8 = str6;
                        bv0 bv0Var5 = bv0VarArr8[i10];
                        ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 2, i11, Wwwwwwwwwwwwwwwwwwwwwwwwwww4[i11]);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 1);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (bv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            c51Var = c51Var2;
                            z = z2;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        } else {
                            c51Var = c51Var2;
                            z = z2;
                            Method method2 = bv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (method2 == null) {
                                throw new RuntimeException("no Getter for field " + bv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + " in class " + ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName(), o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method2));
                        }
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww4[i11]);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 0, (Object[]) null, 0, (Object[]) null);
                        i11++;
                        i10++;
                        concat = str7;
                        c51Var2 = c51Var;
                        z2 = z;
                        str6 = str8;
                        linkedList2 = linkedList4;
                    }
                    cls2 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (cls2 == null) {
                        ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, cls2);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
                    String str9 = "(Ljava/lang/Object;)Z";
                    if (z2) {
                        str = concat;
                        str2 = "java/lang/String";
                        l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, "set", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", null, null);
                        k51[] Wwwwwwwwwwwwwwwwwwwwwwwwwww5 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
                        bv0[] bv0VarArr9 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int length5 = bv0VarArr9.length;
                        int i12 = 0;
                        int i13 = 0;
                        while (i12 < length5) {
                            int i14 = length5;
                            bv0 bv0Var6 = bv0VarArr9[i12];
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 2);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, str2, AnnotationHandler.EQUAL, str9);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(153, Wwwwwwwwwwwwwwwwwwwwwwwwwww5[i13]);
                            ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, bv0Var6);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww5[i13]);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 0, (Object[]) null, 0, (Object[]) null);
                            i13++;
                            i12++;
                            length5 = i14;
                            bv0VarArr9 = bv0VarArr9;
                            linkedList2 = linkedList2;
                        }
                        Class<? extends Exception> cls9 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (cls9 != null) {
                            ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, cls9);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
                        linkedList = linkedList2;
                    } else {
                        str = concat;
                        linkedList = linkedList2;
                        str2 = "java/lang/String";
                    }
                    if (!z2) {
                        l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, "get", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", null, null);
                        k51[] Wwwwwwwwwwwwwwwwwwwwwwwwwww6 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
                        bv0[] bv0VarArr10 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int length6 = bv0VarArr10.length;
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < length6) {
                            bv0 bv0Var7 = bv0VarArr10[i15];
                            bv0[] bv0VarArr11 = bv0VarArr10;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 2);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, str2, AnnotationHandler.EQUAL, str9);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(153, Wwwwwwwwwwwwwwwwwwwwwwwwwww6[i16]);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 1);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            if (bv0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                str3 = str2;
                                str4 = str9;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            } else {
                                str3 = str2;
                                str4 = str9;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName(), o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                            }
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww6[i16]);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 0, (Object[]) null, 0, (Object[]) null);
                            i16++;
                            i15++;
                            bv0VarArr10 = bv0VarArr11;
                            str2 = str3;
                            str9 = str4;
                        }
                        Class<? extends Exception> cls10 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (cls10 != null) {
                            ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, cls10);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
                    }
                    l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, "newInstance", "()Ljava/lang/Object;", null, null);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, str6, "()V");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 1);
                    cls4 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 0, (Object[]) null, 0, (Object[]) null);
            cls2 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (cls2 == null) {
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
            String str92 = "(Ljava/lang/Object;)Z";
            if (z2) {
            }
            if (!z2) {
            }
            l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww62 = c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, "newInstance", "()Ljava/lang/Object;", null, null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww62.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww62.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww62.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, str6, "()V");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww62.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww62.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 1);
            cls4 = ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ev0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } else {
            str = concat;
            linkedList = linkedList2;
        }
        try {
            dv0<P> dv0Var2 = (dv0) cls4.newInstance();
            dv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0VarArr2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putIfAbsent(cls, dv0Var2);
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((dv0<?>) dv0Var2, fv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get((Class) it3.next()));
            }
            return dv0Var2;
        } catch (Exception e) {
            throw new RuntimeException("Error constructing accessor class: " + str, e);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dv0<?> dv0Var, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            bv0 bv0Var = dv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(entry.getValue());
            if (bv0Var != null) {
                hashMap2.put(entry.getValue(), bv0Var);
            }
        }
        dv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putAll(hashMap2);
    }

    public abstract Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, int i);

    public bv0[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0[] bv0VarArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bv0VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
        int length = bv0VarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bv0 bv0Var = bv0VarArr[i];
            bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var);
            i++;
            i2++;
        }
    }
}
