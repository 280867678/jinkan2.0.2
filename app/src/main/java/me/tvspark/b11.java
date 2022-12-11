package me.tvspark;

/* loaded from: classes4.dex */
public final class b11 extends s01<Object> {
    public static final b11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new b11();

    @Override // me.tvspark.s01
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // me.tvspark.s01
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
