package org.fourthline.cling.support.model.dlna.message.header;

import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.message.header.InvalidHeaderException;
import org.fourthline.cling.model.types.BytesRange;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.support.model.dlna.types.NormalPlayTimeRange;
import org.fourthline.cling.support.model.dlna.types.TimeSeekRangeType;

/* loaded from: classes5.dex */
public class TimeSeekRangeHeader extends DLNAHeader<TimeSeekRangeType> {
    public TimeSeekRangeHeader() {
    }

    public TimeSeekRangeHeader(TimeSeekRangeType timeSeekRangeType) {
        setValue(timeSeekRangeType);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        TimeSeekRangeType value = getValue();
        String string = value.getNormalPlayTimeRange().getString();
        if (value.getBytesRange() != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(string, StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(value.getBytesRange().getString(true));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return string;
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.length() != 0) {
            String[] split = str.split(StringUtils.SPACE);
            if (split.length > 0) {
                try {
                    TimeSeekRangeType timeSeekRangeType = new TimeSeekRangeType(NormalPlayTimeRange.valueOf(split[0]));
                    if (split.length > 1) {
                        timeSeekRangeType.setBytesRange(BytesRange.valueOf(split[1]));
                    }
                    setValue(timeSeekRangeType);
                    return;
                } catch (InvalidValueException e) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid TimeSeekRange header value: ", str, "; ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                    throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            }
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid TimeSeekRange header value: ", str));
    }
}
