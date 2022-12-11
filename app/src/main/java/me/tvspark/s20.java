package me.tvspark;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public final class s20 extends r20 {
    public static Class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Field Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public s20() {
        Object obj;
        Field field = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        try {
            field = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = field;
    }

    @Override // me.tvspark.r20
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AccessibleObject accessibleObject) {
        boolean z = false;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, accessibleObject, Long.valueOf(((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMethod("objectFieldOffset", Field.class).invoke(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).longValue()), true);
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }
}
