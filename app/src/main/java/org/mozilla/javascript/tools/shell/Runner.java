package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/* loaded from: classes5.dex */
public class Runner implements Runnable, ContextAction<Object> {
    public Object[] args;

    /* renamed from: f */
    public Function f4748f;
    public ContextFactory factory;

    /* renamed from: s */
    public Script f4749s;
    public Scriptable scope;

    public Runner(Scriptable scriptable, Function function, Object[] objArr) {
        this.scope = scriptable;
        this.f4748f = function;
        this.args = objArr;
    }

    public Runner(Scriptable scriptable, Script script) {
        this.scope = scriptable;
        this.f4749s = script;
    }

    @Override // org.mozilla.javascript.ContextAction
    public Object run(Context context) {
        Function function = this.f4748f;
        if (function != null) {
            Scriptable scriptable = this.scope;
            return function.call(context, scriptable, scriptable, this.args);
        }
        return this.f4749s.exec(context, this.scope);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.factory.call(this);
    }
}
