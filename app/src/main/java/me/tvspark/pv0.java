package me.tvspark;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class pv0 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements jv0 {
        @Override // me.tvspark.jv0
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Field field, Method method) {
            sv0 sv0Var = (sv0) method.getAnnotation(sv0.class);
            return sv0Var == null || !sv0Var.value();
        }
    }
}
