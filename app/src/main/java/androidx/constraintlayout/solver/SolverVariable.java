package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class SolverVariable {
    public static final boolean INTERNAL_DEBUG = false;
    public static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    public static final boolean VAR_USE_HASH = false;
    public static int uniqueConstantId = 1;
    public static int uniqueErrorId = 1;
    public static int uniqueId = 1;
    public static int uniqueSlackId = 1;
    public static int uniqueUnrestrictedId = 1;
    public float computedValue;
    public int definitionId;
    public float[] goalStrengthVector;

    /* renamed from: id */
    public int f31id;
    public boolean inGoal;
    public HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    public ArrayRow[] mClientEquations;
    public int mClientEquationsCount;
    public String mName;
    public Type mType;
    public int strength;
    public float[] strengthVector;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01681 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                Type type = Type.UNRESTRICTED;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
                Type type2 = Type.CONSTANT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
                Type type3 = Type.SLACK;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
                Type type4 = Type.ERROR;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
                Type type5 = Type.UNKNOWN;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f31id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mType = type;
    }

    public SolverVariable(String str, Type type) {
        this.f31id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    public static String getUniqueName(Type type, String str) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        if (str != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            i = uniqueErrorId;
        } else {
            int ordinal = type.ordinal();
            if (ordinal == 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("U");
                i = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i;
            } else if (ordinal == 1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("C");
                i = uniqueConstantId + 1;
                uniqueConstantId = i;
            } else if (ordinal == 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExifInterface.LATITUDE_SOUTH);
                i = uniqueSlackId + 1;
                uniqueSlackId = i;
            } else if (ordinal == 3) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("e");
                i = uniqueErrorId + 1;
                uniqueErrorId = i;
            } else if (ordinal != 4) {
                throw new AssertionError(type.name());
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                i = uniqueId + 1;
                uniqueId = i;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.mClientEquationsCount;
            if (i >= i2) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i2 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i3 = this.mClientEquationsCount;
                arrayRowArr2[i3] = arrayRow;
                this.mClientEquationsCount = i3 + 1;
                return;
            } else if (this.mClientEquations[i] == arrayRow) {
                return;
            } else {
                i++;
            }
        }
    }

    public void clearStrengths() {
        for (int i = 0; i < 9; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        r4.mClientEquationsCount--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r1 >= (r0 - 1)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
        r5 = r4.mClientEquations;
        r2 = r1 + 1;
        r5[r1] = r5[r2];
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        int i2 = 0;
        while (i2 < i) {
            if (this.mClientEquations[i2] == arrayRow) {
                break;
            }
            i2++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f31id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String str = this + "[";
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        while (i < this.strengthVector.length) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.strengthVector[i]);
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            float[] fArr = this.strengthVector;
            if (fArr[i] > 0.0f) {
                z = false;
            } else if (fArr[i] < 0.0f) {
                z = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                z2 = false;
            }
            int length = this.strengthVector.length - 1;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(i < length ? ", " : "] ");
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            i++;
        }
        if (z) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " (-)");
        }
        return z2 ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " (*)") : str;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.mName != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mName);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f31id);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromRow(arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}
