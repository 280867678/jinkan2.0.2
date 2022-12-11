package me.tvspark;

import cn.jzvd.JZMediaSystem;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.utils.player.JZMediaExo;
import me.tvspark.utils.player.JZMediaIjk;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.view.activity.DetailActivity;
import org.litepal.crud.callback.FindCallback;

/* loaded from: classes4.dex */
public class gs0 implements FindCallback<VideoPlayPosData> {
    public final /* synthetic */ DetailActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public gs0(DetailActivity detailActivity, String str, String str2, int i, String str3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = detailActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
        if (r3.Wwwwwww < r3.myJzvdStd.getDuration()) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dd, code lost:
        if (r9.Wwwwwww < r9.myJzvdStd.getDuration()) goto L42;
     */
    @Override // org.litepal.crud.callback.FindCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFinish(VideoPlayPosData videoPlayPosData) {
        BaseActivity baseActivity;
        StringBuilder sb;
        VideoPlayPosData videoPlayPosData2 = videoPlayPosData;
        Wwwwww.Wwwwwwwwww();
        Class cls = JZMediaSystem.class;
        int i = 0;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            cls = JZMediaIjk.class;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
            cls = JZMediaExo.class;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
            cls = JZMediaSystem.class;
        }
        int screen = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getScreen();
        if (screen != -1) {
            i = screen;
        }
        MyJzvdStd myJzvdStd = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww + " - " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, cls);
        if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww;
            if (i2 > 0 && i2 > videoPlayPosData2.getQuitTime()) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration() != 0) {
                    DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                DetailActivity detailActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                detailActivity2.myJzvdStd.Wwwwwwwwwwwwww = detailActivity2.Wwwwwww;
                baseActivity = detailActivity2.Wwwwwwwwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration() == 0 || videoPlayPosData2.getQuitTime() < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
            }
        } else {
            DetailActivity detailActivity3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (detailActivity3.Wwwwwww > 0) {
                if (detailActivity3.myJzvdStd.getDuration() != 0) {
                    DetailActivity detailActivity4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                DetailActivity detailActivity5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                detailActivity5.myJzvdStd.Wwwwwwwwwwwwww = detailActivity5.Wwwwwww;
                baseActivity = detailActivity5.Wwwwwwwwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
            }
        }
        DetailActivity detailActivity6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        detailActivity6.Kkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        detailActivity6.Kkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        detailActivity6.Kkkkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        detailActivity6.Kkkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        MyJzvdStd myJzvdStd2 = detailActivity6.myJzvdStd;
        if (myJzvdStd2.Sssssss.getVisibility() == 0) {
            myJzvdStd2.Sssssss.setVisibility(8);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.Wwwwwwwwwwwwww();
    }
}
