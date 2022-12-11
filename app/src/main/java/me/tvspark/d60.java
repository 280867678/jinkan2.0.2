package me.tvspark;

import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRedo;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public abstract class d60<T> implements h60<T> {
    public static <T> d60<T> amb(Iterable<? extends h60<? extends T>> iterable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "sources is null");
        return new ObservableAmb(null, iterable);
    }

    public static <T> d60<T> ambArray(h60<? extends T>... h60VarArr) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60VarArr, "sources is null");
        int length = h60VarArr.length;
        return length == 0 ? empty() : length == 1 ? wrap(h60VarArr[0]) : new ObservableAmb(h60VarArr, null);
    }

    public static int bufferSize() {
        return x50.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static <T, R> d60<R> combineLatest(Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var) {
        return combineLatest(iterable, f70Var, bufferSize());
    }

    public static <T, R> d60<R> combineLatest(Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "sources is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "combiner is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableCombineLatest(null, iterable, f70Var, i << 1, false);
    }

    public static <T, R> d60<R> combineLatest(f70<? super Object[], ? extends R> f70Var, int i, h60<? extends T>... h60VarArr) {
        return combineLatest(h60VarArr, f70Var, i);
    }

    public static <T1, T2, T3, T4, T5, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, a70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> a70Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((a70) a70Var), bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, b70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> b70Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((b70) b70Var), bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, h60<? extends T7> h60Var7, c70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> c70Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((c70) c70Var), bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6, h60Var7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, h60<? extends T7> h60Var7, h60<? extends T8> h60Var8, d70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> d70Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d70) d70Var), bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6, h60Var7, h60Var8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, h60<? extends T7> h60Var7, h60<? extends T8> h60Var8, h60<? extends T9> h60Var9, e70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> e70Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((e70) e70Var), bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6, h60Var7, h60Var8, h60Var9);
    }

    public static <T1, T2, T3, T4, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, z60<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> z60Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((z60) z60Var), bufferSize(), h60Var, h60Var2, h60Var3, h60Var4);
    }

    public static <T1, T2, T3, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, y60<? super T1, ? super T2, ? super T3, ? extends R> y60Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((y60) y60Var), bufferSize(), h60Var, h60Var2, h60Var3);
    }

    public static <T1, T2, R> d60<R> combineLatest(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, t60<? super T1, ? super T2, ? extends R> t60Var) {
        return combineLatest(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t60) t60Var), bufferSize(), h60Var, h60Var2);
    }

    public static <T, R> d60<R> combineLatest(h60<? extends T>[] h60VarArr, f70<? super Object[], ? extends R> f70Var) {
        return combineLatest(h60VarArr, f70Var, bufferSize());
    }

    public static <T, R> d60<R> combineLatest(h60<? extends T>[] h60VarArr, f70<? super Object[], ? extends R> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60VarArr, "sources is null");
        if (h60VarArr.length == 0) {
            return empty();
        }
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "combiner is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableCombineLatest(h60VarArr, null, f70Var, i << 1, false);
    }

    public static <T, R> d60<R> combineLatestDelayError(Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var) {
        return combineLatestDelayError(iterable, f70Var, bufferSize());
    }

    public static <T, R> d60<R> combineLatestDelayError(Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "sources is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "combiner is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableCombineLatest(null, iterable, f70Var, i << 1, true);
    }

    public static <T, R> d60<R> combineLatestDelayError(f70<? super Object[], ? extends R> f70Var, int i, h60<? extends T>... h60VarArr) {
        return combineLatestDelayError(h60VarArr, f70Var, i);
    }

    public static <T, R> d60<R> combineLatestDelayError(h60<? extends T>[] h60VarArr, f70<? super Object[], ? extends R> f70Var) {
        return combineLatestDelayError(h60VarArr, f70Var, bufferSize());
    }

    public static <T, R> d60<R> combineLatestDelayError(h60<? extends T>[] h60VarArr, f70<? super Object[], ? extends R> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "combiner is null");
        return h60VarArr.length == 0 ? empty() : new ObservableCombineLatest(h60VarArr, null, f70Var, i << 1, true);
    }

    public static <T> d60<T> concat(h60<? extends h60<? extends T>> h60Var) {
        return concat(h60Var, bufferSize());
    }

    public static <T> d60<T> concat(h60<? extends h60<? extends T>> h60Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "sources is null");
        return new ObservableConcatMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, ErrorMode.IMMEDIATE);
    }

    public static <T> d60<T> concat(h60<? extends T> h60Var, h60<? extends T> h60Var2) {
        return concatArray(h60Var, h60Var2);
    }

    public static <T> d60<T> concat(h60<? extends T> h60Var, h60<? extends T> h60Var2, h60<? extends T> h60Var3) {
        return concatArray(h60Var, h60Var2, h60Var3);
    }

    public static <T> d60<T> concat(h60<? extends T> h60Var, h60<? extends T> h60Var2, h60<? extends T> h60Var3, h60<? extends T> h60Var4) {
        return concatArray(h60Var, h60Var2, h60Var3, h60Var4);
    }

    public static <T> d60<T> concatArray(h60<? extends T>... h60VarArr) {
        return h60VarArr.length == 0 ? empty() : h60VarArr.length == 1 ? wrap(h60VarArr[0]) : new ObservableConcatMap(fromArray(h60VarArr), Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bufferSize(), ErrorMode.BOUNDARY);
    }

    public static <T> d60<T> concatArrayDelayError(h60<? extends T>... h60VarArr) {
        return h60VarArr.length == 0 ? empty() : h60VarArr.length == 1 ? wrap(h60VarArr[0]) : concatDelayError(fromArray(h60VarArr));
    }

    public static <T> d60<T> concatArrayEager(int i, int i2, h60<? extends T>... h60VarArr) {
        return fromArray(h60VarArr).concatMapEagerDelayError(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2, false);
    }

    public static <T> d60<T> concatArrayEager(h60<? extends T>... h60VarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), h60VarArr);
    }

    public static <T> d60<T> concatDelayError(Iterable<? extends h60<? extends T>> iterable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> d60<T> concatDelayError(h60<? extends h60<? extends T>> h60Var) {
        return concatDelayError(h60Var, bufferSize(), true);
    }

    public static <T> d60<T> concatDelayError(h60<? extends h60<? extends T>> h60Var, int i, boolean z) {
        return new ObservableConcatMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, z ? ErrorMode.END : ErrorMode.BOUNDARY);
    }

    public static <T> d60<T> concatEager(Iterable<? extends h60<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> d60<T> concatEager(h60<? extends h60<? extends T>> h60Var) {
        return concatEager(h60Var, bufferSize(), bufferSize());
    }

    public static <T> d60<T> concatEager(h60<? extends h60<? extends T>> h60Var, int i, int i2) {
        return wrap(h60Var).concatMapEager(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2);
    }

    public static <T> d60<T> create(f60<T> f60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f60Var, "source is null");
        return new ObservableCreate(f60Var);
    }

    public static <T> d60<T> defer(Callable<? extends h60<? extends T>> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "supplier is null");
        return new p90(callable);
    }

    private d60<T> doOnEach(x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var, r60 r60Var2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "onNext is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var2, "onError is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r60Var, "onComplete is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r60Var2, "onAfterTerminate is null");
        return new w90(this, x60Var, x60Var2, r60Var, r60Var2);
    }

    public static <T> d60<T> empty() {
        return (d60<T>) ba0.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static <T> d60<T> error(Throwable th) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, "e is null");
        return error(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th));
    }

    public static <T> d60<T> error(Callable<? extends Throwable> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "errorSupplier is null");
        return new ca0(callable);
    }

    public static <T> d60<T> fromArray(T... tArr) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : new fa0(tArr);
    }

    public static <T> d60<T> fromCallable(Callable<? extends T> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "supplier is null");
        return new ga0(callable);
    }

    public static <T> d60<T> fromFuture(Future<? extends T> future) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(future, "future is null");
        return new ha0(future, 0L, null);
    }

    public static <T> d60<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(future, "future is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        return new ha0(future, j, timeUnit);
    }

    public static <T> d60<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(k60Var);
    }

    public static <T> d60<T> fromFuture(Future<? extends T> future, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return fromFuture(future).subscribeOn(k60Var);
    }

    public static <T> d60<T> fromIterable(Iterable<? extends T> iterable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "source is null");
        return new ia0(iterable);
    }

    public static <T> d60<T> fromPublisher(r51<? extends T> r51Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r51Var, "publisher is null");
        return new ja0(r51Var);
    }

    public static <T, S> d60<T> generate(Callable<S> callable, t60<S, w50<T>, S> t60Var, x60<? super S> x60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "initialState is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var, "generator  is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "disposeState is null");
        return new la0(callable, t60Var, x60Var);
    }

    public static <T> d60<T> generate(x60<w50<T>> x60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "generator  is null");
        return generate(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, new eb0(x60Var), Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static d60<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static d60<Long> interval(long j, long j2, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, k60Var);
    }

    public static d60<Long> interval(long j, TimeUnit timeUnit, k60 k60Var) {
        return interval(j, j, timeUnit, k60Var);
    }

    public static d60<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static d60<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, k60 k60Var) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return empty().delay(j3, timeUnit, k60Var);
            }
            long j5 = (j2 - 1) + j;
            if (j > 0 && j5 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
            return new ObservableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, k60Var);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count >= 0 required but it was ", j2));
    }

    public static <T> d60<T> just(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The item is null");
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d60) new gb0(t));
    }

    public static <T> d60<T> just(T t, T t2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        return fromArray(t, t2);
    }

    public static <T> d60<T> just(T t, T t2, T t3) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        return fromArray(t, t2, t3);
    }

    public static <T> d60<T> just(T t, T t2, T t3, T t4) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t4, "The fourth item is null");
        return fromArray(t, t2, t3, t4);
    }

    public static <T> d60<T> just(T t, T t2, T t3, T t4, T t5) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t4, "The fourth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t5, "The fifth item is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T> d60<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t4, "The fourth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t5, "The fifth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t6, "The sixth item is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public static <T> d60<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t4, "The fourth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t5, "The fifth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t6, "The sixth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t7, "The seventh item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public static <T> d60<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t4, "The fourth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t5, "The fifth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t6, "The sixth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t7, "The seventh item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t8, "The eighth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    public static <T> d60<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t4, "The fourth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t5, "The fifth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t6, "The sixth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t7, "The seventh item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t8, "The eighth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t9, "The ninth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T> d60<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "The first item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t2, "The second item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t3, "The third item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t4, "The fourth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t5, "The fifth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t6, "The sixth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t7, "The seventh item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t8, "The eighth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t9, "The ninth item is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t10, "The tenth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    public static <T> d60<T> merge(h60<? extends h60<? extends T>> h60Var) {
        return new ObservableFlatMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, Integer.MAX_VALUE, bufferSize());
    }

    public static <T> d60<T> mergeArray(int i, int i2, h60<? extends T>... h60VarArr) {
        return fromArray(h60VarArr).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, i, i2);
    }

    public static <T> d60<T> mergeArrayDelayError(int i, int i2, h60<? extends T>... h60VarArr) {
        return fromArray(h60VarArr).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, i, i2);
    }

    public static <T> d60<T> mergeDelayError(h60<? extends h60<? extends T>> h60Var) {
        return new ObservableFlatMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, Integer.MAX_VALUE, bufferSize());
    }

    public static <T> d60<T> never() {
        return (d60<T>) nb0.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static d60<Integer> range(int i, int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return empty();
            }
            if (i2 == 1) {
                return just(Integer.valueOf(i));
            }
            if (i + (i2 - 1) > 2147483647L) {
                throw new IllegalArgumentException("Integer overflow");
            }
            return new ObservableRange(i, i2);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count >= 0 required but it was ", i2));
    }

    public static d60<Long> rangeLong(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return empty();
            }
            if (j2 == 1) {
                return just(Long.valueOf(j));
            }
            long j3 = (j2 - 1) + j;
            if (j > 0 && j3 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            return new ObservableRangeLong(j, j2);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count >= 0 required but it was ", j2));
    }

    public static <T> l60<Boolean> sequenceEqual(h60<? extends T> h60Var, h60<? extends T> h60Var2) {
        return sequenceEqual(h60Var, h60Var2, l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bufferSize());
    }

    public static <T> l60<Boolean> sequenceEqual(h60<? extends T> h60Var, h60<? extends T> h60Var2, u60<? super T, ? super T> u60Var) {
        return sequenceEqual(h60Var, h60Var2, u60Var, bufferSize());
    }

    public static <T> l60<Boolean> sequenceEqual(h60<? extends T> h60Var, h60<? extends T> h60Var2, u60<? super T, ? super T> u60Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "source2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u60Var, "isEqual is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableSequenceEqualSingle(h60Var, h60Var2, u60Var, i);
    }

    public static <T> d60<T> switchOnNext(h60<? extends h60<? extends T>> h60Var) {
        return switchOnNext(h60Var, bufferSize());
    }

    public static <T> d60<T> switchOnNext(h60<? extends h60<? extends T>> h60Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "sources is null");
        return new ObservableSwitchMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, false);
    }

    public static <T> d60<T> switchOnNextDelayError(h60<? extends h60<? extends T>> h60Var) {
        return switchOnNextDelayError(h60Var, bufferSize());
    }

    public static <T> d60<T> switchOnNextDelayError(h60<? extends h60<? extends T>> h60Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "sources is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "prefetch");
        return new ObservableSwitchMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, true);
    }

    private d60<T> timeout0(long j, TimeUnit timeUnit, h60<? extends T> h60Var, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableTimeoutTimed(this, j, timeUnit, k60Var, h60Var);
    }

    private <U, V> d60<T> timeout0(h60<U> h60Var, f70<? super T, ? extends h60<V>> f70Var, h60<? extends T> h60Var2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "itemTimeoutIndicator is null");
        return new ObservableTimeout(this, h60Var, f70Var, h60Var2);
    }

    public static d60<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static d60<Long> timer(long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableTimer(Math.max(j, 0L), timeUnit, k60Var);
    }

    public static <T> d60<T> unsafeCreate(h60<T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "onSubscribe is null");
        if (!(h60Var instanceof d60)) {
            return new ka0(h60Var);
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> d60<T> using(Callable<? extends D> callable, f70<? super D, ? extends h60<? extends T>> f70Var, x60<? super D> x60Var) {
        return using(callable, f70Var, x60Var, true);
    }

    public static <T, D> d60<T> using(Callable<? extends D> callable, f70<? super D, ? extends h60<? extends T>> f70Var, x60<? super D> x60Var, boolean z) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "resourceSupplier is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "sourceSupplier is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "disposer is null");
        return new ObservableUsing(callable, f70Var, x60Var, z);
    }

    public static <T> d60<T> wrap(h60<T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source is null");
        return h60Var instanceof d60 ? (d60) h60Var : new ka0(h60Var);
    }

    public static <T, R> d60<R> zip(Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "zipper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "sources is null");
        return new ObservableZip(null, iterable, f70Var, bufferSize(), false);
    }

    public static <T, R> d60<R> zip(h60<? extends h60<? extends T>> h60Var, f70<? super Object[], ? extends R> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "zipper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "sources is null");
        return new ic0(h60Var, 16).flatMap(new fb0(f70Var));
    }

    public static <T1, T2, T3, T4, T5, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, a70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> a70Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((a70) a70Var), false, bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, b70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> b70Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((b70) b70Var), false, bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, h60<? extends T7> h60Var7, c70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> c70Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((c70) c70Var), false, bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6, h60Var7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, h60<? extends T7> h60Var7, h60<? extends T8> h60Var8, d70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> d70Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d70) d70Var), false, bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6, h60Var7, h60Var8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, h60<? extends T5> h60Var5, h60<? extends T6> h60Var6, h60<? extends T7> h60Var7, h60<? extends T8> h60Var8, h60<? extends T9> h60Var9, e70<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> e70Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((e70) e70Var), false, bufferSize(), h60Var, h60Var2, h60Var3, h60Var4, h60Var5, h60Var6, h60Var7, h60Var8, h60Var9);
    }

    public static <T1, T2, T3, T4, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, h60<? extends T4> h60Var4, z60<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> z60Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((z60) z60Var), false, bufferSize(), h60Var, h60Var2, h60Var3, h60Var4);
    }

    public static <T1, T2, T3, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, h60<? extends T3> h60Var3, y60<? super T1, ? super T2, ? super T3, ? extends R> y60Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((y60) y60Var), false, bufferSize(), h60Var, h60Var2, h60Var3);
    }

    public static <T1, T2, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, t60<? super T1, ? super T2, ? extends R> t60Var) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t60) t60Var), false, bufferSize(), h60Var, h60Var2);
    }

    public static <T1, T2, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, t60<? super T1, ? super T2, ? extends R> t60Var, boolean z) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t60) t60Var), z, bufferSize(), h60Var, h60Var2);
    }

    public static <T1, T2, R> d60<R> zip(h60<? extends T1> h60Var, h60<? extends T2> h60Var2, t60<? super T1, ? super T2, ? extends R> t60Var, boolean z, int i) {
        return zipArray(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t60) t60Var), z, i, h60Var, h60Var2);
    }

    public static <T, R> d60<R> zipArray(f70<? super Object[], ? extends R> f70Var, boolean z, int i, h60<? extends T>... h60VarArr) {
        if (h60VarArr.length == 0) {
            return empty();
        }
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "zipper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableZip(h60VarArr, null, f70Var, i, z);
    }

    public static <T, R> d60<R> zipIterable(Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var, boolean z, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "zipper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "sources is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d60) new ObservableZip(null, iterable, f70Var, i, z));
    }

    public final l60<Boolean> all(g70<? super T> g70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "predicate is null");
        return new d90(this, g70Var);
    }

    public final d60<T> ambWith(h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return ambArray(this, h60Var);
    }

    public final l60<Boolean> any(g70<? super T> g70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "predicate is null");
        return new f90(this, g70Var);
    }

    public final T blockingFirst() {
        x70 x70Var = new x70();
        subscribe(x70Var);
        T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = x70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new NoSuchElementException();
    }

    public final T blockingFirst(T t) {
        x70 x70Var = new x70();
        subscribe(x70Var);
        T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = x70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : t;
    }

    public final void blockingForEach(x60<? super T> x60Var) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                x60Var.accept(it.next());
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                ((p60) it).dispose();
                throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final Iterable<T> blockingIterable(int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new BlockingObservableIterable(this, i);
    }

    public final T blockingLast() {
        y70 y70Var = new y70();
        subscribe(y70Var);
        T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = y70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new NoSuchElementException();
    }

    public final T blockingLast(T t) {
        y70 y70Var = new y70();
        subscribe(y70Var);
        T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = y70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : t;
    }

    public final Iterable<T> blockingLatest() {
        return new y80(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new a90(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new b90(this);
    }

    public final T blockingSingle() {
        z50<T> singleElement = singleElement();
        if (singleElement != null) {
            z70 z70Var = new z70();
            singleElement.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z70Var);
            T t = (T) z70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (t == null) {
                throw new NoSuchElementException();
            }
            return t;
        }
        throw null;
    }

    public final void blockingSubscribe() {
        dd0 dd0Var = new dd0();
        x60<Object> x60Var = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        LambdaObserver lambdaObserver = new LambdaObserver(x60Var, dd0Var, dd0Var, x60Var);
        subscribe(lambdaObserver);
        if (dd0Var.getCount() != 0) {
            try {
                dd0Var.await();
            } catch (InterruptedException e) {
                lambdaObserver.dispose();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
        Throwable th = dd0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (th == null) {
            return;
        }
        throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    public final void blockingSubscribe(j60<? super T> j60Var) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j60Var);
    }

    public final void blockingSubscribe(x60<? super T> x60Var) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, x60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void blockingSubscribe(x60<? super T> x60Var, x60<? super Throwable> x60Var2) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, x60Var, x60Var2, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void blockingSubscribe(x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, x60Var, x60Var2, r60Var);
    }

    public final d60<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final d60<List<T>> buffer(int i, int i2) {
        return (d60<List<T>>) buffer(i, i2, ArrayListSupplier.asCallable());
    }

    public final <U extends Collection<? super T>> d60<U> buffer(int i, int i2, Callable<U> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "skip");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "bufferSupplier is null");
        return new ObservableBuffer(this, i, i2, callable);
    }

    public final <U extends Collection<? super T>> d60<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, callable);
    }

    public final d60<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return (d60<List<T>>) buffer(j, j2, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ArrayListSupplier.asCallable());
    }

    public final d60<List<T>> buffer(long j, long j2, TimeUnit timeUnit, k60 k60Var) {
        return (d60<List<T>>) buffer(j, j2, timeUnit, k60Var, ArrayListSupplier.asCallable());
    }

    public final <U extends Collection<? super T>> d60<U> buffer(long j, long j2, TimeUnit timeUnit, k60 k60Var, Callable<U> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "bufferSupplier is null");
        return new j90(this, j, j2, timeUnit, k60Var, callable, Integer.MAX_VALUE, false);
    }

    public final d60<List<T>> buffer(long j, TimeUnit timeUnit, k60 k60Var) {
        return (d60<List<T>>) buffer(j, timeUnit, k60Var, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final d60<List<T>> buffer(long j, TimeUnit timeUnit, k60 k60Var, int i) {
        return (d60<List<T>>) buffer(j, timeUnit, k60Var, i, ArrayListSupplier.asCallable(), false);
    }

    public final <U extends Collection<? super T>> d60<U> buffer(long j, TimeUnit timeUnit, k60 k60Var, int i, Callable<U> callable, boolean z) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "bufferSupplier is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
        return new j90(this, j, j, timeUnit, k60Var, callable, i, z);
    }

    public final <B> d60<List<T>> buffer(Callable<? extends h60<B>> callable) {
        return (d60<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    public final <B, U extends Collection<? super T>> d60<U> buffer(Callable<? extends h60<B>> callable, Callable<U> callable2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "boundarySupplier is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable2, "bufferSupplier is null");
        return new h90(this, callable, callable2);
    }

    public final <B> d60<List<T>> buffer(h60<B> h60Var) {
        return (d60<List<T>>) buffer(h60Var, ArrayListSupplier.asCallable());
    }

    public final <B> d60<List<T>> buffer(h60<B> h60Var, int i) {
        return (d60<List<T>>) buffer(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
    }

    public final <B, U extends Collection<? super T>> d60<U> buffer(h60<B> h60Var, Callable<U> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "boundary is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "bufferSupplier is null");
        return new i90(this, h60Var, callable);
    }

    public final <TOpening, TClosing> d60<List<T>> buffer(h60<? extends TOpening> h60Var, f70<? super TOpening, ? extends h60<? extends TClosing>> f70Var) {
        return (d60<List<T>>) buffer(h60Var, f70Var, ArrayListSupplier.asCallable());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> d60<U> buffer(h60<? extends TOpening> h60Var, f70<? super TOpening, ? extends h60<? extends TClosing>> f70Var, Callable<U> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "openingIndicator is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "closingIndicator is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "bufferSupplier is null");
        return new g90(this, h60Var, f70Var, callable);
    }

    public final d60<T> cache() {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16, "capacityHint");
        return new ObservableCache(this, new ObservableCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 16));
    }

    public final d60<T> cacheWithInitialCapacity(int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "capacityHint");
        return new ObservableCache(this, new ObservableCache.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i));
    }

    public final <U> d60<U> cast(Class<U> cls) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "clazz is null");
        return (d60<U>) map(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class) cls));
    }

    public final <U> l60<U> collect(Callable<? extends U> callable, s60<? super U, ? super T> s60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "initialValueSupplier is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s60Var, "collector is null");
        return new l90(this, callable, s60Var);
    }

    public final <U> l60<U> collectInto(U u, s60<? super U, ? super T> s60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u, "initialValue is null");
        return collect(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u), s60Var);
    }

    public final <R> d60<R> compose(i60<T, R> i60Var) {
        return wrap(i60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    public final <R> d60<R> concatMap(f70<? super T, ? extends h60<? extends R>> f70Var) {
        return concatMap(f70Var, 2);
    }

    public final <R> d60<R> concatMap(f70<? super T, ? extends h60<? extends R>> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "prefetch");
        if (this instanceof r70) {
            Object call = ((r70) this).call();
            return call == null ? empty() : new tb0(call, f70Var);
        }
        return new ObservableConcatMap(this, f70Var, i, ErrorMode.IMMEDIATE);
    }

    public final <R> d60<R> concatMapDelayError(f70<? super T, ? extends h60<? extends R>> f70Var) {
        return concatMapDelayError(f70Var, bufferSize(), true);
    }

    public final <R> d60<R> concatMapDelayError(f70<? super T, ? extends h60<? extends R>> f70Var, int i, boolean z) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "prefetch");
        if (!(this instanceof r70)) {
            return new ObservableConcatMap(this, f70Var, i, z ? ErrorMode.END : ErrorMode.BOUNDARY);
        }
        Object call = ((r70) this).call();
        return call == null ? empty() : new tb0(call, f70Var);
    }

    public final <R> d60<R> concatMapEager(f70<? super T, ? extends h60<? extends R>> f70Var) {
        return concatMapEager(f70Var, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> d60<R> concatMapEager(f70<? super T, ? extends h60<? extends R>> f70Var, int i, int i2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "maxConcurrency");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "prefetch");
        return new ObservableConcatMapEager(this, f70Var, ErrorMode.IMMEDIATE, i, i2);
    }

    public final <R> d60<R> concatMapEagerDelayError(f70<? super T, ? extends h60<? extends R>> f70Var, int i, int i2, boolean z) {
        return new ObservableConcatMapEager(this, f70Var, z ? ErrorMode.END : ErrorMode.BOUNDARY, i, i2);
    }

    public final <R> d60<R> concatMapEagerDelayError(f70<? super T, ? extends h60<? extends R>> f70Var, boolean z) {
        return concatMapEagerDelayError(f70Var, Integer.MAX_VALUE, bufferSize(), z);
    }

    public final <U> d60<U> concatMapIterable(f70<? super T, ? extends Iterable<? extends U>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        return new ea0(this, f70Var);
    }

    public final <U> d60<U> concatMapIterable(f70<? super T, ? extends Iterable<? extends U>> f70Var, int i) {
        return (d60<U>) concatMap(new ua0(f70Var), i);
    }

    public final d60<T> concatWith(h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return concat(this, h60Var);
    }

    public final l60<Boolean> contains(Object obj) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "element is null");
        return any(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    public final l60<Long> count() {
        return new n90(this);
    }

    public final d60<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> debounce(long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableDebounceTimed(this, j, timeUnit, k60Var);
    }

    public final <U> d60<T> debounce(f70<? super T, ? extends h60<U>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "debounceSelector is null");
        return new o90(this, f70Var);
    }

    public final d60<T> defaultIfEmpty(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final d60<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
    }

    public final d60<T> delay(long j, TimeUnit timeUnit, k60 k60Var) {
        return delay(j, timeUnit, k60Var, false);
    }

    public final d60<T> delay(long j, TimeUnit timeUnit, k60 k60Var, boolean z) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new q90(this, j, timeUnit, k60Var, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> d60<T> delay(h60<U> h60Var, f70<? super T, ? extends h60<V>> f70Var) {
        return delaySubscription(h60Var).delay(f70Var);
    }

    public final d60<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> delaySubscription(long j, TimeUnit timeUnit, k60 k60Var) {
        return delaySubscription(timer(j, timeUnit, k60Var));
    }

    public final <U> d60<T> delaySubscription(h60<U> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return new r90(this, h60Var);
    }

    public final <T2> d60<T2> dematerialize() {
        return new s90(this);
    }

    public final d60<T> distinct() {
        return distinct(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.HashSetCallable.INSTANCE);
    }

    public final <K> d60<T> distinct(f70<? super T, K> f70Var) {
        return distinct(f70Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final <K> d60<T> distinct(f70<? super T, K> f70Var, Callable<? extends Collection<? super K>> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "keySelector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "collectionSupplier is null");
        return new u90(this, f70Var, callable);
    }

    public final d60<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d60<T> doAfterTerminate(r60 r60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r60Var, "onFinally is null");
        x60<Object> x60Var = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return doOnEach(x60Var, x60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r60Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d60<T> doOnComplete(r60 r60Var) {
        x60<Object> x60Var = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return doOnEach(x60Var, x60Var, r60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> doOnDispose(r60 r60Var) {
        return doOnLifecycle(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r60Var);
    }

    public final d60<T> doOnEach(j60<? super T> j60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, "observer is null");
        return doOnEach(new ab0(j60Var), new za0(j60Var), new ya0(j60Var), Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> doOnError(x60<? super Throwable> x60Var) {
        x60<? super T> x60Var2 = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r60 r60Var = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return doOnEach(x60Var2, x60Var, r60Var, r60Var);
    }

    public final d60<T> doOnLifecycle(x60<? super p60> x60Var, r60 r60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "onSubscribe is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r60Var, "onDispose is null");
        return new x90(this, x60Var, r60Var);
    }

    public final d60<T> doOnNext(x60<? super T> x60Var) {
        x60<? super Throwable> x60Var2 = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r60 r60Var = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return doOnEach(x60Var, x60Var2, r60Var, r60Var);
    }

    public final d60<T> doOnSubscribe(x60<? super p60> x60Var) {
        return doOnLifecycle(x60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> doOnTerminate(r60 r60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r60Var, "onTerminate is null");
        return doOnEach(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Functions.Wwwwwwwwwwwwwwwwww(r60Var), r60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final l60<T> elementAt(long j, T t) {
        if (j >= 0) {
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "defaultItem is null");
            return new aa0(this, j, t);
        }
        throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index >= 0 required but it was ", j));
    }

    public final z50<T> elementAt(long j) {
        if (j >= 0) {
            return new z90(this, j);
        }
        throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index >= 0 required but it was ", j));
    }

    public final l60<T> elementAtOrError(long j) {
        if (j >= 0) {
            return new aa0(this, j, null);
        }
        throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index >= 0 required but it was ", j));
    }

    public final d60<T> filter(g70<? super T> g70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "predicate is null");
        return new da0(this, g70Var);
    }

    public final l60<T> first(T t) {
        return elementAt(0L, t);
    }

    public final z50<T> firstElement() {
        return elementAt(0L);
    }

    public final l60<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> d60<R> flatMap(f70<? super T, ? extends h60<? extends R>> f70Var) {
        return flatMap((f70) f70Var, false);
    }

    public final <R> d60<R> flatMap(f70<? super T, ? extends h60<? extends R>> f70Var, int i) {
        return flatMap((f70) f70Var, false, i, bufferSize());
    }

    public final <R> d60<R> flatMap(f70<? super T, ? extends h60<? extends R>> f70Var, f70<? super Throwable, ? extends h60<? extends R>> f70Var2, Callable<? extends h60<? extends R>> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "onNextMapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var2, "onErrorMapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "onCompleteSupplier is null");
        return merge(new lb0(this, f70Var, f70Var2, callable));
    }

    public final <R> d60<R> flatMap(f70<? super T, ? extends h60<? extends R>> f70Var, f70<Throwable, ? extends h60<? extends R>> f70Var2, Callable<? extends h60<? extends R>> callable, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "onNextMapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var2, "onErrorMapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "onCompleteSupplier is null");
        return merge(new lb0(this, f70Var, f70Var2, callable), i);
    }

    public final <U, R> d60<R> flatMap(f70<? super T, ? extends h60<? extends U>> f70Var, t60<? super T, ? super U, ? extends R> t60Var) {
        return flatMap(f70Var, t60Var, false, bufferSize(), bufferSize());
    }

    public final <U, R> d60<R> flatMap(f70<? super T, ? extends h60<? extends U>> f70Var, t60<? super T, ? super U, ? extends R> t60Var, int i) {
        return flatMap(f70Var, t60Var, false, i, bufferSize());
    }

    public final <U, R> d60<R> flatMap(f70<? super T, ? extends h60<? extends U>> f70Var, t60<? super T, ? super U, ? extends R> t60Var, boolean z) {
        return flatMap(f70Var, t60Var, z, bufferSize(), bufferSize());
    }

    public final <U, R> d60<R> flatMap(f70<? super T, ? extends h60<? extends U>> f70Var, t60<? super T, ? super U, ? extends R> t60Var, boolean z, int i) {
        return flatMap(f70Var, t60Var, z, i, bufferSize());
    }

    public final <U, R> d60<R> flatMap(f70<? super T, ? extends h60<? extends U>> f70Var, t60<? super T, ? super U, ? extends R> t60Var, boolean z, int i, int i2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var, "combiner is null");
        return flatMap(new wa0(t60Var, f70Var), z, i, i2);
    }

    public final <R> d60<R> flatMap(f70<? super T, ? extends h60<? extends R>> f70Var, boolean z) {
        return flatMap(f70Var, z, Integer.MAX_VALUE);
    }

    public final <R> d60<R> flatMap(f70<? super T, ? extends h60<? extends R>> f70Var, boolean z, int i) {
        return flatMap(f70Var, z, i, bufferSize());
    }

    public final t50 flatMapCompletable(f70<? super T, ? extends v50> f70Var) {
        return flatMapCompletable(f70Var, false);
    }

    public final t50 flatMapCompletable(f70<? super T, ? extends v50> f70Var, boolean z) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        return new ObservableFlatMapCompletableCompletable(this, f70Var, z);
    }

    public final <U> d60<U> flatMapIterable(f70<? super T, ? extends Iterable<? extends U>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        return new ea0(this, f70Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> d60<V> flatMapIterable(f70<? super T, ? extends Iterable<? extends U>> f70Var, t60<? super T, ? super U, ? extends V> t60Var) {
        return (d60<V>) flatMap(new ua0(f70Var), t60Var, false, bufferSize(), bufferSize());
    }

    public final <R> d60<R> flatMapMaybe(f70<? super T, ? extends b60<? extends R>> f70Var) {
        return flatMapMaybe(f70Var, false);
    }

    public final <R> d60<R> flatMapMaybe(f70<? super T, ? extends b60<? extends R>> f70Var, boolean z) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        return new ObservableFlatMapMaybe(this, f70Var, z);
    }

    public final <R> d60<R> flatMapSingle(f70<? super T, ? extends n60<? extends R>> f70Var) {
        return flatMapSingle(f70Var, false);
    }

    public final <R> d60<R> flatMapSingle(f70<? super T, ? extends n60<? extends R>> f70Var, boolean z) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        return new ObservableFlatMapSingle(this, f70Var, z);
    }

    public final p60 forEach(x60<? super T> x60Var) {
        return subscribe(x60Var);
    }

    public final p60 forEachWhile(g70<? super T> g70Var) {
        return forEachWhile(g70Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final p60 forEachWhile(g70<? super T> g70Var, x60<? super Throwable> x60Var) {
        return forEachWhile(g70Var, x60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final p60 forEachWhile(g70<? super T> g70Var, x60<? super Throwable> x60Var, r60 r60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "onNext is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "onError is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r60Var, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(g70Var, x60Var, r60Var);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K> d60<hd0<K, T>> groupBy(f70<? super T, ? extends K> f70Var) {
        return (d60<hd0<K, T>>) groupBy(f70Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, bufferSize());
    }

    public final <K, V> d60<hd0<K, V>> groupBy(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2) {
        return groupBy(f70Var, f70Var2, false, bufferSize());
    }

    public final <K, V> d60<hd0<K, V>> groupBy(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, boolean z) {
        return groupBy(f70Var, f70Var2, z, bufferSize());
    }

    public final <K, V> d60<hd0<K, V>> groupBy(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, boolean z, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "keySelector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var2, "valueSelector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableGroupBy(this, f70Var, f70Var2, i, z);
    }

    public final <TRight, TLeftEnd, TRightEnd, R> d60<R> groupJoin(h60<? extends TRight> h60Var, f70<? super T, ? extends h60<TLeftEnd>> f70Var, f70<? super TRight, ? extends h60<TRightEnd>> f70Var2, t60<? super T, ? super d60<TRight>, ? extends R> t60Var) {
        return new ObservableGroupJoin(this, h60Var, f70Var, f70Var2, t60Var);
    }

    public final d60<T> hide() {
        return new ma0(this);
    }

    public final t50 ignoreElements() {
        return new oa0(this);
    }

    public final l60<Boolean> isEmpty() {
        return all(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final <TRight, TLeftEnd, TRightEnd, R> d60<R> join(h60<? extends TRight> h60Var, f70<? super T, ? extends h60<TLeftEnd>> f70Var, f70<? super TRight, ? extends h60<TRightEnd>> f70Var2, t60<? super T, ? super TRight, ? extends R> t60Var) {
        return new ObservableJoin(this, h60Var, f70Var, f70Var2, t60Var);
    }

    public final l60<T> last(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "defaultItem is null");
        return new ib0(this, t);
    }

    public final z50<T> lastElement() {
        return new hb0(this);
    }

    public final l60<T> lastOrError() {
        return new ib0(this, null);
    }

    public final <R> d60<R> lift(g60<? extends R, ? super T> g60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g60Var, "onLift is null");
        return new jb0(this, g60Var);
    }

    public final <R> d60<R> map(f70<? super T, ? extends R> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d60) new kb0(this, f70Var));
    }

    public final d60<c60<T>> materialize() {
        return new mb0(this);
    }

    public final d60<T> mergeWith(h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return merge(this, h60Var);
    }

    public final d60<T> observeOn(k60 k60Var) {
        return observeOn(k60Var, false, bufferSize());
    }

    public final d60<T> observeOn(k60 k60Var, boolean z) {
        return observeOn(k60Var, z, bufferSize());
    }

    public final d60<T> observeOn(k60 k60Var, boolean z, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableObserveOn(this, k60Var, z, i);
    }

    public final <U> d60<U> ofType(Class<U> cls) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "clazz is null");
        return filter(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class) cls)).cast(cls);
    }

    public final d60<T> onErrorResumeNext(f70<? super Throwable, ? extends h60<? extends T>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "resumeFunction is null");
        return new ob0(this, f70Var, false);
    }

    public final d60<T> onErrorResumeNext(h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "next is null");
        return onErrorResumeNext(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var));
    }

    public final d60<T> onErrorReturn(f70<? super Throwable, ? extends T> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "valueSupplier is null");
        return new pb0(this, f70Var);
    }

    public final d60<T> onErrorReturnItem(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "item is null");
        return onErrorReturn(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t));
    }

    public final d60<T> onExceptionResumeNext(h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "next is null");
        return new ob0(this, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var), true);
    }

    public final d60<T> onTerminateDetach() {
        return new t90(this);
    }

    public final <R> d60<R> publish(f70<? super d60<T>, ? extends h60<R>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "selector is null");
        return new ObservablePublishSelector(this, f70Var);
    }

    public final gd0<T> publish() {
        AtomicReference atomicReference = new AtomicReference();
        return new ObservablePublish(new qb0(atomicReference), this, atomicReference);
    }

    public final <R> l60<R> reduce(R r, t60<R, ? super T, R> t60Var) {
        return new yb0(scan(r, t60Var).takeLast(1), null);
    }

    public final z50<T> reduce(t60<T, T, T> t60Var) {
        return scan(t60Var).takeLast(1).singleElement();
    }

    public final <R> l60<R> reduceWith(Callable<R> callable, t60<R, ? super T, R> t60Var) {
        return new yb0(scanWith(callable, t60Var).takeLast(1), null);
    }

    public final d60<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final d60<T> repeat(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? empty() : new ObservableRepeat(this, j);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("times >= 0 required but it was ", j));
    }

    public final d60<T> repeatUntil(v60 v60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v60Var, "stop is null");
        return new ObservableRepeatUntil(this, v60Var);
    }

    public final d60<T> repeatWhen(f70<? super d60<Object>, ? extends h60<?>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "handler is null");
        return new ObservableRedo(this, new bb0(f70Var));
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "selector is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new pa0(this), f70Var);
    }

    public final gd0<T> replay(int i) {
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
    }

    public final gd0<T> replay(int i, long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, timeUnit, k60Var, i);
    }

    public final gd0<T> replay(int i, k60 k60Var) {
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replay(i), k60Var);
    }

    public final gd0<T> replay(long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, timeUnit, k60Var);
    }

    public final gd0<T> replay(k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replay(), k60Var);
    }

    public final d60<T> retry() {
        return retry(Long.MAX_VALUE, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> retry(long j, g70<? super Throwable> g70Var) {
        if (j >= 0) {
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "predicate is null");
            return new ObservableRetryPredicate(this, j, g70Var);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("times >= 0 required but it was ", j));
    }

    public final d60<T> retry(g70<? super Throwable> g70Var) {
        return retry(Long.MAX_VALUE, g70Var);
    }

    public final d60<T> retry(u60<? super Integer, ? super Throwable> u60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u60Var, "predicate is null");
        return new ObservableRetryBiPredicate(this, u60Var);
    }

    public final d60<T> retryUntil(v60 v60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v60Var, "stop is null");
        return retry(Long.MAX_VALUE, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v60Var));
    }

    public final d60<T> retryWhen(f70<? super d60<Throwable>, ? extends h60<?>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "handler is null");
        return new ObservableRedo(this, new cb0(f70Var));
    }

    public final void safeSubscribe(j60<? super T> j60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, "s is null");
        if (j60Var instanceof ld0) {
            subscribe(j60Var);
        } else {
            subscribe(new ld0(j60Var));
        }
    }

    public final d60<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> sample(long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableSampleTimed(this, j, timeUnit, k60Var);
    }

    public final <U> d60<T> sample(h60<U> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "sampler is null");
        return new ObservableSampleWithObservable(this, h60Var);
    }

    public final <R> d60<R> scan(R r, t60<R, ? super T, R> t60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, "seed is null");
        return scanWith(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r), t60Var);
    }

    public final d60<T> scan(t60<T, T, T> t60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var, "accumulator is null");
        return new ub0(this, t60Var);
    }

    public final <R> d60<R> scanWith(Callable<R> callable, t60<R, ? super T, R> t60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "seedSupplier is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var, "accumulator is null");
        return new vb0(this, callable, t60Var);
    }

    public final d60<T> serialize() {
        return new wb0(this);
    }

    public final d60<T> share() {
        gd0<T> publish = publish();
        if (publish != null) {
            return new ObservableRefCount(publish);
        }
        throw null;
    }

    public final l60<T> single(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "defaultItem is null");
        return new yb0(this, t);
    }

    public final z50<T> singleElement() {
        return new xb0(this);
    }

    public final l60<T> singleOrError() {
        return new yb0(this, null);
    }

    public final d60<T> skip(long j) {
        return j <= 0 ? this : new zb0(this, j);
    }

    public final d60<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    public final d60<T> skip(long j, TimeUnit timeUnit, k60 k60Var) {
        return skipUntil(timer(j, timeUnit, k60Var));
    }

    public final d60<T> skipLast(int i) {
        if (i >= 0) {
            return i == 0 ? this : new ObservableSkipLast(this, i);
        }
        throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count >= 0 required but it was ", i));
    }

    public final d60<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, bufferSize());
    }

    public final d60<T> skipLast(long j, TimeUnit timeUnit, k60 k60Var) {
        return skipLast(j, timeUnit, k60Var, false, bufferSize());
    }

    public final d60<T> skipLast(long j, TimeUnit timeUnit, k60 k60Var, boolean z) {
        return skipLast(j, timeUnit, k60Var, z, bufferSize());
    }

    public final d60<T> skipLast(long j, TimeUnit timeUnit, k60 k60Var, boolean z, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableSkipLastTimed(this, j, timeUnit, k60Var, i << 1, z);
    }

    public final <U> d60<T> skipUntil(h60<U> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return new ac0(this, h60Var);
    }

    public final d60<T> skipWhile(g70<? super T> g70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "predicate is null");
        return new bc0(this, g70Var);
    }

    public final d60<T> sorted() {
        l60<List<T>> list = toList();
        if (list != null) {
            return (list instanceof n70 ? ((n70) list).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : new rc0(list)).map(new Functions.Wwwwwwwwwww(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())).flatMapIterable(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        throw null;
    }

    public final d60<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final d60<T> startWith(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "item is null");
        return concatArray(just(t), this);
    }

    public final d60<T> startWith(h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return concatArray(h60Var, this);
    }

    public final d60<T> startWithArray(T... tArr) {
        d60 fromArray = fromArray(tArr);
        return fromArray == empty() ? this : concatArray(fromArray, this);
    }

    public final p60 subscribe() {
        return subscribe(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final p60 subscribe(x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var, x60<? super p60> x60Var3) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "onNext is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var2, "onError is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r60Var, "onComplete is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(x60Var, x60Var2, r60Var, x60Var3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @Override // me.tvspark.h60
    public final void subscribe(j60<? super T> j60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, "observer is null");
        try {
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, "Plugin returned null Observer");
            subscribeActual(j60Var);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(j60<? super T> j60Var);

    public final d60<T> subscribeOn(k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableSubscribeOn(this, k60Var);
    }

    public final <E extends j60<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final d60<T> switchIfEmpty(h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d60) new cc0(this, h60Var));
    }

    public final <R> d60<R> switchMap(f70<? super T, ? extends h60<? extends R>> f70Var) {
        return switchMap(f70Var, bufferSize());
    }

    public final <R> d60<R> switchMap(f70<? super T, ? extends h60<? extends R>> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        if (this instanceof r70) {
            Object call = ((r70) this).call();
            return call == null ? empty() : new tb0(call, f70Var);
        }
        return new ObservableSwitchMap(this, f70Var, i, false);
    }

    public final <R> d60<R> switchMapDelayError(f70<? super T, ? extends h60<? extends R>> f70Var) {
        return switchMapDelayError(f70Var, bufferSize());
    }

    public final <R> d60<R> switchMapDelayError(f70<? super T, ? extends h60<? extends R>> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        if (this instanceof r70) {
            Object call = ((r70) this).call();
            return call == null ? empty() : new tb0(call, f70Var);
        }
        return new ObservableSwitchMap(this, f70Var, i, true);
    }

    public final d60<T> take(long j) {
        if (j >= 0) {
            return new dc0(this, j);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count >= 0 required but it was ", j));
    }

    public final d60<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    public final d60<T> take(long j, TimeUnit timeUnit, k60 k60Var) {
        return takeUntil(timer(j, timeUnit, k60Var));
    }

    public final d60<T> takeLast(int i) {
        if (i >= 0) {
            return i == 0 ? new na0(this) : i == 1 ? new ec0(this) : new ObservableTakeLast(this, i);
        }
        throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count >= 0 required but it was ", i));
    }

    public final d60<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, bufferSize());
    }

    public final d60<T> takeLast(long j, long j2, TimeUnit timeUnit, k60 k60Var) {
        return takeLast(j, j2, timeUnit, k60Var, false, bufferSize());
    }

    public final d60<T> takeLast(long j, long j2, TimeUnit timeUnit, k60 k60Var, boolean z, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        if (j >= 0) {
            return new ObservableTakeLastTimed(this, j, j2, timeUnit, k60Var, i, z);
        }
        throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count >= 0 required but it was ", j));
    }

    public final d60<T> takeLast(long j, TimeUnit timeUnit, k60 k60Var) {
        return takeLast(j, timeUnit, k60Var, false, bufferSize());
    }

    public final d60<T> takeLast(long j, TimeUnit timeUnit, k60 k60Var, boolean z) {
        return takeLast(j, timeUnit, k60Var, z, bufferSize());
    }

    public final d60<T> takeLast(long j, TimeUnit timeUnit, k60 k60Var, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, k60Var, z, i);
    }

    public final d60<T> takeUntil(g70<? super T> g70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "predicate is null");
        return new fc0(this, g70Var);
    }

    public final <U> d60<T> takeUntil(h60<U> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return new ObservableTakeUntil(this, h60Var);
    }

    public final d60<T> takeWhile(g70<? super T> g70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g70Var, "predicate is null");
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d60) new gc0(this, g70Var));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            DisposableHelper.dispose(testObserver.Wwwwwwwwwwwwwwwww);
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final d60<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> throttleFirst(long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableThrottleFirstTimed(this, j, timeUnit, k60Var);
    }

    public final d60<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final d60<T> throttleLast(long j, TimeUnit timeUnit, k60 k60Var) {
        return sample(j, timeUnit, k60Var);
    }

    public final d60<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final d60<T> throttleWithTimeout(long j, TimeUnit timeUnit, k60 k60Var) {
        return debounce(j, timeUnit, k60Var);
    }

    public final d60<pd0<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<pd0<T>> timeInterval(TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new hc0(this, timeUnit, k60Var);
    }

    public final d60<pd0<T>> timeInterval(k60 k60Var) {
        return timeInterval(TimeUnit.MILLISECONDS, k60Var);
    }

    public final d60<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, null, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> timeout(long j, TimeUnit timeUnit, k60 k60Var) {
        return timeout0(j, timeUnit, null, k60Var);
    }

    public final d60<T> timeout(long j, TimeUnit timeUnit, k60 k60Var, h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return timeout0(j, timeUnit, h60Var, k60Var);
    }

    public final <V> d60<T> timeout(f70<? super T, ? extends h60<V>> f70Var) {
        return timeout0(null, f70Var, null);
    }

    public final <V> d60<T> timeout(f70<? super T, ? extends h60<V>> f70Var, h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return timeout0(null, f70Var, h60Var);
    }

    public final <U, V> d60<T> timeout(h60<U> h60Var, f70<? super T, ? extends h60<V>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "firstTimeoutIndicator is null");
        return timeout0(h60Var, f70Var, null);
    }

    public final <U, V> d60<T> timeout(h60<U> h60Var, f70<? super T, ? extends h60<V>> f70Var, h60<? extends T> h60Var2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "firstTimeoutIndicator is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "other is null");
        return timeout0(h60Var, f70Var, h60Var2);
    }

    public final d60<pd0<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<pd0<T>> timestamp(TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return (d60<pd0<T>>) map(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, k60Var));
    }

    public final d60<pd0<T>> timestamp(k60 k60Var) {
        return timestamp(TimeUnit.MILLISECONDS, k60Var);
    }

    /* renamed from: to */
    public final <R> R m189to(f70<? super d60<T>, R> f70Var) {
        try {
            return f70Var.apply(this);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    public final x50<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        n80 n80Var = new n80(this);
        int ordinal = backpressureStrategy.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return new FlowableOnBackpressureError(n80Var);
            }
            if (ordinal == 3) {
                return new FlowableOnBackpressureDrop(n80Var);
            }
            if (ordinal != 4) {
                int i = x50.Wwwwwwwwwwwwwwwwwwwwwwww;
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
                return new FlowableOnBackpressureBuffer(n80Var, i, true, false, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return new FlowableOnBackpressureLatest(n80Var);
        }
        return n80Var;
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new c80());
    }

    public final l60<List<T>> toList() {
        return toList(16);
    }

    public final l60<List<T>> toList(int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "capacityHint");
        return new jc0(this, i);
    }

    public final <U extends Collection<? super T>> l60<U> toList(Callable<U> callable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "collectionSupplier is null");
        return new jc0(this, callable);
    }

    public final <K> l60<Map<K, T>> toMap(f70<? super T, ? extends K> f70Var) {
        return (l60<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((f70) f70Var));
    }

    public final <K, V> l60<Map<K, V>> toMap(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "keySelector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var2, "valueSelector is null");
        return (l60<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, f70Var2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> l60<Map<K, V>> toMap(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, Callable<? extends Map<K, V>> callable) {
        return (l60<Map<K, V>>) collect(callable, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, f70Var2));
    }

    public final <K> l60<Map<K, Collection<T>>> toMultimap(f70<? super T, ? extends K> f70Var) {
        return (l60<Map<K, Collection<T>>>) toMultimap(f70Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final <K, V> l60<Map<K, Collection<V>>> toMultimap(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2) {
        return toMultimap(f70Var, f70Var2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final <K, V> l60<Map<K, Collection<V>>> toMultimap(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(f70Var, f70Var2, callable, ArrayListSupplier.asFunction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> l60<Map<K, Collection<V>>> toMultimap(f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, Callable<? extends Map<K, Collection<V>>> callable, f70<? super K, ? extends Collection<? super V>> f70Var3) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "keySelector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var2, "valueSelector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "mapSupplier is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var3, "collectionFactory is null");
        return (l60<Map<K, Collection<V>>>) collect(callable, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, f70Var2, f70Var3));
    }

    public final l60<List<T>> toSortedList() {
        return toSortedList(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> unsubscribeOn(k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return new ObservableUnsubscribeOn(this, k60Var);
    }

    public final d60<d60<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    public final d60<d60<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    public final d60<d60<T>> window(long j, long j2, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, "count");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, "skip");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        return new ObservableWindow(this, j, j2, i);
    }

    public final d60<d60<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bufferSize());
    }

    public final d60<d60<T>> window(long j, long j2, TimeUnit timeUnit, k60 k60Var) {
        return window(j, j2, timeUnit, k60Var, bufferSize());
    }

    public final d60<d60<T>> window(long j, long j2, TimeUnit timeUnit, k60 k60Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, "timespan");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, "timeskip");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        return new nc0(this, j, j2, timeUnit, k60Var, Long.MAX_VALUE, i, false);
    }

    public final d60<d60<T>> window(long j, TimeUnit timeUnit, k60 k60Var) {
        return window(j, timeUnit, k60Var, Long.MAX_VALUE, false);
    }

    public final d60<d60<T>> window(long j, TimeUnit timeUnit, k60 k60Var, long j2) {
        return window(j, timeUnit, k60Var, j2, false);
    }

    public final d60<d60<T>> window(long j, TimeUnit timeUnit, k60 k60Var, long j2, boolean z) {
        return window(j, timeUnit, k60Var, j2, z, bufferSize());
    }

    public final d60<d60<T>> window(long j, TimeUnit timeUnit, k60 k60Var, long j2, boolean z, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, "count");
        return new nc0(this, j, j, timeUnit, k60Var, j2, i, z);
    }

    public final <B> d60<d60<T>> window(Callable<? extends h60<B>> callable) {
        return window(callable, bufferSize());
    }

    public final <B> d60<d60<T>> window(Callable<? extends h60<B>> callable, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, "boundary is null");
        return new mc0(this, callable, i);
    }

    public final <B> d60<d60<T>> window(h60<B> h60Var) {
        return window(h60Var, bufferSize());
    }

    public final <B> d60<d60<T>> window(h60<B> h60Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "boundary is null");
        return new kc0(this, h60Var, i);
    }

    public final <U, V> d60<d60<T>> window(h60<U> h60Var, f70<? super U, ? extends h60<V>> f70Var) {
        return window(h60Var, f70Var, bufferSize());
    }

    public final <U, V> d60<d60<T>> window(h60<U> h60Var, f70<? super U, ? extends h60<V>> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "openingIndicator is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "closingIndicator is null");
        return new lc0(this, h60Var, f70Var, i);
    }

    public final <R> d60<R> withLatestFrom(Iterable<? extends h60<?>> iterable, f70<? super Object[], R> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "others is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "combiner is null");
        return new ObservableWithLatestFromMany(this, iterable, f70Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> d60<R> withLatestFrom(h60<T1> h60Var, h60<T2> h60Var2, h60<T3> h60Var3, h60<T4> h60Var4, a70<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> a70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "o1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "o2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var3, "o3 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var4, "o4 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a70Var, "combiner is null");
        return withLatestFrom(new h60[]{h60Var, h60Var2, h60Var3, h60Var4}, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((a70) a70Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> d60<R> withLatestFrom(h60<T1> h60Var, h60<T2> h60Var2, h60<T3> h60Var3, z60<? super T, ? super T1, ? super T2, ? super T3, R> z60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "o1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "o2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var3, "o3 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z60Var, "combiner is null");
        return withLatestFrom(new h60[]{h60Var, h60Var2, h60Var3}, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((z60) z60Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> d60<R> withLatestFrom(h60<T1> h60Var, h60<T2> h60Var2, y60<? super T, ? super T1, ? super T2, R> y60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "o1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "o2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y60Var, "combiner is null");
        return withLatestFrom(new h60[]{h60Var, h60Var2}, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((y60) y60Var));
    }

    public final <U, R> d60<R> withLatestFrom(h60<? extends U> h60Var, t60<? super T, ? super U, ? extends R> t60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var, "combiner is null");
        return new ObservableWithLatestFrom(this, t60Var, h60Var);
    }

    public final <R> d60<R> withLatestFrom(h60<?>[] h60VarArr, f70<? super Object[], R> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60VarArr, "others is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "combiner is null");
        return new ObservableWithLatestFromMany(this, h60VarArr, f70Var);
    }

    public final <U, R> d60<R> zipWith(Iterable<U> iterable, t60<? super T, ? super U, ? extends R> t60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "other is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t60Var, "zipper is null");
        return new oc0(this, iterable, t60Var);
    }

    public final <U, R> d60<R> zipWith(h60<? extends U> h60Var, t60<? super T, ? super U, ? extends R> t60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return zip(this, h60Var, t60Var);
    }

    public final <U, R> d60<R> zipWith(h60<? extends U> h60Var, t60<? super T, ? super U, ? extends R> t60Var, boolean z) {
        return zip(this, h60Var, t60Var, z);
    }

    public final <U, R> d60<R> zipWith(h60<? extends U> h60Var, t60<? super T, ? super U, ? extends R> t60Var, boolean z, int i) {
        return zip(this, h60Var, t60Var, z, i);
    }

    public static <T> d60<T> concat(Iterable<? extends h60<? extends T>> iterable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bufferSize(), false);
    }

    public static <T> d60<T> concatEager(Iterable<? extends h60<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2, false);
    }

    public static d60<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <T> d60<T> merge(h60<? extends h60<? extends T>> h60Var, int i) {
        return new ObservableFlatMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, i, bufferSize());
    }

    public static <T> d60<T> mergeArray(h60<? extends T>... h60VarArr) {
        return fromArray(h60VarArr).flatMap(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, h60VarArr.length);
    }

    public static <T> d60<T> mergeArrayDelayError(h60<? extends T>... h60VarArr) {
        return fromArray(h60VarArr).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, h60VarArr.length);
    }

    public static <T> d60<T> mergeDelayError(h60<? extends h60<? extends T>> h60Var, int i) {
        return new ObservableFlatMap(h60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, i, bufferSize());
    }

    public static <T> l60<Boolean> sequenceEqual(h60<? extends T> h60Var, h60<? extends T> h60Var2, int i) {
        return sequenceEqual(h60Var, h60Var2, l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
    }

    public final d60<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.MAX_VALUE);
    }

    public final d60<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z);
    }

    public final d60<T> distinctUntilChanged(u60<? super T, ? super T> u60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u60Var, "comparer is null");
        return new v90(this, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, u60Var);
    }

    public final <R> d60<R> flatMap(f70<? super T, ? extends h60<? extends R>> f70Var, boolean z, int i, int i2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "mapper is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "maxConcurrency");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "bufferSize");
        if (this instanceof r70) {
            Object call = ((r70) this).call();
            return call == null ? empty() : new tb0(call, f70Var);
        }
        return new ObservableFlatMap(this, f70Var, z, i, i2);
    }

    public final <K> d60<hd0<K, T>> groupBy(f70<? super T, ? extends K> f70Var, boolean z) {
        return (d60<hd0<K, T>>) groupBy(f70Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, bufferSize());
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "selector is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new qa0(this, i), f70Var);
    }

    public final d60<T> retry(long j) {
        return retry(j, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, bufferSize());
    }

    public final d60<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, bufferSize());
    }

    public final d60<pd0<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> timeout(long j, TimeUnit timeUnit, h60<? extends T> h60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "other is null");
        return timeout0(j, timeUnit, h60Var, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<pd0<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final l60<List<T>> toSortedList(int i) {
        return toSortedList(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwww, i);
    }

    public final d60<d60<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Long.MAX_VALUE, false);
    }

    public final T blockingSingle(T t) {
        l60<T> single = single(t);
        if (single != null) {
            z70 z70Var = new z70();
            single.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z70Var);
            return (T) z70Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public static <T, S> d60<T> generate(Callable<S> callable, s60<S, w50<T>> s60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s60Var, "generator  is null");
        return generate(callable, new db0(s60Var), Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <T> d60<T> merge(h60<? extends T> h60Var, h60<? extends T> h60Var2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "source2 is null");
        return fromArray(h60Var, h60Var2).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, 2);
    }

    public static <T> d60<T> mergeDelayError(h60<? extends T> h60Var, h60<? extends T> h60Var2) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "source2 is null");
        return fromArray(h60Var, h60Var2).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, 2);
    }

    public final d60<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
    }

    public final <U> d60<T> delay(f70<? super T, ? extends h60<U>> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "itemDelay is null");
        return (d60<T>) flatMap(new xa0(f70Var));
    }

    public final <K> d60<T> distinctUntilChanged(f70<? super T, K> f70Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "keySelector is null");
        return new v90(this, f70Var, l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> doOnEach(x60<? super c60<T>> x60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var, "consumer is null");
        return doOnEach(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((x60) x60Var), new Functions.Wwwwwwwww(x60Var), new Functions.Wwwwwwwwww(x60Var), Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var, int i, long j, TimeUnit timeUnit) {
        return replay(f70Var, i, j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final p60 subscribe(x60<? super T> x60Var) {
        return subscribe(x60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, bufferSize());
    }

    public final l60<List<T>> toSortedList(Comparator<? super T> comparator) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, "comparator is null");
        l60<List<T>> list = toList();
        f70 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator) comparator);
        if (list != null) {
            return new qc0(list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        throw null;
    }

    public final d60<d60<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, false);
    }

    public final l60<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, "comparator is null");
        l60<List<T>> list = toList(i);
        f70 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator) comparator);
        if (list != null) {
            return new qc0(list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        throw null;
    }

    public static <T> d60<T> merge(h60<? extends T> h60Var, h60<? extends T> h60Var2, h60<? extends T> h60Var3) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "source2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var3, "source3 is null");
        return fromArray(h60Var, h60Var2, h60Var3).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, 3);
    }

    public static <T> d60<T> mergeDelayError(h60<? extends T> h60Var, h60<? extends T> h60Var2, h60<? extends T> h60Var3) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "source2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var3, "source3 is null");
        return fromArray(h60Var, h60Var2, h60Var3).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, 3);
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var, int i, long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "bufferSize");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "selector is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ra0(this, i, j, timeUnit, k60Var), f70Var);
    }

    public final p60 subscribe(x60<? super T> x60Var, x60<? super Throwable> x60Var2) {
        return subscribe(x60Var, x60Var2, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final d60<d60<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, z);
    }

    public static <T, S> d60<T> generate(Callable<S> callable, s60<S, w50<T>> s60Var, x60<? super S> x60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s60Var, "generator  is null");
        return generate(callable, new db0(s60Var), x60Var);
    }

    public final d60<T> sorted(Comparator<? super T> comparator) {
        l60<List<T>> list = toList();
        if (list != null) {
            return (list instanceof n70 ? ((n70) list).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : new rc0(list)).map(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator) comparator)).flatMapIterable(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        throw null;
    }

    public static <T> d60<T> merge(h60<? extends T> h60Var, h60<? extends T> h60Var2, h60<? extends T> h60Var3, h60<? extends T> h60Var4) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "source2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var3, "source3 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var4, "source4 is null");
        return fromArray(h60Var, h60Var2, h60Var3, h60Var4).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, 4);
    }

    public static <T> d60<T> mergeDelayError(h60<? extends T> h60Var, h60<? extends T> h60Var2, h60<? extends T> h60Var3, h60<? extends T> h60Var4) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, "source1 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var2, "source2 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var3, "source3 is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var4, "source4 is null");
        return fromArray(h60Var, h60Var2, h60Var3, h60Var4).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, 4);
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var, int i, k60 k60Var) {
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new qa0(this, i), new ta0(f70Var, k60Var));
    }

    public final p60 subscribe(x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var) {
        return subscribe(x60Var, x60Var2, r60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <T, S> d60<T> generate(Callable<S> callable, t60<S, w50<T>, S> t60Var) {
        return generate(callable, t60Var, Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <T> d60<T> merge(Iterable<? extends h60<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <T> d60<T> mergeDelayError(Iterable<? extends h60<? extends T>> iterable) {
        return fromIterable(iterable).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var, long j, TimeUnit timeUnit) {
        return replay(f70Var, j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static <T> d60<T> merge(Iterable<? extends h60<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
    }

    public static <T> d60<T> mergeDelayError(Iterable<? extends h60<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, i);
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var, long j, TimeUnit timeUnit, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "selector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new sa0(this, j, timeUnit, k60Var), f70Var);
    }

    public static <T> d60<T> merge(Iterable<? extends h60<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, i, i2);
    }

    public static <T> d60<T> mergeDelayError(Iterable<? extends h60<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap((f70) Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, i, i2);
    }

    public final <R> d60<R> replay(f70<? super d60<T>, ? extends h60<R>> f70Var, k60 k60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f70Var, "selector is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new pa0(this), new ta0(f70Var, k60Var));
    }

    public final gd0<T> replay() {
        return ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, ObservableReplay.Wwwwwwwwwwwwwwwwwwww);
    }

    public final gd0<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final gd0<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, od0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
