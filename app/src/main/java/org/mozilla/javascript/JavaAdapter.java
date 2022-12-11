package org.mozilla.javascript;

import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import me.tvspark.h21;
import me.tvspark.outline;
import org.apache.http.message.BasicHeaderValueParser;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.optimizer.OptRuntime;
import org.simpleframework.xml.core.AnnotationHandler;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class JavaAdapter implements IdFunctionCall {
    public static final Object FTAG = "JavaAdapter";
    public static final int Id_JavaAdapter = 1;

    /* loaded from: classes5.dex */
    public static class JavaAdapterSignature {
        public Class<?>[] interfaces;
        public ObjToIntMap names;
        public Class<?> superClass;

        public JavaAdapterSignature(Class<?> cls, Class<?>[] clsArr, ObjToIntMap objToIntMap) {
            this.superClass = cls;
            this.interfaces = clsArr;
            this.names = objToIntMap;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof JavaAdapterSignature)) {
                return false;
            }
            JavaAdapterSignature javaAdapterSignature = (JavaAdapterSignature) obj;
            if (this.superClass != javaAdapterSignature.superClass) {
                return false;
            }
            Class<?>[] clsArr = this.interfaces;
            Class<?>[] clsArr2 = javaAdapterSignature.interfaces;
            if (clsArr != clsArr2) {
                if (clsArr.length == clsArr2.length) {
                    int i = 0;
                    while (true) {
                        Class<?>[] clsArr3 = this.interfaces;
                        if (i >= clsArr3.length) {
                            break;
                        } else if (clsArr3[i] != javaAdapterSignature.interfaces[i]) {
                            return false;
                        } else {
                            i++;
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.names.size() != javaAdapterSignature.names.size()) {
                return false;
            }
            ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(this.names);
            iterator.start();
            while (!iterator.done()) {
                int value = iterator.getValue();
                if (value != javaAdapterSignature.names.get((String) iterator.getKey(), value + 1)) {
                    return false;
                }
                iterator.next();
            }
            return true;
        }

        public int hashCode() {
            return (this.superClass.hashCode() + Arrays.hashCode(this.interfaces)) ^ this.names.size();
        }
    }

    public static /* synthetic */ ScriptableObject Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Script script, Context context) {
        ScriptableObject global = ScriptRuntime.getGlobal(context);
        script.exec(context, global);
        return global;
    }

    public static int appendMethodSignature(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append('(');
        int length = clsArr.length + 1;
        for (Class<?> cls2 : clsArr) {
            appendTypeString(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                length++;
            }
        }
        sb.append(')');
        appendTypeString(sb, cls);
        return length;
    }

    public static void appendOverridableMethods(Class<?> cls, ArrayList<Method> arrayList, HashSet<String> hashSet) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            String str = declaredMethods[i].getName() + getMethodSignature(declaredMethods[i], declaredMethods[i].getParameterTypes());
            if (!hashSet.contains(str)) {
                int modifiers = declaredMethods[i].getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (!Modifier.isFinal(modifiers)) {
                        if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                            arrayList.add(declaredMethods[i]);
                        }
                    }
                    hashSet.add(str);
                }
            }
        }
    }

    public static StringBuilder appendTypeString(StringBuilder sb, Class<?> cls) {
        char c;
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            c = cls == Boolean.TYPE ? 'Z' : cls == Long.TYPE ? 'J' : Character.toUpperCase(cls.getName().charAt(0));
        } else {
            sb.append('L');
            sb.append(cls.getName().replace('.', '/'));
            c = BasicHeaderValueParser.PARAM_DELIMITER;
        }
        sb.append(c);
        return sb;
    }

    public static Object callMethod(ContextFactory contextFactory, final Scriptable scriptable, final Function function, final Object[] objArr, final long j) {
        if (function == null) {
            return null;
        }
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        final Scriptable parentScope = function.getParentScope();
        if (j == 0) {
            return Context.call(contextFactory, function, parentScope, scriptable, objArr);
        }
        Context currentContext = Context.getCurrentContext();
        return currentContext != null ? doCall(currentContext, parentScope, scriptable, function, objArr, j) : contextFactory.call(new ContextAction() { // from class: me.tvspark.q21
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                Object doCall;
                doCall = JavaAdapter.doCall(context, Scriptable.this, scriptable, function, objArr, j);
                return doCall;
            }
        });
    }

    public static Object convertResult(Object obj, Class<?> cls) {
        if (obj != Undefined.instance || cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.StringClass) {
            return Context.jsToJava(obj, cls);
        }
        return null;
    }

    public static byte[] createAdapterCode(ObjToIntMap objToIntMap, String str, Class<?> cls, Class<?>[] clsArr, String str2) {
        Constructor<?>[] declaredConstructors;
        Class<?> cls2;
        Method[] methodArr;
        int i;
        Class<?>[] clsArr2 = clsArr;
        ClassFileWriter classFileWriter = new ClassFileWriter(str, cls.getName(), "<adapter>");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("factory", "Lorg/mozilla/javascript/ContextFactory;", (short) 17);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("delegee", OptRuntime.GeneratorState.thisObj_TYPE, (short) 17);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("self", OptRuntime.GeneratorState.thisObj_TYPE, (short) 17);
        int length = clsArr2 == null ? 0 : clsArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (clsArr2[i2] != null) {
                classFileWriter.Wwwwwwwwwwwwwwwww.add(Short.valueOf(classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clsArr2[i2].getName())));
            }
        }
        String replace = cls.getName().replace('.', '/');
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            int modifiers = constructor.getModifiers();
            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                generateCtor(classFileWriter, str, replace, constructor);
            }
        }
        generateSerialCtor(classFileWriter, str, replace);
        if (str2 != null) {
            generateEmptyCtor(classFileWriter, str, replace, str2);
        }
        ObjToIntMap objToIntMap2 = new ObjToIntMap();
        ObjToIntMap objToIntMap3 = new ObjToIntMap();
        int i3 = 0;
        while (i3 < length) {
            Method[] methods = clsArr2[i3].getMethods();
            int i4 = 0;
            while (i4 < methods.length) {
                Method method = methods[i4];
                int modifiers2 = method.getModifiers();
                if (!Modifier.isStatic(modifiers2) && !Modifier.isFinal(modifiers2) && !method.isDefault()) {
                    String name = method.getName();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!objToIntMap.has(name)) {
                        try {
                            cls.getMethod(name, parameterTypes);
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, getMethodSignature(method, parameterTypes));
                    if (!objToIntMap2.has(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        i = i4;
                        generateMethod(classFileWriter, str, name, parameterTypes, method.getReturnType(), true);
                        objToIntMap2.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
                        objToIntMap3.put(name, 0);
                        i4 = i + 1;
                    }
                }
                i = i4;
                i4 = i + 1;
            }
            i3++;
            clsArr2 = clsArr;
        }
        Method[] overridableMethods = getOverridableMethods(cls);
        int i5 = 0;
        while (i5 < overridableMethods.length) {
            Method method2 = overridableMethods[i5];
            boolean isAbstract = Modifier.isAbstract(method2.getModifiers());
            String name2 = method2.getName();
            if (isAbstract || objToIntMap.has(name2)) {
                Class<?>[] parameterTypes2 = method2.getParameterTypes();
                String methodSignature = getMethodSignature(method2, parameterTypes2);
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name2, methodSignature);
                if (!objToIntMap2.has(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    methodArr = overridableMethods;
                    generateMethod(classFileWriter, str, name2, parameterTypes2, method2.getReturnType(), true);
                    objToIntMap2.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0);
                    objToIntMap3.put(name2, 0);
                    if (!isAbstract) {
                        generateSuper(classFileWriter, str, replace, name2, methodSignature, parameterTypes2, method2.getReturnType());
                    }
                    i5++;
                    overridableMethods = methodArr;
                }
            }
            methodArr = overridableMethods;
            i5++;
            overridableMethods = methodArr;
        }
        ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(objToIntMap);
        iterator.start();
        while (!iterator.done()) {
            String str3 = (String) iterator.getKey();
            if (!objToIntMap3.has(str3)) {
                int value = iterator.getValue();
                Class[] clsArr3 = new Class[value];
                int i6 = 0;
                while (true) {
                    cls2 = ScriptRuntime.ObjectClass;
                    if (i6 >= value) {
                        break;
                    }
                    clsArr3[i6] = cls2;
                    i6++;
                }
                generateMethod(classFileWriter, str, str3, clsArr3, cls2, false);
            }
            iterator.next();
        }
        return classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static Scriptable createAdapterWrapper(Scriptable scriptable, Object obj) {
        NativeJavaObject nativeJavaObject = new NativeJavaObject(ScriptableObject.getTopLevelScope(scriptable), obj, null, true);
        nativeJavaObject.setPrototype(scriptable);
        return nativeJavaObject;
    }

    public static Object doCall(Context context, Scriptable scriptable, Scriptable scriptable2, Function function, Object[] objArr, long j) {
        for (int i = 0; i != objArr.length; i++) {
            if (0 != ((1 << i) & j)) {
                Object obj = objArr[i];
                if (!(obj instanceof Scriptable)) {
                    objArr[i] = context.getWrapFactory().wrap(context, scriptable, obj, null);
                }
            }
        }
        return function.call(context, scriptable, scriptable2, objArr);
    }

    public static void generateCtor(ClassFileWriter classFileWriter, String str, String str2, Constructor<?> constructor) {
        String sb;
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        short s = 3;
        if (parameterTypes.length == 0) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short) 1);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
            sb = "()V";
        } else {
            StringBuilder sb2 = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            int length = sb2.length();
            for (Class<?> cls : parameterTypes) {
                appendTypeString(sb2, cls);
            }
            sb2.append(")V");
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<init>", sb2.toString(), (short) 1);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
            for (Class<?> cls2 : parameterTypes) {
                s = (short) (generatePushParam(classFileWriter, s, cls2) + s);
            }
            sb2.delete(1, length);
            sb = sb2.toString();
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, str2, "<init>", sb);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(43);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(44);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(43);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
    }

    public static void generateEmptyCtor(ClassFileWriter classFileWriter, String str, String str2, String str3) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<init>", "()V", (short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, str2, "<init>", "()V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, str3);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, str3, "<init>", "()V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(76);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(43);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(43);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 2);
    }

    public static void generateMethod(ClassFileWriter classFileWriter, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
        StringBuilder sb = new StringBuilder();
        int appendMethodSignature = appendMethodSignature(clsArr, cls, sb);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, sb.toString(), (short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(classFileWriter, clsArr, clsArr.length);
        if (clsArr.length <= 64) {
            long j = 0;
            for (int i = 0; i != clsArr.length; i++) {
                if (!clsArr[i].isPrimitive()) {
                    j |= 1 << i;
                }
            }
            int i2 = (int) j;
            if (i2 == j) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.LOOP);
            } else {
                h21 h21Var = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwww;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9);
                byte[] bArr = h21Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = i3 + 1;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                bArr[i3] = 5;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, bArr, ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (j >>> 32), bArr, i4));
                int i5 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 2;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwww.put(i5, 5);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20, i5);
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
            generateReturnResult(classFileWriter, cls, z);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) appendMethodSignature);
            return;
        }
        throw Context.reportRuntimeError0("JavaAdapter can not subclass methods with more then 64 arguments.");
    }

    public static void generatePopResult(ClassFileWriter classFileWriter, Class<?> cls) {
        int i;
        if (cls.isPrimitive()) {
            char charAt = cls.getName().charAt(0);
            if (charAt != 'f') {
                if (charAt != 'i') {
                    if (charAt == 'l') {
                        i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3;
                    } else if (charAt != 's' && charAt != 'z') {
                        switch (charAt) {
                            case 'b':
                            case 'c':
                                break;
                            case 'd':
                                i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
                                break;
                            default:
                                return;
                        }
                    }
                }
                i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2;
            } else {
                i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
            }
        } else {
            i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public static int generatePushParam(ClassFileWriter classFileWriter, int i, Class<?> cls) {
        if (!cls.isPrimitive()) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, 25, i);
            return 1;
        }
        char charAt = cls.getName().charAt(0);
        if (charAt != 'f') {
            if (charAt != 'i') {
                if (charAt == 'l') {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(30, 22, i);
                    return 2;
                } else if (charAt != 's' && charAt != 'z') {
                    switch (charAt) {
                        case 'b':
                        case 'c':
                            break;
                        case 'd':
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(38, 24, i);
                            return 2;
                        default:
                            throw Kit.codeBug();
                    }
                }
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(26, 21, i);
            return 1;
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(34, 23, i);
        return 1;
    }

    public static void generatePushWrappedArgs(ClassFileWriter classFileWriter, Class<?>[] clsArr, int i) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(i);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(189, "java/lang/Object");
        int i2 = 1;
        for (int i3 = 0; i3 != clsArr.length; i3++) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            i2 += generateWrapArg(classFileWriter, i2, clsArr[i3]);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
        }
    }

    public static void generateReturnResult(ClassFileWriter classFileWriter, Class<?> cls, boolean z) {
        int i;
        if (cls != Void.TYPE) {
            if (cls == Boolean.TYPE) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
            } else if (cls == Character.TYPE) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/Context", AnnotationHandler.STRING, "(Ljava/lang/Object;)Ljava/lang/String;");
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/String", "charAt", "(I)C");
            } else if (cls.isPrimitive()) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
                char charAt = cls.getName().charAt(0);
                if (charAt != 'b') {
                    if (charAt == 'd') {
                        i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
                    } else if (charAt == 'f') {
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(144);
                        i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
                    } else if (charAt != 'i') {
                        if (charAt == 'l') {
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(143);
                            i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3;
                        } else if (charAt != 's') {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected return type ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.toString());
                            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                    }
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(142);
            } else {
                String name = cls.getName();
                if (z) {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name);
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, name);
                i = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2);
            return;
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
        i = 177;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public static void generateSerialCtor(ClassFileWriter classFileWriter, String str, String str2) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, str2, "<init>", "()V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(43);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(44);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(45);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 4);
    }

    public static void generateSuper(ClassFileWriter classFileWriter, String str, String str2, String str3, String str4, Class<?>[] clsArr, Class<?> cls) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("super$" + str3, str4, (short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 0);
        int i = 1;
        for (Class<?> cls2 : clsArr) {
            i += generatePushParam(classFileWriter, i, cls2);
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, str2, str3, str4);
        if (!cls.equals(Void.TYPE)) {
            generatePopResult(classFileWriter, cls);
        } else {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) (i + 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (r9 != 's') goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int generateWrapArg(ClassFileWriter classFileWriter, int i, Class<?> cls) {
        int i2;
        int i3 = 1;
        if (!cls.isPrimitive()) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, i);
        } else if (cls == Boolean.TYPE) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, "java/lang/Boolean");
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, i);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, "java/lang/Boolean", "<init>", "(Z)V");
        } else if (cls == Character.TYPE) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, i);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "java/lang/String", "valueOf", "(C)Ljava/lang/String;");
        } else {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, "java/lang/Double");
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            char charAt = cls.getName().charAt(0);
            if (charAt != 'b') {
                if (charAt == 'd') {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24, i);
                } else if (charAt == 'f') {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(23, i);
                    i2 = 141;
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, "java/lang/Double", "<init>", "(D)V");
                } else if (charAt != 'i') {
                    if (charAt == 'l') {
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(22, i);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.TYPEOFNAME);
                    }
                }
                i3 = 2;
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, "java/lang/Double", "<init>", "(D)V");
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, i);
            i2 = Token.EXPR_RESULT;
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, "java/lang/Double", "<init>", "(D)V");
        }
        return i3;
    }

    public static Class<?> getAdapterClass(Scriptable scriptable, Class<?> cls, Class<?>[] clsArr, Scriptable scriptable2) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<JavaAdapterSignature, Class<?>> interfaceAdapterCacheMap = classCache.getInterfaceAdapterCacheMap();
        ObjToIntMap objectFunctionNames = getObjectFunctionNames(scriptable2);
        JavaAdapterSignature javaAdapterSignature = new JavaAdapterSignature(cls, clsArr, objectFunctionNames);
        Class<?> cls2 = interfaceAdapterCacheMap.get(javaAdapterSignature);
        if (cls2 == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("adapter");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(classCache.newClassSerialNumber());
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            cls2 = loadAdapterClass(sb, createAdapterCode(objectFunctionNames, sb, cls, clsArr, null));
            if (classCache.isCachingEnabled()) {
                interfaceAdapterCacheMap.put(javaAdapterSignature, cls2);
            }
        }
        return cls2;
    }

    public static Object getAdapterSelf(Class<?> cls, Object obj) throws NoSuchFieldException, IllegalAccessException {
        return cls.getDeclaredField("self").get(obj);
    }

    public static int[] getArgsToConvert(Class<?>[] clsArr) {
        int i = 0;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            if (!clsArr[i2].isPrimitive()) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 != clsArr.length; i4++) {
            if (!clsArr[i4].isPrimitive()) {
                iArr[i3] = i4;
                i3++;
            }
        }
        return iArr;
    }

    public static Function getFunction(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            return null;
        }
        if (!(property instanceof Function)) {
            throw ScriptRuntime.notFunctionError(property, str);
        }
        return (Function) property;
    }

    public static String getMethodSignature(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        appendMethodSignature(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    public static ObjToIntMap getObjectFunctionNames(Scriptable scriptable) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable);
        ObjToIntMap objToIntMap = new ObjToIntMap(propertyIds.length);
        for (int i = 0; i != propertyIds.length; i++) {
            if (propertyIds[i] instanceof String) {
                String str = (String) propertyIds[i];
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (property instanceof Function) {
                    int int32 = ScriptRuntime.toInt32(ScriptableObject.getProperty((Function) property, Name.LENGTH));
                    if (int32 < 0) {
                        int32 = 0;
                    }
                    objToIntMap.put(str, int32);
                }
            }
        }
        return objToIntMap;
    }

    public static Method[] getOverridableMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            appendOverridableMethods(cls2, arrayList, hashSet);
        }
        while (cls != null) {
            for (Class<?> cls3 : cls.getInterfaces()) {
                appendOverridableMethods(cls3, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(new JavaAdapter(), FTAG, 1, "JavaAdapter", 1, scriptable);
        idFunctionObject.markAsConstructor(null);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    public static Object js_createAdapter(Context context, Scriptable scriptable, Object[] objArr) {
        Object newInstance;
        int length = objArr.length;
        if (length != 0) {
            int i = 0;
            while (i < length - 1) {
                Object obj = objArr[i];
                if (obj instanceof NativeObject) {
                    break;
                } else if (!(obj instanceof NativeJavaClass)) {
                    throw ScriptRuntime.typeError2("msg.not.java.class.arg", String.valueOf(i), ScriptRuntime.toString(obj));
                } else {
                    i++;
                }
            }
            Class<?> cls = null;
            Class[] clsArr = new Class[i];
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Class<?> classObject = ((NativeJavaClass) objArr[i3]).getClassObject();
                if (classObject.isInterface()) {
                    clsArr[i2] = classObject;
                    i2++;
                } else if (cls != null) {
                    throw ScriptRuntime.typeError2("msg.only.one.super", cls.getName(), classObject.getName());
                } else {
                    cls = classObject;
                }
            }
            if (cls == null) {
                cls = ScriptRuntime.ObjectClass;
            }
            Class[] clsArr2 = new Class[i2];
            System.arraycopy(clsArr, 0, clsArr2, 0, i2);
            Scriptable ensureScriptable = ScriptableObject.ensureScriptable(objArr[i]);
            Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr2, ensureScriptable);
            int i4 = (length - i) - 1;
            try {
                if (i4 > 0) {
                    Object[] objArr2 = new Object[i4 + 2];
                    objArr2[0] = ensureScriptable;
                    objArr2[1] = context.getFactory();
                    System.arraycopy(objArr, i + 1, objArr2, 2, i4);
                    NativeJavaMethod nativeJavaMethod = new NativeJavaClass(scriptable, adapterClass, true).members.ctors;
                    int findCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr2);
                    if (findCachedFunction < 0) {
                        throw Context.reportRuntimeError2("msg.no.java.ctor", adapterClass.getName(), NativeJavaMethod.scriptSignature(objArr));
                    }
                    newInstance = NativeJavaClass.constructInternal(objArr2, nativeJavaMethod.methods[findCachedFunction]);
                } else {
                    newInstance = adapterClass.getConstructor(ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass).newInstance(ensureScriptable, context.getFactory());
                }
                Object adapterSelf = getAdapterSelf(adapterClass, newInstance);
                if (adapterSelf instanceof Wrapper) {
                    Object unwrap = ((Wrapper) adapterSelf).unwrap();
                    if (unwrap instanceof Scriptable) {
                        if (unwrap instanceof ScriptableObject) {
                            ScriptRuntime.setObjectProtoAndParent((ScriptableObject) unwrap, scriptable);
                        }
                        return unwrap;
                    }
                }
                return adapterSelf;
            } catch (Exception e) {
                throw Context.throwAsScriptRuntimeEx(e);
            }
        }
        throw ScriptRuntime.typeError0("msg.adapter.zero.args");
    }

    public static Class<?> loadAdapterClass(String str, byte[] bArr) {
        ProtectionDomain scriptProtectionDomain;
        Class<?> staticSecurityDomainClass = SecurityController.getStaticSecurityDomainClass();
        if (staticSecurityDomainClass == CodeSource.class || staticSecurityDomainClass == ProtectionDomain.class) {
            scriptProtectionDomain = SecurityUtilities.getScriptProtectionDomain();
            if (scriptProtectionDomain == null) {
                scriptProtectionDomain = JavaAdapter.class.getProtectionDomain();
            }
            if (staticSecurityDomainClass == CodeSource.class) {
                if (scriptProtectionDomain != null) {
                    scriptProtectionDomain = scriptProtectionDomain.getCodeSource();
                }
            }
            GeneratedClassLoader createLoader = SecurityController.createLoader(null, scriptProtectionDomain);
            Class<?> defineClass = createLoader.defineClass(str, bArr);
            createLoader.linkClass(defineClass);
            return defineClass;
        }
        scriptProtectionDomain = null;
        GeneratedClassLoader createLoader2 = SecurityController.createLoader(null, scriptProtectionDomain);
        Class<?> defineClass2 = createLoader2.defineClass(str, bArr);
        createLoader2.linkClass(defineClass2);
        return defineClass2;
    }

    public static Object readAdapterObject(Scriptable scriptable, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Context currentContext = Context.getCurrentContext();
        ContextFactory factory = currentContext != null ? currentContext.getFactory() : null;
        Class<?> cls = Class.forName((String) objectInputStream.readObject());
        String[] strArr = (String[]) objectInputStream.readObject();
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i]);
        }
        Scriptable scriptable2 = (Scriptable) objectInputStream.readObject();
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr, scriptable2);
        Class<Scriptable> cls2 = ScriptRuntime.ScriptableClass;
        try {
            return adapterClass.getConstructor(ScriptRuntime.ContextFactoryClass, cls2, cls2).newInstance(factory, scriptable2, scriptable);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            throw new ClassNotFoundException("adapter");
        }
    }

    public static Scriptable runScript(final Script script) {
        return (Scriptable) ContextFactory.getGlobal().call(new ContextAction() { // from class: me.tvspark.r21
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return JavaAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Script.this, context);
            }
        });
    }

    public static void writeAdapterObject(Object obj, ObjectOutputStream objectOutputStream) throws IOException {
        Class<?> cls = obj.getClass();
        objectOutputStream.writeObject(cls.getSuperclass().getName());
        Class<?>[] interfaces = cls.getInterfaces();
        String[] strArr = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            strArr[i] = interfaces[i].getName();
        }
        objectOutputStream.writeObject(strArr);
        try {
            objectOutputStream.writeObject(cls.getField("delegee").get(obj));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            throw new IOException();
        }
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(FTAG) || idFunctionObject.methodId() != 1) {
            throw idFunctionObject.unknown();
        }
        return js_createAdapter(context, scriptable, objArr);
    }
}
