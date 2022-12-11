package me.tvspark;

import com.umeng.analytics.pro.C1543ak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import me.tvspark.r01;

/* loaded from: classes4.dex */
public class q01 {
    public final iy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final p01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public q01(p01 p01Var, iy0 iy0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = p01Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iy0Var;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01 r01Var) {
        int i = r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? ":" : str);
        sb.append(C1543ak.f2965aB);
        sb.append(i);
        if (r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            str = "^";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            r01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "=>");
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Arrays.toString(r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww));
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return sb2;
    }

    public String toString() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        p01 p01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (p01Var != null) {
            ArrayList arrayList = new ArrayList(p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keySet());
            Collections.sort(arrayList, new o01(p01Var));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                r01 r01Var = (r01) it.next();
                r01[] r01VarArr = r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int length = r01VarArr != null ? r01VarArr.length : 0;
                for (int i = 0; i < length; i++) {
                    r01 r01Var2 = r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                    if (r01Var2 != null && r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != Integer.MAX_VALUE) {
                        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var));
                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((jy0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - 1);
                        sb.append("-");
                        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        sb.append("->");
                        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var2));
                        sb.append('\n');
                    }
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() != 0) {
                return sb2;
            }
            return null;
        }
        throw null;
    }
}
