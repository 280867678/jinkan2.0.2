package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

/* loaded from: classes3.dex */
public final class MediaSessionManager {
    public static final String TAG = "MediaSessionManager";
    public static volatile MediaSessionManager sSessionManager;
    public MediaSessionManagerImpl mImpl;
    public static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
    public static final Object sLock = new Object();

    /* loaded from: classes3.dex */
    public interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl);
    }

    /* loaded from: classes3.dex */
    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        public RemoteUserInfoImpl mImpl;

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }

        public RemoteUserInfo(@NonNull String str, int i, int i2) {
            this.mImpl = Build.VERSION.SDK_INT >= 28 ? new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2) : new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.mImpl.equals(((RemoteUserInfo) obj).mImpl);
            }
            return false;
        }

        @NonNull
        public String getPackageName() {
            return this.mImpl.getPackageName();
        }

        public int getPid() {
            return this.mImpl.getPid();
        }

        public int getUid() {
            return this.mImpl.getUid();
        }

        public int hashCode() {
            return this.mImpl.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    public MediaSessionManager(Context context) {
        this.mImpl = Build.VERSION.SDK_INT >= 28 ? new MediaSessionManagerImplApi28(context) : new MediaSessionManagerImplApi21(context);
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = sSessionManager;
        if (mediaSessionManager == null) {
            synchronized (sLock) {
                mediaSessionManager = sSessionManager;
                if (mediaSessionManager == null) {
                    sSessionManager = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = sSessionManager;
                }
            }
        }
        return mediaSessionManager;
    }

    public Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.mImpl.isTrustedForMediaControl(remoteUserInfo.mImpl);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
