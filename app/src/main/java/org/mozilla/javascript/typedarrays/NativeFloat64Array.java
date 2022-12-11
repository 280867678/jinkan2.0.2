package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeFloat64Array extends NativeTypedArrayView<Double> {
    public static final int BYTES_PER_ELEMENT = 8;
    public static final String CLASS_NAME = "Float64Array";
    public static final long serialVersionUID = -1255405650050639335L;

    public NativeFloat64Array() {
    }

    public NativeFloat64Array(int i) {
        this(new NativeArrayBuffer(i * 8), 0, i);
    }

    public NativeFloat64Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 8);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeFloat64Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: construct */
    public NativeTypedArrayView<Double> construct2(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeFloat64Array(nativeArrayBuffer, i, i2);
    }

    @Override // java.util.List
    /* renamed from: get */
    public Double mo5276get(int i) {
        if (!checkIndex(i)) {
            return (Double) js_get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 8;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : Double.valueOf(Double.longBitsToDouble(ByteIo.readUint64Primitive(this.arrayBuffer.buffer, (i * 8) + this.offset, NativeArrayBufferView.useLittleEndian())));
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint64(this.arrayBuffer.buffer, (i * 8) + this.offset, Double.doubleToLongBits(ScriptRuntime.toNumber(obj)), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* renamed from: realThis */
    public NativeTypedArrayView<Double> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeFloat64Array) {
            return (NativeFloat64Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List
    public Double set(int i, Double d) {
        if (!checkIndex(i)) {
            return (Double) js_set(i, d);
        }
        throw new IndexOutOfBoundsException();
    }
}
