package kotlin.jvm.internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.oi0;
import me.tvspark.outline;
import me.tvspark.tj0;
import me.tvspark.uj0;

@ef0
/* loaded from: classes4.dex */
public final class TypeReference$asString$args$1 extends Lambda implements ih0<uj0, CharSequence> {
    public final /* synthetic */ oi0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeReference$asString$args$1(oi0 oi0Var) {
        super(1);
        this.this$0 = oi0Var;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final CharSequence mo4916invoke(uj0 uj0Var) {
        StringBuilder sb;
        String str;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uj0Var, "it");
        if (this.this$0 != null) {
            if (uj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return "*";
            }
            tj0 tj0Var = uj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(tj0Var instanceof oi0)) {
                tj0Var = null;
            }
            if (((oi0) tj0Var) == null) {
                String valueOf = String.valueOf(uj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                KVariance kVariance = uj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (kVariance != null) {
                    int ordinal = kVariance.ordinal();
                    if (ordinal == 0) {
                        return valueOf;
                    }
                    if (ordinal == 1) {
                        sb = new StringBuilder();
                        str = "in ";
                    } else if (ordinal == 2) {
                        sb = new StringBuilder();
                        str = "out ";
                    }
                    return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str, valueOf);
                }
                throw new NoWhenBranchMatchedException();
            }
            throw null;
        }
        throw null;
    }
}
