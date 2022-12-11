package me.tvspark;

import java.io.IOException;
import java.util.Iterator;

/* renamed from: me.tvspark.mt */
/* loaded from: classes4.dex */
public class C2382mt {
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                while (true) {
                    sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next()));
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public C2382mt(String str) {
        if (str != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            return;
        }
        throw null;
    }

    public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (obj != null) {
            return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
        }
        throw null;
    }
}
