package org.mozilla.javascript;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class NativeJavaClass extends NativeJavaObject implements Function {
    public static final String javaClassPropertyName = "__javaObject__";
    public static final long serialVersionUID = -6460763940409461664L;
    public Map<String, FieldAndMethods> staticFieldAndMethods;

    public NativeJavaClass() {
    }

    public NativeJavaClass(Scriptable scriptable, Class<?> cls) {
        this(scriptable, cls, false);
    }

    public NativeJavaClass(Scriptable scriptable, Class<?> cls, boolean z) {
        super(scriptable, cls, null, z);
    }

    public static Object constructInternal(Object[] objArr, MemberBox memberBox) {
        Object[] objArr2;
        Object obj;
        Class<?>[] clsArr = memberBox.argTypes;
        int i = 0;
        if (memberBox.vararg) {
            objArr2 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr2[i2] = Context.jsToJava(objArr[i2], clsArr[i2]);
            }
            if (objArr.length != clsArr.length || (objArr[objArr.length - 1] != null && !(objArr[objArr.length - 1] instanceof NativeArray) && !(objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                Object newInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(newInstance)) {
                    Array.set(newInstance, i, Context.jsToJava(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
                obj = newInstance;
            } else {
                obj = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            }
            objArr2[clsArr.length - 1] = obj;
        } else {
            objArr2 = objArr;
            while (i < objArr2.length) {
                Object obj2 = objArr2[i];
                Object jsToJava = Context.jsToJava(obj2, clsArr[i]);
                if (jsToJava != obj2) {
                    if (objArr2 == objArr) {
                        objArr2 = (Object[]) objArr.clone();
                    }
                    objArr2[i] = jsToJava;
                }
                i++;
            }
        }
        return memberBox.newInstance(objArr2);
    }

    public static Scriptable constructSpecific(Context context, Scriptable scriptable, Object[] objArr, MemberBox memberBox) {
        Object constructInternal = constructInternal(objArr, memberBox);
        return context.getWrapFactory().wrapNewObject(context, ScriptableObject.getTopLevelScope(scriptable), constructInternal);
    }

    public static Class<?> findNestedClass(Class<?> cls, String str) {
        String str2 = cls.getName() + '$' + str;
        ClassLoader classLoader = cls.getClassLoader();
        return classLoader == null ? Kit.classOrNull(str2) : Kit.classOrNull(classLoader, str2);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (objArr.length != 1 || !(objArr[0] instanceof Scriptable)) {
            return construct(context, scriptable, objArr);
        }
        Class<?> classObject = getClassObject();
        Scriptable scriptable3 = (Scriptable) objArr[0];
        do {
            if ((scriptable3 instanceof Wrapper) && classObject.isInstance(((Wrapper) scriptable3).unwrap())) {
                return scriptable3;
            }
            scriptable3 = scriptable3.getPrototype();
        } while (scriptable3 != null);
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
        if (r6 == null) goto L26;
     */
    @Override // org.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        String message;
        Class<?> classObject = getClassObject();
        int modifiers = classObject.getModifiers();
        if (!Modifier.isInterface(modifiers) && !Modifier.isAbstract(modifiers)) {
            NativeJavaMethod nativeJavaMethod = this.members.ctors;
            int findCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr);
            if (findCachedFunction < 0) {
                throw Context.reportRuntimeError2("msg.no.java.ctor", classObject.getName(), NativeJavaMethod.scriptSignature(objArr));
            }
            return constructSpecific(context, scriptable, objArr, nativeJavaMethod.methods[findCachedFunction]);
        } else if (objArr.length == 0) {
            throw Context.reportRuntimeError0("msg.adapter.zero.args");
        } else {
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(this);
            try {
            } catch (Exception e) {
                message = e.getMessage();
            }
            if ("Dalvik".equals(System.getProperty("java.vm.name")) && classObject.isInterface()) {
                return context.getWrapFactory().wrapAsJavaObject(context, scriptable, NativeJavaObject.createInterfaceAdapter(classObject, ScriptableObject.ensureScriptableObject(objArr[0])), null);
            }
            Object obj = topLevelScope.get("JavaAdapter", topLevelScope);
            if (obj != Scriptable.NOT_FOUND) {
                return ((Function) obj).construct(context, topLevelScope, new Object[]{this, objArr[0]});
            }
            message = "";
            throw Context.reportRuntimeError2("msg.cant.instantiate", message, classObject.getName());
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        FieldAndMethods fieldAndMethods;
        if (str.equals("prototype")) {
            return null;
        }
        Map<String, FieldAndMethods> map = this.staticFieldAndMethods;
        if (map != null && (fieldAndMethods = map.get(str)) != null) {
            return fieldAndMethods;
        }
        if (this.members.has(str, true)) {
            return this.members.get(this, str, this.javaObject, true);
        }
        Context context = Context.getContext();
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        WrapFactory wrapFactory = context.getWrapFactory();
        if (javaClassPropertyName.equals(str)) {
            return wrapFactory.wrap(context, topLevelScope, this.javaObject, ScriptRuntime.ClassClass);
        }
        Class<?> findNestedClass = findNestedClass(getClassObject(), str);
        if (findNestedClass == null) {
            throw this.members.reportMemberNotFound(str);
        }
        Scriptable wrapJavaClass = wrapFactory.wrapJavaClass(context, topLevelScope, findNestedClass);
        wrapJavaClass.setParentScope(this);
        return wrapJavaClass;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaClass";
    }

    public Class<?> getClassObject() {
        return (Class) super.unwrap();
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == null || cls == ScriptRuntime.StringClass) ? toString() : cls == ScriptRuntime.BooleanClass ? Boolean.TRUE : cls == ScriptRuntime.NumberClass ? ScriptRuntime.NaNobj : this;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this.members.getIds(true);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.members.has(str, true) || javaClassPropertyName.equals(str);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (!(scriptable instanceof Wrapper) || (scriptable instanceof NativeJavaClass)) {
            return false;
        }
        return getClassObject().isInstance(((Wrapper) scriptable).unwrap());
    }

    @Override // org.mozilla.javascript.NativeJavaObject
    public void initMembers() {
        Class cls = (Class) this.javaObject;
        JavaMembers lookupClass = JavaMembers.lookupClass(this.parent, cls, cls, this.isAdapter);
        this.members = lookupClass;
        this.staticFieldAndMethods = lookupClass.getFieldAndMethodsObjects(this, cls, true);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        this.members.put(this, str, this.javaObject, obj, true);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[JavaClass ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClassObject().getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
