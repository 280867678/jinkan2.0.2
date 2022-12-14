package org.fourthline.cling.support.model;

/* loaded from: classes5.dex */
public class Person {
    public String name;

    public Person(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.name.equals(((Person) obj).name);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return getName();
    }
}
