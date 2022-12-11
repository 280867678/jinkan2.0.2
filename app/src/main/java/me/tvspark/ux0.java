package me.tvspark;

import org.antlr.p055v4.runtime.CommonToken;
import org.antlr.p055v4.runtime.misc.Pair;

/* loaded from: classes4.dex */
public class ux0 implements fy0<CommonToken> {
    public static final fy0<CommonToken> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ux0();
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Pair pair, int i, String str, int i2, int i3, int i4, int i5, int i6) {
        B b;
        CommonToken commonToken = new CommonToken(pair, i, i2, i3, i4);
        commonToken.setLine(i5);
        commonToken.setCharPositionInLine(i6);
        if (str != null) {
            commonToken.setText(str);
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (b = pair.f4544b) != 0) {
            commonToken.setText(((sx0) b).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i4)));
        }
        return commonToken;
    }
}
