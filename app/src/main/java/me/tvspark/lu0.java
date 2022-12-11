package me.tvspark;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import white.whale.R;

/* loaded from: classes4.dex */
public class lu0 implements View.OnClickListener, sk0 {
    public int Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwww = true;
    public SeekBar Wwwwwwwwwwwwwww;
    public SeekBar Wwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwww;
    public LayoutInflater Wwwwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwwww;

    public lu0(Activity activity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwwww = LayoutInflater.from(activity);
        this.Wwwwwwwwwwwwwwwwwwwwww = new Dialog(activity, R.style.Dialog_style);
        View inflate = this.Wwwwwwwwwwwwwwwwwwwwwww.inflate(R.layout.dialog_skip_time, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwww = inflate;
        this.Wwwwwwwwwwwwwwwwwwww = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.Wwwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_ok);
        this.Wwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_skip_end);
        this.Wwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_skip_head);
        this.Wwwwwwwwwwwwwwww = (SeekBar) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.seek_head);
        this.Wwwwwwwwwwwwwww = (SeekBar) this.Wwwwwwwwwwwwwwwwwwwww.findViewById(R.id.seek_end);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
        } else if (id != R.id.tv_ok) {
            return;
        } else {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_head", Integer.valueOf(this.Wwwwwwwwwwww));
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_end", Integer.valueOf(this.Wwwwwwwwwww));
            Dialog dialog2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (dialog2 == null || !dialog2.isShowing()) {
                return;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.dismiss();
    }
}
