package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes5.dex */
public class Platform {
    public static final Platform PLATFORM = findPlatform();
    public final boolean hasJava8Types;
    public final Constructor<MethodHandles.Lookup> lookupConstructor;

    /* loaded from: classes5.dex */
    public static final class Android extends Platform {

        /* loaded from: classes5.dex */
        public static final class MainThreadExecutor implements Executor {
            public final Handler handler = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        public Android() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.invokeDefaultMethod(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    public Platform(boolean z) {
        this.hasJava8Types = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.lookupConstructor = constructor;
    }

    public static Platform findPlatform() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new Android() : new Platform(true);
    }

    public static Platform get() {
        return PLATFORM;
    }

    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        return this.hasJava8Types ? Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory);
    }

    public int defaultCallAdapterFactoriesSize() {
        return this.hasJava8Types ? 2 : 1;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    public List<? extends Converter.Factory> defaultConverterFactories() {
        return this.hasJava8Types ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList();
    }

    public int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.lookupConstructor;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    public boolean isDefaultMethod(Method method) {
        return this.hasJava8Types && method.isDefault();
    }
}
