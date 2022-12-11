package com.arialyy.aria.core.config;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.util.FileUtil;
import java.io.File;

/* loaded from: classes3.dex */
public final class Configuration {
    public static final String APP_CONFIG_FILE = "/Aria/AriaApp.cfg";
    public static final String DGROUP_CONFIG_FILE = "/Aria/AriaDGroup.cfg";
    public static final String DOWNLOAD_CONFIG_FILE = "/Aria/AriaDownload.cfg";
    public static volatile Configuration INSTANCE = null;
    public static final String TAG = "Configuration";
    public static final String UPLOAD_CONFIG_FILE = "/Aria/AriaUpload.cfg";
    public static final String XML_FILE = "/Aria/aria_config.xml";
    public AppConfig appCfg;
    public DGroupConfig dGroupCfg;
    public DownloadConfig downloadCfg;
    public UploadConfig uploadCfg;

    public Configuration() {
        String path = AriaConfig.getInstance().getAPP().getFilesDir().getPath();
        del351Config(path);
        File file = new File(String.format("%s%s", path, DOWNLOAD_CONFIG_FILE));
        File file2 = new File(String.format("%s%s", path, UPLOAD_CONFIG_FILE));
        File file3 = new File(String.format("%s%s", path, APP_CONFIG_FILE));
        File file4 = new File(String.format("%s%s", path, DGROUP_CONFIG_FILE));
        if (file.exists()) {
            this.downloadCfg = (DownloadConfig) FileUtil.readObjFromFile(file.getPath());
        }
        if (this.downloadCfg == null) {
            this.downloadCfg = new DownloadConfig();
        }
        if (file2.exists()) {
            this.uploadCfg = (UploadConfig) FileUtil.readObjFromFile(file2.getPath());
        }
        if (this.uploadCfg == null) {
            this.uploadCfg = new UploadConfig();
        }
        if (file3.exists()) {
            this.appCfg = (AppConfig) FileUtil.readObjFromFile(file3.getPath());
        }
        if (this.appCfg == null) {
            this.appCfg = new AppConfig();
        }
        if (file4.exists()) {
            this.dGroupCfg = (DGroupConfig) FileUtil.readObjFromFile(file4.getPath());
        }
        if (this.dGroupCfg == null) {
            this.dGroupCfg = new DGroupConfig();
        }
    }

    private void del351Config(String str) {
        File file = new File(String.format("%s/Aria/DownloadConfig.properties", str));
        if (file.exists()) {
            File file2 = new File(String.format("%s/Aria/UploadConfig.properties", str));
            File file3 = new File(String.format("%s/Aria/AppConfig.properties", str));
            file.delete();
            file2.delete();
            file3.delete();
            File file4 = new File(String.format("%s%s", str, XML_FILE));
            if (!file4.exists()) {
                return;
            }
            file4.delete();
        }
    }

    public static Configuration getInstance() {
        if (INSTANCE == null) {
            synchronized (AppConfig.class) {
                INSTANCE = new Configuration();
            }
        }
        return INSTANCE;
    }

    public boolean configExists() {
        String path = AriaConfig.getInstance().getAPP().getFilesDir().getPath();
        return new File(String.format("%s%s", path, DOWNLOAD_CONFIG_FILE)).exists() && new File(String.format("%s%s", path, UPLOAD_CONFIG_FILE)).exists() && new File(String.format("%s%s", path, APP_CONFIG_FILE)).exists() && new File(String.format("%s%s", path, DGROUP_CONFIG_FILE)).exists();
    }
}
