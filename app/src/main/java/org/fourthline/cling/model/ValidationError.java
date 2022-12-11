package org.fourthline.cling.model;

/* loaded from: classes5.dex */
public class ValidationError {
    public Class clazz;
    public String message;
    public String propertyName;

    public ValidationError(Class cls, String str) {
        this.clazz = cls;
        this.message = str;
    }

    public ValidationError(Class cls, String str, String str2) {
        this.clazz = cls;
        this.propertyName = str;
        this.message = str2;
    }

    public Class getClazz() {
        return this.clazz;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public String toString() {
        return ValidationError.class.getSimpleName() + " (Class: " + getClazz().getSimpleName() + ", propertyName: " + getPropertyName() + "): " + this.message;
    }
}
