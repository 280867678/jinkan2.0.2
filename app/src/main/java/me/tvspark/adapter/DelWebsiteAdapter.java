package me.tvspark.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import me.tvspark.as0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.view.activity.DelWebsiteActivity;
import me.tvspark.widget.dialog.DialogOperate;
import me.tvspark.xr0;
import me.tvspark.yr0;
import me.tvspark.zr0;
import white.whale.R;

/* loaded from: classes4.dex */
public class DelWebsiteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<WebSourceTitaData> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tagview_delete)
        public ImageView ivDel;
        @BindView(R.id.tagview_title)
        public TextView tvTitle;

        public ViewHolder(DelWebsiteAdapter delWebsiteAdapter, View view) {
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
            viewHolder.ivDel = (ImageView) Utils.findRequiredViewAsType(view, R.id.tagview_delete, "field 'ivDel'", ImageView.class);
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tagview_title, "field 'tvTitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.ivDel = null;
                viewHolder.tvTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLongClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceTitaData webSourceTitaData, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            BaseActivity baseActivity;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DelWebsiteAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                WebSourceTitaData webSourceTitaData = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    throw null;
                }
                baseActivity = DelWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                new DialogOperate(baseActivity, new String[]{"编辑此站源规则", "复制此自定义源"}, new Integer[]{Integer.valueOf((int) R.drawable.ic_web_source_edit_color), Integer.valueOf((int) R.drawable.ic_drawer_share)}, new View.OnClickListener[]{new zr0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, webSourceTitaData, i), new as0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, webSourceTitaData)}).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceTitaData webSourceTitaData, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity baseActivity;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DelWebsiteAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                WebSourceTitaData webSourceTitaData = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                baseActivity = DelWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(baseActivity).setNegativeButton("取消", new yr0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).setPositiveButton("删除", new xr0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, webSourceTitaData));
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("是否删除 ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webSourceTitaData.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ？");
                positiveButton.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()).show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceTitaData webSourceTitaData) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DelWebsiteAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public DelWebsiteAdapter(Context context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public DelWebsiteAdapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<WebSourceTitaData> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        notifyDataSetChanged();
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WebSourceTitaData> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        WebSourceTitaData webSourceTitaData = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        ((ViewHolder) viewHolder).tvTitle.setText(webSourceTitaData.getName());
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceTitaData));
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.ivDel.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceTitaData, i));
        viewHolder2.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceTitaData, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.view_del_website_item, viewGroup, false));
    }
}
