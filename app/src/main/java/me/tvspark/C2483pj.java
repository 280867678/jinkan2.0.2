package me.tvspark;

import android.content.Context;
import android.text.Layout;
import android.util.Base64;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.p022ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.tvspark.C2335lj;

/* renamed from: me.tvspark.pj */
/* loaded from: classes4.dex */
public final class C2483pj extends FrameLayout implements SubtitleView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final WebView Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2261jj Wwwwwwwwwwwwwwwwwwwwwwww;
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwww = Collections.emptyList();
    public C2749wg Wwwwwwwwwwwwwwwwwwwww = C2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwww = 0.0533f;
    public int Wwwwwwwwwwwwwwwwwww = 0;
    public float Wwwwwwwwwwwwwwwwww = 0.08f;

    /* renamed from: me.tvspark.pj$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C2483pj(Context context) {
        super(context, null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new C2261jj(context, null);
        C2446oj c2446oj = new C2446oj(context, null);
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2446oj;
        c2446oj.setBackgroundColor(0);
        addView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        addView(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, float f) {
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -3.4028235E38f ? "unset" : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%.2fpx", Float.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x01b0, code lost:
        if (r13 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01b5, code lost:
        r20 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b7, code lost:
        r21 = r22;
        r22 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b3, code lost:
        if (r13 != false) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i;
        boolean z;
        float f;
        String str;
        Layout.Alignment alignment;
        int i2;
        int i3;
        int i4;
        String str2;
        int i5;
        Iterator it;
        C2483pj c2483pj = this;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[4];
        char c = 0;
        objArr[0] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2483pj.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i6 = 1;
        objArr[1] = c2483pj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2483pj.Wwwwwwwwwwwwwwwwwww, c2483pj.Wwwwwwwwwwwwwwwwwwww);
        float f2 = 1.2f;
        objArr[2] = Float.valueOf(1.2f);
        C2749wg c2749wg = c2483pj.Wwwwwwwwwwwwwwwwwwwww;
        int i7 = c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        objArr[3] = i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? "unset" : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("-0.05em -0.05em 0.15em %s", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0.06em 0.08em 0.15em %s", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0.1em 0.12em 0.15em %s", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2749wg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        sb.append(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2fem;text-shadow:%s;'>", objArr));
        HashMap hashMap = new HashMap();
        hashMap.put(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_bg"), C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("background-color:%s;", Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2483pj.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
        int i8 = 0;
        while (i8 < c2483pj.Wwwwwwwwwwwwwwwwwwwwww.size()) {
            C2786xg c2786xg = c2483pj.Wwwwwwwwwwwwwwwwwwwwww.get(i8);
            float f3 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f4 = f3 != -3.4028235E38f ? f3 * 100.0f : 50.0f;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            float f5 = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (f5 == -3.4028235E38f) {
                Object[] objArr2 = new Object[i6];
                objArr2[c] = Float.valueOf((1.0f - c2483pj.Wwwwwwwwwwwwwwwwww) * 100.0f);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%.2f%%", objArr2);
                i = -100;
            } else if (c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i6) {
                Object[] objArr3 = new Object[i6];
                objArr3[c] = Float.valueOf(f5 * 100.0f);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%.2f%%", objArr3);
                i = c2786xg.Wwwwwwwwwwwwwwwwwwww == i6 ? -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (f5 >= 0.0f) {
                Object[] objArr4 = new Object[i6];
                objArr4[c] = Float.valueOf(f5 * f2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%.2fem", objArr4);
                i = 0;
            } else {
                Object[] objArr5 = new Object[i6];
                objArr5[c] = Float.valueOf(((-f5) - 1.0f) * f2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%.2fem", objArr5);
                i = 0;
                z = true;
                f = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                if (f == -3.4028235E38f) {
                    Object[] objArr6 = new Object[i6];
                    objArr6[0] = Float.valueOf(f * 100.0f);
                    str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%.2f%%", objArr6);
                } else {
                    str = "fit-content";
                }
                alignment = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                String str3 = "center";
                if (alignment != null) {
                    i2 = 2;
                } else {
                    int i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[alignment.ordinal()];
                    i2 = 2;
                    if (i9 == i6) {
                        str3 = "start";
                    } else if (i9 == 2) {
                        str3 = "end";
                    }
                }
                int i10 = c2786xg.Wwwwwwwwwwwwwwwwwwww;
                String str4 = i10 == i6 ? i10 != i2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2483pj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwww, c2786xg.Wwwwwwwwwwwwwwwwwwwww);
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!c2786xg.Wwwwwwwwwwwwwwwwwwwwwwww ? c2786xg.Wwwwwwwwwwwwwwwwwwwwwww : c2483pj.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                int i11 = i;
                i3 = c2786xg.Wwwwwwwwwwwwwwwwwwww;
                String str5 = "right";
                String str6 = "left";
                String str7 = "top";
                if (i3 == 1) {
                    if (i3 != 2) {
                        if (z) {
                            str7 = "bottom";
                        }
                    }
                }
                i4 = c2786xg.Wwwwwwwwwwwwwwwwwwww;
                if (i4 != 2 || i4 == 1) {
                    str2 = "height";
                    i5 = i11;
                    i11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                } else {
                    str2 = "width";
                    i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                C2335lj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2335lj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, getContext().getResources().getDisplayMetrics().density);
                it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str8 = (String) it.next();
                    String str9 = (String) hashMap.put(str8, (String) hashMap.get(str8));
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str9 == null || str9.equals(hashMap.get(str8)));
                    it = it2;
                }
                sb.append(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<div style='position:absolute;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%);'>", str6, Float.valueOf(f4), str7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str2, str, str3, str4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.valueOf(i5), Integer.valueOf(i11)));
                sb.append(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<span class='%s'>", "default_bg"));
                sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                sb.append("</span>");
                sb.append("</div>");
                i8++;
                f2 = 1.2f;
                c = 0;
                i6 = 1;
                c2483pj = this;
            }
            z = false;
            f = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (f == -3.4028235E38f) {
            }
            alignment = c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String str32 = "center";
            if (alignment != null) {
            }
            int i102 = c2786xg.Wwwwwwwwwwwwwwwwwwww;
            if (i102 == i6) {
            }
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42 = c2483pj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwww, c2786xg.Wwwwwwwwwwwwwwwwwwwww);
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!c2786xg.Wwwwwwwwwwwwwwwwwwwwwwww ? c2786xg.Wwwwwwwwwwwwwwwwwwwwwww : c2483pj.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i112 = i;
            i3 = c2786xg.Wwwwwwwwwwwwwwwwwwww;
            String str52 = "right";
            String str62 = "left";
            String str72 = "top";
            if (i3 == 1) {
            }
            i4 = c2786xg.Wwwwwwwwwwwwwwwwwwww;
            if (i4 != 2) {
            }
            str2 = "height";
            i5 = i112;
            i112 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            C2335lj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52 = C2335lj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, getContext().getResources().getDisplayMetrics().density);
            it = hashMap.keySet().iterator();
            while (it.hasNext()) {
            }
            sb.append(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<div style='position:absolute;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%);'>", str62, Float.valueOf(f4), str72, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str2, str, str32, str4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Integer.valueOf(i5), Integer.valueOf(i112)));
            sb.append(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<span class='%s'>", "default_bg"));
            sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            sb.append("</span>");
            sb.append("</div>");
            i8++;
            f2 = 1.2f;
            c = 0;
            i6 = 1;
            c2483pj = this;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (String str10 : hashMap.keySet()) {
            sb2.append(str10);
            sb2.append("{");
            sb2.append((String) hashMap.get(str10));
            sb2.append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.Wwwwwwwwwwwwwwwwwwwwwww.loadData(Base64.encodeToString(sb.toString().getBytes(C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), 1), "text/html", "base64");
    }

    @Override // com.google.android.exoplayer2.p022ui.SubtitleView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2786xg> list, C2749wg c2749wg, float f, int i, float f2) {
        this.Wwwwwwwwwwwwwwwwwwwww = c2749wg;
        this.Wwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwww = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2786xg c2786xg = list.get(i2);
            if (c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                arrayList.add(c2786xg);
            } else {
                arrayList2.add(c2786xg);
            }
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwww.isEmpty() || !arrayList2.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwww = arrayList2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, c2749wg, f, i, f2);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.Wwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
