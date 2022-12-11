package org.mozilla.javascript;

import androidx.core.app.NotificationCompat;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.SoftReference;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.SecureClassLoader;
import java.util.Map;
import java.util.WeakHashMap;
import me.tvspark.outline;
import org.mozilla.classfile.ClassFileWriter;

/* loaded from: classes5.dex */
public class PolicySecurityController extends SecurityController {
    public static final byte[] secureCallerImplBytecode = loadBytecode();
    public static final Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> callers = new WeakHashMap();

    /* loaded from: classes5.dex */
    public static class Loader extends SecureClassLoader implements GeneratedClassLoader {
        public final CodeSource codeSource;

        public Loader(ClassLoader classLoader, CodeSource codeSource) {
            super(classLoader);
            this.codeSource = codeSource;
        }

        @Override // org.mozilla.javascript.GeneratedClassLoader
        public Class<?> defineClass(String str, byte[] bArr) {
            return defineClass(str, bArr, 0, bArr.length, this.codeSource);
        }

        @Override // org.mozilla.javascript.GeneratedClassLoader
        public void linkClass(Class<?> cls) {
            resolveClass(cls);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class SecureCaller {
        public abstract Object call(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);
    }

    public static byte[] loadBytecode() {
        String name = SecureCaller.class.getName();
        ClassFileWriter classFileWriter = new ClassFileWriter(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "Impl"), name, "<generated>");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<init>", "()V", (short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, name, "<init>", "()V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        for (int i = 1; i < 6; i++) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NormalCmdFactory.TASK_CANCEL_ALL, "org/mozilla/javascript/Callable", NotificationCompat.CATEGORY_CALL, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(", "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;"));
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 6);
        return classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.javascript.SecurityController
    public Object callWithDomain(Object obj, final Context context, Callable callable, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Map<ClassLoader, SoftReference<SecureCaller>> map;
        SecureCaller secureCaller;
        final ClassLoader classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.mozilla.javascript.PolicySecurityController.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return context.getApplicationClassLoader();
            }
        });
        final CodeSource codeSource = (CodeSource) obj;
        synchronized (callers) {
            map = callers.get(codeSource);
            if (map == null) {
                map = new WeakHashMap<>();
                callers.put(codeSource, map);
            }
        }
        synchronized (map) {
            SoftReference<SecureCaller> softReference = map.get(classLoader);
            SecureCaller secureCaller2 = softReference != null ? softReference.get() : null;
            if (secureCaller2 == null) {
                try {
                    secureCaller2 = (SecureCaller) AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: org.mozilla.javascript.PolicySecurityController.3
                        @Override // java.security.PrivilegedExceptionAction
                        public Object run() throws Exception {
                            Loader loader = new Loader(classLoader, codeSource);
                            return loader.defineClass(SecureCaller.class.getName() + "Impl", PolicySecurityController.secureCallerImplBytecode).newInstance();
                        }
                    });
                    map.put(classLoader, new SoftReference<>(secureCaller2));
                } catch (PrivilegedActionException e) {
                    throw new UndeclaredThrowableException(e.getCause());
                }
            }
            secureCaller = secureCaller2;
        }
        return secureCaller.call(callable, context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.SecurityController
    public GeneratedClassLoader createClassLoader(final ClassLoader classLoader, final Object obj) {
        return (Loader) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.mozilla.javascript.PolicySecurityController.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return new Loader(classLoader, (CodeSource) obj);
            }
        });
    }

    @Override // org.mozilla.javascript.SecurityController
    public Object getDynamicSecurityDomain(Object obj) {
        return obj;
    }

    @Override // org.mozilla.javascript.SecurityController
    public Class<?> getStaticSecurityDomainClassInternal() {
        return CodeSource.class;
    }
}
