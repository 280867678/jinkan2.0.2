package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeInt32Array extends NativeTypedArrayView<Integer> {
    public static final int BYTES_PER_ELEMENT = 4;
    public static final String CLASS_NAME = "Int32Array";
    public static final long serialVersionUID = -8963461831950499340L;

    public NativeInt32Array() {
    }

    public NativeInt32Array(int i) {
        this(new NativeArrayBuffer(i * 4), 0, i);
    }

    public NativeInt32Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 4);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeInt32Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: construct */
    public NativeTypedArrayView<Integer> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeInt32Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    /* renamed from: get */
    public Integer mo5278get(int i) {
        if (!checkIndex(i)) {
            return (Integer) js_get(i);
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
        return checkIndex(i) ? Undefined.instance : ByteIo.readInt32(this.arrayBuffer.buffer, (i * 4) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeInt32(this.arrayBuffer.buffer, (i * 4) + this.offset, ScriptRuntime.toInt32(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: realThis */
    public NativeTypedArrayView<Integer> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeInt32Array) {
            return (NativeInt32Array) scriptable;
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
