package me.tvspark;

import com.jayway.jsonpath.EvaluationListener;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.internal.EvaluationAbortException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class m40 implements i30 {
    public static final EvaluationAbortException Wwwwwwwwwwwwwwwwwwwwwwwww = new EvaluationAbortException();
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final k30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final b30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HashMap<k30, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public final List<l30> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements EvaluationListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, Object obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        }
    }

    public m40(k30 k30Var, Object obj, b30 b30Var, boolean z) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k30Var, "path can not be null", new Object[0]);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "root can not be null", new Object[0]);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b30Var, "configuration can not be null", new Object[0]);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k30Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b30Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((c50) b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((c50) b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(l30Var);
        }
        ((c50) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, obj);
        ((c50) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww++;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            for (EvaluationListener evaluationListener : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (EvaluationListener.EvaluationContinuation.ABORT == evaluationListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, obj, null))) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
        }
    }

    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        T t;
        if (((l40) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((c50) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 0) {
                    b50 b50Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - 1;
                    if (((c50) b50Var) == null) {
                        throw null;
                    }
                    t = (T) ((List) obj).get(i);
                } else {
                    t = null;
                }
                if (t != null && z && ((c50) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                    throw null;
                }
                return t;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No results for path: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            throw new PathNotFoundException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        return (T) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
