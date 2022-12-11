package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ff0;
import me.tvspark.gf0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements xg0<Iterator<? extends ff0>> {
    public final /* synthetic */ byte[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends ff0> mo4969invoke() {
        return new gf0(this.$this_withIndex);
    }
}
