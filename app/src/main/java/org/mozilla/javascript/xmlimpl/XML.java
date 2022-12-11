package org.mozilla.javascript.xmlimpl;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import me.tvspark.outline;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.simpleframework.xml.core.AnnotationHandler;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class XML extends XMLObjectImpl {
    public static final long serialVersionUID = -630969919086449092L;
    public XmlNode node;

    public XML(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject, XmlNode xmlNode) {
        super(xMLLibImpl, scriptable, xMLObject);
        initialize(xmlNode);
    }

    private XmlNode.Namespace adapt(Namespace namespace) {
        return namespace.prefix() == null ? XmlNode.Namespace.create(namespace.uri()) : XmlNode.Namespace.create(namespace.prefix(), namespace.uri());
    }

    private void addInScopeNamespace(Namespace namespace) {
        if (isElement() && namespace.prefix() != null) {
            if (namespace.prefix().length() == 0 && namespace.uri().length() == 0) {
                return;
            }
            if (this.node.getQname().getNamespace().getPrefix().equals(namespace.prefix())) {
                this.node.invalidateNamespacePrefix();
            }
            this.node.declareNamespace(namespace.prefix(), namespace.uri());
        }
    }

    private String ecmaToString() {
        if (isAttribute() || isText()) {
            return ecmaValue();
        }
        if (!hasSimpleContent()) {
            return toXMLString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.node.getChildCount(); i++) {
            XmlNode child = this.node.getChild(i);
            if (!child.isProcessingInstructionType() && !child.isCommentType()) {
                sb.append(new XML(getLib(), getParentScope(), (XMLObject) getPrototype(), child).toString());
            }
        }
        return sb.toString();
    }

    private String ecmaValue() {
        return this.node.ecmaValue();
    }

    private int getChildIndexOf(XML xml) {
        for (int i = 0; i < this.node.getChildCount(); i++) {
            if (this.node.getChild(i).isSameNode(xml.node)) {
                return i;
            }
        }
        return -1;
    }

    private XmlNode[] getNodesForInsert(Object obj) {
        if (obj instanceof XML) {
            return new XmlNode[]{((XML) obj).node};
        }
        if (!(obj instanceof XMLList)) {
            return new XmlNode[]{XmlNode.createText(getProcessor(), ScriptRuntime.toString(obj))};
        }
        XMLList xMLList = (XMLList) obj;
        XmlNode[] xmlNodeArr = new XmlNode[xMLList.length()];
        for (int i = 0; i < xMLList.length(); i++) {
            xmlNodeArr[i] = xMLList.item(i).node;
        }
        return xmlNodeArr;
    }

    private XML toXML(XmlNode xmlNode) {
        if (xmlNode.getXml() == null) {
            xmlNode.setXml(newXML(xmlNode));
        }
        return xmlNode.getXml();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void addMatches(XMLList xMLList, XMLName xMLName) {
        xMLName.addMatches(xMLList, this);
    }

    public XML addNamespace(Namespace namespace) {
        addInScopeNamespace(namespace);
        return this;
    }

    public XML appendChild(Object obj) {
        if (this.node.isParentType()) {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            XmlNode xmlNode = this.node;
            xmlNode.insertChildrenAt(xmlNode.getChildCount(), nodesForInsert);
        }
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(int i) {
        XMLList newXMLList = newXMLList();
        newXMLList.setTargets(this, null);
        if (i >= 0 && i < this.node.getChildCount()) {
            newXMLList.addToList(getXmlChild(i));
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i = 0; i < matchingChildren.length; i++) {
            if (xMLName.matchesElement(matchingChildren[i].getQname())) {
                newXMLList.addToList(toXML(matchingChildren[i]));
            }
        }
        newXMLList.setTargets(this, xMLName.toQname());
        return newXMLList;
    }

    public int childIndex() {
        return this.node.getChildIndex();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList children() {
        XMLList newXMLList = newXMLList();
        newXMLList.setTargets(this, XMLName.formStar().toQname());
        for (XmlNode xmlNode : this.node.getMatchingChildren(XmlNode.Filter.TRUE)) {
            newXMLList.addToList(toXML(xmlNode));
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList comments() {
        XMLList newXMLList = newXMLList();
        this.node.addMatchingChildren(newXMLList, XmlNode.Filter.COMMENT);
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean contains(Object obj) {
        if (obj instanceof XML) {
            return equivalentXml(obj);
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLObjectImpl copy() {
        return newXML(this.node.copy());
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i == 0) {
            remove();
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void deleteXMLProperty(XMLName xMLName) {
        XMLList propertyList = getPropertyList(xMLName);
        for (int i = 0; i < propertyList.length(); i++) {
            propertyList.item(i).node.deleteMe();
        }
    }

    public final String ecmaClass() {
        if (this.node.isTextType()) {
            return "text";
        }
        if (this.node.isAttributeType()) {
            return AnnotationHandler.ATTRIBUTE;
        }
        if (this.node.isCommentType()) {
            return "comment";
        }
        if (this.node.isProcessingInstructionType()) {
            return "processing-instruction";
        }
        if (this.node.isElementType()) {
            return "element";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unrecognized type: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.node);
        throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList elements(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        newXMLList.setTargets(this, xMLName.toQname());
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i = 0; i < matchingChildren.length; i++) {
            if (xMLName.matches(toXML(matchingChildren[i]))) {
                newXMLList.addToList(toXML(matchingChildren[i]));
            }
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean equivalentXml(Object obj) {
        if (obj instanceof XML) {
            return this.node.toXmlString(getProcessor()).equals(((XML) obj).node.toXmlString(getProcessor()));
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.length() != 1) {
                return false;
            }
            return equivalentXml(xMLList.getXML());
        } else if (!hasSimpleContent()) {
            return false;
        } else {
            return toString().equals(ScriptRuntime.toString(obj));
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return i == 0 ? this : Scriptable.NOT_FOUND;
    }

    public XmlNode getAnnotation() {
        return this.node;
    }

    public XML[] getAttributes() {
        XmlNode[] attributes = this.node.getAttributes();
        int length = attributes.length;
        XML[] xmlArr = new XML[length];
        for (int i = 0; i < length; i++) {
            xmlArr[i] = toXML(attributes[i]);
        }
        return xmlArr;
    }

    public XML[] getChildren() {
        if (!isElement()) {
            return null;
        }
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.TRUE);
        int length = matchingChildren.length;
        XML[] xmlArr = new XML[length];
        for (int i = 0; i < length; i++) {
            xmlArr[i] = toXML(matchingChildren[i]);
        }
        return xmlArr;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "XML";
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Scriptable getExtraMethodSource(Context context) {
        if (hasSimpleContent()) {
            return ScriptRuntime.toObjectOrNull(context, toString());
        }
        return null;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return isPrototype() ? new Object[0] : new Object[]{0};
    }

    public XML getLastXmlChild() {
        int childCount = this.node.getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        return getXmlChild(childCount);
    }

    public XmlNode.QName getNodeQname() {
        return this.node.getQname();
    }

    public XMLList getPropertyList(XMLName xMLName) {
        return xMLName.getMyValueOn(this);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public final XML getXML() {
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object getXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName);
    }

    public XML getXmlChild(int i) {
        XmlNode child = this.node.getChild(i);
        if (child.getXml() == null) {
            child.setXml(newXML(child));
        }
        return child.getXml();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i == 0;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasComplexContent() {
        return !hasSimpleContent();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasOwnProperty(XMLName xMLName) {
        if (isPrototype()) {
            if (findPrototypeId(xMLName.localName()) != 0) {
                return true;
            }
        } else if (getPropertyList(xMLName).length() > 0) {
            return true;
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasSimpleContent() {
        if (isComment() || isProcessingInstruction()) {
            return false;
        }
        if (!isText() && !this.node.isAttributeType()) {
            return !this.node.hasChildElement();
        }
        return true;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName).length() > 0;
    }

    public Namespace[] inScopeNamespaces() {
        return createNamespaces(this.node.getInScopeNamespaces());
    }

    public void initialize(XmlNode xmlNode) {
        this.node = xmlNode;
        xmlNode.setXml(this);
    }

    public XML insertChildAfter(XML xml, Object obj) {
        if (xml == null) {
            prependChild(obj);
        } else {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            int childIndexOf = getChildIndexOf(xml);
            if (childIndexOf != -1) {
                this.node.insertChildrenAt(childIndexOf + 1, nodesForInsert);
            }
        }
        return this;
    }

    public XML insertChildBefore(XML xml, Object obj) {
        if (xml == null) {
            appendChild(obj);
        } else {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            int childIndexOf = getChildIndexOf(xml);
            if (childIndexOf != -1) {
                this.node.insertChildrenAt(childIndexOf, nodesForInsert);
            }
        }
        return this;
    }

    /* renamed from: is */
    public boolean m12is(XML xml) {
        return this.node.isSameNode(xml.node);
    }

    public final boolean isAttribute() {
        return this.node.isAttributeType();
    }

    public final boolean isComment() {
        return this.node.isCommentType();
    }

    public final boolean isElement() {
        return this.node.isElementType();
    }

    public final boolean isProcessingInstruction() {
        return this.node.isProcessingInstructionType();
    }

    public final boolean isText() {
        return this.node.isTextType();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (objArr.length == 0 || objArr[0] == null || objArr[0] == Undefined.instance) {
            objArr = new Object[]{""};
        }
        XML ecmaToXml = ecmaToXml(objArr[0]);
        return z ? ecmaToXml.copy() : ecmaToXml;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public int length() {
        return 1;
    }

    public String localName() {
        if (name() == null) {
            return null;
        }
        return name().localName();
    }

    public XML makeXmlFromString(XMLName xMLName, String str) {
        try {
            return newTextElementXML(this.node, xMLName.toQname(), str);
        } catch (Exception e) {
            throw ScriptRuntime.typeError(e.getMessage());
        }
    }

    public QName name() {
        if (isText() || isComment()) {
            return null;
        }
        return isProcessingInstruction() ? newQName("", this.node.getQname().getLocalName(), null) : newQName(this.node.getQname());
    }

    public Namespace namespace(String str) {
        return createNamespace(str == null ? this.node.getNamespaceDeclaration() : this.node.getNamespaceDeclaration(str));
    }

    public Namespace[] namespaceDeclarations() {
        return createNamespaces(this.node.getNamespaceDeclarations());
    }

    public Object nodeKind() {
        return ecmaClass();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void normalize() {
        this.node.normalize();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object parent() {
        if (this.node.parent() == null) {
            return null;
        }
        return newXML(this.node.parent());
    }

    public XML prependChild(Object obj) {
        if (this.node.isParentType()) {
            this.node.insertChildrenAt(0, getNodesForInsert(obj));
        }
        return this;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList processingInstructions(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        this.node.addMatchingChildren(newXMLList, XmlNode.Filter.PROCESSING_INSTRUCTION(xMLName));
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean propertyIsEnumerable(Object obj) {
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
        } else if (!(obj instanceof Number)) {
            return ScriptRuntime.toString(obj).equals("0");
        } else {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue == RoundRectDrawableWithShadow.COS_45 && 1.0d / doubleValue > RoundRectDrawableWithShadow.COS_45) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        throw ScriptRuntime.typeError("Assignment to indexed XML is not allowed");
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void putXMLProperty(XMLName xMLName, Object obj) {
        if (isPrototype()) {
            return;
        }
        xMLName.setMyValueOn(this, obj);
    }

    public void remove() {
        this.node.deleteMe();
    }

    public void removeChild(int i) {
        this.node.removeChild(i);
    }

    public XML removeNamespace(Namespace namespace) {
        if (!isElement()) {
            return this;
        }
        this.node.removeNamespace(adapt(namespace));
        return this;
    }

    public XML replace(int i, Object obj) {
        XMLList child = child(i);
        if (child.length() > 0) {
            insertChildAfter(child.item(0), obj);
            removeChild(i);
        }
        return this;
    }

    public XML replace(XMLName xMLName, Object obj) {
        putXMLProperty(xMLName, obj);
        return this;
    }

    public void replaceWith(XML xml) {
        if (this.node.parent() != null) {
            this.node.replaceWith(xml.node);
        } else {
            initialize(xml.node);
        }
    }

    public void setAttribute(XMLName xMLName, Object obj) {
        if (isElement()) {
            if (xMLName.uri() == null && xMLName.localName().equals("*")) {
                throw ScriptRuntime.typeError("@* assignment not supported.");
            }
            this.node.setAttribute(xMLName.toQname(), ScriptRuntime.toString(obj));
            return;
        }
        throw new IllegalStateException("Can only set attributes on elements.");
    }

    public XML setChildren(Object obj) {
        if (!isElement()) {
            return this;
        }
        while (this.node.getChildCount() > 0) {
            this.node.removeChild(0);
        }
        this.node.insertChildrenAt(0, getNodesForInsert(obj));
        return this;
    }

    public void setLocalName(String str) {
        if (isText() || isComment()) {
            return;
        }
        this.node.setLocalName(str);
    }

    public void setName(QName qName) {
        if (isText() || isComment()) {
            return;
        }
        if (isProcessingInstruction()) {
            this.node.setLocalName(qName.localName());
        } else {
            this.node.renameNode(qName.getDelegate());
        }
    }

    public void setNamespace(Namespace namespace) {
        if (isText() || isComment() || isProcessingInstruction()) {
            return;
        }
        setName(newQName(namespace.uri(), localName(), namespace.prefix()));
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList text() {
        XMLList newXMLList = newXMLList();
        this.node.addMatchingChildren(newXMLList, XmlNode.Filter.TEXT);
        return newXMLList;
    }

    public Node toDomNode() {
        return this.node.toDomNode();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toSource(int i) {
        return toXMLString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toString() {
        return ecmaToString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toXMLString() {
        return this.node.ecmaToXMLString(getProcessor());
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object valueOf() {
        return this;
    }
}
