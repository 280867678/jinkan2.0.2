package kotlin.collections;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class AbstractCollection$toString$1 extends Lambda implements ih0<E, CharSequence> {
    public final /* synthetic */ AbstractCollection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractCollection$toString$1(AbstractCollection abstractCollection) {
        super(1);
        this.this$0 = abstractCollection;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final CharSequence mo4916invoke(E e) {
        return e == this.this$0 ? "(this Collection)" : String.valueOf(e);
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ CharSequence mo4916invoke(Object obj) {
        return mo4916invoke((AbstractCollection$toString$1) obj);
    }
}
