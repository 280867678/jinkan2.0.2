package kotlin.text;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.gk0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class RegexKt$fromInt$$inlined$apply$lambda$1 extends Lambda implements ih0<T, Boolean> {
    public final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$$inlined$apply$lambda$1(int i) {
        super(1);
        this.$value$inlined = i;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo4916invoke(Object obj) {
        return Boolean.valueOf(invoke((Enum) obj));
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    public final boolean invoke(Enum r3) {
        gk0 gk0Var = (gk0) r3;
        return (this.$value$inlined & gk0Var.getMask()) == gk0Var.getValue();
    }
}
