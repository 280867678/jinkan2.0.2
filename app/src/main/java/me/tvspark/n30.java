package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.internal.filter.RelationalOperator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import me.tvspark.f30;
import me.tvspark.s30;

/* loaded from: classes4.dex */
public class n30 {
    public static final Map<RelationalOperator, m30> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return !n30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(RelationalOperator.TSEQ).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30Var, s30Var2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!s30Var.getClass().equals(s30Var2.getClass())) {
                return false;
            }
            return n30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(RelationalOperator.EQ).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30Var, s30Var2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww == s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                s30Var2 = s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (s30Var2.Wwwwwwwwwwwwwwwwwwww()) {
                    return false;
                }
            }
            s30.Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (s30Var.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                s30Var = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (s30Var.Wwwwwwwwwwwwwwwwwwww()) {
                    return false;
                }
            }
            for (s30 s30Var3 : s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.contains(s30Var3)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!s30Var2.Wwwwwwwwwwwwwwwwwwwwwwww()) {
                return false;
            }
            int intValue = s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.intValue();
            if (s30Var.Wwwwwwwwwwwwwwwwwwwww()) {
                return s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.length() == intValue;
            } else if (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                return false;
            } else {
                s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? ((c50) ((s40) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww()) : -1) == intValue;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (s30Var2 != null) {
                throw new InvalidPathException("Expected predicate node");
            }
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return !n30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(RelationalOperator.IN).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30Var, s30Var2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return !n30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(RelationalOperator.EQ).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30Var, s30Var2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwww() || !s30Var2.Wwwwwwwwwwwwwwwwwwwwwwww()) ? s30Var.Wwwwwwwwwwwwwwwwwwwww() && s30Var2.Wwwwwwwwwwwwwwwwwwwww() && s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) < 0 : s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) < 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwww() || !s30Var2.Wwwwwwwwwwwwwwwwwwwwwwww()) ? s30Var.Wwwwwwwwwwwwwwwwwwwww() && s30Var2.Wwwwwwwwwwwwwwwwwwwww() && s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) <= 0 : s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) <= 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                s30Var2 = s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (s30Var2.Wwwwwwwwwwwwwwwwwwww()) {
                    return false;
                }
            }
            return s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.contains(s30Var);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwww() || !s30Var2.Wwwwwwwwwwwwwwwwwwwwwwww()) ? s30Var.Wwwwwwwwwwwwwwwwwwwww() && s30Var2.Wwwwwwwwwwwwwwwwwwwww() && s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) > 0 : s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) > 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwww() || !s30Var2.Wwwwwwwwwwwwwwwwwwwwwwww()) ? s30Var.Wwwwwwwwwwwwwwwwwwwww() && s30Var2.Wwwwwwwwwwwwwwwwwwwww() && s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) >= 0 : s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.compareTo(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww) >= 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwww() || s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwww() == s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwww();
            }
            throw new JsonPathException("Failed to evaluate exists expression");
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwwww() || !s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                return s30Var.equals(s30Var2);
            }
            s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                throw null;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                return true;
            }
            Object obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            if (obj != null) {
                if (obj.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwww())) {
                    return true;
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww == null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
            if (((java.lang.String) r4.Wwwwwwwwwwwwwwwwww()).length() != 0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
            if (((me.tvspark.c50) ((me.tvspark.s40) r6).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r4.Wwwwwwwwwwwwwwwwww()) == 0) goto L23;
         */
        @Override // me.tvspark.m30
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            boolean z;
            if (s30Var.Wwwwwwwwwwwwwwwwwwwww()) {
                return s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.isEmpty() == s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwww();
            } else if (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                return false;
            } else {
                s30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww() instanceof String) {
                    }
                    z = true;
                }
                return z == s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwww();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (s30Var.Wwwwwwwwwwwwwwwwwwwww() && s30Var2.Wwwwwwwwwwwwwwwwwwwww()) {
                s30.Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.contains(s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww);
            } else if (!s30Var.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                return false;
            } else {
                s30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww()) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww.contains(s30Var2);
                }
                return false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            s30.Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (s30Var.Wwwwwwwwwwwwwwwwwwwwwwwww()) {
                s30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww()) {
                    return true;
                }
                s30.Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                Iterator<s30> it = Wwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                while (it.hasNext()) {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
        hashMap.put(RelationalOperator.EXISTS, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.NE, new Wwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.TSNE, new Wwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.EQ, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.TSEQ, new Wwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.LT, new Wwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.LTE, new Wwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.GT, new Wwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.GTE, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.REGEX, new Wwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.SIZE, new Wwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.EMPTY, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.IN, new Wwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.NIN, new Wwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.ALL, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.CONTAINS, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.MATCHES, new Wwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.TYPE, new Wwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(RelationalOperator.SUBSETOF, new Wwwwwwwwwwwwwwwwww(null));
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwww implements m30 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.m30
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var, s30 s30Var2, f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Matcher matcher;
            if (!(s30Var.Wwwwwwwwwwwwwwwwwwwwww() ^ s30Var2.Wwwwwwwwwwwwwwwwwwwwww())) {
                return false;
            }
            if (s30Var.Wwwwwwwwwwwwwwwwwwwwww()) {
                s30.Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30Var2));
            } else {
                s30.Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = s30Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30Var));
            }
            return matcher.matches();
        }

        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s30 s30Var) {
            if (s30Var.Wwwwwwwwwwwwwwwwwwwww() || s30Var.Wwwwwwwwwwwwwwwwwwwwwwww()) {
                return s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwww;
            }
            return s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwww() ? s30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString() : "";
        }
    }
}
