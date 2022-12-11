package org.fourthline.cling.model.types;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class DLNADoc {
    public static final Pattern PATTERN = Pattern.compile("(.+?)[ -]([0-9].[0-9]{2})");
    public final String devClass;
    public final String version;

    /* loaded from: classes5.dex */
    public enum Version {
        V1_0("1.00"),
        V1_5("1.50");
        

        /* renamed from: s */
        public String f4622s;

        Version(String str) {
            this.f4622s = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f4622s;
        }
    }

    public DLNADoc(String str, String str2) {
        this.devClass = str;
        this.version = str2;
    }

    public DLNADoc(String str, Version version) {
        this.devClass = str;
        this.version = version.f4622s;
    }

    public static DLNADoc valueOf(String str) throws InvalidValueException {
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches()) {
            return new DLNADoc(matcher.group(1), matcher.group(2));
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse DLNADoc: ", str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DLNADoc.class != obj.getClass()) {
            return false;
        }
        DLNADoc dLNADoc = (DLNADoc) obj;
        return this.devClass.equals(dLNADoc.devClass) && this.version.equals(dLNADoc.version);
    }

    public String getDevClass() {
        return this.devClass;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.version.hashCode() + (this.devClass.hashCode() * 31);
    }

    public String toString() {
        return getDevClass() + "-" + getVersion();
    }
}
