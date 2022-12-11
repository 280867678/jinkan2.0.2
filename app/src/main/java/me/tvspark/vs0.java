package me.tvspark;

import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.utils.SKUtils;
import me.tvspark.view.activity.KSYPlayerActivity;
import me.tvspark.view.activity.LocalPlayerActivity;
import org.litepal.crud.callback.CountCallback;

/* loaded from: classes4.dex */
public class vs0 implements CountCallback {
    public final /* synthetic */ LocalPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public vs0(LocalPlayerActivity localPlayerActivity, boolean z, KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = localPlayerActivity;
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
                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), j);
                } else {
                    videoPlayPosData = new VideoPlayPosData(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww, "", j);
                    videoPlayPosData.saveAsync().listen(null);
                }
            }
        } else if (i != 0) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), 0L);
        } else {
            videoPlayPosData = new VideoPlayPosData(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww, "", 0L);
            videoPlayPosData.saveAsync().listen(null);
        }
        KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            ((ss0) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}
