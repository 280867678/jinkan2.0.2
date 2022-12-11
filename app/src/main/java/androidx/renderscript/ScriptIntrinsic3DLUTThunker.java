package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsic3DLUTThunker extends ScriptIntrinsic3DLUT {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsic3DLUT f133mN;

    public ScriptIntrinsic3DLUTThunker(int i, RenderScript renderScript, Element element) {
        super(i, renderScript, element);
    }

    public static ScriptIntrinsic3DLUTThunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsic3DLUTThunker scriptIntrinsic3DLUTThunker = new ScriptIntrinsic3DLUTThunker(0, renderScript, element);
        try {
            scriptIntrinsic3DLUTThunker.f133mN = android.renderscript.ScriptIntrinsic3DLUT.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsic3DLUTThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsic3DLUT
    public void forEach(Allocation allocation, Allocation allocation2) {
        try {
            this.f133mN.forEach(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsic3DLUT
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        try {
            createKernelID.f129mN = this.f133mN.getKernelID();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsic3DLUT mo4369getNObj() {
        return this.f133mN;
    }

    @Override // androidx.renderscript.ScriptIntrinsic3DLUT
    public void setLUT(Allocation allocation) {
        try {
            this.f133mN.setLUT(((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
