package javax.script;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class SimpleScriptContext implements ScriptContext {
    public static List<Integer> scopes;
    public Bindings engineScope = new SimpleBindings();
    public Bindings globalScope = null;
    public Reader reader = new InputStreamReader(System.in);
    public Writer writer = new PrintWriter((OutputStream) System.out, true);
    public Writer errorWriter = new PrintWriter((OutputStream) System.err, true);

    static {
        ArrayList arrayList = new ArrayList(2);
        scopes = arrayList;
        arrayList.add(100);
        scopes.add(200);
        scopes = Collections.unmodifiableList(scopes);
    }

    @Override // javax.script.ScriptContext
    public Object getAttribute(String str) {
        int i;
        if (this.engineScope.containsKey(str)) {
            i = 100;
        } else {
            Bindings bindings = this.globalScope;
            if (bindings == null || !bindings.containsKey(str)) {
                return null;
            }
            i = 200;
        }
        return getAttribute(str, i);
    }

    @Override // javax.script.ScriptContext
    public Object getAttribute(String str, int i) {
        if (i != 100) {
            if (i != 200) {
                throw new IllegalArgumentException("Illegal scope value.");
            }
            Bindings bindings = this.globalScope;
            if (bindings == null) {
                return null;
            }
            return bindings.get(str);
        }
        return this.engineScope.get(str);
    }

    @Override // javax.script.ScriptContext
    public int getAttributesScope(String str) {
        if (this.engineScope.containsKey(str)) {
            return 100;
        }
        Bindings bindings = this.globalScope;
        return (bindings == null || !bindings.containsKey(str)) ? -1 : 200;
    }

    @Override // javax.script.ScriptContext
    public Bindings getBindings(int i) {
        if (i == 100) {
            return this.engineScope;
        }
        if (i != 200) {
            throw new IllegalArgumentException("Illegal scope value.");
        }
        return this.globalScope;
    }

    @Override // javax.script.ScriptContext
    public Writer getErrorWriter() {
        return this.errorWriter;
    }

    @Override // javax.script.ScriptContext
    public Reader getReader() {
        return this.reader;
    }

    @Override // javax.script.ScriptContext
    public List<Integer> getScopes() {
        return scopes;
    }

    @Override // javax.script.ScriptContext
    public Writer getWriter() {
        return this.writer;
    }

    @Override // javax.script.ScriptContext
    public Object removeAttribute(String str, int i) {
        int i2 = 100;
        if (i != 100) {
            i2 = 200;
            if (i != 200) {
                throw new IllegalArgumentException("Illegal scope value.");
            }
            if (getBindings(200) == null) {
                return null;
            }
        } else if (getBindings(100) == null) {
            return null;
        }
        return getBindings(i2).remove(str);
    }

    @Override // javax.script.ScriptContext
    public void setAttribute(String str, Object obj, int i) {
        if (i == 100) {
            this.engineScope.put(str, obj);
        } else if (i != 200) {
            throw new IllegalArgumentException("Illegal scope value.");
        } else {
            Bindings bindings = this.globalScope;
            if (bindings == null) {
                return;
            }
            bindings.put(str, obj);
        }
    }

    @Override // javax.script.ScriptContext
    public void setBindings(Bindings bindings, int i) {
        if (i != 100) {
            if (i != 200) {
                throw new IllegalArgumentException("Invalid scope value.");
            }
            this.globalScope = bindings;
        } else if (bindings == null) {
            throw new NullPointerException("Engine scope cannot be null.");
        } else {
            this.engineScope = bindings;
        }
    }

    @Override // javax.script.ScriptContext
    public void setErrorWriter(Writer writer) {
        this.errorWriter = writer;
    }

    @Override // javax.script.ScriptContext
    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override // javax.script.ScriptContext
    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
