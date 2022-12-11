package org.mozilla.javascript.xml;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public abstract class XMLLib {
    public static final Object XML_LIB_KEY = new Object();

    /* loaded from: classes5.dex */
    public static abstract class Factory {
        public static Factory create(final String str) {
            return new Factory() { // from class: org.mozilla.javascript.xml.XMLLib.Factory.1
                @Override // org.mozilla.javascript.xml.XMLLib.Factory
                public String getImplementationClassName() {
                    return str;
                }
            };
        }

        public abstract String getImplementationClassName();
    }

    public static XMLLib extractFromScope(Scriptable scriptable) {
        XMLLib extractFromScopeOrNull = extractFromScopeOrNull(scriptable);
        if (extractFromScopeOrNull != null) {
            return extractFromScopeOrNull;
        }
        throw Context.reportRuntimeError(ScriptRuntime.getMessage0("msg.XML.not.available"));
    }

    public static XMLLib extractFromScopeOrNull(Scriptable scriptable) {
        ScriptableObject libraryScopeOrNull = ScriptRuntime.getLibraryScopeOrNull(scriptable);
        if (libraryScopeOrNull == null) {
            return null;
        }
        ScriptableObject.getProperty(libraryScopeOrNull, "XML");
        return (XMLLib) libraryScopeOrNull.getAssociatedValue(XML_LIB_KEY);
    }

    public final XMLLib bindToScope(Scriptable scriptable) {
        ScriptableObject libraryScopeOrNull = ScriptRuntime.getLibraryScopeOrNull(scriptable);
        if (libraryScopeOrNull != null) {
            return (XMLLib) libraryScopeOrNull.associateValue(XML_LIB_KEY, this);
        }
        throw new IllegalStateException();
    }

    public abstract String escapeAttributeValue(Object obj);

    public abstract String escapeTextValue(Object obj);

    public int getPrettyIndent() {
        throw new UnsupportedOperationException();
    }

    public boolean isIgnoreComments() {
        throw new UnsupportedOperationException();
    }

    public boolean isIgnoreProcessingInstructions() {
        throw new UnsupportedOperationException();
    }

    public boolean isIgnoreWhitespace() {
        throw new UnsupportedOperationException();
    }

    public boolean isPrettyPrinting() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isXMLName(Context context, Object obj);

    public abstract Ref nameRef(Context context, Object obj, Object obj2, Scriptable scriptable, int i);

    public abstract Ref nameRef(Context context, Object obj, Scriptable scriptable, int i);

    public void setIgnoreComments(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setIgnoreProcessingInstructions(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setIgnoreWhitespace(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setPrettyIndent(int i) {
        throw new UnsupportedOperationException();
    }

    public void setPrettyPrinting(boolean z) {
        throw new UnsupportedOperationException();
    }

    public abstract Object toDefaultXmlNamespace(Context context, Object obj);
}
