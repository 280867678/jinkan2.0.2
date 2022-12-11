package org.fourthline.cling.protocol.async;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.types.NotificationSubtype;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class SendingNotificationAlive extends SendingNotification {
    public static final Logger log = Logger.getLogger(SendingNotification.class.getName());

    public SendingNotificationAlive(UpnpService upnpService, LocalDevice localDevice) {
        super(upnpService, localDevice);
    }

    @Override // org.fourthline.cling.protocol.async.SendingNotification, org.fourthline.cling.protocol.SendingAsync
    public void execute() throws RouterException {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending alive messages (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getBulkRepeat());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" times) for: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDevice());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        super.execute();
    }

    @Override // org.fourthline.cling.protocol.async.SendingNotification
    public NotificationSubtype getNotificationSubtype() {
        return NotificationSubtype.ALIVE;
    }
}
