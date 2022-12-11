package me.tvspark.utils.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.enums.SidePattern;
import me.tvspark.ApplicationC1880C;
import me.tvspark.Wwwwww;
import me.tvspark.bo0;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.er0;
import me.tvspark.fr0;
import me.tvspark.gr0;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.yn0;
import org.litepal.crud.callback.CountCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class FloatPlayService extends Service implements sk0 {
    public float Wwwwwwwwwww;
    public float Wwwwwwwwwwww;
    public EasyFloat.Builder Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public PowerManager.WakeLock Wwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public MyJzvdStd Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwww = 0;
    public IntentFilter Wwwwwwwwww = new IntentFilter();
    public BroadcastReceiver Wwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends BroadcastReceiver {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                try {
                    Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FloatPlayService.this, (String) null);
                    Wwwwww.Wwwwwwwwwwww();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            VideoPlayPosData videoPlayPosData;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (j != 0) {
                    if (i != 0) {
                        FloatPlayService floatPlayService = FloatPlayService.this;
                        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService.Wwwwwwwwwwwwwwwwwwwwwww, floatPlayService.Wwwwwwwwwwwwwwwwwwwwww, j);
                    } else {
                        FloatPlayService floatPlayService2 = FloatPlayService.this;
                        videoPlayPosData = new VideoPlayPosData(floatPlayService2.Wwwwwwwwwwwwwwwwwwwwwww, floatPlayService2.Wwwwwwwwwwwwwwwwwwwwww, floatPlayService2.Wwwwwwwwwwwwwwwwwwwww, floatPlayService2.Wwwwwwwwwwwwwwwwwwww, j);
                        videoPlayPosData.saveAsync().listen(null);
                    }
                }
            } else if (i != 0) {
                FloatPlayService floatPlayService3 = FloatPlayService.this;
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService3.Wwwwwwwwwwwwwwwwwwwwwww, floatPlayService3.Wwwwwwwwwwwwwwwwwwwwww, 0L);
            } else {
                FloatPlayService floatPlayService4 = FloatPlayService.this;
                videoPlayPosData = new VideoPlayPosData(floatPlayService4.Wwwwwwwwwwwwwwwwwwwwwww, floatPlayService4.Wwwwwwwwwwwwwwwwwwwwww, floatPlayService4.Wwwwwwwwwwwwwwwwwwwww, floatPlayService4.Wwwwwwwwwwwwwwwwwwww, 0L);
                videoPlayPosData.saveAsync().listen(null);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.service.FloatPlayService.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            FloatPlayService floatPlayService = FloatPlayService.this;
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatPlayService.Wwwwwwwwwwwwwwwwwwwwwww, new er0(floatPlayService));
            ApplicationC1880C.Wwwwwwwwwwwww = true;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            return;
        }
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new er0(this));
        ApplicationC1880C.Wwwwwwwwwwwww = true;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        long j;
        try {
            j = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, j, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.Wwwwwwwwww.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.Wwwwwwwww, this.Wwwwwwwwww);
        try {
            PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870913, "mei:zhi");
            this.Wwwwwwwwwwwwwwwwwww = newWakeLock;
            newWakeLock.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.Wwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (this.Wwwwwwwwwwwwwww <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                return;
            }
            int i = this.Wwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwww = i;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.Wwwwwwwww);
        PowerManager.WakeLock wakeLock = this.Wwwwwwwwwwwwwwwwwww;
        if (wakeLock != null) {
            wakeLock.release();
        }
        EasyFloat.dismissAppFloat();
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setKeepScreenOn(false);
            Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (String) null);
            Wwwwww.Wwwwwwwwwwww();
            Wwwwww.Wwwwwwwwww();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApplicationC1880C.Wwwwwwwwwwwww = false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        boolean isEmpty = TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww = intent.getStringExtra("key_string");
        this.Wwwwwwwwwwwwwwwwwwwwww = intent.getStringExtra("key_string_one");
        this.Wwwwwwwwwwwwwwwwwwwww = intent.getStringExtra("key_string_two");
        this.Wwwwwwwwwwwwwwwwwwww = intent.getStringExtra("key_string_three");
        boolean booleanExtra = intent.getBooleanExtra("key_boolean", false);
        this.Wwwwwwwwwwwwwwww = booleanExtra;
        if (!booleanExtra) {
            this.Wwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_head") * 1000;
            this.Wwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_end") * 1000;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isEmpty);
            return 1;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isEmpty);
        EasyFloat.Builder with = EasyFloat.with(this);
        this.Wwwwwwwwwwwww = with;
        with.setShowPattern(ShowPattern.ALL_TIME).setSidePattern(SidePattern.DEFAULT).setAppFloatAnimator(null).setGravity(49).setLayout(R.layout.view_float_play, new gr0(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).registerCallbacks(new fr0(this)).show();
        return 1;
    }
}
