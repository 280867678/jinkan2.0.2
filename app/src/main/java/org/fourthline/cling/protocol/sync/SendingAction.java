package org.fourthline.cling.protocol.sync;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.UnsupportedDataException;
import org.fourthline.cling.model.action.ActionCancelledException;
import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.control.IncomingActionResponseMessage;
import org.fourthline.cling.model.message.control.OutgoingActionRequestMessage;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.types.ErrorCode;
import org.fourthline.cling.protocol.SendingSync;
import org.fourthline.cling.transport.RouterException;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public class SendingAction extends SendingSync<OutgoingActionRequestMessage, IncomingActionResponseMessage> {
    public static final Logger log = Logger.getLogger(SendingAction.class.getName());
    public final ActionInvocation actionInvocation;

    public SendingAction(UpnpService upnpService, ActionInvocation actionInvocation, URL url) {
        super(upnpService, new OutgoingActionRequestMessage(actionInvocation, url));
        this.actionInvocation = actionInvocation;
    }

    @Override // org.fourthline.cling.protocol.SendingSync
    public IncomingActionResponseMessage executeSync() throws RouterException {
        return invokeRemote(getInputMessage());
    }

    public void handleResponse(IncomingActionResponseMessage incomingActionResponseMessage) throws ActionException {
        try {
            Logger logger = log;
            logger.fine("Received response for outgoing call, reading SOAP response body: " + incomingActionResponseMessage);
            getUpnpService().getConfiguration().getSoapActionProcessor().readBody(incomingActionResponseMessage, this.actionInvocation);
        } catch (UnsupportedDataException e) {
            Logger logger2 = log;
            logger2.fine("Error reading SOAP body: " + e);
            log.log(Level.FINE, "Exception root cause: ", Exceptions.unwrap(e));
            ErrorCode errorCode = ErrorCode.ACTION_FAILED;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error reading SOAP response message. ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), false);
        }
    }

    public void handleResponseFailure(IncomingActionResponseMessage incomingActionResponseMessage) throws ActionException {
        try {
            log.fine("Received response with Internal Server Error, reading SOAP failure message");
            getUpnpService().getConfiguration().getSoapActionProcessor().readBody(incomingActionResponseMessage, this.actionInvocation);
        } catch (UnsupportedDataException e) {
            Logger logger = log;
            logger.fine("Error reading SOAP body: " + e);
            log.log(Level.FINE, "Exception root cause: ", Exceptions.unwrap(e));
            ErrorCode errorCode = ErrorCode.ACTION_FAILED;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error reading SOAP response failure message. ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), false);
        }
    }

    public IncomingActionResponseMessage invokeRemote(OutgoingActionRequestMessage outgoingActionRequestMessage) throws RouterException {
        Device device = this.actionInvocation.getAction().getService().getDevice();
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending outgoing action call '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.actionInvocation.getAction().getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' to remote service of: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(device);
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        IncomingActionResponseMessage incomingActionResponseMessage = null;
        try {
            StreamResponseMessage sendRemoteRequest = sendRemoteRequest(outgoingActionRequestMessage);
            if (sendRemoteRequest == null) {
                log.fine("No connection or no no response received, returning null");
                this.actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, "Connection error or no response received"));
                return null;
            }
            IncomingActionResponseMessage incomingActionResponseMessage2 = new IncomingActionResponseMessage(sendRemoteRequest);
            try {
                if (!incomingActionResponseMessage2.isFailedNonRecoverable()) {
                    if (incomingActionResponseMessage2.isFailedRecoverable()) {
                        handleResponseFailure(incomingActionResponseMessage2);
                    } else {
                        handleResponse(incomingActionResponseMessage2);
                    }
                    return incomingActionResponseMessage2;
                }
                Logger logger2 = log;
                logger2.fine("Response was a non-recoverable failure: " + incomingActionResponseMessage2);
                ErrorCode errorCode = ErrorCode.ACTION_FAILED;
                throw new ActionException(errorCode, "Non-recoverable remote execution failure: " + incomingActionResponseMessage2.getOperation().getResponseDetails());
            } catch (ActionException e) {
                e = e;
                incomingActionResponseMessage = incomingActionResponseMessage2;
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Remote action invocation failed, returning Internal Server Error message: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e.getMessage());
                logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                this.actionInvocation.setFailure(e);
                return (incomingActionResponseMessage == null || !incomingActionResponseMessage.getOperation().isFailed()) ? new IncomingActionResponseMessage(new UpnpResponse(UpnpResponse.Status.INTERNAL_SERVER_ERROR)) : incomingActionResponseMessage;
            }
        } catch (ActionException e2) {
            e = e2;
        }
    }

    public StreamResponseMessage sendRemoteRequest(OutgoingActionRequestMessage outgoingActionRequestMessage) throws ActionException, RouterException {
        try {
            Logger logger = log;
            logger.fine("Writing SOAP request body of: " + outgoingActionRequestMessage);
            getUpnpService().getConfiguration().getSoapActionProcessor().writeBody(outgoingActionRequestMessage, this.actionInvocation);
            log.fine("Sending SOAP body of message as stream to remote device");
            return getUpnpService().mo5192getRouter().send(outgoingActionRequestMessage);
        } catch (UnsupportedDataException e) {
            if (log.isLoggable(Level.FINE)) {
                Logger logger2 = log;
                logger2.fine("Error writing SOAP body: " + e);
                log.log(Level.FINE, "Exception root cause: ", Exceptions.unwrap(e));
            }
            ErrorCode errorCode = ErrorCode.ACTION_FAILED;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error writing request message. ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } catch (RouterException e2) {
            Throwable unwrap = Exceptions.unwrap(e2);
            if (!(unwrap instanceof InterruptedException)) {
                throw e2;
            }
            if (log.isLoggable(Level.FINE)) {
                Logger logger3 = log;
                logger3.fine("Sending action request message was interrupted: " + unwrap);
            }
            throw new ActionCancelledException((InterruptedException) unwrap);
        }
    }
}
