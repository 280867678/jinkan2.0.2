package me.tvspark.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.co0;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.outline;
import me.tvspark.qs0;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.view.activity.EditHomeMarkActivity;
import me.tvspark.widget.decoration.GridSpanDecoration;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogColorPicker implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public ColorAdapter Wwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_bg)
    public FrameLayout flytBg;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;

    /* loaded from: classes4.dex */
    public class ColorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
        public List<String> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_color)
            public TextView tvColor;

            public ViewHolder(ColorAdapter colorAdapter, View view) {
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
                viewHolder.tvColor = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_color, "field 'tvColor'", TextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (viewHolder != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    viewHolder.tvColor = null;
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
                ColorAdapter colorAdapter = ColorAdapter.this;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DialogColorPicker.this.Wwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    qs0 qs0Var = (qs0) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.setIconUrl("");
                    EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.setIconColor(colorAdapter.Wwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww));
                    if (TextUtils.isEmpty(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.getIconTxt())) {
                        HomeMarkData homeMarkData = EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww;
                        homeMarkData.setIconTxt(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", homeMarkData.getTitle()));
                    }
                    EditHomeMarkActivity editHomeMarkActivity = EditHomeMarkActivity.this;
                    editHomeMarkActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editHomeMarkActivity.Wwwwwwwwwwwwwwwwwww, false);
                }
                DialogColorPicker dialogColorPicker = DialogColorPicker.this;
                Dialog dialog = dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww;
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
            }
        }

        public ColorAdapter(Activity activity, List<String> list) {
            ArrayList arrayList = new ArrayList();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = arrayList;
            if (list != null) {
                arrayList.addAll(list);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((ViewHolder) viewHolder).tvColor.setBackgroundColor(Color.parseColor(this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i)));
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_dialog_color_picker, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public DialogColorPicker(Activity activity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_color_picker, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwww);
        this.rvContent.setLayoutManager(new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwwww, 4));
        this.rvContent.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10)));
        ColorAdapter colorAdapter = new ColorAdapter(this.Wwwwwwwwwwwwwwwwwwwwwwww, sk0.Wwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww = colorAdapter;
        this.rvContent.setAdapter(colorAdapter);
        this.flytBg.setVisibility(8);
    }
}
