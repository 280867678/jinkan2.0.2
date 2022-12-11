package okhttp3.internal.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.qi0;
import okhttp3.internal.cache.DiskLruCache;

@ef0
/* loaded from: classes4.dex */
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, qi0 {
    public final Iterator<DiskLruCache.Entry> delegate;
    public DiskLruCache.Snapshot nextSnapshot;
    public DiskLruCache.Snapshot removeSnapshot;
    public final /* synthetic */ DiskLruCache this$0;

    public DiskLruCache$snapshots$1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        Iterator<DiskLruCache.Entry> it = new ArrayList(diskLruCache.getLruEntries$okhttp().values()).iterator();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) it, "ArrayList(lruEntries.values).iterator()");
        this.delegate = it;
    }

    public final Iterator<DiskLruCache.Entry> getDelegate() {
        return this.delegate;
    }

    public final DiskLruCache.Snapshot getNextSnapshot() {
        return this.nextSnapshot;
    }

    public final DiskLruCache.Snapshot getRemoveSnapshot() {
        return this.removeSnapshot;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        DiskLruCache.Snapshot snapshot$okhttp;
        if (this.nextSnapshot != null) {
            return true;
        }
        synchronized (this.this$0) {
            if (this.this$0.getClosed$okhttp()) {
                return false;
            }
            while (this.delegate.hasNext()) {
                DiskLruCache.Entry next = this.delegate.next();
                if (next != null && next.getReadable$okhttp() && (snapshot$okhttp = next.snapshot$okhttp()) != null) {
                    this.nextSnapshot = snapshot$okhttp;
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.Iterator
    public DiskLruCache.Snapshot next() {
        if (hasNext()) {
            DiskLruCache.Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            if (snapshot != null) {
                return snapshot;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        DiskLruCache.Snapshot snapshot = this.removeSnapshot;
        if (snapshot != null) {
            try {
                this.this$0.remove(snapshot.key());
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.removeSnapshot = null;
                throw th;
            }
            this.removeSnapshot = null;
            return;
        }
        throw new IllegalStateException("remove() before next()".toString());
    }

    public final void setNextSnapshot(DiskLruCache.Snapshot snapshot) {
        this.nextSnapshot = snapshot;
    }

    public final void setRemoveSnapshot(DiskLruCache.Snapshot snapshot) {
        this.removeSnapshot = snapshot;
    }
}
