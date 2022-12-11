package okhttp3;

import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.pf0;
import me.tvspark.r40;
import okhttp3.RealCall;
import okhttp3.internal.Util;

@ef0
/* loaded from: classes4.dex */
public final class Dispatcher {
    public ExecutorService executorServiceOrNull;
    public Runnable idleCallback;
    public int maxRequests;
    public int maxRequestsPerHost;
    public final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    public final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    public final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dispatcher(ExecutorService executorService) {
        this();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executorService, "executorService");
        this.executorServiceOrNull = executorService;
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next.host(), (Object) str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        while (it2.hasNext()) {
            RealCall.AsyncCall next2 = it2.next();
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next2.host(), (Object) str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.idleCallback;
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean promoteAndExecute() {
        int i;
        boolean z = true;
        boolean z2 = !Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z2) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    RealCall.AsyncCall next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    } else if (next.callsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        next.callsPerHost().incrementAndGet();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "asyncCall");
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                if (runningCallsCount() <= 0) {
                    z = false;
                }
            }
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
            }
            return z;
        }
        throw new AssertionError("Assertion failed");
    }

    /* renamed from: -deprecated_executorService  reason: not valid java name */
    public final ExecutorService m5015deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            it.next().get().cancel();
        }
        Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().get().cancel();
        }
        Iterator<RealCall> it3 = this.runningSyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall findExistingCallWithHost;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(asyncCall, NotificationCompat.CATEGORY_CALL);
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
            if (!asyncCall.get().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.host())) != null) {
                asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
            }
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(RealCall realCall) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realCall, NotificationCompat.CATEGORY_CALL);
        this.runningSyncCalls.add(realCall);
    }

    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        if (this.executorServiceOrNull == null) {
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        executorService = this.executorServiceOrNull;
        if (executorService == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        return executorService;
    }

    public final void finished$okhttp(RealCall.AsyncCall asyncCall) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(asyncCall, NotificationCompat.CATEGORY_CALL);
        asyncCall.callsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, asyncCall);
    }

    public final void finished$okhttp(RealCall realCall) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(realCall, NotificationCompat.CATEGORY_CALL);
        finished(this.runningSyncCalls, realCall);
    }

    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
        ArrayList arrayList = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayDeque, 10));
        for (RealCall.AsyncCall asyncCall : arrayDeque) {
            arrayList.add(asyncCall.get());
        }
        unmodifiableList = Collections.unmodifiableList(arrayList);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiable…ncCalls.map { it.get() })");
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized List<Call> runningCalls() {
        List<Call> unmodifiableList;
        ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
        ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
        ArrayList arrayList = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayDeque2, 10));
        for (RealCall.AsyncCall asyncCall : arrayDeque2) {
            arrayList.add(asyncCall.get());
        }
        unmodifiableList = Collections.unmodifiableList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayDeque, arrayList));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiable…ncCalls.map { it.get() })");
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i) {
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (z) {
            synchronized (this) {
                this.maxRequests = i;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("max < 1: ", i).toString());
    }

    public final void setMaxRequestsPerHost(int i) {
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (z) {
            synchronized (this) {
                this.maxRequestsPerHost = i;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("max < 1: ", i).toString());
    }
}
