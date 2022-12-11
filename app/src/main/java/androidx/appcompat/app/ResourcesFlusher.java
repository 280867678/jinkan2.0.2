package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes3.dex */
public class ResourcesFlusher {
    public static final String TAG = "ResourcesFlusher";
    public static Field sDrawableCacheField;
    public static boolean sDrawableCacheFieldFetched;
    public static Field sResourcesImplField;
    public static boolean sResourcesImplFieldFetched;
    public static Class<?> sThemedResourceCacheClazz;
    public static boolean sThemedResourceCacheClazzFetched;
    public static Field sThemedResourceCache_mUnthemedEntriesField;
    public static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    public static void flush(@NonNull Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            flushNougats(resources);
        } else if (i >= 23) {
            flushMarshmallows(resources);
        } else {
            flushLollipops(resources);
        }
    }

    @RequiresApi(21)
    public static void flushLollipops(@NonNull Resources resources) {
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field = sDrawableCacheField;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
            if (map == null) {
                return;
            }
            map.clear();
        }
    }

    @RequiresApi(23)
    public static void flushMarshmallows(@NonNull Resources resources) {
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sDrawableCacheFieldFetched = true;
        }
        Object obj = null;
        Field field = sDrawableCacheField;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
        }
        if (obj == null) {
            return;
        }
        flushThemedResourcesCache(obj);
    }

    @RequiresApi(24)
    public static void flushNougats(@NonNull Resources resources) {
        Object obj;
        if (!sResourcesImplFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                sResourcesImplField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sResourcesImplFieldFetched = true;
        }
        Field field = sResourcesImplField;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException unused2) {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field2 = sDrawableCacheField;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException unused4) {
            }
        }
        if (obj2 == null) {
            return;
        }
        flushThemedResourcesCache(obj2);
    }

    @RequiresApi(16)
    public static void flushThemedResourcesCache(@NonNull Object obj) {
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            sThemedResourceCacheClazzFetched = true;
        }
        Class<?> cls = sThemedResourceCacheClazz;
        if (cls == null) {
            return;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        Field field = sThemedResourceCache_mUnthemedEntriesField;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
        }
        if (longSparseArray == null) {
            return;
        }
        longSparseArray.clear();
    }
}
