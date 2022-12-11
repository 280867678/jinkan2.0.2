package com.arialyy.aria.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class WeakHandler {
    public final Handler.Callback mCallback;
    public final ExecHandler mExec;
    public Lock mLock;
    public final ChainedRef mRunnables;

    /* loaded from: classes3.dex */
    public static class ChainedRef {
        public Lock lock;
        public ChainedRef next;
        public ChainedRef prev;
        public final Runnable runnable;
        public final WeakRunnable wrapper;

        public ChainedRef(Lock lock, Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.wrapper = new WeakRunnable(new WeakReference(runnable), new WeakReference(this));
        }

        public void insertAfter(ChainedRef chainedRef) {
            this.lock.lock();
            try {
                if (this.next != null) {
                    this.next.prev = chainedRef;
                }
                chainedRef.next = this.next;
                this.next = chainedRef;
                chainedRef.prev = this;
            } finally {
                this.lock.unlock();
            }
        }

        public WeakRunnable remove() {
            this.lock.lock();
            try {
                if (this.prev != null) {
                    this.prev.next = this.next;
                }
                if (this.next != null) {
                    this.next.prev = this.prev;
                }
                this.prev = null;
                this.next = null;
                this.lock.unlock();
                return this.wrapper;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public WeakRunnable remove(Runnable runnable) {
            this.lock.lock();
            try {
                for (ChainedRef chainedRef = this.next; chainedRef != null; chainedRef = chainedRef.next) {
                    if (chainedRef.runnable == runnable) {
                        return chainedRef.remove();
                    }
                }
                this.lock.unlock();
                return null;
            } finally {
                this.lock.unlock();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ExecHandler extends Handler {
        public final WeakReference<Handler.Callback> mCallback;

        public ExecHandler() {
            this.mCallback = null;
        }

        public ExecHandler(Looper looper) {
            super(looper);
            this.mCallback = null;
        }

        public ExecHandler(Looper looper, WeakReference<Handler.Callback> weakReference) {
            super(looper);
            this.mCallback = weakReference;
        }

        public ExecHandler(WeakReference<Handler.Callback> weakReference) {
            this.mCallback = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler.Callback callback;
            WeakReference<Handler.Callback> weakReference = this.mCallback;
            if (weakReference == null || (callback = weakReference.get()) == null) {
                return;
            }
            callback.handleMessage(message);
        }
    }

    /* loaded from: classes3.dex */
    public static class WeakRunnable implements Runnable {
        public final WeakReference<Runnable> mDelegate;
        public final WeakReference<ChainedRef> mReference;

        public WeakRunnable(WeakReference<Runnable> weakReference, WeakReference<ChainedRef> weakReference2) {
            this.mDelegate = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.mDelegate.get();
            ChainedRef chainedRef = this.mReference.get();
            if (chainedRef != null) {
                chainedRef.remove();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public WeakHandler() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = null;
        this.mExec = new ExecHandler();
    }

    public WeakHandler(Handler.Callback callback) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = callback;
        this.mExec = new ExecHandler(new WeakReference(callback));
    }

    public WeakHandler(Looper looper) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = null;
        this.mExec = new ExecHandler(looper);
    }

    public WeakHandler(Looper looper, Handler.Callback callback) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = callback;
        this.mExec = new ExecHandler(looper, new WeakReference(callback));
    }

    private WeakRunnable wrapRunnable(Runnable runnable) {
        if (runnable != null) {
            ChainedRef chainedRef = new ChainedRef(this.mLock, runnable);
            this.mRunnables.insertAfter(chainedRef);
            return chainedRef.wrapper;
        }
        throw new NullPointerException("Runnable can't be null");
    }

    public final Looper getLooper() {
        return this.mExec.getLooper();
    }

    public final boolean hasMessages(int i) {
        return this.mExec.hasMessages(i);
    }

    public final boolean hasMessages(int i, Object obj) {
        return this.mExec.hasMessages(i, obj);
    }

    public final boolean post(Runnable runnable) {
        return this.mExec.post(wrapRunnable(runnable));
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return this.mExec.postAtFrontOfQueue(wrapRunnable(runnable));
    }

    public final boolean postAtTime(Runnable runnable, long j) {
        return this.mExec.postAtTime(wrapRunnable(runnable), j);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        return this.mExec.postAtTime(wrapRunnable(runnable), obj, j);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return this.mExec.postDelayed(wrapRunnable(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        WeakRunnable remove = this.mRunnables.remove(runnable);
        if (remove != null) {
            this.mExec.removeCallbacks(remove);
        }
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        WeakRunnable remove = this.mRunnables.remove(runnable);
        if (remove != null) {
            this.mExec.removeCallbacks(remove, obj);
        }
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.mExec.removeCallbacksAndMessages(obj);
    }

    public final void removeMessages(int i) {
        this.mExec.removeMessages(i);
    }

    public final void removeMessages(int i, Object obj) {
        this.mExec.removeMessages(i, obj);
    }

    public final boolean sendEmptyMessage(int i) {
        return this.mExec.sendEmptyMessage(i);
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        return this.mExec.sendEmptyMessageAtTime(i, j);
    }

    public final boolean sendEmptyMessageDelayed(int i, long j) {
        return this.mExec.sendEmptyMessageDelayed(i, j);
    }

    public final boolean sendMessage(Message message) {
        return this.mExec.sendMessage(message);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        return this.mExec.sendMessageAtFrontOfQueue(message);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        return this.mExec.sendMessageAtTime(message, j);
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        return this.mExec.sendMessageDelayed(message, j);
    }
}
