package com.efs.sdk.base;

import android.app.Application;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p006b.AbstractC0708e;
import com.efs.sdk.base.core.p006b.C0701a;
import com.efs.sdk.base.core.p007c.HandlerC0719d;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.stub.StubApp;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class EfsReporter {
    public static ControllerCenter sControllerCenter;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static Map<String, EfsReporter> sInstanceMap = new ConcurrentHashMap();
        public static boolean sUseAppContext = true;
        public final String TAG;
        public GlobalEnvStruct mGlobalEnvStruct;

        /* loaded from: classes3.dex */
        public interface IPublicParams {
            Map<String, String> getRecordHeaders();
        }

        public Builder(@NonNull Application application, @NonNull String str, @NonNull String str2) {
            this(StubApp.getOrigApplicationContext(application.getApplicationContext()), str, str2);
        }

        public Builder(@NonNull Context context, @NonNull String str, @NonNull String str2) {
            this.TAG = "efs.reporter.builder";
            Context checkContext = checkContext(context);
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    throw new RuntimeException("EfsReporter init, secret is empty");
                }
                GlobalEnvStruct globalEnvStruct = new GlobalEnvStruct();
                this.mGlobalEnvStruct = globalEnvStruct;
                globalEnvStruct.mAppContext = checkContext;
                globalEnvStruct.setAppid(str);
                this.mGlobalEnvStruct.setSecret(str2);
                return;
            }
            throw new RuntimeException("EfsReporter init, appid is empty");
        }

        public static Context checkContext(Context context) {
            if (context == null) {
                Log.m4067e("context can not be null!");
                throw null;
            } else if (!sUseAppContext || (context instanceof Application) || ((context = StubApp.getOrigApplicationContext(context.getApplicationContext())) != null && (context instanceof Application))) {
                return context;
            } else {
                Log.m4067e("Can not get Application context from given context!");
                throw new IllegalArgumentException("Can not get Application context from given context!");
            }
        }

        private void checkParam(String str) {
            GlobalEnvStruct globalEnvStruct = sInstanceMap.get(str).getGlobalEnvStruct();
            if (globalEnvStruct.mAppContext.equals(getGlobalEnvStruct().mAppContext)) {
                if (!TextUtils.isEmpty(globalEnvStruct.getSecret()) && !globalEnvStruct.getSecret().equals(getGlobalEnvStruct().getSecret())) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("efs-core: duplicate init, but ", "secret is different"));
                }
                if (globalEnvStruct.isIntl() != getGlobalEnvStruct().isIntl()) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("efs-core: duplicate init, but ", "intl setting is different"));
                }
                if (!TextUtils.isEmpty(getGlobalEnvStruct().getUid()) && !getGlobalEnvStruct().getUid().equals(globalEnvStruct.getUid())) {
                    Log.m4054w("efs.reporter.builder", "efs-core: duplicate init, but  uid is different");
                }
                if (getGlobalEnvStruct().getPublicParamMap() == null || getGlobalEnvStruct().getPublicParamMap().size() <= 0) {
                    return;
                }
                globalEnvStruct.addPublicParams(getGlobalEnvStruct().getPublicParamMap());
                return;
            }
            throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("efs-core: duplicate init, but ", "application context is different"));
        }

        public Builder addEfsReporterObserver(IEfsReporterObserver iEfsReporterObserver) {
            this.mGlobalEnvStruct.addConfigObserver(iEfsReporterObserver);
            return this;
        }

        public EfsReporter build() {
            String appid = getGlobalEnvStruct().getAppid();
            if (!sInstanceMap.containsKey(appid)) {
                synchronized (EfsReporter.class) {
                    if (!sInstanceMap.containsKey(appid)) {
                        EfsReporter efsReporter = new EfsReporter(this);
                        sInstanceMap.put(appid, efsReporter);
                        return efsReporter;
                    }
                }
            }
            Log.m4054w("efs.reporter.builder", "efs-core: duplicate init");
            checkParam(appid);
            return sInstanceMap.get(appid);
        }

        public Builder configRefreshAction(@NonNull IConfigRefreshAction iConfigRefreshAction) {
            C0729c.m4127a().f246b = iConfigRefreshAction;
            return this;
        }

        public Builder configRefreshDelayMills(long j) {
            this.mGlobalEnvStruct.configRefreshDelayMills = j;
            return this;
        }

        public Builder debug(boolean z) {
            this.mGlobalEnvStruct.setDebug(z);
            return this;
        }

        public Builder efsDirRootName(String str) {
            C0763a.m4049a(str);
            return this;
        }

        public Builder enableSendLog(boolean z) {
            this.mGlobalEnvStruct.setEnableSendLog(z);
            return this;
        }

        public Builder enableWaStat(boolean z) {
            this.mGlobalEnvStruct.setEnableWaStat(z);
            return this;
        }

        public GlobalEnvStruct getGlobalEnvStruct() {
            return this.mGlobalEnvStruct;
        }

        public Builder intl(boolean z) {
            this.mGlobalEnvStruct.setIsIntl(z);
            return this;
        }

        public Builder logEncryptAction(ILogEncryptAction iLogEncryptAction) {
            this.mGlobalEnvStruct.setLogEncryptAction(iLogEncryptAction);
            return this;
        }

        public Builder maxConcurrentUploadCnt(int i) {
            HandlerC0719d.m4141a().f206a = i;
            return this;
        }

        public Builder printLogDetail(boolean z) {
            this.mGlobalEnvStruct.setPrintLogDetail(z);
            return this;
        }

        public Builder publicParams(@NonNull IPublicParams iPublicParams) {
            if (iPublicParams.getRecordHeaders() != null && iPublicParams.getRecordHeaders().size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(iPublicParams.getRecordHeaders());
            }
            return this;
        }

        public Builder publicParams(@NonNull Map<String, String> map) {
            if (map.size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(map);
            }
            return this;
        }

        public Builder uid(String str) {
            this.mGlobalEnvStruct.setUid(str);
            return this;
        }
    }

    public EfsReporter(Builder builder) {
        sControllerCenter = new ControllerCenter(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public GlobalEnvStruct getGlobalEnvStruct() {
        return ControllerCenter.getGlobalEnvStruct();
    }

    public void addPublicParams(@NonNull Map<String, String> map) {
        if (map.size() > 0) {
            getGlobalEnvStruct().addPublicParams(map);
        }
    }

    public void flushRecordLogImmediately(String str) {
        AbstractC0708e m4162a = C0701a.C0703b.m4163a().f187c.m4162a((byte) 1);
        if (m4162a != null) {
            m4162a.mo4155a(str);
        }
    }

    public Map<String, String> getAllConfig() {
        return C0729c.m4127a().m4119c();
    }

    public Map<String, Object> getAllSdkConfig() {
        return new HashMap(C0729c.m4127a().f248d.f243f);
    }

    public void getAllSdkConfig(String[] strArr, IConfigCallback iConfigCallback) {
        C0729c m4127a = C0729c.m4127a();
        m4127a.f249e.put(iConfigCallback, strArr);
        if (!m4127a.f248d.f243f.isEmpty()) {
            m4127a.m4118d();
        }
    }

    public void refreshConfig(String str) {
        C0729c.m4127a().m4123a(str);
    }

    public void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        getGlobalEnvStruct().registerCallback(i, valueCallback);
    }

    public void send(ILogProtocol iLogProtocol) {
        sControllerCenter.send(iLogProtocol);
    }

    public HttpResponse sendSyncImediatelly(String str, int i, String str2, File file) {
        return sendSyncImediatelly(str, i, str2, true, file);
    }

    public HttpResponse sendSyncImediatelly(String str, int i, String str2, boolean z, File file) {
        return sControllerCenter.sendSyncImmediately(str, i, str2, z, file);
    }

    public void setEnableRefreshConfigFromRemote(boolean z) {
        C0729c.m4127a().f247c = z;
    }
}
