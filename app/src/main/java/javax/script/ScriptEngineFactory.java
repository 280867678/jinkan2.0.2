package javax.script;

import java.util.List;

/* loaded from: classes4.dex */
public interface ScriptEngineFactory {
    String getEngineName();

    String getEngineVersion();

    List<String> getExtensions();

    String getLanguageName();

    String getLanguageVersion();

    String getMethodCallSyntax(String str, String str2, String... strArr);

    List<String> getMimeTypes();

    List<String> getNames();

    String getOutputStatement(String str);

    Object getParameter(String str);

    String getProgram(String... strArr);

    ScriptEngine getScriptEngine();
}
