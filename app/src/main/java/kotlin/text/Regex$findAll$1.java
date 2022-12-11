package kotlin.text;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.kk0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class Regex$findAll$1 extends Lambda implements xg0<kk0> {
    public final /* synthetic */ CharSequence $input;
    public final /* synthetic */ int $startIndex;
    public final /* synthetic */ Regex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$findAll$1(Regex regex, CharSequence charSequence, int i) {
        super(0);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i;
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke  reason: collision with other method in class */
    public final kk0 mo4969invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
