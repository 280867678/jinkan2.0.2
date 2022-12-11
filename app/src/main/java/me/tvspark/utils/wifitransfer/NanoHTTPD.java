package me.tvspark.utils.wifitransfer;

import com.just.agentweb.JsCallJava;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public abstract class NanoHTTPD {
    public Thread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ServerSocket Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public Wwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, null);
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, null);

    /* loaded from: classes4.dex */
    public enum Method {
        GET,
        PUT,
        POST,
        DELETE;

        public static Method lookup(String str) {
            Method[] values;
            for (Method method : values()) {
                if (method.toString().equalsIgnoreCase(str)) {
                    return method;
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class Response {
        public Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
        public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Status Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public enum Status {
            OK(200, "OK"),
            CREATED(201, "Created"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            REDIRECT(301, "Moved Permanently"),
            NOT_MODIFIED(304, "Not Modified"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            INTERNAL_ERROR(500, "Internal Server Error");
            
            public String descr;
            public int requestStatus;

            Status(int i, String str) {
                this.requestStatus = i;
                this.descr = str;
            }

            public String getDescription() {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.requestStatus);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.descr);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }

            public int getRequestStatus() {
                return this.requestStatus;
            }
        }

        public Response(Status status, String str, String str2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = status;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayInputStream(str2.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OutputStream outputStream, Status status, String str) {
            new Response(status, "text/plain", str).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outputStream);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OutputStream outputStream) {
            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    throw new Error("sendResponse(): Status can't be null.");
                }
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.print("HTTP/1.0 " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDescription() + " \r\n");
                if (str != null) {
                    printWriter.print("Content-Type: " + str + "\r\n");
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get("Date") == null) {
                    printWriter.print("Date: " + simpleDateFormat.format(new Date()) + "\r\n");
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    for (String str2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keySet()) {
                        printWriter.print(str2 + ": " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str2) + "\r\n");
                    }
                }
                printWriter.print("\r\n");
                printWriter.flush();
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    int available = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.available();
                    byte[] bArr = new byte[16384];
                    while (available > 0) {
                        int read = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(bArr, 0, available > 16384 ? 16384 : available);
                        if (read <= 0) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                        available -= read;
                    }
                }
                outputStream.flush();
                outputStream.close();
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwww {
        void delete() throws Exception;

        String getName();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(NanoHTTPD nanoHTTPD, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwww {
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY);
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                try {
                    wwwwwwwwwwwwwwwwwwwwwwwwwww.delete();
                } catch (Exception unused) {
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwww {
        public File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IOException {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = File.createTempFile("NanoHTTPD-", "", new File(str));
            new FileOutputStream(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.utils.wifitransfer.NanoHTTPD.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public void delete() throws Exception {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.delete();
        }

        @Override // me.tvspark.utils.wifitransfer.NanoHTTPD.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public String getName() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAbsolutePath();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NanoHTTPD nanoHTTPD, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("NanoHttpd Request Processor (#");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            thread.setName(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            thread.start();
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {

        /* renamed from: me.tvspark.utils.wifitransfer.NanoHTTPD$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3495Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ Socket Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

            public RunnableC3495Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww, Socket socket) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = socket;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
                Socket socket = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Socket accept;
            InputStream inputStream;
            OutputStream outputStream;
            do {
                try {
                    accept = NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.accept();
                    String str = "accept request from " + accept.getInetAddress();
                    inputStream = accept.getInputStream();
                    outputStream = accept.getOutputStream();
                } catch (IOException unused) {
                }
                if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                    ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RunnableC3495Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), inputStream, outputStream), accept));
                } else {
                    throw null;
                    break;
                }
            } while (!NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isClosed());
        }
    }

    public NanoHTTPD(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws InterruptedException {
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
            throw new InterruptedException();
        }
    }

    public abstract Response Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3);

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = serverSocket;
        serverSocket.bind(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? new InetSocketAddress(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : new InetSocketAddress(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        Thread thread = new Thread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = thread;
        thread.setDaemon(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setName("NanoHttpd Main Listener");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public OutputStream Wwwwwwwwwwwwwwwwwwwwww;
        public InputStream Wwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww, InputStream inputStream, OutputStream outputStream) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = inputStream;
            this.Wwwwwwwwwwwwwwwwwwwwww = outputStream;
        }

        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<String, String> map) {
            String str = map.get("content-length");
            if (str != null) {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return Long.MAX_VALUE;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BufferedReader bufferedReader, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws InterruptedException {
            NanoHTTPD nanoHTTPD;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (!stringTokenizer.hasMoreTokens()) {
                    Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                    throw new InterruptedException();
                }
                map.put(JsCallJava.KEY_METHOD, stringTokenizer.nextToken());
                if (!stringTokenizer.hasMoreTokens()) {
                    Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    throw new InterruptedException();
                }
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(63);
                if (indexOf >= 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken.substring(indexOf + 1), map2);
                    nanoHTTPD = NanoHTTPD.this;
                    nextToken = nextToken.substring(0, indexOf);
                } else {
                    nanoHTTPD = NanoHTTPD.this;
                }
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nanoHTTPD.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken);
                if (stringTokenizer.hasMoreTokens()) {
                    while (true) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 == null || readLine2.trim().length() <= 0) {
                            break;
                        }
                        int indexOf2 = readLine2.indexOf(58);
                        if (indexOf2 >= 0) {
                            map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(), readLine2.substring(indexOf2 + 1).trim());
                        }
                    }
                }
                map.put("uri", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (IOException e) {
                OutputStream outputStream = this.Wwwwwwwwwwwwwwwwwwwwww;
                Response.Status status = Response.Status.INTERNAL_ERROR;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SERVER INTERNAL ERROR: IOException: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e.getMessage());
                Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outputStream, status, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                throw new InterruptedException();
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, ByteBuffer byteBuffer, BufferedReader bufferedReader, Map<String, String> map, Map<String, String> map2) throws InterruptedException {
            String readLine;
            int i;
            String substring;
            Map<String, String> map3;
            int indexOf;
            try {
                byte[] bytes = str.getBytes();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                int i3 = 0;
                int i4 = -1;
                while (i2 < byteBuffer.limit()) {
                    if (byteBuffer.get(i2) == bytes[i3]) {
                        if (i3 == 0) {
                            i4 = i2;
                        }
                        i3++;
                        if (i3 == bytes.length) {
                            arrayList.add(Integer.valueOf(i4));
                        } else {
                            i2++;
                        }
                    } else {
                        i2 -= i3;
                    }
                    i3 = 0;
                    i4 = -1;
                    i2++;
                }
                int size = arrayList.size();
                int[] iArr = new int[size];
                for (int i5 = 0; i5 < size; i5++) {
                    iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
                }
                String readLine2 = bufferedReader.readLine();
                int i6 = 1;
                while (readLine2 != null) {
                    if (!readLine2.contains(str)) {
                        Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
                        throw new InterruptedException();
                    }
                    i6++;
                    HashMap hashMap = new HashMap();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null || readLine.trim().length() <= 0) {
                            break;
                        }
                        int indexOf2 = readLine.indexOf(58);
                        if (indexOf2 != -1) {
                            hashMap.put(readLine.substring(0, indexOf2).trim().toLowerCase(), readLine.substring(indexOf2 + 1).trim());
                        }
                    }
                    if (readLine != null) {
                        String str2 = (String) hashMap.get("content-disposition");
                        if (str2 == null) {
                            Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
                            throw new InterruptedException();
                        }
                        StringTokenizer stringTokenizer = new StringTokenizer(str2, "; ");
                        HashMap hashMap2 = new HashMap();
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            int indexOf3 = nextToken.indexOf(61);
                            if (indexOf3 != -1) {
                                hashMap2.put(nextToken.substring(0, indexOf3).trim().toLowerCase(), nextToken.substring(indexOf3 + 1).trim());
                            }
                        }
                        String str3 = (String) hashMap2.get("name");
                        String substring2 = str3.substring(1, str3.length() - 1);
                        String str4 = "";
                        if (hashMap.get("content-type") == null) {
                            while (readLine != null && !readLine.contains(str)) {
                                readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    str4 = readLine.indexOf(str) == -1 ? str4 + readLine : str4 + readLine.substring(0, indexOf - 2);
                                }
                            }
                            map3 = map;
                            substring = str4;
                        } else if (i6 > size) {
                            Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.INTERNAL_ERROR, "Error processing request");
                            throw new InterruptedException();
                        } else {
                            int i7 = iArr[i6 - 2];
                            while (i7 < byteBuffer.limit()) {
                                if (byteBuffer.get(i7) == 13) {
                                    i7++;
                                    if (byteBuffer.get(i7) == 10) {
                                        i7++;
                                        if (byteBuffer.get(i7) == 13) {
                                            i7++;
                                            if (byteBuffer.get(i7) == 10) {
                                                break;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                i7++;
                            }
                            map2.put(substring2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, i7 + 1, (iArr[i6 - 1] - i) - 4));
                            String str5 = (String) hashMap2.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME);
                            substring = str5.substring(1, str5.length() - 1);
                            do {
                                readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } while (!readLine.contains(str));
                            map3 = map;
                        }
                        map3.put(substring2, substring);
                    }
                    readLine2 = readLine;
                }
            } catch (IOException e) {
                OutputStream outputStream = this.Wwwwwwwwwwwwwwwwwwwwww;
                Response.Status status = Response.Status.INTERNAL_ERROR;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SERVER INTERNAL ERROR: IOException: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outputStream, status, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                throw new InterruptedException();
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Map<String, String> map) throws InterruptedException {
            if (str == null) {
                map.put(fi.iki.elonen.NanoHTTPD.QUERY_STRING_PARAMETER, "");
                return;
            }
            map.put(fi.iki.elonen.NanoHTTPD.QUERY_STRING_PARAMETER, str);
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                try {
                    String nextToken = stringTokenizer.nextToken();
                    int indexOf = nextToken.indexOf(61);
                    if (indexOf >= 0) {
                        map.put(NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken.substring(0, indexOf)).trim(), NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken.substring(indexOf + 1)));
                    } else {
                        map.put(NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken).trim(), "");
                    }
                } catch (InterruptedException unused) {
                    Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.BAD_REQUEST, "BAD REQUEST: Bad percent-encoding.");
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0129 A[Catch: IOException -> 0x0041, all -> 0x01d9, all -> 0x01e2, TryCatch #2 {IOException -> 0x0041, all -> 0x01d9, all -> 0x01e2, blocks: (B:3:0x0004, B:9:0x0012, B:11:0x001f, B:12:0x0021, B:14:0x0025, B:16:0x002b, B:18:0x0033, B:20:0x0039, B:23:0x003d, B:25:0x004b, B:92:0x0044, B:28:0x0054, B:30:0x0088, B:32:0x009b, B:35:0x00a5, B:36:0x00b7, B:40:0x00c1, B:42:0x00cc, B:47:0x00d3, B:49:0x0101, B:52:0x010e, B:54:0x011b, B:55:0x0121, B:57:0x0129, B:59:0x012f, B:61:0x0145, B:63:0x014b, B:64:0x0158, B:66:0x0162, B:67:0x0170, B:68:0x0171, B:69:0x0194, B:71:0x0178, B:73:0x0180, B:75:0x0199, B:78:0x01a0, B:80:0x01a8, B:81:0x01b6, B:89:0x01ca, B:90:0x01d8), top: B:2:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0171 A[Catch: IOException -> 0x0041, all -> 0x01d9, all -> 0x01e2, TryCatch #2 {IOException -> 0x0041, all -> 0x01d9, all -> 0x01e2, blocks: (B:3:0x0004, B:9:0x0012, B:11:0x001f, B:12:0x0021, B:14:0x0025, B:16:0x002b, B:18:0x0033, B:20:0x0039, B:23:0x003d, B:25:0x004b, B:92:0x0044, B:28:0x0054, B:30:0x0088, B:32:0x009b, B:35:0x00a5, B:36:0x00b7, B:40:0x00c1, B:42:0x00cc, B:47:0x00d3, B:49:0x0101, B:52:0x010e, B:54:0x011b, B:55:0x0121, B:57:0x0129, B:59:0x012f, B:61:0x0145, B:63:0x014b, B:64:0x0158, B:66:0x0162, B:67:0x0170, B:68:0x0171, B:69:0x0194, B:71:0x0178, B:73:0x0180, B:75:0x0199, B:78:0x01a0, B:80:0x01a8, B:81:0x01b6, B:89:0x01ca, B:90:0x01d8), top: B:2:0x0004 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            int read;
            try {
            } catch (IOException e) {
                Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e.getMessage());
                throw new InterruptedException();
            } catch (Throwable unused) {
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
                ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            byte[] bArr = new byte[8192];
            int read2 = this.Wwwwwwwwwwwwwwwwwwwwwww.read(bArr, 0, 8192);
            int i = 0;
            int i2 = 0;
            while (read2 > 0) {
                i += read2;
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 3;
                    if (i4 >= i) {
                        i2 = 0;
                        break;
                    } else if (bArr[i3] == 13 && bArr[i3 + 1] == 10 && bArr[i3 + 2] == 13 && bArr[i4] == 10) {
                        i2 = i3 + 4;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 > 0) {
                    break;
                }
                read2 = this.Wwwwwwwwwwwwwwwwwwwwwww.read(bArr, i, 8192 - i);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, i)));
            HashMap hashMap = new HashMap();
            Map<String, String> hashMap2 = new HashMap<>();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bufferedReader, hashMap, hashMap2, hashMap3);
            Method lookup = Method.lookup((String) hashMap.get(JsCallJava.KEY_METHOD));
            if (lookup == null) {
                Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error.");
                throw new InterruptedException();
            }
            String str2 = (String) hashMap.get("uri");
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap3);
            RandomAccessFile Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (i2 < i) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.write(bArr, i2, i - i2);
            }
            if (i2 < i) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= (i - i2) + 1;
            } else if (i2 == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Long.MAX_VALUE) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            }
            int i5 = 512;
            byte[] bArr2 = new byte[512];
            while (i >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                i = this.Wwwwwwwwwwwwwwwwwwwwwww.read(bArr2, 0, i5);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= i;
                if (i > 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.write(bArr2, 0, i);
                }
                i5 = 512;
            }
            MappedByteBuffer map = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.seek(0L);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getFD())));
            if (Method.POST.equals(lookup)) {
                String str3 = (String) hashMap3.get("content-type");
                StringTokenizer stringTokenizer = null;
                String str4 = "";
                if (str3 != null) {
                    stringTokenizer = new StringTokenizer(str3, ",; ");
                    if (stringTokenizer.hasMoreTokens()) {
                        str = stringTokenizer.nextToken();
                        if ("multipart/form-data".equalsIgnoreCase(str)) {
                            char[] cArr = new char[512];
                            while (true) {
                                if (bufferedReader2.read(cArr) < 0 || str4.endsWith("\r\n")) {
                                    break;
                                }
                                str4 = str4 + String.valueOf(cArr, 0, read);
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4.trim(), hashMap2);
                        } else if (!stringTokenizer.hasMoreTokens()) {
                            Response.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                            throw new InterruptedException();
                        } else {
                            String substring = str3.substring(str3.indexOf("boundary=") + 9, str3.length());
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((!substring.startsWith("\"") || !substring.startsWith("\"")) ? substring : substring.substring(1, substring.length() - 1), map, bufferedReader2, hashMap2, hashMap4);
                        }
                    }
                }
                str = str4;
                if ("multipart/form-data".equalsIgnoreCase(str)) {
                }
            }
            if (Method.PUT.equals(lookup)) {
                hashMap4.put("content", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, 0, map.limit()));
            }
            NanoHTTPD.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, lookup, hashMap3, hashMap2, hashMap4).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
            bufferedReader2.close();
            this.Wwwwwwwwwwwwwwwwwwwwwww.close();
            ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final RandomAccessFile Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return new RandomAccessFile(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName(), "rw");
            } catch (Exception e) {
                PrintStream printStream = System.err;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return null;
            }
        }

        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer, int i, int i2) {
            if (i2 > 0) {
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    FileChannel channel = new FileOutputStream(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName()).getChannel();
                    duplicate.position(i).limit(i + i2);
                    channel.write(duplicate.slice());
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName();
                } catch (Exception e) {
                    PrintStream printStream = System.err;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                    printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            }
            return "";
        }
    }
}
