package me.tvspark;

import java.nio.charset.StandardCharsets;
import org.antlr.p055v4.runtime.CodePointBuffer;

/* loaded from: classes4.dex */
public abstract class tx0 implements sx0 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends tx0 {
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, byte[] bArr, int i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(i, i2, str, null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        }

        @Override // me.tvspark.yx0
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            byte b;
            int signum = Integer.signum(i);
            if (signum == -1) {
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
                if (i2 < 0) {
                    return -1;
                }
                b = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
            } else if (signum == 0) {
                return 0;
            } else {
                if (signum != 1) {
                    throw new UnsupportedOperationException("Not reached");
                }
                int i3 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i) - 1;
                if (i3 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return -1;
                }
                b = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
            }
            return b & 255;
        }

        @Override // me.tvspark.sx0
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01 z01Var) {
            return new String(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Math.min(z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1), Math.min((z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), StandardCharsets.ISO_8859_1);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends tx0 {
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, int[] iArr, int i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(i, i2, str, null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        }

        @Override // me.tvspark.yx0
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int signum = Integer.signum(i);
            if (signum == -1) {
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
                if (i2 >= 0) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                }
                return -1;
            } else if (signum == 0) {
                return 0;
            } else {
                if (signum != 1) {
                    throw new UnsupportedOperationException("Not reached");
                }
                int i3 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i) - 1;
                if (i3 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                }
                return -1;
            }
        }

        @Override // me.tvspark.sx0
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01 z01Var) {
            return new String(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Math.min(z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1), Math.min((z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends tx0 {
        public final char[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, char[] cArr, int i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(i, i2, str, null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cArr;
        }

        @Override // me.tvspark.yx0
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            char c;
            int signum = Integer.signum(i);
            if (signum == -1) {
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
                if (i2 < 0) {
                    return -1;
                }
                c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
            } else if (signum == 0) {
                return 0;
            } else {
                if (signum != 1) {
                    throw new UnsupportedOperationException("Not reached");
                }
                int i3 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i) - 1;
                if (i3 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return -1;
                }
                c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
            }
            return c & 65535;
        }

        @Override // me.tvspark.sx0
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01 z01Var) {
            return new String(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Math.min(z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1), Math.min((z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[CodePointBuffer.Type.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                CodePointBuffer.Type type = CodePointBuffer.Type.BYTE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                CodePointBuffer.Type type2 = CodePointBuffer.Type.CHAR;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                CodePointBuffer.Type type3 = CodePointBuffer.Type.INT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ tx0(int i, int i2, String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // me.tvspark.yx0
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
    }

    @Override // me.tvspark.yx0
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i - i2 == 0) {
            throw new IllegalStateException("cannot consume EOF");
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
    }

    @Override // me.tvspark.yx0
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.yx0
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.yx0
    public final int mark() {
        return -1;
    }

    @Override // me.tvspark.yx0
    public final int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final String toString() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1));
    }
}
