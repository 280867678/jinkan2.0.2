package org.fourthline.cling.support.model.dlna.types;

import me.tvspark.outline;
import org.fourthline.cling.model.types.InvalidValueException;

/* loaded from: classes5.dex */
public class NormalPlayTimeRange {
    public static final String PREFIX = "npt=";
    public NormalPlayTime timeDuration;
    public NormalPlayTime timeEnd;
    public NormalPlayTime timeStart;

    public NormalPlayTimeRange(long j, long j2) {
        this.timeStart = new NormalPlayTime(j);
        this.timeEnd = new NormalPlayTime(j2);
    }

    public NormalPlayTimeRange(NormalPlayTime normalPlayTime, NormalPlayTime normalPlayTime2) {
        this.timeStart = normalPlayTime;
        this.timeEnd = normalPlayTime2;
    }

    public NormalPlayTimeRange(NormalPlayTime normalPlayTime, NormalPlayTime normalPlayTime2, NormalPlayTime normalPlayTime3) {
        this.timeStart = normalPlayTime;
        this.timeEnd = normalPlayTime2;
        this.timeDuration = normalPlayTime3;
    }

    public static NormalPlayTimeRange valueOf(String str) throws InvalidValueException {
        return valueOf(str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static NormalPlayTimeRange valueOf(String str, boolean z) throws InvalidValueException {
        NormalPlayTime normalPlayTime;
        NormalPlayTime normalPlayTime2;
        if (str.startsWith(PREFIX)) {
            String[] split = str.substring(4).split("[-/]");
            int length = split.length;
            NormalPlayTime normalPlayTime3 = null;
            if (length != 1) {
                if (length != 2) {
                    if (length == 3) {
                        if (split[2].length() != 0 && !split[2].equals("*")) {
                            normalPlayTime2 = NormalPlayTime.valueOf(split[2]);
                            if (split[1].length() != 0) {
                                normalPlayTime3 = NormalPlayTime.valueOf(split[1]);
                            }
                            NormalPlayTime normalPlayTime4 = normalPlayTime3;
                            normalPlayTime3 = normalPlayTime2;
                            normalPlayTime = normalPlayTime4;
                        }
                    }
                }
                normalPlayTime2 = null;
                if (split[1].length() != 0) {
                }
                NormalPlayTime normalPlayTime42 = normalPlayTime3;
                normalPlayTime3 = normalPlayTime2;
                normalPlayTime = normalPlayTime42;
            } else {
                normalPlayTime = null;
            }
            if (split[0].length() != 0 && (!z || (z && split.length > 1))) {
                return new NormalPlayTimeRange(NormalPlayTime.valueOf(split[0]), normalPlayTime, normalPlayTime3);
            }
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse NormalPlayTimeRange: ", str));
    }

    public String getString() {
        return getString(true);
    }

    public String getString(boolean z) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PREFIX);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.timeStart.getString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("-");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        if (this.timeEnd != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.timeEnd.getString());
            sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        if (z) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "/");
            NormalPlayTime normalPlayTime = this.timeDuration;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(normalPlayTime != null ? normalPlayTime.getString() : "*");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return sb;
    }

    public NormalPlayTime getTimeDuration() {
        return this.timeDuration;
    }

    public NormalPlayTime getTimeEnd() {
        return this.timeEnd;
    }

    public NormalPlayTime getTimeStart() {
        return this.timeStart;
    }
}
