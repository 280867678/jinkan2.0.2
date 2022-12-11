package org.mozilla.classfile;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.location.GpsStatusWrapper;
import androidx.core.view.ViewCompat;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.lzf.easyfloat.permission.PermissionUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import me.tvspark.f21;
import me.tvspark.g21;
import me.tvspark.h21;
import me.tvspark.i21;
import me.tvspark.j21;
import me.tvspark.k21;
import me.tvspark.outline;
import me.tvspark.r40;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.UintMap;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class ClassFileWriter {
    public static final boolean Www;
    public static final int Wwww;
    public static final int Wwwww;
    public ObjArray Wwwwwwww;
    public int Wwwwwwwww;
    public long[] Wwwwwwwwww;
    public int Wwwwwwwwwww;
    public int[] Wwwwwwwwwwww;
    public short Wwwwwwwwwwwww;
    public short Wwwwwwwwwwwwww;
    public short Wwwwwwwwwwwwwww;
    public short Wwwwwwwwwwwwwwww;
    public short Wwwwwwwwwwwwwwwwwwww;
    public short Wwwwwwwwwwwwwwwwwwwww;
    public short Wwwwwwwwwwwwwwwwwwwwww;
    public g21 Wwwwwwwwwwwwwwwwwwwwwww;
    public h21 Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public i21[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public UintMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwww = new byte[256];
    public ObjArray Wwwwwwwwwwwwwwwwwww = new ObjArray();
    public ObjArray Wwwwwwwwwwwwwwwwww = new ObjArray();
    public ObjArray Wwwwwwwwwwwwwwwww = new ObjArray();
    public int Wwwwwww = 0;
    public char[] Wwwwww = new char[64];

    /* loaded from: classes5.dex */
    public static class ClassFileFormatException extends RuntimeException {
        public static final long serialVersionUID = 1263998431033790599L;

        public ClassFileFormatException(String str) {
            super(str);
        }
    }

    static {
        int i;
        boolean z = false;
        InputStream inputStream = null;
        try {
            inputStream = ClassFileWriter.class.getResourceAsStream("ClassFileWriter.class");
            if (inputStream == null) {
                inputStream = ClassLoader.getSystemResourceAsStream("org/mozilla/classfile/ClassFileWriter.class");
            }
            byte[] bArr = new byte[8];
            int i2 = 0;
            while (i2 < 8) {
                int read = inputStream.read(bArr, i2, 8 - i2);
                if (read < 0) {
                    throw new IOException();
                }
                i2 += read;
            }
            i = (bArr[4] << 8) | (bArr[5] & 255);
            try {
                int i3 = (bArr[7] & 255) | (bArr[6] << 8);
                Wwww = i;
                Wwwww = i3;
                if (i3 >= 50) {
                    z = true;
                }
                Www = z;
                if (inputStream == null) {
                    return;
                }
            } catch (Exception unused) {
                Wwww = i;
                Wwwww = 48;
                Www = false;
                if (inputStream == null) {
                    return;
                }
                inputStream.close();
            } catch (Throwable th) {
                th = th;
                Wwww = i;
                Wwwww = 48;
                Www = false;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            i = 0;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        try {
            inputStream.close();
        } catch (IOException unused4) {
        }
    }

    public ClassFileWriter(String str, String str2, String str3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        h21 h21Var = new h21(this);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h21Var;
        this.Wwwwwwwwwwwwwww = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        this.Wwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        if (str3 != null) {
            this.Wwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
        }
        this.Wwwwwwwwwwwwwwww = (short) 33;
    }

    public static int Wwwwwwwwwwwwwww(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 47:
            case 49:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case Token.TARGET /* 132 */:
            case Token.EXPR_VOID /* 134 */:
            case Token.TYPEOFNAME /* 138 */:
            case Token.USE_STACK /* 139 */:
            case 143:
            case 145:
            case 146:
            case 147:
            case 167:
            case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
            case 177:
            case 178:
            case 179:
            case 184:
            case NormalCmdFactory.TASK_RESTART /* 186 */:
            case 188:
            case 189:
            case 190:
            case 192:
            case GpsStatusWrapper.QZSS_SVID_MIN /* 193 */:
            case 196:
            case 200:
            case 202:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 44:
            case 45:
            case 89:
            case 90:
            case 91:
            case Token.LOOP /* 133 */:
            case Token.EXPR_RESULT /* 135 */:
            case 140:
            case 141:
            case TbsListener.ErrorCode.STARTDOWNLOAD_9 /* 168 */:
            case 187:
            case 197:
            case 201:
                return 1;
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 92:
            case 93:
            case 94:
                return 2;
            case 46:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 87:
            case 96:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 108:
            case 110:
            case 112:
            case 114:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 128:
            case 130:
            case Token.JSR /* 136 */:
            case Token.SCRIPT /* 137 */:
            case 142:
            case 144:
            case 149:
            case 150:
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
            case 180:
            case 181:
            case 182:
            case 183:
            case NormalCmdFactory.TASK_CANCEL_ALL /* 185 */:
            case 191:
            case 194:
            case 195:
            case 198:
            case PermissionUtils.requestCode /* 199 */:
                return -1;
            case 55:
            case 57:
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
            case 72:
            case 73:
            case 74:
            case 88:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 127:
            case 129:
            case Token.LABEL /* 131 */:
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
                return -2;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case 148:
            case 151:
            case 152:
                return -3;
            case 80:
            case 82:
                return -4;
            default:
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad opcode: ", i));
        }
    }

    public static void Wwwwwwwwwwwwwwww(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i < 0 ? "Stack underflow: " : "Too big stack: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int i;
        boolean z;
        char charAt;
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(41);
        if (3 <= length) {
            boolean z2 = false;
            if (str.charAt(0) == '(' && 1 <= lastIndexOf && (i = lastIndexOf + 1) < length) {
                int i2 = 1;
                int i3 = 0;
                int i4 = 0;
                while (i2 != lastIndexOf) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 != 'F') {
                        if (charAt2 != 'L') {
                            if (charAt2 != 'S' && charAt2 != 'I') {
                                if (charAt2 != 'J') {
                                    if (charAt2 != 'Z') {
                                        if (charAt2 != '[') {
                                            switch (charAt2) {
                                                case 'B':
                                                case 'C':
                                                    break;
                                                default:
                                                    z = false;
                                                    if (z) {
                                                        char charAt3 = str.charAt(i);
                                                        if (charAt3 != 'F' && charAt3 != 'L' && charAt3 != 'S') {
                                                            if (charAt3 != 'V') {
                                                                if (charAt3 != 'I') {
                                                                    if (charAt3 != 'J') {
                                                                        if (charAt3 != 'Z' && charAt3 != '[') {
                                                                            switch (charAt3) {
                                                                            }
                                                                            if (z2) {
                                                                                return (i4 << 16) | (65535 & i3);
                                                                            }
                                                                        }
                                                                    }
                                                                    i3++;
                                                                }
                                                            }
                                                            z2 = z;
                                                            if (z2) {
                                                            }
                                                        }
                                                        i3++;
                                                        z2 = z;
                                                        if (z2) {
                                                        }
                                                    }
                                                    break;
                                                case 'D':
                                                    i3--;
                                                    break;
                                            }
                                        } else {
                                            do {
                                                i2++;
                                                charAt = str.charAt(i2);
                                            } while (charAt == '[');
                                            if (charAt != 'F') {
                                                if (charAt != 'L') {
                                                    if (charAt != 'S' && charAt != 'Z' && charAt != 'I' && charAt != 'J') {
                                                        switch (charAt) {
                                                            case 'B':
                                                            case 'C':
                                                            case 'D':
                                                                break;
                                                            default:
                                                                z = false;
                                                                if (z) {
                                                                }
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i3--;
                            }
                        }
                        i3--;
                        i4++;
                        int i5 = i2 + 1;
                        int indexOf = str.indexOf(59, i5);
                        if (i5 + 1 <= indexOf && indexOf < lastIndexOf) {
                            i2 = indexOf + 1;
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    i3--;
                    i4++;
                    i2++;
                }
                z = true;
                if (z) {
                }
            }
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad parameter signature: ", str));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return str.replace('.', '/');
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        char charAt = str.charAt(0);
        if (charAt != 'F') {
            if (charAt == 'L') {
                return str.substring(1, str.length() - 1);
            }
            if (charAt == 'S' || charAt == 'V' || charAt == 'I' || charAt == 'J' || charAt == 'Z' || charAt == '[') {
                return str;
            }
            switch (charAt) {
                case 'B':
                case 'C':
                case 'D':
                    return str;
                default:
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bad descriptor:", str));
            }
        }
        return str;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int length = str.length();
        int i = length + 1;
        int i2 = i + 1;
        char[] cArr = new char[i2];
        cArr[0] = 'L';
        cArr[i] = BasicHeaderValueParser.PARAM_DELIMITER;
        str.getChars(0, length, cArr, 1);
        for (int i3 = 1; i3 != i; i3++) {
            if (cArr[i3] == '.') {
                cArr[i3] = '/';
            }
        }
        return new String(cArr, 0, i2);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        return i2 + 4;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        return i2 + 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClassFileWriter classFileWriter) {
        int i;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = new int[classFileWriter.Wwwwwwwwwwwwwwwwwwww];
        g21 g21Var = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwww;
        if ((g21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 8) == 0) {
            if ("<init>".equals(g21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                iArr[0] = 6;
            } else {
                iArr[0] = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(classFileWriter.Wwwwwwwwwwwwwww);
            }
            i = 1;
        } else {
            i = 0;
        }
        String str = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(41);
        if (indexOf != 0 || indexOf2 < 0) {
            throw new IllegalArgumentException("bad method type");
        }
        int i2 = indexOf + 1;
        StringBuilder sb = new StringBuilder();
        while (i2 < indexOf2) {
            char charAt = str.charAt(i2);
            if (charAt != 'F') {
                if (charAt == 'L') {
                    int indexOf3 = str.indexOf(59, i2) + 1;
                    sb.append(str.substring(i2, indexOf3));
                    i2 = indexOf3;
                } else if (charAt != 'S' && charAt != 'I' && charAt != 'J' && charAt != 'Z') {
                    if (charAt != '[') {
                        switch (charAt) {
                        }
                    } else {
                        sb.append('[');
                        i2++;
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString()), classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwww);
                int i3 = i + 1;
                iArr[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    i3++;
                }
                i = i3;
                sb.setLength(0);
            }
            sb.append(str.charAt(i2));
            i2++;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString()), classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwww);
            int i32 = i + 1;
            iArr[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            }
            i = i32;
            sb.setLength(0);
        }
        return iArr;
    }

    public final void Wwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, -1, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwww(int i) {
        if (i < 0) {
            int i2 = i & Integer.MAX_VALUE;
            if (i2 > this.Wwwwwwwwwww) {
                throw new IllegalArgumentException("Bad label");
            }
            int[] iArr = this.Wwwwwwwwwwww;
            if (iArr[i2] != -1) {
                throw new IllegalStateException("Can only mark label once");
            }
            iArr[i2] = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            return;
        }
        throw new IllegalArgumentException("Bad label, no biscuit");
    }

    public void Wwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwww = (short) 1;
        Wwwwwwwwwwwwwwwwww(i);
    }

    public int Wwwwwwwwwwwwwwwwwwww(int i) {
        if (i < 0) {
            int i2 = i & Integer.MAX_VALUE;
            if (i2 >= this.Wwwwwwwwwww) {
                throw new IllegalArgumentException("Bad label");
            }
            return this.Wwwwwwwwwwww[i2];
        }
        throw new IllegalArgumentException("Bad label, no biscuit");
    }

    public void Wwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwww + i;
        if (i2 < 0 || 32767 < i2) {
            Wwwwwwwwwwwwwwww(i2);
            throw null;
        }
        short s = (short) i2;
        this.Wwwwwwwwwwwwwwwwwwwwww = s;
        if (i2 <= this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = s;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwww(2));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (Www) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (iArr == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[4];
            } else {
                int length = iArr.length;
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (length == i2) {
                    int[] iArr2 = new int[i2 * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
                }
            }
            int[] iArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
            iArr3[i3] = i;
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i + i2;
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 > bArr.length) {
                int length = bArr.length * 2;
                if (i3 > length) {
                    length = i3;
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr2, 0, i2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = bArr2;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = i3;
            return i2;
        }
        throw new IllegalArgumentException("No method to add to");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        byte b;
        int i3 = (byte) i;
        if (i3 == i) {
            if (i == -1) {
                b = 2;
            } else if (i < 0 || i > 5) {
                i2 = 16;
            } else {
                b = (byte) (i + 3);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) b);
            return;
        }
        i3 = (short) i;
        if (i3 != i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            return;
        }
        i2 = 17;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        if (i == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        } else if (i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        } else if (i == 2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
        } else {
            if (i == 3) {
                i2 = 6;
            } else if (i == 4) {
                i2 = 7;
            } else if (i != 5) {
                h21 h21Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                byte[] bArr = h21Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = i3 + 1;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                bArr[i3] = 3;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, bArr, i4);
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwww.put(h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 3);
                int i5 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(18, (short) i5);
                return;
            } else {
                i2 = 8;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(59, 54, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(26, 21, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(71, 57, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(38, 24, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(75, 58, i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        Wwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        if (i3 != 0) {
            int i4 = 1;
            if (i3 != 1) {
                i4 = 2;
                if (i3 != 2) {
                    i4 = 3;
                    if (i3 != 3) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3);
                        return;
                    }
                }
            }
            i += i4;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i > i2) {
            throw new ClassFileFormatException("Bad bounds: " + i + TokenParser.f4579SP + i2);
        }
        int Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwww(170) + this.Wwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwww < 0 || 32767 < Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwww(Wwwwwwwwwwwwwww);
            throw null;
        }
        int i3 = (~this.Wwwwwwwwwwwwwwwwwwwwwwwww) & 3;
        int Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww((((i2 - i) + 1 + 3) * 4) + i3 + 1);
        int i4 = Wwwwwwwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww] = -86;
        while (i3 != 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i4] = 0;
            i3--;
            i4++;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, i4 + 4));
        short s = (short) Wwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = s;
        if (Wwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwww = s;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, 25, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        if (i3 < 0 || this.Wwwwwwwwwwwwwwwwwwwwwwwww < i3) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad jump target: ", i3));
        }
        if (i2 < -1) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad case index: ", i2));
        }
        int i4 = (~i) & 3;
        int i5 = i + 1 + i4;
        if (i2 >= 0) {
            i5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 3, 4, i5);
        }
        if (i >= 0) {
            int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (((i6 - 16) - i4) - 1 >= i) {
                byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((bArr[i] & 255) != 170) {
                    throw new IllegalArgumentException(i + " is not offset of tableswitch statement");
                } else if (i5 < 0 || i6 < i5 + 4) {
                    throw new ClassFileFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Too big case index: ", i2));
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 - i, bArr, i5);
                    return;
                }
            }
        }
        throw new IllegalArgumentException(i + " is outside a possible range of tableswitch in already generated code");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww >>> 16;
        int Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwww(i) + this.Wwwwwwwwwwwwwwwwwwwwww + ((short) Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwww >= 0 && 32767 >= Wwwwwwwwwwwwwww) {
            switch (i) {
                case 182:
                case 183:
                case 184:
                case NormalCmdFactory.TASK_CANCEL_ALL /* 185 */:
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
                    if (i == 185) {
                        h21 h21Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str3);
                        short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                        byte[] bArr = h21Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                        int i3 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i4 = i3 + 1;
                        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                        bArr[i3] = 11;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, bArr, i4);
                        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, h21Var.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                        j21 j21Var = new j21(str, str2, str3);
                        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwww.put(h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, j21Var);
                        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwww.put(h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 11);
                        int i5 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
                        Wwwwwwwwwwwwwwwwwwwwww((short) i5);
                        Wwwwwwwwwwwwwwwwwwwwwww(i2 + 1);
                        Wwwwwwwwwwwwwwwwwwwwwww(0);
                    } else {
                        h21 h21Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        if (h21Var2 != null) {
                            j21 j21Var2 = new j21(str, str2, str3);
                            int i6 = h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(j21Var2, -1);
                            if (i6 == -1) {
                                short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str3);
                                short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                                h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                                byte[] bArr2 = h21Var2.Wwwwwwwwwwwwwwwwwwwwwwww;
                                int i7 = h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i8 = i7 + 1;
                                h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
                                bArr2[i7] = 10;
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, bArr2, i8);
                                h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
                                h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, h21Var2.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                i6 = h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i6 + 1;
                                h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(j21Var2, i6);
                            }
                            h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww.put(i6, j21Var2);
                            h21Var2.Wwwwwwwwwwwwwwwwwwwwwwwww.put(i6, 10);
                            Wwwwwwwwwwwwwwwwwwwwww((short) i6);
                        } else {
                            throw null;
                        }
                    }
                    short s = (short) Wwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwww = s;
                    if (Wwwwwwwwwwwwwww <= this.Wwwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwww = s;
                    return;
                default:
                    throw new IllegalArgumentException("bad opcode for method reference");
            }
        }
        Wwwwwwwwwwwwwwww(Wwwwwwwwwwwwwww);
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int length = str.length();
        int i = 0;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 0, length);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, "java/lang/StringBuilder");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        Wwwwwwwwwwwwwwwwwwwwwwwwww(length);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, "java/lang/StringBuilder", "<init>", "(I)V");
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.substring(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == length) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/StringBuilder", AnnotationHandler.STRING, "()Ljava/lang/String;");
                return;
            }
            i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, length);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, short s) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = new g21(str, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), str2, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2), s);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new UintMap();
        this.Wwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwww;
        int[] iArr = this.Wwwwwwwwwwww;
        if (iArr == null || i == iArr.length) {
            int[] iArr2 = this.Wwwwwwwwwwww;
            if (iArr2 == null) {
                this.Wwwwwwwwwwww = new int[32];
            } else {
                int[] iArr3 = new int[iArr2.length * 2];
                System.arraycopy(iArr2, 0, iArr3, 0, i);
                this.Wwwwwwwwwwww = iArr3;
            }
        }
        this.Wwwwwwwwwww = i + 1;
        this.Wwwwwwwwwwww[i] = -1;
        return i | Integer.MIN_VALUE;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        if (i3 < 0 || i3 > this.Wwwwwwwwwwwwwwwwwwwww) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad stack index: ", i3));
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = (short) i3;
        Wwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, String str) {
        if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            if ((i2 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Bad endLabel");
            }
            if ((i3 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Bad handlerLabel");
            }
            i21 i21Var = new i21(i, i2, i3, str == null ? (short) 0 : this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i4 == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new i21[4];
            } else {
                i21[] i21VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i4 == i21VarArr.length) {
                    i21[] i21VarArr2 = new i21[i4 * 2];
                    System.arraycopy(i21VarArr, 0, i21VarArr2, 0, i4);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i21VarArr2;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4] = i21Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
            return;
        }
        throw new IllegalArgumentException("Bad startLabel");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, int i2) {
        int[] iArr = {this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2), i, i2};
        if (this.Wwwwwwww == null) {
            this.Wwwwwwww = new ObjArray();
        }
        this.Wwwwwwww.add(iArr);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, short s) {
        this.Wwwwwwwwwwwwwwwwww.add(new f21(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2), s));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(short s) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[16];
            } else {
                int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i == iArr.length) {
                    int[] iArr2 = new int[i * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = (this.Wwwwwwwwwwwwwwwwwwwwwwwww << 16) + s;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return;
        }
        throw new IllegalArgumentException("No method to stop");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? 4 : 3);
    }

    /* loaded from: classes5.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public k21[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public k21[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwww = false;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = i & 255;
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
            bArr[i3] = (byte) i2;
            if (i2 == 7 || i2 == 8) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >>> 8, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww << 32) | (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & ViewCompat.MEASURED_SIZE_MASK);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                int[] iArr = new int[Math.max(i2 * 2, 4)];
                System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            }
            int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
            iArr2[i3] = i;
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            return iArr[i];
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= i3) {
                int i4 = i + 1;
                int[] iArr = new int[i4];
                System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr, 0, i3);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = i2;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k21 k21Var) {
            if (k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k21Var);
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (j & 16777215));
            long j2 = j >>> 32;
            if (j2 != 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (j2 & 16777215));
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k21 k21Var) {
            if (!k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                k21[] k21VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i == k21VarArr.length) {
                    k21[] k21VarArr2 = new k21[i * 2];
                    System.arraycopy(k21VarArr, 0, k21VarArr2, 0, i);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k21VarArr2;
                }
                k21[] k21VarArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
                k21VarArr3[i2] = k21Var;
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int[] iArr2, int i) {
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i2 + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            bArr[i2] = -1;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, bArr, i3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr.length, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr2.length, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr2);
        }

        public final k21 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            k21 k21Var;
            int i2 = 0;
            while (true) {
                k21[] k21VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i2 >= k21VarArr.length || (k21Var = k21VarArr[i2]) == null) {
                    break;
                } else if (i >= k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && i < k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return k21Var;
                } else {
                    i2++;
                }
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bad offset: ", i));
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] : 0;
            int i3 = i2 & 255;
            if (i3 == 7 || i3 == 6 || i3 == 8 || i3 == 5) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                return;
            }
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bad local variable type: ", i2, " at index: ", i));
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0123, code lost:
            if (r1.equals(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED) == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x01a1, code lost:
            if (r1.equals(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED) == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x03a5, code lost:
            if (r1 != false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x03a8, code lost:
            if (r1 != false) goto L90;
         */
        /* JADX WARN: Removed duplicated region for block: B:239:0x04a7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:247:0x0000 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x03ae  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x03b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            boolean z;
            int i;
            int i2;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
            int i3;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z2;
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            char c;
            while (true) {
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i4 > 0) {
                    k21[] k21VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i5 = i4 - 1;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                    k21 k21Var = k21VarArr[i5];
                    int i6 = 0;
                    k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    int[] iArr = k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int[] iArr2 = new int[iArr.length];
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
                    int[] iArr3 = k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int length = iArr3.length;
                    int[] iArr4 = new int[length];
                    System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr4;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
                    int i7 = k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i8 = 0;
                    while (i7 < k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        byte[] bArr = ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i9 = bArr[i7] & 255;
                        int i10 = bArr[i7] & 255;
                        switch (i10) {
                            case 0:
                            case Token.TARGET /* 132 */:
                            case 167:
                            case 200:
                                i = 0;
                                break;
                            case 1:
                                i2 = 5;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                i = 0;
                                break;
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 16:
                            case 17:
                            case 21:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                i = 0;
                                break;
                            case 9:
                            case 10:
                            case 22:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                                i2 = 4;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                i = 0;
                                break;
                            case 11:
                            case 12:
                            case 13:
                            case 23:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                i = 0;
                                break;
                            case 14:
                            case 15:
                            case 24:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                                i2 = 3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                i = 0;
                                break;
                            case 18:
                            case 19:
                            case 20:
                                int i11 = i7 + 1;
                                if (i10 == 18) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11, 1);
                                } else {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11, 2);
                                }
                                byte b = (byte) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww.getInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
                                if (b != 3) {
                                    if (b != 4) {
                                        if (b != 5) {
                                            if (b != 6) {
                                                if (b != 8) {
                                                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bad const type ", (int) b));
                                                }
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("java/lang/String", ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                                i = 0;
                                                break;
                                            }
                                            i2 = 3;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                            i = 0;
                                        }
                                        i2 = 4;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                        i = 0;
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    i = 0;
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                i = 0;
                            case 25:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwww ? 2 : 1);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                i = 0;
                                break;
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = i10 - 42;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                i = 0;
                                break;
                            case 46:
                            case 51:
                            case 52:
                            case 53:
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
                            case 148:
                            case 149:
                            case 150:
                            case 151:
                            case 152:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                i = 0;
                                break;
                            case 47:
                            case 97:
                            case 101:
                            case 105:
                            case 109:
                            case 113:
                            case 121:
                            case 123:
                            case 125:
                            case 127:
                            case 129:
                            case Token.LABEL /* 131 */:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i2 = 4;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                i = 0;
                                break;
                            case 48:
                            case 98:
                            case 102:
                            case 106:
                            case 110:
                            case 114:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                i = 0;
                                break;
                            case 49:
                            case 99:
                            case 103:
                            case 107:
                            case 111:
                            case 115:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i2 = 3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                i = 0;
                                break;
                            case 50:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                String str = (String) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >>> 8);
                                if (str.charAt(0) != '[') {
                                    throw new IllegalStateException("bad array type");
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.substring(1)));
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 54:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwww ? 2 : 1);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, 1);
                                i = 0;
                                break;
                            case 55:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwww ? 2 : 1);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i3 = 4;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, i3);
                                i = 0;
                                break;
                            case 56:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwww ? 2 : 1);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, 2);
                                i = 0;
                                break;
                            case 57:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwww ? 2 : 1);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i3 = 3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, i3);
                                i = 0;
                                break;
                            case 58:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, this.Wwwwwwwwwwwwwwwwwwwwwwwww ? 2 : 1);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                i = 0;
                                break;
                            case 59:
                            case 60:
                            case 61:
                            case 62:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = i10 - 59;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, 1);
                                i = 0;
                                break;
                            case 63:
                            case 64:
                            case 65:
                            case 66:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = i10 - 63;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i3 = 4;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, i3);
                                i = 0;
                                break;
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = i10 - 67;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, 2);
                                i = 0;
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = i10 - 71;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i3 = 3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, i3);
                                i = 0;
                                break;
                            case 75:
                            case 76:
                            case 77:
                            case 78:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = i10 - 75;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                i = 0;
                                break;
                            case 79:
                            case 80:
                            case 81:
                            case 82:
                            case 83:
                            case 84:
                            case 85:
                            case 86:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i = 0;
                                break;
                            case 87:
                            case 153:
                            case 154:
                            case 155:
                            case 156:
                            case 157:
                            case 158:
                            case 179:
                            case 194:
                            case 195:
                            case 198:
                            case PermissionUtils.requestCode /* 199 */:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i = 0;
                                break;
                            case 88:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i = 0;
                                break;
                            case 89:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 90:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 91:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 92:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                i = 0;
                                break;
                            case 93:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                i = 0;
                                break;
                            case 94:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                i = 0;
                                break;
                            case 95:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 116:
                            case Token.JSR /* 136 */:
                            case Token.USE_STACK /* 139 */:
                            case 142:
                            case 145:
                            case 146:
                            case 147:
                            case 190:
                            case GpsStatusWrapper.QZSS_SVID_MIN /* 193 */:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                i = 0;
                                break;
                            case 117:
                            case Token.LOOP /* 133 */:
                            case 140:
                            case 143:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i2 = 4;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                i = 0;
                                break;
                            case 118:
                            case Token.EXPR_VOID /* 134 */:
                            case Token.SCRIPT /* 137 */:
                            case 144:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                i = 0;
                                break;
                            case 119:
                            case Token.EXPR_RESULT /* 135 */:
                            case Token.TYPEOFNAME /* 138 */:
                            case 141:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i2 = 3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                i = 0;
                                break;
                            case Token.LETEXPR /* 159 */:
                            case 160:
                            case 161:
                            case 162:
                            case 163:
                            case 164:
                            case 165:
                            case 166:
                            case 181:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i = 0;
                                break;
                            case TbsListener.ErrorCode.STARTDOWNLOAD_9 /* 168 */:
                            case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1 /* 171 */:
                            case 197:
                            default:
                                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bad opcode: ", i10));
                            case 170:
                                int i12 = i7 + 1 + ((~i7) & 3);
                                i = ((((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i12 + 8, 4) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i12 + 4, 4)) + 4) * 4) + i12) - i7;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                break;
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2 /* 172 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3 /* 173 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5 /* 175 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                            case 177:
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                                i = 0;
                                break;
                            case 178:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((j21) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 2))).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 180:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((j21) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 2))).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 182:
                            case 183:
                            case 184:
                            case NormalCmdFactory.TASK_CANCEL_ALL /* 185 */:
                                j21 j21Var = (j21) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 2));
                                String str2 = j21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                String str3 = j21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2) >>> 16;
                                for (int i13 = 0; i13 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwww; i13++) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                }
                                if (i10 != 184 && ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) & 255) == 8 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 6)) {
                                    if ("<init>".equals(str3)) {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClassFileWriter.this.Wwwwwwwwwwwwwww);
                                        int[] iArr5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        int i14 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        for (int i15 = 0; i15 < i14; i15++) {
                                            if (iArr5[i15] == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                                                iArr5[i15] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                                            }
                                        }
                                        int[] iArr6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        int i16 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        for (int i17 = 0; i17 < i16; i17++) {
                                            if (iArr6[i17] == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                                                iArr6[i17] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                                            }
                                        }
                                    } else {
                                        throw new IllegalStateException("bad instance");
                                    }
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2.substring(str2.indexOf(41) + 1));
                                break;
                            case NormalCmdFactory.TASK_RESTART /* 186 */:
                                String str4 = (String) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 2));
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4) >>> 16;
                                for (int i18 = 0; i18 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2; i18++) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4.substring(str4.indexOf(41) + 1));
                                break;
                            case 187:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((65535 & i7) << 8) | 8;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 188:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                switch (ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i7 + 1]) {
                                    case 4:
                                        c = 'Z';
                                        break;
                                    case 5:
                                        c = 'C';
                                        break;
                                    case 6:
                                        c = 'F';
                                        break;
                                    case 7:
                                        c = 'D';
                                        break;
                                    case 8:
                                        c = 'B';
                                        break;
                                    case 9:
                                        c = 'S';
                                        break;
                                    case 10:
                                        c = 'I';
                                        break;
                                    case 11:
                                        c = 'J';
                                        break;
                                    default:
                                        throw new IllegalArgumentException("bad operand");
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[" + c);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 189:
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 2);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[L" + ((String) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10)) + BasicHeaderValueParser.PARAM_DELIMITER, ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 191:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 192:
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 2);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                i = 0;
                                break;
                            case 196:
                                this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
                                i = 0;
                                break;
                        }
                        if (i == 0) {
                            boolean z3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i10 != 254 && i10 != 255) {
                                switch (i10) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                    case 33:
                                    case 34:
                                    case 35:
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                    case 40:
                                    case 41:
                                    case 42:
                                    case 43:
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 59:
                                    case 60:
                                    case 61:
                                    case 62:
                                    case 63:
                                    case 64:
                                    case 65:
                                    case 66:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                    case 75:
                                    case 76:
                                    case 77:
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                    case 87:
                                    case 88:
                                    case 89:
                                    case 90:
                                    case 91:
                                    case 92:
                                    case 93:
                                    case 94:
                                    case 95:
                                    case 96:
                                    case 97:
                                    case 98:
                                    case 99:
                                    case 100:
                                    case 101:
                                    case 102:
                                    case 103:
                                    case 104:
                                    case 105:
                                    case 106:
                                    case 107:
                                    case 108:
                                    case 109:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case 127:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case Token.LABEL /* 131 */:
                                    case Token.LOOP /* 133 */:
                                    case Token.EXPR_VOID /* 134 */:
                                    case Token.EXPR_RESULT /* 135 */:
                                    case Token.JSR /* 136 */:
                                    case Token.SCRIPT /* 137 */:
                                    case Token.TYPEOFNAME /* 138 */:
                                    case Token.USE_STACK /* 139 */:
                                    case 140:
                                    case 141:
                                    case 142:
                                    case 143:
                                    case 144:
                                    case 145:
                                    case 146:
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    case 151:
                                    case 152:
                                        break;
                                    case 16:
                                    case 18:
                                        i = 2;
                                        break;
                                    case 17:
                                    case 19:
                                    case 20:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case Token.LETEXPR /* 159 */:
                                    case 160:
                                    case 161:
                                    case 162:
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case 167:
                                    case TbsListener.ErrorCode.STARTDOWNLOAD_9 /* 168 */:
                                        i = 3;
                                        break;
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                    case 58:
                                    case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
                                        break;
                                    case Token.TARGET /* 132 */:
                                        break;
                                    default:
                                        switch (i10) {
                                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2 /* 172 */:
                                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3 /* 173 */:
                                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
                                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5 /* 175 */:
                                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                                            case 177:
                                            case 190:
                                            case 191:
                                            case 194:
                                            case 195:
                                            case 196:
                                            case 202:
                                                break;
                                            case 178:
                                            case 179:
                                            case 180:
                                            case 181:
                                            case 182:
                                            case 183:
                                            case 184:
                                            case 187:
                                            case 189:
                                            case 192:
                                            case GpsStatusWrapper.QZSS_SVID_MIN /* 193 */:
                                            case 198:
                                            case PermissionUtils.requestCode /* 199 */:
                                                break;
                                            case NormalCmdFactory.TASK_CANCEL_ALL /* 185 */:
                                            case NormalCmdFactory.TASK_RESTART /* 186 */:
                                            case 200:
                                            case 201:
                                                i = 5;
                                                break;
                                            case 188:
                                                break;
                                            case 197:
                                                i = 4;
                                                break;
                                            default:
                                                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad opcode: ", i10));
                                        }
                                }
                            }
                            i = 1;
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwww && i10 != 196) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwww = false;
                        }
                        switch (i9) {
                            default:
                                switch (i9) {
                                    case 198:
                                    case PermissionUtils.requestCode /* 199 */:
                                    case 200:
                                        break;
                                    default:
                                        z2 = false;
                                        break;
                                }
                            case 153:
                            case 154:
                            case 155:
                            case 156:
                            case 157:
                            case 158:
                            case Token.LETEXPR /* 159 */:
                            case 160:
                            case 161:
                            case 162:
                            case 163:
                            case 164:
                            case 165:
                            case 166:
                            case 167:
                                z2 = true;
                                break;
                        }
                        if (z2) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i7] & 255) == 200 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 4) : (short) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 + 1, 2)) + i7));
                        } else if (i9 == 170) {
                            int i19 = i7 + 1 + ((~i7) & 3);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19, 4) + i7));
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19 + 8, 4) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19 + 4, 4)) + 1;
                            int i20 = i19 + 12;
                            for (int i21 = 0; i21 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11; i21++) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i21 * 4) + i20, 4) + i7));
                            }
                        }
                        int i22 = 0;
                        while (true) {
                            ClassFileWriter classFileWriter = ClassFileWriter.this;
                            if (i22 < classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                i21 i21Var = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i22];
                                short Wwwwwwwwwwwwwwwwwwww = (short) classFileWriter.Wwwwwwwwwwwwwwwwwwww(i21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                short Wwwwwwwwwwwwwwwwwwww2 = (short) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwww(i21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                if (i7 >= Wwwwwwwwwwwwwwwwwwww && i7 < Wwwwwwwwwwwwwwwwwwww2) {
                                    k21 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwww(i21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                    short s = i21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (s == 0) {
                                        s = ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("java/lang/Throwable");
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new int[]{r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s)}, 1, ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                }
                                i22++;
                            }
                        }
                        i7 += i;
                        i6 = 0;
                        i8 = i9;
                    }
                    if (i8 != 167 && i8 != 191 && i8 != 200 && i8 != 176 && i8 != 177) {
                        switch (i8) {
                            case 170:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1 /* 171 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2 /* 172 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3 /* 173 */:
                            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
                                break;
                            default:
                                z = false;
                                break;
                        }
                        if (z) {
                            int i23 = k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                            k21[] k21VarArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i23 < k21VarArr2.length) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k21VarArr2[i23]);
                            }
                        }
                    }
                    z = true;
                    if (z) {
                    }
                } else {
                    return;
                }
            }
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            if (i2 <= 4) {
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    i3 = (i3 << 8) | (ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i + i4] & 255);
                }
                return i3;
            }
            throw new IllegalArgumentException("bad operand size");
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr) {
            for (int i : iArr) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        char c;
        if (i != 254 && i != 255) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case Token.LABEL /* 131 */:
                case Token.LOOP /* 133 */:
                case Token.EXPR_VOID /* 134 */:
                case Token.EXPR_RESULT /* 135 */:
                case Token.JSR /* 136 */:
                case Token.SCRIPT /* 137 */:
                case Token.TYPEOFNAME /* 138 */:
                case Token.USE_STACK /* 139 */:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2 /* 172 */:
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3 /* 173 */:
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5 /* 175 */:
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                case 177:
                    break;
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
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case Token.LETEXPR /* 159 */:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case TbsListener.ErrorCode.STARTDOWNLOAD_9 /* 168 */:
                case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case NormalCmdFactory.TASK_CANCEL_ALL /* 185 */:
                    c = 1;
                    break;
                case Token.TARGET /* 132 */:
                    c = 2;
                    break;
                case 170:
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1 /* 171 */:
                    c = 65535;
                    break;
                default:
                    switch (i) {
                        case 187:
                        case 188:
                        case 189:
                        case 192:
                        case GpsStatusWrapper.QZSS_SVID_MIN /* 193 */:
                        case 198:
                        case PermissionUtils.requestCode /* 199 */:
                        case 200:
                        case 201:
                            break;
                        case 190:
                        case 191:
                        case 194:
                        case 195:
                        case 196:
                        case 202:
                            break;
                        case 197:
                            break;
                        default:
                            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad opcode: ", i));
                    }
            }
            if (c == 0) {
                throw new IllegalArgumentException("Unexpected operands");
            }
            int Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwww(i) + this.Wwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwww < 0 || 32767 < Wwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwww(Wwwwwwwwwwwwwww);
                throw null;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
            short s = (short) Wwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = s;
            if (Wwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = s;
            }
            if (i != 191) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        c = 0;
        if (c == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwww(i) + this.Wwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwww < 0 || 32767 < Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwww(Wwwwwwwwwwwwwww);
            throw null;
        }
        if (i == 180 || i == 181) {
            if (i2 < 0 || i2 >= 65536) {
                throw new IllegalArgumentException("out of range field");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwww(2));
        } else if (i != 188) {
            if (i != 198 && i != 199) {
                switch (i) {
                    case 16:
                        byte b = (byte) i2;
                        if (b != i2) {
                            throw new IllegalArgumentException("out of range byte");
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
                        Wwwwwwwwwwwwwwwwwwwwwww(b);
                        break;
                    case 17:
                        if (((short) i2) == i2) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwww(2));
                            break;
                        } else {
                            throw new IllegalArgumentException("out of range short");
                        }
                    case 18:
                    case 19:
                    case 20:
                        if (i2 >= 0 && i2 < 65536) {
                            if (i2 < 256 && i != 19 && i != 20) {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i2;
                                break;
                            } else {
                                if (i == 18) {
                                    Wwwwwwwwwwwwwwwwwwwwwww(19);
                                } else {
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwww(2));
                                break;
                            }
                        } else {
                            throw new ClassFileFormatException("out of range index");
                        }
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        if (i2 >= 0 && 65536 > i2) {
                            if (i2 >= 256) {
                                Wwwwwwwwwwwwwwwwwwwwwww(196);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwww(2));
                                break;
                            } else {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i2;
                                break;
                            }
                        } else {
                            throw new ClassFileFormatException("out of range variable");
                        }
                    default:
                        switch (i) {
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                            case 58:
                                break;
                            default:
                                switch (i) {
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case Token.LETEXPR /* 159 */:
                                    case 160:
                                    case 161:
                                    case 162:
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case TbsListener.ErrorCode.STARTDOWNLOAD_9 /* 168 */:
                                        break;
                                    case 167:
                                        Wwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww + 3);
                                        break;
                                    case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Unexpected opcode for 1 operand");
                                }
                        }
                }
            }
            int i3 = i2 & Integer.MIN_VALUE;
            if (i3 != Integer.MIN_VALUE && (i2 < 0 || i2 > 65535)) {
                throw new IllegalArgumentException("Bad label for branch");
            }
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
            if (i3 != Integer.MIN_VALUE) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwww(2));
                int i5 = i2 + i4;
                Wwwwwwwwwwwwwwwwwwwwwwww(i5);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i5, i4);
            } else {
                int Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwww(i2);
                if (Wwwwwwwwwwwwwwwwwwww != -1) {
                    Wwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwww - i4);
                    Wwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Wwwwwwwwwwwwwwwwwwww, i4);
                } else {
                    int i6 = i4 + 1;
                    if (i2 >= 0) {
                        throw new IllegalArgumentException("Bad label, no biscuit");
                    }
                    int i7 = Integer.MAX_VALUE & i2;
                    if (i7 < this.Wwwwwwwwwww) {
                        int i8 = this.Wwwwwwwww;
                        long[] jArr = this.Wwwwwwwwww;
                        if (jArr == null || i8 == jArr.length) {
                            long[] jArr2 = this.Wwwwwwwwww;
                            if (jArr2 == null) {
                                this.Wwwwwwwwww = new long[40];
                            } else {
                                long[] jArr3 = new long[jArr2.length * 2];
                                System.arraycopy(jArr2, 0, jArr3, 0, i8);
                                this.Wwwwwwwwww = jArr3;
                            }
                        }
                        this.Wwwwwwwww = i8 + 1;
                        this.Wwwwwwwwww[i8] = (i7 << 32) | i6;
                        Wwwwwwwwwwwwwwwwwwwwww(0);
                    } else {
                        throw new IllegalArgumentException("Bad label");
                    }
                }
            }
        } else if (i2 >= 0 && i2 < 256) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i2;
        } else {
            throw new IllegalArgumentException("out of range index");
        }
        short s = (short) Wwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = s;
        if (Wwwwwwwwwwwwwww <= this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = s;
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(short s) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        int i2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        short s2;
        ClassFileWriter classFileWriter;
        int[] iArr;
        ClassFileWriter classFileWriter2;
        ClassFileWriter classFileWriter3;
        int i3;
        k21 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = 0;
            for (int i6 = 0; i6 < this.Wwwwwwwww; i6++) {
                long j = this.Wwwwwwwwww[i6];
                int i7 = (int) j;
                int i8 = this.Wwwwwwwwwwww[(int) (j >> 32)];
                if (i8 == -1) {
                    throw new RuntimeException("unlocated label");
                }
                Wwwwwwwwwwwwwwwwwwwwwwww(i8);
                int i9 = i7 - 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i8, i9);
                int i10 = i8 - i9;
                if (((short) i10) != i10) {
                    throw new ClassFileFormatException("Program too complex: too big jump offset");
                }
                bArr[i7] = (byte) (i10 >> 8);
                bArr[i7 + 1] = (byte) i10;
            }
            this.Wwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwww = s;
            boolean z = Www;
            int i11 = 1;
            if (z) {
                if (z) {
                    for (int i12 = 0; i12 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww; i12++) {
                        Wwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i12].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    Arrays.sort(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    int i13 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
                    int i14 = 1;
                    for (int i15 = 1; i15 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i15++) {
                        int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i16 = iArr2[i15];
                        if (i13 != i16) {
                            if (i14 != i15) {
                                iArr2[i14] = i16;
                            }
                            i14++;
                            i13 = i16;
                        }
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i14;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i14 - 1] == this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i14 - 1;
                    }
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ClassFileWriter classFileWriter4 = ClassFileWriter.this;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new k21[classFileWriter4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(classFileWriter4);
                int i17 = 0;
                while (true) {
                    ClassFileWriter classFileWriter5 = ClassFileWriter.this;
                    int i18 = classFileWriter5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i17 >= i18) {
                        break;
                    }
                    int[] iArr3 = classFileWriter5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i19 = iArr3[i17];
                    if (i17 == i18 - 1) {
                        i4 = classFileWriter5.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        i4 = iArr3[i17 + 1];
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i17] = new k21(i17, i19, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    i17++;
                }
                k21[] k21VarArr = new k21[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.length];
                int i20 = 0;
                while (true) {
                    classFileWriter = ClassFileWriter.this;
                    if (i20 >= classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        break;
                    }
                    i21 i21Var = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i20];
                    k21VarArr[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwww(i21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) classFileWriter.Wwwwwwwwwwwwwwwwwwww(i21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    i20++;
                }
                int[] keys = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getKeys();
                for (int i21 : keys) {
                    k21VarArr[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i21).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(i21, -1));
                }
                int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClassFileWriter.this);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[0].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.length, new int[0], 0, ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k21[]{wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[0]};
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int i22 = 0;
                while (true) {
                    k21[] k21VarArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i22 >= k21VarArr2.length) {
                        break;
                    }
                    k21 k21Var = k21VarArr2[i22];
                    if (!k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        int[] iArr4 = new int[0];
                        int[] iArr5 = {r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("java/lang/Throwable", ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwww)};
                        int i23 = 0;
                        while (true) {
                            ClassFileWriter classFileWriter6 = ClassFileWriter.this;
                            if (i23 >= classFileWriter6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                iArr = iArr4;
                                break;
                            }
                            i21 i21Var2 = classFileWriter6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i23];
                            int Wwwwwwwwwwwwwwwwwwww = classFileWriter6.Wwwwwwwwwwwwwwwwwwww(i21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            int Wwwwwwwwwwwwwwwwwwww2 = ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwww(i21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwww(i21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                            int i24 = k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if ((i24 <= Wwwwwwwwwwwwwwwwwwww || i24 >= Wwwwwwwwwwwwwwwwwwww2) && (Wwwwwwwwwwwwwwwwwwww <= k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || Wwwwwwwwwwwwwwwwwwww >= k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                i23++;
                            }
                        }
                        int[] iArr6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int[] iArr7 = new int[iArr6.length];
                        System.arraycopy(iArr6, 0, iArr7, 0, iArr6.length);
                        iArr = iArr7;
                        int i25 = 0;
                        while (true) {
                            classFileWriter2 = ClassFileWriter.this;
                            if (i25 >= classFileWriter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                break;
                            }
                            if (classFileWriter2.Wwwwwwwwwwwwwwwwwwww(classFileWriter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i25].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                int i26 = i25 + 1;
                                while (true) {
                                    classFileWriter3 = ClassFileWriter.this;
                                    i3 = classFileWriter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (i26 >= i3) {
                                        break;
                                    }
                                    i21[] i21VarArr = classFileWriter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i21VarArr[i26 - 1] = i21VarArr[i26];
                                    i26++;
                                }
                                classFileWriter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 - 1;
                                i25--;
                            }
                            i25++;
                        }
                        k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, iArr.length, iArr5, 1, classFileWriter2.Wwwwwwwwwwwwwwwwwwwwwwww);
                        int i27 = k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                        ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i27] = -65;
                        for (int i28 = k21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i28 < i27; i28++) {
                            ClassFileWriter.this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i28] = 0;
                        }
                    }
                    i22++;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
            int i29 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww * 4) + 8 : 0;
            ObjArray objArray = this.Wwwwwwww;
            int size = objArray != null ? (objArray.size() * 10) + 8 : 0;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                k21[] k21VarArr3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ClassFileWriter classFileWriter7 = ClassFileWriter.this;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[((classFileWriter7.Wwwwwwwwwwwwwwwwwwwww * 3) + (classFileWriter7.Wwwwwwwwwwwwwwwwwwww * 3) + 7) * (k21VarArr3.length - 1)];
                int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = k21VarArr3[0].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int i30 = 1;
                int i31 = -1;
                while (true) {
                    k21[] k21VarArr4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i30 >= k21VarArr4.length) {
                        break;
                    }
                    k21 k21Var2 = k21VarArr4[i30];
                    int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = k21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int[] iArr8 = k21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int length = iArr8.length;
                    int[] iArr9 = new int[length];
                    System.arraycopy(iArr8, i5, iArr9, i5, iArr8.length);
                    int i32 = (k21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i31) - i11;
                    if (length == 0) {
                        int length2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.length > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.length ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.length : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.length;
                        int abs = Math.abs(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.length - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.length);
                        int i33 = 0;
                        while (i33 < length2 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5[i33] == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6[i33]) {
                            i33++;
                        }
                        if (i33 == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.length && abs == 0) {
                            byte[] bArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i34 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i35 = i34 + 1;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = i35;
                            if (i32 <= 63) {
                                bArr2[i34] = (byte) i32;
                            } else {
                                bArr2[i34] = -5;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i32, bArr2, i35);
                            }
                        } else if (i33 == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.length && abs <= 3) {
                            byte[] bArr3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i36 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i37 = i36 + 1;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = i37;
                            bArr3[i36] = (byte) (251 - abs);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i32, bArr3, i37);
                        } else {
                            if (i33 == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.length && abs <= 3) {
                                byte[] bArr4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i38 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i39 = i38 + 1;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = i39;
                                bArr4[i38] = (byte) (abs + TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i32, bArr4, i39);
                                for (int length3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.length - abs; length3 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.length; length3++) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6[length3]);
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, iArr9, i32);
                        }
                    } else {
                        if (length == 1 && Arrays.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6)) {
                            byte[] bArr5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i40 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i41 = i40 + 1;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = i41;
                            if (i32 <= 63) {
                                bArr5[i40] = (byte) (i32 + 64);
                            } else {
                                bArr5[i40] = -9;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i32, bArr5, i41);
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr9[0]);
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, iArr9, i32);
                    }
                    i31 = k21Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i30++;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                    i5 = 0;
                    i11 = 1;
                }
                int i42 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww + 2;
                if (i42 > 0) {
                    i = i42 + 6;
                    i2 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww * 8) + this.Wwwwwwwwwwwwwwwwwwwwwwwww + 14 + 2 + 2 + i29 + size + i;
                    if (i2 <= 65536) {
                        throw new ClassFileFormatException("generated bytecode for method exceeds 64K limit.");
                    }
                    byte[] bArr6 = new byte[i2];
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 - 6, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Code"), bArr6, 0)))));
                    System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
                    int i43 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    int i44 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i44 > 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i44, bArr6, i43);
                        for (int i45 = 0; i45 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww; i45++) {
                            i21 i21Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i45];
                            short Wwwwwwwwwwwwwwwwwwww3 = (short) Wwwwwwwwwwwwwwwwwwww(i21Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            short Wwwwwwwwwwwwwwwwwwww4 = (short) Wwwwwwwwwwwwwwwwwwww(i21Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            short Wwwwwwwwwwwwwwwwwwww5 = (short) Wwwwwwwwwwwwwwwwwwww(i21Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            short s3 = i21Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (Wwwwwwwwwwwwwwwwwwww3 == -1) {
                                throw new IllegalStateException("start label not defined");
                            }
                            if (Wwwwwwwwwwwwwwwwwwww4 == -1) {
                                throw new IllegalStateException("end label not defined");
                            }
                            if (Wwwwwwwwwwwwwwwwwwww5 == -1) {
                                throw new IllegalStateException("handler label not defined");
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s3, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwww5, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwww4, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwww3, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2))));
                        }
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, bArr6, i43);
                    }
                    int i46 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? 1 : 0;
                    if (this.Wwwwwwww != null) {
                        i46++;
                    }
                    if (i > 0) {
                        i46++;
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i46, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((this.Wwwwwwwwwwwwwwwwwwwwwwwwwww * 4) + 2, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LineNumberTable"), bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7)));
                        for (int i47 = 0; i47 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwww; i47++) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i47], bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                        }
                    }
                    if (this.Wwwwwwww != null) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LocalVariableTable"), bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                        int size2 = this.Wwwwwwww.size();
                        char c = 2;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size2, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((size2 * 10) + 2, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8));
                        int i48 = 0;
                        while (i48 < size2) {
                            int[] iArr10 = (int[]) this.Wwwwwwww.get(i48);
                            int i49 = iArr10[0];
                            int i50 = iArr10[1];
                            int i51 = iArr10[c];
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr10[3], bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i50, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i49, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww - i51, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i51, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9)))));
                            i48++;
                            c = 2;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                    }
                    if (i > 0) {
                        s2 = 0;
                        System.arraycopy(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.length - 1, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww + 2, bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("StackMapTable"), bArr6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7))), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        s2 = 0;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr6;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = s2;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = s2;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = s2;
                    this.Wwwwwwwwwwwwwwwwwwwwwww = null;
                    this.Wwwwwwwwwwwwwwwwwwwww = s2;
                    this.Wwwwwwwwwwwwwwwwwwwwww = s2;
                    this.Wwwwwwwwwww = s2;
                    this.Wwwwwwwww = s2;
                    this.Wwwwwwww = null;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s2;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    return;
                }
            }
            i = 0;
            i2 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww * 8) + this.Wwwwwwwwwwwwwwwwwwwwwwwww + 14 + 2 + 2 + i29 + size + i;
            if (i2 <= 65536) {
            }
        } else {
            throw new IllegalStateException("No method to stop");
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        int Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwww(i) + this.Wwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwww < 0 || 32767 < Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwww(Wwwwwwwwwwwwwww);
            throw null;
        } else if (i != 187 && i != 189 && i != 192 && i != 193) {
            throw new IllegalArgumentException("bad opcode for class reference");
        } else {
            short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
            Wwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            short s = (short) Wwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = s;
            if (Wwwwwwwwwwwwwww <= this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = s;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3) {
        int i2;
        int Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwww(i) + this.Wwwwwwwwwwwwwwwwwwwwww;
        char charAt = str3.charAt(0);
        int i3 = (charAt == 'J' || charAt == 'D') ? 2 : 1;
        switch (i) {
            case 178:
            case 180:
                i2 = Wwwwwwwwwwwwwww + i3;
                break;
            case 179:
            case 181:
                i2 = Wwwwwwwwwwwwwww - i3;
                break;
            default:
                throw new IllegalArgumentException("bad opcode for field reference");
        }
        if (i2 < 0 || 32767 < i2) {
            Wwwwwwwwwwwwwwww(i2);
            throw null;
        }
        h21 h21Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (h21Var != null) {
            j21 j21Var = new j21(str, str2, str3);
            int i4 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(j21Var, -1);
            if (i4 == -1) {
                short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str3);
                short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                byte[] bArr = h21Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i5 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i6 = i5 + 1;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                bArr[i5] = 9;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, bArr, i6);
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, h21Var.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                i4 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
                h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(j21Var, i4);
            }
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwww.put(i4, j21Var);
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwww.put(i4, 9);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwww(1)] = (byte) i;
            Wwwwwwwwwwwwwwwwwwwwww((short) i4);
            short s = (short) i2;
            this.Wwwwwwwwwwwwwwwwwwwwww = s;
            if (i2 <= this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = s;
            return;
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        h21 h21Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) & 65535;
        int i = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1);
        if (i == -1) {
            i = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            byte[] bArr = h21Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i2 + 1;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            bArr[i2] = 8;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i3);
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
        }
        h21Var.Wwwwwwwwwwwwwwwwwwwwwwwww.put(i, 8);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(18, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        if (d == RoundRectDrawableWithShadow.COS_45) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(14);
            if (1.0d / d >= RoundRectDrawableWithShadow.COS_45) {
                return;
            }
        } else if (d != 1.0d && d != -1.0d) {
            h21 h21Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9);
            byte[] bArr = h21Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            bArr[i] = 6;
            long doubleToLongBits = Double.doubleToLongBits(d);
            byte[] bArr2 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = (int) doubleToLongBits;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, bArr2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) (doubleToLongBits >>> 32), bArr2, h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
            int i3 = h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 2;
            h21Var.Wwwwwwwwwwwwwwwwwwwwwwwww.put(i3, 6);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20, i3);
            return;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
            if (d >= RoundRectDrawableWithShadow.COS_45) {
                return;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(119);
    }

    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        short s;
        int i;
        if (this.Wwwwwwwwwwwww != 0) {
            s = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SourceFile");
            i = 1;
        } else {
            s = 0;
            i = 0;
        }
        if (this.Wwwwwwwwwwwww != 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SourceFile");
        }
        int size = (this.Wwwwwwwwwwwwwwwww.size() * 2) + this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + 2 + 8 + 2 + 2 + 2 + 2 + 2;
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwww.size(); i2++) {
            size += !((f21) this.Wwwwwwwwwwwwwwwwww.get(i2)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 8 : 16;
        }
        int i3 = size + 2;
        for (int i4 = 0; i4 < this.Wwwwwwwwwwwwwwwwwww.size(); i4++) {
            i3 += ((g21) this.Wwwwwwwwwwwwwwwwwww.get(i4)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length + 8;
        }
        int i5 = i3 + 2;
        if (this.Wwwwwwwwwwwww != 0) {
            i5 = i5 + 2 + 4 + 2;
        }
        byte[] bArr = new byte[i5];
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-889275714, bArr, 0)));
        h21 h21Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        System.arraycopy(h21Var.Wwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww.size(), bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww))));
        for (int i6 = 0; i6 < this.Wwwwwwwwwwwwwwwww.size(); i6++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Short) this.Wwwwwwwwwwwwwwwww.get(i6)).shortValue(), bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww.size(), bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        for (int i7 = 0; i7 < this.Wwwwwwwwwwwwwwwwww.size(); i7++) {
            f21 f21Var = (f21) this.Wwwwwwwwwwwwwwwwww.get(i7);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5)));
            if (f21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6))));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww.size(), bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
        for (int i8 = 0; i8 < this.Wwwwwwwwwwwwwwwwwww.size(); i8++) {
            g21 g21Var = (g21) this.Wwwwwwwwwwwwwwwwwww.get(i8);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7))));
            byte[] bArr2 = g21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            System.arraycopy(bArr2, 0, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, bArr2.length);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 + g21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
        if (this.Wwwwwwwwwwwww != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9)));
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == i5) {
            return bArr;
        }
        throw new RuntimeException();
    }
}
