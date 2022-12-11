package com.arialyy.aria.core.group;

import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class SimpleSubQueue implements ISubQueue<AbsSubDLoadUtil> {
    public final String TAG = CommonUtil.getClassName(SimpleSubQueue.class);
    public Map<String, AbsSubDLoadUtil> mCache = new LinkedHashMap();
    public Map<String, AbsSubDLoadUtil> mExec = new LinkedHashMap();
    public boolean isStopAll = false;
    public int mExecSize = Configuration.getInstance().dGroupCfg.getSubMaxTaskNum();

    public static SimpleSubQueue newInstance() {
        return new SimpleSubQueue();
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void addTask(AbsSubDLoadUtil absSubDLoadUtil) {
        this.mCache.put(absSubDLoadUtil.getKey(), absSubDLoadUtil);
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void clear() {
        this.mCache.clear();
        this.mExec.clear();
    }

    public int getCacheSize() {
        return this.mCache.size();
    }

    public synchronized AbsSubDLoadUtil getLoaderUtil(String str) {
        AbsSubDLoadUtil absSubDLoadUtil = this.mExec.get(str);
        if (absSubDLoadUtil != null) {
            return absSubDLoadUtil;
        }
        return this.mCache.get(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.arialyy.aria.core.group.ISubQueue
    /* renamed from: getNextTask */
    public AbsSubDLoadUtil mo4428getNextTask() {
        Iterator<String> it = this.mCache.keySet().iterator();
        if (it.hasNext()) {
            return this.mCache.get(it.next());
        }
        return null;
    }

    public boolean isStopAll() {
        return this.isStopAll;
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void modifyMaxExecNum(int i) {
        int i2 = 0;
        if (i < 1) {
            ALog.m4191e(this.TAG, String.format("修改组合任务子任务队列数失败，num: %s", Integer.valueOf(i)));
            return;
        }
        int i3 = this.mExecSize;
        if (i == i3) {
            ALog.m4189i(this.TAG, String.format("忽略此次修改，oldSize: %s, num: %s", Integer.valueOf(i3), Integer.valueOf(i)));
            return;
        }
        this.mExecSize = i;
        int abs = Math.abs(i3 - i);
        if (i3 >= i) {
            if (this.mExec.size() >= i) {
                return;
            }
            while (i2 < abs) {
                AbsSubDLoadUtil mo4428getNextTask = mo4428getNextTask();
                if (mo4428getNextTask != null) {
                    startTask(mo4428getNextTask);
                } else {
                    ALog.m4192d(this.TAG, "子任务中没有缓存任务");
                }
                i2++;
            }
        } else if (this.mExec.size() > i) {
            Set<String> keySet = this.mExec.keySet();
            ArrayList arrayList = new ArrayList();
            for (String str : keySet) {
                if (i2 > i) {
                    arrayList.add(this.mExec.get(str));
                }
                i2++;
            }
            Collection<AbsSubDLoadUtil> values = this.mCache.values();
            this.mCache.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                addTask((AbsSubDLoadUtil) it.next());
            }
            for (AbsSubDLoadUtil absSubDLoadUtil : values) {
                addTask(absSubDLoadUtil);
            }
        }
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void removeAllTask() {
        ALog.m4192d(this.TAG, "删除组合任务");
        for (String str : this.mExec.keySet()) {
            AbsSubDLoadUtil absSubDLoadUtil = this.mExec.get(str);
            if (absSubDLoadUtil != null) {
                ALog.m4192d(this.TAG, String.format("停止子任务：%s", absSubDLoadUtil.getEntity().getFileName()));
                absSubDLoadUtil.cancel();
            }
        }
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void removeTask(AbsSubDLoadUtil absSubDLoadUtil) {
        removeTaskFromExecQ(absSubDLoadUtil);
        this.mCache.remove(absSubDLoadUtil.getKey());
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void removeTaskFromExecQ(AbsSubDLoadUtil absSubDLoadUtil) {
        this.mExec.remove(absSubDLoadUtil.getKey());
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void startTask(AbsSubDLoadUtil absSubDLoadUtil) {
        if (this.mExec.size() >= this.mExecSize) {
            ALog.m4192d(this.TAG, String.format("执行队列已满，任务进入缓存器中，key: %s", absSubDLoadUtil.getKey()));
            addTask(absSubDLoadUtil);
            return;
        }
        this.mCache.remove(absSubDLoadUtil.getKey());
        this.mExec.put(absSubDLoadUtil.getKey(), absSubDLoadUtil);
        ALog.m4192d(this.TAG, String.format("开始执行子任务：%s", absSubDLoadUtil.getEntity().getFileName()));
        absSubDLoadUtil.run();
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void stopAllTask() {
        this.isStopAll = true;
        ALog.m4192d(this.TAG, "停止组合任务");
        for (String str : this.mExec.keySet()) {
            AbsSubDLoadUtil absSubDLoadUtil = this.mExec.get(str);
            if (absSubDLoadUtil != null) {
                ALog.m4192d(this.TAG, String.format("停止子任务：%s", absSubDLoadUtil.getEntity().getFileName()));
                absSubDLoadUtil.stop();
            }
        }
    }

    @Override // com.arialyy.aria.core.group.ISubQueue
    public void stopTask(AbsSubDLoadUtil absSubDLoadUtil) {
        absSubDLoadUtil.stop();
        this.mExec.remove(absSubDLoadUtil.getKey());
    }
}
