package me.tvspark;

import com.jayway.jsonpath.spi.mapper.MappingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes4.dex */
public class d50 implements e50 {
    public static pw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<String> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<Long> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public Long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            long longValue;
            if (obj == null) {
                return null;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return (Long) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                longValue = ((Integer) obj).longValue();
            } else if (Double.class.isAssignableFrom(obj.getClass())) {
                longValue = ((Double) obj).longValue();
            } else if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                longValue = ((BigDecimal) obj).longValue();
            } else if (!Float.class.isAssignableFrom(obj.getClass())) {
                if (String.class.isAssignableFrom(obj.getClass())) {
                    return Long.valueOf(obj.toString());
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not map a ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" to ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Long.class.getName());
                throw new MappingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                longValue = ((Float) obj).longValue();
            }
            return Long.valueOf(longValue);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<Integer> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            int intValue;
            if (obj == null) {
                return null;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return (Integer) obj;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                intValue = ((Long) obj).intValue();
            } else if (Double.class.isAssignableFrom(obj.getClass())) {
                intValue = ((Double) obj).intValue();
            } else if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                intValue = ((BigDecimal) obj).intValue();
            } else if (!Float.class.isAssignableFrom(obj.getClass())) {
                if (String.class.isAssignableFrom(obj.getClass())) {
                    return Integer.valueOf(obj.toString());
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not map a ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" to ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.class.getName());
                throw new MappingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                intValue = ((Float) obj).intValue();
            }
            return Integer.valueOf(intValue);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<Float> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public Float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            float floatValue;
            if (obj == null) {
                return null;
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return (Float) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                floatValue = ((Integer) obj).floatValue();
            } else if (Long.class.isAssignableFrom(obj.getClass())) {
                floatValue = ((Long) obj).floatValue();
            } else if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                floatValue = ((BigDecimal) obj).floatValue();
            } else if (!Double.class.isAssignableFrom(obj.getClass())) {
                if (String.class.isAssignableFrom(obj.getClass())) {
                    return Float.valueOf(obj.toString());
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not map a ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" to ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Float.class.getName());
                throw new MappingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                floatValue = ((Double) obj).floatValue();
            }
            return Float.valueOf(floatValue);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<Double> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            double doubleValue;
            if (obj == null) {
                return null;
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return (Double) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                doubleValue = ((Integer) obj).doubleValue();
            } else if (Long.class.isAssignableFrom(obj.getClass())) {
                doubleValue = ((Long) obj).doubleValue();
            } else if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                doubleValue = ((BigDecimal) obj).doubleValue();
            } else if (!Float.class.isAssignableFrom(obj.getClass())) {
                if (String.class.isAssignableFrom(obj.getClass())) {
                    return Double.valueOf(obj.toString());
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not map a ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" to ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Double.class.getName());
                throw new MappingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                doubleValue = ((Float) obj).doubleValue();
            }
            return Double.valueOf(doubleValue);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<Date> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public Date Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Date.class.isAssignableFrom(obj.getClass())) {
                return (Date) obj;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return new Date(((Long) obj).longValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                try {
                    return DateFormat.getInstance().parse(obj.toString());
                } catch (ParseException e) {
                    throw new MappingException(e);
                }
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not map a ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" to ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Date.class.getName());
            throw new MappingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<Boolean> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Boolean.class.isAssignableFrom(obj.getClass())) {
                return (Boolean) obj;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not map a ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" to ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Boolean.class.getName());
            throw new MappingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<BigInteger> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public BigInteger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            if (obj == null) {
                return null;
            }
            return new BigInteger(obj.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends qw0<BigDecimal> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.qw0
        public BigDecimal Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            if (obj == null) {
                return null;
            }
            return new BigDecimal(obj.toString());
        }
    }

    static {
        pw0 pw0Var = new pw0();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pw0Var;
        pw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Long.class, new Wwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Long.TYPE, new Wwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Integer.class, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Integer.TYPE, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Double.class, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Double.TYPE, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Float.class, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Float.TYPE, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(BigDecimal.class, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(String.class, new Wwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Date.class, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var12 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(BigInteger.class, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        pw0 pw0Var13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pw0Var13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Boolean.TYPE, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}
