package me.tvspark;

import java.util.BitSet;
import java.util.Collection;
import org.antlr.p055v4.runtime.RecognitionException;
import org.antlr.p055v4.runtime.Recognizer;

/* loaded from: classes4.dex */
public class cy0 implements px0 {
    public final Collection<? extends px0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public cy0(Collection<? extends px0> collection) {
        if (collection != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = collection;
            return;
        }
        throw new NullPointerException("delegates");
    }

    @Override // me.tvspark.px0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ay0 ay0Var, p01 p01Var, int i, int i2, int i3, ny0 ny0Var) {
        for (px0 px0Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            px0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ay0Var, p01Var, i, i2, i3, ny0Var);
        }
    }

    @Override // me.tvspark.px0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ay0 ay0Var, p01 p01Var, int i, int i2, BitSet bitSet, ny0 ny0Var) {
        for (px0 px0Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            px0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ay0Var, p01Var, i, i2, bitSet, ny0Var);
        }
    }

    @Override // me.tvspark.px0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ay0 ay0Var, p01 p01Var, int i, int i2, boolean z, BitSet bitSet, ny0 ny0Var) {
        for (px0 px0Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            px0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ay0Var, p01Var, i, i2, z, bitSet, ny0Var);
        }
    }

    @Override // me.tvspark.px0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, Object obj, int i, int i2, String str, RecognitionException recognitionException) {
        for (px0 px0Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            px0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recognizer, obj, i, i2, str, recognitionException);
        }
    }
}
