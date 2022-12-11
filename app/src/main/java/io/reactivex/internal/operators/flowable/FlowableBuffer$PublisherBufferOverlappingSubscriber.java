package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.v60;

/* loaded from: classes4.dex */
public final class FlowableBuffer$PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements s51<T>, t51, v60 {
    public static final long serialVersionUID = -7370244972039324525L;
    public final s51<? super C> actual;
    public final Callable<C> bufferSupplier;
    public volatile boolean cancelled;
    public boolean done;
    public int index;
    public long produced;

    /* renamed from: s */
    public t51 f4358s;
    public final int size;
    public final int skip;
    public final AtomicBoolean once = new AtomicBoolean();
    public final ArrayDeque<C> buffers = new ArrayDeque<>();

    public FlowableBuffer$PublisherBufferOverlappingSubscriber(s51<? super C> s51Var, int i, int i2, Callable<C> callable) {
        this.actual = s51Var;
        this.size = i;
        this.skip = i2;
        this.bufferSupplier = callable;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.cancelled = true;
        this.f4358s.cancel();
    }

    @Override // me.tvspark.v60
    public boolean getAsBoolean() {
        return this.cancelled;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        long j;
        long j2;
        if (this.done) {
            return;
        }
        this.done = true;
        long j3 = this.produced;
        if (j3 != 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j3);
        }
        s51<? super C> s51Var = this.actual;
        ArrayDeque<C> arrayDeque = this.buffers;
        if (arrayDeque.isEmpty()) {
            s51Var.onComplete();
        } else if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(get(), s51Var, arrayDeque, this, this)) {
        } else {
            do {
                j = get();
                if ((j & Long.MIN_VALUE) != 0) {
                    return;
                }
                j2 = Long.MIN_VALUE | j;
            } while (!compareAndSet(j, j2));
            if (j == 0) {
                return;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, s51Var, arrayDeque, this, this);
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        this.buffers.clear();
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        ArrayDeque<C> arrayDeque = this.buffers;
        int i = this.index;
        int i2 = i + 1;
        if (i == 0) {
            try {
                C call = this.bufferSupplier.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The bufferSupplier returned a null buffer");
                arrayDeque.offer(call);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                cancel();
                onError(th);
                return;
            }
        }
        C peek = arrayDeque.peek();
        if (peek != null && peek.size() + 1 == this.size) {
            arrayDeque.poll();
            peek.add(t);
            this.produced++;
            this.actual.onNext(peek);
        }
        Iterator<C> it = arrayDeque.iterator();
        while (it.hasNext()) {
            it.next().add(t);
        }
        if (i2 == this.skip) {
            i2 = 0;
        }
        this.index = i2;
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4358s, t51Var)) {
            this.f4358s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        long j2;
        boolean z;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (SubscriptionHelper.validate(j)) {
            s51<? super C> s51Var = this.actual;
            ArrayDeque<C> arrayDeque = this.buffers;
            do {
                j2 = get();
            } while (!compareAndSet(j2, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
            if (j2 == Long.MIN_VALUE) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j | Long.MIN_VALUE, s51Var, arrayDeque, this, this);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            if (this.once.get() || !this.once.compareAndSet(false, true)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.skip, j);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.size, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.skip, j - 1));
            }
            this.f4358s.request(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
