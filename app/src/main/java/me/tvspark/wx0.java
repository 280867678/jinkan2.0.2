package me.tvspark;

import java.io.PrintStream;
import org.antlr.p055v4.runtime.RecognitionException;
import org.antlr.p055v4.runtime.Recognizer;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class wx0 extends qx0 {
    public static final wx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new wx0();

    @Override // me.tvspark.px0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, Object obj, int i, int i2, String str, RecognitionException recognitionException) {
        PrintStream printStream = System.err;
        printStream.println("line " + i + ":" + i2 + StringUtils.SPACE + str);
    }
}
