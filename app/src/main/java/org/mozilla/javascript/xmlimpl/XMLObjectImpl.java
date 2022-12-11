package org.mozilla.javascript.xmlimpl;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeWith;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.simpleframework.xml.core.AnnotationHandler;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public abstract class XMLObjectImpl extends XMLObject {
    public static final int Id_addNamespace = 2;
    public static final int Id_appendChild = 3;
    public static final int Id_attribute = 4;
    public static final int Id_attributes = 5;
    public static final int Id_child = 6;
    public static final int Id_childIndex = 7;
    public static final int Id_children = 8;
    public static final int Id_comments = 9;
    public static final int Id_constructor = 1;
    public static final int Id_contains = 10;
    public static final int Id_copy = 11;
    public static final int Id_descendants = 12;
    public static final int Id_elements = 13;
    public static final int Id_hasComplexContent = 18;
    public static final int Id_hasOwnProperty = 17;
    public static final int Id_hasSimpleContent = 19;
    public static final int Id_inScopeNamespaces = 14;
    public static final int Id_insertChildAfter = 15;
    public static final int Id_insertChildBefore = 16;
    public static final int Id_length = 20;
    public static final int Id_localName = 21;
    public static final int Id_name = 22;
    public static final int Id_namespace = 23;
    public static final int Id_namespaceDeclarations = 24;
    public static final int Id_nodeKind = 25;
    public static final int Id_normalize = 26;
    public static final int Id_parent = 27;
    public static final int Id_prependChild = 28;
    public static final int Id_processingInstructions = 29;
    public static final int Id_propertyIsEnumerable = 30;
    public static final int Id_removeNamespace = 31;
    public static final int Id_replace = 32;
    public static final int Id_setChildren = 33;
    public static final int Id_setLocalName = 34;
    public static final int Id_setName = 35;
    public static final int Id_setNamespace = 36;
    public static final int Id_text = 37;
    public static final int Id_toSource = 39;
    public static final int Id_toString = 38;
    public static final int Id_toXMLString = 40;
    public static final int Id_valueOf = 41;
    public static final int MAX_PROTOTYPE_ID = 41;
    public static final Object XMLOBJECT_TAG = "XMLObject";
    public XMLLibImpl lib;
    public boolean prototypeFlag;

    public XMLObjectImpl(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        initialize(xMLLibImpl, scriptable, xMLObject);
    }

    public static Object arg(Object[] objArr, int i) {
        return i < objArr.length ? objArr[i] : Undefined.instance;
    }

    private XMLList getMatches(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        addMatches(newXMLList, xMLName);
        return newXMLList;
    }

    private Object[] toObjectArray(Object[] objArr) {
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr2[i] = objArr[i];
        }
        return objArr2;
    }

    private void xmlMethodNotFound(Object obj, String str) {
        throw ScriptRuntime.notFunctionError(obj, str);
    }

    public abstract void addMatches(XMLList xMLList, XMLName xMLName);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.mozilla.javascript.xml.XMLObject] */
    @Override // org.mozilla.javascript.xml.XMLObject
    public final Object addValues(Context context, boolean z, Object obj) {
        XMLObjectImpl xMLObjectImpl;
        XMLObjectImpl xMLObjectImpl2;
        if (!(obj instanceof XMLObject)) {
            return obj == Undefined.instance ? ScriptRuntime.toString(this) : super.addValues(context, z, obj);
        }
        ?? r4 = (XMLObject) obj;
        if (z) {
            xMLObjectImpl = r4;
            xMLObjectImpl2 = this;
        } else {
            xMLObjectImpl = this;
            xMLObjectImpl2 = r4;
        }
        return this.lib.addXMLObjects(context, xMLObjectImpl2, xMLObjectImpl);
    }

    public abstract XMLList child(int i);

    public abstract XMLList child(XMLName xMLName);

    public abstract XMLList children();

    public abstract XMLList comments();

    public abstract boolean contains(Object obj);

    public abstract XMLObjectImpl copy();

    public final XML createEmptyXML() {
        return newXML(XmlNode.createEmpty(getProcessor()));
    }

    public final Namespace createNamespace(XmlNode.Namespace namespace) {
        if (namespace == null) {
            return null;
        }
        return this.lib.createNamespaces(new XmlNode.Namespace[]{namespace})[0];
    }

    public final Namespace[] createNamespaces(XmlNode.Namespace[] namespaceArr) {
        return this.lib.createNamespaces(namespaceArr);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(String str) {
        deleteXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final boolean delete(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            delete((int) ScriptRuntime.lastUint32Result(context));
            return true;
        }
        deleteXMLProperty(xMLNameOrIndex);
        return true;
    }

    public abstract void deleteXMLProperty(XMLName xMLName);

    public final String ecmaEscapeAttributeValue(String str) {
        String escapeAttributeValue = this.lib.escapeAttributeValue(str);
        return escapeAttributeValue.substring(1, escapeAttributeValue.length() - 1);
    }

    public final XML ecmaToXml(Object obj) {
        return this.lib.ecmaToXml(obj);
    }

    public abstract XMLList elements(XMLName xMLName);

    @Override // org.mozilla.javascript.xml.XMLObject
    public NativeWith enterDotQuery(Scriptable scriptable) {
        XMLWithScope xMLWithScope = new XMLWithScope(this.lib, scriptable, this);
        xMLWithScope.initAsDotQuery();
        return xMLWithScope;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public NativeWith enterWith(Scriptable scriptable) {
        return new XMLWithScope(this.lib, scriptable, this);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public final Object equivalentValues(Object obj) {
        return equivalentXml(obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    public abstract boolean equivalentXml(Object obj);

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(XMLOBJECT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        boolean z = true;
        if (methodId == 1) {
            if (scriptable2 != null) {
                z = false;
            }
            return jsConstructor(context, z, objArr);
        } else if (!(scriptable2 instanceof XMLObjectImpl)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        } else {
            XMLObjectImpl xMLObjectImpl = (XMLObjectImpl) scriptable2;
            XML xml = xMLObjectImpl.getXML();
            String str = null;
            switch (methodId) {
                case 2:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "addNamespace");
                    }
                    return xml.addNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                case 3:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "appendChild");
                    }
                    return xml.appendChild(arg(objArr, 0));
                case 4:
                    return xMLObjectImpl.getMatches(XMLName.create(this.lib.toNodeQName(context, arg(objArr, 0), true), true, false));
                case 5:
                    return xMLObjectImpl.getMatches(XMLName.create(XmlNode.QName.create(null, null), true, false));
                case 6:
                    XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                    return xMLNameOrIndex == null ? xMLObjectImpl.child((int) ScriptRuntime.lastUint32Result(context)) : xMLObjectImpl.child(xMLNameOrIndex);
                case 7:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "childIndex");
                    }
                    return ScriptRuntime.wrapInt(xml.childIndex());
                case 8:
                    return xMLObjectImpl.children();
                case 9:
                    return xMLObjectImpl.comments();
                case 10:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.contains(arg(objArr, 0)));
                case 11:
                    return xMLObjectImpl.copy();
                case 12:
                    return xMLObjectImpl.getMatches(XMLName.create(objArr.length == 0 ? XmlNode.QName.create(null, null) : this.lib.toNodeQName(context, objArr[0], false), false, true));
                case 13:
                    return xMLObjectImpl.elements(objArr.length == 0 ? XMLName.formStar() : this.lib.toXMLName(context, objArr[0]));
                case 14:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "inScopeNamespaces");
                    }
                    return context.newArray(scriptable, toObjectArray(xml.inScopeNamespaces()));
                case 15:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "insertChildAfter");
                    }
                    Object arg = arg(objArr, 0);
                    return (arg == null || (arg instanceof XML)) ? xml.insertChildAfter((XML) arg, arg(objArr, 1)) : Undefined.instance;
                case 16:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "insertChildBefore");
                    }
                    Object arg2 = arg(objArr, 0);
                    return (arg2 == null || (arg2 instanceof XML)) ? xml.insertChildBefore((XML) arg2, arg(objArr, 1)) : Undefined.instance;
                case 17:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasOwnProperty(this.lib.toXMLName(context, arg(objArr, 0))));
                case 18:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasComplexContent());
                case 19:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasSimpleContent());
                case 20:
                    return ScriptRuntime.wrapInt(xMLObjectImpl.length());
                case 21:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "localName");
                    }
                    return xml.localName();
                case 22:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "name");
                    }
                    return xml.name();
                case 23:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "namespace");
                    }
                    if (objArr.length > 0) {
                        str = ScriptRuntime.toString(objArr[0]);
                    }
                    Namespace namespace = xml.namespace(str);
                    return namespace == null ? Undefined.instance : namespace;
                case 24:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "namespaceDeclarations");
                    }
                    return context.newArray(scriptable, toObjectArray(xml.namespaceDeclarations()));
                case 25:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "nodeKind");
                    }
                    return xml.nodeKind();
                case 26:
                    xMLObjectImpl.normalize();
                    return Undefined.instance;
                case 27:
                    return xMLObjectImpl.parent();
                case 28:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "prependChild");
                    }
                    return xml.prependChild(arg(objArr, 0));
                case 29:
                    return xMLObjectImpl.processingInstructions(objArr.length > 0 ? this.lib.toXMLName(context, objArr[0]) : XMLName.formStar());
                case 30:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.propertyIsEnumerable(arg(objArr, 0)));
                case 31:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "removeNamespace");
                    }
                    return xml.removeNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                case 32:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "replace");
                    }
                    XMLName xMLNameOrIndex2 = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                    Object arg3 = arg(objArr, 1);
                    return xMLNameOrIndex2 == null ? xml.replace((int) ScriptRuntime.lastUint32Result(context), arg3) : xml.replace(xMLNameOrIndex2, arg3);
                case 33:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setChildren");
                    }
                    return xml.setChildren(arg(objArr, 0));
                case 34:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setLocalName");
                    }
                    Object arg4 = arg(objArr, 0);
                    xml.setLocalName(arg4 instanceof QName ? ((QName) arg4).localName() : ScriptRuntime.toString(arg4));
                    return Undefined.instance;
                case 35:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setName");
                    }
                    xml.setName(this.lib.constructQName(context, objArr.length != 0 ? objArr[0] : Undefined.instance));
                    return Undefined.instance;
                case 36:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setNamespace");
                    }
                    xml.setNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                    return Undefined.instance;
                case 37:
                    return xMLObjectImpl.text();
                case 38:
                    return xMLObjectImpl.toString();
                case 39:
                    return xMLObjectImpl.toSource(ScriptRuntime.toInt32(objArr, 0));
                case 40:
                    return xMLObjectImpl.toXMLString();
                case 41:
                    return xMLObjectImpl.valueOf();
                default:
                    throw new IllegalArgumentException(String.valueOf(methodId));
            }
        }
    }

    public final void exportAsJSClass(boolean z) {
        this.prototypeFlag = true;
        exportAsJSClass(41, getParentScope(), z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        switch (str.length()) {
            case 4:
                char charAt = str.charAt(0);
                if (charAt != 'c') {
                    if (charAt != 'n') {
                        if (charAt == 't') {
                            i = 37;
                            str2 = "text";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 22;
                        str2 = "name";
                        break;
                    }
                } else {
                    i = 11;
                    str2 = "copy";
                    break;
                }
            case 5:
                i = 6;
                str2 = "child";
                break;
            case 6:
                char charAt2 = str.charAt(0);
                if (charAt2 != 'l') {
                    if (charAt2 == 'p') {
                        i = 27;
                        str2 = "parent";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 20;
                    str2 = Name.LENGTH;
                    break;
                }
            case 7:
                char charAt3 = str.charAt(0);
                if (charAt3 != 'r') {
                    if (charAt3 != 's') {
                        if (charAt3 == 'v') {
                            i = 41;
                            str2 = "valueOf";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 35;
                        str2 = "setName";
                        break;
                    }
                } else {
                    i = 32;
                    str2 = "replace";
                    break;
                }
            case 8:
                char charAt4 = str.charAt(2);
                if (charAt4 == 'S') {
                    char charAt5 = str.charAt(7);
                    if (charAt5 == 'e') {
                        i = 39;
                        str2 = "toSource";
                        break;
                    } else {
                        if (charAt5 == 'g') {
                            i = 38;
                            str2 = AnnotationHandler.STRING;
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt4 == 'i') {
                    i = 8;
                    str2 = "children";
                    break;
                } else if (charAt4 == 'd') {
                    i = 25;
                    str2 = "nodeKind";
                    break;
                } else if (charAt4 == 'e') {
                    i = 13;
                    str2 = "elements";
                    break;
                } else if (charAt4 == 'm') {
                    i = 9;
                    str2 = "comments";
                    break;
                } else {
                    if (charAt4 == 'n') {
                        i = 10;
                        str2 = "contains";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 9:
                char charAt6 = str.charAt(2);
                if (charAt6 == 'c') {
                    i = 21;
                    str2 = "localName";
                    break;
                } else if (charAt6 == 'm') {
                    i = 23;
                    str2 = "namespace";
                    break;
                } else if (charAt6 == 'r') {
                    i = 26;
                    str2 = "normalize";
                    break;
                } else {
                    if (charAt6 == 't') {
                        i = 4;
                        str2 = AnnotationHandler.ATTRIBUTE;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 10:
                char charAt7 = str.charAt(0);
                if (charAt7 != 'a') {
                    if (charAt7 == 'c') {
                        str2 = "childIndex";
                        i = 7;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 5;
                    str2 = "attributes";
                    break;
                }
            case 11:
                char charAt8 = str.charAt(0);
                if (charAt8 == 'a') {
                    str2 = "appendChild";
                    i = 3;
                    break;
                } else if (charAt8 == 'c') {
                    i = 1;
                    str2 = "constructor";
                    break;
                } else if (charAt8 == 'd') {
                    i = 12;
                    str2 = "descendants";
                    break;
                } else if (charAt8 == 's') {
                    i = 33;
                    str2 = "setChildren";
                    break;
                } else {
                    if (charAt8 == 't') {
                        i = 40;
                        str2 = "toXMLString";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 12:
                char charAt9 = str.charAt(0);
                if (charAt9 != 'a') {
                    if (charAt9 != 'p') {
                        if (charAt9 == 's') {
                            char charAt10 = str.charAt(3);
                            if (charAt10 != 'L') {
                                if (charAt10 == 'N') {
                                    i = 36;
                                    str2 = "setNamespace";
                                    break;
                                }
                            } else {
                                i = 34;
                                str2 = "setLocalName";
                                break;
                            }
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 28;
                        str2 = "prependChild";
                        break;
                    }
                } else {
                    str2 = "addNamespace";
                    i = 2;
                    break;
                }
            case 13:
            case 18:
            case 19:
            default:
                str2 = null;
                i = 0;
                break;
            case 14:
                i = 17;
                str2 = "hasOwnProperty";
                break;
            case 15:
                i = 31;
                str2 = "removeNamespace";
                break;
            case 16:
                char charAt11 = str.charAt(0);
                if (charAt11 != 'h') {
                    if (charAt11 == 'i') {
                        i = 15;
                        str2 = "insertChildAfter";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 19;
                    str2 = "hasSimpleContent";
                    break;
                }
            case 17:
                char charAt12 = str.charAt(3);
                if (charAt12 != 'C') {
                    if (charAt12 != 'c') {
                        if (charAt12 == 'e') {
                            i = 16;
                            str2 = "insertChildBefore";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 14;
                        str2 = "inScopeNamespaces";
                        break;
                    }
                } else {
                    i = 18;
                    str2 = "hasComplexContent";
                    break;
                }
            case 20:
                i = 30;
                str2 = "propertyIsEnumerable";
                break;
            case 21:
                i = 24;
                str2 = "namespaceDeclarations";
                break;
            case 22:
                i = 29;
                str2 = "processingInstructions";
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return getXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final Object get(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            Object obj2 = get((int) ScriptRuntime.lastUint32Result(context), this);
            return obj2 == Scriptable.NOT_FOUND ? Undefined.instance : obj2;
        }
        return getXMLProperty(xMLNameOrIndex);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final Object getDefaultValue(Class<?> cls) {
        return toString();
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Object getFunctionProperty(Context context, int i) {
        if (isPrototype()) {
            return super.get(i, this);
        }
        Scriptable prototype = getPrototype();
        return prototype instanceof XMLObject ? ((XMLObject) prototype).getFunctionProperty(context, i) : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Object getFunctionProperty(Context context, String str) {
        if (isPrototype()) {
            return super.get(str, this);
        }
        Scriptable prototype = getPrototype();
        return prototype instanceof XMLObject ? ((XMLObject) prototype).getFunctionProperty(context, str) : Scriptable.NOT_FOUND;
    }

    public XMLLibImpl getLib() {
        return this.lib;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final Scriptable getParentScope() {
        return super.getParentScope();
    }

    public final XmlProcessor getProcessor() {
        return this.lib.getProcessor();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final Scriptable getPrototype() {
        return super.getPrototype();
    }

    public abstract XML getXML();

    public abstract Object getXMLProperty(XMLName xMLName);

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return hasXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final boolean has(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        return xMLNameOrIndex == null ? has((int) ScriptRuntime.lastUint32Result(context), this) : hasXMLProperty(xMLNameOrIndex);
    }

    public abstract boolean hasComplexContent();

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final boolean hasInstance(Scriptable scriptable) {
        return super.hasInstance(scriptable);
    }

    public abstract boolean hasOwnProperty(XMLName xMLName);

    public abstract boolean hasSimpleContent();

    public abstract boolean hasXMLProperty(XMLName xMLName);

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                initPrototypeConstructor(this instanceof XML ? new XMLCtor((XML) this, XMLOBJECT_TAG, i, 1) : new IdFunctionObject(this, XMLOBJECT_TAG, i, 1));
                return;
            case 2:
                str = "addNamespace";
                break;
            case 3:
                str = "appendChild";
                break;
            case 4:
                str = AnnotationHandler.ATTRIBUTE;
                break;
            case 5:
                str = "attributes";
                i2 = 0;
                break;
            case 6:
                str = "child";
                break;
            case 7:
                str = "childIndex";
                i2 = 0;
                break;
            case 8:
                str = "children";
                i2 = 0;
                break;
            case 9:
                str = "comments";
                i2 = 0;
                break;
            case 10:
                str = "contains";
                break;
            case 11:
                str = "copy";
                i2 = 0;
                break;
            case 12:
                str = "descendants";
                break;
            case 13:
                str = "elements";
                break;
            case 14:
                str = "inScopeNamespaces";
                i2 = 0;
                break;
            case 15:
                str2 = "insertChildAfter";
                str = str2;
                i2 = 2;
                break;
            case 16:
                str2 = "insertChildBefore";
                str = str2;
                i2 = 2;
                break;
            case 17:
                str = "hasOwnProperty";
                break;
            case 18:
                str = "hasComplexContent";
                i2 = 0;
                break;
            case 19:
                str = "hasSimpleContent";
                i2 = 0;
                break;
            case 20:
                str = Name.LENGTH;
                i2 = 0;
                break;
            case 21:
                str = "localName";
                i2 = 0;
                break;
            case 22:
                str = "name";
                i2 = 0;
                break;
            case 23:
                str = "namespace";
                break;
            case 24:
                str = "namespaceDeclarations";
                i2 = 0;
                break;
            case 25:
                str = "nodeKind";
                i2 = 0;
                break;
            case 26:
                str = "normalize";
                i2 = 0;
                break;
            case 27:
                str = "parent";
                i2 = 0;
                break;
            case 28:
                str = "prependChild";
                break;
            case 29:
                str = "processingInstructions";
                break;
            case 30:
                str = "propertyIsEnumerable";
                break;
            case 31:
                str = "removeNamespace";
                break;
            case 32:
                str2 = "replace";
                str = str2;
                i2 = 2;
                break;
            case 33:
                str = "setChildren";
                break;
            case 34:
                str = "setLocalName";
                break;
            case 35:
                str = "setName";
                break;
            case 36:
                str = "setNamespace";
                break;
            case 37:
                str = "text";
                i2 = 0;
                break;
            case 38:
                str = AnnotationHandler.STRING;
                i2 = 0;
                break;
            case 39:
                str = "toSource";
                break;
            case 40:
                str = "toXMLString";
                break;
            case 41:
                str = "valueOf";
                i2 = 0;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
    }

    public final void initialize(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        setParentScope(scriptable);
        setPrototype(xMLObject);
        this.prototypeFlag = xMLObject == null;
        this.lib = xMLLibImpl;
    }

    public final boolean isPrototype() {
        return this.prototypeFlag;
    }

    public abstract Object jsConstructor(Context context, boolean z, Object[] objArr);

    public abstract int length();

    @Override // org.mozilla.javascript.xml.XMLObject
    public Ref memberRef(Context context, Object obj, int i) {
        boolean z = true;
        boolean z2 = (i & 2) != 0;
        if ((i & 4) == 0) {
            z = false;
        }
        if (z2 || z) {
            XMLName create = XMLName.create(this.lib.toNodeQName(context, obj, z2), z2, z);
            create.initXMLObject(this);
            return create;
        }
        throw Kit.codeBug();
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Ref memberRef(Context context, Object obj, Object obj2, int i) {
        boolean z = true;
        boolean z2 = (i & 2) != 0;
        if ((i & 4) == 0) {
            z = false;
        }
        XMLName create = XMLName.create(this.lib.toNodeQName(context, obj, obj2), z2, z);
        create.initXMLObject(this);
        return create;
    }

    public final QName newQName(String str, String str2, String str3) {
        return this.lib.newQName(str, str2, str3);
    }

    public final QName newQName(XmlNode.QName qName) {
        return this.lib.newQName(qName);
    }

    public final XML newTextElementXML(XmlNode xmlNode, XmlNode.QName qName, String str) {
        return this.lib.newTextElementXML(xmlNode, qName, str);
    }

    public final XML newXML(XmlNode xmlNode) {
        return this.lib.newXML(xmlNode);
    }

    public final XML newXMLFromJs(Object obj) {
        return this.lib.newXMLFromJs(obj);
    }

    public final XMLList newXMLList() {
        return this.lib.newXMLList();
    }

    public final XMLList newXMLListFrom(Object obj) {
        return this.lib.newXMLListFrom(obj);
    }

    public abstract void normalize();

    public abstract Object parent();

    public abstract XMLList processingInstructions(XMLName xMLName);

    public abstract boolean propertyIsEnumerable(Object obj);

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        putXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str), obj);
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final void put(Context context, Object obj, Object obj2) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            put((int) ScriptRuntime.lastUint32Result(context), this, obj2);
        } else {
            putXMLProperty(xMLNameOrIndex, obj2);
        }
    }

    public abstract void putXMLProperty(XMLName xMLName, Object obj);

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final void setParentScope(Scriptable scriptable) {
        super.setParentScope(scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final void setPrototype(Scriptable scriptable) {
        super.setPrototype(scriptable);
    }

    public abstract XMLList text();

    public abstract String toSource(int i);

    public abstract String toString();

    public abstract String toXMLString();

    public abstract Object valueOf();

    public XML xmlFromNode(XmlNode xmlNode) {
        if (xmlNode.getXml() == null) {
            xmlNode.setXml(newXML(xmlNode));
        }
        return xmlNode.getXml();
    }
}
