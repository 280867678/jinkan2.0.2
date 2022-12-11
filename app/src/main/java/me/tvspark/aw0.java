package me.tvspark;

import java.io.IOException;
import java.util.Date;

/* loaded from: classes4.dex */
public class aw0 implements kw0<Date> {
    public aw0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        appendable.append('\"');
        qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Date) obj).toString(), appendable, ov0Var);
        appendable.append('\"');
    }
}
