package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicConvolve5x5 extends ScriptIntrinsic {
    public Allocation mInput;
    public final float[] mValues = new float[25];

    public ScriptIntrinsicConvolve5x5(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicConvolve5x5 create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
            return ScriptIntrinsicConvolve5x5Thunker.create(renderScript, element);
        }
        return new ScriptIntrinsicConvolve5x5(renderScript.nScriptIntrinsicCreate(4, element.getID(renderScript)), renderScript);
    }

    public void forEach(Allocation allocation) {
        forEach(0, null, allocation, null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(1, null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    public void setCoefficients(float[] fArr) {
        FieldPacker fieldPacker = new FieldPacker(100);
        int i = 0;
        while (true) {
            float[] fArr2 = this.mValues;
            if (i >= fArr2.length) {
                setVar(0, fieldPacker);
                return;
            }
            fArr2[i] = fArr[i];
            fieldPacker.addF32(fArr2[i]);
            i++;
        }
    }

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, allocation);
    }
}
