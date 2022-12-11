package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicConvolve3x3 extends ScriptIntrinsic {
    public Allocation mInput;
    public final float[] mValues = new float[9];

    public ScriptIntrinsicConvolve3x3(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicConvolve3x3 create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
            return ScriptIntrinsicConvolve3x3Thunker.create(renderScript, element);
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        if (!element.isCompatible(Element.U8_4(renderScript))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        }
        ScriptIntrinsicConvolve3x3 scriptIntrinsicConvolve3x3 = new ScriptIntrinsicConvolve3x3(renderScript.nScriptIntrinsicCreate(1, element.getID(renderScript)), renderScript);
        scriptIntrinsicConvolve3x3.setCoefficients(fArr);
        return scriptIntrinsicConvolve3x3;
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
        FieldPacker fieldPacker = new FieldPacker(36);
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
