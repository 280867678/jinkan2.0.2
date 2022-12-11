package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import me.tvspark.mg0;
import me.tvspark.outline;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Utils;

/* loaded from: classes5.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    public final Call.Factory callFactory;
    public final RequestFactory requestFactory;
    public final Converter<ResponseBody, ResponseT> responseConverter;

    /* loaded from: classes5.dex */
    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        public final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        public ReturnT adapt(Call<ResponseT> call, Object[] objArr) {
            return this.callAdapter.mo5338adapt(call);
        }
    }

    /* loaded from: classes5.dex */
    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        public final boolean isNullable;

        public SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter, boolean z) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
            this.isNullable = z;
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> mo5338adapt = this.callAdapter.mo5338adapt(call);
            mg0 mg0Var = (mg0) objArr[objArr.length - 1];
            try {
                return this.isNullable ? KotlinExtensions.awaitNullable(mo5338adapt, mg0Var) : KotlinExtensions.await(mo5338adapt, mg0Var);
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, mg0Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        public SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> mo5338adapt = this.callAdapter.mo5338adapt(call);
            mg0 mg0Var = (mg0) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.awaitResponse(mo5338adapt, mg0Var);
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, mg0Var);
            }
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    public static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (CallAdapter<ResponseT, ReturnT>) retrofit.callAdapter(type, annotationArr);
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create call adapter for %s", type);
        }
    }

    public static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        Type genericReturnType;
        boolean z;
        boolean z2 = requestFactory.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(parameterLowerBound) != Response.class || !(parameterLowerBound instanceof ParameterizedType)) {
                z = false;
            } else {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z = true;
            }
            genericReturnType = new Utils.ParameterizedTypeImpl(null, Call.class, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method, genericReturnType, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == okhttp3.Response.class) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("'");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Utils.getRawType(responseType).getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' is not a valid response body type. Did you mean ResponseBody?");
            throw Utils.methodError(method, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        } else if (responseType == Response.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else {
            if (requestFactory.httpMethod.equals("HEAD") && !Void.class.equals(responseType)) {
                throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
            }
            Converter createResponseConverter = createResponseConverter(retrofit, method, responseType);
            Call.Factory factory = retrofit.callFactory;
            return !z2 ? new CallAdapted(requestFactory, factory, createResponseConverter, createCallAdapter) : z ? new SuspendForResponse(requestFactory, factory, createResponseConverter, createCallAdapter) : new SuspendForBody(requestFactory, factory, createResponseConverter, createCallAdapter, false);
        }
    }

    public abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    @Override // retrofit2.ServiceMethod
    public final ReturnT invoke(Object[] objArr) {
        return adapt(new OkHttpCall(this.requestFactory, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
