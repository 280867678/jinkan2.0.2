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
import me.tvspark.data.sql.WebHistoryData;
import me.tvspark.do0;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.sk0;
import me.tvspark.view.fragment.History2Fragment;
import me.tvspark.yn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class HistoryListWebAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public List<WebHistoryData> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        public TextView tvTime;
        @BindView(R.id.tv_title)
        public TextView tvTitle;
        @BindView(R.id.tv_url)
        public TextView tvUrl;

        public ViewHolder(HistoryListWebAdapter historyListWebAdapter, View view) {
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
            viewHolder.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
            viewHolder.tvUrl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_url, "field 'tvUrl'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.tvTime = null;
                viewHolder.tvUrl = null;
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
        public final /* synthetic */ WebHistoryData Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getSiteUrl());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                HistoryListWebAdapter.this.Wwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
                HistoryListWebAdapter.this.notifyDataSetChanged();
                HistoryListWebAdapter historyListWebAdapter = HistoryListWebAdapter.this;
                if (historyListWebAdapter.Wwwwwwwwwwwwwwwwwwwwww == null || !historyListWebAdapter.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    return;
                }
                History2Fragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(History2Fragment.this, true);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebHistoryData webHistoryData, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webHistoryData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(HistoryListWebAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("删除", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("是否删除 ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getSiteName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" ？");
            positiveButton.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString()).show();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ WebHistoryData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebHistoryData webHistoryData) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webHistoryData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HistoryListWebAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getSiteUrl(), true);
        }
    }

    public HistoryListWebAdapter(Context context, List<WebHistoryData> list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WebHistoryData> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        String siteName;
        WebHistoryData webHistoryData = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i);
        if (TextUtils.isEmpty(webHistoryData.getSiteName())) {
            textView = ((ViewHolder) viewHolder).tvTitle;
            siteName = "N/A";
        } else {
            textView = ((ViewHolder) viewHolder).tvTitle;
            siteName = webHistoryData.getSiteName();
        }
        textView.setText(siteName);
        ((ViewHolder) viewHolder).tvTime.setText(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webHistoryData.getTimestamp(), "yyyy-MM-dd"));
        try {
            ((ViewHolder) viewHolder).tvUrl.setText(webHistoryData.getSiteUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webHistoryData));
        viewHolder.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webHistoryData, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_collect_list_web, viewGroup, false));
    }
}
