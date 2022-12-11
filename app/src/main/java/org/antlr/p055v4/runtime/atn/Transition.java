package org.antlr.p055v4.runtime.atn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import me.tvspark.a11;
import me.tvspark.c01;
import me.tvspark.dz0;
import me.tvspark.f01;
import me.tvspark.h01;
import me.tvspark.n01;
import me.tvspark.sy0;
import me.tvspark.tz0;
import me.tvspark.uy0;
import me.tvspark.wy0;
import me.tvspark.yz0;
import me.tvspark.zz0;

/* renamed from: org.antlr.v4.runtime.atn.Transition */
/* loaded from: classes4.dex */
public abstract class Transition {
    public sy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        Collections.unmodifiableList(Arrays.asList("INVALID", "EPSILON", "RANGE", "RULE", "PREDICATE", "ATOM", "ACTION", "SET", "NOT_SET", "WILDCARD", "PRECEDENCE"));
        Collections.unmodifiableMap(new HashMap<Class<? extends Transition>, Integer>() { // from class: org.antlr.v4.runtime.atn.Transition.1
            {
                put(dz0.class, 1);
                put(c01.class, 2);
                put(f01.class, 3);
                put(zz0.class, 4);
                put(wy0.class, 5);
                put(uy0.class, 6);
                put(h01.class, 7);
                put(tz0.class, 8);
                put(n01.class, 9);
                put(yz0.class, 10);
            }
        });
    }

    public Transition(sy0 sy0Var) {
        if (sy0Var != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sy0Var;
            return;
        }
        throw new NullPointerException("target cannot be null.");
    }

    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3);
}
