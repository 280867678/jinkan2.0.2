package org.mozilla.javascript.tools.shell;

import java.io.InputStream;
import java.nio.charset.Charset;
import org.mozilla.javascript.Scriptable;

@Deprecated
/* loaded from: classes5.dex */
public class ShellLine {
    @Deprecated
    public static InputStream getStream(Scriptable scriptable) {
        ShellConsole console = ShellConsole.getConsole(scriptable, Charset.defaultCharset());
        if (console != null) {
            return console.getIn();
        }
        return null;
    }
}
