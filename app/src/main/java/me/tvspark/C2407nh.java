package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.C2444oh;

/* renamed from: me.tvspark.nh */
/* loaded from: classes4.dex */
public final class C2407nh extends AbstractC2823yg {
    public final C2444oh Wwwwwwwwwwwwwwwwwwwww;

    public C2407nh(List<byte[]> list) {
        super("DvbDecoder");
        byte[] bArr = list.get(0);
        int length = bArr.length;
        int i = 0 + 1;
        int i2 = i + 1;
        this.Wwwwwwwwwwwwwwwwwwwww = new C2444oh(((bArr[0] & 255) << 8) | (bArr[i] & 255), (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0228  */
    @Override // me.tvspark.AbstractC2823yg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) {
        C2481ph c2481ph;
        C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        List unmodifiableList;
        C2481ph c2481ph2;
        C2481ph c2481ph3;
        SparseArray<C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray;
        int i2;
        SparseArray<C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2;
        int[] iArr;
        SparseArray sparseArray3;
        int i3;
        C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4;
        int i5;
        int i6;
        int i7;
        if (z) {
            C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        C2444oh c2444oh = this.Wwwwwwwwwwwwwwwwwwwww;
        if (c2444oh != null) {
            C2041dl c2041dl = new C2041dl(bArr, i);
            while (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 48) {
                int i8 = 8;
                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8) == 15) {
                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    int i9 = 16;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 * 8 > c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    } else {
                        switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                            case 16:
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    int i10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 - 2;
                                    SparseArray sparseArray4 = new SparseArray();
                                    while (i10 > 0) {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                                        i10 -= 6;
                                        sparseArray4.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9, new C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16), c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16)));
                                        i8 = 8;
                                    }
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, sparseArray4);
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                                        wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                                        wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                                        break;
                                    } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                        break;
                                    }
                                }
                                break;
                            case 17:
                                C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    int i11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 - 10;
                                    SparseArray sparseArray5 = new SparseArray();
                                    while (i11 > 0) {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
                                        i11 -= 6;
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 2) {
                                            i11 -= 2;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                        } else {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = 0;
                                        }
                                        sparseArray5.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19, new C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                                        i9 = 16;
                                    }
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18, sparseArray5);
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && (wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) != null) {
                                        SparseArray<C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
                                        for (int i12 = 0; i12 < sparseArray6.size(); i12++) {
                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwww.put(sparseArray6.keyAt(i12), sparseArray6.valueAt(i12));
                                        }
                                    }
                                    sparseArray3 = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                    sparseArray3.put(i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                    break;
                                }
                                break;
                            case 18:
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24 = C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                    sparseArray3 = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25 = C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                    sparseArray3 = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25;
                                }
                                i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                sparseArray3.put(i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                break;
                            case 19:
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26 = C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl);
                                    sparseArray3 = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww27 = C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl);
                                    sparseArray3 = wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww27;
                                }
                                i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                sparseArray3.put(i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                break;
                            case 20:
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww28 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww29 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww30 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                        i4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                        i7 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                        i5 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                        i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww30;
                                    } else {
                                        i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww28;
                                        i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww29;
                                        i6 = 0;
                                        i7 = 0;
                                    }
                                    wwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww28, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww29, i6, i4, i7, i5);
                                    break;
                                }
                                break;
                        }
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                } else {
                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        unmodifiableList = Collections.emptyList();
                        c2481ph2 = c2481ph;
                    } else {
                        C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        Bitmap bitmap = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (bitmap == null || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1 != bitmap.getWidth() || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1 != c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeight()) {
                            Bitmap createBitmap = Bitmap.createBitmap(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1, Bitmap.Config.ARGB_8888);
                            c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = createBitmap;
                            c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setBitmap(createBitmap);
                        }
                        ArrayList arrayList = new ArrayList();
                        SparseArray<C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i13 = 0;
                        while (i13 < sparseArray7.size()) {
                            c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.save();
                            C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww valueAt = sparseArray7.valueAt(i13);
                            C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(sparseArray7.keyAt(i13));
                            int i14 = valueAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i15 = valueAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clipRect(i14, i15, Math.min(wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i14, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Math.min(wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i15, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                            C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) == null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                            SparseArray<C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            int i16 = 0;
                            while (i16 < sparseArray8.size()) {
                                int keyAt = sparseArray8.keyAt(i16);
                                C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww valueAt2 = sparseArray8.valueAt(i16);
                                C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(keyAt);
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.get(keyAt);
                                }
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                                    Paint paint = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? null : c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i17 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    sparseArray = sparseArray7;
                                    int i18 = valueAt2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i14;
                                    int i19 = valueAt2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i15;
                                    sparseArray2 = sparseArray8;
                                    Canvas canvas = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    c2481ph3 = c2481ph;
                                    if (i17 == 3) {
                                        iArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    } else {
                                        iArr = i17 == 2 ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    }
                                    i2 = i13;
                                    int[] iArr2 = iArr;
                                    Paint paint2 = paint;
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iArr2, i17, i18, i19, paint2, canvas);
                                    C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iArr2, i17, i18, i19 + 1, paint2, canvas);
                                } else {
                                    c2481ph3 = c2481ph;
                                    sparseArray = sparseArray7;
                                    i2 = i13;
                                    sparseArray2 = sparseArray8;
                                }
                                i16++;
                                sparseArray7 = sparseArray;
                                sparseArray8 = sparseArray2;
                                c2481ph = c2481ph3;
                                i13 = i2;
                            }
                            C2481ph c2481ph4 = c2481ph;
                            SparseArray<C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray9 = sparseArray7;
                            int i20 = i13;
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                int i21 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(i21 == 3 ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww] : i21 == 2 ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwww] : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwww]);
                                c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.drawRect(i14, i15, wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i14, wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i15, c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            Bitmap createBitmap2 = Bitmap.createBitmap(c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i14, i15, wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            float f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            float f2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            arrayList.add(new C2786xg(null, null, createBitmap2, i15 / f2, 0, 0, i14 / f, 0, Integer.MIN_VALUE, -3.4028235E38f, wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / f, wwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / f2, false, -16777216, Integer.MIN_VALUE, null));
                            c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.drawColor(0, PorterDuff.Mode.CLEAR);
                            c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.restore();
                            i13 = i20 + 1;
                            sparseArray7 = sparseArray9;
                            c2481ph = c2481ph4;
                        }
                        unmodifiableList = Collections.unmodifiableList(arrayList);
                        c2481ph2 = c2481ph;
                    }
                    return new C2481ph(unmodifiableList);
                }
            }
            C2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww32 = c2444oh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            }
            return new C2481ph(unmodifiableList);
        }
        throw null;
    }
}
