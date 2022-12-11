package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$generateSequence$2 extends Lambda implements xg0<T> {
    public final /* synthetic */ Object $seed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$generateSequence$2(Object obj) {
        super(0);
        this.$seed = obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    @Override // me.tvspark.xg0
    /* renamed from: invoke */
    public final T mo4969invoke() {
        return this.$seed;
    }
}
