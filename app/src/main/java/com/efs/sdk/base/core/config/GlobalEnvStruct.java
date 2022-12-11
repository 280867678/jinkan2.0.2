package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class GlobalEnvStruct {

    /* renamed from: a */
    public String f221a;

    /* renamed from: b */
    public String f222b;

    /* renamed from: h */
    public String f228h;

    /* renamed from: m */
    public ILogEncryptAction f233m;
    public Context mAppContext;

    /* renamed from: c */
    public boolean f223c = true;

    /* renamed from: d */
    public boolean f224d = true;

    /* renamed from: e */
    public boolean f225e = false;

    /* renamed from: f */
    public Boolean f226f = null;

    /* renamed from: g */
    public boolean f227g = false;

    /* renamed from: i */
    public boolean f229i = false;
    public long configRefreshDelayMills = 5000;

    /* renamed from: j */
    public long f230j = 10000;

    /* renamed from: k */
    public long f231k = 10000;

    /* renamed from: l */
    public Map<String, String> f232l = new HashMap(5);

    /* renamed from: n */
    public ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> f234n = new ConcurrentHashMap<>();

    /* renamed from: o */
    public List<IEfsReporterObserver> f235o = new ArrayList(5);

    public void addConfigObserver(IEfsReporterObserver iEfsReporterObserver) {
        if (!this.f235o.contains(iEfsReporterObserver)) {
            this.f235o.add(iEfsReporterObserver);
        }
    }

    public void addPublicParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap(this.f232l);
        hashMap.putAll(map);
        this.f232l = hashMap;
    }

    public String getAppid() {
        return this.f221a;
    }

    public List<ValueCallback<Pair<Message, Message>>> getCallback(int i) {
        return (!this.f234n.containsKey(Integer.valueOf(i)) || this.f234n.get(Integer.valueOf(i)) == null) ? Collections.emptyList() : this.f234n.get(Integer.valueOf(i));
    }

    public List<IEfsReporterObserver> getEfsReporterObservers() {
        return this.f235o;
    }

    public ILogEncryptAction getLogEncryptAction() {
        return this.f233m;
    }

    public long getLogSendDelayMills() {
        return this.f230j;
    }

    public long getLogSendIntervalMills() {
        return this.f231k;
    }

    public Map<String, String> getPublicParamMap() {
        Map<String, String> map = this.f232l;
        return map == null ? Collections.emptyMap() : map;
    }

    public String getSecret() {
        return this.f222b;
    }

    public String getUid() {
        return this.f228h;
    }

    public boolean isDebug() {
        return this.f225e;
    }

    public boolean isEnableSendLog() {
        return this.f224d;
    }

    public boolean isEnableWaStat() {
        return this.f223c;
    }

    public boolean isIntl() {
        return this.f229i;
    }

    public boolean isPrintLogDetail() {
        return this.f227g;
    }

    public void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        List<ValueCallback<Pair<Message, Message>>> list = this.f234n.get(Integer.valueOf(i));
        if (list == null) {
            list = new LinkedList<>();
            this.f234n.putIfAbsent(Integer.valueOf(i), list);
        }
        list.add(valueCallback);
    }

    public void setAppid(String str) {
        this.f221a = str;
    }

    public void setDebug(boolean z) {
        this.f225e = z;
    }

    public void setEnableSendLog(boolean z) {
        this.f224d = z;
    }

    public void setEnableWaStat(boolean z) {
        this.f223c = z;
    }

    public void setIsIntl(boolean z) {
        this.f229i = z;
    }

    public void setLogEncryptAction(ILogEncryptAction iLogEncryptAction) {
        this.f233m = iLogEncryptAction;
    }

    public void setPrintLogDetail(boolean z) {
        this.f227g = z;
    }

    public void setSecret(String str) {
        this.f222b = str;
    }

    public void setUid(String str) {
        this.f228h = str;
    }
}
