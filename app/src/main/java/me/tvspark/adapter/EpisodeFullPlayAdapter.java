package me.tvspark.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.eo0;
import me.tvspark.outline;
import me.tvspark.utils.player.MyJzvdStd;
import white.whale.R;

/* loaded from: classes4.dex */
public class EpisodeFullPlayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<EpisodeParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_episode)
        public TextView tvEpisode;

        public ViewHolder(EpisodeFullPlayAdapter episodeFullPlayAdapter, View view) {
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
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvEpisode = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
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
            EpisodeFullPlayAdapter episodeFullPlayAdapter = EpisodeFullPlayAdapter.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public EpisodeFullPlayAdapter(Context context, List<EpisodeParcel> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<EpisodeParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null && !list.isEmpty()) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i - 1 >= 0) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i - 1).getCount();
            }
        }
        return "N/A";
    }

    public EpisodeFullPlayAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<EpisodeParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null && !list.isEmpty()) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i - 1 < 0) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "已经是最后一集了");
            } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                int i2 = i - 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                EpisodeParcel episodeParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
                ((MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeParcel, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                notifyDataSetChanged();
            }
        }
        return this;
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
        Context context;
        int i2;
        EpisodeParcel episodeParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        ((ViewHolder) viewHolder).tvEpisode.setText(episodeParcel.getCount());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeParcel, i));
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        TextView textView = ((ViewHolder) viewHolder).tvEpisode;
        if (i3 == i) {
            context = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i2 = R.color.colorPrimary;
        } else {
            context = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i2 = R.color.f5061white;
        }
        textView.setTextColor(ContextCompat.getColor(context, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_episode_full_player, viewGroup, false));
    }
}
