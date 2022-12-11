package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeInt8Array extends NativeTypedArrayView<Byte> {
    public static final String CLASS_NAME = "Int8Array";
    public static final long serialVersionUID = -3349419704390398895L;

    public NativeInt8Array() {
    }

    public NativeInt8Array(int i) {
        this(new NativeArrayBuffer(i), 0, i);
    }

    public NativeInt8Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeInt8Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: construct */
    public NativeTypedArrayView<Byte> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeInt8Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    /* renamed from: get */
    public Byte mo5279get(int i) {
        if (!checkIndex(i)) {
            return (Byte) js_get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 1;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : ByteIo.readInt8(this.arrayBuffer.buffer, i + this.offset);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeInt8(this.arrayBuffer.buffer, i + this.offset, Conversions.toInt8(obj));
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: realThis */
    public NativeTypedArrayView<Byte> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeInt8Array) {
            return (NativeInt8Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Byte set(int i, Byte b) {
        if (!checkIndex(i)) {
            return (Byte) js_set(i, b);
        }
        throw new IndexOutOfBoundsException();
    }
}
