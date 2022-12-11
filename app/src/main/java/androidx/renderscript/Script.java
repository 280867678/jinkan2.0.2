package androidx.renderscript;

import android.renderscript.Script;
import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class Script extends BaseObj {

    /* renamed from: mT */
    public ScriptCThunker f127mT;
    public final SparseArray<KernelID> mKIDs = new SparseArray<>();
    public final SparseArray<FieldID> mFIDs = new SparseArray<>();

    /* loaded from: classes3.dex */
    public static class Builder {
        public RenderScript mRS;

        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }
    }

    /* loaded from: classes3.dex */
    public static class FieldBase {
        public Allocation mAllocation;
        public Element mElement;

        public Allocation getAllocation() {
            return this.mAllocation;
        }

        public Element getElement() {
            return this.mElement;
        }

        public Type getType() {
            return this.mAllocation.getType();
        }

        public void init(RenderScript renderScript, int i) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, 1);
        }

        public void init(RenderScript renderScript, int i, int i2) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, i2 | 1);
        }

        public void updateAllocation() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class FieldID extends BaseObj {

        /* renamed from: mN */
        public Script.FieldID f128mN;
        public Script mScript;
        public int mSlot;

        public FieldID(int i, RenderScript renderScript, Script script, int i2) {
            super(i, renderScript);
            this.mScript = script;
            this.mSlot = i2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class KernelID extends BaseObj {

        /* renamed from: mN */
        public Script.KernelID f129mN;
        public Script mScript;
        public int mSig;
        public int mSlot;

        public KernelID(int i, RenderScript renderScript, Script script, int i2, int i3) {
            super(i, renderScript);
            this.mScript = script;
            this.mSlot = i2;
            this.mSig = i3;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LaunchOptions {
        public int strategy;
        public int xstart = 0;
        public int ystart = 0;
        public int xend = 0;
        public int yend = 0;
        public int zstart = 0;
        public int zend = 0;

        public int getXEnd() {
            return this.xend;
        }

        public int getXStart() {
            return this.xstart;
        }

        public int getYEnd() {
            return this.yend;
        }

        public int getYStart() {
            return this.ystart;
        }

        public int getZEnd() {
            return this.zend;
        }

        public int getZStart() {
            return this.zstart;
        }

        public LaunchOptions setX(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.xstart = i;
            this.xend = i2;
            return this;
        }

        public LaunchOptions setY(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.ystart = i;
            this.yend = i2;
            return this;
        }

        public LaunchOptions setZ(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.zstart = i;
            this.zend = i2;
            return this;
        }
    }

    public Script(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public void bindAllocation(Allocation allocation, int i) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkBindAllocation(allocation, i);
            return;
        }
        this.mRS.validate();
        if (allocation != null) {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptBindAllocation(getID(renderScript), allocation.getID(this.mRS), i);
            return;
        }
        RenderScript renderScript2 = this.mRS;
        renderScript2.nScriptBindAllocation(getID(renderScript2), 0, i);
    }

    public FieldID createFieldID(int i, Element element) {
        RenderScript renderScript = this.mRS;
        if (RenderScript.isNative) {
            FieldID fieldID = new FieldID(0, renderScript, this, i);
            ScriptCThunker scriptCThunker = this.f127mT;
            if (scriptCThunker != null) {
                fieldID.f128mN = scriptCThunker.thunkCreateFieldID(i, element);
            }
            this.mFIDs.put(i, fieldID);
            return fieldID;
        }
        FieldID fieldID2 = this.mFIDs.get(i);
        if (fieldID2 != null) {
            return fieldID2;
        }
        RenderScript renderScript2 = this.mRS;
        int nScriptFieldIDCreate = renderScript2.nScriptFieldIDCreate(getID(renderScript2), i);
        if (nScriptFieldIDCreate == 0) {
            throw new RSDriverException("Failed to create FieldID");
        }
        FieldID fieldID3 = new FieldID(nScriptFieldIDCreate, this.mRS, this, i);
        this.mFIDs.put(i, fieldID3);
        return fieldID3;
    }

    public KernelID createKernelID(int i, int i2, Element element, Element element2) {
        KernelID kernelID = this.mKIDs.get(i);
        if (kernelID != null) {
            return kernelID;
        }
        RenderScript renderScript = this.mRS;
        if (RenderScript.isNative) {
            KernelID kernelID2 = new KernelID(0, renderScript, this, i, i2);
            ScriptCThunker scriptCThunker = this.f127mT;
            if (scriptCThunker != null) {
                kernelID2.f129mN = scriptCThunker.thunkCreateKernelID(i, i2, element, element2);
            }
            this.mKIDs.put(i, kernelID2);
            return kernelID2;
        }
        int nScriptKernelIDCreate = renderScript.nScriptKernelIDCreate(getID(renderScript), i, i2);
        if (nScriptKernelIDCreate == 0) {
            throw new RSDriverException("Failed to create KernelID");
        }
        KernelID kernelID3 = new KernelID(nScriptKernelIDCreate, this.mRS, this, i, i2);
        this.mKIDs.put(i, kernelID3);
        return kernelID3;
    }

    public void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkForEach(i, allocation, allocation2, fieldPacker);
        } else if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        } else {
            int id = allocation != null ? allocation.getID(this.mRS) : 0;
            int id2 = allocation2 != null ? allocation2.getID(this.mRS) : 0;
            byte[] bArr = null;
            if (fieldPacker != null) {
                bArr = fieldPacker.getData();
            }
            RenderScript renderScript = this.mRS;
            renderScript.nScriptForEach(getID(renderScript), i, id, id2, bArr);
        }
    }

    public void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkForEach(i, allocation, allocation2, fieldPacker, launchOptions);
        } else if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        } else {
            if (launchOptions == null) {
                forEach(i, allocation, allocation2, fieldPacker);
                return;
            }
            int id = allocation != null ? allocation.getID(this.mRS) : 0;
            int id2 = allocation2 != null ? allocation2.getID(this.mRS) : 0;
            byte[] bArr = null;
            if (fieldPacker != null) {
                bArr = fieldPacker.getData();
            }
            RenderScript renderScript = this.mRS;
            renderScript.nScriptForEachClipped(getID(renderScript), i, id, id2, bArr, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend);
        }
    }

    @Override // androidx.renderscript.BaseObj
    /* renamed from: getNObj  reason: collision with other method in class */
    public android.renderscript.Script mo4369getNObj() {
        return this.f127mT;
    }

    public void invoke(int i) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkInvoke(i);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptInvoke(getID(renderScript), i);
    }

    public void invoke(int i, FieldPacker fieldPacker) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkInvoke(i, fieldPacker);
        } else if (fieldPacker != null) {
            RenderScript renderScript = this.mRS;
            renderScript.nScriptInvokeV(getID(renderScript), i, fieldPacker.getData());
        } else {
            RenderScript renderScript2 = this.mRS;
            renderScript2.nScriptInvoke(getID(renderScript2), i);
        }
    }

    public void setTimeZone(String str) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetTimeZone(str);
            return;
        }
        this.mRS.validate();
        try {
            this.mRS.nScriptSetTimeZone(getID(this.mRS), str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVar(int i, double d) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, d);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarD(getID(renderScript), i, d);
    }

    public void setVar(int i, float f) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, f);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarF(getID(renderScript), i, f);
    }

    public void setVar(int i, int i2) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, i2);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarI(getID(renderScript), i, i2);
    }

    public void setVar(int i, long j) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, j);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarJ(getID(renderScript), i, j);
    }

    public void setVar(int i, BaseObj baseObj) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, baseObj);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarObj(getID(renderScript), i, baseObj == null ? 0 : baseObj.getID(this.mRS));
    }

    public void setVar(int i, FieldPacker fieldPacker) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, fieldPacker);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarV(getID(renderScript), i, fieldPacker.getData());
    }

    public void setVar(int i, FieldPacker fieldPacker, Element element, int[] iArr) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, fieldPacker, element, iArr);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarVE(getID(renderScript), i, fieldPacker.getData(), element.getID(this.mRS), iArr);
    }

    public void setVar(int i, boolean z) {
        ScriptCThunker scriptCThunker = this.f127mT;
        if (scriptCThunker != null) {
            scriptCThunker.thunkSetVar(i, z);
            return;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptSetVarI(getID(renderScript), i, z ? 1 : 0);
    }
}
