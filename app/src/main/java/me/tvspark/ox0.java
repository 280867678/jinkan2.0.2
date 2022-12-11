package me.tvspark;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C1588bm;
import java.util.Arrays;
import kotlin.TypeCastException;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class ox0 {
    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final char[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        byte[] bArr = new byte[0];
        if (ByteString.Companion != null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "data");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
            return;
        }
        throw null;
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        String utf8$jvm = byteString.getUtf8$jvm();
        if (utf8$jvm == null) {
            byte[] internalArray$jvm = byteString.internalArray$jvm();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(internalArray$jvm, "$receiver");
            String str = new String(internalArray$jvm, ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            byteString.setUtf8$jvm(str);
            return str;
        }
        return utf8$jvm;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x017b, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0168, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f5, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x012a, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0121, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x010f, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0100, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00ed, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00af, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x00a4, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0093, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01b9, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01f8, code lost:
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c0, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b1, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x019b, code lost:
        if (r5 == 64) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x018c, code lost:
        if (r5 == 64) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        if (byteString.getData$jvm().length == 0) {
            return "[size=0]";
        }
        byte[] data$jvm = byteString.getData$jvm();
        int length = data$jvm.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        loop0: while (true) {
            if (i >= length) {
                break;
            }
            byte b = data$jvm[i];
            if (b >= 0) {
                int i4 = i3 + 1;
                if (i3 == 64) {
                    break;
                }
                if (b != 10 && b != 13) {
                    if ((b >= 0 && 31 >= b) || (Byte.MAX_VALUE <= b && 159 >= b)) {
                        break;
                    }
                }
                if (b == 65533) {
                    break;
                }
                i2 += b < 65536 ? 1 : 2;
                i++;
                while (true) {
                    i3 = i4;
                    if (i < length && data$jvm[i] >= 0) {
                        int i5 = i + 1;
                        byte b2 = data$jvm[i];
                        i4 = i3 + 1;
                        if (i3 == 64) {
                            break loop0;
                        }
                        if (b2 != 10 && b2 != 13) {
                            if ((b2 >= 0 && 31 >= b2) || (Byte.MAX_VALUE <= b2 && 159 >= b2)) {
                                break loop0;
                            }
                        }
                        if (b2 == 65533) {
                            break loop0;
                        }
                        i2 += b2 < 65536 ? 1 : 2;
                        i = i5;
                    }
                }
            } else if ((b >> 5) == -2) {
                int i6 = i + 1;
                if (length > i6) {
                    byte b3 = data$jvm[i];
                    byte b4 = data$jvm[i6];
                    if ((b4 & ExifInterface.MARKER_SOF0) == 128) {
                        int i7 = (b4 ^ 3968) ^ (b3 << 6);
                        if (i7 >= 128) {
                            int i8 = i3 + 1;
                            if (i3 == 64) {
                                break;
                            }
                            if (i7 != 10 && i7 != 13) {
                                if ((i7 >= 0 && 31 >= i7) || (127 <= i7 && 159 >= i7)) {
                                    break;
                                }
                            }
                            if (i7 == 65533) {
                                break;
                            }
                            i2 += i7 < 65536 ? 1 : 2;
                            i += 2;
                            i3 = i8;
                        }
                    }
                }
            } else if ((b >> 4) == -2) {
                int i9 = i + 2;
                if (length > i9) {
                    byte b5 = data$jvm[i];
                    byte b6 = data$jvm[i + 1];
                    if ((b6 & ExifInterface.MARKER_SOF0) == 128) {
                        byte b7 = data$jvm[i9];
                        if ((b7 & ExifInterface.MARKER_SOF0) == 128) {
                            int i10 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b5 << 12);
                            if (i10 >= 2048) {
                                if (55296 > i10 || 57343 < i10) {
                                    int i11 = i3 + 1;
                                    if (i3 == 64) {
                                        break;
                                    }
                                    if (i10 != 10 && i10 != 13) {
                                        if ((i10 >= 0 && 31 >= i10) || (127 <= i10 && 159 >= i10)) {
                                            break;
                                        }
                                    }
                                    if (i10 == 65533) {
                                        break;
                                    }
                                    i2 += i10 < 65536 ? 1 : 2;
                                    i += 3;
                                    i3 = i11;
                                }
                            }
                        }
                    }
                }
            } else if ((b >> 3) == -2) {
                int i12 = i + 3;
                if (length > i12) {
                    byte b8 = data$jvm[i];
                    byte b9 = data$jvm[i + 1];
                    if ((b9 & ExifInterface.MARKER_SOF0) == 128) {
                        byte b10 = data$jvm[i + 2];
                        if ((b10 & ExifInterface.MARKER_SOF0) == 128) {
                            byte b11 = data$jvm[i12];
                            if ((b11 & ExifInterface.MARKER_SOF0) == 128) {
                                int i13 = (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b8 << 18);
                                if (i13 <= 1114111) {
                                    if (55296 > i13 || 57343 < i13) {
                                        if (i13 >= 65536) {
                                            int i14 = i3 + 1;
                                            if (i3 == 64) {
                                                break;
                                            }
                                            if (i13 != 10 && i13 != 13) {
                                                if ((i13 >= 0 && 31 >= i13) || (127 <= i13 && 159 >= i13)) {
                                                    break;
                                                }
                                            }
                                            if (i13 == 65533) {
                                                break;
                                            }
                                            i2 += i13 < 65536 ? 1 : 2;
                                            i += 4;
                                            i3 = i14;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i2 == -1) {
            if (byteString.getData$jvm().length <= 64) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[hex=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(byteString.hex());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(']');
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[size=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(byteString.getData$jvm().length);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" hex=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, 0, 64).hex());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("…]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
        }
        String utf8 = byteString.utf8();
        if (utf8 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = utf8.substring(0, i2);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, "\\", "\\\\", false, 4), "\n", "\\n", false, 4), StringUtils.f4552CR, "\\r", false, 4);
        if (i2 >= utf8.length()) {
            return "[text=" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 + ']';
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[size=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(byteString.getData$jvm().length);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(" text=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append("…]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString();
    }

    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        byte[] data$jvm = byteString.getData$jvm();
        byte[] copyOf = Arrays.copyOf(data$jvm, data$jvm.length);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        byte b;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        for (int i = 0; i < byteString.getData$jvm().length; i++) {
            byte b2 = byteString.getData$jvm()[i];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data$jvm = byteString.getData$jvm();
                byte[] copyOf = Arrays.copyOf(data$jvm, data$jvm.length);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + C1588bm.f3196k);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + C1588bm.f3196k);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        byte b;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        for (int i = 0; i < byteString.getData$jvm().length; i++) {
            byte b2 = byteString.getData$jvm()[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data$jvm = byteString.getData$jvm();
                byte[] copyOf = Arrays.copyOf(data$jvm, data$jvm.length);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        return byteString.getData$jvm();
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        byte[] data$jvm;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        char[] cArr = new char[byteString.getData$jvm().length * 2];
        int i = 0;
        for (byte b : byteString.getData$jvm()) {
            int i2 = i + 1;
            char[] cArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        int hashCode$jvm = byteString.getHashCode$jvm();
        if (hashCode$jvm != 0) {
            return hashCode$jvm;
        }
        byteString.setHashCode$jvm(Arrays.hashCode(byteString.getData$jvm()));
        return byteString.getHashCode$jvm();
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        return byteString.getData$jvm().length;
    }

    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
        byte[] bytes = str.getBytes(ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString(bytes);
        byteString.setUtf8$jvm(str);
        return byteString;
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, ByteString byteString2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, byte[] bArr, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        for (int min = Math.min(i, byteString.getData$jvm().length - bArr.length); min >= 0; min--) {
            if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString.getData$jvm(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        return rw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString.getData$jvm(), rw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.charAt(i2 + 1)) + (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected hex string: ", str).toString());
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, ByteString byteString2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }

    public static final byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        return byteString.getData$jvm()[i];
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, ByteString byteString2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = byteString.getByte(i) & 255;
            int i3 = byteString2.getByte(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, byte[] bArr, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        int length = byteString.getData$jvm().length - bArr.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString.getData$jvm(), max, bArr, 0, bArr.length)) {
                if (max == length) {
                    return -1;
                }
                max++;
            }
            return max;
        }
        return -1;
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        return rw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString.getData$jvm(), rw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
        byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = rw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            return new ByteString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        return null;
    }

    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        boolean z = true;
        if (i >= 0) {
            if (!(i2 <= byteString.getData$jvm().length)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("endIndex > length(");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(byteString.getData$jvm().length);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(')');
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
            }
            int i3 = i2 - i;
            if (i3 < 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            if (i == 0 && i2 == byteString.getData$jvm().length) {
                return byteString;
            }
            byte[] bArr = new byte[i3];
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString.getData$jvm(), i, bArr, 0, i3);
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public static final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, int i, ByteString byteString2, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString2, "other");
        return byteString2.rangeEquals(i2, byteString.getData$jvm(), i, i3);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, int i, byte[] bArr, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        return i >= 0 && i <= byteString.getData$jvm().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString.getData$jvm(), i, bArr, i2, i3);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, Object obj) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$jvm().length && byteString2.rangeEquals(0, byteString.getData$jvm(), 0, byteString.getData$jvm().length)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString, byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$receiver");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }
}
