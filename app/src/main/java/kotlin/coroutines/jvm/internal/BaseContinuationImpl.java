package kotlin.coroutines.jvm.internal;

import androidx.core.app.NotificationCompatJellybean;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mg0;
import me.tvspark.of0;
import me.tvspark.outline;
import me.tvspark.qg0;
import me.tvspark.r40;
import me.tvspark.rg0;
import me.tvspark.sg0;

@ef0
/* loaded from: classes4.dex */
public abstract class BaseContinuationImpl implements mg0<Object>, qg0, Serializable {
    public final mg0<Object> completion;

    public BaseContinuationImpl(mg0<Object> mg0Var) {
        this.completion = mg0Var;
    }

    public mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public mg0<of0> create(mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public qg0 getCallerFrame() {
        mg0<Object> mg0Var = this.completion;
        if (!(mg0Var instanceof qg0)) {
            mg0Var = null;
        }
        return (qg0) mg0Var;
    }

    public final mg0<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int i;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "$this$getStackTraceElementImpl");
        rg0 rg0Var = (rg0) getClass().getAnnotation(rg0.class);
        String str2 = null;
        if (rg0Var != null) {
            int m184v = rg0Var.m184v();
            if (m184v <= 1) {
                int i2 = -1;
                try {
                    Field declaredField = getClass().getDeclaredField(NotificationCompatJellybean.KEY_LABEL);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(declaredField, "field");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this);
                    if (!(obj instanceof Integer)) {
                        obj = null;
                    }
                    Integer num = (Integer) obj;
                    i = (num != null ? num.intValue() : 0) - 1;
                } catch (Exception unused) {
                    i = -1;
                }
                if (i >= 0) {
                    i2 = rg0Var.m186l()[i];
                }
                sg0 sg0Var = sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "continuation");
                sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    try {
                        sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
                        sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    } catch (Exception unused2) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != sg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (method = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && (invoke = method.invoke(getClass(), new Object[0])) != null && (method2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && (invoke2 = method2.invoke(invoke, new Object[0])) != null) {
                    Method method3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
                    if (invoke3 instanceof String) {
                        str2 = invoke3;
                    }
                    str2 = str2;
                }
                if (str2 == null) {
                    str = rg0Var.m188c();
                } else {
                    str = str2 + '/' + rg0Var.m188c();
                }
                return new StackTraceElement(str, rg0Var.m185m(), rg0Var.m187f(), i2);
            }
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Debug metadata version mismatch. Expected: ", 1, ", got ", m184v, ". Please update the Kotlin standard library.").toString());
        }
        return null;
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // me.tvspark.mg0
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseContinuationImpl, "frame");
            mg0<Object> mg0Var = baseContinuationImpl.completion;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Result.Companion;
                obj = Result.m4870constructorimpl(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th));
            }
            if (invokeSuspend == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
            Result.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Result.Companion;
            obj = Result.m4870constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (!(mg0Var instanceof BaseContinuationImpl)) {
                mg0Var.resumeWith(obj);
                return;
            }
            baseContinuationImpl = (BaseContinuationImpl) mg0Var;
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
