package com.google.common.base;

import me.tvspark.C2536qt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Predicates$ContainsPatternFromStringPredicate extends Predicates$ContainsPatternPredicate {
    public static final long serialVersionUID = 0;

    public Predicates$ContainsPatternFromStringPredicate(String str) {
        super(C2536qt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    @Override // com.google.common.base.Predicates$ContainsPatternPredicate
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Predicates.containsPattern(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pattern.pattern());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
