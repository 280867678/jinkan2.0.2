package me.tvspark;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* renamed from: me.tvspark.lm */
/* loaded from: classes4.dex */
public class C2338lm extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2338lm();
    public final WeakHashMap<Drawable, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new WeakHashMap<>();

    public C2338lm() {
        super(Integer.class, "drawableAlphaCompat");
    }

    @Override // android.util.Property
    @Nullable
    public Integer get(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
