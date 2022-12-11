package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeUint32Array extends NativeTypedArrayView<Long> {
    public static final int BYTES_PER_ELEMENT = 4;
    public static final String CLASS_NAME = "Uint32Array";
    public static final long serialVersionUID = -7987831421954144244L;

    public NativeUint32Array() {
    }

    public NativeUint32Array(int i) {
        this(new NativeArrayBuffer(i * 4), 0, i);
    }

    public NativeUint32Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 4);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint32Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Long> construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint32Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    /* renamed from: get */
    public Long mo5281get(int i) {
        if (!checkIndex(i)) {
            return (Long) js_get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 4;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : ByteIo.readUint32(this.arrayBuffer.buffer, (i * 4) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint32(this.arrayBuffer.buffer, (i * 4) + this.offset, Conversions.toUint32(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Long> realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint32Array) {
            return (NativeUint32Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Long set(int i, Long l) {
        if (!checkIndex(i)) {
            return (Long) js_set(i, l);
        }
        throw new IndexOutOfBoundsException();
    }
}
