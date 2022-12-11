package org.eclipse.jetty.util.thread;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class Timeout {
    public static final Logger LOG = Log.getLogger(Timeout.class);
    public long _duration;
    public Task _head;
    public Object _lock;
    public volatile long _now;

    /* loaded from: classes5.dex */
    public static class Task {
        public long _delay;
        public Timeout _timeout;
        public long _timestamp = 0;
        public boolean _expired = false;
        public Task _prev = this;
        public Task _next = this;

        /* JADX INFO: Access modifiers changed from: private */
        public void link(Task task) {
            Task task2 = this._next;
            task2._prev = task;
            this._next = task;
            task._next = task2;
            this._next._prev = this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void unlink() {
            Task task = this._next;
            task._prev = this._prev;
            this._prev._next = task;
            this._prev = this;
            this._next = this;
            this._expired = false;
        }

        public void cancel() {
            Timeout timeout = this._timeout;
            if (timeout != null) {
                synchronized (timeout._lock) {
                    unlink();
                    this._timestamp = 0L;
                }
            }
        }

        public void expire() {
        }

        public void expired() {
        }

        public long getAge() {
            Timeout timeout = this._timeout;
            if (timeout != null) {
                long j = timeout._now;
                if (j != 0) {
                    long j2 = this._timestamp;
                    if (j2 != 0) {
                        return j - j2;
                    }
                }
            }
            return 0L;
        }

        public long getTimestamp() {
            return this._timestamp;
        }

        public boolean isExpired() {
            return this._expired;
        }

        public boolean isScheduled() {
            return this._next != this;
        }

        public void reschedule() {
            Timeout timeout = this._timeout;
            if (timeout != null) {
                timeout.schedule(this, this._delay);
            }
        }

        public void schedule(Timeout timeout) {
            timeout.schedule(this);
        }

        public void schedule(Timeout timeout, long j) {
            timeout.schedule(this, j);
        }
    }

    public Timeout() {
        this._now = System.currentTimeMillis();
        this._head = new Task();
        this._lock = new Object();
        this._head._timeout = this;
    }

    public Timeout(Object obj) {
        this._now = System.currentTimeMillis();
        Task task = new Task();
        this._head = task;
        this._lock = obj;
        task._timeout = this;
    }

    public void cancelAll() {
        synchronized (this._lock) {
            Task task = this._head;
            Task task2 = this._head;
            Task task3 = this._head;
            task2._prev = task3;
            task._next = task3;
        }
    }

    public Task expired() {
        synchronized (this._lock) {
            long j = this._now - this._duration;
            if (this._head._next != this._head) {
                Task task = this._head._next;
                if (task._timestamp > j) {
                    return null;
                }
                task.unlink();
                task._expired = true;
                return task;
            }
            return null;
        }
    }

    public long getDuration() {
        return this._duration;
    }

    public long getNow() {
        return this._now;
    }

    public long getTimeToNext() {
        synchronized (this._lock) {
            if (this._head._next == this._head) {
                return -1L;
            }
            long j = (this._duration + this._head._next._timestamp) - this._now;
            if (j < 0) {
                j = 0;
            }
            return j;
        }
    }

    public boolean isEmpty() {
        boolean z;
        synchronized (this._lock) {
            z = this._head._next == this._head;
        }
        return z;
    }

    public void schedule(Task task) {
        schedule(task, 0L);
    }

    public void schedule(Task task, long j) {
        synchronized (this._lock) {
            if (task._timestamp != 0) {
                task.unlink();
                task._timestamp = 0L;
            }
            task._timeout = this;
            task._expired = false;
            task._delay = j;
            task._timestamp = this._now + j;
            Task task2 = this._head;
            do {
                task2 = task2._prev;
                if (task2 == this._head) {
                    break;
                }
            } while (task2._timestamp > task._timestamp);
            task2.link(task);
        }
    }

    public void setDuration(long j) {
        this._duration = j;
    }

    public long setNow() {
        long currentTimeMillis = System.currentTimeMillis();
        this._now = currentTimeMillis;
        return currentTimeMillis;
    }

    public void setNow(long j) {
        this._now = j;
    }

    public void tick() {
        Task task;
        long j = this._now - this._duration;
        while (true) {
            try {
                synchronized (this._lock) {
                    task = this._head._next;
                    if (task != this._head && task._timestamp <= j) {
                        task.unlink();
                        task._expired = true;
                        task.expire();
                    }
                    return;
                }
                task.expired();
            } catch (Throwable th) {
                LOG.warn(Log.EXCEPTION, th);
            }
        }
    }

    public void tick(long j) {
        this._now = j;
        tick();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        Task task = this._head;
        while (true) {
            task = task._next;
            if (task != this._head) {
                stringBuffer.append("-->");
                stringBuffer.append(task);
            } else {
                return stringBuffer.toString();
            }
        }
    }
}
