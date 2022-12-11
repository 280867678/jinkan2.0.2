package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicConvolve5x5Thunker extends ScriptIntrinsicConvolve5x5 {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsicConvolve5x5 f138mN;

    public ScriptIntrinsicConvolve5x5Thunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicConvolve5x5Thunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsicConvolve5x5Thunker scriptIntrinsicConvolve5x5Thunker = new ScriptIntrinsicConvolve5x5Thunker(0, renderScript);
        try {
            scriptIntrinsicConvolve5x5Thunker.f138mN = android.renderscript.ScriptIntrinsicConvolve5x5.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsicConvolve5x5Thunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve5x5
    public void forEach(Allocation allocation) {
        try {
            this.f138mN.forEach(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve5x5
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(1, null);
        try {
            createFieldID.f128mN = this.f138mN.getFieldID_Input();
            return createFieldID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve5x5
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        try {
            createKernelID.f129mN = this.f138mN.getKernelID();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsicConvolve5x5 mo4369getNObj() {
        return this.f138mN;
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve5x5
    public void setCoefficients(float[] fArr) {
        try {
            this.f138mN.setCoefficients(fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve5x5
    public void setInput(Allocation allocation) {
        try {
            this.f138mN.setInput(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
