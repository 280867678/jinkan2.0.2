package me.tvspark.utils.sniffer.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.DlnaDeviceAdapter;
import me.tvspark.adapter.ParsingAdapter;
import me.tvspark.bo0;
import me.tvspark.cq0;
import me.tvspark.data.bean.CNTVEpisodeParcel;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.eo0;
import me.tvspark.gq0;
import me.tvspark.mn0;
import me.tvspark.mr0;
import me.tvspark.nn0;
import me.tvspark.nr0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.tr0;
import me.tvspark.ur0;
import me.tvspark.utils.cast.p050ui.DialogDlna;
import me.tvspark.utils.wifitransfer.Defaults;
import me.tvspark.xt0;
import okhttp3.ResponseBody;
import org.eclipse.jetty.util.StringUtil;
import org.fourthline.cling.android.AndroidUpnpService;
import org.fourthline.cling.controlpoint.ControlPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogParse implements sk0 {
    public boolean Kkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkk;
    public gq0 Kkkkkkkkkkkkkkkkkk;
    public DlnaDeviceAdapter Kkkkkkkkkkkkkkkkkkk;
    public cq0 Kkkkkkkkkkkkkkkkkkkk;
    public ControlPoint Kkkkkkkkkkkkkkkkkkkkk;
    public ParsingAdapter Kkkkkkkkkkkkkkkkkkkkkk;
    public List<String> Kkkkkkkkkkkkkkkkkkkkkkk;
    public nr0 Kkkkkkkkkkkkkkkkkkkkkkkk;
    public Wwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Www;
    public int Wwww;
    public String Wwwww;
    public String Wwwwww;
    public String Wwwwwww;
    public String Wwwwwwww;
    public String Wwwwwwwww;
    public String Wwwwwwwwww;
    public String Wwwwwwwwwww;
    public String Wwwwwwwwwwww;
    public String Wwwwwwwwwwwww;
    public String Wwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.iv_dialog_close)
    public ImageView ivDialogClose;
    @BindView(R.id.iv_quick_sniff)
    public ImageView ivQuickSniff;
    @BindView(R.id.llyt_pc_play)
    public LinearLayout llytPcPlay;
    @BindView(R.id.llyt_quick_sniff)
    public LinearLayout llytQuickSniff;
    @BindView(R.id.rv_progress)
    public RecyclerView rvProgress;
    @BindView(R.id.tv_dialog_title)
    public TextView tvDialogTitle;
    @BindView(R.id.tv_ip)
    public TextView tvIp;
    @BindView(R.id.view_bottom)
    public View viewBottom;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, DialogParse dialogParse);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwww {
        void onDismiss();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwww implements cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            List<cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            DialogParse dialogParse = DialogParse.this;
            if (dialogParse.Kkkkkkkkkkkkkkkkkkkkk == null) {
                AndroidUpnpService androidUpnpService = dialogParse.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                dialogParse.Kkkkkkkkkkkkkkkkkkkkk = androidUpnpService == null ? null : androidUpnpService.getControlPoint();
            }
            DialogParse dialogParse2 = DialogParse.this;
            DlnaDeviceAdapter dlnaDeviceAdapter = dialogParse2.Kkkkkkkkkkkkkkkkkkk;
            if (dlnaDeviceAdapter == null || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogParse2.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return;
            }
            dlnaDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            dlnaDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            dlnaDeviceAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements DlnaDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements ParsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnShowListener {
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                ((InputMethodManager) DialogParse.this.Wwwwwwwwwwwwwwwww.getSystemService("input_method")).showSoftInput(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1);
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogParse.this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString())) {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogParse.this.Wwwwwwwwwwwwwwwww, "不能为空");
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogParse.this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                DialogParse dialogParse = DialogParse.this;
                dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, dialogParse.Wwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString());
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            if (i == 3) {
                DialogParse dialogParse = DialogParse.this;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogParse.Wwwwwwwwwwwwwwwww, dialogParse.Wwwwwwwwwwwwwww);
                DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (i == 4) {
                DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                DialogParse dialogParse2 = DialogParse.this;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) dialogParse2.Wwwwwwwwwwwwwwwww, dialogParse2.Wwwwwwwwwwwwwwww, true);
            } else if (i == 2) {
                nr0 nr0Var = DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkkk;
                if (nr0Var != null) {
                    nr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkkk = null;
                }
                DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (i != 1) {
            } else {
                if (TextUtils.isEmpty(str)) {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogParse.this.Wwwwwwwwwwwwwwwww, "地址不能为空");
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogParse.this.Wwwwwwwwwwwwwwwww);
                builder.setTitle("校对");
                EditText editText = new EditText(DialogParse.this.Wwwwwwwwwwwwwwwww);
                editText.setHint("不能为空");
                editText.setText(str);
                builder.setView(editText);
                builder.setPositiveButton("校对完毕", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText));
                builder.setNegativeButton("取消", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText));
                AlertDialog create = builder.create();
                create.setCanceledOnTouchOutside(false);
                create.setView(editText, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0);
                create.setOnShowListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText));
                create.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            String str;
            if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("quick_sniff", true)) {
                DialogParse.this.ivQuickSniff.setImageResource(R.drawable.switch_close);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("quick_sniff", false);
                activity = DialogParse.this.Wwwwwwwwwwwwwwwww;
                str = "严格判断网址链接的最终服务器返回格式信息";
            } else {
                DialogParse.this.ivQuickSniff.setImageResource(R.drawable.switch_open);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("quick_sniff", true);
                activity = DialogParse.this.Wwwwwwwwwwwwwwwww;
                str = "链接后缀名为m3u8格式立即播放，如果错误请关闭此选项";
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, str);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnDismissListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            th.printStackTrace();
            DialogParse dialogParse = DialogParse.this;
            ((Wwwwwwwwwwwwwwwwwwwwwwwwwww) dialogParse.Kkkkkkkkkkkkkkkkkkkkkkkkk).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogParse.Wwww);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                Wwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwww = DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                ((Wwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogParse.this.Wwww, ((CNTVEpisodeParcel) JSON.parseObject(response.body().string(), CNTVEpisodeParcel.class)).getHls_url());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements nr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            DialogParse dialogParse = DialogParse.this;
            if (dialogParse.Kkkkkkkkkkkkkkkkkkkkkkk == null) {
                dialogParse.Kkkkkkkkkkkkkkkkkkkkkkk = new ArrayList();
            }
            DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkk.add(str);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ParsingAdapter parsingAdapter = DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkk;
            if (parsingAdapter != null) {
                parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, str);
                DialogParse dialogParse = DialogParse.this;
                dialogParse.rvProgress.scrollToPosition(dialogParse.Kkkkkkkkkkkkkkkkkkkkkk.getItemCount() - 1);
            }
            Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww = DialogParse.this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements gq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public DialogParse(Activity activity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 2;
        this.Wwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwww = "";
        this.Wwwwwwwwwwww = "";
        this.Wwwwwwwwwww = "嗅探中";
        this.Wwwwwwwwww = "嗅探失败";
        this.Wwwwwwwww = "嗅探完";
        this.Wwwwwwww = "选择设备";
        this.Wwwwwww = "需校对";
        this.Wwwwww = "开始网页嗅探...";
        this.Wwwww = "开始网页嗅探...";
        this.Www = false;
        this.Kkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkk = true;
        this.Wwwwwwwwwwwwwwwww = activity;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_air_play, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public DialogParse(Activity activity, String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 2;
        this.Wwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwww = "";
        this.Wwwwwwwwwwww = "";
        this.Wwwwwwwwwww = "嗅探中";
        this.Wwwwwwwwww = "嗅探失败";
        this.Wwwwwwwww = "嗅探完";
        this.Wwwwwwww = "选择设备";
        this.Wwwwwww = "需校对";
        this.Wwwwww = "开始网页嗅探...";
        this.Wwwww = "开始网页嗅探...";
        this.Www = false;
        this.Kkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkk = true;
        this.Wwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwww = str4;
        this.Wwwwwwwwwwwwww = str5;
        this.Wwwwwwwwwwwwwwww = str3;
        this.Wwww = i;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = z;
        if (str3.contains(WebSourceSeasonData.cntvEpLinkPre)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = 3;
        }
        if (i == 8) {
            ApplicationC1880C.Wwwwwwwwwwww.clear();
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, str3, true);
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_air_play, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 3) {
            return;
        }
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (ApplicationC1880C.Wwwwwwwww) {
            return;
        }
        xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww = xt0Var;
        xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "8091823043098355";
        xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, DialogParse.class.getSimpleName());
        this.flytBanner.removeAllViews();
        this.flytBanner.addView(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public DialogParse Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Wwwwwwwwwwwwwwwwww;
        if (dialog != null && !dialog.isShowing()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
        return this;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ImageView imageView;
        int i;
        Dialog dialog = new Dialog(this.Wwwwwwwwwwwwwwwww, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(false);
        this.Wwwwwwwwwwwwwwwwww.setCancelable(true);
        this.Wwwwwwwwwwwwwwwwww.setOnDismissListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.ivDialogClose.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("quick_sniff", true)) {
            imageView = this.ivQuickSniff;
            i = R.drawable.switch_open;
        } else {
            imageView = this.ivQuickSniff;
            i = R.drawable.switch_close;
        }
        imageView.setImageResource(i);
        this.llytQuickSniff.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.rvProgress.setItemAnimator(null);
        this.rvProgress.setLayoutManager(new LinearLayoutManager(this.Wwwwwwwwwwwwwwwww, 1, false));
        ParsingAdapter parsingAdapter = new ParsingAdapter(this.Wwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Kkkkkkkkkkkkkkkkkkkkkk = parsingAdapter;
        this.rvProgress.setAdapter(parsingAdapter);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = new nr0(this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, this.Wwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ParsingAdapter parsingAdapter;
        String str;
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) {
            parsingAdapter = this.Kkkkkkkkkkkkkkkkkkkkkk;
            str = this.Wwwww;
        } else {
            parsingAdapter = this.Kkkkkkkkkkkkkkkkkkkkkk;
            str = this.Wwwwwwwwwwwwww + " __ " + this.Wwwwww;
        }
        parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, str);
        this.tvDialogTitle.setText(this.Wwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 3) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36").get(this.Wwwwwwwwwwwwwwww).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } else {
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkk == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            nr0 nr0Var = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
            nr0Var.Wwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            mr0 mr0Var = nr0Var.Wwwwwwwwwwwwww;
            if (mr0Var != null) {
                nr0Var.Wwwwwwwwwwww = false;
                mr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            nr0Var.Wwwwwwwwwwwwwwwwwwwwwwww.stopLoading();
            nr0Var.Wwwwwwwwwwwwwwwwwwwwwwww.loadUrl(nr0Var.Wwwwwwwwwwwwwwwwwwwwww);
            nr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nr0Var.Wwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nr0Var.Wwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return true;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Dialog dialog = this.Wwwwwwwwwwwwwwwwww;
        if (dialog != null && dialog.isShowing()) {
            this.Wwwwwwwwwwwwwwwwww.dismiss();
        }
        Wwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            tr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwwww.onDismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (!this.Www && this.Wwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Www = false;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkk != null) {
                this.Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Kkkkkkkkkkkkkkkkkkkkkkkk = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            if (this.Kkkkkkkkkkkkkkkkkkkkkkk != null) {
                this.Kkkkkkkkkkkkkkkkkkkkkkk.clear();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            if (this.Kkkkkkkkkkkkkkkkkkkk == null) {
                return;
            }
            this.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.Wwww = i;
        this.Wwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwww = str3;
        this.Wwwwwwwwwwwwww = str6;
        this.Wwwwwwwwwwwwwwww = str4;
        this.Wwwwwwwwwwwww = str5;
        Wwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (i == 3 || i == 14 || i == 9) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, i, str2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (this.Kkkkkkkkkkkkkkkkk) {
            this.flytBanner.setVisibility(8);
        } else {
            this.flytBanner.setVisibility(0);
        }
        Wwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (this.Kkkkkkkkkkkkkkkk) {
            this.Wwwwwwwwwwwwwwwwww.show();
            Window window = this.Wwwwwwwwwwwwwwwwww.getWindow();
            window.setWindowAnimations(R.style.BotomInOutDialogStyle);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            if (this.Kkkkkkkkkkkkkkkkk) {
                this.viewBottom.setVisibility(0);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (int) (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww) * 0.5d);
            } else {
                this.viewBottom.setVisibility(8);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww);
            }
            attributes.width = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            window.setAttributes(attributes);
            window.setContentView(this.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
            this.Wwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str) {
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            new DialogDlna(this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, this.Wwwwwwwwwwwww, str, this.Wwwwwwwwwwwwwwww, 1, false).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.llytQuickSniff.setVisibility(8);
        try {
            this.tvDialogTitle.setText(this.Wwwwwwww);
            cq0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww);
            this.Kkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            DlnaDeviceAdapter dlnaDeviceAdapter = new DlnaDeviceAdapter(this.Wwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwww(str));
            this.Kkkkkkkkkkkkkkkkkkk = dlnaDeviceAdapter;
            this.rvProgress.setAdapter(dlnaDeviceAdapter);
            this.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Kkkkkkkkkkkkkkkkkk == null) {
                gq0 gq0Var = new gq0();
                this.Kkkkkkkkkkkkkkkkkk = gq0Var;
                gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (Exception e) {
            e.printStackTrace();
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, e.getMessage());
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i, String str) {
        String str2;
        String str3;
        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww);
        this.tvDialogTitle.setText(this.Wwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, z);
        }
        switch (i) {
            case -1:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PARSE");
                if (str.startsWith("http")) {
                    ((ClipboardManager) this.Wwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(str);
                    Toast.makeText(this.Wwwwwwwwwwwwwwwww, "已复制：" + str, 0).show();
                    if (z) {
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 0:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PLAY_X5");
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, this.Wwwwwwwwwwwwwwwww, str, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, this.Wwwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
                if (z) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case 1:
            case 7:
            default:
                if (z) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case 2:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_THIED_PLAYER");
                if (str.startsWith("http")) {
                    if (!z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, str);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 3:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PC_PLAYER");
                if (str.startsWith("http")) {
                    RecyclerView recyclerView = this.rvProgress;
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                    }
                    TextView textView = this.tvIp;
                    if (textView != null) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("播放地址：http://");
                        Activity activity = this.Wwwwwwwwwwwwwwwww;
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            if (activeNetworkInfo.getType() == 0) {
                                try {
                                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                                    while (networkInterfaces.hasMoreElements()) {
                                        Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                                        while (inetAddresses.hasMoreElements()) {
                                            InetAddress nextElement = inetAddresses.nextElement();
                                            if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                                                str2 = nextElement.getHostAddress();
                                            }
                                        }
                                    }
                                } catch (SocketException e) {
                                    e.printStackTrace();
                                }
                            } else if (activeNetworkInfo.getType() == 1) {
                                int ipAddress = ((WifiManager) activity.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo().getIpAddress();
                                str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                            } else if (activeNetworkInfo.getType() == 9) {
                                try {
                                    Enumeration<NetworkInterface> networkInterfaces2 = NetworkInterface.getNetworkInterfaces();
                                    while (networkInterfaces2.hasMoreElements()) {
                                        Enumeration<InetAddress> inetAddresses2 = networkInterfaces2.nextElement().getInetAddresses();
                                        while (inetAddresses2.hasMoreElements()) {
                                            InetAddress nextElement2 = inetAddresses2.nextElement();
                                            if (!nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                                                str2 = nextElement2.getHostAddress();
                                            }
                                        }
                                    }
                                } catch (SocketException unused) {
                                }
                                str2 = StringUtil.ALL_INTERFACES;
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                            Defaults.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(8598);
                            textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        }
                        str2 = null;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                        Defaults.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(8598);
                        textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                    LinearLayout linearLayout = this.llytPcPlay;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    this.llytQuickSniff.setVisibility(8);
                    String str4 = this.Wwwwwwwwwwwwwww + "-" + this.Wwwwwwwwwwwwww;
                    if (ur0.Wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        Defaults.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        ur0.Wwwwwwwwwwwwwwwwwwwwwwwwww = new ur0(8598);
                    }
                    ur0 ur0Var = ur0.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    ur0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = str4;
                    ur0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                    tr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ur0Var;
                    try {
                        if (tr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            return;
                        }
                        ur0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        tr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 4:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PLAY_KSY");
                if (str.startsWith("http")) {
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, str, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, this.Wwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
                } else {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, "播放地址格式错误");
                }
                if (z) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case 5:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_QQ_BROWSER");
                if (str.startsWith("http")) {
                    if (!z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, str);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 6:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_UC_BROWSER");
                if (str.startsWith("http")) {
                    if (!z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, str);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 8:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_WEBVIEW");
                ApplicationC1880C.Wwwwwwwwwwww.clear();
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, true);
                return;
            case 9:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_DLNA");
                if (str.startsWith("http")) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, str);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 10:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PLAY_FLOAT");
                if (str.startsWith("http")) {
                    if (!z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, str, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, false, (mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 11:
                str3 = "GO_DOWNLOAD";
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case 12:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_QQ_BROWSER_BROWSER");
                if (str.startsWith("http")) {
                    if (!z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, str);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
            case 13:
                str3 = "GO_PLAY_IN_CAST_ACTIVITY";
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case 14:
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_CAST");
                if (str.startsWith("http")) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, str);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                return;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.tvDialogTitle.setText(this.Wwwwwwwwww);
        ParsingAdapter parsingAdapter = this.Kkkkkkkkkkkkkkkkkkkkkk;
        if (parsingAdapter != null) {
            parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
            parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            parsingAdapter.notifyDataSetChanged();
        }
        Wwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            DialogParse dialogParse;
            nr0 nr0Var = DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkkk;
            if (nr0Var != null) {
                nr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkkk = null;
            }
            List<String> list = DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkk;
            if (list == null || list.isEmpty()) {
                dialogParse = DialogParse.this;
            } else if (DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkk.size() == 1) {
                DialogParse dialogParse2 = DialogParse.this;
                dialogParse2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, i, dialogParse2.Kkkkkkkkkkkkkkkkkkkkkkk.get(0));
                return;
            } else {
                dialogParse = DialogParse.this;
                ParsingAdapter parsingAdapter = dialogParse.Kkkkkkkkkkkkkkkkkkkkkk;
                if (parsingAdapter != null) {
                    List<String> list2 = dialogParse.Kkkkkkkkkkkkkkkkkkkkkkk;
                    parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                    if (list2 == null || list2.isEmpty()) {
                        parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                        List<String> list3 = parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        list3.add(parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwww + list2.size() + " 条，请分别点击链接校对后逐个尝试，【点我】查看校对规则");
                        parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list2);
                    }
                    parsingAdapter.notifyDataSetChanged();
                    DialogParse dialogParse3 = DialogParse.this;
                    dialogParse3.tvDialogTitle.setText(dialogParse3.Wwwwwww);
                    return;
                }
            }
            dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            nr0 nr0Var = DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkkk;
            if (nr0Var != null) {
                nr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                DialogParse.this.Kkkkkkkkkkkkkkkkkkkkkkkk = null;
            }
            DialogParse.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, i, str);
        }
    }
}
