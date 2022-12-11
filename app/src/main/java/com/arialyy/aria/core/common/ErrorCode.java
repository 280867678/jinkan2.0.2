package com.arialyy.aria.core.common;

/* loaded from: classes3.dex */
public enum ErrorCode {
    ERROR_CODE_NORMAL(0, "正常"),
    ERROR_CODE_TASK_ID_NULL(1, "任务id为空的错误码"),
    ERROR_CODE_URL_NULL(2, "url 为空"),
    ERROR_CODE_URL_INVALID(3, "url 无效"),
    ERROR_CODE_PAGE_NUM(4, "page和num不能小于1"),
    ERROR_CODE_GROUP_URL_NULL(5, "组合任务url列表为空"),
    ERROR_CODE_UPLOAD_FILE_NULL(7, "上传文件不存在"),
    ERROR_CODE_MEMBER_WARNING(8, "为了防止内存泄漏，请使用静态的成员类(public static class xxx)或文件类(A.java)"),
    ERROR_CODE_TASK_NOT_EXIST(9, "任务信息不存在");
    
    public int code;
    public String msg;

    ErrorCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
