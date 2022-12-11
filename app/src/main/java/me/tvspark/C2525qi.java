package me.tvspark;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;

/* renamed from: me.tvspark.qi */
/* loaded from: classes4.dex */
public final class C2525qi extends AbstractC2823yg {
    public final C2078el Wwwwwwwwwwwwwwwwwwwww = new C2078el();
    public final C2297ki Wwwwwwwwwwwwwwwwwwww = new C2297ki();

    public C2525qi() {
        super("WebvttDecoder");
    }

    /* JADX WARN: Code restructure failed: missing block: B:198:0x0112, code lost:
        if (")".equals(me.tvspark.C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r9, r10)) == false) goto L201;
     */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v2 */
    @Override // me.tvspark.AbstractC2823yg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        C2445oi Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str;
        C2297ki c2297ki;
        String sb;
        C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwww;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        int i2 = 0;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        ArrayList arrayList = new ArrayList();
        try {
            C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
            do {
            } while (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwww;
                int i3 = -1;
                ?? r8 = 1;
                char c = 65535;
                int i4 = 0;
                while (c == 65535) {
                    i4 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    c = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? (char) 0 : "STYLE".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? (char) 2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("NOTE") ? (char) 1 : (char) 3;
                }
                c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                if (c == 0) {
                    return new C2599si(arrayList2);
                }
                if (c == 1) {
                    do {
                    } while (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                } else {
                    if (c == 2) {
                        if (!arrayList2.isEmpty()) {
                            throw new SubtitleDecoderException("A style block was found after the first cue.");
                        }
                        this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        C2297ki c2297ki2 = this.Wwwwwwwwwwwwwwwwwwww;
                        C2078el c2078el3 = this.Wwwwwwwwwwwwwwwwwwwww;
                        c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLength(i2);
                        int i5 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        while (!TextUtils.isEmpty(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                            i3 = -1;
                        }
                        c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                        ArrayList arrayList3 = new ArrayList();
                        while (true) {
                            C2078el c2078el4 = c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            StringBuilder sb2 = c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el4);
                            if (c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 5 && "::cue".equals(c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5))) {
                                int i6 = c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el4, sb2);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                    if ("{".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                        c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                                        str = "";
                                    } else if ("(".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                        int i7 = c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        int i8 = c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        boolean z2 = false;
                                        while (i7 < i8 && !z2) {
                                            int i9 = i7 + 1;
                                            z2 = ((char) c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i7]) == ')';
                                            i7 = i9;
                                        }
                                        str = c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i7 - 1) - c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).trim();
                                    } else {
                                        str = null;
                                    }
                                    if (str == null || !"{".equals(C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                                        break;
                                    }
                                    C2408ni c2408ni = new C2408ni();
                                    if (!"".equals(str)) {
                                        int indexOf = str.indexOf(91);
                                        if (indexOf != i3) {
                                            Matcher matcher = C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str.substring(indexOf));
                                            if (matcher.matches()) {
                                                String group = matcher.group((int) r8);
                                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                                                c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = group;
                                            }
                                            str = str.substring(i2, indexOf);
                                        }
                                        String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "\\.");
                                        String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[i2];
                                        int indexOf2 = str2.indexOf(35);
                                        if (indexOf2 != i3) {
                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2.substring(i2, indexOf2);
                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2.substring(indexOf2 + 1);
                                        } else {
                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
                                        }
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length > r8) {
                                            int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length;
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((boolean) r8);
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length);
                                            int i10 = r8 == true ? 1 : 0;
                                            int i11 = r8 == true ? 1 : 0;
                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashSet(Arrays.asList((String[]) Arrays.copyOfRange(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, i10, length)));
                                        }
                                    }
                                    boolean z3 = false;
                                    String str3 = null;
                                    while (!z3) {
                                        C2078el c2078el5 = c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        int i12 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5, c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        boolean z4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null || "}".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                        if (!z4) {
                                            c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i12);
                                            C2078el c2078el6 = c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            StringBuilder sb3 = c2297ki2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el6);
                                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el6, sb3);
                                            if (!"".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                if (!":".equals(C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el6, sb3))) {
                                                    c2297ki = c2297ki2;
                                                } else {
                                                    C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el6);
                                                    StringBuilder sb4 = new StringBuilder();
                                                    boolean z5 = false;
                                                    while (true) {
                                                        c2297ki = c2297ki2;
                                                        if (z5) {
                                                            sb = sb4.toString();
                                                            break;
                                                        }
                                                        int i13 = c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                        boolean z6 = z5;
                                                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el6, sb3);
                                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                                                            sb = null;
                                                            break;
                                                        } else if ("}".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) || ";".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                            c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i13);
                                                            c2297ki2 = c2297ki;
                                                            z5 = true;
                                                        } else {
                                                            sb4.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                                            c2297ki2 = c2297ki;
                                                            z5 = z6;
                                                        }
                                                    }
                                                    if (sb != null && !"".equals(sb)) {
                                                        int i14 = c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2297ki.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el6, sb3);
                                                        if (!";".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)) {
                                                            if ("}".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4)) {
                                                                c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14);
                                                            }
                                                        }
                                                        if ("color".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2638tk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, true);
                                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                                        } else if ("background-color".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwww = C2638tk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, true);
                                                            c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                                        } else {
                                                            if ("ruby-position".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                                if ("over".equals(sb)) {
                                                                    c2408ni.Wwwwwwwwwwwwwwwwwww = 1;
                                                                } else if ("under".equals(sb)) {
                                                                    c2408ni.Wwwwwwwwwwwwwwwwwww = 2;
                                                                }
                                                            } else if ("text-combine-upright".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                                c2408ni.Wwwwwwwwwwwwwwwwww = "all".equals(sb) || sb.startsWith("digits");
                                                            } else if ("text-decoration".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                                if ("underline".equals(sb)) {
                                                                    c2408ni.Wwwwwwwwwwwwwwwwwwwwwwww = 1;
                                                                }
                                                            } else if ("font-family".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                                c2408ni.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb);
                                                            } else {
                                                                if ("font-weight".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                                                                    if ("bold".equals(sb)) {
                                                                        c2408ni.Wwwwwwwwwwwwwwwwwwwwwww = 1;
                                                                    }
                                                                } else if ("font-style".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) && "italic".equals(sb)) {
                                                                    c2408ni.Wwwwwwwwwwwwwwwwwwwwww = 1;
                                                                }
                                                                str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                                                z3 = z4;
                                                                c2297ki2 = c2297ki;
                                                            }
                                                            str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                                            z3 = z4;
                                                            c2297ki2 = c2297ki;
                                                        }
                                                    }
                                                }
                                                str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                                z3 = z4;
                                                c2297ki2 = c2297ki;
                                            }
                                        }
                                        c2297ki = c2297ki2;
                                        str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                        z3 = z4;
                                        c2297ki2 = c2297ki;
                                    }
                                    C2297ki c2297ki3 = c2297ki2;
                                    if ("}".equals(str3)) {
                                        arrayList3.add(c2408ni);
                                    }
                                    c2297ki2 = c2297ki3;
                                    i2 = 0;
                                    i3 = -1;
                                    r8 = 1;
                                }
                            }
                            str = null;
                            if (str == null) {
                                break;
                            }
                            break;
                        }
                        arrayList.addAll(arrayList3);
                    } else if (c == 3 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2482pi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, arrayList)) != null) {
                        arrayList2.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    i2 = 0;
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
