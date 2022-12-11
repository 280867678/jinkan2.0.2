package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.ed0;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableCache<T> extends x80<T, T> {
    public final AtomicBoolean Wwwwwwwwwwwwwwwwwwwwww = new AtomicBoolean();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements p60 {
        public static final long serialVersionUID = 7058506693698832024L;
        public volatile boolean cancelled;
        public final j60<? super T> child;
        public Object[] currentBuffer;
        public int currentIndexInBuffer;
        public int index;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> state;

        public ReplayDisposable(j60<? super T> j60Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.child = j60Var;
            this.state = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.p60
        public void dispose() {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable[] replayDisposableArr2;
            if (!this.cancelled) {
                this.cancelled = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.state;
                do {
                    replayDisposableArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.get();
                    int length = replayDisposableArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (replayDisposableArr[i].equals(this)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        replayDisposableArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
                    } else {
                        ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                        System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                        System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                        replayDisposableArr2 = replayDisposableArr3;
                    }
                } while (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.compareAndSet(replayDisposableArr, replayDisposableArr2));
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            j60<? super T> j60Var = this.child;
            int i = 1;
            while (!this.cancelled) {
                int i2 = this.state.Wwwwwwwwwwwwwwwwwwwww;
                if (i2 != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.Wwwwwwwwwwwwwwwwwwwwwww;
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - 1;
                    int i3 = this.index;
                    int i4 = this.currentIndexInBuffer;
                    while (i3 < i2) {
                        if (this.cancelled) {
                            return;
                        }
                        if (i4 == length) {
                            objArr = (Object[]) objArr[length];
                            i4 = 0;
                        }
                        if (NotificationLite.accept(objArr[i4], j60Var)) {
                            return;
                        }
                        i4++;
                        i3++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    this.index = i3;
                    this.currentIndexInBuffer = i4;
                    this.currentBuffer = objArr;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends ed0 implements j60<T> {
        public boolean Wwwwwwwwwwwwwwww;
        public final AtomicReference<ReplayDisposable<T>[]> Wwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwww);
        public final SequentialDisposable Wwwwwwwwwwwwwwwwww = new SequentialDisposable();
        public final d60<? extends T> Wwwwwwwwwwwwwwwwwww;
        public static final ReplayDisposable[] Wwwwwwwwwwwwwww = new ReplayDisposable[0];
        public static final ReplayDisposable[] Wwwwwwwwwwwwww = new ReplayDisposable[0];

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d60<? extends T> d60Var, int i) {
            super(i);
            this.Wwwwwwwwwwwwwwwwwww = d60Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.Wwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwww = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NotificationLite.complete());
                this.Wwwwwwwwwwwwwwwwww.dispose();
                for (ReplayDisposable<T> replayDisposable : this.Wwwwwwwwwwwwwwwww.getAndSet(Wwwwwwwwwwwwww)) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.Wwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwww = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NotificationLite.error(th));
                this.Wwwwwwwwwwwwwwwwww.dispose();
                for (ReplayDisposable<T> replayDisposable : this.Wwwwwwwwwwwwwwwww.getAndSet(Wwwwwwwwwwwwww)) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (!this.Wwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NotificationLite.next(t));
                for (ReplayDisposable<T> replayDisposable : this.Wwwwwwwwwwwwwwwww.get()) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwww.update(p60Var);
        }
    }

    public ObservableCache(d60<T> d60Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(d60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(replayDisposable);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        do {
            replayDisposableArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.get();
            if (replayDisposableArr == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww) {
                break;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.compareAndSet(replayDisposableArr, replayDisposableArr2));
        if (!this.Wwwwwwwwwwwwwwwwwwwwww.get() && this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(false, true)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        replayDisposable.replay();
    }
}
