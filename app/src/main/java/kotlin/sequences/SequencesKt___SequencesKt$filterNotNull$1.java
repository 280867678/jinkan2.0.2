package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$filterNotNull$1 extends Lambda implements ih0<T, Boolean> {
    public static final SequencesKt___SequencesKt$filterNotNull$1 INSTANCE = new SequencesKt___SequencesKt$filterNotNull$1();

    public SequencesKt___SequencesKt$filterNotNull$1() {
        super(1);
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo4916invoke(Object obj) {
        return Boolean.valueOf(mo4916invoke((SequencesKt___SequencesKt$filterNotNull$1) obj));
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Boolean mo4916invoke(T t) {
        return t == 0 ? 1 : null;
    }
}
