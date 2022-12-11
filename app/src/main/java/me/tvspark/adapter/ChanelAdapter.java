package me.tvspark.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import java.util.Collections;
import java.util.List;
import me.tvspark.data.bean.ChanelParcel;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.outline;
import white.whale.R;

/* loaded from: classes4.dex */
public class ChanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<ChanelParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.llyt_bg)
        public LinearLayout llytBg;
        @BindView(R.id.tv_chanel)
        public TextView tvChanel;

        public ViewHolder(ChanelAdapter chanelAdapter, View view) {
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
            viewHolder.tvChanel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chanel, "field 'tvChanel'", TextView.class);
            viewHolder.llytBg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_bg, "field 'llytBg'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvChanel = null;
                viewHolder.llytBg = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<EpisodeParcel> list, int i);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ ChanelParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ChanelParcel chanelParcel, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = chanelParcel;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ChanelAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getEpisodeList(), this.Wwwwwwwwwwwwwwwwwwwwwww);
                ChanelAdapter chanelAdapter = ChanelAdapter.this;
                chanelAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                chanelAdapter.notifyDataSetChanged();
            }
        }
    }

    public ChanelAdapter(Context context, List<ChanelParcel> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    public ChanelAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<ChanelParcel> list, int i) {
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        if (i < list.size()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
        notifyDataSetChanged();
        return this;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            Collections.reverse(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).getEpisodeList());
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ChanelParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        LinearLayout linearLayout;
        int i2;
        ChanelParcel chanelParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        ((ViewHolder) viewHolder).tvChanel.setText(chanelParcel.getChanel());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chanelParcel, i));
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
            viewHolder2.tvChanel.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.black));
            linearLayout = viewHolder2.llytBg;
            i2 = R.drawable.bg_channel_frame_sel;
        } else {
            viewHolder2.tvChanel.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.text_gray));
            linearLayout = viewHolder2.llytBg;
            i2 = R.drawable.bg_channel_frame_nor;
        }
        linearLayout.setBackgroundResource(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_chanel, viewGroup, false));
    }
}
