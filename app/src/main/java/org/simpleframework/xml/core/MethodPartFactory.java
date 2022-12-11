package org.simpleframework.xml.core;

import com.umeng.analytics.pro.C1543ak;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class MethodPartFactory {
    public final AnnotationFactory factory;

    public MethodPartFactory(Detail detail, Support support) {
        this.factory = new AnnotationFactory(detail, support);
    }

    private Annotation getAnnotation(Method method) throws Exception {
        Class[] dependents = getDependents(method);
        Class type = getType(method);
        if (type != null) {
            return this.factory.getInstance(type, dependents);
        }
        return null;
    }

    private Class[] getDependents(Method method) throws Exception {
        MethodType methodType = getMethodType(method);
        if (methodType == MethodType.SET) {
            return Reflector.getParameterDependents(method, 0);
        }
        if (methodType != MethodType.GET && methodType != MethodType.IS) {
            return null;
        }
        return Reflector.getReturnDependents(method);
    }

    private MethodType getMethodType(Method method) {
        String name = method.getName();
        return name.startsWith("get") ? MethodType.GET : name.startsWith(C1543ak.f2994ae) ? MethodType.IS : name.startsWith("set") ? MethodType.SET : MethodType.NONE;
    }

    private MethodName getName(Method method, Annotation annotation) throws Exception {
        MethodType methodType = getMethodType(method);
        if (methodType != MethodType.GET && methodType != MethodType.IS) {
            if (methodType != MethodType.SET) {
                throw new MethodException("Annotation %s must mark a set or get method", annotation);
            }
            return getWrite(method, methodType);
        }
        return getRead(method, methodType);
    }

    private Class getParameterType(Method method) throws Exception {
        if (method.getParameterTypes().length == 1) {
            return method.getParameterTypes()[0];
        }
        return null;
    }

    private MethodName getRead(Method method, MethodType methodType) throws Exception {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String name = method.getName();
        if (parameterTypes.length == 0) {
            String typeName = getTypeName(name, methodType);
            if (typeName == null) {
                throw new MethodException("Could not get name for %s", method);
            }
            return new MethodName(method, methodType, typeName);
        }
        throw new MethodException("Get method %s is not a valid property", method);
    }

    private Class getReturnType(Method method) throws Exception {
        if (method.getParameterTypes().length == 0) {
            return method.getReturnType();
        }
        return null;
    }

    private String getTypeName(String str, MethodType methodType) {
        int prefix = methodType.getPrefix();
        int length = str.length();
        if (length > prefix) {
            str = str.substring(prefix, length);
        }
        return Reflector.getName(str);
    }

    private MethodName getWrite(Method method, MethodType methodType) throws Exception {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String name = method.getName();
        if (parameterTypes.length == 1) {
            String typeName = getTypeName(name, methodType);
            if (typeName == null) {
                throw new MethodException("Could not get name for %s", method);
            }
            return new MethodName(method, methodType, typeName);
        }
        throw new MethodException("Set method %s is not a valid property", method);
    }

    public MethodPart getInstance(Method method, Annotation annotation, Annotation[] annotationArr) throws Exception {
        MethodName name = getName(method, annotation);
        return name.getType() == MethodType.SET ? new SetPart(name, annotation, annotationArr) : new GetPart(name, annotation, annotationArr);
    }

    public MethodPart getInstance(Method method, Annotation[] annotationArr) throws Exception {
        Annotation annotation = getAnnotation(method);
        if (annotation != null) {
            return getInstance(method, annotation, annotationArr);
        }
        return null;
    }

    public Class getType(Method method) throws Exception {
        MethodType methodType = getMethodType(method);
        if (methodType == MethodType.SET) {
            return getParameterType(method);
        }
        if (methodType != MethodType.GET && methodType != MethodType.IS) {
            return null;
        }
        return getReturnType(method);
    }
}
