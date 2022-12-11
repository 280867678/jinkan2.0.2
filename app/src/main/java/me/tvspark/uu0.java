package me.tvspark;

import android.view.View;
import me.tvspark.view.activity.SortWebsiteActivity;
import me.tvspark.widget.easytagdragview.widget.TipItemView;

/* loaded from: classes4.dex */
public class uu0 implements View.OnClickListener {
    public final /* synthetic */ TipItemView Wwwwwwwwwwwwwwwwwwwwwwww;

    public uu0(TipItemView tipItemView) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = tipItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.isShown()) {
            TipItemView tipItemView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tipItemView.Wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tipItemView.Wwwwwwwwwwwwwwwwwwwwww, tipItemView.Wwwwwwwwwwwwwwwwwww, tipItemView);
            return;
        }
        TipItemView tipItemView2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tipItemView2.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tipItemView2.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), new ys0((SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3502Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}
