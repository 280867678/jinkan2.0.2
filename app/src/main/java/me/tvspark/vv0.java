package me.tvspark;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.math.BigInteger;
import me.tvspark.uv0;
import net.minidev.json.parser.ParseException;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes4.dex */
public abstract class vv0 extends uv0 {
    public int Wwwwwwwwwwww;

    public vv0(int i) {
        super(i);
    }

    @Override // me.tvspark.uv0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ParseException, IOException {
        uv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == '\'') {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                boolean[] zArr = uv0.Wwwwwwwwwwwwwwwww;
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            }
            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        wv0 wv0Var = (wv0) this;
        int indexOf = wv0Var.Wwwwwwwwwww.indexOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
        if (indexOf != -1) {
            wv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wv0Var.Wwwwwwwwwww.substring(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1, indexOf);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.indexOf(92) == -1) {
                if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                    int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        char charAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i3);
                        if (charAt >= 0) {
                            if (charAt <= 31) {
                                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i3, 0, Character.valueOf(charAt));
                            }
                            if (charAt == 127 && this.Wwwwwwwwwwwwwwwwww) {
                                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i3, 0, Character.valueOf(charAt));
                            }
                        }
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = indexOf;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            while (true) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                char c2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                char c3 = '\"';
                if (c2 == '\"' || c2 == '\'') {
                    char c4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c == c4) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c4);
                } else if (c2 != '\\') {
                    if (c2 != 127) {
                        switch (c2) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case '\b':
                            case '\t':
                            case '\n':
                            case 11:
                            case '\f':
                            case '\r':
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                                if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                                    throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                }
                                continue;
                            case 26:
                                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, 3, null);
                            default:
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                c3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                break;
                        }
                    } else if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                        if (this.Wwwwwwwwwwwwwwwwww) {
                            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        c3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        continue;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c3);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    char c5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c5 != '\"') {
                        if (c5 != '\'') {
                            c3 = '/';
                            if (c5 != '/') {
                                if (c5 != '\\') {
                                    if (c5 == 'b') {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        c3 = '\b';
                                    } else if (c5 == 'f') {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        c3 = '\f';
                                    } else if (c5 == 'n') {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        c3 = '\n';
                                    } else if (c5 != 'r') {
                                        if (c5 == 'x') {
                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            i = 2;
                                        } else if (c5 == 't') {
                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            c3 = '\t';
                                        } else if (c5 == 'u') {
                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            i = 4;
                                        }
                                        c3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                                    } else {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        c3 = '\r';
                                    }
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c3);
                                } else {
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('\\');
                                }
                            }
                        } else {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExtendedMessageFormat.QUOTE);
                        }
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c3);
                }
            }
        } else {
            throw new ParseException(this.Wwwwwwwwwwww, 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d3  */
    @Override // me.tvspark.uv0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean[] zArr) throws ParseException, IOException {
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        char c = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z3 = true;
        if (c == '.' || c == 'E' || c == 'e') {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == '.') {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            char c2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2 == 'E' || c2 == 'e') {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('E');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                char c3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c3 != '+' && c3 != '-' && (c3 < '0' || c3 > '9')) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                char c4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c4 >= 0 && c4 < '~' && !zArr[c4] && c4 != 26) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                char c5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c5 >= 0 && c5 < '~' && !zArr[c5] && c5 != 26) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        char c6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c6 >= 0 && c6 < '~' && !zArr[c6] && c6 != 26) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = str.length();
        if (str.charAt(0) == '-') {
            i = 20;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && length >= 3 && str.charAt(1) == '0') {
                throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6, str);
            }
            i2 = 1;
            z = true;
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && length >= 2 && str.charAt(0) == '0') {
            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6, str);
        } else {
            i = 19;
            i2 = 0;
            z = false;
        }
        if (length < i) {
            i3 = length;
            z2 = false;
        } else if (length > i) {
            return new BigInteger(str, 10);
        } else {
            i3 = length - 1;
            z2 = true;
        }
        long j = 0;
        while (i2 < i3) {
            j = (j * 10) + ('0' - str.charAt(i2));
            i2++;
        }
        if (z2) {
            int i6 = (j > JsonReader.MIN_INCOMPLETE_INTEGER ? 1 : (j == JsonReader.MIN_INCOMPLETE_INTEGER ? 0 : -1));
            if (i6 <= 0) {
                if (i6 >= 0) {
                    char charAt = str.charAt(i2);
                    if (!z) {
                    }
                }
                if (!z3) {
                    return new BigInteger(str, 10);
                }
                j = (j * 10) + ('0' - str.charAt(i2));
            }
            z3 = false;
            if (!z3) {
            }
        }
        if (!z) {
            long j2 = -j;
            if (!this.Wwwwwwwwwwwwwwwwwww || j2 > 2147483647L) {
                return Long.valueOf(j2);
            }
            i4 = (int) j2;
        } else if (!this.Wwwwwwwwwwwwwwwwwww || j < -2147483648L) {
            return Long.valueOf(j);
        } else {
            i4 = (int) j;
        }
        return Integer.valueOf(i4);
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);
}
