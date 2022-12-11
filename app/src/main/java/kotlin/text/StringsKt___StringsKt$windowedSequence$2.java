package kotlin.text;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements ih0<Integer, R> {
    public final /* synthetic */ int $size;
    public final /* synthetic */ CharSequence $this_windowedSequence;
    public final /* synthetic */ ih0 $transform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt___StringsKt$windowedSequence$2(CharSequence charSequence, int i, ih0 ih0Var) {
        super(1);
        this.$this_windowedSequence = charSequence;
        this.$size = i;
        this.$transform = ih0Var;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [R, java.lang.Object] */
    public final R invoke(int i) {
        int i2 = this.$size + i;
        if (i2 < 0 || i2 > this.$this_windowedSequence.length()) {
            i2 = this.$this_windowedSequence.length();
        }
        return this.$transform.mo4916invoke(this.$this_windowedSequence.subSequence(i, i2));
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4916invoke(Integer num) {
        return invoke(num.intValue());
    }
}
