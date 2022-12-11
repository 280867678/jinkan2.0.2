package kotlin.text;

import kotlin.jvm.internal.FunctionReferenceImpl;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.kk0;
import org.mozilla.javascript.ES6Iterator;

@ef0
/* loaded from: classes4.dex */
public final /* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements ih0<kk0, kk0> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    public Regex$findAll$2() {
        super(1, kk0.class, ES6Iterator.NEXT_METHOD, "next()Lkotlin/text/MatchResult;", 0);
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final kk0 mo4916invoke(kk0 kk0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kk0Var, "p1");
        return kk0Var.next();
    }
}
