package com.arialyy.aria.core.common;

import android.os.Handler;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.config.BaseTaskConfig;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import java.io.File;

/* loaded from: classes3.dex */
public class SubThreadConfig {
    public static final int TYPE_FTP = 2;
    public static final int TYPE_FTP_DG_SUB = 5;
    public static final int TYPE_HTTP = 1;
    public static final int TYPE_HTTP_DG_SUB = 4;
    public static final int TYPE_M3U8_PEER = 3;
    public Object obj;
    public int peerIndex;
    public ThreadRecord record;
    public int startThreadNum;
    public Handler stateHandler;
    public AbsTaskWrapper taskWrapper;
    public File tempFile;
    public String url;
    public boolean isBlock = false;
    public int threadType = 1;
    public long updateInterval = 1000;

    public static int getThreadType(int i) {
        switch (i) {
            case 1:
            case 5:
            default:
                return 1;
            case 2:
                return 4;
            case 3:
            case 6:
                return 2;
            case 4:
                return 5;
            case 7:
            case 8:
                return 3;
        }
    }

    public static long getUpdateInterval(int i) {
        BaseTaskConfig dConfig;
        switch (i) {
            case 1:
            case 3:
            case 7:
            case 8:
                dConfig = AriaConfig.getInstance().getDConfig();
                break;
            case 2:
            case 4:
                dConfig = AriaConfig.getInstance().getDGConfig();
                break;
            case 5:
            case 6:
                dConfig = AriaConfig.getInstance().getUConfig();
                break;
            default:
                return 1000L;
        }
        return dConfig.getUpdateInterval();
    }
}
