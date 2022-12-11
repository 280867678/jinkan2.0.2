package me.tvspark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.antlr.p055v4.runtime.Recognizer;

/* loaded from: classes4.dex */
public abstract class g01 {
    public static final g01 Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends g01 {
        public final boolean Wwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwww = false;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // me.tvspark.g01
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
            boolean z = this.Wwwwwwwwwwwwwwwwwwwww;
            if (recognizer != null) {
                return true;
            }
            throw null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        }

        public int hashCode() {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.Wwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwww ? 1 : 0), 3);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("{");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, "}?");
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends g01 implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public final int Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // me.tvspark.g01
        public g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
            if (recognizer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dy0Var, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                return g01.Wwwwwwwwwwwwwwwwwwwwwwww;
            }
            return null;
        }

        @Override // me.tvspark.g01
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
            return recognizer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dy0Var, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.lang.Comparable
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwwww - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            return this == obj || this.Wwwwwwwwwwwwwwwwwwwwwww == ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwww;
        }

        public int hashCode() {
            return 31 + this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        public String toString() {
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("{"), this.Wwwwwwwwwwwwwwwwwwwwwww, ">=prec}?");
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends g01 {
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final g01[] Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01 g01Var, g01 g01Var2) {
            HashSet hashSet = new HashSet();
            if (g01Var instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                hashSet.addAll(Arrays.asList(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) g01Var).Wwwwwwwwwwwwwwwwwwwwwww));
            } else {
                hashSet.add(g01Var);
            }
            if (g01Var2 instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                hashSet.addAll(Arrays.asList(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) g01Var2).Wwwwwwwwwwwwwwwwwwwwwww));
            } else {
                hashSet.add(g01Var2);
            }
            List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashSet);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                hashSet.add((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Collections.max(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = (g01[]) hashSet.toArray(new g01[hashSet.size()]);
        }

        @Override // me.tvspark.g01
        public g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
            ArrayList arrayList = new ArrayList();
            g01[] g01VarArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int length = g01VarArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i >= length) {
                    if (i2 == 0) {
                        return this;
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    g01 g01Var = (g01) arrayList.get(0);
                    while (i3 < arrayList.size()) {
                        g01Var = g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01Var, (g01) arrayList.get(i3));
                        i3++;
                    }
                    return g01Var;
                }
                g01 g01Var2 = g01VarArr[i];
                g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recognizer, dy0Var);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == g01Var2) {
                    i3 = 0;
                }
                i2 |= i3;
                g01 g01Var3 = g01.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == g01Var3) {
                    return g01Var3;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                i++;
            }
        }

        @Override // me.tvspark.g01
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
            for (g01 g01Var : this.Wwwwwwwwwwwwwwwwwwwwwww) {
                if (g01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recognizer, dy0Var)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }

        public int hashCode() {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.hashCode());
        }

        public String toString() {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(this.Wwwwwwwwwwwwwwwwwwwwwww).iterator(), "||");
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final g01[] Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01 g01Var, g01 g01Var2) {
            HashSet hashSet = new HashSet();
            if (g01Var instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                hashSet.addAll(Arrays.asList(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) g01Var).Wwwwwwwwwwwwwwwwwwwwwww));
            } else {
                hashSet.add(g01Var);
            }
            if (g01Var2 instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                hashSet.addAll(Arrays.asList(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) g01Var2).Wwwwwwwwwwwwwwwwwwwwwww));
            } else {
                hashSet.add(g01Var2);
            }
            List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashSet);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                hashSet.add((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Collections.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = (g01[]) hashSet.toArray(new g01[hashSet.size()]);
        }

        @Override // me.tvspark.g01
        public g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
            ArrayList arrayList = new ArrayList();
            g01[] g01VarArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int length = g01VarArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i >= length) {
                    if (i2 == 0) {
                        return this;
                    }
                    if (arrayList.isEmpty()) {
                        return g01.Wwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    g01 g01Var = (g01) arrayList.get(0);
                    while (i3 < arrayList.size()) {
                        g01Var = g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01Var, (g01) arrayList.get(i3));
                        i3++;
                    }
                    return g01Var;
                }
                g01 g01Var2 = g01VarArr[i];
                g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recognizer, dy0Var);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == g01Var2) {
                    i3 = 0;
                }
                i2 |= i3;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return null;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != g01.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                i++;
            }
        }

        @Override // me.tvspark.g01
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
            for (g01 g01Var : this.Wwwwwwwwwwwwwwwwwwwwwww) {
                if (!g01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recognizer, dy0Var)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwww, ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }

        public int hashCode() {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.hashCode());
        }

        public String toString() {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.asList(this.Wwwwwwwwwwwwwwwwwwwwwww).iterator(), "&&");
        }
    }

    public static g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01 g01Var, g01 g01Var2) {
        if (g01Var == null) {
            return g01Var2;
        }
        if (g01Var2 == null) {
            return g01Var;
        }
        g01 g01Var3 = Wwwwwwwwwwwwwwwwwwwwwwww;
        if (g01Var == g01Var3 || g01Var2 == g01Var3) {
            return Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01Var, g01Var2);
        g01[] g01VarArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        return g01VarArr.length == 1 ? g01VarArr[0] : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection) {
        Iterator it = collection.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            g01 g01Var = (g01) it.next();
            if (g01Var instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) g01Var);
                it.remove();
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    public static g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01 g01Var, g01 g01Var2) {
        g01 g01Var3;
        if (g01Var == null || g01Var == (g01Var3 = Wwwwwwwwwwwwwwwwwwwwwwww)) {
            return g01Var2;
        }
        if (g01Var2 == null || g01Var2 == g01Var3) {
            return g01Var;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01Var, g01Var2);
        g01[] g01VarArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        return g01VarArr.length == 1 ? g01VarArr[0] : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var) {
        return this;
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Recognizer<?, ?> recognizer, dy0 dy0Var);
}
