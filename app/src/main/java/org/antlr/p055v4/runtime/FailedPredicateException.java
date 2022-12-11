package org.antlr.p055v4.runtime;

import java.util.Locale;
import me.tvspark.ay0;
import me.tvspark.ty0;
import me.tvspark.vz0;
import me.tvspark.zz0;

/* renamed from: org.antlr.v4.runtime.FailedPredicateException */
/* loaded from: classes4.dex */
public class FailedPredicateException extends RecognitionException {
    public final String predicate;
    public final int predicateIndex;
    public final int ruleIndex;

    public FailedPredicateException(ay0 ay0Var) {
        this(ay0Var, null);
    }

    public FailedPredicateException(ay0 ay0Var, String str) {
        this(ay0Var, str, null);
    }

    public FailedPredicateException(ay0 ay0Var, String str, String str2) {
        super(formatMessage(str, str2), ay0Var, ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ty0 ty0Var = (ty0) ((vz0) ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        if (ty0Var instanceof zz0) {
            zz0 zz0Var = (zz0) ty0Var;
            this.ruleIndex = zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.predicateIndex = zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            this.ruleIndex = 0;
            this.predicateIndex = 0;
        }
        this.predicate = str;
        setOffendingToken(ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public static String formatMessage(String str, String str2) {
        return str2 != null ? str2 : String.format(Locale.getDefault(), "failed predicate: {%s}?", str);
    }

    public int getPredIndex() {
        return this.predicateIndex;
    }

    public String getPredicate() {
        return this.predicate;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }
}
