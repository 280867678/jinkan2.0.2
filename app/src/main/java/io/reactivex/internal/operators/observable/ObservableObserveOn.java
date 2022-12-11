package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import me.tvspark.ad0;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.o70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.t70;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableObserveOn<T> extends x80<T, T> {
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements j60<T>, Runnable {
        public static final long serialVersionUID = 6576896619930983584L;
        public final j60<? super T> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public boolean outputFused;
        public t70<T> queue;

        /* renamed from: s */
        public p60 f4434s;
        public int sourceMode;
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

        public ObserveOnObserver(j60<? super T> j60Var, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, int i) {
            this.actual = j60Var;
            this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.delayError = z;
            this.bufferSize = i;
        }

        public boolean checkTerminated(boolean z, boolean z2, j60<? super T> j60Var) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (this.delayError) {
                    if (!z2) {
                        return false;
                    }
                    if (th != null) {
                        j60Var.onError(th);
                    } else {
                        j60Var.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                } else if (th != null) {
                    this.queue.clear();
                    j60Var.onError(th);
                    this.worker.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    j60Var.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
        }

        @Override // me.tvspark.t70
        public void clear() {
            this.queue.clear();
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f4434s.dispose();
                this.worker.dispose();
                if (getAndIncrement() != 0) {
                    return;
                }
                this.queue.clear();
            }
        }

        public void drainFused() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                Throwable th = this.error;
                if (this.delayError || !z || th == null) {
                    this.actual.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.actual.onError(th2);
                        } else {
                            this.actual.onComplete();
                        }
                    } else {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    this.actual.onError(th);
                }
                this.worker.dispose();
                return;
            }
        }

        public void drainNormal() {
            t70<T> t70Var = this.queue;
            j60<? super T> j60Var = this.actual;
            int i = 1;
            while (!checkTerminated(this.done, t70Var.isEmpty(), j60Var)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        Object obj = (T) t70Var.mo4868poll();
                        boolean z2 = obj == null;
                        if (checkTerminated(z, z2, j60Var)) {
                            return;
                        }
                        if (z2) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            j60Var.onNext(obj);
                        }
                    } catch (Throwable th) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                        this.f4434s.dispose();
                        t70Var.clear();
                        j60Var.onError(th);
                        return;
                    }
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.t70
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4434s, p60Var)) {
                this.f4434s = p60Var;
                if (p60Var instanceof o70) {
                    o70 o70Var = (o70) p60Var;
                    int requestFusion = o70Var.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = o70Var;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        schedule();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = o70Var;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new sc0(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() throws Exception {
            return this.queue.mo4868poll();
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }
    }

    public ObservableObserveOn(h60<T> h60Var, k60 k60Var, boolean z, int i) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = k60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        k60 k60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (k60Var instanceof ad0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(j60Var);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new ObserveOnObserver(j60Var, k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
    }
}
