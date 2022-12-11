package me.tvspark.utils.web.utils;

/* loaded from: classes4.dex */
public class ReturnData {
    public Object data;
    public int errorCode;
    public boolean isSuccess = false;
    public String errorMsg = "未知错误,请联系开发者!";

    public Object getData() {
        return this.data;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public ReturnData setData(Object obj) {
        this.isSuccess = true;
        this.errorMsg = "";
        this.data = obj;
        return this;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public ReturnData setErrorMsg(String str) {
        this.isSuccess = false;
        this.errorMsg = str;
        return this;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
