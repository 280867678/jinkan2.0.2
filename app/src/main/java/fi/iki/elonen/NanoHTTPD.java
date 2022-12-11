package fi.iki.elonen;

import com.just.agentweb.JsCallJava;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpVersions;
import org.eclipse.jetty.util.StringUtil;

/* loaded from: classes4.dex */
public abstract class NanoHTTPD {
    public static final String MIME_HTML = "text/html";
    public static final String MIME_PLAINTEXT = "text/plain";
    public static Map<String, String> MIME_TYPES = null;
    public static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
    public static final int SOCKET_READ_TIMEOUT = 5000;
    public AsyncRunner asyncRunner;
    public final String hostname;
    public final int myPort;
    public volatile ServerSocket myServerSocket;
    public Thread myThread;
    public ServerSocketFactory serverSocketFactory;
    public TempFileManagerFactory tempFileManagerFactory;
    public static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    public static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile(CONTENT_DISPOSITION_REGEX, 2);
    public static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";
    public static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile(CONTENT_TYPE_REGEX, 2);
    public static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    public static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = Pattern.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
    public static final Logger LOG = Logger.getLogger(NanoHTTPD.class.getName());

    /* loaded from: classes4.dex */
    public interface AsyncRunner {
        void closeAll();

        void closed(ClientHandler clientHandler);

        void exec(ClientHandler clientHandler);
    }

    /* loaded from: classes4.dex */
    public class ClientHandler implements Runnable {
        public final Socket acceptSocket;
        public final InputStream inputStream;

        public ClientHandler(InputStream inputStream, Socket socket) {
            this.inputStream = inputStream;
            this.acceptSocket = socket;
        }

        public void close() {
            NanoHTTPD.safeClose(this.inputStream);
            NanoHTTPD.safeClose(this.acceptSocket);
        }

        @Override // java.lang.Runnable
        public void run() {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = this.acceptSocket.getOutputStream();
                    HTTPSession hTTPSession = new HTTPSession(NanoHTTPD.this.tempFileManagerFactory.create(), this.inputStream, outputStream, this.acceptSocket.getInetAddress());
                    while (!this.acceptSocket.isClosed()) {
                        hTTPSession.execute();
                    }
                } catch (Exception e) {
                    if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                        NanoHTTPD.LOG.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e);
                    }
                }
            } finally {
                NanoHTTPD.safeClose(outputStream);
                NanoHTTPD.safeClose(this.inputStream);
                NanoHTTPD.safeClose(this.acceptSocket);
                NanoHTTPD.this.asyncRunner.closed(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ContentType {
        public static final String ASCII_ENCODING = "US-ASCII";
        public static final String MULTIPART_FORM_DATA_HEADER = "multipart/form-data";
        public final String boundary;
        public final String contentType;
        public final String contentTypeHeader;
        public final String encoding;
        public static final String CONTENT_REGEX = "[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)";
        public static final Pattern MIME_PATTERN = Pattern.compile(CONTENT_REGEX, 2);
        public static final String CHARSET_REGEX = "[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";
        public static final Pattern CHARSET_PATTERN = Pattern.compile(CHARSET_REGEX, 2);
        public static final String BOUNDARY_REGEX = "[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";
        public static final Pattern BOUNDARY_PATTERN = Pattern.compile(BOUNDARY_REGEX, 2);

        public ContentType(String str) {
            String str2;
            this.contentTypeHeader = str;
            if (str != null) {
                this.contentType = getDetailFromContentHeader(str, MIME_PATTERN, "", 1);
                str2 = getDetailFromContentHeader(str, CHARSET_PATTERN, null, 2);
            } else {
                this.contentType = "";
                str2 = "UTF-8";
            }
            this.encoding = str2;
            if ("multipart/form-data".equalsIgnoreCase(this.contentType)) {
                this.boundary = getDetailFromContentHeader(str, BOUNDARY_PATTERN, null, 2);
            } else {
                this.boundary = null;
            }
        }

        private String getDetailFromContentHeader(String str, Pattern pattern, String str2, int i) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(i) : str2;
        }

        public String getBoundary() {
            return this.boundary;
        }

        public String getContentType() {
            return this.contentType;
        }

        public String getContentTypeHeader() {
            return this.contentTypeHeader;
        }

        public String getEncoding() {
            String str = this.encoding;
            return str == null ? "US-ASCII" : str;
        }

        public boolean isMultipart() {
            return "multipart/form-data".equalsIgnoreCase(this.contentType);
        }

        public ContentType tryUTF8() {
            return this.encoding == null ? new ContentType(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.contentTypeHeader, "; charset=UTF-8")) : this;
        }
    }

    /* loaded from: classes4.dex */
    public static class Cookie {

        /* renamed from: e */
        public final String f4345e;

        /* renamed from: n */
        public final String f4346n;

        /* renamed from: v */
        public final String f4347v;

        public Cookie(String str, String str2) {
            this(str, str2, 30);
        }

        public Cookie(String str, String str2, int i) {
            this.f4346n = str;
            this.f4347v = str2;
            this.f4345e = getHTTPTime(i);
        }

        public Cookie(String str, String str2, String str3) {
            this.f4346n = str;
            this.f4347v = str2;
            this.f4345e = str3;
        }

        public static String getHTTPTime(int i) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            calendar.add(5, i);
            return simpleDateFormat.format(calendar.getTime());
        }

        public String getHTTPHeader() {
            return String.format("%s=%s; expires=%s", this.f4346n, this.f4347v, this.f4345e);
        }
    }

    /* loaded from: classes4.dex */
    public class CookieHandler implements Iterable<String> {
        public final HashMap<String, String> cookies = new HashMap<>();
        public final ArrayList<Cookie> queue = new ArrayList<>();

        public CookieHandler(Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String str2 : str.split(";")) {
                    String[] split = str2.trim().split("=");
                    if (split.length == 2) {
                        this.cookies.put(split[0], split[1]);
                    }
                }
            }
        }

        public void delete(String str) {
            set(str, "-delete-", -30);
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return this.cookies.keySet().iterator();
        }

        public String read(String str) {
            return this.cookies.get(str);
        }

        public void set(Cookie cookie) {
            this.queue.add(cookie);
        }

        public void set(String str, String str2, int i) {
            this.queue.add(new Cookie(str, str2, Cookie.getHTTPTime(i)));
        }

        public void unloadQueue(Response response) {
            Iterator<Cookie> it = this.queue.iterator();
            while (it.hasNext()) {
                response.addHeader(HttpHeaders.SET_COOKIE, it.next().getHTTPHeader());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class DefaultAsyncRunner implements AsyncRunner {
        public long requestCount;
        public final List<ClientHandler> running = Collections.synchronizedList(new ArrayList());

        @Override // fi.iki.elonen.NanoHTTPD.AsyncRunner
        public void closeAll() {
            Iterator it = new ArrayList(this.running).iterator();
            while (it.hasNext()) {
                ((ClientHandler) it.next()).close();
            }
        }

        @Override // fi.iki.elonen.NanoHTTPD.AsyncRunner
        public void closed(ClientHandler clientHandler) {
            this.running.remove(clientHandler);
        }

        @Override // fi.iki.elonen.NanoHTTPD.AsyncRunner
        public void exec(ClientHandler clientHandler) {
            this.requestCount++;
            Thread thread = new Thread(clientHandler);
            thread.setDaemon(true);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("NanoHttpd Request Processor (#");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.requestCount);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            thread.setName(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            this.running.add(clientHandler);
            thread.start();
        }

        public List<ClientHandler> getRunning() {
            return this.running;
        }
    }

    /* loaded from: classes4.dex */
    public static class DefaultServerSocketFactory implements ServerSocketFactory {
        @Override // fi.iki.elonen.NanoHTTPD.ServerSocketFactory
        public ServerSocket create() throws IOException {
            return new ServerSocket();
        }
    }

    /* loaded from: classes4.dex */
    public static class DefaultTempFile implements TempFile {
        public final File file;
        public final OutputStream fstream;

        public DefaultTempFile(File file) throws IOException {
            this.file = File.createTempFile("NanoHTTPD-", "", file);
            this.fstream = new FileOutputStream(this.file);
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFile
        public void delete() throws Exception {
            NanoHTTPD.safeClose(this.fstream);
            if (this.file.delete()) {
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("could not delete temporary file: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.file.getAbsolutePath());
            throw new Exception(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFile
        public String getName() {
            return this.file.getAbsolutePath();
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFile
        public OutputStream open() throws Exception {
            return this.fstream;
        }
    }

    /* loaded from: classes4.dex */
    public static class DefaultTempFileManager implements TempFileManager {
        public final List<TempFile> tempFiles;
        public final File tmpdir;

        public DefaultTempFileManager() {
            File file = new File(System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY));
            this.tmpdir = file;
            if (!file.exists()) {
                this.tmpdir.mkdirs();
            }
            this.tempFiles = new ArrayList();
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFileManager
        public void clear() {
            for (TempFile tempFile : this.tempFiles) {
                try {
                    tempFile.delete();
                } catch (Exception e) {
                    NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", (Throwable) e);
                }
            }
            this.tempFiles.clear();
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFileManager
        public TempFile createTempFile(String str) throws Exception {
            DefaultTempFile defaultTempFile = new DefaultTempFile(this.tmpdir);
            this.tempFiles.add(defaultTempFile);
            return defaultTempFile;
        }
    }

    /* loaded from: classes4.dex */
    public class DefaultTempFileManagerFactory implements TempFileManagerFactory {
        public DefaultTempFileManagerFactory() {
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFileManagerFactory
        public TempFileManager create() {
            return new DefaultTempFileManager();
        }
    }

    /* loaded from: classes4.dex */
    public class HTTPSession implements IHTTPSession {
        public static final int BUFSIZE = 8192;
        public static final int MAX_HEADER_SIZE = 1024;
        public static final int MEMORY_STORE_LIMIT = 1024;
        public static final int REQUEST_BUFFER_LEN = 512;
        public CookieHandler cookies;
        public Map<String, String> headers;
        public final BufferedInputStream inputStream;
        public Method method;
        public final OutputStream outputStream;
        public Map<String, List<String>> parms;
        public String protocolVersion;
        public String queryParameterString;
        public String remoteHostname;
        public String remoteIp;
        public int rlen;
        public int splitbyte;
        public final TempFileManager tempFileManager;
        public String uri;

        public HTTPSession(TempFileManager tempFileManager, InputStream inputStream, OutputStream outputStream) {
            this.tempFileManager = tempFileManager;
            this.inputStream = new BufferedInputStream(inputStream, 8192);
            this.outputStream = outputStream;
        }

        public HTTPSession(TempFileManager tempFileManager, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            this.tempFileManager = tempFileManager;
            this.inputStream = new BufferedInputStream(inputStream, 8192);
            this.outputStream = outputStream;
            this.remoteIp = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            this.remoteHostname = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "localhost" : inetAddress.getHostName().toString();
            this.headers = new HashMap();
        }

        private void decodeHeader(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) throws ResponseException {
            String decodePercent;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
                map.put(JsCallJava.KEY_METHOD, stringTokenizer.nextToken());
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(63);
                if (indexOf >= 0) {
                    decodeParms(nextToken.substring(indexOf + 1), map2);
                    decodePercent = NanoHTTPD.decodePercent(nextToken.substring(0, indexOf));
                } else {
                    decodePercent = NanoHTTPD.decodePercent(nextToken);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.protocolVersion = stringTokenizer.nextToken();
                } else {
                    this.protocolVersion = HttpVersions.HTTP_1_1;
                    NanoHTTPD.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                }
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null || readLine2.trim().isEmpty()) {
                        break;
                    }
                    int indexOf2 = readLine2.indexOf(58);
                    if (indexOf2 >= 0) {
                        map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                    }
                }
                map.put("uri", decodePercent);
            } catch (IOException e) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SERVER INTERNAL ERROR: IOException: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                throw new ResponseException(status, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
            }
        }

        private void decodeMultipartFormData(ContentType contentType, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) throws ResponseException {
            String str;
            try {
                int[] boundaryPositions = getBoundaryPositions(byteBuffer, contentType.getBoundary().getBytes());
                int i = 2;
                if (boundaryPositions.length < 2) {
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
                }
                int i2 = 1024;
                byte[] bArr = new byte[1024];
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int i6 = 1;
                    if (i4 >= boundaryPositions.length - 1) {
                        return;
                    }
                    byteBuffer.position(boundaryPositions[i4]);
                    int remaining = byteBuffer.remaining() < i2 ? byteBuffer.remaining() : 1024;
                    byteBuffer.get(bArr, i3, remaining);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i3, remaining), Charset.forName(contentType.getEncoding())), remaining);
                    String readLine = bufferedReader.readLine();
                    if (readLine == null || !readLine.contains(contentType.getBoundary())) {
                        break;
                    }
                    String readLine2 = bufferedReader.readLine();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    int i7 = 2;
                    while (readLine2 != null && readLine2.trim().length() > 0) {
                        Matcher matcher = NanoHTTPD.CONTENT_DISPOSITION_PATTERN.matcher(readLine2);
                        if (matcher.matches()) {
                            Matcher matcher2 = NanoHTTPD.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(i));
                            while (matcher2.find()) {
                                String group = matcher2.group(i6);
                                if ("name".equalsIgnoreCase(group)) {
                                    str = matcher2.group(2);
                                } else {
                                    if (TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME.equalsIgnoreCase(group)) {
                                        String group2 = matcher2.group(2);
                                        if (!group2.isEmpty()) {
                                            if (i5 > 0) {
                                                str = str2 + String.valueOf(i5);
                                                str3 = group2;
                                                i5++;
                                            } else {
                                                i5++;
                                            }
                                        }
                                        str3 = group2;
                                    }
                                    i6 = 1;
                                }
                                str2 = str;
                                i6 = 1;
                            }
                        }
                        Matcher matcher3 = NanoHTTPD.CONTENT_TYPE_PATTERN.matcher(readLine2);
                        if (matcher3.matches()) {
                            str4 = matcher3.group(2).trim();
                        }
                        readLine2 = bufferedReader.readLine();
                        i7++;
                        i = 2;
                        i6 = 1;
                    }
                    int i8 = 0;
                    while (true) {
                        int i9 = i7 - 1;
                        if (i7 <= 0) {
                            break;
                        }
                        i8 = scipOverNewLine(bArr, i8);
                        i7 = i9;
                    }
                    if (i8 >= remaining - 4) {
                        throw new ResponseException(Response.Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                    }
                    int i10 = boundaryPositions[i4] + i8;
                    i4++;
                    int i11 = boundaryPositions[i4] - 4;
                    byteBuffer.position(i10);
                    List<String> list = map.get(str2);
                    if (list == null) {
                        list = new ArrayList<>();
                        map.put(str2, list);
                    }
                    int i12 = i11 - i10;
                    if (str4 == null) {
                        byte[] bArr2 = new byte[i12];
                        byteBuffer.get(bArr2);
                        list.add(new String(bArr2, contentType.getEncoding()));
                    } else {
                        String saveTmpFile = saveTmpFile(byteBuffer, i10, i12, str3);
                        if (!map2.containsKey(str2)) {
                            map2.put(str2, saveTmpFile);
                        } else {
                            int i13 = 2;
                            while (true) {
                                if (!map2.containsKey(str2 + i13)) {
                                    break;
                                }
                                i13++;
                            }
                            map2.put(str2 + i13, saveTmpFile);
                        }
                        list.add(str3);
                    }
                    i2 = 1024;
                    i = 2;
                    i3 = 0;
                }
                throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
            } catch (ResponseException e) {
                throw e;
            } catch (Exception e2) {
                throw new ResponseException(Response.Status.INTERNAL_ERROR, e2.toString());
            }
        }

        private void decodeParms(String str, Map<String, List<String>> map) {
            String trim;
            String str2;
            if (str == null) {
                this.queryParameterString = "";
                return;
            }
            this.queryParameterString = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    trim = NanoHTTPD.decodePercent(nextToken.substring(0, indexOf)).trim();
                    str2 = NanoHTTPD.decodePercent(nextToken.substring(indexOf + 1));
                } else {
                    trim = NanoHTTPD.decodePercent(nextToken).trim();
                    str2 = "";
                }
                List<String> list = map.get(trim);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(trim, list);
                }
                list.add(str2);
            }
        }

        private int findHeaderEnd(byte[] bArr, int i) {
            int i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i4 < i) {
                    if (bArr[i3] == 13 && bArr[i4] == 10 && (i2 = i3 + 3) < i && bArr[i3 + 2] == 13 && bArr[i2] == 10) {
                        return i3 + 4;
                    }
                    if (bArr[i3] == 10 && bArr[i4] == 10) {
                        return i3 + 2;
                    }
                    i3 = i4;
                } else {
                    return 0;
                }
            }
        }

        private int[] getBoundaryPositions(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            int length = bArr.length + 4096;
            byte[] bArr2 = new byte[length];
            int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
            byteBuffer.get(bArr2, 0, remaining);
            int length2 = remaining - bArr.length;
            int i = 0;
            do {
                for (int i2 = 0; i2 < length2; i2++) {
                    for (int i3 = 0; i3 < bArr.length && bArr2[i2 + i3] == bArr[i3]; i3++) {
                        if (i3 == bArr.length - 1) {
                            int[] iArr2 = new int[iArr.length + 1];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i + i2;
                            iArr = iArr2;
                        }
                    }
                }
                i += length2;
                System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
                length2 = length - bArr.length;
                if (byteBuffer.remaining() < length2) {
                    length2 = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length2);
            } while (length2 > 0);
            return iArr;
        }

        private RandomAccessFile getTmpBucket() {
            try {
                return new RandomAccessFile(this.tempFileManager.createTempFile(null).getName(), "rw");
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        private String saveTmpFile(ByteBuffer byteBuffer, int i, int i2, String str) {
            TempFile createTempFile;
            ByteBuffer duplicate;
            FileOutputStream fileOutputStream;
            if (i2 > 0) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        createTempFile = this.tempFileManager.createTempFile(str);
                        duplicate = byteBuffer.duplicate();
                        fileOutputStream = new FileOutputStream(createTempFile.getName());
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    FileChannel channel = fileOutputStream.getChannel();
                    duplicate.position(i).limit(i + i2);
                    channel.write(duplicate.slice());
                    String name = createTempFile.getName();
                    NanoHTTPD.safeClose(fileOutputStream);
                    return name;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    throw new Error(e);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    NanoHTTPD.safeClose(fileOutputStream2);
                    throw th;
                }
            }
            return "";
        }

        private int scipOverNewLine(byte[] bArr, int i) {
            byte b;
            do {
                b = bArr[i];
                i++;
            } while (b != 10);
            return i;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public void execute() throws IOException {
            OutputStream outputStream;
            byte[] bArr;
            boolean z;
            Response response = null;
            try {
                try {
                    try {
                        try {
                            try {
                                bArr = new byte[8192];
                                z = false;
                                this.splitbyte = 0;
                                this.rlen = 0;
                                this.inputStream.mark(8192);
                            } catch (ResponseException e) {
                                NanoHTTPD.newFixedLengthResponse(e.getStatus(), "text/plain", e.getMessage()).send(this.outputStream);
                                outputStream = this.outputStream;
                                NanoHTTPD.safeClose(outputStream);
                                return;
                            }
                        } catch (SocketException e2) {
                            throw e2;
                        }
                    } catch (SSLException e3) {
                        Response.Status status = Response.Status.INTERNAL_ERROR;
                        NanoHTTPD.newFixedLengthResponse(status, "text/plain", "SSL PROTOCOL FAILURE: " + e3.getMessage()).send(this.outputStream);
                        outputStream = this.outputStream;
                        NanoHTTPD.safeClose(outputStream);
                        return;
                    }
                } catch (SocketTimeoutException e4) {
                    throw e4;
                } catch (IOException e5) {
                    Response.Status status2 = Response.Status.INTERNAL_ERROR;
                    NanoHTTPD.newFixedLengthResponse(status2, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e5.getMessage()).send(this.outputStream);
                    outputStream = this.outputStream;
                    NanoHTTPD.safeClose(outputStream);
                    return;
                }
                try {
                    int read = this.inputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        NanoHTTPD.safeClose(this.inputStream);
                        NanoHTTPD.safeClose(this.outputStream);
                        throw new SocketException("NanoHttpd Shutdown");
                    }
                    while (read > 0) {
                        int i = this.rlen + read;
                        this.rlen = i;
                        int findHeaderEnd = findHeaderEnd(bArr, i);
                        this.splitbyte = findHeaderEnd;
                        if (findHeaderEnd > 0) {
                            break;
                        }
                        read = this.inputStream.read(bArr, this.rlen, 8192 - this.rlen);
                    }
                    if (this.splitbyte < this.rlen) {
                        this.inputStream.reset();
                        this.inputStream.skip(this.splitbyte);
                    }
                    this.parms = new HashMap();
                    if (this.headers == null) {
                        this.headers = new HashMap();
                    } else {
                        this.headers.clear();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.rlen)));
                    HashMap hashMap = new HashMap();
                    decodeHeader(bufferedReader, hashMap, this.parms, this.headers);
                    if (this.remoteIp != null) {
                        this.headers.put("remote-addr", this.remoteIp);
                        this.headers.put("http-client-ip", this.remoteIp);
                    }
                    Method lookup = Method.lookup((String) hashMap.get(JsCallJava.KEY_METHOD));
                    this.method = lookup;
                    if (lookup == null) {
                        Response.Status status3 = Response.Status.BAD_REQUEST;
                        throw new ResponseException(status3, "BAD REQUEST: Syntax error. HTTP verb " + ((String) hashMap.get(JsCallJava.KEY_METHOD)) + " unhandled.");
                    }
                    this.uri = (String) hashMap.get("uri");
                    this.cookies = new CookieHandler(this.headers);
                    String str = this.headers.get("connection");
                    boolean z2 = HttpVersions.HTTP_1_1.equals(this.protocolVersion) && (str == null || !str.matches("(?i).*close.*"));
                    response = NanoHTTPD.this.serve(this);
                    if (response == null) {
                        throw new ResponseException(Response.Status.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                    }
                    String str2 = this.headers.get("accept-encoding");
                    this.cookies.unloadQueue(response);
                    response.setRequestMethod(this.method);
                    if (NanoHTTPD.this.useGzipWhenAccepted(response) && str2 != null && str2.contains("gzip")) {
                        z = true;
                    }
                    response.setGzipEncoding(z);
                    response.setKeepAlive(z2);
                    response.send(this.outputStream);
                    if (z2 && !response.isCloseConnection()) {
                        return;
                    }
                    throw new SocketException("NanoHttpd Shutdown");
                } catch (SSLException e6) {
                    throw e6;
                } catch (IOException unused) {
                    NanoHTTPD.safeClose(this.inputStream);
                    NanoHTTPD.safeClose(this.outputStream);
                    throw new SocketException("NanoHttpd Shutdown");
                }
            } finally {
                NanoHTTPD.safeClose(null);
                this.tempFileManager.clear();
            }
        }

        public long getBodySize() {
            if (this.headers.containsKey("content-length")) {
                return Long.parseLong(this.headers.get("content-length"));
            }
            int i = this.splitbyte;
            int i2 = this.rlen;
            if (i >= i2) {
                return 0L;
            }
            return i2 - i;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public CookieHandler getCookies() {
            return this.cookies;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final InputStream getInputStream() {
            return this.inputStream;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final Method getMethod() {
            return this.method;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final Map<String, List<String>> getParameters() {
            return this.parms;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        @Deprecated
        public final Map<String, String> getParms() {
            HashMap hashMap = new HashMap();
            for (String str : this.parms.keySet()) {
                hashMap.put(str, this.parms.get(str).get(0));
            }
            return hashMap;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public String getQueryParameterString() {
            return this.queryParameterString;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public String getRemoteHostName() {
            return this.remoteHostname;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public String getRemoteIpAddress() {
            return this.remoteIp;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final String getUri() {
            return this.uri;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public void parseBody(Map<String, String> map) throws IOException, ResponseException {
            long bodySize;
            RandomAccessFile tmpBucket;
            ByteArrayOutputStream byteArrayOutputStream;
            DataOutput dataOutput;
            ByteBuffer map2;
            RandomAccessFile randomAccessFile = null;
            try {
                bodySize = getBodySize();
                if (bodySize < 1024) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    dataOutput = new DataOutputStream(byteArrayOutputStream);
                    tmpBucket = null;
                } else {
                    tmpBucket = getTmpBucket();
                    byteArrayOutputStream = null;
                    dataOutput = tmpBucket;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[512];
                while (this.rlen >= 0 && bodySize > 0) {
                    int read = this.inputStream.read(bArr, 0, (int) Math.min(bodySize, 512L));
                    this.rlen = read;
                    bodySize -= read;
                    if (read > 0) {
                        dataOutput.write(bArr, 0, read);
                    }
                }
                if (byteArrayOutputStream != null) {
                    map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                } else {
                    map2 = tmpBucket.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, tmpBucket.length());
                    tmpBucket.seek(0L);
                }
                if (Method.POST.equals(this.method)) {
                    ContentType contentType = new ContentType(this.headers.get("content-type"));
                    if (!contentType.isMultipart()) {
                        byte[] bArr2 = new byte[map2.remaining()];
                        map2.get(bArr2);
                        String trim = new String(bArr2, contentType.getEncoding()).trim();
                        if ("application/x-www-form-urlencoded".equalsIgnoreCase(contentType.getContentType())) {
                            decodeParms(trim, this.parms);
                        } else if (trim.length() != 0) {
                            map.put("postData", trim);
                        }
                    } else if (contentType.getBoundary() == null) {
                        throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    } else {
                        decodeMultipartFormData(contentType, map2, this.parms, map);
                    }
                } else if (Method.PUT.equals(this.method)) {
                    map.put("content", saveTmpFile(map2, 0, map2.limit(), null));
                }
                NanoHTTPD.safeClose(tmpBucket);
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = tmpBucket;
                NanoHTTPD.safeClose(randomAccessFile);
                throw th;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface IHTTPSession {
        void execute() throws IOException;

        CookieHandler getCookies();

        Map<String, String> getHeaders();

        InputStream getInputStream();

        Method getMethod();

        Map<String, List<String>> getParameters();

        @Deprecated
        Map<String, String> getParms();

        String getQueryParameterString();

        String getRemoteHostName();

        String getRemoteIpAddress();

        String getUri();

        void parseBody(Map<String, String> map) throws IOException, ResponseException;
    }

    /* loaded from: classes4.dex */
    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        public static Method lookup(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Response implements Closeable {
        public boolean chunkedTransfer;
        public long contentLength;
        public InputStream data;
        public boolean encodeAsGzip;
        public boolean keepAlive;
        public String mimeType;
        public Method requestMethod;
        public IStatus status;
        public final Map<String, String> header = new HashMap<String, String>() { // from class: fi.iki.elonen.NanoHTTPD.Response.1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public String put(String str, String str2) {
                Response.this.lowerCaseHeader.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put((C18671) str, str2);
            }
        };
        public final Map<String, String> lowerCaseHeader = new HashMap();

        /* loaded from: classes4.dex */
        public static class ChunkedOutputStream extends FilterOutputStream {
            public ChunkedOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void finish() throws IOException {
                ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (i2 == 0) {
                    return;
                }
                ((FilterOutputStream) this).out.write(String.format("%x\r\n", Integer.valueOf(i2)).getBytes());
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                ((FilterOutputStream) this).out.write("\r\n".getBytes());
            }
        }

        /* loaded from: classes4.dex */
        public interface IStatus {
            String getDescription();

            int getRequestStatus();
        }

        /* loaded from: classes4.dex */
        public enum Status implements IStatus {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            MULTI_STATUS(207, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(307, "Temporary Redirect"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            GONE(410, "Gone"),
            LENGTH_REQUIRED(411, "Length Required"),
            PRECONDITION_FAILED(412, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(417, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            public final String description;
            public final int requestStatus;

            Status(int i, String str) {
                this.requestStatus = i;
                this.description = str;
            }

            public static Status lookup(int i) {
                Status[] values;
                for (Status status : values()) {
                    if (status.getRequestStatus() == i) {
                        return status;
                    }
                }
                return null;
            }

            @Override // fi.iki.elonen.NanoHTTPD.Response.IStatus
            public String getDescription() {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.requestStatus);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.description);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }

            @Override // fi.iki.elonen.NanoHTTPD.Response.IStatus
            public int getRequestStatus() {
                return this.requestStatus;
            }
        }

        public Response(IStatus iStatus, String str, InputStream inputStream, long j) {
            this.status = iStatus;
            this.mimeType = str;
            boolean z = false;
            if (inputStream == null) {
                this.data = new ByteArrayInputStream(new byte[0]);
                this.contentLength = 0L;
            } else {
                this.data = inputStream;
                this.contentLength = j;
            }
            this.chunkedTransfer = this.contentLength < 0 ? true : z;
            this.keepAlive = true;
        }

        private void sendBody(OutputStream outputStream, long j) throws IOException {
            byte[] bArr = new byte[(int) 16384];
            boolean z = j == -1;
            while (true) {
                if (j > 0 || z) {
                    int read = this.data.read(bArr, 0, (int) (z ? 16384L : Math.min(j, 16384L)));
                    if (read <= 0) {
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                    if (!z) {
                        j -= read;
                    }
                } else {
                    return;
                }
            }
        }

        private void sendBodyWithCorrectEncoding(OutputStream outputStream, long j) throws IOException {
            if (!this.encodeAsGzip) {
                sendBody(outputStream, j);
                return;
            }
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            sendBody(gZIPOutputStream, -1L);
            gZIPOutputStream.finish();
        }

        private void sendBodyWithCorrectTransferAndEncoding(OutputStream outputStream, long j) throws IOException {
            if (this.requestMethod == Method.HEAD || !this.chunkedTransfer) {
                sendBodyWithCorrectEncoding(outputStream, j);
                return;
            }
            ChunkedOutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
            sendBodyWithCorrectEncoding(chunkedOutputStream, -1L);
            chunkedOutputStream.finish();
        }

        public void addHeader(String str, String str2) {
            this.header.put(str, str2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.data;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public void closeConnection(boolean z) {
            if (z) {
                this.header.put("connection", HttpHeaderValues.CLOSE);
            } else {
                this.header.remove("connection");
            }
        }

        public InputStream getData() {
            return this.data;
        }

        public String getHeader(String str) {
            return this.lowerCaseHeader.get(str.toLowerCase());
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public Method getRequestMethod() {
            return this.requestMethod;
        }

        public IStatus getStatus() {
            return this.status;
        }

        public boolean isCloseConnection() {
            return HttpHeaderValues.CLOSE.equals(getHeader("connection"));
        }

        public void printHeader(PrintWriter printWriter, String str, String str2) {
            printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
        }

        public void send(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.status == null) {
                    throw new Error("sendResponse(): Status can't be null.");
                }
                PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new ContentType(this.mimeType).getEncoding())), false);
                printWriter.append("HTTP/1.1 ").append((CharSequence) this.status.getDescription()).append(" \r\n");
                if (this.mimeType != null) {
                    printHeader(printWriter, "Content-Type", this.mimeType);
                }
                if (getHeader("date") == null) {
                    printHeader(printWriter, "Date", simpleDateFormat.format(new Date()));
                }
                for (Map.Entry<String, String> entry : this.header.entrySet()) {
                    printHeader(printWriter, entry.getKey(), entry.getValue());
                }
                if (getHeader("connection") == null) {
                    printHeader(printWriter, "Connection", this.keepAlive ? "keep-alive" : HttpHeaderValues.CLOSE);
                }
                if (getHeader("content-length") != null) {
                    this.encodeAsGzip = false;
                }
                if (this.encodeAsGzip) {
                    printHeader(printWriter, "Content-Encoding", "gzip");
                    setChunkedTransfer(true);
                }
                long j = this.data != null ? this.contentLength : 0L;
                if (this.requestMethod != Method.HEAD && this.chunkedTransfer) {
                    printHeader(printWriter, "Transfer-Encoding", "chunked");
                } else if (!this.encodeAsGzip) {
                    j = sendContentLengthHeaderIfNotAlreadyPresent(printWriter, j);
                }
                printWriter.append("\r\n");
                printWriter.flush();
                sendBodyWithCorrectTransferAndEncoding(outputStream, j);
                outputStream.flush();
                NanoHTTPD.safeClose(this.data);
            } catch (IOException e) {
                NanoHTTPD.LOG.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
            }
        }

        public long sendContentLengthHeaderIfNotAlreadyPresent(PrintWriter printWriter, long j) {
            String header = getHeader("content-length");
            if (header != null) {
                try {
                    j = Long.parseLong(header);
                } catch (NumberFormatException unused) {
                    Logger logger = NanoHTTPD.LOG;
                    logger.severe("content-length was no number " + header);
                }
            }
            printWriter.print("Content-Length: " + j + "\r\n");
            return j;
        }

        public void setChunkedTransfer(boolean z) {
            this.chunkedTransfer = z;
        }

        public void setData(InputStream inputStream) {
            this.data = inputStream;
        }

        public void setGzipEncoding(boolean z) {
            this.encodeAsGzip = z;
        }

        public void setKeepAlive(boolean z) {
            this.keepAlive = z;
        }

        public void setMimeType(String str) {
            this.mimeType = str;
        }

        public void setRequestMethod(Method method) {
            this.requestMethod = method;
        }

        public void setStatus(IStatus iStatus) {
            this.status = iStatus;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ResponseException extends Exception {
        public static final long serialVersionUID = 6569838532917408380L;
        public final Response.Status status;

        public ResponseException(Response.Status status, String str) {
            super(str);
            this.status = status;
        }

        public ResponseException(Response.Status status, String str, Exception exc) {
            super(str, exc);
            this.status = status;
        }

        public Response.Status getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes4.dex */
    public static class SecureServerSocketFactory implements ServerSocketFactory {
        public String[] sslProtocols;
        public SSLServerSocketFactory sslServerSocketFactory;

        public SecureServerSocketFactory(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
            this.sslServerSocketFactory = sSLServerSocketFactory;
            this.sslProtocols = strArr;
        }

        @Override // fi.iki.elonen.NanoHTTPD.ServerSocketFactory
        public ServerSocket create() throws IOException {
            SSLServerSocket sSLServerSocket = (SSLServerSocket) this.sslServerSocketFactory.createServerSocket();
            String[] strArr = this.sslProtocols;
            if (strArr != null) {
                sSLServerSocket.setEnabledProtocols(strArr);
            } else {
                sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
            }
            sSLServerSocket.setUseClientMode(false);
            sSLServerSocket.setWantClientAuth(false);
            sSLServerSocket.setNeedClientAuth(false);
            return sSLServerSocket;
        }
    }

    /* loaded from: classes4.dex */
    public class ServerRunnable implements Runnable {
        public IOException bindException;
        public boolean hasBinded = false;
        public final int timeout;

        public ServerRunnable(int i) {
            this.timeout = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NanoHTTPD.this.myServerSocket.bind(NanoHTTPD.this.hostname != null ? new InetSocketAddress(NanoHTTPD.this.hostname, NanoHTTPD.this.myPort) : new InetSocketAddress(NanoHTTPD.this.myPort));
                this.hasBinded = true;
                do {
                    try {
                        Socket accept = NanoHTTPD.this.myServerSocket.accept();
                        if (this.timeout > 0) {
                            accept.setSoTimeout(this.timeout);
                        }
                        NanoHTTPD.this.asyncRunner.exec(NanoHTTPD.this.createClientHandler(accept, accept.getInputStream()));
                    } catch (IOException e) {
                        NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", (Throwable) e);
                    }
                } while (!NanoHTTPD.this.myServerSocket.isClosed());
            } catch (IOException e2) {
                this.bindException = e2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface ServerSocketFactory {
        ServerSocket create() throws IOException;
    }

    /* loaded from: classes4.dex */
    public interface TempFile {
        void delete() throws Exception;

        String getName();

        OutputStream open() throws Exception;
    }

    /* loaded from: classes4.dex */
    public interface TempFileManager {
        void clear();

        TempFile createTempFile(String str) throws Exception;
    }

    /* loaded from: classes4.dex */
    public interface TempFileManagerFactory {
        TempFileManager create();
    }

    public NanoHTTPD(int i) {
        this(null, i);
    }

    public NanoHTTPD(String str, int i) {
        this.serverSocketFactory = new DefaultServerSocketFactory();
        this.hostname = str;
        this.myPort = i;
        setTempFileManagerFactory(new DefaultTempFileManagerFactory());
        setAsyncRunner(new DefaultAsyncRunner());
    }

    public static Map<String, List<String>> decodeParameters(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                String trim = (indexOf >= 0 ? decodePercent(nextToken.substring(0, indexOf)) : decodePercent(nextToken)).trim();
                if (!hashMap.containsKey(trim)) {
                    hashMap.put(trim, new ArrayList());
                }
                String decodePercent = indexOf >= 0 ? decodePercent(nextToken.substring(indexOf + 1)) : null;
                if (decodePercent != null) {
                    ((List) hashMap.get(trim)).add(decodePercent);
                }
            }
        }
        return hashMap;
    }

    public static Map<String, List<String>> decodeParameters(Map<String, String> map) {
        return decodeParameters(map.get(QUERY_STRING_PARAMETER));
    }

    public static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, StringUtil.__UTF8Alt);
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e);
            return null;
        }
    }

    public static String getMimeTypeForFile(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = lastIndexOf >= 0 ? mimeTypes().get(str.substring(lastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    public static void loadMimeTypes(Map<String, String> map, String str) {
        try {
            Enumeration<URL> resources = NanoHTTPD.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Properties properties = new Properties();
                InputStream inputStream = null;
                try {
                    inputStream = nextElement.openStream();
                    properties.load(inputStream);
                } catch (IOException e) {
                    Logger logger = LOG;
                    Level level = Level.SEVERE;
                    logger.log(level, "could not load mimetypes from " + nextElement, (Throwable) e);
                }
                safeClose(inputStream);
                map.putAll(properties);
            }
        } catch (IOException unused) {
            Logger logger2 = LOG;
            Level level2 = Level.INFO;
            logger2.log(level2, "no mime types available at " + str);
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String str, char[] cArr) throws IOException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = NanoHTTPD.class.getResourceAsStream(str);
            if (resourceAsStream != null) {
                keyStore.load(resourceAsStream, cArr);
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, cArr);
                return makeSSLSocketFactory(keyStore, keyManagerFactory);
            }
            throw new IOException("Unable to load keystore from classpath: " + str);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManagerFactory keyManagerFactory) throws IOException {
        try {
            return makeSSLSocketFactory(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManager[] keyManagerArr) throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(keyManagerArr, trustManagerFactory.getTrustManagers(), null);
            return sSLContext.getServerSocketFactory();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static Map<String, String> mimeTypes() {
        if (MIME_TYPES == null) {
            HashMap hashMap = new HashMap();
            MIME_TYPES = hashMap;
            loadMimeTypes(hashMap, "META-INF/nanohttpd/default-mimetypes.properties");
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
            if (MIME_TYPES.isEmpty()) {
                LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return MIME_TYPES;
    }

    public static Response newChunkedResponse(Response.IStatus iStatus, String str, InputStream inputStream) {
        return new Response(iStatus, str, inputStream, -1L);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, InputStream inputStream, long j) {
        return new Response(iStatus, str, inputStream, j);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, String str2) {
        byte[] bArr;
        ContentType contentType = new ContentType(str);
        if (str2 == null) {
            return newFixedLengthResponse(iStatus, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(contentType.getEncoding()).newEncoder().canEncode(str2)) {
                contentType = contentType.tryUTF8();
            }
            bArr = str2.getBytes(contentType.getEncoding());
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e);
            bArr = new byte[0];
        }
        return newFixedLengthResponse(iStatus, contentType.getContentTypeHeader(), new ByteArrayInputStream(bArr), bArr.length);
    }

    public static Response newFixedLengthResponse(String str) {
        return newFixedLengthResponse(Response.Status.OK, "text/html", str);
    }

    public static final void safeClose(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (!(obj instanceof ServerSocket)) {
                    throw new IllegalArgumentException("Unknown object to close");
                } else {
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Could not close", (Throwable) e);
            }
        }
    }

    public synchronized void closeAllConnections() {
        stop();
    }

    public ClientHandler createClientHandler(Socket socket, InputStream inputStream) {
        return new ClientHandler(inputStream, socket);
    }

    public ServerRunnable createServerRunnable(int i) {
        return new ServerRunnable(i);
    }

    public String getHostname() {
        return this.hostname;
    }

    public final int getListeningPort() {
        if (this.myServerSocket == null) {
            return -1;
        }
        return this.myServerSocket.getLocalPort();
    }

    public ServerSocketFactory getServerSocketFactory() {
        return this.serverSocketFactory;
    }

    public TempFileManagerFactory getTempFileManagerFactory() {
        return this.tempFileManagerFactory;
    }

    public final boolean isAlive() {
        return wasStarted() && !this.myServerSocket.isClosed() && this.myThread.isAlive();
    }

    public void makeSecure(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.serverSocketFactory = new SecureServerSocketFactory(sSLServerSocketFactory, strArr);
    }

    public Response serve(IHTTPSession iHTTPSession) {
        HashMap hashMap = new HashMap();
        Method method = iHTTPSession.getMethod();
        if (Method.PUT.equals(method) || Method.POST.equals(method)) {
            try {
                iHTTPSession.parseBody(hashMap);
            } catch (ResponseException e) {
                return newFixedLengthResponse(e.getStatus(), "text/plain", e.getMessage());
            } catch (IOException e2) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SERVER INTERNAL ERROR: IOException: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.getMessage());
                return newFixedLengthResponse(status, "text/plain", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        Map<String, String> parms = iHTTPSession.getParms();
        parms.put(QUERY_STRING_PARAMETER, iHTTPSession.getQueryParameterString());
        return serve(iHTTPSession.getUri(), method, iHTTPSession.getHeaders(), parms, hashMap);
    }

    @Deprecated
    public Response serve(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Not Found");
    }

    public void setAsyncRunner(AsyncRunner asyncRunner) {
        this.asyncRunner = asyncRunner;
    }

    public void setServerSocketFactory(ServerSocketFactory serverSocketFactory) {
        this.serverSocketFactory = serverSocketFactory;
    }

    public void setTempFileManagerFactory(TempFileManagerFactory tempFileManagerFactory) {
        this.tempFileManagerFactory = tempFileManagerFactory;
    }

    public void start() throws IOException {
        start(5000);
    }

    public void start(int i) throws IOException {
        start(i, true);
    }

    public void start(int i, boolean z) throws IOException {
        this.myServerSocket = getServerSocketFactory().create();
        this.myServerSocket.setReuseAddress(true);
        ServerRunnable createServerRunnable = createServerRunnable(i);
        Thread thread = new Thread(createServerRunnable);
        this.myThread = thread;
        thread.setDaemon(z);
        this.myThread.setName("NanoHttpd Main Listener");
        this.myThread.start();
        while (!createServerRunnable.hasBinded && createServerRunnable.bindException == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        if (createServerRunnable.bindException == null) {
            return;
        }
        throw createServerRunnable.bindException;
    }

    public void stop() {
        try {
            safeClose(this.myServerSocket);
            this.asyncRunner.closeAll();
            if (this.myThread == null) {
                return;
            }
            this.myThread.join();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Could not stop all connections", (Throwable) e);
        }
    }

    public boolean useGzipWhenAccepted(Response response) {
        return response.getMimeType() != null && (response.getMimeType().toLowerCase().contains("text/") || response.getMimeType().toLowerCase().contains("/json"));
    }

    public final boolean wasStarted() {
        return (this.myServerSocket == null || this.myThread == null) ? false : true;
    }
}
