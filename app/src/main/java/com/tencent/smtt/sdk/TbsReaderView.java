package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.stub.StubApp;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;
import org.litepal.parser.LitePalParser;

/* loaded from: classes4.dex */
public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";

    /* renamed from: f */
    public static boolean f1939f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";

    /* renamed from: a */
    public Context f1940a;

    /* renamed from: b */
    public ReaderWizard f1941b = null;

    /* renamed from: c */
    public Object f1942c = null;

    /* renamed from: d */
    public ReaderCallback f1943d;

    /* renamed from: e */
    public ReaderCallback f1944e;

    /* loaded from: classes4.dex */
    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) throws RuntimeException {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f1940a = null;
        this.f1943d = null;
        this.f1944e = null;
        if (context instanceof Activity) {
            this.f1943d = readerCallback;
            this.f1940a = context;
            this.f1944e = new ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderView.1
                @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
                public void onCallBackAction(Integer num, Object obj, Object obj2) {
                    TbsReaderView tbsReaderView;
                    String str;
                    Bundle bundle;
                    TbsReaderView tbsReaderView2;
                    String str2;
                    int intValue = num.intValue();
                    String str3 = "";
                    Bundle bundle2 = null;
                    boolean z = true;
                    if (intValue != 5026) {
                        if (intValue != 5030) {
                            switch (intValue) {
                                case 5008:
                                    if (MttLoader.isBrowserInstalledEx(TbsReaderView.this.f1940a)) {
                                        if (obj != null) {
                                            bundle2 = (Bundle) obj;
                                            str3 = bundle2.getString("docpath");
                                        }
                                        QbSdk.startQBForDoc(TbsReaderView.this.f1940a, str3, 4, 0, "pdf", bundle2);
                                        tbsReaderView = TbsReaderView.this;
                                        str = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER;
                                        tbsReaderView.userStatistics(str);
                                        break;
                                    } else {
                                        num = 5011;
                                        String resString = TbsReaderView.getResString(TbsReaderView.this.f1940a, ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                                        bundle = new Bundle();
                                        bundle.putString("tip", resString);
                                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                                        tbsReaderView2 = TbsReaderView.this;
                                        str2 = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG;
                                        tbsReaderView2.userStatistics(str2);
                                        obj = bundle;
                                        z = false;
                                        break;
                                    }
                                case 5009:
                                    if (MttLoader.isBrowserInstalledEx(TbsReaderView.this.f1940a)) {
                                        if (obj != null) {
                                            bundle2 = (Bundle) obj;
                                            str3 = bundle2.getString("docpath");
                                        }
                                        QbSdk.startQBForDoc(TbsReaderView.this.f1940a, str3, 4, 0, "", bundle2);
                                        tbsReaderView = TbsReaderView.this;
                                        str = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER;
                                        tbsReaderView.userStatistics(str);
                                        break;
                                    } else {
                                        num = 5011;
                                        String resString2 = TbsReaderView.getResString(TbsReaderView.this.f1940a, 5021);
                                        bundle = new Bundle();
                                        bundle.putString("tip", resString2);
                                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                                        tbsReaderView2 = TbsReaderView.this;
                                        str2 = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG;
                                        tbsReaderView2.userStatistics(str2);
                                        obj = bundle;
                                        z = false;
                                        break;
                                    }
                                case 5010:
                                    if (MttLoader.isBrowserInstalledEx(TbsReaderView.this.f1940a)) {
                                        if (obj != null) {
                                            bundle2 = (Bundle) obj;
                                            str3 = bundle2.getString("docpath");
                                        }
                                        QbSdk.startQBForDoc(TbsReaderView.this.f1940a, str3, 4, 0, "txt", bundle2);
                                        break;
                                    } else {
                                        num = 5011;
                                        String resString3 = TbsReaderView.getResString(TbsReaderView.this.f1940a, 5022);
                                        bundle = new Bundle();
                                        bundle.putString("tip", resString3);
                                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                                        tbsReaderView2 = TbsReaderView.this;
                                        str2 = TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG;
                                        tbsReaderView2.userStatistics(str2);
                                        obj = bundle;
                                        z = false;
                                        break;
                                    }
                                default:
                                    z = false;
                                    break;
                            }
                        } else if (obj != null) {
                            Bundle bundle3 = (Bundle) obj;
                            TbsReaderView.gReaderPackName = bundle3.getString("name");
                            TbsReaderView.gReaderPackVersion = bundle3.getString(LitePalParser.NODE_VERSION);
                        }
                    } else if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f1940a)) {
                        num = 5011;
                        String resString4 = TbsReaderView.getResString(TbsReaderView.this.f1940a, ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
                        bundle = new Bundle();
                        bundle.putString("tip", resString4);
                        bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                        bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
                        tbsReaderView2 = TbsReaderView.this;
                        str2 = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG;
                        tbsReaderView2.userStatistics(str2);
                        obj = bundle;
                        z = false;
                    } else {
                        if (obj != null) {
                            bundle2 = (Bundle) obj;
                            str3 = bundle2.getString("docpath");
                        }
                        QbSdk.startQBForDoc(TbsReaderView.this.f1940a, str3, 4, 0, "doc", bundle2);
                        tbsReaderView = TbsReaderView.this;
                        str = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER;
                        tbsReaderView.userStatistics(str);
                    }
                    ReaderCallback readerCallback2 = TbsReaderView.this.f1943d;
                    if (readerCallback2 == null || z) {
                        return;
                    }
                    readerCallback2.onCallBackAction(num, obj, obj2);
                }
            };
            return;
        }
        throw new RuntimeException("error: unexpect context(none Activity)");
    }

    /* renamed from: a */
    public static boolean m2739a(Context context) {
        if (!f1939f) {
            C1363g.m2597a(true).m2599a(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, false);
            f1939f = C1363g.m2597a(false).m2596b();
        }
        return f1939f;
    }

    public static Drawable getResDrawable(Context context, int i) {
        if (m2739a(context)) {
            return ReaderWizard.getResDrawable(i);
        }
        return null;
    }

    public static String getResString(Context context, int i) {
        return m2739a(context) ? ReaderWizard.getResString(i) : "";
    }

    public static boolean isSupportExt(Context context, String str) {
        return m2739a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str);
    }

    /* renamed from: a */
    public boolean m2740a() {
        try {
            if (this.f1941b == null) {
                this.f1941b = new ReaderWizard(this.f1944e);
            }
            if (this.f1942c == null) {
                this.f1942c = this.f1941b.getTbsReader();
            }
            if (this.f1942c == null) {
                return false;
            }
            return this.f1941b.initTbsReader(this.f1942c, this.f1940a);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        Object obj3;
        ReaderWizard readerWizard = this.f1941b;
        if (readerWizard == null || (obj3 = this.f1942c) == null) {
            return;
        }
        readerWizard.doCommand(obj3, num, obj, obj2);
    }

    public boolean downloadPlugin(String str) {
        Object obj = this.f1942c;
        if (obj == null) {
            return false;
        }
        return this.f1941b.checkPlugin(obj, this.f1940a, str, true);
    }

    public void onSizeChanged(int i, int i2) {
        Object obj;
        ReaderWizard readerWizard = this.f1941b;
        if (readerWizard == null || (obj = this.f1942c) == null) {
            return;
        }
        readerWizard.onSizeChanged(obj, i, i2);
    }

    public void onStop() {
        ReaderWizard readerWizard = this.f1941b;
        if (readerWizard != null) {
            readerWizard.destroy(this.f1942c);
            this.f1942c = null;
        }
        this.f1940a = null;
        f1939f = false;
    }

    public void openFile(Bundle bundle) {
        if (this.f1942c == null || bundle == null) {
            return;
        }
        bundle.putBoolean("browser6.0", MttLoader.isBrowserInstalledEx(this.f1940a) | (!MttLoader.isBrowserInstalled(this.f1940a)));
        bundle.putBoolean("browser6.1", MttLoader.isGreatBrowserVer(this.f1940a, 6101625L, 610000L) | (!MttLoader.isBrowserInstalled(this.f1940a)));
        this.f1941b.openFile(this.f1942c, this.f1940a, bundle, this);
    }

    public boolean preOpen(String str, boolean z) {
        boolean z2 = false;
        if (!isSupportExt(this.f1940a, str)) {
            return false;
        }
        boolean m2739a = m2739a(this.f1940a);
        if (!m2739a) {
            return m2739a;
        }
        boolean m2740a = m2740a();
        if (!z || !m2740a) {
            return m2740a;
        }
        if (Apn.getApnType(this.f1940a) == 3) {
            z2 = true;
        }
        return this.f1941b.checkPlugin(this.f1942c, this.f1940a, str, z2);
    }

    public void userStatistics(String str) {
        ReaderWizard readerWizard = this.f1941b;
        if (readerWizard != null) {
            readerWizard.userStatistics(this.f1942c, str);
        }
    }
}
