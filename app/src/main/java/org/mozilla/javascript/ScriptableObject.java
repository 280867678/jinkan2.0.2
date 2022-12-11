package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.outline;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;
import org.mozilla.javascript.annotations.JSGetter;
import org.mozilla.javascript.annotations.JSSetter;
import org.mozilla.javascript.annotations.JSStaticFunction;
import org.mozilla.javascript.debug.DebuggableObject;
import org.simpleframework.xml.core.AnnotationHandler;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public abstract class ScriptableObject implements Scriptable, SymbolScriptable, Serializable, DebuggableObject, ConstProperties {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONST = 13;
    public static final int DONTENUM = 2;
    public static final int EMPTY = 0;
    public static final Method GET_ARRAY_LENGTH;
    public static final Comparator<Object> KEY_COMPARATOR;
    public static final int PERMANENT = 4;
    public static final int READONLY = 1;
    public static final int UNINITIALIZED_CONST = 8;
    public static final long serialVersionUID = 2829861078851942586L;
    public volatile Map<Object, Object> associatedValues;
    public transient ExternalArrayData externalData;
    public boolean isExtensible;
    public boolean isSealed;
    public Scriptable parentScopeObject;
    public Scriptable prototypeObject;
    public transient SlotMapContainer slotMap;

    /* loaded from: classes5.dex */
    public static final class GetterSlot extends Slot {
        public static final long serialVersionUID = -4900574849788797588L;
        public Object getter;
        public Object setter;

        public GetterSlot(Object obj, int i, int i2) {
            super(obj, i, i2);
        }

        @Override // org.mozilla.javascript.ScriptableObject.Slot
        public ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
            int attributes = getAttributes();
            NativeObject nativeObject = new NativeObject();
            ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
            boolean z = true;
            nativeObject.defineProperty("enumerable", Boolean.valueOf((attributes & 2) == 0), 0);
            nativeObject.defineProperty("configurable", Boolean.valueOf((attributes & 4) == 0), 0);
            if (this.getter == null && this.setter == null) {
                if ((attributes & 1) != 0) {
                    z = false;
                }
                nativeObject.defineProperty("writable", Boolean.valueOf(z), 0);
            }
            Object obj = this.name;
            String obj2 = obj == null ? "f" : obj.toString();
            Object obj3 = this.getter;
            if (obj3 != null) {
                if (obj3 instanceof MemberBox) {
                    obj3 = new FunctionObject(obj2, ((MemberBox) this.getter).member(), scriptable);
                } else if (obj3 instanceof Member) {
                    obj3 = new FunctionObject(obj2, (Member) this.getter, scriptable);
                }
                nativeObject.defineProperty("get", obj3, 0);
            }
            Object obj4 = this.setter;
            if (obj4 != null) {
                if (obj4 instanceof MemberBox) {
                    obj4 = new FunctionObject(obj2, ((MemberBox) this.setter).member(), scriptable);
                } else if (obj4 instanceof Member) {
                    obj4 = new FunctionObject(obj2, (Member) this.setter, scriptable);
                }
                nativeObject.defineProperty("set", obj4, 0);
            }
            return nativeObject;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.mozilla.javascript.ScriptableObject.Slot
        public Object getValue(Scriptable scriptable) {
            Object[] objArr;
            Object obj = this.getter;
            if (obj != null) {
                if (obj instanceof MemberBox) {
                    MemberBox memberBox = (MemberBox) obj;
                    Object obj2 = memberBox.delegateTo;
                    if (obj2 == 0) {
                        objArr = ScriptRuntime.emptyArgs;
                    } else {
                        Object[] objArr2 = {scriptable};
                        scriptable = obj2;
                        objArr = objArr2;
                    }
                    return memberBox.invoke(scriptable, objArr);
                } else if (obj instanceof Function) {
                    Function function = (Function) obj;
                    return function.call(Context.getContext(), function.getParentScope(), scriptable, ScriptRuntime.emptyArgs);
                }
            }
            Object obj3 = this.value;
            if (obj3 instanceof LazilyLoadedCtor) {
                LazilyLoadedCtor lazilyLoadedCtor = (LazilyLoadedCtor) obj3;
                try {
                    lazilyLoadedCtor.init();
                    return lazilyLoadedCtor.getValue();
                } finally {
                    this.value = lazilyLoadedCtor.getValue();
                }
            }
            return obj3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.mozilla.javascript.ScriptableObject.Slot
        public boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
            Object[] objArr;
            String str;
            if (this.setter == null) {
                if (this.getter == null) {
                    return super.setValue(obj, scriptable, scriptable2);
                }
                Context context = Context.getContext();
                if (!context.isStrictMode() && !context.hasFeature(11)) {
                    return true;
                }
                if (this.name != null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(scriptable2.getClassName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("].");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.name.toString());
                    str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                } else {
                    str = "";
                }
                throw ScriptRuntime.typeError2("msg.set.prop.no.setter", str, Context.toString(obj));
            }
            Context context2 = Context.getContext();
            Object obj2 = this.setter;
            if (obj2 instanceof MemberBox) {
                MemberBox memberBox = (MemberBox) obj2;
                Class<?>[] clsArr = memberBox.argTypes;
                Object convertArg = FunctionObject.convertArg(context2, scriptable2, obj, FunctionObject.getTypeTag(clsArr[clsArr.length - 1]));
                Object obj3 = memberBox.delegateTo;
                if (obj3 == 0) {
                    objArr = new Object[]{convertArg};
                } else {
                    Object[] objArr2 = {scriptable2, convertArg};
                    scriptable2 = obj3;
                    objArr = objArr2;
                }
                memberBox.invoke(scriptable2, objArr);
            } else if (obj2 instanceof Function) {
                Function function = (Function) obj2;
                function.call(context2, function.getParentScope(), scriptable2, new Object[]{obj});
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static final class KeyComparator implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            int intValue;
            int intValue2;
            if (!(obj instanceof Integer)) {
                return obj2 instanceof Integer ? 1 : 0;
            } else if (!(obj2 instanceof Integer) || (intValue = ((Integer) obj).intValue()) < (intValue2 = ((Integer) obj2).intValue())) {
                return -1;
            } else {
                return intValue > intValue2 ? 1 : 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Slot implements Serializable {
        public static final long serialVersionUID = -6090581677123995491L;
        public short attributes;
        public int indexOrHash;
        public Object name;
        public transient Slot next;
        public transient Slot orderedNext;
        public Object value;

        public Slot(Object obj, int i, int i2) {
            this.name = obj;
            this.indexOrHash = i;
            this.attributes = (short) i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Object obj = this.name;
            if (obj != null) {
                this.indexOrHash = obj.hashCode();
            }
        }

        public int getAttributes() {
            return this.attributes;
        }

        public ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
            return ScriptableObject.buildDataDescriptor(scriptable, this.value, this.attributes);
        }

        public Object getValue(Scriptable scriptable) {
            return this.value;
        }

        public synchronized void setAttributes(int i) {
            ScriptableObject.checkValidAttributes(i);
            this.attributes = (short) i;
        }

        public boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
            if ((this.attributes & 1) != 0) {
                if (Context.getContext().isStrictMode()) {
                    throw ScriptRuntime.typeError1("msg.modify.readonly", this.name);
                }
                return true;
            } else if (scriptable != scriptable2) {
                return false;
            } else {
                this.value = obj;
                return true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum SlotAccess {
        QUERY,
        MODIFY,
        MODIFY_CONST,
        MODIFY_GETTER_SETTER,
        CONVERT_ACCESSOR_TO_DATA
    }

    static {
        try {
            GET_ARRAY_LENGTH = ScriptableObject.class.getMethod("getExternalArrayLength", new Class[0]);
            KEY_COMPARATOR = new KeyComparator();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public ScriptableObject() {
        this.isExtensible = true;
        this.isSealed = false;
        this.slotMap = createSlotMap(0);
    }

    public ScriptableObject(Scriptable scriptable, Scriptable scriptable2) {
        this.isExtensible = true;
        this.isSealed = false;
        if (scriptable != null) {
            this.parentScopeObject = scriptable;
            this.prototypeObject = scriptable2;
            this.slotMap = createSlotMap(0);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T extends Scriptable> BaseFunction buildClassCtor(Scriptable scriptable, Class<T> cls, boolean z, boolean z2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?> constructor;
        Scriptable scriptable2;
        Member findAnnotatedMember;
        Member member;
        Member member2;
        FunctionObject functionObject;
        HashSet hashSet;
        HashSet hashSet2;
        Annotation annotation;
        GenericDeclaration genericDeclaration;
        String str;
        HashSet hashSet3;
        int i;
        String propertyName;
        String defineClass;
        BaseFunction baseFunction;
        Object prototypeProperty;
        Method[] methodList = FunctionObject.getMethodList(cls);
        int i2 = 0;
        while (true) {
            int i3 = 3;
            Method method = null;
            if (i2 < methodList.length) {
                Method method2 = methodList[i2];
                if (method2.getName().equals("init")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length == 3 && parameterTypes[0] == ScriptRuntime.ContextClass && parameterTypes[1] == ScriptRuntime.ScriptableClass && parameterTypes[2] == Boolean.TYPE && Modifier.isStatic(method2.getModifiers())) {
                        Object[] objArr = new Object[3];
                        objArr[0] = Context.getContext();
                        objArr[1] = scriptable;
                        objArr[2] = z ? Boolean.TRUE : Boolean.FALSE;
                        method2.invoke(null, objArr);
                        return null;
                    } else if (parameterTypes.length == 1 && parameterTypes[0] == ScriptRuntime.ScriptableClass && Modifier.isStatic(method2.getModifiers())) {
                        method2.invoke(null, scriptable);
                        return null;
                    }
                }
                i2++;
            } else {
                Constructor<?>[] constructors = cls.getConstructors();
                int i4 = 0;
                while (true) {
                    if (i4 >= constructors.length) {
                        constructor = null;
                        break;
                    } else if (constructors[i4].getParameterTypes().length == 0) {
                        constructor = constructors[i4];
                        break;
                    } else {
                        i4++;
                    }
                }
                if (constructor == null) {
                    throw Context.reportRuntimeError1("msg.zero.arg.ctor", cls.getName());
                }
                Scriptable scriptable3 = (Scriptable) constructor.newInstance(ScriptRuntime.emptyArgs);
                String className = scriptable3.getClassName();
                Object property = getProperty(getTopLevelScope(scriptable), className);
                if ((property instanceof BaseFunction) && (prototypeProperty = (baseFunction = (BaseFunction) property).getPrototypeProperty()) != null) {
                    if (cls.equals(prototypeProperty.getClass())) {
                        return baseFunction;
                    }
                }
                if (z2) {
                    Class<? super T> superclass = cls.getSuperclass();
                    if (ScriptRuntime.ScriptableClass.isAssignableFrom(superclass) && !Modifier.isAbstract(superclass.getModifiers()) && (defineClass = defineClass(scriptable, extendsScriptable(superclass), z, z2)) != null) {
                        scriptable2 = getClassPrototype(scriptable, defineClass);
                        if (scriptable2 == null) {
                            scriptable2 = getObjectPrototype(scriptable);
                        }
                        scriptable3.setPrototype(scriptable2);
                        findAnnotatedMember = findAnnotatedMember(methodList, JSConstructor.class);
                        member = findAnnotatedMember;
                        if (findAnnotatedMember == null) {
                            member = findAnnotatedMember(constructors, JSConstructor.class);
                        }
                        String str2 = "jsConstructor";
                        member2 = member;
                        if (member == null) {
                            member2 = FunctionObject.findSingleMethod(methodList, str2);
                        }
                        if (member2 == null) {
                            if (constructors.length == 1) {
                                member2 = constructors[0];
                            } else {
                                member2 = member2;
                                if (constructors.length == 2) {
                                    if (constructors[0].getParameterTypes().length == 0) {
                                        member2 = constructors[1];
                                    } else {
                                        member2 = member2;
                                        if (constructors[1].getParameterTypes().length == 0) {
                                            member2 = constructors[0];
                                        }
                                    }
                                }
                            }
                            if (member2 == null) {
                                throw Context.reportRuntimeError1("msg.ctor.multiple.parms", cls.getName());
                            }
                        }
                        functionObject = new FunctionObject(className, member2, scriptable);
                        if (!functionObject.isVarArgsMethod()) {
                            throw Context.reportRuntimeError1("msg.varargs.ctor", member2.getName());
                        }
                        functionObject.initAsConstructor(scriptable, scriptable3);
                        HashSet hashSet4 = new HashSet();
                        HashSet hashSet5 = new HashSet();
                        int length = methodList.length;
                        int i5 = 0;
                        while (i5 < length) {
                            Method method3 = methodList[i5];
                            if (method3 == member2) {
                                hashSet = hashSet4;
                                str = str2;
                                hashSet2 = hashSet5;
                            } else {
                                String name = method3.getName();
                                if (name.equals("finishInit")) {
                                    Class<?>[] parameterTypes2 = method3.getParameterTypes();
                                    hashSet = hashSet4;
                                    if (parameterTypes2.length == i3) {
                                        Class<?> cls2 = parameterTypes2[0];
                                        Class<Scriptable> cls3 = ScriptRuntime.ScriptableClass;
                                        if (cls2 == cls3) {
                                            hashSet2 = hashSet5;
                                            if (parameterTypes2[1] == FunctionObject.class && parameterTypes2[2] == cls3 && Modifier.isStatic(method3.getModifiers())) {
                                                method = method3;
                                                str = str2;
                                            }
                                            if (name.indexOf(36) == -1 && !name.equals(str2)) {
                                                if (!method3.isAnnotationPresent(JSFunction.class)) {
                                                    genericDeclaration = JSFunction.class;
                                                } else if (method3.isAnnotationPresent(JSStaticFunction.class)) {
                                                    genericDeclaration = JSStaticFunction.class;
                                                } else if (method3.isAnnotationPresent(JSGetter.class)) {
                                                    genericDeclaration = JSGetter.class;
                                                } else if (!method3.isAnnotationPresent(JSSetter.class)) {
                                                    annotation = null;
                                                    String str3 = "jsFunction_";
                                                    if (annotation == null) {
                                                        if (!name.startsWith(str3)) {
                                                            if (name.startsWith("jsStaticFunction_")) {
                                                                str = str2;
                                                                str3 = "jsStaticFunction_";
                                                            } else if (name.startsWith("jsGet_")) {
                                                                str3 = "jsGet_";
                                                            }
                                                        }
                                                        str = str2;
                                                    } else {
                                                        str = str2;
                                                        str3 = null;
                                                    }
                                                    boolean z3 = !(annotation instanceof JSStaticFunction) || str3 == "jsStaticFunction_";
                                                    hashSet3 = z3 ? hashSet : hashSet2;
                                                    i = length;
                                                    propertyName = getPropertyName(name, str3, annotation);
                                                    if (hashSet3.contains(propertyName)) {
                                                        throw Context.reportRuntimeError2("duplicate.defineClass.name", name, propertyName);
                                                    }
                                                    hashSet3.add(propertyName);
                                                    if ((annotation instanceof JSGetter) || str3 == "jsGet_") {
                                                        if (!(scriptable3 instanceof ScriptableObject)) {
                                                            throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable3.getClass().toString(), propertyName);
                                                        }
                                                        Method findSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                                        ((ScriptableObject) scriptable3).defineProperty(propertyName, null, method3, findSetterMethod, (findSetterMethod != null ? 0 : 1) | 6);
                                                    } else if (z3 && !Modifier.isStatic(method3.getModifiers())) {
                                                        throw Context.reportRuntimeError("jsStaticFunction must be used with static method.");
                                                    } else {
                                                        FunctionObject functionObject2 = new FunctionObject(propertyName, method3, scriptable3);
                                                        if (functionObject2.isVarArgsConstructor()) {
                                                            throw Context.reportRuntimeError1("msg.varargs.fun", member2.getName());
                                                        }
                                                        defineProperty(z3 ? functionObject : scriptable3, propertyName, functionObject2, 2);
                                                        if (z) {
                                                            functionObject2.sealObject();
                                                        }
                                                    }
                                                    i5++;
                                                    hashSet4 = hashSet;
                                                    hashSet5 = hashSet2;
                                                    str2 = str;
                                                    length = i;
                                                    i3 = 3;
                                                }
                                                annotation = method3.getAnnotation(genericDeclaration);
                                                String str32 = "jsFunction_";
                                                if (annotation == null) {
                                                }
                                                if (!(annotation instanceof JSStaticFunction)) {
                                                }
                                                if (z3) {
                                                }
                                                i = length;
                                                propertyName = getPropertyName(name, str32, annotation);
                                                if (hashSet3.contains(propertyName)) {
                                                }
                                            }
                                            str = str2;
                                        }
                                    }
                                } else {
                                    hashSet = hashSet4;
                                }
                                hashSet2 = hashSet5;
                                if (name.indexOf(36) == -1) {
                                    if (!method3.isAnnotationPresent(JSFunction.class)) {
                                    }
                                    annotation = method3.getAnnotation(genericDeclaration);
                                    String str322 = "jsFunction_";
                                    if (annotation == null) {
                                    }
                                    if (!(annotation instanceof JSStaticFunction)) {
                                    }
                                    if (z3) {
                                    }
                                    i = length;
                                    propertyName = getPropertyName(name, str322, annotation);
                                    if (hashSet3.contains(propertyName)) {
                                    }
                                }
                                str = str2;
                            }
                            i = length;
                            i5++;
                            hashSet4 = hashSet;
                            hashSet5 = hashSet2;
                            str2 = str;
                            length = i;
                            i3 = 3;
                        }
                        if (method != null) {
                            method.invoke(null, scriptable, functionObject, scriptable3);
                        }
                        if (z) {
                            functionObject.sealObject();
                            if (scriptable3 instanceof ScriptableObject) {
                                ((ScriptableObject) scriptable3).sealObject();
                            }
                        }
                        return functionObject;
                    }
                }
                scriptable2 = null;
                if (scriptable2 == null) {
                }
                scriptable3.setPrototype(scriptable2);
                findAnnotatedMember = findAnnotatedMember(methodList, JSConstructor.class);
                member = findAnnotatedMember;
                if (findAnnotatedMember == null) {
                }
                String str22 = "jsConstructor";
                member2 = member;
                if (member == null) {
                }
                if (member2 == null) {
                }
                functionObject = new FunctionObject(className, member2, scriptable);
                if (!functionObject.isVarArgsMethod()) {
                }
            }
        }
    }

    public static ScriptableObject buildDataDescriptor(Scriptable scriptable, Object obj, int i) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        boolean z = true;
        nativeObject.defineProperty("writable", Boolean.valueOf((i & 1) == 0), 0);
        nativeObject.defineProperty("enumerable", Boolean.valueOf((i & 2) == 0), 0);
        if ((i & 4) != 0) {
            z = false;
        }
        nativeObject.defineProperty("configurable", Boolean.valueOf(z), 0);
        return nativeObject;
    }

    public static Object callMethod(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Object property = getProperty(scriptable, str);
        if (property instanceof Function) {
            Function function = (Function) property;
            Scriptable topLevelScope = getTopLevelScope(scriptable);
            return context != null ? function.call(context, topLevelScope, scriptable, objArr) : Context.call(null, function, topLevelScope, scriptable, objArr);
        }
        throw ScriptRuntime.notFunctionError(scriptable, str);
    }

    public static Object callMethod(Scriptable scriptable, String str, Object[] objArr) {
        return callMethod(null, scriptable, str, objArr);
    }

    private void checkNotSealed(Object obj, int i) {
        if (!isSealed()) {
            return;
        }
        throw Context.reportRuntimeError1("msg.modify.sealed", obj != null ? obj.toString() : Integer.toString(i));
    }

    public static void checkValidAttributes(int i) {
        if ((i & (-16)) == 0) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    private SlotMapContainer createSlotMap(int i) {
        Context currentContext = Context.getCurrentContext();
        return (currentContext == null || !currentContext.hasFeature(17)) ? new SlotMapContainer(i) : new ThreadSafeSlotMapContainer(i);
    }

    public static <T extends Scriptable> String defineClass(Scriptable scriptable, Class<T> cls, boolean z, boolean z2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        BaseFunction buildClassCtor = buildClassCtor(scriptable, cls, z, z2);
        if (buildClassCtor == null) {
            return null;
        }
        String className = buildClassCtor.getClassPrototype().getClassName();
        defineProperty(scriptable, className, buildClassCtor, 2);
        return className;
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        defineClass(scriptable, cls, false, false);
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls, boolean z) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        defineClass(scriptable, cls, z, false);
    }

    public static void defineConstProperty(Scriptable scriptable, String str) {
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).defineConst(str, scriptable);
        } else {
            defineProperty(scriptable, str, Undefined.instance, 13);
        }
    }

    public static void defineProperty(Scriptable scriptable, String str, Object obj, int i) {
        if (!(scriptable instanceof ScriptableObject)) {
            scriptable.put(str, scriptable, obj);
        } else {
            ((ScriptableObject) scriptable).defineProperty(str, obj, i);
        }
    }

    public static boolean deleteProperty(Scriptable scriptable, int i) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            return true;
        }
        base.delete(i);
        return !base.has(i, scriptable);
    }

    public static boolean deleteProperty(Scriptable scriptable, String str) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return true;
        }
        base.delete(str);
        return !base.has(str, scriptable);
    }

    public static Scriptable ensureScriptable(Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
    }

    public static ScriptableObject ensureScriptableObject(Object obj) {
        if (obj instanceof ScriptableObject) {
            return (ScriptableObject) obj;
        }
        throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
    }

    public static SymbolScriptable ensureSymbolScriptable(Object obj) {
        if (obj instanceof SymbolScriptable) {
            return (SymbolScriptable) obj;
        }
        throw ScriptRuntime.typeError1("msg.object.not.symbolscriptable", ScriptRuntime.typeof(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Scriptable> Class<T> extendsScriptable(Class<?> cls) {
        if (ScriptRuntime.ScriptableClass.isAssignableFrom(cls)) {
            return cls;
        }
        return null;
    }

    public static Member findAnnotatedMember(AccessibleObject[] accessibleObjectArr, Class<? extends Annotation> cls) {
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject.isAnnotationPresent(cls)) {
                return (Member) accessibleObject;
            }
        }
        return null;
    }

    private Slot findAttributeSlot(String str, int i, SlotAccess slotAccess) {
        Slot slot = this.slotMap.get(str, i, slotAccess);
        if (slot == null) {
            if (str == null) {
                str = Integer.toString(i);
            }
            throw Context.reportRuntimeError1("msg.prop.not.found", str);
        }
        return slot;
    }

    private Slot findAttributeSlot(Symbol symbol, SlotAccess slotAccess) {
        Slot slot = this.slotMap.get(symbol, 0, slotAccess);
        if (slot != null) {
            return slot;
        }
        throw Context.reportRuntimeError1("msg.prop.not.found", symbol);
    }

    public static Method findSetterMethod(Method[] methodArr, String str, String str2) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("set");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Character.toUpperCase(str.charAt(0)));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.substring(1));
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        for (Method method : methodArr) {
            JSSetter jSSetter = (JSSetter) method.getAnnotation(JSSetter.class);
            if (jSSetter != null && (str.equals(jSSetter.value()) || ("".equals(jSSetter.value()) && sb.equals(method.getName())))) {
                return method;
            }
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str);
        for (Method method2 : methodArr) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(method2.getName())) {
                return method2;
            }
        }
        return null;
    }

    public static Scriptable getArrayPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Array);
    }

    public static Scriptable getBase(Scriptable scriptable, int i) {
        while (!scriptable.has(i, scriptable) && (scriptable = scriptable.getPrototype()) != null) {
        }
        return scriptable;
    }

    public static Scriptable getBase(Scriptable scriptable, String str) {
        while (!scriptable.has(str, scriptable) && (scriptable = scriptable.getPrototype()) != null) {
        }
        return scriptable;
    }

    public static Scriptable getBase(Scriptable scriptable, Symbol symbol) {
        while (!ensureSymbolScriptable(scriptable).has(symbol, scriptable) && (scriptable = scriptable.getPrototype()) != null) {
        }
        return scriptable;
    }

    public static Scriptable getClassPrototype(Scriptable scriptable, String str) {
        Object obj;
        Object property = getProperty(getTopLevelScope(scriptable), str);
        if (!(property instanceof BaseFunction)) {
            if (property instanceof Scriptable) {
                Scriptable scriptable2 = (Scriptable) property;
                obj = scriptable2.get("prototype", scriptable2);
            }
            return null;
        }
        obj = ((BaseFunction) property).getPrototypeProperty();
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return null;
    }

    public static Object getDefaultValue(Scriptable scriptable, Class<?> cls) {
        Context context = null;
        for (int i = 0; i < 2; i++) {
            boolean z = true;
            if (cls != ScriptRuntime.StringClass ? i != 1 : i != 0) {
                z = false;
            }
            Object property = getProperty(scriptable, z ? AnnotationHandler.STRING : "valueOf");
            if (property instanceof Function) {
                Function function = (Function) property;
                if (context == null) {
                    context = Context.getContext();
                }
                Object call = function.call(context, function.getParentScope(), scriptable, ScriptRuntime.emptyArgs);
                if (call != null) {
                    if (!(call instanceof Scriptable)) {
                        return call;
                    }
                    if (cls != ScriptRuntime.ScriptableClass && cls != ScriptRuntime.FunctionClass) {
                        if (z && (call instanceof Wrapper)) {
                            call = ((Wrapper) call).unwrap();
                            if (call instanceof String) {
                            }
                        }
                    }
                    return call;
                }
                continue;
            }
        }
        throw ScriptRuntime.typeError1("msg.default.value", cls == null ? "undefined" : cls.getName());
    }

    public static Scriptable getFunctionPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Function);
    }

    public static Scriptable getObjectPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Object);
    }

    public static Object getProperty(Scriptable scriptable, int i) {
        Object obj;
        Scriptable scriptable2 = scriptable;
        do {
            obj = scriptable2.get(i, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable2 = scriptable2.getPrototype();
        } while (scriptable2 != null);
        return obj;
    }

    public static Object getProperty(Scriptable scriptable, String str) {
        Object obj;
        Scriptable scriptable2 = scriptable;
        do {
            obj = scriptable2.get(str, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable2 = scriptable2.getPrototype();
        } while (scriptable2 != null);
        return obj;
    }

    public static Object getProperty(Scriptable scriptable, Symbol symbol) {
        Object obj;
        Scriptable scriptable2 = scriptable;
        do {
            obj = ensureSymbolScriptable(scriptable2).get(symbol, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            scriptable2 = scriptable2.getPrototype();
        } while (scriptable2 != null);
        return obj;
    }

    public static Object[] getPropertyIds(Scriptable scriptable) {
        if (scriptable == null) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] ids = scriptable.getIds();
        ObjToIntMap objToIntMap = null;
        while (true) {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                break;
            }
            Object[] ids2 = scriptable.getIds();
            if (ids2.length != 0) {
                if (objToIntMap == null) {
                    if (ids.length == 0) {
                        ids = ids2;
                    } else {
                        objToIntMap = new ObjToIntMap(ids.length + ids2.length);
                        for (int i = 0; i != ids.length; i++) {
                            objToIntMap.intern(ids[i]);
                        }
                        ids = null;
                    }
                }
                for (int i2 = 0; i2 != ids2.length; i2++) {
                    objToIntMap.intern(ids2[i2]);
                }
            }
        }
        return objToIntMap != null ? objToIntMap.getKeys() : ids;
    }

    public static String getPropertyName(String str, String str2, Annotation annotation) {
        if (str2 != null) {
            return str.substring(str2.length());
        }
        String str3 = null;
        if (annotation instanceof JSGetter) {
            str3 = ((JSGetter) annotation).value();
            if ((str3 == null || str3.length() == 0) && str.length() > 3 && str.startsWith("get")) {
                str3 = str.substring(3);
                if (Character.isUpperCase(str3.charAt(0))) {
                    if (str3.length() == 1) {
                        str3 = str3.toLowerCase();
                    } else if (!Character.isUpperCase(str3.charAt(1))) {
                        str3 = Character.toLowerCase(str3.charAt(0)) + str3.substring(1);
                    }
                }
            }
        } else if (annotation instanceof JSFunction) {
            str3 = ((JSFunction) annotation).value();
        } else if (annotation instanceof JSStaticFunction) {
            str3 = ((JSStaticFunction) annotation).value();
        }
        return (str3 == null || str3.length() == 0) ? str : str3;
    }

    public static Scriptable getTopLevelScope(Scriptable scriptable) {
        while (true) {
            Scriptable parentScope = scriptable.getParentScope();
            if (parentScope == null) {
                return scriptable;
            }
            scriptable = parentScope;
        }
    }

    public static Object getTopScopeValue(Scriptable scriptable, Object obj) {
        Object associatedValue;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        do {
            if ((topLevelScope instanceof ScriptableObject) && (associatedValue = ((ScriptableObject) topLevelScope).getAssociatedValue(obj)) != null) {
                return associatedValue;
            }
            topLevelScope = topLevelScope.getPrototype();
        } while (topLevelScope != null);
        return null;
    }

    public static <T> T getTypedProperty(Scriptable scriptable, int i, Class<T> cls) {
        Object property = getProperty(scriptable, i);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    public static <T> T getTypedProperty(Scriptable scriptable, String str, Class<T> cls) {
        Object property = getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    public static boolean hasProperty(Scriptable scriptable, int i) {
        return getBase(scriptable, i) != null;
    }

    public static boolean hasProperty(Scriptable scriptable, String str) {
        return getBase(scriptable, str) != null;
    }

    public static boolean hasProperty(Scriptable scriptable, Symbol symbol) {
        return getBase(scriptable, symbol) != null;
    }

    public static boolean isFalse(Object obj) {
        return !isTrue(obj);
    }

    public static boolean isTrue(Object obj) {
        return obj != Scriptable.NOT_FOUND && ScriptRuntime.toBoolean(obj);
    }

    private boolean putConstImpl(String str, int i, Scriptable scriptable, Object obj, int i2) {
        Slot query;
        if (this.isExtensible || !Context.getContext().isStrictMode()) {
            if (this != scriptable) {
                query = this.slotMap.query(str, i);
                if (query == null) {
                    return false;
                }
            } else if (isExtensible()) {
                checkNotSealed(str, i);
                Slot slot = this.slotMap.get(str, i, SlotAccess.MODIFY_CONST);
                int attributes = slot.getAttributes();
                if ((attributes & 1) == 0) {
                    throw Context.reportRuntimeError1("msg.var.redecl", str);
                }
                if ((attributes & 8) != 0) {
                    slot.value = obj;
                    if (i2 != 8) {
                        slot.setAttributes(attributes & (-9));
                    }
                }
                return true;
            } else {
                query = this.slotMap.query(str, i);
                if (query == null) {
                    return true;
                }
            }
            return query.setValue(obj, this, scriptable);
        }
        throw ScriptRuntime.typeError0("msg.not.extensible");
    }

    public static void putConstProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        if (base instanceof ConstProperties) {
            ((ConstProperties) base).putConst(str, scriptable, obj);
        }
    }

    private boolean putImpl(Object obj, int i, Scriptable scriptable, Object obj2) {
        Slot slot;
        if (this.isExtensible || !Context.getContext().isStrictMode()) {
            if (this != scriptable) {
                slot = this.slotMap.query(obj, i);
                if (slot == null) {
                    return false;
                }
            } else if (!this.isExtensible) {
                slot = this.slotMap.query(obj, i);
                if (slot == null) {
                    return true;
                }
            } else {
                if (this.isSealed) {
                    checkNotSealed(obj, i);
                }
                slot = this.slotMap.get(obj, i, SlotAccess.MODIFY);
            }
            return slot.setValue(obj2, this, scriptable);
        }
        throw ScriptRuntime.typeError0("msg.not.extensible");
    }

    public static void putProperty(Scriptable scriptable, int i, Object obj) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            base = scriptable;
        }
        base.put(i, scriptable, obj);
    }

    public static void putProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        base.put(str, scriptable, obj);
    }

    public static void putProperty(Scriptable scriptable, Symbol symbol, Object obj) {
        Scriptable base = getBase(scriptable, symbol);
        if (base == null) {
            base = scriptable;
        }
        ensureSymbolScriptable(base).put(symbol, scriptable, obj);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.slotMap = createSlotMap(readInt);
        for (int i = 0; i < readInt; i++) {
            this.slotMap.addSlot((Slot) objectInputStream.readObject());
        }
    }

    public static void redefineProperty(Scriptable scriptable, String str, boolean z) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return;
        }
        if ((base instanceof ConstProperties) && ((ConstProperties) base).isConst(str)) {
            throw ScriptRuntime.typeError1("msg.const.redecl", str);
        }
        if (z) {
            throw ScriptRuntime.typeError1("msg.var.redecl", str);
        }
    }

    private void setGetterOrSetter(String str, int i, Callable callable, boolean z, boolean z2) {
        Slot query;
        if (str == null || i == 0) {
            if (!z2) {
                checkNotSealed(str, i);
            }
            if (isExtensible()) {
                query = this.slotMap.get(str, i, SlotAccess.MODIFY_GETTER_SETTER);
            } else {
                query = this.slotMap.query(str, i);
                if (!(query instanceof GetterSlot)) {
                    return;
                }
            }
            GetterSlot getterSlot = (GetterSlot) query;
            if (!z2 && (getterSlot.getAttributes() & 1) != 0) {
                throw Context.reportRuntimeError1("msg.modify.readonly", str);
            }
            if (z) {
                getterSlot.setter = callable;
            } else {
                getterSlot.getter = callable;
            }
            getterSlot.value = Undefined.instance;
            return;
        }
        throw new IllegalArgumentException(str);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        long readLock = this.slotMap.readLock();
        try {
            int dirtySize = this.slotMap.dirtySize();
            if (dirtySize == 0) {
                objectOutputStream.writeInt(0);
            } else {
                objectOutputStream.writeInt(dirtySize);
                Iterator<Slot> it = this.slotMap.iterator();
                while (it.hasNext()) {
                    objectOutputStream.writeObject(it.next());
                }
            }
        } finally {
            this.slotMap.unlockRead(readLock);
        }
    }

    public void addLazilyInitializedValue(String str, int i, LazilyLoadedCtor lazilyLoadedCtor, int i2) {
        if (str == null || i == 0) {
            checkNotSealed(str, i);
            GetterSlot getterSlot = (GetterSlot) this.slotMap.get(str, i, SlotAccess.MODIFY_GETTER_SETTER);
            getterSlot.setAttributes(i2);
            getterSlot.getter = null;
            getterSlot.setter = null;
            getterSlot.value = lazilyLoadedCtor;
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public int applyDescriptorToAttributeBitset(int i, ScriptableObject scriptableObject) {
        Object property = getProperty(scriptableObject, "enumerable");
        if (property != Scriptable.NOT_FOUND) {
            i = ScriptRuntime.toBoolean(property) ? i & (-3) : i | 2;
        }
        Object property2 = getProperty(scriptableObject, "writable");
        if (property2 != Scriptable.NOT_FOUND) {
            i = ScriptRuntime.toBoolean(property2) ? i & (-2) : i | 1;
        }
        Object property3 = getProperty(scriptableObject, "configurable");
        return property3 != Scriptable.NOT_FOUND ? ScriptRuntime.toBoolean(property3) ? i & (-5) : i | 4 : i;
    }

    public final synchronized Object associateValue(Object obj, Object obj2) {
        Map map;
        if (obj2 == null) {
            throw new IllegalArgumentException();
        }
        map = this.associatedValues;
        if (map == null) {
            map = new HashMap();
            this.associatedValues = map;
        }
        return Kit.initHash(map, obj, obj2);
    }

    public boolean avoidObjectDetection() {
        return false;
    }

    public void checkPropertyChange(Object obj, ScriptableObject scriptableObject, ScriptableObject scriptableObject2) {
        if (scriptableObject == null) {
            if (!isExtensible()) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
        } else if (!isFalse(scriptableObject.get("configurable", scriptableObject))) {
        } else {
            if (isTrue(getProperty(scriptableObject2, "configurable"))) {
                throw ScriptRuntime.typeError1("msg.change.configurable.false.to.true", obj);
            }
            if (isTrue(scriptableObject.get("enumerable", scriptableObject)) != isTrue(getProperty(scriptableObject2, "enumerable"))) {
                throw ScriptRuntime.typeError1("msg.change.enumerable.with.configurable.false", obj);
            }
            boolean isDataDescriptor = isDataDescriptor(scriptableObject2);
            boolean isAccessorDescriptor = isAccessorDescriptor(scriptableObject2);
            if (!isDataDescriptor && !isAccessorDescriptor) {
                return;
            }
            if (isDataDescriptor && isDataDescriptor(scriptableObject)) {
                if (!isFalse(scriptableObject.get("writable", scriptableObject))) {
                    return;
                }
                if (isTrue(getProperty(scriptableObject2, "writable"))) {
                    throw ScriptRuntime.typeError1("msg.change.writable.false.to.true.with.configurable.false", obj);
                }
                if (!sameValue(getProperty(scriptableObject2, "value"), scriptableObject.get("value", scriptableObject))) {
                    throw ScriptRuntime.typeError1("msg.change.value.with.writable.false", obj);
                }
            } else if (!isAccessorDescriptor || !isAccessorDescriptor(scriptableObject)) {
                if (!isDataDescriptor(scriptableObject)) {
                    throw ScriptRuntime.typeError1("msg.change.property.accessor.to.data.with.configurable.false", obj);
                }
                throw ScriptRuntime.typeError1("msg.change.property.data.to.accessor.with.configurable.false", obj);
            } else if (!sameValue(getProperty(scriptableObject2, "set"), scriptableObject.get("set", scriptableObject))) {
                throw ScriptRuntime.typeError1("msg.change.setter.with.configurable.false", obj);
            } else {
                if (!sameValue(getProperty(scriptableObject2, "get"), scriptableObject.get("get", scriptableObject))) {
                    throw ScriptRuntime.typeError1("msg.change.getter.with.configurable.false", obj);
                }
            }
        }
    }

    public void checkPropertyDefinition(ScriptableObject scriptableObject) {
        Object property = getProperty(scriptableObject, "get");
        if (property == Scriptable.NOT_FOUND || property == Undefined.instance || (property instanceof Callable)) {
            Object property2 = getProperty(scriptableObject, "set");
            if (property2 != Scriptable.NOT_FOUND && property2 != Undefined.instance && !(property2 instanceof Callable)) {
                throw ScriptRuntime.notFunctionError(property2);
            }
            if (isDataDescriptor(scriptableObject) && isAccessorDescriptor(scriptableObject)) {
                throw ScriptRuntime.typeError0("msg.both.data.and.accessor.desc");
            }
            return;
        }
        throw ScriptRuntime.notFunctionError(property);
    }

    @Override // org.mozilla.javascript.ConstProperties
    public void defineConst(String str, Scriptable scriptable) {
        if (putConstImpl(str, 0, scriptable, Undefined.instance, 8)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (!(scriptable instanceof ConstProperties)) {
            return;
        }
        ((ConstProperties) scriptable).defineConst(str, scriptable);
    }

    public void defineFunctionProperties(String[] strArr, Class<?> cls, int i) {
        Method[] methodList = FunctionObject.getMethodList(cls);
        for (String str : strArr) {
            Method findSingleMethod = FunctionObject.findSingleMethod(methodList, str);
            if (findSingleMethod == null) {
                throw Context.reportRuntimeError2("msg.method.not.found", str, cls.getName());
            }
            defineProperty(str, new FunctionObject(str, findSingleMethod, this), i);
        }
    }

    public void defineOwnProperties(Context context, ScriptableObject scriptableObject) {
        Object[] ids = scriptableObject.getIds(false, true);
        ScriptableObject[] scriptableObjectArr = new ScriptableObject[ids.length];
        int length = ids.length;
        for (int i = 0; i < length; i++) {
            ScriptableObject ensureScriptableObject = ensureScriptableObject(ScriptRuntime.getObjectElem((Scriptable) scriptableObject, ids[i], context));
            checkPropertyDefinition(ensureScriptableObject);
            scriptableObjectArr[i] = ensureScriptableObject;
        }
        int length2 = ids.length;
        for (int i2 = 0; i2 < length2; i2++) {
            defineOwnProperty(context, ids[i2], scriptableObjectArr[i2]);
        }
    }

    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject) {
        checkPropertyDefinition(scriptableObject);
        defineOwnProperty(context, obj, scriptableObject, true);
    }

    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        int attributes;
        Object property;
        Slot slot;
        GetterSlot getterSlot;
        Slot slot2 = getSlot(context, obj, SlotAccess.QUERY);
        boolean z2 = slot2 == null;
        if (z) {
            checkPropertyChange(obj, slot2 == null ? null : slot2.getPropertyDescriptor(context, this), scriptableObject);
        }
        boolean isAccessorDescriptor = isAccessorDescriptor(scriptableObject);
        if (slot2 == null) {
            slot2 = getSlot(context, obj, isAccessorDescriptor ? SlotAccess.MODIFY_GETTER_SETTER : SlotAccess.MODIFY);
            attributes = 7;
        } else {
            attributes = slot2.getAttributes();
        }
        int applyDescriptorToAttributeBitset = applyDescriptorToAttributeBitset(attributes, scriptableObject);
        if (isAccessorDescriptor) {
            if (!(slot2 instanceof GetterSlot)) {
                slot2 = getSlot(context, obj, SlotAccess.MODIFY_GETTER_SETTER);
            }
            GetterSlot getterSlot2 = (GetterSlot) slot2;
            Object property2 = getProperty(scriptableObject, "get");
            if (property2 != Scriptable.NOT_FOUND) {
                getterSlot2.getter = property2;
            }
            Object property3 = getProperty(scriptableObject, "set");
            if (property3 != Scriptable.NOT_FOUND) {
                getterSlot2.setter = property3;
            }
            property = Undefined.instance;
            getterSlot = getterSlot2;
        } else {
            boolean z3 = slot2 instanceof GetterSlot;
            Slot slot3 = slot2;
            if (z3) {
                slot3 = slot2;
                if (isDataDescriptor(scriptableObject)) {
                    slot3 = getSlot(context, obj, SlotAccess.CONVERT_ACCESSOR_TO_DATA);
                }
            }
            property = getProperty(scriptableObject, "value");
            getterSlot = slot3;
            slot = slot3;
            if (property == Scriptable.NOT_FOUND) {
                if (z2) {
                    property = Undefined.instance;
                    getterSlot = slot3;
                }
                slot.setAttributes(applyDescriptorToAttributeBitset);
            }
        }
        getterSlot.value = property;
        slot = getterSlot;
        slot.setAttributes(applyDescriptorToAttributeBitset);
    }

    public void defineProperty(String str, Class<?> cls, int i) {
        int length = str.length();
        if (length != 0) {
            char[] cArr = new char[length + 3];
            str.getChars(0, length, cArr, 3);
            cArr[3] = Character.toUpperCase(cArr[3]);
            cArr[0] = 'g';
            cArr[1] = 'e';
            cArr[2] = 't';
            String str2 = new String(cArr);
            cArr[0] = 's';
            String str3 = new String(cArr);
            Method[] methodList = FunctionObject.getMethodList(cls);
            Method findSingleMethod = FunctionObject.findSingleMethod(methodList, str2);
            Method findSingleMethod2 = FunctionObject.findSingleMethod(methodList, str3);
            if (findSingleMethod2 == null) {
                i |= 1;
            }
            int i2 = i;
            if (findSingleMethod2 == null) {
                findSingleMethod2 = null;
            }
            defineProperty(str, null, findSingleMethod, findSingleMethod2, i2);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void defineProperty(String str, Object obj, int i) {
        checkNotSealed(str, 0);
        put(str, this, obj);
        setAttributes(str, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x003c, code lost:
        if (r5 == org.mozilla.javascript.ScriptRuntime.ScriptableObjectClass) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003f, code lost:
        if (r4 != false) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void defineProperty(String str, Object obj, Method method, Method method2, int i) {
        MemberBox memberBox;
        boolean z;
        String str2;
        boolean z2;
        String str3 = null;
        if (method != null) {
            memberBox = new MemberBox(method);
            if (!Modifier.isStatic(method.getModifiers())) {
                z2 = obj != null;
                memberBox.delegateTo = obj;
            } else {
                memberBox.delegateTo = Void.TYPE;
                z2 = true;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            String str4 = "msg.bad.getter.parms";
            if (parameterTypes.length == 0) {
                if (z2) {
                    str4 = "msg.obj.getter.parms";
                    if (str4 != null) {
                        throw Context.reportRuntimeError1(str4, method.toString());
                    }
                }
                str4 = null;
                if (str4 != null) {
                }
            } else {
                if (parameterTypes.length == 1) {
                    Class<?> cls = parameterTypes[0];
                    if (cls != ScriptRuntime.ScriptableClass) {
                    }
                }
                if (str4 != null) {
                }
            }
        } else {
            memberBox = null;
        }
        if (method2 != null) {
            if (method2.getReturnType() != Void.TYPE) {
                throw Context.reportRuntimeError1("msg.setter.return", method2.toString());
            }
            MemberBox memberBox2 = new MemberBox(method2);
            if (!Modifier.isStatic(method2.getModifiers())) {
                z = obj != null;
                memberBox2.delegateTo = obj;
            } else {
                memberBox2.delegateTo = Void.TYPE;
                z = true;
            }
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            if (parameterTypes2.length == 1) {
                if (z) {
                    str3 = "msg.setter2.expected";
                }
            } else if (parameterTypes2.length == 2) {
                Class<?> cls2 = parameterTypes2[0];
                if (cls2 != ScriptRuntime.ScriptableClass && cls2 != ScriptRuntime.ScriptableObjectClass) {
                    str2 = "msg.setter2.parms";
                } else if (!z) {
                    str2 = "msg.setter1.parms";
                }
                str3 = str2;
            } else {
                str3 = "msg.setter.parms";
            }
            if (str3 != null) {
                throw Context.reportRuntimeError1(str3, method2.toString());
            }
            str3 = memberBox2;
        }
        GetterSlot getterSlot = (GetterSlot) this.slotMap.get(str, 0, SlotAccess.MODIFY_GETTER_SETTER);
        getterSlot.setAttributes(i);
        getterSlot.getter = memberBox;
        getterSlot.setter = str3;
    }

    public void defineProperty(Symbol symbol, Object obj, int i) {
        checkNotSealed(symbol, 0);
        put(symbol, this, obj);
        setAttributes(symbol, i);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i) {
        checkNotSealed(null, i);
        this.slotMap.remove(null, i);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
        checkNotSealed(str, 0);
        this.slotMap.remove(str, 0);
    }

    public void delete(Symbol symbol) {
        checkNotSealed(symbol, 0);
        this.slotMap.remove(symbol, 0);
    }

    public Object equivalentValues(Object obj) {
        return this == obj ? Boolean.TRUE : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        ExternalArrayData externalArrayData = this.externalData;
        if (externalArrayData != null) {
            return i < externalArrayData.getArrayLength() ? this.externalData.getArrayElement(i) : Scriptable.NOT_FOUND;
        }
        Slot query = this.slotMap.query(null, i);
        return query == null ? Scriptable.NOT_FOUND : query.getValue(scriptable);
    }

    public Object get(Object obj) {
        Object obj2 = obj instanceof String ? get((String) obj, this) : obj instanceof Symbol ? get((Symbol) obj, this) : obj instanceof Number ? get(((Number) obj).intValue(), this) : null;
        if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
            return null;
        }
        return obj2 instanceof Wrapper ? ((Wrapper) obj2).unwrap() : obj2;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Slot query = this.slotMap.query(str, 0);
        return query == null ? Scriptable.NOT_FOUND : query.getValue(scriptable);
    }

    public Object get(Symbol symbol, Scriptable scriptable) {
        Slot query = this.slotMap.query(symbol, 0);
        return query == null ? Scriptable.NOT_FOUND : query.getValue(scriptable);
    }

    @Override // org.mozilla.javascript.debug.DebuggableObject
    public Object[] getAllIds() {
        return getIds(true, false);
    }

    public final Object getAssociatedValue(Object obj) {
        Map<Object, Object> map = this.associatedValues;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public int getAttributes(int i) {
        return findAttributeSlot(null, i, SlotAccess.QUERY).getAttributes();
    }

    @Deprecated
    public final int getAttributes(int i, Scriptable scriptable) {
        return getAttributes(i);
    }

    public int getAttributes(String str) {
        return findAttributeSlot(str, 0, SlotAccess.QUERY).getAttributes();
    }

    @Deprecated
    public final int getAttributes(String str, Scriptable scriptable) {
        return getAttributes(str);
    }

    public int getAttributes(Symbol symbol) {
        return findAttributeSlot(symbol, SlotAccess.QUERY).getAttributes();
    }

    @Override // org.mozilla.javascript.Scriptable
    public abstract String getClassName();

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return getDefaultValue(this, cls);
    }

    public ExternalArrayData getExternalArrayData() {
        return this.externalData;
    }

    public Object getExternalArrayLength() {
        ExternalArrayData externalArrayData = this.externalData;
        return Integer.valueOf(externalArrayData == null ? 0 : externalArrayData.getArrayLength());
    }

    public Object getGetterOrSetter(String str, int i, boolean z) {
        if (str == null || i == 0) {
            Slot query = this.slotMap.query(str, i);
            if (query == null) {
                return null;
            }
            if (!(query instanceof GetterSlot)) {
                return Undefined.instance;
            }
            GetterSlot getterSlot = (GetterSlot) query;
            Object obj = z ? getterSlot.setter : getterSlot.getter;
            return obj != null ? obj : Undefined.instance;
        }
        throw new IllegalArgumentException(str);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return getIds(false, false);
    }

    public Object[] getIds(boolean z, boolean z2) {
        Object[] objArr;
        ExternalArrayData externalArrayData = this.externalData;
        int arrayLength = externalArrayData == null ? 0 : externalArrayData.getArrayLength();
        if (arrayLength == 0) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            objArr = new Object[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                objArr[i] = Integer.valueOf(i);
            }
        }
        if (this.slotMap.isEmpty()) {
            return objArr;
        }
        long readLock = this.slotMap.readLock();
        try {
            Iterator<Slot> it = this.slotMap.iterator();
            int i2 = arrayLength;
            while (it.hasNext()) {
                Slot next = it.next();
                if (z || (next.getAttributes() & 2) == 0) {
                    if (z2 || !(next.name instanceof Symbol)) {
                        if (i2 == arrayLength) {
                            Object[] objArr2 = new Object[this.slotMap.dirtySize() + arrayLength];
                            if (objArr != null) {
                                System.arraycopy(objArr, 0, objArr2, 0, arrayLength);
                            }
                            objArr = objArr2;
                        }
                        int i3 = i2 + 1;
                        objArr[i2] = next.name != null ? next.name : Integer.valueOf(next.indexOrHash);
                        i2 = i3;
                    }
                }
            }
            this.slotMap.unlockRead(readLock);
            if (i2 != objArr.length + arrayLength) {
                Object[] objArr3 = new Object[i2];
                System.arraycopy(objArr, 0, objArr3, 0, i2);
                objArr = objArr3;
            }
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(16)) {
                Arrays.sort(objArr, KEY_COMPARATOR);
            }
            return objArr;
        } catch (Throwable th) {
            this.slotMap.unlockRead(readLock);
            throw th;
        }
    }

    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        Slot slot = getSlot(context, obj, SlotAccess.QUERY);
        if (slot == null) {
            return null;
        }
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        return slot.getPropertyDescriptor(context, parentScope);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return this.parentScopeObject;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        return this.prototypeObject;
    }

    public Slot getSlot(Context context, Object obj, SlotAccess slotAccess) {
        if (obj instanceof Symbol) {
            return this.slotMap.get(obj, 0, slotAccess);
        }
        String stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(context, obj);
        return stringIdOrIndex == null ? this.slotMap.get(null, ScriptRuntime.lastIndexResult(context), slotAccess) : this.slotMap.get(stringIdOrIndex, 0, slotAccess);
    }

    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "object";
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        ExternalArrayData externalArrayData = this.externalData;
        return externalArrayData != null ? i < externalArrayData.getArrayLength() : this.slotMap.query(null, i) != null;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.slotMap.query(str, 0) != null;
    }

    public boolean has(Symbol symbol, Scriptable scriptable) {
        return this.slotMap.query(symbol, 0) != null;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return ScriptRuntime.jsDelegatesTo(scriptable, this);
    }

    public boolean isAccessorDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, "get") || hasProperty(scriptableObject, "set");
    }

    @Override // org.mozilla.javascript.ConstProperties
    public boolean isConst(String str) {
        Slot query = this.slotMap.query(str, 0);
        return query != null && (query.getAttributes() & 5) == 5;
    }

    public boolean isDataDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, "value") || hasProperty(scriptableObject, "writable");
    }

    public boolean isEmpty() {
        return this.slotMap.isEmpty();
    }

    public boolean isExtensible() {
        return this.isExtensible;
    }

    public boolean isGenericDescriptor(ScriptableObject scriptableObject) {
        return !isDataDescriptor(scriptableObject) && !isAccessorDescriptor(scriptableObject);
    }

    public boolean isGetterOrSetter(String str, int i, boolean z) {
        Slot query = this.slotMap.query(str, i);
        if (query instanceof GetterSlot) {
            if (z && ((GetterSlot) query).setter != null) {
                return true;
            }
            return !z && ((GetterSlot) query).getter != null;
        }
        return false;
    }

    public final boolean isSealed() {
        return this.isSealed;
    }

    public void preventExtensions() {
        this.isExtensible = false;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        ExternalArrayData externalArrayData = this.externalData;
        if (externalArrayData != null) {
            if (i >= externalArrayData.getArrayLength()) {
                throw new JavaScriptException(ScriptRuntime.newNativeError(Context.getCurrentContext(), this, TopLevel.NativeErrors.RangeError, new Object[]{"External array index out of bounds "}), null, 0);
            }
            this.externalData.setArrayElement(i, obj);
        } else if (putImpl(null, i, scriptable, obj)) {
        } else {
            if (scriptable == this) {
                throw Kit.codeBug();
            }
            scriptable.put(i, scriptable, obj);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (putImpl(str, 0, scriptable, obj)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        scriptable.put(str, scriptable, obj);
    }

    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        if (putImpl(symbol, 0, scriptable, obj)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        ensureSymbolScriptable(scriptable).put(symbol, scriptable, obj);
    }

    @Override // org.mozilla.javascript.ConstProperties
    public void putConst(String str, Scriptable scriptable, Object obj) {
        if (putConstImpl(str, 0, scriptable, obj, 1)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).putConst(str, scriptable, obj);
        } else {
            scriptable.put(str, scriptable, obj);
        }
    }

    public boolean sameValue(Object obj, Object obj2) {
        Object obj3 = Scriptable.NOT_FOUND;
        if (obj == obj3) {
            return true;
        }
        if (obj2 == obj3) {
            obj2 = Undefined.instance;
        }
        if ((obj2 instanceof Number) && (obj instanceof Number)) {
            double doubleValue = ((Number) obj2).doubleValue();
            double doubleValue2 = ((Number) obj).doubleValue();
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            if (doubleValue == RoundRectDrawableWithShadow.COS_45 && Double.doubleToLongBits(doubleValue) != Double.doubleToLongBits(doubleValue2)) {
                return false;
            }
        }
        return ScriptRuntime.shallowEq(obj2, obj);
    }

    public void sealObject() {
        if (!this.isSealed) {
            long readLock = this.slotMap.readLock();
            try {
                Iterator<Slot> it = this.slotMap.iterator();
                while (it.hasNext()) {
                    Slot next = it.next();
                    Object obj = next.value;
                    if (obj instanceof LazilyLoadedCtor) {
                        LazilyLoadedCtor lazilyLoadedCtor = (LazilyLoadedCtor) obj;
                        lazilyLoadedCtor.init();
                        next.value = lazilyLoadedCtor.getValue();
                    }
                }
                this.isSealed = true;
            } finally {
                this.slotMap.unlockRead(readLock);
            }
        }
    }

    public void setAttributes(int i, int i2) {
        checkNotSealed(null, i);
        findAttributeSlot(null, i, SlotAccess.MODIFY).setAttributes(i2);
    }

    @Deprecated
    public void setAttributes(int i, Scriptable scriptable, int i2) {
        setAttributes(i, i2);
    }

    public void setAttributes(String str, int i) {
        checkNotSealed(str, 0);
        findAttributeSlot(str, 0, SlotAccess.MODIFY).setAttributes(i);
    }

    @Deprecated
    public final void setAttributes(String str, Scriptable scriptable, int i) {
        setAttributes(str, i);
    }

    public void setAttributes(Symbol symbol, int i) {
        checkNotSealed(symbol, 0);
        findAttributeSlot(symbol, SlotAccess.MODIFY).setAttributes(i);
    }

    public void setExternalArrayData(ExternalArrayData externalArrayData) {
        this.externalData = externalArrayData;
        if (externalArrayData == null) {
            delete(Name.LENGTH);
        } else {
            defineProperty(Name.LENGTH, null, GET_ARRAY_LENGTH, null, 3);
        }
    }

    public void setGetterOrSetter(String str, int i, Callable callable, boolean z) {
        setGetterOrSetter(str, i, callable, z, false);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parentScopeObject = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        this.prototypeObject = scriptable;
    }

    public int size() {
        return this.slotMap.size();
    }
}
