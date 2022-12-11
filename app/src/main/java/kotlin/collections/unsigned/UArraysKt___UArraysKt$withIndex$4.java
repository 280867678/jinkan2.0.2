package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.mf0;
import me.tvspark.nf0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class UArraysKt___UArraysKt$withIndex$4 extends Lambda implements xg0<Iterator<? extends mf0>> {
    public final /* synthetic */ short[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$4(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends mf0> mo4969invoke() {
        return new nf0(this.$this_withIndex);
    }
}
