package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.vh0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class ArraysKt___ArraysKt$withIndex$2 extends Lambda implements xg0<Iterator<? extends Byte>> {
    public final /* synthetic */ byte[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$2(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends Byte> mo4969invoke() {
        byte[] bArr = this.$this_withIndex;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "array");
        return new vh0(bArr);
    }
}
