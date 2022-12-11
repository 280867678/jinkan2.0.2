package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class TextUtilsCompat {
    public static final String ARAB_SCRIPT_SUBTAG = "Arab";
    public static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    public static final Locale ROOT = new Locale("", "");

    public static int getLayoutDirectionFromFirstChar(@NonNull Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }

    @NonNull
    public static String htmlEncode(@NonNull String str) {
        return TextUtils.htmlEncode(str);
    }
}
