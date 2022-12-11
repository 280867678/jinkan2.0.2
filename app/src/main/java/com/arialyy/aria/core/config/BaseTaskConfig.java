package com.arialyy.aria.core.config;

import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class BaseTaskConfig extends BaseConfig implements Serializable {
    public String caName;
    public String caPath;
    public String TAG = CommonUtil.getClassName((Class) getClass());
    public int buffSize = 8192;
    public long updateInterval = 1000;
    public int oldMaxTaskNum = 2;
    public int maxTaskNum = 2;
    public int reTryNum = 10;
    public int reTryInterval = 2000;
    public int connectTimeOut = 5000;
    public boolean isConvertSpeed = false;
    public String queueMod = "wait";
    public int iOTimeOut = 20000;
    public int maxSpeed = 0;

    public int getBuffSize() {
        return this.buffSize;
    }

    public String getCaName() {
        return this.caName;
    }

    public String getCaPath() {
        return this.caPath;
    }

    public int getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public int getIOTimeOut() {
        return this.iOTimeOut;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getMaxTaskNum() {
        return this.maxTaskNum;
    }

    public String getQueueMod() {
        return this.queueMod;
    }

    public int getReTryInterval() {
        return this.reTryInterval;
    }

    public int getReTryNum() {
        return this.reTryNum;
    }

    public long getUpdateInterval() {
        return this.updateInterval;
    }

    public boolean isConvertSpeed() {
        return this.isConvertSpeed;
    }

    public BaseTaskConfig setBuffSize(int i) {
        this.buffSize = i;
        save();
        return this;
    }

    public BaseConfig setCaName(String str) {
        this.caName = str;
        save();
        return this;
    }

    public BaseConfig setCaPath(String str) {
        this.caPath = str;
        save();
        return this;
    }

    public BaseTaskConfig setConnectTimeOut(int i) {
        this.connectTimeOut = i;
        save();
        return this;
    }

    public BaseTaskConfig setConvertSpeed(boolean z) {
        this.isConvertSpeed = z;
        save();
        return this;
    }

    public BaseTaskConfig setIOTimeOut(int i) {
        this.iOTimeOut = i;
        save();
        return this;
    }

    /* renamed from: setMaxSpeed */
    public BaseTaskConfig mo4410setMaxSpeed(int i) {
        this.maxSpeed = i;
        save();
        return this;
    }

    /* renamed from: setMaxTaskNum */
    public BaseTaskConfig mo4411setMaxTaskNum(int i) {
        this.oldMaxTaskNum = this.maxTaskNum;
        this.maxTaskNum = i;
        save();
        return this;
    }

    public BaseTaskConfig setQueueMod(String str) {
        this.queueMod = str;
        save();
        return this;
    }

    public BaseTaskConfig setReTryInterval(int i) {
        this.reTryInterval = i;
        save();
        return this;
    }

    public BaseTaskConfig setReTryNum(int i) {
        this.reTryNum = i;
        save();
        return this;
    }

    public BaseTaskConfig setUpdateInterval(long j) {
        if (j <= 0) {
            ALog.m4185w(Configuration.TAG, "进度更新间隔不能小于0");
            return this;
        }
        this.updateInterval = j;
        save();
        return this;
    }
}
