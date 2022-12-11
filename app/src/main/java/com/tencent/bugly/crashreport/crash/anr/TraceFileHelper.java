package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.C1199X;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class TraceFileHelper {

    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a */
    /* loaded from: classes3.dex */
    public static class C1147a {

        /* renamed from: a */
        public long f1173a;

        /* renamed from: b */
        public String f1174b;

        /* renamed from: c */
        public long f1175c;

        /* renamed from: d */
        public Map<String, String[]> f1176d;
    }

    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b */
    /* loaded from: classes3.dex */
    public interface AbstractC1148b {
        /* renamed from: a */
        boolean mo3307a(long j);

        /* renamed from: a */
        boolean mo3306a(long j, long j2, String str);

        /* renamed from: a */
        boolean mo3305a(String str, int i, String str2, String str3, boolean z);

        /* renamed from: a */
        boolean mo3304a(String str, long j, long j2);
    }

    /* renamed from: a */
    public static String m3334a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r5.matcher(r1).matches() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
        if (r8 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
        r1 = r7.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        r2 = r8.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        if (r4 >= r2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
        r5 = r8[r4];
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object[] m3333a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null) {
        }
        return null;
    }

    /* renamed from: b */
    public static String m3332b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static C1147a readFirstDumpInfo(String str, boolean z) {
        if (str == null) {
            C1199X.m3081b("path:%s", str);
            return null;
        }
        C1147a c1147a = new C1147a();
        readTraceFile(str, new C1157i(c1147a, z));
        if (c1147a.f1173a > 0 && c1147a.f1175c > 0 && c1147a.f1174b != null) {
            return c1147a;
        }
        C1199X.m3081b("first dump error %s", c1147a.f1173a + StringUtils.SPACE + c1147a.f1175c + StringUtils.SPACE + c1147a.f1174b);
        return null;
    }

    public static C1147a readTargetDumpInfo(String str, String str2, boolean z) {
        if (str != null && str2 != null) {
            C1147a c1147a = new C1147a();
            readTraceFile(str2, new C1156h(c1147a, str, z));
            if (c1147a.f1173a > 0 && c1147a.f1175c > 0 && c1147a.f1174b != null) {
                return c1147a;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, AbstractC1148b abstractC1148b) {
        BufferedReader bufferedReader;
        IOException iOException;
        if (str == null || abstractC1148b == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists() || !abstractC1148b.mo3304a(str, file.lastModified(), file.length())) {
            return;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
            Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
            Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
            Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            while (true) {
                Object[] m3333a = m3333a(bufferedReader, compile);
                if (m3333a == null) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e2) {
                        iOException = e2;
                        if (C1199X.m3080b(iOException)) {
                            return;
                        }
                        iOException.printStackTrace();
                    }
                }
                String[] split = m3333a[1].toString().split("\\s");
                long parseLong = Long.parseLong(split[2]);
                StringBuilder sb = new StringBuilder();
                sb.append(split[4]);
                sb.append(StringUtils.SPACE);
                sb.append(split[5]);
                long time = simpleDateFormat.parse(sb.toString()).getTime();
                Object[] m3333a2 = m3333a(bufferedReader, compile3);
                if (m3333a2 == null) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e3) {
                        if (C1199X.m3080b(e3)) {
                            return;
                        }
                        e3.printStackTrace();
                        return;
                    }
                }
                Matcher matcher = compile3.matcher(m3333a2[1].toString());
                matcher.find();
                matcher.group(1);
                SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                if (!abstractC1148b.mo3306a(parseLong, time, matcher.group(1))) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e4) {
                        if (C1199X.m3080b(e4)) {
                            return;
                        }
                        e4.printStackTrace();
                        return;
                    }
                }
                while (true) {
                    Object[] m3333a3 = m3333a(bufferedReader, compile4, compile2);
                    if (m3333a3 == null) {
                        break;
                    } else if (m3333a3[0] == compile4) {
                        String obj = m3333a3[1].toString();
                        Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                        matcher2.find();
                        String group = matcher2.group();
                        String substring = group.substring(1, group.length() - 1);
                        boolean contains = obj.contains("NATIVE");
                        Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                        matcher3.find();
                        String group2 = matcher3.group();
                        if (!abstractC1148b.mo3305a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), m3332b(bufferedReader), m3334a(bufferedReader), contains)) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e5) {
                                if (C1199X.m3080b(e5)) {
                                    return;
                                }
                                e5.printStackTrace();
                                return;
                            }
                        }
                    } else if (!abstractC1148b.mo3307a(Long.parseLong(m3333a3[1].toString().split("\\s")[2]))) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e6) {
                            if (C1199X.m3080b(e6)) {
                                return;
                            }
                            e6.printStackTrace();
                            return;
                        }
                    }
                }
                simpleDateFormat = simpleDateFormat2;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader2 = bufferedReader;
            if (!C1199X.m3080b(e)) {
                e.printStackTrace();
            }
            Object[] objArr = new Object[2];
            objArr[0] = e.getClass().getName();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(e.getMessage());
            objArr[1] = sb2.toString();
            C1199X.m3076e("trace open fail:%s : %s", objArr);
            if (bufferedReader2 == null) {
                return;
            }
            try {
                bufferedReader2.close();
            } catch (IOException e8) {
                iOException = e8;
                if (C1199X.m3080b(iOException)) {
                    return;
                }
                iOException.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e9) {
                    if (!C1199X.m3080b(e9)) {
                        e9.printStackTrace();
                    }
                }
            }
            throw th3;
        }
    }
}
