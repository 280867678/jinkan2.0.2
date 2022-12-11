package me.tvspark;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

/* loaded from: classes4.dex */
public abstract class o50 implements ScriptEngineFactory {
    @Override // javax.script.ScriptEngineFactory
    public String getEngineName() {
        return (String) getParameter(ScriptEngine.ENGINE);
    }

    @Override // javax.script.ScriptEngineFactory
    public String getEngineVersion() {
        return (String) getParameter(ScriptEngine.ENGINE_VERSION);
    }

    @Override // javax.script.ScriptEngineFactory
    public String getLanguageName() {
        return (String) getParameter(ScriptEngine.LANGUAGE);
    }

    @Override // javax.script.ScriptEngineFactory
    public String getLanguageVersion() {
        return (String) getParameter(ScriptEngine.LANGUAGE_VERSION);
    }

    public String getName() {
        return (String) getParameter(ScriptEngine.NAME);
    }
}
