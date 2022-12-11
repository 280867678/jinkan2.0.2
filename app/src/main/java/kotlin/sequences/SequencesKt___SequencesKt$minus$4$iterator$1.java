package kotlin.sequences;

import java.util.HashSet;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$minus$4$iterator$1 extends Lambda implements ih0<T, Boolean> {
    public final /* synthetic */ HashSet $other;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$4$iterator$1(HashSet hashSet) {
        super(1);
        this.$other = hashSet;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo4916invoke(Object obj) {
        return Boolean.valueOf(mo4916invoke((SequencesKt___SequencesKt$minus$4$iterator$1) obj));
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Boolean, boolean] */
    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Boolean mo4916invoke(T t) {
        return this.$other.contains(t);
    }
}
