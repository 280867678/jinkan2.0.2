package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$flatMap$1 extends FunctionReferenceImpl implements ih0<Iterable<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE = new SequencesKt___SequencesKt$flatMap$1();

    public SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final Iterator<R> mo4916invoke(Iterable<? extends R> iterable) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "p1");
        return iterable.iterator();
    }
}
