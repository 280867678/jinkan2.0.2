package org.apache.commons.lang3;

import java.util.Random;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class RandomStringUtils {
    public static final Random RANDOM = new Random();

    public static String random(int i) {
        return random(i, false, false);
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2) {
        return random(i, i2, i3, z, z2, null, RANDOM);
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2, char... cArr) {
        return random(i, i2, i3, z, z2, cArr, RANDOM);
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2, char[] cArr, Random random) {
        if (i == 0) {
            return "";
        }
        if (i < 0) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Requested random string length ", i, " is less than 0."));
        }
        if (cArr != null && cArr.length == 0) {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
        if (i2 == 0 && i3 == 0) {
            if (cArr != null) {
                i3 = cArr.length;
            } else if (z || z2) {
                i3 = 123;
                i2 = 32;
            } else {
                i3 = Integer.MAX_VALUE;
            }
        } else if (i3 <= i2) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Parameter end (", i3, ") must be greater than start (", i2, ")"));
        }
        char[] cArr2 = new char[i];
        int i4 = i3 - i2;
        while (true) {
            int i5 = i - 1;
            if (i == 0) {
                return new String(cArr2);
            }
            int nextInt = random.nextInt(i4) + i2;
            char c = cArr == null ? (char) nextInt : cArr[nextInt];
            if ((z && Character.isLetter(c)) || ((z2 && Character.isDigit(c)) || (!z && !z2))) {
                if (c < 56320 || c > 57343) {
                    if (c < 55296 || c > 56191) {
                        if (c < 56192 || c > 56319) {
                            cArr2[i5] = c;
                        }
                    } else if (i5 != 0) {
                        cArr2[i5] = (char) (random.nextInt(128) + 56320);
                        i5--;
                        cArr2[i5] = c;
                    }
                } else if (i5 != 0) {
                    cArr2[i5] = c;
                    i5--;
                    cArr2[i5] = (char) (random.nextInt(128) + 55296);
                }
                i = i5;
            }
            i5++;
            i = i5;
        }
    }

    public static String random(int i, String str) {
        return str == null ? random(i, 0, 0, false, false, null, RANDOM) : random(i, str.toCharArray());
    }

    public static String random(int i, boolean z, boolean z2) {
        return random(i, 0, 0, z, z2);
    }

    public static String random(int i, char... cArr) {
        int length;
        boolean z;
        boolean z2;
        Random random;
        int i2;
        char[] cArr2;
        if (cArr == null) {
            length = 0;
            z = false;
            z2 = false;
            cArr2 = null;
            random = RANDOM;
            i2 = i;
        } else {
            length = cArr.length;
            z = false;
            z2 = false;
            random = RANDOM;
            i2 = i;
            cArr2 = cArr;
        }
        return random(i2, 0, length, z, z2, cArr2, random);
    }

    public static String randomAlphabetic(int i) {
        return random(i, true, false);
    }

    public static String randomAlphanumeric(int i) {
        return random(i, true, true);
    }

    public static String randomAscii(int i) {
        return random(i, 32, 127, false, false);
    }

    public static String randomNumeric(int i) {
        return random(i, false, true);
    }
}
