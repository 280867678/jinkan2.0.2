package androidx.core.p003os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import me.tvspark.outline;

/* renamed from: androidx.core.os.LocaleListCompatWrapper */
/* loaded from: classes3.dex */
public final class LocaleListCompatWrapper implements LocaleListInterface {
    public final Locale[] mList;
    @NonNull
    public final String mStringRepresentation;
    public static final Locale[] sEmptyList = new Locale[0];
    public static final Locale LOCALE_EN_XA = new Locale("en", "XA");
    public static final Locale LOCALE_AR_XB = new Locale("ar", "XB");
    public static final Locale EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");

    public LocaleListCompatWrapper(@NonNull Locale... localeArr) {
        String sb;
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            sb = "";
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < localeArr.length; i++) {
                Locale locale = localeArr[i];
                if (locale == null) {
                    throw new NullPointerException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("list[", i, "] is null"));
                }
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    toLanguageTag(sb2, locale2);
                    if (i < localeArr.length - 1) {
                        sb2.append(',');
                    }
                    hashSet.add(locale2);
                }
            }
            this.mList = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
            sb = sb2.toString();
        }
        this.mStringRepresentation = sb;
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean z) {
        int computeFirstMatchIndex = computeFirstMatchIndex(collection, z);
        if (computeFirstMatchIndex == -1) {
            return null;
        }
        return this.mList[computeFirstMatchIndex];
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
        if (r6 < Integer.MAX_VALUE) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int computeFirstMatchIndex(Collection<String> collection, boolean z) {
        int i;
        Locale[] localeArr = this.mList;
        if (localeArr.length == 1) {
            return 0;
        }
        if (localeArr.length == 0) {
            return -1;
        }
        if (z) {
            i = findFirstMatchIndex(EN_LATN);
            if (i == 0) {
                return 0;
            }
        }
        i = Integer.MAX_VALUE;
        for (String str : collection) {
            int findFirstMatchIndex = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(str));
            if (findFirstMatchIndex == 0) {
                return 0;
            }
            if (findFirstMatchIndex < i) {
                i = findFirstMatchIndex;
            }
        }
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        return 0;
    }

    private int findFirstMatchIndex(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                if (matchScore(locale, localeArr[i]) > 0) {
                    return i;
                }
                i++;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static String getLikelyScript(Locale locale) {
        String script = locale.getScript();
        return !script.isEmpty() ? script : "";
    }

    public static boolean isPseudoLocale(Locale locale) {
        return LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale);
    }

    @IntRange(from = 0, m4212to = 1)
    public static int matchScore(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
            return 0;
        }
        String likelyScript = getLikelyScript(locale);
        if (!likelyScript.isEmpty()) {
            return likelyScript.equals(getLikelyScript(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
    }

    @VisibleForTesting
    public static void toLanguageTag(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.mList;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // androidx.core.p003os.LocaleListInterface
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    @Override // androidx.core.p003os.LocaleListInterface
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), false);
    }

    @Override // androidx.core.p003os.LocaleListInterface
    @Nullable
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i2 < localeArr.length) {
                i = (i * 31) + localeArr[i2].hashCode();
                i2++;
            } else {
                return i;
            }
        }
    }

    @Override // androidx.core.p003os.LocaleListInterface
    public int indexOf(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                if (localeArr[i].equals(locale)) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    @Override // androidx.core.p003os.LocaleListInterface
    public boolean isEmpty() {
        return this.mList.length == 0;
    }

    @Override // androidx.core.p003os.LocaleListInterface
    public int size() {
        return this.mList.length;
    }

    @Override // androidx.core.p003os.LocaleListInterface
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(localeArr[i]);
            if (i < this.mList.length - 1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
            }
            i++;
        }
    }
}
