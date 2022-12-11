package org.fourthline.cling.transport.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.message.UpnpMessage;
import org.fourthline.cling.model.message.UpnpRequest;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.header.UpnpHeader;
import org.fourthline.cling.transport.spi.InitializationException;
import org.fourthline.cling.transport.spi.StreamClient;
import org.seamless.http.Headers;
import org.seamless.util.Exceptions;
import org.seamless.util.URIUtil;
import org.seamless.util.p061io.C3387IO;

/* loaded from: classes5.dex */
public class StreamClientImpl implements StreamClient {
    public static final String HACK_STREAM_HANDLER_SYSTEM_PROPERTY = "hackStreamHandlerProperty";
    public static final Logger log = Logger.getLogger(StreamClient.class.getName());
    public final StreamClientConfigurationImpl configuration;

    public StreamClientImpl(StreamClientConfigurationImpl streamClientConfigurationImpl) throws InitializationException {
        this.configuration = streamClientConfigurationImpl;
        if (ModelUtil.ANDROID_EMULATOR || ModelUtil.ANDROID_RUNTIME) {
            throw new InitializationException("This client does not work on Android. The design of HttpURLConnection is broken, we can not add additional 'permitted' HTTP methods. Read the Cling manual.");
        }
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Using persistent HTTP stream client connections: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(streamClientConfigurationImpl.isUsePersistentConnections());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        System.setProperty("http.keepAlive", Boolean.toString(streamClientConfigurationImpl.isUsePersistentConnections()));
        if (System.getProperty(HACK_STREAM_HANDLER_SYSTEM_PROPERTY) != null) {
            return;
        }
        log.fine("Setting custom static URLStreamHandlerFactory to work around bad JDK defaults");
        URL.setURLStreamHandlerFactory((URLStreamHandlerFactory) Class.forName("org.fourthline.cling.transport.impl.FixedSunURLStreamHandler").newInstance());
        System.setProperty(HACK_STREAM_HANDLER_SYSTEM_PROPERTY, "alreadyWorkedAroundTheEvilJDK");
    }

    public void applyHeaders(HttpURLConnection httpURLConnection, Headers headers) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing headers on HttpURLConnection: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(headers.size());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            for (String str : entry.getValue()) {
                String key = entry.getKey();
                Logger logger2 = log;
                logger2.fine("Setting header '" + key + "': " + str);
                httpURLConnection.setRequestProperty(key, str);
            }
        }
    }

    public void applyRequestBody(HttpURLConnection httpURLConnection, StreamRequestMessage streamRequestMessage) throws IOException {
        if (!streamRequestMessage.hasBody()) {
            httpURLConnection.setDoOutput(false);
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (streamRequestMessage.getBodyType().equals(UpnpMessage.BodyType.STRING)) {
            C3387IO.writeUTF8(httpURLConnection.getOutputStream(), streamRequestMessage.getBodyString());
        } else if (streamRequestMessage.getBodyType().equals(UpnpMessage.BodyType.BYTES)) {
            C3387IO.writeBytes(httpURLConnection.getOutputStream(), streamRequestMessage.getBodyBytes());
        }
        httpURLConnection.getOutputStream().flush();
    }

    public void applyRequestProperties(HttpURLConnection httpURLConnection, StreamRequestMessage streamRequestMessage) {
        httpURLConnection.setInstanceFollowRedirects(false);
        if (!streamRequestMessage.getHeaders().containsKey(UpnpHeader.Type.USER_AGENT)) {
            httpURLConnection.setRequestProperty(UpnpHeader.Type.USER_AGENT.getHttpName(), mo5230getConfiguration().getUserAgentValue(streamRequestMessage.getUdaMajorVersion(), streamRequestMessage.getUdaMinorVersion()));
        }
        applyHeaders(httpURLConnection, streamRequestMessage.getHeaders());
    }

    public StreamResponseMessage createResponse(HttpURLConnection httpURLConnection, InputStream inputStream) throws Exception {
        byte[] bArr = null;
        if (httpURLConnection.getResponseCode() == -1) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Received an invalid HTTP response: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(httpURLConnection.getURL());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            log.warning("Is your Cling-based server sending connection heartbeats with RemoteClientInfo#isRequestCancelled? This client can't handle heartbeats, read the manual.");
            return null;
        }
        UpnpResponse upnpResponse = new UpnpResponse(httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage());
        Logger logger2 = log;
        logger2.fine("Received response: " + upnpResponse);
        StreamResponseMessage streamResponseMessage = new StreamResponseMessage(upnpResponse);
        streamResponseMessage.setHeaders(new UpnpHeaders(httpURLConnection.getHeaderFields()));
        if (inputStream != null) {
            try {
                bArr = C3387IO.readBytes(inputStream);
            } finally {
                inputStream.close();
            }
        }
        if (inputStream != null) {
        }
        if (bArr != null && bArr.length > 0 && streamResponseMessage.isContentTypeMissingOrText()) {
            log.fine("Response contains textual entity body, converting then setting string on message");
            streamResponseMessage.setBodyCharacters(bArr);
        } else if (bArr == null || bArr.length <= 0) {
            log.fine("Response did not contain entity body");
        } else {
            log.fine("Response contains binary entity body, setting bytes on message");
            streamResponseMessage.setBody(UpnpMessage.BodyType.BYTES, bArr);
        }
        Logger logger3 = log;
        logger3.fine("Response message complete: " + streamResponseMessage);
        return streamResponseMessage;
    }

    @Override // org.fourthline.cling.transport.spi.StreamClient
    /* renamed from: getConfiguration */
    public StreamClientConfigurationImpl mo5230getConfiguration() {
        return this.configuration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0175  */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.fourthline.cling.transport.impl.StreamClientImpl] */
    @Override // org.fourthline.cling.transport.spi.StreamClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StreamResponseMessage sendRequest(StreamRequestMessage streamRequestMessage) {
        UpnpRequest operation = streamRequestMessage.getOperation();
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Preparing HTTP request message with method '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(operation.getHttpMethodName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(streamRequestMessage);
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        ?? url = URIUtil.toURL(operation.getURI());
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                url = (HttpURLConnection) url.openConnection();
                try {
                    url.setRequestMethod(operation.getHttpMethodName());
                    url.setReadTimeout(this.configuration.getTimeoutSeconds() * 1000);
                    url.setConnectTimeout(this.configuration.getTimeoutSeconds() * 1000);
                    applyRequestProperties(url, streamRequestMessage);
                    applyRequestBody(url, streamRequestMessage);
                    log.fine("Sending HTTP request: " + streamRequestMessage);
                    StreamResponseMessage createResponse = createResponse(url, url.getInputStream());
                    url.disconnect();
                    return createResponse;
                } catch (ProtocolException e) {
                    e = e;
                    log.log(Level.WARNING, "HTTP request failed: " + streamRequestMessage, Exceptions.unwrap(e));
                    if (url != 0) {
                        url.disconnect();
                    }
                    return null;
                } catch (IOException e2) {
                    e = e2;
                    if (url == 0) {
                        log.log(Level.WARNING, "HTTP request failed: " + streamRequestMessage, Exceptions.unwrap(e));
                        if (url != 0) {
                            url.disconnect();
                        }
                        return null;
                    } else if (e instanceof SocketTimeoutException) {
                        log.info("Timeout of " + mo5230getConfiguration().getTimeoutSeconds() + " seconds while waiting for HTTP request to complete, aborting: " + streamRequestMessage);
                        url.disconnect();
                        return null;
                    } else {
                        if (log.isLoggable(Level.FINE)) {
                            log.fine("Exception occurred, trying to read the error stream: " + Exceptions.unwrap(e));
                        }
                        try {
                            StreamResponseMessage createResponse2 = createResponse(url, url.getErrorStream());
                            url.disconnect();
                            return createResponse2;
                        } catch (Exception e3) {
                            if (log.isLoggable(Level.FINE)) {
                                log.fine("Could not read error stream: " + e3);
                            }
                            url.disconnect();
                            return null;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    log.log(Level.WARNING, "HTTP request failed: " + streamRequestMessage, Exceptions.unwrap(e));
                    if (url != 0) {
                        url.disconnect();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection = url;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (ProtocolException e5) {
            e = e5;
            url = 0;
        } catch (IOException e6) {
            e = e6;
            url = 0;
        } catch (Exception e7) {
            e = e7;
            url = 0;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    @Override // org.fourthline.cling.transport.spi.StreamClient
    public void stop() {
    }
}
