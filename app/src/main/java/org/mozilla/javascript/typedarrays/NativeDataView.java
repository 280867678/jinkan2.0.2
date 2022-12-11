package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeDataView extends NativeArrayBufferView {
    public static final String CLASS_NAME = "DataView";
    public static final int Id_constructor = 1;
    public static final int Id_getFloat32 = 8;
    public static final int Id_getFloat64 = 9;
    public static final int Id_getInt16 = 4;
    public static final int Id_getInt32 = 6;
    public static final int Id_getInt8 = 2;
    public static final int Id_getUint16 = 5;
    public static final int Id_getUint32 = 7;
    public static final int Id_getUint8 = 3;
    public static final int Id_setFloat32 = 16;
    public static final int Id_setFloat64 = 17;
    public static final int Id_setInt16 = 12;
    public static final int Id_setInt32 = 14;
    public static final int Id_setInt8 = 10;
    public static final int Id_setUint16 = 13;
    public static final int Id_setUint32 = 15;
    public static final int Id_setUint8 = 11;
    public static final int MAX_PROTOTYPE_ID = 17;
    public static final long serialVersionUID = 1427967607557438968L;

    public NativeDataView() {
    }

    public NativeDataView(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2);
    }

    private int determinePos(Object[] objArr) {
        if (NativeArrayBufferView.isArg(objArr, 0)) {
            double number = ScriptRuntime.toNumber(objArr[0]);
            if (Double.isInfinite(number)) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            return ScriptRuntime.toInt32(number);
        }
        return 0;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeDataView().exportAsJSClass(17, scriptable, z);
    }

    private NativeDataView js_constructor(Object[] objArr) {
        int length;
        int i = 0;
        if (!NativeArrayBufferView.isArg(objArr, 0) || !(objArr[0] instanceof NativeArrayBuffer)) {
            throw ScriptRuntime.constructError("TypeError", "Missing parameters");
        }
        NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) objArr[0];
        if (NativeArrayBufferView.isArg(objArr, 1)) {
            double number = ScriptRuntime.toNumber(objArr[1]);
            if (Double.isInfinite(number)) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            i = ScriptRuntime.toInt32(number);
        }
        if (NativeArrayBufferView.isArg(objArr, 2)) {
            double number2 = ScriptRuntime.toNumber(objArr[2]);
            if (Double.isInfinite(number2)) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            length = ScriptRuntime.toInt32(number2);
        } else {
            length = nativeArrayBuffer.getLength() - i;
        }
        if (length < 0) {
            throw ScriptRuntime.constructError("RangeError", "length out of range");
        }
        if (i >= 0 && i + length <= nativeArrayBuffer.getLength()) {
            return new NativeDataView(nativeArrayBuffer, i, length);
        }
        throw ScriptRuntime.constructError("RangeError", "offset out of range");
    }

    private Object js_getFloat(int i, Object[] objArr) {
        int determinePos = determinePos(objArr);
        rangeCheck(determinePos, i);
        boolean z = true;
        if (!NativeArrayBufferView.isArg(objArr, 1) || i <= 1 || !ScriptRuntime.toBoolean(objArr[1])) {
            z = false;
        }
        if (i != 4) {
            if (i != 8) {
                throw new AssertionError();
            }
            return ByteIo.readFloat64(this.arrayBuffer.buffer, this.offset + determinePos, z);
        }
        return ByteIo.readFloat32(this.arrayBuffer.buffer, this.offset + determinePos, z);
    }

    private Object js_getInt(int i, boolean z, Object[] objArr) {
        int determinePos = determinePos(objArr);
        rangeCheck(determinePos, i);
        boolean z2 = NativeArrayBufferView.isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1]);
        if (i == 1) {
            byte[] bArr = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt8(bArr, this.offset + determinePos) : ByteIo.readUint8(bArr, this.offset + determinePos);
        } else if (i == 2) {
            byte[] bArr2 = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt16(bArr2, this.offset + determinePos, z2) : ByteIo.readUint16(bArr2, this.offset + determinePos, z2);
        } else if (i != 4) {
            throw new AssertionError();
        } else {
            byte[] bArr3 = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt32(bArr3, this.offset + determinePos, z2) : ByteIo.readUint32(bArr3, this.offset + determinePos, z2);
        }
    }

    private void js_setFloat(int i, Object[] objArr) {
        int determinePos = determinePos(objArr);
        if (determinePos >= 0) {
            boolean z = NativeArrayBufferView.isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2]);
            double d = Double.NaN;
            if (objArr.length > 1) {
                d = ScriptRuntime.toNumber(objArr[1]);
            }
            if (determinePos + i > this.byteLength) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            if (i == 4) {
                ByteIo.writeFloat32(this.arrayBuffer.buffer, this.offset + determinePos, d, z);
                return;
            } else if (i != 8) {
                throw new AssertionError();
            } else {
                ByteIo.writeFloat64(this.arrayBuffer.buffer, this.offset + determinePos, d, z);
                return;
            }
        }
        throw ScriptRuntime.constructError("RangeError", "offset out of range");
    }

    private void js_setInt(int i, boolean z, Object[] objArr) {
        int determinePos = determinePos(objArr);
        if (determinePos >= 0) {
            boolean z2 = NativeArrayBufferView.isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2]);
            int i2 = 0;
            if (objArr.length > 1) {
                i2 = objArr[1];
            }
            if (i == 1) {
                if (z) {
                    int int8 = Conversions.toInt8(i2);
                    if (i + determinePos > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeInt8(this.arrayBuffer.buffer, this.offset + determinePos, int8);
                    return;
                }
                int uint8 = Conversions.toUint8(i2);
                if (i + determinePos > this.byteLength) {
                    throw ScriptRuntime.constructError("RangeError", "offset out of range");
                }
                ByteIo.writeUint8(this.arrayBuffer.buffer, this.offset + determinePos, uint8);
                return;
            } else if (i == 2) {
                if (z) {
                    int int16 = Conversions.toInt16(i2);
                    if (i + determinePos > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeInt16(this.arrayBuffer.buffer, this.offset + determinePos, int16, z2);
                    return;
                }
                int uint16 = Conversions.toUint16(i2);
                if (i + determinePos > this.byteLength) {
                    throw ScriptRuntime.constructError("RangeError", "offset out of range");
                }
                ByteIo.writeUint16(this.arrayBuffer.buffer, this.offset + determinePos, uint16, z2);
                return;
            } else if (i != 4) {
                throw new AssertionError();
            } else {
                if (z) {
                    int int32 = Conversions.toInt32(i2);
                    if (i + determinePos > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeInt32(this.arrayBuffer.buffer, this.offset + determinePos, int32, z2);
                    return;
                }
                long uint32 = Conversions.toUint32(i2);
                if (i + determinePos > this.byteLength) {
                    throw ScriptRuntime.constructError("RangeError", "offset out of range");
                }
                ByteIo.writeUint32(this.arrayBuffer.buffer, this.offset + determinePos, uint32, z2);
                return;
            }
        }
        throw ScriptRuntime.constructError("RangeError", "offset out of range");
    }

    private void rangeCheck(int i, int i2) {
        if (i < 0 || i + i2 > this.byteLength) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
    }

    public static NativeDataView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeDataView) {
            return (NativeDataView) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        switch (methodId) {
            case 1:
                return js_constructor(objArr);
            case 2:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, true, objArr);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, false, objArr);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, true, objArr);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, false, objArr);
            case 6:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, true, objArr);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, false, objArr);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_getFloat(4, objArr);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getFloat(8, objArr);
            case 10:
                realThis(scriptable2, idFunctionObject).js_setInt(1, true, objArr);
                return Undefined.instance;
            case 11:
                realThis(scriptable2, idFunctionObject).js_setInt(1, false, objArr);
                return Undefined.instance;
            case 12:
                realThis(scriptable2, idFunctionObject).js_setInt(2, true, objArr);
                return Undefined.instance;
            case 13:
                realThis(scriptable2, idFunctionObject).js_setInt(2, false, objArr);
                return Undefined.instance;
            case 14:
                realThis(scriptable2, idFunctionObject).js_setInt(4, true, objArr);
                return Undefined.instance;
            case 15:
                realThis(scriptable2, idFunctionObject).js_setInt(4, false, objArr);
                return Undefined.instance;
            case 16:
                realThis(scriptable2, idFunctionObject).js_setFloat(4, objArr);
                return Undefined.instance;
            case 17:
                realThis(scriptable2, idFunctionObject).js_setFloat(8, objArr);
                return Undefined.instance;
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i = 6;
        switch (str.length()) {
            case 7:
                char charAt = str.charAt(0);
                if (charAt != 'g') {
                    if (charAt == 's') {
                        i = 10;
                        str2 = "setInt8";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 2;
                    str2 = "getInt8";
                    break;
                }
            case 8:
                char charAt2 = str.charAt(6);
                if (charAt2 == '1') {
                    char charAt3 = str.charAt(0);
                    if (charAt3 != 'g') {
                        if (charAt3 == 's') {
                            i = 12;
                            str2 = "setInt16";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 4;
                        str2 = "getInt16";
                        break;
                    }
                } else if (charAt2 == '3') {
                    char charAt4 = str.charAt(0);
                    if (charAt4 == 'g') {
                        str2 = "getInt32";
                        break;
                    } else {
                        if (charAt4 == 's') {
                            i = 14;
                            str2 = "setInt32";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else {
                    if (charAt2 == 't') {
                        char charAt5 = str.charAt(0);
                        if (charAt5 != 'g') {
                            if (charAt5 == 's') {
                                i = 11;
                                str2 = "setUint8";
                                break;
                            }
                        } else {
                            i = 3;
                            str2 = "getUint8";
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 9:
                char charAt6 = str.charAt(0);
                if (charAt6 == 'g') {
                    char charAt7 = str.charAt(8);
                    if (charAt7 != '2') {
                        if (charAt7 == '6') {
                            i = 5;
                            str2 = "getUint16";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 7;
                        str2 = "getUint32";
                        break;
                    }
                } else {
                    if (charAt6 == 's') {
                        char charAt8 = str.charAt(8);
                        if (charAt8 != '2') {
                            if (charAt8 == '6') {
                                i = 13;
                                str2 = "setUint16";
                                break;
                            }
                        } else {
                            i = 15;
                            str2 = "setUint32";
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 10:
                char charAt9 = str.charAt(0);
                if (charAt9 == 'g') {
                    char charAt10 = str.charAt(9);
                    if (charAt10 != '2') {
                        if (charAt10 == '4') {
                            str2 = "getFloat64";
                            i = 9;
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        str2 = "getFloat32";
                        i = 8;
                        break;
                    }
                } else {
                    if (charAt9 == 's') {
                        char charAt11 = str.charAt(9);
                        if (charAt11 != '2') {
                            if (charAt11 == '4') {
                                i = 17;
                                str2 = "setFloat64";
                                break;
                            }
                        } else {
                            i = 16;
                            str2 = "setFloat32";
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 11:
                i = 1;
                str2 = "constructor";
                break;
            default:
                str2 = null;
                i = 0;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 2;
        switch (i) {
            case 1:
                i2 = 3;
                str = "constructor";
                break;
            case 2:
                str2 = "getInt8";
                str = str2;
                i2 = 1;
                break;
            case 3:
                str2 = "getUint8";
                str = str2;
                i2 = 1;
                break;
            case 4:
                str2 = "getInt16";
                str = str2;
                i2 = 1;
                break;
            case 5:
                str2 = "getUint16";
                str = str2;
                i2 = 1;
                break;
            case 6:
                str2 = "getInt32";
                str = str2;
                i2 = 1;
                break;
            case 7:
                str2 = "getUint32";
                str = str2;
                i2 = 1;
                break;
            case 8:
                str2 = "getFloat32";
                str = str2;
                i2 = 1;
                break;
            case 9:
                str2 = "getFloat64";
                str = str2;
                i2 = 1;
                break;
            case 10:
                str = "setInt8";
                break;
            case 11:
                str = "setUint8";
                break;
            case 12:
                str = "setInt16";
                break;
            case 13:
                str = "setUint16";
                break;
            case 14:
                str = "setInt32";
                break;
            case 15:
                str = "setUint32";
                break;
            case 16:
                str = "setFloat32";
                break;
            case 17:
                str = "setFloat64";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(getClassName(), i, str, i2);
    }
}
