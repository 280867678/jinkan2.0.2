package me.tvspark;

import android.database.ContentObserver;

/* loaded from: classes4.dex */
public class a61 extends ContentObserver {
    public z51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public a61(z51 z51Var, int i, String str) {
        super(null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z51Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        z51 z51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (z51Var != null) {
            z51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
