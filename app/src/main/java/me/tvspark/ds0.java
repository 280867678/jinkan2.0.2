package me.tvspark;

import android.content.DialogInterface;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.view.activity.DetailActivity;

/* loaded from: classes4.dex */
public class ds0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

    public ds0(DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, EpisodeParcel episodeParcel, List list) {
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
        this.Wwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bl0 bl0Var;
        vm0 vm0Var;
        boolean z;
        int i2;
        DetailActivity detailActivity;
        String str;
        String str2;
        bl0 bl0Var2;
        bl0 bl0Var3;
        bl0 bl0Var4;
        bl0 bl0Var5;
        bl0 bl0Var6;
        BaseActivity baseActivity;
        bl0 bl0Var7;
        bl0 bl0Var8;
        vm0 vm0Var2;
        boolean z2;
        boolean z3;
        List<EpisodeParcel> list;
        DetailActivity detailActivity2;
        String str3;
        String str4;
        bl0 bl0Var9;
        switch (i) {
            case 0:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_DOWNLOAD");
                bl0Var = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0Var = (vm0) bl0Var;
                z = false;
                i2 = 11;
                detailActivity = DetailActivity.this;
                str = detailActivity.Wwwwwwwwwwwww;
                str2 = detailActivity.Wwwwwwwwwww;
                vm0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, i2, str, str2, detailActivity.Wwwwwwwwwwwwww.getDesc(), this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 1:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PARSE");
                bl0Var2 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0 vm0Var3 = (vm0) bl0Var2;
                DetailActivity detailActivity3 = DetailActivity.this;
                vm0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity3.Wwwwwwwwwwwww, detailActivity3.Wwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 2:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PC_PLAYER");
                bl0Var3 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0 vm0Var4 = (vm0) bl0Var3;
                DetailActivity detailActivity4 = DetailActivity.this;
                vm0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity4.Wwwwwwwwwwwww, detailActivity4.Wwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 3:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_THIED_PLAYER");
                bl0Var4 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0 vm0Var5 = (vm0) bl0Var4;
                DetailActivity detailActivity5 = DetailActivity.this;
                vm0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity5.Wwwwwwwwwwwww, detailActivity5.Wwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 4:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_UC_BROWSER");
                bl0Var5 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0 vm0Var6 = (vm0) bl0Var5;
                DetailActivity detailActivity6 = DetailActivity.this;
                vm0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity6.Wwwwwwwwwwwww, detailActivity6.Wwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 5:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_QQ_BROWSER");
                bl0Var6 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0 vm0Var7 = (vm0) bl0Var6;
                DetailActivity detailActivity7 = DetailActivity.this;
                vm0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity7.Wwwwwwwwwwwww, detailActivity7.Wwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 6:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_QQ_BROWSER_BROWSER");
                baseActivity = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, TbsConfig.APP_QB)) {
                    detailActivity = DetailActivity.this;
                    vm0Var = (vm0) detailActivity.Wwwwwwwwwwwwwwwwwwwww;
                    z = false;
                    i2 = 12;
                    str = detailActivity.Wwwwwwwwwwwww;
                    str2 = detailActivity.Wwwwwwwwwww;
                    vm0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, i2, str, str2, detailActivity.Wwwwwwwwwwwwww.getDesc(), this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                    return;
                }
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先安装手机QQ浏览器");
                return;
            case 7:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PLAY_X5");
                bl0Var7 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0 vm0Var8 = (vm0) bl0Var7;
                DetailActivity detailActivity8 = DetailActivity.this;
                vm0Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity8.Wwwwwwwwwwwww, detailActivity8.Wwwwwwwwwww, detailActivity8.Wwwwwwwwwwwwww.getDesc(), this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 8:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_CAST");
                bl0Var8 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0Var2 = (vm0) bl0Var8;
                z2 = false;
                z3 = true;
                list = this.Wwwwwwwwwwwwwwwwwwwwww;
                detailActivity2 = DetailActivity.this;
                str3 = detailActivity2.Wwwwwwwwwwwww;
                str4 = detailActivity2.Wwwwwwwwwww;
                vm0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z3, list, str3, str4, detailActivity2.Wwwwwwwwwwwwww.getDesc(), this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            case 9:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_DLNA");
                bl0Var9 = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                vm0Var2 = (vm0) bl0Var9;
                z2 = false;
                z3 = false;
                list = this.Wwwwwwwwwwwwwwwwwwwwww;
                detailActivity2 = DetailActivity.this;
                str3 = detailActivity2.Wwwwwwwwwwwww;
                str4 = detailActivity2.Wwwwwwwwwww;
                vm0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z3, list, str3, str4, detailActivity2.Wwwwwwwwwwwwww.getDesc(), this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwww.getLink());
                return;
            default:
                return;
        }
    }
}
