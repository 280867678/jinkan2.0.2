package me.tvspark;

import com.tencent.smtt.sdk.TbsListener;

/* loaded from: classes4.dex */
public class c51 extends b51 {
    public static final byte[] Kkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkk;
    public m51 Kkkkkkkkkkkkkkkkkkkkkkk;
    public m51 Kkkkkkkkkkkkkkkkkkkkkkkk;
    public f51 Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public f51 Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public z41 Www;
    public int Wwww;
    public z41 Wwwww;
    public int Wwwwww;
    public y41 Wwwwwww;
    public x41 Wwwwwwww;
    public x41 Wwwwwwwww;
    public x41 Wwwwwwwwww;
    public x41 Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public z41 Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public short Wwwwwwwwwwwwwwwwwwwwwww;
    public j51[] Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public j51[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public a51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    public final z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new z41();
    public final j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new j51();
    public final j51 Wwwwwwwwwwwwwwwwwwwwwwwwwww = new j51();
    public final j51 Wwwwwwwwwwwwwwwwwwwwwwwwww = new j51();
    public final j51 Wwwwwwwwwwwwwwwwwwwwwwwww = new j51();

    static {
        byte[] bArr = new byte[TbsListener.ErrorCode.COPY_INSTALL_SUCCESS];
        for (int i = 0; i < 220; i++) {
            bArr[i] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i) - 'A');
        }
        Kkkkkkkkkkkkkkkkkkk = bArr;
    }

    public c51(int i) {
        super(327680);
        boolean z = true;
        j51[] j51VarArr = new j51[256];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j51VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) (j51VarArr.length * 0.75d);
        this.Kkkkkkkkkkkkkkkkkkkkkk = (i & 1) != 0;
        this.Kkkkkkkkkkkkkkkkkkkkk = (i & 2) == 0 ? false : z;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, str, null, null);
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            int length = str.length();
            if (length <= 65535) {
                int i = z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i + 2 + length > z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length + 2);
                }
                byte[] bArr = z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = i + 1;
                bArr[i] = (byte) (length >>> 8);
                int i3 = i2 + 1;
                bArr[i2] = (byte) length;
                int i4 = 0;
                while (i4 < length) {
                    char charAt = str.charAt(i4);
                    if (charAt < 1 || charAt > 127) {
                        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i4, 65535);
                        break;
                    }
                    bArr[i3] = (byte) charAt;
                    i4++;
                    i3++;
                }
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new j51(i5, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(30, str, null, null);
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51 j51Var) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
            int i = (length * 2) + 1;
            j51[] j51VarArr = new j51[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                j51 j51Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                while (j51Var2 != null) {
                    int i3 = j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww % i;
                    j51 j51Var3 = j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww = j51VarArr[i3];
                    j51VarArr[i3] = j51Var2;
                    j51Var2 = j51Var3;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j51VarArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) (i * 0.75d);
        }
        int i4 = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51[] j51VarArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length2 = i4 % j51VarArr2.length;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwww = j51VarArr2[length2];
        j51VarArr2[length2] = j51Var;
    }

    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i2;
        int i3;
        int i4;
        z41 z41Var;
        String str7;
        int i5;
        int i6;
        String str8;
        int i7;
        int i8;
        int i9;
        c51 c51Var = this;
        if (c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 65535) {
            int i10 = (c51Var.Wwwwwwwwwwwwwwwww * 2) + 24;
            f51 f51Var = c51Var.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            int i11 = 0;
            while (true) {
                str = "ConstantValue";
                if (f51Var == null) {
                    break;
                }
                i11++;
                if (f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                    i9 = 16;
                } else {
                    i9 = 8;
                }
                int i12 = f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i12 & 4096) != 0 && ((f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < 49 || (i12 & 262144) != 0)) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Synthetic");
                    i9 += 6;
                }
                if ((f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deprecated");
                    i9 += 6;
                }
                if (f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Signature");
                    i9 += 8;
                }
                if (f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleAnnotations");
                    i9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 8, i9);
                }
                if (f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleAnnotations");
                    i9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwww, 8, i9);
                }
                if (f51Var.Wwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations");
                    i9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var.Wwwwwwwwwwwwwwwwwwwwwwwww, 8, i9);
                }
                if (f51Var.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations");
                    i9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var.Wwwwwwwwwwwwwwwwwwwwwwww, 8, i9);
                }
                y41 y41Var = f51Var.Wwwwwwwwwwwwwwwwwwwwwww;
                if (y41Var != null) {
                    i9 += y41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, 0, -1, -1);
                }
                i10 += i9;
                f51Var = f51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            m51 m51Var = c51Var.Kkkkkkkkkkkkkkkkkkkkkkkk;
            int i13 = 0;
            while (m51Var != null) {
                int i14 = i13 + 1;
                if (m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    i8 = m51Var.Wwwwwwwwwwwwwwwwwwwwwwwww + 6;
                    i5 = i14;
                    i6 = i11;
                    str8 = str;
                } else {
                    int i15 = m51Var.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i15 <= 0) {
                        i5 = i14;
                        i6 = i11;
                        str8 = str;
                        i7 = 8;
                    } else if (i15 > 65536) {
                        throw new RuntimeException("Method code too large!");
                    } else {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Code");
                        i7 = (m51Var.Wwww * 8) + m51Var.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 18 + 8;
                        if (m51Var.Kkkkkkkkkkkkkkkkkkkkkk != null) {
                            m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LocalVariableTable");
                            i7 += m51Var.Kkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
                        }
                        if (m51Var.Kkkkkkkkkkkkkkkkkkkk != null) {
                            m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LocalVariableTypeTable");
                            i7 += m51Var.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
                        }
                        if (m51Var.Kkkkkkkkkkkkkkkkkk != null) {
                            m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LineNumberTable");
                            i7 += m51Var.Kkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
                        }
                        if (m51Var.Wwwwwwww != null) {
                            m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) >= 50 ? "StackMapTable" : "StackMap");
                            i7 += m51Var.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
                        }
                        if (m51Var.Kkkkkkkkkkkkkkkk != null) {
                            m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations");
                            i7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Kkkkkkkkkkkkkkkk, 8, i7);
                        }
                        if (m51Var.Kkkkkkkkkkkkkkk != null) {
                            m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations");
                            i7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Kkkkkkkkkkkkkkk, 8, i7);
                        }
                        y41 y41Var2 = m51Var.Kkkkkkkkkkkkkk;
                        if (y41Var2 != null) {
                            c51 c51Var2 = m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            i5 = i14;
                            z41 z41Var2 = m51Var.Wwwwwwwwwwwww;
                            str8 = str;
                            i6 = i11;
                            i7 += y41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var2, z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, m51Var.Wwwwwwwwwwww, m51Var.Wwwwwwwwwww);
                        } else {
                            i5 = i14;
                            i6 = i11;
                            str8 = str;
                        }
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwwwwwwwwww > 0) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Exceptions");
                        i7 += (m51Var.Wwwwwwwwwwwwwwwwwwwwwwww * 2) + 8;
                    }
                    int i16 = m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if ((i16 & 4096) != 0 && ((m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < 49 || (i16 & 262144) != 0)) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Synthetic");
                        i7 += 6;
                    }
                    if ((m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deprecated");
                        i7 += 6;
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Signature");
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i7 += 8;
                    }
                    if (m51Var.Kkkkkkkkkkkkkkkkkkkkkkkk != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MethodParameters");
                        i7 += m51Var.Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 7;
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AnnotationDefault");
                        i7 += m51Var.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 6;
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleAnnotations");
                        i7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Wwwwwwwwwwwwwwwwwwwww, 8, i7);
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleAnnotations");
                        i7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Wwwwwwwwwwwwwwwwwwww, 8, i7);
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations");
                        i7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Wwwwwwwwwwwwwwwwwww, 8, i7);
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations");
                        i7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Wwwwwwwwwwwwwwwwww, 8, i7);
                    }
                    if (m51Var.Wwwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleParameterAnnotations");
                        x41[] x41VarArr = m51Var.Wwwwwwwwwwwwwwwww;
                        i7 = ((x41VarArr.length - m51Var.Wwwwwwwwwwwwwww) * 2) + 7 + i7;
                        for (int length = x41VarArr.length - 1; length >= m51Var.Wwwwwwwwwwwwwww; length--) {
                            x41[] x41VarArr2 = m51Var.Wwwwwwwwwwwwwwwww;
                            i7 += x41VarArr2[length] == null ? 0 : x41VarArr2[length].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    }
                    if (m51Var.Wwwwwwwwwwwwwwww != null) {
                        m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleParameterAnnotations");
                        x41[] x41VarArr3 = m51Var.Wwwwwwwwwwwwwwww;
                        int length2 = ((x41VarArr3.length - m51Var.Wwwwwwwwwwwwwww) * 2) + 7 + i7;
                        int length3 = x41VarArr3.length;
                        while (true) {
                            length3--;
                            if (length3 < m51Var.Wwwwwwwwwwwwwww) {
                                break;
                            }
                            x41[] x41VarArr4 = m51Var.Wwwwwwwwwwwwwwww;
                            length2 += x41VarArr4[length3] == null ? 0 : x41VarArr4[length3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        i8 = length2;
                    } else {
                        i8 = i7;
                    }
                    y41 y41Var3 = m51Var.Wwwwwwwwwwwwww;
                    if (y41Var3 != null) {
                        i8 += y41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, 0, -1, -1);
                    }
                }
                i10 += i8;
                m51Var = (m51) m51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c51Var = this;
                i13 = i5;
                str = str8;
                i11 = i6;
            }
            int i17 = i11;
            String str9 = str;
            z41 z41Var3 = c51Var.Www;
            String str10 = "BootstrapMethods";
            if (z41Var3 != null) {
                i10 += z41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str10);
                i = 1;
            } else {
                i = 0;
            }
            if (c51Var.Wwwwwwwwwwwwwwwwwww != 0) {
                i++;
                i10 += 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Signature");
            }
            if (c51Var.Wwwwwwwwwwwwwww != 0) {
                i++;
                i10 += 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SourceFile");
            }
            z41 z41Var4 = c51Var.Wwwwwwwwwwwwww;
            if (z41Var4 != null) {
                i++;
                i10 += z41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 6;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SourceDebugExtension");
            }
            if (c51Var.Wwwwwwwwwwwww != 0) {
                i++;
                i10 += 10;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("EnclosingMethod");
            }
            if ((c51Var.Wwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
                i++;
                i10 += 6;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deprecated");
            }
            int i18 = c51Var.Wwwwwwwwwwwwwwwwwwwwww;
            if ((i18 & 4096) != 0) {
                str2 = "SourceDebugExtension";
                if ((c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < 49 || (i18 & 262144) != 0) {
                    i++;
                    i10 += 6;
                    c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Synthetic");
                }
            } else {
                str2 = "SourceDebugExtension";
            }
            z41 z41Var5 = c51Var.Wwwww;
            if (z41Var5 != null) {
                i++;
                i10 += z41Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("InnerClasses");
            }
            x41 x41Var = c51Var.Wwwwwwwwwww;
            if (x41Var != null) {
                i++;
                i10 += x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleAnnotations");
            }
            x41 x41Var2 = c51Var.Wwwwwwwwww;
            if (x41Var2 != null) {
                i++;
                i10 += x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleAnnotations");
            }
            x41 x41Var3 = c51Var.Wwwwwwwww;
            if (x41Var3 != null) {
                i++;
                i10 += x41Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations");
            }
            x41 x41Var4 = c51Var.Wwwwwwww;
            if (x41Var4 != null) {
                i++;
                i10 += x41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + 8;
                c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations");
            }
            int i19 = i10;
            y41 y41Var4 = c51Var.Wwwwwww;
            if (y41Var4 != null) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = y41Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + i;
                i3 = 49;
                str4 = "EnclosingMethod";
                str3 = "InnerClasses";
                str5 = str2;
                str6 = "SourceFile";
                i2 = i13;
                i19 += c51Var.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, null, 0, -1, -1);
                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                str3 = "InnerClasses";
                str4 = "EnclosingMethod";
                str5 = str2;
                str6 = "SourceFile";
                i2 = i13;
                i3 = 49;
            }
            z41 z41Var6 = new z41(i19 + c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-889275714);
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41 z41Var7 = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i20 = c51Var.Wwwwwwwwwwwwwwwwwwwwww;
            int i21 = 393216;
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i20 & (~(((i20 & 262144) / 64) | 393216)));
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwww);
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwww);
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwww);
            for (int i22 = 0; i22 < c51Var.Wwwwwwwwwwwwwwwww; i22++) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwww[i22]);
            }
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i17);
            f51 f51Var2 = c51Var.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            int i23 = i3;
            while (f51Var2 != null) {
                int i24 = f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((~(((i24 & 262144) / 64) | i21)) & i24);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                int i25 = f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 0 ? 1 : 0;
                int i26 = f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                String str11 = str10;
                if ((i26 & 4096) != 0 && ((f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < i23 || (i26 & 262144) != 0)) {
                    i25++;
                }
                if ((f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
                    i25++;
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    i25++;
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    i25++;
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    i25++;
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    i25++;
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    i25++;
                }
                y41 y41Var5 = f51Var2.Wwwwwwwwwwwwwwwwwwwwwww;
                if (y41Var5 != null) {
                    i25 += y41Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i25);
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    str7 = str9;
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7));
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    str7 = str9;
                }
                int i27 = f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i27 & 4096) != 0 && ((f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < i23 || (i27 & 262144) != 0)) {
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Synthetic"));
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                }
                if ((f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deprecated"));
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Signature"));
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleAnnotations"));
                    f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleAnnotations"));
                    f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations"));
                    f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
                }
                if (f51Var2.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations"));
                    f51Var2.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
                }
                y41 y41Var6 = f51Var2.Wwwwwwwwwwwwwwwwwwwwwww;
                if (y41Var6 != null) {
                    y41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, 0, -1, -1, z41Var6);
                }
                f51Var2 = f51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i21 = 393216;
                i23 = 49;
                str9 = str7;
                str10 = str11;
            }
            String str12 = str10;
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            for (m51 m51Var2 = c51Var.Kkkkkkkkkkkkkkkkkkkkkkkk; m51Var2 != null; m51Var2 = (m51) m51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                m51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
            }
            z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if (c51Var.Www != null) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str12));
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 2);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwww);
                z41 z41Var8 = c51Var.Www;
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (c51Var.Wwwwwwwwwwwwwwwwwww != 0) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Signature"));
                i4 = 2;
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwww);
            } else {
                i4 = 2;
            }
            if (c51Var.Wwwwwwwwwwwwwww != 0) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str6));
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwww);
            }
            z41 z41Var9 = c51Var.Wwwwwwwwwwwwww;
            if (z41Var9 != null) {
                int i28 = z41Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5));
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i28);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i28);
            }
            if (c51Var.Wwwwwwwwwwwww != 0) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4));
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwww);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwww);
            }
            if ((c51Var.Wwwwwwwwwwwwwwwwwwwwww & 131072) != 0) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deprecated"));
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            }
            int i29 = c51Var.Wwwwwwwwwwwwwwwwwwwwww;
            if ((i29 & 4096) != 0 && ((c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 65535) < 49 || (i29 & 262144) != 0)) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Synthetic"));
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            }
            if (c51Var.Wwwww != null) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3));
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 2);
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwww);
                z41 z41Var10 = c51Var.Wwwww;
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (c51Var.Wwwwwwwwwww != null) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleAnnotations"));
                c51Var.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
            }
            if (c51Var.Wwwwwwwwww != null) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleAnnotations"));
                c51Var.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
            }
            if (c51Var.Wwwwwwwww != null) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeVisibleTypeAnnotations"));
                c51Var.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
            }
            if (c51Var.Wwwwwwww != null) {
                z41Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RuntimeInvisibleTypeAnnotations"));
                c51Var.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var6);
            }
            y41 y41Var7 = c51Var.Wwwwwww;
            if (y41Var7 != null) {
                z41Var = z41Var6;
                y41Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, null, 0, -1, -1, z41Var);
            } else {
                z41Var = z41Var6;
            }
            if (!c51Var.Kkkkkkkkkkkkkkkkkkkk) {
                return z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            c51Var.Wwwwwwwwwww = null;
            c51Var.Wwwwwwwwww = null;
            c51Var.Wwwwwww = null;
            c51Var.Wwwwww = 0;
            c51Var.Wwwww = null;
            c51Var.Wwww = 0;
            c51Var.Www = null;
            c51Var.Kkkkkkkkkkkkkkkkkkkkkkkkkk = null;
            c51Var.Kkkkkkkkkkkkkkkkkkkkkkkkk = null;
            c51Var.Kkkkkkkkkkkkkkkkkkkkkkkk = null;
            c51Var.Kkkkkkkkkkkkkkkkkkkkkkk = null;
            c51Var.Kkkkkkkkkkkkkkkkkkkkkk = false;
            c51Var.Kkkkkkkkkkkkkkkkkkkkk = true;
            c51Var.Kkkkkkkkkkkkkkkkkkkk = false;
            new a51(z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, 4);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw new RuntimeException("Class file too large!");
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
        j51 j51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 31;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (str.hashCode() + 31 + i) & Integer.MAX_VALUE;
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        short s = (short) (this.Wwwwwwwwwwwwwwwwwwwwwww + 1);
        this.Wwwwwwwwwwwwwwwwwwwwwww = s;
        j51 j51Var = new j51(s, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new j51[16];
        }
        short s2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        j51[] j51VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (s2 == j51VarArr.length) {
            j51[] j51VarArr2 = new j51[j51VarArr.length * 2];
            System.arraycopy(j51VarArr, 0, j51VarArr2, 0, j51VarArr.length);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j51VarArr2;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww] = j51Var;
        return j51Var;
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        j51 j51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 6;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.doubleToRawLongBits(d);
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE & (j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ((int) d));
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            j51 j51Var2 = new j51(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var2);
            return j51Var2;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, str, null, null);
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            j51 j51Var = new j51(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
            return j51Var;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.b51
    public final l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3, String[] strArr) {
        return new m51(this, i, str, str2, str3, strArr, this.Kkkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkk);
    }

    @Override // me.tvspark.b51
    public final x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, String str, boolean z) {
        z41 z41Var = new z41();
        x41.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, p51Var, z41Var);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        x41 x41Var = new x41(this, true, z41Var, z41Var, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 2);
        if (z) {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwww;
            this.Wwwwwwwww = x41Var;
        } else {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww;
            this.Wwwwwwww = x41Var;
        }
        return x41Var;
    }

    @Override // me.tvspark.b51
    public final x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z) {
        z41 z41Var = new z41();
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        x41 x41Var = new x41(this, true, z41Var, z41Var, 2);
        if (z) {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwww;
            this.Wwwwwwwwwww = x41Var;
        } else {
            x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwww;
            this.Wwwwwwwwww = x41Var;
        }
        return x41Var;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        j51 j51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Float.floatToRawIntBits(f);
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE & (j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ((int) f));
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            j51 j51Var2 = new j51(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var2);
            return j51Var2;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        j51 j51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (i + 3) & Integer.MAX_VALUE;
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
            j51 j51Var2 = new j51(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var2);
            return j51Var2;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3) {
        int i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + 20, str, str2, str3);
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (i <= 4) {
                i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, str3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, str3, i == 9).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15, i);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
            j51 j51Var = new j51(i3, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
            return j51Var;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        j51 j51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 5;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (((int) j) + 5) & Integer.MAX_VALUE;
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            j51 j51Var2 = new j51(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var2);
            return j51Var2;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (obj instanceof Integer) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8, str, null, null);
            j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            j51 j51Var = new j51(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
            return j51Var;
        } else if (!(obj instanceof o51)) {
            if (obj instanceof h51) {
                h51 h51Var = (h51) obj;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("value ");
            stringBuffer.append(obj);
            throw new IllegalArgumentException(stringBuffer.toString());
        } else {
            o51 o51Var = (o51) obj;
            int i2 = o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == 10) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new String(o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (i2 == 11) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, null, null);
                j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
                j51 j51Var2 = new j51(i3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var2);
                return j51Var2;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9, str, str2, str3);
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str3));
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            j51 j51Var = new j51(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
            return j51Var;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, str2, str3);
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str3));
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
            j51 j51Var = new j51(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
            return j51Var;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0049, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0082, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0097, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51 j51Var) {
        j51[] j51VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        j51 j51Var2 = j51VarArr[j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww % j51VarArr.length];
        while (j51Var2 != null) {
            int i = j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == i2) {
                boolean z = true;
                if (i2 != 1) {
                    if (i2 == 12) {
                        if (j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        }
                        z = false;
                        if (z) {
                        }
                    } else if (i2 != 16) {
                        if (i2 != 18) {
                            switch (i2) {
                                case 3:
                                case 4:
                                    break;
                                case 5:
                                case 6:
                                    break;
                                case 7:
                                case 8:
                                    break;
                                default:
                                    switch (i2) {
                                        case 30:
                                            break;
                                        case 31:
                                            if (j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                                break;
                                            }
                                            z = false;
                                            break;
                                        case 32:
                                            break;
                                        default:
                                            if (j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                if (j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                    break;
                                                }
                                            }
                                            z = false;
                                            break;
                                    }
                            }
                            if (z) {
                            }
                        } else {
                            if (j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                if (j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        }
                    }
                    return j51Var2;
                }
                z = j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (z) {
                }
            }
            j51Var2 = j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return j51Var2;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12, str, str2, null);
        j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2));
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new j51(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.b51
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwww = str;
        if (str2 != null) {
            this.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        }
        this.Wwwwwwwwwwwwwwwwww = str3 == null ? 0 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.Wwwwwwwwwwwwwwwww = length;
        this.Wwwwwwwwwwwwwwww = new int[length];
        for (int i3 = 0; i3 < this.Wwwwwwwwwwwwwwwww; i3++) {
            this.Wwwwwwwwwwwwwwww[i3] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr[i3]);
        }
    }
}
