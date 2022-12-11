package me.tvspark;

import android.content.DialogInterface;
import me.tvspark.view.fragment.SearchHistoryFragment;

/* loaded from: classes4.dex */
public class rt0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

    public rt0(SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchHistoryFragment.this, this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
