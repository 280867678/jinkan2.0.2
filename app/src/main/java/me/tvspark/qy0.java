package me.tvspark;

import org.antlr.p055v4.runtime.atn.ATNDeserializer;

/* loaded from: classes4.dex */
public final class qy0 implements ATNDeserializer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    @Override // org.antlr.p055v4.runtime.atn.ATNDeserializer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char[] cArr, int i) {
        return (cArr[i + 1] << 16) | cArr[i];
    }

    @Override // org.antlr.p055v4.runtime.atn.ATNDeserializer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public int size() {
        return 2;
    }
}
