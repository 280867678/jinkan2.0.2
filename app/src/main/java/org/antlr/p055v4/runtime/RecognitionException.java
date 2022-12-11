package org.antlr.p055v4.runtime;

import me.tvspark.a11;
import me.tvspark.by0;
import me.tvspark.dy0;
import me.tvspark.ey0;
import me.tvspark.yx0;

/* renamed from: org.antlr.v4.runtime.RecognitionException */
/* loaded from: classes4.dex */
public class RecognitionException extends RuntimeException {
    public final dy0 ctx;
    public final yx0 input;
    public int offendingState;
    public ey0 offendingToken;
    public final Recognizer<?, ?> recognizer;

    public RecognitionException(String str, Recognizer<?, ?> recognizer, yx0 yx0Var, by0 by0Var) {
        super(str);
        this.offendingState = -1;
        this.recognizer = recognizer;
        this.input = yx0Var;
        this.ctx = by0Var;
        if (recognizer != null) {
            this.offendingState = recognizer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public dy0 getCtx() {
        return this.ctx;
    }

    public a11 getExpectedTokens() {
        Recognizer<?, ?> recognizer = this.recognizer;
        if (recognizer != null) {
            return recognizer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.offendingState, this.ctx);
        }
        return null;
    }

    /* renamed from: getInputStream */
    public yx0 mo5113getInputStream() {
        return this.input;
    }

    public int getOffendingState() {
        return this.offendingState;
    }

    public ey0 getOffendingToken() {
        return this.offendingToken;
    }

    public Recognizer<?, ?> getRecognizer() {
        return this.recognizer;
    }

    public final void setOffendingState(int i) {
        this.offendingState = i;
    }

    public final void setOffendingToken(ey0 ey0Var) {
        this.offendingToken = ey0Var;
    }

    public RecognitionException(Recognizer<?, ?> recognizer, yx0 yx0Var, by0 by0Var) {
        this.offendingState = -1;
        this.recognizer = recognizer;
        this.input = yx0Var;
        this.ctx = by0Var;
        if (recognizer != null) {
            this.offendingState = recognizer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }
}
