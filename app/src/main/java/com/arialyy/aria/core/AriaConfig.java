package com.arialyy.aria.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import com.arialyy.aria.core.config.AppConfig;
import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.core.config.DGroupConfig;
import com.arialyy.aria.core.config.DownloadConfig;
import com.arialyy.aria.core.config.UploadConfig;
import com.arialyy.aria.core.config.XMLReader;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.FileUtil;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/* loaded from: classes3.dex */
public class AriaConfig {
    public static Context APP = null;
    public static final String DOWNLOAD_TEMP_DIR = "/Aria/temp/download/";
    public static final String IGNORE_CLASS_KLASS = "shadow$_klass_";
    public static final String IGNORE_CLASS_MONITOR = "shadow$_monitor_";
    public static volatile AriaConfig Instance = null;
    public static final String TAG = "AriaConfig";
    public static final String UPLOAD_TEMP_DIR = "/Aria/temp/upload/";
    public static boolean isConnectedNet = true;
    public AppConfig mAConfig;
    public Handler mAriaHandler;
    public DownloadConfig mDConfig;
    public DGroupConfig mDGConfig;
    public UploadConfig mUConfig;

    public AriaConfig(Context context) {
        APP = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static AriaConfig getInstance() {
        if (Instance == null) {
            ALog.m4191e(TAG, "请使用init()初始化");
        }
        return Instance;
    }

    public static AriaConfig init(Context context) {
        if (Instance == null) {
            synchronized (AriaConfig.class) {
                if (Instance == null) {
                    Instance = new AriaConfig(context);
                    Instance.initData();
                }
            }
        }
        return Instance;
    }

    private void initConfig() {
        this.mDConfig = Configuration.getInstance().downloadCfg;
        this.mUConfig = Configuration.getInstance().uploadCfg;
        this.mAConfig = Configuration.getInstance().appCfg;
        this.mDGConfig = Configuration.getInstance().dGroupCfg;
        File file = new File(APP.getFilesDir().getPath() + Configuration.XML_FILE);
        File file2 = new File(APP.getFilesDir().getPath() + "/temp");
        if (!file.exists()) {
            loadConfig();
        } else {
            try {
                String fileMD5 = CommonUtil.getFileMD5(file);
                File file3 = new File(APP.getFilesDir().getPath() + "/temp.xml");
                if (file3.exists()) {
                    file3.delete();
                }
                FileUtil.createFileFormInputStream(APP.getAssets().open("aria_config.xml"), file3.getPath());
                if (!CommonUtil.checkMD5(fileMD5, file3) || !Configuration.getInstance().configExists()) {
                    loadConfig();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file2.exists()) {
            File file4 = new File(APP.getFilesDir().getPath() + DOWNLOAD_TEMP_DIR);
            file4.mkdirs();
            file2.renameTo(file4);
        }
    }

    private void initData() {
        initConfig();
        regNetCallBack(APP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNetworkAvailable() {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) getAPP().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    private void loadConfig() {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(APP.getAssets().open("aria_config.xml"), new XMLReader());
            InputStream open = APP.getAssets().open("aria_config.xml");
            FileUtil.createFileFormInputStream(open, APP.getFilesDir().getPath() + Configuration.XML_FILE);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            ALog.m4191e(TAG, e.toString());
        }
    }

    private void regNetCallBack(Context context) {
        ConnectivityManager connectivityManager;
        isConnectedNet = isNetworkAvailable();
        if (getAConfig().isNetCheck() && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build(), new ConnectivityManager.NetworkCallback() { // from class: com.arialyy.aria.core.AriaConfig.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    boolean unused = AriaConfig.isConnectedNet = true;
                    ALog.m4192d(AriaConfig.TAG, "onAvailable, isConnectNet = true");
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    boolean unused = AriaConfig.isConnectedNet = AriaConfig.this.isNetworkAvailable();
                    ALog.m4192d(AriaConfig.TAG, "onLost, isConnectNet = " + AriaConfig.isConnectedNet);
                }
            });
        }
    }

    public AppConfig getAConfig() {
        return this.mAConfig;
    }

    public Context getAPP() {
        return APP;
    }

    public synchronized Handler getAriaHandler() {
        if (this.mAriaHandler == null) {
            this.mAriaHandler = new Handler(Looper.getMainLooper());
        }
        return this.mAriaHandler;
    }

    public DownloadConfig getDConfig() {
        return this.mDConfig;
    }

    public DGroupConfig getDGConfig() {
        return this.mDGConfig;
    }

    public UploadConfig getUConfig() {
        return this.mUConfig;
    }

    public boolean isConnectedNet() {
        return isConnectedNet;
    }
}
