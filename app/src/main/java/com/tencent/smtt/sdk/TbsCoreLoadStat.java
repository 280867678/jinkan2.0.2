package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class TbsCoreLoadStat {

    /* renamed from: d */
    public static TbsCoreLoadStat f1837d = null;
    public static volatile int mLoadErrorCode = -1;

    /* renamed from: a */
    public TbsSequenceQueue f1838a = null;

    /* renamed from: b */
    public boolean f1839b = false;

    /* renamed from: c */
    public final int f1840c = 3;

    /* loaded from: classes4.dex */
    public class TbsSequenceQueue {

        /* renamed from: b */
        public int f1842b;

        /* renamed from: c */
        public int f1843c;

        /* renamed from: d */
        public int[] f1844d;

        /* renamed from: e */
        public int f1845e;

        /* renamed from: f */
        public int f1846f;

        public TbsSequenceQueue() {
            this.f1842b = 10;
            this.f1845e = 0;
            this.f1846f = 0;
            this.f1843c = 10;
            this.f1844d = new int[10];
        }

        public TbsSequenceQueue(int i, int i2) {
            this.f1842b = 10;
            this.f1845e = 0;
            this.f1846f = 0;
            this.f1843c = i2;
            int[] iArr = new int[i2];
            this.f1844d = iArr;
            iArr[0] = i;
            this.f1846f = 0 + 1;
        }

        public void add(int i) {
            int i2 = this.f1846f;
            if (i2 <= this.f1843c - 1) {
                int[] iArr = this.f1844d;
                this.f1846f = i2 + 1;
                iArr[i2] = i;
                return;
            }
            throw new IndexOutOfBoundsException("sequeue is full");
        }

        public void clear() {
            Arrays.fill(this.f1844d, 0);
            this.f1845e = 0;
            this.f1846f = 0;
        }

        public int element() {
            if (!empty()) {
                return this.f1844d[this.f1845e];
            }
            throw new IndexOutOfBoundsException("sequeue is null");
        }

        public boolean empty() {
            return this.f1846f == this.f1845e;
        }

        public int length() {
            return this.f1846f - this.f1845e;
        }

        public int remove() {
            if (!empty()) {
                int[] iArr = this.f1844d;
                int i = this.f1845e;
                int i2 = iArr[i];
                this.f1845e = i + 1;
                iArr[i] = 0;
                return i2;
            }
            throw new IndexOutOfBoundsException("sequeue is null");
        }

        public String toString() {
            if (empty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = this.f1845e; i < this.f1846f; i++) {
                sb.append(String.valueOf(this.f1844d[i]) + ",");
            }
            int length = sb.length();
            StringBuilder delete = sb.delete(length - 1, length);
            delete.append("]");
            return delete.toString();
        }
    }

    public static TbsCoreLoadStat getInstance() {
        if (f1837d == null) {
            f1837d = new TbsCoreLoadStat();
        }
        return f1837d;
    }

    /* renamed from: a */
    public void m2815a(Context context, int i) {
        m2814a(context, i, null);
        TbsLog.m2158e(TbsListener.tag_load_error, "" + i);
    }

    /* renamed from: a */
    public synchronized void m2814a(Context context, int i, Throwable th) {
        TbsLog.m2158e("TbsCoreLoadStat", "[loadError] errorCode: " + i + ", details:" + String.valueOf(th));
        if (th != null) {
            if (mLoadErrorCode == -1) {
                mLoadErrorCode = i;
                TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
                TbsLog.m2155i("TbsCoreLoadStat", mLoadErrorCode + " report success!");
            } else {
                TbsLog.m2148w("TbsCoreLoadStat", mLoadErrorCode + " is reported, others will be saved in local TbsLog!");
            }
        }
    }
}
