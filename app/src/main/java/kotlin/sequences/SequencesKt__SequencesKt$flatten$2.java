package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$flatten$2 extends Lambda implements ih0<Iterable<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$2 INSTANCE = new SequencesKt__SequencesKt$flatten$2();

    public SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final Iterator<T> mo4916invoke(Iterable<? extends T> iterable) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "it");
        return iterable.iterator();
    }
}
