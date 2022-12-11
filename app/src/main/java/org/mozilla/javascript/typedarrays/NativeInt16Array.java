package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeInt16Array extends NativeTypedArrayView<Short> {
    public static final int BYTES_PER_ELEMENT = 2;
    public static final String CLASS_NAME = "Int16Array";
    public static final long serialVersionUID = -8592870435287581398L;

    public NativeInt16Array() {
    }

    public NativeInt16Array(int i) {
        this(new NativeArrayBuffer(i * 2), 0, i);
    }

    public NativeInt16Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 2);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeInt16Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: construct */
    public NativeTypedArrayView<Short> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeInt16Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    public Short get(int i) {
        if (!checkIndex(i)) {
            return (Short) js_get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 2;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : ByteIo.readInt16(this.arrayBuffer.buffer, (i * 2) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeInt16(this.arrayBuffer.buffer, (i * 2) + this.offset, Conversions.toInt16(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: realThis */
    public NativeTypedArrayView<Short> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeInt16Array) {
            return (NativeInt16Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Short set(int i, Short sh) {
        if (!checkIndex(i)) {
            return (Short) js_set(i, sh);
        }
        throw new IndexOutOfBoundsException();
    }
}
