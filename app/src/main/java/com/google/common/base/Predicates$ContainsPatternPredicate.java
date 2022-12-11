package com.google.common.base;

import com.google.common.base.JdkPattern;
import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.AbstractC2234it;
import me.tvspark.AbstractC2573rt;
import me.tvspark.C2456ot;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Predicates$ContainsPatternPredicate implements AbstractC2573rt<CharSequence>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2234it pattern;

    public Predicates$ContainsPatternPredicate(AbstractC2234it abstractC2234it) {
        if (abstractC2234it != null) {
            this.pattern = abstractC2234it;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(CharSequence charSequence) {
        return ((JdkPattern.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.pattern.matcher(charSequence)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.find();
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj instanceof Predicates$ContainsPatternPredicate) {
            Predicates$ContainsPatternPredicate predicates$ContainsPatternPredicate = (Predicates$ContainsPatternPredicate) obj;
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.pattern.pattern(), predicates$ContainsPatternPredicate.pattern.pattern()) && this.pattern.flags() == predicates$ContainsPatternPredicate.pattern.flags();
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
    }

    public String toString() {
        C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this.pattern);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pattern", this.pattern.pattern());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pattern.flags", this.pattern.flags());
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Predicates.contains(", Wwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), ")");
    }
}
