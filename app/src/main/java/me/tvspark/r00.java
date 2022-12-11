package me.tvspark;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class r00 extends AbstractC3508o00 {
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public r00(Boolean bool) {
        if (bool != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bool;
            return;
        }
        throw null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r00 r00Var) {
        Object obj = r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (obj instanceof Number) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString();
        }
        return obj instanceof Boolean ? ((Boolean) obj).toString() : (String) obj;
    }

    public Number Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return obj instanceof String ? new LazilyParsedNumber((String) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : (Number) obj;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r00.class != obj.getClass()) {
            return false;
        }
        r00 r00Var = (r00) obj;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r00Var)) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().longValue() == r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().longValue();
        } else if (!(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Number) || !(r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Number)) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            double doubleValue = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue();
            double doubleValue2 = r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return 31;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
            doubleToLongBits = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().longValue();
        } else {
            Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public r00(Number number) {
        if (number != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = number;
            return;
        }
        throw null;
    }

    public r00(String str) {
        if (str != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            return;
        }
        throw null;
    }
}
