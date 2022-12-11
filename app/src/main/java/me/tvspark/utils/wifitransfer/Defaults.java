package me.tvspark.utils.wifitransfer;

import java.util.HashMap;
import org.eclipse.jetty.http.MimeTypes;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;
import org.simpleframework.xml.stream.DocumentReader;

/* loaded from: classes4.dex */
public class Defaults {
    static {
        new HashMap<String, String>() { // from class: me.tvspark.utils.wifitransfer.Defaults.1
            {
                put("htm", "text/html");
                put("html", "text/html");
                put(DocumentReader.RESERVED, MimeTypes.TEXT_XML);
                put("txt", "text/plain");
                put("json", "text/plain");
                put("css", "text/css");
                put("ico", "image/x-icon");
                put("png", DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG);
                put("gif", "image/gif");
                put("jpg", "image/jpg");
                put("jpeg", DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG);
                put("zip", "application/zip");
                put("rar", "application/rar");
                put("js", "text/javascript");
            }
        };
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 8590;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 8598;
    }
}
