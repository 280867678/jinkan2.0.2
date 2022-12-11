package me.tvspark;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.TooltipCompatHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.jetty.server.AsyncContinuation;

/* loaded from: classes4.dex */
public class Wwwww extends Wwwwww {
    public static Timer IIlllll = null;
    public static int IIllllll = 70;
    public static long IIlllllll;
    public BroadcastReceiver IIllllllll = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public boolean IIlllllllll;

    /* renamed from: Il */
    public boolean f4509Il;
    public boolean Ill;
    public TextView Illl;
    public ProgressBar Illll;
    public Dialog Illlll;
    public ImageView Illllll;
    public TextView Illlllll;
    public ProgressBar Illllllll;
    public Dialog Illlllllll;
    public ImageView Illllllllll;
    public TextView Illlllllllll;
    public TextView Illllllllllll;
    public ProgressBar Illlllllllllll;
    public Dialog Illllllllllllll;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Illlllllllllllll;
    public LinearLayout Illllllllllllllll;
    public TextView Illlllllllllllllll;
    public PopupWindow Illllllllllllllllll;
    public TextView Illlllllllllllllllll;
    public LinearLayout Illllllllllllllllllll;
    public TextView Illlllllllllllllllllll;
    public TextView Illllllllllllllllllllll;
    public ImageView Illlllllllllllllllllllll;
    public LinearLayout Illllllllllllllllllllllll;
    public ImageView Illlllllllllllllllllllllll;
    public ImageView Illllllllllllllllllllllllll;
    public TextView Illlllllllllllllllllllllllll;
    public ProgressBar Illllllllllllllllllllllllllll;

    /* renamed from: Kk */
    public ProgressBar f4510Kk;
    public ImageView Kkk;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TimerTask {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Wwwww wwwww = Wwwww.this;
            if (wwwww.Wwwwwwwwwwwwwwwwwwwwwww != 0) {
                wwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends BroadcastReceiver {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                Wwwww.IIllllll = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                Wwwww.this.Kkkkkkkkkkkkkkkkkkkkk();
                try {
                    Wwwww.this.getContext().unregisterReceiver(Wwwww.this.IIllllllll);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Wwwww(Context context) {
        super(context);
    }

    public Wwwww(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void Kkkkkkkkkkkkkkkkkk() {
        ImageView imageView;
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == 4) {
            this.Wwwwwwwwwwwww.setVisibility(0);
            imageView = this.Wwwwwwwwwwwww;
            i = cn.jzvd.R$drawable.jz_click_pause_selector;
        } else if (i2 == 7) {
            this.Wwwwwwwwwwwww.setVisibility(4);
            this.Illlllllllllllllllllll.setVisibility(8);
            this.Illllllllllllllllllll.setVisibility(8);
        } else if (i2 == 6) {
            this.Wwwwwwwwwwwww.setVisibility(0);
            this.Wwwwwwwwwwwww.setImageResource(cn.jzvd.R$drawable.jz_click_replay_selector);
            this.Illlllllllllllllllllll.setVisibility(0);
            if (this.f4509Il) {
                return;
            }
            this.Illllllllllllllllllll.setVisibility(0);
            return;
        } else {
            imageView = this.Wwwwwwwwwwwww;
            i = cn.jzvd.R$drawable.jz_click_play_selector;
        }
        imageView.setImageResource(i);
        this.Illlllllllllllllllllll.setVisibility(8);
        this.Illllllllllllllllllll.setVisibility(8);
    }

    public void Kkkkkkkkkkkkkkkkkkk() {
        Wwwwwwwww();
        IIlllll = new Timer();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Illlllllllllllll = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        IIlllll.schedule(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    public void Kkkkkkkkkkkkkkkkkkkk() {
        this.Illllllllllllllllllllll.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (System.currentTimeMillis() - IIlllllll <= AsyncContinuation.DEFAULT_TIMEOUT) {
            Kkkkkkkkkkkkkkkkkkkkk();
            return;
        }
        IIlllllll = System.currentTimeMillis();
        getContext().registerReceiver(this.IIllllllll, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public void Kkkkkkkkkkkkkkkkkkkkk() {
        ImageView imageView;
        int i;
        int i2 = IIllllll;
        if (i2 < 15) {
            imageView = this.Illlllllllllllllllllllll;
            i = cn.jzvd.R$drawable.jz_battery_level_10;
        } else if (i2 >= 15 && i2 < 40) {
            imageView = this.Illlllllllllllllllllllll;
            i = cn.jzvd.R$drawable.jz_battery_level_30;
        } else if (i2 >= 40 && i2 < 60) {
            imageView = this.Illlllllllllllllllllllll;
            i = cn.jzvd.R$drawable.jz_battery_level_50;
        } else if (i2 >= 60 && i2 < 80) {
            imageView = this.Illlllllllllllllllllllll;
            i = cn.jzvd.R$drawable.jz_battery_level_70;
        } else if (i2 >= 80 && i2 < 95) {
            imageView = this.Illlllllllllllllllllllll;
            i = cn.jzvd.R$drawable.jz_battery_level_90;
        } else if (i2 < 95 || i2 > 100) {
            return;
        } else {
            imageView = this.Illlllllllllllllllllllll;
            i = cn.jzvd.R$drawable.jz_battery_level_100;
        }
        imageView.setBackgroundResource(i);
    }

    public void Kkkkkkkkkkkkkkkkkkkkkk() {
        if (this.Wwwwww.getVisibility() != 0) {
            Kkkkkkkkkkkkkkkkkkkk();
            this.Illlllllllllllllllll.setText(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
            if (this.Wwwwww.getVisibility() == 0) {
                return;
            }
            Kkkkkkkkkkkkkkkkkkkk();
        } else if (i == 4) {
            if (this.Wwwwww.getVisibility() == 0) {
                Www();
            } else {
                Kkkkkkkkkkkkkkkkkkkkkkkkkk();
            }
        } else if (i != 5) {
        } else {
            if (this.Wwwwww.getVisibility() == 0) {
                Wwwww();
            } else {
                Wwww();
            }
        }
    }

    public void Kkkkkkkkkkkkkkkkkkkkkkk() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 1) {
            if (this.Wwwwww.getVisibility() != 0) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
        } else if (i == 4) {
            if (this.Wwwwww.getVisibility() != 0) {
                return;
            }
            Www();
        } else if (i == 5) {
            if (this.Wwwwww.getVisibility() != 0) {
                return;
            }
            Wwwww();
        } else if (i != 6 || this.Wwwwww.getVisibility() != 0) {
        } else {
            Wwwwwwww();
        }
    }

    public /* synthetic */ void Kkkkkkkkkkkkkkkkkkkkkkkk() {
        this.Wwwwww.setVisibility(4);
        this.Wwwwwww.setVisibility(4);
        this.Wwwwwwwwwwwww.setVisibility(4);
        PopupWindow popupWindow = this.Illllllllllllllllll;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != 2) {
            this.f4510Kk.setVisibility(0);
        }
    }

    public void Kkkkkkkkkkkkkkkkkkkkkkkkk() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 7 || i == 6) {
            return;
        }
        post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                Wwwww.this.Kkkkkkkkkkkkkkkkkkkkkkkk();
            }
        });
    }

    public void Kkkkkkkkkkkkkkkkkkkkkkkkkk() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0, 0, 4, 4, 4, 4);
            Kkkkkkkkkkkkkkkkkk();
        }
    }

    public void Www() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void Wwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0, 0, 4, 4, 4, 4);
            Kkkkkkkkkkkkkkkkkk();
        }
    }

    public void Wwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void Wwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 4, 0, 4, 0, 4, 4);
            Kkkkkkkkkkkkkkkkkk();
        }
    }

    public void Wwwwwww() {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == 0) {
            i = 4;
        } else if (i2 != 1) {
            return;
        } else {
            i = 0;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 4, 0, 4, 4, 4, 0);
        Kkkkkkkkkkkkkkkkkk();
    }

    public void Wwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 4, 0, 4, 0, 4, 4);
            Kkkkkkkkkkkkkkkkkk();
        }
    }

    public void Wwwwwwwww() {
        Timer timer = IIlllll;
        if (timer != null) {
            timer.cancel();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Illlllllllllllll;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.cancel();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwww() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage(getResources().getString(cn.jzvd.R$string.tips_not_wifi));
            builder.setPositiveButton(getResources().getString(cn.jzvd.R$string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: me.tvspark.Wwwwwwwwwwwww
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Wwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogInterface, i);
                }
            });
            builder.setNegativeButton(getResources().getString(cn.jzvd.R$string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: me.tvspark.Wwwwwwwwwwww
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Wwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogInterface, i);
                }
            });
            builder.setOnCancelListener(lambda.Wwwwwwwwwwwwwwwwwwwwwwww);
            builder.create().show();
        } catch (Exception unused) {
            Wwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwww = 1;
        this.Wwwwwwwwwww.setImageResource(cn.jzvd.R$drawable.jz_shrink);
        this.Kkk.setVisibility(0);
        this.Illlllllllllllllllllllllll.setVisibility(4);
        this.Illllllllllllllllllllllll.setVisibility(0);
        if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1) {
            this.Illlllllllllllllllll.setVisibility(8);
        } else {
            this.Illlllllllllllllllll.setText(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
            this.Illlllllllllllllllll.setVisibility(0);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) getResources().getDimension(cn.jzvd.R$dimen.jz_start_button_w_h_fullscreen));
        Kkkkkkkkkkkkkkkkkkkk();
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwww();
        this.f4510Kk.setProgress(0);
        this.f4510Kk.setSecondaryProgress(0);
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwww();
        Wwwwwwwww();
        PopupWindow popupWindow = this.Illllllllllllllllll;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == 0) {
            Kkkkkkkkkkkkkkkkkkkkkkkkkk();
        } else {
            Www();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwww();
        Wwww();
        Wwwwwwwww();
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwww();
        Wwwwww();
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwww();
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwww();
        Wwwwwwwww();
        this.f4510Kk.setProgress(100);
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwww();
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Illlllllll;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Illllllllllllll;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Illlll;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        ViewGroup.LayoutParams layoutParams = this.Wwwwwwwwwwwww.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        ViewGroup.LayoutParams layoutParams2 = this.Illllllllllllllllllllllllllll.getLayoutParams();
        layoutParams2.height = i;
        layoutParams2.width = i;
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0, 4, 0, 0, 0, 4);
            Kkkkkkkkkkkkkkkkkk();
        }
    }

    public Dialog Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        Dialog dialog = new Dialog(getContext(), cn.jzvd.R$style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, int i) {
        if (this.Illlllllll == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(cn.jzvd.R$layout.jz_dialog_volume, (ViewGroup) null);
            this.Illllll = (ImageView) inflate.findViewById(cn.jzvd.R$id.volume_image_tip);
            this.Illlllll = (TextView) inflate.findViewById(cn.jzvd.R$id.tv_volume);
            this.Illllllll = (ProgressBar) inflate.findViewById(cn.jzvd.R$id.volume_progressbar);
            this.Illlllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inflate);
        }
        if (!this.Illlllllll.isShowing()) {
            this.Illlllllll.show();
        }
        this.Illllll.setBackgroundResource(i <= 0 ? cn.jzvd.R$drawable.jz_close_volume : cn.jzvd.R$drawable.jz_add_volume);
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        TextView textView = this.Illlllll;
        textView.setText(i + "%");
        this.Illllllll.setProgress(i);
        Kkkkkkkkkkkkkkkkkkkkkkk();
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, String str, long j, String str2, long j2) {
        ImageView imageView;
        int i;
        if (this.Illllllllllllll == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(cn.jzvd.R$layout.jz_dialog_progress, (ViewGroup) null);
            this.Illlllllllllll = (ProgressBar) inflate.findViewById(cn.jzvd.R$id.duration_progressbar);
            this.Illllllllllll = (TextView) inflate.findViewById(cn.jzvd.R$id.tv_current);
            this.Illlllllllll = (TextView) inflate.findViewById(cn.jzvd.R$id.tv_duration);
            this.Illllllllll = (ImageView) inflate.findViewById(cn.jzvd.R$id.duration_image_tip);
            this.Illllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inflate);
        }
        if (!this.Illllllllllllll.isShowing()) {
            this.Illllllllllllll.show();
        }
        this.Illllllllllll.setText(str);
        TextView textView = this.Illlllllllll;
        textView.setText(" / " + str2);
        this.Illlllllllllll.setProgress(j2 <= 0 ? 0 : (int) ((j * 100) / j2));
        if (f > 0.0f) {
            imageView = this.Illllllllll;
            i = cn.jzvd.R$drawable.jz_forward_icon;
        } else {
            imageView = this.Illllllllll;
            i = cn.jzvd.R$drawable.jz_backward_icon;
        }
        imageView.setBackgroundResource(i);
        Kkkkkkkkkkkkkkkkkkkkkkk();
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Illlll == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(cn.jzvd.R$layout.jz_dialog_brightness, (ViewGroup) null);
            this.Illl = (TextView) inflate.findViewById(cn.jzvd.R$id.tv_brightness);
            this.Illll = (ProgressBar) inflate.findViewById(cn.jzvd.R$id.brightness_progressbar);
            this.Illlll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inflate);
        }
        if (!this.Illlll.isShowing()) {
            this.Illlll.show();
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        TextView textView = this.Illl;
        textView.setText(i + "%");
        this.Illll.setProgress(i);
        Kkkkkkkkkkkkkkkkkkkkkkk();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.Wwwwwww.setVisibility(i);
        this.Wwwwww.setVisibility(i2);
        this.Wwwwwwwwwwwww.setVisibility(i3);
        this.Illllllllllllllllllllllllllll.setVisibility(i4);
        this.Illllllllllllllllllllllllll.setVisibility(i5);
        if (i5 == 8 || i5 == 4) {
            this.Illllllllllllllllllllllllll.setImageDrawable(null);
        }
        this.f4510Kk.setVisibility(i6);
        this.Illllllllllllllll.setVisibility(i7);
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j);
        this.Wwwwwwwwwwwww.setVisibility(4);
        this.Illlllllllllllllllllll.setVisibility(8);
        this.Illllllllllllllllllll.setVisibility(8);
        this.Illllllllllllllll.setVisibility(8);
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j, j2);
        if (i != 0) {
            this.f4510Kk.setProgress(i);
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        this.Illllllllllllllllllllllll = (LinearLayout) findViewById(cn.jzvd.R$id.battery_time_layout);
        this.f4510Kk = (ProgressBar) findViewById(cn.jzvd.R$id.bottom_progress);
        this.Illlllllllllllllllllllllllll = (TextView) findViewById(cn.jzvd.R$id.title);
        this.Kkk = (ImageView) findViewById(cn.jzvd.R$id.back);
        this.Illllllllllllllllllllllllll = (ImageView) findViewById(cn.jzvd.R$id.thumb);
        this.Illllllllllllllllllllllllllll = (ProgressBar) findViewById(cn.jzvd.R$id.loading);
        this.Illlllllllllllllllllllllll = (ImageView) findViewById(cn.jzvd.R$id.back_tiny);
        this.Illlllllllllllllllllllll = (ImageView) findViewById(cn.jzvd.R$id.battery_level);
        this.Illllllllllllllllllllll = (TextView) findViewById(cn.jzvd.R$id.video_current_time);
        this.Illlllllllllllllllllll = (TextView) findViewById(cn.jzvd.R$id.replay_text);
        this.Illllllllllllllllllll = (LinearLayout) findViewById(cn.jzvd.R$id.next_layout_auto);
        this.Illlllllllllllllllll = (TextView) findViewById(cn.jzvd.R$id.clarity);
        this.Illlllllllllllllll = (TextView) findViewById(cn.jzvd.R$id.retry_btn);
        this.Illllllllllllllll = (LinearLayout) findViewById(cn.jzvd.R$id.retry_layout);
        this.Illllllllllllllllllllllllll.setOnClickListener(this);
        this.Kkk.setOnClickListener(this);
        this.Illlllllllllllllllllllllll.setOnClickListener(this);
        this.Illlllllllllllllllll.setOnClickListener(this);
        this.Illlllllllllllllll.setOnClickListener(this);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Wwwwwwwwwwwwww();
        Wwwwww.Kkkkkkk = true;
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LinearLayout linearLayout, View view) {
        TextView textView;
        String str;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.Illlllllllllllllllll.setText(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            if (i == this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                textView = (TextView) linearLayout.getChildAt(i);
                str = "#fff85959";
            } else {
                textView = (TextView) linearLayout.getChildAt(i);
                str = "#ffffff";
            }
            textView.setTextColor(Color.parseColor(str));
        }
        PopupWindow popupWindow = this.Illllllllllllllllll;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 1;
        Wwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwww wwwwwwwwww, int i, Class cls) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwww, i, cls);
        this.Illlllllllllllllllllllllllll.setText(wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        setScreen(i);
    }

    @Override // me.tvspark.Wwwwww
    public int getLayoutId() {
        return cn.jzvd.R$layout.jz_layout_std;
    }

    @Override // me.tvspark.Wwwwww, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == cn.jzvd.R$id.thumb) {
            Wwwwwwwwww wwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwww != null && !wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (i != 0) {
                    if (i != 6) {
                        return;
                    }
                    Kkkkkkkkkkkkkkkkkkkkkk();
                    return;
                } else if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().startsWith("file") || this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().startsWith("/") || Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()) || Wwwwww.Kkkkkkk) {
                    Wwwwwwwwwwwwww();
                    return;
                } else {
                    Wwwwwwwwwwwwwwww();
                    return;
                }
            }
        } else if (id == cn.jzvd.R$id.surface_container) {
            Kkkkkkkkkkkkkkkkkkk();
            return;
        } else if (id == cn.jzvd.R$id.back) {
            if (Wwwwww.Kkkkkkkkkkkk == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            } else {
                Wwwwww.Wwwwwwwwwwwww();
                return;
            }
        } else if (id == cn.jzvd.R$id.back_tiny) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        } else if (id == cn.jzvd.R$id.clarity) {
            final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(cn.jzvd.R$layout.jz_layout_clarity, (ViewGroup) null);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: me.tvspark.Wwwwwwwwwwwwwww
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Wwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(linearLayout, view2);
                }
            };
            for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                TextView textView = (TextView) View.inflate(getContext(), cn.jzvd.R$layout.jz_layout_clarity_item, null);
                textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                textView.setTag(Integer.valueOf(i2));
                linearLayout.addView(textView, i2);
                textView.setOnClickListener(onClickListener);
                if (i2 == this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    textView.setTextColor(Color.parseColor("#fff85959"));
                }
            }
            PopupWindow popupWindow = new PopupWindow((View) linearLayout, -2, -2, true);
            this.Illllllllllllllllll = popupWindow;
            popupWindow.setContentView(linearLayout);
            this.Illllllllllllllllll.showAsDropDown(this.Illlllllllllllllllll);
            linearLayout.measure(0, 0);
            this.Illllllllllllllllll.update(this.Illlllllllllllllllll, -(this.Illlllllllllllllllll.getMeasuredWidth() / 3), -(this.Illlllllllllllllllll.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
            return;
        } else if (id != cn.jzvd.R$id.retry_btn) {
            return;
        } else {
            if (!this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().startsWith("file") && !this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString().startsWith("/") && !Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()) && !Wwwwww.Kkkkkkk) {
                    Wwwwwwwwwwwwwwww();
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
                return;
            }
        }
        Toast.makeText(getContext(), getResources().getString(cn.jzvd.R$string.no_url), 0).show();
    }

    @Override // me.tvspark.Wwwwww, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        Wwwwwwwww();
    }

    @Override // me.tvspark.Wwwwww, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        Kkkkkkkkkkkkkkkkkkk();
    }

    @Override // me.tvspark.Wwwwww, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == cn.jzvd.R$id.surface_container) {
            if (motionEvent.getAction() == 1) {
                Kkkkkkkkkkkkkkkkkkk();
                if (this.Kkkkkkkkkkkkkkkkkkk) {
                    long duration = getDuration();
                    long j = this.Kkkkkkkkkkkkkk * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.f4510Kk.setProgress((int) (j / duration));
                }
                if (!this.Kkkkkkkkkkkkkkkkkkk && !this.Kkkkkkkkkkkkkkkkkkkk) {
                    Kkkkkkkkkkkkkkkkkkkkkk();
                }
            }
        } else if (id == cn.jzvd.R$id.bottom_seek_progress) {
            int action = motionEvent.getAction();
            if (action == 0) {
                Wwwwwwwww();
            } else if (action == 1) {
                Kkkkkkkkkkkkkkkkkkk();
            }
        }
        super.onTouch(view, motionEvent);
        return false;
    }

    @Override // me.tvspark.Wwwwww
    public void setBufferProgress(int i) {
        super.setBufferProgress(i);
        if (i != 0) {
            this.f4510Kk.setSecondaryProgress(i);
        }
    }

    @Override // me.tvspark.Wwwwww
    public void setScreenNormal(boolean z) {
        super.setScreenNormal(z);
        this.Wwwwwwwwwww.setImageResource(cn.jzvd.R$drawable.jz_enlarge);
        if (this.f4509Il) {
            this.Kkk.setVisibility(8);
        } else {
            this.Kkk.setVisibility(0);
        }
        this.Illlllllllllllllllllllllll.setVisibility(4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) getResources().getDimension(cn.jzvd.R$dimen.jz_start_button_w_h_normal));
        this.Illllllllllllllllllllllll.setVisibility(8);
        this.Illlllllllllllllllll.setVisibility(8);
    }
}
