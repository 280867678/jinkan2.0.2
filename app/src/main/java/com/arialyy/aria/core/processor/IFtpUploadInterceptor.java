package com.arialyy.aria.core.processor;

import com.arialyy.aria.core.inf.IEventHandler;
import com.arialyy.aria.core.upload.UploadEntity;
import java.util.List;

/* loaded from: classes3.dex */
public interface IFtpUploadInterceptor extends IEventHandler {
    FtpInterceptHandler onIntercept(UploadEntity uploadEntity, List<String> list);
}
