package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
import me.tvspark.hj0;
import me.tvspark.ji0;
import me.tvspark.jj0;
import me.tvspark.ki0;
import me.tvspark.tj0;

/* loaded from: classes4.dex */
public abstract class CallableReference implements hj0, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;
    public final boolean isTopLevel;
    public final String name;
    public final Class owner;
    public final Object receiver;
    public transient hj0 reflected;
    public final String signature;

    /* loaded from: classes4.dex */
    public static class NoReceiver implements Serializable {
        public static final NoReceiver INSTANCE = new NoReceiver();

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // me.tvspark.hj0
    public Object call(Object... objArr) {
        return mo4906getReflected().call(objArr);
    }

    @Override // me.tvspark.hj0
    public Object callBy(Map map) {
        return mo4906getReflected().callBy(map);
    }

    public hj0 compute() {
        hj0 hj0Var = this.reflected;
        if (hj0Var == null) {
            hj0 computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return hj0Var;
    }

    public abstract hj0 computeReflected();

    @Override // me.tvspark.gj0
    public List<Annotation> getAnnotations() {
        return mo4906getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public jj0 getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            if (ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                throw null;
            }
            return new ji0(cls, "");
        }
        return ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
    }

    @Override // me.tvspark.hj0
    public List<KParameter> getParameters() {
        return mo4906getReflected().getParameters();
    }

    /* renamed from: getReflected */
    public hj0 mo4906getReflected() {
        hj0 compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // me.tvspark.hj0
    public tj0 getReturnType() {
        return mo4906getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // me.tvspark.hj0
    public List<Object> getTypeParameters() {
        return mo4906getReflected().getTypeParameters();
    }

    @Override // me.tvspark.hj0
    public KVisibility getVisibility() {
        return mo4906getReflected().getVisibility();
    }

    @Override // me.tvspark.hj0
    public boolean isAbstract() {
        return mo4906getReflected().isAbstract();
    }

    @Override // me.tvspark.hj0
    public boolean isFinal() {
        return mo4906getReflected().isFinal();
    }

    @Override // me.tvspark.hj0
    public boolean isOpen() {
        return mo4906getReflected().isOpen();
    }

    @Override // me.tvspark.hj0
    public boolean isSuspend() {
        return mo4906getReflected().isSuspend();
    }
}
