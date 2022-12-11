package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.jf0;
import me.tvspark.kf0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements xg0<Iterator<? extends jf0>> {
    public final /* synthetic */ long[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends jf0> mo4969invoke() {
        return new kf0(this.$this_withIndex);
    }
}
