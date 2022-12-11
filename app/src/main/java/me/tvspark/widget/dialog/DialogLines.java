package me.tvspark.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bo0;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.hu0;
import me.tvspark.jl0;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.sk0;
import me.tvspark.xt0;
import me.tvspark.yn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogLines implements sk0 {
    public xt0 Wwwwwwwwwwwwwwwww;
    public LineListAdapter Wwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.llyt_change_conf_url)
    public LinearLayout llytChangeConfUrl;
    @BindView(R.id.rv_file)
    public RecyclerView rvFile;
    @BindView(R.id.tv_ok)
    public TextView tvOk;
    public List<GenreParcel> Wwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class LineListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* loaded from: classes4.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.iv_check)
            public ImageView ivCheck;
            @BindView(R.id.tv_del)
            public TextView tvDel;
            @BindView(R.id.tv_title)
            public TextView tvTitle;
            @BindView(R.id.tv_url)
            public TextView tvUrl;
            @BindView(R.id.iv_line)
            public ImageView viewLine;

            public ViewHolder(LineListAdapter lineListAdapter, View view) {
                super(view);
                ButterKnife.bind(this, view);
                this.viewLine.setLayerType(1, null);
            }
        }

        /* loaded from: classes4.dex */
        public class ViewHolder_ViewBinding implements Unbinder {
            public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
                viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
                viewHolder.ivCheck = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_check, "field 'ivCheck'", ImageView.class);
                viewHolder.viewLine = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_line, "field 'viewLine'", ImageView.class);
                viewHolder.tvUrl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_url, "field 'tvUrl'", TextView.class);
                viewHolder.tvDel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_del, "field 'tvDel'", TextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (viewHolder != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    viewHolder.tvTitle = null;
                    viewHolder.ivCheck = null;
                    viewHolder.viewLine = null;
                    viewHolder.tvUrl = null;
                    viewHolder.tvDel = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TextView textView;
                Activity activity;
                int i;
                if (DialogLines.this.Wwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww).isAppLine()) {
                    DialogLines dialogLines = DialogLines.this;
                    dialogLines.Wwwwwwwwwwwwwwwwwwww = -1;
                    dialogLines.tvOk.setText("当前");
                    DialogLines dialogLines2 = DialogLines.this;
                    textView = dialogLines2.tvOk;
                    activity = dialogLines2.Wwwwwwwwwwwwwwwwwwwwww;
                    i = R.color.text_black;
                } else {
                    DialogLines dialogLines3 = DialogLines.this;
                    dialogLines3.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    dialogLines3.tvOk.setText("切换");
                    DialogLines dialogLines4 = DialogLines.this;
                    textView = dialogLines4.tvOk;
                    activity = dialogLines4.Wwwwwwwwwwwwwwwwwwwwww;
                    i = R.color.colorPrimary;
                }
                textView.setTextColor(ContextCompat.getColor(activity, i));
                LineListAdapter.this.notifyDataSetChanged();
            }
        }

        public LineListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<GenreParcel> list = DialogLines.this.Wwwwwwwwwwwwwwwwwwwww;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
            if (r8 == r3) goto L6;
         */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            TextView textView;
            GenreParcel genreParcel = DialogLines.this.Wwwwwwwwwwwwwwwwwwwww.get(i);
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.tvTitle.setText(genreParcel.getName());
            viewHolder2.tvUrl.setText(genreParcel.getLink());
            DialogLines dialogLines = DialogLines.this;
            int i2 = dialogLines.Wwwwwwwwwwwwwwwwwwww;
            if (i2 != -1) {
                textView = viewHolder2.tvTitle;
            } else if (genreParcel.isAppLine()) {
                textView = viewHolder2.tvTitle;
                dialogLines = DialogLines.this;
                textView.setTextColor(ContextCompat.getColor(dialogLines.Wwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
                viewHolder2.ivCheck.setVisibility(0);
            } else {
                textView = viewHolder2.tvTitle;
                dialogLines = DialogLines.this;
                textView.setTextColor(ContextCompat.getColor(dialogLines.Wwwwwwwwwwwwwwwwwwwwww, R.color.text_black));
                viewHolder2.ivCheck.setVisibility(8);
            }
            viewHolder2.tvDel.setVisibility(8);
            viewHolder2.viewLine.setVisibility(8);
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_line_list, viewGroup, false));
        }
    }

    public DialogLines(Activity activity) {
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_lines, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(activity, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(1);
        this.rvFile.setLayoutManager(linearLayoutManager);
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new hu0(this));
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "8091823043098355";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, DialogLines.class.getSimpleName());
            this.flytBanner.removeAllViews();
            this.flytBanner.addView(this.Wwwwwwwwwwwwwwwww);
        }
    }

    @OnClick({R.id.tv_ok, R.id.tv_cancel, R.id.tv_change_conf_url})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
        } else if (id == R.id.tv_change_conf_url) {
            jl0.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            jl0.Wwwwwwwwwwwwwwwwwwwwwww = false;
            jl0.Wwwwwwwwwwwwwwwwwwwwww = false;
            jl0.Wwwwwwwwwwwwwwwwwwwww = false;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
            return;
        } else if (id != R.id.tv_ok) {
            return;
        } else {
            int i = this.Wwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                Dialog dialog2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (dialog2 == null || !dialog2.isShowing()) {
                    return;
                }
            } else if (this.Wwwwwwwwwwwwwwwwwwwww.get(i).getAppVer() > 302) {
                Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwww, "此网站只适配最新版APP，请更新APP！", 1).show();
                return;
            } else {
                int i2 = this.Wwwwwwwwwwwwwwwwwwww;
                if (i2 == -1) {
                    i2 = 0;
                }
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
                jl0.Wwwwwwwwwwwwwwwwwwwwwwww = false;
                jl0.Wwwwwwwwwwwwwwwwwwwwwww = false;
                jl0.Wwwwwwwwwwwwwwwwwwwwww = false;
                jl0.Wwwwwwwwwwwwwwwwwwwww = false;
                String link = this.Wwwwwwwwwwwwwwwwwwwww.get(i2).getLink();
                ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwww = link;
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cur_url_index", link);
                Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwww, "网站列表重置中", 1).show();
                mn0.Wwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
                return;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }
}
