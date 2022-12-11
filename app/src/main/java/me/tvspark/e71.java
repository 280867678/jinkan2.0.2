package me.tvspark;

import java.util.List;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class e71 implements j61 {
    @Override // me.tvspark.j61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var, List<m61> list) {
        if (list != null && list.size() != 0) {
            return new m61(Integer.valueOf(((Elements) list.get(0).Wwwwwwwwwwwwwwwwwwwwwwww).size()));
        }
        return new m61(0);
    }

    @Override // me.tvspark.j61
    public String name() {
        return "count";
    }
}
