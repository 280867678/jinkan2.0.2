package me.tvspark;

import cn.jzvd.JZMediaSystem;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.utils.player.JZMediaExo;
import me.tvspark.utils.player.JZMediaIjk;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.view.activity.KSYPlayerActivity;
import org.litepal.crud.callback.FindCallback;

/* loaded from: classes4.dex */
public class us0 implements FindCallback<VideoPlayPosData> {
    public final /* synthetic */ KSYPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public us0(KSYPlayerActivity kSYPlayerActivity, String str, String str2, String str3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kSYPlayerActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
        if (r4.Wwwwwwww < r4.myJzvdStd.getDuration()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dd, code lost:
        if (r10.Wwwwwwww < r10.myJzvdStd.getDuration()) goto L38;
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
        int screen = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getScreen();
        if (screen != -1) {
            i = screen;
        }
        MyJzvdStd myJzvdStd = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd;
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww + " - " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, cls);
        if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww;
            if (i2 > 0 && i2 > videoPlayPosData2.getQuitTime()) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration() != 0) {
                    KSYPlayerActivity kSYPlayerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                KSYPlayerActivity kSYPlayerActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                kSYPlayerActivity2.myJzvdStd.Wwwwwwwwwwwwww = kSYPlayerActivity2.Wwwwwwww;
                baseActivity = kSYPlayerActivity2.Wwwwwwwwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration() == 0 || videoPlayPosData2.getQuitTime() < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
            }
        } else {
            KSYPlayerActivity kSYPlayerActivity3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (kSYPlayerActivity3.Wwwwwwww > 0) {
                if (kSYPlayerActivity3.myJzvdStd.getDuration() != 0) {
                    KSYPlayerActivity kSYPlayerActivity4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                KSYPlayerActivity kSYPlayerActivity5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                kSYPlayerActivity5.myJzvdStd.Wwwwwwwwwwwwww = kSYPlayerActivity5.Wwwwwwww;
                baseActivity = kSYPlayerActivity5.Wwwwwwwwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
            }
        }
        KSYPlayerActivity kSYPlayerActivity6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        kSYPlayerActivity6.Wwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        kSYPlayerActivity6.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        kSYPlayerActivity6.Wwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        kSYPlayerActivity6.myJzvdStd.Wwwwwwwwwwwwww();
        MyJzvdStd myJzvdStd2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd;
        myJzvdStd2.QQOOOOOOOO.performClick();
        myJzvdStd2.IIlllllllll = true;
    }
}
