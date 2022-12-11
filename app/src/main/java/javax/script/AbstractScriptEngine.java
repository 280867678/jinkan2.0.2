package javax.script;

import java.io.Reader;

/* loaded from: classes4.dex */
public abstract class AbstractScriptEngine implements ScriptEngine {
    public ScriptContext context;

    public AbstractScriptEngine() {
        this.context = new SimpleScriptContext();
    }

    public AbstractScriptEngine(Bindings bindings) {
        this();
        if (bindings != null) {
            this.context.setBindings(bindings, 100);
            return;
        }
        throw new NullPointerException("n is null");
    }

    @Override // javax.script.ScriptEngine
    public Object eval(Reader reader) throws ScriptException {
        return eval(reader, this.context);
    }

    @Override // javax.script.ScriptEngine
    public Object eval(Reader reader, Bindings bindings) throws ScriptException {
        return eval(reader, getScriptContext(bindings));
    }

    @Override // javax.script.ScriptEngine
    public Object eval(String str) throws ScriptException {
        return eval(str, this.context);
    }

    @Override // javax.script.ScriptEngine
    public Object eval(String str, Bindings bindings) throws ScriptException {
        return eval(str, getScriptContext(bindings));
    }

    @Override // javax.script.ScriptEngine
    public Object get(String str) {
        Bindings bindings = getBindings(100);
        if (bindings != null) {
            return bindings.get(str);
        }
        return null;
    }

    @Override // javax.script.ScriptEngine
    public Bindings getBindings(int i) {
        int i2 = 200;
        if (i != 200) {
            i2 = 100;
            if (i != 100) {
                throw new IllegalArgumentException("Invalid scope value.");
            }
        }
        return this.context.getBindings(i2);
    }

    @Override // javax.script.ScriptEngine
    public ScriptContext getContext() {
        return this.context;
    }

    public ScriptContext getScriptContext(Bindings bindings) {
        SimpleScriptContext simpleScriptContext = new SimpleScriptContext();
        Bindings bindings2 = getBindings(200);
        if (bindings2 != null) {
            simpleScriptContext.setBindings(bindings2, 200);
        }
        if (bindings != null) {
            simpleScriptContext.setBindings(bindings, 100);
            simpleScriptContext.setReader(this.context.getReader());
            simpleScriptContext.setWriter(this.context.getWriter());
            simpleScriptContext.setErrorWriter(this.context.getErrorWriter());
            return simpleScriptContext;
        }
        throw new NullPointerException("Engine scope Bindings may not be null.");
    }

    @Override // javax.script.ScriptEngine
    public void put(String str, Object obj) {
        Bindings bindings = getBindings(100);
        if (bindings != null) {
            bindings.put(str, obj);
        }
    }

    @Override // javax.script.ScriptEngine
    public void setBindings(Bindings bindings, int i) {
        int i2 = 200;
        if (i != 200) {
            i2 = 100;
            if (i != 100) {
                throw new IllegalArgumentException("Invalid scope value.");
            }
        }
        this.context.setBindings(bindings, i2);
    }

    @Override // javax.script.ScriptEngine
    public void setContext(ScriptContext scriptContext) {
        if (scriptContext != null) {
            this.context = scriptContext;
            return;
        }
        throw new NullPointerException("null context");
    }
}
