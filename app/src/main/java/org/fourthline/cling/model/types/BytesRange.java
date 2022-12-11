package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class BytesRange {
    public static final String PREFIX = "bytes=";
    public Long byteLength;
    public Long firstByte;
    public Long lastByte;

    public BytesRange(Long l, Long l2) {
        this.firstByte = l;
        this.lastByte = l2;
        this.byteLength = null;
    }

    public BytesRange(Long l, Long l2, Long l3) {
        this.firstByte = l;
        this.lastByte = l2;
        this.byteLength = l3;
    }

    public static BytesRange valueOf(String str) throws InvalidValueException {
        return valueOf(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BytesRange valueOf(String str, String str2) throws InvalidValueException {
        Long l;
        Long l2;
        if (str.startsWith(str2 != null ? str2 : PREFIX)) {
            if (str2 == null) {
                str2 = PREFIX;
            }
            String[] split = str.substring(str2.length()).split("[-/]");
            int length = split.length;
            Long l3 = null;
            if (length != 1) {
                if (length != 2) {
                    if (length == 3) {
                        if (split[2].length() != 0 && !split[2].equals("*")) {
                            l = Long.valueOf(Long.parseLong(split[2]));
                            l2 = split[1].length() == 0 ? Long.valueOf(Long.parseLong(split[1])) : null;
                        }
                    }
                }
                l = null;
                if (split[1].length() == 0) {
                }
            } else {
                l = null;
                l2 = null;
            }
            if (split[0].length() != 0) {
                l3 = Long.valueOf(Long.parseLong(split[0]));
            }
            if (l3 != null || l2 != null) {
                return new BytesRange(l3, l2, l);
            }
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse Bytes Range: ", str));
    }

    public Long getByteLength() {
        return this.byteLength;
    }

    public Long getFirstByte() {
        return this.firstByte;
    }

    public Long getLastByte() {
        return this.lastByte;
    }

    public String getString() {
        return getString(false, null);
    }

    public String getString(boolean z) {
        return getString(z, null);
    }

    public String getString(boolean z, String str) {
        if (str == null) {
            str = PREFIX;
        }
        if (this.firstByte != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.firstByte.toString());
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "-");
        if (this.lastByte != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.lastByte.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
        }
        if (z) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "/");
            Long l = this.byteLength;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(l != null ? l.toString() : "*");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }
}
