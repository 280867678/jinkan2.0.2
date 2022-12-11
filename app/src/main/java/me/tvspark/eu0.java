package me.tvspark;

import android.widget.TextView;

/* loaded from: classes4.dex */
public class eu0 implements Runnable {
    public final /* synthetic */ cu0 Wwwwwwwwwwwwwwwwwwwwwwww;

    public eu0(cu0 cu0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cu0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        cu0 cu0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i = cu0Var.Wwwwwww;
        if (i != -1) {
            textView = cu0Var.Wwwwwwwwwwwwwwwwwww;
        } else if (cu0Var.Wwwwwwwwwwwwwwwwwww.getLineCount() == 1) {
            textView = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            i = 17;
        } else {
            textView = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            i = 19;
        }
        textView.setGravity(i);
    }
}
