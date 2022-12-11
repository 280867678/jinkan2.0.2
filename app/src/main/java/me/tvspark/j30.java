package me.tvspark;

import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class j30 implements c30 {
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final b30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        LoggerFactory.getLogger(j30.class);
    }

    public j30(Object obj, b30 b30Var) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "json can not be null", new Object[0]);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b30Var, "configuration can not be null", new Object[0]);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b30Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e30 e30Var) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e30Var, "path can not be null", new Object[0]);
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        b30 b30Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Option.AS_PATH_LIST);
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Option.ALWAYS_RETURN_LIST);
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Option.SUPPRESS_EXCEPTIONS);
        try {
            if (((l40) e30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof n40) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    return (T) ((m40) ((l40) e30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj, b30Var)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                }
                throw new JsonPathException("Options " + Option.AS_PATH_LIST + " and " + Option.ALWAYS_RETURN_LIST + " are not allowed when using path functions!");
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                m40 m40Var = (m40) ((l40) e30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj, b30Var);
                if (m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    return (T) m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                throw new PathNotFoundException("No results for path: " + m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                T t = (T) ((m40) ((l40) e30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj, b30Var)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 || !((l40) e30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return t;
                }
                T t2 = (T) ((c50) b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ((c50) b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t2, 0, t);
                return t2;
            }
        } catch (RuntimeException e) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                throw e;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 || !((l40) e30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return (T) ((c50) b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return null;
        }
    }

    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, f30... f30VarArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "path can not be null or empty", new Object[0]);
        a50 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String trim = str.trim();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim, new LinkedList(Arrays.asList(f30VarArr)).toString());
        e30 e30Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (e30Var != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        if (e30Var != null) {
            return (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e30Var);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim, "json can not be null or empty", new Object[0]);
        e30 e30Var2 = new e30(trim, f30VarArr);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, e30Var2) != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addFirst(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            } finally {
            }
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Map<String, e30> map = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lock();
            try {
                String removeLast = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeLast();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unlock();
                map.remove(removeLast);
            } finally {
            }
        }
        return (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e30Var2);
    }
}
