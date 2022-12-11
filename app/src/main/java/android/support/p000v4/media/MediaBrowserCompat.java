package android.support.p000v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p000v4.p001os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
/* loaded from: classes3.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    public final MediaBrowserImpl mImpl;
    public static final String TAG = "MediaBrowserCompat";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CallbackHandler */
    /* loaded from: classes3.dex */
    public static class CallbackHandler extends Handler {
        public final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        public WeakReference<Messenger> mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.ensureClassLoader(data);
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbackImplRef.get();
            Messenger messenger = this.mCallbacksMessengerRef.get();
            try {
                int i = message.what;
                if (i == 1) {
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                } else if (i == 2) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                } else if (i != 3) {
                    String str = "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1;
                } else {
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                if (message.what != 1) {
                    return;
                }
                mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
            }
        }

        public void setCallbacksMessenger(Messenger messenger) {
            this.mCallbacksMessengerRef = new WeakReference<>(messenger);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback */
    /* loaded from: classes3.dex */
    public static class ConnectionCallback {
        public final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new ConnectionCallbackApi21();
        public ConnectionCallbackInternal mConnectionCallbackInternal;

        @RequiresApi(21)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21 */
        /* loaded from: classes3.dex */
        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal */
        /* loaded from: classes3.dex */
        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionCallback */
    /* loaded from: classes3.dex */
    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
    /* loaded from: classes3.dex */
    public static class CustomActionResultReceiver extends ResultReceiver {
        public final String mAction;
        public final CustomActionCallback mCallback;
        public final Bundle mExtras;

        public CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        @Override // android.support.p000v4.p001os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            if (this.mCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i == -1) {
                this.mCallback.onError(this.mAction, this.mExtras, bundle);
            } else if (i == 0) {
                this.mCallback.onResult(this.mAction, this.mExtras, bundle);
            } else if (i == 1) {
                this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown result code: ", i, " (extras=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mExtras);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", resultData=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(bundle);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback */
    /* loaded from: classes3.dex */
    public static abstract class ItemCallback {
        public final MediaBrowser.ItemCallback mItemCallbackFwk;

        @RequiresApi(23)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback$ItemCallbackApi23 */
        /* loaded from: classes3.dex */
        public class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            public ItemCallbackApi23() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(@NonNull String str) {
                ItemCallback.this.onError(str);
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                ItemCallback.this.onItemLoaded(MediaItem.fromMediaItem(mediaItem));
            }
        }

        public ItemCallback() {
            this.mItemCallbackFwk = Build.VERSION.SDK_INT >= 23 ? new ItemCallbackApi23() : null;
        }

        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
    /* loaded from: classes3.dex */
    public static class ItemReceiver extends ResultReceiver {
        public final ItemCallback mCallback;
        public final String mMediaId;

        public ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        @Override // android.support.p000v4.p001os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.mCallback.onItemLoaded((MediaItem) parcelable);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl */
    /* loaded from: classes3.dex */
    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String str, @NonNull ItemCallback itemCallback);

        @Nullable
        Bundle getNotifyChildrenChangedOptions();

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback);

        void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback);

        void subscribe(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback);

        void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback);
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21 */
    /* loaded from: classes3.dex */
    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        public final MediaBrowser mBrowserFwk;
        public Messenger mCallbacksMessenger;
        public final Context mContext;
        public MediaSessionCompat.Token mMediaSessionToken;
        public Bundle mNotifyChildrenChangedOptions;
        public final Bundle mRootHints;
        public ServiceBinderWrapper mServiceBinderWrapper;
        public int mServiceVersion;
        public final CallbackHandler mHandler = new CallbackHandler(this);
        public final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.mContext = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.mRootHints = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new MediaBrowser(context, componentName, connectionCallback.mConnectionCallbackFwk, this.mRootHints);
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            this.mBrowserFwk.connect();
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                try {
                    serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                } catch (RemoteException unused) {
                }
            }
            this.mBrowserFwk.disconnect();
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            return this.mBrowserFwk.getExtras();
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String str, @NonNull final ItemCallback itemCallback) {
            CallbackHandler callbackHandler;
            Runnable runnable;
            if (!TextUtils.isEmpty(str)) {
                if (itemCallback == null) {
                    throw new IllegalArgumentException("cb is null");
                }
                if (!this.mBrowserFwk.isConnected()) {
                    callbackHandler = this.mHandler;
                    runnable = new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    };
                } else if (this.mServiceBinderWrapper != null) {
                    try {
                        this.mServiceBinderWrapper.getMediaItem(str, new ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
                        return;
                    } catch (RemoteException unused) {
                        this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                            @Override // java.lang.Runnable
                            public void run() {
                                itemCallback.onError(str);
                            }
                        });
                        return;
                    }
                } else {
                    callbackHandler = this.mHandler;
                    runnable = new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    };
                }
                callbackHandler.post(runnable);
                return;
            }
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            return this.mBrowserFwk.getRoot();
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return this.mBrowserFwk.getServiceComponent();
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mBrowserFwk.isConnected();
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            try {
                Bundle extras = this.mBrowserFwk.getExtras();
                if (extras == null) {
                    return;
                }
                this.mServiceVersion = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.mServiceBinderWrapper = new ServiceBinderWrapper(binder, this.mRootHints);
                    Messenger messenger = new Messenger(this.mHandler);
                    this.mCallbacksMessenger = messenger;
                    this.mHandler.setCallbacksMessenger(messenger);
                    try {
                        this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                    } catch (RemoteException unused) {
                    }
                }
                IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (asInterface == null) {
                    return;
                }
                this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), asInterface);
            } catch (IllegalStateException unused2) {
            }
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.mCallbacksMessenger != messenger) {
                return;
            }
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                boolean z = MediaBrowserCompat.DEBUG;
                return;
            }
            SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback == null) {
                return;
            }
            if (bundle == null) {
                if (list == null) {
                    callback.onError(str);
                    return;
                } else {
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list);
                }
            } else if (list == null) {
                callback.onError(str, bundle);
                return;
            } else {
                this.mNotifyChildrenChangedOptions = bundle2;
                callback.onChildrenLoaded(str, list, bundle);
            }
            this.mNotifyChildrenChangedOptions = null;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String str, final Bundle bundle, @NonNull final SearchCallback searchCallback) {
            if (isConnected()) {
                if (this.mServiceBinderWrapper == null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                        @Override // java.lang.Runnable
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                    return;
                }
                try {
                    this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
                    return;
                } catch (RemoteException unused) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                        @Override // java.lang.Runnable
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                    return;
                }
            }
            throw new IllegalStateException("search() called while not connected");
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String str, final Bundle bundle, @Nullable final CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot send a custom action (");
                sb.append(str);
                sb.append(") with ");
                sb.append("extras ");
                sb.append(bundle);
                throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " because the browser is not connected to the ", "service."));
            }
            if (this.mServiceBinderWrapper == null && customActionCallback != null) {
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                    @Override // java.lang.Runnable
                    public void run() {
                        customActionCallback.onError(str, bundle, null);
                    }
                });
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                String str2 = "Remote error sending a custom action: action=" + str + ", extras=" + bundle;
                if (customActionCallback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                    @Override // java.lang.Runnable
                    public void run() {
                        customActionCallback.onError(str, bundle, null);
                    }
                });
            }
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            subscriptionCallback.setSubscription(subscription);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
            } catch (RemoteException unused) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
            if (r1.size() == 0) goto L8;
         */
        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                if (subscriptionCallback != null) {
                    List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                    List<Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                }
                this.mBrowserFwk.unsubscribe(str);
            } else {
                try {
                    if (subscriptionCallback == null) {
                        serviceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    } else {
                        List<SubscriptionCallback> callbacks2 = subscription.getCallbacks();
                        List<Bundle> optionsList2 = subscription.getOptionsList();
                        for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                            if (callbacks2.get(size2) == subscriptionCallback) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                                callbacks2.remove(size2);
                                optionsList2.remove(size2);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                }
            }
            if (!subscription.isEmpty() && subscriptionCallback != null) {
                return;
            }
            this.mSubscriptions.remove(str);
        }
    }

    @RequiresApi(23)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23 */
    /* loaded from: classes3.dex */
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                this.mBrowserFwk.getItem(str, itemCallback.mItemCallbackFwk);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    @RequiresApi(26)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi26 */
    /* loaded from: classes3.dex */
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.subscribe(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
            } else {
                this.mBrowserFwk.subscribe(str, bundle, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.unsubscribe(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                this.mBrowserFwk.unsubscribe(str);
            } else {
                this.mBrowserFwk.unsubscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase */
    /* loaded from: classes3.dex */
    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        public static final int CONNECT_STATE_CONNECTED = 3;
        public static final int CONNECT_STATE_CONNECTING = 2;
        public static final int CONNECT_STATE_DISCONNECTED = 1;
        public static final int CONNECT_STATE_DISCONNECTING = 0;
        public static final int CONNECT_STATE_SUSPENDED = 4;
        public final ConnectionCallback mCallback;
        public Messenger mCallbacksMessenger;
        public final Context mContext;
        public Bundle mExtras;
        public MediaSessionCompat.Token mMediaSessionToken;
        public Bundle mNotifyChildrenChangedOptions;
        public final Bundle mRootHints;
        public String mRootId;
        public ServiceBinderWrapper mServiceBinderWrapper;
        public final ComponentName mServiceComponent;
        public MediaServiceConnection mServiceConnection;
        public final CallbackHandler mHandler = new CallbackHandler(this);
        public final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();
        public int mState = 1;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection */
        /* loaded from: classes3.dex */
        public class MediaServiceConnection implements ServiceConnection {
            public MediaServiceConnection() {
            }

            private void postOrRun(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            public boolean isCurrent(String str) {
                int i;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mServiceConnection != this || (i = mediaBrowserImplBase.mState) == 0 || i == 1) {
                    int i2 = MediaBrowserImplBase.this.mState;
                    if (i2 == 0 || i2 == 1) {
                        return false;
                    }
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " for ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(MediaBrowserImplBase.this.mServiceComponent);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" with mServiceConnection=");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(MediaBrowserImplBase.this.mServiceConnection);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" this=");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    return false;
                }
                return true;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MediaServiceConnection.onServiceConnected name=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(componentName);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" binder=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(iBinder);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                            MediaBrowserImplBase.this.dump();
                        }
                        if (!MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            return;
                        }
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = new ServiceBinderWrapper(iBinder, mediaBrowserImplBase.mRootHints);
                        MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                        MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase3.mState = 2;
                        try {
                            if (MediaBrowserCompat.DEBUG) {
                                mediaBrowserImplBase3.dump();
                            }
                            MediaBrowserImplBase.this.mServiceBinderWrapper.connect(MediaBrowserImplBase.this.mContext, MediaBrowserImplBase.this.mCallbacksMessenger);
                        } catch (RemoteException unused) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RemoteException during connect for ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(MediaBrowserImplBase.this.mServiceComponent);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                            if (!MediaBrowserCompat.DEBUG) {
                                return;
                            }
                            MediaBrowserImplBase.this.dump();
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MediaServiceConnection.onServiceDisconnected name=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(componentName);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" this=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" mServiceConnection=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(MediaBrowserImplBase.this.mServiceConnection);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                            MediaBrowserImplBase.this.dump();
                        }
                        if (!MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            return;
                        }
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = null;
                        mediaBrowserImplBase.mCallbacksMessenger = null;
                        mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mState = 4;
                        mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                    }
                });
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context != null) {
                if (componentName == null) {
                    throw new IllegalArgumentException("service component must not be null");
                }
                if (connectionCallback == null) {
                    throw new IllegalArgumentException("connection callback must not be null");
                }
                this.mContext = context;
                this.mServiceComponent = componentName;
                this.mCallback = connectionCallback;
                this.mRootHints = bundle == null ? null : new Bundle(bundle);
                return;
            }
            throw new IllegalArgumentException("context must not be null");
        }

        public static String getStateLabel(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UNKNOWN/", i) : "CONNECT_STATE_SUSPENDED" : "CONNECT_STATE_CONNECTED" : "CONNECT_STATE_CONNECTING" : "CONNECT_STATE_DISCONNECTED" : "CONNECT_STATE_DISCONNECTING";
        }

        private boolean isCurrent(Messenger messenger, String str) {
            int i;
            if (this.mCallbacksMessenger != messenger || (i = this.mState) == 0 || i == 1) {
                int i2 = this.mState;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mServiceComponent);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" with mCallbacksMessenger=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mCallbacksMessenger);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" this=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                return false;
            }
            return true;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int i = this.mState;
            if (i == 0 || i == 1) {
                this.mState = 2;
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        if (mediaBrowserImplBase.mState == 0) {
                            return;
                        }
                        mediaBrowserImplBase.mState = 2;
                        if (MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mServiceConnection should be null. Instead it is ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(MediaBrowserImplBase.this.mServiceConnection);
                            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        if (mediaBrowserImplBase2.mServiceBinderWrapper != null) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mServiceBinderWrapper should be null. Instead it is ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(MediaBrowserImplBase.this.mServiceBinderWrapper);
                            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        } else if (mediaBrowserImplBase2.mCallbacksMessenger != null) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mCallbacksMessenger should be null. Instead it is ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(MediaBrowserImplBase.this.mCallbacksMessenger);
                            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                        } else {
                            Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                            intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase3.mServiceConnection = new MediaServiceConnection();
                            boolean z = false;
                            try {
                                z = MediaBrowserImplBase.this.mContext.bindService(intent, MediaBrowserImplBase.this.mServiceConnection, 1);
                            } catch (Exception unused) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed binding to service ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(MediaBrowserImplBase.this.mServiceComponent);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString();
                            }
                            if (!z) {
                                MediaBrowserImplBase.this.forceCloseConnection();
                                MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                            }
                            if (!MediaBrowserCompat.DEBUG) {
                                return;
                            }
                            MediaBrowserImplBase.this.dump();
                        }
                    }
                });
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("connect() called while neigther disconnecting nor disconnected (state=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getStateLabel(this.mState));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                    if (messenger != null) {
                        try {
                            mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
                        } catch (RemoteException unused) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RemoteException during connect for ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(MediaBrowserImplBase.this.mServiceComponent);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                        }
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    int i = mediaBrowserImplBase2.mState;
                    mediaBrowserImplBase2.forceCloseConnection();
                    if (i != 0) {
                        MediaBrowserImplBase.this.mState = i;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        public void dump() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  mServiceComponent=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mServiceComponent);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            String str = "  mCallback=" + this.mCallback;
            String str2 = "  mRootHints=" + this.mRootHints;
            getStateLabel(this.mState);
            String str3 = "  mServiceConnection=" + this.mServiceConnection;
            String str4 = "  mServiceBinderWrapper=" + this.mServiceBinderWrapper;
            String str5 = "  mCallbacksMessenger=" + this.mCallbacksMessenger;
            String str6 = "  mMediaSessionToken=" + this.mMediaSessionToken;
        }

        public void forceCloseConnection() {
            MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getExtras() called while not connected (state=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getStateLabel(this.mState));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String str, @NonNull final ItemCallback itemCallback) {
            if (!TextUtils.isEmpty(str)) {
                if (itemCallback == null) {
                    throw new IllegalArgumentException("cb is null");
                }
                if (!isConnected()) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                    return;
                }
                try {
                    this.mServiceBinderWrapper.getMediaItem(str, new ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
                    return;
                } catch (RemoteException unused) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                    return;
                }
            }
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getRoot() called while not connected(state=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getStateLabel(this.mState));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getServiceComponent() called while not connected (state="), this.mState, ")"));
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getSessionToken() called while not connected(state="), this.mState, ")"));
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onConnectFailed for ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mServiceComponent);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            if (!isCurrent(messenger, "onConnectFailed")) {
                return;
            }
            int i = this.mState;
            if (i != 2) {
                getStateLabel(i);
                return;
            }
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (!isCurrent(messenger, "onLoadChildren")) {
                return;
            }
            if (MediaBrowserCompat.DEBUG) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onLoadChildren for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mServiceComponent);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" id=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                boolean z = MediaBrowserCompat.DEBUG;
                return;
            }
            SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback == null) {
                return;
            }
            if (bundle == null) {
                if (list == null) {
                    callback.onError(str);
                    return;
                } else {
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list);
                }
            } else if (list == null) {
                callback.onError(str, bundle);
                return;
            } else {
                this.mNotifyChildrenChangedOptions = bundle2;
                callback.onChildrenLoaded(str, list, bundle);
            }
            this.mNotifyChildrenChangedOptions = null;
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (!isCurrent(messenger, "onConnect")) {
                return;
            }
            int i = this.mState;
            if (i != 2) {
                getStateLabel(i);
                return;
            }
            this.mRootId = str;
            this.mMediaSessionToken = token;
            this.mExtras = bundle;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG) {
                dump();
            }
            this.mCallback.onConnected();
            try {
                for (Map.Entry<String, Subscription> entry : this.mSubscriptions.entrySet()) {
                    String key = entry.getKey();
                    Subscription value = entry.getValue();
                    List<SubscriptionCallback> callbacks = value.getCallbacks();
                    List<Bundle> optionsList = value.getOptionsList();
                    for (int i2 = 0; i2 < callbacks.size(); i2++) {
                        this.mServiceBinderWrapper.addSubscription(key, callbacks.get(i2).mToken, optionsList.get(i2), this.mCallbacksMessenger);
                    }
                }
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String str, final Bundle bundle, @NonNull final SearchCallback searchCallback) {
            if (!isConnected()) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("search() called while not connected (state=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getStateLabel(this.mState));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
            }
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String str, final Bundle bundle, @Nullable final CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot send a custom action (");
                sb.append(str);
                sb.append(") with ");
                sb.append("extras ");
                sb.append(bundle);
                throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " because the browser is not connected to the ", "service."));
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                String str2 = "Remote error sending a custom action: action=" + str + ", extras=" + bundle;
                if (customActionCallback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        customActionCallback.onError(str, bundle, null);
                    }
                });
            }
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                } catch (RemoteException unused) {
                }
            }
        }

        @Override // android.support.p000v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            try {
                if (subscriptionCallback != null) {
                    List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                    List<Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                } else if (isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                }
            } catch (RemoteException unused) {
            }
            if (!subscription.isEmpty() && subscriptionCallback != null) {
                return;
            }
            this.mSubscriptions.remove(str);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl */
    /* loaded from: classes3.dex */
    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    /* loaded from: classes3.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            /* renamed from: createFromParcel */
            public MediaItem mo4214createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            /* renamed from: newArray */
            public MediaItem[] mo4215newArray(int i) {
                return new MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        public final MediaDescriptionCompat mDescription;
        public final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$Flags */
        /* loaded from: classes3.dex */
        public @interface Flags {
        }

        public MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat != null) {
                if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                    throw new IllegalArgumentException("description must have a non-empty media id");
                }
                this.mFlags = i;
                this.mDescription = mediaDescriptionCompat;
                return;
            }
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj != null) {
                MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
                return new MediaItem(MediaDescriptionCompat.fromMediaDescription(mediaItem.getDescription()), mediaItem.getFlags());
            }
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(fromMediaItem(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchCallback */
    /* loaded from: classes3.dex */
    public static abstract class SearchCallback {
        public void onError(@NonNull String str, Bundle bundle) {
        }

        public void onSearchResult(@NonNull String str, Bundle bundle, @NonNull List<MediaItem> list) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
    /* loaded from: classes3.dex */
    public static class SearchResultReceiver extends ResultReceiver {
        public final SearchCallback mCallback;
        public final Bundle mExtras;
        public final String mQuery;

        public SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        @Override // android.support.p000v4.p001os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper */
    /* loaded from: classes3.dex */
    public static class ServiceBinderWrapper {
        public Messenger mMessenger;
        public Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.mRootHints = bundle;
        }

        private void sendRequest(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            sendRequest(3, bundle2, messenger);
        }

        public void connect(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        public void disconnect(Messenger messenger) throws RemoteException {
            sendRequest(2, null, messenger);
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        public void registerCallbackMessenger(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        public void removeSubscription(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            sendRequest(4, bundle, messenger);
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        public void unregisterCallbackMessenger(Messenger messenger) throws RemoteException {
            sendRequest(7, null, messenger);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$Subscription */
    /* loaded from: classes3.dex */
    public static class Subscription {
        public final List<SubscriptionCallback> mCallbacks = new ArrayList();
        public final List<Bundle> mOptionsList = new ArrayList();

        public SubscriptionCallback getCallback(Bundle bundle) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), bundle)) {
                    return this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), bundle)) {
                    this.mCallbacks.set(i, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback */
    /* loaded from: classes3.dex */
    public static abstract class SubscriptionCallback {
        public final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
        public WeakReference<Subscription> mSubscriptionRef;
        public final IBinder mToken = new Binder();

        @RequiresApi(21)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi21 */
        /* loaded from: classes3.dex */
        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            public List<MediaItem> applyOptions(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i < 0 || i2 < 1 || i3 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                WeakReference<Subscription> weakReference = SubscriptionCallback.this.mSubscriptionRef;
                Subscription subscription = weakReference == null ? null : weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                List<Bundle> optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle bundle = optionsList.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str) {
                SubscriptionCallback.this.onError(str);
            }
        }

        @RequiresApi(26)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi26 */
        /* loaded from: classes3.dex */
        public class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            public SubscriptionCallbackApi26() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            this.mSubscriptionCallbackFwk = Build.VERSION.SDK_INT >= 26 ? new SubscriptionCallbackApi26() : new SubscriptionCallbackApi21();
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void onError(@NonNull String str) {
        }

        public void onError(@NonNull String str, @NonNull Bundle bundle) {
        }

        public void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference<>(subscription);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        this.mImpl = i >= 26 ? new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle) : i >= 23 ? new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle) : new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
        if (!TextUtils.isEmpty(str)) {
            if (searchCallback == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            this.mImpl.search(str, bundle, searchCallback);
            return;
        }
        throw new IllegalArgumentException("query cannot be empty");
    }

    public void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.mImpl.sendCustomAction(str, bundle, customActionCallback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
        if (!TextUtils.isEmpty(str)) {
            if (subscriptionCallback == null) {
                throw new IllegalArgumentException("callback is null");
            }
            if (bundle == null) {
                throw new IllegalArgumentException("options are null");
            }
            this.mImpl.subscribe(str, bundle, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (!TextUtils.isEmpty(str)) {
            if (subscriptionCallback == null) {
                throw new IllegalArgumentException("callback is null");
            }
            this.mImpl.subscribe(str, null, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mImpl.unsubscribe(str, null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (!TextUtils.isEmpty(str)) {
            if (subscriptionCallback == null) {
                throw new IllegalArgumentException("callback is null");
            }
            this.mImpl.unsubscribe(str, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }
}
