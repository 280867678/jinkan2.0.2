package com.arialyy.aria.core.config;

import android.text.TextUtils;
import com.arialyy.aria.core.inf.ReceiverType;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes3.dex */
public class XMLReader extends DefaultHandler {
    public int mType;
    public final String TAG = CommonUtil.getClassName(this);
    public DownloadConfig mDownloadConfig = Configuration.getInstance().downloadCfg;
    public UploadConfig mUploadConfig = Configuration.getInstance().uploadCfg;
    public AppConfig mAppConfig = Configuration.getInstance().appCfg;
    public DGroupConfig mDGroupConfig = Configuration.getInstance().dGroupCfg;

    private boolean checkBoolean(String str) {
        return !TextUtils.isEmpty(str) && (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false"));
    }

    private boolean checkInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Integer.parseInt(str) >= 0;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkLong(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void setField(Class cls, Object obj, String str, Object obj2) {
        try {
            CommonUtil.getField(cls, str).set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void setField(String str, Object obj, int i) {
        Class cls;
        Object obj2;
        if (i == 1) {
            cls = DownloadConfig.class;
            obj2 = this.mDownloadConfig;
        } else if (i == 2) {
            cls = UploadConfig.class;
            obj2 = this.mUploadConfig;
        } else if (i == 3) {
            cls = AppConfig.class;
            obj2 = this.mAppConfig;
        } else if (i != 4) {
            return;
        } else {
            cls = DGroupConfig.class;
            obj2 = this.mDGroupConfig;
        }
        setField(cls, obj2, str, obj);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        super.characters(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        super.endDocument();
        this.mDownloadConfig.save();
        this.mUploadConfig.save();
        this.mAppConfig.save();
        this.mDGroupConfig.save();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        super.endElement(str, str2, str3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        char c;
        char c2;
        int i;
        int i2;
        int i3;
        XMLReader xMLReader;
        Object valueOf;
        int i4;
        String str4;
        char c3;
        Object valueOf2;
        String str5;
        super.startElement(str, str2, str3, attributes);
        int i5 = 2;
        boolean z = true;
        switch (str3.hashCode()) {
            case -1362975621:
                if (str3.equals("dGroup")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -838595071:
                if (str3.equals(ReceiverType.UPLOAD)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 96801:
                if (str3.equals("app")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1427818632:
                if (str3.equals(ReceiverType.DOWNLOAD)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            this.mType = 1;
        } else if (c == 1) {
            this.mType = 2;
        } else if (c == 2) {
            this.mType = 3;
        } else if (c == 3) {
            this.mType = 4;
        }
        int i6 = this.mType;
        if (i6 != 1 && i6 != 2 && i6 != 4) {
            if (i6 != 3) {
                return;
            }
            String value = attributes.getValue("value");
            switch (str3.hashCode()) {
                case -1465029389:
                    if (str3.equals("useAriaCrashHandler")) {
                        c3 = 0;
                        break;
                    }
                    c3 = 65535;
                    break;
                case -556102918:
                    if (str3.equals("useBroadcast")) {
                        c3 = 3;
                        break;
                    }
                    c3 = 65535;
                    break;
                case 1265223019:
                    if (str3.equals("netCheck")) {
                        c3 = 2;
                        break;
                    }
                    c3 = 65535;
                    break;
                case 1698008830:
                    if (str3.equals("notNetRetry")) {
                        c3 = 4;
                        break;
                    }
                    c3 = 65535;
                    break;
                case 1995731616:
                    if (str3.equals("logLevel")) {
                        c3 = 1;
                        break;
                    }
                    c3 = 65535;
                    break;
                default:
                    c3 = 65535;
                    break;
            }
            if (c3 == 0) {
                if (checkBoolean(value)) {
                    z = Boolean.valueOf(value).booleanValue();
                }
                valueOf2 = Boolean.valueOf(z);
                str5 = "useAriaCrashHandler";
            } else if (c3 == 1) {
                int parseInt = checkInt(value) ? Integer.parseInt(value) : 2;
                if (parseInt < 2 || parseInt > 8) {
                    String str6 = this.TAG;
                    ALog.m4185w(str6, "level【" + parseInt + "】错误");
                } else {
                    i5 = parseInt;
                }
                valueOf2 = Integer.valueOf(i5);
                str5 = "logLevel";
            } else if (c3 == 2) {
                valueOf2 = Boolean.valueOf(checkBoolean(value) ? Boolean.valueOf(value).booleanValue() : false);
                str5 = "netCheck";
            } else if (c3 == 3) {
                valueOf2 = Boolean.valueOf(checkBoolean(value) ? Boolean.valueOf(value).booleanValue() : false);
                str5 = "useBroadcast";
            } else if (c3 != 4) {
                return;
            } else {
                valueOf2 = Boolean.valueOf(checkBoolean(value) ? Boolean.valueOf(value).booleanValue() : false);
                str5 = "notNetRetry";
            }
            setField(str5, valueOf2, 3);
            return;
        }
        String value2 = attributes.getValue("value");
        switch (str3.hashCode()) {
            case -1562250980:
                if (str3.equals("threadNum")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1522580748:
                if (str3.equals("buffSize")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1225712674:
                if (str3.equals("reTryNum")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1164496847:
                if (str3.equals("queueMod")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -363319875:
                if (str3.equals("maxTaskNum")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -359728905:
                if (str3.equals("connectTimeOut")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -310088890:
                if (str3.equals("useBlock")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case -210383525:
                if (str3.equals("iOTimeOut")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3166:
                if (str3.equals("ca")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 75456114:
                if (str3.equals("subFailAsStop")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 88800830:
                if (str3.equals("subReTryNum")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 163772445:
                if (str3.equals("subMaxTaskNum")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 396896579:
                if (str3.equals("maxSpeed")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 492890989:
                if (str3.equals("reTryInterval")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 699761933:
                if (str3.equals("subReTryInterval")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 755731028:
                if (str3.equals("convertSpeed")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1440589998:
                if (str3.equals("updateInterval")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        int i7 = 2000;
        switch (c2) {
            case 0:
                if (checkInt(value2)) {
                    i2 = Integer.parseInt(value2);
                    i = 1;
                } else {
                    i = 1;
                    i2 = 3;
                }
                if (i2 < i) {
                    ALog.m4185w(this.TAG, "下载线程数不能小于 1");
                    i2 = 1;
                }
                setField("threadNum", Integer.valueOf(i2), i);
                return;
            case 1:
                int parseInt2 = checkInt(value2) ? Integer.parseInt(value2) : 2;
                if (parseInt2 < 1) {
                    ALog.m4185w(this.TAG, "任务队列数不能小于 1");
                    i3 = 2;
                } else {
                    i3 = parseInt2;
                }
                setField("maxTaskNum", Integer.valueOf(i3), this.mType);
                return;
            case 2:
                setField("reTryNum", Integer.valueOf(checkInt(value2) ? Integer.parseInt(value2) : 0), this.mType);
                return;
            case 3:
                setField("connectTimeOut", Integer.valueOf(checkInt(value2) ? Integer.parseInt(value2) : 5000), this.mType);
                return;
            case 4:
                int i8 = 10000;
                int parseInt3 = checkInt(value2) ? Integer.parseInt(value2) : 10000;
                if (parseInt3 >= 10000) {
                    i8 = parseInt3;
                }
                setField("iOTimeOut", Integer.valueOf(i8), this.mType);
                return;
            case 5:
                int parseInt4 = checkInt(value2) ? Integer.parseInt(value2) : 2000;
                if (parseInt4 >= 2000) {
                    i7 = parseInt4;
                }
                setField("reTryInterval", Integer.valueOf(i7), this.mType);
                return;
            case 6:
                int parseInt5 = checkInt(value2) ? Integer.parseInt(value2) : 8192;
                if (parseInt5 < 2048) {
                    parseInt5 = 2048;
                }
                setField("buffSize", Integer.valueOf(parseInt5), this.mType);
                return;
            case 7:
                String value3 = attributes.getValue("name");
                String value4 = attributes.getValue("path");
                setField("caName", value3, this.mType);
                setField("caPath", value4, this.mType);
                return;
            case '\b':
                xMLReader = this;
                valueOf = Boolean.valueOf(!xMLReader.checkBoolean(value2) || Boolean.parseBoolean(value2));
                i4 = xMLReader.mType;
                str4 = "isConvertSpeed";
                break;
            case '\t':
                setField("maxSpeed", Integer.valueOf(checkInt(value2) ? Integer.parseInt(value2) : 0), this.mType);
                return;
            case '\n':
                if (TextUtils.isEmpty(value2) || (!value2.equalsIgnoreCase("now") && !value2.equalsIgnoreCase("wait"))) {
                    value2 = "now";
                }
                setField("queueMod", value2, this.mType);
                return;
            case 11:
                xMLReader = this;
                valueOf = Long.valueOf(xMLReader.checkLong(value2) ? Long.parseLong(value2) : 1000L);
                i4 = xMLReader.mType;
                str4 = "updateInterval";
                break;
            case '\f':
                setField("useBlock", Boolean.valueOf(checkBoolean(value2) ? Boolean.valueOf(value2).booleanValue() : false), 1);
                return;
            case '\r':
                setField("subMaxTaskNum", Integer.valueOf(checkInt(value2) ? Integer.parseInt(value2) : 3), 4);
                return;
            case 14:
                setField("subFailAsStop", Boolean.valueOf(checkBoolean(value2) ? Boolean.valueOf(value2).booleanValue() : false), 4);
                return;
            case 15:
                setField("subReTryNum", Integer.valueOf(checkInt(value2) ? Integer.parseInt(value2) : 5), 4);
                return;
            case 16:
                if (checkInt(value2)) {
                    i7 = Integer.parseInt(value2);
                }
                setField("subReTryInterval", Integer.valueOf(i7), 4);
                return;
            default:
                return;
        }
        xMLReader.setField(str4, valueOf, i4);
    }
}
