package me.tvspark;

/* loaded from: classes4.dex */
public class ni0 {
    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i) {
        if (obj != null) {
            boolean z = false;
            if (obj instanceof cf0) {
                if ((obj instanceof hi0 ? ((hi0) obj).getArity() : obj instanceof xg0 ? 0 : obj instanceof ih0 ? 1 : obj instanceof mh0 ? 2 : obj instanceof nh0 ? 3 : obj instanceof oh0 ? 4 : obj instanceof ph0 ? 5 : obj instanceof qh0 ? 6 : obj instanceof rh0 ? 7 : obj instanceof sh0 ? 8 : obj instanceof th0 ? 9 : obj instanceof yg0 ? 10 : obj instanceof zg0 ? 11 : obj instanceof ah0 ? 12 : obj instanceof bh0 ? 13 : obj instanceof ch0 ? 14 : obj instanceof dh0 ? 15 : obj instanceof eh0 ? 16 : obj instanceof fh0 ? 17 : obj instanceof gh0 ? 18 : obj instanceof hh0 ? 19 : obj instanceof jh0 ? 20 : obj instanceof kh0 ? 21 : obj instanceof lh0 ? 22 : -1) == i) {
                    z = true;
                }
            }
            if (!z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "kotlin.jvm.functions.Function" + i);
                throw null;
            }
        }
        return obj;
    }

    public static ClassCastException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClassCastException classCastException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(classCastException, ni0.class.getName());
        throw classCastException;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ClassCastException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str)));
        throw null;
    }
}
