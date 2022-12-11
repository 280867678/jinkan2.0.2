package org.fourthline.cling.registry;

import me.tvspark.outline;
import org.fourthline.cling.model.ExpirationDetails;

/* loaded from: classes5.dex */
public class RegistryItem<K, I> {
    public ExpirationDetails expirationDetails;
    public I item;
    public K key;

    public RegistryItem(K k) {
        this.expirationDetails = new ExpirationDetails();
        this.key = k;
    }

    public RegistryItem(K k, I i, int i2) {
        this.expirationDetails = new ExpirationDetails();
        this.key = k;
        this.item = i;
        this.expirationDetails = new ExpirationDetails(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RegistryItem.class == obj.getClass()) {
            return this.key.equals(((RegistryItem) obj).key);
        }
        return false;
    }

    public ExpirationDetails getExpirationDetails() {
        return this.expirationDetails;
    }

    public I getItem() {
        return this.item;
    }

    public K getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(RegistryItem.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getExpirationDetails());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" KEY: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getKey());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ITEM: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getItem());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
