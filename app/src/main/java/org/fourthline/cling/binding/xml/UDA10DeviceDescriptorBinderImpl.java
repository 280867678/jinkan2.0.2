package org.fourthline.cling.binding.xml;

import com.just.agentweb.DefaultWebClient;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.binding.staging.MutableDevice;
import org.fourthline.cling.binding.staging.MutableIcon;
import org.fourthline.cling.binding.staging.MutableService;
import org.fourthline.cling.binding.xml.Descriptor;
import org.fourthline.cling.model.Namespace;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.XMLUtil;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.model.meta.Icon;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.model.meta.RemoteService;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.profile.RemoteClientInfo;
import org.fourthline.cling.model.types.DLNACaps;
import org.fourthline.cling.model.types.DLNADoc;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.model.types.ServiceId;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.model.types.UDN;
import org.seamless.util.Exceptions;
import org.seamless.util.MimeType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class UDA10DeviceDescriptorBinderImpl implements DeviceDescriptorBinder, ErrorHandler {
    public static Logger log = Logger.getLogger(DeviceDescriptorBinder.class.getName());

    public static URI parseURI(String str) {
        if (str.startsWith("www.")) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME, str);
        }
        if (str.contains(StringUtils.SPACE)) {
            str = str.replaceAll(StringUtils.SPACE, "%20");
        }
        try {
            return URI.create(str);
        } catch (Throwable th) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Illegal URI, trying with ./ prefix: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Exceptions.unwrap(th));
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            try {
                return URI.create("./" + str);
            } catch (IllegalArgumentException e) {
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Illegal URI '", str, "', ignoring value: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Exceptions.unwrap(e));
                logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return null;
            }
        }
    }

    @Override // org.fourthline.cling.binding.xml.DeviceDescriptorBinder
    public Document buildDOM(Device device, RemoteClientInfo remoteClientInfo, Namespace namespace) throws DescriptorBindingException {
        try {
            Logger logger = log;
            logger.fine("Generating DOM from device model: " + device);
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            Document newDocument = newInstance.newDocumentBuilder().newDocument();
            generateRoot(namespace, device, newDocument, remoteClientInfo);
            return newDocument;
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not generate device descriptor: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public <D extends Device> D buildInstance(D d, MutableDevice mutableDevice) throws ValidationException {
        return (D) mutableDevice.build(d);
    }

    @Override // org.fourthline.cling.binding.xml.DeviceDescriptorBinder
    public <D extends Device> D describe(D d, String str) throws DescriptorBindingException, ValidationException {
        if (str == null || str.length() == 0) {
            throw new DescriptorBindingException("Null or empty descriptor");
        }
        try {
            Logger logger = log;
            logger.fine("Populating device from XML descriptor: " + d);
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler(this);
            return (D) describe((UDA10DeviceDescriptorBinderImpl) d, newDocumentBuilder.parse(new InputSource(new StringReader(str.trim()))));
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse device descriptor: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.toString());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e2);
        }
    }

    @Override // org.fourthline.cling.binding.xml.DeviceDescriptorBinder
    public <D extends Device> D describe(D d, Document document) throws DescriptorBindingException, ValidationException {
        try {
            Logger logger = log;
            logger.fine("Populating device from DOM: " + d);
            MutableDevice mutableDevice = new MutableDevice();
            hydrateRoot(mutableDevice, document.getDocumentElement());
            return (D) buildInstance(d, mutableDevice);
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse device DOM: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.toString());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e2);
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.fourthline.cling.binding.xml.DeviceDescriptorBinder
    public String generate(Device device, RemoteClientInfo remoteClientInfo, Namespace namespace) throws DescriptorBindingException {
        try {
            Logger logger = log;
            logger.fine("Generating XML descriptor from device model: " + device);
            return XMLUtil.documentToString(buildDOM(device, remoteClientInfo, namespace));
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not build DOM: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public void generateDevice(Namespace namespace, Device device, Document document, Element element, RemoteClientInfo remoteClientInfo) {
        DLNADoc[] dlnaDocs;
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.device);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.deviceType, device.getType());
        DeviceDetails details = device.getDetails(remoteClientInfo);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.friendlyName, details.getFriendlyName());
        if (details.getManufacturerDetails() != null) {
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.manufacturer, details.getManufacturerDetails().getManufacturer());
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.manufacturerURL, details.getManufacturerDetails().getManufacturerURI());
        }
        if (details.getModelDetails() != null) {
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.modelDescription, details.getModelDetails().getModelDescription());
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.modelName, details.getModelDetails().getModelName());
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.modelNumber, details.getModelDetails().getModelNumber());
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.modelURL, details.getModelDetails().getModelURI());
        }
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.serialNumber, details.getSerialNumber());
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.UDN, device.getIdentity().getUdn());
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.presentationURL, details.getPresentationURI());
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.UPC, details.getUpc());
        if (details.getDlnaDocs() != null) {
            for (DLNADoc dLNADoc : details.getDlnaDocs()) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dlna:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Descriptor.Device.ELEMENT.X_DLNADOC);
                XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), dLNADoc, Descriptor.Device.DLNA_NAMESPACE_URI);
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dlna:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Descriptor.Device.ELEMENT.X_DLNACAP);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), details.getDlnaCaps(), Descriptor.Device.DLNA_NAMESPACE_URI);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "sec:" + Descriptor.Device.ELEMENT.ProductCap, details.getSecProductCaps(), Descriptor.Device.SEC_NAMESPACE_URI);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "sec:" + Descriptor.Device.ELEMENT.X_ProductCap, details.getSecProductCaps(), Descriptor.Device.SEC_NAMESPACE_URI);
        generateIconList(namespace, device, document, appendNewElement);
        generateServiceList(namespace, device, document, appendNewElement);
        generateDeviceList(namespace, device, document, appendNewElement, remoteClientInfo);
    }

    public void generateDeviceList(Namespace namespace, Device device, Document document, Element element, RemoteClientInfo remoteClientInfo) {
        if (!device.hasEmbeddedDevices()) {
            return;
        }
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.deviceList);
        for (Device device2 : device.getEmbeddedDevices()) {
            generateDevice(namespace, device2, document, appendNewElement, remoteClientInfo);
        }
    }

    public void generateIconList(Namespace namespace, Device device, Document document, Element element) {
        Icon[] icons;
        Descriptor.Device.ELEMENT element2;
        URI iconPath;
        if (!device.hasIcons()) {
            return;
        }
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.iconList);
        for (Icon icon : device.getIcons()) {
            Element appendNewElement2 = XMLUtil.appendNewElement(document, appendNewElement, Descriptor.Device.ELEMENT.icon);
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.mimetype, icon.getMimeType());
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.width, Integer.valueOf(icon.getWidth()));
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.height, Integer.valueOf(icon.getHeight()));
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.depth, Integer.valueOf(icon.getDepth()));
            if (device instanceof RemoteDevice) {
                element2 = Descriptor.Device.ELEMENT.url;
                iconPath = icon.getUri();
            } else if (device instanceof LocalDevice) {
                element2 = Descriptor.Device.ELEMENT.url;
                iconPath = namespace.getIconPath(icon);
            }
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, element2, iconPath);
        }
    }

    public void generateRoot(Namespace namespace, Device device, Document document, RemoteClientInfo remoteClientInfo) {
        Descriptor.Device.ELEMENT element = Descriptor.Device.ELEMENT.root;
        Element createElementNS = document.createElementNS(Descriptor.Device.NAMESPACE_URI, "root");
        document.appendChild(createElementNS);
        generateSpecVersion(namespace, device, document, createElementNS);
        generateDevice(namespace, device, document, createElementNS, remoteClientInfo);
    }

    public void generateServiceList(Namespace namespace, Device device, Document document, Element element) {
        Service[] mo5197getServices;
        Descriptor.Device.ELEMENT element2;
        URI eventSubscriptionPath;
        if (!device.hasServices()) {
            return;
        }
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.serviceList);
        for (Service service : device.mo5197getServices()) {
            Element appendNewElement2 = XMLUtil.appendNewElement(document, appendNewElement, Descriptor.Device.ELEMENT.service);
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.serviceType, service.getServiceType());
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.serviceId, service.getServiceId());
            if (service instanceof RemoteService) {
                RemoteService remoteService = (RemoteService) service;
                XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.SCPDURL, remoteService.getDescriptorURI());
                XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.controlURL, remoteService.getControlURI());
                element2 = Descriptor.Device.ELEMENT.eventSubURL;
                eventSubscriptionPath = remoteService.getEventSubscriptionURI();
            } else if (service instanceof LocalService) {
                LocalService localService = (LocalService) service;
                XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.SCPDURL, namespace.getDescriptorPath(localService));
                XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Device.ELEMENT.controlURL, namespace.getControlPath(localService));
                element2 = Descriptor.Device.ELEMENT.eventSubURL;
                eventSubscriptionPath = namespace.getEventSubscriptionPath(localService);
            }
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, element2, eventSubscriptionPath);
        }
    }

    public void generateSpecVersion(Namespace namespace, Device device, Document document, Element element) {
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.specVersion);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.major, Integer.valueOf(device.getVersion().getMajor()));
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Device.ELEMENT.minor, Integer.valueOf(device.getVersion().getMinor()));
    }

    public void hydrateDevice(MutableDevice mutableDevice, Node node) throws DescriptorBindingException {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                if (Descriptor.Device.ELEMENT.deviceType.equals(item)) {
                    mutableDevice.deviceType = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.friendlyName.equals(item)) {
                    mutableDevice.friendlyName = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.manufacturer.equals(item)) {
                    mutableDevice.manufacturer = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.manufacturerURL.equals(item)) {
                    mutableDevice.manufacturerURI = parseURI(XMLUtil.getTextContent(item));
                } else if (Descriptor.Device.ELEMENT.modelDescription.equals(item)) {
                    mutableDevice.modelDescription = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.modelName.equals(item)) {
                    mutableDevice.modelName = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.modelNumber.equals(item)) {
                    mutableDevice.modelNumber = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.modelURL.equals(item)) {
                    mutableDevice.modelURI = parseURI(XMLUtil.getTextContent(item));
                } else if (Descriptor.Device.ELEMENT.presentationURL.equals(item)) {
                    mutableDevice.presentationURI = parseURI(XMLUtil.getTextContent(item));
                } else if (Descriptor.Device.ELEMENT.UPC.equals(item)) {
                    mutableDevice.upc = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.serialNumber.equals(item)) {
                    mutableDevice.serialNumber = XMLUtil.getTextContent(item);
                } else if (Descriptor.Device.ELEMENT.UDN.equals(item)) {
                    mutableDevice.udn = UDN.valueOf(XMLUtil.getTextContent(item));
                } else if (Descriptor.Device.ELEMENT.iconList.equals(item)) {
                    hydrateIconList(mutableDevice, item);
                } else if (Descriptor.Device.ELEMENT.serviceList.equals(item)) {
                    hydrateServiceList(mutableDevice, item);
                } else if (Descriptor.Device.ELEMENT.deviceList.equals(item)) {
                    hydrateDeviceList(mutableDevice, item);
                } else if (Descriptor.Device.ELEMENT.X_DLNADOC.equals(item) && Descriptor.Device.DLNA_PREFIX.equals(item.getPrefix())) {
                    String textContent = XMLUtil.getTextContent(item);
                    try {
                        mutableDevice.dlnaDocs.add(DLNADoc.valueOf(textContent));
                    } catch (InvalidValueException unused) {
                        Logger logger = log;
                        logger.info("Invalid X_DLNADOC value, ignoring value: " + textContent);
                    }
                } else if (Descriptor.Device.ELEMENT.X_DLNACAP.equals(item) && Descriptor.Device.DLNA_PREFIX.equals(item.getPrefix())) {
                    mutableDevice.dlnaCaps = DLNACaps.valueOf(XMLUtil.getTextContent(item));
                }
            }
        }
    }

    public void hydrateDeviceList(MutableDevice mutableDevice, Node node) throws DescriptorBindingException {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && Descriptor.Device.ELEMENT.device.equals(item)) {
                MutableDevice mutableDevice2 = new MutableDevice();
                mutableDevice2.parentDevice = mutableDevice;
                mutableDevice.embeddedDevices.add(mutableDevice2);
                hydrateDevice(mutableDevice2, item);
            }
        }
    }

    public void hydrateIconList(MutableDevice mutableDevice, Node node) throws DescriptorBindingException {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && Descriptor.Device.ELEMENT.icon.equals(item)) {
                MutableIcon mutableIcon = new MutableIcon();
                NodeList childNodes2 = item.getChildNodes();
                for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                    Node item2 = childNodes2.item(i2);
                    if (item2.getNodeType() == 1) {
                        if (Descriptor.Device.ELEMENT.width.equals(item2)) {
                            mutableIcon.width = Integer.valueOf(XMLUtil.getTextContent(item2)).intValue();
                        } else if (Descriptor.Device.ELEMENT.height.equals(item2)) {
                            mutableIcon.height = Integer.valueOf(XMLUtil.getTextContent(item2)).intValue();
                        } else if (Descriptor.Device.ELEMENT.depth.equals(item2)) {
                            String textContent = XMLUtil.getTextContent(item2);
                            try {
                                mutableIcon.depth = Integer.valueOf(textContent).intValue();
                            } catch (NumberFormatException e) {
                                Logger logger = log;
                                logger.warning("Invalid icon depth '" + textContent + "', using 16 as default: " + e);
                                mutableIcon.depth = 16;
                            }
                        } else if (Descriptor.Device.ELEMENT.url.equals(item2)) {
                            mutableIcon.uri = parseURI(XMLUtil.getTextContent(item2));
                        } else if (Descriptor.Device.ELEMENT.mimetype.equals(item2)) {
                            try {
                                String textContent2 = XMLUtil.getTextContent(item2);
                                mutableIcon.mimeType = textContent2;
                                MimeType.valueOf(textContent2);
                            } catch (IllegalArgumentException unused) {
                                Logger logger2 = log;
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring invalid icon mime type: ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(mutableIcon.mimeType);
                                logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                                mutableIcon.mimeType = "";
                            }
                        }
                    }
                }
                mutableDevice.icons.add(mutableIcon);
            }
        }
    }

    public void hydrateRoot(MutableDevice mutableDevice, Element element) throws DescriptorBindingException {
        if (element.getNamespaceURI() == null || !element.getNamespaceURI().equals(Descriptor.Device.NAMESPACE_URI)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Wrong XML namespace declared on root element: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(element.getNamespaceURI());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        String nodeName = element.getNodeName();
        Descriptor.Device.ELEMENT element2 = Descriptor.Device.ELEMENT.root;
        if (!nodeName.equals("root")) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Root element name is not <root>: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(element.getNodeName());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        NodeList childNodes = element.getChildNodes();
        Node node = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                if (Descriptor.Device.ELEMENT.specVersion.equals(item)) {
                    hydrateSpecVersion(mutableDevice, item);
                } else if (Descriptor.Device.ELEMENT.URLBase.equals(item)) {
                    try {
                        String textContent = XMLUtil.getTextContent(item);
                        if (textContent != null && textContent.length() > 0) {
                            mutableDevice.baseURL = new URL(textContent);
                        }
                    } catch (Exception e) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid URLBase: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(e.getMessage());
                        throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    }
                } else if (!Descriptor.Device.ELEMENT.device.equals(item)) {
                    Logger logger2 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring unknown element: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(item.getNodeName());
                    logger2.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                } else if (node != null) {
                    throw new DescriptorBindingException("Found multiple <device> elements in <root>");
                } else {
                    node = item;
                }
            }
        }
        if (node == null) {
            throw new DescriptorBindingException("No <device> element in <root>");
        }
        hydrateDevice(mutableDevice, node);
    }

    public void hydrateServiceList(MutableDevice mutableDevice, Node node) throws DescriptorBindingException {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && Descriptor.Device.ELEMENT.service.equals(item)) {
                NodeList childNodes2 = item.getChildNodes();
                try {
                    MutableService mutableService = new MutableService();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node item2 = childNodes2.item(i2);
                        if (item2.getNodeType() == 1) {
                            if (Descriptor.Device.ELEMENT.serviceType.equals(item2)) {
                                mutableService.serviceType = ServiceType.valueOf(XMLUtil.getTextContent(item2));
                            } else if (Descriptor.Device.ELEMENT.serviceId.equals(item2)) {
                                mutableService.serviceId = ServiceId.valueOf(XMLUtil.getTextContent(item2));
                            } else if (Descriptor.Device.ELEMENT.SCPDURL.equals(item2)) {
                                mutableService.descriptorURI = parseURI(XMLUtil.getTextContent(item2));
                            } else if (Descriptor.Device.ELEMENT.controlURL.equals(item2)) {
                                mutableService.controlURI = parseURI(XMLUtil.getTextContent(item2));
                            } else if (Descriptor.Device.ELEMENT.eventSubURL.equals(item2)) {
                                mutableService.eventSubscriptionURI = parseURI(XMLUtil.getTextContent(item2));
                            }
                        }
                    }
                    mutableDevice.services.add(mutableService);
                } catch (InvalidValueException e) {
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation, skipping invalid service declaration. ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                    logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            }
        }
    }

    public void hydrateSpecVersion(MutableDevice mutableDevice, Node node) throws DescriptorBindingException {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                if (Descriptor.Device.ELEMENT.major.equals(item)) {
                    String trim = XMLUtil.getTextContent(item).trim();
                    if (!trim.equals("1")) {
                        Logger logger = log;
                        logger.warning("Unsupported UDA major version, ignoring: " + trim);
                        trim = "1";
                    }
                    mutableDevice.udaVersion.major = Integer.valueOf(trim).intValue();
                } else if (Descriptor.Device.ELEMENT.minor.equals(item)) {
                    String trim2 = XMLUtil.getTextContent(item).trim();
                    if (!trim2.equals("0")) {
                        Logger logger2 = log;
                        logger2.warning("Unsupported UDA minor version, ignoring: " + trim2);
                        trim2 = "0";
                    }
                    mutableDevice.udaVersion.minor = Integer.valueOf(trim2).intValue();
                }
            }
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
        log.warning(sAXParseException.toString());
    }
}
