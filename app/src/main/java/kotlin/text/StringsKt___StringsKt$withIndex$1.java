package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.ok0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class StringsKt___StringsKt$withIndex$1 extends Lambda implements xg0<Iterator<? extends Character>> {
    public final /* synthetic */ CharSequence $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        super(0);
        this.$this_withIndex = charSequence;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Iterator<? extends Character> mo4969invoke() {
        CharSequence charSequence = this.$this_withIndex;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$iterator");
        return new ok0(charSequence);
    }
}
