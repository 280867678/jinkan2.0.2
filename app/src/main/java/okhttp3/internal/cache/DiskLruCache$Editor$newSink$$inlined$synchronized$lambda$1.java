package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.of0;
import okhttp3.internal.cache.DiskLruCache;

@ef0
/* loaded from: classes4.dex */
public final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends Lambda implements ih0<IOException, of0> {
    public final /* synthetic */ int $index$inlined;
    public final /* synthetic */ DiskLruCache.Editor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(DiskLruCache.Editor editor, int i) {
        super(1);
        this.this$0 = editor;
        this.$index$inlined = i;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ of0 mo4916invoke(IOException iOException) {
        invoke2(iOException);
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "it");
        synchronized (this.this$0.this$0) {
            this.this$0.detach$okhttp();
        }
    }
}
