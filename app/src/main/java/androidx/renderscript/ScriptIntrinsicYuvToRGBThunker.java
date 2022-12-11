package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicYuvToRGBThunker extends ScriptIntrinsicYuvToRGB {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsicYuvToRGB f140mN;

    public ScriptIntrinsicYuvToRGBThunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicYuvToRGBThunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsicYuvToRGBThunker scriptIntrinsicYuvToRGBThunker = new ScriptIntrinsicYuvToRGBThunker(0, renderScript);
        try {
            scriptIntrinsicYuvToRGBThunker.f140mN = android.renderscript.ScriptIntrinsicYuvToRGB.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsicYuvToRGBThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicYuvToRGB
    public void forEach(Allocation allocation) {
        try {
            this.f140mN.forEach(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicYuvToRGB
    public Script.FieldID getFieldID_Input() {
        Script.FieldID createFieldID = createFieldID(0, null);
        try {
            createFieldID.f128mN = this.f140mN.getFieldID_Input();
            return createFieldID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicYuvToRGB
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 2, null, null);
        try {
            createKernelID.f129mN = this.f140mN.getKernelID();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsicYuvToRGB mo4369getNObj() {
        return this.f140mN;
    }

    @Override // androidx.renderscript.ScriptIntrinsicYuvToRGB
    public void setInput(Allocation allocation) {
        try {
            this.f140mN.setInput(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
