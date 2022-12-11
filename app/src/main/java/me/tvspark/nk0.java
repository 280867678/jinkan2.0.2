package me.tvspark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt__IndentKt$getIndentFunction$1;
import kotlin.text.StringsKt__IndentKt$getIndentFunction$2;
import kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2;
import kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4;
import kotlin.text.StringsKt__StringsKt$splitToSequence$1;
import org.apache.commons.lang3.StringUtils;
import org.mozilla.javascript.tools.idswitch.Main;

/* loaded from: classes4.dex */
public class nk0 extends mk0 {
    public static final CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        boolean z;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$indices");
            bj0 bj0Var = new bj0(0, charSequence.length() - 1);
            if (!(bj0Var instanceof Collection) || !((Collection) bj0Var).isEmpty()) {
                Iterator<Integer> it = bj0Var.iterator();
                while (it.hasNext()) {
                    if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.charAt(((cg0) it).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$startsWith");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "prefix");
        return !z ? str.startsWith(str2) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, z);
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, String str, int i, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$indexOf");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Main.STRING_TAG_STR);
        return (z || !(charSequence instanceof String)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, str, i, charSequence.length(), z, false, 16) : ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, str, i, z);
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$indexOfAny");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr), i);
        }
        if (i < 0) {
            i = 0;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
        if (i > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(i);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return i;
            }
            if (i == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return -1;
            }
            i++;
        }
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$repeat");
        int i2 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        } else if (i == 0) {
            return "";
        } else {
            if (i == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length == 1) {
                char charAt = charSequence.charAt(0);
                char[] cArr = new char[i];
                for (int i3 = 0; i3 < i; i3++) {
                    cArr[i3] = charAt;
                }
                return new String(cArr);
            }
            StringBuilder sb = new StringBuilder(charSequence.length() * i);
            if (1 <= i) {
                while (true) {
                    sb.append(charSequence);
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            String sb2 = sb.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "sb.toString()");
            return sb2;
        }
    }

    public static final Comparator<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mi0 mi0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mi0Var, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, char c, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$contains");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, c, 0, z, 2) >= 0;
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$regionMatchesImpl");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, int i2, int i3, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$regionMatches");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$startsWith");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "prefix");
        return !z ? str.startsWith(str2, i) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, boolean z, int i2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, i, z);
    }

    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        boolean z2 = (i & 2) != 0 ? false : z;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$contains");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, (String) charSequence2, 0, z2, 2) < 0) {
                return false;
            }
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, charSequence2, 0, charSequence.length(), z2, false, 16) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, char c, int i, boolean z, int i2) {
        boolean z2;
        if ((i2 & 2) != 0) {
            i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$lastIndexOf");
        if (z || !(charSequence instanceof String)) {
            char[] cArr = {c};
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$lastIndexOfAny");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, "chars");
            if (!z && (charSequence instanceof String)) {
                return ((String) charSequence).lastIndexOf(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr), i);
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
            if (i > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            while (i >= 0) {
                char charAt = charSequence.charAt(i);
                int i3 = 0;
                while (true) {
                    if (i3 >= 1) {
                        z2 = false;
                        break;
                    } else if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr[i3], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z2) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$endsWith");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "suffix");
        return !z ? str.endsWith(str2) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!z2) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new bj0(i, i2);
        } else {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
            if (i > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            if (i5 >= 0) {
                if (i3 > i4) {
                    return -1;
                }
            } else if (i3 < i4) {
                return -1;
            }
            while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) charSequence2, 0, (String) charSequence, i3, charSequence2.length(), z)) {
                if (i3 == i4) {
                    return -1;
                }
                i3 += i5;
            }
            return i3;
        }
        int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        int i8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        if (i8 >= 0) {
            if (i6 > i7) {
                return -1;
            }
        } else if (i6 < i7) {
            return -1;
        }
        while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence2, 0, charSequence, i6, charSequence2.length(), z)) {
            if (i6 == i7) {
                return -1;
            }
            i6 += i8;
        }
        return i6;
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, char c, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, boolean z, int i) {
        int i2 = 0;
        if ((i & 4) != 0) {
            z = false;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$replace");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "oldValue");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, "newValue");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, str2, 0, z);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
            return str;
        }
        int length = str2.length();
        int i3 = 1;
        if (length >= 1) {
            i3 = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            sb.append(str3);
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + length;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= str.length()) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i3, z);
        } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0);
        sb.append((CharSequence) str, i2, str.length());
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "stringBuilder.append(this, i, length).toString()");
        return sb2;
    }

    public static /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, char[] cArr, boolean z, int i, int i2) {
        int i3 = 0;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$split");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, "delimiters");
        int i4 = 10;
        boolean z2 = true;
        if (cArr.length != 1) {
            if (i < 0) {
                z2 = false;
            }
            if (z2) {
                fk0 fk0Var = new fk0(charSequence, 0, i, new StringsKt__StringsKt$rangesDelimitedBy$2(cArr, z));
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fk0Var, "$this$asIterable");
                bk0 bk0Var = new bk0(fk0Var);
                ArrayList arrayList = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bk0Var, 10));
                Iterator it = bk0Var.iterator();
                while (it.hasNext()) {
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, (bj0) it.next()));
                }
                return arrayList;
            }
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        String valueOf = String.valueOf(cArr[0]);
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, valueOf, 0, z);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 || i == 1) {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.toString());
        }
        if (i <= 0) {
            z2 = false;
        }
        if (z2 && i <= 10) {
            i4 = i;
        }
        ArrayList arrayList2 = new ArrayList(i4);
        do {
            arrayList2.add(charSequence.subSequence(i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).toString());
            i3 = valueOf.length() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (z2 && arrayList2.size() == i - 1) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, valueOf, i3, z);
        } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1);
        arrayList2.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList2;
    }

    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, bj0 bj0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "$this$substring");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bj0Var, "range");
        return charSequence.subSequence(bj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue(), Integer.valueOf(bj0Var.Wwwwwwwwwwwwwwwwwwwwwww).intValue() + 1).toString();
    }

    public static /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, char c, String str2, int i) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$substringAfterLast");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "missingDelimiterValue");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, c, 0, false, 6);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            return str2;
        }
        String substring = str.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1, str.length());
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$trimMargin");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "marginPrefix");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$replaceIndentByMargin");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", "newIndent");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "marginPrefix");
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2)) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$lines");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$lineSequence");
            String[] strArr = {"\r\n", "\n", StringUtils.f4552CR};
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$splitToSequence");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "delimiters");
            fk0 fk0Var = new fk0(str, 0, 0, new StringsKt__StringsKt$rangesDelimitedBy$4(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) strArr), false));
            StringsKt__StringsKt$splitToSequence$1 stringsKt__StringsKt$splitToSequence$1 = new StringsKt__StringsKt$splitToSequence$1(str);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fk0Var, "$this$map");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringsKt__StringsKt$splitToSequence$1, "transform");
            dk0 dk0Var = new dk0(fk0Var, stringsKt__StringsKt$splitToSequence$1);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dk0Var, "$this$toList");
            List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((zj0) dk0Var));
            int size = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() * 0) + str.length();
            ih0 stringsKt__IndentKt$getIndentFunction$2 = "".length() == 0 ? StringsKt__IndentKt$getIndentFunction$1.INSTANCE : new StringsKt__IndentKt$getIndentFunction$2("");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "$this$lastIndex");
            int size2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1;
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (Object obj : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int i3 = i2 + 1;
                String str3 = null;
                if (i2 < 0) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                String str4 = (String) obj;
                if ((i2 != 0 && i2 != size2) || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4)) {
                    int length = str4.length();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            i4 = -1;
                            break;
                        } else if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4.charAt(i4))) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 != -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, str2, i4, false, 4)) {
                        str3 = str4.substring(str2.length() + i4);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, "(this as java.lang.String).substring(startIndex)");
                    }
                    if (str3 == null || (str3 = (String) stringsKt__IndentKt$getIndentFunction$2.mo4916invoke(str3)) == null) {
                        str3 = str4;
                    }
                }
                if (str3 != null) {
                    arrayList.add(str3);
                }
                i2 = i3;
            }
            StringBuilder sb = new StringBuilder(size);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, sb, "\n", "", "", -1, "...", (ih0) null);
            String sb2 = sb.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }
}
