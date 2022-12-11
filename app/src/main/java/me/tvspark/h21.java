package me.tvspark;

import com.tencent.smtt.sdk.TbsListener;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.UintMap;

/* loaded from: classes4.dex */
public final class h21 {
    public ClassFileWriter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public UintMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new UintMap();
    public ObjToIntMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ObjToIntMap();
    public ObjToIntMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ObjToIntMap();
    public ObjToIntMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ObjToIntMap();
    public ObjToIntMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ObjToIntMap();
    public UintMap Wwwwwwwwwwwwwwwwwwwwwwwwww = new UintMap();
    public UintMap Wwwwwwwwwwwwwwwwwwwwwwwww = new UintMap();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwww = new byte[256];
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public h21(ClassFileWriter classFileWriter) {
        new ObjToIntMap();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter;
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwww.getObject(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str, -1);
        if (i2 == -1) {
            int length = str.length();
            boolean z = false;
            if (length <= 65535) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((length * 3) + 3);
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww[i3] = 1;
                int i4 = i3 + 1 + 2;
                ClassFileWriter classFileWriter = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                char[] cArr = classFileWriter.Wwwwww;
                if (length > cArr.length) {
                    int length2 = cArr.length * 2;
                    if (length > length2) {
                        length2 = length;
                    }
                    classFileWriter.Wwwwww = new char[length2];
                }
                char[] cArr2 = classFileWriter.Wwwwww;
                str.getChars(0, length, cArr2, 0);
                for (int i5 = 0; i5 != length; i5++) {
                    char c = cArr2[i5];
                    if (c != 0 && c <= 127) {
                        i = i4 + 1;
                        this.Wwwwwwwwwwwwwwwwwwwwwwww[i4] = (byte) c;
                    } else if (c > 2047) {
                        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        int i6 = i4 + 1;
                        bArr[i4] = (byte) ((c >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                        int i7 = i6 + 1;
                        bArr[i6] = (byte) (((c >> 6) & 63) | 128);
                        i = i7 + 1;
                        bArr[i7] = (byte) ((c & '?') | 128);
                    } else {
                        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        int i8 = i4 + 1;
                        bArr2[i4] = (byte) ((c >> 6) | 192);
                        i4 = i8 + 1;
                        bArr2[i8] = (byte) ((c & '?') | 128);
                    }
                    i4 = i;
                }
                int i9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i10 = i4 - ((i9 + 1) + 2);
                if (i10 <= 65535) {
                    byte[] bArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    bArr3[i9 + 1] = (byte) (i10 >>> 8);
                    bArr3[i9 + 2] = (byte) i10;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                    i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, i2);
                    if (z) {
                        throw new IllegalArgumentException("Too big string");
                    }
                }
            }
            z = true;
            if (z) {
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww.put(i2, str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.put(i2, 1);
        return (short) i2;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, int i2) {
        int i3 = 65535;
        if ((i2 - i) * 3 <= 65535) {
            return i2;
        }
        while (i != i2) {
            char charAt = str.charAt(i);
            i3 = (charAt == 0 || charAt > 127) ? charAt < 2047 ? i3 - 2 : i3 - 3 : i3 - 1;
            if (i3 < 0) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String str2;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str, -1);
        if (i == -1) {
            if (str.indexOf(46) > 0) {
                String replace = str.replace('.', '/');
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(replace, -1);
                if (i2 != -1) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, i2);
                }
                str2 = replace;
                i = i2;
            } else {
                str2 = str;
            }
            if (i == -1) {
                short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = i3 + 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                bArr[i3] = 7;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i4);
                i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str2, i);
                if (!str.equals(str2)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, i);
                }
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww.put(i, str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.put(i, 7);
        return (short) i;
    }

    public final short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        bArr[i] = 12;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 12);
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
        return (short) i3;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + i;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i2 + i > length) {
                length = i2 + i;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwww, 0, bArr2, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = bArr2;
        }
    }
}
