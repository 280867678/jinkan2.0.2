package okhttp3.internal;

import androidx.core.app.NotificationCompat;
import com.just.agentweb.JsCallJava;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import me.tvspark.bj0;
import me.tvspark.cg0;
import me.tvspark.dx0;
import me.tvspark.ef0;
import me.tvspark.ek0;
import me.tvspark.fj0;
import me.tvspark.ii0;
import me.tvspark.mx0;
import me.tvspark.nk0;
import me.tvspark.nx0;
import me.tvspark.of0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.uw0;
import me.tvspark.vw0;
import me.tvspark.ww0;
import me.tvspark.xg0;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.ByteString;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.p056io.input.XmlStreamReader;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@ef0
/* loaded from: classes4.dex */
public final class Util {
    public static final TimeZone UTC;
    public static final Regex VERIFY_AS_IP_ADDRESS;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Headers EMPTY_HEADERS = Headers.Companion.m53of(new String[0]);
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, EMPTY_BYTE_ARRAY, (MediaType) null, 1, (Object) null);
    public static final RequestBody EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, EMPTY_BYTE_ARRAY, (MediaType) null, 0, 0, 7, (Object) null);
    public static final dx0 UNICODE_BOMS = dx0.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("efbbbf"), ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("feff"), ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("fffe"), ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0000ffff"), ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ffff0000"));

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final int and(short s, int i) {
        return s & i;
    }

    public static final long and(int i, long j) {
        return i & j;
    }

    public static final EventListener.Factory asFactory(final EventListener eventListener) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(eventListener, "$this$asFactory");
        return new EventListener.Factory() { // from class: okhttp3.internal.Util$asFactory$1
            @Override // okhttp3.EventListener.Factory
            public EventListener create(Call call) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
                return EventListener.this;
            }
        };
    }

    public static final boolean canParseAsIpAddress(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "$this$canReuseConnectionFor");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl2, "other");
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) httpUrl.host(), (Object) httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) httpUrl.scheme(), (Object) httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        boolean z = true;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (!(timeUnit != null)) {
                throw new IllegalStateException("unit == null".toString());
            }
            long millis = timeUnit.toMillis(j);
            if (!(millis <= ((long) Integer.MAX_VALUE))) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " too large.").toString());
            }
            if (millis == 0 && i > 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " too small.").toString());
            }
            return (int) millis;
        }
        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(serverSocket, "$this$closeQuietly");
        try {
            serverSocket.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Socket socket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "$this$concat");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr2, "$this$lastIndex");
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static final String connectionName(Socket socket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "$this$connectionName");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    public static final int delimiterOffset(String str, char c, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int delimiterOffset(String str, String str2, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$delimiterOffset");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "delimiters");
        while (i < i2) {
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, str.charAt(i), false, 2)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final boolean discard(mx0 mx0Var, int i, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "$this$discard");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
        try {
            return skipAll(mx0Var, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final void execute(Executor executor, String str, xg0<of0> xg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executor, "$this$execute");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "block");
        executor.execute(new Util$execute$1(str, xg0Var));
    }

    public static final String format(String str, Object... objArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, IjkMediaMeta.IJKM_KEY_FORMAT);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr, JsCallJava.KEY_ARGS);
        Locale locale = Locale.US;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "$this$hasIntersection");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "$this$headersContentLength");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(xg0<of0> xg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "block");
        try {
            xg0Var.mo4969invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "$this$indexOf");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "value");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, "comparator");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfNonWhitespace(String str, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$indexOfNonWhitespace");
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "$this$intersect");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr2, "other");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final void lockAndWaitNanos(Object obj, long j) throws InterruptedException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "$this$lockAndWaitNanos");
        long j2 = j / StopWatch.NANO_2_MILLIS;
        long j3 = j - (StopWatch.NANO_2_MILLIS * j2);
        synchronized (obj) {
            waitMillis(obj, j2, (int) j3);
        }
    }

    public static final void notify(Object obj) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "$this$notify");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "$this$notifyAll");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static final Charset readBomAsCharset(ww0 ww0Var, Charset charset) throws IOException {
        Charset charset2;
        String str;
        Charset charset3;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "$this$readBomAsCharset");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "default");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ww0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UNICODE_BOMS);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                charset2 = StandardCharsets.UTF_8;
                str = "UTF_8";
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                charset2 = StandardCharsets.UTF_16BE;
                str = "UTF_16BE";
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 2) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3) {
                    ek0 ek0Var = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    charset3 = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (charset3 == null) {
                        charset3 = Charset.forName(XmlStreamReader.UTF_32BE);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset3, "Charset.forName(\"UTF-32BE\")");
                        ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charset3;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 4) {
                    ek0 ek0Var2 = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    charset3 = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (charset3 == null) {
                        charset3 = Charset.forName(XmlStreamReader.UTF_32LE);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset3, "Charset.forName(\"UTF-32LE\")");
                        ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charset3;
                    }
                } else {
                    throw new AssertionError();
                }
                return charset3;
            } else {
                charset2 = StandardCharsets.UTF_16LE;
                str = "UTF_16LE";
            }
            String str2 = str;
            Charset charset4 = charset2;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) charset4, str2);
            return charset4;
        }
        return charset;
    }

    public static final int readMedium(ww0 ww0Var) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "$this$readMedium");
        return and(ww0Var.readByte(), 255) | (and(ww0Var.readByte(), 255) << 16) | (and(ww0Var.readByte(), 255) << 8);
    }

    public static final int skipAll(uw0 uw0Var, byte b) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "$this$skipAll");
        int i = 0;
        while (!uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L) == b) {
            i++;
            uw0Var.readByte();
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r5 == Long.MAX_VALUE) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
        r11.timeout().clearDeadline();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007f, code lost:
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
        r11.timeout().deadlineNanoTime(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
        if (r5 != Long.MAX_VALUE) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean skipAll(mx0 mx0Var, int i, TimeUnit timeUnit) throws IOException {
        boolean z;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "$this$skipAll");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = mx0Var.timeout().hasDeadline() ? mx0Var.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        mx0Var.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i)) + nanoTime);
        try {
            uw0 uw0Var = new uw0();
            while (mx0Var.read(uw0Var, 8192L) != -1) {
                uw0Var.skip(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww);
            }
            z = true;
        } catch (InterruptedIOException unused) {
            z = false;
        } catch (Throwable th) {
            int i2 = (deadlineNanoTime > Long.MAX_VALUE ? 1 : (deadlineNanoTime == Long.MAX_VALUE ? 0 : -1));
            nx0 timeout = mx0Var.timeout();
            if (i2 == 0) {
                timeout.clearDeadline();
            } else {
                timeout.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String str, final boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.Util$threadFactory$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static final void threadName(String str, xg0<of0> xg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "block");
        Thread currentThread = Thread.currentThread();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            xg0Var.mo4969invoke();
        } finally {
            currentThread.setName(name);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, "$this$toHeaderList");
        bj0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, headers.size());
        ArrayList arrayList = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 10));
        Iterator<Integer> it = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((cg0) it).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            arrayList.add(new Header(headers.name(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), headers.value(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z) {
        String host;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "$this$toHostHeader");
        if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) httpUrl.host(), (CharSequence) ":", false, 2)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(httpUrl.host());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
            host = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        } else {
            host = httpUrl.host();
        }
        if (z || httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return host + ':' + httpUrl.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) list));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(String str, int i) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong >= 0) {
                    return (int) parseLong;
                }
                return 0;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final String trimSubstring(String str, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i, i2);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i2));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final void tryExecute(Executor executor, String str, xg0<of0> xg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executor, "$this$tryExecute");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "block");
        try {
            executor.execute(new Util$execute$1(str, xg0Var));
        } catch (RejectedExecutionException unused) {
        }
    }

    public static final void wait(Object obj) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "$this$wait");
        obj.wait();
    }

    public static final void waitMillis(Object obj, long j, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "$this$waitMillis");
        if (j > 0 || i > 0) {
            obj.wait(j, i);
        }
    }

    public static /* synthetic */ void waitMillis$default(Object obj, long j, int i, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        waitMillis(obj, j, i);
    }

    public static final void writeMedium(vw0 vw0Var, int i) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "$this$writeMedium");
        vw0Var.mo4963writeByte((i >>> 16) & 255);
        vw0Var.mo4963writeByte((i >>> 8) & 255);
        vw0Var.mo4963writeByte(i & 255);
    }
}
