package me.tvspark.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.view.activity.TbsPlayerActivity;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.widget.decoration.SpacesItemDecoration;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogEpisodeX5 implements sk0 {
    public int Wwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwww;
    public LineListAdapter Wwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.iv_grid)
    public ImageView ivGrid;
    @BindView(R.id.rv_file)
    public RecyclerView rvFile;
    public List<EpisodeParcel> Wwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public boolean Wwwwwwwwwwwwwwww = true;

    /* loaded from: classes4.dex */
    public class LineListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* loaded from: classes4.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_episode)
            public TextView tvTitle;

            public ViewHolder(LineListAdapter lineListAdapter, View view) {
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

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
            public final /* synthetic */ EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EpisodeParcel episodeParcel) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogEpisodeX5 dialogEpisodeX5 = DialogEpisodeX5.this;
                if (dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwww != null) {
                    Dialog dialog = dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (dialog != null && dialog.isShowing()) {
                        dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DialogEpisodeX5.this.Wwwwwwwwwwwwwwwwwwww;
                    TbsPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsPlayerActivity.this, this.Wwwwwwwwwwwwwwwwwwwwwwww, ApplicationC1880C.Wwwwwwwwwwww.getChannelPlay());
                }
            }
        }

        public LineListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<EpisodeParcel> list = DialogEpisodeX5.this.Wwwwwwwwwwwwwwwwwwwww;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            TextView textView;
            int i2;
            EpisodeParcel episodeParcel = DialogEpisodeX5.this.Wwwwwwwwwwwwwwwwwwwww.get(i);
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.tvTitle.setText(episodeParcel.getCount());
            if (TextUtils.isEmpty(DialogEpisodeX5.this.Wwwwwwwwwwwwwwwwww) || !DialogEpisodeX5.this.Wwwwwwwwwwwwwwwwww.equals(episodeParcel.getLink())) {
                textView = viewHolder2.tvTitle;
                i2 = R.drawable.bg_episode_frame_nor_x5;
            } else {
                textView = viewHolder2.tvTitle;
                i2 = R.drawable.bg_episode_frame_sel_x5;
            }
            textView.setBackgroundResource(i2);
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeParcel));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_episode_x5, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public DialogEpisodeX5(Activity activity, String str, List<EpisodeParcel> list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int i = 0;
        this.Wwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_episode_x5, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(activity, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        if (list != null) {
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (list.get(i).getLink().equals(str)) {
                    this.Wwwwwwwwwwwwwwwww = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        LineListAdapter lineListAdapter = new LineListAdapter();
        this.Wwwwwwwwwwwwwwwwwww = lineListAdapter;
        this.rvFile.setAdapter(lineListAdapter);
        this.rvFile.scrollToPosition(this.Wwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        LinearLayoutManager linearLayoutManager;
        ImageView imageView = this.ivGrid;
        if (z) {
            imageView.setImageResource(R.drawable.ic_category_vertical_white);
            linearLayoutManager = new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwww, 7);
            this.rvFile.setNestedScrollingEnabled(false);
            try {
                this.rvFile.removeItemDecorationAt(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.rvFile.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15)));
        } else {
            imageView.setImageResource(R.drawable.ic_category_grid_white);
            linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwww);
            linearLayoutManager.setOrientation(1);
            this.rvFile.setNestedScrollingEnabled(false);
            try {
                this.rvFile.removeItemDecorationAt(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.rvFile.addItemDecoration(new SpacesItemDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15), 1));
        }
        this.rvFile.setLayoutManager(linearLayoutManager);
        this.Wwwwwwwwwwwwwwww = z;
    }

    @OnClick({R.id.iv_close, R.id.iv_grid, R.id.iv_sort})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_close) {
            Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
        } else if (id == R.id.iv_grid) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwww);
        } else if (id != R.id.iv_sort) {
        } else {
            LineListAdapter lineListAdapter = this.Wwwwwwwwwwwwwwwwwww;
            Collections.reverse(DialogEpisodeX5.this.Wwwwwwwwwwwwwwwwwwwww);
            lineListAdapter.notifyDataSetChanged();
        }
    }
}
