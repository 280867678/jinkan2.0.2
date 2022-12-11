package me.tvspark.adapter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.just.agentweb.DefaultWebClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import me.tvspark.ap0;
import me.tvspark.cq0;
import me.tvspark.eq0;
import me.tvspark.gq0;
import me.tvspark.lq0;
import me.tvspark.outline;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import org.fourthline.cling.android.AndroidUpnpService;
import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.support.model.ProtocolInfo;
import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.item.VideoItem;
import org.seamless.util.MimeType;
import white.whale.R;

/* loaded from: classes4.dex */
public class DlnaDeviceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = "扫描 DLNA 设备中...";
    public List<cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pbar)
        public ProgressBar progressBar;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(DlnaDeviceAdapter dlnaDeviceAdapter, View view) {
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
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.progressBar = null;
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
        public final /* synthetic */ cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogParse dialogParse;
            ControlPoint controlPoint;
            Handler handler;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DlnaDeviceAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                Device device = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                DialogParse dialogParse2 = DialogParse.this;
                if (dialogParse2.Kkkkkkkkkkkkkkkkkkkkk == null) {
                    AndroidUpnpService androidUpnpService = dialogParse2.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    dialogParse2.Kkkkkkkkkkkkkkkkkkkkk = androidUpnpService == null ? null : androidUpnpService.getControlPoint();
                }
                if (device == null || device.getDetails() == null || (controlPoint = (dialogParse = DialogParse.this).Kkkkkkkkkkkkkkkkkkkkk) == null) {
                    return;
                }
                gq0 gq0Var = dialogParse.Kkkkkkkkkkkkkkkkkk;
                gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = controlPoint;
                gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = device;
                int i = 1;
                String format = String.format("√ 已连接：%s", device.getDetails().getFriendlyName());
                DlnaDeviceAdapter dlnaDeviceAdapter = DialogParse.this.Kkkkkkkkkkkkkkkkkkk;
                dlnaDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = format;
                dlnaDeviceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                dlnaDeviceAdapter.notifyDataSetChanged();
                gq0 gq0Var2 = DialogParse.this.Kkkkkkkkkkkkkkkkkk;
                String str = DialogParse.this.Wwwwwwwwwwwwwww + "-" + DialogParse.this.Wwwwwwwwwwwwww;
                String str2 = wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                gq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (TextUtils.isEmpty(str2)) {
                    handler = gq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    if (!str2.startsWith("http") && !str2.startsWith("rtsp")) {
                        if (str2.startsWith("/")) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(lq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(8299);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
                            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                        } else {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(lq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(8299);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("/");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2);
                            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                        }
                    }
                    Service findService = gq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.findService(new UDAServiceType("AVTransport"));
                    if (findService != null) {
                        VideoItem videoItem = new VideoItem("id", "0", str, "unknow", new Res(new MimeType("*", "*"), (Long) 0L, str2));
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<?xml version=\"1.0\"?><DIDL-Lite xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" xmlns:dlna=\"urn:schemas-dlna-org:metadata-1-0/\">");
                        Object[] objArr = new Object[3];
                        objArr[0] = videoItem.getId();
                        objArr[1] = videoItem.getParentID();
                        objArr[2] = videoItem.isRestricted() ? "1" : "0";
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(String.format("<item id=\"%s\" parentID=\"%s\" restricted=\"%s\">", objArr));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(String.format("<dc:title>%s</dc:title>", videoItem.getTitle()));
                        String creator = videoItem.getCreator();
                        if (creator != null) {
                            creator = creator.replaceAll("<", "_").replaceAll(">", "_");
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(String.format("<upnp:artist>%s</upnp:artist>", creator));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(String.format("<upnp:class>%s</upnp:class>", videoItem.getClazz().getValue()));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(String.format("<dc:date>%s</dc:date>", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date())));
                        Res firstResource = videoItem.getFirstResource();
                        if (firstResource != null) {
                            ProtocolInfo protocolInfo = firstResource.getProtocolInfo();
                            String str3 = "";
                            String format2 = protocolInfo != null ? String.format("protocolInfo=\"%s:%s:%s:%s\"", protocolInfo.getProtocol(), protocolInfo.getNetwork(), protocolInfo.getContentFormatMimeType(), protocolInfo.getAdditionalInfo()) : str3;
                            String format3 = (firstResource.getResolution() == null || firstResource.getResolution().length() <= 0) ? str3 : String.format("resolution=\"%s\"", firstResource.getResolution());
                            if (firstResource.getDuration() != null && firstResource.getDuration().length() > 0) {
                                str3 = String.format("duration=\"%s\"", firstResource.getDuration());
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(String.format("<res %s %s %s>", format2, format3, str3));
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(firstResource.getValue());
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("</res>");
                        }
                        gq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(new eq0(gq0Var2, findService, str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, "</item>", "</DIDL-Lite>")));
                        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
                    }
                    handler = gq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i = -5;
                }
                handler.obtainMessage(i).sendToTarget();
                ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            }
        }
    }

    public DlnaDeviceAdapter(Context context, List<cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = 8;
        if (getItemViewType(i) != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.progressBar.setVisibility(8);
            cq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i - 1);
            viewHolder2.tvTitle.setText(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDetails().getFriendlyName());
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            return;
        }
        ViewHolder viewHolder3 = (ViewHolder) viewHolder;
        viewHolder3.tvTitle.setText(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ProgressBar progressBar = viewHolder3.progressBar;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            i2 = 0;
        }
        progressBar.setVisibility(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_dlna_device_list, viewGroup, false);
        return i == i2 ? new ViewHolder(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : new ViewHolder(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }
}
