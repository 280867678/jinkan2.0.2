package me.tvspark.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.just.agentweb.DefaultWebClient;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.ap0;
import me.tvspark.aq0;
import me.tvspark.bp0;
import me.tvspark.eo0;
import me.tvspark.gp0;
import me.tvspark.lp0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.ro0;
import me.tvspark.so0;
import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.p050ui.DialogDlna;
import me.tvspark.zp0;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.item.Item;
import white.whale.R;

/* loaded from: classes4.dex */
public class CastDeviceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = "扫描 投屏 设备中...";
    public List<ro0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_check)
        public ImageView ivCheck;
        @BindView(R.id.pbar)
        public ProgressBar progressBar;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(CastDeviceAdapter castDeviceAdapter, View view) {
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
            viewHolder.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pbar, "field 'progressBar'", ProgressBar.class);
            viewHolder.ivCheck = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_check, "field 'ivCheck'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.progressBar = null;
                viewHolder.ivCheck = null;
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
        public final /* synthetic */ ro0 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ro0 ro0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = ro0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Device device;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CastDeviceAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ro0 ro0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ro0Var;
                int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    DeviceDetails details = ro0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDetails();
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDlna.this.Wwwwwwwwwwwwwwwwwwwwww, String.format("已连接：%s", details.getFriendlyName()));
                    DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DialogDlna.this.Wwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(details.getFriendlyName());
                    }
                    DialogDlna.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else if (ro0Var == null || (device = ro0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                } else {
                    DeviceDetails details2 = device.getDetails();
                    CastDeviceAdapter castDeviceAdapter = DialogDlna.this.Wwwwwwwwwwwwwww;
                    castDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = details2.getFriendlyName();
                    castDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    castDeviceAdapter.notifyDataSetChanged();
                    ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    DialogDlna dialogDlna = DialogDlna.this;
                    if (dialogDlna.Wwwwwwwwwww) {
                        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Item item = new Item();
                        item.setTitle(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        Res res = new Res();
                        res.setValue(DefaultWebClient.HTTP_SCHEME + r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDlna.this.Wwwwwwwwwwwwwwwwwwwwww) + ":8289/video" + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(res);
                        item.setResources(arrayList);
                        ap0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = item;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                        ApplicationC1880C.Wwwwwwwwwww.clear();
                        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.STOPED;
                        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.TRANSITIONING;
                        ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        zp0 zp0Var = new zp0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            throw null;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new bp0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, item, zp0Var));
                        return;
                    }
                    so0 so0Var = new so0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, dialogDlna.Wwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "", "", 0L, "", "");
                    ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(so0Var);
                    ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.TRANSITIONING;
                    ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    aq0 aq0Var = new aq0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                        throw null;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new gp0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, so0Var, aq0Var));
                }
            }
        }
    }

    public CastDeviceAdapter(Context context, List<ro0> list, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ro0 ro0Var = lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ro0Var != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ro0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDetails().getFriendlyName();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ro0> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.tvTitle.setText(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            viewHolder2.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.text_gray));
            viewHolder2.tvTitle.setTextSize(13.0f);
            viewHolder2.ivCheck.setVisibility(8);
            return;
        }
        ViewHolder viewHolder3 = (ViewHolder) viewHolder;
        viewHolder3.tvTitle.setTextSize(14.0f);
        viewHolder3.progressBar.setVisibility(8);
        viewHolder3.tvTitle.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.text_black));
        ro0 ro0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i - 1);
        viewHolder3.tvTitle.setText(ro0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDetails().getFriendlyName());
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwww || TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(ro0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDetails().getFriendlyName())) {
            viewHolder3.ivCheck.setVisibility(8);
        } else {
            viewHolder3.ivCheck.setVisibility(0);
        }
        viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ro0Var));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_cast_device_list, viewGroup, false);
        return i == i2 ? new ViewHolder(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : new ViewHolder(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }
}
