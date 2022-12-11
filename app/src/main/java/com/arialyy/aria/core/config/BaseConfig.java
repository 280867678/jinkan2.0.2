package com.arialyy.aria.core.config;

import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.FileUtil;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class BaseConfig implements Serializable {
    public static final String TAG = "BaseConfig";
    public static final int TYPE_APP = 3;
    public static final int TYPE_DGROUP = 4;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPLOAD = 2;

    public abstract int getType();

    public void save() {
        String path = AriaConfig.getInstance().getAPP().getFilesDir().getPath();
        int type = getType();
        String str = type != 1 ? type != 2 ? type != 3 ? type != 4 ? null : Configuration.DGROUP_CONFIG_FILE : Configuration.APP_CONFIG_FILE : Configuration.UPLOAD_CONFIG_FILE : Configuration.DOWNLOAD_CONFIG_FILE;
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(TAG, String.format("保存配置失败，配置类型：%s，原因：路径错误", Integer.valueOf(getType())));
            return;
        }
        String format = String.format("%s%s", path, str);
        FileUtil.deleteFile(format);
        FileUtil.writeObjToFile(format, this);
    }
}
