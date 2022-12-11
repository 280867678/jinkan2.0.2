package me.tvspark.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.tvspark.outline;
import me.tvspark.sk0;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogOperate implements sk0 {
    public boolean Wwwwwwwwwwwwwwwww;
    public View.OnClickListener[] Wwwwwwwwwwwwwwwwww;
    public Integer[] Wwwwwwwwwwwwwwwwwww;
    public String[] Wwwwwwwwwwwwwwwwwwww;
    public AtyAdapter Wwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.recycler_view)
    public RecyclerView recycler;

    /* loaded from: classes4.dex */
    public class AtyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* loaded from: classes4.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.iv_icon)
            public ImageView ivIcon;
            @BindView(R.id.tv_title)
            public TextView tvTitle;
            @BindView(R.id.view_line)
            public View viewLine;

            public ViewHolder(AtyAdapter atyAdapter, View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        /* loaded from: classes4.dex */
        public class ViewHolder_ViewBinding implements Unbinder {
            public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
                viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
                viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
                viewHolder.viewLine = Utils.findRequiredView(view, R.id.view_line, "field 'viewLine'");
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (viewHolder != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    viewHolder.ivIcon = null;
                    viewHolder.tvTitle = null;
                    viewHolder.viewLine = null;
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
                View.OnClickListener[] onClickListenerArr = DialogOperate.this.Wwwwwwwwwwwwwwwwww;
                if (onClickListenerArr != null) {
                    int length = onClickListenerArr.length;
                    int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (length > i) {
                        onClickListenerArr[i].onClick(view);
                    }
                }
                DialogOperate dialogOperate = DialogOperate.this;
                Dialog dialog = dialogOperate.Wwwwwwwwwwwwwwwwwwwwwww;
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                dialogOperate.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
            }
        }

        public AtyAdapter(Activity activity) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DialogOperate.this.Wwwwwwwwwwwwwwwwwwww.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (DialogOperate.this.Wwwwwwwwwwwwwwwww) {
                ViewHolder viewHolder2 = (ViewHolder) viewHolder;
                viewHolder2.ivIcon.setVisibility(0);
                viewHolder2.ivIcon.setImageResource(DialogOperate.this.Wwwwwwwwwwwwwwwwwww[i].intValue());
            } else {
                ((ViewHolder) viewHolder).ivIcon.setVisibility(8);
            }
            ViewHolder viewHolder3 = (ViewHolder) viewHolder;
            viewHolder3.tvTitle.setText(DialogOperate.this.Wwwwwwwwwwwwwwwwwwww[i]);
            int length = DialogOperate.this.Wwwwwwwwwwwwwwwwwwww.length - 1;
            View view = viewHolder3.viewLine;
            if (i == length) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_dialog_ope_source, viewGroup, false));
        }
    }

    public DialogOperate(Activity activity, String[] strArr, Integer[] numArr, View.OnClickListener[] onClickListenerArr) {
        this.Wwwwwwwwwwwwwwwwwwww = new String[0];
        this.Wwwwwwwwwwwwwwwwwww = new Integer[0];
        this.Wwwwwwwwwwwwwwwwww = new View.OnClickListener[0];
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwww = strArr;
        this.Wwwwwwwwwwwwwwwwwww = numArr;
        this.Wwwwwwwwwwwwwwwwww = onClickListenerArr;
        if (numArr == null || numArr.length > strArr.length) {
            this.Wwwwwwwwwwwwwwwww = false;
        } else {
            this.Wwwwwwwwwwwwwwwww = true;
        }
        View inflate = LayoutInflater.from(this.Wwwwwwwwwwwwwwwwwwwwww).inflate(R.layout.dialog_ope_source, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(this.Wwwwwwwwwwwwwwwwwwwwww, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager.setOrientation(1);
        this.recycler.setLayoutManager(linearLayoutManager);
        AtyAdapter atyAdapter = new AtyAdapter(this.Wwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww = atyAdapter;
        this.recycler.setAdapter(atyAdapter);
    }

    public DialogOperate Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
            this.Wwwwwwwwwwwwwwwwwwwwwww.show();
            Window window = this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww) * 0.7d);
            window.setAttributes(attributes);
            window.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
        }
        return this;
    }
}
