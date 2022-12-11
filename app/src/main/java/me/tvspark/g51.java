package me.tvspark;

import androidx.core.location.GpsStatusWrapper;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.tencent.smtt.sdk.TbsListener;
import org.mozilla.javascript.Token;

/* loaded from: classes4.dex */
public final class g51 {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public k51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        int[] iArr = new int[202];
        for (int i = 0; i < 202; i++) {
            iArr[i] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i) - 'E';
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51 c51Var, String str) {
        int indexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        char charAt = str.charAt(indexOf);
        int i = 16777218;
        if (charAt != 'F') {
            if (charAt == 'L') {
                return c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.substring(indexOf + 1, str.length() - 1)) | 24117248;
            }
            if (charAt != 'S') {
                if (charAt == 'V') {
                    return 0;
                }
                if (charAt != 'Z' && charAt != 'I') {
                    if (charAt == 'J') {
                        return 16777220;
                    }
                    switch (charAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return 16777219;
                        default:
                            int i2 = indexOf + 1;
                            while (str.charAt(i2) == '[') {
                                i2++;
                            }
                            char charAt2 = str.charAt(i2);
                            if (charAt2 != 'F') {
                                if (charAt2 == 'S') {
                                    i = 16777228;
                                } else if (charAt2 == 'Z') {
                                    i = 16777225;
                                } else if (charAt2 == 'I') {
                                    i = 16777217;
                                } else if (charAt2 != 'J') {
                                    switch (charAt2) {
                                        case 'B':
                                            i = 16777226;
                                            break;
                                        case 'C':
                                            i = 16777227;
                                            break;
                                        case 'D':
                                            i = 16777219;
                                            break;
                                        default:
                                            i = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.substring(i2 + 1, str.length() - 1)) | 24117248;
                                            break;
                                    }
                                } else {
                                    i = 16777220;
                                }
                            }
                            return ((i2 - indexOf) << 28) | i;
                    }
                }
            }
            return 16777217;
        }
        return 16777218;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 >= i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 - i;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww -= i - i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[10];
        }
        int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr, 0, length);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        }
        int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = i3 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        iArr2[i3] = i;
        k51 k51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i5 = k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i4;
        if (i5 > k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            return iArr[i2];
        }
        k51 k51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
        k51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        return 50331648 | (-i3);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (iArr == null || i >= iArr.length) {
            return i | 33554432;
        }
        int i2 = iArr[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = i | 33554432;
        iArr[i] = i3;
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[LOOP:0: B:6:0x0022->B:13:0x004d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51 c51Var, int i) {
        String str;
        int i2;
        if (i != 16777222) {
            if (((-1048576) & i) == 25165824) {
                str = c51Var.Wwwwwwwwwwwwwwwwwwwwwwww[1048575 & i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return i;
        }
        str = c51Var.Wwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) | 24117248;
        for (int i3 = 0; i3 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww; i3++) {
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
            int i5 = (-268435456) & i4;
            int i6 = 251658240 & i4;
            if (i6 == 33554432) {
                i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 & 8388607];
            } else {
                if (i6 == 50331648) {
                    int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i2 = iArr[iArr.length - (i4 & 8388607)];
                }
                if (i != i4) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            i4 = i2 + i5;
            if (i != i4) {
            }
        }
        return i;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[10];
        }
        int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr, 0, length);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r1.charAt(0) == '[') goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, c51 c51Var, j51 j51Var) {
        int i3;
        String str;
        int i4;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        if (i != 198 && i != 199) {
            switch (i) {
                case 0:
                    return;
                case 1:
                    i3 = 16777221;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 16:
                case 17:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777217);
                    return;
                case 9:
                case 10:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777220);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                    return;
                case 11:
                case 12:
                case 13:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777218);
                    return;
                case 14:
                case 15:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777219);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                    return;
                case 18:
                    int i5 = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i5 != 16) {
                        switch (i5) {
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                str = "java/lang/Class";
                                break;
                            case 8:
                                str = "java/lang/String";
                                break;
                            default:
                                str = "java/lang/invoke/MethodHandle";
                                break;
                        }
                    } else {
                        str = "java/lang/invoke/MethodType";
                    }
                    i3 = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) | 24117248;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                    return;
                default:
                    switch (i) {
                        case 21:
                            break;
                        case 22:
                            break;
                        case 23:
                            break;
                        case 24:
                            break;
                        case 25:
                            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                            return;
                        default:
                            switch (i) {
                                case 46:
                                case 51:
                                case 52:
                                case 53:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777217);
                                    return;
                                case 47:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777220);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                                    return;
                                case 48:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777218);
                                    return;
                                case 49:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777219);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                                    return;
                                case 50:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                    i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 268435456;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                    return;
                                case 54:
                                case 56:
                                case 58:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                    if (i2 <= 0) {
                                        return;
                                    }
                                    i4 = i2 - 1;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 16777220 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 16777219) {
                                        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 251658240) == 16777216) {
                                            return;
                                        }
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww | 8388608);
                                        return;
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, 16777216);
                                    return;
                                case 55:
                                case 57:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + 1, 16777216);
                                    if (i2 <= 0) {
                                        return;
                                    }
                                    i4 = i2 - 1;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 16777220 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 16777219) {
                                        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 251658240) == 16777216) {
                                            return;
                                        }
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww | 8388608);
                                        return;
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, 16777216);
                                    return;
                                default:
                                    switch (i) {
                                        case 79:
                                        case 81:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                            return;
                                        case 80:
                                        case 82:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                            return;
                                        case 87:
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case 170:
                                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1 /* 171 */:
                                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2 /* 172 */:
                                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
                                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                                        case 191:
                                        case 194:
                                        case 195:
                                            break;
                                        case 88:
                                        case Token.LETEXPR /* 159 */:
                                        case 160:
                                        case 161:
                                        case 162:
                                        case 163:
                                        case 164:
                                        case 165:
                                        case 166:
                                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3 /* 173 */:
                                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5 /* 175 */:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                            return;
                                        case 89:
                                            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 90:
                                            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 91:
                                            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 92:
                                            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 93:
                                            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 94:
                                            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 95:
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                                            return;
                                        case 96:
                                        case 100:
                                        case 104:
                                        case 108:
                                        case 112:
                                        case 120:
                                        case 122:
                                        case 124:
                                        case 126:
                                        case 128:
                                        case 130:
                                        case Token.JSR /* 136 */:
                                        case 142:
                                        case 149:
                                        case 150:
                                            break;
                                        case 97:
                                        case 101:
                                        case 105:
                                        case 109:
                                        case 113:
                                        case 127:
                                        case 129:
                                        case Token.LABEL /* 131 */:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777220);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                                            return;
                                        case 98:
                                        case 102:
                                        case 106:
                                        case 110:
                                        case 114:
                                        case Token.SCRIPT /* 137 */:
                                        case 144:
                                            break;
                                        case 99:
                                        case 103:
                                        case 107:
                                        case 111:
                                        case 115:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777219);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                                            return;
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 145:
                                        case 146:
                                        case 147:
                                        case 167:
                                        case 177:
                                            return;
                                        case 121:
                                        case 123:
                                        case 125:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777220);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                                            return;
                                        case Token.TARGET /* 132 */:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 16777217);
                                            return;
                                        case Token.LOOP /* 133 */:
                                        case 140:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777220);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                                            return;
                                        case Token.EXPR_VOID /* 134 */:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777218);
                                            return;
                                        case Token.EXPR_RESULT /* 135 */:
                                        case 141:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777219);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
                                            return;
                                        case Token.TYPEOFNAME /* 138 */:
                                            break;
                                        case Token.USE_STACK /* 139 */:
                                        case 190:
                                        case GpsStatusWrapper.QZSS_SVID_MIN /* 193 */:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777217);
                                            return;
                                        case 143:
                                            break;
                                        case 148:
                                        case 151:
                                        case 152:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777217);
                                            return;
                                        case TbsListener.ErrorCode.STARTDOWNLOAD_9 /* 168 */:
                                        case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
                                            throw new RuntimeException("JSR/RET are not supported with computeFrames option");
                                        case 178:
                                            str = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, str);
                                            return;
                                        case 179:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            return;
                                        case 180:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                            str = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, str);
                                            return;
                                        case 181:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            return;
                                        case 182:
                                        case 183:
                                        case 184:
                                        case NormalCmdFactory.TASK_CANCEL_ALL /* 185 */:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            if (i != 184) {
                                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                if (i == 183 && j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(0) == '<') {
                                                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new int[2];
                                                    }
                                                    int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.length;
                                                    int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                    if (i6 >= length) {
                                                        int[] iArr = new int[Math.max(i6 + 1, length * 2)];
                                                        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr, 0, length);
                                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
                                                    }
                                                    int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                    int i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i7 + 1;
                                                    iArr2[i7] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
                                                }
                                            }
                                            str = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, str);
                                            return;
                                        case NormalCmdFactory.TASK_RESTART /* 186 */:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                            str = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, str);
                                            return;
                                        case 187:
                                            i3 = 25165824 | c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 188:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            switch (i2) {
                                                case 4:
                                                    i3 = 285212681;
                                                    break;
                                                case 5:
                                                    i3 = 285212683;
                                                    break;
                                                case 6:
                                                    i3 = 285212674;
                                                    break;
                                                case 7:
                                                    i3 = 285212675;
                                                    break;
                                                case 8:
                                                    i3 = 285212682;
                                                    break;
                                                case 9:
                                                    i3 = 285212684;
                                                    break;
                                                case 10:
                                                    i3 = 285212673;
                                                    break;
                                                default:
                                                    i3 = 285212676;
                                                    break;
                                            }
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                            return;
                                        case 189:
                                            String str2 = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            if (str2.charAt(0) != '[') {
                                                i3 = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2) | 292552704;
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                                return;
                                            }
                                            StringBuffer stringBuffer = new StringBuffer();
                                            stringBuffer.append('[');
                                            stringBuffer.append(str2);
                                            str = stringBuffer.toString();
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, str);
                                            return;
                                        case 192:
                                            str = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            break;
                                        default:
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                            str = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, str);
                                            return;
                                    }
                            }
                    }
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51 c51Var, String str) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51Var, str);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 16777220 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 16777219) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16777216);
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c51 c51Var, int i, int[] iArr, int i2) {
        int min;
        int i3 = i;
        int i4 = iArr[i2];
        if (i4 == i3) {
            return false;
        }
        if ((268435455 & i3) == 16777221) {
            if (i4 == 16777221) {
                return false;
            }
            i3 = 16777221;
        }
        if (i4 == 0) {
            iArr[i2] = i3;
            return true;
        }
        int i5 = i4 & 267386880;
        int i6 = 16777216;
        int i7 = -268435456;
        if (i5 == 24117248 || (i4 & (-268435456)) != 0) {
            if (i3 == 16777221) {
                return false;
            }
            String str = "java/lang/Object";
            if ((i3 & (-1048576)) != ((-1048576) & i4)) {
                int i8 = i3 & 267386880;
                if (i8 == 24117248 || (i3 & (-268435456)) != 0) {
                    int i9 = i3 & (-268435456);
                    int i10 = ((i9 == 0 || i8 == 24117248) ? 0 : -268435456) + i9;
                    int i11 = i4 & (-268435456);
                    if (i11 == 0 || i5 == 24117248) {
                        i7 = 0;
                    }
                    min = Math.min(i10, i7 + i11);
                    i6 = min | 24117248 | c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                }
            } else if (i5 == 24117248) {
                int i12 = (i3 & (-268435456)) | 24117248;
                int i13 = i3 & 1048575;
                int i14 = 1048575 & i4;
                j51 j51Var = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 32;
                j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i13 | (i14 << 32);
                j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (i13 + 32 + i14) & Integer.MAX_VALUE;
                j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j51Var);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    j51[] j51VarArr = c51Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                    String str2 = j51VarArr[i13].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    String str3 = j51VarArr[i14].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    j51 j51Var2 = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    ClassLoader classLoader = c51.class.getClassLoader();
                    try {
                        Class<?> cls = Class.forName(str2.replace('/', '.'), false, classLoader);
                        Class<?> cls2 = Class.forName(str3.replace('/', '.'), false, classLoader);
                        if (cls.isAssignableFrom(cls2)) {
                            str = str2;
                        } else if (cls2.isAssignableFrom(cls)) {
                            str = str3;
                        } else if (!cls.isInterface() && !cls2.isInterface()) {
                            do {
                                cls = cls.getSuperclass();
                            } while (!cls.isAssignableFrom(cls2));
                            str = cls.getName().replace('.', '/');
                        }
                        j51Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new j51(0, c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                        c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } catch (Exception e) {
                        throw new RuntimeException(e.toString());
                    }
                }
                i6 = i12 | Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                min = (i4 & (-268435456)) - 268435456;
                i6 = min | 24117248 | c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            }
        } else if (i4 == 16777221) {
            if ((i3 & 267386880) != 24117248 && (i3 & (-268435456)) == 0) {
                i3 = 16777216;
            }
            i6 = i3;
        }
        if (i4 == i6) {
            return false;
        }
        iArr[i2] = i6;
        return true;
    }
}
