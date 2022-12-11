package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements ih0<Object, Boolean> {
    public final /* synthetic */ Class $klass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesJvmKt$filterIsInstance$1(Class cls) {
        super(1);
        this.$klass = cls;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo4916invoke(Object obj) {
        return Boolean.valueOf(mo4916invoke(obj));
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Boolean, boolean] */
    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Boolean mo4916invoke(Object obj) {
        return this.$klass.isInstance(obj);
    }
}
