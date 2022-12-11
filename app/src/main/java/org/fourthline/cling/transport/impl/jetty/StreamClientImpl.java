package org.fourthline.cling.transport.impl.jetty;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.message.UpnpMessage;
import org.fourthline.cling.model.message.UpnpRequest;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.header.ContentTypeHeader;
import org.fourthline.cling.model.message.header.UpnpHeader;
import org.fourthline.cling.transport.spi.AbstractStreamClient;
import org.fourthline.cling.transport.spi.InitializationException;
import org.fourthline.cling.transport.spi.StreamClient;
import org.seamless.util.Exceptions;
import org.seamless.util.MimeType;

/* loaded from: classes5.dex */
public class StreamClientImpl extends AbstractStreamClient<StreamClientConfigurationImpl, HttpContentExchange> {
    public static final Logger log = Logger.getLogger(StreamClient.class.getName());
    public final HttpClient client;
    public final StreamClientConfigurationImpl configuration;

    /* loaded from: classes5.dex */
    public static class HttpContentExchange extends ContentExchange {
        public final HttpClient client;
        public final StreamClientConfigurationImpl configuration;
        public Throwable exception;
        public final StreamRequestMessage requestMessage;

        public HttpContentExchange(StreamClientConfigurationImpl streamClientConfigurationImpl, HttpClient httpClient, StreamRequestMessage streamRequestMessage) {
            super(true);
            this.configuration = streamClientConfigurationImpl;
            this.client = httpClient;
            this.requestMessage = streamRequestMessage;
            applyRequestURLMethod();
            applyRequestHeaders();
            applyRequestBody();
        }

        public void applyRequestBody() {
            ByteArrayBuffer byteArrayBuffer;
            if (getRequestMessage().hasBody()) {
                if (getRequestMessage().getBodyType() == UpnpMessage.BodyType.STRING) {
                    if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                        Logger logger = StreamClientImpl.log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing textual request body: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestMessage());
                        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                    MimeType value = getRequestMessage().getContentTypeHeader() != null ? getRequestMessage().getContentTypeHeader().getValue() : ContentTypeHeader.DEFAULT_CONTENT_TYPE_UTF8;
                    String contentTypeCharset = getRequestMessage().getContentTypeCharset() != null ? getRequestMessage().getContentTypeCharset() : "UTF-8";
                    setRequestContentType(value.toString());
                    try {
                        byteArrayBuffer = new ByteArrayBuffer(getRequestMessage().getBodyString(), contentTypeCharset);
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unsupported character encoding: ", contentTypeCharset), e);
                    }
                } else {
                    if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                        Logger logger2 = StreamClientImpl.log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing binary request body: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getRequestMessage());
                        logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                    if (getRequestMessage().getContentTypeHeader() == null) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing content type header in request message: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.requestMessage);
                        throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    }
                    setRequestContentType(getRequestMessage().getContentTypeHeader().getValue().toString());
                    byteArrayBuffer = new ByteArrayBuffer(getRequestMessage().getBodyBytes());
                }
                setRequestHeader("Content-Length", String.valueOf(byteArrayBuffer.length()));
                setRequestContent(byteArrayBuffer);
            }
        }

        public void applyRequestHeaders() {
            UpnpHeaders headers = getRequestMessage().getHeaders();
            if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                Logger logger = StreamClientImpl.log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing headers on HttpContentExchange: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(headers.size());
                logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            if (!headers.containsKey(UpnpHeader.Type.USER_AGENT)) {
                setRequestHeader(UpnpHeader.Type.USER_AGENT.getHttpName(), getConfiguration().getUserAgentValue(getRequestMessage().getUdaMajorVersion(), getRequestMessage().getUdaMinorVersion()));
            }
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                for (String str : entry.getValue()) {
                    String key = entry.getKey();
                    if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                        Logger logger2 = StreamClientImpl.log;
                        logger2.fine("Setting header '" + key + "': " + str);
                    }
                    addRequestHeader(key, str);
                }
            }
        }

        public void applyRequestURLMethod() {
            UpnpRequest operation = getRequestMessage().getOperation();
            if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                Logger logger = StreamClientImpl.log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Preparing HTTP request message with method '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(operation.getHttpMethodName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestMessage());
                logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            setURL(operation.getURI().toString());
            setMethod(operation.getHttpMethodName());
        }

        public StreamResponseMessage createResponse() {
            UpnpResponse upnpResponse = new UpnpResponse(getResponseStatus(), UpnpResponse.Status.getByStatusCode(getResponseStatus()).getStatusMsg());
            if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                Logger logger = StreamClientImpl.log;
                logger.fine("Received response: " + upnpResponse);
            }
            StreamResponseMessage streamResponseMessage = new StreamResponseMessage(upnpResponse);
            UpnpHeaders upnpHeaders = new UpnpHeaders();
            HttpFields responseFields = getResponseFields();
            for (String str : responseFields.getFieldNamesCollection()) {
                for (String str2 : responseFields.getValuesCollection(str)) {
                    upnpHeaders.add(str, str2);
                }
            }
            streamResponseMessage.setHeaders(upnpHeaders);
            byte[] responseContentBytes = getResponseContentBytes();
            if (responseContentBytes != null && responseContentBytes.length > 0 && streamResponseMessage.isContentTypeMissingOrText()) {
                if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                    StreamClientImpl.log.fine("Response contains textual entity body, converting then setting string on message");
                }
                try {
                    streamResponseMessage.setBodyCharacters(responseContentBytes);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("Unsupported character encoding: " + e, e);
                }
            } else if (responseContentBytes != null && responseContentBytes.length > 0) {
                if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                    StreamClientImpl.log.fine("Response contains binary entity body, setting bytes on message");
                }
                streamResponseMessage.setBody(UpnpMessage.BodyType.BYTES, responseContentBytes);
            } else if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                StreamClientImpl.log.fine("Response did not contain entity body");
            }
            if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                Logger logger2 = StreamClientImpl.log;
                logger2.fine("Response message complete: " + streamResponseMessage);
            }
            return streamResponseMessage;
        }

        public StreamClientConfigurationImpl getConfiguration() {
            return this.configuration;
        }

        public StreamRequestMessage getRequestMessage() {
            return this.requestMessage;
        }

        @Override // org.eclipse.jetty.client.HttpExchange
        public void onConnectionFailed(Throwable th) {
            Logger logger = StreamClientImpl.log;
            Level level = Level.WARNING;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HTTP connection failed: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.requestMessage);
            logger.log(level, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), Exceptions.unwrap(th));
        }

        @Override // org.eclipse.jetty.client.HttpExchange
        public void onException(Throwable th) {
            Logger logger = StreamClientImpl.log;
            Level level = Level.WARNING;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HTTP request failed: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.requestMessage);
            logger.log(level, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), Exceptions.unwrap(th));
        }
    }

    public StreamClientImpl(StreamClientConfigurationImpl streamClientConfigurationImpl) throws InitializationException {
        this.configuration = streamClientConfigurationImpl;
        log.info("Starting Jetty HttpClient...");
        HttpClient httpClient = new HttpClient();
        this.client = httpClient;
        httpClient.setThreadPool(new ExecutorThreadPool(mo5230getConfiguration().getRequestExecutorService()) { // from class: org.fourthline.cling.transport.impl.jetty.StreamClientImpl.1
            @Override // org.eclipse.jetty.util.thread.ExecutorThreadPool, org.eclipse.jetty.util.component.AbstractLifeCycle
            public void doStop() throws Exception {
            }
        });
        this.client.setTimeout((streamClientConfigurationImpl.getTimeoutSeconds() + 5) * 1000);
        this.client.setConnectTimeout((streamClientConfigurationImpl.getTimeoutSeconds() + 5) * 1000);
        this.client.setMaxRetries(streamClientConfigurationImpl.getRequestRetryCount());
        try {
            this.client.start();
        } catch (Exception e) {
            throw new InitializationException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not start Jetty HTTP client: ", e), e);
        }
    }

    @Override // org.fourthline.cling.transport.spi.AbstractStreamClient
    public void abort(HttpContentExchange httpContentExchange) {
        httpContentExchange.cancel();
    }

    @Override // org.fourthline.cling.transport.spi.AbstractStreamClient
    public Callable<StreamResponseMessage> createCallable(final StreamRequestMessage streamRequestMessage, final HttpContentExchange httpContentExchange) {
        return new Callable<StreamResponseMessage>() { // from class: org.fourthline.cling.transport.impl.jetty.StreamClientImpl.2
            @Override // java.util.concurrent.Callable
            public StreamResponseMessage call() throws Exception {
                if (StreamClientImpl.log.isLoggable(Level.FINE)) {
                    Logger logger = StreamClientImpl.log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending HTTP request: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(streamRequestMessage);
                    logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                StreamClientImpl.this.client.send(httpContentExchange);
                int waitForDone = httpContentExchange.waitForDone();
                if (waitForDone == 7) {
                    try {
                        return httpContentExchange.createResponse();
                    } catch (Throwable th) {
                        Logger logger2 = StreamClientImpl.log;
                        Level level = Level.WARNING;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error reading response: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(streamRequestMessage);
                        logger2.log(level, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), Exceptions.unwrap(th));
                        return null;
                    }
                } else if (waitForDone == 11 || waitForDone == 9) {
                    return null;
                } else {
                    Logger logger3 = StreamClientImpl.log;
                    logger3.warning("Unhandled HTTP exchange status: " + waitForDone);
                    return null;
                }
            }
        };
    }

    @Override // org.fourthline.cling.transport.spi.AbstractStreamClient
    public HttpContentExchange createRequest(StreamRequestMessage streamRequestMessage) {
        return new HttpContentExchange(mo5230getConfiguration(), this.client, streamRequestMessage);
    }

    @Override // org.fourthline.cling.transport.spi.StreamClient
    /* renamed from: getConfiguration */
    public StreamClientConfigurationImpl mo5230getConfiguration() {
        return this.configuration;
    }

    @Override // org.fourthline.cling.transport.spi.AbstractStreamClient
    public boolean logExecutionException(Throwable th) {
        return false;
    }

    @Override // org.fourthline.cling.transport.spi.StreamClient
    public void stop() {
        try {
            this.client.stop();
        } catch (Exception e) {
            Logger logger = log;
            logger.info("Error stopping HTTP client: " + e);
        }
    }
}
