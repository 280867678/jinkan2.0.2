package me.tvspark;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.C1543ak;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.C2786xg;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;

/* renamed from: me.tvspark.pi */
/* loaded from: classes4.dex */
public final class C2482pi {
    public static final Map<String, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Map<String, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: me.tvspark.pi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -3.4028235E38f;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwww = -3.4028235E38f;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
        public float Wwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
        public int Wwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;

        /* JADX WARN: Code restructure failed: missing block: B:52:0x006b, code lost:
            if (r6 == 0) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Layout.Alignment alignment;
            int i;
            CharSequence charSequence;
            float f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f2 = -3.4028235E38f;
            if (f == -3.4028235E38f) {
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                f = i2 != 4 ? i2 != 5 ? 0.5f : 1.0f : 0.0f;
            }
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 == Integer.MIN_VALUE) {
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i4 != 1) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                i3 = 1;
                            }
                        }
                    }
                    i3 = 2;
                }
                i3 = 0;
            }
            C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 != 5) {
                                alignment = null;
                            }
                        }
                    }
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = alignment;
                float f3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i = (f3 > (-3.4028235E38f) ? 1 : (f3 == (-3.4028235E38f) ? 0 : -1));
                if (i != 0 || i6 != 0 || (f3 >= 0.0f && f3 <= 1.0f)) {
                    if (i == 0) {
                        f2 = f3;
                    }
                    int i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                    float f4 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i3 == 0) {
                        f = 1.0f - f;
                    } else if (i3 == 1) {
                        f = f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
                    } else if (i3 != 2) {
                        throw new IllegalStateException(String.valueOf(i3));
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = Math.min(f4, f);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    charSequence = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (charSequence != null) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
                    }
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                f2 = 1.0f;
                int i72 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i72;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                float f42 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (i3 == 0) {
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = Math.min(f42, f);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                charSequence = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (charSequence != null) {
                }
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            alignment = Layout.Alignment.ALIGN_NORMAL;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = alignment;
            float f32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i62 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i = (f32 > (-3.4028235E38f) ? 1 : (f32 == (-3.4028235E38f) ? 0 : -1));
            if (i != 0) {
            }
            if (i == 0) {
            }
            int i722 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i722;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            float f422 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 == 0) {
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = Math.min(f422, f);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            charSequence = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (charSequence != null) {
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.pi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public final C2408ni Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, C2408ni c2408ni) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwww = c2408ni;
        }

        @Override // java.lang.Comparable
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Integer.compare(this.Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.pi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Set<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, Set<String> set) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = set;
        }
    }

    /* renamed from: me.tvspark.pi$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Comparator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2223ii.Wwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableMap(hashMap2);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int indexOf = str.indexOf(44);
        char c = 65535;
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 1);
            int i = 2;
            switch (substring.hashCode()) {
                case -1842484672:
                    if (substring.equals("line-left")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1364013995:
                    if (substring.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1276788989:
                    if (substring.equals("line-right")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1074341483:
                    if (substring.equals("middle")) {
                        c = 3;
                        break;
                    }
                    break;
                case 100571:
                    if (substring.equals("end")) {
                        c = 5;
                        break;
                    }
                    break;
                case 109757538:
                    if (substring.equals("start")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0 || c == 1) {
                i = 0;
            } else if (c == 2 || c == 3) {
                i = 1;
            } else if (c != 4 && c != 5) {
                if (substring.length() != 0) {
                    "Invalid anchor value: ".concat(substring);
                } else {
                    new String("Invalid anchor value: ");
                }
                i = Integer.MIN_VALUE;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = i;
            str = str.substring(0, indexOf);
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        char c;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c == 1) {
                return 4;
            }
            if (c == 2 || c == 3) {
                return 2;
            }
            if (c == 4) {
                return 3;
            }
            if (c == 5) {
                return 5;
            }
            if (str.length() != 0) {
                "Invalid alignment value: ".concat(str);
            } else {
                new String("Invalid alignment value: ");
            }
            return 2;
        }
        return 1;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2408ni> list, @Nullable String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (i < arrayList.size()) {
                int i2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList.get(i)).Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
                if (i2 != -1) {
                    return i2;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    @Nullable
    public static C2445oi Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, List<C2408ni> list) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            return null;
        }
        Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (matcher.matches()) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null, matcher, c2078el, list);
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
            return null;
        }
        Matcher matcher2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        if (!matcher2.matches()) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.trim(), matcher2, c2078el, list);
    }

    public static C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static C2786xg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0231 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, SpannableStringBuilder spannableStringBuilder, List<C2408ni> list2) {
        char c;
        Object absoluteSizeSpan;
        Object styleSpan;
        Object foregroundColorSpan;
        int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = spannableStringBuilder.length();
        String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int hashCode = str2.hashCode();
        int i2 = -1;
        if (hashCode == 0) {
            if (str2.equals("")) {
                c = 7;
            }
            c = 65535;
        } else if (hashCode == 105) {
            if (str2.equals(C1543ak.f2966aC)) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == 3314158) {
            if (str2.equals("lang")) {
                c = 5;
            }
            c = 65535;
        } else if (hashCode == 3511770) {
            if (str2.equals("ruby")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == 98) {
            if (str2.equals("b")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == 99) {
            if (str2.equals(C1543ak.f2969aF)) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode != 117) {
            if (hashCode == 118 && str2.equals(C1543ak.f2968aE)) {
                c = 6;
            }
            c = 65535;
        } else {
            if (str2.equals(C1543ak.f2970aG)) {
                c = 3;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                styleSpan = new StyleSpan(1);
                spannableStringBuilder.setSpan(styleSpan, i, length, 33);
                break;
            case 1:
                styleSpan = new StyleSpan(2);
                spannableStringBuilder.setSpan(styleSpan, i, length, 33);
                break;
            case 2:
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = 0;
                int i5 = 0;
                while (i4 < arrayList.size()) {
                    if ("rt".equals(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList.get(i4)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList.get(i4);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == i2) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != i2 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : 1;
                        }
                        int i6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i5;
                        int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i5;
                        CharSequence subSequence = spannableStringBuilder.subSequence(i6, i7);
                        spannableStringBuilder.delete(i6, i7);
                        spannableStringBuilder.setSpan(new C2635th(subSequence.toString(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3), i3, i6, 33);
                        i5 = subSequence.length() + i5;
                        i3 = i6;
                    }
                    i4++;
                    i2 = -1;
                }
                break;
            case 3:
                styleSpan = new UnderlineSpan();
                spannableStringBuilder.setSpan(styleSpan, i, length, 33);
                break;
            case 4:
                for (String str3 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(str3)) {
                        foregroundColorSpan = new ForegroundColorSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str3).intValue());
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(str3)) {
                        foregroundColorSpan = new BackgroundColorSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str3).intValue());
                    }
                    spannableStringBuilder.setSpan(foregroundColorSpan, i, length, 33);
                }
                break;
            case 5:
            case 6:
            case 7:
                break;
            default:
                return;
        }
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i8 = 0;
        while (true) {
            ArrayList arrayList2 = (ArrayList) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (i8 < arrayList2.size()) {
                C2408ni c2408ni = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList2.get(i8)).Wwwwwwwwwwwwwwwwwwwwwww;
                if (c2408ni != null) {
                    if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != -1) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new StyleSpan(c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()), i, length, 33);
                    }
                    if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
                    }
                    if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwww == 1) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                    }
                    if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new ForegroundColorSpan(c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), i, length, 33);
                        } else {
                            throw new IllegalStateException("Font color not defined");
                        }
                    }
                    if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new BackgroundColorSpan(c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwww), i, length, 33);
                        } else {
                            throw new IllegalStateException("Background color not defined.");
                        }
                    }
                    if (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new TypefaceSpan(c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww), i, length, 33);
                    }
                    int i9 = c2408ni.Wwwwwwwwwwwwwwwwwwwww;
                    if (i9 == 1) {
                        absoluteSizeSpan = new AbsoluteSizeSpan((int) c2408ni.Wwwwwwwwwwwwwwwwwwww, true);
                    } else if (i9 == 2) {
                        absoluteSizeSpan = new RelativeSizeSpan(c2408ni.Wwwwwwwwwwwwwwwwwwww);
                    } else if (i9 == 3) {
                        absoluteSizeSpan = new RelativeSizeSpan(c2408ni.Wwwwwwwwwwwwwwwwwwww / 100.0f);
                    } else if (!c2408ni.Wwwwwwwwwwwwwwwwww) {
                        spannableStringBuilder.setSpan(new C2598sh(), i, length, 33);
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, absoluteSizeSpan, i, length, 33);
                    if (!c2408ni.Wwwwwwwwwwwwwwwwww) {
                    }
                }
                i8++;
            } else {
                return;
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int indexOf = str.indexOf(44);
        char c = 65535;
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 1);
            int i = 2;
            switch (substring.hashCode()) {
                case -1364013995:
                    if (substring.equals("center")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1074341483:
                    if (substring.equals("middle")) {
                        c = 2;
                        break;
                    }
                    break;
                case 100571:
                    if (substring.equals("end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 109757538:
                    if (substring.equals("start")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                i = 0;
            } else if (c == 1 || c == 2) {
                i = 1;
            } else if (c != 3) {
                if (substring.length() != 0) {
                    "Invalid anchor value: ".concat(substring);
                } else {
                    new String("Invalid anchor value: ");
                }
                i = Integer.MIN_VALUE;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            return;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.parseInt(str);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2408ni> list, @Nullable String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C2408ni c2408ni = list.get(i);
            String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Set<String> set = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String str3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || !c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || !c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || !c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str, 1073741824), c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str2, 2), c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str3, 4);
                size = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1 || !set.containsAll(c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) ? 0 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + (c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() * 4);
            } else {
                size = TextUtils.isEmpty(str2);
            }
            if (size > 0) {
                arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(size, c2408ni));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @Nullable
    public static C2445oi Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str, Matcher matcher, C2078el c2078el, List<C2408ni> list) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        try {
            String group = matcher.group(1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            String group2 = matcher.group(2);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
            String group3 = matcher.group(3);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, sb.toString(), list);
                    return new C2445oi(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.trim());
            }
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(matcher.group());
            if (valueOf.length() != 0) {
                "Skipping cue with bad header: ".concat(valueOf);
                return null;
            }
            new String("Skipping cue with bad header: ");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        char c;
        Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String group = matcher.group(1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            String str2 = group;
            String group2 = matcher.group(2);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
            String str3 = group2;
            try {
                if ("line".equals(str2)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if ("align".equals(str2)) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
                } else if ("position".equals(str2)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if ("size".equals(str2)) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww = C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
                } else if ("vertical".equals(str2)) {
                    int hashCode = str3.hashCode();
                    if (hashCode != 3462) {
                        if (hashCode == 3642 && str3.equals("rl")) {
                            c = 0;
                            if (c != 0) {
                                if (c != 1) {
                                    if (str3.length() != 0) {
                                        "Invalid 'vertical' value: ".concat(str3);
                                    } else {
                                        new String("Invalid 'vertical' value: ");
                                    }
                                    i = Integer.MIN_VALUE;
                                } else {
                                    i = 2;
                                }
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                    } else {
                        if (str3.equals("lr")) {
                            c = 1;
                            if (c != 0) {
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                    }
                } else {
                    String.valueOf(str2).length();
                    String.valueOf(str3).length();
                }
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(matcher.group());
                if (valueOf.length() != 0) {
                    "Skipping bad cue setting: ".concat(valueOf);
                } else {
                    new String("Skipping bad cue setting: ");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannedString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str, String str2, List<C2408ni> list) {
        String str3;
        char c;
        char c2;
        boolean z;
        char c3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        char c4 = 0;
        int i = 0;
        while (true) {
            str3 = "";
            if (i < str2.length()) {
                char charAt = str2.charAt(i);
                char c5 = '>';
                if (charAt == '&') {
                    i++;
                    int indexOf = str2.indexOf(59, i);
                    int indexOf2 = str2.indexOf(32, i);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf != -1) {
                        String substring = str2.substring(i, indexOf);
                        int hashCode = substring.hashCode();
                        if (hashCode == 3309) {
                            if (substring.equals("gt")) {
                                c = 1;
                                if (c != 0) {
                                }
                                spannableStringBuilder.append(c5);
                                if (indexOf == indexOf2) {
                                }
                                i = indexOf + 1;
                            }
                            c = 65535;
                            if (c != 0) {
                            }
                            spannableStringBuilder.append(c5);
                            if (indexOf == indexOf2) {
                            }
                            i = indexOf + 1;
                        } else if (hashCode == 3464) {
                            if (substring.equals("lt")) {
                                c = 0;
                                if (c != 0) {
                                }
                                spannableStringBuilder.append(c5);
                                if (indexOf == indexOf2) {
                                }
                                i = indexOf + 1;
                            }
                            c = 65535;
                            if (c != 0) {
                            }
                            spannableStringBuilder.append(c5);
                            if (indexOf == indexOf2) {
                            }
                            i = indexOf + 1;
                        } else if (hashCode != 96708) {
                            if (hashCode == 3374865 && substring.equals("nbsp")) {
                                c = 2;
                                if (c != 0) {
                                    c5 = '<';
                                } else if (c != 1) {
                                    if (c == 2) {
                                        c5 = TokenParser.f4579SP;
                                    } else if (c != 3) {
                                        substring.length();
                                        if (indexOf == indexOf2) {
                                            spannableStringBuilder.append((CharSequence) StringUtils.SPACE);
                                        }
                                        i = indexOf + 1;
                                    } else {
                                        c5 = '&';
                                    }
                                }
                                spannableStringBuilder.append(c5);
                                if (indexOf == indexOf2) {
                                }
                                i = indexOf + 1;
                            }
                            c = 65535;
                            if (c != 0) {
                            }
                            spannableStringBuilder.append(c5);
                            if (indexOf == indexOf2) {
                            }
                            i = indexOf + 1;
                        } else {
                            if (substring.equals("amp")) {
                                c = 3;
                                if (c != 0) {
                                }
                                spannableStringBuilder.append(c5);
                                if (indexOf == indexOf2) {
                                }
                                i = indexOf + 1;
                            }
                            c = 65535;
                            if (c != 0) {
                            }
                            spannableStringBuilder.append(c5);
                            if (indexOf == indexOf2) {
                            }
                            i = indexOf + 1;
                        }
                    } else {
                        spannableStringBuilder.append(charAt);
                    }
                } else if (charAt != '<') {
                    spannableStringBuilder.append(charAt);
                    i++;
                } else {
                    int i2 = i + 1;
                    if (i2 < str2.length()) {
                        boolean z2 = str2.charAt(i2) == '/';
                        int indexOf3 = str2.indexOf(62, i2);
                        i2 = indexOf3 == -1 ? str2.length() : indexOf3 + 1;
                        int i3 = i2 - 2;
                        boolean z3 = str2.charAt(i3) == '/';
                        int i4 = i + (z2 ? 2 : 1);
                        if (!z3) {
                            i3 = i2 - 1;
                        }
                        String substring2 = str2.substring(i4, i3);
                        if (!substring2.trim().isEmpty()) {
                            String trim = substring2.trim();
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!trim.isEmpty());
                            String str4 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim, "[ \\.]")[c4];
                            int hashCode2 = str4.hashCode();
                            if (hashCode2 == 98) {
                                if (str4.equals("b")) {
                                    c2 = 0;
                                    switch (c2) {
                                    }
                                    if (z) {
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            } else if (hashCode2 == 99) {
                                if (str4.equals(C1543ak.f2969aF)) {
                                    c2 = 1;
                                    switch (c2) {
                                    }
                                    if (z) {
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            } else if (hashCode2 == 105) {
                                if (str4.equals(C1543ak.f2966aC)) {
                                    c2 = 2;
                                    switch (c2) {
                                    }
                                    if (z) {
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            } else if (hashCode2 == 3650) {
                                if (str4.equals("rt")) {
                                    c2 = 5;
                                    switch (c2) {
                                    }
                                    if (z) {
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            } else if (hashCode2 == 3314158) {
                                if (str4.equals("lang")) {
                                    c2 = 3;
                                    switch (c2) {
                                    }
                                    if (z) {
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            } else if (hashCode2 == 3511770) {
                                if (str4.equals("ruby")) {
                                    c2 = 4;
                                    switch (c2) {
                                    }
                                    if (z) {
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            } else if (hashCode2 != 117) {
                                if (hashCode2 == 118 && str4.equals(C1543ak.f2968aE)) {
                                    c2 = 7;
                                    switch (c2) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                            z = true;
                                            break;
                                        default:
                                            z = false;
                                            break;
                                    }
                                    if (z) {
                                        if (z2) {
                                            while (!arrayDeque.isEmpty()) {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayDeque.pop();
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, arrayList, spannableStringBuilder, list);
                                                if (!arrayDeque.isEmpty()) {
                                                    arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, spannableStringBuilder.length(), null));
                                                } else {
                                                    arrayList.clear();
                                                }
                                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(str4)) {
                                                }
                                            }
                                        } else if (!z3) {
                                            int length = spannableStringBuilder.length();
                                            String trim2 = substring2.trim();
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!trim2.isEmpty());
                                            int indexOf4 = trim2.indexOf(StringUtils.SPACE);
                                            if (indexOf4 == -1) {
                                                c3 = 0;
                                            } else {
                                                str3 = trim2.substring(indexOf4).trim();
                                                c3 = 0;
                                                trim2 = trim2.substring(0, indexOf4);
                                            }
                                            String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim2, "\\.");
                                            String str5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[c3];
                                            HashSet hashSet = new HashSet();
                                            for (int i5 = 1; i5 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length; i5++) {
                                                hashSet.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[i5]);
                                            }
                                            arrayDeque.push(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, length, str3, hashSet));
                                        }
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            } else {
                                if (str4.equals(C1543ak.f2970aG)) {
                                    c2 = 6;
                                    switch (c2) {
                                    }
                                    if (z) {
                                    }
                                }
                                c2 = 65535;
                                switch (c2) {
                                }
                                if (z) {
                                }
                            }
                        }
                    }
                    i = i2;
                }
                c4 = 0;
            }
        }
        while (!arrayDeque.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, 0, str3, Collections.emptySet()), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }
}
