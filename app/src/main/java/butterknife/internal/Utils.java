package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Utils {
    public static final TypedValue VALUE = new TypedValue();

    public Utils() {
        throw new AssertionError("No instances.");
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... tArr) {
        int length = tArr.length;
        int i = 0;
        for (T t : tArr) {
            if (t != null) {
                tArr[i] = t;
                i++;
            }
        }
        return i == length ? tArr : (T[]) Arrays.copyOf(tArr, i);
    }

    public static <T> T castParam(Object obj, String str, int i, String str2, int i2, Class<T> cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Parameter #");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i + 1);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" of method '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' was of the wrong type for parameter #");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i2 + 1);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" of method '");
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str2, "'. See cause for more info."), e);
        }
    }

    public static <T> T castView(View view, @IdRes int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            String resourceEntryName = getResourceEntryName(view, i);
            StringBuilder sb = new StringBuilder();
            sb.append("View '");
            sb.append(resourceEntryName);
            sb.append("' with ID ");
            sb.append(i);
            sb.append(" for ");
            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str, " was of the wrong type. See cause for more info."), e);
        }
    }

    public static <T> T findOptionalViewAsType(View view, @IdRes int i, String str, Class<T> cls) {
        return (T) castView(view.findViewById(i), i, str, cls);
    }

    public static View findRequiredView(View view, @IdRes int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String resourceEntryName = getResourceEntryName(view, i);
        StringBuilder sb = new StringBuilder();
        sb.append("Required view '");
        sb.append(resourceEntryName);
        sb.append("' with ID ");
        sb.append(i);
        sb.append(" for ");
        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str, " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation."));
    }

    public static <T> T findRequiredViewAsType(View view, @IdRes int i, String str, Class<T> cls) {
        return (T) castView(findRequiredView(view, i, str), i, str, cls);
    }

    @UiThread
    public static float getFloat(Context context, @DimenRes int i) {
        TypedValue typedValue = VALUE;
        context.getResources().getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Resource ID #0x");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(i));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" type #0x");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(typedValue.type));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is not valid");
        throw new Resources.NotFoundException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static String getResourceEntryName(View view, @IdRes int i) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
    }

    @UiThread
    public static Drawable getTintedDrawable(Context context, @DrawableRes int i, @AttrRes int i2) {
        if (context.getTheme().resolveAttribute(i2, VALUE, true)) {
            Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(context, i).mutate());
            DrawableCompat.setTint(wrap, ContextCompat.getColor(context, VALUE.resourceId));
            return wrap;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required tint color attribute with name ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(context.getResources().getResourceEntryName(i2));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" and attribute ID ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" was not found.");
        throw new Resources.NotFoundException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... tArr) {
        return new ImmutableList(arrayFilteringNull(tArr));
    }
}
