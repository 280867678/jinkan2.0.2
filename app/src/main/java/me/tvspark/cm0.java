package me.tvspark;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import me.tvspark.data.bean.VersionParcel;

/* loaded from: classes4.dex */
public class cm0 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ VersionParcel Wwwwwwwwwwwwwwwwwwwwwwww;

    public cm0(am0 am0Var, VersionParcel versionParcel, AlertDialog alertDialog) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = versionParcel;
        this.Wwwwwwwwwwwwwwwwwwwwwww = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.isForceUpdate()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.cancel();
        }
    }
}
