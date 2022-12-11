package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicBlur extends ScriptIntrinsic {
    public Allocation mInput;
    public final float[] mValues = new float[9];

    public ScriptIntrinsicBlur(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicBlur create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
            return ScriptIntrinsicBlurThunker.create(renderScript, element);
        } else if (!element.isCompatible(Element.U8_4(renderScript)) && !element.isCompatible(Element.m4196U8(renderScript))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        } else {
            ScriptIntrinsicBlur scriptIntrinsicBlur = new ScriptIntrinsicBlur(renderScript.nScriptIntrinsicCreate(5, element.getID(renderScript)), renderScript);
            scriptIntrinsicBlur.setRadius(5.0f);
            return scriptIntrinsicBlur;
        }
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

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, allocation);
    }

    public void setRadius(float f) {
        if (f <= 0.0f || f > 25.0f) {
            throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
        }
        setVar(0, f);
    }
}
