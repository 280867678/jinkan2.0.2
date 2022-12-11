package me.tvspark;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.stub.StubApp;

/* renamed from: me.tvspark.cm */
/* loaded from: classes4.dex */
public final class C1988cm {
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final WindowManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.cm$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Choreographer.FrameCallback, Handler.Callback {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public int Wwwwwwwwwwwwwwwwwwww;
        public Choreographer Wwwwwwwwwwwwwwwwwwwww;
        public final HandlerThread Wwwwwwwwwwwwwwwwwwwwww;
        public final Handler Wwwwwwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.Wwwwwwwwwwwwwwwwwwwwww = handlerThread;
            handlerThread.start();
            Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.getLooper(), (Handler.Callback) this);
            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.sendEmptyMessage(0);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwww.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.Wwwwwwwwwwwwwwwwwwwww = Choreographer.getInstance();
                return true;
            } else if (i == 1) {
                int i2 = this.Wwwwwwwwwwwwwwwwwwww + 1;
                this.Wwwwwwwwwwwwwwwwwwww = i2;
                if (i2 == 1) {
                    this.Wwwwwwwwwwwwwwwwwwwww.postFrameCallback(this);
                }
                return true;
            } else if (i != 2) {
                return false;
            } else {
                int i3 = this.Wwwwwwwwwwwwwwwwwwww - 1;
                this.Wwwwwwwwwwwwwwwwwwww = i3;
                if (i3 == 0) {
                    this.Wwwwwwwwwwwwwwwwwwwww.removeFrameCallback(this);
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
                }
                return true;
            }
        }
    }

    @RequiresApi(17)
    /* renamed from: me.tvspark.cm$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DisplayManager.DisplayListener {
        public final DisplayManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DisplayManager displayManager) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                C1988cm.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    public C1988cm(@Nullable Context context) {
        DisplayManager displayManager;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        if (context != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (WindowManager) context.getSystemService("window");
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(displayManager);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Display defaultDisplay = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = refreshRate;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (refreshRate * 80) / 100;
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        return Math.abs((j2 - this.Wwwwwwwwwwwwwwwwwwwwwwwww) - (j - this.Wwwwwwwwwwwwwwwwwwwwwwww)) > 20000000;
    }
}
