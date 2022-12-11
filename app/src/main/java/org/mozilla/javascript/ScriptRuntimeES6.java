package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class ScriptRuntimeES6 {
    public static Scriptable requireObjectCoercible(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable == null || Undefined.isUndefined(scriptable)) {
            throw ScriptRuntime.typeError2("msg.called.null.or.undefined", idFunctionObject.getTag(), idFunctionObject.getFunctionName());
        }
        return scriptable;
    }
}
