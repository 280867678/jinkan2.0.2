package me.tvspark;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* renamed from: me.tvspark.km */
/* loaded from: classes4.dex */
public class C2301km extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2301km("childrenAlpha");

    public C2301km(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @NonNull
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(com.google.android.material.R$id.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f) {
        ViewGroup viewGroup2 = viewGroup;
        float floatValue = f.floatValue();
        viewGroup2.setTag(com.google.android.material.R$id.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup2.getChildAt(i).setAlpha(floatValue);
        }
    }
}
