package androidx.renderscript;

import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ScriptC extends Script {
    public static final String TAG = "ScriptC";

    public ScriptC(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public ScriptC(RenderScript renderScript, Resources resources, int i) {
        super(0, renderScript);
        if (RenderScript.isNative) {
            this.f127mT = new ScriptCThunker((RenderScriptThunker) renderScript, resources, i);
            return;
        }
        int internalCreate = internalCreate(renderScript, resources, i);
        if (internalCreate == 0) {
            throw new RSRuntimeException("Loading of ScriptC script failed.");
        }
        setID(internalCreate);
    }

    public static synchronized int internalCreate(RenderScript renderScript, Resources resources, int i) {
        int nScriptCCreate;
        synchronized (ScriptC.class) {
            InputStream openRawResource = resources.openRawResource(i);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    int i2 = 0;
                    while (true) {
                        int length = bArr.length - i2;
                        if (length == 0) {
                            int length2 = bArr.length * 2;
                            byte[] bArr2 = new byte[length2];
                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                            length = length2 - i2;
                            bArr = bArr2;
                        }
                        int read = openRawResource.read(bArr, i2, length);
                        if (read <= 0) {
                            nScriptCCreate = renderScript.nScriptCCreate(resources.getResourceEntryName(i), renderScript.getApplicationContext().getCacheDir().toString(), bArr, i2);
                        } else {
                            i2 += read;
                        }
                    }
                } catch (IOException unused) {
                    throw new Resources.NotFoundException();
                }
            } finally {
                openRawResource.close();
            }
        }
        return nScriptCCreate;
    }
}
