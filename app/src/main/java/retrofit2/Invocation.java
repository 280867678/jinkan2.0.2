package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class Invocation {
    public final List<?> arguments;
    public final Method method;

    public Invocation(Method method, List<?> list) {
        this.method = method;
        this.arguments = Collections.unmodifiableList(list);
    }

    /* renamed from: of */
    public static Invocation m10of(Method method, List<?> list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new Invocation(method, new ArrayList(list));
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public Method method() {
        return this.method;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments);
    }
}
