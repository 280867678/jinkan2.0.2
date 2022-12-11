package org.mozilla.javascript.xmlimpl;

import java.io.Serializable;
import me.tvspark.outline;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.xml.XMLLib;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public final class XMLLibImpl extends XMLLib implements Serializable {
    public static final long serialVersionUID = 1;
    public Scriptable globalScope;
    public Namespace namespacePrototype;
    public XmlProcessor options = new XmlProcessor();
    public QName qnamePrototype;
    public XMLList xmlListPrototype;
    public XML xmlPrototype;

    public XMLLibImpl(Scriptable scriptable) {
        this.globalScope = scriptable;
    }

    public static RuntimeException badXMLName(Object obj) {
        String str;
        if (obj instanceof Number) {
            str = "Can not construct XML name from number: ";
        } else if (obj instanceof Boolean) {
            str = "Can not construct XML name from boolean: ";
        } else if (obj != Undefined.instance && obj != null) {
            throw new IllegalArgumentException(obj.toString());
        } else {
            str = "Can not construct XML name from ";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ScriptRuntime.toString(obj));
        return ScriptRuntime.typeError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    private void exportToScope(boolean z) {
        this.xmlPrototype = newXML(XmlNode.createText(this.options, ""));
        this.xmlListPrototype = newXMLList();
        this.namespacePrototype = Namespace.create(this.globalScope, null, XmlNode.Namespace.GLOBAL);
        this.qnamePrototype = QName.create(this, this.globalScope, null, XmlNode.QName.create(XmlNode.Namespace.create(""), ""));
        this.xmlPrototype.exportAsJSClass(z);
        this.xmlListPrototype.exportAsJSClass(z);
        this.namespacePrototype.exportAsJSClass(z);
        this.qnamePrototype.exportAsJSClass(z);
    }

    private String getDefaultNamespaceURI(Context context) {
        return getDefaultNamespace(context).uri();
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        XMLLibImpl xMLLibImpl = new XMLLibImpl(scriptable);
        if (xMLLibImpl.bindToScope(scriptable) == xMLLibImpl) {
            xMLLibImpl.exportToScope(z);
        }
    }

    private XML parse(String str) {
        try {
            return newXML(XmlNode.createElement(this.options, getDefaultNamespaceURI(Context.getCurrentContext()), str));
        } catch (SAXException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot parse XML: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw ScriptRuntime.typeError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public static Node toDomNode(Object obj) {
        if (obj instanceof XML) {
            return ((XML) obj).toDomNode();
        }
        throw new IllegalArgumentException("xmlObject is not an XML object in JavaScript.");
    }

    private Ref xmlPrimaryReference(Context context, XMLName xMLName, Scriptable scriptable) {
        XMLObjectImpl xMLObjectImpl;
        XMLObjectImpl xMLObjectImpl2 = null;
        while (true) {
            if (scriptable instanceof XMLWithScope) {
                xMLObjectImpl = (XMLObjectImpl) scriptable.getPrototype();
                if (xMLObjectImpl.hasXMLProperty(xMLName)) {
                    break;
                } else if (xMLObjectImpl2 == null) {
                    xMLObjectImpl2 = xMLObjectImpl;
                }
            }
            scriptable = scriptable.getParentScope();
            if (scriptable == null) {
                xMLObjectImpl = xMLObjectImpl2;
                break;
            }
        }
        if (xMLObjectImpl != null) {
            xMLName.initXMLObject(xMLObjectImpl);
        }
        return xMLName;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addXMLObjects(Context context, XMLObject xMLObject, XMLObject xMLObject2) {
        XMLList newXMLList = newXMLList();
        if (xMLObject instanceof XMLList) {
            XMLList xMLList = (XMLList) xMLObject;
            if (xMLList.length() != 1) {
                newXMLList = newXMLListFrom(xMLObject);
                if (!(xMLObject2 instanceof XMLList)) {
                    XMLList xMLList2 = (XMLList) xMLObject2;
                    for (int i = 0; i < xMLList2.length(); i++) {
                        newXMLList.addToList(xMLList2.item(i));
                    }
                } else if (xMLObject2 instanceof XML) {
                    newXMLList.addToList(xMLObject2);
                }
                return newXMLList;
            }
            xMLObject = xMLList.item(0);
        }
        newXMLList.addToList(xMLObject);
        if (!(xMLObject2 instanceof XMLList)) {
        }
        return newXMLList;
    }

    public Namespace castToNamespace(Context context, Object obj) {
        return this.namespacePrototype.castToNamespace(obj);
    }

    public QName castToQName(Context context, Object obj) {
        return this.qnamePrototype.castToQName(this, context, obj);
    }

    public QName constructQName(Context context, Object obj) {
        return this.qnamePrototype.constructQName(this, context, obj);
    }

    public QName constructQName(Context context, Object obj, Object obj2) {
        return this.qnamePrototype.constructQName(this, context, obj, obj2);
    }

    public Namespace[] createNamespaces(XmlNode.Namespace[] namespaceArr) {
        Namespace[] namespaceArr2 = new Namespace[namespaceArr.length];
        for (int i = 0; i < namespaceArr.length; i++) {
            namespaceArr2[i] = this.namespacePrototype.newNamespace(namespaceArr[i].getPrefix(), namespaceArr[i].getUri());
        }
        return namespaceArr2;
    }

    public final XML ecmaToXml(Object obj) {
        XmlNode createText;
        if (obj == null || obj == Undefined.instance) {
            throw ScriptRuntime.typeError("Cannot convert " + obj + " to XML");
        } else if (obj instanceof XML) {
            return (XML) obj;
        } else {
            if (obj instanceof XMLList) {
                XMLList xMLList = (XMLList) obj;
                if (xMLList.getXML() == null) {
                    throw ScriptRuntime.typeError("Cannot convert list of >1 element to XML");
                }
                return xMLList.getXML();
            }
            if (obj instanceof Wrapper) {
                obj = ((Wrapper) obj).unwrap();
            }
            if (obj instanceof Node) {
                createText = XmlNode.createElementFromNode((Node) obj);
            } else {
                String scriptRuntime = ScriptRuntime.toString(obj);
                if (scriptRuntime.length() > 0 && scriptRuntime.charAt(0) == '<') {
                    return parse(scriptRuntime);
                }
                createText = XmlNode.createText(this.options, scriptRuntime);
            }
            return newXML(createText);
        }
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public String escapeAttributeValue(Object obj) {
        return this.options.escapeAttributeValue(obj);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public String escapeTextValue(Object obj) {
        return this.options.escapeTextValue(obj);
    }

    public Namespace getDefaultNamespace(Context context) {
        Object searchDefaultNamespace;
        if ((context != null || (context = Context.getCurrentContext()) != null) && (searchDefaultNamespace = ScriptRuntime.searchDefaultNamespace(context)) != null && (searchDefaultNamespace instanceof Namespace)) {
            return (Namespace) searchDefaultNamespace;
        }
        return this.namespacePrototype;
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public int getPrettyIndent() {
        return this.options.getPrettyIndent();
    }

    public XmlProcessor getProcessor() {
        return this.options;
    }

    @Deprecated
    public Scriptable globalScope() {
        return this.globalScope;
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreComments() {
        return this.options.isIgnoreComments();
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreProcessingInstructions() {
        return this.options.isIgnoreProcessingInstructions();
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreWhitespace() {
        return this.options.isIgnoreWhitespace();
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public boolean isPrettyPrinting() {
        return this.options.isPrettyPrinting();
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public boolean isXMLName(Context context, Object obj) {
        return XMLName.accept(obj);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Object obj2, Scriptable scriptable, int i) {
        XMLName create = XMLName.create(toNodeQName(context, obj, obj2), false, false);
        if ((i & 2) != 0 && !create.isAttributeName()) {
            create.setAttributeName();
        }
        return xmlPrimaryReference(context, create, scriptable);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Scriptable scriptable, int i) {
        if ((i & 2) != 0) {
            return xmlPrimaryReference(context, toAttributeName(context, obj), scriptable);
        }
        throw Kit.codeBug();
    }

    public Namespace newNamespace(String str) {
        return this.namespacePrototype.newNamespace(str);
    }

    public QName newQName(String str, String str2, String str3) {
        return this.qnamePrototype.newQName(this, str, str2, str3);
    }

    public QName newQName(XmlNode.QName qName) {
        return QName.create(this, this.globalScope, this.qnamePrototype, qName);
    }

    public final XML newTextElementXML(XmlNode xmlNode, XmlNode.QName qName, String str) {
        return newXML(XmlNode.newElementWithText(this.options, xmlNode, qName, str));
    }

    public XML newXML(XmlNode xmlNode) {
        return new XML(this, this.globalScope, this.xmlPrototype, xmlNode);
    }

    public final XML newXMLFromJs(Object obj) {
        String xMLString = (obj == null || obj == Undefined.instance) ? "" : obj instanceof XMLObjectImpl ? ((XMLObjectImpl) obj).toXMLString() : ScriptRuntime.toString(obj);
        if (!xMLString.trim().startsWith("<>")) {
            return xMLString.indexOf("<") == -1 ? newXML(XmlNode.createText(this.options, xMLString)) : parse(xMLString);
        }
        throw ScriptRuntime.typeError("Invalid use of XML object anonymous tags <></>.");
    }

    public XMLList newXMLList() {
        return new XMLList(this, this.globalScope, this.xmlListPrototype);
    }

    public final XMLList newXMLListFrom(Object obj) {
        XMLList newXMLList = newXMLList();
        if (obj == null || (obj instanceof Undefined)) {
            return newXMLList;
        }
        if (obj instanceof XML) {
            newXMLList.getNodeList().add((XML) obj);
            return newXMLList;
        } else if (obj instanceof XMLList) {
            newXMLList.getNodeList().add(((XMLList) obj).getNodeList());
            return newXMLList;
        } else {
            String trim = ScriptRuntime.toString(obj).trim();
            if (!trim.startsWith("<>")) {
                trim = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<>", trim, "</>");
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<fragment>");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(trim.substring(2));
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            if (!sb.endsWith("</>")) {
                throw ScriptRuntime.typeError("XML with anonymous tag missing end anonymous tag");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(sb.substring(0, sb.length() - 3));
            sb2.append("</fragment>");
            XMLList children = newXMLFromJs(sb2.toString()).children();
            for (int i = 0; i < children.getNodeList().length(); i++) {
                newXMLList.getNodeList().add((XML) children.item(i).copy());
            }
            return newXMLList;
        }
    }

    @Deprecated
    public QName qnamePrototype() {
        return this.qnamePrototype;
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public void setIgnoreComments(boolean z) {
        this.options.setIgnoreComments(z);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public void setIgnoreProcessingInstructions(boolean z) {
        this.options.setIgnoreProcessingInstructions(z);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public void setIgnoreWhitespace(boolean z) {
        this.options.setIgnoreWhitespace(z);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public void setPrettyIndent(int i) {
        this.options.setPrettyIndent(i);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public void setPrettyPrinting(boolean z) {
        this.options.setPrettyPrinting(z);
    }

    @Deprecated
    public XMLName toAttributeName(Context context, Object obj) {
        XmlNode.QName create;
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof QName) {
            create = ((QName) obj).getDelegate();
        } else if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        } else {
            String scriptRuntime = obj instanceof String ? (String) obj : ScriptRuntime.toString(obj);
            if (scriptRuntime != null && scriptRuntime.equals("*")) {
                scriptRuntime = null;
            }
            create = XmlNode.QName.create(XmlNode.Namespace.create(""), scriptRuntime);
        }
        return XMLName.create(create, true, false);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public Object toDefaultXmlNamespace(Context context, Object obj) {
        return this.namespacePrototype.constructNamespace(obj);
    }

    public XmlNode.QName toNodeQName(Context context, Object obj, Object obj2) {
        Namespace constructNamespace;
        XmlNode.Namespace delegate;
        String localName = obj2 instanceof QName ? ((QName) obj2).localName() : ScriptRuntime.toString(obj2);
        if (obj == Undefined.instance) {
            if (!"*".equals(localName)) {
                constructNamespace = getDefaultNamespace(context);
                delegate = constructNamespace.getDelegate();
            }
            delegate = null;
        } else {
            if (obj != null) {
                if (obj instanceof Namespace) {
                    delegate = ((Namespace) obj).getDelegate();
                } else {
                    constructNamespace = this.namespacePrototype.constructNamespace(obj);
                    delegate = constructNamespace.getDelegate();
                }
            }
            delegate = null;
        }
        if (localName != null && localName.equals("*")) {
            localName = null;
        }
        return XmlNode.QName.create(delegate, localName);
    }

    public XmlNode.QName toNodeQName(Context context, Object obj, boolean z) {
        if (obj instanceof XMLName) {
            return ((XMLName) obj).toQname();
        }
        if (obj instanceof QName) {
            return ((QName) obj).getDelegate();
        }
        if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        }
        return toNodeQName(context, obj instanceof String ? (String) obj : ScriptRuntime.toString(obj), z);
    }

    public XmlNode.QName toNodeQName(Context context, String str, boolean z) {
        return (str == null || !str.equals("*")) ? z ? XmlNode.QName.create(XmlNode.Namespace.GLOBAL, str) : XmlNode.QName.create(getDefaultNamespace(context).getDelegate(), str) : XmlNode.QName.create(null, null);
    }

    public XMLName toXMLName(Context context, Object obj) {
        String scriptRuntime;
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            return XMLName.formProperty(qName.uri(), qName.localName());
        }
        if (obj instanceof String) {
            scriptRuntime = (String) obj;
        } else if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        } else {
            scriptRuntime = ScriptRuntime.toString(obj);
        }
        return toXMLNameFromString(context, scriptRuntime);
    }

    public XMLName toXMLNameFromString(Context context, String str) {
        return XMLName.create(getDefaultNamespaceURI(context), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008a, code lost:
        return toXMLNameFromString(r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0082, code lost:
        org.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0080, code lost:
        if (r4 >= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r4 >= 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XMLName toXMLNameOrIndex(Context context, Object obj) {
        String scriptRuntime;
        long testUint32String;
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof String) {
            scriptRuntime = (String) obj;
            testUint32String = ScriptRuntime.testUint32String(scriptRuntime);
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            long j = (long) doubleValue;
            if (j != doubleValue || 0 > j || j > 4294967295L) {
                throw badXMLName(obj);
            }
            ScriptRuntime.storeUint32Result(context, j);
            return null;
        } else if (obj instanceof QName) {
            QName qName = (QName) obj;
            String uri = qName.uri();
            boolean z = false;
            if (uri != null && uri.length() == 0) {
                long testUint32String2 = ScriptRuntime.testUint32String(uri);
                if (testUint32String2 >= 0) {
                    ScriptRuntime.storeUint32Result(context, testUint32String2);
                    z = true;
                }
            }
            if (z) {
                return null;
            }
            return XMLName.formProperty(uri, qName.localName());
        } else if ((obj instanceof Boolean) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        } else {
            scriptRuntime = ScriptRuntime.toString(obj);
            testUint32String = ScriptRuntime.testUint32String(scriptRuntime);
        }
    }
}
