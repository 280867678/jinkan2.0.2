package io.reactivex.internal.operators.flowable;

import java.util.Iterator;
import me.tvspark.m70;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class FlowableFromIterable$IteratorConditionalSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    public static final long serialVersionUID = -6022804456014692607L;
    public final m70<? super T> actual;

    public FlowableFromIterable$IteratorConditionalSubscription(m70<? super T> m70Var, Iterator<? extends T> it) {
        super(it);
        this.actual = m70Var;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void fastPath() {
        Object obj;
        Iterator<? extends T> it = this.f4375it;
        m70<? super T> m70Var = this.actual;
        while (!this.cancelled) {
            try {
                obj = (T) it.next();
            } catch (Throwable th) {
                th = th;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
            if (this.cancelled) {
                return;
            }
            if (obj == null) {
                th = new NullPointerException("Iterator.next() returned a null value");
                m70Var.onError(th);
                return;
            }
            m70Var.tryOnNext(obj);
            if (this.cancelled) {
                return;
            }
            if (!it.hasNext()) {
                if (this.cancelled) {
                    return;
                }
                m70Var.onComplete();
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void slowPath(long j) {
        Iterator<? extends T> it = this.f4375it;
        m70<? super T> m70Var = this.actual;
        loop0: do {
            long j2 = 0;
            while (true) {
                if (j2 == j) {
                    j = get();
                    if (j2 == j) {
                        j = addAndGet(-j2);
                    }
                } else if (this.cancelled) {
                    return;
                } else {
                    try {
                        Object obj = (T) it.next();
                        if (this.cancelled) {
                            return;
                        }
                        if (obj == null) {
                            th = new NullPointerException("Iterator.next() returned a null value");
                            break loop0;
                        }
                        boolean tryOnNext = m70Var.tryOnNext(obj);
                        if (this.cancelled) {
                            return;
                        }
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            m70Var.onComplete();
                            return;
                        } else if (tryOnNext) {
                            j2++;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    }
                }
            }
            m70Var.onError(th);
            return;
        } while (j != 0);
    }
}
