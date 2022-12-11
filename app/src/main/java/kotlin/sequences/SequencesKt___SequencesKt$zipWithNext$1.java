package kotlin.sequences;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.mh0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$zipWithNext$1 extends Lambda implements mh0<T, T, Pair<? extends T, ? extends T>> {
    public static final SequencesKt___SequencesKt$zipWithNext$1 INSTANCE = new SequencesKt___SequencesKt$zipWithNext$1();

    public SequencesKt___SequencesKt$zipWithNext$1() {
        super(2);
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Pair<T, T> mo4918invoke(T t, T t2) {
        return new Pair<>(t, t2);
    }
}
