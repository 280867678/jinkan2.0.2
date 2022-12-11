package org.mozilla.javascript.commonjs.module;

import java.io.Serializable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/* loaded from: classes5.dex */
public class RequireBuilder implements Serializable {
    public static final long serialVersionUID = 1;
    public ModuleScriptProvider moduleScriptProvider;
    public Script postExec;
    public Script preExec;
    public boolean sandboxed = true;

    public Require createRequire(Context context, Scriptable scriptable) {
        return new Require(context, scriptable, this.moduleScriptProvider, this.preExec, this.postExec, this.sandboxed);
    }

    public RequireBuilder setModuleScriptProvider(ModuleScriptProvider moduleScriptProvider) {
        this.moduleScriptProvider = moduleScriptProvider;
        return this;
    }

    public RequireBuilder setPostExec(Script script) {
        this.postExec = script;
        return this;
    }

    public RequireBuilder setPreExec(Script script) {
        this.preExec = script;
        return this;
    }

    public RequireBuilder setSandboxed(boolean z) {
        this.sandboxed = z;
        return this;
    }
}
