package org.fourthline.cling.model.types;

import java.util.logging.Logger;
import me.tvspark.outline;
import okhttp3.internal.p054ws.WebSocketProtocol;

/* loaded from: classes5.dex */
public abstract class UnsignedVariableInteger {
    public static final Logger log = Logger.getLogger(UnsignedVariableInteger.class.getName());
    public long value;

    /* loaded from: classes5.dex */
    public enum Bits {
        EIGHT(255),
        SIXTEEN(WebSocketProtocol.PAYLOAD_SHORT_MAX),
        TWENTYFOUR(16777215),
        THIRTYTWO(4294967295L);
        
        public long maxValue;

        Bits(long j) {
            this.maxValue = j;
        }

        public long getMaxValue() {
            return this.maxValue;
        }
    }

    public UnsignedVariableInteger() {
    }

    public UnsignedVariableInteger(long j) throws NumberFormatException {
        setValue(j);
    }

    public UnsignedVariableInteger(String str) throws NumberFormatException {
        if (str.startsWith("-")) {
            Logger logger = log;
            logger.warning("Invalid negative integer value '" + str + "', assuming value 0!");
            str = "0";
        }
        setValue(Long.parseLong(str.trim()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((UnsignedVariableInteger) obj).value;
    }

    public abstract Bits getBits();

    public int getMinValue() {
        return 0;
    }

    public Long getValue() {
        return Long.valueOf(this.value);
    }

    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >>> 32));
    }

    public UnsignedVariableInteger increment(boolean z) {
        long j = 1;
        if (this.value + 1 > getBits().getMaxValue()) {
            if (!z) {
                j = 0;
            }
            this.value = j;
        } else {
            this.value++;
        }
        return this;
    }

    public void isInRange(long j) throws NumberFormatException {
        if (j < getMinValue() || j > getBits().getMaxValue()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Value must be between ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getMinValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" and ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getBits().getMaxValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(": ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(j);
            throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public UnsignedVariableInteger setValue(long j) {
        isInRange(j);
        this.value = j;
        return this;
    }

    public String toString() {
        return Long.toString(this.value);
    }
}
