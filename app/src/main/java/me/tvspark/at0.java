package me.tvspark;

import android.content.DialogInterface;
import me.tvspark.view.activity.SortWebsiteActivity;

/* loaded from: classes4.dex */
public class at0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    public at0(SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SortWebsiteActivity.this.tvCancel.setText("编辑");
        SortWebsiteActivity.this.dragView.setGoEditMode(false);
        SortWebsiteActivity sortWebsiteActivity = SortWebsiteActivity.this;
        sortWebsiteActivity.Wwwwwwwwwwwwwwww = !sortWebsiteActivity.Wwwwwwwwwwwwwwww;
    }
}
