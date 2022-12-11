package retrofit2;

import androidx.core.app.NotificationCompat;
import com.just.agentweb.JsCallJava;
import com.umeng.analytics.pro.C1543ak;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mg0;
import me.tvspark.of0;
import me.tvspark.r40;

@ef0
/* loaded from: classes5.dex */
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, mg0<? super T> mg0Var) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((mg0) mg0Var), 1);
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new C3414x19835f10(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, NotificationCompat.CATEGORY_CALL);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, C1543ak.f2971aH);
                Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                cancellableContinuation.resumeWith(Result.m4870constructorimpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                mg0 mg0Var2;
                Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, NotificationCompat.CATEGORY_CALL);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
                if (response.isSuccessful()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = response.body();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        Object tag = call2.request().tag(Invocation.class);
                        if (tag == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tag, "call.request().tag(Invocation::class.java)!!");
                        Method method = ((Invocation) tag).method();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Response from ");
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, JsCallJava.KEY_METHOD);
                        Class<?> declaringClass = method.getDeclaringClass();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) declaringClass, "method.declaringClass");
                        sb.append(declaringClass.getName());
                        sb.append('.');
                        sb.append(method.getName());
                        sb.append(" was null but response body type was declared as non-null");
                        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                        mg0Var2 = (mg0) cancellableContinuation;
                        Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) kotlinNullPointerException);
                    } else {
                        mg0Var2 = (mg0) cancellableContinuation;
                        Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Result.Companion;
                    }
                } else {
                    mg0Var2 = cancellableContinuation;
                    HttpException httpException = new HttpException(response);
                    Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Result.Companion;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) httpException);
                }
                mg0Var2.resumeWith(Result.m4870constructorimpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "frame");
        }
        return result;
    }

    public static final <T> Object awaitNullable(Call<T> call, mg0<? super T> mg0Var) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((mg0) mg0Var), 1);
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new C3415x19835f11(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, NotificationCompat.CATEGORY_CALL);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, C1543ak.f2971aH);
                Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                cancellableContinuation.resumeWith(Result.m4870constructorimpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                mg0 mg0Var2;
                Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, NotificationCompat.CATEGORY_CALL);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
                if (response.isSuccessful()) {
                    mg0Var2 = (mg0) cancellableContinuation;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = response.body();
                    Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                } else {
                    mg0Var2 = cancellableContinuation;
                    HttpException httpException = new HttpException(response);
                    Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Result.Companion;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) httpException);
                }
                mg0Var2.resumeWith(Result.m4870constructorimpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "frame");
        }
        return result;
    }

    public static final <T> Object awaitResponse(Call<T> call, mg0<? super Response<T>> mg0Var) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((mg0) mg0Var), 1);
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new C3416xc95e9eb1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, NotificationCompat.CATEGORY_CALL);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, C1543ak.f2971aH);
                Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                cancellableContinuation.resumeWith(Result.m4870constructorimpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, NotificationCompat.CATEGORY_CALL);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
                Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                cancellableContinuation.resumeWith(Result.m4870constructorimpl(response));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "frame");
        }
        return result;
    }

    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(retrofit, "$this$create");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object suspendAndThrow(final Exception exc, mg0<?> mg0Var) {
        final KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        int i;
        if (mg0Var instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) mg0Var;
            int i2 = kotlinExtensions$suspendAndThrow$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.label = i2 - Integer.MIN_VALUE;
                Object obj = kotlinExtensions$suspendAndThrow$1.result;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                i = kotlinExtensions$suspendAndThrow$1.label;
                if (i != 0) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                    kotlinExtensions$suspendAndThrow$1.L$0 = exc;
                    kotlinExtensions$suspendAndThrow$1.label = 1;
                    Dispatchers.getDefault().dispatch(kotlinExtensions$suspendAndThrow$1.getContext(), new Runnable() { // from class: retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            mg0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0.this);
                            Exception exc2 = exc;
                            Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.resumeWith(Result.m4870constructorimpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) exc2)));
                        }
                    });
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (coroutineSingletons2 == coroutineSingletons2) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kotlinExtensions$suspendAndThrow$1, "frame");
                    }
                    if (coroutineSingletons2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Exception exc2 = (Exception) kotlinExtensions$suspendAndThrow$1.L$0;
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                }
                return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(mg0Var);
        Object obj2 = kotlinExtensions$suspendAndThrow$1.result;
        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        i = kotlinExtensions$suspendAndThrow$1.label;
        if (i != 0) {
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
