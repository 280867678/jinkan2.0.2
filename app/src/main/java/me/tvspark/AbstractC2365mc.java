package me.tvspark;

/* renamed from: me.tvspark.mc */
/* loaded from: classes4.dex */
public interface AbstractC2365mc {
    public static final AbstractC2365mc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.mc$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2365mc {
        @Override // me.tvspark.AbstractC2365mc
        public AbstractC2328lc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            String str = c2245j3.Wwwwwwwwwwwww;
            if (str != null) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals("application/vnd.dvb.ait")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals("application/id3")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals("application/x-emsg")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals("application/x-scte35")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    return new C2218id();
                }
                if (c == 1) {
                    return new C2667uc();
                }
                if (c == 2) {
                    return new C2557rd();
                }
                if (c == 3) {
                    return new C2819yc();
                }
                if (c == 4) {
                    return new C2593sc();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }

        @Override // me.tvspark.AbstractC2365mc
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            String str = c2245j3.Wwwwwwwwwwwww;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }
    }

    AbstractC2328lc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);
}
