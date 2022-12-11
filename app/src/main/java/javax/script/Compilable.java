package javax.script;

import java.io.Reader;

/* loaded from: classes4.dex */
public interface Compilable {
    CompiledScript compile(Reader reader) throws ScriptException;

    CompiledScript compile(String str) throws ScriptException;
}
