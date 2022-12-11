package me.tvspark;

import com.jayway.jsonpath.internal.filter.RelationalOperator;
import me.tvspark.f30;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class r30 extends o30 {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LoggerFactory.getLogger(r30.class);
    public final s30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final RelationalOperator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final s30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public r30(s30 s30Var, RelationalOperator relationalOperator, s30 s30Var2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = relationalOperator;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.trace("ExpressionNode {}", toString());
    }

    @Override // me.tvspark.f30
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        s30 s30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        s30 s30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (s30Var.Wwwwwwwwwwwwwwwwwwwwwww()) {
            s30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww()) {
            s30Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        m30 m30Var = n30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (m30Var != null) {
            return m30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30Var, s30Var2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public String toString() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == RelationalOperator.EXISTS) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString() + StringUtils.SPACE + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString() + StringUtils.SPACE + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
