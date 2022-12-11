package me.tvspark;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import me.tvspark.data.bean.VersionParcel;

/* loaded from: classes4.dex */
public class bm0 implements View.OnClickListener {
    public final /* synthetic */ am0 Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AlertDialog Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ VersionParcel Wwwwwwwwwwwwwwwwwwwwwwww;

    public bm0(am0 am0Var, VersionParcel versionParcel, AlertDialog alertDialog) {
        this.Wwwwwwwwwwwwwwwwwwwwww = am0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = versionParcel;
        this.Wwwwwwwwwwwwwwwwwwwwwww = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(((um0) this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getDownloadUrl());
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.isForceUpdate()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.cancel();
        }
    }
}
