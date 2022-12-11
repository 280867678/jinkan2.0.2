package me.tvspark;

import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class p40 {
    public p40 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public p40 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;

    public p40 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException("Current path token is a leaf");
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            boolean z = true;
            if (!(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) && (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                z = false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.valueOf(z);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue();
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Boolean bool = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null;
    }

    public abstract String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, Object obj, m40 m40Var) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "[", String.valueOf(i), "]");
        l30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww ? l30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, i) : l30.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i < 0) {
            i += ((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        try {
            if (((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                Object obj2 = ((List) obj).get(i);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, obj2);
                    return;
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, obj2, m40Var);
                    return;
                }
            }
            throw null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, m40 m40Var);

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj, m40 m40Var, List<String> list) {
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Object obj2 = null;
        if (list.size() == 1) {
            String str2 = list.get(0);
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "['", str2, "']");
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, obj, m40Var);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != b50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                obj2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if (!m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.DEFAULT_PATH_LEAF_TO_NULL)) {
                    if (!m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.SUPPRESS_EXCEPTIONS) && m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.REQUIRE_PROPERTIES)) {
                        throw new PathNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No results for path: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                    }
                    return;
                }
            } else if (((!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) && !m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.REQUIRE_PROPERTIES)) || m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.SUPPRESS_EXCEPTIONS)) {
                return;
            } else {
                throw new PathNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing property in path ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
            }
            l30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww ? l30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, str2) : l30.Wwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, obj2);
                return;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, obj2, m40Var);
                return;
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(", ", "'", (Iterable<? extends Object>) list));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        for (String str3 : list) {
            if (((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj).contains(str3)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, obj, m40Var);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == b50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    if (m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.DEFAULT_PATH_LEAF_TO_NULL)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    } else {
                        continue;
                    }
                }
            } else if (m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.DEFAULT_PATH_LEAF_TO_NULL)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            } else if (m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(Option.REQUIRE_PROPERTIES)) {
                throw new PathNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing property in path ", sb));
            }
            if (((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof Map)) {
                    throw new JsonPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setProperty operation cannot be used with ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getClass().getName() : "null");
                }
                ((Map) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).put(str3.toString(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                throw null;
            }
        }
        m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww ? l30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, list) : l30.Wwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj, m40 m40Var) {
        if (((c50) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            Map map = (Map) obj;
            return !map.containsKey(str) ? b50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : map.get(str);
        }
        throw null;
    }
}
