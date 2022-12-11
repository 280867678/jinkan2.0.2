package androidx.core.p003os;

import android.content.res.Configuration;
import android.os.Build;
import androidx.annotation.NonNull;

/* renamed from: androidx.core.os.ConfigurationCompat */
/* loaded from: classes3.dex */
public final class ConfigurationCompat {
    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? LocaleListCompat.wrap(configuration.getLocales()) : LocaleListCompat.create(configuration.locale);
    }
}
