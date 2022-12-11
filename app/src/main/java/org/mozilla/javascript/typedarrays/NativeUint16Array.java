package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeUint16Array extends NativeTypedArrayView<Integer> {
    public static final int BYTES_PER_ELEMENT = 2;
    public static final String CLASS_NAME = "Uint16Array";
    public static final long serialVersionUID = 7700018949434240321L;

    public NativeUint16Array() {
    }

    public NativeUint16Array(int i) {
        this(new NativeArrayBuffer(i * 2), 0, i);
    }

    public NativeUint16Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 2);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint16Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Integer> construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint16Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    /* renamed from: get */
    public Integer mo5280get(int i) {
        if (!checkIndex(i)) {
            return (Integer) js_get(i);
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
        return checkIndex(i) ? Undefined.instance : ByteIo.readUint16(this.arrayBuffer.buffer, (i * 2) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint16(this.arrayBuffer.buffer, (i * 2) + this.offset, Conversions.toUint16(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Integer> realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint16Array) {
            return (NativeUint16Array) scriptable;
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
