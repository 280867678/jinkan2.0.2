package me.tvspark;

import android.graphics.PointF;
import android.text.Layout;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.C2750wh;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.uh */
/* loaded from: classes4.dex */
public final class C2672uh extends AbstractC2823yg {
    public static final Pattern Wwwwwwwwwwwwwwww = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public Map<String, C2750wh> Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2710vh Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwww = -3.4028235E38f;
    public float Wwwwwwwwwwwwwwwww = -3.4028235E38f;

    public C2672uh(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.get(0));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("Format:"));
        C2710vh Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2078el(list.get(1)));
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 0) {
            if (i == 1) {
                return 0.5f;
            }
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.05f;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, List<Long> list, List<List<C2786xg>> list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            } else if (list.get(size).longValue() == j) {
                return size;
            } else {
                if (list.get(size).longValue() < j) {
                    i = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList(list2.get(i - 1)));
        return i;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Matcher matcher = Wwwwwwwwwwwwwwww.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
        long parseLong = (Long.parseLong(matcher.group(2)) * 60 * StopWatch.NANO_2_MILLIS) + (Long.parseLong(group) * 60 * 60 * StopWatch.NANO_2_MILLIS);
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * StopWatch.NANO_2_MILLIS) + parseLong;
    }

    @Override // me.tvspark.AbstractC2823yg
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) {
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        int i2;
        int i3;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C2078el c2078el = new C2078el(bArr, i);
        if (!this.Wwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
        }
        C2710vh c2710vh = this.Wwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwww : null;
        while (true) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("Format:")) {
                    c2710vh = C2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("Dialogue:")) {
                    if (c2710vh != null) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("Dialogue:"));
                        String[] split = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(9).split(",", c2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (split.length == c2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[c2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -9223372036854775807L) {
                                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[c2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != -9223372036854775807L) {
                                    Map<String, C2750wh> map = this.Wwwwwwwwwwwwwwwwwww;
                                    C2750wh c2750wh = (map == null || (i5 = c2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == -1) ? null : map.get(split[i5].trim());
                                    String str = split[c2710vh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                                    Matcher matcher = C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
                                    int i6 = -1;
                                    PointF pointF = null;
                                    while (matcher.find()) {
                                        String group = matcher.group(1);
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                                        try {
                                            PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
                                                pointF = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                            }
                                        } catch (RuntimeException unused) {
                                        }
                                        try {
                                            Matcher matcher2 = C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(group);
                                            if (matcher2.find()) {
                                                String group2 = matcher2.group(1);
                                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
                                                i4 = C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
                                            } else {
                                                i4 = -1;
                                            }
                                        } catch (RuntimeException unused2) {
                                        }
                                        if (i4 != -1) {
                                            i6 = i4;
                                        }
                                    }
                                    C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6, pointF);
                                    String replace = C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = this.Wwwwwwwwwwwwwwwwww;
                                    float f2 = this.Wwwwwwwwwwwwwwwww;
                                    int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (i7 == -1) {
                                        i7 = c2750wh != null ? c2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : -1;
                                    }
                                    switch (i7) {
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment2 = Layout.Alignment.ALIGN_NORMAL;
                                            alignment = alignment2;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment2 = Layout.Alignment.ALIGN_CENTER;
                                            alignment = alignment2;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment2 = Layout.Alignment.ALIGN_OPPOSITE;
                                            alignment = alignment2;
                                            break;
                                        default:
                                            alignment = null;
                                            break;
                                    }
                                    switch (i7) {
                                        case 1:
                                        case 4:
                                        case 7:
                                            i2 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i2 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i2 = 2;
                                            break;
                                        default:
                                            i2 = Integer.MIN_VALUE;
                                            break;
                                    }
                                    switch (i7) {
                                        case 1:
                                        case 2:
                                        case 3:
                                            i3 = 2;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i3 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i3 = 0;
                                            break;
                                        default:
                                            i3 = Integer.MIN_VALUE;
                                            break;
                                    }
                                    PointF pointF2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (pointF2 == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                    } else {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = pointF2.y / f2;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pointF2.x / f;
                                    }
                                    C2786xg c2786xg = new C2786xg(replace, alignment, null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, null);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, arrayList2, arrayList);
                                    for (int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, arrayList2, arrayList); Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7++) {
                                        ((List) arrayList.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7)).add(c2786xg);
                                    }
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() != 0) {
                                    "Skipping invalid timing: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                } else {
                                    new String("Skipping invalid timing: ");
                                }
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() != 0) {
                                "Skipping invalid timing: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            } else {
                                new String("Skipping invalid timing: ");
                            }
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() != 0) {
                            "Skipping dialogue line with fewer columns than format: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        } else {
                            new String("Skipping dialogue line with fewer columns than format: ");
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() != 0) {
                        "Skipping dialogue line before complete format: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        new String("Skipping dialogue line before complete format: ");
                    }
                }
            } else {
                return new C2787xh(arrayList, arrayList2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0179 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        char c;
        char c2;
        C2750wh c2750wh;
        while (true) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                if ("[Script Info]".equalsIgnoreCase(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    while (true) {
                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0 || c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 91)) {
                            String[] split = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.split(":");
                            if (split.length == 2) {
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[0].trim());
                                switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode()) {
                                    case 1879649548:
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("playresx")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1879649549:
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("playresy")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                if (c == 0) {
                                    this.Wwwwwwwwwwwwwwwwww = Float.parseFloat(split[1].trim());
                                } else if (c == 1) {
                                    try {
                                        this.Wwwwwwwwwwwwwwwww = Float.parseFloat(split[1].trim());
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                            }
                        }
                    }
                } else if ("[V4+ Styles]".equalsIgnoreCase(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    while (true) {
                        C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                        while (true) {
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null && (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0 || c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 91)) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("Format:")) {
                                    String[] split2 = TextUtils.split(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.substring(7), ",");
                                    int i = -1;
                                    int i2 = -1;
                                    for (int i3 = 0; i3 < split2.length; i3++) {
                                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(split2[i3].trim());
                                        int hashCode = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hashCode();
                                        if (hashCode != 3373707) {
                                            if (hashCode == 1767875043 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("alignment")) {
                                                c2 = 1;
                                            }
                                            c2 = 65535;
                                        } else {
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("name")) {
                                                c2 = 0;
                                            }
                                            c2 = 65535;
                                        }
                                        if (c2 == 0) {
                                            i = i3;
                                        } else if (c2 == 1) {
                                            i2 = i3;
                                        }
                                    }
                                    if (i != -1) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, split2.length);
                                    }
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("Style:")) {
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.startsWith("Style:"));
                                        String[] split3 = TextUtils.split(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.substring(6), ",");
                                        int length = split3.length;
                                        int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        if (length != i4) {
                                            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i4), Integer.valueOf(split3.length), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                        } else {
                                            try {
                                                c2750wh = new C2750wh(split3[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].trim(), C2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split3[wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]));
                                            } catch (RuntimeException e) {
                                                StringBuilder sb = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() + 36);
                                                sb.append("Skipping malformed 'Style:' line: '");
                                                sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                                sb.append("'");
                                                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString(), e);
                                            }
                                            if (c2750wh == null) {
                                                linkedHashMap.put(c2750wh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2750wh);
                                            }
                                        }
                                        c2750wh = null;
                                        if (c2750wh == null) {
                                        }
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length() != 0) {
                                        "Skipping 'Style:' line before 'Format:' line: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                    } else {
                                        new String("Skipping 'Style:' line before 'Format:' line: ");
                                    }
                                }
                            }
                        }
                    }
                    this.Wwwwwwwwwwwwwwwwwww = linkedHashMap;
                } else if (!"[V4 Styles]".equalsIgnoreCase(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && "[Events]".equalsIgnoreCase(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
