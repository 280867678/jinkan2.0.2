package com.p046uc.crashsdk.p047a;

import com.p046uc.crashsdk.C1490a;
import com.p046uc.crashsdk.C1500b;
import com.p046uc.crashsdk.C1503e;
import com.p046uc.crashsdk.C1508f;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsMediaPlayer;

/* renamed from: com.uc.crashsdk.a.e */
/* loaded from: classes4.dex */
public class RunnableC1495e implements Runnable {

    /* renamed from: a */
    public static final /* synthetic */ boolean f2634a = !RunnableC1495e.class.desiredAssertionStatus();

    /* renamed from: b */
    public final int f2635b;

    /* renamed from: c */
    public final Object[] f2636c;

    public RunnableC1495e(int i) {
        this.f2635b = i;
        this.f2636c = null;
    }

    public RunnableC1495e(int i, Object[] objArr) {
        this.f2635b = i;
        this.f2636c = objArr;
    }

    /* renamed from: a */
    public final boolean m1892a() {
        int i = this.f2635b;
        if (i == 451 || i == 452) {
            return C1503e.m1649b(this.f2635b, this.f2636c);
        }
        switch (i) {
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META /* 351 */:
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META /* 352 */:
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND /* 353 */:
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND /* 354 */:
                return C1498h.m1827b(i, this.f2636c);
            default:
                switch (i) {
                    case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA /* 751 */:
                    case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA /* 752 */:
                    case 753:
                    case 754:
                    case 755:
                    case 756:
                        return C1508f.m1562a(i, this.f2636c);
                    default:
                        C1491a.m1920d("crashsdk", "Unknown sync runnable: " + toString());
                        if (!f2634a) {
                            throw new AssertionError();
                        }
                        return false;
                }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.f2635b;
        if (i == 10) {
            C1496f.m1887a(i, this.f2636c);
        } else if (i == 500) {
            C1494d.m1901a(i);
        } else if (i == 700) {
            C1508f.m1550b(i);
        } else if (i == 800) {
            C1497g.m1881a(i);
        } else if (i == 201 || i == 202) {
            C1490a.m1961a(this.f2635b);
        } else {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                    C1500b.m1769a(i);
                    return;
                default:
                    switch (i) {
                        case 301:
                        case 302:
                        case 303:
                            C1498h.m1843a(i, this.f2636c);
                            return;
                        default:
                            switch (i) {
                                case 401:
                                case 402:
                                case 403:
                                    break;
                                default:
                                    switch (i) {
                                        case 405:
                                        case 406:
                                        case 407:
                                        case 408:
                                        case 409:
                                        case 410:
                                        case 411:
                                        case 412:
                                        case 413:
                                        case 414:
                                        case 415:
                                        case 416:
                                            break;
                                        default:
                                            C1491a.m1920d("crashsdk", "Unknown async runnable: " + toString());
                                            if (!f2634a) {
                                                throw new AssertionError();
                                            }
                                            return;
                                    }
                            }
                            C1503e.m1683a(this.f2635b, this.f2636c);
                            return;
                    }
            }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.f2635b;
    }
}
