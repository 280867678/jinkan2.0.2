package me.tvspark.view.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import com.arialyy.aria.core.Aria;
import com.stub.StubApp;
import java.util.List;
import me.tvspark.Wwwwww;
import me.tvspark.adapter.EpisodeFullPlayAdapter;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.event.VideoPlayEvent;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.dn0;
import me.tvspark.do0;
import me.tvspark.en0;
import me.tvspark.eo0;
import me.tvspark.jm0;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.ss0;
import me.tvspark.ts0;
import me.tvspark.us0;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.yn0;
import org.litepal.crud.callback.CountCallback;
import org.litepal.crud.callback.FindCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class KSYPlayerActivity extends BaseActivity<dn0> implements sk0, en0 {
    public boolean Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public boolean Wwwwwwwwwww;
    @BindView(R.id.video)
    public MyJzvdStd myJzvdStd;
    public String Wwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwww = "";
    public boolean Wwwwwwwwwwwww = false;
    public int Wwwwwwwwwwww = -1;
    public int Wwwwwwww = 0;
    public int Wwwwwww = 0;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i != 0) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dn0 dn0Var;
                boolean z;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                int i2;
                if (i == 0) {
                    dn0Var = (dn0) KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                    z = false;
                    KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
                    str = kSYPlayerActivity.Wwwwwwwwwwwwww;
                    str2 = kSYPlayerActivity.Wwwwwwwwwwwwwwww;
                    str3 = kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww;
                    str4 = kSYPlayerActivity.Wwwwwwwwwwwwwwwwww;
                    str5 = kSYPlayerActivity.Wwwwwwwwwwwwwww;
                    i2 = 14;
                } else if (i != 1) {
                    return;
                } else {
                    dn0Var = (dn0) KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwww;
                    z = false;
                    KSYPlayerActivity kSYPlayerActivity2 = KSYPlayerActivity.this;
                    str = kSYPlayerActivity2.Wwwwwwwwwwwwww;
                    str2 = kSYPlayerActivity2.Wwwwwwwwwwwwwwww;
                    str3 = kSYPlayerActivity2.Wwwwwwwwwwwwwwwwwww;
                    str4 = kSYPlayerActivity2.Wwwwwwwwwwwwwwwwww;
                    str5 = kSYPlayerActivity2.Wwwwwwwwwwwwwww;
                    i2 = 9;
                }
                dn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, str, str2, str3, str4, str5, i2);
            }
        }

        /* renamed from: me.tvspark.view.activity.KSYPlayerActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3500Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public C3500Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                KSYPlayerActivity.this.finish();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            BaseActivity baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
            String str = kSYPlayerActivity.Wwwwwwwwwwwwwwwww;
            String str2 = kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww;
            String str3 = kSYPlayerActivity.Wwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str, str2, str3, kSYPlayerActivity.Wwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwww, str3);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            KSYPlayerActivity.this.finish();
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            mn0.Wwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            AlertDialog.Builder builder = new AlertDialog.Builder(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
            builder.setItems(new String[]{"云播投屏播放", "DLNA投屏播放"}, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            builder.setCancelable(true);
            builder.create().show();
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            BaseActivity baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1000, (Activity) baseActivity, kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwww, false, (mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) new C3500Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    static {
        StubApp.interface11(11232);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity kSYPlayerActivity, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (!kSYPlayerActivity.Wwwwwwwwww) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww, new ts0(kSYPlayerActivity, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public dn0 Wwwwwwwwwwwwwwww() {
        return new jm0();
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_player_ksy;
    }

    @Override // me.tvspark.en0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwww = false;
    }

    @Override // me.tvspark.en0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, (int) R.string.parse_error);
    }

    @Override // me.tvspark.en0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            try {
                if (!this.myJzvdStd.Wwwwwwwwwwwwwwwwww.isPlaying()) {
                    return;
                }
                this.Wwwwwwwwwwwww = true;
                Wwwwww.Wwwwwwwwwwww();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        } catch (Exception unused) {
            Wwwwww.Wwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.en0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwww) {
            Wwwwww.Wwwwwwwwwww();
            this.Wwwwwwwwwwwww = false;
        }
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_head") * 1000;
        this.Wwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_end") * 1000;
        ((dn0) this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
        this.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.myJzvdStd.setCallBack(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, this.Wwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.en0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, String str3) {
        if (i == 7) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, str, 0, str2, str3);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (Wwwwww.Wwwwwwwwwwwww()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
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

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.view.activity.KSYPlayerActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3499Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<VideoPlayPosData> {
            public C3499Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
                if (r3.Wwwwwwww < r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration()) goto L13;
             */
            @Override // org.litepal.crud.callback.FindCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onFinish(VideoPlayPosData videoPlayPosData) {
                BaseActivity baseActivity;
                StringBuilder sb;
                KSYPlayerActivity kSYPlayerActivity;
                VideoPlayPosData videoPlayPosData2 = videoPlayPosData;
                if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
                    int i = KSYPlayerActivity.this.Wwwwwwww;
                    if (i > 0 && i > videoPlayPosData2.getQuitTime()) {
                        if (KSYPlayerActivity.this.myJzvdStd.getDuration() != 0) {
                        }
                        KSYPlayerActivity kSYPlayerActivity2 = KSYPlayerActivity.this;
                        MyJzvdStd myJzvdStd = kSYPlayerActivity2.myJzvdStd;
                        long j = kSYPlayerActivity2.Wwwwwwww;
                        myJzvdStd.Wwwwwwwwwwwwww = j;
                        myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(j);
                        baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        sb = new StringBuilder();
                    }
                    if (KSYPlayerActivity.this.myJzvdStd.getDuration() != 0 && videoPlayPosData2.getQuitTime() >= KSYPlayerActivity.this.myJzvdStd.getDuration()) {
                        return;
                    }
                    KSYPlayerActivity.this.myJzvdStd.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
                    KSYPlayerActivity.this.myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(videoPlayPosData2.getQuitTime());
                    return;
                }
                KSYPlayerActivity kSYPlayerActivity3 = KSYPlayerActivity.this;
                new VideoPlayPosData(kSYPlayerActivity3.Wwwwwwwwwwwwwwwwwww, kSYPlayerActivity3.Wwwwwwwwwwwwwwwww, kSYPlayerActivity3.Wwwwwwwwwwwwwwww, kSYPlayerActivity3.Wwwwwwwwwwwwwww, 0L).saveAsync().listen(null);
                KSYPlayerActivity kSYPlayerActivity4 = KSYPlayerActivity.this;
                if (kSYPlayerActivity4.Wwwwwwww <= 0) {
                    return;
                }
                if (kSYPlayerActivity4.myJzvdStd.getDuration() != 0) {
                    if (kSYPlayerActivity.Wwwwwwww >= KSYPlayerActivity.this.myJzvdStd.getDuration()) {
                        return;
                    }
                }
                KSYPlayerActivity kSYPlayerActivity5 = KSYPlayerActivity.this;
                MyJzvdStd myJzvdStd2 = kSYPlayerActivity5.myJzvdStd;
                long j2 = kSYPlayerActivity5.Wwwwwwww;
                myJzvdStd2.Wwwwwwwwwwwwww = j2;
                myJzvdStd2.Wwwwwwwwwwwwwwwwww.seekTo(j2);
                baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                sb = new StringBuilder();
                sb.append("已跳过片头 ");
                sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText, EditText editText2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
                this.Wwwwwwwwwwwwwwwwwwwwwww = editText2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString();
                String obj2 = this.Wwwwwwwwwwwwwwwwwwwwwww.getText().toString();
                if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请完整填写正确内容");
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "加入缓存任务列表");
                String replace = obj.replace("/", "");
                String str = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww) + "download/" + replace + "/" + obj2.replace("/", "") + "-" + replace;
                KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwwww, str, -1L, 0);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (Aria.download(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww).taskExists(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwww)) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "已存在，请查看我的缓存");
                return;
            }
            View inflate = LayoutInflater.from(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww).inflate(R.layout.view_web_sniffer_down, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.et_dir);
            EditText editText2 = (EditText) inflate.findViewById(R.id.et_file);
            editText.setText(KSYPlayerActivity.this.Wwwwwwwwwwwwwwww);
            editText2.setText(KSYPlayerActivity.this.Wwwwwwwwwwwwwww);
            new AlertDialog.Builder(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("填写缓存信息").setView(inflate).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("下载", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText, editText2)).create().show();
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
            if (!kSYPlayerActivity.Wwwwwwwww) {
                KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity, false, null);
            }
            KSYPlayerActivity.this.Wwwwwwwww = false;
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            BaseActivity baseActivity;
            String str;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "已切换IJK内核";
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 1) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
                    baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    str = "已切换Android内核";
                }
                KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
                kSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww, 0, kSYPlayerActivity.Wwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwwww);
            } else {
                baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "已切换EXO内核";
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
            KSYPlayerActivity kSYPlayerActivity2 = KSYPlayerActivity.this;
            kSYPlayerActivity2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, kSYPlayerActivity2.Wwwwwwwwwwwwwwwwwww, 0, kSYPlayerActivity2.Wwwwwwwwwwwwwww, kSYPlayerActivity2.Wwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this, true, null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
            kSYPlayerActivity.Wwwwwwwwwww = true;
            KSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity, false, null);
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, EpisodeParcel episodeParcel, List<EpisodeParcel> list, int i, int i2) {
            KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
            kSYPlayerActivity.Wwwwwwwww = true;
            kSYPlayerActivity.Wwwwwwwwwwww = i;
            if (!kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww.equals(episodeParcel.getLink()) || kSYPlayerActivity.Wwwwwwwwwww) {
                ss0 ss0Var = new ss0(kSYPlayerActivity, z, episodeParcel);
                if (kSYPlayerActivity.Wwwwwwwwww) {
                    return;
                }
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww, new ts0(kSYPlayerActivity, false, ss0Var));
            }
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww) && !TextUtils.isEmpty(KSYPlayerActivity.this.Wwwwwwwwwwwwww)) {
                KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, kSYPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww, kSYPlayerActivity.Wwwwwwwwww);
            } else {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, (int) R.string.x5_failure);
                KSYPlayerActivity kSYPlayerActivity2 = KSYPlayerActivity.this;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity2.Wwwwwwwwwwwwwwwwwwwwwwww, kSYPlayerActivity2.Wwwwwwwwwwwwwwwww);
            }
            KSYPlayerActivity.this.finish();
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
            KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
            int i2 = kSYPlayerActivity.Wwwwwww;
            if (i2 > 0) {
                long j3 = j2 - j;
                if (j3 < i2 - 500 || j3 > i2 + 500) {
                    return;
                }
                kSYPlayerActivity.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww();
                BaseActivity baseActivity = KSYPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已跳过片尾 ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(KSYPlayerActivity.this.Wwwwwww / 1000));
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
        }

        @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            KSYPlayerActivity kSYPlayerActivity = KSYPlayerActivity.this;
            if (!kSYPlayerActivity.Wwwwwwwwww) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kSYPlayerActivity.Wwwwwwwwwwwwwwwwwww, new C3499Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, int i, String str2, String str3) {
        getWindow().addFlags(128);
        this.myJzvdStd.setKeepScreenOn(true);
        if (z || this.Wwwwwwwwww) {
            this.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        } else {
            int i2 = this.Wwwwwwwwwwww;
            if (i2 != -1) {
                EpisodeFullPlayAdapter episodeFullPlayAdapter = this.myJzvdStd.Sssssssss;
                if (episodeFullPlayAdapter != null && i2 >= 0 && i2 < episodeFullPlayAdapter.getItemCount() && episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i2) {
                    episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                    episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                    episodeFullPlayAdapter.notifyDataSetChanged();
                }
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new VideoPlayEvent(this.Wwwwwwwwwwwwwwwwww, str2, str, this.Wwwwwwwwwwww));
                if (!bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no_history", false)) {
                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str2, str));
                }
            }
        }
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new us0(this, str3, str2, str));
    }
}
