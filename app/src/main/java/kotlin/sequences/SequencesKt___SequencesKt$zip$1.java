package kotlin.sequences;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.mh0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$zip$1 extends Lambda implements mh0<T, R, Pair<? extends T, ? extends R>> {
    public static final SequencesKt___SequencesKt$zip$1 INSTANCE = new SequencesKt___SequencesKt$zip$1();

    public SequencesKt___SequencesKt$zip$1() {
        super(2);
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4918invoke(Object obj, Object obj2) {
        return mo4918invoke((SequencesKt___SequencesKt$zip$1) obj, obj2);
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Pair<T, R> mo4918invoke(T t, R r) {
        return new Pair<>(t, r);
    }
}
