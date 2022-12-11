package org.fourthline.cling.transport.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.logging.Logger;
import me.tvspark.outline;
import sun.net.www.protocol.http.Handler;
import sun.net.www.protocol.http.HttpURLConnection;

/* loaded from: classes5.dex */
public class FixedSunURLStreamHandler implements URLStreamHandlerFactory {
    public static final Logger log = Logger.getLogger(FixedSunURLStreamHandler.class.getName());

    /* loaded from: classes5.dex */
    public static class UpnpURLConnection extends HttpURLConnection {
        public static final String[] methods = {"GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "SUBSCRIBE", "UNSUBSCRIBE", "NOTIFY"};

        public UpnpURLConnection(URL url, String str, int i) throws IOException {
            super(url, str, i);
        }

        public UpnpURLConnection(URL url, Handler handler) throws IOException {
            super(url, handler);
        }

        public synchronized OutputStream getOutputStream() throws IOException {
            String str;
            OutputStream outputStream;
            String str2 = this.method;
            if (!this.method.equals("PUT") && !this.method.equals("POST") && !this.method.equals("NOTIFY")) {
                str = "GET";
                this.method = str;
                outputStream = super.getOutputStream();
                this.method = str2;
            }
            str = "PUT";
            this.method = str;
            outputStream = super.getOutputStream();
            this.method = str2;
            return outputStream;
        }

        public void setRequestMethod(String str) throws ProtocolException {
            if (!this.connected) {
                for (String str2 : methods) {
                    if (str2.equals(str)) {
                        this.method = str;
                        return;
                    }
                }
                throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid UPnP HTTP method: ", str));
            }
            throw new ProtocolException("Cannot reset method once connected");
        }
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        Logger logger = log;
        logger.fine("Creating new URLStreamHandler for protocol: " + str);
        if ("http".equals(str)) {
            return new Handler() { // from class: org.fourthline.cling.transport.impl.FixedSunURLStreamHandler.1
                public URLConnection openConnection(URL url) throws IOException {
                    return openConnection(url, null);
                }

                public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
                    return new UpnpURLConnection(url, this);
                }
            };
        }
        return null;
    }
}
