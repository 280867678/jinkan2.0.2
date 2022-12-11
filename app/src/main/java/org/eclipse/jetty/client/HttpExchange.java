package org.eclipse.jetty.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpSchemes;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.HttpVersions;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferCache;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Timeout;

/* loaded from: classes4.dex */
public class HttpExchange {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Logger LOG = Log.getLogger(HttpExchange.class);
    public static final int STATUS_CANCELLED = 11;
    public static final int STATUS_CANCELLING = 10;
    public static final int STATUS_COMPLETED = 7;
    public static final int STATUS_EXCEPTED = 9;
    public static final int STATUS_EXPIRED = 8;
    public static final int STATUS_PARSING_CONTENT = 6;
    public static final int STATUS_PARSING_HEADERS = 5;
    public static final int STATUS_SENDING_COMPLETED = 14;
    public static final int STATUS_SENDING_PARSING_CONTENT = 13;
    public static final int STATUS_SENDING_PARSING_HEADERS = 12;
    public static final int STATUS_SENDING_REQUEST = 3;
    public static final int STATUS_START = 0;
    public static final int STATUS_WAITING_FOR_COMMIT = 2;
    public static final int STATUS_WAITING_FOR_CONNECTION = 1;
    public static final int STATUS_WAITING_FOR_RESPONSE = 4;
    public Address _address;
    public volatile AbstractHttpConnection _connection;
    public boolean _onDone;
    public boolean _onRequestCompleteDone;
    public boolean _onResponseCompleteDone;
    public Buffer _requestContent;
    public InputStream _requestContentSource;
    public volatile Timeout.Task _timeoutTask;
    public String _uri;
    public String _method = "GET";
    public Buffer _scheme = HttpSchemes.HTTP_BUFFER;
    public int _version = 11;
    public final HttpFields _requestFields = new HttpFields();
    public AtomicInteger _status = new AtomicInteger(0);
    public boolean _retryStatus = false;
    public boolean _configureListeners = true;
    public HttpEventListener _listener = new Listener();
    public Address _localAddress = null;
    public long _timeout = -1;
    public long _lastStateChange = System.currentTimeMillis();
    public long _sent = -1;
    public int _lastState = -1;
    public int _lastStatePeriod = -1;

    @Deprecated
    /* loaded from: classes4.dex */
    public static class CachedExchange extends org.eclipse.jetty.client.CachedExchange {
        public CachedExchange(boolean z) {
            super(z);
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public static class ContentExchange extends org.eclipse.jetty.client.ContentExchange {
    }

    /* loaded from: classes4.dex */
    public class Listener implements HttpEventListener {
        public Listener() {
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onConnectionFailed(Throwable th) {
            try {
                HttpExchange.this.onConnectionFailed(th);
            } finally {
                HttpExchange.this.done();
            }
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onException(Throwable th) {
            try {
                HttpExchange.this.onException(th);
            } finally {
                HttpExchange.this.done();
            }
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onExpire() {
            try {
                HttpExchange.this.onExpire();
            } finally {
                HttpExchange.this.done();
            }
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onRequestCommitted() throws IOException {
            HttpExchange.this.onRequestCommitted();
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onRequestComplete() throws IOException {
            try {
                HttpExchange.this.onRequestComplete();
                synchronized (HttpExchange.this) {
                    HttpExchange.this._onRequestCompleteDone = true;
                    HttpExchange.this._onDone |= HttpExchange.this._onResponseCompleteDone;
                    if (HttpExchange.this._onDone) {
                        HttpExchange.this.disassociate();
                    }
                    HttpExchange.this.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (HttpExchange.this) {
                    HttpExchange.this._onRequestCompleteDone = true;
                    HttpExchange.this._onDone |= HttpExchange.this._onResponseCompleteDone;
                    if (HttpExchange.this._onDone) {
                        HttpExchange.this.disassociate();
                    }
                    HttpExchange.this.notifyAll();
                    throw th;
                }
            }
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseComplete() throws IOException {
            try {
                HttpExchange.this.onResponseComplete();
                synchronized (HttpExchange.this) {
                    HttpExchange.this._onResponseCompleteDone = true;
                    HttpExchange.this._onDone |= HttpExchange.this._onRequestCompleteDone;
                    if (HttpExchange.this._onDone) {
                        HttpExchange.this.disassociate();
                    }
                    HttpExchange.this.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (HttpExchange.this) {
                    HttpExchange.this._onResponseCompleteDone = true;
                    HttpExchange.this._onDone |= HttpExchange.this._onRequestCompleteDone;
                    if (HttpExchange.this._onDone) {
                        HttpExchange.this.disassociate();
                    }
                    HttpExchange.this.notifyAll();
                    throw th;
                }
            }
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseContent(Buffer buffer) throws IOException {
            HttpExchange.this.onResponseContent(buffer);
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
            HttpExchange.this.onResponseHeader(buffer, buffer2);
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseHeaderComplete() throws IOException {
            HttpExchange.this.onResponseHeaderComplete();
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
            HttpExchange.this.onResponseStatus(buffer, i, buffer2);
        }

        @Override // org.eclipse.jetty.client.HttpEventListener
        public void onRetry() {
            HttpExchange.this.setRetryStatus(true);
            try {
                HttpExchange.this.onRetry();
            } catch (IOException e) {
                HttpExchange.LOG.debug(e);
            }
        }
    }

    private void abort() {
        AbstractHttpConnection abstractHttpConnection = this._connection;
        try {
            if (abstractHttpConnection == null) {
                return;
            }
            try {
                abstractHttpConnection.close();
            } catch (IOException e) {
                LOG.debug(e);
            }
        } finally {
            disassociate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void done() {
        synchronized (this) {
            disassociate();
            this._onDone = true;
            notifyAll();
        }
    }

    private boolean isResponseCompleted() {
        boolean z;
        synchronized (this) {
            z = this._onResponseCompleteDone;
        }
        return z;
    }

    private boolean setStatusExpired(int i, int i2) {
        boolean compareAndSet = this._status.compareAndSet(i2, i);
        if (compareAndSet) {
            getEventListener().onExpire();
        }
        return compareAndSet;
    }

    public static String toState(int i) {
        switch (i) {
            case 0:
                return "START";
            case 1:
                return "CONNECTING";
            case 2:
                return "CONNECTED";
            case 3:
                return "SENDING";
            case 4:
                return "WAITING";
            case 5:
                return "HEADERS";
            case 6:
                return "CONTENT";
            case 7:
                return "COMPLETED";
            case 8:
                return "EXPIRED";
            case 9:
                return "EXCEPTED";
            case 10:
                return "CANCELLING";
            case 11:
                return "CANCELLED";
            case 12:
                return "SENDING+HEADERS";
            case 13:
                return "SENDING+CONTENT";
            case 14:
                return "SENDING+COMPLETED";
            default:
                return "UNKNOWN";
        }
    }

    public void addRequestHeader(String str, String str2) {
        getRequestFields().add(str, str2);
    }

    public void addRequestHeader(Buffer buffer, Buffer buffer2) {
        getRequestFields().add(buffer, buffer2);
    }

    public void associate(AbstractHttpConnection abstractHttpConnection) {
        if (abstractHttpConnection.getEndPoint().getLocalAddr() != null) {
            this._localAddress = new Address(abstractHttpConnection.getEndPoint().getLocalAddr(), abstractHttpConnection.getEndPoint().getLocalPort());
        }
        this._connection = abstractHttpConnection;
        if (getStatus() == 10) {
            abort();
        }
    }

    public void cancel() {
        setStatus(10);
        abort();
    }

    public void cancelTimeout(HttpClient httpClient) {
        Timeout.Task task = this._timeoutTask;
        if (task != null) {
            httpClient.cancel(task);
        }
        this._timeoutTask = null;
    }

    public boolean configureListeners() {
        return this._configureListeners;
    }

    public AbstractHttpConnection disassociate() {
        AbstractHttpConnection abstractHttpConnection = this._connection;
        this._connection = null;
        if (getStatus() == 10) {
            setStatus(11);
        }
        return abstractHttpConnection;
    }

    public void expire(HttpDestination httpDestination) {
        AbstractHttpConnection abstractHttpConnection = this._connection;
        int status = getStatus();
        if (status < 7 || status == 12 || status == 13 || status == 14) {
            setStatus(8);
        }
        httpDestination.exchangeExpired(this);
        if (abstractHttpConnection != null) {
            abstractHttpConnection.exchangeExpired(this);
        }
    }

    public Address getAddress() {
        return this._address;
    }

    public HttpEventListener getEventListener() {
        return this._listener;
    }

    public Address getLocalAddress() {
        return this._localAddress;
    }

    public String getMethod() {
        return this._method;
    }

    public Buffer getRequestContent() {
        return this._requestContent;
    }

    public Buffer getRequestContentChunk(Buffer buffer) throws IOException {
        synchronized (this) {
            if (this._requestContentSource != null) {
                if (buffer == null) {
                    buffer = new ByteArrayBuffer(8192);
                }
                int read = this._requestContentSource.read(buffer.array(), buffer.putIndex(), buffer.space());
                if (read >= 0) {
                    buffer.setPutIndex(buffer.putIndex() + read);
                    return buffer;
                }
            }
            return null;
        }
    }

    public InputStream getRequestContentSource() {
        return this._requestContentSource;
    }

    public HttpFields getRequestFields() {
        return this._requestFields;
    }

    public String getRequestURI() {
        return this._uri;
    }

    public boolean getRetryStatus() {
        return this._retryStatus;
    }

    public Buffer getScheme() {
        return this._scheme;
    }

    public int getStatus() {
        return this._status.get();
    }

    public long getTimeout() {
        return this._timeout;
    }

    @Deprecated
    public String getURI() {
        return getRequestURI();
    }

    public int getVersion() {
        return this._version;
    }

    public boolean isAssociated() {
        return this._connection != null;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this) {
            z = this._onDone;
        }
        return z;
    }

    @Deprecated
    public boolean isDone(int i) {
        return isDone();
    }

    public void onConnectionFailed(Throwable th) {
        Logger logger = LOG;
        logger.warn("CONNECTION FAILED " + this, th);
    }

    public void onException(Throwable th) {
        Logger logger = LOG;
        logger.warn(Log.EXCEPTION + this, th);
    }

    public void onExpire() {
        Logger logger = LOG;
        logger.warn("EXPIRED " + this, new Object[0]);
    }

    public void onRequestCommitted() throws IOException {
    }

    public void onRequestComplete() throws IOException {
    }

    public void onResponseComplete() throws IOException {
    }

    public void onResponseContent(Buffer buffer) throws IOException {
    }

    public void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
    }

    public void onResponseHeaderComplete() throws IOException {
    }

    public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
    }

    public void onRetry() throws IOException {
        InputStream inputStream = this._requestContentSource;
        if (inputStream != null) {
            if (!inputStream.markSupported()) {
                throw new IOException("Unsupported retry attempt");
            }
            this._requestContent = null;
            this._requestContentSource.reset();
        }
    }

    public Connection onSwitchProtocol(EndPoint endPoint) throws IOException {
        return null;
    }

    public void reset() {
        synchronized (this) {
            this._timeoutTask = null;
            this._onRequestCompleteDone = false;
            this._onResponseCompleteDone = false;
            this._onDone = false;
            setStatus(0);
        }
    }

    public void scheduleTimeout(final HttpDestination httpDestination) {
        this._timeoutTask = new Timeout.Task() { // from class: org.eclipse.jetty.client.HttpExchange.1
            @Override // org.eclipse.jetty.util.thread.Timeout.Task
            public void expired() {
                HttpExchange.this.expire(httpDestination);
            }
        };
        HttpClient httpClient = httpDestination.getHttpClient();
        long timeout = getTimeout();
        if (timeout > 0) {
            httpClient.schedule(this._timeoutTask, timeout);
        } else {
            httpClient.schedule(this._timeoutTask);
        }
    }

    public void setAddress(Address address) {
        this._address = address;
    }

    public void setConfigureListeners(boolean z) {
        this._configureListeners = z;
    }

    public void setEventListener(HttpEventListener httpEventListener) {
        this._listener = httpEventListener;
    }

    public void setMethod(String str) {
        this._method = str;
    }

    public void setRequestContent(Buffer buffer) {
        this._requestContent = buffer;
    }

    public void setRequestContentSource(InputStream inputStream) {
        this._requestContentSource = inputStream;
        if (inputStream == null || !inputStream.markSupported()) {
            return;
        }
        this._requestContentSource.mark(Integer.MAX_VALUE);
    }

    public void setRequestContentType(String str) {
        getRequestFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, str);
    }

    public void setRequestHeader(String str, String str2) {
        getRequestFields().put(str, str2);
    }

    public void setRequestHeader(Buffer buffer, Buffer buffer2) {
        getRequestFields().put(buffer, buffer2);
    }

    public void setRequestURI(String str) {
        this._uri = str;
    }

    public void setRetryStatus(boolean z) {
        this._retryStatus = z;
    }

    public void setScheme(String str) {
        Buffer buffer;
        if (str != null) {
            if ("http".equalsIgnoreCase(str)) {
                buffer = HttpSchemes.HTTP_BUFFER;
            } else if (!"https".equalsIgnoreCase(str)) {
                setScheme(new ByteArrayBuffer(str));
                return;
            } else {
                buffer = HttpSchemes.HTTPS_BUFFER;
            }
            setScheme(buffer);
        }
    }

    public void setScheme(Buffer buffer) {
        this._scheme = buffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x016f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003a A[Catch: IOException -> 0x01bd, TryCatch #1 {IOException -> 0x01bd, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x001b, B:11:0x0028, B:12:0x01a7, B:13:0x01bc, B:16:0x002e, B:26:0x0032, B:27:0x0034, B:28:0x003a, B:29:0x0040, B:35:0x0057, B:36:0x005a, B:40:0x006d, B:46:0x0084, B:47:0x0087, B:51:0x009a, B:59:0x00b0, B:64:0x00c5, B:65:0x00c9, B:68:0x00d1, B:70:0x00d5, B:72:0x00db, B:73:0x00e3, B:74:0x00e7, B:75:0x00eb, B:77:0x00ef, B:78:0x00f3, B:82:0x0106, B:83:0x010a, B:88:0x011f, B:91:0x0127, B:93:0x012c, B:94:0x0130, B:95:0x0139, B:100:0x014e, B:102:0x0154, B:104:0x0159, B:108:0x0163, B:110:0x0168), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean setStatus(int i) {
        AtomicInteger atomicInteger;
        boolean compareAndSet;
        HttpEventListener eventListener;
        HttpEventListener eventListener2;
        HttpEventListener eventListener3;
        boolean z;
        boolean z2 = false;
        try {
            int i2 = this._status.get();
            if (i2 != i) {
                long currentTimeMillis = System.currentTimeMillis();
                this._lastStatePeriod = (int) (currentTimeMillis - this._lastStateChange);
                this._lastState = i2;
                this._lastStateChange = currentTimeMillis;
                if (i == 3) {
                    this._sent = currentTimeMillis;
                }
            }
            try {
                switch (i2) {
                    case 0:
                        if (i != 0 && i != 1 && i != 2) {
                            switch (i) {
                                case 8:
                                    compareAndSet = setStatusExpired(i, i2);
                                    break;
                                case 9:
                                case 10:
                                    break;
                                default:
                                    compareAndSet = false;
                                    break;
                            }
                            z = false;
                            if (!compareAndSet || z) {
                                LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                                return compareAndSet;
                            }
                            throw new IllegalStateException(toState(i2) + " => " + toState(i));
                        }
                        atomicInteger = this._status;
                        compareAndSet = atomicInteger.compareAndSet(i2, i);
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 1:
                        if (i != 2) {
                            switch (i) {
                                case 8:
                                    break;
                                case 9:
                                case 10:
                                    break;
                                default:
                                    compareAndSet = false;
                                    break;
                            }
                            z = false;
                            if (!compareAndSet) {
                            }
                            LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                            return compareAndSet;
                        }
                        atomicInteger = this._status;
                        compareAndSet = atomicInteger.compareAndSet(i2, i);
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 2:
                        if (i != 3) {
                            switch (i) {
                                case 8:
                                    break;
                                case 9:
                                case 10:
                                    break;
                                default:
                                    compareAndSet = false;
                                    break;
                            }
                            z = false;
                            if (!compareAndSet) {
                            }
                            LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                            return compareAndSet;
                        }
                        atomicInteger = this._status;
                        compareAndSet = atomicInteger.compareAndSet(i2, i);
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 3:
                        if (i == 4) {
                            compareAndSet = this._status.compareAndSet(i2, i);
                            if (compareAndSet) {
                                eventListener = getEventListener();
                                eventListener.onRequestCommitted();
                            }
                        } else if (i != 5) {
                            switch (i) {
                                case 8:
                                    break;
                                case 9:
                                case 10:
                                    atomicInteger = this._status;
                                    compareAndSet = atomicInteger.compareAndSet(i2, i);
                                    break;
                                default:
                                    compareAndSet = false;
                                    break;
                            }
                        } else {
                            compareAndSet = this._status.compareAndSet(i2, 12);
                        }
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 4:
                        if (i != 5) {
                            switch (i) {
                            }
                            z = false;
                            if (!compareAndSet) {
                            }
                            LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                            return compareAndSet;
                        }
                        atomicInteger = this._status;
                        compareAndSet = atomicInteger.compareAndSet(i2, i);
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 5:
                        switch (i) {
                            case 6:
                                compareAndSet = this._status.compareAndSet(i2, i);
                                if (compareAndSet) {
                                    eventListener2 = getEventListener();
                                    eventListener2.onResponseHeaderComplete();
                                    break;
                                }
                                break;
                            case 9:
                            case 10:
                                atomicInteger = this._status;
                                compareAndSet = atomicInteger.compareAndSet(i2, i);
                                break;
                        }
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 6:
                        switch (i) {
                            case 7:
                                compareAndSet = this._status.compareAndSet(i2, i);
                                if (compareAndSet) {
                                    eventListener3 = getEventListener();
                                    eventListener3.onResponseComplete();
                                    break;
                                }
                                break;
                            case 8:
                                break;
                            case 9:
                            case 10:
                                atomicInteger = this._status;
                                compareAndSet = atomicInteger.compareAndSet(i2, i);
                                break;
                            default:
                                compareAndSet = false;
                                break;
                        }
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 7:
                        if (i != 0) {
                            if (i != 4) {
                                switch (i) {
                                    case 8:
                                    case 9:
                                    case 10:
                                        break;
                                    default:
                                        compareAndSet = false;
                                        z = false;
                                        break;
                                }
                                if (!compareAndSet) {
                                }
                                LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                                return compareAndSet;
                            } else if (isResponseCompleted()) {
                                getEventListener().onRequestCommitted();
                            } else {
                                atomicInteger = this._status;
                            }
                            compareAndSet = false;
                            z = true;
                            if (!compareAndSet) {
                            }
                            LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                            return compareAndSet;
                        }
                        atomicInteger = this._status;
                        compareAndSet = atomicInteger.compareAndSet(i2, i);
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 8:
                    case 9:
                    case 11:
                        if (i == 0) {
                            atomicInteger = this._status;
                            compareAndSet = atomicInteger.compareAndSet(i2, i);
                            z = false;
                            if (!compareAndSet) {
                            }
                            LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                            return compareAndSet;
                        }
                        if (i == 7) {
                            done();
                        }
                        compareAndSet = false;
                        z = true;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 10:
                        if (i == 9 || i == 11) {
                            compareAndSet = this._status.compareAndSet(i2, i);
                            if (compareAndSet) {
                                done();
                            }
                            z = false;
                            if (!compareAndSet) {
                            }
                            LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                            return compareAndSet;
                        }
                        compareAndSet = false;
                        z = true;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 12:
                        if (i == 4) {
                            compareAndSet = this._status.compareAndSet(i2, 5);
                            if (compareAndSet) {
                                eventListener = getEventListener();
                                eventListener.onRequestCommitted();
                            }
                        } else if (i != 6) {
                            switch (i) {
                                case 9:
                                case 10:
                                    atomicInteger = this._status;
                                    compareAndSet = atomicInteger.compareAndSet(i2, i);
                                    break;
                            }
                        } else {
                            compareAndSet = this._status.compareAndSet(i2, 13);
                            if (compareAndSet) {
                                eventListener2 = getEventListener();
                                eventListener2.onResponseHeaderComplete();
                            }
                        }
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 13:
                        if (i != 4) {
                            switch (i) {
                                case 7:
                                    compareAndSet = this._status.compareAndSet(i2, 14);
                                    if (compareAndSet) {
                                        eventListener3 = getEventListener();
                                        eventListener3.onResponseComplete();
                                        break;
                                    }
                                    break;
                                case 9:
                                case 10:
                                    atomicInteger = this._status;
                                    compareAndSet = atomicInteger.compareAndSet(i2, i);
                                    break;
                            }
                        } else {
                            compareAndSet = this._status.compareAndSet(i2, 6);
                            if (compareAndSet) {
                                eventListener = getEventListener();
                                eventListener.onRequestCommitted();
                            }
                        }
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    case 14:
                        if (i == 4) {
                            compareAndSet = this._status.compareAndSet(i2, 7);
                            if (compareAndSet) {
                                eventListener = getEventListener();
                                eventListener.onRequestCommitted();
                            }
                            z = false;
                            if (!compareAndSet) {
                            }
                            LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                            return compareAndSet;
                        }
                        switch (i) {
                            case 8:
                                break;
                            case 9:
                            case 10:
                                atomicInteger = this._status;
                                compareAndSet = atomicInteger.compareAndSet(i2, i);
                                break;
                            default:
                                compareAndSet = false;
                                break;
                        }
                        z = false;
                        if (!compareAndSet) {
                        }
                        LOG.debug("setStatus {} {}", Integer.valueOf(i), this);
                        return compareAndSet;
                    default:
                        throw new AssertionError(i2 + " => " + i);
                }
            } catch (IOException e) {
                e = e;
                z2 = true;
                LOG.warn(e);
                return z2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public void setTimeout(long j) {
        this._timeout = j;
    }

    @Deprecated
    public void setURI(String str) {
        setRequestURI(str);
    }

    public void setURI(URI uri) {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("!Absolute URI: " + uri);
        } else if (uri.isOpaque()) {
            throw new IllegalArgumentException("Opaque URI: " + uri);
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("URI = {}", uri.toASCIIString());
            }
            String scheme = uri.getScheme();
            int port = uri.getPort();
            if (port <= 0) {
                port = "https".equalsIgnoreCase(scheme) ? 443 : 80;
            }
            setScheme(scheme);
            setAddress(new Address(uri.getHost(), port));
            String completePath = new HttpURI(uri).getCompletePath();
            if (completePath == null) {
                completePath = "/";
            }
            setRequestURI(completePath);
        }
    }

    public void setURL(String str) {
        setURI(URI.create(str));
    }

    public void setVersion(int i) {
        this._version = i;
    }

    public void setVersion(String str) {
        BufferCache.CachedBuffer cachedBuffer = HttpVersions.CACHE.get(str);
        this._version = cachedBuffer == null ? 10 : cachedBuffer.getOrdinal();
    }

    public String toString() {
        String state = toState(getStatus());
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this._lastStateChange;
        String format = this._lastState >= 0 ? String.format("%s@%x=%s//%s%s#%s(%dms)->%s(%dms)", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._method, this._address, this._uri, toState(this._lastState), Integer.valueOf(this._lastStatePeriod), state, Long.valueOf(j)) : String.format("%s@%x=%s//%s%s#%s(%dms)", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._method, this._address, this._uri, state, Long.valueOf(j));
        if (getStatus() < 3 || this._sent <= 0) {
            return format;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(format, "sent=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(currentTimeMillis - this._sent);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("ms");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public int waitForDone() throws InterruptedException {
        int i;
        synchronized (this) {
            while (!isDone()) {
                wait();
            }
            i = this._status.get();
        }
        return i;
    }

    @Deprecated
    public void waitForStatus(int i) throws InterruptedException {
        throw new UnsupportedOperationException();
    }
}
