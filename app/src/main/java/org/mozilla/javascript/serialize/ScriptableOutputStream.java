package org.mozilla.javascript.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import me.tvspark.outline;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.UniqueTag;

/* loaded from: classes5.dex */
public class ScriptableOutputStream extends ObjectOutputStream {
    public Scriptable scope;
    public Map<Object, String> table;

    /* loaded from: classes5.dex */
    public static class PendingLookup implements Serializable {
        public static final long serialVersionUID = -2692990309789917727L;
        public String name;

        public PendingLookup(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public ScriptableOutputStream(OutputStream outputStream, Scriptable scriptable) throws IOException {
        super(outputStream);
        this.scope = scriptable;
        HashMap hashMap = new HashMap();
        this.table = hashMap;
        hashMap.put(scriptable, "");
        enableReplaceObject(true);
        excludeStandardObjectNames();
    }

    public static Object lookupQualifiedName(Scriptable scriptable, String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        Object obj = scriptable;
        while (stringTokenizer.hasMoreTokens()) {
            obj = ScriptableObject.getProperty((Scriptable) obj, stringTokenizer.nextToken());
            if (obj == null) {
                break;
            }
            boolean z = obj instanceof Scriptable;
            obj = obj;
            if (!z) {
                break;
            }
        }
        return obj;
    }

    public void addExcludedName(String str) {
        Object lookupQualifiedName = lookupQualifiedName(this.scope, str);
        if (lookupQualifiedName instanceof Scriptable) {
            this.table.put(lookupQualifiedName, str);
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Object for excluded name ", str, " not found."));
    }

    public void addOptionalExcludedName(String str) {
        Object lookupQualifiedName = lookupQualifiedName(this.scope, str);
        if (lookupQualifiedName == null || lookupQualifiedName == UniqueTag.NOT_FOUND) {
            return;
        }
        if (lookupQualifiedName instanceof Scriptable) {
            this.table.put(lookupQualifiedName, str);
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Object for excluded name ", str, " is not a Scriptable, it is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(lookupQualifiedName.getClass().getName());
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void excludeAllIds(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj instanceof String) {
                Scriptable scriptable = this.scope;
                String str = (String) obj;
                if (scriptable.get(str, scriptable) instanceof Scriptable) {
                    addExcludedName(str);
                }
            }
        }
    }

    public void excludeStandardObjectNames() {
        String[] strArr = {"Object", "Object.prototype", "Function", "Function.prototype", "String", "String.prototype", "Math", "Array", "Array.prototype", "Error", "Error.prototype", "Number", "Number.prototype", "Date", "Date.prototype", "RegExp", "RegExp.prototype", "Script", "Script.prototype", "Continuation", "Continuation.prototype"};
        for (int i = 0; i < 21; i++) {
            addExcludedName(strArr[i]);
        }
        String[] strArr2 = {"XML", "XML.prototype", "XMLList", "XMLList.prototype"};
        for (int i2 = 0; i2 < 4; i2++) {
            addOptionalExcludedName(strArr2[i2]);
        }
    }

    public boolean hasExcludedName(String str) {
        return this.table.get(str) != null;
    }

    public void removeExcludedName(String str) {
        this.table.remove(str);
    }

    @Override // java.io.ObjectOutputStream
    public Object replaceObject(Object obj) throws IOException {
        String str = this.table.get(obj);
        return str == null ? obj : new PendingLookup(str);
    }
}
