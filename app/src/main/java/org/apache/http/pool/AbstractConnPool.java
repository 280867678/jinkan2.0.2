package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.tvspark.outline;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.pool.PoolEntry;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes4.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    public final Condition condition;
    public final ConnFactory<T, C> connFactory;
    public volatile int defaultMaxPerRoute;
    public volatile boolean isShutDown;
    public final Lock lock;
    public volatile int maxTotal;
    public volatile int validateAfterInactivity;
    public final Map<T, RouteSpecificPool<T, C, E>> routeToPool = new HashMap();
    public final Set<E> leased = new HashSet();
    public final LinkedList<E> available = new LinkedList<>();
    public final LinkedList<Future<E>> pending = new LinkedList<>();
    public final Map<T, Integer> maxPerRoute = new HashMap();

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i, int i2) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(i, "Max per route value");
        this.maxTotal = Args.positive(i2, "Max total value");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    private int getMax(T t) {
        Integer num = this.maxPerRoute.get(t);
        return num != null ? num.intValue() : this.defaultMaxPerRoute;
    }

    private RouteSpecificPool<T, C, E> getPool(final T t) {
        RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(t);
        if (routeSpecificPool == null) {
            RouteSpecificPool<T, C, E> routeSpecificPool2 = (RouteSpecificPool<T, C, E>) new RouteSpecificPool<T, C, E>(t) { // from class: org.apache.http.pool.AbstractConnPool.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // org.apache.http.pool.RouteSpecificPool
                public E createEntry(C c) {
                    return (E) AbstractConnPool.this.createEntry(t, c);
                }
            };
            this.routeToPool.put(t, routeSpecificPool2);
            return routeSpecificPool2;
        }
        return routeSpecificPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public E getPoolEntryBlocking(T t, Object obj, long j, TimeUnit timeUnit, Future<E> future) throws IOException, InterruptedException, TimeoutException {
        E e;
        Date date = j > 0 ? new Date(timeUnit.toMillis(j) + System.currentTimeMillis()) : null;
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(t);
            while (true) {
                boolean z = true;
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                while (true) {
                    e = (E) pool.getFree(obj);
                    if (e == null) {
                        break;
                    }
                    if (e.isExpired(System.currentTimeMillis())) {
                        e.close();
                    }
                    if (!e.isClosed()) {
                        break;
                    }
                    this.available.remove(e);
                    pool.free(e, false);
                }
                if (e != null) {
                    this.available.remove(e);
                    this.leased.add(e);
                    onReuse(e);
                    return e;
                }
                int max = getMax(t);
                int max2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                if (max2 > 0) {
                    for (int i = 0; i < max2; i++) {
                        PoolEntry lastUsed = pool.getLastUsed();
                        if (lastUsed == null) {
                            break;
                        }
                        lastUsed.close();
                        this.available.remove(lastUsed);
                        pool.remove(lastUsed);
                    }
                }
                if (pool.getAllocatedCount() < max) {
                    int max3 = Math.max(this.maxTotal - this.leased.size(), 0);
                    if (max3 > 0) {
                        if (this.available.size() > max3 - 1 && !this.available.isEmpty()) {
                            E removeLast = this.available.removeLast();
                            removeLast.close();
                            getPool(removeLast.getRoute()).remove(removeLast);
                        }
                        E e2 = (E) pool.add(this.connFactory.create(t));
                        this.leased.add(e2);
                        return e2;
                    }
                }
                if (future.isCancelled()) {
                    throw new InterruptedException("Operation interrupted");
                }
                pool.queue(future);
                this.pending.add(future);
                if (date != null) {
                    z = this.condition.awaitUntil(date);
                } else {
                    this.condition.await();
                }
                if (future.isCancelled()) {
                    throw new InterruptedException("Operation interrupted");
                }
                pool.unqueue(future);
                this.pending.remove(future);
                if (!z && date != null && date.getTime() <= System.currentTimeMillis()) {
                    throw new TimeoutException("Timeout waiting for connection");
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool<T, C, E> value = it.next().getValue();
            if (value.getAllocatedCount() + value.getPendingCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeExpired() {
        final long currentTimeMillis = System.currentTimeMillis();
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: org.apache.http.pool.AbstractConnPool.4
            @Override // org.apache.http.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.isExpired(currentTimeMillis)) {
                    poolEntry.close();
                }
            }
        });
    }

    public void closeIdle(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        if (millis < 0) {
            millis = 0;
        }
        final long currentTimeMillis = System.currentTimeMillis() - millis;
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: org.apache.http.pool.AbstractConnPool.3
            @Override // org.apache.http.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.getUpdated() <= currentTimeMillis) {
                    poolEntry.close();
                }
            }
        });
    }

    public abstract E createEntry(T t, C c);

    public void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                poolEntryCallback.process(next);
                if (next.isClosed()) {
                    getPool(next.getRoute()).remove(next);
                    it.remove();
                }
            }
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    public void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            for (E e : this.leased) {
                poolEntryCallback.process(e);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            return getMax(t);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool<T, C, E> pool = getPool(t);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public Future<E> lease(T t, Object obj) {
        return lease(t, obj, null);
    }

    @Override // org.apache.http.pool.ConnPool
    public Future<E> lease(final T t, final Object obj, final FutureCallback<E> futureCallback) {
        Args.notNull(t, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return (Future<E>) new Future<E>() { // from class: org.apache.http.pool.AbstractConnPool.2
            public final AtomicBoolean cancelled = new AtomicBoolean(false);
            public final AtomicBoolean done = new AtomicBoolean(false);
            public final AtomicReference<E> entryRef = new AtomicReference<>(null);

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z) {
                if (this.cancelled.compareAndSet(false, true)) {
                    this.done.set(true);
                    AbstractConnPool.this.lock.lock();
                    try {
                        AbstractConnPool.this.condition.signalAll();
                        AbstractConnPool.this.lock.unlock();
                        FutureCallback futureCallback2 = futureCallback;
                        if (futureCallback2 != null) {
                            futureCallback2.cancelled();
                        }
                        return true;
                    } catch (Throwable th) {
                        AbstractConnPool.this.lock.unlock();
                        throw th;
                    }
                }
                return false;
            }

            @Override // java.util.concurrent.Future
            public E get() throws InterruptedException, ExecutionException {
                try {
                    return (E) get(0L, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    throw new ExecutionException(e);
                }
            }

            @Override // java.util.concurrent.Future
            public E get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                E e;
                E e2 = this.entryRef.get();
                if (e2 != null) {
                    return e2;
                }
                synchronized (this) {
                    while (true) {
                        try {
                            try {
                                e = (E) AbstractConnPool.this.getPoolEntryBlocking(t, obj, j, timeUnit, this);
                                if (AbstractConnPool.this.validateAfterInactivity <= 0 || e.getUpdated() + AbstractConnPool.this.validateAfterInactivity > System.currentTimeMillis() || AbstractConnPool.this.validate(e)) {
                                    break;
                                }
                                e.close();
                                AbstractConnPool.this.release((AbstractConnPool) e, false);
                            } catch (IOException e3) {
                                this.done.set(true);
                                if (futureCallback != null) {
                                    futureCallback.failed(e3);
                                }
                                throw new ExecutionException(e3);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    this.entryRef.set(e);
                    this.done.set(true);
                    AbstractConnPool.this.onLease(e);
                    if (futureCallback != null) {
                        futureCallback.completed(e);
                    }
                }
                return e;
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return this.cancelled.get();
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return this.done.get();
            }
        };
    }

    public void onLease(E e) {
    }

    public void onRelease(E e) {
    }

    public void onReuse(E e) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.http.pool.ConnPool
    public /* bridge */ /* synthetic */ void release(Object obj, boolean z) {
        release((AbstractConnPool<T, C, E>) ((PoolEntry) obj), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release(E e, boolean z) {
        this.lock.lock();
        try {
            if (this.leased.remove(e)) {
                RouteSpecificPool pool = getPool(e.getRoute());
                pool.free(e, z);
                if (!z || this.isShutDown) {
                    e.close();
                } else {
                    this.available.addFirst(e);
                }
                onRelease(e);
                Future<E> nextPending = pool.nextPending();
                if (nextPending != null) {
                    this.pending.remove(nextPending);
                } else {
                    nextPending = this.pending.poll();
                }
                if (nextPending != null) {
                    this.condition.signalAll();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxPerRoute(T t, int i) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            if (i > -1) {
                this.maxPerRoute.put(t, Integer.valueOf(i));
            } else {
                this.maxPerRoute.remove(t);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxTotal(int i) {
        Args.positive(i, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i;
        } finally {
            this.lock.unlock();
        }
    }

    public void setValidateAfterInactivity(int i) {
        this.validateAfterInactivity = i;
    }

    public void shutdown() throws IOException {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            for (E e : this.leased) {
                e.close();
            }
            for (RouteSpecificPool<T, C, E> routeSpecificPool : this.routeToPool.values()) {
                routeSpecificPool.shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[leased: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.leased);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("][available: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.available);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("][pending: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pending);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public boolean validate(E e) {
        return true;
    }
}
