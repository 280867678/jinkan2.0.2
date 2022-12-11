package me.tvspark;

import java.util.IdentityHashMap;
import java.util.UUID;
import org.antlr.p055v4.runtime.atn.ATNDeserializer;

/* loaded from: classes4.dex */
public abstract class ry0 {
    public static final r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final b01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ly0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        int i = ATNDeserializer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        UUID uuid = ATNDeserializer.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        r01 r01Var = new r01(new ny0(true));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r01Var;
        r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
    }

    public ry0(ly0 ly0Var, b01 b01Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ly0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b01Var;
    }

    public a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01 a01Var) {
        a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        b01 b01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (b01Var == null) {
            return a01Var;
        }
        synchronized (b01Var) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new IdentityHashMap());
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
}
