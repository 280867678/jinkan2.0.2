package me.tvspark;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class r71 implements j61 {
    @Override // me.tvspark.j61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var, List<m61> list) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int intValue = list.get(1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue();
        if (list.get(2) != null) {
            return new m61(StringUtils.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, intValue, list.get(2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue()));
        }
        return new m61(StringUtils.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, intValue));
    }

    @Override // me.tvspark.j61
    public String name() {
        return "substring-ex";
    }
}
