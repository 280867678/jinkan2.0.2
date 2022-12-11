package me.tvspark;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: i */
/* JADX WARN: Method from annotation default annotation not found: n */
/* JADX WARN: Method from annotation default annotation not found: s */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface rg0 {
    /* renamed from: c */
    String m188c() default "";

    /* renamed from: f */
    String m187f() default "";

    /* renamed from: l */
    int[] m186l() default {};

    /* renamed from: m */
    String m185m() default "";

    /* renamed from: v */
    int m184v() default 1;
}
