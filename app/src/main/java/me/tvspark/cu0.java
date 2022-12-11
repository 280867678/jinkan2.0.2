package me.tvspark;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.smtt.utils.TbsLog;
import white.whale.R;

/* loaded from: classes4.dex */
public class cu0 implements View.OnClickListener {
    public boolean Wwwwwwww;
    public LinearLayout Wwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public LayoutInflater Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww = TbsLog.TBSLOG_CODE_SDK_INIT;
    public String Wwwwwwwwwwwww = "取消";
    public String Wwwwwwwwwwww = "确定";
    public boolean Wwwwwwwwwww = true;
    public String Wwwwwwwww = "";
    public int Wwwwwww = -1;
    public int Wwwwww = -1;
    public int Wwwww = -1;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog, String str);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Dialog Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cu0.this.Wwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public cu0(Context context, String str, String str2) {
        this.Wwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.setOnCancelListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialog));
        this.Wwwwwwwwwwwwwwwww = str2;
        View inflate = this.Wwwwwwwwwwwwwwwwwwwwwwww.inflate(R.layout.dialog_common, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwww = inflate;
        this.Wwwwwwwwwwwwwwwwww = (TextView) inflate.findViewById(R.id.tv_title);
        this.Wwwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_content);
        this.Wwwwwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_cancel);
        this.Wwwwwwwwwwwwwwwwwwww = (TextView) this.Wwwwwwwwwwwwwwwwwwwwww.findViewById(R.id.tv_ok);
        this.Wwwwwwwwww = (LinearLayout) this.Wwwwwwwwwwwwwwwwwwwwww.findViewById(R.id.llyt_content);
    }

    public cu0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(this.Wwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwww.setText(this.Wwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwww.setMaxLines(this.Wwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwww.getViewTreeObserver().addOnPreDrawListener(new du0(this));
            this.Wwwwwwwwwwwwwwwwwww.setText(this.Wwwwwwwwwwwwwwwww);
            int i = this.Wwwww;
            if (i > 0) {
                this.Wwwwwwwwwwwwwwwwwww.setTextSize(i);
            }
            int i2 = this.Wwwwww;
            if (i2 > 0) {
                this.Wwwwwwwwwwwwwwwwww.setTextSize(i2);
            }
            this.Wwwwwwwwwwwwwwwwwwwww.setText(this.Wwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww.setOnClickListener(this);
            this.Wwwwwwwwwwwwwwwwwwww.setText(this.Wwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwww.setOnClickListener(this);
            this.Wwwwwwwwwwwwwwwwwww.post(new eu0(this));
            this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.show();
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        } else if (id != R.id.tv_ok || this.Wwwwwwwwwwwwwww == null) {
        } else {
            if (TextUtils.isEmpty(this.Wwwwwwwww)) {
                this.Wwwwwwwww = this.Wwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww);
        }
    }
}
