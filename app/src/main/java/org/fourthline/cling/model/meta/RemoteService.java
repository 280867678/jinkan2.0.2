package org.fourthline.cling.model.meta;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.types.ServiceId;
import org.fourthline.cling.model.types.ServiceType;

/* loaded from: classes5.dex */
public class RemoteService extends Service<RemoteDevice, RemoteService> {
    public final URI controlURI;
    public final URI descriptorURI;
    public final URI eventSubscriptionURI;

    public RemoteService(ServiceType serviceType, ServiceId serviceId, URI uri, URI uri2, URI uri3) throws ValidationException {
        this(serviceType, serviceId, uri, uri2, uri3, null, null);
    }

    public RemoteService(ServiceType serviceType, ServiceId serviceId, URI uri, URI uri2, URI uri3, Action<RemoteService>[] actionArr, StateVariable<RemoteService>[] stateVariableArr) throws ValidationException {
        super(serviceType, serviceId, actionArr, stateVariableArr);
        this.descriptorURI = uri;
        this.controlURI = uri2;
        this.eventSubscriptionURI = uri3;
        List<ValidationError> validateThis = validateThis();
        if (validateThis.size() <= 0) {
            return;
        }
        throw new ValidationException("Validation of device graph failed, call getErrors() on exception", validateThis);
    }

    public URI getControlURI() {
        return this.controlURI;
    }

    public URI getDescriptorURI() {
        return this.descriptorURI;
    }

    public URI getEventSubscriptionURI() {
        return this.eventSubscriptionURI;
    }

    @Override // org.fourthline.cling.model.meta.Service
    public Action getQueryStateVariableAction() {
        return new QueryStateVariableAction(this);
    }

    @Override // org.fourthline.cling.model.meta.Service
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(RemoteService.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") Descriptor: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDescriptorURI());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public List<ValidationError> validateThis() {
        ArrayList arrayList = new ArrayList();
        if (getDescriptorURI() == null) {
            arrayList.add(new ValidationError(RemoteService.class, "descriptorURI", "Descriptor location (SCPDURL) is required"));
        }
        if (getControlURI() == null) {
            arrayList.add(new ValidationError(RemoteService.class, "controlURI", "Control URL is required"));
        }
        if (getEventSubscriptionURI() == null) {
            arrayList.add(new ValidationError(RemoteService.class, "eventSubscriptionURI", "Event subscription URL is required"));
        }
        return arrayList;
    }
}
