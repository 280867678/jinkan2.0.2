package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;
import me.tvspark.outline;
import org.apache.http.pool.PoolEntry;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* loaded from: classes4.dex */
public abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    public final T route;
    public final Set<E> leased = new HashSet();
    public final LinkedList<E> available = new LinkedList<>();
    public final LinkedList<Future<E>> pending = new LinkedList<>();

    public RouteSpecificPool(T t) {
        this.route = t;
    }

    public E add(C c) {
        E createEntry = createEntry(c);
        this.leased.add(createEntry);
        return createEntry;
    }

    public abstract E createEntry(C c);

    public void free(E e, boolean z) {
        Args.notNull(e, "Pool entry");
        Asserts.check(this.leased.remove(e), "Entry %s has not been leased from this pool", e);
        if (z) {
            this.available.addFirst(e);
        }
    }

    public int getAllocatedCount() {
        return this.leased.size() + this.available.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public E getFree(Object obj) {
        if (!this.available.isEmpty()) {
            if (obj != null) {
                Iterator<E> it = this.available.iterator();
                while (it.hasNext()) {
                    E next = it.next();
                    if (obj.equals(next.getState())) {
                        it.remove();
                        this.leased.add(next);
                        return next;
                    }
                }
            }
            Iterator<E> it2 = this.available.iterator();
            while (it2.hasNext()) {
                E next2 = it2.next();
                if (next2.getState() == null) {
                    it2.remove();
                    this.leased.add(next2);
                    return next2;
                }
            }
            return null;
        }
        return null;
    }

    public E getLastUsed() {
        if (!this.available.isEmpty()) {
            return this.available.getLast();
        }
        return null;
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public final T getRoute() {
        return this.route;
    }

    public Future<E> nextPending() {
        return this.pending.poll();
    }

    public void queue(Future<E> future) {
        if (future == null) {
            return;
        }
        this.pending.add(future);
    }

    public boolean remove(E e) {
        Args.notNull(e, "Pool entry");
        return this.available.remove(e) || this.leased.remove(e);
    }

    public void shutdown() {
        Iterator<Future<E>> it = this.pending.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.pending.clear();
        Iterator<E> it2 = this.available.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
        this.available.clear();
        for (E e : this.leased) {
            e.close();
        }
        this.leased.clear();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[route: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.route);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("][leased: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.leased.size());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("][available: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.available.size());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("][pending: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pending.size());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public void unqueue(Future<E> future) {
        if (future == null) {
            return;
        }
        this.pending.remove(future);
    }
}
