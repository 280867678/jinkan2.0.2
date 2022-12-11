package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class ButterKnife {
    @VisibleForTesting
    public static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
    public static final String TAG = "ButterKnife";
    public static boolean debug;

    public ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Activity activity) {
        return bind(activity, activity.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Dialog dialog) {
        return bind(dialog, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull View view) {
        return bind(view, view);
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull View view) {
        Class<?> cls = obj.getClass();
        if (debug) {
            cls.getName();
        }
        Constructor<? extends Unbinder> findBindingConstructorForClass = findBindingConstructorForClass(cls);
        if (findBindingConstructorForClass == null) {
            return Unbinder.EMPTY;
        }
        try {
            return findBindingConstructorForClass.newInstance(obj, view);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (!(cause instanceof Error)) {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
            throw ((Error) cause);
        }
    }

    @Nullable
    @CheckResult
    @UiThread
    public static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> cls) {
        Constructor<? extends Unbinder> findBindingConstructorForClass;
        Constructor<? extends Unbinder> constructor = BINDINGS.get(cls);
        if (constructor != null || BINDINGS.containsKey(cls)) {
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            return null;
        }
        try {
            ClassLoader classLoader = cls.getClassLoader();
            findBindingConstructorForClass = classLoader.loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
        } catch (ClassNotFoundException unused) {
            if (debug) {
                cls.getSuperclass().getName();
            }
            findBindingConstructorForClass = findBindingConstructorForClass(cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to find binding constructor for ", name), e);
        }
        BINDINGS.put(cls, findBindingConstructorForClass);
        return findBindingConstructorForClass;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }
}
