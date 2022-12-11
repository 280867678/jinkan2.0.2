package org.mozilla.javascript.xmlimpl;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;

/* loaded from: classes5.dex */
public class XMLList extends XMLObjectImpl implements Function {
    public static final long serialVersionUID = -4543618751670781135L;
    public XMLObjectImpl targetObject = null;
    public XmlNode.QName targetProperty = null;
    public XmlNode.InternalList _annos = new XmlNode.InternalList();

    public XMLList(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        super(xMLLibImpl, scriptable, xMLObject);
    }

    private Object applyOrCall(boolean z, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        String str = z ? "apply" : NotificationCompat.CATEGORY_CALL;
        if (!(scriptable2 instanceof XMLList) || ((XMLList) scriptable2).targetProperty == null) {
            throw ScriptRuntime.typeError1("msg.isnt.function", str);
        }
        return ScriptRuntime.applyOrCall(z, context, scriptable, scriptable2, objArr);
    }

    private XMLList getPropertyList(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        newXMLList.setTargets(this, (xMLName.isDescendants() || xMLName.isAttributeName()) ? null : xMLName.toQname());
        for (int i = 0; i < length(); i++) {
            newXMLList.addToList(getXmlFromAnnotation(i).getPropertyList(xMLName));
        }
        return newXMLList;
    }

    private XML getXML(XmlNode.InternalList internalList, int i) {
        if (i < 0 || i >= length()) {
            return null;
        }
        return xmlFromNode(internalList.item(i));
    }

    private XML getXmlFromAnnotation(int i) {
        return getXML(this._annos, i);
    }

    private void insert(int i, XML xml) {
        if (i < length()) {
            XmlNode.InternalList internalList = new XmlNode.InternalList();
            internalList.add(this._annos, 0, i);
            internalList.add(xml);
            internalList.add(this._annos, i, length());
            this._annos = internalList;
        }
    }

    private void internalRemoveFromList(int i) {
        this._annos.remove(i);
    }

    private void replaceNode(XML xml, XML xml2) {
        xml.replaceWith(xml2);
    }

    private void setAttribute(XMLName xMLName, Object obj) {
        for (int i = 0; i < length(); i++) {
            getXmlFromAnnotation(i).setAttribute(xMLName, obj);
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void addMatches(XMLList xMLList, XMLName xMLName) {
        for (int i = 0; i < length(); i++) {
            getXmlFromAnnotation(i).addMatches(xMLList, xMLName);
        }
    }

    public void addToList(Object obj) {
        this._annos.addToList(obj);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Scriptable scriptable3;
        XMLObject xMLObject;
        XmlNode.QName qName = this.targetProperty;
        if (qName != null) {
            String localName = qName.getLocalName();
            boolean equals = localName.equals("apply");
            if (equals || localName.equals(NotificationCompat.CATEGORY_CALL)) {
                return applyOrCall(equals, context, scriptable, scriptable2, objArr);
            }
            if (!(scriptable2 instanceof XMLObject)) {
                throw ScriptRuntime.typeError1("msg.incompat.call", localName);
            }
            Object obj2 = null;
            loop0: while (true) {
                obj = obj2;
                do {
                    scriptable3 = scriptable2;
                    while ((scriptable2 instanceof XMLObject) && (obj = (xMLObject = (XMLObject) scriptable2).getFunctionProperty(context, localName)) == Scriptable.NOT_FOUND) {
                        scriptable2 = xMLObject.getExtraMethodSource(context);
                        if (scriptable2 != null) {
                            break;
                        }
                    }
                } while (scriptable2 instanceof XMLObject);
                obj2 = ScriptableObject.getProperty(scriptable2, localName);
            }
            if (!(obj instanceof Callable)) {
                throw ScriptRuntime.notFunctionError(scriptable3, obj, localName);
            }
            return ((Callable) obj).call(context, scriptable, scriptable3, objArr);
        }
        throw ScriptRuntime.notFunctionError(this);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(int i) {
        XMLList newXMLList = newXMLList();
        for (int i2 = 0; i2 < length(); i2++) {
            newXMLList.addToList(getXmlFromAnnotation(i2).child(i));
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        for (int i = 0; i < length(); i++) {
            newXMLList.addToList(getXmlFromAnnotation(i).child(xMLName));
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList children() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length(); i++) {
            XML xmlFromAnnotation = getXmlFromAnnotation(i);
            if (xmlFromAnnotation != null) {
                XMLList children = xmlFromAnnotation.children();
                int length = children.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(children.item(i2));
                }
            }
        }
        XMLList newXMLList = newXMLList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            newXMLList.addToList(arrayList.get(i3));
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList comments() {
        XMLList newXMLList = newXMLList();
        for (int i = 0; i < length(); i++) {
            newXMLList.addToList(getXmlFromAnnotation(i).comments());
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        throw ScriptRuntime.typeError1("msg.not.ctor", "XMLList");
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean contains(Object obj) {
        for (int i = 0; i < length(); i++) {
            if (getXmlFromAnnotation(i).equivalentXml(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLObjectImpl copy() {
        XMLList newXMLList = newXMLList();
        for (int i = 0; i < length(); i++) {
            newXMLList.addToList(getXmlFromAnnotation(i).copy());
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i < 0 || i >= length()) {
            return;
        }
        getXmlFromAnnotation(i).remove();
        internalRemoveFromList(i);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void deleteXMLProperty(XMLName xMLName) {
        for (int i = 0; i < length(); i++) {
            XML xmlFromAnnotation = getXmlFromAnnotation(i);
            if (xmlFromAnnotation.isElement()) {
                xmlFromAnnotation.deleteXMLProperty(xMLName);
            }
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList elements(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        for (int i = 0; i < length(); i++) {
            newXMLList.addToList(getXmlFromAnnotation(i).elements(xMLName));
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean equivalentXml(Object obj) {
        if (!(obj instanceof Undefined) || length() != 0) {
            if (length() == 1) {
                return getXmlFromAnnotation(0).equivalentXml(obj);
            }
            if (obj instanceof XMLList) {
                XMLList xMLList = (XMLList) obj;
                if (xMLList.length() == length()) {
                    for (int i = 0; i < length(); i++) {
                        if (getXmlFromAnnotation(i).equivalentXml(xMLList.getXmlFromAnnotation(i))) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return (i < 0 || i >= length()) ? Scriptable.NOT_FOUND : getXmlFromAnnotation(i);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "XMLList";
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Scriptable getExtraMethodSource(Context context) {
        if (length() == 1) {
            return getXmlFromAnnotation(0);
        }
        return null;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        if (isPrototype()) {
            return new Object[0];
        }
        int length = length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = Integer.valueOf(i);
        }
        return objArr;
    }

    public Object[] getIdsForDebug() {
        return getIds();
    }

    public XmlNode.InternalList getNodeList() {
        return this._annos;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XML getXML() {
        if (length() == 1) {
            return getXmlFromAnnotation(0);
        }
        return null;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object getXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i >= 0 && i < length();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasComplexContent() {
        int length = length();
        if (length != 0) {
            if (length == 1) {
                return getXmlFromAnnotation(0).hasComplexContent();
            }
            for (int i = 0; i < length; i++) {
                if (getXmlFromAnnotation(i).isElement()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasOwnProperty(XMLName xMLName) {
        return isPrototype() ? findPrototypeId(xMLName.localName()) != 0 : getPropertyList(xMLName).length() > 0;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasSimpleContent() {
        if (length() == 0) {
            return true;
        }
        if (length() == 1) {
            return getXmlFromAnnotation(0).hasSimpleContent();
        }
        for (int i = 0; i < length(); i++) {
            if (getXmlFromAnnotation(i).isElement()) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName).length() > 0;
    }

    public XML item(int i) {
        return this._annos != null ? getXmlFromAnnotation(i) : createEmptyXML();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (objArr.length == 0) {
            return newXMLList();
        }
        Object obj = objArr[0];
        return (z || !(obj instanceof XMLList)) ? newXMLListFrom(obj) : obj;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public int length() {
        XmlNode.InternalList internalList = this._annos;
        if (internalList != null) {
            return internalList.length();
        }
        return 0;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void normalize() {
        for (int i = 0; i < length(); i++) {
            getXmlFromAnnotation(i).normalize();
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object parent() {
        if (length() == 0) {
            return Undefined.instance;
        }
        XML xml = null;
        for (int i = 0; i < length(); i++) {
            Object parent = getXmlFromAnnotation(i).parent();
            if (!(parent instanceof XML)) {
                return Undefined.instance;
            }
            XML xml2 = (XML) parent;
            if (i == 0) {
                xml = xml2;
            } else if (!xml.m12is(xml2)) {
                return Undefined.instance;
            }
        }
        return xml;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList processingInstructions(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        for (int i = 0; i < length(); i++) {
            newXMLList.addToList(getXmlFromAnnotation(i).processingInstructions(xMLName));
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean propertyIsEnumerable(Object obj) {
        long testUint32String;
        if (obj instanceof Integer) {
            testUint32String = ((Integer) obj).intValue();
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            long j = (long) doubleValue;
            if (j != doubleValue) {
                return false;
            }
            if (j == 0 && 1.0d / doubleValue < RoundRectDrawableWithShadow.COS_45) {
                return false;
            }
            testUint32String = j;
        } else {
            testUint32String = ScriptRuntime.testUint32String(ScriptRuntime.toString(obj));
        }
        return 0 <= testUint32String && testUint32String < ((long) length());
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        Object obj2;
        XMLObjectImpl xMLObjectImpl;
        Object obj3 = Undefined.instance;
        if (obj == null) {
            obj = "null";
        } else if (obj instanceof Undefined) {
            obj = "undefined";
        }
        if (obj instanceof XMLObject) {
            obj2 = (XMLObject) obj;
        } else if (this.targetProperty == null) {
            obj2 = newXMLFromJs(obj.toString());
        } else {
            XMLObjectImpl item = item(i);
            if (item == null) {
                XML item2 = item(0);
                item = item2 == null ? newTextElementXML(null, this.targetProperty, null) : item2.copy();
            }
            ((XML) item).setChildren(obj);
            obj2 = item;
        }
        Object parent = i < length() ? item(i).parent() : (length() != 0 || (xMLObjectImpl = this.targetObject) == null) ? parent() : xMLObjectImpl.getXML();
        if (!(parent instanceof XML)) {
            if (i >= length()) {
                addToList(obj2);
                return;
            }
            XML xml = getXML(this._annos, i);
            if (obj2 instanceof XML) {
                replaceNode(xml, (XML) obj2);
                replace(i, xml);
                return;
            } else if (!(obj2 instanceof XMLList)) {
                return;
            } else {
                XMLList xMLList = (XMLList) obj2;
                if (xMLList.length() <= 0) {
                    return;
                }
                replaceNode(xml, xMLList.item(0));
                replace(i, xMLList.item(0));
                for (int i2 = 1; i2 < xMLList.length(); i2++) {
                    insert(i + i2, xMLList.item(i2));
                }
                return;
            }
        }
        XML xml2 = (XML) parent;
        if (i >= length()) {
            xml2.appendChild(obj2);
            addToList(xml2.getLastXmlChild());
            return;
        }
        XML xmlFromAnnotation = getXmlFromAnnotation(i);
        if (obj2 instanceof XML) {
            replaceNode(xmlFromAnnotation, (XML) obj2);
            replace(i, xmlFromAnnotation);
        } else if (obj2 instanceof XMLList) {
            XMLList xMLList2 = (XMLList) obj2;
            if (xMLList2.length() <= 0) {
                return;
            }
            int childIndex = xmlFromAnnotation.childIndex();
            replaceNode(xmlFromAnnotation, xMLList2.item(0));
            replace(i, xMLList2.item(0));
            for (int i3 = 1; i3 < xMLList2.length(); i3++) {
                xml2.insertChildAfter(xml2.getXmlChild(childIndex), xMLList2.item(i3));
                childIndex++;
                insert(i + i3, xMLList2.item(i3));
            }
        }
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void putXMLProperty(XMLName xMLName, Object obj) {
        XML item;
        XmlNode.QName qName;
        if (obj == null) {
            obj = "null";
        } else if (obj instanceof Undefined) {
            obj = "undefined";
        }
        if (length() <= 1) {
            if (length() == 0) {
                if (this.targetObject == null || (qName = this.targetProperty) == null || qName.getLocalName() == null || this.targetProperty.getLocalName().length() <= 0) {
                    throw ScriptRuntime.typeError("Assignment to empty XMLList without targets not supported");
                }
                addToList(newTextElementXML(null, this.targetProperty, null));
                if (xMLName.isAttributeName()) {
                    setAttribute(xMLName, obj);
                } else {
                    item(0).putXMLProperty(xMLName, obj);
                    replace(0, item(0));
                }
                this.targetObject.putXMLProperty(XMLName.formProperty(this.targetProperty.getNamespace().getUri(), this.targetProperty.getLocalName()), this);
                item = this.targetObject.getXML().getLastXmlChild();
            } else if (xMLName.isAttributeName()) {
                setAttribute(xMLName, obj);
                return;
            } else {
                item(0).putXMLProperty(xMLName, obj);
                item = item(0);
            }
            replace(0, item);
            return;
        }
        throw ScriptRuntime.typeError("Assignment to lists with more than one item is not supported");
    }

    public void remove() {
        for (int length = length() - 1; length >= 0; length--) {
            XML xmlFromAnnotation = getXmlFromAnnotation(length);
            if (xmlFromAnnotation != null) {
                xmlFromAnnotation.remove();
                internalRemoveFromList(length);
            }
        }
    }

    public void replace(int i, XML xml) {
        if (i < length()) {
            XmlNode.InternalList internalList = new XmlNode.InternalList();
            internalList.add(this._annos, 0, i);
            internalList.add(xml);
            internalList.add(this._annos, i + 1, length());
            this._annos = internalList;
        }
    }

    public void setTargets(XMLObjectImpl xMLObjectImpl, XmlNode.QName qName) {
        this.targetObject = xMLObjectImpl;
        this.targetProperty = qName;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList text() {
        XMLList newXMLList = newXMLList();
        for (int i = 0; i < length(); i++) {
            newXMLList.addToList(getXmlFromAnnotation(i).text());
        }
        return newXMLList;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toSource(int i) {
        return toXMLString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toString() {
        if (hasSimpleContent()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length(); i++) {
                XML xmlFromAnnotation = getXmlFromAnnotation(i);
                if (!xmlFromAnnotation.isComment() && !xmlFromAnnotation.isProcessingInstruction()) {
                    sb.append(xmlFromAnnotation.toString());
                }
            }
            return sb.toString();
        }
        return toXMLString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toXMLString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            if (getProcessor().isPrettyPrinting() && i != 0) {
                sb.append('\n');
            }
            sb.append(getXmlFromAnnotation(i).toXMLString());
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object valueOf() {
        return this;
    }
}
