package org.mozilla.javascript.typedarrays;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeArrayBuffer extends IdScriptableObject {
    public static final String CLASS_NAME = "ArrayBuffer";
    public static final int ConstructorId_isView = -1;
    public static final byte[] EMPTY_BUF = new byte[0];
    public static final NativeArrayBuffer EMPTY_BUFFER = new NativeArrayBuffer();
    public static final int Id_byteLength = 1;
    public static final int Id_constructor = 1;
    public static final int Id_slice = 2;
    public static final int MAX_INSTANCE_ID = 1;
    public static final int MAX_PROTOTYPE_ID = 2;
    public static final long serialVersionUID = 3110411773054879549L;
    public final byte[] buffer;

    public NativeArrayBuffer() {
        this.buffer = EMPTY_BUF;
    }

    public NativeArrayBuffer(double d) {
        if (d >= 2.147483647E9d) {
            throw ScriptRuntime.constructError("RangeError", "length parameter (" + d + ") is too large ");
        } else if (d == Double.NEGATIVE_INFINITY) {
            throw ScriptRuntime.constructError("RangeError", "Negative array length " + d);
        } else {
            int int32 = ScriptRuntime.toInt32(d);
            if (int32 < 0) {
                throw ScriptRuntime.constructError("RangeError", "Negative array length " + d);
            } else if (int32 == 0) {
                this.buffer = EMPTY_BUF;
            } else {
                this.buffer = new byte[int32];
            }
        }
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeArrayBuffer().exportAsJSClass(2, scriptable, z);
    }

    public static boolean isArg(Object[] objArr, int i) {
        return objArr.length > i && !Undefined.instance.equals(objArr[i]);
    }

    public static NativeArrayBuffer realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeArrayBuffer) {
            return (NativeArrayBuffer) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CLASS_NAME)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        boolean z = true;
        if (methodId == -1) {
            if (!isArg(objArr, 0) || !(objArr[0] instanceof NativeArrayBufferView)) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        double d = RoundRectDrawableWithShadow.COS_45;
        if (methodId == 1) {
            if (isArg(objArr, 0)) {
                d = ScriptRuntime.toNumber(objArr[0]);
            }
            return new NativeArrayBuffer(d);
        } else if (methodId != 2) {
            throw new IllegalArgumentException(String.valueOf(methodId));
        } else {
            NativeArrayBuffer realThis = realThis(scriptable2, idFunctionObject);
            if (isArg(objArr, 0)) {
                d = ScriptRuntime.toNumber(objArr[0]);
            }
            return realThis.slice(d, isArg(objArr, 1) ? ScriptRuntime.toNumber(objArr[1]) : realThis.buffer.length);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, CLASS_NAME, -1, "isView", 1);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        return "byteLength".equals(str) ? IdScriptableObject.instanceIdInfo(5, 1) : super.findInstanceIdInfo(str);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 5) {
            i = 2;
            str2 = "slice";
        } else if (length == 11) {
            i = 1;
            str2 = "constructor";
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i == 1 ? "byteLength" : super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapInt(this.buffer.length) : super.getInstanceIdValue(i);
    }

    public int getLength() {
        return this.buffer.length;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        if (i == 1) {
            str = "constructor";
        } else if (i != 2) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            str = "slice";
        }
        initPrototypeMethod(CLASS_NAME, i, str, 1);
    }

    public NativeArrayBuffer slice(double d, double d2) {
        byte[] bArr;
        double length = this.buffer.length;
        if (d2 < RoundRectDrawableWithShadow.COS_45) {
            d2 += bArr.length;
        }
        int int32 = ScriptRuntime.toInt32(Math.max((double) RoundRectDrawableWithShadow.COS_45, Math.min(length, d2)));
        double d3 = int32;
        if (d < RoundRectDrawableWithShadow.COS_45) {
            d += this.buffer.length;
        }
        int int322 = ScriptRuntime.toInt32(Math.min(d3, Math.max((double) RoundRectDrawableWithShadow.COS_45, d)));
        int i = int32 - int322;
        NativeArrayBuffer nativeArrayBuffer = new NativeArrayBuffer(i);
        System.arraycopy(this.buffer, int322, nativeArrayBuffer.buffer, 0, i);
        return nativeArrayBuffer;
    }
}
