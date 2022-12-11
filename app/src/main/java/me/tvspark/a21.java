package me.tvspark;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes4.dex */
public class a21 {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<e21> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Map<Class<?>, List<z11>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[4];

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public d21 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<z11> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        public final Map<Class, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
        public final Map<String, Class> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
        public final StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder(128);

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Method method, Class<?> cls) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLength(0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(method.getName());
            StringBuilder sb = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(sb2, put);
            return false;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Class<? super Object> superclass = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuperclass();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = superclass;
                String name = superclass.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.") && !name.startsWith("androidx.")) {
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Method method, Class<?> cls) {
            Object put = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Method) put, cls)) {
                    throw new IllegalStateException();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, this);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, cls);
        }
    }

    public a21(List<e21> list, boolean z, boolean z2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
    }

    public final List<z11> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ArrayList arrayList = new ArrayList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        int i = 0;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLength(0);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            while (true) {
                if (i >= 4) {
                    break;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            for (int i = 0; i < 4; i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = null;
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Method[] methods;
        try {
            try {
                methods = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMethods();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        x11 x11Var = (x11) method.getAnnotation(x11.class);
                        if (x11Var != null) {
                            Class<?> cls = parameterTypes[0];
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, cls)) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new z11(method, cls, x11Var.threadMode(), x11Var.priority(), x11Var.sticky()));
                            }
                        }
                    } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && method.isAnnotationPresent(x11.class)) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("@Subscribe method ", method.getDeclaringClass().getName() + "." + method.getName(), "must have exactly 1 parameter but has ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(parameterTypes.length);
                        throw new EventBusException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && method.isAnnotationPresent(x11.class)) {
                    throw new EventBusException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method.getDeclaringClass().getName() + "." + method.getName(), " is a illegal @Subscribe method: must be public, non-static, and non-abstract"));
                }
            }
        } catch (LinkageError e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not inspect methods of ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName());
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(z ? ". Please consider using EventBus annotation processor to avoid reflection." : ". Please make this class visible to EventBus annotation processor to avoid reflection.");
            throw new EventBusException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), e);
        }
    }
}
