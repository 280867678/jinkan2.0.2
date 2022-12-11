package me.tvspark.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.VideoIndexParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.view.fragment.VideoIndexFragment;
import me.tvspark.widget.decoration.GridSpanDecoration;
import white.whale.R;

/* loaded from: classes4.dex */
public class VideoIndexListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public WebSourceIndexData Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Map<Integer, VideoIndexOtherAdapter> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<VideoIndexParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        public ImageView ivIcon;
        @BindView(R.id.rv_content)
        public RecyclerView rvContent;
        @BindView(R.id.tv_title)
        public TextView tvTitle;
        @BindView(R.id.tv_web_name)
        public TextView tvWebName;
        @BindView(R.id.view_line)
        public View viewLine;

        public ViewHolder(VideoIndexListAdapter videoIndexListAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.rvContent.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6)));
            this.rvContent.setNestedScrollingEnabled(false);
            this.rvContent.setLayoutManager(new GridLayoutManager(videoIndexListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 3));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
            viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
            viewHolder.viewLine = Utils.findRequiredView(view, R.id.view_line, "field 'viewLine'");
            viewHolder.tvWebName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_web_name, "field 'tvWebName'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.rvContent = null;
                viewHolder.ivIcon = null;
                viewHolder.viewLine = null;
                viewHolder.tvWebName = null;
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
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity baseActivity;
            VideoIndexFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (VideoIndexFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) VideoIndexListAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            baseActivity = VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) baseActivity, VideoIndexFragment.this.Wwwwwwwwwwww.getWebSourceBaseUrl(), false);
        }
    }

    public VideoIndexListAdapter(Context context, List<VideoIndexParcel> list) {
        HashMap hashMap = new HashMap();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        hashMap.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    public VideoIndexListAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<VideoIndexParcel> list) {
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
            notifyDataSetChanged();
        }
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideoIndexParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        VideoIndexOtherAdapter videoIndexOtherAdapter;
        VideoIndexParcel videoIndexParcel = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(Integer.valueOf(i))) {
            videoIndexOtherAdapter = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(Integer.valueOf(i));
        } else {
            videoIndexOtherAdapter = new VideoIndexOtherAdapter(videoIndexParcel.getVideoList(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Integer.valueOf(i), videoIndexOtherAdapter);
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2.rvContent.getAdapter() == null) {
            viewHolder2.rvContent.setAdapter(videoIndexOtherAdapter);
            viewHolder2.rvContent.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3)));
        }
        viewHolder2.tvTitle.setText(videoIndexParcel.getColumnTitle());
        if (videoIndexParcel.getMoreIcon() != 0) {
            viewHolder2.ivIcon.setBackgroundResource(videoIndexParcel.getMoreIcon());
        }
        if (i + 1 == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
            viewHolder2.viewLine.setVisibility(0);
        } else {
            viewHolder2.viewLine.setVisibility(8);
        }
        if (i == 0) {
            viewHolder2.tvWebName.setVisibility(0);
            TextView textView = viewHolder2.tvWebName;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[ ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" ]");
            textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        } else {
            viewHolder2.tvWebName.setVisibility(8);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            viewHolder2.tvWebName.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_index_list, viewGroup, false));
    }
}
