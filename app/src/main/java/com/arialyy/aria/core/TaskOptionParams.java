package com.arialyy.aria.core;

import com.arialyy.aria.core.common.BaseOption;
import com.arialyy.aria.core.inf.IEventHandler;
import com.arialyy.aria.core.processor.FtpInterceptHandler;
import com.arialyy.aria.core.processor.IBandWidthUrlConverter;
import com.arialyy.aria.core.processor.IFtpUploadInterceptor;
import com.arialyy.aria.core.processor.IHttpFileLenAdapter;
import com.arialyy.aria.core.processor.IHttpFileNameAdapter;
import com.arialyy.aria.core.processor.IKeyUrlConverter;
import com.arialyy.aria.core.processor.ILiveTsUrlConverter;
import com.arialyy.aria.core.processor.ITsMergeHandler;
import com.arialyy.aria.core.processor.IVodTsUrlConverter;
import com.arialyy.aria.util.CommonUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TaskOptionParams {
    public static List<Class> PROCESSORES;
    public Map<String, Object> params = new HashMap();
    public Map<String, IEventHandler> handler = new HashMap();

    static {
        ArrayList arrayList = new ArrayList();
        PROCESSORES = arrayList;
        arrayList.add(FtpInterceptHandler.class);
        PROCESSORES.add(IBandWidthUrlConverter.class);
        PROCESSORES.add(IFtpUploadInterceptor.class);
        PROCESSORES.add(IHttpFileLenAdapter.class);
        PROCESSORES.add(IHttpFileNameAdapter.class);
        PROCESSORES.add(ILiveTsUrlConverter.class);
        PROCESSORES.add(ITsMergeHandler.class);
        PROCESSORES.add(IVodTsUrlConverter.class);
        PROCESSORES.add(IKeyUrlConverter.class);
    }

    public IEventHandler getHandler(String str) {
        return this.handler.get(str);
    }

    public Map<String, IEventHandler> getHandler() {
        return this.handler;
    }

    public Object getParam(String str) {
        return this.params.get(str);
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public TaskOptionParams setObjs(String str, IEventHandler iEventHandler) {
        this.handler.put(str, iEventHandler);
        return this;
    }

    public TaskOptionParams setParams(String str, Object obj) {
        this.params.put(str, obj);
        return this;
    }

    public void setParams(BaseOption baseOption) {
        for (Field field : CommonUtil.getAllFields(baseOption.getClass())) {
            field.setAccessible(true);
            try {
                if (PROCESSORES.contains(field.getType())) {
                    Object obj = field.get(baseOption);
                    if (obj != null) {
                        setObjs(field.getName(), (IEventHandler) obj);
                    }
                } else {
                    Object obj2 = field.get(baseOption);
                    if (obj2 != null) {
                        setParams(field.getName(), obj2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
