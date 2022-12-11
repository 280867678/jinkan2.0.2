package kotlin.text;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.nk0;

@ef0
/* loaded from: classes4.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements mh0<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$2(char[] cArr, boolean z) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> mo4918invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$receiver");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, this.$delimiters, i, this.$ignoreCase);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
            return null;
        }
        return new Pair<>(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), 1);
    }
}
