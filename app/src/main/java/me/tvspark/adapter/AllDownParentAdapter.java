package me.tvspark.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.MyDownData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.view.activity.AllDownParentActivity;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.widget.ShangshabanChangeTextSpaceView;
import me.tvspark.wr0;
import white.whale.R;

/* loaded from: classes4.dex */
public class AllDownParentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<MyDownData> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover)
        public RoundImageView ivCover;
        @BindView(R.id.tv_size)
        public TextView tvSize;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(AllDownParentAdapter allDownParentAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivCover.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder0 extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover)
        public RoundImageView ivCover;
        @BindView(R.id.rlyt_content)
        public RelativeLayout rvContent;
        @BindView(R.id.tv_info)
        public ShangshabanChangeTextSpaceView tvInfo;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentAdapter allDownParentAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public ViewHolder0(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.rvContent.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentAdapter.this));
            this.ivCover.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
            this.tvInfo.setSpacing(4.0f);
            this.tvInfo.setTextSize(8.0f);
            this.tvInfo.setText("长按每一集可缓存");
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder0_ViewBinding implements Unbinder {
        public ViewHolder0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder0_ViewBinding(ViewHolder0 viewHolder0, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder0;
            viewHolder0.rvContent = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_content, "field 'rvContent'", RelativeLayout.class);
            viewHolder0.ivCover = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_cover, "field 'ivCover'", RoundImageView.class);
            viewHolder0.tvInfo = (ShangshabanChangeTextSpaceView) Utils.findRequiredViewAsType(view, R.id.tv_info, "field 'tvInfo'", ShangshabanChangeTextSpaceView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder0 viewHolder0 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder0 != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder0.rvContent = null;
                viewHolder0.ivCover = null;
                viewHolder0.tvInfo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.tvSize = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_size, "field 'tvSize'", TextView.class);
            viewHolder.ivCover = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_cover, "field 'ivCover'", RoundImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.tvSize = null;
                viewHolder.ivCover = null;
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
        public final /* synthetic */ MyDownData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MyDownData myDownData, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = myDownData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            BaseActivity baseActivity;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AllDownParentAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                MyDownData myDownData = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                AllDownParentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AllDownParentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                baseActivity = AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                AlertDialog.Builder builder = new AlertDialog.Builder(baseActivity);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("是否删除文件夹 ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(myDownData.getDirName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ？");
                AlertDialog create = builder.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()).setPositiveButton("删除", new wr0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, myDownData, this.Wwwwwwwwwwwwwwwwwwwwwww - 1)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
                create.setCanceledOnTouchOutside(true);
                create.show();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ MyDownData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MyDownData myDownData) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = myDownData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity baseActivity;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AllDownParentAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                MyDownData myDownData = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                baseActivity = AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, myDownData.getDirName(), myDownData.getChildList());
            }
        }
    }

    public AllDownParentAdapter(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<MyDownData> list, boolean z) {
        if (list != null) {
            if (!z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MyDownData> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MyDownData myDownData;
        if (getItemViewType(i) == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || (myDownData = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i - 1)) == null) {
            return;
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(myDownData.getDirName());
        TextView textView = viewHolder2.tvSize;
        textView.setText(myDownData.getChildFilesCount() + "个文件");
        viewHolder2.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(myDownData));
        viewHolder2.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(myDownData, i));
        if (TextUtils.isEmpty(myDownData.getCoverUrl())) {
            viewHolder2.ivCover.setBackgroundColor(Color.parseColor("#ffba42"));
        } else {
            vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, myDownData.getCoverUrl(), viewHolder2.ivCover, "");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? new ViewHolder0(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_all_down_parent_0, viewGroup, false)) : new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_all_down_parent, viewGroup, false));
    }
}
