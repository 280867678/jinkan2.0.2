package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.r40;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements xg0<Iterator<? extends T>> {
    public final /* synthetic */ Object[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$1(Object[] objArr) {
        super(0);
        this.$this_withIndex = objArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<T> mo4969invoke() {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.$this_withIndex);
    }
}
