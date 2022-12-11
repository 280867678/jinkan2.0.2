package me.tvspark;

import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.internal.path.ArraySliceOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class k40 extends p40 {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwww = LoggerFactory.getLogger(k40.class);
    public final j40 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ArraySliceOperation Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public k40(ArraySliceOperation arraySliceOperation) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arraySliceOperation;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public k40(j40 j40Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j40Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.p40
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        j40 j40Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return j40Var != null && j40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj, m40 m40Var) {
        if (obj == null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                throw new PathNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The path ", str, " is null"));
            }
            return false;
        } else if (((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            if (obj instanceof List) {
                return true;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                throw new PathNotFoundException(String.format("Filter: %s can only be applied to arrays. Current context is: %s", toString(), obj));
            }
            return false;
        } else {
            throw null;
        }
    }

    @Override // me.tvspark.p40
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        j40 j40Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return j40Var != null ? j40Var.toString() : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // me.tvspark.p40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, m40 m40Var) {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj, m40Var)) {
            return;
        }
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj, m40Var)) {
                return;
            }
            int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal == 0) {
                ArraySliceOperation arraySliceOperation = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                int intValue = arraySliceOperation.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.intValue();
                if (intValue < 0) {
                    intValue += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                int max = Math.max(0, intValue);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww.debug("Slice from index on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Integer.valueOf(max), Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1), toString());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 || max >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                while (max < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(max, str, obj, m40Var);
                    max++;
                }
            } else if (ordinal == 1) {
                ArraySliceOperation arraySliceOperation2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                    return;
                }
                int intValue2 = arraySliceOperation2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.intValue();
                if (intValue2 < 0) {
                    intValue2 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                int min = Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, intValue2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww.debug("Slice to index on array with length: {}. From index: 0 to: {}. Input: {}", Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), Integer.valueOf(min), toString());
                for (int i = 0; i < min; i++) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, obj, m40Var);
                }
            } else if (ordinal == 2) {
                ArraySliceOperation arraySliceOperation3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = ((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                int intValue3 = arraySliceOperation3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.intValue();
                int min2 = Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, arraySliceOperation3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.intValue());
                if (intValue3 >= min2 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 0) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww.debug("Slice between indexes on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3), Integer.valueOf(intValue3), Integer.valueOf(min2), toString());
                while (intValue3 < min2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intValue3, str, obj, m40Var);
                    intValue3++;
                }
            }
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj, m40Var)) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() != 1) {
                z = false;
            }
            j40 j40Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0).intValue(), str, obj, m40Var);
                return;
            }
            for (Integer num : j40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(num.intValue(), str, obj, m40Var);
            }
        }
    }
}
