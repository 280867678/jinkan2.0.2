package me.tvspark;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class m71 implements j61 {
    @Override // me.tvspark.j61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var, List<m61> list) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int max = Math.max(list.get(1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue() - 1, 0);
        if (list.get(2) != null) {
            return new m61(StringUtils.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, max, Math.max(Math.min(list.get(2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue() + max, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length()), 0)));
        }
        return new m61(StringUtils.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, max));
    }

    @Override // me.tvspark.j61
    public String name() {
        return "substring";
    }
}
