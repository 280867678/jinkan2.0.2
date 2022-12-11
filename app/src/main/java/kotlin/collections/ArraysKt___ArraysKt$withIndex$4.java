package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.xg0;
import me.tvspark.zh0;

@ef0
/* loaded from: classes4.dex */
public final class ArraysKt___ArraysKt$withIndex$4 extends Lambda implements xg0<Iterator<? extends Integer>> {
    public final /* synthetic */ int[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$4(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends Integer> mo4969invoke() {
        int[] iArr = this.$this_withIndex;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, "array");
        return new zh0(iArr);
    }
}
