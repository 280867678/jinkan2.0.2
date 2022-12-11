package me.tvspark;

import cn.jzvd.JZMediaSystem;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.utils.player.JZMediaExo;
import me.tvspark.utils.player.JZMediaIjk;
import me.tvspark.utils.service.FloatPlayService;
import org.litepal.crud.callback.FindCallback;

/* loaded from: classes4.dex */
public class er0 implements FindCallback<VideoPlayPosData> {
    public final /* synthetic */ FloatPlayService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public er0(FloatPlayService floatPlayService) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = floatPlayService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
        if (r3.Wwwwwwwwwwwwwwwwww < r3.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c7, code lost:
        if (r9.Wwwwwwwwwwwwwwwwww < r9.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration()) goto L38;
     */
    @Override // org.litepal.crud.callback.FindCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFinish(VideoPlayPosData videoPlayPosData) {
        FloatPlayService floatPlayService;
        StringBuilder sb;
        VideoPlayPosData videoPlayPosData2 = videoPlayPosData;
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
        int screen = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getScreen();
        if (screen != -1) {
            i = screen;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.setKeepScreenOn(true);
        FloatPlayService floatPlayService2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        floatPlayService2.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService2.Wwwwwwwwwwwwwwwwwwwwww, floatPlayService2.Wwwwwwwwwwwwwwwwwwwww, i, cls);
        if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
            if (i2 > 0 && i2 > videoPlayPosData2.getQuitTime()) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration() != 0) {
                    FloatPlayService floatPlayService3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                floatPlayService = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                floatPlayService.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = floatPlayService.Wwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService, sb.toString());
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration() == 0 || videoPlayPosData2.getQuitTime() < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
            }
        } else {
            FloatPlayService floatPlayService4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (floatPlayService4.Wwwwwwwwwwwwwwwwww > 0) {
                if (floatPlayService4.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration() != 0) {
                    FloatPlayService floatPlayService5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                floatPlayService = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                floatPlayService.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = floatPlayService.Wwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService, sb.toString());
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww();
    }
}
