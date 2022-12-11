package me.tvspark;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: me.tvspark.lj */
/* loaded from: classes4.dex */
public final class C2335lj {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("(&#13;)?&#10;");

    /* renamed from: me.tvspark.lj$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    }

    /* renamed from: me.tvspark.lj$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final Comparator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2187hj.Wwwwwwwwwwwwwwwwwwwwwwww;
        public static final Comparator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2224ij.Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, String str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        }

        public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            int compare = Integer.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare != 0) {
                return compare;
            }
            int compareTo = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareTo(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return compareTo != 0 ? compareTo : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareTo(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            int compare = Integer.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare != 0) {
                return compare;
            }
            int compareTo = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareTo(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return compareTo != 0 ? compareTo : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareTo(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.lj$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Map map, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x01ac, code lost:
        if (((android.text.style.TypefaceSpan) r9).getFamily() != null) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0244 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable CharSequence charSequence, float f) {
        String str;
        String str2;
        String str3;
        String str4;
        if (charSequence == null) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", ImmutableMap.m3900of(), null);
        }
        if (!(charSequence instanceof Spanned)) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence), ImmutableMap.m3900of(), null);
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            StringBuilder sb = new StringBuilder(14);
            sb.append("bg_");
            sb.append(intValue);
            hashMap.put(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString()), C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("background-color:%s;", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intValue)));
        }
        SparseArray sparseArray = new SparseArray();
        Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
        int length = spans.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = spans[i2];
            boolean z = obj instanceof StrikethroughSpan;
            if (z) {
                str = "<span style='text-decoration:line-through;'>";
            } else if (obj instanceof ForegroundColorSpan) {
                str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<span style='color:%s;'>", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((ForegroundColorSpan) obj).getForegroundColor()));
            } else if (obj instanceof BackgroundColorSpan) {
                str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
            } else if (obj instanceof C2598sh) {
                str = "<span style='text-combine-upright:all;'>";
            } else if (obj instanceof AbsoluteSizeSpan) {
                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                boolean dip = absoluteSizeSpan.getDip();
                float size = absoluteSizeSpan.getSize();
                if (!dip) {
                    size /= f;
                }
                str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
            } else if (obj instanceof RelativeSizeSpan) {
                str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
            } else if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                str = family != null ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<span style='font-family:\"%s\";'>", family) : null;
            } else {
                if (obj instanceof StyleSpan) {
                    int style = ((StyleSpan) obj).getStyle();
                    if (style == 1) {
                        str = "<b>";
                    } else if (style != 2) {
                        if (style == 3) {
                            str = "<b><i>";
                        }
                        str2 = null;
                    } else {
                        str = "<i>";
                    }
                } else if (obj instanceof C2635th) {
                    int i3 = ((C2635th) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i3 == -1) {
                        str = "<ruby style='ruby-position:unset;'>";
                    } else if (i3 != 1) {
                        if (i3 == 2) {
                            str = "<ruby style='ruby-position:under;'>";
                        }
                        str2 = null;
                    } else {
                        str = "<ruby style='ruby-position:over;'>";
                    }
                } else {
                    if (obj instanceof UnderlineSpan) {
                        str = "<u>";
                    }
                    str2 = null;
                }
                if (!z && !(obj instanceof ForegroundColorSpan) && !(obj instanceof BackgroundColorSpan) && !(obj instanceof C2598sh) && !(obj instanceof AbsoluteSizeSpan) && !(obj instanceof RelativeSizeSpan)) {
                    if (obj instanceof TypefaceSpan) {
                        if (obj instanceof StyleSpan) {
                            int style2 = ((StyleSpan) obj).getStyle();
                            if (style2 == 1) {
                                str4 = "</b>";
                            } else if (style2 == 2) {
                                str4 = "</i>";
                            } else if (style2 == 3) {
                                str4 = "</i></b>";
                            }
                            str3 = str4;
                        } else {
                            if (obj instanceof C2635th) {
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((C2635th) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                StringBuilder sb2 = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 16));
                                sb2.append("<rt>");
                                sb2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                sb2.append("</rt></ruby>");
                                str4 = sb2.toString();
                            } else if (obj instanceof UnderlineSpan) {
                                str4 = "</u>";
                            }
                            str3 = str4;
                        }
                        int spanStart = spanned.getSpanStart(obj);
                        int spanEnd = spanned.getSpanEnd(obj);
                        if (str2 != null) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spanStart, spanEnd, str2, str3, null);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) sparseArray.get(spanStart);
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                sparseArray.put(spanStart, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) sparseArray.get(spanEnd);
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                sparseArray.put(spanEnd, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                    }
                    str3 = null;
                    int spanStart2 = spanned.getSpanStart(obj);
                    int spanEnd2 = spanned.getSpanEnd(obj);
                    if (str2 != null) {
                    }
                }
                str3 = "</span>";
                int spanStart22 = spanned.getSpanStart(obj);
                int spanEnd22 = spanned.getSpanEnd(obj);
                if (str2 != null) {
                }
            }
            str2 = str;
            if (!z) {
                if (obj instanceof TypefaceSpan) {
                }
                str3 = null;
                int spanStart222 = spanned.getSpanStart(obj);
                int spanEnd222 = spanned.getSpanEnd(obj);
                if (str2 != null) {
                }
            }
            str3 = "</span>";
            int spanStart2222 = spanned.getSpanStart(obj);
            int spanEnd2222 = spanned.getSpanEnd(obj);
            if (str2 != null) {
            }
        }
        StringBuilder sb3 = new StringBuilder(spanned.length());
        int i4 = 0;
        while (i < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i);
            sb3.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spanned.subSequence(i4, keyAt)));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) sparseArray.get(keyAt);
            Collections.sort(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                sb3.append(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            Collections.sort(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                sb3.append(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            i++;
            i4 = keyAt;
        }
        sb3.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spanned.subSequence(i4, spanned.length())));
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb3.toString(), hashMap, null);
    }
}
