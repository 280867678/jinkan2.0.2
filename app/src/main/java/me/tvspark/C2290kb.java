package me.tvspark;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.ParserException;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC2327lb;
import me.tvspark.AbstractC2625t7;
import org.mozilla.javascript.Token;

/* renamed from: me.tvspark.kb */
/* loaded from: classes4.dex */
public final class C2290kb implements AbstractC2175h7 {
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public AbstractC2327lb Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwww;
    public C2216ib Wwwwwwwwwwwwwwwwwwwwwwww;
    public final C2253jb Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final SparseBooleanArray Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final SparseBooleanArray Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final SparseArray<AbstractC2327lb> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final SparseIntArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<C2337ll> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.kb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2105fb {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2041dl(new byte[5]);
        public final SparseArray<AbstractC2327lb> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseArray<>();
        public final SparseIntArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseIntArray();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x013d, code lost:
            if (r24.Wwwwwwwwwwwwwwwwwwwwww() == r13) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0228  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0235  */
        @Override // me.tvspark.AbstractC2105fb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
            C2337ll c2337ll;
            C2290kb c2290kb;
            C2337ll c2337ll2;
            int i;
            AbstractC2327lb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2;
            int i3;
            C2337ll c2337ll3;
            int i4;
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwww() != 2) {
                return;
            }
            C2290kb c2290kb2 = C2290kb.this;
            int i5 = c2290kb2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i5 != 1 && i5 != 2 && c2290kb2.Wwwwwwwwwwwwwwwwwwwwww != 1) {
                c2337ll = new C2337ll(c2290kb2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(c2337ll);
            } else {
                c2337ll = C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0);
            }
            if ((c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 128) == 0) {
                return;
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
            int i6 = 3;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            int i7 = 13;
            C2290kb.this.Wwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(13);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 2);
            int i8 = 4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            int i9 = 12;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12));
            C2290kb c2290kb3 = C2290kb.this;
            int i10 = 21;
            if (c2290kb3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 && c2290kb3.Wwwwwwwwwwwwwwwwww == null) {
                AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, null, null, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                C2290kb c2290kb4 = C2290kb.this;
                c2290kb4.Wwwwwwwwwwwwwwwwww = c2290kb4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                C2290kb c2290kb5 = C2290kb.this;
                c2290kb5.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2337ll, c2290kb5.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww, 21, 8192));
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 0) {
                int i11 = 5;
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 5);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
                int i12 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 + i12;
                int i14 = -1;
                String str = null;
                ArrayList arrayList = null;
                while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < i13) {
                    int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwww2 > i13) {
                        break;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwww == i11) {
                        long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwww != 1094921523) {
                            if (Wwwwwwwwwwwwwwwwwwwww != 1161904947) {
                                if (Wwwwwwwwwwwwwwwwwwwww != 1094921524) {
                                    if (Wwwwwwwwwwwwwwwwwwwww == 1212503619) {
                                        i14 = 36;
                                    }
                                    i3 = Wwwwwwwwwwwwwwwww;
                                    c2337ll3 = c2337ll;
                                    i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                }
                                i14 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2;
                                i3 = Wwwwwwwwwwwwwwwww;
                                c2337ll3 = c2337ll;
                                i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                            }
                            i14 = Token.EXPR_RESULT;
                            i3 = Wwwwwwwwwwwwwwwww;
                            c2337ll3 = c2337ll;
                            i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                        }
                        i14 = 129;
                        i3 = Wwwwwwwwwwwwwwwww;
                        c2337ll3 = c2337ll;
                        i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                    } else {
                        if (Wwwwwwwwwwwwwwwwwwwwww != 106) {
                            if (Wwwwwwwwwwwwwwwwwwwwww != 122) {
                                if (Wwwwwwwwwwwwwwwwwwwwww != 127) {
                                    if (Wwwwwwwwwwwwwwwwwwwwww == 123) {
                                        i14 = Token.TYPEOFNAME;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwww == 10) {
                                        str = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3).trim();
                                        i3 = Wwwwwwwwwwwwwwwww;
                                        c2337ll3 = c2337ll;
                                        i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                    } else {
                                        int i15 = 3;
                                        if (Wwwwwwwwwwwwwwwwwwwwww == 89) {
                                            ArrayList arrayList2 = new ArrayList();
                                            while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < Wwwwwwwwwwwwwwwwwwwwww2) {
                                                String trim = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i15).trim();
                                                int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                                                byte[] bArr = new byte[4];
                                                System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, 4);
                                                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 4;
                                                arrayList2.add(new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trim, Wwwwwwwwwwwwwwwwwwwwww3, bArr));
                                                c2337ll = c2337ll;
                                                Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwww;
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                                i15 = 3;
                                            }
                                            i3 = Wwwwwwwwwwwwwwwww;
                                            c2337ll3 = c2337ll;
                                            i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                            arrayList = arrayList2;
                                            i14 = 89;
                                        } else {
                                            i3 = Wwwwwwwwwwwwwwwww;
                                            c2337ll3 = c2337ll;
                                            i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                            if (Wwwwwwwwwwwwwwwwwwwwww == 111) {
                                                i14 = InputDeviceCompat.SOURCE_KEYBOARD;
                                            }
                                        }
                                    }
                                }
                                i3 = Wwwwwwwwwwwwwwwww;
                                c2337ll3 = c2337ll;
                                i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                            }
                            i14 = Token.EXPR_RESULT;
                            i3 = Wwwwwwwwwwwwwwwww;
                            c2337ll3 = c2337ll;
                            i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                        }
                        i14 = 129;
                        i3 = Wwwwwwwwwwwwwwwww;
                        c2337ll3 = c2337ll;
                        i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                    }
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww2 - c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    c2337ll = c2337ll3;
                    Wwwwwwwwwwwwwwwww = i3;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = i4;
                    i11 = 5;
                    i10 = 21;
                }
                int i16 = Wwwwwwwwwwwwwwwww;
                C2337ll c2337ll4 = c2337ll;
                int i17 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i13);
                AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i14, str, arrayList, Arrays.copyOfRange(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i12, i13));
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 6 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 5) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 + 5;
                int i18 = C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 : i17;
                if (!C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.get(i18)) {
                    C2290kb c2290kb6 = C2290kb.this;
                    if (c2290kb6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 21) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2290kb6.Wwwwwwwwwwwwwwwwww;
                        if (C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 2) {
                            i2 = i17;
                            if (i2 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i18, 8192)) {
                            }
                        } else {
                            i2 = i17;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i18, i2);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i18, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 2) {
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i18, i2);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i18, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                c2337ll = c2337ll4;
                Wwwwwwwwwwwwwwwww = i16;
                i6 = 3;
                i8 = 4;
                i7 = 13;
                i9 = 12;
                i10 = 21;
            }
            int i19 = Wwwwwwwwwwwwwwwww;
            C2337ll c2337ll5 = c2337ll;
            int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            int i20 = 0;
            while (i20 < size) {
                int keyAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keyAt(i20);
                int valueAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i20);
                C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.put(keyAt, true);
                C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwww.put(valueAt, true);
                AbstractC2327lb valueAt2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i20);
                if (valueAt2 != null) {
                    C2290kb c2290kb7 = C2290kb.this;
                    if (valueAt2 != c2290kb7.Wwwwwwwwwwwwwwwwww) {
                        AbstractC2249j7 abstractC2249j7 = c2290kb7.Wwwwwwwwwwwwwwwwwwwwwww;
                        i = i19;
                        AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, keyAt, 8192);
                        c2337ll2 = c2337ll5;
                        valueAt2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2337ll2, abstractC2249j7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        c2337ll2 = c2337ll5;
                        i = i19;
                    }
                    C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.put(valueAt, valueAt2);
                } else {
                    c2337ll2 = c2337ll5;
                    i = i19;
                }
                i20++;
                c2337ll5 = c2337ll2;
                i19 = i;
            }
            C2290kb c2290kb8 = C2290kb.this;
            if (c2290kb8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                if (c2290kb8.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                c2290kb8.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c2290kb = C2290kb.this;
                c2290kb.Wwwwwwwwwwwwwwwwwwwwww = 0;
            } else {
                c2290kb8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                C2290kb c2290kb9 = C2290kb.this;
                c2290kb9.Wwwwwwwwwwwwwwwwwwwwww = c2290kb9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 ? 0 : c2290kb9.Wwwwwwwwwwwwwwwwwwwwww - 1;
                C2290kb c2290kb10 = C2290kb.this;
                if (c2290kb10.Wwwwwwwwwwwwwwwwwwwwww != 0) {
                    return;
                }
                c2290kb10.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c2290kb = C2290kb.this;
            }
            c2290kb.Wwwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.AbstractC2105fb
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2337ll c2337ll, AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    /* renamed from: me.tvspark.kb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2105fb {
        public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2041dl(new byte[4]);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2105fb
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 0 && (c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 128) != 0) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() / 4;
                for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(13);
                    } else {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(13);
                        if (C2290kb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) == null) {
                            C2290kb c2290kb = C2290kb.this;
                            c2290kb.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, new C2142gb(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)));
                            C2290kb.this.Wwwwwwwwwwwwwwwwwwwwww++;
                        }
                    }
                }
                C2290kb c2290kb2 = C2290kb.this;
                if (c2290kb2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                    return;
                }
                c2290kb2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(0);
            }
        }

        @Override // me.tvspark.AbstractC2105fb
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2337ll c2337ll, AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    static {
        C2178ha c2178ha = C2178ha.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public C2290kb(int i, C2337ll c2337ll, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i2) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            if (i == 1 || i == 2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(c2337ll);
            } else {
                ArrayList arrayList = new ArrayList();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
                arrayList.add(c2337ll);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(new byte[9400], 0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseBooleanArray();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new SparseBooleanArray();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseArray<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseIntArray();
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = new C2253jb(i2);
            this.Wwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            SparseArray<AbstractC2327lb> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.keyAt(i3), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.valueAt(i3));
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.put(0, new C2142gb(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
            this.Wwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw null;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2290kb(1, new C2337ll(0L), new C2437oa(0), 112800)};
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v3 */
    @Override // me.tvspark.AbstractC2175h7
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        ?? r3;
        ?? r4;
        int i;
        boolean z;
        int i2;
        boolean z2;
        AbstractC2249j7 abstractC2249j7;
        AbstractC2625t7 wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long length = abstractC2212i7.getLength();
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            long j = -9223372036854775807L;
            if ((length == -1 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) ? false : true) {
                C2253jb c2253jb = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (!c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    int i3 = this.Wwwwwwwwwwwwwwww;
                    if (i3 > 0) {
                        if (!c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            long length2 = abstractC2212i7.getLength();
                            int min = (int) Math.min(c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, length2);
                            long j2 = length2 - min;
                            if (abstractC2212i7.getPosition() == j2) {
                                c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
                                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, min);
                                C2078el c2078el = c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i5 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                while (true) {
                                    i5--;
                                    if (i5 < i4) {
                                        break;
                                    } else if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5] == 71) {
                                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, i5, i3);
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -9223372036854775807L) {
                                            j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                            break;
                                        }
                                    }
                                }
                                c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                                c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                return 0;
                            }
                            c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
                        } else if (c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                            if (!c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                int min2 = (int) Math.min(c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2212i7.getLength());
                                long j3 = 0;
                                if (abstractC2212i7.getPosition() == j3) {
                                    c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min2);
                                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, min2);
                                    C2078el c2078el2 = c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i6 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i7 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    while (true) {
                                        if (i6 >= i7) {
                                            break;
                                        }
                                        if (c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i6] == 71) {
                                            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2, i6, i3);
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -9223372036854775807L) {
                                                j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                                break;
                                            }
                                        }
                                        i6++;
                                    }
                                    c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                                    c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                    return 0;
                                }
                                c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                            } else {
                                long j4 = c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (j4 != -9223372036854775807L) {
                                    c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwww) - c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4);
                                }
                            }
                        }
                        return 1;
                    }
                    c2253jb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                    return 0;
                }
            }
            if (!this.Wwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwww = true;
                C2253jb c2253jb2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                long j5 = c2253jb2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                if (j5 != -9223372036854775807L) {
                    C2216ib c2216ib = new C2216ib(c2253jb2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j5, length, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = c2216ib;
                    abstractC2249j7 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2216ib.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    abstractC2249j7 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j5, 0L);
                }
                abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (this.Wwwwwwwwwwwwwwwwwww) {
                z2 = false;
                this.Wwwwwwwwwwwwwwwwwww = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L, 0L);
                if (abstractC2212i7.getPosition() != 0) {
                    c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
                    return 1;
                }
            } else {
                z2 = false;
            }
            r4 = 1;
            r4 = 1;
            C2216ib c2216ib2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            r3 = z2;
            if (c2216ib2 != null) {
                r3 = z2;
                if (c2216ib2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2588s7);
                }
            }
        } else {
            r3 = 0;
            r4 = 1;
        }
        C2078el c2078el3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (9400 - c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 188) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 > 0) {
                System.arraycopy(bArr, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, r3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        }
        while (true) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 188) {
                i = -1;
                z = true;
                break;
            }
            int i8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int read = abstractC2212i7.read(bArr, i8, 9400 - i8);
            i = -1;
            if (read == -1) {
                z = false;
                break;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8 + read);
        }
        if (!z) {
            return i;
        }
        C2078el c2078el4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i9 = c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i10 = c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr2 = c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i11 = i9;
        while (i11 < i10 && bArr2[i11] != 71) {
            i11++;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11);
        int i12 = i11 + 188;
        if (i12 > i10) {
            int i13 = (i11 - i9) + this.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww = i13;
            i2 = 2;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 && i13 > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            i2 = 2;
            int i14 = r3 == true ? 1 : 0;
            int i15 = r3 == true ? 1 : 0;
            int i16 = r3 == true ? 1 : 0;
            this.Wwwwwwwwwwwwwwwww = i14;
        }
        C2078el c2078el5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i17 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i12 > i17) {
            return r3;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if ((8388608 & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 0) {
            int i18 = (4194304 & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != 0 ? 1 : 0;
            int i19 = r3 == true ? 1 : 0;
            boolean z3 = r3 == true ? 1 : 0;
            boolean z4 = r3 == true ? 1 : 0;
            int i20 = i18 | i19;
            int i21 = (2096896 & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) >> 8;
            boolean z5 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 32) != 0;
            AbstractC2327lb abstractC2327lb = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 16) != 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i21) : null;
            if (abstractC2327lb != null) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i2) {
                    int i22 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 15;
                    int i23 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i21, i22 - 1);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i21, i22);
                    if (i23 != i22) {
                        if (i22 != ((i23 + r4) & 15)) {
                            abstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    }
                }
                if (z5) {
                    int Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                    i20 |= (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww() & 64) != 0 ? 2 : 0;
                    C2078el c2078el6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i24 = r4 == true ? 1 : 0;
                    int i25 = r4 == true ? 1 : 0;
                    int i26 = r4 == true ? 1 : 0;
                    c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww - i24);
                }
                boolean z6 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i2 || z6 || !this.Wwwwwwwwwwwwwwwwwwwwwwwwww.get(i21, r3)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i12);
                    abstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i20);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i17);
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i2 && !z6 && this.Wwwwwwwwwwwwwwwwwwwww && length != -1) {
                    this.Wwwwwwwwwwwwwwwwwww = r4;
                }
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i12);
        return r3;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        C2216ib c2216ib;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 2);
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        for (int i = 0; i < size; i++) {
            C2337ll c2337ll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            if ((c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == -9223372036854775807L) || (c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 0 && c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != j2)) {
                c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
                c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
            }
        }
        if (j2 != 0 && (c2216ib = this.Wwwwwwwwwwwwwwwwwwwwwwww) != null) {
            c2216ib.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwww = 0;
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        boolean z;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z = true;
                    break;
                } else if (bArr[(i2 * 188) + i] != 71) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return true;
            }
        }
        return false;
    }
}
