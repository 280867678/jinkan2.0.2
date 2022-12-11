package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicBlurThunker extends ScriptIntrinsicBlur {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsicBlur f135mN;

    public ScriptIntrinsicBlurThunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicBlurThunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsicBlurThunker scriptIntrinsicBlurThunker = new ScriptIntrinsicBlurThunker(0, renderScript);
        try {
            scriptIntrinsicBlurThunker.f135mN = android.renderscript.ScriptIntrinsicBlur.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsicBlurThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlur
    public void forEach(Allocation allocation) {
        AllocationThunker allocationThunker = (AllocationThunker) allocation;
        if (allocationThunker != null) {
            try {
                this.f135mN.forEach(allocationThunker.mo4369getNObj());
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlur
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(1, null);
        try {
            createFieldID.f128mN = this.f135mN.getFieldID_Input();
            return createFieldID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlur
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        try {
            createKernelID.f129mN = this.f135mN.getKernelID();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsicBlur mo4369getNObj() {
        return this.f135mN;
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlur
    public void setInput(Allocation allocation) {
        try {
            this.f135mN.setInput(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlur
    public void setRadius(float f) {
        try {
            this.f135mN.setRadius(f);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
