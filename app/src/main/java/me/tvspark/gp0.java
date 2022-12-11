package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.support.model.ProtocolInfo;
import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.item.VideoItem;
import org.seamless.util.MimeType;

/* loaded from: classes4.dex */
public class gp0 implements AbstractC3509oo0 {
    public final /* synthetic */ ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AbstractC3509oo0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ so0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC3509oo0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            gp0 gp0Var = gp0.this;
            gp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            gp0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str);
        }
    }

    public gp0(ControlManager controlManager, so0 so0Var, AbstractC3509oo0 abstractC3509oo0) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = controlManager;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = so0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC3509oo0;
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ControlManager controlManager = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        so0 so0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(101, "service is null");
            return;
        }
        Res res = new Res(new MimeType("*", "*"), Long.valueOf(so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        res.setDuration(so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        res.setResolution(so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        VideoItem videoItem = new VideoItem(so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "0", so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, res);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<DIDL-Lite xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:sec=\"http://www.sec.co.kr/\">");
        Object[] objArr = new Object[3];
        objArr[0] = videoItem.getId();
        objArr[1] = videoItem.getParentID();
        objArr[2] = videoItem.isRestricted() ? "1" : "0";
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(String.format("<tem id=\"%s\" parentID=\"%s\" restricted=\"%s\">", objArr));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(String.format("<dc:title>%s</dc:title>", videoItem.getTitle()));
        String creator = videoItem.getCreator();
        if (creator != null) {
            creator = creator.replaceAll("<", "_").replaceAll(">", "_");
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(String.format("<upnp:class>%s</upnp:class>", videoItem.getClazz().getValue()));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(String.format("<upnp:artist>%s</upnp:artist>", creator));
        Res firstResource = videoItem.getFirstResource();
        if (firstResource != null) {
            ProtocolInfo protocolInfo = firstResource.getProtocolInfo();
            String str = "";
            String format = protocolInfo != null ? String.format("protocolInfo=\"%s:%s:%s:%s\"", protocolInfo.getProtocol(), protocolInfo.getNetwork(), protocolInfo.getContentFormatMimeType(), protocolInfo.getAdditionalInfo()) : str;
            VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.INFO, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("protocolInfo: ", format));
            String format2 = (firstResource.getResolution() == null || firstResource.getResolution().length() <= 0) ? str : String.format("resolution=\"%s\"", firstResource.getResolution());
            if (firstResource.getDuration() != null && firstResource.getDuration().length() > 0) {
                str = String.format("duration=\"%s\"", firstResource.getDuration());
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(String.format("<res %s %s %s>", format, format2, str));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(firstResource.getValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("</res>");
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "</item>", "</DIDL-Lite>");
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.INFO, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("metadata: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3));
        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new cp0(controlManager, controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str);
    }
}
