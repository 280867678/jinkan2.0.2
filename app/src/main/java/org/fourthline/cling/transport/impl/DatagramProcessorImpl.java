package org.fourthline.cling.transport.impl;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpVersions;
import org.fourthline.cling.model.UnsupportedDataException;
import org.fourthline.cling.model.message.IncomingDatagramMessage;
import org.fourthline.cling.model.message.OutgoingDatagramMessage;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.message.UpnpRequest;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.transport.spi.DatagramProcessor;
import org.seamless.http.Headers;

/* loaded from: classes5.dex */
public class DatagramProcessorImpl implements DatagramProcessor {
    public static Logger log = Logger.getLogger(DatagramProcessor.class.getName());

    @Override // org.fourthline.cling.transport.spi.DatagramProcessor
    public IncomingDatagramMessage read(InetAddress inetAddress, DatagramPacket datagramPacket) throws UnsupportedDataException {
        try {
            if (log.isLoggable(Level.FINER)) {
                log.finer("===================================== DATAGRAM BEGIN ============================================");
                log.finer(new String(datagramPacket.getData(), "UTF-8"));
                log.finer("-===================================== DATAGRAM END =============================================");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData());
            String[] split = Headers.readLine(byteArrayInputStream).split(StringUtils.SPACE);
            return split[0].startsWith("HTTP/1.") ? readResponseMessage(inetAddress, datagramPacket, byteArrayInputStream, Integer.valueOf(split[1]).intValue(), split[2], split[0]) : readRequestMessage(inetAddress, datagramPacket, byteArrayInputStream, split[0], split[2]);
        } catch (Exception e) {
            throw new UnsupportedDataException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse headers: ", e), e, datagramPacket.getData());
        }
    }

    public IncomingDatagramMessage readRequestMessage(InetAddress inetAddress, DatagramPacket datagramPacket, ByteArrayInputStream byteArrayInputStream, String str, String str2) throws Exception {
        UpnpHeaders upnpHeaders = new UpnpHeaders(byteArrayInputStream);
        UpnpRequest upnpRequest = new UpnpRequest(UpnpRequest.Method.getByHttpName(str));
        upnpRequest.setHttpMinorVersion(str2.toUpperCase(Locale.ROOT).equals(HttpVersions.HTTP_1_1) ? 1 : 0);
        IncomingDatagramMessage incomingDatagramMessage = new IncomingDatagramMessage(upnpRequest, datagramPacket.getAddress(), datagramPacket.getPort(), inetAddress);
        incomingDatagramMessage.setHeaders(upnpHeaders);
        return incomingDatagramMessage;
    }

    public IncomingDatagramMessage readResponseMessage(InetAddress inetAddress, DatagramPacket datagramPacket, ByteArrayInputStream byteArrayInputStream, int i, String str, String str2) throws Exception {
        UpnpHeaders upnpHeaders = new UpnpHeaders(byteArrayInputStream);
        UpnpResponse upnpResponse = new UpnpResponse(i, str);
        upnpResponse.setHttpMinorVersion(str2.toUpperCase(Locale.ROOT).equals(HttpVersions.HTTP_1_1) ? 1 : 0);
        IncomingDatagramMessage incomingDatagramMessage = new IncomingDatagramMessage(upnpResponse, datagramPacket.getAddress(), datagramPacket.getPort(), inetAddress);
        incomingDatagramMessage.setHeaders(upnpHeaders);
        return incomingDatagramMessage;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.fourthline.cling.model.message.UpnpOperation] */
    @Override // org.fourthline.cling.transport.spi.DatagramProcessor
    public DatagramPacket write(OutgoingDatagramMessage outgoingDatagramMessage) throws UnsupportedDataException {
        StringBuilder sb = new StringBuilder();
        ?? operation = outgoingDatagramMessage.getOperation();
        if (operation instanceof UpnpRequest) {
            sb.append(((UpnpRequest) operation).getHttpMethodName());
            sb.append(" * ");
            sb.append("HTTP/1.");
            sb.append(operation.getHttpMinorVersion());
        } else if (!(operation instanceof UpnpResponse)) {
            throw new UnsupportedDataException("Message operation is not request or response, don't know how to process: " + outgoingDatagramMessage);
        } else {
            UpnpResponse upnpResponse = (UpnpResponse) operation;
            sb.append("HTTP/1.");
            sb.append(operation.getHttpMinorVersion());
            sb.append(StringUtils.SPACE);
            sb.append(upnpResponse.getStatusCode());
            sb.append(StringUtils.SPACE);
            sb.append(upnpResponse.getStatusMessage());
        }
        sb.append("\r\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) sb);
        sb2.append(outgoingDatagramMessage.getHeaders().toString());
        sb2.append("\r\n");
        if (log.isLoggable(Level.FINER)) {
            Logger logger = log;
            logger.finer("Writing message data for: " + outgoingDatagramMessage);
            log.finer("---------------------------------------------------------------------------------");
            log.finer(sb2.toString().substring(0, sb2.length() + (-2)));
            log.finer("---------------------------------------------------------------------------------");
        }
        try {
            byte[] bytes = sb2.toString().getBytes("US-ASCII");
            Logger logger2 = log;
            logger2.fine("Writing new datagram packet with " + bytes.length + " bytes for: " + outgoingDatagramMessage);
            return new DatagramPacket(bytes, bytes.length, outgoingDatagramMessage.getDestinationAddress(), outgoingDatagramMessage.getDestinationPort());
        } catch (UnsupportedEncodingException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't convert message content to US-ASCII: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new UnsupportedDataException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e, sb2);
        }
    }
}
