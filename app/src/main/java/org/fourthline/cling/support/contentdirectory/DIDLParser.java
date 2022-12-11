package org.fourthline.cling.support.contentdirectory;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import com.umeng.analytics.pro.C1543ak;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import me.tvspark.outline;
import org.fourthline.cling.binding.xml.Descriptor;
import org.fourthline.cling.model.XMLUtil;
import org.fourthline.cling.model.types.Datatype;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.support.model.DIDLAttribute;
import org.fourthline.cling.support.model.DIDLContent;
import org.fourthline.cling.support.model.DIDLObject;
import org.fourthline.cling.support.model.DescMeta;
import org.fourthline.cling.support.model.Person;
import org.fourthline.cling.support.model.PersonWithRole;
import org.fourthline.cling.support.model.ProtocolInfo;
import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.StorageMedium;
import org.fourthline.cling.support.model.WriteStatus;
import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.Item;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.seamless.util.Exceptions;
import org.seamless.util.p061io.C3387IO;
import org.seamless.xml.SAXParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes5.dex */
public class DIDLParser extends SAXParser {
    public static final String UNKNOWN_TITLE = "Unknown Title";
    public static final Logger log = Logger.getLogger(DIDLParser.class.getName());

    /* loaded from: classes5.dex */
    public class ContainerHandler extends DIDLObjectHandler<Container> {
        public ContainerHandler(Container container, SAXParser.Handler handler) {
            super(container, handler);
        }

        @Override // org.fourthline.cling.support.contentdirectory.DIDLParser.DIDLObjectHandler, org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            List<DIDLObject.Class> createClasses;
            DIDLObject.Class r6;
            super.endElement(str, str2, str3);
            if (DIDLObject.Property.UPNP.NAMESPACE.URI.equals(str)) {
                if ("searchClass".equals(str2)) {
                    createClasses = ((Container) getInstance()).getSearchClasses();
                    r6 = new DIDLObject.Class(getCharacters(), getAttributes().getValue("name"), "true".equals(getAttributes().getValue("includeDerived")));
                } else if (!"createClass".equals(str2)) {
                    return;
                } else {
                    createClasses = ((Container) getInstance()).getCreateClasses();
                    r6 = new DIDLObject.Class(getCharacters(), getAttributes().getValue("name"), "true".equals(getAttributes().getValue("includeDerived")));
                }
                createClasses.add(r6);
            }
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            if (!DIDLContent.NAMESPACE_URI.equals(str) || !"container".equals(str2)) {
                return false;
            }
            if (((Container) getInstance()).getTitle() == null) {
                Logger logger = DIDLParser.log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("In DIDL content, missing 'dc:title' element for container: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(((Container) getInstance()).getId());
                logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            if (((Container) getInstance()).getClazz() != null) {
                return true;
            }
            Logger logger2 = DIDLParser.log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("In DIDL content, missing 'upnp:class' element for container: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(((Container) getInstance()).getId());
            logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return true;
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            Res createResource;
            super.startElement(str, str2, str3, attributes);
            if (!DIDLContent.NAMESPACE_URI.equals(str)) {
                return;
            }
            if (str2.equals("item")) {
                Item createItem = DIDLParser.this.createItem(attributes);
                ((Container) getInstance()).addItem(createItem);
                DIDLParser.this.createItemHandler(createItem, this);
            } else if (str2.equals("desc")) {
                DescMeta createDescMeta = DIDLParser.this.createDescMeta(attributes);
                ((Container) getInstance()).addDescMetadata(createDescMeta);
                DIDLParser.this.createDescMetaHandler(createDescMeta, this);
            } else if (!str2.equals("res") || (createResource = DIDLParser.this.createResource(attributes)) == null) {
            } else {
                ((Container) getInstance()).addResource(createResource);
                DIDLParser.this.createResHandler(createResource, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public abstract class DIDLObjectHandler<I extends DIDLObject> extends SAXParser.Handler<I> {
        public DIDLObjectHandler(I i, SAXParser.Handler handler) {
            super(i, handler);
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            DIDLObject dIDLObject;
            DIDLObject.Property user_annotation;
            super.endElement(str, str2, str3);
            if (DIDLObject.Property.C3095DC.NAMESPACE.URI.equals(str)) {
                if (NotificationCompatJellybean.KEY_TITLE.equals(str2)) {
                    ((DIDLObject) getInstance()).setTitle(getCharacters());
                    return;
                } else if ("creator".equals(str2)) {
                    ((DIDLObject) getInstance()).setCreator(getCharacters());
                    return;
                } else if ("description".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.C3095DC.DESCRIPTION(getCharacters());
                } else if ("publisher".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.C3095DC.PUBLISHER(new Person(getCharacters()));
                } else if ("contributor".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.C3095DC.CONTRIBUTOR(new Person(getCharacters()));
                } else if ("date".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.C3095DC.DATE(getCharacters());
                } else if ("language".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.C3095DC.LANGUAGE(getCharacters());
                } else if ("rights".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.C3095DC.RIGHTS(getCharacters());
                } else if (!"relation".equals(str2)) {
                    return;
                } else {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.C3095DC.RELATION(URI.create(getCharacters()));
                }
            } else if (!DIDLObject.Property.UPNP.NAMESPACE.URI.equals(str)) {
                return;
            } else {
                if ("writeStatus".equals(str2)) {
                    try {
                        ((DIDLObject) getInstance()).setWriteStatus(WriteStatus.valueOf(getCharacters()));
                        return;
                    } catch (Exception unused) {
                        Logger logger = DIDLParser.log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring invalid writeStatus value: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getCharacters());
                        logger.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        return;
                    }
                } else if ("class".equals(str2)) {
                    ((DIDLObject) getInstance()).setClazz(new DIDLObject.Class(getCharacters(), getAttributes().getValue("name")));
                    return;
                } else if ("artist".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.ARTIST(new PersonWithRole(getCharacters(), getAttributes().getValue("role")));
                } else if ("actor".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.ACTOR(new PersonWithRole(getCharacters(), getAttributes().getValue("role")));
                } else if (NotificationCompat.CarExtender.KEY_AUTHOR.equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.AUTHOR(new PersonWithRole(getCharacters(), getAttributes().getValue("role")));
                } else if ("producer".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.PRODUCER(new Person(getCharacters()));
                } else if ("director".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.DIRECTOR(new Person(getCharacters()));
                } else if ("longDescription".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.LONG_DESCRIPTION(getCharacters());
                } else if ("storageUsed".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.STORAGE_USED(Long.valueOf(getCharacters()));
                } else if ("storageTotal".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.STORAGE_TOTAL(Long.valueOf(getCharacters()));
                } else if ("storageFree".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.STORAGE_FREE(Long.valueOf(getCharacters()));
                } else if ("storageMaxPartition".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.STORAGE_MAX_PARTITION(Long.valueOf(getCharacters()));
                } else if ("storageMedium".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.STORAGE_MEDIUM(StorageMedium.valueOrVendorSpecificOf(getCharacters()));
                } else if ("genre".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.GENRE(getCharacters());
                } else if ("album".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.ALBUM(getCharacters());
                } else if ("playlist".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.PLAYLIST(getCharacters());
                } else if ("region".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.REGION(getCharacters());
                } else if ("rating".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.RATING(getCharacters());
                } else if ("toc".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.TOC(getCharacters());
                } else if ("albumArtURI".equals(str2)) {
                    DIDLObject.Property.UPNP.ALBUM_ART_URI album_art_uri = new DIDLObject.Property.UPNP.ALBUM_ART_URI(URI.create(getCharacters()));
                    Attributes attributes = getAttributes();
                    for (int i = 0; i < attributes.getLength(); i++) {
                        if ("profileID".equals(attributes.getLocalName(i))) {
                            album_art_uri.addAttribute(new DIDLObject.Property.DLNA.PROFILE_ID(new DIDLAttribute(DIDLObject.Property.DLNA.NAMESPACE.URI, Descriptor.Device.DLNA_PREFIX, attributes.getValue(i))));
                        }
                    }
                    ((DIDLObject) getInstance()).addProperty(album_art_uri);
                    return;
                } else if ("artistDiscographyURI".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.ARTIST_DISCO_URI(URI.create(getCharacters()));
                } else if ("lyricsURI".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.LYRICS_URI(URI.create(getCharacters()));
                } else if ("icon".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.ICON(URI.create(getCharacters()));
                } else if ("radioCallSign".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.RADIO_CALL_SIGN(getCharacters());
                } else if ("radioStationID".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.RADIO_STATION_ID(getCharacters());
                } else if ("radioBand".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.RADIO_BAND(getCharacters());
                } else if ("channelNr".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.CHANNEL_NR(Integer.valueOf(getCharacters()));
                } else if ("channelName".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.CHANNEL_NAME(getCharacters());
                } else if ("scheduledStartTime".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.SCHEDULED_START_TIME(getCharacters());
                } else if ("scheduledEndTime".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.SCHEDULED_END_TIME(getCharacters());
                } else if ("DVDRegionCode".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.DVD_REGION_CODE(Integer.valueOf(getCharacters()));
                } else if ("originalTrackNumber".equals(str2)) {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.ORIGINAL_TRACK_NUMBER(Integer.valueOf(getCharacters()));
                } else if (!"userAnnotation".equals(str2)) {
                    return;
                } else {
                    dIDLObject = (DIDLObject) getInstance();
                    user_annotation = new DIDLObject.Property.UPNP.USER_ANNOTATION(getCharacters());
                }
            }
            dIDLObject.addProperty(user_annotation);
        }
    }

    /* loaded from: classes5.dex */
    public class DescMetaHandler extends SAXParser.Handler<DescMeta> {
        public Element current = ((Document) getInstance().getMetadata()).getDocumentElement();

        public DescMetaHandler(DescMeta descMeta, SAXParser.Handler handler) {
            super(descMeta, handler);
            descMeta.setMetadata(descMeta.createMetadataDocument());
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            super.endElement(str, str2, str3);
            if (isLastElement(str, str2, str3)) {
                return;
            }
            if (getCharacters().length() > 0 && !getCharacters().matches("[\\t\\n\\x0B\\f\\r\\s]+")) {
                this.current.appendChild(((Document) getInstance().getMetadata()).createTextNode(getCharacters()));
            }
            this.current = (Element) this.current.getParentNode();
            this.characters = new StringBuilder();
            this.attributes = null;
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public DescMeta getInstance() {
            return (DescMeta) super.getInstance();
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            return DIDLContent.NAMESPACE_URI.equals(str) && "desc".equals(str2);
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            super.startElement(str, str2, str3, attributes);
            Element createElementNS = ((Document) getInstance().getMetadata()).createElementNS(str, str3);
            for (int i = 0; i < attributes.getLength(); i++) {
                createElementNS.setAttributeNS(attributes.getURI(i), attributes.getQName(i), attributes.getValue(i));
            }
            this.current.appendChild(createElementNS);
            this.current = createElementNS;
        }
    }

    /* loaded from: classes5.dex */
    public class ItemHandler extends DIDLObjectHandler<Item> {
        public ItemHandler(Item item, SAXParser.Handler handler) {
            super(item, handler);
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            if (!DIDLContent.NAMESPACE_URI.equals(str) || !"item".equals(str2)) {
                return false;
            }
            if (((Item) getInstance()).getTitle() == null) {
                Logger logger = DIDLParser.log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("In DIDL content, missing 'dc:title' element for item: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(((Item) getInstance()).getId());
                logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            if (((Item) getInstance()).getClazz() != null) {
                return true;
            }
            Logger logger2 = DIDLParser.log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("In DIDL content, missing 'upnp:class' element for item: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(((Item) getInstance()).getId());
            logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return true;
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            super.startElement(str, str2, str3, attributes);
            if (!DIDLContent.NAMESPACE_URI.equals(str)) {
                return;
            }
            if (str2.equals("res")) {
                Res createResource = DIDLParser.this.createResource(attributes);
                if (createResource == null) {
                    return;
                }
                ((Item) getInstance()).addResource(createResource);
                DIDLParser.this.createResHandler(createResource, this);
            } else if (!str2.equals("desc")) {
            } else {
                DescMeta createDescMeta = DIDLParser.this.createDescMeta(attributes);
                ((Item) getInstance()).addDescMetadata(createDescMeta);
                DIDLParser.this.createDescMetaHandler(createDescMeta, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class ResHandler extends SAXParser.Handler<Res> {
        public ResHandler(Res res, SAXParser.Handler handler) {
            super(res, handler);
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            super.endElement(str, str2, str3);
            getInstance().setValue(getCharacters());
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            return DIDLContent.NAMESPACE_URI.equals(str) && "res".equals(str2);
        }
    }

    /* loaded from: classes5.dex */
    public class RootHandler extends SAXParser.Handler<DIDLContent> {
        public RootHandler(DIDLContent dIDLContent, SAXParser sAXParser) {
            super(dIDLContent, sAXParser);
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            if (!DIDLContent.NAMESPACE_URI.equals(str) || !"DIDL-Lite".equals(str2)) {
                return false;
            }
            getInstance().replaceGenericContainerAndItems();
            return true;
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            super.startElement(str, str2, str3, attributes);
            if (!DIDLContent.NAMESPACE_URI.equals(str)) {
                return;
            }
            if (str2.equals("container")) {
                Container createContainer = DIDLParser.this.createContainer(attributes);
                getInstance().addContainer(createContainer);
                DIDLParser.this.createContainerHandler(createContainer, this);
            } else if (str2.equals("item")) {
                Item createItem = DIDLParser.this.createItem(attributes);
                getInstance().addItem(createItem);
                DIDLParser.this.createItemHandler(createItem, this);
            } else if (!str2.equals("desc")) {
            } else {
                DescMeta createDescMeta = DIDLParser.this.createDescMeta(attributes);
                getInstance().addDescMetadata(createDescMeta);
                DIDLParser.this.createDescMetaHandler(createDescMeta, this);
            }
        }
    }

    private Long toLongOrNull(String str) {
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public void appendClass(Document document, Element element, DIDLObject.Class r5, String str, boolean z) {
        Element appendNewElementIfNotNull = XMLUtil.appendNewElementIfNotNull(document, element, str, r5.getValue(), DIDLObject.Property.UPNP.NAMESPACE.URI);
        if (r5.getFriendlyName() != null && r5.getFriendlyName().length() > 0) {
            appendNewElementIfNotNull.setAttribute("name", r5.getFriendlyName());
        }
        if (z) {
            appendNewElementIfNotNull.setAttribute("includeDerived", Boolean.toString(r5.isIncludeDerived()));
        }
    }

    public void appendProperties(Document document, Element element, DIDLObject dIDLObject, String str, Class<? extends DIDLObject.Property.NAMESPACE> cls, String str2) {
        DIDLObject.Property[] propertiesByNamespace;
        for (DIDLObject.Property property : dIDLObject.getPropertiesByNamespace(cls)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(property.getDescriptorName());
            Element createElementNS = document.createElementNS(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            element.appendChild(createElementNS);
            property.setOnElement(createElementNS);
        }
    }

    public String booleanToInt(boolean z) {
        return z ? "1" : "0";
    }

    public Document buildDOM(DIDLContent dIDLContent, boolean z) throws Exception {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        Document newDocument = newInstance.newDocumentBuilder().newDocument();
        generateRoot(dIDLContent, newDocument, z);
        return newDocument;
    }

    public Container createContainer(Attributes attributes) {
        Container container = new Container();
        container.setId(attributes.getValue("id"));
        container.setParentID(attributes.getValue("parentID"));
        if (attributes.getValue("childCount") != null) {
            container.setChildCount(Integer.valueOf(attributes.getValue("childCount")));
        }
        try {
            Boolean bool = (Boolean) Datatype.Builtin.BOOLEAN.getDatatype().mo5215valueOf(attributes.getValue("restricted"));
            if (bool != null) {
                container.setRestricted(bool.booleanValue());
            }
            Boolean bool2 = (Boolean) Datatype.Builtin.BOOLEAN.getDatatype().mo5215valueOf(attributes.getValue("searchable"));
            if (bool2 != null) {
                container.setSearchable(bool2.booleanValue());
            }
        } catch (Exception unused) {
        }
        return container;
    }

    public ContainerHandler createContainerHandler(Container container, SAXParser.Handler handler) {
        return new ContainerHandler(container, handler);
    }

    public DescMeta createDescMeta(Attributes attributes) {
        DescMeta descMeta = new DescMeta();
        descMeta.setId(attributes.getValue("id"));
        if (attributes.getValue("type") != null) {
            descMeta.setType(attributes.getValue("type"));
        }
        if (attributes.getValue("nameSpace") != null) {
            descMeta.setNameSpace(URI.create(attributes.getValue("nameSpace")));
        }
        return descMeta;
    }

    public DescMetaHandler createDescMetaHandler(DescMeta descMeta, SAXParser.Handler handler) {
        return new DescMetaHandler(descMeta, handler);
    }

    public Item createItem(Attributes attributes) {
        Item item = new Item();
        item.setId(attributes.getValue("id"));
        item.setParentID(attributes.getValue("parentID"));
        try {
            Boolean bool = (Boolean) Datatype.Builtin.BOOLEAN.getDatatype().mo5215valueOf(attributes.getValue("restricted"));
            if (bool != null) {
                item.setRestricted(bool.booleanValue());
            }
        } catch (Exception unused) {
        }
        if (attributes.getValue("refID") != null) {
            item.setRefID(attributes.getValue("refID"));
        }
        return item;
    }

    public ItemHandler createItemHandler(Item item, SAXParser.Handler handler) {
        return new ItemHandler(item, handler);
    }

    public ResHandler createResHandler(Res res, SAXParser.Handler handler) {
        return new ResHandler(res, handler);
    }

    public Res createResource(Attributes attributes) {
        Res res = new Res();
        if (attributes.getValue("importUri") != null) {
            res.setImportUri(URI.create(attributes.getValue("importUri")));
        }
        try {
            res.setProtocolInfo(new ProtocolInfo(attributes.getValue("protocolInfo")));
            if (attributes.getValue("size") != null) {
                res.setSize(toLongOrNull(attributes.getValue("size")));
            }
            if (attributes.getValue("duration") != null) {
                res.setDuration(attributes.getValue("duration"));
            }
            if (attributes.getValue(IjkMediaMeta.IJKM_KEY_BITRATE) != null) {
                res.setBitrate(toLongOrNull(attributes.getValue(IjkMediaMeta.IJKM_KEY_BITRATE)));
            }
            if (attributes.getValue("sampleFrequency") != null) {
                res.setSampleFrequency(toLongOrNull(attributes.getValue("sampleFrequency")));
            }
            if (attributes.getValue("bitsPerSample") != null) {
                res.setBitsPerSample(toLongOrNull(attributes.getValue("bitsPerSample")));
            }
            if (attributes.getValue("nrAudioChannels") != null) {
                res.setNrAudioChannels(toLongOrNull(attributes.getValue("nrAudioChannels")));
            }
            if (attributes.getValue("colorDepth") != null) {
                res.setColorDepth(toLongOrNull(attributes.getValue("colorDepth")));
            }
            if (attributes.getValue("protection") != null) {
                res.setProtection(attributes.getValue("protection"));
            }
            if (attributes.getValue(C1543ak.f3055z) != null) {
                res.setResolution(attributes.getValue(C1543ak.f3055z));
            }
            return res;
        } catch (InvalidValueException e) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("In DIDL content, invalid resource protocol info: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Exceptions.unwrap(e));
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return null;
        }
    }

    public RootHandler createRootHandler(DIDLContent dIDLContent, SAXParser sAXParser) {
        return new RootHandler(dIDLContent, sAXParser);
    }

    public void debugXML(String str) {
        if (log.isLoggable(Level.FINE)) {
            log.fine("-------------------------------------------------------------------------------------");
            Logger logger = log;
            logger.fine("\n" + str);
            log.fine("-------------------------------------------------------------------------------------");
        }
    }

    public String documentToString(Document document, boolean z) throws Exception {
        Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
        if (z) {
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
        }
        StringWriter stringWriter = new StringWriter();
        newTransformer.transform(new DOMSource(document), new StreamResult(stringWriter));
        return stringWriter.toString();
    }

    public String generate(DIDLContent dIDLContent) throws Exception {
        return generate(dIDLContent, false);
    }

    public String generate(DIDLContent dIDLContent, boolean z) throws Exception {
        return documentToString(buildDOM(dIDLContent, z), true);
    }

    public void generateContainer(Container container, Document document, Element element, boolean z) {
        if (container.getClazz() == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing 'upnp:class' element for container: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(container.getId());
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        Element appendNewElement = XMLUtil.appendNewElement(document, element, "container");
        if (container.getId() == null) {
            throw new NullPointerException("Missing id on container: " + container);
        }
        appendNewElement.setAttribute("id", container.getId());
        if (container.getParentID() == null) {
            throw new NullPointerException("Missing parent id on container: " + container);
        }
        appendNewElement.setAttribute("parentID", container.getParentID());
        if (container.getChildCount() != null) {
            appendNewElement.setAttribute("childCount", Integer.toString(container.getChildCount().intValue()));
        }
        appendNewElement.setAttribute("restricted", booleanToInt(container.isRestricted()));
        appendNewElement.setAttribute("searchable", booleanToInt(container.isSearchable()));
        String title = container.getTitle();
        if (title == null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing 'dc:title' element for container: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(container.getId());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            title = UNKNOWN_TITLE;
        }
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "dc:title", title, DIDLObject.Property.C3095DC.NAMESPACE.URI);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "dc:creator", container.getCreator(), DIDLObject.Property.C3095DC.NAMESPACE.URI);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "upnp:writeStatus", container.getWriteStatus(), DIDLObject.Property.UPNP.NAMESPACE.URI);
        appendClass(document, appendNewElement, container.getClazz(), "upnp:class", false);
        for (DIDLObject.Class r1 : container.getSearchClasses()) {
            appendClass(document, appendNewElement, r1, "upnp:searchClass", true);
        }
        for (DIDLObject.Class r12 : container.getCreateClasses()) {
            appendClass(document, appendNewElement, r12, "upnp:createClass", true);
        }
        appendProperties(document, appendNewElement, container, "upnp", DIDLObject.Property.UPNP.NAMESPACE.class, DIDLObject.Property.UPNP.NAMESPACE.URI);
        appendProperties(document, appendNewElement, container, "dc", DIDLObject.Property.C3095DC.NAMESPACE.class, DIDLObject.Property.C3095DC.NAMESPACE.URI);
        if (z) {
            for (Item item : container.getItems()) {
                if (item != null) {
                    generateItem(item, document, appendNewElement);
                }
            }
        }
        for (Res res : container.getResources()) {
            if (res != null) {
                generateResource(res, document, appendNewElement);
            }
        }
        for (DescMeta descMeta : container.getDescMetadata()) {
            if (descMeta != null) {
                generateDescMetadata(descMeta, document, appendNewElement);
            }
        }
    }

    public void generateDescMetadata(DescMeta descMeta, Document document, Element element) {
        if (descMeta.getId() == null) {
            throw new RuntimeException("Missing id of description metadata: " + descMeta);
        } else if (descMeta.getNameSpace() == null) {
            throw new RuntimeException("Missing namespace of description metadata: " + descMeta);
        } else {
            Element appendNewElement = XMLUtil.appendNewElement(document, element, "desc");
            appendNewElement.setAttribute("id", descMeta.getId());
            appendNewElement.setAttribute("nameSpace", descMeta.getNameSpace().toString());
            if (descMeta.getType() != null) {
                appendNewElement.setAttribute("type", descMeta.getType());
            }
            populateDescMetadata(appendNewElement, descMeta);
        }
    }

    public void generateItem(Item item, Document document, Element element) {
        if (item.getClazz() == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing 'upnp:class' element for item: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(item.getId());
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        Element appendNewElement = XMLUtil.appendNewElement(document, element, "item");
        if (item.getId() == null) {
            throw new NullPointerException("Missing id on item: " + item);
        }
        appendNewElement.setAttribute("id", item.getId());
        if (item.getParentID() == null) {
            throw new NullPointerException("Missing parent id on item: " + item);
        }
        appendNewElement.setAttribute("parentID", item.getParentID());
        if (item.getRefID() != null) {
            appendNewElement.setAttribute("refID", item.getRefID());
        }
        appendNewElement.setAttribute("restricted", booleanToInt(item.isRestricted()));
        String title = item.getTitle();
        if (title == null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing 'dc:title' element for item: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(item.getId());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            title = UNKNOWN_TITLE;
        }
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "dc:title", title, DIDLObject.Property.C3095DC.NAMESPACE.URI);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "dc:creator", item.getCreator(), DIDLObject.Property.C3095DC.NAMESPACE.URI);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, "upnp:writeStatus", item.getWriteStatus(), DIDLObject.Property.UPNP.NAMESPACE.URI);
        appendClass(document, appendNewElement, item.getClazz(), "upnp:class", false);
        appendProperties(document, appendNewElement, item, "upnp", DIDLObject.Property.UPNP.NAMESPACE.class, DIDLObject.Property.UPNP.NAMESPACE.URI);
        appendProperties(document, appendNewElement, item, "dc", DIDLObject.Property.C3095DC.NAMESPACE.class, DIDLObject.Property.C3095DC.NAMESPACE.URI);
        appendProperties(document, appendNewElement, item, Descriptor.Device.SEC_PREFIX, DIDLObject.Property.SEC.NAMESPACE.class, DIDLObject.Property.SEC.NAMESPACE.URI);
        for (Res res : item.getResources()) {
            if (res != null) {
                generateResource(res, document, appendNewElement);
            }
        }
        for (DescMeta descMeta : item.getDescMetadata()) {
            if (descMeta != null) {
                generateDescMetadata(descMeta, document, appendNewElement);
            }
        }
    }

    public void generateResource(Res res, Document document, Element element) {
        if (res.getValue() == null) {
            throw new RuntimeException("Missing resource URI value" + res);
        } else if (res.getProtocolInfo() == null) {
            throw new RuntimeException("Missing resource protocol info: " + res);
        } else {
            Element appendNewElement = XMLUtil.appendNewElement(document, element, "res", res.getValue());
            appendNewElement.setAttribute("protocolInfo", res.getProtocolInfo().toString());
            if (res.getImportUri() != null) {
                appendNewElement.setAttribute("importUri", res.getImportUri().toString());
            }
            if (res.getSize() != null) {
                appendNewElement.setAttribute("size", res.getSize().toString());
            }
            if (res.getDuration() != null) {
                appendNewElement.setAttribute("duration", res.getDuration());
            }
            if (res.getBitrate() != null) {
                appendNewElement.setAttribute(IjkMediaMeta.IJKM_KEY_BITRATE, res.getBitrate().toString());
            }
            if (res.getSampleFrequency() != null) {
                appendNewElement.setAttribute("sampleFrequency", res.getSampleFrequency().toString());
            }
            if (res.getBitsPerSample() != null) {
                appendNewElement.setAttribute("bitsPerSample", res.getBitsPerSample().toString());
            }
            if (res.getNrAudioChannels() != null) {
                appendNewElement.setAttribute("nrAudioChannels", res.getNrAudioChannels().toString());
            }
            if (res.getColorDepth() != null) {
                appendNewElement.setAttribute("colorDepth", res.getColorDepth().toString());
            }
            if (res.getProtection() != null) {
                appendNewElement.setAttribute("protection", res.getProtection());
            }
            if (res.getResolution() == null) {
                return;
            }
            appendNewElement.setAttribute(C1543ak.f3055z, res.getResolution());
        }
    }

    public void generateRoot(DIDLContent dIDLContent, Document document, boolean z) {
        Element createElementNS = document.createElementNS(DIDLContent.NAMESPACE_URI, "DIDL-Lite");
        document.appendChild(createElementNS);
        createElementNS.setAttributeNS(XmlNode.XML_NAMESPACES_NAMESPACE_URI, "xmlns:upnp", DIDLObject.Property.UPNP.NAMESPACE.URI);
        createElementNS.setAttributeNS(XmlNode.XML_NAMESPACES_NAMESPACE_URI, "xmlns:dc", DIDLObject.Property.C3095DC.NAMESPACE.URI);
        createElementNS.setAttributeNS(XmlNode.XML_NAMESPACES_NAMESPACE_URI, "xmlns:sec", DIDLObject.Property.SEC.NAMESPACE.URI);
        for (Container container : dIDLContent.getContainers()) {
            if (container != null) {
                generateContainer(container, document, createElementNS, z);
            }
        }
        for (Item item : dIDLContent.getItems()) {
            if (item != null) {
                generateItem(item, document, createElementNS);
            }
        }
        for (DescMeta descMeta : dIDLContent.getDescMetadata()) {
            if (descMeta != null) {
                generateDescMetadata(descMeta, document, createElementNS);
            }
        }
    }

    public DIDLContent parse(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("Null or empty XML");
        }
        DIDLContent dIDLContent = new DIDLContent();
        createRootHandler(dIDLContent, this);
        log.fine("Parsing DIDL XML content");
        parse(new InputSource(new StringReader(str)));
        return dIDLContent;
    }

    public DIDLContent parseResource(String str) throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
            DIDLContent parse = parse(C3387IO.readLines(inputStream));
            inputStream.close();
            return parse;
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void populateDescMetadata(Element element, DescMeta descMeta) {
        if (!(descMeta.getMetadata() instanceof Document)) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown desc metadata content, please override populateDescMetadata(): ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(descMeta.getMetadata());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return;
        }
        NodeList childNodes = ((Document) descMeta.getMetadata()).getDocumentElement().getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                element.appendChild(element.getOwnerDocument().importNode(item, true));
            }
        }
    }
}
