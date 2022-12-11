package org.mozilla.javascript.xmlimpl;

import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public final class QName extends IdScriptableObject {
    public static final int Id_constructor = 1;
    public static final int Id_localName = 1;
    public static final int Id_toSource = 3;
    public static final int Id_toString = 2;
    public static final int Id_uri = 2;
    public static final int MAX_INSTANCE_ID = 2;
    public static final int MAX_PROTOTYPE_ID = 3;
    public static final Object QNAME_TAG = "QName";
    public static final long serialVersionUID = 416745167693026750L;
    public XmlNode.QName delegate;
    public XMLLibImpl lib;
    public QName prototype;

    public static QName create(XMLLibImpl xMLLibImpl, Scriptable scriptable, QName qName, XmlNode.QName qName2) {
        QName qName3 = new QName();
        qName3.lib = xMLLibImpl;
        qName3.setParentScope(scriptable);
        qName3.prototype = qName;
        qName3.setPrototype(qName);
        qName3.delegate = qName2;
        return qName3;
    }

    private boolean equals(QName qName) {
        return this.delegate.equals(qName.delegate);
    }

    private Object jsConstructor(Context context, boolean z, Object[] objArr) {
        return (z || objArr.length != 1) ? objArr.length == 0 ? constructQName(this.lib, context, Undefined.instance) : objArr.length == 1 ? constructQName(this.lib, context, objArr[0]) : constructQName(this.lib, context, objArr[0], objArr[1]) : castToQName(this.lib, context, objArr[0]);
    }

    private String js_toSource() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(');
        toSourceImpl(uri(), localName(), prefix(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    private QName realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof QName) {
            return (QName) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    public static void toSourceImpl(String str, String str2, String str3, StringBuilder sb) {
        String str4;
        sb.append("new QName(");
        if (str == null && str3 == null) {
            if (!"*".equals(str2)) {
                str4 = "null, ";
            }
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(ScriptRuntime.escapeString(str2, ExtendedMessageFormat.QUOTE));
            sb.append("')");
        }
        Namespace.toSourceImpl(str3, str, sb);
        str4 = ", ";
        sb.append(str4);
        sb.append(ExtendedMessageFormat.QUOTE);
        sb.append(ScriptRuntime.escapeString(str2, ExtendedMessageFormat.QUOTE));
        sb.append("')");
    }

    public QName castToQName(XMLLibImpl xMLLibImpl, Context context, Object obj) {
        return obj instanceof QName ? (QName) obj : constructQName(xMLLibImpl, context, obj);
    }

    public QName constructQName(XMLLibImpl xMLLibImpl, Context context, Object obj) {
        return constructQName(xMLLibImpl, context, Undefined.instance, obj);
    }

    public QName constructQName(XMLLibImpl xMLLibImpl, Context context, Object obj, Object obj2) {
        String prefix;
        if (obj2 instanceof QName) {
            if (obj == Undefined.instance) {
                return (QName) obj2;
            }
            ((QName) obj2).localName();
        }
        String scriptRuntime = obj2 == Undefined.instance ? "" : ScriptRuntime.toString(obj2);
        String str = null;
        if (obj == Undefined.instance) {
            obj = "*".equals(scriptRuntime) ? null : xMLLibImpl.getDefaultNamespace(context);
        }
        Namespace newNamespace = obj == null ? null : obj instanceof Namespace ? (Namespace) obj : xMLLibImpl.newNamespace(ScriptRuntime.toString(obj));
        if (obj == null) {
            prefix = null;
        } else {
            str = newNamespace.uri();
            prefix = newNamespace.prefix();
        }
        return newQName(xMLLibImpl, str, scriptRuntime, prefix);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof QName)) {
            return false;
        }
        return equals((QName) obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public Object equivalentValues(Object obj) {
        return !(obj instanceof QName) ? Scriptable.NOT_FOUND : equals((QName) obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(QNAME_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        boolean z = true;
        if (methodId == 1) {
            if (scriptable2 != null) {
                z = false;
            }
            return jsConstructor(context, z, objArr);
        } else if (methodId == 2) {
            return realThis(scriptable2, idFunctionObject).toString();
        } else {
            if (methodId != 3) {
                throw new IllegalArgumentException(String.valueOf(methodId));
            }
            return realThis(scriptable2, idFunctionObject).js_toSource();
        }
    }

    public void exportAsJSClass(boolean z) {
        exportAsJSClass(3, getParentScope(), z);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        int i2 = 0;
        if (length == 3) {
            str2 = "uri";
            i = 2;
        } else if (length == 9) {
            str2 = "localName";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i2 = i;
        }
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException();
        }
        return IdScriptableObject.instanceIdInfo(5, super.getMaxInstanceId() + i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 8) {
            char charAt = str.charAt(3);
            if (charAt == 'o') {
                str2 = "toSource";
            } else {
                if (charAt == 't') {
                    i = 2;
                    str2 = AnnotationHandler.STRING;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                i = 1;
                str2 = "constructor";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "QName";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return toString();
    }

    public final XmlNode.QName getDelegate() {
        return this.delegate;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        return maxInstanceId != 1 ? maxInstanceId != 2 ? super.getInstanceIdName(i) : "uri" : "localName";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        return maxInstanceId != 1 ? maxInstanceId != 2 ? super.getInstanceIdValue(i) : uri() : localName();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return super.getMaxInstanceId() + 2;
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2 = 0;
        if (i == 1) {
            str = "constructor";
            i2 = 2;
        } else if (i == 2) {
            str = AnnotationHandler.STRING;
        } else if (i != 3) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            str = "toSource";
        }
        initPrototypeMethod(QNAME_TAG, i, str, i2);
    }

    public String localName() {
        return this.delegate.getLocalName() == null ? "*" : this.delegate.getLocalName();
    }

    public QName newQName(XMLLibImpl xMLLibImpl, String str, String str2, String str3) {
        QName qName = this.prototype;
        if (qName == null) {
            qName = this;
        }
        XmlNode.Namespace create = str3 != null ? XmlNode.Namespace.create(str3, str) : str != null ? XmlNode.Namespace.create(str) : null;
        if (str2 != null && str2.equals("*")) {
            str2 = null;
        }
        return create(xMLLibImpl, getParentScope(), qName, XmlNode.QName.create(create, str2));
    }

    public String prefix() {
        if (this.delegate.getNamespace() == null) {
            return null;
        }
        return this.delegate.getNamespace().getPrefix();
    }

    @Deprecated
    public final XmlNode.QName toNodeQname() {
        return this.delegate;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (this.delegate.getNamespace() == null) {
            sb = new StringBuilder();
            str = "*::";
        } else if (this.delegate.getNamespace().isGlobal()) {
            return localName();
        } else {
            sb = new StringBuilder();
            sb.append(uri());
            str = "::";
        }
        sb.append(str);
        sb.append(localName());
        return sb.toString();
    }

    public String uri() {
        if (this.delegate.getNamespace() == null) {
            return null;
        }
        return this.delegate.getNamespace().getUri();
    }
}
