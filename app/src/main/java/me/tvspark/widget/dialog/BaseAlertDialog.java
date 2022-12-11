package me.tvspark.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.au0;
import me.tvspark.bu0;
import me.tvspark.co0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.nn0;
import me.tvspark.outline;
import me.tvspark.qs0;
import me.tvspark.rs0;
import me.tvspark.sk0;
import me.tvspark.sn0;
import me.tvspark.view.activity.EditHomeMarkActivity;
import white.whale.R;

/* loaded from: classes4.dex */
public class BaseAlertDialog implements sk0 {
    public View Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_bg)
    public FrameLayout flytBg;
    @BindView(R.id.flyt_view)
    public FrameLayout flytView;
    @BindView(R.id.list_view)
    public RecyclerView listView;
    @BindView(R.id.tv_cancel)
    public TextView tvCancel;
    @BindView(R.id.tv_msg)
    public TextView tvMsg;
    @BindView(R.id.tv_ok)
    public TextView tvOk;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    public boolean Wwwwwwwwwwwwwwwwwwwww = true;
    public boolean Wwwwwwwwwwwwwwwwwwww = true;
    public boolean Wwwwwwwwwwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public class DialogListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public ViewHolder(DialogListAdapter dialogListAdapter, View view) {
                super(view);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (TextView) view.findViewById(R.id.tv_msg);
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
            public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwwww = str;
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
                if (r0.equals("https://m.v.qq.com") != false) goto L17;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                BaseActivity baseActivity;
                BaseActivity baseActivity2;
                String title;
                HomeMarkData homeMarkData;
                String str;
                BaseAlertDialog.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DialogListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    EditHomeMarkActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (EditHomeMarkActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i == 0) {
                        baseActivity = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        DialogColorPicker dialogColorPicker = new DialogColorPicker(baseActivity, new qs0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        if (dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                            return;
                        }
                        dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
                        dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
                        dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.show();
                        Window window = dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
                        window.setContentView(dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwww);
                        int dimensionPixelSize = dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelSize(R.dimen.dialog_max_size);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwwww) - (dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelSize(R.dimen.dialog_padding) * 2);
                        if (dimensionPixelSize > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            dimensionPixelSize = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        window.setLayout(dimensionPixelSize, -2);
                        dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
                        dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
                        return;
                    }
                    char c = 0;
                    if (i != 1) {
                        if (i != 2) {
                            return;
                        }
                        EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.setIconColor(nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        HomeMarkData homeMarkData2 = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww;
                        homeMarkData2.setIconTxt(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", homeMarkData2.getTitle()));
                        String url = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.getUrl();
                        int hashCode = url.hashCode();
                        if (hashCode != 1805723) {
                            if (hashCode != 359092916) {
                                if (hashCode == 707437014 && url.equals("https://www.youku.com")) {
                                    c = 1;
                                }
                                c = 65535;
                            } else {
                                if (url.equals("https://m.iqiyi.com")) {
                                    c = 2;
                                }
                                c = 65535;
                            }
                        }
                        EditHomeMarkActivity editHomeMarkActivity = EditHomeMarkActivity.this;
                        if (c == 0) {
                            homeMarkData = editHomeMarkActivity.Wwwwwwwwwwwwwwwwwww;
                            str = "file:///android_asset/nav_site_qq.png";
                        } else if (c == 1) {
                            homeMarkData = editHomeMarkActivity.Wwwwwwwwwwwwwwwwwww;
                            str = "file:///android_asset/nav_site_youku.png";
                        } else if (c != 2) {
                            homeMarkData = editHomeMarkActivity.Wwwwwwwwwwwwwwwwwww;
                            String url2 = homeMarkData.getUrl();
                            str = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url2) + "/favicon.ico";
                        } else {
                            homeMarkData = editHomeMarkActivity.Wwwwwwwwwwwwwwwwwww;
                            str = "file:///android_asset/nav_site_iqiyi.png";
                        }
                        homeMarkData.setIconUrl(str);
                        EditHomeMarkActivity editHomeMarkActivity2 = EditHomeMarkActivity.this;
                        editHomeMarkActivity2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editHomeMarkActivity2.Wwwwwwwwwwwwwwwwwww, true);
                        return;
                    }
                    baseActivity2 = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    EditText editText = new EditText(baseActivity2);
                    editText.setSingleLine();
                    if (!TextUtils.isEmpty(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.getIconTxt())) {
                        title = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.getIconTxt().replace("\n", "");
                    } else {
                        if (!TextUtils.isEmpty(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.getTitle())) {
                            title = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.getTitle();
                        }
                        BaseAlertDialog baseAlertDialog = new BaseAlertDialog(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                        baseAlertDialog.tvTitle.setVisibility(0);
                        baseAlertDialog.tvTitle.setText("设置文字");
                        baseAlertDialog.flytView.setVisibility(0);
                        baseAlertDialog.tvMsg.setVisibility(8);
                        baseAlertDialog.flytView.removeAllViews();
                        baseAlertDialog.flytView.addView(editText);
                        baseAlertDialog.tvCancel.setVisibility(0);
                        baseAlertDialog.tvCancel.setText("取消");
                        baseAlertDialog.tvCancel.setOnClickListener(new bu0(baseAlertDialog, null));
                        rs0 rs0Var = new rs0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, editText);
                        baseAlertDialog.tvOk.setVisibility(0);
                        baseAlertDialog.tvOk.setText("确定");
                        baseAlertDialog.tvOk.setOnClickListener(new au0(baseAlertDialog, rs0Var));
                        baseAlertDialog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    editText.setText(title);
                    BaseAlertDialog baseAlertDialog2 = new BaseAlertDialog(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    baseAlertDialog2.tvTitle.setVisibility(0);
                    baseAlertDialog2.tvTitle.setText("设置文字");
                    baseAlertDialog2.flytView.setVisibility(0);
                    baseAlertDialog2.tvMsg.setVisibility(8);
                    baseAlertDialog2.flytView.removeAllViews();
                    baseAlertDialog2.flytView.addView(editText);
                    baseAlertDialog2.tvCancel.setVisibility(0);
                    baseAlertDialog2.tvCancel.setText("取消");
                    baseAlertDialog2.tvCancel.setOnClickListener(new bu0(baseAlertDialog2, null));
                    rs0 rs0Var2 = new rs0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, editText);
                    baseAlertDialog2.tvOk.setVisibility(0);
                    baseAlertDialog2.tvOk.setText("确定");
                    baseAlertDialog2.tvOk.setOnClickListener(new au0(baseAlertDialog2, rs0Var2));
                    baseAlertDialog2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }

        public DialogListAdapter(List<String> list) {
            ArrayList arrayList = new ArrayList();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
            arrayList.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            ((ViewHolder) viewHolder).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setText(str);
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_base_alert_dialog_list, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public BaseAlertDialog(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.base_alert_dialog, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwww);
        this.tvTitle.setVisibility(8);
        this.tvOk.setVisibility(8);
        this.tvOk.setText("确定");
        this.tvCancel.setVisibility(8);
        this.tvCancel.setText("取消");
        this.flytBg.setVisibility(8);
    }

    public BaseAlertDialog Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(this.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(this.Wwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.show();
            Window window = this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
            window.setWindowAnimations(R.style.DialogStyleNo);
            window.setContentView(this.Wwwwwwwwwwwwwwwwwwwwww);
            int dimensionPixelSize = this.Wwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelSize(R.dimen.dialog_max_size);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = sn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww) - (this.Wwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelSize(R.dimen.dialog_padding) * 2);
            if (dimensionPixelSize > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                dimensionPixelSize = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            window.setLayout(dimensionPixelSize, -2);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
        }
        return this;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog;
        if (this.Wwwwwwwwwwwwwwwwwww || (dialog = this.Wwwwwwwwwwwwwwwwwwwwwww) == null || !dialog.isShowing()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }
}
