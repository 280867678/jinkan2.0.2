package com.arialyy.aria.http.download;

import android.os.Handler;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.group.AbsSubDLoadUtil;
import com.arialyy.aria.core.group.SubRecordHandler;
import com.arialyy.aria.core.loader.GroupSubThreadStateManager;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.loader.NormalTTBuilder;
import com.arialyy.aria.core.loader.SubLoader;

/* loaded from: classes3.dex */
public final class HttpSubDLoaderUtil extends AbsSubDLoadUtil {
    public HttpSubDLoaderUtil(DTaskWrapper dTaskWrapper, Handler handler, boolean z, String str) {
        super(dTaskWrapper, handler, z, str);
    }

    @Override // com.arialyy.aria.core.group.AbsSubDLoadUtil
    public LoaderStructure buildLoaderStructure() {
        LoaderStructure loaderStructure = new LoaderStructure();
        loaderStructure.addComponent(new SubRecordHandler(getWrapper())).addComponent(new GroupSubThreadStateManager(getSchedulers(), getKey())).addComponent(new NormalTTBuilder(getWrapper(), new HttpDTTBuilderAdapter())).addComponent(new HttpDFileInfoTask(getWrapper()));
        loaderStructure.accept(getLoader());
        return loaderStructure;
    }

    @Override // com.arialyy.aria.core.group.AbsSubDLoadUtil
    public SubLoader getLoader() {
        if (this.mDLoader == null) {
            SubLoader subLoader = new SubLoader(getWrapper(), getSchedulers());
            this.mDLoader = subLoader;
            subLoader.setNeedGetInfo(isNeedGetInfo());
            this.mDLoader.setParentKey(getParentKey());
        }
        return this.mDLoader;
    }
}
