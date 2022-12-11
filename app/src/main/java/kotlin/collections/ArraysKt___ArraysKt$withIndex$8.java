package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.uh0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class ArraysKt___ArraysKt$withIndex$8 extends Lambda implements xg0<Iterator<? extends Boolean>> {
    public final /* synthetic */ boolean[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$8(boolean[] zArr) {
        super(0);
        this.$this_withIndex = zArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends Boolean> mo4969invoke() {
        boolean[] zArr = this.$this_withIndex;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr, "array");
        return new uh0(zArr);
    }
}
