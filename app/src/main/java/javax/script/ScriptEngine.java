package javax.script;

import java.io.Reader;

/* loaded from: classes4.dex */
public interface ScriptEngine {
    public static final String ARGV = "javax.script.argv";
    public static final String ENGINE = "javax.script.engine";
    public static final String ENGINE_VERSION = "javax.script.engine_version";
    public static final String FILENAME = "javax.script.filename";
    public static final String LANGUAGE = "javax.script.language";
    public static final String LANGUAGE_VERSION = "javax.script.language_version";
    public static final String NAME = "javax.script.name";

    Bindings createBindings();

    Object eval(Reader reader) throws ScriptException;

    Object eval(Reader reader, Bindings bindings) throws ScriptException;

    Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException;

    Object eval(String str) throws ScriptException;

    Object eval(String str, Bindings bindings) throws ScriptException;

    Object eval(String str, ScriptContext scriptContext) throws ScriptException;

    Object get(String str);

    Bindings getBindings(int i);

    ScriptContext getContext();

    ScriptEngineFactory getFactory();

    void put(String str, Object obj);

    void setBindings(Bindings bindings, int i);

    void setContext(ScriptContext scriptContext);
}
