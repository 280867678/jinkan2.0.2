package me.tvspark;

import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPathException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minidev.json.parser.ParseException;

/* loaded from: classes4.dex */
public class c50 implements b50 {
    public final qw0<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    public c50() {
        qw0<lv0> qw0Var = qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qw0Var;
    }

    public Iterable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (obj instanceof List) {
            return (Iterable) obj;
        }
        throw new JsonPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot iterate over ", obj) != null ? obj.getClass().getName() : "null");
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (obj instanceof List) {
            return ((List) obj).size();
        }
        if (obj instanceof Map) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj).size();
        }
        if (obj instanceof String) {
            return ((String) obj).length();
        }
        throw new JsonPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("length operation cannot be applied to ", obj) != null ? obj.getClass().getName() : "null");
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public Collection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (!(obj instanceof List)) {
            return ((Map) obj).keySet();
        }
        throw new UnsupportedOperationException();
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            tv0 tv0Var = new tv0(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            qw0<?> qw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (tv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                tv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new wv0(tv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return tv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, qw0Var);
        } catch (ParseException e) {
            throw new InvalidJsonException(e);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i == list.size()) {
                list.add(obj2);
                return;
            } else {
                list.set(i, obj2);
                return;
            }
        }
        throw new UnsupportedOperationException();
    }
}
