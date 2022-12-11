package com.arialyy.aria.core.group;

import android.os.Handler;
import android.os.Looper;
import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.listener.IDGroupListener;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.loader.ILoader;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.loader.IThreadTaskBuilder;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class AbsGroupLoader implements ILoaderVisitor, ILoader {
    public DGTaskWrapper mGTWrapper;
    public IInfoTask mInfoTask;
    public IDGroupListener mListener;
    public Handler mScheduler;
    public GroupRunState mState;
    public ScheduledThreadPoolExecutor mTimer;
    public final String TAG = CommonUtil.getClassName((Class) getClass());
    public long mCurrentLocation = 0;
    public boolean isStop = false;
    public boolean isCancel = false;
    public SimpleSubQueue mSubQueue = SimpleSubQueue.newInstance();
    public Map<String, AbsSubDLoadUtil> mExeLoader = new WeakHashMap();
    public Map<String, DTaskWrapper> mCache = new WeakHashMap();
    public long mUpdateInterval = Configuration.getInstance().downloadCfg.getUpdateInterval();

    public AbsGroupLoader(AbsTaskWrapper absTaskWrapper, IEventListener iEventListener) {
        this.mListener = (IDGroupListener) iEventListener;
        this.mGTWrapper = (DGTaskWrapper) absTaskWrapper;
    }

    private void checkComponent() {
        if (this.mInfoTask != null) {
            return;
        }
        throw new NullPointerException("文件信息组件为空");
    }

    private long checkFileExists(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        File file2 = new File(String.format(IRecordHandler.SUB_PATH, str, 0));
        if (!file2.exists()) {
            return -1L;
        }
        return file2.length();
    }

    private boolean checkSubTask(String str, String str2) {
        String str3;
        StringBuilder sb;
        String str4;
        DTaskWrapper dTaskWrapper = this.mCache.get(str);
        if (dTaskWrapper == null) {
            str3 = this.TAG;
            sb = new StringBuilder();
            sb.append("任务组中没有该任务【");
            sb.append(str);
            str4 = "】，";
        } else if (dTaskWrapper.getState() != 1) {
            return true;
        } else {
            str3 = this.TAG;
            sb = new StringBuilder();
            sb.append("任务【");
            sb.append(str);
            str4 = "】已完成，";
        }
        sb.append(str4);
        sb.append(str2);
        sb.append("失败");
        ALog.m4185w(str3, sb.toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void closeTimer() {
        if (this.mTimer != null && !this.mTimer.isShutdown()) {
            this.mTimer.shutdown();
        }
    }

    private AbsSubDLoadUtil getDownloader(String str, boolean z) {
        AbsSubDLoadUtil absSubDLoadUtil = this.mExeLoader.get(str);
        return absSubDLoadUtil == null ? createSubLoader(this.mCache.get(str), z) : absSubDLoadUtil;
    }

    private void initState(Looper looper) {
        long j;
        long currentProgress;
        this.mState = new GroupRunState(getWrapper().getKey(), this.mListener, this.mSubQueue);
        for (DTaskWrapper dTaskWrapper : this.mGTWrapper.getSubTaskWrapper()) {
            long checkFileExists = checkFileExists(dTaskWrapper.mo4442getEntity().getFilePath());
            if (dTaskWrapper.mo4442getEntity().getState() == 1 && checkFileExists > 0 && checkFileExists == dTaskWrapper.mo4442getEntity().getFileSize()) {
                j = this.mCurrentLocation;
                currentProgress = dTaskWrapper.mo4442getEntity().getFileSize();
            } else {
                if (checkFileExists <= 0) {
                    dTaskWrapper.mo4442getEntity().setCurrentProgress(0L);
                }
                dTaskWrapper.mo4442getEntity().setState(6);
                this.mCache.put(dTaskWrapper.getKey(), dTaskWrapper);
                j = this.mCurrentLocation;
                currentProgress = dTaskWrapper.mo4442getEntity().getCurrentProgress();
            }
            this.mCurrentLocation = currentProgress + j;
        }
        if (getWrapper().getSubTaskWrapper().size() != this.mState.getCompleteNum()) {
            getWrapper().setState(6);
        }
        this.mState.updateProgress(this.mCurrentLocation);
        this.mScheduler = new Handler(looper, SimpleSchedulers.newInstance(this.mState, this.mGTWrapper.getKey()));
    }

    private void startRunningFlow() {
        closeTimer();
        Looper.prepare();
        Looper myLooper = Looper.myLooper();
        if (myLooper != Looper.getMainLooper()) {
            initState(myLooper);
            getState().setSubSize(getWrapper().getSubTaskWrapper().size());
            if (getState().getCompleteNum() != 0 && getState().getCompleteNum() == getState().getSubSize()) {
                this.mListener.onComplete();
                return;
            }
            startTimer();
            handlerTask(myLooper);
            Looper.loop();
            return;
        }
        throw new IllegalThreadStateException("不能在主线程程序中调用Loader");
    }

    private synchronized void startTimer() {
        this.mState.isRunning.set(true);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.mTimer = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.arialyy.aria.core.group.AbsGroupLoader.1
            @Override // java.lang.Runnable
            public void run() {
                if (!AbsGroupLoader.this.mState.isRunning.get()) {
                    AbsGroupLoader.this.closeTimer();
                    return;
                }
                long j = 0;
                if (AbsGroupLoader.this.mCurrentLocation < 0) {
                    return;
                }
                for (DTaskWrapper dTaskWrapper : AbsGroupLoader.this.mGTWrapper.getSubTaskWrapper()) {
                    int state = dTaskWrapper.getState();
                    DownloadEntity mo4442getEntity = dTaskWrapper.mo4442getEntity();
                    j = (state == 1 ? mo4442getEntity.getFileSize() : mo4442getEntity.getCurrentProgress()) + j;
                }
                AbsGroupLoader.this.mCurrentLocation = j;
                AbsGroupLoader.this.mState.updateProgress(AbsGroupLoader.this.mCurrentLocation);
                AbsGroupLoader.this.mListener.onProgress(j);
            }
        }, 0L, this.mUpdateInterval, TimeUnit.MILLISECONDS);
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    @Deprecated
    public void addComponent(IThreadStateManager iThreadStateManager) {
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    @Deprecated
    public void addComponent(IRecordHandler iRecordHandler) {
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    @Deprecated
    public void addComponent(IThreadTaskBuilder iThreadTaskBuilder) {
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public void cancel() {
        this.isCancel = true;
        closeTimer();
        this.mSubQueue.removeAllTask();
        this.mListener.onCancel();
    }

    public abstract AbsSubDLoadUtil createSubLoader(DTaskWrapper dTaskWrapper, boolean z);

    public void fail(AriaException ariaException, boolean z) {
        closeTimer();
        getListener().onFail(z, ariaException);
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public long getCurrentProgress() {
        return this.mCurrentLocation;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public String getKey() {
        return this.mGTWrapper.getKey();
    }

    public IDGroupListener getListener() {
        return this.mListener;
    }

    public Handler getScheduler() {
        return this.mScheduler;
    }

    public GroupRunState getState() {
        return this.mState;
    }

    public DGTaskWrapper getWrapper() {
        return this.mGTWrapper;
    }

    public abstract void handlerTask(Looper looper);

    @Override // com.arialyy.aria.core.loader.ILoader
    public boolean isBreak() {
        if (this.isCancel || this.isStop) {
            ALog.m4192d(this.TAG, String.format("任务【%s】已停止或取消了", this.mGTWrapper.getKey()));
            return true;
        }
        return false;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public boolean isRunning() {
        GroupRunState groupRunState = this.mState;
        return groupRunState != null && groupRunState.isRunning.get();
    }

    public void onPostStart() {
        if (isBreak()) {
            return;
        }
        getListener().onPostPre(((DownloadGroupEntity) getWrapper().mo4442getEntity()).getFileSize());
        int i = (((DownloadGroupEntity) getWrapper().mo4442getEntity()).getFileSize() > 0L ? 1 : (((DownloadGroupEntity) getWrapper().mo4442getEntity()).getFileSize() == 0L ? 0 : -1));
        IDGroupListener listener = getListener();
        long currentProgress = ((DownloadGroupEntity) getWrapper().mo4442getEntity()).getCurrentProgress();
        if (i > 0) {
            listener.onResume(currentProgress);
        } else {
            listener.onStart(currentProgress);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        checkComponent();
        if (this.isStop || this.isCancel) {
            closeTimer();
        } else {
            startRunningFlow();
        }
    }

    public void startSubLoader(AbsSubDLoadUtil absSubDLoadUtil) {
        this.mExeLoader.put(absSubDLoadUtil.getKey(), absSubDLoadUtil);
        this.mSubQueue.startTask(absSubDLoadUtil);
    }

    public void startSubTask(String str) {
        if (!checkSubTask(str, "开始")) {
            return;
        }
        if (!this.mState.isRunning.get()) {
            startTimer();
        }
        AbsSubDLoadUtil downloader = getDownloader(str, false);
        if (downloader == null || downloader.isRunning()) {
            return;
        }
        this.mSubQueue.startTask(downloader);
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public void stop() {
        this.isStop = true;
        this.mSubQueue.stopAllTask();
        closeTimer();
    }

    public void stopSubTask(String str) {
        AbsSubDLoadUtil downloader;
        if (checkSubTask(str, "停止") && (downloader = getDownloader(str, false)) != null && downloader.isRunning()) {
            this.mSubQueue.stopTask(downloader);
        }
    }
}
