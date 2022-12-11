package androidx.renderscript;

import android.content.res.Resources;
import android.renderscript.Script;
import androidx.renderscript.Script;

/* loaded from: classes3.dex */
public class ScriptCThunker extends android.renderscript.ScriptC {
    public static final String TAG = "ScriptC";

    public ScriptCThunker(RenderScriptThunker renderScriptThunker, Resources resources, int i) {
        super(renderScriptThunker.f125mN, resources, i);
    }

    public void thunkBindAllocation(Allocation allocation, int i) {
        try {
            bindAllocation(allocation != null ? ((AllocationThunker) allocation).f73mN : null, i);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public Script.FieldID thunkCreateFieldID(int i, Element element) {
        try {
            return createFieldID(i, ((ElementThunker) element).mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public Script.KernelID thunkCreateKernelID(int i, int i2, Element element, Element element2) {
        android.renderscript.Element element3 = null;
        android.renderscript.Element element4 = element != null ? ((ElementThunker) element).f94mN : null;
        if (element2 != null) {
            element3 = ((ElementThunker) element2).f94mN;
        }
        try {
            return createKernelID(i, i2, element4, element3);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkForEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        android.renderscript.FieldPacker fieldPacker2 = null;
        android.renderscript.Allocation allocation3 = allocation != null ? ((AllocationThunker) allocation).f73mN : null;
        android.renderscript.Allocation allocation4 = allocation2 != null ? ((AllocationThunker) allocation2).f73mN : null;
        if (fieldPacker != null) {
            try {
                fieldPacker2 = new android.renderscript.FieldPacker(fieldPacker.getData());
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }
        forEach(i, allocation3, allocation4, fieldPacker2);
    }

    public void thunkForEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, Script.LaunchOptions launchOptions) {
        Script.LaunchOptions launchOptions2;
        android.renderscript.FieldPacker fieldPacker2 = null;
        if (launchOptions != null) {
            try {
                Script.LaunchOptions launchOptions3 = new Script.LaunchOptions();
                if (launchOptions.getXEnd() > 0) {
                    launchOptions3.setX(launchOptions.getXStart(), launchOptions.getXEnd());
                }
                if (launchOptions.getYEnd() > 0) {
                    launchOptions3.setY(launchOptions.getYStart(), launchOptions.getYEnd());
                }
                if (launchOptions.getZEnd() > 0) {
                    launchOptions3.setZ(launchOptions.getZStart(), launchOptions.getZEnd());
                }
                launchOptions2 = launchOptions3;
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        } else {
            launchOptions2 = null;
        }
        android.renderscript.Allocation allocation3 = allocation != null ? ((AllocationThunker) allocation).f73mN : null;
        android.renderscript.Allocation allocation4 = allocation2 != null ? ((AllocationThunker) allocation2).f73mN : null;
        if (fieldPacker != null) {
            fieldPacker2 = new android.renderscript.FieldPacker(fieldPacker.getData());
        }
        forEach(i, allocation3, allocation4, fieldPacker2, launchOptions2);
    }

    public void thunkInvoke(int i) {
        try {
            invoke(i);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkInvoke(int i, FieldPacker fieldPacker) {
        try {
            invoke(i, new android.renderscript.FieldPacker(fieldPacker.getData()));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetTimeZone(String str) {
        try {
            setTimeZone(str);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetVar(int i, double d) {
        try {
            setVar(i, d);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetVar(int i, float f) {
        try {
            setVar(i, f);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetVar(int i, int i2) {
        try {
            setVar(i, i2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetVar(int i, long j) {
        try {
            setVar(i, j);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetVar(int i, BaseObj baseObj) {
        if (baseObj == null) {
            try {
                setVar(i, 0);
                return;
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }
        try {
            setVar(i, baseObj.mo4369getNObj());
        } catch (android.renderscript.RSRuntimeException e2) {
            throw ExceptionThunker.convertException(e2);
        }
    }

    public void thunkSetVar(int i, FieldPacker fieldPacker) {
        try {
            setVar(i, new android.renderscript.FieldPacker(fieldPacker.getData()));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetVar(int i, FieldPacker fieldPacker, Element element, int[] iArr) {
        try {
            setVar(i, new android.renderscript.FieldPacker(fieldPacker.getData()), ((ElementThunker) element).f94mN, iArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public void thunkSetVar(int i, boolean z) {
        try {
            setVar(i, z);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
