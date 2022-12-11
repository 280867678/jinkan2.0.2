package me.tvspark.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
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
import me.tvspark.data.sql.VideoCollectData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.view.fragment.CollectedFragment;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.yn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class CollectListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public List<VideoCollectData> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_gallery)
        public RoundImageView ivGallery;
        @BindView(R.id.tv_desc)
        public TextView tvDesc;
        @BindView(R.id.tv_title)
        public TextView tvTitle;
        @BindView(R.id.tv_type)
        public TextView tvType;

        public ViewHolder(CollectListAdapter collectListAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivGallery.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
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
            viewHolder.tvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tvDesc'", TextView.class);
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
                viewHolder.tvDesc = null;
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
        public final /* synthetic */ VideoCollectData Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.adapter.CollectListAdapter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC3465Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC3465Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
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
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                CollectListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
                CollectListAdapter.this.notifyDataSetChanged();
                CollectListAdapter collectListAdapter = CollectListAdapter.this;
                if (collectListAdapter.Wwwwwwwwwwwwwwwwwwwwww == null || !collectListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    return;
                }
                CollectedFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CollectedFragment.this, true);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoCollectData videoCollectData, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = videoCollectData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(CollectListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww).setNegativeButton("取消", new DialogInterface$OnClickListenerC3465Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).setPositiveButton("删除", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("是否删除 ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" ？");
            positiveButton.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString()).show();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ VideoCollectData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoCollectData videoCollectData) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = videoCollectData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CollectListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getCoverUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.isCustomWebSource());
        }
    }

    public CollectListAdapter(Context context, List<VideoCollectData> list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
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
        List<VideoCollectData> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        String desc;
        VideoCollectData videoCollectData = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(videoCollectData.getTitle());
        if (TextUtils.isEmpty(videoCollectData.getDesc())) {
            textView = viewHolder2.tvDesc;
            desc = "暂无简介";
        } else {
            textView = viewHolder2.tvDesc;
            desc = videoCollectData.getDesc();
        }
        textView.setText(desc);
        viewHolder2.tvType.setText(videoCollectData.getSiteName());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoCollectData));
        viewHolder.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoCollectData, i));
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, videoCollectData.getCoverUrl(), ((ViewHolder) viewHolder).ivGallery, videoCollectData.getImgReferer());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_collect_list, viewGroup, false));
    }
}
