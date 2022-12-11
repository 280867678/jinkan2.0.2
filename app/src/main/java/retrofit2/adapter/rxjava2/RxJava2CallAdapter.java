package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import java.lang.reflect.Type;
import me.tvspark.d60;
import me.tvspark.k60;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* loaded from: classes5.dex */
public final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    public final boolean isAsync;
    public final boolean isBody;
    public final boolean isCompletable;
    public final boolean isFlowable;
    public final boolean isMaybe;
    public final boolean isResult;
    public final boolean isSingle;
    public final Type responseType;
    public final k60 scheduler;

    public RxJava2CallAdapter(Type type, k60 k60Var, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.responseType = type;
        this.scheduler = k60Var;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isFlowable = z4;
        this.isSingle = z5;
        this.isMaybe = z6;
        this.isCompletable = z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // retrofit2.CallAdapter
    /* renamed from: adapt */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo5338adapt(Call<R> call) {
        d60 bodyObservable;
        k60 k60Var;
        d60 callEnqueueObservable = this.isAsync ? new CallEnqueueObservable(call) : new CallExecuteObservable(call);
        if (!this.isResult) {
            if (this.isBody) {
                bodyObservable = new BodyObservable(callEnqueueObservable);
            }
            k60Var = this.scheduler;
            if (k60Var != null) {
                callEnqueueObservable = callEnqueueObservable.subscribeOn(k60Var);
            }
            return !this.isFlowable ? callEnqueueObservable.toFlowable(BackpressureStrategy.LATEST) : this.isSingle ? callEnqueueObservable.singleOrError() : this.isMaybe ? callEnqueueObservable.singleElement() : this.isCompletable ? callEnqueueObservable.ignoreElements() : callEnqueueObservable;
        }
        bodyObservable = new ResultObservable(callEnqueueObservable);
        callEnqueueObservable = bodyObservable;
        k60Var = this.scheduler;
        if (k60Var != null) {
        }
        if (!this.isFlowable) {
        }
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
