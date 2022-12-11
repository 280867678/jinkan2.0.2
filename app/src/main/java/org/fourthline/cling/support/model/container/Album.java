package org.fourthline.cling.support.model.container;

import java.net.URI;
import java.util.List;
import org.fourthline.cling.support.model.DIDLObject;
import org.fourthline.cling.support.model.Person;
import org.fourthline.cling.support.model.StorageMedium;

/* loaded from: classes5.dex */
public class Album extends Container {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.container.album");

    public Album() {
        setClazz(CLASS);
    }

    public Album(String str, String str2, String str3, String str4, Integer num) {
        super(str, str2, str3, str4, CLASS, num);
    }

    public Album(String str, Container container, String str2, String str3, Integer num) {
        this(str, container.getId(), str2, str3, num);
    }

    public Album(Container container) {
        super(container);
    }

    public Person[] getContributors() {
        List propertyValues = getPropertyValues(DIDLObject.Property.C3095DC.CONTRIBUTOR.class);
        return (Person[]) propertyValues.toArray(new Person[propertyValues.size()]);
    }

    public String getDate() {
        return (String) getFirstPropertyValue(DIDLObject.Property.C3095DC.DATE.class);
    }

    public String getDescription() {
        return (String) getFirstPropertyValue(DIDLObject.Property.C3095DC.DESCRIPTION.class);
    }

    public Person getFirstContributor() {
        return (Person) getFirstPropertyValue(DIDLObject.Property.C3095DC.CONTRIBUTOR.class);
    }

    public Person getFirstPublisher() {
        return (Person) getFirstPropertyValue(DIDLObject.Property.C3095DC.PUBLISHER.class);
    }

    public URI getFirstRelation() {
        return (URI) getFirstPropertyValue(DIDLObject.Property.C3095DC.RELATION.class);
    }

    public String getFirstRights() {
        return (String) getFirstPropertyValue(DIDLObject.Property.C3095DC.RIGHTS.class);
    }

    public String getLongDescription() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.LONG_DESCRIPTION.class);
    }

    public Person[] getPublishers() {
        List propertyValues = getPropertyValues(DIDLObject.Property.C3095DC.PUBLISHER.class);
        return (Person[]) propertyValues.toArray(new Person[propertyValues.size()]);
    }

    public URI[] getRelations() {
        List propertyValues = getPropertyValues(DIDLObject.Property.C3095DC.RELATION.class);
        return (URI[]) propertyValues.toArray(new URI[propertyValues.size()]);
    }

    public String[] getRights() {
        List propertyValues = getPropertyValues(DIDLObject.Property.C3095DC.RIGHTS.class);
        return (String[]) propertyValues.toArray(new String[propertyValues.size()]);
    }

    public StorageMedium getStorageMedium() {
        return (StorageMedium) getFirstPropertyValue(DIDLObject.Property.UPNP.STORAGE_MEDIUM.class);
    }

    public Album setContributors(Person[] personArr) {
        removeProperties(DIDLObject.Property.C3095DC.CONTRIBUTOR.class);
        for (Person person : personArr) {
            addProperty(new DIDLObject.Property.C3095DC.CONTRIBUTOR(person));
        }
        return this;
    }

    public Album setDate(String str) {
        replaceFirstProperty(new DIDLObject.Property.C3095DC.DATE(str));
        return this;
    }

    public Album setDescription(String str) {
        replaceFirstProperty(new DIDLObject.Property.C3095DC.DESCRIPTION(str));
        return this;
    }

    public Album setLongDescription(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.LONG_DESCRIPTION(str));
        return this;
    }

    public Album setPublishers(Person[] personArr) {
        removeProperties(DIDLObject.Property.C3095DC.PUBLISHER.class);
        for (Person person : personArr) {
            addProperty(new DIDLObject.Property.C3095DC.PUBLISHER(person));
        }
        return this;
    }

    public Album setRelations(URI[] uriArr) {
        removeProperties(DIDLObject.Property.C3095DC.RELATION.class);
        for (URI uri : uriArr) {
            addProperty(new DIDLObject.Property.C3095DC.RELATION(uri));
        }
        return this;
    }

    public Album setRights(String[] strArr) {
        removeProperties(DIDLObject.Property.C3095DC.RIGHTS.class);
        for (String str : strArr) {
            addProperty(new DIDLObject.Property.C3095DC.RIGHTS(str));
        }
        return this;
    }

    public Album setStorageMedium(StorageMedium storageMedium) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.STORAGE_MEDIUM(storageMedium));
        return this;
    }
}
