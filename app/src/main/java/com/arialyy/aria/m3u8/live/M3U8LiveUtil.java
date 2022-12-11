package com.arialyy.aria.m3u8.live;

import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.AbsNormalLoader;
import com.arialyy.aria.core.loader.AbsNormalLoaderUtil;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.http.HttpTaskOption;
import com.arialyy.aria.m3u8.M3U8InfoTask;
import com.arialyy.aria.m3u8.M3U8Listener;
import com.arialyy.aria.m3u8.M3U8TaskOption;

/* loaded from: classes3.dex */
public class M3U8LiveUtil extends AbsNormalLoaderUtil {
    public M3U8LiveUtil(AbsTaskWrapper absTaskWrapper, IEventListener iEventListener) {
        super(absTaskWrapper, iEventListener);
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoaderUtil
    public LoaderStructure BuildLoaderStructure() {
        LoaderStructure loaderStructure = new LoaderStructure();
        loaderStructure.addComponent(new LiveRecordHandler(mo4449getTaskWrapper())).addComponent(new M3U8InfoTask(mo4449getTaskWrapper())).addComponent(new LiveStateManager(mo4449getTaskWrapper(), getListener()));
        loaderStructure.accept(mo4445getLoader());
        return loaderStructure;
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoaderUtil
    /* renamed from: getLoader  reason: collision with other method in class */
    public M3U8LiveLoader mo4445getLoader() {
        mo4449getTaskWrapper().generateM3u8Option(M3U8TaskOption.class);
        mo4449getTaskWrapper().generateTaskOption(HttpTaskOption.class);
        AbsNormalLoader absNormalLoader = this.mLoader;
        return absNormalLoader == null ? new M3U8LiveLoader(mo4449getTaskWrapper(), (M3U8Listener) getListener()) : (M3U8LiveLoader) absNormalLoader;
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoaderUtil
    /* renamed from: getTaskWrapper */
    public DTaskWrapper mo4449getTaskWrapper() {
        return (DTaskWrapper) super.mo4449getTaskWrapper();
    }
}
