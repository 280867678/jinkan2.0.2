package org.fourthline.cling.support.lastchange;

import java.net.URI;
import java.util.Map;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.types.Datatype;
import org.fourthline.cling.model.types.InvalidValueException;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public class EventedValueURI extends EventedValue<URI> {
    public static final Logger log = Logger.getLogger(EventedValueURI.class.getName());

    public EventedValueURI(URI uri) {
        super(uri);
    }

    public EventedValueURI(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }

    @Override // org.fourthline.cling.support.lastchange.EventedValue
    public Datatype getDatatype() {
        return Datatype.Builtin.URI.getDatatype();
    }

    @Override // org.fourthline.cling.support.lastchange.EventedValue
    /* renamed from: valueOf  reason: collision with other method in class */
    public URI mo5218valueOf(String str) throws InvalidValueException {
        try {
            return (URI) super.mo5218valueOf(str);
        } catch (InvalidValueException e) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring invalid URI in evented value '", str, "': ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Exceptions.unwrap(e));
            logger.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return null;
        }
    }
}
