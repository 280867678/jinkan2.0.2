package org.mozilla.javascript;

import com.umeng.analytics.pro.C1543ak;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;
import okhttp3.HttpUrl;

/* loaded from: classes5.dex */
public class JavaMembers {

    /* renamed from: cl */
    public Class<?> f4671cl;
    public NativeJavaMethod ctors;
    public Map<String, FieldAndMethods> fieldAndMethods;
    public Map<String, Object> members;
    public Map<String, FieldAndMethods> staticFieldAndMethods;
    public Map<String, Object> staticMembers;

    /* loaded from: classes5.dex */
    public static final class MethodSignature {
        public final Class<?>[] args;
        public final String name;

        public MethodSignature(String str, Class<?>[] clsArr) {
            this.name = str;
            this.args = clsArr;
        }

        public MethodSignature(Method method) {
            this(method.getName(), method.getParameterTypes());
        }

        public boolean equals(Object obj) {
            if (obj instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) obj;
                return methodSignature.name.equals(this.name) && Arrays.equals(this.args, methodSignature.args);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode() ^ this.args.length;
        }
    }

    public JavaMembers(Scriptable scriptable, Class<?> cls) {
        this(scriptable, cls, false);
    }

    public JavaMembers(Scriptable scriptable, Class<?> cls, boolean z) {
        try {
            Context enterContext = ContextFactory.getGlobal().enterContext();
            ClassShutter classShutter = enterContext.getClassShutter();
            if (classShutter != null && !classShutter.visibleToScripts(cls.getName())) {
                throw Context.reportRuntimeError1("msg.access.prohibited", cls.getName());
            }
            this.members = new HashMap();
            this.staticMembers = new HashMap();
            this.f4671cl = cls;
            reflect(scriptable, z, enterContext.hasFeature(13));
        } finally {
            Context.exit();
        }
    }

    public static void discoverAccessibleMethods(Class<?> cls, Map<MethodSignature, Method> map, boolean z, boolean z2) {
        Method[] methods;
        Method[] declaredMethods;
        Method[] methods2;
        if (Modifier.isPublic(cls.getModifiers()) || z2) {
            try {
                if (!z && !z2) {
                    for (Method method : cls.getMethods()) {
                        MethodSignature methodSignature = new MethodSignature(method);
                        if (!map.containsKey(methodSignature)) {
                            map.put(methodSignature, method);
                        }
                    }
                    return;
                }
                while (cls != null) {
                    try {
                        for (Method method2 : cls.getDeclaredMethods()) {
                            int modifiers = method2.getModifiers();
                            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers) || z2) {
                                MethodSignature methodSignature2 = new MethodSignature(method2);
                                if (!map.containsKey(methodSignature2)) {
                                    if (z2 && !method2.isAccessible()) {
                                        method2.setAccessible(true);
                                    }
                                    map.put(methodSignature2, method2);
                                }
                            }
                        }
                        for (Class<?> cls2 : cls.getInterfaces()) {
                            discoverAccessibleMethods(cls2, map, z, z2);
                        }
                        cls = cls.getSuperclass();
                    } catch (SecurityException unused) {
                        for (Method method3 : cls.getMethods()) {
                            MethodSignature methodSignature3 = new MethodSignature(method3);
                            if (!map.containsKey(methodSignature3)) {
                                map.put(methodSignature3, method3);
                            }
                        }
                        return;
                    }
                }
                return;
            } catch (SecurityException unused2) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not discover accessible methods of class ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" due to lack of privileges, attemping superclasses/interfaces.");
                Context.reportWarning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            discoverAccessibleMethods(cls3, map, z, z2);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            discoverAccessibleMethods(superclass, map, z, z2);
        }
    }

    public static Method[] discoverAccessibleMethods(Class<?> cls, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        discoverAccessibleMethods(cls, hashMap, z, z2);
        return (Method[]) hashMap.values().toArray(new Method[hashMap.size()]);
    }

    public static MemberBox extractGetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if (memberBox.argTypes.length == 0 && (!z || memberBox.isStatic())) {
                if (memberBox.method().getReturnType() == Void.TYPE) {
                    return null;
                }
                return memberBox;
            }
        }
        return null;
    }

    public static MemberBox extractSetMethod(Class<?> cls, MemberBox[] memberBoxArr, boolean z) {
        for (int i = 1; i <= 2; i++) {
            for (MemberBox memberBox : memberBoxArr) {
                if (!z || memberBox.isStatic()) {
                    Class<?>[] clsArr = memberBox.argTypes;
                    if (clsArr.length != 1) {
                        continue;
                    } else if (i != 1) {
                        if (i != 2) {
                            Kit.codeBug();
                        }
                        if (clsArr[0].isAssignableFrom(cls)) {
                            return memberBox;
                        }
                    } else if (clsArr[0] == cls) {
                        return memberBox;
                    }
                }
            }
        }
        return null;
    }

    public static MemberBox extractSetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if ((!z || memberBox.isStatic()) && memberBox.method().getReturnType() == Void.TYPE && memberBox.argTypes.length == 1) {
                return memberBox;
            }
        }
        return null;
    }

    private MemberBox findExplicitFunction(String str, boolean z) {
        MemberBox[] memberBoxArr;
        int indexOf = str.indexOf(40);
        if (indexOf < 0) {
            return null;
        }
        Map<String, Object> map = z ? this.staticMembers : this.members;
        if (z && indexOf == 0) {
            memberBoxArr = this.ctors.methods;
        } else {
            String substring = str.substring(0, indexOf);
            Object obj = map.get(substring);
            if (!z && obj == null) {
                obj = this.staticMembers.get(substring);
            }
            memberBoxArr = obj instanceof NativeJavaMethod ? ((NativeJavaMethod) obj).methods : null;
        }
        if (memberBoxArr != null) {
            for (MemberBox memberBox : memberBoxArr) {
                String liveConnectSignature = liveConnectSignature(memberBox.argTypes);
                if (liveConnectSignature.length() + indexOf == str.length() && str.regionMatches(indexOf, liveConnectSignature, 0, liveConnectSignature.length())) {
                    return memberBox;
                }
            }
        }
        return null;
    }

    private MemberBox findGetter(boolean z, Map<String, Object> map, String str, String str2) {
        String concat = str.concat(str2);
        if (map.containsKey(concat)) {
            Object obj = map.get(concat);
            if (!(obj instanceof NativeJavaMethod)) {
                return null;
            }
            return extractGetMethod(((NativeJavaMethod) obj).methods, z);
        }
        return null;
    }

    private Constructor<?>[] getAccessibleConstructors(boolean z) {
        Class<?> cls;
        if (z && (cls = this.f4671cl) != ScriptRuntime.ClassClass) {
            try {
                Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                AccessibleObject.setAccessible(declaredConstructors, true);
                return declaredConstructors;
            } catch (SecurityException unused) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not access constructor  of class ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4671cl.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" due to lack of privileges.");
                Context.reportWarning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        return this.f4671cl.getConstructors();
    }

    private Field[] getAccessibleFields(boolean z, boolean z2) {
        Field[] declaredFields;
        if (z2 || z) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Class<?> cls = this.f4671cl; cls != null; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (z2 || Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                            if (!field.isAccessible()) {
                                field.setAccessible(true);
                            }
                            arrayList.add(field);
                        }
                    }
                }
                return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
            } catch (SecurityException unused) {
            }
        }
        return this.f4671cl.getFields();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [org.mozilla.javascript.NativeJavaConstructor] */
    private Object getExplicitFunction(Scriptable scriptable, String str, Object obj, boolean z) {
        NativeJavaMethod nativeJavaMethod;
        Map<String, Object> map = z ? this.staticMembers : this.members;
        NativeJavaMethod nativeJavaMethod2 = null;
        MemberBox findExplicitFunction = findExplicitFunction(str, z);
        if (findExplicitFunction != null) {
            Scriptable functionPrototype = ScriptableObject.getFunctionPrototype(scriptable);
            if (findExplicitFunction.isCtor()) {
                nativeJavaMethod = new NativeJavaConstructor(findExplicitFunction);
            } else {
                Object obj2 = map.get(findExplicitFunction.getName());
                boolean z2 = obj2 instanceof NativeJavaMethod;
                nativeJavaMethod2 = obj2;
                if (z2) {
                    int length = ((NativeJavaMethod) obj2).methods.length;
                    nativeJavaMethod2 = obj2;
                    if (length > 1) {
                        nativeJavaMethod = new NativeJavaMethod(findExplicitFunction, str);
                    }
                }
            }
            nativeJavaMethod.setPrototype(functionPrototype);
            map.put(str, nativeJavaMethod);
            nativeJavaMethod2 = nativeJavaMethod;
        }
        return nativeJavaMethod2;
    }

    public static String javaSignature(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        int i = 0;
        do {
            i++;
            cls = cls.getComponentType();
        } while (cls.isArray());
        String name = cls.getName();
        if (i == 1) {
            return name.concat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        StringBuilder sb = new StringBuilder((i * 2) + name.length());
        sb.append(name);
        while (i != 0) {
            i--;
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    public static String liveConnectSignature(Class<?>[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return "()";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(');
        for (int i = 0; i != length; i++) {
            if (i != 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(javaSignature(clsArr[i]));
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static JavaMembers lookupClass(Scriptable scriptable, Class<?> cls, Class<?> cls2, boolean z) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<Class<?>, JavaMembers> classCacheMap = classCache.getClassCacheMap();
        Class<?> cls3 = cls;
        while (true) {
            JavaMembers javaMembers = classCacheMap.get(cls3);
            if (javaMembers != null) {
                if (cls3 != cls) {
                    classCacheMap.put(cls, javaMembers);
                }
                return javaMembers;
            }
            try {
                JavaMembers javaMembers2 = new JavaMembers(classCache.getAssociatedScope(), cls3, z);
                if (classCache.isCachingEnabled()) {
                    classCacheMap.put(cls3, javaMembers2);
                    if (cls3 != cls) {
                        classCacheMap.put(cls, javaMembers2);
                    }
                }
                return javaMembers2;
            } catch (SecurityException e) {
                if (cls2 == null || !cls2.isInterface()) {
                    Class<?> superclass = cls3.getSuperclass();
                    if (superclass == null) {
                        if (!cls3.isInterface()) {
                            throw e;
                        }
                        superclass = ScriptRuntime.ObjectClass;
                    }
                    cls3 = superclass;
                } else {
                    cls3 = cls2;
                    cls2 = null;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0186, code lost:
        r7 = 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0203  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [org.mozilla.javascript.NativeJavaMethod] */
    /* JADX WARN: Type inference failed for: r5v9, types: [org.mozilla.javascript.NativeJavaMethod] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void reflect(Scriptable scriptable, boolean z, boolean z2) {
        Method[] discoverAccessibleMethods;
        Field[] accessibleFields;
        char charAt;
        String str;
        Object obj;
        MemberBox findGetter;
        String concat;
        ?? r5;
        boolean isStatic;
        Map<String, Object> map;
        Object obj2;
        MemberBox[] memberBoxArr;
        ObjArray objArray;
        for (Method method : discoverAccessibleMethods(this.f4671cl, z, z2)) {
            Map<String, Object> map2 = Modifier.isStatic(method.getModifiers()) ? this.staticMembers : this.members;
            String name = method.getName();
            Object obj3 = map2.get(name);
            if (obj3 == null) {
                map2.put(name, method);
            } else {
                if (obj3 instanceof ObjArray) {
                    objArray = (ObjArray) obj3;
                } else {
                    if (!(obj3 instanceof Method)) {
                        Kit.codeBug();
                    }
                    ObjArray objArray2 = new ObjArray();
                    objArray2.add(obj3);
                    map2.put(name, objArray2);
                    objArray = objArray2;
                }
                objArray.add(method);
            }
        }
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i == 2) {
                break;
            }
            Map<String, Object> map3 = i == 0 ? this.staticMembers : this.members;
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Method) {
                    memberBoxArr = new MemberBox[i2];
                    memberBoxArr[0] = new MemberBox((Method) value);
                } else {
                    ObjArray objArray3 = (ObjArray) value;
                    int size = objArray3.size();
                    if (size < 2) {
                        Kit.codeBug();
                    }
                    MemberBox[] memberBoxArr2 = new MemberBox[size];
                    for (int i3 = 0; i3 != size; i3++) {
                        memberBoxArr2[i3] = new MemberBox((Method) objArray3.get(i3));
                    }
                    memberBoxArr = memberBoxArr2;
                }
                NativeJavaMethod nativeJavaMethod = new NativeJavaMethod(memberBoxArr);
                if (scriptable != null) {
                    ScriptRuntime.setFunctionProtoAndParent(nativeJavaMethod, scriptable);
                }
                map3.put(entry.getKey(), nativeJavaMethod);
                i2 = 1;
            }
            i++;
        }
        for (Field field : getAccessibleFields(z, z2)) {
            String name2 = field.getName();
            try {
                isStatic = Modifier.isStatic(field.getModifiers());
                map = isStatic ? this.staticMembers : this.members;
                obj2 = map.get(name2);
            } catch (SecurityException unused) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not access field ", name2, " of class ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4671cl.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" due to lack of privileges.");
                Context.reportWarning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            if (obj2 != null) {
                if (obj2 instanceof NativeJavaMethod) {
                    FieldAndMethods fieldAndMethods = new FieldAndMethods(scriptable, ((NativeJavaMethod) obj2).methods, field);
                    Map<String, FieldAndMethods> map4 = isStatic ? this.staticFieldAndMethods : this.fieldAndMethods;
                    if (map4 == null) {
                        map4 = new HashMap<>();
                        if (isStatic) {
                            this.staticFieldAndMethods = map4;
                        } else {
                            this.fieldAndMethods = map4;
                        }
                    }
                    map4.put(name2, fieldAndMethods);
                    map.put(name2, fieldAndMethods);
                } else if (!(obj2 instanceof Field)) {
                    Kit.codeBug();
                } else if (!((Field) obj2).getDeclaringClass().isAssignableFrom(field.getDeclaringClass())) {
                }
            }
            map.put(name2, field);
        }
        int i4 = 0;
        while (i4 != 2) {
            boolean z3 = i4 == 0;
            Map<String, Object> map5 = z3 ? this.staticMembers : this.members;
            HashMap hashMap = new HashMap();
            for (String str2 : map5.keySet()) {
                boolean startsWith = str2.startsWith("get");
                boolean startsWith2 = str2.startsWith("set");
                boolean startsWith3 = str2.startsWith(C1543ak.f2994ae);
                if (startsWith || startsWith3 || startsWith2) {
                    int i5 = 3;
                    String substring = str2.substring(i5);
                    if (substring.length() != 0) {
                        if (Character.isUpperCase(substring.charAt(0))) {
                            if (substring.length() == 1) {
                                str = substring.toLowerCase();
                            } else if (!Character.isUpperCase(substring.charAt(1))) {
                                str = Character.toLowerCase(charAt) + substring.substring(1);
                            }
                            if (!hashMap.containsKey(str) && ((obj = map5.get(str)) == null || (z2 && (obj instanceof Member) && Modifier.isPrivate(((Member) obj).getModifiers())))) {
                                findGetter = findGetter(z3, map5, "get", substring);
                                if (findGetter == null) {
                                    findGetter = findGetter(z3, map5, C1543ak.f2994ae, substring);
                                }
                                concat = "set".concat(substring);
                                MemberBox memberBox = null;
                                if (map5.containsKey(concat)) {
                                    Object obj4 = map5.get(concat);
                                    if (obj4 instanceof NativeJavaMethod) {
                                        ?? r52 = (NativeJavaMethod) obj4;
                                        MemberBox extractSetMethod = findGetter != null ? extractSetMethod(findGetter.method().getReturnType(), r52.methods, z3) : extractSetMethod(r52.methods, z3);
                                        if (r52.methods.length > 1) {
                                            memberBox = r52;
                                        }
                                        r5 = memberBox;
                                        memberBox = extractSetMethod;
                                        hashMap.put(str, new BeanProperty(findGetter, memberBox, r5));
                                    }
                                }
                                r5 = 0;
                                hashMap.put(str, new BeanProperty(findGetter, memberBox, r5));
                            }
                        }
                        str = substring;
                        if (!hashMap.containsKey(str)) {
                            findGetter = findGetter(z3, map5, "get", substring);
                            if (findGetter == null) {
                            }
                            concat = "set".concat(substring);
                            MemberBox memberBox2 = null;
                            if (map5.containsKey(concat)) {
                            }
                            r5 = 0;
                            hashMap.put(str, new BeanProperty(findGetter, memberBox2, r5));
                        }
                    }
                }
            }
            for (String str3 : hashMap.keySet()) {
                map5.put(str3, hashMap.get(str3));
            }
            i4++;
        }
        Constructor<?>[] accessibleConstructors = getAccessibleConstructors(z2);
        MemberBox[] memberBoxArr3 = new MemberBox[accessibleConstructors.length];
        for (int i6 = 0; i6 != accessibleConstructors.length; i6++) {
            memberBoxArr3[i6] = new MemberBox(accessibleConstructors[i6]);
        }
        this.ctors = new NativeJavaMethod(memberBoxArr3, this.f4671cl.getSimpleName());
    }

    public Object get(Scriptable scriptable, String str, Object obj, boolean z) {
        Object obj2;
        Class<?> type;
        Object obj3 = (z ? this.staticMembers : this.members).get(str);
        if (!z && obj3 == null) {
            obj3 = this.staticMembers.get(str);
        }
        if (obj3 == null && (obj3 = getExplicitFunction(scriptable, str, obj, z)) == null) {
            return Scriptable.NOT_FOUND;
        }
        if (obj3 instanceof Scriptable) {
            return obj3;
        }
        Context context = Context.getContext();
        try {
            if (obj3 instanceof BeanProperty) {
                BeanProperty beanProperty = (BeanProperty) obj3;
                if (beanProperty.getter == null) {
                    return Scriptable.NOT_FOUND;
                }
                obj2 = beanProperty.getter.invoke(obj, Context.emptyArgs);
                type = beanProperty.getter.method().getReturnType();
            } else {
                Field field = (Field) obj3;
                if (z) {
                    obj = null;
                }
                obj2 = field.get(obj);
                type = field.getType();
            }
            return context.getWrapFactory().wrap(context, ScriptableObject.getTopLevelScope(scriptable), obj2, type);
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    public Map<String, FieldAndMethods> getFieldAndMethodsObjects(Scriptable scriptable, Object obj, boolean z) {
        Map<String, FieldAndMethods> map = z ? this.staticFieldAndMethods : this.fieldAndMethods;
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap(map.size());
        for (FieldAndMethods fieldAndMethods : map.values()) {
            FieldAndMethods fieldAndMethods2 = new FieldAndMethods(scriptable, fieldAndMethods.methods, fieldAndMethods.field);
            fieldAndMethods2.javaObject = obj;
            hashMap.put(fieldAndMethods.field.getName(), fieldAndMethods2);
        }
        return hashMap;
    }

    public Object[] getIds(boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        return map.keySet().toArray(new Object[map.size()]);
    }

    public boolean has(String str, boolean z) {
        return ((z ? this.staticMembers : this.members).get(str) == null && findExplicitFunction(str, z) == null) ? false : true;
    }

    public void put(Scriptable scriptable, String str, Object obj, Object obj2, boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        Object obj3 = map.get(str);
        if (!z && obj3 == null) {
            obj3 = this.staticMembers.get(str);
        }
        if (obj3 != null) {
            if (obj3 instanceof FieldAndMethods) {
                obj3 = ((FieldAndMethods) map.get(str)).field;
            }
            if (!(obj3 instanceof BeanProperty)) {
                if (!(obj3 instanceof Field)) {
                    throw Context.reportRuntimeError1(obj3 == null ? "msg.java.internal.private" : "msg.java.method.assign", str);
                }
                Field field = (Field) obj3;
                try {
                    field.set(obj, Context.jsToJava(obj2, field.getType()));
                    return;
                } catch (IllegalAccessException e) {
                    if ((field.getModifiers() & 16) == 0) {
                        throw Context.throwAsScriptRuntimeEx(e);
                    }
                    return;
                } catch (IllegalArgumentException unused) {
                    throw Context.reportRuntimeError3("msg.java.internal.field.type", obj2.getClass().getName(), field, obj.getClass().getName());
                }
            }
            BeanProperty beanProperty = (BeanProperty) obj3;
            if (beanProperty.setter == null) {
                throw reportMemberNotFound(str);
            }
            NativeJavaMethod nativeJavaMethod = beanProperty.setters;
            if (nativeJavaMethod != null && obj2 != null) {
                nativeJavaMethod.call(Context.getContext(), ScriptableObject.getTopLevelScope(scriptable), scriptable, new Object[]{obj2});
                return;
            }
            try {
                beanProperty.setter.invoke(obj, new Object[]{Context.jsToJava(obj2, beanProperty.setter.argTypes[0])});
                return;
            } catch (Exception e2) {
                throw Context.throwAsScriptRuntimeEx(e2);
            }
        }
        throw reportMemberNotFound(str);
    }

    public RuntimeException reportMemberNotFound(String str) {
        return Context.reportRuntimeError2("msg.java.member.not.found", this.f4671cl.getName(), str);
    }
}
