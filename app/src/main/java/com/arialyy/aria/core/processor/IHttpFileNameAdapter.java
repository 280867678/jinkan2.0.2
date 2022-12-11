package com.arialyy.aria.core.processor;

import com.arialyy.aria.core.inf.IEventHandler;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IHttpFileNameAdapter extends IEventHandler {
    String handleFileName(Map<String, List<String>> map, String str);
}
