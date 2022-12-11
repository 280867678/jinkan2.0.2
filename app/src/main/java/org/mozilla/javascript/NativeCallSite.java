package org.mozilla.javascript;

import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class NativeCallSite extends IdScriptableObject {
    public static final String CALLSITE_TAG = "CallSite";
    public static final int Id_constructor = 1;
    public static final int Id_getColumnNumber = 9;
    public static final int Id_getEvalOrigin = 10;
    public static final int Id_getFileName = 7;
    public static final int Id_getFunction = 4;
    public static final int Id_getFunctionName = 5;
    public static final int Id_getLineNumber = 8;
    public static final int Id_getMethodName = 6;
    public static final int Id_getThis = 2;
    public static final int Id_getTypeName = 3;
    public static final int Id_isConstructor = 14;
    public static final int Id_isEval = 12;
    public static final int Id_isNative = 13;
    public static final int Id_isToplevel = 11;
    public static final int Id_toString = 15;
    public static final int MAX_PROTOTYPE_ID = 15;
    public ScriptStackElement element;

    public static Object getFileName(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        if (scriptStackElement != null) {
            return scriptStackElement.fileName;
        }
        return null;
    }

    public static Object getFunctionName(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        if (scriptStackElement != null) {
            return scriptStackElement.functionName;
        }
        return null;
    }

    public static Object getLineNumber(Scriptable scriptable) {
        int i;
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        return (scriptStackElement == null || (i = scriptStackElement.lineNumber) < 0) ? Undefined.instance : Integer.valueOf(i);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeCallSite().exportAsJSClass(15, scriptable, z);
    }

    public static Object js_toString(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        StringBuilder sb = new StringBuilder();
        ((NativeCallSite) scriptable).element.renderJavaStyle(sb);
        return sb.toString();
    }

    public static NativeCallSite make(Scriptable scriptable, Scriptable scriptable2) {
        NativeCallSite nativeCallSite = new NativeCallSite();
        nativeCallSite.setParentScope(scriptable);
        nativeCallSite.setPrototype((Scriptable) scriptable2.get("prototype", scriptable2));
        return nativeCallSite;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CALLSITE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        switch (methodId) {
            case 1:
                return make(scriptable, idFunctionObject);
            case 2:
            case 3:
            case 4:
            case 9:
                return Undefined.instance;
            case 5:
                return getFunctionName(scriptable2);
            case 6:
                return null;
            case 7:
                return getFileName(scriptable2);
            case 8:
                return getLineNumber(scriptable2);
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return Boolean.FALSE;
            case 15:
                return js_toString(scriptable2);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i = 4;
        switch (str.length()) {
            case 6:
                i = 12;
                str2 = "isEval";
                break;
            case 7:
                i = 2;
                str2 = "getThis";
                break;
            case 8:
                char charAt = str.charAt(0);
                if (charAt != 'i') {
                    if (charAt == 't') {
                        i = 15;
                        str2 = AnnotationHandler.STRING;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 13;
                    str2 = "isNative";
                    break;
                }
            case 9:
            case 12:
            case 14:
            default:
                str2 = null;
                i = 0;
                break;
            case 10:
                i = 11;
                str2 = "isToplevel";
                break;
            case 11:
                char charAt2 = str.charAt(4);
                if (charAt2 == 'i') {
                    i = 7;
                    str2 = "getFileName";
                    break;
                } else if (charAt2 == 'y') {
                    str2 = "getTypeName";
                    i = 3;
                    break;
                } else if (charAt2 == 't') {
                    i = 1;
                    str2 = "constructor";
                    break;
                } else {
                    if (charAt2 == 'u') {
                        str2 = "getFunction";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 13:
                char charAt3 = str.charAt(3);
                if (charAt3 == 'E') {
                    i = 10;
                    str2 = "getEvalOrigin";
                    break;
                } else if (charAt3 == 'o') {
                    i = 14;
                    str2 = "isConstructor";
                    break;
                } else if (charAt3 == 'L') {
                    i = 8;
                    str2 = "getLineNumber";
                    break;
                } else {
                    if (charAt3 == 'M') {
                        i = 6;
                        str2 = "getMethodName";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 15:
                char charAt4 = str.charAt(3);
                if (charAt4 != 'C') {
                    if (charAt4 == 'F') {
                        i = 5;
                        str2 = "getFunctionName";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 9;
                    str2 = "getColumnNumber";
                    break;
                }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CALLSITE_TAG;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "getThis";
                break;
            case 3:
                str = "getTypeName";
                break;
            case 4:
                str = "getFunction";
                break;
            case 5:
                str = "getFunctionName";
                break;
            case 6:
                str = "getMethodName";
                break;
            case 7:
                str = "getFileName";
                break;
            case 8:
                str = "getLineNumber";
                break;
            case 9:
                str = "getColumnNumber";
                break;
            case 10:
                str = "getEvalOrigin";
                break;
            case 11:
                str = "isToplevel";
                break;
            case 12:
                str = "isEval";
                break;
            case 13:
                str = "isNative";
                break;
            case 14:
                str = "isConstructor";
                break;
            case 15:
                str = AnnotationHandler.STRING;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(CALLSITE_TAG, i, str, 0);
    }

    public void setElement(ScriptStackElement scriptStackElement) {
        this.element = scriptStackElement;
    }

    public String toString() {
        ScriptStackElement scriptStackElement = this.element;
        return scriptStackElement == null ? "" : scriptStackElement.toString();
    }
}
