package me.tvspark;

import com.arialyy.aria.core.command.NormalCmdFactory;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import org.apache.http.message.BasicHeaderValueParser;
import org.mozilla.javascript.Token;

/* loaded from: classes4.dex */
public class m51 extends l51 {
    public int Kkkkkk;
    public int Kkkkkkk;
    public k51 Kkkkkkkk;
    public k51 Kkkkkkkkk;
    public k51 Kkkkkkkkkk;
    public final int Kkkkkkkkkkk;
    public int Kkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkk;
    public y41 Kkkkkkkkkkkkkk;
    public x41 Kkkkkkkkkkkkkkk;
    public x41 Kkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkk;
    public z41 Kkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkk;
    public z41 Kkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkk;
    public z41 Kkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkk;
    public z41 Kkkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public i51 Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public i51 Www;
    public int Wwww;
    public int[] Wwwww;
    public int[] Wwwwww;
    public int Wwwwwww;
    public z41 Wwwwwwww;
    public int Wwwwwwwww;
    public int Wwwwwwwwww;
    public int Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public z41 Wwwwwwwwwwwww = new z41();
    public y41 Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public x41[] Wwwwwwwwwwwwwwww;
    public x41[] Wwwwwwwwwwwwwwwww;
    public x41 Wwwwwwwwwwwwwwwwww;
    public x41 Wwwwwwwwwwwwwwwwwww;
    public x41 Wwwwwwwwwwwwwwwwwwww;
    public x41 Wwwwwwwwwwwwwwwwwwwww;
    public z41 Wwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final c51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public m51(c51 c51Var, int i, String str, String str2, String str3, String[] strArr, boolean z, boolean z2) {
        super(327680);
        if (c51Var.Kkkkkkkkkkkkkkkkkkkkkkkk == null) {
            c51Var.Kkkkkkkkkkkkkkkkkkkkkkkk = this;
        } else {
            c51Var.Kkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
        }
        c51Var.Kkkkkkkkkkkkkkkkkkkkkkk = this;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if ("<init>".equals(str)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 524288;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = length;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new int[length];
            for (int i3 = 0; i3 < this.Wwwwwwwwwwwwwwwwwwwwwwww; i3++) {
                this.Wwwwwwwwwwwwwwwwwwwwwww[i3] = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr[i3]);
            }
        }
        this.Kkkkkkkkkkk = !z2 ? z ? 1 : 2 : i2;
        if (z || z2) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) >> 2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 8) != 0 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            k51 k51Var = new k51();
            this.Kkkkkkkkkk = k51Var;
            k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 8;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var);
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = i2 - i;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i < iArr[i4] && iArr[i4] <= i2) {
                i3 += iArr2[i4];
            } else if (i2 < iArr[i4] && iArr[i4] <= i) {
                i3 -= iArr2[i4];
            }
        }
        return i3;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int[] iArr2, k51 k51Var) {
        if ((k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 4) == 0) {
            k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, iArr2, 0, k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 4;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        char c;
        z41 z41Var;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (i < i2) {
            int i3 = this.Wwwww[i];
            int i4 = (-268435456) & i3;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                int i6 = i3 & 267386880;
                if (i6 == 24117248) {
                    z41Var = this.Wwwwwwww;
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7);
                    c51 c51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwww[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (i6 != 25165824) {
                    this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                    i++;
                } else {
                    z41Var = this.Wwwwwwww;
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                int i7 = i4 >> 28;
                while (true) {
                    int i8 = i7 - 1;
                    if (i7 > 0) {
                        stringBuffer.append('[');
                        i7 = i8;
                    } else {
                        if ((i3 & 267386880) == 24117248) {
                            stringBuffer.append('L');
                            stringBuffer.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww[i3 & 1048575].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            c = BasicHeaderValueParser.PARAM_DELIMITER;
                        } else {
                            int i9 = i3 & 15;
                            if (i9 == 1) {
                                c = 'I';
                            } else if (i9 == 2) {
                                c = 'F';
                            } else if (i9 != 3) {
                                switch (i9) {
                                    case 9:
                                        c = 'Z';
                                        break;
                                    case 10:
                                        c = 'B';
                                        break;
                                    case 11:
                                        c = 'C';
                                        break;
                                    case 12:
                                        c = 'S';
                                        break;
                                    default:
                                        c = 'J';
                                        break;
                                }
                            } else {
                                c = 'D';
                            }
                        }
                        stringBuffer.append(c);
                        z41Var = this.Wwwwwwww;
                        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer.toString());
                    }
                }
            }
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            i++;
        }
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, (c51) null, (j51) null);
            } else if (i == 169) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 256;
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkk;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                int i3 = this.Kkkkkkk + g51.Wwwwwwwwwwwwwwwwwwwwwwwwww[i];
                if (i3 > this.Kkkkkk) {
                    this.Kkkkkk = i3;
                }
                this.Kkkkkkk = i3;
            }
        }
        if (this.Kkkkkkkkkkk != 2) {
            int i4 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i4 > this.Wwwwwwwwwww) {
                this.Wwwwwwwwwww = i4;
            }
        }
        if (i2 >= 4 || i == 169) {
            z41 z41Var = this.Wwwwwwwwwwwww;
            if (i2 >= 256) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(196);
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            } else {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            }
        } else {
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        }
        if (i < 54 || this.Kkkkkkkkkkk != 0 || this.Wwww <= 0) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new k51());
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 1862
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: me.tvspark.m51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int, int):void");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, k51 k51Var) {
        e51 e51Var = new e51();
        e51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        e51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k51Var;
        k51 k51Var2 = this.Kkkkkkkk;
        e51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwww;
        k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwww = e51Var;
    }

    @Override // me.tvspark.l51
    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, String str, boolean z) {
        z41 z41Var = new z41();
        x41.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, p51Var, z41Var);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        x41 x41Var = new x41(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, z41Var, z41Var, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 2);
        if (z) {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = x41Var;
        } else {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwww = x41Var;
        }
        return x41Var;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkk == 0) {
            k51 k51Var = new k51();
            g51 g51Var = new g51();
            k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = g51Var;
            g51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k51Var;
            z41 z41Var = this.Wwwwwwwwwwwww;
            k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww = k51Var;
            this.Kkkkkkkkk = k51Var;
        } else {
            this.Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkk;
        }
        this.Kkkkkkkk = null;
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, (c51) null, (j51) null);
            } else if (i != 188) {
                int i3 = this.Kkkkkkk + 1;
                if (i3 > this.Kkkkkk) {
                    this.Kkkkkk = i3;
                }
                this.Kkkkkkk = i3;
            }
        }
        if (i == 17) {
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        } else {
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        }
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, k51 k51Var) {
        if (this.Kkkkkkkkkkkkkkkkkk == null) {
            this.Kkkkkkkkkkkkkkkkkk = new z41();
        }
        this.Kkkkkkkkkkkkkkkkkkk++;
        this.Kkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Kkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        z41 z41Var;
        int i;
        if (obj instanceof String) {
            z41Var = this.Wwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7);
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) obj);
        } else if (obj instanceof Integer) {
            this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) obj).intValue());
            return;
        } else {
            z41Var = this.Wwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
            i = ((k51) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.Wwwww;
        if (iArr == null || iArr.length < i4) {
            this.Wwwww = new int[i4];
        }
        int[] iArr2 = this.Wwwww;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    @Override // me.tvspark.l51
    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z) {
        z41 z41Var = new z41();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.Wwwwwwwwwwwwwww = Math.max(this.Wwwwwwwwwwwwwww, i + 1);
            return new x41(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, z41Var, null, 0);
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        x41 x41Var = new x41(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, z41Var, z41Var, 2);
        if (z) {
            if (this.Wwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwww = new x41[o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).length];
            }
            x41[] x41VarArr = this.Wwwwwwwwwwwwwwwww;
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = x41VarArr[i];
            x41VarArr[i] = x41Var;
        } else {
            if (this.Wwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwww = new x41[o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww).length];
            }
            x41[] x41VarArr2 = this.Wwwwwwwwwwwwwwww;
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = x41VarArr2[i];
            x41VarArr2[i] = x41Var;
        }
        return x41Var;
    }

    @Override // me.tvspark.l51
    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, String str, boolean z) {
        z41 z41Var = new z41();
        x41.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i & (-16776961)) | (this.Kkkkkkkkkkkkkkkkk << 8), p51Var, z41Var);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        x41 x41Var = new x41(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, z41Var, z41Var, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 2);
        if (z) {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkk;
            this.Kkkkkkkkkkkkkkkk = x41Var;
        } else {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkk;
            this.Kkkkkkkkkkkkkkk = x41Var;
        }
        return x41Var;
    }

    @Override // me.tvspark.l51
    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, k51[] k51VarArr, k51[] k51VarArr2, int[] iArr, String str, boolean z) {
        z41 z41Var = new z41();
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >>> 24);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51VarArr.length);
        for (int i2 = 0; i2 < k51VarArr.length; i2++) {
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51VarArr[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51VarArr2[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - k51VarArr[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[i2]);
        }
        if (p51Var == null) {
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        } else {
            byte[] bArr = p51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = p51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i3, (bArr[i3] * 2) + 1);
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        x41 x41Var = new x41(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, z41Var, z41Var, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 2);
        if (z) {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkk;
            this.Kkkkkkkkkkkkkkkk = x41Var;
        } else {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkk;
            this.Kkkkkkkkkkkkkkk = x41Var;
        }
        return x41Var;
    }

    @Override // me.tvspark.l51
    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z) {
        z41 z41Var = new z41();
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        x41 x41Var = new x41(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, z41Var, z41Var, 2);
        if (z) {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = x41Var;
        } else {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = x41Var;
        }
        return x41Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        char c;
        int i2;
        z41 z41Var;
        int i3;
        if (this.Wwwwww != null) {
            if (this.Wwwwwwww == null) {
                this.Wwwwwwww = new z41();
            }
            int[] iArr = this.Wwwww;
            int i4 = iArr[1];
            int i5 = iArr[2];
            int i6 = 0;
            if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < 50) {
                z41 z41Var2 = this.Wwwwwwww;
                z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[0]);
                z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                i3 = i4 + 3;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, i3);
            } else {
                int[] iArr2 = this.Wwwwww;
                int i7 = iArr2[1];
                int i8 = this.Wwwwwwwww == 0 ? iArr[0] : (iArr[0] - iArr2[0]) - 1;
                if (i5 == 0) {
                    i = i4 - i7;
                    switch (i) {
                        case -3:
                        case -2:
                        case -1:
                            i7 = i4;
                            i2 = i;
                            c = 248;
                            break;
                        case 0:
                            i2 = i;
                            if (i8 >= 64) {
                                c = 251;
                                break;
                            } else {
                                c = 0;
                                break;
                            }
                        case 1:
                        case 2:
                        case 3:
                            i2 = i;
                            c = 252;
                            break;
                        default:
                            i2 = i;
                            c = 255;
                            break;
                    }
                    if (c != 255) {
                        int i9 = 3;
                        while (true) {
                            if (i6 < i7) {
                                if (this.Wwwww[i9] != this.Wwwwww[i9]) {
                                    c = 255;
                                } else {
                                    i9++;
                                    i6++;
                                }
                            }
                        }
                    }
                    if (c != 0) {
                        if (c == '@') {
                            this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8 + 64);
                        } else if (c != 247) {
                            if (c == 248) {
                                z41Var = this.Wwwwwwww;
                                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                            } else if (c == 251) {
                                z41Var = this.Wwwwwwww;
                                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                            } else if (c != 252) {
                                z41 z41Var3 = this.Wwwwwwww;
                                z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(255);
                                z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                                z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                                i3 = i4 + 3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, i3);
                            } else {
                                z41 z41Var4 = this.Wwwwwwww;
                                z41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                                z41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 3, i4 + 3);
                            }
                            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                        } else {
                            z41 z41Var5 = this.Wwwwwwww;
                            z41Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(247);
                            z41Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4 + 3, i4 + 4);
                    } else {
                        this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                    }
                    this.Wwwwwwwww++;
                } else if (i4 != i7 || i5 != 1) {
                    i = 0;
                    i2 = i;
                    c = 255;
                    if (c != 255) {
                    }
                    if (c != 0) {
                    }
                    this.Wwwwwwwww++;
                } else {
                    c = i8 < 63 ? '@' : (char) 247;
                    i2 = 0;
                    if (c != 255) {
                    }
                    if (c != 0) {
                    }
                    this.Wwwwwwwww++;
                }
            }
            this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i5 + i3);
            this.Wwwwwwwww++;
        }
        this.Wwwwww = this.Wwwww;
        this.Wwwww = null;
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        z41 z41Var = this.Wwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkkkk = z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0, (c51) null, (j51) null);
            } else {
                int i2 = this.Kkkkkkk + g51.Wwwwwwwwwwwwwwwwwwwwwwwwww[i];
                if (i2 > this.Kkkkkk) {
                    this.Kkkkkk = i2;
                }
                this.Kkkkkkk = i2;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3;
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null && this.Kkkkkkkkkkk == 0) {
            k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.TARGET, i, (c51) null, (j51) null);
        }
        if (this.Kkkkkkkkkkk != 2 && (i3 = i + 1) > this.Wwwwwwwwwww) {
            this.Wwwwwwwwwww = i3;
        }
        if (i <= 255 && i2 <= 127 && i2 >= -128) {
            z41 z41Var = this.Wwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.TARGET);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            return;
        }
        z41 z41Var2 = this.Wwwwwwwwwwwww;
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(196);
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.TARGET, i);
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, k51 k51Var, k51... k51VarArr) {
        z41 z41Var = this.Wwwwwwwwwwwww;
        int i3 = z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkkkk = i3;
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(170);
        z41 z41Var2 = this.Wwwwwwwwwwwww;
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((byte[]) null, 0, (4 - (z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww % 4)) % 4);
        k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, i3, true);
        z41 z41Var3 = this.Wwwwwwwwwwwww;
        z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        for (k51 k51Var2 : k51VarArr) {
            k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, i3, true);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var, k51VarArr);
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (i == 187) {
                int i2 = this.Kkkkkkk + 1;
                if (i2 > this.Kkkkkk) {
                    this.Kkkkkk = i2;
                }
                this.Kkkkkkk = i2;
            }
        }
        this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, str3);
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null) {
            int i4 = 0;
            if (this.Kkkkkkkkkkk == 0) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                char charAt = str3.charAt(0);
                int i5 = 1;
                int i6 = -2;
                switch (i) {
                    case 178:
                        int i7 = this.Kkkkkkk;
                        if (charAt == 'D' || charAt == 'J') {
                            i5 = 2;
                        }
                        i2 = i7 + i5;
                        break;
                    case 179:
                        i3 = this.Kkkkkkk;
                        if (charAt != 'D' && charAt != 'J') {
                            i6 = -1;
                        }
                        i2 = i6 + i3;
                        break;
                    case 180:
                        int i8 = this.Kkkkkkk;
                        if (charAt == 'D' || charAt == 'J') {
                            i4 = 1;
                        }
                        i2 = i8 + i4;
                        break;
                    default:
                        i3 = this.Kkkkkkk;
                        if (charAt == 'D' || charAt == 'J') {
                            i6 = -3;
                        }
                        i2 = i6 + i3;
                        break;
                }
                if (i2 > this.Kkkkkk) {
                    this.Kkkkkk = i2;
                }
                this.Kkkkkkk = i2;
            }
        }
        this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3, boolean z) {
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, str3, z);
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                if (i2 == 0) {
                    i2 = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                }
                int i3 = i == 184 ? (this.Kkkkkkk - (i2 >> 2)) + (i2 & 3) + 1 : (this.Kkkkkkk - (i2 >> 2)) + (i2 & 3);
                if (i3 > this.Kkkkkk) {
                    this.Kkkkkk = i3;
                }
                this.Kkkkkkk = i3;
            }
        }
        if (i != 185) {
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        if (i2 == 0) {
            i2 = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
        z41 z41Var = this.Wwwwwwwwwwwww;
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NormalCmdFactory.TASK_CANCEL_ALL, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 >> 2, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // me.tvspark.l51
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, k51 k51Var) {
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        k51 k51Var2 = this.Kkkkkkkk;
        k51 k51Var3 = null;
        if (k51Var2 != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0, (c51) null, (j51) null);
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 16;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, k51Var);
                if (i != 167) {
                    k51Var3 = new k51();
                }
            } else if (i == 168) {
                int i2 = k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i2 & 512) == 0) {
                    k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 | 512;
                    this.Kkkkkkkkkkkk++;
                }
                this.Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 128;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkk + 1, k51Var);
                k51Var3 = new k51();
            } else {
                int i3 = this.Kkkkkkk + g51.Wwwwwwwwwwwwwwwwwwwwwwwwww[i];
                this.Kkkkkkk = i3;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, k51Var);
            }
        }
        if ((k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 2) != 0) {
            int i4 = k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41 z41Var = this.Wwwwwwwwwwwww;
            if (i4 - z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < -32768) {
                int i5 = 200;
                if (i != 167) {
                    if (i != 168) {
                        if (k51Var3 != null) {
                            k51Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 16;
                        }
                        this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i <= 166 ? ((i + 1) ^ 1) - 1 : i ^ 1);
                        this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(200);
                        z41 z41Var2 = this.Wwwwwwwwwwwww;
                        k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var2, z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, true);
                        if (this.Kkkkkkkk == null) {
                            return;
                        }
                        if (k51Var3 != null) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var3);
                        }
                        if (i != 167) {
                            return;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                    i5 = 201;
                }
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                z41 z41Var22 = this.Wwwwwwwwwwwww;
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var22, z41Var22.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, true);
                if (this.Kkkkkkkk == null) {
                }
            }
        }
        this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        z41 z41Var3 = this.Wwwwwwwwwwwww;
        k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var3, z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, false);
        if (this.Kkkkkkkk == null) {
        }
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        z41 z41Var;
        int i;
        this.Kkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        k51 k51Var = this.Kkkkkkkk;
        if (k51Var != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(18, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = (i2 == 5 || i2 == 6) ? this.Kkkkkkk + 2 : this.Kkkkkkk + 1;
                if (i3 > this.Kkkkkk) {
                    this.Kkkkkk = i3;
                }
                this.Kkkkkkk = i3;
            }
        }
        int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i5 == 5 || i5 == 6) {
            z41Var = this.Wwwwwwwwwwwww;
            i = 20;
        } else if (i4 < 256) {
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(18, i4);
            return;
        } else {
            z41Var = this.Wwwwwwwwwwwww;
            i = 19;
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i4);
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, k51 k51Var, k51 k51Var2, int i) {
        int i2 = 1;
        if (str3 != null) {
            if (this.Kkkkkkkkkkkkkkkkkkkk == null) {
                this.Kkkkkkkkkkkkkkkkkkkk = new z41();
            }
            this.Kkkkkkkkkkkkkkkkkkkkk++;
            z41 z41Var = this.Kkkkkkkkkkkkkkkkkkkk;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3));
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkk == null) {
            this.Kkkkkkkkkkkkkkkkkkkkkk = new z41();
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkk++;
        z41 z41Var2 = this.Kkkkkkkkkkkkkkkkkkkkkk;
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2));
        z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if (this.Kkkkkkkkkkk != 2) {
            char charAt = str2.charAt(0);
            if (charAt == 'J' || charAt == 'D') {
                i2 = 2;
            }
            int i3 = i + i2;
            if (i3 <= this.Wwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwww = i3;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g51 g51Var) {
        int[] iArr = g51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr2 = g51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < iArr.length) {
            int i5 = iArr[i2];
            i4++;
            if (i5 != 16777216) {
                i3 += i4;
                i4 = 0;
            }
            if (i5 == 16777220 || i5 == 16777219) {
                i2++;
            }
            i2++;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < iArr2.length) {
            int i8 = iArr2[i6];
            i7++;
            if (i8 == 16777220 || i8 == 16777219) {
                i6++;
            }
            i6++;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, i7);
        int i9 = 3;
        int i10 = 0;
        while (i3 > 0) {
            int i11 = iArr[i10];
            int i12 = i9 + 1;
            this.Wwwww[i9] = i11;
            if (i11 == 16777220 || i11 == 16777219) {
                i10++;
            }
            i10++;
            i3--;
            i9 = i12;
        }
        while (i < iArr2.length) {
            int i13 = iArr2[i];
            int i14 = i9 + 1;
            this.Wwwww[i9] = i13;
            if (i13 == 16777220 || i13 == 16777219) {
                i++;
            }
            i++;
            i9 = i14;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r0 != null) goto L23;
     */
    @Override // me.tvspark.l51
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51 k51Var) {
        k51 k51Var2;
        boolean z = this.Kkkkkkkkkkkkk;
        z41 z41Var = this.Wwwwwwwwwwwww;
        this.Kkkkkkkkkkkkk = z | k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i = k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if ((i & 1) != 0) {
            return;
        }
        int i2 = this.Kkkkkkkkkkk;
        if (i2 == 0) {
            k51 k51Var3 = this.Kkkkkkkk;
            if (k51Var3 != null) {
                if (k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == k51Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    k51Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 16) | k51Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = k51Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, k51Var);
            }
            this.Kkkkkkkk = k51Var;
            if (k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                g51 g51Var = new g51();
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = g51Var;
                g51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k51Var;
            }
            k51Var2 = this.Kkkkkkkkk;
            if (k51Var2 != null) {
                if (k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 16;
                    k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Kkkkkkkk = k51Var2;
                    return;
                }
                k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww = k51Var;
            }
            this.Kkkkkkkkk = k51Var;
        } else if (i2 != 1) {
        } else {
            k51 k51Var4 = this.Kkkkkkkk;
            if (k51Var4 != null) {
                k51Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkk;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkk, k51Var);
            }
            this.Kkkkkkkk = k51Var;
            this.Kkkkkkk = 0;
            this.Kkkkkk = 0;
            k51Var2 = this.Kkkkkkkkk;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51 k51Var, k51[] k51VarArr) {
        k51 k51Var2 = this.Kkkkkkkk;
        if (k51Var2 != null) {
            if (this.Kkkkkkkkkkk == 0) {
                k51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, 0, (c51) null, (j51) null);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, k51Var);
                k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 16;
                for (int i = 0; i < k51VarArr.length; i++) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, k51VarArr[i]);
                    k51VarArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 16;
                }
            } else {
                int i2 = this.Kkkkkkk - 1;
                this.Kkkkkkk = i2;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, k51Var);
                for (k51 k51Var3 : k51VarArr) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkk, k51Var3);
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41 z41Var) {
        int i;
        int i2;
        y41 y41Var;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 & (~(((i3 & 262144) / 64) | 917504)));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i4 != 0) {
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        int i5 = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0 ? 1 : 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww > 0) {
            i5++;
        }
        int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if ((i6 & 4096) != 0 && ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < 49 || (i6 & 262144) != 0)) {
            i5++;
        }
        if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            i5++;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk != null) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww != null) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwwwwww != null) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwwwww != null) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwwww != null) {
            i5++;
        }
        if (this.Wwwwwwwwwwwwwwww != null) {
            i5++;
        }
        y41 y41Var2 = this.Wwwwwwwwwwwwww;
        if (y41Var2 != null) {
            i5 += y41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
        int i7 = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i7 > 0) {
            int i8 = (this.Wwww * 8) + i7 + 12;
            z41 z41Var2 = this.Kkkkkkkkkkkkkkkkkkkkkk;
            if (z41Var2 != null) {
                i8 += z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
            }
            z41 z41Var3 = this.Kkkkkkkkkkkkkkkkkkkk;
            if (z41Var3 != null) {
                i8 += z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
            }
            z41 z41Var4 = this.Kkkkkkkkkkkkkkkkkk;
            if (z41Var4 != null) {
                i8 += z41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
            }
            z41 z41Var5 = this.Wwwwwwww;
            if (z41Var5 != null) {
                i8 += z41Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
            }
            x41 x41Var = this.Kkkkkkkkkkkkkkkk;
            if (x41Var != null) {
                i8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x41Var, 8, i8);
            }
            x41 x41Var2 = this.Kkkkkkkkkkkkkkk;
            if (x41Var2 != null) {
                i8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x41Var2, 8, i8);
            }
            y41 y41Var3 = this.Kkkkkkkkkkkkkk;
            if (y41Var3 != null) {
                c51 c51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z41 z41Var6 = this.Wwwwwwwwwwwww;
                i8 += y41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwww, this.Wwwwwwwwwww);
            }
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Code"));
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41 z41Var7 = this.Wwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww);
            if (this.Wwww > 0) {
                for (i51 i51Var = this.Www; i51Var != null; i51Var = i51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
            int i9 = this.Kkkkkkkkkkkkkkkkkkkkkk != null ? 1 : 0;
            if (this.Kkkkkkkkkkkkkkkkkkkk != null) {
                i9++;
            }
            if (this.Kkkkkkkkkkkkkkkkkk != null) {
                i9++;
            }
            if (this.Wwwwwwww != null) {
                i9++;
            }
            if (this.Kkkkkkkkkkkkkkkk != null) {
                i9++;
            }
            if (this.Kkkkkkkkkkkkkkk != null) {
                i9++;
            }
            y41 y41Var4 = this.Kkkkkkkkkkkkkk;
            if (y41Var4 != null) {
                i9 += y41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
            if (this.Kkkkkkkkkkkkkkkkkkkkkk != null) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LocalVariableTable"));
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 2);
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk);
                z41 z41Var8 = this.Kkkkkkkkkkkkkkkkkkkkkk;
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (this.Kkkkkkkkkkkkkkkkkkkk != null) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LocalVariableTypeTable"));
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 2);
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkk);
                z41 z41Var9 = this.Kkkkkkkkkkkkkkkkkkkk;
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (this.Kkkkkkkkkkkkkkkkkk != null) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LineNumberTable"));
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 2);
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkk);
                z41 z41Var10 = this.Kkkkkkkkkkkkkkkkkk;
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (this.Wwwwwwww != null) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) >= 50 ? "StackMapTable" : "StackMap"));
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 2);
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwww);
                z41 z41Var11 = this.Wwwwwwww;
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (this.Kkkkkkkkkkkkkkkk != null) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations"));
                this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var);
            }
            if (this.Kkkkkkkkkkkkkkk != null) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations"));
                this.Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var);
            }
            y41 y41Var5 = this.Kkkkkkkkkkkkkk;
            if (y41Var5 != null) {
                c51 c51Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z41 z41Var12 = this.Wwwwwwwwwwwww;
                i = 2;
                y41Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var2, z41Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z41Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwww, this.Wwwwwwwwwwww, z41Var);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww > 0) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Exceptions"));
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((this.Wwwwwwwwwwwwwwwwwwwwwwww * 2) + i);
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    for (int i10 = 0; i10 < this.Wwwwwwwwwwwwwwwwwwwwwwww; i10++) {
                        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww[i10]);
                    }
                }
                i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i2 & 4096) != 0 && ((65535 & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) < 49 || (262144 & i2) != 0)) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Synthetic"));
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                }
                if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deprecated"));
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Signature"));
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
                if (this.Kkkkkkkkkkkkkkkkkkkkkkkk != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MethodParameters"));
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
                    z41 z41Var13 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AnnotationDefault"));
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    z41 z41Var14 = this.Wwwwwwwwwwwwwwwwwwwwww;
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var14.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var14.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleAnnotations"));
                    this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var);
                }
                if (this.Wwwwwwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleAnnotations"));
                    this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var);
                }
                if (this.Wwwwwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations"));
                    this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var);
                }
                if (this.Wwwwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations"));
                    this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var);
                }
                if (this.Wwwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleParameterAnnotations"));
                    x41.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, z41Var);
                }
                if (this.Wwwwwwwwwwwwwwww != null) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleParameterAnnotations"));
                    x41.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, z41Var);
                }
                y41Var = this.Wwwwwwwwwwwwww;
                if (y41Var != null) {
                    return;
                }
                y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, 0, -1, -1, z41Var);
                return;
            }
        }
        i = 2;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww > 0) {
        }
        i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if ((i2 & 4096) != 0) {
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Synthetic"));
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
        if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk != null) {
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww != null) {
        }
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
        }
        if (this.Wwwwwwwwwwwwwwwwwww != null) {
        }
        if (this.Wwwwwwwwwwwwwwwwww != null) {
        }
        if (this.Wwwwwwwwwwwwwwwww != null) {
        }
        if (this.Wwwwwwwwwwwwwwww != null) {
        }
        y41Var = this.Wwwwwwwwwwwwww;
        if (y41Var != null) {
        }
    }

    @Override // me.tvspark.l51
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        z41 z41Var;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.Kkkkkkkkkkk == 0) {
            return;
        }
        int i9 = 3;
        int i10 = 0;
        if (i == -1) {
            if (this.Wwwwww == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.length() + 1, 0);
                int i11 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i11 & 8) == 0) {
                    if ((i11 & 524288) == 0) {
                        int[] iArr = this.Wwwww;
                        c51 c51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        iArr[3] = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwww) | 24117248;
                    } else {
                        this.Wwwww[3] = 6;
                    }
                    i7 = 4;
                } else {
                    i7 = 3;
                }
                int i12 = 1;
                while (true) {
                    int i13 = i12 + 1;
                    char charAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i12);
                    if (charAt == 'F') {
                        i8 = i7 + 1;
                        this.Wwwww[i7] = 2;
                    } else if (charAt != 'L') {
                        if (charAt != 'S' && charAt != 'I') {
                            if (charAt == 'J') {
                                i8 = i7 + 1;
                                this.Wwwww[i7] = 4;
                            } else if (charAt != 'Z') {
                                if (charAt != '[') {
                                    switch (charAt) {
                                        case 'B':
                                        case 'C':
                                            break;
                                        case 'D':
                                            i8 = i7 + 1;
                                            this.Wwwww[i7] = 3;
                                            break;
                                        default:
                                            this.Wwwww[1] = i7 - 3;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            break;
                                    }
                                } else {
                                    while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i13) == '[') {
                                        i13++;
                                    }
                                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i13) == 'L') {
                                        do {
                                            i13++;
                                        } while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i13) != ';');
                                        int i14 = i13 + 1;
                                        this.Wwwww[i7] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(i12, i14)) | 24117248;
                                        i12 = i14;
                                        i7++;
                                    } else {
                                        int i142 = i13 + 1;
                                        this.Wwwww[i7] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(i12, i142)) | 24117248;
                                        i12 = i142;
                                        i7++;
                                    }
                                }
                            }
                        }
                        i8 = i7 + 1;
                        this.Wwwww[i7] = 1;
                    } else {
                        int i15 = i13;
                        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i15) != ';') {
                            i15++;
                        }
                        this.Wwwww[i7] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(i13, i15)) | 24117248;
                        i7++;
                        i12 = i15 + 1;
                    }
                    i7 = i8;
                    i12 = i13;
                }
            }
            this.Wwwwwwwwww = i2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, i3);
            for (int i16 = 0; i16 < i2; i16++) {
                if (objArr[i16] instanceof String) {
                    i6 = i9 + 1;
                    this.Wwwww[i9] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) objArr[i16]) | 24117248;
                } else if (objArr[i16] instanceof Integer) {
                    i6 = i9 + 1;
                    this.Wwwww[i9] = ((Integer) objArr[i16]).intValue();
                } else {
                    this.Wwwww[i9] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", ((k51) objArr[i16]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) | 25165824;
                    i9++;
                }
                i9 = i6;
            }
            while (i10 < i3) {
                if (objArr2[i10] instanceof String) {
                    i5 = i9 + 1;
                    this.Wwwww[i9] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) objArr2[i10]) | 24117248;
                } else if (objArr2[i10] instanceof Integer) {
                    i5 = i9 + 1;
                    this.Wwwww[i9] = ((Integer) objArr2[i10]).intValue();
                } else {
                    i5 = i9 + 1;
                    this.Wwwww[i9] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", ((k51) objArr2[i10]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) | 25165824;
                }
                i9 = i5;
                i10++;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            if (this.Wwwwwwww == null) {
                this.Wwwwwwww = new z41();
                i4 = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                i4 = (this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwww) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.Wwwwwwwwww = i2;
                z41 z41Var2 = this.Wwwwwwww;
                z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(255);
                z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                for (int i17 = 0; i17 < i2; i17++) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr[i17]);
                }
                this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                while (i10 < i3) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[i10]);
                    i10++;
                }
            } else if (i != 1) {
                int i18 = TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION;
                if (i == 2) {
                    this.Wwwwwwwwww -= i2;
                    z41Var = this.Wwwwwwww;
                    i18 = TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION - i2;
                } else if (i == 3) {
                    z41Var = this.Wwwwwwww;
                    if (i4 < 64) {
                        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                    }
                } else if (i == 4) {
                    z41 z41Var3 = this.Wwwwwwww;
                    if (i4 < 64) {
                        z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4 + 64);
                    } else {
                        z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(247);
                        z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr2[0]);
                }
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18);
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            } else {
                this.Wwwwwwwwww += i2;
                z41 z41Var4 = this.Wwwwwwww;
                z41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                z41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                while (i10 < i2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr[i10]);
                    i10++;
                }
            }
            this.Wwwwwww = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwww++;
        }
        this.Wwwwwwwwwwww = Math.max(this.Wwwwwwwwwwww, i3);
        this.Wwwwwwwwwww = Math.max(this.Wwwwwwwwwww, this.Wwwwwwwwww);
    }
}
