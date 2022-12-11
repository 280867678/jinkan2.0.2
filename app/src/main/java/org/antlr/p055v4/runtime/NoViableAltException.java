package org.antlr.p055v4.runtime;

import me.tvspark.ay0;
import me.tvspark.by0;
import me.tvspark.ey0;
import me.tvspark.hy0;
import me.tvspark.ny0;

/* renamed from: org.antlr.v4.runtime.NoViableAltException */
/* loaded from: classes4.dex */
public class NoViableAltException extends RecognitionException {
    public final ny0 deadEndConfigs;
    public final ey0 startToken;

    public NoViableAltException(ay0 ay0Var) {
        this(ay0Var, ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(), ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(), null, ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public NoViableAltException(ay0 ay0Var, hy0 hy0Var, ey0 ey0Var, ey0 ey0Var2, ny0 ny0Var, by0 by0Var) {
        super(ay0Var, hy0Var, by0Var);
        this.deadEndConfigs = ny0Var;
        this.startToken = ey0Var;
        setOffendingToken(ey0Var2);
    }

    public ny0 getDeadEndConfigs() {
        return this.deadEndConfigs;
    }

    public ey0 getStartToken() {
        return this.startToken;
    }
}
