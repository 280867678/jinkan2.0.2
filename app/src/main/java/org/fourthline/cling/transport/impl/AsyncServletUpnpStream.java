package org.fourthline.cling.transport.impl;

import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.message.Connection;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.message.UpnpMessage;
import org.fourthline.cling.model.message.UpnpRequest;
import org.fourthline.cling.protocol.ProtocolFactory;
import org.fourthline.cling.transport.spi.UpnpStream;
import org.seamless.util.p061io.C3387IO;

/* loaded from: classes5.dex */
public abstract class AsyncServletUpnpStream extends UpnpStream implements AsyncListener {
    public static final Logger log = Logger.getLogger(UpnpStream.class.getName());
    public final AsyncContext asyncContext;
    public final ae0 request;
    public StreamResponseMessage responseMessage;

    public AsyncServletUpnpStream(ProtocolFactory protocolFactory, AsyncContext asyncContext, ae0 ae0Var) {
        super(protocolFactory);
        this.asyncContext = asyncContext;
        this.request = ae0Var;
        asyncContext.addListener(this);
    }

    public void complete() {
        try {
            this.asyncContext.complete();
        } catch (IllegalStateException e) {
            Logger logger = log;
            logger.info("Error calling servlet container's AsyncContext#complete() method: " + e);
        }
    }

    public abstract Connection createConnection();

    public ae0 getRequest() {
        return this.request;
    }

    public ce0 getResponse() {
        ServletResponse response = this.asyncContext.getResponse();
        if (response != null) {
            return (ce0) response;
        }
        throw new IllegalStateException("Couldn't get response from asynchronous context, already timed out");
    }

    @Override // javax.servlet.AsyncListener
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        if (log.isLoggable(Level.FINER)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Completed asynchronous processing of HTTP request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(asyncEvent.getSuppliedRequest());
            logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        responseSent(this.responseMessage);
    }

    @Override // javax.servlet.AsyncListener
    public void onError(AsyncEvent asyncEvent) throws IOException {
        if (log.isLoggable(Level.FINER)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Asynchronous processing of HTTP request error: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(asyncEvent.getThrowable());
            logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        responseException(asyncEvent.getThrowable());
    }

    @Override // javax.servlet.AsyncListener
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
    }

    @Override // javax.servlet.AsyncListener
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        if (log.isLoggable(Level.FINER)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Asynchronous processing of HTTP request timed out: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(asyncEvent.getSuppliedRequest());
            logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        responseException(new Exception("Asynchronous request timed out"));
    }

    public StreamRequestMessage readRequestMessage() throws IOException {
        String method = getRequest().getMethod();
        String requestURI = getRequest().getRequestURI();
        if (log.isLoggable(Level.FINER)) {
            Logger logger = log;
            logger.finer("Processing HTTP request: " + method + StringUtils.SPACE + requestURI);
        }
        try {
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.getByHttpName(method), URI.create(requestURI));
            if (((UpnpRequest) streamRequestMessage.getOperation()).getMethod().equals(UpnpRequest.Method.UNKNOWN)) {
                throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Method not supported: ", method));
            }
            streamRequestMessage.setConnection(createConnection());
            UpnpHeaders upnpHeaders = new UpnpHeaders();
            Enumeration<String> headerNames = getRequest().getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String nextElement = headerNames.nextElement();
                Enumeration<String> headers = getRequest().getHeaders(nextElement);
                while (headers.hasMoreElements()) {
                    upnpHeaders.add(nextElement, headers.nextElement());
                }
            }
            streamRequestMessage.setHeaders(upnpHeaders);
            ServletInputStream servletInputStream = null;
            try {
                servletInputStream = getRequest().getInputStream();
                byte[] readBytes = C3387IO.readBytes(servletInputStream);
                if (log.isLoggable(Level.FINER)) {
                    Logger logger2 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Reading request body bytes: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(readBytes.length);
                    logger2.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                if (readBytes.length > 0 && streamRequestMessage.isContentTypeMissingOrText()) {
                    if (log.isLoggable(Level.FINER)) {
                        log.finer("Request contains textual entity body, converting then setting string on message");
                    }
                    streamRequestMessage.setBodyCharacters(readBytes);
                } else if (readBytes.length > 0) {
                    if (log.isLoggable(Level.FINER)) {
                        log.finer("Request contains binary entity body, setting bytes on message");
                    }
                    streamRequestMessage.setBody(UpnpMessage.BodyType.BYTES, readBytes);
                } else if (log.isLoggable(Level.FINER)) {
                    log.finer("Request did not contain entity body");
                }
                return streamRequestMessage;
            } finally {
                if (servletInputStream != null) {
                    servletInputStream.close();
                }
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid request URI: ", requestURI), e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            StreamRequestMessage readRequestMessage = readRequestMessage();
            if (log.isLoggable(Level.FINER)) {
                Logger logger = log;
                logger.finer("Processing new request message: " + readRequestMessage);
            }
            StreamResponseMessage process = process(readRequestMessage);
            this.responseMessage = process;
            if (process != null) {
                if (log.isLoggable(Level.FINER)) {
                    Logger logger2 = log;
                    logger2.finer("Preparing HTTP response message: " + this.responseMessage);
                }
                writeResponseMessage(this.responseMessage);
            } else {
                if (log.isLoggable(Level.FINER)) {
                    log.finer("Sending HTTP response status: 404");
                }
                getResponse().setStatus(404);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void writeResponseMessage(StreamResponseMessage streamResponseMessage) throws IOException {
        if (log.isLoggable(Level.FINER)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending HTTP response status: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(streamResponseMessage.getOperation().getStatusCode());
            logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        getResponse().setStatus(streamResponseMessage.getOperation().getStatusCode());
        for (Map.Entry<String, List<String>> entry : streamResponseMessage.getHeaders().entrySet()) {
            for (String str : entry.getValue()) {
                getResponse().addHeader(entry.getKey(), str);
            }
        }
        getResponse().setDateHeader("Date", System.currentTimeMillis());
        byte[] bodyBytes = streamResponseMessage.hasBody() ? streamResponseMessage.getBodyBytes() : null;
        int length = bodyBytes != null ? bodyBytes.length : -1;
        if (length > 0) {
            getResponse().setContentLength(length);
            log.finer("Response message has body, writing bytes to stream...");
            C3387IO.writeBytes(getResponse().getOutputStream(), bodyBytes);
        }
    }
}
