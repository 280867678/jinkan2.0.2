package androidx.renderscript;

import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptIntrinsicBlendThunker extends ScriptIntrinsicBlend {

    /* renamed from: mN */
    public android.renderscript.ScriptIntrinsicBlend f134mN;

    public ScriptIntrinsicBlendThunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static ScriptIntrinsicBlendThunker create(RenderScript renderScript, Element element) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        ElementThunker elementThunker = (ElementThunker) element;
        ScriptIntrinsicBlendThunker scriptIntrinsicBlendThunker = new ScriptIntrinsicBlendThunker(0, renderScript);
        try {
            scriptIntrinsicBlendThunker.f134mN = android.renderscript.ScriptIntrinsicBlend.create(renderScriptThunker.f125mN, elementThunker.mo4369getNObj());
            return scriptIntrinsicBlendThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachAdd(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachAdd(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachClear(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachClear(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachDst(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachDst(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachDstAtop(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachDstAtop(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachDstIn(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachDstIn(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachDstOut(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachDstOut(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachDstOver(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachDstOver(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachMultiply(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachMultiply(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachSrc(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachSrc(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachSrcAtop(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachSrcAtop(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachSrcIn(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachSrcIn(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachSrcOut(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachSrcOut(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachSrcOver(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachSrcOver(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachSubtract(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachSubtract(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public void forEachXor(Allocation allocation, Allocation allocation2) {
        try {
            this.f134mN.forEachXor(((AllocationThunker) allocation).mo4369getNObj(), ((AllocationThunker) allocation2).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDAdd() {
        Script.KernelID createKernelID = createKernelID(34, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDAdd();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDClear() {
        Script.KernelID createKernelID = createKernelID(0, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDClear();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDst() {
        Script.KernelID createKernelID = createKernelID(2, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDDst();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstAtop() {
        Script.KernelID createKernelID = createKernelID(10, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDDstAtop();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstIn() {
        Script.KernelID createKernelID = createKernelID(6, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDDstIn();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstOut() {
        Script.KernelID createKernelID = createKernelID(8, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDDstOut();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDDstOver() {
        Script.KernelID createKernelID = createKernelID(4, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDDstOver();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDMultiply() {
        Script.KernelID createKernelID = createKernelID(14, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDMultiply();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrc() {
        Script.KernelID createKernelID = createKernelID(1, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDSrc();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcAtop() {
        Script.KernelID createKernelID = createKernelID(9, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDSrcAtop();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcIn() {
        Script.KernelID createKernelID = createKernelID(5, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDSrcIn();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcOut() {
        Script.KernelID createKernelID = createKernelID(7, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDSrcOut();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSrcOver() {
        Script.KernelID createKernelID = createKernelID(3, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDSrcOver();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDSubtract() {
        Script.KernelID createKernelID = createKernelID(35, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDSubtract();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptIntrinsicBlend
    public Script.KernelID getKernelIDXor() {
        Script.KernelID createKernelID = createKernelID(11, 3, null, null);
        try {
            createKernelID.f129mN = this.f134mN.getKernelIDXor();
            return createKernelID;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Script, androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.ScriptIntrinsicBlend mo4369getNObj() {
        return this.f134mN;
    }
}
