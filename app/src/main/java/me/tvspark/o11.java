package me.tvspark;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import me.tvspark.a21;
import me.tvspark.r11;
import me.tvspark.s11;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes4.dex */
public class o11 {
    public static volatile o11 Wwwwwwwwwwwwwwww;
    public final r11 Wwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public final ExecutorService Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final a21 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final m11 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final n11 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final w11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final s11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ThreadLocal<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    public final Map<Class<?>, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<Object, List<Class<?>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<Class<?>, CopyOnWriteArrayList<b21>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final p11 Wwwwwwwwwwwwwww = new p11();
    public static final Map<Class<?>, List<Class<?>>> Wwwwwwwwwwwwww = new HashMap();

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ThreadLocal<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o11 o11Var) {
        }

        @Override // java.lang.ThreadLocal
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww initialValue() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public o11() {
        Looper looper;
        r11 c21Var;
        Looper looper2;
        s11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        p11 p11Var = Wwwwwwwwwwwwwww;
        q11 q11Var = null;
        if (p11Var != null) {
            if (c21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                try {
                    looper = Looper.getMainLooper();
                } catch (RuntimeException unused) {
                    looper = null;
                }
                if (looper != null) {
                    c21Var = new c21("EventBus");
                    this.Wwwwwwwwwwwwwwwww = c21Var;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();
                    if (c21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        try {
                            looper2 = Looper.getMainLooper();
                        } catch (RuntimeException unused2) {
                            looper2 = null;
                        }
                        if (looper2 != null) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new s11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper2);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? new q11(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 10) : q11Var;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new n11(this);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new m11(this);
                            List<e21> list = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwww = list != null ? list.size() : 0;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new a21(p11Var.Wwwwwwwwwwwwwwwwwwwwwwwww, p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            return;
                        }
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? new q11(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 10) : q11Var;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new n11(this);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new m11(this);
                    List<e21> list2 = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwww = list2 != null ? list2.size() : 0;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new a21(p11Var.Wwwwwwwwwwwwwwwwwwwwwwwww, p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    return;
                }
            }
            c21Var = new r11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwww = c21Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();
            if (c21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? new q11(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 10) : q11Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new n11(this);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new m11(this);
            List<e21> list22 = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwww = list22 != null ? list22.size() : 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new a21(p11Var.Wwwwwwwwwwwwwwwwwwwwwwwww, p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = p11Var.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            return;
        }
        throw null;
    }

    public static o11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        o11 o11Var = Wwwwwwwwwwwwwwww;
        if (o11Var == null) {
            synchronized (o11.class) {
                o11Var = Wwwwwwwwwwwwwwww;
                if (o11Var == null) {
                    o11Var = new o11();
                    Wwwwwwwwwwwwwwww = o11Var;
                }
            }
        }
        return o11Var;
    }

    public static List<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
        ArrayList arrayList;
        synchronized (Wwwwwwwwwwwwww) {
            List<Class<?>> list = Wwwwwwwwwwwwww.get(cls);
            arrayList = list;
            if (list == null) {
                ArrayList arrayList2 = new ArrayList();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    arrayList2.add(cls2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList2, cls2.getInterfaces());
                }
                Wwwwwwwwwwwwww.put(cls, arrayList2);
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, cls.getInterfaces());
            }
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        List<Class<?>> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                CopyOnWriteArrayList<b21> copyOnWriteArrayList = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
                if (copyOnWriteArrayList != null) {
                    int size = copyOnWriteArrayList.size();
                    int i = 0;
                    while (i < size) {
                        b21 b21Var = copyOnWriteArrayList.get(i);
                        if (b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == obj) {
                            b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                            copyOnWriteArrayList.remove(i);
                            i--;
                            size--;
                        }
                        i++;
                    }
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(obj);
        } else {
            this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
        if (r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == r5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        List<z11> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        d21 d21Var;
        z11[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Class<?> cls = obj.getClass();
        a21 a21Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (a21Var != null) {
            List<z11> list = a21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
            if (list == null) {
                if (a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    a21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                } else {
                    a21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        d21 d21Var2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (d21Var2 != null && d21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                            d21Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        List<e21> list2 = a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (list2 != null) {
                            for (e21 e21Var : list2) {
                                d21 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = e21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
                                    d21Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                    break;
                                }
                            }
                        }
                        d21Var = null;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = d21Var;
                        if (d21Var != null) {
                            for (z11 z11Var : d21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(z11Var);
                                }
                            }
                        } else {
                            a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = a21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                }
                list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (list.isEmpty()) {
                    throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
                }
                a21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, list);
            }
            synchronized (this) {
                for (z11 z11Var2 : list) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, z11Var2);
                }
            }
            return;
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
        List<Object> list = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        list.add(obj);
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new EventBusException("Internal error. Abort state was not reset");
            }
            while (true) {
                try {
                    if (list.isEmpty()) {
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.remove(0), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } finally {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                }
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws Error {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Class<?> cls = obj.getClass();
        if (this.Wwwwwwwwwwwwwwwwwww) {
            List<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.size();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = false;
            for (int i = 0; i < size; i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 |= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.get(i));
            }
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cls);
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                r11 r11Var = this.Wwwwwwwwwwwwwwwww;
                Level level = Level.FINE;
                r11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(level, "No subscribers registered for event " + cls);
            }
            if (!this.Wwwwwwwwwwwwwwwwwwww || cls == t11.class || cls == y11.class) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new t11(this, obj));
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21 b21Var, Object obj) {
        try {
            b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.invoke(b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(obj instanceof y11)) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    throw new EventBusException("Invoking subscriber failed", cause);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    r11 r11Var = this.Wwwwwwwwwwwwwwwww;
                    Level level = Level.SEVERE;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not dispatch event: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj.getClass());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" to subscribing class ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClass());
                    r11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(level, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), cause);
                }
                if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new y11(this, cause, obj, b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            } else {
                r11 r11Var2 = this.Wwwwwwwwwwwwwwwww;
                Level level2 = Level.SEVERE;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SubscriberExceptionEvent subscriber ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClass());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" threw an exception");
                r11Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(level2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), cause);
                y11 y11Var = (y11) obj;
                r11 r11Var3 = this.Wwwwwwwwwwwwwwwww;
                Level level3 = Level.SEVERE;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Initial event ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(y11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(" caused exception in ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(y11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                r11Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(level3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString(), y11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r5 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21 b21Var, Object obj, boolean z) {
        w11 w11Var;
        int ordinal = b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    w11Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else if (ordinal != 3) {
                    if (ordinal == 4) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj);
                        return;
                    }
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown thread mode: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                } else if (z) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj);
                    return;
                }
            } else if (!z) {
                w11Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                w11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj);
                return;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u11 u11Var) {
        Object obj = u11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        b21 b21Var = u11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        u11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u11Var);
        if (b21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj);
        }
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(obj);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Class<?> cls) {
        CopyOnWriteArrayList<b21> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<b21> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b21 next = it.next();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, obj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return true;
                }
            } finally {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("EventBus[indexCount=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", eventInheritance=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        s11 s11Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (s11Var != null) {
            if (!(((s11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) s11Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Looper.myLooper())) {
                return false;
            }
        }
        return true;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, z11 z11Var) {
        Object value;
        Class<?> cls = z11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        b21 b21Var = new b21(obj, z11Var);
        CopyOnWriteArrayList<b21> copyOnWriteArrayList = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(b21Var)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Subscriber ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj.getClass());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" already registered to event ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls);
            throw new EventBusException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || z11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > copyOnWriteArrayList.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                copyOnWriteArrayList.add(i, b21Var);
                break;
            }
        }
        List<Class<?>> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(obj, list);
        }
        list.add(cls);
        if (z11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!this.Wwwwwwwwwwwwwwwwwww) {
                Object obj2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
                if (obj2 == null) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey()) && (value = entry.getValue()) != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, value, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
            }
        }
    }
}
