package org.fourthline.cling.model.types;

import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes5.dex */
public class URIDatatype extends AbstractDatatype<URI> {
    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf  reason: collision with other method in class */
    public URI mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new InvalidValueException(e.getMessage(), e);
        }
    }
}
