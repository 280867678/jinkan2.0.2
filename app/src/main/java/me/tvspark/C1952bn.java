package me.tvspark;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;

@RequiresApi(21)
/* renamed from: me.tvspark.bn */
/* loaded from: classes4.dex */
public class C1952bn {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {16843848};

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, float f) {
        int integer = view.getResources().getInteger(com.google.android.material.R$integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{16842766, com.google.android.material.R$attr.state_liftable, -com.google.android.material.R$attr.state_lifted}, ObjectAnimator.ofFloat(view, Key.ELEVATION, 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, Key.ELEVATION, f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, Key.ELEVATION, 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
