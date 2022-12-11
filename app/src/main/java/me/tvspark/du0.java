package me.tvspark;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/* loaded from: classes4.dex */
public class du0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ cu0 Wwwwwwwwwwwwwwwwwwwwwwww;

    public du0(cu0 cu0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cu0Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        LinearLayout.LayoutParams layoutParams;
        cu0 cu0Var;
        cu0 cu0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (cu0Var2.Wwwwwwww) {
            layoutParams = (LinearLayout.LayoutParams) cu0Var2.Wwwwwwwwww.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(200);
            cu0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        } else if (cu0Var2.Wwwwwwwwwwwwwwwwwww.getLineCount() <= 4) {
            return true;
        } else {
            layoutParams = (LinearLayout.LayoutParams) this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(250);
            cu0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        cu0Var.Wwwwwwwwww.setLayoutParams(layoutParams);
        return true;
    }
}
