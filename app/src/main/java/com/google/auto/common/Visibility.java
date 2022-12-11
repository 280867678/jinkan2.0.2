package com.google.auto.common;

import com.google.common.base.Enums;
import com.google.common.collect.Ordering;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

/* loaded from: classes3.dex */
public enum Visibility {
    PRIVATE,
    DEFAULT,
    PROTECTED,
    PUBLIC;
    
    public static final ElementKind MODULE = (ElementKind) Enums.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ElementKind.class, "MODULE").orNull();

    public static Visibility effectiveVisibilityOfElement(Element element) {
        if (element != null) {
            Visibility visibility = PUBLIC;
            while (element != null) {
                visibility = (Visibility) Ordering.natural().min(visibility, ofElement(element));
                element = element.getEnclosingElement();
            }
            return visibility;
        }
        throw null;
    }

    public static Visibility ofElement(Element element) {
        if (element != null) {
            if (element.getKind().equals(ElementKind.PACKAGE) || element.getKind().equals(MODULE)) {
                return PUBLIC;
            }
            Set modifiers = element.getModifiers();
            return modifiers.contains(Modifier.PRIVATE) ? PRIVATE : modifiers.contains(Modifier.PROTECTED) ? PROTECTED : modifiers.contains(Modifier.PUBLIC) ? PUBLIC : DEFAULT;
        }
        throw null;
    }
}
