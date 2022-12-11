package me.tvspark.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import me.tvspark.data.bean.LiveParcel;
import me.tvspark.sk0;
import me.tvspark.view.fragment.LiveContentFragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class LiveListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public boolean Wwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwwww;
    public List<LiveParcel> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public String Wwwwwwwwwwwwwwwwwwww = "";

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_webview)
        public ImageView ivWebview;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(LiveListAdapter liveListAdapter, View view) {
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
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.ivWebview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_webview, "field 'ivWebview'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.ivWebview = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel);
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ LiveParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = liveParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LiveListAdapter.this.Wwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((LiveContentFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLongClickListener {
        public final /* synthetic */ LiveParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = liveParcel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            LiveListAdapter liveListAdapter = LiveListAdapter.this;
            if (liveListAdapter.Wwwwwwwwwwwwwwwwwww || (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = liveListAdapter.Wwwwwwwwwwwwwwwwwwwww) == null) {
                return false;
            }
            ((LiveContentFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ LiveParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = liveParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LiveListAdapter.this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public LiveListAdapter(Activity activity, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwww = z;
    }

    public LiveListAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, List<LiveParcel> list) {
        this.Wwwwwwwwwwwwwwwwwwww = str;
        if (list != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        notifyDataSetChanged();
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<LiveParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        int i2;
        LiveParcel liveParcel = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(liveParcel.getChanelName());
        if (!this.Wwwwwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwwwwwwww.equals(liveParcel.getChanelName())) {
            viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.color.text_black));
            textView = viewHolder2.tvTitle;
            i2 = 0;
        } else {
            viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
            textView = viewHolder2.tvTitle;
            i2 = 1;
        }
        textView.setTypeface(Typeface.defaultFromStyle(i2));
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(liveParcel));
        viewHolder.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(liveParcel));
        ((ViewHolder) viewHolder).ivWebview.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(liveParcel));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from;
        int i2;
        if (this.Wwwwwwwwwwwwwwwwwww) {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = R.layout.item_live_list_left;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = R.layout.item_live_list_right;
        }
        return new ViewHolder(this, from.inflate(i2, viewGroup, false));
    }
}
