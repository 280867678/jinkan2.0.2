package org.fourthline.cling.support.model.item;

import java.util.Arrays;
import java.util.List;
import org.fourthline.cling.support.model.DIDLObject;
import org.fourthline.cling.support.model.Person;
import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.StorageMedium;
import org.fourthline.cling.support.model.container.Container;

/* loaded from: classes5.dex */
public class ImageItem extends Item {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.item.imageItem");

    public ImageItem() {
        setClazz(CLASS);
    }

    public ImageItem(String str, String str2, String str3, String str4, Res... resArr) {
        super(str, str2, str3, str4, CLASS);
        if (resArr != null) {
            getResources().addAll(Arrays.asList(resArr));
        }
    }

    public ImageItem(String str, Container container, String str2, String str3, Res... resArr) {
        this(str, container.getId(), str2, str3, resArr);
    }

    public ImageItem(Item item) {
        super(item);
    }

    public String getDate() {
        return (String) getFirstPropertyValue(DIDLObject.Property.C3095DC.DATE.class);
    }

    public String getDescription() {
        return (String) getFirstPropertyValue(DIDLObject.Property.C3095DC.DESCRIPTION.class);
    }

    public Person getFirstPublisher() {
        return (Person) getFirstPropertyValue(DIDLObject.Property.C3095DC.PUBLISHER.class);
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

    public String getRating() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RATING.class);
    }

    public String[] getRights() {
        List propertyValues = getPropertyValues(DIDLObject.Property.C3095DC.RIGHTS.class);
        return (String[]) propertyValues.toArray(new String[propertyValues.size()]);
    }

    public StorageMedium getStorageMedium() {
        return (StorageMedium) getFirstPropertyValue(DIDLObject.Property.UPNP.STORAGE_MEDIUM.class);
    }

    public ImageItem setDate(String str) {
        replaceFirstProperty(new DIDLObject.Property.C3095DC.DATE(str));
        return this;
    }

    public ImageItem setDescription(String str) {
        replaceFirstProperty(new DIDLObject.Property.C3095DC.DESCRIPTION(str));
        return this;
    }

    public ImageItem setLongDescription(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.LONG_DESCRIPTION(str));
        return this;
    }

    public ImageItem setPublishers(Person[] personArr) {
        removeProperties(DIDLObject.Property.C3095DC.PUBLISHER.class);
        for (Person person : personArr) {
            addProperty(new DIDLObject.Property.C3095DC.PUBLISHER(person));
        }
        return this;
    }

    public ImageItem setRating(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RATING(str));
        return this;
    }

    public ImageItem setRights(String[] strArr) {
        removeProperties(DIDLObject.Property.C3095DC.RIGHTS.class);
        for (String str : strArr) {
            addProperty(new DIDLObject.Property.C3095DC.RIGHTS(str));
        }
        return this;
    }

    public ImageItem setStorageMedium(StorageMedium storageMedium) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.STORAGE_MEDIUM(storageMedium));
        return this;
    }
}
