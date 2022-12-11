package me.tvspark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.antlr.p055v4.runtime.atn.Transition;
import org.eclipse.jetty.util.security.Constraint;

/* loaded from: classes4.dex */
public abstract class sy0 {
    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ly0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public final List<Transition> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(4);

    static {
        Collections.unmodifiableList(Arrays.asList("INVALID", Constraint.__BASIC_AUTH, "RULE_START", "BLOCK_START", "PLUS_BLOCK_START", "STAR_BLOCK_START", "TOKEN_START", "RULE_STOP", "BLOCK_END", "STAR_LOOP_BACK", "STAR_LOOP_ENTRY", "PLUS_LOOP_BACK", "LOOP_END"));
    }

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
    }

    public Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Transition transition) {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = transition.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != transition.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            System.err.format(Locale.getDefault(), "ATN state %d has both epsilon and non-epsilon transitions.\n", Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
        Iterator<Transition> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Transition next = it.next();
            if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == transition.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && ((next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null && transition.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null && next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().equals(transition.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) || (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && transition.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()))) {
                break;
            }
        }
        if (!z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(size, transition);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof sy0) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ((sy0) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        return String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
