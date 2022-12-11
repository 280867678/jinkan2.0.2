package org.fourthline.cling.support.model.dlna.message.header;

import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.message.header.InvalidHeaderException;
import org.fourthline.cling.model.types.BytesRange;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.support.model.dlna.types.AvailableSeekRangeType;
import org.fourthline.cling.support.model.dlna.types.NormalPlayTimeRange;

/* loaded from: classes5.dex */
public class AvailableSeekRangeHeader extends DLNAHeader<AvailableSeekRangeType> {
    public AvailableSeekRangeHeader() {
    }

    public AvailableSeekRangeHeader(AvailableSeekRangeType availableSeekRangeType) {
        setValue(availableSeekRangeType);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        AvailableSeekRangeType value = getValue();
        String num = Integer.toString(value.getModeFlag().ordinal());
        if (value.getNormalPlayTimeRange() != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(num, StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(value.getNormalPlayTimeRange().getString(false));
            num = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        if (value.getBytesRange() != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(num, StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(value.getBytesRange().getString(false));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        return num;
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        NormalPlayTimeRange normalPlayTimeRange;
        AvailableSeekRangeType availableSeekRangeType;
        if (str.length() != 0) {
            String[] split = str.split(StringUtils.SPACE);
            boolean z = true;
            try {
                if (split.length > 1) {
                    try {
                        AvailableSeekRangeType.Mode valueOf = AvailableSeekRangeType.Mode.valueOf("MODE_" + split[0]);
                        BytesRange bytesRange = null;
                        try {
                            try {
                                normalPlayTimeRange = NormalPlayTimeRange.valueOf(split[1], true);
                            } catch (InvalidValueException unused) {
                                throw new InvalidValueException("Invalid AvailableSeekRange Range");
                            }
                        } catch (InvalidValueException unused2) {
                            normalPlayTimeRange = null;
                            bytesRange = BytesRange.valueOf(split[1]);
                            z = false;
                        }
                        if (!z) {
                            availableSeekRangeType = new AvailableSeekRangeType(valueOf, bytesRange);
                        } else if (split.length > 2) {
                            setValue(new AvailableSeekRangeType(valueOf, normalPlayTimeRange, BytesRange.valueOf(split[2])));
                            return;
                        } else {
                            availableSeekRangeType = new AvailableSeekRangeType(valueOf, normalPlayTimeRange);
                        }
                        setValue(availableSeekRangeType);
                        return;
                    } catch (IllegalArgumentException unused3) {
                        throw new InvalidValueException("Invalid AvailableSeekRange Mode");
                    }
                }
            } catch (InvalidValueException e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid AvailableSeekRange header value: ", str, "; ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid AvailableSeekRange header value: ", str));
    }
}
