package com.squareup.javapoet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import javax.lang.model.element.Modifier;
import me.tvspark.m50;

/* loaded from: classes3.dex */
public enum TypeSpec$Kind {
    CLASS(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet()),
    INTERFACE(m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.STATIC))),
    ENUM(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC)),
    ANNOTATION(m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), m50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(Modifier.STATIC)));
    
    public final Set<Modifier> asMemberModifiers;
    public final Set<Modifier> implicitFieldModifiers;
    public final Set<Modifier> implicitMethodModifiers;
    public final Set<Modifier> implicitTypeModifiers;

    TypeSpec$Kind(Set set, Set set2, Set set3, Set set4) {
        this.implicitFieldModifiers = set;
        this.implicitMethodModifiers = set2;
        this.implicitTypeModifiers = set3;
        this.asMemberModifiers = set4;
    }
}
