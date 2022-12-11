package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.media.MediaDescriptionCompatApi21;
import android.support.p000v4.media.MediaDescriptionCompatApi23;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
/* loaded from: classes3.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public MediaDescriptionCompat mo4216createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public MediaDescriptionCompat[] mo4217newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    public final CharSequence mDescription;
    public Object mDescriptionObj;
    public final Bundle mExtras;
    public final Bitmap mIcon;
    public final Uri mIconUri;
    public final String mMediaId;
    public final Uri mMediaUri;
    public final CharSequence mSubtitle;
    public final CharSequence mTitle;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$Builder */
    /* loaded from: classes3.dex */
    public static final class Builder {
        public CharSequence mDescription;
        public Bundle mExtras;
        public Bitmap mIcon;
        public Uri mIconUri;
        public String mMediaId;
        public Uri mMediaUri;
        public CharSequence mSubtitle;
        public CharSequence mTitle;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap bitmap) {
            this.mIcon = bitmap;
            return this;
        }

        public Builder setIconUri(@Nullable Uri uri) {
            this.mIconUri = uri;
            return this;
        }

        public Builder setMediaId(@Nullable String str) {
            this.mMediaId = str;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri uri) {
            this.mMediaUri = uri;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap) parcel.readParcelable(classLoader);
        this.mIconUri = (Uri) parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.mMediaUri = (Uri) parcel.readParcelable(classLoader);
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaDescriptionCompat fromMediaDescription(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj != null) {
            Builder builder = new Builder();
            builder.setMediaId(MediaDescriptionCompatApi21.getMediaId(obj));
            builder.setTitle(MediaDescriptionCompatApi21.getTitle(obj));
            builder.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(obj));
            builder.setDescription(MediaDescriptionCompatApi21.getDescription(obj));
            builder.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(obj));
            builder.setIconUri(MediaDescriptionCompatApi21.getIconUri(obj));
            Bundle extras = MediaDescriptionCompatApi21.getExtras(obj);
            if (extras != null) {
                MediaSessionCompat.ensureClassLoader(extras);
                uri = (Uri) extras.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
            } else {
                uri = null;
            }
            if (uri != null) {
                if (!extras.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) || extras.size() != 2) {
                    extras.remove(DESCRIPTION_KEY_MEDIA_URI);
                    extras.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
                }
                builder.setExtras(bundle);
                if (uri == null) {
                    builder.setMediaUri(uri);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    builder.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(obj));
                }
                MediaDescriptionCompat build = builder.build();
                build.mDescriptionObj = obj;
                return build;
            }
            bundle = extras;
            builder.setExtras(bundle);
            if (uri == null) {
            }
            MediaDescriptionCompat build2 = builder.build();
            build2.mDescriptionObj = obj;
            return build2;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.mDescription;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    @Nullable
    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        Object obj = this.mDescriptionObj;
        if (obj == null) {
            Object newInstance = MediaDescriptionCompatApi21.Builder.newInstance();
            MediaDescriptionCompatApi21.Builder.setMediaId(newInstance, this.mMediaId);
            MediaDescriptionCompatApi21.Builder.setTitle(newInstance, this.mTitle);
            MediaDescriptionCompatApi21.Builder.setSubtitle(newInstance, this.mSubtitle);
            MediaDescriptionCompatApi21.Builder.setDescription(newInstance, this.mDescription);
            MediaDescriptionCompatApi21.Builder.setIconBitmap(newInstance, this.mIcon);
            MediaDescriptionCompatApi21.Builder.setIconUri(newInstance, this.mIconUri);
            Bundle bundle = this.mExtras;
            if (Build.VERSION.SDK_INT < 23 && this.mMediaUri != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
                }
                bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
            }
            MediaDescriptionCompatApi21.Builder.setExtras(newInstance, bundle);
            if (Build.VERSION.SDK_INT >= 23) {
                MediaDescriptionCompatApi23.Builder.setMediaUri(newInstance, this.mMediaUri);
            }
            Object build = MediaDescriptionCompatApi21.Builder.build(newInstance);
            this.mDescriptionObj = build;
            return build;
        }
        return obj;
    }

    @Nullable
    public String getMediaId() {
        return this.mMediaId;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        return ((Object) this.mTitle) + ", " + ((Object) this.mSubtitle) + ", " + ((Object) this.mDescription);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel, i);
    }
}
