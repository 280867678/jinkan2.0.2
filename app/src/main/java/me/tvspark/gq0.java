package me.tvspark;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.support.model.MediaInfo;
import org.fourthline.cling.support.model.PositionInfo;
import org.fourthline.cling.support.model.TransportInfo;
import org.fourthline.cling.support.model.TransportStatus;

/* loaded from: classes4.dex */
public class gq0 {
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper.myLooper());
    public Device Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ControlPoint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            int i = message.what;
            if (i != -8 && i != -7 && i != -6) {
                switch (i) {
                    case 6:
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null || (r4 = DialogParse.this.Wwwwwwwwwwwwwwwww) == null) {
                            return;
                        }
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r4, "投屏成功，可关闭此对话框");
                        return;
                    case 7:
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            return;
                        }
                        DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        return;
                    case 8:
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            return;
                        }
                        DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        return;
                    case 9:
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            return;
                        }
                        DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        return;
                    default:
                        switch (i) {
                            case 16:
                                MediaInfo mediaInfo = (MediaInfo) message.obj;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                    return;
                                }
                                DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222 = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                return;
                            case 17:
                                TransportInfo transportInfo = (TransportInfo) message.obj;
                                if (transportInfo == null) {
                                    return;
                                }
                                TransportStatus currentTransportStatus = transportInfo.getCurrentTransportStatus();
                                if (gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (currentTransportStatus == TransportStatus.OK || currentTransportStatus == TransportStatus.CUSTOM)) {
                                    int ordinal = transportInfo.getCurrentTransportState().ordinal();
                                    if (ordinal != 0) {
                                        if (ordinal == 1) {
                                            Activity activity2 = DialogParse.this.Wwwwwwwwwwwwwwwww;
                                            if (activity2 == null) {
                                                return;
                                            }
                                            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity2, "投屏成功，可关闭此对话框");
                                            return;
                                        } else if (ordinal == 3) {
                                            if (((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                                                throw null;
                                            }
                                            return;
                                        } else if (ordinal != 6) {
                                            return;
                                        }
                                    }
                                    if (((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                                        throw null;
                                    }
                                    return;
                                }
                                activity = DialogParse.this.Wwwwwwwwwwwwwwwww;
                                if (activity == null) {
                                    return;
                                }
                                break;
                            case 18:
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                    return;
                                }
                                DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222 = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                return;
                            case 19:
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                    return;
                                }
                                ((Boolean) message.obj).booleanValue();
                                DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                return;
                            case 20:
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                    return;
                                }
                                PositionInfo positionInfo = (PositionInfo) message.obj;
                                DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = (DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                return;
                            default:
                                return;
                        }
                }
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = gq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null || (activity = DialogParse.this.Wwwwwwwwwwwwwwwww) == null) {
                    return;
                }
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, "投屏失败");
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                throw new NullPointerException("MediaRender device must not be null.");
            }
            return;
        }
        throw new NullPointerException("mControlPoint must not be null,you should invoke setControlPoint(ControlPoint) method first.");
    }
}
