package me.tvspark;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class o71 implements j61 {
    @Override // me.tvspark.j61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var, List<m61> list) {
        return new m61(StringUtils.substringAfterLast(list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), list.get(1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
    }

    @Override // me.tvspark.j61
    public String name() {
        return "substring-after-last";
    }
}
