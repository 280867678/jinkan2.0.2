package com.arialyy.aria.core.group;

import com.arialyy.aria.core.listener.IDGroupListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class GroupRunState {
    public IDGroupListener listener;
    public String mGroupHash;
    public long mProgress;
    public int mSubSize;
    public SimpleSubQueue queue;
    public String TAG = "GroupRunState";
    public AtomicInteger mCompleteNum = new AtomicInteger();
    public AtomicInteger mFailNum = new AtomicInteger();
    public AtomicInteger mStopNum = new AtomicInteger();
    public AtomicBoolean isRunning = new AtomicBoolean(false);
    public Set<String> mFailTemp = new HashSet();
    public Set<String> mStopTemp = new HashSet();

    public GroupRunState(String str, IDGroupListener iDGroupListener, SimpleSubQueue simpleSubQueue) {
        this.listener = iDGroupListener;
        this.queue = simpleSubQueue;
        this.mGroupHash = str;
    }

    public void countFailNum(String str) {
        this.mFailTemp.add(str);
        this.mFailNum.getAndIncrement();
    }

    public void countStopNum(String str) {
        this.mStopTemp.add(str);
        this.mStopNum.getAndIncrement();
    }

    public int getCompleteNum() {
        return this.mCompleteNum.get();
    }

    public int getFailNum() {
        return this.mFailNum.get();
    }

    public String getGroupHash() {
        return this.mGroupHash;
    }

    public long getProgress() {
        return this.mProgress;
    }

    public int getStopNum() {
        return this.mStopNum.get();
    }

    public int getSubSize() {
        return this.mSubSize;
    }

    public boolean isRunning() {
        return this.isRunning.get();
    }

    public void setRunning(boolean z) {
        this.isRunning.set(z);
    }

    public void setSubSize(int i) {
        this.mSubSize = i;
    }

    public void updateCompleteNum() {
        this.mCompleteNum.getAndIncrement();
    }

    public void updateCount(String str) {
        AtomicInteger atomicInteger;
        if (this.mFailTemp.contains(str)) {
            this.mFailTemp.remove(str);
            atomicInteger = this.mFailNum;
        } else if (!this.mStopTemp.contains(str)) {
            return;
        } else {
            this.mStopTemp.remove(str);
            atomicInteger = this.mStopNum;
        }
        atomicInteger.getAndDecrement();
    }

    public void updateProgress(long j) {
        this.mProgress = j;
    }
}
