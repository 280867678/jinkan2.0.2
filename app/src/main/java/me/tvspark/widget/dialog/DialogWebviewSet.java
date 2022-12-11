package me.tvspark.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.ft0;
import me.tvspark.ko0;
import me.tvspark.mn0;
import me.tvspark.sk0;
import me.tvspark.view.activity.WebSnifferActivity;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogWebviewSet implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.iv_adb)
    public ImageView ivAdb;
    @BindView(R.id.llyt_chane_web)
    public LinearLayout llytChaneWeb;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public DialogWebviewSet(Activity activity) {
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_webview_set, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(activity, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.ivAdb.setImageResource(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("usd_adb", true) ? R.drawable.ic_web_nav_adb_open : R.drawable.ic_web_nav_adb_close);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @OnClick({R.id.llyt_chane_web, R.id.llyt_chane_player, R.id.llyt_history, R.id.llyt_download, R.id.llyt_adb, R.id.llyt_share, R.id.llyt_go_setting, R.id.llyt_dismiss, R.id.llyt_go_exit})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewClicked(View view) {
        ko0 ko0Var;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        switch (view.getId()) {
            case R.id.llyt_adb /* 2131362229 */:
                if (!bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("usd_adb", true)) {
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("usd_adb", true);
                    if (ApplicationC1880C.Wwwwwwwwwwwwww == null) {
                        ko0Var = new ko0(this.Wwwwwwwwwwwwwwwwwwwwww.getExternalFilesDir("filters"));
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        return;
                    }
                    WebSnifferActivity.this.Wwwwwwwwwwww();
                    return;
                }
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("usd_adb", false);
                ko0Var = null;
                ApplicationC1880C.Wwwwwwwwwwwwww = ko0Var;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                }
            case R.id.llyt_chane_player /* 2131362244 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    return;
                }
                WebSnifferActivity.this.Wwwwwwwwwwwwww();
                return;
            case R.id.llyt_chane_web /* 2131362245 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                    return;
                }
                WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                baseActivity = WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity);
                builder.setTitle("选择浏览器UA");
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("vip_browser_ua");
                String str = "※ 手机模式";
                String str2 = "※ 电脑模式";
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                    str = "※ 手机模式      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 1) {
                    str2 = "※ 电脑模式      √";
                }
                builder.setItems(new String[]{str, str2}, new ft0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                builder.setCancelable(true);
                builder.create().show();
                return;
            case R.id.llyt_dismiss /* 2131362251 */:
                break;
            case R.id.llyt_download /* 2131362254 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_go_exit /* 2131362259 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null) {
                    return;
                }
                WebSnifferActivity.this.finish();
                return;
            case R.id.llyt_go_setting /* 2131362260 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
                break;
            case R.id.llyt_history /* 2131362261 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_share /* 2131362289 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == null) {
                    return;
                }
                WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                baseActivity2 = WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, WebSnifferActivity.this.Wwwwwwwwwwwwwwwwww);
                return;
            default:
                return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
