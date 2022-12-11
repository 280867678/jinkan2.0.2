package com.arialyy.aria.http.upload;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.AbsNormalLoader;
import com.arialyy.aria.core.loader.AbsNormalLoaderUtil;
import com.arialyy.aria.core.loader.AbsNormalTTBuilderAdapter;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.loader.NormalTTBuilder;
import com.arialyy.aria.core.loader.NormalThreadStateManager;
import com.arialyy.aria.core.task.IThreadTaskAdapter;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.http.HttpRecordHandler;
import com.arialyy.aria.http.HttpTaskOption;

/* loaded from: classes3.dex */
public final class HttpULoaderUtil extends AbsNormalLoaderUtil {
    public HttpULoaderUtil(AbsTaskWrapper absTaskWrapper, IEventListener iEventListener) {
        super(absTaskWrapper, iEventListener);
        absTaskWrapper.generateTaskOption(HttpTaskOption.class);
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoaderUtil
    public LoaderStructure BuildLoaderStructure() {
        LoaderStructure loaderStructure = new LoaderStructure();
        loaderStructure.addComponent(new HttpRecordHandler(mo4449getTaskWrapper())).addComponent(new NormalThreadStateManager(getListener())).addComponent(new NormalTTBuilder(mo4449getTaskWrapper(), new AbsNormalTTBuilderAdapter() { // from class: com.arialyy.aria.http.upload.HttpULoaderUtil.1
            @Override // com.arialyy.aria.core.loader.AbsNormalTTBuilderAdapter
            public IThreadTaskAdapter getAdapter(SubThreadConfig subThreadConfig) {
                return new HttpUThreadTaskAdapter(subThreadConfig);
            }

            @Override // com.arialyy.aria.core.loader.AbsNormalTTBuilderAdapter
            public boolean handleNewTask(TaskRecord taskRecord, int i) {
                return true;
            }
        }));
        loaderStructure.accept(mo4445getLoader());
        return loaderStructure;
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoaderUtil
    /* renamed from: getLoader */
    public AbsNormalLoader mo4445getLoader() {
        AbsNormalLoader absNormalLoader = this.mLoader;
        return absNormalLoader == null ? new HttpULoader((UTaskWrapper) mo4449getTaskWrapper(), getListener()) : absNormalLoader;
    }
}
