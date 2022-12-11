package org.fourthline.cling.support.model.dlna.types;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.support.model.dlna.types.CodedDataBuffer;

/* loaded from: classes5.dex */
public class BufferInfoType {
    public static final Pattern pattern = Pattern.compile("^dejitter=(\\d{1,10})(;CDB=(\\d{1,10});BTM=(0|1|2))?(;TD=(\\d{1,10}))?(;BFR=(0|1))?$", 2);
    public CodedDataBuffer cdb;
    public Long dejitterSize;
    public Boolean fullnessReports;
    public Long targetDuration;

    public BufferInfoType(Long l) {
        this.dejitterSize = l;
    }

    public BufferInfoType(Long l, CodedDataBuffer codedDataBuffer, Long l2, Boolean bool) {
        this.dejitterSize = l;
        this.cdb = codedDataBuffer;
        this.targetDuration = l2;
        this.fullnessReports = bool;
    }

    public static BufferInfoType valueOf(String str) throws InvalidValueException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(matcher.group(1)));
                Boolean bool = null;
                CodedDataBuffer codedDataBuffer = matcher.group(2) != null ? new CodedDataBuffer(Long.valueOf(Long.parseLong(matcher.group(3))), CodedDataBuffer.TransferMechanism.values()[Integer.parseInt(matcher.group(4))]) : null;
                Long valueOf2 = matcher.group(5) != null ? Long.valueOf(Long.parseLong(matcher.group(6))) : null;
                if (matcher.group(7) != null) {
                    bool = Boolean.valueOf(matcher.group(8).equals("1"));
                }
                return new BufferInfoType(valueOf, codedDataBuffer, valueOf2, bool);
            } catch (NumberFormatException unused) {
            }
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse BufferInfoType: ", str));
    }

    public CodedDataBuffer getCdb() {
        return this.cdb;
    }

    public Long getDejitterSize() {
        return this.dejitterSize;
    }

    public String getString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dejitter=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.dejitterSize.toString());
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        if (this.cdb != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, ";CDB=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.cdb.getSize().toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(";BTM=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.cdb.getTranfer().ordinal());
            sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        if (this.targetDuration != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, ";TD=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.targetDuration.toString());
            sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        if (this.fullnessReports != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, ";BFR=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.fullnessReports.booleanValue() ? "1" : "0");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
        }
        return sb;
    }

    public Long getTargetDuration() {
        return this.targetDuration;
    }

    public Boolean isFullnessReports() {
        return this.fullnessReports;
    }
}
