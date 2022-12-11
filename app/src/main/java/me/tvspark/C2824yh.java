package me.tvspark;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: me.tvspark.yh */
/* loaded from: classes4.dex */
public final class C2824yh extends AbstractC2823yg {
    public static final Pattern Wwwwwwwwwwwwwwwwwww = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    public static final Pattern Wwwwwwwwwwwwwwwwww = Pattern.compile("\\{\\\\.*?\\}");
    public final StringBuilder Wwwwwwwwwwwwwwwwwwwww = new StringBuilder();
    public final ArrayList<String> Wwwwwwwwwwwwwwwwwwww = new ArrayList<>();

    public C2824yh() {
        super("SubripDecoder");
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 0) {
            if (i == 1) {
                return 0.5f;
            }
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            return 0.92f;
        }
        return 0.08f;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matcher matcher, int i) {
        String group = matcher.group(i + 1);
        long parseLong = group != null ? Long.parseLong(group) * 60 * 60 * 1000 : 0L;
        String group2 = matcher.group(i + 2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
        String group3 = matcher.group(i + 3);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3);
        long parseLong2 = (Long.parseLong(group3) * 1000) + (Long.parseLong(group2) * 60 * 1000) + parseLong;
        String group4 = matcher.group(i + 4);
        if (group4 != null) {
            parseLong2 += Long.parseLong(group4);
        }
        return parseLong2 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // me.tvspark.AbstractC2823yg
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) {
        C2078el c2078el;
        String str;
        long[] jArr;
        char c;
        char c2;
        C2786xg c2786xg;
        C2824yh c2824yh = this;
        ArrayList arrayList = new ArrayList();
        long[] jArr2 = new long[32];
        C2078el c2078el2 = new C2078el(bArr, i);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() != 0) {
                    try {
                        Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } catch (NumberFormatException unused) {
                        c2078el = c2078el2;
                        str = "Skipping invalid index: ";
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() == 0) {
                            new String(str);
                        }
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Matcher matcher = Wwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (matcher.matches()) {
                            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher, 1);
                            if (i3 == jArr2.length) {
                                jArr2 = Arrays.copyOf(jArr2, i3 * 2);
                            }
                            int i4 = i3 + 1;
                            jArr2[i3] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher, 6);
                            if (i4 == jArr2.length) {
                                jArr2 = Arrays.copyOf(jArr2, i4 * 2);
                            }
                            int i5 = i4 + 1;
                            jArr2[i4] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            c2824yh.Wwwwwwwwwwwwwwwwwwwww.setLength(i2);
                            c2824yh.Wwwwwwwwwwwwwwwwwwww.clear();
                            for (String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); !TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2); Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                if (c2824yh.Wwwwwwwwwwwwwwwwwwwww.length() > 0) {
                                    c2824yh.Wwwwwwwwwwwwwwwwwwwww.append("<br>");
                                }
                                StringBuilder sb = c2824yh.Wwwwwwwwwwwwwwwwwwwww;
                                ArrayList<String> arrayList2 = c2824yh.Wwwwwwwwwwwwwwwwwwww;
                                String trim = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.trim();
                                StringBuilder sb2 = new StringBuilder(trim);
                                Matcher matcher2 = Wwwwwwwwwwwwwwwwww.matcher(trim);
                                int i6 = 0;
                                while (matcher2.find()) {
                                    String group = matcher2.group();
                                    arrayList2.add(group);
                                    int start = matcher2.start() - i6;
                                    int length = group.length();
                                    sb2.replace(start, start + length, "");
                                    i6 += length;
                                }
                                sb.append(sb2.toString());
                            }
                            Spanned fromHtml = Html.fromHtml(c2824yh.Wwwwwwwwwwwwwwwwwwwww.toString());
                            String str2 = null;
                            int i7 = 0;
                            while (true) {
                                if (i7 < c2824yh.Wwwwwwwwwwwwwwwwwwww.size()) {
                                    String str3 = c2824yh.Wwwwwwwwwwwwwwwwwwww.get(i7);
                                    if (str3.matches("\\{\\\\an[1-9]\\}")) {
                                        str2 = str3;
                                    } else {
                                        i7++;
                                    }
                                }
                            }
                            if (str2 == null) {
                                c2786xg = new C2786xg(fromHtml, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, null);
                                jArr = jArr2;
                                c2078el = c2078el2;
                            } else {
                                jArr = jArr2;
                                switch (str2.hashCode()) {
                                    case -685620710:
                                        if (str2.equals("{\\an1}")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620679:
                                        if (str2.equals("{\\an2}")) {
                                            c = 6;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620648:
                                        if (str2.equals("{\\an3}")) {
                                            c = 3;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620617:
                                        if (str2.equals("{\\an4}")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620586:
                                        if (str2.equals("{\\an5}")) {
                                            c = 7;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620555:
                                        if (str2.equals("{\\an6}")) {
                                            c = 4;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620524:
                                        if (str2.equals("{\\an7}")) {
                                            c = 2;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620493:
                                        if (str2.equals("{\\an8}")) {
                                            c = '\b';
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620462:
                                        if (str2.equals("{\\an9}")) {
                                            c = 5;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                c2078el = c2078el2;
                                int i8 = (c == 0 || c == 1 || c == 2) ? 0 : (c == 3 || c == 4 || c == 5) ? 2 : 1;
                                switch (str2.hashCode()) {
                                    case -685620710:
                                        if (str2.equals("{\\an1}")) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620679:
                                        if (str2.equals("{\\an2}")) {
                                            c2 = 1;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620648:
                                        if (str2.equals("{\\an3}")) {
                                            c2 = 2;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620617:
                                        if (str2.equals("{\\an4}")) {
                                            c2 = 6;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620586:
                                        if (str2.equals("{\\an5}")) {
                                            c2 = 7;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620555:
                                        if (str2.equals("{\\an6}")) {
                                            c2 = '\b';
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620524:
                                        if (str2.equals("{\\an7}")) {
                                            c2 = 3;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620493:
                                        if (str2.equals("{\\an8}")) {
                                            c2 = 4;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -685620462:
                                        if (str2.equals("{\\an9}")) {
                                            c2 = 5;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        c2 = 65535;
                                        break;
                                }
                                int i9 = (c2 == 0 || c2 == 1 || c2 == 2) ? 2 : (c2 == 3 || c2 == 4 || c2 == 5) ? 0 : 1;
                                c2786xg = new C2786xg(fromHtml, null, null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9), 0, i9, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8), i8, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, null);
                            }
                            arrayList.add(c2786xg);
                            arrayList.add(C2786xg.Wwwwwwwwwwwwwwwwwww);
                            i2 = 0;
                            c2824yh = this;
                            i3 = i5;
                            jArr2 = jArr;
                            c2078el2 = c2078el;
                        } else {
                            c2078el = c2078el2;
                            str = "Skipping invalid timing: ";
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() == 0) {
                                new String(str);
                                i2 = 0;
                                c2824yh = this;
                                c2078el2 = c2078el;
                            }
                            str.concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            i2 = 0;
                            c2824yh = this;
                            c2078el2 = c2078el;
                        }
                    }
                }
            }
        }
        return new C2861zh((C2786xg[]) arrayList.toArray(new C2786xg[0]), Arrays.copyOf(jArr2, i3));
    }
}
