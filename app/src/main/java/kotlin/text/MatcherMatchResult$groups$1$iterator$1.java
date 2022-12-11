package kotlin.text;

import java.util.regex.Matcher;
import kotlin.jvm.internal.Lambda;
import me.tvspark.bj0;
import me.tvspark.ef0;
import me.tvspark.fj0;
import me.tvspark.hk0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.lk0;

@ef0
/* loaded from: classes4.dex */
public final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements ih0<Integer, hk0> {
    public final /* synthetic */ lk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatcherMatchResult$groups$1$iterator$1(lk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(1);
        this.this$0 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ hk0 mo4916invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final hk0 invoke(int i) {
        lk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.this$0;
        Matcher matcher = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        bj0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.start(i), matcher.end(i));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue() >= 0) {
            String group = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.group(i);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group, "matchResult.group(index)");
            return new hk0(group, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return null;
    }
}
