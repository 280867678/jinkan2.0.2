package me.tvspark;

import android.widget.AutoCompleteTextView;

/* renamed from: me.tvspark.ur */
/* loaded from: classes4.dex */
public class C2682ur implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ C2571rr Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2682ur(C2571rr c2571rr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2571rr;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        C2571rr c2571rr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
        c2571rr.Wwwwwwwwwwwwwwwwwwwwwwww = System.currentTimeMillis();
        C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
    }
}
