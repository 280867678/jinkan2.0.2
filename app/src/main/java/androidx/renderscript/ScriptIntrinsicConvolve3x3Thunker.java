package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicConvolve3x3Thunker extends ScriptIntrinsicConvolve3x3 {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsicConvolve3x3 f137mN;

    public ScriptIntrinsicConvolve3x3Thunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicConvolve3x3Thunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsicConvolve3x3Thunker scriptIntrinsicConvolve3x3Thunker = new ScriptIntrinsicConvolve3x3Thunker(0, renderScript);
        try {
            scriptIntrinsicConvolve3x3Thunker.f137mN = android.renderscript.ScriptIntrinsicConvolve3x3.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsicConvolve3x3Thunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve3x3
    public void forEach(Allocation allocation) {
        try {
            this.f137mN.forEach(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve3x3
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(1, null);
        try {
            createFieldID.f128mN = this.f137mN.getFieldID_Input();
            return createFieldID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve3x3
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        try {
            createKernelID.f129mN = this.f137mN.getKernelID();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsicConvolve3x3 mo4369getNObj() {
        return this.f137mN;
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve3x3
    public void setCoefficients(float[] fArr) {
        try {
            this.f137mN.setCoefficients(fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicConvolve3x3
    public void setInput(Allocation allocation) {
        try {
            this.f137mN.setInput(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
