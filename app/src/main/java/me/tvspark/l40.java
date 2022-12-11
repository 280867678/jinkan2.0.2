package me.tvspark;

import com.jayway.jsonpath.internal.EvaluationAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class l40 implements k30 {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LoggerFactory.getLogger(l40.class);
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final w40 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public l40(w40 w40Var, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = w40Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public i30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2, b30 b30Var) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isDebugEnabled()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.debug("Evaluating path: {}", toString());
        }
        m40 m40Var = new m40(this, obj2, b30Var, false);
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww ? l30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2) : l30.Wwwwwwwwwwwwwwwwwwwwwww, obj, m40Var);
        } catch (EvaluationAbortException unused) {
        }
        return m40Var;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
