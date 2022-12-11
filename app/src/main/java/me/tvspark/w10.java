package me.tvspark;

import java.lang.reflect.Modifier;

/* loaded from: classes4.dex */
public abstract class w10 {
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Interface can't be instantiated! Interface name: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
            throw new UnsupportedOperationException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (!Modifier.isAbstract(modifiers)) {
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Abstract class can't be instantiated! Class name: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getName());
            throw new UnsupportedOperationException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    public abstract <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<T> cls) throws Exception;
}
