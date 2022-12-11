package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.swiperefreshlayout.widget.CircleImageView;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    public static final int AMBIENT_SHADOW_ALPHA = 30;
    public static final float BLUR_FACTOR = 0.010416667f;
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    public static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    @VisibleForTesting
    public static final String EXTRA_INT1 = "int1";
    @VisibleForTesting
    public static final String EXTRA_INT2 = "int2";
    @VisibleForTesting
    public static final String EXTRA_OBJ = "obj";
    @VisibleForTesting
    public static final String EXTRA_STRING1 = "string1";
    @VisibleForTesting
    public static final String EXTRA_TINT_LIST = "tint_list";
    @VisibleForTesting
    public static final String EXTRA_TINT_MODE = "tint_mode";
    @VisibleForTesting
    public static final String EXTRA_TYPE = "type";
    public static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    public static final int KEY_SHADOW_ALPHA = 61;
    public static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    public static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] mData;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt2;
    public Object mObj1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable mParcelable;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mString1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList mTintList;
    public PorterDuff.Mode mTintMode;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mTintModeStr;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mType;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes3.dex */
    public @interface IconType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    public IconCompat(int i) {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = i;
    }

    @Nullable
    public static IconCompat createFromBundle(@NonNull Bundle bundle) {
        Object parcelable;
        int i = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i);
        iconCompat.mInt1 = bundle.getInt(EXTRA_INT1);
        iconCompat.mInt2 = bundle.getInt(EXTRA_INT2);
        iconCompat.mString1 = bundle.getString(EXTRA_STRING1);
        if (bundle.containsKey(EXTRA_TINT_LIST)) {
            iconCompat.mTintList = (ColorStateList) bundle.getParcelable(EXTRA_TINT_LIST);
        }
        if (bundle.containsKey(EXTRA_TINT_MODE)) {
            iconCompat.mTintMode = PorterDuff.Mode.valueOf(bundle.getString(EXTRA_TINT_MODE));
        }
        switch (i) {
            case -1:
            case 1:
            case 5:
                parcelable = bundle.getParcelable("obj");
                iconCompat.mObj1 = parcelable;
                break;
            case 0:
            default:
                return null;
            case 2:
            case 4:
            case 6:
                parcelable = bundle.getString("obj");
                iconCompat.mObj1 = parcelable;
                break;
            case 3:
                iconCompat.mObj1 = bundle.getByteArray("obj");
                break;
        }
        return iconCompat;
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat createFromIcon(@NonNull Context context, @NonNull Icon icon) {
        Preconditions.checkNotNull(icon);
        int type = getType(icon);
        if (type == 2) {
            String resPackage = getResPackage(icon);
            try {
                return createWithResource(getResources(context, resPackage), resPackage, getResId(icon));
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else if (type == 4) {
            return createWithContentUri(getUri(icon));
        } else {
            if (type == 6) {
                return createWithAdaptiveBitmapContentUri(getUri(icon));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.mObj1 = icon;
            return iconCompat;
        }
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIcon(@NonNull Icon icon) {
        Preconditions.checkNotNull(icon);
        int type = getType(icon);
        if (type != 2) {
            if (type == 4) {
                return createWithContentUri(getUri(icon));
            }
            if (type == 6) {
                return createWithAdaptiveBitmapContentUri(getUri(icon));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.mObj1 = icon;
            return iconCompat;
        }
        return createWithResource(null, getResPackage(icon), getResId(icon));
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon icon) {
        if (getType(icon) == 2 && getResId(icon) == 0) {
            return null;
        }
        return createFromIcon(icon);
    }

    @VisibleForTesting
    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, CircleImageView.FILL_SHADOW_COLOR);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, CircleImageView.KEY_SHADOW_COLOR);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(5);
            iconCompat.mObj1 = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull Uri uri) {
        if (uri != null) {
            return createWithAdaptiveBitmapContentUri(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(6);
            iconCompat.mObj1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.mObj1 = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat createWithContentUri(Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithContentUri(String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.mObj1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithData(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            IconCompat iconCompat = new IconCompat(3);
            iconCompat.mObj1 = bArr;
            iconCompat.mInt1 = i;
            iconCompat.mInt2 = i2;
            return iconCompat;
        }
        throw new IllegalArgumentException("Data must not be null.");
    }

    public static IconCompat createWithResource(Context context, @DrawableRes int i) {
        if (context != null) {
            return createWithResource(context.getResources(), context.getPackageName(), i);
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createWithResource(Resources resources, String str, @DrawableRes int i) {
        if (str != null) {
            if (i == 0) {
                throw new IllegalArgumentException("Drawable resource ID must not be 0");
            }
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.mInt1 = i;
            if (resources != null) {
                try {
                    iconCompat.mObj1 = resources.getResourceName(i);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.mObj1 = str;
            }
            iconCompat.mString1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Package must not be null.");
    }

    @DrawableRes
    @IdRes
    @RequiresApi(23)
    public static int getResId(@NonNull Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return 0;
        }
    }

    @Nullable
    @RequiresApi(23)
    public static String getResPackage(@NonNull Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Resources getResources(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo == null) {
                return null;
            }
            return packageManager.getResourcesForApplication(applicationInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            String.format("Unable to find pkg=%s for icon", str);
            return null;
        }
    }

    @RequiresApi(23)
    public static int getType(@NonNull Icon icon) {
        StringBuilder sb;
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            sb.toString();
            return -1;
        } catch (NoSuchMethodException unused2) {
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            sb.toString();
            return -1;
        } catch (InvocationTargetException unused3) {
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            sb.toString();
            return -1;
        }
    }

    @Nullable
    @RequiresApi(23)
    public static Uri getUri(@NonNull Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private Drawable loadDrawableInner(Context context) {
        switch (this.mType) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.mObj1);
            case 2:
                String resPackage = getResPackage();
                if (TextUtils.isEmpty(resPackage)) {
                    resPackage = context.getPackageName();
                }
                try {
                    return ResourcesCompat.getDrawable(getResources(context, resPackage), this.mInt1, context.getTheme());
                } catch (RuntimeException unused) {
                    String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.mInt1), this.mObj1);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
            case 4:
                InputStream uriInputStream = getUriInputStream(context);
                if (uriInputStream != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream));
                }
                break;
            case 5:
                return new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
            case 6:
                InputStream uriInputStream2 = getUriInputStream(context);
                if (uriInputStream2 != null) {
                    return Build.VERSION.SDK_INT >= 26 ? new AdaptiveIconDrawable(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream2))) : new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(uriInputStream2), false));
                }
                break;
        }
        return null;
    }

    public static String typeToString(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addToShortcutIntent(@NonNull Intent intent, @Nullable Drawable drawable, @NonNull Context context) {
        Bitmap bitmap;
        checkResource(context);
        int i = this.mType;
        if (i == 1) {
            bitmap = (Bitmap) this.mObj1;
            if (drawable != null) {
                bitmap = bitmap.copy(bitmap.getConfig(), true);
            }
        } else if (i == 2) {
            try {
                Context createPackageContext = context.createPackageContext(getResPackage(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(createPackageContext, this.mInt1));
                    return;
                }
                Drawable drawable2 = ContextCompat.getDrawable(createPackageContext, this.mInt1);
                if (drawable2.getIntrinsicWidth() > 0 && drawable2.getIntrinsicHeight() > 0) {
                    bitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    drawable2.draw(new Canvas(bitmap));
                }
                int launcherLargeIconSize = ((ActivityManager) createPackageContext.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getLauncherLargeIconSize();
                bitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                drawable2.draw(new Canvas(bitmap));
            } catch (PackageManager.NameNotFoundException e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't find package ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mObj1);
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
            }
        } else if (i != 5) {
            throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
        } else {
            bitmap = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        }
        if (drawable != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmap));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@NonNull Context context) {
        Object obj;
        int identifier;
        if (this.mType != 2 || (obj = this.mObj1) == null) {
            return;
        }
        String str = (String) obj;
        if (!str.contains(":")) {
            return;
        }
        String str2 = str.split(":", -1)[1];
        String str3 = str2.split("/", -1)[0];
        String str4 = str2.split("/", -1)[1];
        String str5 = str.split(":", -1)[0];
        if ("0_resource_name_obfuscated".equals(str4) || this.mInt1 == (identifier = getResources(context, getResPackage()).getIdentifier(str4, str3, str5))) {
            return;
        }
        this.mInt1 = identifier;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap getBitmap() {
        if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.mObj1;
            if (!(obj instanceof Bitmap)) {
                return null;
            }
            return (Bitmap) obj;
        }
        int i = this.mType;
        if (i == 1) {
            return (Bitmap) this.mObj1;
        }
        if (i == 5) {
            return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    @IdRes
    public int getResId() {
        if (this.mType != -1 || Build.VERSION.SDK_INT < 23) {
            if (this.mType == 2) {
                return this.mInt1;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return getResId((Icon) this.mObj1);
    }

    @NonNull
    public String getResPackage() {
        if (this.mType != -1 || Build.VERSION.SDK_INT < 23) {
            if (this.mType == 2) {
                return TextUtils.isEmpty(this.mString1) ? ((String) this.mObj1).split(":", -1)[0] : this.mString1;
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return getResPackage((Icon) this.mObj1);
    }

    public int getType() {
        return (this.mType != -1 || Build.VERSION.SDK_INT < 23) ? this.mType : getType((Icon) this.mObj1);
    }

    @NonNull
    public Uri getUri() {
        if (this.mType != -1 || Build.VERSION.SDK_INT < 23) {
            int i = this.mType;
            if (i == 4 || i == 6) {
                return Uri.parse((String) this.mObj1);
            }
            throw new IllegalStateException("called getUri() on " + this);
        }
        return getUri((Icon) this.mObj1);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream getUriInputStream(@NonNull Context context) {
        StringBuilder sb;
        String str;
        Uri uri = getUri();
        String scheme = uri.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uri);
            } catch (Exception unused) {
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.mObj1));
            } catch (FileNotFoundException unused2) {
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(uri);
        sb.toString();
        return null;
    }

    @Nullable
    public Drawable loadDrawable(@NonNull Context context) {
        checkResource(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return toIcon(context).loadDrawable(context);
        }
        Drawable loadDrawableInner = loadDrawableInner(context);
        if (loadDrawableInner != null && (this.mTintList != null || this.mTintMode != DEFAULT_TINT_MODE)) {
            loadDrawableInner.mutate();
            DrawableCompat.setTintList(loadDrawableInner, this.mTintList);
            DrawableCompat.setTintMode(loadDrawableInner, this.mTintMode);
        }
        return loadDrawableInner;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        Parcelable parcelable;
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch (this.mType) {
            case -1:
                parcelable = this.mParcelable;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.mParcelable;
                if (parcelable == null) {
                    byte[] bArr = this.mData;
                    this.mObj1 = bArr;
                    this.mType = 3;
                    this.mInt1 = 0;
                    this.mInt2 = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.mData, Charset.forName("UTF-16"));
                this.mObj1 = str;
                if (this.mType != 2 || this.mString1 != null) {
                    return;
                }
                this.mString1 = str.split(":", -1)[0];
                return;
            case 3:
                this.mObj1 = this.mData;
                return;
        }
        this.mObj1 = parcelable;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        this.mTintModeStr = this.mTintMode.name();
        switch (this.mType) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.mObj1).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.mData = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.mData = ((String) this.mObj1).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.mData = (byte[]) this.mObj1;
                return;
            case 4:
            case 6:
                this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.mParcelable = (Parcelable) this.mObj1;
    }

    public IconCompat setTint(@ColorInt int i) {
        return setTintList(ColorStateList.valueOf(i));
    }

    public IconCompat setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    @NonNull
    public Bundle toBundle() {
        Parcelable parcelable;
        Bundle bundle = new Bundle();
        switch (this.mType) {
            case -1:
                parcelable = (Parcelable) this.mObj1;
                bundle.putParcelable("obj", parcelable);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                parcelable = (Bitmap) this.mObj1;
                bundle.putParcelable("obj", parcelable);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.mObj1);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.mObj1);
                break;
        }
        bundle.putInt("type", this.mType);
        bundle.putInt(EXTRA_INT1, this.mInt1);
        bundle.putInt(EXTRA_INT2, this.mInt2);
        bundle.putString(EXTRA_STRING1, this.mString1);
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            bundle.putParcelable(EXTRA_TINT_LIST, colorStateList);
        }
        PorterDuff.Mode mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            bundle.putString(EXTRA_TINT_MODE, mode.name());
        }
        return bundle;
    }

    @NonNull
    @RequiresApi(23)
    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r0 >= 26) goto L23;
     */
    @NonNull
    @RequiresApi(23)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Icon toIcon(@Nullable Context context) {
        Bitmap bitmap;
        Icon createWithResource;
        Bitmap bitmap2;
        switch (this.mType) {
            case -1:
                return (Icon) this.mObj1;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                bitmap = (Bitmap) this.mObj1;
                createWithResource = Icon.createWithBitmap(bitmap);
                break;
            case 2:
                createWithResource = Icon.createWithResource(getResPackage(), this.mInt1);
                break;
            case 3:
                createWithResource = Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
                break;
            case 4:
                createWithResource = Icon.createWithContentUri((String) this.mObj1);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    bitmap2 = (Bitmap) this.mObj1;
                    bitmap = createLegacyIconFromAdaptiveIcon(bitmap2, false);
                    createWithResource = Icon.createWithBitmap(bitmap);
                    break;
                } else {
                    bitmap2 = (Bitmap) this.mObj1;
                    createWithResource = Icon.createWithAdaptiveBitmap(bitmap2);
                    break;
                }
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    createWithResource = Icon.createWithAdaptiveBitmapContentUri(getUri());
                    break;
                } else if (context == null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Context is required to resolve the file uri of the icon: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getUri());
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else {
                    InputStream uriInputStream = getUriInputStream(context);
                    if (uriInputStream == null) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot load adaptive icon from uri: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getUri());
                        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                    int i = Build.VERSION.SDK_INT;
                    bitmap2 = BitmapFactory.decodeStream(uriInputStream);
                    break;
                }
        }
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            createWithResource.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            createWithResource.setTintMode(mode);
        }
        return createWithResource;
    }

    @NonNull
    public String toString() {
        int height;
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(typeToString(this.mType));
        switch (this.mType) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.mObj1).getWidth());
                sb.append("x");
                height = ((Bitmap) this.mObj1).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.mString1);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(getResId())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.mInt1);
                if (this.mInt2 != 0) {
                    sb.append(" off=");
                    height = this.mInt2;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.mObj1);
                break;
        }
        if (this.mTintList != null) {
            sb.append(" tint=");
            sb.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            sb.append(" mode=");
            sb.append(this.mTintMode);
        }
        sb.append(")");
        return sb.toString();
    }
}
