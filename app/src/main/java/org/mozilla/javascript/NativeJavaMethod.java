package org.mozilla.javascript;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.tools.idswitch.Main;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public class NativeJavaMethod extends BaseFunction {
    public static final int PREFERENCE_AMBIGUOUS = 3;
    public static final int PREFERENCE_EQUAL = 0;
    public static final int PREFERENCE_FIRST_ARG = 1;
    public static final int PREFERENCE_SECOND_ARG = 2;
    public static final boolean debug = false;
    public static final long serialVersionUID = -3440381785576412928L;
    public String functionName;
    public MemberBox[] methods;
    public transient CopyOnWriteArrayList<ResolvedOverload> overloadCache;

    public NativeJavaMethod(Method method, String str) {
        this(new MemberBox(method), str);
    }

    public NativeJavaMethod(MemberBox memberBox, String str) {
        this.functionName = str;
        this.methods = new MemberBox[]{memberBox};
    }

    public NativeJavaMethod(MemberBox[] memberBoxArr) {
        this.functionName = memberBoxArr[0].getName();
        this.methods = memberBoxArr;
    }

    public NativeJavaMethod(MemberBox[] memberBoxArr, String str) {
        this.functionName = str;
        this.methods = memberBoxArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x008c, code lost:
        if (r14.isPublic() == false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int findFunction(Context context, MemberBox[] memberBoxArr, Object[] objArr) {
        int i = -1;
        if (memberBoxArr.length == 0) {
            return -1;
        }
        if (memberBoxArr.length == 1) {
            MemberBox memberBox = memberBoxArr[0];
            Class<?>[] clsArr = memberBox.argTypes;
            int length = clsArr.length;
            if (memberBox.vararg) {
                length--;
                if (length > objArr.length) {
                    return -1;
                }
            } else if (length != objArr.length) {
                return -1;
            }
            for (int i2 = 0; i2 != length; i2++) {
                if (!NativeJavaObject.canConvert(objArr[i2], clsArr[i2])) {
                    return -1;
                }
            }
            return 0;
        }
        int[] iArr = null;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i3 < memberBoxArr.length) {
            MemberBox memberBox2 = memberBoxArr[i3];
            Class<?>[] clsArr2 = memberBox2.argTypes;
            int length2 = clsArr2.length;
            if (!memberBox2.vararg ? length2 == objArr.length : length2 - 1 <= objArr.length) {
                for (int i6 = 0; i6 < length2; i6++) {
                    if (NativeJavaObject.canConvert(objArr[i6], clsArr2[i6])) {
                    }
                }
                if (i4 >= 0) {
                    int i7 = -1;
                    int i8 = 0;
                    int i9 = 0;
                    while (i7 != i5) {
                        MemberBox memberBox3 = memberBoxArr[i7 == i ? i4 : iArr[i7]];
                        if (!context.hasFeature(13) || memberBox3.isPublic() == memberBox2.isPublic()) {
                            int preferSignature = preferSignature(objArr, clsArr2, memberBox2.vararg, memberBox3.argTypes, memberBox3.vararg);
                            if (preferSignature == 3) {
                                break;
                            }
                            if (preferSignature != 1) {
                                if (preferSignature != 2) {
                                    if (preferSignature != 0) {
                                        Kit.codeBug();
                                    }
                                    if (memberBox3.isStatic() && memberBox3.getDeclaringClass().isAssignableFrom(memberBox2.getDeclaringClass())) {
                                        if (i7 != -1) {
                                            iArr[i7] = i3;
                                        }
                                    }
                                    i3++;
                                    i = -1;
                                }
                                i9++;
                            }
                            i8++;
                        }
                        i7++;
                        i = -1;
                    }
                    int i10 = i5 + 1;
                    if (i8 == i10) {
                        i4 = i3;
                        i5 = 0;
                    } else if (i9 != i10) {
                        if (iArr == null) {
                            iArr = new int[memberBoxArr.length - 1];
                        }
                        iArr[i5] = i3;
                        i5 = i10;
                    }
                    i3++;
                    i = -1;
                }
                i4 = i3;
                i3++;
                i = -1;
            }
            i3++;
            i = -1;
        }
        if (i4 < 0) {
            return -1;
        }
        if (i5 == 0) {
            return i4;
        }
        StringBuilder sb = new StringBuilder();
        int i11 = -1;
        while (i11 != i5) {
            int i12 = i11 == -1 ? i4 : iArr[i11];
            sb.append("\n    ");
            sb.append(memberBoxArr[i12].toJavaDeclaration());
            i11++;
        }
        MemberBox memberBox4 = memberBoxArr[i4];
        String name = memberBox4.getName();
        String name2 = memberBox4.getDeclaringClass().getName();
        if (!memberBoxArr[0].isCtor()) {
            throw Context.reportRuntimeError4("msg.method.ambiguous", name2, name, scriptSignature(objArr), sb.toString());
        }
        throw Context.reportRuntimeError3("msg.constructor.ambiguous", name, scriptSignature(objArr), sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
        if (r4.isAssignableFrom(r3) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int preferSignature(Object[] objArr, Class<?>[] clsArr, boolean z, Class<?>[] clsArr2, boolean z2) {
        int i = 0;
        int i2 = 0;
        while (i < objArr.length) {
            int i3 = 1;
            Class<?> cls = (!z || i < clsArr.length) ? clsArr[i] : clsArr[clsArr.length - 1];
            Class<?> cls2 = (!z2 || i < clsArr2.length) ? clsArr2[i] : clsArr2[clsArr2.length - 1];
            if (cls != cls2) {
                Object obj = objArr[i];
                int conversionWeight = NativeJavaObject.getConversionWeight(obj, cls);
                int conversionWeight2 = NativeJavaObject.getConversionWeight(obj, cls2);
                if (conversionWeight >= conversionWeight2) {
                    if (conversionWeight <= conversionWeight2) {
                        if (conversionWeight == 0) {
                            if (!cls.isAssignableFrom(cls2)) {
                            }
                        }
                        i3 = 3;
                    }
                    i3 = 2;
                }
                i2 |= i3;
                if (i2 == 3) {
                    break;
                }
            }
            i++;
        }
        return i2;
    }

    public static void printDebug(String str, MemberBox memberBox, Object[] objArr) {
    }

    public static String scriptSignature(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            String name = obj == null ? "null" : obj instanceof Boolean ? ClassTransform.BOOLEAN : obj instanceof String ? Main.STRING_TAG_STR : obj instanceof Number ? "number" : obj instanceof Scriptable ? obj instanceof Undefined ? "undefined" : obj instanceof Wrapper ? ((Wrapper) obj).unwrap().getClass().getName() : obj instanceof Function ? "function" : "object" : JavaMembers.javaSignature(obj.getClass());
            if (i != 0) {
                sb.append(',');
            }
            sb.append(name);
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] objArr2;
        Object obj;
        Object obj2;
        if (this.methods.length != 0) {
            int findCachedFunction = findCachedFunction(context, objArr);
            int i = 0;
            if (findCachedFunction < 0) {
                Class<?> declaringClass = this.methods[0].method().getDeclaringClass();
                throw Context.reportRuntimeError1("msg.java.no_such_method", declaringClass.getName() + '.' + getFunctionName() + '(' + scriptSignature(objArr) + ')');
            }
            MemberBox memberBox = this.methods[findCachedFunction];
            Class<?>[] clsArr = memberBox.argTypes;
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
                    obj2 = newInstance;
                } else {
                    obj2 = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
                }
                objArr2[clsArr.length - 1] = obj2;
            } else {
                objArr2 = objArr;
                while (i < objArr2.length) {
                    Object obj3 = objArr2[i];
                    Object jsToJava = Context.jsToJava(obj3, clsArr[i]);
                    if (jsToJava != obj3) {
                        if (objArr == objArr2) {
                            objArr2 = (Object[]) objArr2.clone();
                        }
                        objArr2[i] = jsToJava;
                    }
                    i++;
                }
            }
            if (!memberBox.isStatic()) {
                Class<?> declaringClass2 = memberBox.getDeclaringClass();
                for (Scriptable scriptable3 = scriptable2; scriptable3 != null; scriptable3 = scriptable3.getPrototype()) {
                    if (scriptable3 instanceof Wrapper) {
                        Object unwrap = ((Wrapper) scriptable3).unwrap();
                        if (declaringClass2.isInstance(unwrap)) {
                            obj = unwrap;
                        }
                    }
                }
                throw Context.reportRuntimeError3("msg.nonjava.method", getFunctionName(), ScriptRuntime.toString(scriptable2), declaringClass2.getName());
            }
            obj = null;
            Object invoke = memberBox.invoke(obj, objArr2);
            Class<?> returnType = memberBox.method().getReturnType();
            Object wrap = context.getWrapFactory().wrap(context, scriptable, invoke, returnType);
            return (wrap == null && returnType == Void.TYPE) ? Undefined.instance : wrap;
        }
        throw new RuntimeException("No methods defined for call");
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String decompile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        if ((i2 & 1) == 0) {
            z = false;
        }
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() {");
        }
        sb.append("/*\n");
        sb.append(toString());
        sb.append(z ? "*/\n" : "*/}\n");
        return sb.toString();
    }

    public int findCachedFunction(Context context, Object[] objArr) {
        MemberBox[] memberBoxArr = this.methods;
        if (memberBoxArr.length > 1) {
            CopyOnWriteArrayList<ResolvedOverload> copyOnWriteArrayList = this.overloadCache;
            if (copyOnWriteArrayList != null) {
                Iterator<ResolvedOverload> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ResolvedOverload next = it.next();
                    if (next.matches(objArr)) {
                        return next.index;
                    }
                }
            } else {
                this.overloadCache = new CopyOnWriteArrayList<>();
            }
            int findFunction = findFunction(context, this.methods, objArr);
            if (this.overloadCache.size() < this.methods.length * 2) {
                synchronized (this.overloadCache) {
                    ResolvedOverload resolvedOverload = new ResolvedOverload(objArr, findFunction);
                    if (!this.overloadCache.contains(resolvedOverload)) {
                        this.overloadCache.add(0, resolvedOverload);
                    }
                }
            }
            return findFunction;
        }
        return findFunction(context, memberBoxArr, objArr);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return this.functionName;
    }

    public String toString() {
        String name;
        StringBuilder sb = new StringBuilder();
        int length = this.methods.length;
        for (int i = 0; i != length; i++) {
            if (this.methods[i].isMethod()) {
                Method method = this.methods[i].method();
                sb.append(JavaMembers.javaSignature(method.getReturnType()));
                sb.append(TokenParser.f4579SP);
                name = method.getName();
            } else {
                name = this.methods[i].getName();
            }
            sb.append(name);
            sb.append(JavaMembers.liveConnectSignature(this.methods[i].argTypes));
            sb.append('\n');
        }
        return sb.toString();
    }
}
