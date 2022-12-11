package me.tvspark.utils.cast.p050ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.List;
import me.tvspark.adapter.CastDeviceAdapter;
import me.tvspark.ap0;
import me.tvspark.eo0;
import me.tvspark.lp0;
import me.tvspark.mn0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.ro0;
import me.tvspark.sk0;
import me.tvspark.wo0;
import me.tvspark.x11;
import org.greenrobot.eventbus.ThreadMode;
import white.whale.R;

/* renamed from: me.tvspark.utils.cast.ui.DialogDlna */
/* loaded from: classes4.dex */
public class DialogDlna implements sk0 {
    public boolean Wwwwwwwwwww;
    public String Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
    public CastDeviceAdapter Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.rv_progress)
    public RecyclerView rvProgress;
    @BindView(R.id.tv_dialog_title)
    public TextView tvDialogTitle;

    /* renamed from: me.tvspark.utils.cast.ui.DialogDlna$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);
    }

    /* renamed from: me.tvspark.utils.cast.ui.DialogDlna$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CastDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3, String str4) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str4;
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.DialogDlna$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnDismissListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDlna.this);
        }
    }

    public DialogDlna(Activity activity, String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwww = "云播投屏";
        this.Wwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwww = z;
        this.Wwwwwwwwwww = false;
        this.Wwwwwwwwwwww = str5;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_dlna, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        if (!o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        this.Wwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwww = str3;
        this.Wwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwww = str4;
        this.Wwwwwwwwwwwwwwww = i;
        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public DialogDlna(Activity activity, String str, String str2, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwww = "云播投屏";
        this.Wwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwww = z;
        this.Wwwwwwwwwww = true;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_dlna, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        if (!o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        this.Wwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwww = 1;
        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDlna dialogDlna) {
        if (dialogDlna != null) {
            if (!o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogDlna)) {
                return;
            }
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogDlna);
            return;
        }
        throw null;
    }

    public DialogDlna Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (dialog != null && !dialog.isShowing()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.show();
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
            Window window = this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww) * 0.85d);
            window.setAttributes(attributes);
            window.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
        }
        return this;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        String str2;
        String str3;
        int i;
        Dialog dialog = new Dialog(this.Wwwwwwwwwwwwwwwwwwwwww, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(false);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setOnDismissListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.rvProgress.setItemAnimator(null);
        this.rvProgress.setLayoutManager(new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwww, 1, false));
        int i2 = this.Wwwwwwwwwwwwwwww;
        String str4 = this.Wwwwwwwwwwwwwwwwwwwww;
        String str5 = this.Wwwwwwwwwwwwwwwwww;
        String str6 = this.Wwwwwwwwwwwwwwwwwww;
        String str7 = this.Wwwwwwwwwwwwwwwwwwww;
        String str8 = "";
        if (i2 == 1) {
            this.tvDialogTitle.setText(this.Wwwwwwwwwwwwwwwww);
            this.rvProgress.setVisibility(0);
            str8 = str4;
            str = str5;
            str2 = str6;
            str3 = str7;
            i = 1;
        } else if (i2 != 2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        } else {
            this.tvDialogTitle.setText(this.Wwwwwwwwwwwwwwwww);
            this.rvProgress.setVisibility(0);
            str = str8;
            str2 = str;
            str3 = str2;
            i = 2;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str8, str, str2, str3, i);
    }

    @OnClick({R.id.tv_net_setting, R.id.tv_cast_control})
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.tv_cast_control) {
            if (id != R.id.tv_net_setting) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } else if (!this.Wwwwwwwwwwwww) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onEventBus(wo0 wo0Var) {
        List<ro0> list;
        CastDeviceAdapter castDeviceAdapter = this.Wwwwwwwwwwwwwww;
        if (castDeviceAdapter == null || (list = lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null || list.isEmpty()) {
            return;
        }
        castDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        castDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        castDeviceAdapter.notifyDataSetChanged();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, String str4, int i) {
        try {
            this.tvDialogTitle.setText(this.Wwwwwwwwwwwwwwwww);
            CastDeviceAdapter castDeviceAdapter = new CastDeviceAdapter(this.Wwwwwwwwwwwwwwwwwwwwww, lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, str4, str2, str3));
            this.Wwwwwwwwwwwwwww = castDeviceAdapter;
            this.rvProgress.setAdapter(castDeviceAdapter);
        } catch (Exception e) {
            e.printStackTrace();
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, e.getMessage());
        }
    }
}
