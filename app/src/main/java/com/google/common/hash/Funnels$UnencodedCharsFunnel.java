package com.google.common.hash;

import me.tvspark.AbstractC2387my;
import me.tvspark.AbstractC2652ty;

/* loaded from: classes3.dex */
public enum Funnels$UnencodedCharsFunnel implements Funnel<CharSequence> {
    INSTANCE;

    @Override // com.google.common.hash.Funnel
    public void funnel(CharSequence charSequence, AbstractC2652ty abstractC2652ty) {
        AbstractC2387my abstractC2387my = (AbstractC2387my) abstractC2652ty;
        if (abstractC2387my != null) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                abstractC2387my.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.charAt(i));
            }
            return;
        }
        throw null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.unencodedCharsFunnel()";
    }
}
