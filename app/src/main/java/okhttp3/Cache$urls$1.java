package okhttp3;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.qi0;
import me.tvspark.r40;
import okhttp3.internal.cache.DiskLruCache;

@ef0
/* loaded from: classes4.dex */
public final class Cache$urls$1 implements Iterator<String>, qi0 {
    public boolean canRemove;
    public final Iterator<DiskLruCache.Snapshot> delegate;
    public String nextUrl;
    public final /* synthetic */ Cache this$0;

    public Cache$urls$1(Cache cache) {
        this.this$0 = cache;
        this.delegate = cache.getCache$okhttp().snapshots();
    }

    public final boolean getCanRemove() {
        return this.canRemove;
    }

    public final Iterator<DiskLruCache.Snapshot> getDelegate() {
        return this.delegate;
    }

    public final String getNextUrl() {
        return this.nextUrl;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextUrl != null) {
            return true;
        }
        this.canRemove = false;
        while (this.delegate.hasNext()) {
            try {
                DiskLruCache.Snapshot next = this.delegate.next();
                this.nextUrl = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.getSource(0)).Wwwwwwwwwwwwwwwwwwwwwwwww();
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, (Throwable) null);
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public String next() {
        if (hasNext()) {
            String str = this.nextUrl;
            if (str == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.canRemove) {
            this.delegate.remove();
            return;
        }
        throw new IllegalStateException("remove() before next()".toString());
    }

    public final void setCanRemove(boolean z) {
        this.canRemove = z;
    }

    public final void setNextUrl(String str) {
        this.nextUrl = str;
    }
}
