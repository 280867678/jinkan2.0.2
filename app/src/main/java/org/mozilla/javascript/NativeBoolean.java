package org.mozilla.javascript;

import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public final class NativeBoolean extends IdScriptableObject {
    public static final Object BOOLEAN_TAG = "Boolean";
    public static final int Id_constructor = 1;
    public static final int Id_toSource = 3;
    public static final int Id_toString = 2;
    public static final int Id_valueOf = 4;
    public static final int MAX_PROTOTYPE_ID = 4;
    public static final long serialVersionUID = -3716996899943880933L;
    public boolean booleanValue;

    public NativeBoolean(boolean z) {
        this.booleanValue = z;
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeBoolean(false).exportAsJSClass(4, scriptable, z);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(BOOLEAN_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        boolean z = true;
        if (methodId == 1) {
            boolean z2 = false;
            if (objArr.length != 0) {
                if (!(objArr[0] instanceof ScriptableObject) || !((ScriptableObject) objArr[0]).avoidObjectDetection()) {
                    z = ScriptRuntime.toBoolean(objArr[0]);
                }
                z2 = z;
            }
            return scriptable2 == null ? new NativeBoolean(z2) : ScriptRuntime.wrapBoolean(z2);
        } else if (!(scriptable2 instanceof NativeBoolean)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        } else {
            boolean z3 = ((NativeBoolean) scriptable2).booleanValue;
            if (methodId == 2) {
                return z3 ? "true" : "false";
            } else if (methodId == 3) {
                return z3 ? "(new Boolean(true))" : "(new Boolean(false))";
            } else if (methodId != 4) {
                throw new IllegalArgumentException(String.valueOf(methodId));
            } else {
                return ScriptRuntime.wrapBoolean(z3);
            }
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 7) {
            i = 4;
            str2 = "valueOf";
        } else if (length == 8) {
            char charAt = str.charAt(3);
            if (charAt == 'o') {
                str2 = "toSource";
            } else {
                if (charAt == 't') {
                    i = 2;
                    str2 = AnnotationHandler.STRING;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                i = 1;
                str2 = "constructor";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Boolean";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return cls == ScriptRuntime.BooleanClass ? ScriptRuntime.wrapBoolean(this.booleanValue) : super.getDefaultValue(cls);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2 = 0;
        if (i == 1) {
            str = "constructor";
            i2 = 1;
        } else if (i == 2) {
            str = AnnotationHandler.STRING;
        } else if (i == 3) {
            str = "toSource";
        } else if (i != 4) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            str = "valueOf";
        }
        initPrototypeMethod(BOOLEAN_TAG, i, str, i2);
    }
}
