package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public abstract class ServiceMethod<T> {
    public static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method) {
        RequestFactory parseAnnotations = RequestFactory.parseAnnotations(retrofit, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!Utils.hasUnresolvableType(genericReturnType)) {
            if (genericReturnType == Void.TYPE) {
                throw Utils.methodError(method, "Service methods cannot return void.", new Object[0]);
            }
            return HttpServiceMethod.parseAnnotations(retrofit, method, parseAnnotations);
        }
        throw Utils.methodError(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }

    public abstract T invoke(Object[] objArr);
}
