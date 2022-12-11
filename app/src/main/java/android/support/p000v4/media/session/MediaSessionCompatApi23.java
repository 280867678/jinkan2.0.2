package android.support.p000v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.media.session.MediaSessionCompatApi21;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* renamed from: android.support.v4.media.session.MediaSessionCompatApi23 */
/* loaded from: classes3.dex */
public class MediaSessionCompatApi23 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$Callback */
    /* loaded from: classes3.dex */
    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$CallbackProxy */
    /* loaded from: classes3.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
