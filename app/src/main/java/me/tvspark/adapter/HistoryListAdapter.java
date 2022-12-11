package me.tvspark.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.sql.VideoHistoryData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.view.fragment.History1Fragment;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.yn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class HistoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public List<VideoHistoryData> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_gallery)
        public RoundImageView ivGallery;
        @BindView(R.id.tv_last_episode)
        public TextView tvLastEpisode;
        @BindView(R.id.tv_title)
        public TextView tvTitle;
        @BindView(R.id.tv_type)
        public TextView tvType;

        public ViewHolder(HistoryListAdapter historyListAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivGallery.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.ivGallery = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_gallery, "field 'ivGallery'", RoundImageView.class);
            viewHolder.tvLastEpisode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_last_episode, "field 'tvLastEpisode'", TextView.class);
            viewHolder.tvType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'tvType'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.ivGallery = null;
                viewHolder.tvLastEpisode = null;
                viewHolder.tvType = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLongClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ VideoHistoryData Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.adapter.HistoryListAdapter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC3466Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC3466Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getDetailUrl());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                HistoryListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
                HistoryListAdapter.this.notifyDataSetChanged();
                HistoryListAdapter historyListAdapter = HistoryListAdapter.this;
                if (historyListAdapter.Wwwwwwwwwwwwwwwwwwwwww == null || !historyListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    return;
                }
                History1Fragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(History1Fragment.this, true);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoHistoryData videoHistoryData, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = videoHistoryData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(HistoryListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww).setNegativeButton("取消", new DialogInterface$OnClickListenerC3466Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).setPositiveButton("删除", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("是否删除 ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" ？");
            positiveButton.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString()).show();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ VideoHistoryData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoHistoryData videoHistoryData) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = videoHistoryData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HistoryListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getDetailUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getCoverUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.isCustomWebSource());
        }
    }

    public HistoryListAdapter(Context context, List<VideoHistoryData> list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideoHistoryData> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        VideoHistoryData videoHistoryData = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(videoHistoryData.getTitle());
        TextView textView = viewHolder2.tvLastEpisode;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("上次观看到：");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(videoHistoryData.getLastEpisode());
        textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        TextView textView2 = viewHolder2.tvType;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[ ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(videoHistoryData.getSiteName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" ]");
        textView2.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoHistoryData));
        viewHolder.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoHistoryData, i));
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, videoHistoryData.getCoverUrl(), ((ViewHolder) viewHolder).ivGallery, videoHistoryData.getImgReferer());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_history_list, viewGroup, false));
    }
}
