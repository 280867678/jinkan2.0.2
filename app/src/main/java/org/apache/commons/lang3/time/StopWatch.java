package org.apache.commons.lang3.time;

/* loaded from: classes4.dex */
public class StopWatch {
    public static final long NANO_2_MILLIS = 1000000;
    public State runningState = State.UNSTARTED;
    public SplitState splitState = SplitState.UNSPLIT;
    public long startTime;
    public long startTimeMillis;
    public long stopTime;

    /* loaded from: classes4.dex */
    public enum SplitState {
        SPLIT,
        UNSPLIT
    }

    /* loaded from: classes4.dex */
    public enum State {
        UNSTARTED { // from class: org.apache.commons.lang3.time.StopWatch.State.1
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        RUNNING { // from class: org.apache.commons.lang3.time.StopWatch.State.2
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        STOPPED { // from class: org.apache.commons.lang3.time.StopWatch.State.3
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED { // from class: org.apache.commons.lang3.time.StopWatch.State.4
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return true;
            }
        };

        public abstract boolean isStarted();

        public abstract boolean isStopped();

        public abstract boolean isSuspended();
    }

    public long getNanoTime() {
        long j;
        State state = this.runningState;
        if (state == State.STOPPED || state == State.SUSPENDED) {
            j = this.stopTime;
        } else if (state == State.UNSTARTED) {
            return 0L;
        } else {
            if (state != State.RUNNING) {
                throw new RuntimeException("Illegal running state has occurred.");
            }
            j = System.nanoTime();
        }
        return j - this.startTime;
    }

    public long getSplitNanoTime() {
        if (this.splitState == SplitState.SPLIT) {
            return this.stopTime - this.startTime;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getSplitTime() {
        return getSplitNanoTime() / NANO_2_MILLIS;
    }

    public long getStartTime() {
        if (this.runningState != State.UNSTARTED) {
            return this.startTimeMillis;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getTime() {
        return getNanoTime() / NANO_2_MILLIS;
    }

    public boolean isStarted() {
        return this.runningState.isStarted();
    }

    public boolean isStopped() {
        return this.runningState.isStopped();
    }

    public boolean isSuspended() {
        return this.runningState.isSuspended();
    }

    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    public void resume() {
        if (this.runningState == State.SUSPENDED) {
            this.startTime = (System.nanoTime() - this.stopTime) + this.startTime;
            this.runningState = State.RUNNING;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public void split() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.splitState = SplitState.SPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void start() {
        State state = this.runningState;
        if (state != State.STOPPED) {
            if (state != State.UNSTARTED) {
                throw new IllegalStateException("Stopwatch already started. ");
            }
            this.startTime = System.nanoTime();
            this.startTimeMillis = System.currentTimeMillis();
            this.runningState = State.RUNNING;
            return;
        }
        throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
    }

    public void stop() {
        State state = this.runningState;
        if (state == State.RUNNING || state == State.SUSPENDED) {
            if (this.runningState == State.RUNNING) {
                this.stopTime = System.nanoTime();
            }
            this.runningState = State.STOPPED;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void suspend() {
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
            this.runningState = State.SUSPENDED;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public void unsplit() {
        if (this.splitState == SplitState.SPLIT) {
            this.splitState = SplitState.UNSPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }
}
