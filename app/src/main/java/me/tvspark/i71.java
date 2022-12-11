package me.tvspark;

import java.util.List;
import org.seimicrawler.xpath.exception.XpathParserException;

/* loaded from: classes4.dex */
public class i71 implements j61 {
    @Override // me.tvspark.j61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var, List<m61> list) {
        if (list.size() == 1) {
            return new m61(Boolean.valueOf(!list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().booleanValue()));
        }
        throw new XpathParserException("error param in not(bool) function.Please check.");
    }

    @Override // me.tvspark.j61
    public String name() {
        return "not";
    }
}
