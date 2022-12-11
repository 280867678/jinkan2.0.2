package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeFloat32Array extends NativeTypedArrayView<Float> {
    public static final int BYTES_PER_ELEMENT = 4;
    public static final String CLASS_NAME = "Float32Array";
    public static final long serialVersionUID = -8963461831950499340L;

    public NativeFloat32Array() {
    }

    public NativeFloat32Array(int i) {
        this(new NativeArrayBuffer(i * 4), 0, i);
    }

    public NativeFloat32Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 4);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeFloat32Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: construct */
    public NativeTypedArrayView<Float> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeFloat32Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    /* renamed from: get */
    public Float mo5275get(int i) {
        if (!checkIndex(i)) {
            return (Float) js_get(i);
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
        return checkIndex(i) ? Undefined.instance : ByteIo.readFloat32(this.arrayBuffer.buffer, (i * 4) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeFloat32(this.arrayBuffer.buffer, (i * 4) + this.offset, ScriptRuntime.toNumber(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: realThis */
    public NativeTypedArrayView<Float> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeFloat32Array) {
            return (NativeFloat32Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Float set(int i, Float f) {
        if (!checkIndex(i)) {
            return (Float) js_set(i, f);
        }
        throw new IndexOutOfBoundsException();
    }
}
