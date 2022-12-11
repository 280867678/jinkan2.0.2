package org.fourthline.cling.model.meta;

import java.net.URI;

/* loaded from: classes5.dex */
public class ManufacturerDetails {
    public String manufacturer;
    public URI manufacturerURI;

    public ManufacturerDetails() {
    }

    public ManufacturerDetails(String str) {
        this.manufacturer = str;
    }

    public ManufacturerDetails(String str, String str2) throws IllegalArgumentException {
        this.manufacturer = str;
        this.manufacturerURI = URI.create(str2);
    }

    public ManufacturerDetails(String str, URI uri) {
        this.manufacturer = str;
        this.manufacturerURI = uri;
    }

    public ManufacturerDetails(URI uri) {
        this.manufacturerURI = uri;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public URI getManufacturerURI() {
        return this.manufacturerURI;
    }
}
