package me.tvspark;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;
import me.tvspark.utils.cast.p050ui.DialogDlna;
import white.whale.R;

/* loaded from: classes4.dex */
public class mu0 implements View.OnClickListener, sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwww;
    public EditText Wwwwwwwwwwwwwww;
    public FrameLayout Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww = true;
    public TextView Wwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwww;
    public LayoutInflater Wwwwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            if (TextUtils.isEmpty(str)) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mu0.this.Wwwwwwwwwwwwwwwwwwwwwwww, "剪切板为空");
            } else {
                mu0.this.Wwwwwwwwwwwwwww.setText(str);
            }
        }
    }

    public mu0(Activity activity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        TextView textView;
        String str;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = LayoutInflater.from(activity);
        this.Wwwwwwwwwwwwwwwwwwwwww = new Dialog(activity, R.style.Dialog_style);
        View inflate = this.Wwwwwwwwwwwwwwwwwwwwwww.inflate(R.layout.dialog_float_input, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwww = inflate;
        this.Wwwwwwwwwwwwwww = (EditText) inflate.findViewById(R.id.et_url);
        this.Wwwwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_cancel);
        this.Wwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_title);
        this.Wwwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_ok);
        this.Wwwwwwwwwwwwwwww = (FrameLayout) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.flyt_banner);
        if (this.Wwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwww.setText("悬浮窗播放");
            this.Wwwwwwwwwwwwwww.setHint("输入视频直链小窗播放");
            textView = this.Wwwwwwwwwwwwwwwwwww;
            str = "播放";
        } else {
            this.Wwwwwwwwwwwwwwwwww.setText("投屏播放");
            this.Wwwwwwwwwwwwwww.setHint("输入视频直链投屏播放");
            textView = this.Wwwwwwwwwwwwwwwwwww;
            str = "投屏";
        }
        textView.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } else if (id != R.id.tv_ok) {
        } else {
            String obj = this.Wwwwwwwwwwwwwww.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "请输入视频直链地址");
            } else if (this.Wwwwwwwwwwww == null) {
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (dialog != null && dialog.isShowing()) {
                    this.Wwwwwwwwwwwwwwwwwwwwww.dismiss();
                }
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.Wwwwwwwwwwwwwwwwwwwwwwww, obj, obj, obj, "", false, (mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
            } else {
                Dialog dialog2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (dialog2 != null && dialog2.isShowing()) {
                    this.Wwwwwwwwwwwwwwwwwwwwww.dismiss();
                }
                CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = (CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    throw null;
                }
                ApplicationC1880C.Wwwwwwwwwww.clear();
                CastPlayActivity.this.Wwwwwwwwwwwwwwwwww = new so0("投屏播放", "N/A", "", obj, obj, "", "", 0L, "", "");
                ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this.Wwwwwwwwwwwwwwwwww);
                CastPlayActivity.this.Wwwwwwwwwwwww();
                if (lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    CastPlayActivity.this.Wwwwwwwwwwwwww();
                    return;
                }
                DialogDlna dialogDlna = new DialogDlna(CastPlayActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "", "", "", "", "", 2, true);
                dialogDlna.Wwwwwwwwwwwwww = new wp0(wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                dialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }
}
