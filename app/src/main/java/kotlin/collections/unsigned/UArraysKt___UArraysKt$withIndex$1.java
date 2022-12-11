package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.hf0;
import me.tvspark.if0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class UArraysKt___UArraysKt$withIndex$1 extends Lambda implements xg0<Iterator<? extends hf0>> {
    public final /* synthetic */ int[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$1(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends hf0> mo4969invoke() {
        return new if0(this.$this_withIndex);
    }
}
