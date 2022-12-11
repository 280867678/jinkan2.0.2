package com.arialyy.aria.core.manager;

import android.util.LruCache;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class TaskWrapperManager {
    public static volatile TaskWrapperManager INSTANCE = null;
    public static final String TAG = "TaskWrapperManager";
    public LruCache<String, AbsTaskWrapper> cache = new LruCache<>(1024);
    public Lock lock = new ReentrantLock();

    private IGroupWrapperFactory chooseGroupFactory(Class cls) {
        if (cls == DGTaskWrapper.class) {
            return DGTaskWrapperFactory.getInstance();
        }
        return null;
    }

    private INormalTEFactory chooseNormalFactory(Class cls) {
        if (cls == DTaskWrapper.class) {
            return DTaskWrapperFactory.getInstance();
        }
        if (cls != UTaskWrapper.class) {
            return null;
        }
        return UTaskWrapperFactory.getInstance();
    }

    private String convertKey(Class cls, long j) {
        return CommonUtil.keyToHashKey(cls.getName() + j);
    }

    public static TaskWrapperManager getInstance() {
        if (INSTANCE == null) {
            synchronized (TaskWrapperManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskWrapperManager();
                }
            }
        }
        return INSTANCE;
    }

    public <TW extends AbsTaskWrapper> TW getGroupWrapper(Class<TW> cls, long j) {
        Lock lock = this.lock;
        lock.lock();
        try {
            TW tw = (TW) this.cache.get(convertKey(cls, j));
            if (tw == null || tw.getClass() != cls) {
                IGroupWrapperFactory chooseGroupFactory = chooseGroupFactory(cls);
                if (chooseGroupFactory == null) {
                    ALog.m4191e(TAG, "任务实体创建失败");
                    return null;
                }
                tw = (TW) chooseGroupFactory.mo4429getGroupWrapper(j);
                putTaskWrapper(tw);
            }
            return tw;
        } finally {
            lock.unlock();
        }
    }

    public <TW extends AbsTaskWrapper> TW getNormalTaskWrapper(Class<TW> cls, long j) {
        Lock lock = this.lock;
        lock.lock();
        try {
            TW tw = (TW) this.cache.get(convertKey(cls, j));
            if (tw == null || tw.getClass() != cls) {
                INormalTEFactory chooseNormalFactory = chooseNormalFactory(cls);
                if (chooseNormalFactory == null) {
                    ALog.m4191e(TAG, "任务实体创建失败");
                    return null;
                }
                tw = (TW) chooseNormalFactory.mo4431create(j);
                putTaskWrapper(tw);
            }
            return tw;
        } finally {
            lock.unlock();
        }
    }

    public void putTaskWrapper(AbsTaskWrapper absTaskWrapper) {
        if (absTaskWrapper == null) {
            ALog.m4191e(TAG, "任务实体添加失败");
        } else if (absTaskWrapper.mo4442getEntity() == null || absTaskWrapper.mo4442getEntity().getId() == -1) {
        } else {
            Lock lock = this.lock;
            lock.lock();
            try {
                this.cache.put(convertKey(absTaskWrapper.getClass(), absTaskWrapper.mo4442getEntity().getId()), absTaskWrapper);
            } finally {
                lock.unlock();
            }
        }
    }

    public void removeTaskWrapper(AbsTaskWrapper absTaskWrapper) {
        Lock lock = this.lock;
        lock.lock();
        try {
            this.cache.remove(convertKey(absTaskWrapper.getClass(), absTaskWrapper.mo4442getEntity().getId()));
        } finally {
            lock.unlock();
        }
    }
}
