package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsic3DLUT extends ScriptIntrinsic {
    public Element mElement;
    public Allocation mLUT;

    public ScriptIntrinsic3DLUT(int i, RenderScript renderScript, Element element) {
        super(i, renderScript);
        this.mElement = element;
    }

    public static ScriptIntrinsic3DLUT create(RenderScript renderScript, Element element) {
        if (RenderScript.isNative) {
            RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
            return ScriptIntrinsic3DLUTThunker.create(renderScript, element);
        }
        int nScriptIntrinsicCreate = renderScript.nScriptIntrinsicCreate(8, element.getID(renderScript));
        if (!element.isCompatible(Element.U8_4(renderScript))) {
            throw new RSIllegalArgumentException("Element must be compatible with uchar4.");
        }
        return new ScriptIntrinsic3DLUT(nScriptIntrinsicCreate, renderScript, element);
    }

    public void forEach(Allocation allocation, Allocation allocation2) {
        forEach(0, allocation, allocation2, null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, null, null);
    }

    public void setLUT(Allocation allocation) {
        Type type = allocation.getType();
        if (type.getZ() != 0) {
            if (!type.getElement().isCompatible(this.mElement)) {
                throw new RSIllegalArgumentException("LUT element type must match.");
            }
            this.mLUT = allocation;
            setVar(0, allocation);
            return;
        }
        throw new RSIllegalArgumentException("LUT must be 3d.");
    }
}
