package me.tvspark;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.interfaces.OnInvokeView;
import java.util.List;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.utils.service.FloatPlayService;
import me.tvspark.widget.ScaleImageView;
import org.litepal.crud.callback.FindCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class gr0 implements OnInvokeView {
    public final /* synthetic */ FloatPlayService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            EasyFloat.Builder builder = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
            if (builder != null) {
                try {
                    builder.setDragEnable(!z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ScaleImageView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ RelativeLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ FrameLayout.LayoutParams Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FrameLayout.LayoutParams layoutParams, RelativeLayout relativeLayout) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = layoutParams;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = relativeLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.gr0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3473Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public C3473Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.utils.service.FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.stopSelf();
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.utils.service.FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                FloatPlayService floatPlayService = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                String str = floatPlayService.Wwwwwwwwwwwwwwwwwwwwww;
                String str2 = floatPlayService.Wwwwwwwwwwwwwwwwwwwwwww;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService, str, str2, str2, floatPlayService.Wwwwwwwwwwwwwwwwwwwww, floatPlayService.Wwwwwwwwwwwwwwwwwwww, str2);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, (FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, (FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) new C3473Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public gr0(FloatPlayService floatPlayService, FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = floatPlayService;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.lzf.easyfloat.interfaces.OnInvokeView
    public void invoke(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rlContent);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww > 0) {
                layoutParams.width = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
                layoutParams.height = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww * 10) / 16;
                relativeLayout.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = (MyJzvdStd) view.findViewById(R.id.videoFloat);
        MyJzvdStd myJzvdStd = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, relativeLayout);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        myJzvdStd.f4509Il = true;
        myJzvdStd.Sssss = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        myJzvdStd.QQO = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            myJzvdStd.QQOOOOOO.setVisibility(0);
            myJzvdStd.OO0.setVisibility(0);
            myJzvdStd.Ssssssss.setVisibility(0);
            myJzvdStd.Ssssssss.setOnScaledListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            myJzvdStd.QQOOOOOOOO.setVisibility(8);
            myJzvdStd.OO000.setVisibility(8);
            myJzvdStd.OO00.setVisibility(8);
            myJzvdStd.OO0000.setVisibility(8);
        } catch (Exception unused) {
        }
        myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        myJzvdStd.setCallBack(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            FloatPlayService.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.gr0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3474Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<VideoPlayPosData> {
            public C3474Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
                if (r3.Wwwwwwwwwwwwwwwwww < r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration()) goto L13;
             */
            @Override // org.litepal.crud.callback.FindCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onFinish(VideoPlayPosData videoPlayPosData) {
                FloatPlayService floatPlayService;
                StringBuilder sb;
                FloatPlayService floatPlayService2;
                VideoPlayPosData videoPlayPosData2 = videoPlayPosData;
                if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
                    int i = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
                    if (i > 0 && i > videoPlayPosData2.getQuitTime()) {
                        if (gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration() != 0) {
                        }
                        FloatPlayService floatPlayService3 = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        MyJzvdStd myJzvdStd = floatPlayService3.Wwwwwwwwwwwwwwwwwwwwwwww;
                        long j = floatPlayService3.Wwwwwwwwwwwwwwwwww;
                        myJzvdStd.Wwwwwwwwwwwwww = j;
                        myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(j);
                        floatPlayService = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        sb = new StringBuilder();
                    }
                    if (gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration() != 0 && videoPlayPosData2.getQuitTime() >= gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration()) {
                        return;
                    }
                    gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
                    gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.seekTo(videoPlayPosData2.getQuitTime());
                    return;
                }
                FloatPlayService floatPlayService4 = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                new VideoPlayPosData(floatPlayService4.Wwwwwwwwwwwwwwwwwwwwwww, floatPlayService4.Wwwwwwwwwwwwwwwwwwwwww, floatPlayService4.Wwwwwwwwwwwwwwwwwwwww, floatPlayService4.Wwwwwwwwwwwwwwwwwwww, 0L).saveAsync().listen(null);
                FloatPlayService floatPlayService5 = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (floatPlayService5.Wwwwwwwwwwwwwwwwww <= 0) {
                    return;
                }
                if (floatPlayService5.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration() != 0) {
                    if (floatPlayService2.Wwwwwwwwwwwwwwwwww >= gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getDuration()) {
                        return;
                    }
                }
                FloatPlayService floatPlayService6 = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                MyJzvdStd myJzvdStd2 = floatPlayService6.Wwwwwwwwwwwwwwwwwwwwwwww;
                long j2 = floatPlayService6.Wwwwwwwwwwwwwwwwww;
                myJzvdStd2.Wwwwwwwwwwwwww = j2;
                myJzvdStd2.Wwwwwwwwwwwwwwwwww.seekTo(j2);
                floatPlayService = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService, sb.toString());
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, (FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            FloatPlayService floatPlayService;
            String str;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                floatPlayService = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                str = "已切换IJK内核";
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                    floatPlayService = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    str = "已切换Android内核";
                }
                FloatPlayService floatPlayService2 = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService2.Wwwwwwwwwwwwwwwwwwwwwww, new er0(floatPlayService2));
                ApplicationC1880C.Wwwwwwwwwwwww = true;
            } else {
                floatPlayService = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                str = "已切换EXO内核";
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService, str);
            FloatPlayService floatPlayService22 = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService22.Wwwwwwwwwwwwwwwwwwwwwww, new er0(floatPlayService22));
            ApplicationC1880C.Wwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, (FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, (FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "浮窗播放不支持此操作");
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
            FloatPlayService floatPlayService = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = floatPlayService.Wwwwwwwwwwwwwwwww;
            if (i2 > 0) {
                long j3 = j2 - j;
                if (j3 < i2 - 500 || j3 > i2 + 500) {
                    return;
                }
                floatPlayService.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww();
                FloatPlayService floatPlayService2 = gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已跳过片尾 ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, EpisodeParcel episodeParcel, List<EpisodeParcel> list, int i, int i2) {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gr0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, new C3474Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }
}
