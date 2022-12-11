package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements ih0<Integer, T> {
    public final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$elementAt$1(int i) {
        super(1);
        this.$index = i;
    }

    public final T invoke(int i) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sequence doesn't contain element at index ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.$index);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('.');
        throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4916invoke(Integer num) {
        return invoke(num.intValue());
    }
}
