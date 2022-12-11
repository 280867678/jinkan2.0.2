package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeUint8ClampedArray extends NativeTypedArrayView<Integer> {
    public static final String CLASS_NAME = "Uint8ClampedArray";
    public static final long serialVersionUID = -3349419704390398895L;

    public NativeUint8ClampedArray() {
    }

    public NativeUint8ClampedArray(int i) {
        this(new NativeArrayBuffer(i), 0, i);
    }

    public NativeUint8ClampedArray(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint8ClampedArray().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Integer> construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint8ClampedArray(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    /* renamed from: get */
    public Integer mo5283get(int i) {
        if (!checkIndex(i)) {
            return (Integer) js_get(i);
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
        return checkIndex(i) ? Undefined.instance : ByteIo.readUint8(this.arrayBuffer.buffer, i + this.offset);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint8(this.arrayBuffer.buffer, i + this.offset, Conversions.toUint8Clamp(obj));
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Integer> realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint8ClampedArray) {
            return (NativeUint8ClampedArray) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Integer set(int i, Integer num) {
        if (!checkIndex(i)) {
            return (Integer) js_set(i, num);
        }
        throw new IndexOutOfBoundsException();
    }
}
