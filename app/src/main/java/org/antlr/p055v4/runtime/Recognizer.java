package org.antlr.p055v4.runtime;

import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.tvspark.cy0;
import me.tvspark.dy0;
import me.tvspark.iy0;
import me.tvspark.ly0;
import me.tvspark.px0;
import me.tvspark.ry0;
import me.tvspark.wx0;

/* renamed from: org.antlr.v4.runtime.Recognizer */
/* loaded from: classes4.dex */
public abstract class Recognizer<Symbol, ATNInterpreter extends ry0> {
    public ATNInterpreter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<px0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArrayList<px0>() { // from class: org.antlr.v4.runtime.Recognizer.1
        {
            add(wx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    };
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    static {
        new WeakHashMap();
        new WeakHashMap();
    }

    public abstract iy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public px0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new cy0(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public abstract ly0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dy0 dy0Var, int i) {
        return true;
    }
}
