package me.tvspark.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.text.TextUtils;
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
import java.util.HashMap;
import java.util.List;
import me.tvspark.data.bean.EngineResultParcel;
import me.tvspark.outline;
import me.tvspark.sk0;
import me.tvspark.view.fragment.SearchWebSourceAllFragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebSourceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwwww;
    public List<EngineResultParcel> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public HashMap<String, List<EngineResultParcel>> Wwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public String Wwwwwwwwwwwwwwwwwwww = "";
    public int Wwwwwwwwwwwwwwwwwww = -1;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        public TextView tvTitle;
        @BindView(R.id.tv_web)
        public TextView tvWeb;
        @BindView(R.id.view_line)
        public View viewLine;

        public ViewHolder(WebSourceListAdapter webSourceListAdapter, View view) {
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
            viewHolder.tvWeb = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_web, "field 'tvWeb'", TextView.class);
            viewHolder.viewLine = Utils.findRequiredView(view, R.id.view_line, "field 'viewLine'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.tvWeb = null;
                viewHolder.viewLine = null;
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
        public final /* synthetic */ EngineResultParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EngineResultParcel engineResultParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = engineResultParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebSourceListAdapter webSourceListAdapter = WebSourceListAdapter.this;
            if (webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwww != null) {
                webSourceListAdapter.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceData().getWebSourceSiteName();
                ((SearchWebSourceAllFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) WebSourceListAdapter.this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.isShowWebViewSearch(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceData(), WebSourceListAdapter.this.Wwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceData().getWebSourceBaseUrl()));
                WebSourceListAdapter.this.notifyDataSetChanged();
            }
        }
    }

    public WebSourceListAdapter(Activity activity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<EngineResultParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        Typeface defaultFromStyle;
        EngineResultParcel engineResultParcel = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i);
        if (engineResultParcel.isShowWebViewSearch()) {
            ((ViewHolder) viewHolder).tvWeb.setVisibility(0);
        } else {
            ((ViewHolder) viewHolder).tvWeb.setVisibility(8);
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.tvTitle.setText(engineResultParcel.getWebSourceData().getWebSourceSiteName());
        if (i == this.Wwwwwwwwwwwwwwwwwwwwwww.size() - 1) {
            viewHolder2.viewLine.setVisibility(8);
        } else {
            viewHolder2.viewLine.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwww)) {
            this.Wwwwwwwwwwwwwwwwwwww = engineResultParcel.getWebSourceData().getWebSourceSiteName();
            viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
            viewHolder2.tvTitle.setTypeface(Typeface.defaultFromStyle(1));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((SearchWebSourceAllFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(engineResultParcel.isShowWebViewSearch(), engineResultParcel.getWebSourceData(), this.Wwwwwwwwwwwwwwwwwwwwww.get(engineResultParcel.getWebSourceData().getWebSourceBaseUrl()));
            }
        } else {
            if (this.Wwwwwwwwwwwwwwwwwwww.equals(engineResultParcel.getWebSourceData().getWebSourceSiteName())) {
                viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
                textView = viewHolder2.tvTitle;
                defaultFromStyle = Typeface.defaultFromStyle(1);
            } else {
                viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.color.text_black));
                textView = viewHolder2.tvTitle;
                defaultFromStyle = Typeface.defaultFromStyle(0);
            }
            textView.setTypeface(defaultFromStyle);
        }
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(engineResultParcel));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_websource_list_left, viewGroup, false));
    }
}
