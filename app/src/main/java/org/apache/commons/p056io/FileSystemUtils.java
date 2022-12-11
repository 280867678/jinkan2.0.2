package org.apache.commons.p056io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: org.apache.commons.io.FileSystemUtils */
/* loaded from: classes4.dex */
public class FileSystemUtils {

    /* renamed from: DF */
    public static final String f4546DF;
    public static final int INIT_PROBLEM = -1;
    public static final FileSystemUtils INSTANCE = new FileSystemUtils();

    /* renamed from: OS */
    public static final int f4547OS;
    public static final int OTHER = 0;
    public static final int POSIX_UNIX = 3;
    public static final int UNIX = 2;
    public static final int WINDOWS = 1;

    static {
        int i;
        String property;
        String str = "df";
        try {
            property = System.getProperty("os.name");
        } catch (Exception unused) {
            i = -1;
        }
        if (property != null) {
            String lowerCase = property.toLowerCase(Locale.ENGLISH);
            i = 3;
            if (lowerCase.contains("windows")) {
                i = 1;
            } else {
                if (!lowerCase.contains("linux") && !lowerCase.contains("mpe/ix") && !lowerCase.contains("freebsd") && !lowerCase.contains("irix") && !lowerCase.contains("digital unix") && !lowerCase.contains("unix") && !lowerCase.contains("mac os x")) {
                    if (!lowerCase.contains("sun os") && !lowerCase.contains("sunos") && !lowerCase.contains("solaris")) {
                        if (!lowerCase.contains("hp-ux") && !lowerCase.contains("aix")) {
                            i = 0;
                        }
                    }
                    str = "/usr/xpg4/bin/df";
                }
                i = 2;
            }
            f4547OS = i;
            f4546DF = str;
            return;
        }
        throw new IOException("os.name not found");
    }

    @Deprecated
    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, f4547OS, false, -1L);
    }

    public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1L);
    }

    public static long freeSpaceKb(long j) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), j);
    }

    public static long freeSpaceKb(String str) throws IOException {
        return freeSpaceKb(str, -1L);
    }

    public static long freeSpaceKb(String str, long j) throws IOException {
        return INSTANCE.freeSpaceOS(str, f4547OS, true, j);
    }

    public long freeSpaceOS(String str, int i, boolean z, long j) throws IOException {
        if (str != null) {
            if (i == 0) {
                throw new IllegalStateException("Unsupported operating system");
            }
            if (i == 1) {
                long freeSpaceWindows = freeSpaceWindows(str, j);
                return z ? freeSpaceWindows / 1024 : freeSpaceWindows;
            } else if (i == 2) {
                return freeSpaceUnix(str, z, false, j);
            } else {
                if (i != 3) {
                    throw new IllegalStateException("Exception caught when determining operating system");
                }
                return freeSpaceUnix(str, z, true, j);
            }
        }
        throw new IllegalArgumentException("Path must not be null");
    }

    public long freeSpaceUnix(String str, boolean z, boolean z2, long j) throws IOException {
        if (!str.isEmpty()) {
            String str2 = z ? "-k" : "-";
            if (z2) {
                str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "P");
            }
            List<String> performCommand = performCommand(str2.length() > 1 ? new String[]{f4546DF, str2, str} : new String[]{f4546DF, str}, 3, j);
            if (performCommand.size() < 2) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Command line '");
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f4546DF, "' did not return info as expected ", "for path '", str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'- response was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(performCommand);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            StringTokenizer stringTokenizer = new StringTokenizer(performCommand.get(1), StringUtils.SPACE);
            if (stringTokenizer.countTokens() >= 4) {
                stringTokenizer.nextToken();
            } else if (stringTokenizer.countTokens() != 1 || performCommand.size() < 3) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Command line '");
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, f4546DF, "' did not return data as expected ", "for path '", str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("'- check path is valid");
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else {
                stringTokenizer = new StringTokenizer(performCommand.get(2), StringUtils.SPACE);
            }
            stringTokenizer.nextToken();
            stringTokenizer.nextToken();
            return parseBytes(stringTokenizer.nextToken(), str);
        }
        throw new IllegalArgumentException("Path must not be empty");
    }

    public long freeSpaceWindows(String str, long j) throws IOException {
        String normalize = FilenameUtils.normalize(str, false);
        if (normalize.length() > 0 && normalize.charAt(0) != '\"') {
            normalize = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\"", normalize, "\"");
        }
        List<String> performCommand = performCommand(new String[]{"cmd.exe", "/C", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dir /a /-c ", normalize)}, Integer.MAX_VALUE, j);
        for (int size = performCommand.size() - 1; size >= 0; size--) {
            String str2 = performCommand.get(size);
            if (str2.length() > 0) {
                return parseDir(str2, normalize);
            }
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Command line 'dir /-c' did not return any info for path '", normalize, "'"));
    }

    public Process openProcess(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }

    public long parseBytes(String str, String str2) throws IOException {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException("Command line '" + f4546DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Command line '");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f4546DF, "' did not return numeric data as expected ", "for path '", str2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'- check path is valid");
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public long parseDir(String str, String str2) throws IOException {
        int i;
        int i2;
        int i3;
        int length = str.length();
        while (true) {
            length--;
            i = 0;
            if (length < 0) {
                i2 = 0;
                break;
            } else if (Character.isDigit(str.charAt(length))) {
                i2 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i3 = 0;
                break;
            }
            char charAt = str.charAt(length);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i3 = length + 1;
                break;
            }
            length--;
        }
        if (length >= 0) {
            StringBuilder sb = new StringBuilder(str.substring(i3, i2));
            while (i < sb.length()) {
                if (sb.charAt(i) == ',' || sb.charAt(i) == '.') {
                    sb.deleteCharAt(i);
                    i--;
                }
                i++;
            }
            return parseBytes(sb.toString(), str2);
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Command line 'dir /-c' did not return valid info for path '", str2, "'"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> performCommand(String[] strArr, int i, long j) throws IOException {
        Process process;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream inputStream2;
        ?? r7;
        ?? r72;
        Thread start;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream3 = null;
        try {
            start = ThreadMonitor.start(j);
            process = openProcess(strArr);
            try {
                inputStream = process.getInputStream();
            } catch (InterruptedException e) {
                e = e;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                inputStream2 = outputStream;
                r72 = inputStream2;
                IOUtils.closeQuietly(inputStream3);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly((Reader) r72);
                if (process != null) {
                }
                throw th;
            }
            try {
                outputStream = process.getOutputStream();
            } catch (InterruptedException e2) {
                e = e2;
                outputStream = null;
                inputStream2 = outputStream;
                r7 = inputStream2;
                inputStream3 = process;
                r7 = r7;
                try {
                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                } catch (Throwable th2) {
                    th = th2;
                    process = inputStream3;
                    inputStream3 = inputStream;
                    r72 = r7;
                    IOUtils.closeQuietly(inputStream3);
                    IOUtils.closeQuietly(outputStream);
                    IOUtils.closeQuietly(inputStream2);
                    IOUtils.closeQuietly((Reader) r72);
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                inputStream2 = null;
            }
        } catch (InterruptedException e3) {
            e = e3;
            inputStream = null;
            outputStream = null;
            inputStream2 = null;
            r7 = 0;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            outputStream = null;
        }
        try {
            inputStream2 = process.getErrorStream();
            try {
                r7 = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
                while (true) {
                    try {
                        String readLine = r7.readLine();
                        if (readLine == null || arrayList.size() >= i) {
                            break;
                        }
                        arrayList.add(readLine.toLowerCase(Locale.ENGLISH).trim());
                    } catch (InterruptedException e4) {
                        e = e4;
                        inputStream3 = process;
                        r7 = r7;
                        throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream3 = inputStream;
                        r72 = r7;
                        IOUtils.closeQuietly(inputStream3);
                        IOUtils.closeQuietly(outputStream);
                        IOUtils.closeQuietly(inputStream2);
                        IOUtils.closeQuietly((Reader) r72);
                        if (process != null) {
                        }
                        throw th;
                    }
                }
                process.waitFor();
                ThreadMonitor.stop(start);
                if (process.exitValue() != 0) {
                    throw new IOException("Command line returned OS error code '" + process.exitValue() + "' for command " + Arrays.asList(strArr));
                } else if (arrayList.isEmpty()) {
                    throw new IOException("Command line did not return any info for command " + Arrays.asList(strArr));
                } else {
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(outputStream);
                    IOUtils.closeQuietly(inputStream2);
                    IOUtils.closeQuietly((Reader) r7);
                    process.destroy();
                    return arrayList;
                }
            } catch (InterruptedException e5) {
                e = e5;
                r7 = 0;
            } catch (Throwable th6) {
                th = th6;
                r7 = 0;
            }
        } catch (InterruptedException e6) {
            e = e6;
            inputStream2 = null;
            r7 = inputStream2;
            inputStream3 = process;
            r7 = r7;
            throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
        } catch (Throwable th7) {
            th = th7;
            inputStream2 = null;
            r7 = inputStream2;
            inputStream3 = inputStream;
            r72 = r7;
            IOUtils.closeQuietly(inputStream3);
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inputStream2);
            IOUtils.closeQuietly((Reader) r72);
            if (process != null) {
            }
            throw th;
        }
    }
}
