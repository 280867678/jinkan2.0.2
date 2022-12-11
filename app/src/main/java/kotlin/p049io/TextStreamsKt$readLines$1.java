package kotlin.p049io;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.of0;

@ef0
/* renamed from: kotlin.io.TextStreamsKt$readLines$1 */
/* loaded from: classes4.dex */
public final class TextStreamsKt$readLines$1 extends Lambda implements ih0<String, of0> {
    public final /* synthetic */ ArrayList $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextStreamsKt$readLines$1(ArrayList arrayList) {
        super(1);
        this.$result = arrayList;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ of0 mo4916invoke(String str) {
        invoke2(str);
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "it");
        this.$result.add(str);
    }
}
