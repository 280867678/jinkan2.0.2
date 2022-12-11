package me.tvspark;

import java.util.Arrays;
import org.eclipse.jetty.util.B64Code;

/* renamed from: me.tvspark.ot */
/* loaded from: classes4.dex */
public final class C2456ot {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.ot$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2419nt c2419nt) {
        }
    }

    public /* synthetic */ C2456ot(String str, C2419nt c2419nt) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (str != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            return;
        }
        throw null;
    }

    public C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, double d) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, String.valueOf(d));
        return this;
    }

    public C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, String.valueOf(i));
        return this;
    }

    public C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, String.valueOf(j));
        return this;
    }

    public final C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        if (str != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            return this;
        }
        throw null;
    }

    public String toString() {
        boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        sb.append('{');
        String str = "";
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null; wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Object obj = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!z || obj != null) {
                sb.append(str);
                String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append(B64Code.__pad);
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        return this;
    }
}
