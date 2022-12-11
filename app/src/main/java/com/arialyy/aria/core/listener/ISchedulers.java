package com.arialyy.aria.core.listener;

import android.os.Handler;

/* loaded from: classes3.dex */
public interface ISchedulers extends Handler.Callback {
    public static final String ARIA_TASK_INFO_ACTION = "ARIA_TASK_INFO_ACTION";
    public static final int CANCEL = 5;
    public static final int CHECK_FAIL = 11;
    public static final int COMPLETE = 6;
    public static final String DATA_M3U8_PEER_INDEX = "DATA_M3U8_PEER_INDEX";
    public static final String DATA_M3U8_PEER_PATH = "DATA_M3U8_PEER_PATH";
    public static final String DATA_M3U8_URL = "DATA_M3U8_URL";
    public static final int FAIL = 4;
    public static final int IS_M3U8_PEER = 210;
    public static final int IS_SUB_TASK = 209;
    public static final int M3U8_PEER_COMPLETE = 178;
    public static final int M3U8_PEER_FAIL = 179;
    public static final int M3U8_PEER_START = 177;
    public static final int NO_SUPPORT_BREAK_POINT = 9;
    public static final int POST_PRE = 1;
    public static final int PRE = 0;
    public static final int RESUME = 8;
    public static final int RUNNING = 7;
    public static final int START = 2;
    public static final int STOP = 3;
    public static final int SUB_CANCEL = 164;
    public static final int SUB_COMPLETE = 167;
    public static final int SUB_FAIL = 165;
    public static final int SUB_PRE = 161;
    public static final int SUB_RUNNING = 166;
    public static final int SUB_START = 162;
    public static final int SUB_STOP = 163;
    public static final String TASK_ENTITY = "ARIA_TASK_ENTITY";
    public static final String TASK_PERCENT = "ARIA_TASK_PERCENT";
    public static final String TASK_SPEED = "ARIA_TASK_SPEED";
    public static final String TASK_STATE = "ARIA_TASK_STATE";
    public static final String TASK_TYPE = "ARIA_TASK_TYPE";
    public static final int WAIT = 10;
}
