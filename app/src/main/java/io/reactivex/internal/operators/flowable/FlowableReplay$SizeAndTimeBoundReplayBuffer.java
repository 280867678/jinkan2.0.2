package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import me.tvspark.k60;
import me.tvspark.pd0;

/* loaded from: classes4.dex */
public final class FlowableReplay$SizeAndTimeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    public static final long serialVersionUID = 3457957419649567404L;
    public final int limit;
    public final long maxAge;
    public final k60 scheduler;
    public final TimeUnit unit;

    public FlowableReplay$SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, k60 k60Var) {
        this.scheduler = k60Var;
        this.limit = i;
        this.maxAge = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object enterTransform(Object obj) {
        return new pd0(obj, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit), this.unit);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object leaveTransform(Object obj) {
        return ((pd0) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncate() {
        FlowableReplay$Node flowableReplay$Node;
        int i;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.maxAge;
        FlowableReplay$Node flowableReplay$Node2 = get();
        FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2.get();
        int i2 = 0;
        while (true) {
            FlowableReplay$Node flowableReplay$Node4 = flowableReplay$Node3;
            flowableReplay$Node = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node4;
            if (flowableReplay$Node2 == null || ((i = this.size) <= this.limit && ((pd0) flowableReplay$Node2.value).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                break;
            }
            i2++;
            this.size = i - 1;
            flowableReplay$Node3 = flowableReplay$Node2.get();
        }
        if (i2 != 0) {
            setFirst(flowableReplay$Node);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        setFirst(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        return;
     */
    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void truncateFinal() {
        int i;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.maxAge;
        FlowableReplay$Node flowableReplay$Node = get();
        FlowableReplay$Node flowableReplay$Node2 = flowableReplay$Node.get();
        int i2 = 0;
        while (true) {
            FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2;
            FlowableReplay$Node flowableReplay$Node4 = flowableReplay$Node;
            flowableReplay$Node = flowableReplay$Node3;
            if (flowableReplay$Node == null || (i = this.size) <= 1 || ((pd0) flowableReplay$Node.value).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                break;
            }
            i2++;
            this.size = i - 1;
            flowableReplay$Node2 = flowableReplay$Node.get();
        }
    }
}
