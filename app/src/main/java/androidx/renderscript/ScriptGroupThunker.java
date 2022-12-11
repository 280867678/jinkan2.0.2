package androidx.renderscript;

import android.renderscript.ScriptGroup;
import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptGroupThunker extends ScriptGroup {

    /* renamed from: mN */
    public android.renderscript.ScriptGroup f131mN;

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: bN */
        public ScriptGroup.Builder f132bN;
        public RenderScript mRS;

        public Builder(RenderScript renderScript) {
            RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
            this.mRS = renderScript;
            try {
                this.f132bN = new ScriptGroup.Builder(renderScriptThunker.f125mN);
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            try {
                this.f132bN.addConnection(((TypeThunker) type).mo4369getNObj(), kernelID.f129mN, fieldID.f128mN);
                return this;
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            try {
                this.f132bN.addConnection(((TypeThunker) type).mo4369getNObj(), kernelID.f129mN, kernelID2.f129mN);
                return this;
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }

        public Builder addKernel(Script.KernelID kernelID) {
            try {
                this.f132bN.addKernel(kernelID.f129mN);
                return this;
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }

        public ScriptGroupThunker create() {
            ScriptGroupThunker scriptGroupThunker = new ScriptGroupThunker(0, this.mRS);
            try {
                scriptGroupThunker.f131mN = this.f132bN.create();
                return scriptGroupThunker;
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }
    }

    public ScriptGroupThunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    @Override // androidx.renderscript.ScriptGroup
    public void execute() {
        try {
            this.f131mN.execute();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.BaseObj
    /* renamed from: getNObj  reason: collision with other method in class */
    public android.renderscript.ScriptGroup mo4369getNObj() {
        return this.f131mN;
    }

    @Override // androidx.renderscript.ScriptGroup
    public void setInput(Script.KernelID kernelID, Allocation allocation) {
        try {
            this.f131mN.setInput(kernelID.f129mN, ((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.ScriptGroup
    public void setOutput(Script.KernelID kernelID, Allocation allocation) {
        try {
            this.f131mN.setOutput(kernelID.f129mN, ((AllocationThunker) allocation).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
