package me.tvspark;

import com.just.agentweb.JsCallJava;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Vector;
import org.apache.commons.lang3.SystemUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.fourthline.cling.model.message.header.ContentRangeHeader;
import org.fourthline.cling.model.types.BytesRange;

/* loaded from: classes4.dex */
public class jq0 {
    public static SimpleDateFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Hashtable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Hashtable();
    public File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new File("/");
    public Thread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ServerSocket Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Properties Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Properties();
        public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jq0 jq0Var, String str, String str2, InputStream inputStream) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = inputStream;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jq0 jq0Var, String str, String str2, String str3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayInputStream(str3.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.accept());
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    static {
        StringTokenizer stringTokenizer = new StringTokenizer("css\t\ttext/css js\t\t\ttext/javascript htm\t\ttext/html html\t\ttext/html txt\t\ttext/plain asc\t\ttext/plain gif\t\timage/gif jpg\t\timage/jpeg jpeg\t\timage/jpeg png\t\timage/png mp3\t\taudio/mpeg m3u\t\taudio/mpeg-url pdf\t\tapplication/pdf doc\t\tapplication/msword ogg\t\tapplication/x-ogg zip\t\tapplication/octet-stream exe\t\tapplication/octet-stream class\t\tapplication/octet-stream ");
        while (stringTokenizer.hasMoreTokens()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public jq0(int i) throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ServerSocket(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Thread thread = new Thread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = thread;
        thread.setDaemon(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00db, code lost:
        if (r5 != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, Properties properties, Properties properties2, Properties properties3) {
        String str3;
        String str4;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j;
        long length;
        int indexOf;
        String str5 = str;
        System.out.println(str2 + " '" + str5 + "' ");
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str6 = (String) propertyNames.nextElement();
            PrintStream printStream = System.out;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  HDR: '", str6, "' = '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(properties.getProperty(str6));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("'");
            printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        Enumeration<?> propertyNames2 = properties2.propertyNames();
        while (propertyNames2.hasMoreElements()) {
            String str7 = (String) propertyNames2.nextElement();
            PrintStream printStream2 = System.out;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  PRM: '", str7, "' = '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(properties2.getProperty(str7));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("'");
            printStream2.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        }
        Enumeration<?> propertyNames3 = properties3.propertyNames();
        while (propertyNames3.hasMoreElements()) {
            String str8 = (String) propertyNames3.nextElement();
            PrintStream printStream3 = System.out;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  UPLOADED: '", str8, "' = '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(properties3.getProperty(str8));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append("'");
            printStream3.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        }
        String decode = URLDecoder.decode(str5.replaceFirst("/", ""));
        String str9 = null;
        if (iq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(decode)) {
            hq0 hq0Var = iq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(decode) ? iq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(decode) : null;
            boolean z = hq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (z) {
                if (z) {
                    str3 = hq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            str5 = str3;
        }
        File file = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = !file.isDirectory() ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "500 Internal Server Error", "text/plain", "INTERNAL ERRROR: serveFile(): given homeDir is not a directory.") : null;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            str5 = str5.trim().replace(File.separatorChar, '/');
            if (str5.indexOf(63) >= 0) {
                str5 = str5.substring(0, str5.indexOf(63));
            }
            if (str5.startsWith("..") || str5.endsWith("..") || str5.indexOf("../") >= 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "403 Forbidden", "text/plain", "FORBIDDEN: Won't serve ../ for security reasons.");
            }
        }
        File file2 = new File(file, str5);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null && !file2.exists()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "404 Not Found", "text/plain", "Error 404, file not found.");
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null && file2.isDirectory()) {
            if (!str5.endsWith("/")) {
                str5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, "/");
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "301 Moved Permanently", "text/html", "<html><body>Redirected: <a href=\"" + str5 + "\">" + str5 + "</a></body></html>");
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Location", str5);
            }
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                if (new File(file2, "index.html").exists()) {
                    file2 = new File(file, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, "/index.html"));
                } else if (new File(file2, "index.htm").exists()) {
                    file2 = new File(file, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, "/index.htm"));
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "403 Forbidden", "text/plain", "FORBIDDEN: No directory listing.");
                }
            }
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            try {
                int lastIndexOf = file2.getCanonicalPath().lastIndexOf(46);
                if (lastIndexOf >= 0) {
                    str9 = (String) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(file2.getCanonicalPath().substring(lastIndexOf + 1).toLowerCase());
                }
                if (str9 == null) {
                    str9 = "application/octet-stream";
                }
                long j2 = -1;
                String property = properties.getProperty("range");
                try {
                    if (property != null && property.startsWith(BytesRange.PREFIX) && (indexOf = (property = property.substring(6)).indexOf(45)) > 0) {
                        try {
                            j = Long.parseLong(property.substring(0, indexOf));
                            try {
                                j2 = Long.parseLong(property.substring(indexOf + 1));
                            } catch (NumberFormatException unused) {
                            }
                        } catch (NumberFormatException unused2) {
                        }
                        str4 = "403 Forbidden";
                        length = file2.length();
                        if (property != null || j < 0) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "200 OK", str9, new FileInputStream(file2));
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Content-Length", "" + length);
                        } else if (j >= length) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "416 Requested Range Not Satisfiable", "text/plain", "");
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Content-Range", "bytes 0-0/" + length);
                        } else {
                            if (j2 < 0) {
                                j2 = length - 1;
                            }
                            long j3 = (j2 - j) + 1;
                            long j4 = j3 < 0 ? 0L : j3;
                            kq0 kq0Var = new kq0(this, file2, j4);
                            kq0Var.skip(j);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "206 Partial Content", str9, kq0Var);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Content-Length", "" + j4);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Content-Range", ContentRangeHeader.PREFIX + j + "-" + j2 + "/" + length);
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        }
                    }
                    length = file2.length();
                    if (property != null) {
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "200 OK", str9, new FileInputStream(file2));
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Content-Length", "" + length);
                } catch (IOException unused3) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, str4, "text/plain", "FORBIDDEN: Reading file failed.");
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Accept-Ranges", HttpHeaderValues.BYTES);
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                j = 0;
                str4 = "403 Forbidden";
            } catch (IOException unused4) {
                str4 = "403 Forbidden";
            }
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("Accept-Ranges", HttpHeaderValues.BYTES);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Socket Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Socket socket) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = socket;
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.start();
        }

        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws InterruptedException {
            try {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt == '%') {
                        sb.append((char) Integer.parseInt(str.substring(i + 1, i + 3), 16));
                        i += 2;
                    } else if (charAt != '+') {
                        sb.append(charAt);
                    } else {
                        sb.append(TokenParser.f4579SP);
                    }
                    i++;
                }
                return sb.toString();
            } catch (Exception unused) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("400 Bad Request", "BAD REQUEST: Bad percent-encoding.");
                throw null;
            }
        }

        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            if (i2 > 0) {
                try {
                    File createTempFile = File.createTempFile("NanoHTTPD", "", new File(System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY)));
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    fileOutputStream.write(bArr, i, i2);
                    fileOutputStream.close();
                    return createTempFile.getAbsolutePath();
                } catch (Exception e) {
                    PrintStream printStream = System.err;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                    printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    return "";
                }
            }
            return "";
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BufferedReader bufferedReader, Properties properties, Properties properties2, Properties properties3) throws InterruptedException {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (!stringTokenizer.hasMoreTokens()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("400 Bad Request", "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                    throw null;
                }
                properties.put(JsCallJava.KEY_METHOD, stringTokenizer.nextToken());
                if (!stringTokenizer.hasMoreTokens()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("400 Bad Request", "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    throw null;
                }
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(63);
                if (indexOf >= 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken.substring(indexOf + 1), properties2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken.substring(0, indexOf));
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    while (true) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 == null || readLine2.trim().length() <= 0) {
                            break;
                        }
                        int indexOf2 = readLine2.indexOf(58);
                        if (indexOf2 >= 0) {
                            properties3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(), readLine2.substring(indexOf2 + 1).trim());
                        }
                    }
                }
                properties.put("uri", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (IOException e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SERVER INTERNAL ERROR: IOException: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e.getMessage());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("500 Internal Server Error", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                throw null;
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) throws InterruptedException {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "text/plain", (Properties) null, new ByteArrayInputStream(str2.getBytes()));
            throw new InterruptedException();
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Properties properties) throws InterruptedException {
            if (str == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    properties.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken.substring(0, indexOf)).trim(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken.substring(indexOf + 1)));
                }
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, byte[] bArr, BufferedReader bufferedReader, Properties properties, Properties properties2) throws InterruptedException {
            String readLine;
            int i;
            Properties properties3;
            int indexOf;
            String str2;
            try {
                int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, str.getBytes());
                String readLine2 = bufferedReader.readLine();
                int i2 = 1;
                while (readLine2 != null) {
                    if (!readLine2.contains(str)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
                        throw null;
                    }
                    i2++;
                    Properties properties4 = new Properties();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null || readLine.trim().length() <= 0) {
                            break;
                        }
                        int indexOf2 = readLine.indexOf(58);
                        if (indexOf2 != -1) {
                            properties4.put(readLine.substring(0, indexOf2).trim().toLowerCase(), readLine.substring(indexOf2 + 1).trim());
                        }
                    }
                    if (readLine != null) {
                        String property = properties4.getProperty("content-disposition");
                        if (property == null) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
                            throw null;
                        }
                        StringTokenizer stringTokenizer = new StringTokenizer(property, "; ");
                        Properties properties5 = new Properties();
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            int indexOf3 = nextToken.indexOf(61);
                            if (indexOf3 != -1) {
                                properties5.put(nextToken.substring(0, indexOf3).trim().toLowerCase(), nextToken.substring(indexOf3 + 1).trim());
                            }
                        }
                        String property2 = properties5.getProperty("name");
                        String substring = property2.substring(1, property2.length() - 1);
                        String str3 = "";
                        if (properties4.getProperty("content-type") == null) {
                            while (readLine != null && !readLine.contains(str)) {
                                readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (readLine.indexOf(str) == -1) {
                                        str2 = str3 + readLine;
                                    } else {
                                        str2 = str3 + readLine.substring(0, indexOf - 2);
                                    }
                                    str3 = str2;
                                }
                            }
                            properties3 = properties;
                        } else if (i2 > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("500 Internal Server Error", "Error processing request");
                            throw null;
                        } else {
                            int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2 - 2];
                            while (i3 < bArr.length) {
                                if (bArr[i3] == 13) {
                                    i3++;
                                    if (bArr[i3] == 10) {
                                        i3++;
                                        if (bArr[i3] == 13) {
                                            i3++;
                                            if (bArr[i3] == 10) {
                                                break;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                i3++;
                            }
                            properties2.put(substring, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i3 + 1, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2 - 1] - i) - 4));
                            String property3 = properties5.getProperty(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME);
                            str3 = property3.substring(1, property3.length() - 1);
                            do {
                                readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } while (!readLine.contains(str));
                            properties3 = properties;
                        }
                        properties3.put(substring, str3);
                    }
                    readLine2 = readLine;
                }
            } catch (IOException e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SERVER INTERNAL ERROR: IOException: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e.getMessage());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("500 Internal Server Error", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                throw null;
            }
        }

        public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, byte[] bArr2) {
            Vector vector = new Vector();
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            while (i < bArr.length) {
                if (bArr[i] == bArr2[i2]) {
                    if (i2 == 0) {
                        i3 = i;
                    }
                    i2++;
                    if (i2 == bArr2.length) {
                        vector.addElement(new Integer(i3));
                    } else {
                        i++;
                    }
                } else {
                    i -= i2;
                }
                i2 = 0;
                i3 = -1;
                i++;
            }
            int size = vector.size();
            int[] iArr = new int[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = ((Integer) vector.elementAt(i4)).intValue();
            }
            return iArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[Catch: InterruptedException -> 0x0195, IOException -> 0x019a, TryCatch #4 {IOException -> 0x019a, InterruptedException -> 0x0195, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0019, B:94:0x0053, B:17:0x006e, B:19:0x0074, B:21:0x007c, B:23:0x0082, B:27:0x008e, B:29:0x0096, B:32:0x009f, B:33:0x00b2, B:37:0x00bc, B:39:0x00c7, B:44:0x00cd, B:46:0x00ea, B:49:0x00ff, B:50:0x0105, B:52:0x010d, B:55:0x0115, B:57:0x0127, B:58:0x0138, B:61:0x013f, B:64:0x0146, B:65:0x0148, B:67:0x014e, B:69:0x0156, B:71:0x016b, B:74:0x0172, B:76:0x017c, B:78:0x018e, B:87:0x008a, B:99:0x005f), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[Catch: InterruptedException -> 0x0195, IOException -> 0x019a, TryCatch #4 {IOException -> 0x019a, InterruptedException -> 0x0195, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0019, B:94:0x0053, B:17:0x006e, B:19:0x0074, B:21:0x007c, B:23:0x0082, B:27:0x008e, B:29:0x0096, B:32:0x009f, B:33:0x00b2, B:37:0x00bc, B:39:0x00c7, B:44:0x00cd, B:46:0x00ea, B:49:0x00ff, B:50:0x0105, B:52:0x010d, B:55:0x0115, B:57:0x0127, B:58:0x0138, B:61:0x013f, B:64:0x0146, B:65:0x0148, B:67:0x014e, B:69:0x0156, B:71:0x016b, B:74:0x0172, B:76:0x017c, B:78:0x018e, B:87:0x008a, B:99:0x005f), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009f A[Catch: InterruptedException -> 0x0195, IOException -> 0x019a, TryCatch #4 {IOException -> 0x019a, InterruptedException -> 0x0195, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0019, B:94:0x0053, B:17:0x006e, B:19:0x0074, B:21:0x007c, B:23:0x0082, B:27:0x008e, B:29:0x0096, B:32:0x009f, B:33:0x00b2, B:37:0x00bc, B:39:0x00c7, B:44:0x00cd, B:46:0x00ea, B:49:0x00ff, B:50:0x0105, B:52:0x010d, B:55:0x0115, B:57:0x0127, B:58:0x0138, B:61:0x013f, B:64:0x0146, B:65:0x0148, B:67:0x014e, B:69:0x0156, B:71:0x016b, B:74:0x0172, B:76:0x017c, B:78:0x018e, B:87:0x008a, B:99:0x005f), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00c7 A[Catch: InterruptedException -> 0x0195, IOException -> 0x019a, TryCatch #4 {IOException -> 0x019a, InterruptedException -> 0x0195, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0019, B:94:0x0053, B:17:0x006e, B:19:0x0074, B:21:0x007c, B:23:0x0082, B:27:0x008e, B:29:0x0096, B:32:0x009f, B:33:0x00b2, B:37:0x00bc, B:39:0x00c7, B:44:0x00cd, B:46:0x00ea, B:49:0x00ff, B:50:0x0105, B:52:0x010d, B:55:0x0115, B:57:0x0127, B:58:0x0138, B:61:0x013f, B:64:0x0146, B:65:0x0148, B:67:0x014e, B:69:0x0156, B:71:0x016b, B:74:0x0172, B:76:0x017c, B:78:0x018e, B:87:0x008a, B:99:0x005f), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ca A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ea A[Catch: InterruptedException -> 0x0195, IOException -> 0x019a, TRY_LEAVE, TryCatch #4 {IOException -> 0x019a, InterruptedException -> 0x0195, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0019, B:94:0x0053, B:17:0x006e, B:19:0x0074, B:21:0x007c, B:23:0x0082, B:27:0x008e, B:29:0x0096, B:32:0x009f, B:33:0x00b2, B:37:0x00bc, B:39:0x00c7, B:44:0x00cd, B:46:0x00ea, B:49:0x00ff, B:50:0x0105, B:52:0x010d, B:55:0x0115, B:57:0x0127, B:58:0x0138, B:61:0x013f, B:64:0x0146, B:65:0x0148, B:67:0x014e, B:69:0x0156, B:71:0x016b, B:74:0x0172, B:76:0x017c, B:78:0x018e, B:87:0x008a, B:99:0x005f), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x017c A[Catch: InterruptedException -> 0x0195, IOException -> 0x019a, TryCatch #4 {IOException -> 0x019a, InterruptedException -> 0x0195, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0019, B:94:0x0053, B:17:0x006e, B:19:0x0074, B:21:0x007c, B:23:0x0082, B:27:0x008e, B:29:0x0096, B:32:0x009f, B:33:0x00b2, B:37:0x00bc, B:39:0x00c7, B:44:0x00cd, B:46:0x00ea, B:49:0x00ff, B:50:0x0105, B:52:0x010d, B:55:0x0115, B:57:0x0127, B:58:0x0138, B:61:0x013f, B:64:0x0146, B:65:0x0148, B:67:0x014e, B:69:0x0156, B:71:0x016b, B:74:0x0172, B:76:0x017c, B:78:0x018e, B:87:0x008a, B:99:0x005f), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x018e A[Catch: InterruptedException -> 0x0195, IOException -> 0x019a, TRY_LEAVE, TryCatch #4 {IOException -> 0x019a, InterruptedException -> 0x0195, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0019, B:94:0x0053, B:17:0x006e, B:19:0x0074, B:21:0x007c, B:23:0x0082, B:27:0x008e, B:29:0x0096, B:32:0x009f, B:33:0x00b2, B:37:0x00bc, B:39:0x00c7, B:44:0x00cd, B:46:0x00ea, B:49:0x00ff, B:50:0x0105, B:52:0x010d, B:55:0x0115, B:57:0x0127, B:58:0x0138, B:61:0x013f, B:64:0x0146, B:65:0x0148, B:67:0x014e, B:69:0x0156, B:71:0x016b, B:74:0x0172, B:76:0x017c, B:78:0x018e, B:87:0x008a, B:99:0x005f), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x008d A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            byte[] bArr;
            int read;
            InputStream inputStream;
            long parseInt;
            int i;
            boolean z;
            int i2;
            byte[] bArr2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int read2;
            try {
                InputStream inputStream2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.getInputStream();
                if (inputStream2 == null || (read = inputStream2.read((bArr = new byte[8192]), 0, 8192)) <= 0) {
                    return;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, read)));
                Properties properties = new Properties();
                Properties properties2 = new Properties();
                Properties properties3 = new Properties();
                Properties properties4 = new Properties();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bufferedReader, properties, properties2, properties3);
                String property = properties.getProperty(JsCallJava.KEY_METHOD);
                String property2 = properties.getProperty("uri");
                String property3 = properties3.getProperty("content-length");
                if (property3 != null) {
                    try {
                        inputStream = inputStream2;
                        parseInt = Integer.parseInt(property3);
                    } catch (NumberFormatException e) {
                        inputStream = inputStream2;
                        e.printStackTrace();
                    }
                    i = 0;
                    while (true) {
                        if (i < read) {
                            z = false;
                            break;
                        }
                        if (bArr[i] == 13) {
                            i++;
                            if (bArr[i] == 10) {
                                i++;
                                if (bArr[i] == 13) {
                                    i++;
                                    if (bArr[i] == 10) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                        i++;
                    }
                    i2 = i + 1;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (i2 < read) {
                        byteArrayOutputStream.write(bArr, i2, read - i2);
                    }
                    if (i2 >= read) {
                        parseInt -= (read - i2) + 1;
                    } else if (!z || parseInt == Long.MAX_VALUE) {
                        parseInt = 0;
                    }
                    bArr2 = new byte[512];
                    while (read >= 0 && parseInt > 0) {
                        InputStream inputStream3 = inputStream;
                        read = inputStream3.read(bArr2, 0, 512);
                        parseInt -= read;
                        if (read <= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        inputStream = inputStream3;
                    }
                    InputStream inputStream4 = inputStream;
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArray)));
                    if (property.equalsIgnoreCase("POST")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(properties3.getProperty("content-type"), "; ");
                        String str = "";
                        if (!(stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : str).equalsIgnoreCase("multipart/form-data")) {
                            char[] cArr = new char[512];
                            while (true) {
                                if (bufferedReader2.read(cArr) < 0 || str.endsWith("\r\n")) {
                                    break;
                                }
                                str = str + String.valueOf(cArr, 0, read2);
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.trim(), properties2);
                        } else if (!stringTokenizer.hasMoreTokens()) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                            throw null;
                        } else {
                            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "=");
                            if (stringTokenizer2.countTokens() != 2) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary syntax error. Usage: GET /example/file.html");
                                throw null;
                            } else {
                                stringTokenizer2.nextToken();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer2.nextToken(), byteArray, bufferedReader2, properties2, properties4);
                            }
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(property2, property, properties3, properties2, properties4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("500 Internal Server Error", "SERVER INTERNAL ERROR: Serve() returned a null response.");
                        throw null;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    bufferedReader2.close();
                    inputStream4.close();
                    return;
                }
                inputStream = inputStream2;
                parseInt = Long.MAX_VALUE;
                i = 0;
                while (true) {
                    if (i < read) {
                    }
                    i++;
                }
                i2 = i + 1;
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                if (i2 < read) {
                }
                if (i2 >= read) {
                }
                bArr2 = new byte[512];
                while (read >= 0) {
                    InputStream inputStream32 = inputStream;
                    read = inputStream32.read(bArr2, 0, 512);
                    parseInt -= read;
                    if (read <= 0) {
                    }
                    inputStream = inputStream32;
                }
                InputStream inputStream42 = inputStream;
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                BufferedReader bufferedReader22 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArray2)));
                if (property.equalsIgnoreCase("POST")) {
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(property2, property, properties3, properties2, properties4);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                }
            } catch (IOException e2) {
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("500 Internal Server Error", "SERVER INTERNAL ERROR: IOException: " + e2.getMessage());
                    throw null;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, Properties properties, InputStream inputStream) {
            try {
                try {
                    if (str == null) {
                        throw new Error("sendResponse(): Status can't be null.");
                    }
                    OutputStream outputStream = this.Wwwwwwwwwwwwwwwwwwwwwwww.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.print("HTTP/1.0 " + str + " \r\n");
                    if (str2 != null) {
                        printWriter.print("Content-Type: " + str2 + "\r\n");
                    }
                    if (properties == null || properties.getProperty("Date") == null) {
                        printWriter.print("Date: " + jq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.format(new Date()) + "\r\n");
                    }
                    if (properties != null) {
                        Enumeration keys = properties.keys();
                        while (keys.hasMoreElements()) {
                            String str3 = (String) keys.nextElement();
                            String property = properties.getProperty(str3);
                            printWriter.print(str3 + ": " + property + "\r\n");
                        }
                    }
                    printWriter.print("\r\n");
                    printWriter.flush();
                    if (inputStream != null) {
                        int available = inputStream.available();
                        byte[] bArr = new byte[2048];
                        while (available > 0) {
                            int read = inputStream.read(bArr, 0, available > 2048 ? 2048 : available);
                            if (read <= 0) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                            available -= read;
                        }
                    }
                    outputStream.flush();
                    outputStream.close();
                    if (inputStream == null) {
                        return;
                    }
                    inputStream.close();
                } catch (IOException unused) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
