package me.tvspark;

import com.alibaba.fastjson.parser.JSONLexer;
import java.io.IOException;
import java.math.BigDecimal;
import net.minidev.json.parser.ParseException;

/* loaded from: classes4.dex */
public abstract class uv0 {
    public static boolean[] Wwwwwwwwwwwww;
    public static boolean[] Wwwwwwwwwwwwww;
    public static boolean[] Wwwwwwwwwwwwwww;
    public static boolean[] Wwwwwwwwwwwwwwww;
    public static boolean[] Wwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        public char[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new char[i];
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            char[] cArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (cArr.length <= i) {
                char[] cArr2 = new char[(cArr.length * 2) + 1];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cArr2;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = c;
        }

        public String toString() {
            return new String(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
        }
    }

    static {
        boolean[] zArr = new boolean[126];
        Wwwwwwwwwwwwwwwww = zArr;
        boolean[] zArr2 = new boolean[126];
        Wwwwwwwwwwwwwwww = zArr2;
        boolean[] zArr3 = new boolean[126];
        Wwwwwwwwwwwwwww = zArr3;
        boolean[] zArr4 = new boolean[126];
        Wwwwwwwwwwwwww = zArr4;
        boolean[] zArr5 = new boolean[126];
        Wwwwwwwwwwwww = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public uv0(int i) {
        boolean z = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 4) > 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = (i & 2) > 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = (i & 1) > 0;
        this.Wwwwwwwwwwwwwwwwwwwww = (i & 8) > 0;
        this.Wwwwwwwwwwwwwwwwwww = (i & 16) > 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 32) > 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (i & 64) > 0;
        this.Wwwwwwwwwwwwwwwwwwww = (i & 128) > 0;
        this.Wwwwwwwwwwwwwwwwwwwwwww = (i & 768) != 768;
        this.Wwwwwwwwwwwwwwwwwwwwww = (i & 512) == 0;
        this.Wwwwwwwwwwwwwwwwww = (i & 1024) > 0 ? true : z;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        while (true) {
            char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c > ' ' || c == 26) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        while (true) {
            char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c < '0' || c > '9') {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ParseException, IOException;

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0101, code lost:
        throw new net.minidev.json.parser.ParseException(r13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, java.lang.Character.valueOf(r13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0<T> qw0Var) throws ParseException, IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == '{') {
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            boolean z = false;
            while (true) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
                    if (c != ',') {
                        if (c == ':' || c == '[' || c == ']' || c == '{') {
                            break;
                        } else if (c != '}') {
                            if (c == '\"' || c == '\'') {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else {
                                boolean[] zArr = Wwwwwwwwwwwwwww;
                                vv0 vv0Var = (vv0) this;
                                int i = vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                                vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                            }
                            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            char c2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (c2 != ':') {
                                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                                if (c2 != 26) {
                                    throw new ParseException(i2, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                }
                                throw new ParseException(i2, 3, null);
                            }
                            wv0 wv0Var = (wv0) this;
                            int i3 = wv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                            wv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                            if (i3 < wv0Var.Wwwwwwwwwwww) {
                                wv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wv0Var.Wwwwwwwwwww.charAt(i3);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                                qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0Var, Wwwwwwwwwwwwww));
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                char c3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (c3 == '}') {
                                    break;
                                } else if (c3 == 26) {
                                    throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, 3, null);
                                } else {
                                    if (c3 != ',') {
                                        throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, 1, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                    }
                                }
                            } else {
                                wv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = JSONLexer.EOI;
                                throw new ParseException(wv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, 3, "EOF");
                            }
                        } else if (z && !this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                    } else if (z && !this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                        throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    z = true;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        throw new RuntimeException("Internal Error");
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    public Number Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ParseException {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return !this.Wwwwwwwwwwwwwwwwwwww ? Float.valueOf(Float.parseFloat(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() > 18 ? new BigDecimal(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : Double.valueOf(Double.parseDouble(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ca, code lost:
        throw new net.minidev.json.parser.ParseException(r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, java.lang.Character.valueOf(r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x010f, code lost:
        r0 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(me.tvspark.uv0.Wwwwwwwwwwwww);
        r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0<T> qw0Var) throws ParseException, IOException {
        Object valueOf;
        while (true) {
            char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c != '\t' && c != '\n') {
                switch (c) {
                    case '\r':
                    case ' ':
                        break;
                    case '\"':
                    case '\'':
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        break;
                    case '-':
                        break;
                    case 'N':
                        boolean[] zArr = Wwwwwwwwwwwww;
                        vv0 vv0Var = (vv0) this;
                        int i = vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                        vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        if ("NaN".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            valueOf = Float.valueOf(Float.NaN);
                            break;
                        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        break;
                    case '[':
                        return (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0Var);
                    case ']':
                    case '}':
                        break;
                    case 'f':
                        boolean[] zArr2 = Wwwwwwwwwwwww;
                        vv0 vv0Var2 = (vv0) this;
                        int i2 = vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr2);
                        vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if ("false".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            valueOf = Boolean.FALSE;
                            break;
                        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        break;
                    case 'n':
                        boolean[] zArr3 = Wwwwwwwwwwwww;
                        vv0 vv0Var3 = (vv0) this;
                        int i3 = vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr3);
                        vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if ("null".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            return null;
                        }
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        break;
                    case 't':
                        boolean[] zArr4 = Wwwwwwwwwwwww;
                        vv0 vv0Var4 = (vv0) this;
                        int i4 = vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr4);
                        vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if ("true".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            valueOf = Boolean.TRUE;
                            break;
                        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        break;
                    case '{':
                        return (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0Var);
                    default:
                        switch (c) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            case ':':
                                break;
                            default:
                                boolean[] zArr5 = Wwwwwwwwwwwww;
                                vv0 vv0Var5 = (vv0) this;
                                int i5 = vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr5);
                                vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                                break;
                        }
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        valueOf = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean[] zArr) throws IOException {
        while (true) {
            char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c != 26) {
                if (c >= 0 && c < '~' && zArr[c]) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                return;
            }
        }
    }

    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws ParseException, IOException {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 * 16;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c > '9' || c < '0') {
                char c2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2 > 'F' || c2 < 'A') {
                    char c3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c3 < 'a' || c3 > 'f') {
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 26) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 3, "EOF");
                    }
                    i2 = c3 - 'a';
                } else {
                    i2 = c2 - 'A';
                }
                i3 = i2 + 10;
            } else {
                i3 = c - '0';
            }
            i4 = i3 + i6;
        }
        return (char) i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0043, code lost:
        if (r5 == ':') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0047, code lost:
        if (r5 == ']') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
        if (r5 == '}') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
        throw new net.minidev.json.parser.ParseException(r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, java.lang.Character.valueOf(r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0057, code lost:
        if (r4 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005b, code lost:
        if (r7.Wwwwwwwwwwwwwwwwwwwwwwww == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006b, code lost:
        throw new net.minidev.json.parser.ParseException(r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, java.lang.Character.valueOf(r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x006c, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0073, code lost:
        return r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0<T> qw0Var) throws ParseException, IOException {
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == '[') {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ',' && !this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            while (true) {
                boolean z = false;
                while (true) {
                    char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c != '\t' && c != '\n' && c != '\r') {
                        if (c == 26) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, 3, "EOF");
                        }
                        if (c != ' ') {
                            if (c != ',') {
                                break;
                            } else if (z && !this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                z = true;
                            }
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0Var, Wwwwwwwwwwwwwwww));
            }
        } else {
            throw new RuntimeException("Internal Error");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c8, code lost:
        throw new net.minidev.json.parser.ParseException(r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, java.lang.Character.valueOf(r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0115, code lost:
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0<?> qw0Var, boolean[] zArr) throws ParseException, IOException {
        while (true) {
            char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c != '\t' && c != '\n') {
                switch (c) {
                    case '\r':
                    case ' ':
                        break;
                    case '\"':
                    case '\'':
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    case '-':
                        break;
                    case 'N':
                        vv0 vv0Var = (vv0) this;
                        int i = vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                        vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, vv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        if ("NaN".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            return Float.valueOf(Float.NaN);
                        }
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    case '[':
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    case ']':
                    case '}':
                        break;
                    case 'f':
                        vv0 vv0Var2 = (vv0) this;
                        int i2 = vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                        vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, vv0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if ("false".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            return Boolean.FALSE;
                        }
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    case 'n':
                        vv0 vv0Var3 = (vv0) this;
                        int i3 = vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                        vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, vv0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if ("null".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            return null;
                        }
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    case 't':
                        vv0 vv0Var4 = (vv0) this;
                        int i4 = vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                        vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, vv0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if ("true".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            return Boolean.TRUE;
                        }
                        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    case '{':
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    default:
                        switch (c) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            case ':':
                                break;
                            default:
                                vv0 vv0Var5 = (vv0) this;
                                int i5 = vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                                vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, vv0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public abstract Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean[] zArr) throws ParseException, IOException;

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ParseException {
        int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
        if (length == 1) {
            return;
        }
        if (length == 2) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("00")) {
                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return;
        }
        char charAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(0);
        char charAt2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(1);
        if (charAt != '-') {
            if (charAt == '0' && charAt2 >= '0' && charAt2 <= '9') {
                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return;
        }
        char charAt3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(2);
        if (charAt2 == '0' && charAt3 >= '0' && charAt3 <= '9') {
            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
