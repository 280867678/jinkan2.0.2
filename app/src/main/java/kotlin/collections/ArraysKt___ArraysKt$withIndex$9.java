package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.wh0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class ArraysKt___ArraysKt$withIndex$9 extends Lambda implements xg0<Iterator<? extends Character>> {
    public final /* synthetic */ char[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$9(char[] cArr) {
        super(0);
        this.$this_withIndex = cArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends Character> mo4969invoke() {
        char[] cArr = this.$this_withIndex;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, "array");
        return new wh0(cArr);
    }
}
