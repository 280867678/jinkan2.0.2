package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;

    /* renamed from: b */
    public static final String[] f1927b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};

    /* renamed from: i */
    public ReaderPreDownloadCallback f1935i;

    /* renamed from: a */
    public Handler f1928a = null;

    /* renamed from: c */
    public LinkedList<String> f1929c = new LinkedList<>();

    /* renamed from: d */
    public boolean f1930d = false;

    /* renamed from: e */
    public ReaderWizard f1931e = null;

    /* renamed from: f */
    public TbsReaderView.ReaderCallback f1932f = null;

    /* renamed from: g */
    public Object f1933g = null;

    /* renamed from: h */
    public Context f1934h = null;

    /* renamed from: j */
    public String f1936j = "";

    /* loaded from: classes4.dex */
    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i, boolean z);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        this.f1935i = null;
        this.f1935i = readerPreDownloadCallback;
        for (String str : f1927b) {
            this.f1929c.add(str);
        }
        m2747a();
    }

    /* renamed from: b */
    private void m2743b() {
        m2742b(3);
    }

    /* renamed from: a */
    public void m2747a() {
        this.f1928a = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 3 && !TbsReaderPredownload.this.f1929c.isEmpty()) {
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    if (tbsReaderPredownload.f1930d) {
                        return;
                    }
                    String removeFirst = tbsReaderPredownload.f1929c.removeFirst();
                    TbsReaderPredownload tbsReaderPredownload2 = TbsReaderPredownload.this;
                    tbsReaderPredownload2.f1936j = removeFirst;
                    if (tbsReaderPredownload2.m2744a(removeFirst)) {
                        return;
                    }
                    TbsReaderPredownload.this.m2746a(-1);
                }
            }
        };
    }

    /* renamed from: a */
    public void m2746a(int i) {
        if (this.f1935i != null) {
            this.f1935i.onEvent(this.f1936j, i, this.f1929c.isEmpty());
        }
    }

    /* renamed from: a */
    public void m2745a(int i, int i2) {
        this.f1928a.sendMessageDelayed(this.f1928a.obtainMessage(i), i2);
    }

    /* renamed from: a */
    public boolean m2744a(String str) {
        if (this.f1933g == null || this.f1931e == null || !ReaderWizard.isSupportExt(str)) {
            return false;
        }
        return this.f1931e.checkPlugin(this.f1933g, this.f1934h, str, true);
    }

    /* renamed from: b */
    public void m2742b(int i) {
        this.f1928a.removeMessages(i);
    }

    /* renamed from: c */
    public boolean m2741c(int i) {
        return this.f1928a.hasMessages(i);
    }

    public boolean init(Context context) {
        if (context == null) {
            return false;
        }
        this.f1934h = StubApp.getOrigApplicationContext(context.getApplicationContext());
        boolean m2739a = TbsReaderView.m2739a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        TbsReaderView.ReaderCallback readerCallback = new TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                int intValue;
                if (num.intValue() == 5012 && 5014 != (intValue = ((Integer) obj).intValue())) {
                    if (5013 == intValue || intValue == 0) {
                        TbsReaderPredownload.this.m2746a(0);
                    } else {
                        TbsReaderPredownload.this.m2746a(-1);
                    }
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    tbsReaderPredownload.f1936j = "";
                    tbsReaderPredownload.m2745a(3, 100);
                }
            }
        };
        this.f1932f = readerCallback;
        try {
            if (this.f1931e == null) {
                this.f1931e = new ReaderWizard(readerCallback);
            }
            if (this.f1933g == null) {
                this.f1933g = this.f1931e.getTbsReader();
            }
            return this.f1933g != null ? this.f1931e.initTbsReader(this.f1933g, StubApp.getOrigApplicationContext(context.getApplicationContext())) : m2739a;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public void pause() {
        this.f1930d = true;
    }

    public void shutdown() {
        this.f1935i = null;
        this.f1930d = false;
        this.f1929c.clear();
        m2743b();
        ReaderWizard readerWizard = this.f1931e;
        if (readerWizard != null) {
            readerWizard.destroy(this.f1933g);
            this.f1933g = null;
        }
        this.f1934h = null;
    }

    public void start(String str) {
        this.f1930d = false;
        m2742b(3);
        this.f1929c.add(str);
        m2745a(3, 100);
    }

    public void startAll() {
        this.f1930d = false;
        if (!false && !m2741c(3)) {
            m2745a(3, 100);
        }
    }
}
