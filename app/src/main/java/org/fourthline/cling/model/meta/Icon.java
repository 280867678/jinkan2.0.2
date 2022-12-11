package org.fourthline.cling.model.meta;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.Validatable;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.types.BinHexDatatype;
import org.seamless.util.MimeType;
import org.seamless.util.URIUtil;
import org.seamless.util.p061io.C3387IO;

/* loaded from: classes5.dex */
public class Icon implements Validatable {
    public static final Logger log = Logger.getLogger(StateVariable.class.getName());
    public final byte[] data;
    public final int depth;
    public Device device;
    public final int height;
    public final MimeType mimeType;
    public final URI uri;
    public final int width;

    public Icon(String str, int i, int i2, int i3, File file) throws IOException {
        this(str, i, i2, i3, file.getName(), C3387IO.readBytes(file));
    }

    public Icon(String str, int i, int i2, int i3, String str2, InputStream inputStream) throws IOException {
        this(str, i, i2, i3, str2, C3387IO.readBytes(inputStream));
    }

    public Icon(String str, int i, int i2, int i3, String str2, String str3) {
        this(str, i, i2, i3, str2, (str3 == null || str3.equals("")) ? null : new BinHexDatatype().mo5215valueOf(str3));
    }

    public Icon(String str, int i, int i2, int i3, String str2, byte[] bArr) {
        this((str == null || str.length() <= 0) ? null : MimeType.valueOf(str), i, i2, i3, URI.create(str2), bArr);
    }

    public Icon(String str, int i, int i2, int i3, URI uri) {
        this((str == null || str.length() <= 0) ? null : MimeType.valueOf(str), i, i2, i3, uri, (byte[]) null);
    }

    public Icon(String str, int i, int i2, int i3, URL url) throws IOException {
        this(str, i, i2, i3, new File(URIUtil.toURI(url)));
    }

    public Icon(MimeType mimeType, int i, int i2, int i3, URI uri, byte[] bArr) {
        this.mimeType = mimeType;
        this.width = i;
        this.height = i2;
        this.depth = i3;
        this.uri = uri;
        this.data = bArr;
    }

    public Icon deepCopy() {
        return new Icon(getMimeType(), getWidth(), getHeight(), getDepth(), getUri(), getData());
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDepth() {
        return this.depth;
    }

    public Device getDevice() {
        return this.device;
    }

    public int getHeight() {
        return this.height;
    }

    public MimeType getMimeType() {
        return this.mimeType;
    }

    public URI getUri() {
        return this.uri;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDevice(Device device) {
        if (this.device == null) {
            this.device = device;
            return;
        }
        throw new IllegalStateException("Final value has been set already, model is immutable");
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Icon(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getWidth());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("x");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getHeight());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", MIME: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getMimeType());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getUri());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getMimeType() == null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDevice());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            Logger logger2 = log;
            logger2.warning("Invalid icon, missing mime type: " + this);
        }
        if (getWidth() == 0) {
            Logger logger3 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getDevice());
            logger3.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            Logger logger4 = log;
            logger4.warning("Invalid icon, missing width: " + this);
        }
        if (getHeight() == 0) {
            Logger logger5 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getDevice());
            logger5.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            Logger logger6 = log;
            logger6.warning("Invalid icon, missing height: " + this);
        }
        if (getDepth() == 0) {
            Logger logger7 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getDevice());
            logger7.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            Logger logger8 = log;
            logger8.warning("Invalid icon, missing bitmap depth: " + this);
        }
        if (getUri() == null) {
            arrayList.add(new ValidationError(Icon.class, "uri", "URL is required"));
        } else {
            try {
                if (getUri().toURL() == null) {
                    throw new MalformedURLException();
                }
            } catch (IllegalArgumentException unused) {
            } catch (MalformedURLException e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("URL must be valid: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(e.getMessage());
                arrayList.add(new ValidationError(Icon.class, "uri", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString()));
            }
        }
        return arrayList;
    }
}
