package me.tvspark;

import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class y40 extends p40 {
    @Override // me.tvspark.p40
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.p40
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return "[*]";
    }

    @Override // me.tvspark.p40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, m40 m40Var) {
        b50 b50Var = m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (((c50) b50Var) != null) {
            c50 c50Var = (c50) b50Var;
            if (obj instanceof Map) {
                Iterator it = c50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj).iterator();
                while (it.hasNext()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj, m40Var, Arrays.asList((String) it.next()));
                }
                return;
            } else if (c50Var != null) {
                if (!(obj instanceof List)) {
                    return;
                }
                for (int i = 0; i < ((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj); i++) {
                    try {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, obj, m40Var);
                    } catch (PathNotFoundException e) {
                        if (m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.REQUIRE_PROPERTIES)) {
                            throw e;
                        }
                    }
                }
                return;
            } else {
                throw null;
            }
        }
        throw null;
    }
}
