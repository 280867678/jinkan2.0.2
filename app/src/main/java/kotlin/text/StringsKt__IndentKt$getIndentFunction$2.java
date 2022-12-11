package kotlin.text;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements ih0<String, String> {
    public final /* synthetic */ String $indent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$getIndentFunction$2(String str) {
        super(1);
        this.$indent = str;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final String mo4916invoke(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "line");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.$indent, str);
    }
}
