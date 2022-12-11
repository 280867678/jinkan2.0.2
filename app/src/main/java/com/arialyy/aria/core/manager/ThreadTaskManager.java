package com.arialyy.aria.core.manager;

import android.text.TextUtils;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class ThreadTaskManager {
    public static final int CORE_POOL_NUM = 20;
    public static volatile ThreadTaskManager INSTANCE;
    public static final ReentrantLock LOCK = new ReentrantLock();
    public ThreadPoolExecutor mExePool;
    public final String TAG = CommonUtil.getClassName(this);
    public Map<String, Set<FutureContainer>> mThreadTasks = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public class FutureContainer {
        public Future future;
        public IThreadTask threadTask;

        public FutureContainer() {
        }
    }

    public ThreadTaskManager() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
        this.mExePool = threadPoolExecutor;
        threadPoolExecutor.allowsCoreThreadTimeOut();
    }

    public static synchronized ThreadTaskManager getInstance() {
        ThreadTaskManager threadTaskManager;
        synchronized (ThreadTaskManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new ThreadTaskManager();
            }
            threadTaskManager = INSTANCE;
        }
        return threadTaskManager;
    }

    private String getKey(String str) {
        return CommonUtil.getStrMd5(str);
    }

    public void removeAllThreadTask() {
        try {
            if (this.mThreadTasks.isEmpty()) {
                return;
            }
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
                for (Set<FutureContainer> set : this.mThreadTasks.values()) {
                    for (FutureContainer futureContainer : set) {
                        if (!futureContainer.future.isDone() && !futureContainer.future.isCancelled()) {
                            futureContainer.threadTask.destroy();
                        }
                    }
                    set.clear();
                }
                this.mThreadTasks.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            LOCK.unlock();
        }
    }

    public boolean removeSingleTaskThread(String str, IThreadTask iThreadTask) {
        String str2;
        String str3;
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                str2 = this.TAG;
                str3 = "线程池已经关闭";
            } else if (iThreadTask != null) {
                Set<FutureContainer> set = this.mThreadTasks.get(getKey(str));
                if (set != null && set.size() > 0) {
                    FutureContainer futureContainer = null;
                    Iterator<FutureContainer> it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FutureContainer next = it.next();
                        if (next.threadTask == iThreadTask) {
                            futureContainer = next;
                            break;
                        }
                    }
                    if (futureContainer != null) {
                        iThreadTask.destroy();
                        set.remove(futureContainer);
                        return true;
                    }
                }
                return false;
            } else {
                str2 = this.TAG;
                str3 = "线程任务为空";
            }
            ALog.m4191e(str2, str3);
            return false;
        } finally {
            LOCK.unlock();
        }
    }

    public boolean removeSingleTaskThread(String str, String str2) {
        String str3;
        String str4;
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                str3 = this.TAG;
                str4 = "线程池已经关闭";
            } else if (!TextUtils.isEmpty(str2)) {
                Set<FutureContainer> set = this.mThreadTasks.get(getKey(str));
                if (set != null && set.size() > 0) {
                    FutureContainer futureContainer = null;
                    Iterator<FutureContainer> it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FutureContainer next = it.next();
                        if (next.threadTask.getThreadName().equals(str2)) {
                            futureContainer = next;
                            break;
                        }
                    }
                    if (futureContainer != null) {
                        futureContainer.threadTask.destroy();
                        set.remove(futureContainer);
                        return true;
                    }
                }
                return false;
            } else {
                str3 = this.TAG;
                str4 = "线程名为空";
            }
            ALog.m4191e(str3, str4);
            return false;
        } finally {
            LOCK.unlock();
        }
    }

    public void removeTaskThread(String str) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.m4191e(this.TAG, "线程池已经关闭");
                return;
            }
            String key = getKey(str);
            Set<FutureContainer> set = this.mThreadTasks.get(key);
            if (set != null && set.size() > 0) {
                for (FutureContainer futureContainer : set) {
                    if (!futureContainer.future.isDone() && !futureContainer.future.isCancelled()) {
                        futureContainer.threadTask.destroy();
                    }
                }
                set.clear();
                this.mThreadTasks.remove(key);
            }
        } finally {
            LOCK.unlock();
        }
    }

    public void retryThread(IThreadTask iThreadTask) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.m4191e(this.TAG, "线程池已经关闭");
            } else {
                if (iThreadTask != null) {
                    try {
                        if (!iThreadTask.isDestroy()) {
                            this.mExePool.submit(iThreadTask);
                            return;
                        }
                    } catch (Exception e2) {
                        ALog.m4190e(this.TAG, "", e2);
                    }
                }
                ALog.m4191e(this.TAG, "线程为空或线程已经中断");
            }
        } finally {
            LOCK.unlock();
        }
    }

    public void startThread(String str, IThreadTask iThreadTask) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.m4191e(this.TAG, "线程池已经关闭");
                return;
            }
            String key = getKey(str);
            Set<FutureContainer> set = this.mThreadTasks.get(key);
            if (set == null) {
                set = new HashSet<>();
                this.mThreadTasks.put(key, set);
            }
            FutureContainer futureContainer = new FutureContainer();
            futureContainer.threadTask = iThreadTask;
            futureContainer.future = this.mExePool.submit(iThreadTask);
            set.add(futureContainer);
        } finally {
            LOCK.unlock();
        }
    }

    public boolean taskIsRunning(String str) {
        return this.mThreadTasks.get(getKey(str)) != null;
    }
}
