package me.tvspark.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.bo0;
import me.tvspark.co0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.ds0;
import me.tvspark.view.activity.DetailActivity;
import white.whale.R;

/* loaded from: classes4.dex */
public class EpisodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<EpisodeParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_playing)
        public ImageView ivPlaying;
        @BindView(R.id.rlyt_item)
        public RelativeLayout rlytItem;
        @BindView(R.id.tv_episode)
        public TextView tvEpisode;

        public ViewHolder(EpisodeAdapter episodeAdapter, View view) {
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
            viewHolder.tvEpisode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_episode, "field 'tvEpisode'", TextView.class);
            viewHolder.ivPlaying = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_playing, "field 'ivPlaying'", ImageView.class);
            viewHolder.rlytItem = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_item, "field 'rlytItem'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvEpisode = null;
                viewHolder.ivPlaying = null;
                viewHolder.rlytItem = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLongClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EpisodeParcel episodeParcel, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            BaseActivity baseActivity;
            EpisodeAdapter episodeAdapter = EpisodeAdapter.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                EpisodeParcel episodeParcel = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                List<EpisodeParcel> list = episodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i = episodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                baseActivity = DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity);
                builder.setTitle(episodeParcel.getCount());
                builder.setItems(new String[]{"※ 缓存下载本集", "※ 复制播放链接", "※ 电脑浏览器播放", "※ 第三方播放器", "※ UC浏览器播放", "※ QQ浏览器播放", "※ QQ浏览器去下载", "※ 极速 (X5) 播放", "※ 云播投屏播放", "※ DLNA投屏播放"}, new ds0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, episodeParcel, list));
                builder.setCancelable(true);
                builder.create().show();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EpisodeParcel episodeParcel, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EpisodeAdapter episodeAdapter;
            EpisodeAdapter episodeAdapter2 = EpisodeAdapter.this;
            if (episodeAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                episodeAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.getCount();
                EpisodeAdapter episodeAdapter3 = EpisodeAdapter.this;
                int i = episodeAdapter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                episodeAdapter3.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeAdapter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                EpisodeParcel episodeParcel = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                List<EpisodeParcel> list = episodeAdapter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                boolean z = episodeAdapter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                DetailActivity detailActivity = DetailActivity.this;
                if (!z ? (episodeAdapter = detailActivity.Wwwwwwwwwwwwwww) != null : (episodeAdapter = detailActivity.Wwwwwwwwwwwwwwww) != null) {
                    episodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    episodeAdapter.notifyDataSetChanged();
                }
                DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity.this, true, false, list, i, episodeParcel);
                EpisodeAdapter.this.notifyDataSetChanged();
            }
        }
    }

    public EpisodeAdapter(Activity activity, List<EpisodeParcel> list, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
        if (!bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("auto_play_activity", true)) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0).getCount();
    }

    public EpisodeAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<EpisodeParcel> list, int i) {
        if (list == null || list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        } else {
            if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("auto_play_activity", true) && TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(0).getCount();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        notifyDataSetChanged();
        return this;
    }

    public EpisodeAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<EpisodeParcel> list, int i, String str) {
        if (list == null || list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        } else {
            if (!TextUtils.isEmpty(str)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            }
            if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("auto_play_activity", true) && TextUtils.isEmpty(str)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(0).getCount();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        notifyDataSetChanged();
        return this;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Collections.reverse(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<EpisodeParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RelativeLayout relativeLayout;
        int i2;
        EpisodeParcel episodeParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        ((ViewHolder) viewHolder).tvEpisode.setText(episodeParcel.getCount());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeParcel, i));
        viewHolder.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeParcel, i));
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwwwwwwww || TextUtils.isEmpty(episodeParcel.getCount()) || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(episodeParcel.getCount())) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.ivPlaying.setVisibility(8);
            viewHolder2.tvEpisode.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.eoisode_player_nor));
            relativeLayout = viewHolder2.rlytItem;
            i2 = R.drawable.bg_episode_frame_nor;
        } else {
            ViewHolder viewHolder3 = (ViewHolder) viewHolder;
            viewHolder3.ivPlaying.setVisibility(0);
            viewHolder3.tvEpisode.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.eoisode_player_sel));
            relativeLayout = viewHolder3.rlytItem;
            i2 = R.drawable.bg_episode_frame_sel;
        }
        relativeLayout.setBackgroundResource(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from;
        int i2;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = R.layout.item_episode_all;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = R.layout.item_episode;
        }
        return new ViewHolder(this, from.inflate(i2, viewGroup, false));
    }
}
