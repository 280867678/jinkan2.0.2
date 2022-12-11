package me.tvspark;

import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.view.activity.KSYPlayerActivity;
import org.litepal.crud.callback.CountCallback;

/* loaded from: classes4.dex */
public class ts0 implements CountCallback {
    public final /* synthetic */ KSYPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ts0(KSYPlayerActivity kSYPlayerActivity, boolean z, KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kSYPlayerActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.litepal.crud.callback.CountCallback
    public void onFinish(int i) {
        long j;
        VideoPlayPosData videoPlayPosData;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.Wwwwwwwwwwwwwwwwww.getCurrentPosition();
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (j != 0) {
                if (i != 0) {
                    KSYPlayerActivity kSYPlayerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwwww, j);
                } else {
                    KSYPlayerActivity kSYPlayerActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    videoPlayPosData = new VideoPlayPosData(kSYPlayerActivity2.Wwwwwwwwwwwwwwwwwww, kSYPlayerActivity2.Wwwwwwwwwwwwwwwww, kSYPlayerActivity2.Wwwwwwwwwwwwwwww, kSYPlayerActivity2.Wwwwwwwwwwwwwww, j);
                    videoPlayPosData.saveAsync().listen(null);
                }
            }
        } else if (i != 0) {
            KSYPlayerActivity kSYPlayerActivity3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity3.Wwwwwwwwwwwwwwwwwww, kSYPlayerActivity3.Wwwwwwwwwwwwwwwww, 0L);
        } else {
            KSYPlayerActivity kSYPlayerActivity4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            videoPlayPosData = new VideoPlayPosData(kSYPlayerActivity4.Wwwwwwwwwwwwwwwwwww, kSYPlayerActivity4.Wwwwwwwwwwwwwwwww, kSYPlayerActivity4.Wwwwwwwwwwwwwwww, kSYPlayerActivity4.Wwwwwwwwwwwwwww, 0L);
            videoPlayPosData.saveAsync().listen(null);
        }
        KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            ((ss0) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}
