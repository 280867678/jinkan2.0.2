package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.bi0;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class ArraysKt___ArraysKt$withIndex$5 extends Lambda implements xg0<Iterator<? extends Long>> {
    public final /* synthetic */ long[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$5(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends Long> mo4969invoke() {
        long[] jArr = this.$this_withIndex;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, "array");
        return new bi0(jArr);
    }
}
