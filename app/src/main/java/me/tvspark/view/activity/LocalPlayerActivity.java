package me.tvspark.view.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import butterknife.BindView;
import com.arialyy.aria.m3u8.vod.DownloadCompleteEvent;
import com.stub.StubApp;
import java.util.List;
import me.tvspark.Wwwwww;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.event.PlayedFileMergingEvent;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.do0;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.utils.SKUtils;
import me.tvspark.utils.player.JZMediaIjk;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.view.activity.KSYPlayerActivity;
import me.tvspark.vs0;
import me.tvspark.x11;
import me.tvspark.yn0;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.crud.callback.FindCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class LocalPlayerActivity extends BaseActivity {
    public boolean Wwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwww;
    @BindView(R.id.video)
    public MyJzvdStd myJzvdStd;
    public String Wwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwww = "";
    public int Wwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<VideoPlayPosData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
            if (r3.Wwwwwwwwwwwwwwww < r3.myJzvdStd.getDuration()) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00a0, code lost:
            if (r9.Wwwwwwwwwwwwwwww < r9.myJzvdStd.getDuration()) goto L29;
         */
        @Override // org.litepal.crud.callback.FindCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onFinish(VideoPlayPosData videoPlayPosData) {
            BaseActivity baseActivity;
            StringBuilder sb;
            VideoPlayPosData videoPlayPosData2 = videoPlayPosData;
            LocalPlayerActivity localPlayerActivity = LocalPlayerActivity.this;
            localPlayerActivity.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localPlayerActivity.Wwwwwwwwwwwwwwwwwww, localPlayerActivity.Wwwwwwwwwwwwwwwwww, 0, JZMediaIjk.class);
            if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
                int i = LocalPlayerActivity.this.Wwwwwwwwwwwwwwww;
                if (i > 0 && i > videoPlayPosData2.getQuitTime()) {
                    if (LocalPlayerActivity.this.myJzvdStd.getDuration() != 0) {
                        LocalPlayerActivity localPlayerActivity2 = LocalPlayerActivity.this;
                    }
                    LocalPlayerActivity localPlayerActivity3 = LocalPlayerActivity.this;
                    localPlayerActivity3.myJzvdStd.Wwwwwwwwwwwwww = localPlayerActivity3.Wwwwwwwwwwwwwwww;
                    baseActivity = localPlayerActivity3.Wwwwwwwwwwwwwwwwwwwwwwww;
                    sb = new StringBuilder();
                    sb.append("已跳过片头 ");
                    sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this.Wwwwwwwwwwwwwwww / 1000));
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
                }
                if (LocalPlayerActivity.this.myJzvdStd.getDuration() == 0 || videoPlayPosData2.getQuitTime() < LocalPlayerActivity.this.myJzvdStd.getDuration()) {
                    LocalPlayerActivity.this.myJzvdStd.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
                }
            } else {
                LocalPlayerActivity localPlayerActivity4 = LocalPlayerActivity.this;
                if (localPlayerActivity4.Wwwwwwwwwwwwwwww > 0) {
                    if (localPlayerActivity4.myJzvdStd.getDuration() != 0) {
                        LocalPlayerActivity localPlayerActivity5 = LocalPlayerActivity.this;
                    }
                    LocalPlayerActivity localPlayerActivity6 = LocalPlayerActivity.this;
                    localPlayerActivity6.myJzvdStd.Wwwwwwwwwwwwww = localPlayerActivity6.Wwwwwwwwwwwwwwww;
                    baseActivity = localPlayerActivity6.Wwwwwwwwwwwwwwwwwwwwwwww;
                    sb = new StringBuilder();
                    sb.append("已跳过片头 ");
                    sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this.Wwwwwwwwwwwwwwww / 1000));
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
                }
            }
            LocalPlayerActivity.this.myJzvdStd.Wwwwwwwwwwwwww();
            MyJzvdStd myJzvdStd = LocalPlayerActivity.this.myJzvdStd;
            myJzvdStd.QQOOOOOOOO.performClick();
            myJzvdStd.IIlllllllll = true;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.view.activity.LocalPlayerActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3501Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public C3501Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                LocalPlayerActivity.this.finish();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            BaseActivity baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            LocalPlayerActivity localPlayerActivity = LocalPlayerActivity.this;
            String str = localPlayerActivity.Wwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str, str, str, localPlayerActivity.Wwwwwwwwwwwwwwwwww, "", str);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            LocalPlayerActivity.this.onBackPressed();
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            BaseActivity baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            LocalPlayerActivity localPlayerActivity = LocalPlayerActivity.this;
            String str = localPlayerActivity.Wwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1000, baseActivity, str, str, localPlayerActivity.Wwwwwwwwwwwwwwwwww, "", localPlayerActivity.Wwwwwwwwwwwwww, new C3501Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    static {
        StubApp.interface11(11239);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity localPlayerActivity, boolean z, KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localPlayerActivity.Wwwwwwwwwwwwwwwwwww), new vs0(localPlayerActivity, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public final void Wwwwwwwwwwwwww() {
        getWindow().addFlags(128);
        this.myJzvdStd.setKeepScreenOn(true);
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_player_local;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getWindow().addFlags(128);
        this.myJzvdStd.setKeepScreenOn(true);
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Wwwwww.Wwwwwwwwww();
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onDownloadCompleteEvent(DownloadCompleteEvent downloadCompleteEvent) {
        if (TextUtils.isEmpty(downloadCompleteEvent.getLocalM3U8Path()) || !this.Wwwwwwwwwwwwwwwwwww.equals(downloadCompleteEvent.getLocalM3U8Path())) {
            return;
        }
        long j = 0;
        try {
            j = this.myJzvdStd.Wwwwwwwwwwwwwwwwww.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
        }
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new PlayedFileMergingEvent(this.Wwwwwwwwwwwwwwwwww, downloadCompleteEvent.getMergedFilePath(), j));
        finish();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
        this.myJzvdStd.setKeepScreenOn(false);
        try {
            Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (String) null);
            Wwwwww.Wwwwwwwwwwww();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getWindow().addFlags(128);
        this.myJzvdStd.setKeepScreenOn(true);
        try {
            Wwwwww.Wwwwwwwwwww();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        if (!this.Wwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_head") * 1000;
            this.Wwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_end") * 1000;
        }
        this.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        MyJzvdStd myJzvdStd = this.myJzvdStd;
        myJzvdStd.Ill = true;
        myJzvdStd.setCallBack(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Wwwwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<VideoPlayPosData> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
                if (r3.Wwwwwwwwwwwwwwww < r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration()) goto L13;
             */
            @Override // org.litepal.crud.callback.FindCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onFinish(VideoPlayPosData videoPlayPosData) {
                BaseActivity baseActivity;
                StringBuilder sb;
                LocalPlayerActivity localPlayerActivity;
                VideoPlayPosData videoPlayPosData2 = videoPlayPosData;
                if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
                    int i = LocalPlayerActivity.this.Wwwwwwwwwwwwwwww;
                    if (i > 0 && i > videoPlayPosData2.getQuitTime()) {
                        if (LocalPlayerActivity.this.myJzvdStd.getDuration() != 0) {
                        }
                        LocalPlayerActivity localPlayerActivity2 = LocalPlayerActivity.this;
                        MyJzvdStd myJzvdStd = localPlayerActivity2.myJzvdStd;
                        long j = localPlayerActivity2.Wwwwwwwwwwwwwwww;
                        myJzvdStd.Wwwwwwwwwwwwww = j;
                        myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(j);
                        baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        sb = new StringBuilder();
                    }
                    if (LocalPlayerActivity.this.myJzvdStd.getDuration() != 0 && videoPlayPosData2.getQuitTime() >= LocalPlayerActivity.this.myJzvdStd.getDuration()) {
                        return;
                    }
                    LocalPlayerActivity.this.myJzvdStd.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
                    LocalPlayerActivity.this.myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(videoPlayPosData2.getQuitTime());
                    return;
                }
                new VideoPlayPosData(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwww), SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwww), LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwww, "", 0L).saveAsync().listen(null);
                LocalPlayerActivity localPlayerActivity3 = LocalPlayerActivity.this;
                if (localPlayerActivity3.Wwwwwwwwwwwwwwww <= 0) {
                    return;
                }
                if (localPlayerActivity3.myJzvdStd.getDuration() != 0) {
                    if (localPlayerActivity.Wwwwwwwwwwwwwwww >= LocalPlayerActivity.this.myJzvdStd.getDuration()) {
                        return;
                    }
                }
                LocalPlayerActivity localPlayerActivity4 = LocalPlayerActivity.this;
                MyJzvdStd myJzvdStd2 = localPlayerActivity4.myJzvdStd;
                long j2 = localPlayerActivity4.Wwwwwwwwwwwwwwww;
                myJzvdStd2.Wwwwwwwwwwwwww = j2;
                myJzvdStd2.Wwwwwwwwwwwwwwwwww.seekTo(j2);
                baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this.Wwwwwwwwwwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            LocalPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this, false, null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            BaseActivity baseActivity;
            String str;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "已切换IJK内核";
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 1) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
                    baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    str = "已切换Android内核";
                }
                LocalPlayerActivity localPlayerActivity = LocalPlayerActivity.this;
                localPlayerActivity.Wwwwwwwwwwwwwwwww = 0L;
                localPlayerActivity.Wwwwwwwwwwwwww();
            } else {
                baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "已切换EXO内核";
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
            LocalPlayerActivity localPlayerActivity2 = LocalPlayerActivity.this;
            localPlayerActivity2.Wwwwwwwwwwwwwwwww = 0L;
            localPlayerActivity2.Wwwwwwwwwwwwww();
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            LocalPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this, true, null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            LocalPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this, false, null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                LocalPlayerActivity localPlayerActivity = LocalPlayerActivity.this;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwww, localPlayerActivity.Wwwwwwwwwwwwwwwwwww, localPlayerActivity.Wwwwwwwwwwwwwwwwww, "", "", "");
            } else {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, (int) R.string.x5_failure);
                LocalPlayerActivity localPlayerActivity2 = LocalPlayerActivity.this;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localPlayerActivity2.Wwwwwwwwwwwwwwwwwwwwwwww, localPlayerActivity2.Wwwwwwwwwwwwwwwwwww);
            }
            LocalPlayerActivity.this.finish();
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, EpisodeParcel episodeParcel, List<EpisodeParcel> list, int i, int i2) {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
            LocalPlayerActivity localPlayerActivity = LocalPlayerActivity.this;
            int i2 = localPlayerActivity.Wwwwwwwwwwwwwww;
            if (i2 > 0) {
                long j3 = j2 - j;
                if (j3 < i2 - 500 || j3 > i2 + 500) {
                    return;
                }
                localPlayerActivity.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww();
                BaseActivity baseActivity = LocalPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已跳过片尾 ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LocalPlayerActivity.this.Wwwwwwwwwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            LocalPlayerActivity localPlayerActivity = LocalPlayerActivity.this;
            long j = localPlayerActivity.Wwwwwwwwwwwwwwwww;
            if (j != 0) {
                localPlayerActivity.myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(j);
            } else {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localPlayerActivity.Wwwwwwwwwwwwwwwwwww), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
        }
    }
}
