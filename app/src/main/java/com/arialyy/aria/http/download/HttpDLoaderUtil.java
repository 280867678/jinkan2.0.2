package com.arialyy.aria.http.download;

import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.AbsNormalLoader;
import com.arialyy.aria.core.loader.AbsNormalLoaderUtil;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.loader.NormalLoader;
import com.arialyy.aria.core.loader.NormalTTBuilder;
import com.arialyy.aria.core.loader.NormalThreadStateManager;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.http.HttpRecordHandler;
import com.arialyy.aria.http.HttpTaskOption;

/* loaded from: classes3.dex */
public final class HttpDLoaderUtil extends AbsNormalLoaderUtil {
    public HttpDLoaderUtil(AbsTaskWrapper absTaskWrapper, IEventListener iEventListener) {
        super(absTaskWrapper, iEventListener);
        absTaskWrapper.generateTaskOption(HttpTaskOption.class);
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoaderUtil
    public LoaderStructure BuildLoaderStructure() {
        LoaderStructure loaderStructure = new LoaderStructure();
        loaderStructure.addComponent(new HttpRecordHandler(mo4449getTaskWrapper())).addComponent(new NormalThreadStateManager(getListener())).addComponent(new HttpDFileInfoTask((DTaskWrapper) mo4449getTaskWrapper())).addComponent(new NormalTTBuilder(mo4449getTaskWrapper(), new HttpDTTBuilderAdapter()));
        loaderStructure.accept(mo4445getLoader());
        return loaderStructure;
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoaderUtil
    /* renamed from: getLoader */
    public AbsNormalLoader mo4445getLoader() {
        AbsNormalLoader absNormalLoader = this.mLoader;
        return absNormalLoader == null ? new NormalLoader(mo4449getTaskWrapper(), getListener()) : absNormalLoader;
    }
}
