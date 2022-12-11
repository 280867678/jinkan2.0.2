package com.arialyy.aria.http.download;

import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.CompleteInfo;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.listener.DownloadGroupListener;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.http.HttpTaskOption;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class HttpDGInfoTask implements IInfoTask {
    public IInfoTask.Callback callback;
    public DownloadGroupListener listener;
    public DGTaskWrapper wrapper;
    public String TAG = CommonUtil.getClassName(this);
    public final Object LOCK = new Object();
    public ExecutorService mPool = null;
    public boolean getLenComplete = false;
    public AtomicInteger count = new AtomicInteger();
    public AtomicInteger failCount = new AtomicInteger();
    public IInfoTask.Callback subCallback = new IInfoTask.Callback() { // from class: com.arialyy.aria.http.download.HttpDGInfoTask.1
        @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
        public void onFail(AbsEntity absEntity, AriaException ariaException, boolean z) {
            DownloadEntity downloadEntity = (DownloadEntity) absEntity;
            ALog.m4191e(HttpDGInfoTask.this.TAG, String.format("获取文件信息失败，url：%s", downloadEntity.getUrl()));
            HttpDGInfoTask.this.count.getAndIncrement();
            HttpDGInfoTask.this.failCount.getAndIncrement();
            HttpDGInfoTask.this.listener.onSubFail(downloadEntity, new AriaHTTPException(HttpDGInfoTask.this.TAG, String.format("子任务获取文件长度失败，url：%s", downloadEntity.getUrl())));
            HttpDGInfoTask httpDGInfoTask = HttpDGInfoTask.this;
            httpDGInfoTask.checkGetSizeComplete(httpDGInfoTask.count.get(), HttpDGInfoTask.this.failCount.get());
        }

        @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
        public void onSucceed(String str, CompleteInfo completeInfo) {
            HttpDGInfoTask.this.count.getAndIncrement();
            HttpDGInfoTask httpDGInfoTask = HttpDGInfoTask.this;
            httpDGInfoTask.checkGetSizeComplete(httpDGInfoTask.count.get(), HttpDGInfoTask.this.failCount.get());
            ALog.m4192d(HttpDGInfoTask.this.TAG, "获取子任务信息完成");
        }
    };

    public HttpDGInfoTask(DGTaskWrapper dGTaskWrapper, DownloadGroupListener downloadGroupListener) {
        this.wrapper = dGTaskWrapper;
        this.listener = downloadGroupListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGetSizeComplete(int i, int i2) {
        if (i2 == this.wrapper.getSubTaskWrapper().size()) {
            this.callback.onFail(this.wrapper.mo4442getEntity(), new AriaHTTPException(this.TAG, "获取子任务长度失败"), false);
            notifyLock();
        } else if (i == this.wrapper.getSubTaskWrapper().size()) {
            long j = 0;
            for (DTaskWrapper dTaskWrapper : this.wrapper.getSubTaskWrapper()) {
                j += dTaskWrapper.mo4442getEntity().getFileSize();
            }
            ((DownloadGroupEntity) this.wrapper.mo4442getEntity()).setConvertFileSize(CommonUtil.formatFileSize(j));
            ((DownloadGroupEntity) this.wrapper.mo4442getEntity()).setFileSize(j);
            ((DownloadGroupEntity) this.wrapper.mo4442getEntity()).update();
            this.getLenComplete = true;
            ALog.m4192d(this.TAG, String.format("获取组合任务长度完成，组合任务总长度：%s，失败的子任务数：%s", Long.valueOf(j), Integer.valueOf(i2)));
            this.callback.onSucceed(this.wrapper.getKey(), new CompleteInfo());
            notifyLock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cloneHeader(DTaskWrapper dTaskWrapper) {
        HttpTaskOption httpTaskOption = (HttpTaskOption) this.wrapper.getTaskOption();
        HttpTaskOption httpTaskOption2 = new HttpTaskOption();
        httpTaskOption2.setFileLenAdapter(httpTaskOption.getFileLenAdapter());
        httpTaskOption2.setFileNameAdapter(httpTaskOption.getFileNameAdapter());
        httpTaskOption2.setUseServerFileName(httpTaskOption.isUseServerFileName());
        httpTaskOption2.setFileNameAdapter(httpTaskOption.getFileNameAdapter());
        httpTaskOption2.setRequestEnum(httpTaskOption.getRequestEnum());
        httpTaskOption2.setHeaders(httpTaskOption.getHeaders());
        httpTaskOption2.setProxy(httpTaskOption.getProxy());
        httpTaskOption2.setParams(httpTaskOption.getParams());
        dTaskWrapper.setTaskOption(httpTaskOption2);
    }

    private void getGroupSize() {
        new Thread(new Runnable() { // from class: com.arialyy.aria.http.download.HttpDGInfoTask.2
            @Override // java.lang.Runnable
            public void run() {
                for (DTaskWrapper dTaskWrapper : HttpDGInfoTask.this.wrapper.getSubTaskWrapper()) {
                    DownloadEntity mo4442getEntity = dTaskWrapper.mo4442getEntity();
                    if (mo4442getEntity.getFileSize() > 0) {
                        HttpDGInfoTask.this.count.getAndIncrement();
                        if (mo4442getEntity.getCurrentProgress() < mo4442getEntity.getFileSize()) {
                            HttpDGInfoTask.this.cloneHeader(dTaskWrapper);
                        }
                        HttpDGInfoTask httpDGInfoTask = HttpDGInfoTask.this;
                        httpDGInfoTask.checkGetSizeComplete(httpDGInfoTask.count.get(), HttpDGInfoTask.this.failCount.get());
                    } else {
                        HttpDGInfoTask.this.cloneHeader(dTaskWrapper);
                        HttpDFileInfoTask httpDFileInfoTask = new HttpDFileInfoTask(dTaskWrapper);
                        httpDFileInfoTask.setCallback(HttpDGInfoTask.this.subCallback);
                        HttpDGInfoTask.this.mPool.execute(httpDFileInfoTask);
                    }
                }
            }
        }).start();
    }

    private void notifyLock() {
        synchronized (this.LOCK) {
            this.LOCK.notifyAll();
        }
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.loader.IInfoTask, java.lang.Runnable
    public void run() {
        if (this.mPool != null && !this.getLenComplete) {
            ALog.m4192d(this.TAG, "获取长度未完成的情况下，停止组合任务");
            this.mPool.shutdown();
            this.listener.onStop(0L);
        } else if (!this.wrapper.isUnknownSize()) {
            for (DTaskWrapper dTaskWrapper : this.wrapper.getSubTaskWrapper()) {
                cloneHeader(dTaskWrapper);
            }
            this.callback.onSucceed(this.wrapper.getKey(), new CompleteInfo());
        } else {
            this.mPool = Executors.newCachedThreadPool();
            getGroupSize();
            try {
                synchronized (this.LOCK) {
                    this.LOCK.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.mPool.isShutdown()) {
                return;
            }
            this.mPool.shutdown();
        }
    }

    @Override // com.arialyy.aria.core.loader.IInfoTask
    public void setCallback(IInfoTask.Callback callback) {
        this.callback = callback;
    }
}
