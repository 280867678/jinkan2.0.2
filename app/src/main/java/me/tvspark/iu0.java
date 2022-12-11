package me.tvspark;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import white.whale.R;

/* loaded from: classes4.dex */
public class iu0 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LayoutInflater Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnCancelListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            iu0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
    }

    public iu0(Activity activity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LayoutInflater.from(activity);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Dialog(activity, R.style.Dialog_style_trans);
        View inflate = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.inflate(R.layout.view_loading, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = inflate;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (TextView) inflate.findViewById(R.id.tv_msg);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnCancelListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public iu0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!TextUtils.isEmpty(str)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setText(str);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.show();
        }
        return this;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return dialog != null && dialog.isShowing();
    }
}
