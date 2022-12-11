package me.tvspark;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import me.tvspark.Wwwwww;

/* loaded from: classes4.dex */
public abstract class Wwwwww extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    public static Wwwwww Kkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkk;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkkkkkkkkk;
    public AudioManager Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Www;
    public Timer Wwww;
    public Wwwwwwww Wwwww;
    public ViewGroup Wwwwww;
    public ViewGroup Wwwwwww;
    public ViewGroup Wwwwwwww;
    public TextView Wwwwwwwww;
    public TextView Wwwwwwwwww;
    public ImageView Wwwwwwwwwww;
    public SeekBar Wwwwwwwwwwww;
    public ImageView Wwwwwwwwwwwww;
    public Wwwwwwwww Wwwwwwwwwwwwwwwwww;
    public Class Wwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public static LinkedList<ViewGroup> Kkkkkkkkkkk = new LinkedList<>();
    public static boolean Kkkkkkkkkk = true;
    public static int Kkkkkkkkk = 6;
    public static int Kkkkkkkk = 1;
    public static boolean Kkkkkkk = false;
    public static int Kkkkkk = 0;
    public static int Kkkkk = 0;
    public static AudioManager.OnAudioFocusChangeListener Kkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int Wwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwww = 0;
    public long Wwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwww = 0;
    public boolean Kkkkkkkkkkkkk = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TimerTask {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            long currentPositionWhenPlaying = Wwwwww.this.getCurrentPositionWhenPlaying();
            long duration = Wwwwww.this.getDuration();
            Wwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i = Wwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 4 || i == 5) {
                Wwwwww.this.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwww
                    @Override // java.lang.Runnable
                    public final void run() {
                        Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                });
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AudioManager.OnAudioFocusChangeListener {
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -2) {
                try {
                    Wwwwww wwwwww = Wwwwww.Kkkkkkkkkkkk;
                    if (wwwwww != null && wwwwww.Wwwwwwwwwwwwwwwwwwwwwwww == 4) {
                        wwwwww.Wwwwwwwwwwwww.performClick();
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            } else if (i != -1) {
                return;
            } else {
                Wwwwww.Wwwwwwwwww();
            }
            hashCode();
        }
    }

    public Wwwwww(Context context) {
        super(context);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
    }

    public Wwwwww(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
    }

    public static void Wwwwwwwwww() {
        Wwwwww wwwwww = Kkkkkkkkkkkk;
        if (wwwwww != null) {
            try {
                wwwwww.Wwwwwwwwwwwwwwwwwww();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Kkkkkkkkkkkk = null;
        }
    }

    public static void Wwwwwwwwwww() {
        Wwwwww wwwwww = Kkkkkkkkkkkk;
        if (wwwwww == null || wwwwww.Wwwwwwwwwwwwwwwwwwwwwwww != 5) {
            return;
        }
        if (Kkkkk == 5) {
            wwwwww.Wwwwwwwwwwwwwwwwwwwww();
            Kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwww.pause();
        } else {
            wwwwww.Wwwwwwwwwwwwwwwwwwww();
            Kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwww.start();
        }
        Kkkkk = 0;
    }

    public static void Wwwwwwwwwwww() {
        Wwwwww wwwwww = Kkkkkkkkkkkk;
        if (wwwwww != null) {
            int i = wwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 6 || i == 0 || i == 1 || i == 7) {
                Wwwwwwwwww();
                return;
            }
            Kkkkk = i;
            wwwwww.Wwwwwwwwwwwwwwwwwwwww();
            Kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwww.pause();
        }
    }

    public static boolean Wwwwwwwwwwwww() {
        Wwwwww wwwwww;
        Wwwwww wwwwww2;
        if (Kkkkkkkkkkk.size() == 0 || (wwwwww2 = Kkkkkkkkkkkk) == null) {
            if (Kkkkkkkkkkk.size() == 0 && (wwwwww = Kkkkkkkkkkkk) != null && wwwwww.Wwwwwwwwwwwwwwwwwwwwwww != 0) {
                wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return true;
            }
            Wwwwww wwwwww3 = Kkkkkkkkkkkk;
            if (wwwwww3 == null || wwwwww3.Wwwwwwwwwwwwwwwwwwwwwww != 0) {
                return false;
            }
            wwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return false;
        } else if (wwwwww2 != null) {
            wwwwww2.Wwwwwwwwwwwwwwww = System.currentTimeMillis();
            ((ViewGroup) Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwww2.getContext()).getWindow().getDecorView()).removeView(wwwwww2);
            try {
                ((ViewGroup) wwwwww2.getParent()).removeView(wwwwww2);
            } catch (Exception unused) {
            }
            Kkkkkkkkkkk.getLast().removeAllViews();
            Kkkkkkkkkkk.getLast().addView(wwwwww2, new FrameLayout.LayoutParams(-1, -1));
            Kkkkkkkkkkk.pop();
            wwwwww2.setScreenNormal(true);
            Context context = wwwwww2.getContext();
            if (Kkkkkkkkkk) {
                Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).clearFlags(1024);
            }
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwww2.getContext(), Kkkkkkkk);
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwww2.getContext()).getDecorView().setSystemUiVisibility(Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return true;
        } else {
            throw null;
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        SharedPreferences.Editor putLong;
        SharedPreferences.Editor edit = context.getSharedPreferences("JZVD_PROGRESS", 0).edit();
        if (str == null) {
            putLong = edit.clear();
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("newVersion:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str.toString());
            putLong = edit.putLong(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), 0L);
        }
        putLong.apply();
    }

    public static void setCurrentJzvd(Wwwwww wwwwww) {
        Wwwwww wwwwww2 = Kkkkkkkkkkkk;
        if (wwwwww2 != null) {
            wwwwww2.Wwwwwwwwwwwwwwwwwww();
        }
        Kkkkkkkkkkkk = wwwwww;
    }

    public static void setTextureViewRotation(int i) {
        Wwwwwwww wwwwwwww;
        Wwwwww wwwwww = Kkkkkkkkkkkk;
        if (wwwwww == null || (wwwwwwww = wwwwww.Wwwww) == null) {
            return;
        }
        wwwwwwww.setRotation(i);
    }

    public static void setVideoImageDisplayType(int i) {
        Wwwwwwww wwwwwwww;
        Kkkkkk = i;
        Wwwwww wwwwww = Kkkkkkkkkkkk;
        if (wwwwww == null || (wwwwwwww = wwwwww.Wwwww) == null) {
            return;
        }
        wwwwwwww.requestLayout();
    }

    public void Wwwwwwwwwwwwww() {
        hashCode();
        setCurrentJzvd(this);
        try {
            this.Wwwwwwwwwwwwwwwwww = (Wwwwwwwww) this.Wwwwwwwwwwwwwwwwwww.getConstructor(Wwwwww.class).newInstance(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        AudioManager audioManager = (AudioManager) StubApp.getOrigApplicationContext(getApplicationContext()).getSystemService("audio");
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = audioManager;
        audioManager.requestAudioFocus(Kkkk, 3, 2);
        try {
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getWindow().addFlags(128);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
    }

    public void Wwwwwwwwwwwwwww() {
        hashCode();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwww = new Timer();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwww.schedule(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0L, 300L);
    }

    public void Wwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwww = 1;
    }

    public void Wwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwww.setProgress(0);
        this.Wwwwwwwwwwww.setSecondaryProgress(0);
        this.Wwwwwwwwww.setText(Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L));
        this.Wwwwwwwww.setText(Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L));
    }

    public void Wwwwwwwwwwwwwwwwwww() {
        hashCode();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 4 || i == 5) {
            getCurrentPositionWhenPlaying();
            getContext();
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwww.removeAllViews();
        ((AudioManager) StubApp.getOrigApplicationContext(getApplicationContext()).getSystemService("audio")).abandonAudioFocus(Kkkk);
        try {
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getWindow().clearFlags(128);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Wwwwwwwww wwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
        if (wwwwwwwww != null) {
            wwwwwwwww.release();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwww() {
        hashCode();
        long j = this.Wwwwwwwwwwwwww;
        if (j != 0) {
            this.Wwwwwwwwwwwwwwwwww.seekTo(j);
            this.Wwwwwwwwwwwwww = 0L;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 4;
        Wwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwww() {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 5;
        Wwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwww() {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwww wwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
        if (wwwwwwwww != null) {
            wwwwwwwww.release();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwww() {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 7;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwww() {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 6;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwww.setProgress(100);
        this.Wwwwwwwwww.setText(this.Wwwwwwwww.getText());
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwww() {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 3;
        if (!this.Kkkkkkkkkkkkk) {
            this.Wwwwwwwwwwwwwwwwww.start();
            this.Kkkkkkkkkkkkk = false;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().toLowerCase().contains("mp3") || this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().toLowerCase().contains("wma") || this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().toLowerCase().contains("aac") || this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().toLowerCase().contains("m4a") || this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().toLowerCase().contains("wav")) {
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Runtime.getRuntime().gc();
        hashCode();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwww.release();
        try {
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getWindow().clearFlags(128);
        } catch (Exception unused) {
        }
        getContext();
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Context context = getContext();
        if (Kkkkkkkkkk) {
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).clearFlags(1024);
        }
        Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), Kkkkkkkk);
        Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getDecorView().setSystemUiVisibility(Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ((ViewGroup) Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getWindow().getDecorView()).removeView(this);
        Wwwwwwwww wwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
        if (wwwwwwwww != null) {
            wwwwwwwww.release();
        }
        Kkkkkkkkkkkk = null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Timer timer = this.Wwww;
        if (timer != null) {
            timer.cancel();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.cancel();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i == 3) {
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 != 3 && i3 != 2) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        hashCode();
        Wwwwwwww wwwwwwww = this.Wwwww;
        if (wwwwwwww != null) {
            this.Wwwwwwww.removeView(wwwwwwww);
        }
        Wwwwwwww wwwwwwww2 = new Wwwwwwww(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        this.Wwwww = wwwwwwww2;
        wwwwwwww2.setSurfaceTextureListener(this.Wwwwwwwwwwwwwwwwww);
        this.Wwwwwwww.addView(this.Wwwww, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, int i) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, String str, long j, String str2, long j2) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        hashCode();
        if (i == 38 || i2 == -38 || i == -38 || i2 == 38 || i2 == -19) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwww.release();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 2;
        this.Wwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwww.setSurface(null);
        this.Wwwwwwwwwwwwwwwwww.release();
        this.Wwwwwwwwwwwwwwwwww.prepare();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
        if (!this.Kkkkkkkkkkkkkkkkkkkkkkk) {
            int i2 = this.Wwwwwwwwwwwwwww;
            if (i2 != -1) {
                if (i2 > i) {
                    return;
                }
                this.Wwwwwwwwwwwwwww = -1;
            } else if (i != 0) {
                this.Wwwwwwwwwwww.setProgress(i);
            }
        }
        if (j != 0) {
            this.Wwwwwwwwww.setText(Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j));
        }
        this.Wwwwwwwww.setText(Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.Wwwwwwwwwwwww = (ImageView) findViewById(cn.jzvd.R$id.start);
        this.Wwwwwwwwwww = (ImageView) findViewById(cn.jzvd.R$id.fullscreen);
        this.Wwwwwwwwwwww = (SeekBar) findViewById(cn.jzvd.R$id.bottom_seek_progress);
        this.Wwwwwwwwww = (TextView) findViewById(cn.jzvd.R$id.current);
        this.Wwwwwwwww = (TextView) findViewById(cn.jzvd.R$id.total);
        this.Wwwwww = (ViewGroup) findViewById(cn.jzvd.R$id.layout_bottom);
        this.Wwwwwwww = (ViewGroup) findViewById(cn.jzvd.R$id.surface_container);
        this.Wwwwwww = (ViewGroup) findViewById(cn.jzvd.R$id.layout_top);
        this.Wwwwwwwwwwwww.setOnClickListener(this);
        this.Wwwwwwwwwww.setOnClickListener(this);
        this.Wwwwwwwwwwww.setOnSeekBarChangeListener(this);
        this.Wwwwww.setOnClickListener(this);
        this.Wwwwwwww.setOnClickListener(this);
        this.Wwwwwwww.setOnTouchListener(this);
        this.Www = getContext().getResources().getDisplayMetrics().widthPixels;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = getContext().getResources().getDisplayMetrics().heightPixels;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = -1;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 1;
        Wwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, Class cls) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwww(str, str2), i, cls);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwww wwwwwwwwww, int i, Class cls) {
        if (System.currentTimeMillis() - this.Wwwwwwwwwwwwwwww < 200) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww = cls;
    }

    public Context getApplicationContext() {
        Context origApplicationContext;
        Context context = getContext();
        return (context == null || (origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())) == null) ? context : origApplicationContext;
    }

    public long getCurrentPositionWhenPlaying() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 4 || i == 5) {
            try {
                return this.Wwwwwwwwwwwwwwwwww.getCurrentPosition();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public long getDuration() {
        Wwwwwwwww wwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
        if (wwwwwwwww != null) {
            try {
                return wwwwwwwww.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public abstract int getLayoutId();

    public int getScreen() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == cn.jzvd.R$id.start) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            hashCode();
            Wwwwwwwwww wwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwww == null || wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                Toast.makeText(getContext(), getResources().getString(cn.jzvd.R$string.no_url), 0).show();
                return;
            }
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().startsWith("file") && !this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().startsWith("/") && !Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()) && !Kkkkkkk) {
                    Wwwwwwwwwwwwwwww();
                    return;
                }
            } else if (i == 4) {
                hashCode();
                this.Wwwwwwwwwwwwwwwwww.pause();
                Wwwwwwwwwwwwwwwwwwwww();
                return;
            } else if (i == 5) {
                this.Wwwwwwwwwwwwwwwwww.start();
                Wwwwwwwwwwwwwwwwwwww();
                return;
            } else if (i != 6) {
                return;
            }
            Wwwwwwwwwwwwww();
        } else if (id != cn.jzvd.R$id.fullscreen) {
        } else {
            hashCode();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 6) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwww == 1) {
                Wwwwwwwwwwwww();
                return;
            }
            hashCode();
            ViewGroup viewGroup = (ViewGroup) getParent();
            viewGroup.removeView(this);
            try {
                Wwwwww wwwwww = (Wwwwww) getClass().getConstructor(Context.class).newInstance(getContext());
                wwwwww.setId(getId());
                viewGroup.addView(wwwwww);
                wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 0, this.Wwwwwwwwwwwwwwwwwww);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            Kkkkkkkkkkk.add(viewGroup);
            ((ViewGroup) Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getWindow().getDecorView()).addView(this, new FrameLayout.LayoutParams(-1, -1));
            Wwwwwwwwwwwwwwwww();
            Context context = getContext();
            if (Kkkkkkkkkk) {
                Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).setFlags(1024, 1024);
            }
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), Kkkkkkkkk);
            Context context2 = getContext();
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2).getDecorView().getSystemUiVisibility();
            Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2).getDecorView().setSystemUiVisibility(5638);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i3 == 1 || i3 == 2) {
            super.onMeasure(i, i2);
        } else if (this.Wwwwwwwwwwwwwwwwwwwww == 0 || this.Wwwwwwwwwwwwwwwwwwww == 0) {
            super.onMeasure(i, i2);
        } else {
            int size = View.MeasureSpec.getSize(i);
            int i4 = (int) ((size * this.Wwwwwwwwwwwwwwwwwwww) / this.Wwwwwwwwwwwwwwwwwwwww);
            setMeasuredDimension(size, i4);
            getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.Wwwwwwwwww.setText(Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i * getDuration()) / 100));
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        hashCode();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        hashCode();
        Wwwwwwwwwwwwwww();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 4 || i == 5) {
            long duration = getDuration();
            this.Wwwwwwwwwwwwwww = seekBar.getProgress();
            this.Wwwwwwwwwwwwwwwwww.seekTo((duration * seekBar.getProgress()) / 100);
            hashCode();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int streamMaxVolume;
        int i;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.getId() == cn.jzvd.R$id.surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                hashCode();
                this.Kkkkkkkkkkkkkkkkkkkkkkk = true;
                this.Kkkkkkkkkkkkkkkkkkkkkk = x;
                this.Kkkkkkkkkkkkkkkkkkkkk = y;
                this.Kkkkkkkkkkkkkkkkkkkk = false;
                this.Kkkkkkkkkkkkkkkkkkk = false;
                this.Kkkkkkkkkkkkkkkkkk = false;
            } else if (action == 1) {
                hashCode();
                this.Kkkkkkkkkkkkkkkkkkkkkkk = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (this.Kkkkkkkkkkkkkkkkkkk) {
                    this.Wwwwwwwwwwwwwwwwww.seekTo(this.Kkkkkkkkkkkkkk);
                    long duration = getDuration();
                    long j = this.Kkkkkkkkkkkkkk * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.Wwwwwwwwwwww.setProgress((int) (j / duration));
                }
                Wwwwwwwwwwwwwww();
            } else if (action == 2) {
                hashCode();
                float f = x - this.Kkkkkkkkkkkkkkkkkkkkkk;
                float f2 = y - this.Kkkkkkkkkkkkkkkkkkkkk;
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                if (this.Wwwwwwwwwwwwwwwwwwwwwww == 1 && !this.Kkkkkkkkkkkkkkkkkkk && !this.Kkkkkkkkkkkkkkkkkkkk && !this.Kkkkkkkkkkkkkkkkkk && (abs > 80.0f || abs2 > 80.0f)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (i >= 0) {
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != 7) {
                            this.Kkkkkkkkkkkkkkkkkkk = true;
                            this.Kkkkkkkkkkkkkkkkk = getCurrentPositionWhenPlaying();
                        }
                    } else if (this.Kkkkkkkkkkkkkkkkkkkkkk < this.Www * 0.5f) {
                        this.Kkkkkkkkkkkkkkkkkk = true;
                        float f3 = Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getAttributes().screenBrightness;
                        if (f3 < 0.0f) {
                            try {
                                this.Kkkkkkkkkkkkkkk = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                            } catch (Settings.SettingNotFoundException e) {
                                e.printStackTrace();
                            }
                        } else {
                            this.Kkkkkkkkkkkkkkk = f3 * 255.0f;
                        }
                    } else {
                        this.Kkkkkkkkkkkkkkkkkkkk = true;
                        this.Kkkkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getStreamVolume(3);
                    }
                }
                if (this.Kkkkkkkkkkkkkkkkkkk) {
                    long duration2 = getDuration();
                    long j2 = (int) (((((float) duration2) * f) / this.Www) + ((float) this.Kkkkkkkkkkkkkkkkk));
                    this.Kkkkkkkkkkkkkk = j2;
                    if (j2 > duration2) {
                        this.Kkkkkkkkkkkkkk = duration2;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk), this.Kkkkkkkkkkkkkk, Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(duration2), duration2);
                }
                if (this.Kkkkkkkkkkkkkkkkkkkk) {
                    f2 = -f2;
                    this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setStreamVolume(3, this.Kkkkkkkkkkkkkkkk + ((int) (((this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getStreamMaxVolume(3) * f2) * 3.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk)), 0);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-f2, (int) ((((f2 * 3.0f) * 100.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) + ((this.Kkkkkkkkkkkkkkkk * 100) / streamMaxVolume)));
                }
                if (this.Kkkkkkkkkkkkkkkkkk) {
                    float f4 = -f2;
                    WindowManager.LayoutParams attributes = Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getAttributes();
                    float f5 = this.Kkkkkkkkkkkkkkk;
                    float f6 = (int) (((f4 * 255.0f) * 3.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
                    if ((f5 + f6) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f5 + f6) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f5 + f6) / 255.0f;
                    }
                    Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).setAttributes(attributes);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((((f4 * 3.0f) * 100.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) + ((this.Kkkkkkkkkkkkkkk * 100.0f) / 255.0f)));
                }
            }
        }
        return false;
    }

    public void setBufferProgress(int i) {
        if (i != 0) {
            this.Wwwwwwwwwwww.setSecondaryProgress(i);
        }
    }

    public void setMediaInterface(Class cls) {
        Wwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww = cls;
    }

    public void setScreen(int i) {
        if (i == 0) {
            setScreenNormal(false);
        } else if (i == 1) {
            Wwwwwwwwwwwwwwwww();
        } else if (i != 2) {
        } else {
            Wwwww wwwww = (Wwwww) this;
            wwwww.Wwwwwwwwwwwwwwwwwwwwwww = 2;
            wwwww.Illlllllllllllllllllllllll.setVisibility(0);
            wwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, 4, 4, 4, 4, 4, 4);
            wwwww.Illllllllllllllllllllllll.setVisibility(8);
            wwwww.Illlllllllllllllllll.setVisibility(8);
        }
    }

    public void setScreenNormal(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public void setState(int i) {
        if (i == 0) {
            Wwwwwwwwwwwwwwwwwwwwww();
        } else if (i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
        } else if (i == 2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
        } else if (i == 4) {
            Wwwwwwwwwwwwwwwwwwww();
        } else if (i == 5) {
            Wwwwwwwwwwwwwwwwwwwww();
        } else if (i == 6) {
            Wwwwwwwwwwwwwwwwwwwwwwww();
        } else if (i != 7) {
        } else {
            Wwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        hashCode();
        Wwwwwwww wwwwwwww = this.Wwwww;
        if (wwwwwwww != null) {
            int i3 = this.Wwwwwwwwwwwwwwwww;
            if (i3 != 0) {
                wwwwwwww.setRotation(i3);
            }
            Wwwwwwww wwwwwwww2 = this.Wwwww;
            if (wwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww == i && wwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww == i2) {
                return;
            }
            wwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            wwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww = i2;
            wwwwwwww2.requestLayout();
        }
    }
}
