package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicColorMatrixThunker extends ScriptIntrinsicColorMatrix {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsicColorMatrix f136mN;

    public ScriptIntrinsicColorMatrixThunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicColorMatrixThunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsicColorMatrixThunker scriptIntrinsicColorMatrixThunker = new ScriptIntrinsicColorMatrixThunker(0, renderScript);
        try {
            scriptIntrinsicColorMatrixThunker.f136mN = android.renderscript.ScriptIntrinsicColorMatrix.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsicColorMatrixThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicColorMatrix
    public void forEach(Allocation allocation, Allocation allocation2) {
        try {
            this.f136mN.forEach(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicColorMatrix
    public Script.KernelID getKernelID() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        try {
            createKernelID.f129mN = this.f136mN.getKernelID();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsicColorMatrix mo4369getNObj() {
        return this.f136mN;
    }

    @Override // androidx.renderscript.ScriptIntrinsicColorMatrix
    public void setColorMatrix(Matrix3f matrix3f) {
        try {
            this.f136mN.setColorMatrix(new android.renderscript.Matrix3f(matrix3f.getArray()));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicColorMatrix
    public void setColorMatrix(Matrix4f matrix4f) {
        try {
            this.f136mN.setColorMatrix(new android.renderscript.Matrix4f(matrix4f.getArray()));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicColorMatrix
    public void setGreyscale() {
        try {
            this.f136mN.setGreyscale();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicColorMatrix
    public void setRGBtoYUV() {
        try {
            this.f136mN.setRGBtoYUV();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicColorMatrix
    public void setYUVtoRGB() {
        try {
            this.f136mN.setYUVtoRGB();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
