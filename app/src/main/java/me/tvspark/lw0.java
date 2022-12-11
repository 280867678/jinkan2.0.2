package me.tvspark;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class lw0<T> extends qw0<T> {
    public static qw0<int[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<Integer[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<Byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<char[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<Character[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwww(null);
    public static qw0<long[]> Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwww(null);
    public static qw0<Long[]> Wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<float[]> Wwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<Float[]> Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<double[]> Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<Double[]> Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<boolean[]> Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static qw0<Boolean[]> Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(null);

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwww extends lw0<long[]> {
        public Wwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Number> list = (List) obj;
            long[] jArr = new long[list.size()];
            int i = 0;
            for (Number number : list) {
                jArr[i] = number.intValue();
                i++;
            }
            return jArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwww extends lw0<Character[]> {
        public Wwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Character[] chArr = new Character[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    chArr[i] = Character.valueOf(obj2.toString().charAt(0));
                    i++;
                }
            }
            return chArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwww extends lw0<char[]> {
        public Wwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Object> list = (List) obj;
            char[] cArr = new char[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                cArr[i] = obj2.toString().charAt(0);
                i++;
            }
            return cArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwww extends lw0<Byte[]> {
        public Wwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Byte[] bArr = new Byte[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Byte) {
                        bArr[i] = (Byte) obj2;
                    } else {
                        bArr[i] = Byte.valueOf(((Number) obj2).byteValue());
                    }
                    i++;
                }
            }
            return bArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwww extends lw0<byte[]> {
        public Wwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Number> list = (List) obj;
            byte[] bArr = new byte[list.size()];
            int i = 0;
            for (Number number : list) {
                bArr[i] = number.byteValue();
                i++;
            }
            return bArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwww extends lw0<Short[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Short[] shArr = new Short[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Short) {
                        shArr[i] = (Short) obj2;
                    } else {
                        shArr[i] = Short.valueOf(((Number) obj2).shortValue());
                    }
                    i++;
                }
            }
            return shArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwww extends lw0<short[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Number> list = (List) obj;
            short[] sArr = new short[list.size()];
            int i = 0;
            for (Number number : list) {
                sArr[i] = number.shortValue();
                i++;
            }
            return sArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<Integer[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Integer[] numArr = new Integer[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Integer) {
                        numArr[i] = (Integer) obj2;
                    } else {
                        numArr[i] = Integer.valueOf(((Number) obj2).intValue());
                    }
                    i++;
                }
            }
            return numArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<int[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Number> list = (List) obj;
            int[] iArr = new int[list.size()];
            int i = 0;
            for (Number number : list) {
                iArr[i] = number.intValue();
                i++;
            }
            return iArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<Boolean[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Boolean[] boolArr = new Boolean[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Boolean) {
                        boolArr[i] = Boolean.valueOf(((Boolean) obj2).booleanValue());
                    } else if (!(obj2 instanceof Number)) {
                        throw new RuntimeException("can not convert " + obj2 + " toBoolean");
                    } else {
                        boolArr[i] = Boolean.valueOf(((Number) obj2).intValue() != 0);
                    }
                    i++;
                }
            }
            return boolArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<boolean[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Boolean> list = (List) obj;
            boolean[] zArr = new boolean[list.size()];
            int i = 0;
            for (Boolean bool : list) {
                zArr[i] = bool.booleanValue();
                i++;
            }
            return zArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<Double[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Double[] dArr = new Double[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Double) {
                        dArr[i] = (Double) obj2;
                    } else {
                        dArr[i] = Double.valueOf(((Number) obj2).doubleValue());
                    }
                    i++;
                }
            }
            return dArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<double[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Number> list = (List) obj;
            double[] dArr = new double[list.size()];
            int i = 0;
            for (Number number : list) {
                dArr[i] = number.doubleValue();
                i++;
            }
            return dArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<Float[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Float[] fArr = new Float[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        fArr[i] = (Float) obj2;
                    } else {
                        fArr[i] = Float.valueOf(((Number) obj2).floatValue());
                    }
                    i++;
                }
            }
            return fArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<float[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List<Number> list = (List) obj;
            float[] fArr = new float[list.size()];
            int i = 0;
            for (Number number : list) {
                fArr[i] = number.floatValue();
                i++;
            }
            return fArr;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends lw0<Long[]> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pw0 pw0Var) {
            super(pw0Var);
        }

        @Override // me.tvspark.qw0
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            List list = (List) obj;
            Long[] lArr = new Long[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        lArr[i] = (Long) obj2;
                    } else {
                        lArr[i] = Long.valueOf(((Number) obj2).longValue());
                    }
                    i++;
                }
            }
            return lArr;
        }
    }

    static {
        new Wwwwwwwwwwwwwwwwwwwwwwwww(null);
        new Wwwwwwwwwwwwwwwwwwwwwwww(null);
    }

    public lw0(pw0 pw0Var) {
        super(pw0Var);
    }

    @Override // me.tvspark.qw0
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new ArrayList();
    }

    @Override // me.tvspark.qw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }
}
