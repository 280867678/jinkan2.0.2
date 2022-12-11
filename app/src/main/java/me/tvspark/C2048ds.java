package me.tvspark;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: me.tvspark.ds */
/* loaded from: classes4.dex */
public class C2048ds implements InputFilter {
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2048ds(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) > this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                return "";
            }
            return null;
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
