package me.tvspark;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.mn0;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.view.activity.DetailActivity;

/* loaded from: classes4.dex */
public class ns0 implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ DetailActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            bl0 bl0Var;
            DetailActivity detailActivity;
            vm0 vm0Var;
            String str;
            List<EpisodeParcel> list;
            String str2;
            String str3;
            int i2;
            String str4;
            boolean z;
            bl0 bl0Var2;
            if (i == 0) {
                bl0Var = ns0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                DetailActivity detailActivity2 = ns0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                List<EpisodeParcel> list2 = detailActivity2.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                String str5 = detailActivity2.Wwwwwwwwwwwww;
                String str6 = detailActivity2.Wwwwwwwwwww;
                String desc = detailActivity2.Wwwwwwwwwwwwww.getDesc();
                detailActivity = ns0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                vm0Var = (vm0) bl0Var;
                str = desc;
                list = list2;
                str2 = str5;
                str3 = str6;
                i2 = detailActivity.Kkkkkkkkkkkkkkkkkkkkkkk;
                str4 = detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkk;
                z = true;
            } else if (i != 1) {
                return;
            } else {
                bl0Var2 = ns0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                DetailActivity detailActivity3 = ns0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                List<EpisodeParcel> list3 = detailActivity3.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                String str7 = detailActivity3.Wwwwwwwwwwwww;
                String str8 = detailActivity3.Wwwwwwwwwww;
                String desc2 = detailActivity3.Wwwwwwwwwwwwww.getDesc();
                detailActivity = ns0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                vm0Var = (vm0) bl0Var2;
                str = desc2;
                list = list3;
                str2 = str7;
                str3 = str8;
                i2 = detailActivity.Kkkkkkkkkkkkkkkkkkkkkkk;
                str4 = detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkk;
                z = false;
            }
            vm0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, z, list, str2, str3, str, i2, str4, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ns0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.finish();
        }
    }

    public ns0(DetailActivity detailActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = detailActivity;
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BaseActivity baseActivity;
        baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str = detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        String str2 = detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        String str3 = detailActivity.Wwwwwwwwwwwwwwwwwww;
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str, str2, str3, detailActivity.Wwwwwwwwwwwww, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkk, str3);
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.finish();
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BaseActivity baseActivity;
        baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        mn0.Wwwwwwwwwwwwwwwwwwwwwww(baseActivity);
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            builder.setItems(new String[]{"云播投屏播放", "DLNA投屏播放"}, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BaseActivity baseActivity;
        baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1000, (Activity) baseActivity, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Wwwwwwwwwwwww, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkk, false, (mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}
