package me.tvspark;

import android.app.Application;
import android.content.Context;
import com.p038qq.p039e.comm.managers.GDTAdSdk;
import com.stub.StubApp;
import com.tencent.smtt.sdk.WebSettings;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.statistics.C1767b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import me.tvspark.data.bean.NowPlayListParcel;
import me.tvspark.data.bean.VersionParcel;
import me.tvspark.data.sql.CustomConfUrlData;
import me.tvspark.lo0;
import org.litepal.LitePal;

/* renamed from: me.tvspark.C */
/* loaded from: classes4.dex */
public class ApplicationC1880C extends Application implements sk0 {
    public static boolean Wwwwwwwwwwwww = false;
    public static ko0 Wwwwwwwwwwwwww = null;
    public static VersionParcel Wwwwwwwwwwwwwww = null;
    public static String Wwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceLive.json";
    public static String Wwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceSeason.json";
    public static String Wwwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceIndex.json";
    public static String Wwwwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceIndexRec.json";
    public static String Wwwwwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/config.json";
    public static boolean Wwwwwwwwwwwwwwwwwwwww = false;
    public static String Wwwwwwwwwwwwwwwwwwwwww = "";
    public static String Wwwwwwwwwwwwwwwwwwwwwww = "https://m.kankanwu.com";
    public static Application Wwwwwwwwwwwwwwwwwwwwwwww;
    public static NowPlayListParcel Wwwwwwwwwwww = new NowPlayListParcel();
    public static NowPlayListParcel Wwwwwwwwwww = new NowPlayListParcel();
    public static LinkedBlockingQueue<hr0> Wwwwwwwwww = new LinkedBlockingQueue<>();
    public static boolean Wwwwwwwww = false;
    public static final Pattern Wwwwwwww = Pattern.compile("(<js>[\\w\\W]*?</js>|@js:[\\w\\W]*$)", 2);
    public static final Pattern Wwwwwww = Pattern.compile("\\{\\{([\\w\\W]*?)\\}\\}");
    public static final ScriptEngine Wwwwww = new ScriptEngineManager().getEngineByName("rhino");
    public static boolean Wwwww = false;
    public static boolean Wwww = false;

    /* renamed from: me.tvspark.C$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements lo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("usd_adb", true)) {
                ApplicationC1880C.Wwwwwwwwwwwwww = new ko0(StubApp.getOrigApplicationContext(ApplicationC1880C.this.getApplicationContext()).getExternalFilesDir("filters"));
            }
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            CustomConfUrlData Wwwwwwwwwwwwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww.getVersionUrl();
                Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww.getIndexRecUrl();
                Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww.getIndexUrl();
                Wwwwwwwwwwwwwwwwwwwwwwwwww.getCategoryUrl();
                Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww.getSeasonUrl();
                Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww.getLiveUrl();
                Wwwwwwwwwwwwwwwwwwwwwwwwww.getDownloadUrl();
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            str = "http://www.baidu.com";
            Wwwwwwwwwwwwwwwwwwww = str;
            Wwwwwwwwwwwwwwwwwww = str;
            Wwwwwwwwwwwwwwwwww = str;
            Wwwwwwwwwwwwwwwww = str;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            Wwwwwwwwwwwwwwwwwwww = sk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwww = sk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwww = sk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwww = sk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            str = sk0.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 1) {
            Wwwwwwwwwwwwwwwwwwww = "https://fastly.jsdelivr.net/gh/ppbrowser/whale2/config.json";
            Wwwwwwwwwwwwwwwwwww = "https://fastly.jsdelivr.net/gh/ppbrowser/whale2/sourceIndexRec.json";
            Wwwwwwwwwwwwwwwwww = "https://fastly.jsdelivr.net/gh/ppbrowser/whale2/sourceIndex.json";
            Wwwwwwwwwwwwwwwww = "https://fastly.jsdelivr.net/gh/ppbrowser/whale2/sourceSeason.json";
            str = "https://fastly.jsdelivr.net/gh/ppbrowser/whale2/sourceLive.json";
        } else {
            Wwwwwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/config.json";
            Wwwwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceIndexRec.json";
            Wwwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceIndex.json";
            Wwwwwwwwwwwwwwwww = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceSeason.json";
            str = "https://codeberg.org/ppbrowser/whale2/raw/branch/master/sourceLive.json";
        }
        Wwwwwwwwwwwwwwww = str;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Integer valueOf;
        int i2;
        int i3 = -1;
        if (i != -1) {
            if (i != 0) {
                i3 = 1;
                if (i != 1) {
                    i2 = 2;
                }
            } else {
                i2 = 0;
            }
            valueOf = Integer.valueOf(i2);
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("conf_url_url", valueOf);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        valueOf = Integer.valueOf(i3);
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("conf_url_url", valueOf);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.app.Application
    public void onCreate() {
        String property;
        super.onCreate();
        Wwwwwwwwwwwwwwwwwwwwwwww = this;
        nn0.Wwwwwwwwwwwwwwwwwwwwwwww = this;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StubApp.getOrigApplicationContext(getApplicationContext()));
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(C1767b.f4025f)) {
            System.exit(0);
        }
        pn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StubApp.getOrigApplicationContext(getApplicationContext()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        UMConfigure.preInit(StubApp.getOrigApplicationContext(getApplicationContext()), "62e3a4f205844627b506bed6", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        UMConfigure.init(StubApp.getOrigApplicationContext(getApplicationContext()), "62e3a4f205844627b506bed6", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.MANUAL);
        try {
            property = WebSettings.getDefaultUserAgent(StubApp.getOrigApplicationContext(getApplicationContext()));
        } catch (Exception unused) {
            property = System.getProperty("http.agent");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char charAt = property.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwww = stringBuffer.toString();
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwww = origApplicationContext.getSharedPreferences("whaletv", 0);
        }
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwww == null) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwww.edit();
        }
        LitePal.initialize(StubApp.getOrigApplicationContext(getApplicationContext()));
        k50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new j50());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cur_url_index");
        GDTAdSdk.init(this, "1110607006");
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("usd_adb", true)) {
            Wwwwwwwwwwwwww = new ko0(StubApp.getOrigApplicationContext(getApplicationContext()).getExternalFilesDir("filters"));
        }
        if (do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            new lo0(StubApp.getOrigApplicationContext(getApplicationContext()).getExternalFilesDir("filters"), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
