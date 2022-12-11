package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.zj0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements ih0<zj0<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = new SequencesKt__SequencesKt$flatten$1();

    public SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final Iterator<T> mo4916invoke(zj0<? extends T> zj0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zj0Var, "it");
        return zj0Var.iterator();
    }
}
