package me.tvspark;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;

/* loaded from: classes4.dex */
public interface hj0<R> extends gj0 {
    R call(Object... objArr);

    R callBy(Map<KParameter, ? extends Object> map);

    List<KParameter> getParameters();

    tj0 getReturnType();

    List<Object> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
