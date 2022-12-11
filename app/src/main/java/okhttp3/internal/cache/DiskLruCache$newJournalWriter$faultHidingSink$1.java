package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.of0;
import me.tvspark.pf0;

@ef0
/* loaded from: classes4.dex */
public final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends Lambda implements ih0<IOException, of0> {
    public final /* synthetic */ DiskLruCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        super(1);
        this.this$0 = diskLruCache;
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
        boolean holdsLock = Thread.holdsLock(this.this$0);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            this.this$0.hasJournalErrors = true;
            return;
        }
        throw new AssertionError("Assertion failed");
    }
}
