package retrofit2.adapter.rxjava2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import me.tvspark.d60;
import me.tvspark.k60;
import me.tvspark.l60;
import me.tvspark.t50;
import me.tvspark.x50;
import me.tvspark.z50;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    public final boolean isAsync;
    public final k60 scheduler;

    public RxJava2CallAdapterFactory(k60 k60Var, boolean z) {
        this.scheduler = k60Var;
        this.isAsync = z;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(k60 k60Var) {
        if (k60Var != null) {
            return new RxJava2CallAdapterFactory(k60Var, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == t50.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean z3 = rawType == x50.class;
        boolean z4 = rawType == l60.class;
        boolean z5 = rawType == z50.class;
        if (rawType != d60.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (!(parameterUpperBound instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z = false;
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z = false;
            z2 = true;
            return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z, z2, z3, z4, z5, false);
        } else if (!(parameterUpperBound instanceof ParameterizedType)) {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        } else {
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z = true;
        }
        z2 = false;
        return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z, z2, z3, z4, z5, false);
    }
}
