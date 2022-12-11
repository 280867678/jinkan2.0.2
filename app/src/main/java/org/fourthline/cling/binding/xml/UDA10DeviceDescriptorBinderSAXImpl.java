package org.fourthline.cling.binding.xml;

import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.binding.staging.MutableDevice;
import org.fourthline.cling.binding.staging.MutableIcon;
import org.fourthline.cling.binding.staging.MutableService;
import org.fourthline.cling.binding.staging.MutableUDAVersion;
import org.fourthline.cling.binding.xml.Descriptor;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.types.DLNACaps;
import org.fourthline.cling.model.types.DLNADoc;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.model.types.ServiceId;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.model.types.UDN;
import org.seamless.util.MimeType;
import org.seamless.xml.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class UDA10DeviceDescriptorBinderSAXImpl extends UDA10DeviceDescriptorBinderImpl {
    public static Logger log = Logger.getLogger(DeviceDescriptorBinder.class.getName());

    /* renamed from: org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C30381 {

        /* renamed from: $SwitchMap$org$fourthline$cling$binding$xml$Descriptor$Device$ELEMENT */
        public static final /* synthetic */ int[] f4600xcea4acb6;

        static {
            int[] iArr = new int[Descriptor.Device.ELEMENT.values().length];
            f4600xcea4acb6 = iArr;
            try {
                Descriptor.Device.ELEMENT element = Descriptor.Device.ELEMENT.URLBase;
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element2 = Descriptor.Device.ELEMENT.major;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element3 = Descriptor.Device.ELEMENT.minor;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element4 = Descriptor.Device.ELEMENT.deviceType;
                iArr4[11] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element5 = Descriptor.Device.ELEMENT.friendlyName;
                iArr5[12] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element6 = Descriptor.Device.ELEMENT.manufacturer;
                iArr6[13] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element7 = Descriptor.Device.ELEMENT.manufacturerURL;
                iArr7[14] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element8 = Descriptor.Device.ELEMENT.modelDescription;
                iArr8[15] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element9 = Descriptor.Device.ELEMENT.modelName;
                iArr9[16] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element10 = Descriptor.Device.ELEMENT.modelNumber;
                iArr10[17] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element11 = Descriptor.Device.ELEMENT.modelURL;
                iArr11[18] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element12 = Descriptor.Device.ELEMENT.presentationURL;
                iArr12[19] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element13 = Descriptor.Device.ELEMENT.UPC;
                iArr13[20] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element14 = Descriptor.Device.ELEMENT.serialNumber;
                iArr14[21] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                int[] iArr15 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element15 = Descriptor.Device.ELEMENT.UDN;
                iArr15[6] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                int[] iArr16 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element16 = Descriptor.Device.ELEMENT.X_DLNADOC;
                iArr16[7] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                int[] iArr17 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element17 = Descriptor.Device.ELEMENT.X_DLNACAP;
                iArr17[8] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                int[] iArr18 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element18 = Descriptor.Device.ELEMENT.width;
                iArr18[24] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                int[] iArr19 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element19 = Descriptor.Device.ELEMENT.height;
                iArr19[25] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                int[] iArr20 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element20 = Descriptor.Device.ELEMENT.depth;
                iArr20[26] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                int[] iArr21 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element21 = Descriptor.Device.ELEMENT.url;
                iArr21[27] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                int[] iArr22 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element22 = Descriptor.Device.ELEMENT.mimetype;
                iArr22[28] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                int[] iArr23 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element23 = Descriptor.Device.ELEMENT.serviceType;
                iArr23[31] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                int[] iArr24 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element24 = Descriptor.Device.ELEMENT.serviceId;
                iArr24[32] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                int[] iArr25 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element25 = Descriptor.Device.ELEMENT.SCPDURL;
                iArr25[33] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                int[] iArr26 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element26 = Descriptor.Device.ELEMENT.controlURL;
                iArr26[34] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                int[] iArr27 = f4600xcea4acb6;
                Descriptor.Device.ELEMENT element27 = Descriptor.Device.ELEMENT.eventSubURL;
                iArr27[35] = 27;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class DeviceDescriptorHandler<I> extends SAXParser.Handler<I> {
        public DeviceDescriptorHandler(I i) {
            super(i);
        }

        public DeviceDescriptorHandler(I i, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(i, deviceDescriptorHandler);
        }

        public DeviceDescriptorHandler(I i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        public DeviceDescriptorHandler(I i, SAXParser sAXParser, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(i, sAXParser, deviceDescriptorHandler);
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            super.endElement(str, str2, str3);
            Descriptor.Device.ELEMENT valueOrNullOf = Descriptor.Device.ELEMENT.valueOrNullOf(str2);
            if (valueOrNullOf == null) {
                return;
            }
            endElement(valueOrNullOf);
        }

        public void endElement(Descriptor.Device.ELEMENT element) throws SAXException {
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            Descriptor.Device.ELEMENT valueOrNullOf = Descriptor.Device.ELEMENT.valueOrNullOf(str2);
            return valueOrNullOf != null && isLastElement(valueOrNullOf);
        }

        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return false;
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            super.startElement(str, str2, str3, attributes);
            Descriptor.Device.ELEMENT valueOrNullOf = Descriptor.Device.ELEMENT.valueOrNullOf(str2);
            if (valueOrNullOf == null) {
                return;
            }
            startElement(valueOrNullOf, attributes);
        }

        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) throws SAXException {
        }
    }

    /* loaded from: classes5.dex */
    public static class DeviceHandler extends DeviceDescriptorHandler<MutableDevice> {

        /* renamed from: EL */
        public static final Descriptor.Device.ELEMENT f4601EL = Descriptor.Device.ELEMENT.device;

        public DeviceHandler(MutableDevice mutableDevice, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableDevice, deviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) throws SAXException {
            switch (element.ordinal()) {
                case 6:
                    getInstance().udn = UDN.valueOf(getCharacters());
                    return;
                case 7:
                    String characters = getCharacters();
                    try {
                        getInstance().dlnaDocs.add(DLNADoc.valueOf(characters));
                        return;
                    } catch (InvalidValueException unused) {
                        Logger logger = UDA10DeviceDescriptorBinderSAXImpl.log;
                        logger.info("Invalid X_DLNADOC value, ignoring value: " + characters);
                        return;
                    }
                case 8:
                    getInstance().dlnaCaps = DLNACaps.valueOf(getCharacters());
                    return;
                case 9:
                case 10:
                default:
                    return;
                case 11:
                    getInstance().deviceType = getCharacters();
                    return;
                case 12:
                    getInstance().friendlyName = getCharacters();
                    return;
                case 13:
                    getInstance().manufacturer = getCharacters();
                    return;
                case 14:
                    getInstance().manufacturerURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    return;
                case 15:
                    getInstance().modelDescription = getCharacters();
                    return;
                case 16:
                    getInstance().modelName = getCharacters();
                    return;
                case 17:
                    getInstance().modelNumber = getCharacters();
                    return;
                case 18:
                    getInstance().modelURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    return;
                case 19:
                    getInstance().presentationURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    return;
                case 20:
                    getInstance().upc = getCharacters();
                    return;
                case 21:
                    getInstance().serialNumber = getCharacters();
                    return;
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(f4601EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(IconListHandler.f4604EL)) {
                ArrayList arrayList = new ArrayList();
                getInstance().icons = arrayList;
                new IconListHandler(arrayList, this);
            }
            if (element.equals(ServiceListHandler.f4606EL)) {
                ArrayList arrayList2 = new ArrayList();
                getInstance().services = arrayList2;
                new ServiceListHandler(arrayList2, this);
            }
            if (element.equals(DeviceListHandler.f4602EL)) {
                ArrayList arrayList3 = new ArrayList();
                getInstance().embeddedDevices = arrayList3;
                new DeviceListHandler(arrayList3, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class DeviceListHandler extends DeviceDescriptorHandler<List<MutableDevice>> {

        /* renamed from: EL */
        public static final Descriptor.Device.ELEMENT f4602EL = Descriptor.Device.ELEMENT.deviceList;

        public DeviceListHandler(List<MutableDevice> list, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(list, deviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(f4602EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(DeviceHandler.f4601EL)) {
                MutableDevice mutableDevice = new MutableDevice();
                getInstance().add(mutableDevice);
                new DeviceHandler(mutableDevice, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class IconHandler extends DeviceDescriptorHandler<MutableIcon> {

        /* renamed from: EL */
        public static final Descriptor.Device.ELEMENT f4603EL = Descriptor.Device.ELEMENT.icon;

        public IconHandler(MutableIcon mutableIcon, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableIcon, deviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) throws SAXException {
            switch (element.ordinal()) {
                case 24:
                    getInstance().width = Integer.valueOf(getCharacters()).intValue();
                    return;
                case 25:
                    getInstance().height = Integer.valueOf(getCharacters()).intValue();
                    return;
                case 26:
                    try {
                        getInstance().depth = Integer.valueOf(getCharacters()).intValue();
                        return;
                    } catch (NumberFormatException e) {
                        Logger logger = UDA10DeviceDescriptorBinderSAXImpl.log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid icon depth '");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getCharacters());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("', using 16 as default: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e);
                        logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        getInstance().depth = 16;
                        return;
                    }
                case 27:
                    getInstance().uri = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    return;
                case 28:
                    try {
                        getInstance().mimeType = getCharacters();
                        MimeType.valueOf(getInstance().mimeType);
                        return;
                    } catch (IllegalArgumentException unused) {
                        Logger logger2 = UDA10DeviceDescriptorBinderSAXImpl.log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring invalid icon mime type: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getInstance().mimeType);
                        logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        getInstance().mimeType = "";
                        return;
                    }
                default:
                    return;
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(f4603EL);
        }
    }

    /* loaded from: classes5.dex */
    public static class IconListHandler extends DeviceDescriptorHandler<List<MutableIcon>> {

        /* renamed from: EL */
        public static final Descriptor.Device.ELEMENT f4604EL = Descriptor.Device.ELEMENT.iconList;

        public IconListHandler(List<MutableIcon> list, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(list, deviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(f4604EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(IconHandler.f4603EL)) {
                MutableIcon mutableIcon = new MutableIcon();
                getInstance().add(mutableIcon);
                new IconHandler(mutableIcon, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class RootHandler extends DeviceDescriptorHandler<MutableDevice> {
        public RootHandler(MutableDevice mutableDevice, SAXParser sAXParser) {
            super(mutableDevice, sAXParser);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) throws SAXException {
            if (element.ordinal() != 4) {
                return;
            }
            try {
                String characters = getCharacters();
                if (characters == null || characters.length() <= 0) {
                    return;
                }
                getInstance().baseURL = new URL(characters);
            } catch (Exception e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid URLBase: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
                throw new SAXException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(SpecVersionHandler.f4607EL)) {
                MutableUDAVersion mutableUDAVersion = new MutableUDAVersion();
                getInstance().udaVersion = mutableUDAVersion;
                new SpecVersionHandler(mutableUDAVersion, this);
            }
            if (element.equals(DeviceHandler.f4601EL)) {
                new DeviceHandler(getInstance(), this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ServiceHandler extends DeviceDescriptorHandler<MutableService> {

        /* renamed from: EL */
        public static final Descriptor.Device.ELEMENT f4605EL = Descriptor.Device.ELEMENT.service;

        public ServiceHandler(MutableService mutableService, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableService, deviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) throws SAXException {
            try {
                switch (element.ordinal()) {
                    case 31:
                        getInstance().serviceType = ServiceType.valueOf(getCharacters());
                        break;
                    case 32:
                        getInstance().serviceId = ServiceId.valueOf(getCharacters());
                        break;
                    case 33:
                        getInstance().descriptorURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                        break;
                    case 34:
                        getInstance().controlURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                        break;
                    case 35:
                        getInstance().eventSubscriptionURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                        break;
                }
            } catch (InvalidValueException e) {
                Logger logger = UDA10DeviceDescriptorBinderSAXImpl.log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation, skipping invalid service declaration. ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(f4605EL);
        }
    }

    /* loaded from: classes5.dex */
    public static class ServiceListHandler extends DeviceDescriptorHandler<List<MutableService>> {

        /* renamed from: EL */
        public static final Descriptor.Device.ELEMENT f4606EL = Descriptor.Device.ELEMENT.serviceList;

        public ServiceListHandler(List<MutableService> list, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(list, deviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            boolean equals = element.equals(f4606EL);
            if (equals) {
                Iterator<MutableService> it = getInstance().iterator();
                while (it.hasNext()) {
                    MutableService next = it.next();
                    if (next.serviceType == null || next.serviceId == null) {
                        it.remove();
                    }
                }
            }
            return equals;
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(ServiceHandler.f4605EL)) {
                MutableService mutableService = new MutableService();
                getInstance().add(mutableService);
                new ServiceHandler(mutableService, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class SpecVersionHandler extends DeviceDescriptorHandler<MutableUDAVersion> {

        /* renamed from: EL */
        public static final Descriptor.Device.ELEMENT f4607EL = Descriptor.Device.ELEMENT.specVersion;

        public SpecVersionHandler(MutableUDAVersion mutableUDAVersion, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableUDAVersion, deviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) throws SAXException {
            int ordinal = element.ordinal();
            if (ordinal == 2) {
                String trim = getCharacters().trim();
                if (!trim.equals("1")) {
                    Logger logger = UDA10DeviceDescriptorBinderSAXImpl.log;
                    logger.warning("Unsupported UDA major version, ignoring: " + trim);
                    trim = "1";
                }
                getInstance().major = Integer.valueOf(trim).intValue();
            } else if (ordinal != 3) {
            } else {
                String trim2 = getCharacters().trim();
                if (!trim2.equals("0")) {
                    Logger logger2 = UDA10DeviceDescriptorBinderSAXImpl.log;
                    logger2.warning("Unsupported UDA minor version, ignoring: " + trim2);
                    trim2 = "0";
                }
                getInstance().minor = Integer.valueOf(trim2).intValue();
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(f4607EL);
        }
    }

    @Override // org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderImpl, org.fourthline.cling.binding.xml.DeviceDescriptorBinder
    public <D extends Device> D describe(D d, String str) throws DescriptorBindingException, ValidationException {
        if (str == null || str.length() == 0) {
            throw new DescriptorBindingException("Null or empty descriptor");
        }
        try {
            Logger logger = log;
            logger.fine("Populating device from XML descriptor: " + d);
            SAXParser sAXParser = new SAXParser();
            MutableDevice mutableDevice = new MutableDevice();
            new RootHandler(mutableDevice, sAXParser);
            sAXParser.parse(new InputSource(new StringReader(str.trim())));
            return (D) mutableDevice.build(d);
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse device descriptor: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.toString());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e2);
        }
    }
}
