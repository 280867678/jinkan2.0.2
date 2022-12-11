package me.tvspark.widget;

import androidx.core.view.GestureDetectorCompat;
import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class DirectionDpadView$mGestureDetectorCompat$2 extends Lambda implements xg0<GestureDetectorCompat> {
    public final /* synthetic */ DirectionDpadView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectionDpadView$mGestureDetectorCompat$2(DirectionDpadView directionDpadView) {
        super(0);
        this.this$0 = directionDpadView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.tvspark.xg0
    /* renamed from: invoke */
    public final GestureDetectorCompat mo4969invoke() {
        return new GestureDetectorCompat(this.this$0.getContext(), this.this$0);
    }
}
