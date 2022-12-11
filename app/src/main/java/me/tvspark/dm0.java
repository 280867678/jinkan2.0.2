package me.tvspark;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.VersionParcel;

/* loaded from: classes4.dex */
public class dm0 implements View.OnClickListener {
    public final /* synthetic */ am0 Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AlertDialog Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ VersionParcel Wwwwwwwwwwwwwwwwwwwwwwww;

    public dm0(am0 am0Var, VersionParcel versionParcel, AlertDialog alertDialog) {
        this.Wwwwwwwwwwwwwwwwwwwwww = am0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = versionParcel;
        this.Wwwwwwwwwwwwwwwwwwwwwww = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity mo4928getContext;
        String noticeUrl;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getnType().startsWith("wforce")) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getnType().startsWith("wdetail")) {
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getNoticeUrl())) {
                mo4928getContext = ((um0) this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext();
                noticeUrl = "https://docs.qq.com/doc/DUEJvZW1sVXZWSHJB";
            } else {
                mo4928getContext = ((um0) this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext();
                noticeUrl = this.Wwwwwwwwwwwwwwwwwwwwwwww.getNoticeUrl();
            }
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) mo4928getContext, noticeUrl, false);
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getnType().startsWith("http")) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(((um0) this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getnType());
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }
}
