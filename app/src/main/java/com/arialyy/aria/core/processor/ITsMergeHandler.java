package com.arialyy.aria.core.processor;

import com.arialyy.aria.core.download.M3U8Entity;
import com.arialyy.aria.core.inf.IEventHandler;
import java.util.List;

/* loaded from: classes3.dex */
public interface ITsMergeHandler extends IEventHandler {
    boolean merge(M3U8Entity m3U8Entity, List<String> list);
}
