package org.fourthline.cling.model.message.header;

import com.just.agentweb.DefaultWebClient;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class CallbackHeader extends UpnpHeader<List<URL>> {
    public static final Logger log = Logger.getLogger(CallbackHeader.class.getName());

    public CallbackHeader() {
        setValue(new ArrayList());
    }

    public CallbackHeader(URL url) {
        this();
        getValue().add(url);
    }

    public CallbackHeader(List<URL> list) {
        this();
        getValue().addAll(list);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        StringBuilder sb = new StringBuilder();
        for (URL url : getValue()) {
            sb.append("<");
            sb.append(url.toString());
            sb.append(">");
        }
        return sb.toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.length() == 0) {
            return;
        }
        if (!str.contains("<") || !str.contains(">")) {
            throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("URLs not in brackets: ", str));
        }
        String replaceAll = str.replaceAll("<", "");
        String[] split = replaceAll.split(">");
        try {
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                String trim = str2.trim();
                if (!trim.startsWith(DefaultWebClient.HTTP_SCHEME)) {
                    log.warning("Discarding non-http callback URL: " + trim);
                } else {
                    URL url = new URL(trim);
                    try {
                        url.toURI();
                        arrayList.add(url);
                    } catch (URISyntaxException e) {
                        log.log(Level.WARNING, "Discarding callback URL, not a valid URI on this platform: " + url, (Throwable) e);
                    }
                }
            }
            setValue(arrayList);
        } catch (MalformedURLException e2) {
            throw new InvalidHeaderException("Can't parse callback URLs from '" + replaceAll + "': " + e2);
        }
    }
}
