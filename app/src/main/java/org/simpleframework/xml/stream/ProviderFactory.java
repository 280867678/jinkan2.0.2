package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public final class ProviderFactory {
    public static Provider getInstance() {
        try {
            try {
                return new StreamProvider();
            } catch (Throwable unused) {
                return new PullProvider();
            }
        } catch (Throwable unused2) {
            return new DocumentProvider();
        }
    }
}
