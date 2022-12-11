package me.tvspark.utils.cast.p050ui;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bo0;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.widget.decoration.SpacesItemDecoration;
import me.tvspark.xt0;
import white.whale.R;

/* renamed from: me.tvspark.utils.cast.ui.DialogEpisode */
/* loaded from: classes4.dex */
public class DialogEpisode implements sk0 {
    public int Wwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwww;
    public LineListAdapter Wwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public List<EpisodeParcel> Wwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.rv_file)
    public RecyclerView rvFile;

    /* renamed from: me.tvspark.utils.cast.ui.DialogEpisode$LineListAdapter */
    /* loaded from: classes4.dex */
    public class LineListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: me.tvspark.utils.cast.ui.DialogEpisode$LineListAdapter$ViewHolder */
        /* loaded from: classes4.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_episode)
            public TextView tvTitle;

            public ViewHolder(LineListAdapter lineListAdapter, View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        /* renamed from: me.tvspark.utils.cast.ui.DialogEpisode$LineListAdapter$ViewHolder_ViewBinding */
        /* loaded from: classes4.dex */
        public class ViewHolder_ViewBinding implements Unbinder {
            public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
                viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_episode, "field 'tvTitle'", TextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (viewHolder != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    viewHolder.tvTitle = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        /* renamed from: me.tvspark.utils.cast.ui.DialogEpisode$LineListAdapter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
            public final /* synthetic */ EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EpisodeParcel episodeParcel) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogEpisode dialogEpisode = DialogEpisode.this;
                if (dialogEpisode.Wwwwwwwwwwwwwwwwwwww != null) {
                    Dialog dialog = dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (dialog != null && dialog.isShowing()) {
                        dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DialogEpisode.this.Wwwwwwwwwwwwwwwwwwww;
                    CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this, this.Wwwwwwwwwwwwwwwwwwwwwwww, ApplicationC1880C.Wwwwwwwwwww.getChannelPlay());
                }
            }
        }

        public LineListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<EpisodeParcel> list = DialogEpisode.this.Wwwwwwwwwwwwwwwwwwwww;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            TextView textView;
            int i2;
            EpisodeParcel episodeParcel = DialogEpisode.this.Wwwwwwwwwwwwwwwwwwwww.get(i);
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.tvTitle.setText(episodeParcel.getCount());
            if (!TextUtils.isEmpty(DialogEpisode.this.Wwwwwwwwwwwwwwwww) && DialogEpisode.this.Wwwwwwwwwwwwwwwww.equals(episodeParcel.getLink())) {
                viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(DialogEpisode.this.Wwwwwwwwwwwwwwwwwwwwww, R.color.green));
                textView = viewHolder2.tvTitle;
                i2 = R.drawable.bg_episode_frame_sel;
            } else {
                viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(DialogEpisode.this.Wwwwwwwwwwwwwwwwwwwwww, R.color.text_gray5));
                textView = viewHolder2.tvTitle;
                i2 = R.drawable.bg_episode_frame_nor;
            }
            textView.setBackgroundResource(i2);
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeParcel));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_episode_dialog, viewGroup, false));
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.DialogEpisode$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public DialogEpisode(Activity activity, String str, List<EpisodeParcel> list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_episode, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(activity, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        if (list != null) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (list.get(i).getLink().equals(str)) {
                    this.Wwwwwwwwwwwwwwww = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(1);
        this.rvFile.hasFixedSize();
        this.rvFile.addItemDecoration(new SpacesItemDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 1));
        this.rvFile.setLayoutManager(linearLayoutManager);
        LineListAdapter lineListAdapter = new LineListAdapter();
        this.Wwwwwwwwwwwwwwwwwww = lineListAdapter;
        this.rvFile.setAdapter(lineListAdapter);
        this.rvFile.scrollToPosition(this.Wwwwwwwwwwwwwwww);
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "8091823043098355";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, DialogEpisode.class.getSimpleName());
            this.flytBanner.removeAllViews();
            this.flytBanner.addView(this.Wwwwwwwwwwwwwwwwww);
        }
    }
}
