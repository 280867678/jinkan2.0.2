package kotlin.coroutines;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.og0;

@ef0
/* loaded from: classes4.dex */
public final class CombinedContext$toString$1 extends Lambda implements mh0<String, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    public CombinedContext$toString$1() {
        super(2);
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final String mo4918invoke(String str, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "acc");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "element");
        if (str.length() == 0) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return str + ", " + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
