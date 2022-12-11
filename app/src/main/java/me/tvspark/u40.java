package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.PathNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class u40 extends p40 {
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public u40(List<String> list, char c) {
        if (!list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Character.toString(c);
            return;
        }
        throw new InvalidPathException("Empty properties");
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 1;
    }

    @Override // me.tvspark.p40
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.p40
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(",", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Iterable<? extends Object>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // me.tvspark.p40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, m40 m40Var) {
        if (((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            if (!(obj instanceof Map)) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                throw new PathNotFoundException(String.format("Expected to find an object with property %s in path %s but found '%s'. This is not a json object according to the JsonProvider: '%s'.", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), str, obj == null ? "null" : obj.getClass().getName(), m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClass().getName()));
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwww() || Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj, m40Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            } else {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(null);
                for (String str2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    arrayList.set(0, str2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, obj, m40Var, arrayList);
                }
                return;
            }
        }
        throw null;
    }
}
