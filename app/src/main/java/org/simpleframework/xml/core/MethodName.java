package org.simpleframework.xml.core;

import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class MethodName {
    public Method method;
    public String name;
    public MethodType type;

    public MethodName(Method method, MethodType methodType, String str) {
        this.method = method;
        this.type = methodType;
        this.name = str;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }

    public MethodType getType() {
        return this.type;
    }
}
