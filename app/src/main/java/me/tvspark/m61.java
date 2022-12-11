package me.tvspark;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.seimicrawler.xpath.exception.XpathParserException;

/* loaded from: classes4.dex */
public class m61 implements Comparable<m61> {
    public Object Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwwwww = false;

    public m61(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    public Class Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return obj == null ? Object.class : obj.getClass();
    }

    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = StringUtils.removeEnd(StringUtils.removeEnd(StringUtils.removeStart(StringUtils.removeStart(String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwww), "'"), "\""), "'"), "\"");
        return this;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return obj instanceof List ? StringUtils.join((List) obj, ",") : String.valueOf(obj).trim();
    }

    public Long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long longValue;
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (obj instanceof String) {
            longValue = new BigDecimal((String) this.Wwwwwwwwwwwwwwwwwwwwwwww).setScale(0, 4).longValue();
        } else if (!(obj instanceof Number)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cast to number fail. vale = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            longValue = ((Number) obj).longValue();
        }
        return Long.valueOf(longValue);
    }

    public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        double doubleValue;
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (obj instanceof String) {
            doubleValue = new BigDecimal((String) this.Wwwwwwwwwwwwwwwwwwwwwwww).doubleValue();
        } else if (!(obj instanceof Number)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cast to number fail. vale = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            doubleValue = ((Number) obj).doubleValue();
        }
        return Double.valueOf(doubleValue);
    }

    public Date Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (obj instanceof String) {
            try {
                return DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.parse((String) obj);
            } catch (ParseException unused) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cast to date fail. vale = ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        } else if (obj instanceof Date) {
            return (Date) obj;
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cast to date fail. vale = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public int compareTo(m61 m61Var) {
        if (equals(m61Var)) {
            return 0;
        }
        if (m61Var == null || m61Var.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            return 1;
        }
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (obj == null) {
            return -1;
        }
        if (obj instanceof String) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww().compareTo(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        if (obj instanceof Number) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().compareTo(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unsupported comparable XValue = ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
        throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return Boolean.valueOf(obj != null && !StringUtils.isBlank(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m61.class == obj.getClass()) {
            return Objects.equals(this.Wwwwwwwwwwwwwwwwwwwwwwww, ((m61) obj).Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    public String toString() {
        return new ToStringBuilder(this).append("value", this.Wwwwwwwwwwwwwwwwwwwwwwww).append("isAttr", this.Wwwwwwwwwwwwwwwwwwwwwww).append("isExprStr", this.Wwwwwwwwwwwwwwwwwwwwww).toString();
    }
}
