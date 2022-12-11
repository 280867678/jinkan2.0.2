package me.tvspark.data.bean;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class ParsedParcel<T> implements Serializable {
    public boolean isSuccess;
    public T obj;

    public T getObj() {
        return this.obj;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setObj(T t) {
        this.obj = t;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
