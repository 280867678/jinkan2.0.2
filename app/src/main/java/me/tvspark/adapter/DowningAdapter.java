package me.tvspark.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arialyy.aria.core.download.DownloadEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.tvspark.mn0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.pk0;
import me.tvspark.qk0;
import me.tvspark.rk0;
import me.tvspark.sk0;
import me.tvspark.view.activity.DowningActivity;
import me.tvspark.widget.HorizontalProgressBarWithNumber;
import me.tvspark.zn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class DowningAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;
    public List<DownloadEntity> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Map<String, Integer> Wwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressBar)
        public HorizontalProgressBarWithNumber pbar;
        @BindView(R.id.tv_del)
        public TextView tvDel;
        @BindView(R.id.tv_pause)
        public TextView tvPause;
        @BindView(R.id.tv_play)
        public TextView tvPlay;
        @BindView(R.id.tv_repair)
        public TextView tvRepair;
        @BindView(R.id.tv_speed)
        public TextView tvSpeed;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(DowningAdapter downingAdapter, View view) {
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
            viewHolder.tvSpeed = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_speed, "field 'tvSpeed'", TextView.class);
            viewHolder.tvDel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_del, "field 'tvDel'", TextView.class);
            viewHolder.tvPause = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pause, "field 'tvPause'", TextView.class);
            viewHolder.tvPlay = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_play, "field 'tvPlay'", TextView.class);
            viewHolder.tvRepair = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_repair, "field 'tvRepair'", TextView.class);
            viewHolder.pbar = (HorizontalProgressBarWithNumber) Utils.findRequiredViewAsType(view, R.id.progressBar, "field 'pbar'", HorizontalProgressBarWithNumber.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.tvSpeed = null;
                viewHolder.tvDel = null;
                viewHolder.tvPause = null;
                viewHolder.tvPlay = null;
                viewHolder.tvRepair = null;
                viewHolder.pbar = null;
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
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public DownloadEntity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownloadEntity downloadEntity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = downloadEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context;
            String url;
            long id;
            int i;
            int state = this.Wwwwwwwwwwwwwwwwwwwwwwww.getState();
            if (state != -1 && state != 0 && state != 2) {
                if (state == 3 || state == 4) {
                    context = DowningAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    url = this.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl();
                    id = this.Wwwwwwwwwwwwwwwwwwwwwwww.getId();
                    i = 2;
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, url, "", id, i);
                } else if (state != 5 && state != 6) {
                    return;
                }
            }
            context = DowningAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            url = this.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl();
            id = this.Wwwwwwwwwwwwwwwwwwwwwwww.getId();
            i = 1;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, url, "", id, i);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ DownloadEntity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DowningAdapter downingAdapter, DownloadEntity downloadEntity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = downloadEntity;
        }

        @Override // java.lang.Runnable
        public void run() {
            zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".m3u8", this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".key");
        }
    }

    public DowningAdapter(Context context, List<DownloadEntity> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        if (!o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (list != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
            int i = 0;
            for (DownloadEntity downloadEntity : list) {
                this.Wwwwwwwwwwwwwwwwwwwwww.put(downloadEntity.getUrl(), Integer.valueOf(i));
                i++;
            }
        }
    }

    public final synchronized int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        for (String str2 : this.Wwwwwwwwwwwwwwwwwwwwww.keySet()) {
            if (str2.equals(str)) {
                try {
                    return this.Wwwwwwwwwwwwwwwwwwwwww.get(str2).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    return -1;
                }
            }
        }
        return -1;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecyclerView.ViewHolder viewHolder, DownloadEntity downloadEntity) {
        String str;
        if (downloadEntity.getUrl().contains(".m3u8") || downloadEntity.getUrl().contains(".m3u")) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.tvPlay.setVisibility(0);
            viewHolder2.tvRepair.setVisibility(0);
        } else {
            ViewHolder viewHolder3 = (ViewHolder) viewHolder;
            viewHolder3.tvPlay.setVisibility(8);
            viewHolder3.tvRepair.setVisibility(8);
        }
        ViewHolder viewHolder4 = (ViewHolder) viewHolder;
        viewHolder4.tvDel.setVisibility(0);
        viewHolder4.tvSpeed.setVisibility(8);
        int i = 17170452;
        switch (downloadEntity.getState()) {
            case -1:
            case 0:
                str = "开始";
                break;
            case 1:
                viewHolder4.pbar.setProgress(100);
                viewHolder4.tvPlay.setVisibility(8);
                viewHolder4.tvRepair.setVisibility(8);
                viewHolder4.tvDel.setVisibility(8);
                str = "完成";
                break;
            case 2:
                i = 17170450;
                str = "已暂停";
                break;
            case 3:
                str = "等待中";
                break;
            case 4:
            case 5:
            case 6:
                i = 17170454;
                viewHolder4.tvSpeed.setVisibility(0);
                str = "下载中";
                break;
            default:
                str = "";
                break;
        }
        viewHolder4.tvPause.setText(str);
        viewHolder4.tvPause.setTextColor(Resources.getSystem().getColor(i));
        viewHolder4.pbar.setProgress(downloadEntity.getPercent());
        viewHolder4.tvPause.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadEntity));
        viewHolder4.tvTitle.setText(downloadEntity.getFileName());
        viewHolder4.tvSpeed.setText(downloadEntity.getConvertSpeed());
        viewHolder4.tvDel.setOnClickListener(new pk0(this, downloadEntity));
        viewHolder4.tvPlay.setOnClickListener(new qk0(this, downloadEntity));
        viewHolder4.tvRepair.setOnClickListener(new rk0(this, downloadEntity));
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownloadEntity downloadEntity) {
        if (downloadEntity.getState() != 7) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadEntity.getUrl());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < this.Wwwwwwwwwwwwwwwwwwwwwww.size()) {
                if (downloadEntity.getState() == 1) {
                    if (this.Wwwwwwwwwwwwwwwwwwwww != null) {
                        ((DowningActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadEntity);
                    }
                    new Handler().postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, downloadEntity), 3500L);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, downloadEntity);
                notifyItemChanged(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.remove(downloadEntity);
        this.Wwwwwwwwwwwwwwwwwwwwww.clear();
        int i = 0;
        for (DownloadEntity downloadEntity2 : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww.put(downloadEntity2.getUrl(), Integer.valueOf(i));
            i++;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<DownloadEntity> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder, this.Wwwwwwwwwwwwwwwwwwwwwww.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
        super.onBindViewHolder(viewHolder, i, list);
        if (list.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder, this.Wwwwwwwwwwwwwwwwwwwwwww.get(i));
            return;
        }
        DownloadEntity downloadEntity = (DownloadEntity) list.get(0);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvSpeed.setText(downloadEntity.getConvertSpeed());
        viewHolder2.pbar.setProgress(downloadEntity.getPercent());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_downing, viewGroup, false));
    }
}
