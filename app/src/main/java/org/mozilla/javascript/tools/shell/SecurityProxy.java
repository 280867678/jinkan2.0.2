package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;

/* loaded from: classes5.dex */
public abstract class SecurityProxy extends SecurityController {
    public abstract void callProcessFileSecure(Context context, Scriptable scriptable, String str);
}
