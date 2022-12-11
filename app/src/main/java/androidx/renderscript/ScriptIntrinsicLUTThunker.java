package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicLUTThunker extends ScriptIntrinsicLUT {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsicLUT f139mN;

    public ScriptIntrinsicLUTThunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicLUTThunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsicLUTThunker scriptIntrinsicLUTThunker = new ScriptIntrinsicLUTThunker(0, renderScript);
        try {
            scriptIntrinsicLUTThunker.f139mN = android.renderscript.ScriptIntrinsicLUT.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsicLUTThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicLUT
    public void forEach(Allocation allocation, Allocation allocation2) {
        try {
            this.f139mN.forEach(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicLUT
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        try {
            createKernelID.f129mN = this.f139mN.getKernelID();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsicLUT mo4369getNObj() {
        return this.f139mN;
    }

    @Override // androidx.renderscript.ScriptIntrinsicLUT
    public void setAlpha(int i, int i2) {
        try {
            this.f139mN.setAlpha(i, i2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicLUT
    public void setBlue(int i, int i2) {
        try {
            this.f139mN.setBlue(i, i2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicLUT
    public void setGreen(int i, int i2) {
        try {
            this.f139mN.setGreen(i, i2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicLUT
    public void setRed(int i, int i2) {
        try {
            this.f139mN.setRed(i, i2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
