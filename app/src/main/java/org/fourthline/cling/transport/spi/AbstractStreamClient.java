package org.fourthline.cling.transport.spi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.transport.spi.StreamClientConfiguration;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public abstract class AbstractStreamClient<C extends StreamClientConfiguration, REQUEST> implements StreamClient<C> {
    public static final Logger log = Logger.getLogger(StreamClient.class.getName());

    public abstract void abort(REQUEST request);

    public abstract Callable<StreamResponseMessage> createCallable(StreamRequestMessage streamRequestMessage, REQUEST request);

    public abstract REQUEST createRequest(StreamRequestMessage streamRequestMessage);

    public abstract boolean logExecutionException(Throwable th);

    public void onFinally(REQUEST request) {
    }

    @Override // org.fourthline.cling.transport.spi.StreamClient
    public StreamResponseMessage sendRequest(StreamRequestMessage streamRequestMessage) throws InterruptedException {
        if (log.isLoggable(Level.FINE)) {
            Logger logger = log;
            logger.fine("Preparing HTTP request: " + streamRequestMessage);
        }
        REQUEST createRequest = createRequest(streamRequestMessage);
        if (createRequest == null) {
            return null;
        }
        Callable<StreamResponseMessage> createCallable = createCallable(streamRequestMessage, createRequest);
        long currentTimeMillis = System.currentTimeMillis();
        Future submit = mo5230getConfiguration().getRequestExecutorService().submit(createCallable);
        try {
            try {
                try {
                    if (log.isLoggable(Level.FINE)) {
                        Logger logger2 = log;
                        logger2.fine("Waiting " + mo5230getConfiguration().getTimeoutSeconds() + " seconds for HTTP request to complete: " + streamRequestMessage);
                    }
                    StreamResponseMessage streamResponseMessage = (StreamResponseMessage) submit.get(mo5230getConfiguration().getTimeoutSeconds(), TimeUnit.SECONDS);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (log.isLoggable(Level.FINEST)) {
                        Logger logger3 = log;
                        logger3.finest("Got HTTP response in " + currentTimeMillis2 + "ms: " + streamRequestMessage);
                    }
                    if (mo5230getConfiguration().getLogWarningSeconds() > 0 && currentTimeMillis2 > mo5230getConfiguration().getLogWarningSeconds() * 1000) {
                        Logger logger4 = log;
                        logger4.warning("HTTP request took a long time (" + currentTimeMillis2 + "ms): " + streamRequestMessage);
                    }
                    onFinally(createRequest);
                    return streamResponseMessage;
                } catch (TimeoutException unused) {
                    Logger logger5 = log;
                    logger5.info("Timeout of " + mo5230getConfiguration().getTimeoutSeconds() + " seconds while waiting for HTTP request to complete, aborting: " + streamRequestMessage);
                    abort(createRequest);
                    onFinally(createRequest);
                    return null;
                }
            } catch (InterruptedException unused2) {
                if (log.isLoggable(Level.FINE)) {
                    Logger logger6 = log;
                    logger6.fine("Interruption, aborting request: " + streamRequestMessage);
                }
                abort(createRequest);
                throw new InterruptedException("HTTP request interrupted and aborted");
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (!logExecutionException(cause)) {
                    Logger logger7 = log;
                    Level level = Level.WARNING;
                    logger7.log(level, "HTTP request failed: " + streamRequestMessage, Exceptions.unwrap(cause));
                }
                onFinally(createRequest);
                return null;
            }
        } catch (Throwable th) {
            onFinally(createRequest);
            throw th;
        }
    }
}
