package me.tvspark;

import android.content.DialogInterface;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.view.activity.SettingActivity;

/* loaded from: classes4.dex */
public class xs0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SettingActivity Wwwwwwwwwwwwwwwwwwwwwwww;

    public xs0(SettingActivity settingActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = settingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        if (i == 0) {
            baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, "腾讯X5内核目前已不再提供视频播放器功能，可以安装旧版本的内核试一试！");
        } else if (i == 1) {
            dialogInterface.dismiss();
            baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2);
        } else if (i != 2) {
        } else {
            dialogInterface.dismiss();
            baseActivity3 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity3, "http://debugtbs.qq.com", true);
        }
    }
}
