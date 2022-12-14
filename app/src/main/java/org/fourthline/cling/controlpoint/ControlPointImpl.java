package org.fourthline.cling.controlpoint;

import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import me.tvspark.outline;
import org.fourthline.cling.UpnpServiceConfiguration;
import org.fourthline.cling.controlpoint.event.ExecuteAction;
import org.fourthline.cling.controlpoint.event.Search;
import org.fourthline.cling.model.message.header.MXHeader;
import org.fourthline.cling.model.message.header.STAllHeader;
import org.fourthline.cling.model.message.header.UpnpHeader;
import org.fourthline.cling.protocol.ProtocolFactory;
import org.fourthline.cling.registry.Registry;

@ApplicationScoped
/* loaded from: classes5.dex */
public class ControlPointImpl implements ControlPoint {
    public static Logger log = Logger.getLogger(ControlPointImpl.class.getName());
    public UpnpServiceConfiguration configuration;
    public ProtocolFactory protocolFactory;
    public Registry registry;

    public ControlPointImpl() {
    }

    @Inject
    public ControlPointImpl(UpnpServiceConfiguration upnpServiceConfiguration, ProtocolFactory protocolFactory, Registry registry) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Creating ControlPoint: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ControlPointImpl.class.getName());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        this.configuration = upnpServiceConfiguration;
        this.protocolFactory = protocolFactory;
        this.registry = registry;
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public Future execute(ActionCallback actionCallback) {
        Logger logger = log;
        logger.fine("Invoking action in background: " + actionCallback);
        actionCallback.setControlPoint(this);
        return getConfiguration().getSyncProtocolExecutorService().submit(actionCallback);
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public void execute(SubscriptionCallback subscriptionCallback) {
        Logger logger = log;
        logger.fine("Invoking subscription in background: " + subscriptionCallback);
        subscriptionCallback.setControlPoint(this);
        getConfiguration().getSyncProtocolExecutorService().execute(subscriptionCallback);
    }

    public void execute(ExecuteAction executeAction) {
        execute(executeAction.getCallback());
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public UpnpServiceConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public ProtocolFactory getProtocolFactory() {
        return this.protocolFactory;
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public Registry getRegistry() {
        return this.registry;
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public void search() {
        search(new STAllHeader(), MXHeader.DEFAULT_VALUE.intValue());
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public void search(int i) {
        search(new STAllHeader(), i);
    }

    public void search(@Observes Search search) {
        search(search.getSearchType(), search.getMxSeconds());
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public void search(UpnpHeader upnpHeader) {
        search(upnpHeader, MXHeader.DEFAULT_VALUE.intValue());
    }

    @Override // org.fourthline.cling.controlpoint.ControlPoint
    public void search(UpnpHeader upnpHeader, int i) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending asynchronous search for: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(upnpHeader.getString());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        getConfiguration().getAsyncProtocolExecutor().execute(getProtocolFactory().createSendingSearch(upnpHeader, i));
    }
}
