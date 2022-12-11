package org.mozilla.javascript;

import com.p046uc.crashsdk.export.LogType;

/* loaded from: classes5.dex */
public class NativeJavaTopPackage extends NativeJavaPackage implements Function, IdFunctionCall {
    public static final int Id_getClass = 1;
    public static final long serialVersionUID = -1455787259477709999L;
    public static final String[][] commonPackages = {new String[]{LogType.JAVA_TYPE, "lang", "reflect"}, new String[]{LogType.JAVA_TYPE, "io"}, new String[]{LogType.JAVA_TYPE, "math"}, new String[]{LogType.JAVA_TYPE, "net"}, new String[]{LogType.JAVA_TYPE, "util", "zip"}, new String[]{LogType.JAVA_TYPE, "text", "resources"}, new String[]{LogType.JAVA_TYPE, "applet"}, new String[]{"javax", "swing"}};
    public static final Object FTAG = "JavaTopPackage";

    public NativeJavaTopPackage(ClassLoader classLoader) {
        super(true, "", classLoader);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeJavaTopPackage nativeJavaTopPackage = new NativeJavaTopPackage(context.getApplicationClassLoader());
        nativeJavaTopPackage.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeJavaTopPackage.setParentScope(scriptable);
        for (int i = 0; i != commonPackages.length; i++) {
            NativeJavaPackage nativeJavaPackage = nativeJavaTopPackage;
            int i2 = 0;
            while (true) {
                String[][] strArr = commonPackages;
                if (i2 != strArr[i].length) {
                    nativeJavaPackage = nativeJavaPackage.forcePackage(strArr[i][i2], scriptable);
                    i2++;
                }
            }
        }
        IdFunctionObject idFunctionObject = new IdFunctionObject(nativeJavaTopPackage, FTAG, 1, "getClass", 1, scriptable);
        String[] topPackageNames = ScriptRuntime.getTopPackageNames();
        Object[] objArr = new NativeJavaPackage[topPackageNames.length];
        for (int i3 = 0; i3 < topPackageNames.length; i3++) {
            objArr[i3] = (NativeJavaPackage) nativeJavaTopPackage.get(topPackageNames[i3], nativeJavaTopPackage);
        }
        ScriptableObject scriptableObject = (ScriptableObject) scriptable;
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
        scriptableObject.defineProperty("Packages", nativeJavaTopPackage, 2);
        for (int i4 = 0; i4 < topPackageNames.length; i4++) {
            scriptableObject.defineProperty(topPackageNames[i4], objArr[i4], 2);
        }
    }

    private Scriptable js_getClass(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length > 0) {
            int i = 0;
            if (objArr[0] instanceof Wrapper) {
                String name = ((Wrapper) objArr[0]).unwrap().getClass().getName();
                Scriptable scriptable2 = this;
                while (true) {
                    int indexOf = name.indexOf(46, i);
                    Object obj = scriptable2.get(indexOf == -1 ? name.substring(i) : name.substring(i, indexOf), scriptable2);
                    if (!(obj instanceof Scriptable)) {
                        break;
                    }
                    scriptable2 = (Scriptable) obj;
                    if (indexOf == -1) {
                        return scriptable2;
                    }
                    i = indexOf + 1;
                }
            }
        }
        throw Context.reportRuntimeError0("msg.not.java.obj");
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    @Override // org.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        ClassLoader classLoader;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                obj = ((Wrapper) obj).unwrap();
            }
            if (obj instanceof ClassLoader) {
                classLoader = (ClassLoader) obj;
                if (classLoader != null) {
                    Context.reportRuntimeError0("msg.not.classloader");
                    return null;
                }
                NativeJavaPackage nativeJavaPackage = new NativeJavaPackage(true, "", classLoader);
                ScriptRuntime.setObjectProtoAndParent(nativeJavaPackage, scriptable);
                return nativeJavaPackage;
            }
        }
        classLoader = null;
        if (classLoader != null) {
        }
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(FTAG) || idFunctionObject.methodId() != 1) {
            throw idFunctionObject.unknown();
        }
        return js_getClass(context, scriptable, objArr);
    }
}
