package me.tvspark;

import com.jayway.jsonpath.internal.filter.LogicalOperator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.tvspark.f30;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class q30 extends o30 {
    public final LogicalOperator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<o30> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public q30(LogicalOperator logicalOperator, Collection<o30> collection) {
        ArrayList arrayList = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
        arrayList.addAll(collection);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = logicalOperator;
    }

    public q30(o30 o30Var, LogicalOperator logicalOperator, o30 o30Var2) {
        ArrayList arrayList = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
        arrayList.add(o30Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(o30Var2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = logicalOperator;
    }

    @Override // me.tvspark.f30
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        LogicalOperator logicalOperator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (logicalOperator == LogicalOperator.OR) {
            for (o30 o30Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (o30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return true;
                }
            }
            return false;
        } else if (logicalOperator != LogicalOperator.AND) {
            return !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            for (o30 o30Var2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!o30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return false;
                }
            }
            return true;
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringUtils.SPACE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getOperatorString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(StringUtils.SPACE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), (Iterable<? extends Object>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
