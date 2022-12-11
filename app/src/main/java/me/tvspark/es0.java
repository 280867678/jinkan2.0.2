package me.tvspark;

import android.content.Intent;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.utils.service.FloatPlayService;
import me.tvspark.view.activity.DetailActivity;
import org.litepal.crud.callback.CountCallback;

/* loaded from: classes4.dex */
public class es0 implements CountCallback {
    public final /* synthetic */ DetailActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public es0(DetailActivity detailActivity, boolean z, DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = detailActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.litepal.crud.callback.CountCallback
    public void onFinish(int i) {
        long j;
        VideoPlayPosData videoPlayPosData;
        bl0 bl0Var;
        BaseActivity baseActivity;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.Wwwwwwwwwwwwwwwwww.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (j != 0) {
                if (i != 0) {
                    DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkk, j);
                } else {
                    DetailActivity detailActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    videoPlayPosData = new VideoPlayPosData(detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity2.Wwwwwwwwwwwww, detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkkk, j);
                    videoPlayPosData.saveAsync().listen(null);
                }
            }
        } else if (i != 0) {
            DetailActivity detailActivity3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity3.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity3.Kkkkkkkkkkkkkkkkkkkkkkkkk, 0L);
        } else {
            DetailActivity detailActivity4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            videoPlayPosData = new VideoPlayPosData(detailActivity4.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity4.Kkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity4.Wwwwwwwwwwwww, detailActivity4.Kkkkkkkkkkkkkkkkkkkkkkkk, 0L);
            videoPlayPosData.saveAsync().listen(null);
        }
        DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            fs0 fs0Var = (fs0) wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (fs0Var == null) {
                throw null;
            }
            try {
                if (ApplicationC1880C.Wwwwwwwwwwwww) {
                    baseActivity = fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                    fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.stopService(new Intent(baseActivity, FloatPlayService.class));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            bl0Var = fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            vm0 vm0Var = (vm0) bl0Var;
            boolean z = fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z2 = fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            List<EpisodeParcel> list = fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            DetailActivity detailActivity5 = fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            vm0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2, list, detailActivity5.Wwwwwwwwwwwww, detailActivity5.Wwwwwwwwwww, detailActivity5.Wwwwwwwwwwwwww.getDesc(), fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount(), fs0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink());
        }
    }
}
