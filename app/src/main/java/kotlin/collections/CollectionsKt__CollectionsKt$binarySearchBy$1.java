package kotlin.collections;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.r40;

@ef0
/* loaded from: classes4.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements ih0<T, Integer> {
    public final /* synthetic */ Comparable $key;
    public final /* synthetic */ ih0 $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(ih0 ih0Var, Comparable comparable) {
        super(1);
        this.$selector = ih0Var;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r2v3, types: [int, java.lang.Integer] */
    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final Integer mo4916invoke(T t) {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparable) this.$selector.mo4916invoke(t), this.$key);
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Integer mo4916invoke(Object obj) {
        return Integer.valueOf(mo4916invoke((CollectionsKt__CollectionsKt$binarySearchBy$1) obj));
    }
}
