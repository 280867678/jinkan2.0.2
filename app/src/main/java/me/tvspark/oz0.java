package me.tvspark;

import java.util.EmptyStackException;
import org.antlr.p055v4.runtime.atn.LexerActionType;

/* loaded from: classes4.dex */
public final class oz0 implements hz0 {
    public static final oz0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new oz0();

    @Override // me.tvspark.hz0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zx0 zx0Var) {
        if (!(zx0Var.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0)) {
            y01 y01Var = zx0Var.Wwwwwwwwwwwwwwwwwwwww;
            int i = y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            if (i2 >= 0 && i2 < i) {
                int[] iArr = y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = iArr[i2];
                System.arraycopy(iArr, i2 + 1, iArr, i2, (i - i2) - 1);
                int[] iArr2 = y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                iArr2[i4] = 0;
                y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                zx0Var.Wwwwwwwwwwwwwwwwwwww = i3;
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new EmptyStackException();
    }

    @Override // me.tvspark.hz0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        LexerActionType lexerActionType = LexerActionType.POP_MODE;
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 4), 1);
    }

    public String toString() {
        return "popMode";
    }
}
