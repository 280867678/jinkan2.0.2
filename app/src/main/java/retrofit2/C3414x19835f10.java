package retrofit2;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.of0;

@ef0
/* renamed from: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1 */
/* loaded from: classes5.dex */
public final class C3414x19835f10 extends Lambda implements ih0<Throwable, of0> {
    public final /* synthetic */ Call $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3414x19835f10(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ of0 mo4916invoke(Throwable th) {
        invoke2(th);
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
