package me.tvspark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes4.dex */
public final class Mmmmmmmm {
    public static volatile boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;

    public static Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return AppCompatResources.getDrawable(theme != null ? new ContextThemeWrapper(context2, theme) : context2, i);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return ResourcesCompat.getDrawable(context2.getResources(), i, theme);
    }
}
