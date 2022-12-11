package me.tvspark;

import java.util.List;

/* loaded from: classes4.dex */
public class c71 implements j61 {
    @Override // me.tvspark.j61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var, List<m61> list) {
        StringBuilder sb = new StringBuilder();
        for (m61 m61Var : list) {
            sb.append(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        return new m61(sb.toString());
    }

    @Override // me.tvspark.j61
    public String name() {
        return "concat";
    }
}
