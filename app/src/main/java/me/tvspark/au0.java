package me.tvspark;

import android.text.TextUtils;
import android.view.View;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.view.activity.EditHomeMarkActivity;
import me.tvspark.widget.dialog.BaseAlertDialog;

/* loaded from: classes4.dex */
public class au0 implements View.OnClickListener {
    public final /* synthetic */ BaseAlertDialog Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ BaseAlertDialog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    public au0(BaseAlertDialog baseAlertDialog, BaseAlertDialog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = baseAlertDialog;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        BaseAlertDialog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            rs0 rs0Var = (rs0) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity.this), rs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            String obj = rs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "文字不能为空");
                return;
            }
            if (TextUtils.isEmpty(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.getIconColor())) {
                EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.setIconColor(nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.setIconUrl("");
            HomeMarkData homeMarkData = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww;
            homeMarkData.setIconTxt(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, homeMarkData.getTitle()));
            EditHomeMarkActivity editHomeMarkActivity = EditHomeMarkActivity.this;
            editHomeMarkActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editHomeMarkActivity.Wwwwwwwwwwwwwwwwwww, false);
        }
    }
}
