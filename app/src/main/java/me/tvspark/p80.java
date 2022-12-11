package me.tvspark;

import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber;

/* loaded from: classes4.dex */
public interface p80 {
    void innerClose(boolean z, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber);

    void innerCloseError(Throwable th);

    void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber);

    void innerError(Throwable th);

    void innerValue(boolean z, Object obj);
}
