package me.tvspark;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class w51 {
    public static Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls.newInstance();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMethod("getUDID", Context.class);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMethod("getOAID", Context.class);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMethod("getVAID", Context.class);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }
}
