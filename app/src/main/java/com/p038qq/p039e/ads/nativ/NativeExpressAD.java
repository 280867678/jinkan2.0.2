package com.p038qq.p039e.ads.nativ;

import android.content.Context;
import com.p038qq.p039e.ads.NativeAbstractAD;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADEvent;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.constants.ErrorCode;
import com.p038qq.p039e.comm.constants.LoadAdParams;
import com.p038qq.p039e.comm.listeners.ADRewardListener;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.p040pi.IReward;
import com.p038qq.p039e.comm.p040pi.NEADI;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeExpressAD */
/* loaded from: classes3.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {
    public volatile ServerSideVerificationOptions Wwwwwwwwwww;
    public LoadAdParams Wwwwwwwwwwww;
    public final ADListenerAdapter Wwwwwwwwwwwww;
    public NativeExpressADListener Wwwwwwwwwwwwww;
    public ADSize Wwwwwwwwwwwwwww;
    public VideoOption Wwwwwwwwwwwwwwww;
    public List<Integer> Wwwwwwwwwwwwwwwww = Collections.synchronizedList(new ArrayList());
    public volatile int Wwwwwwwwwwwwwwwwww;
    public volatile int Wwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.nativ.NativeExpressAD$ADListenerAdapter */
    /* loaded from: classes3.dex */
    public static class ADListenerAdapter implements ADListener {
        public ADRewardListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public NegativeFeedbackListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public NativeExpressMediaListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public NativeExpressADListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nativeExpressMediaListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00ac A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x012a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
        @Override // com.p038qq.p039e.comm.adevent.ADListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onADEvent(ADEvent aDEvent) {
            boolean z;
            boolean z2;
            boolean z3;
            NativeExpressADView nativeExpressADView;
            NativeExpressADListener nativeExpressADListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (nativeExpressADListener != null) {
                int type = aDEvent.getType();
                if (type == 100) {
                    List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                    if (list != null) {
                        nativeExpressADListener.onADLoaded(list);
                    }
                } else if (type == 101) {
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                    }
                } else if (type == 103) {
                    NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView2 != null) {
                        nativeExpressADListener.onADExposure(nativeExpressADView2);
                    }
                } else if (type == 303) {
                    NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView3 != null) {
                        nativeExpressADListener.onADLeftApplication(nativeExpressADView3);
                    }
                } else if (type == 105) {
                    NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView4 != null) {
                        nativeExpressADListener.onADClicked(nativeExpressADView4);
                    }
                } else if (type == 106) {
                    NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView5 != null) {
                        nativeExpressADListener.onADClosed(nativeExpressADView5);
                        nativeExpressADView5.negativeFeedback();
                    }
                } else if (type == 109) {
                    NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView6 != null) {
                        nativeExpressADListener.onRenderSuccess(nativeExpressADView6);
                    }
                } else if (type == 110) {
                    NativeExpressADView nativeExpressADView7 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView7 != null) {
                        nativeExpressADListener.onRenderFail(nativeExpressADView7);
                    }
                }
                z = true;
                if (!z) {
                    return;
                }
                NativeExpressMediaListener nativeExpressMediaListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
                    int type2 = aDEvent.getType();
                    if (type2 == 201) {
                        nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                    } else if (type2 == 202) {
                        nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                    } else if (type2 == 204) {
                        nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                    } else if (type2 == 206) {
                        nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                    } else if (type2 == 207) {
                        Integer num2 = (Integer) aDEvent.getParam(1, Integer.class);
                        if (num2 != null) {
                            nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num2.intValue()));
                        }
                    } else if (type2 == 301) {
                        nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                    } else if (type2 != 302) {
                        switch (type2) {
                            case 209:
                                nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                                break;
                            case 210:
                                Integer num3 = (Integer) aDEvent.getParam(1, Integer.class);
                                if (num3 != null) {
                                    nativeExpressMediaListener.onVideoReady(nativeExpressADView, num3.intValue());
                                    break;
                                }
                                break;
                            case 211:
                                nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                                break;
                        }
                        if (z2) {
                            return;
                        }
                        NegativeFeedbackListener negativeFeedbackListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (negativeFeedbackListener != null && aDEvent.getType() == 304) {
                            negativeFeedbackListener.onComplainSuccess();
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            return;
                        }
                        ADRewardListener aDRewardListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (aDRewardListener == null || aDEvent.getType() != 104) {
                            return;
                        }
                        String str = (String) aDEvent.getParam(String.class);
                        if (str == null) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                        aDRewardListener.onReward(hashMap);
                        return;
                    } else {
                        nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            z = false;
            if (!z) {
            }
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = negativeFeedbackListener;
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeExpressAD$NativeExpressADListener */
    /* loaded from: classes3.dex */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        boolean z;
        this.Wwwwwwwwwwwwww = nativeExpressADListener;
        this.Wwwwwwwwwwwww = new ADListenerAdapter(nativeExpressADListener);
        if (aDSize == null) {
            GDTLogger.m3646e("初始化错误：参数adSize不能为空");
            m3680a(ErrorCode.INIT_ERROR);
            z = true;
        } else {
            this.Wwwwwwwwwwwwwww = aDSize;
            z = false;
        }
        if (z) {
            return;
        }
        m3679a(context, str);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public Object mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.Wwwwwwwwwwwwwww, str, str2, str3, this.Wwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.NativeAbstractAD, com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo3668a(NEADI neadi) {
        super.mo3671a((NativeExpressAD) neadi);
        neadi.setMinVideoDuration(this.Wwwwwwwwwwwwwwwwwww);
        neadi.setMaxVideoDuration(this.Wwwwwwwwwwwwwwwwww);
        ((NEADI) this.f657a).setServerSideVerificationOptions(this.Wwwwwwwwwww);
        VideoOption videoOption = this.Wwwwwwwwwwwwwwww;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.Wwwwwwwwwwwwwwwww) {
            Iterator<Integer> it = this.Wwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                if (this.f657a != 0) {
                    if (this.Wwwwwwwwwwww != null) {
                        ((NEADI) this.f657a).loadAd(it.next().intValue(), this.Wwwwwwwwwwww);
                    } else {
                        ((NEADI) this.f657a).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: b */
    public void mo3667b(int i) {
        NativeExpressADListener nativeExpressADListener = this.Wwwwwwwwwwwwww;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f657a;
        if (t != 0) {
            return ((NEADI) t).getAdNetWorkName();
        }
        m3677a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i) {
        loadAD(i, null);
    }

    public void loadAD(int i, LoadAdParams loadAdParams) {
        if (!m3681a()) {
            return;
        }
        if (loadAdParams != null) {
            setAdParams(loadAdParams);
        }
        if (!m3676b()) {
            synchronized (this.Wwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwww.add(Integer.valueOf(i));
            }
            return;
        }
        T t = this.f657a;
        if (t == 0) {
            m3677a("loadAD");
            return;
        }
        LoadAdParams loadAdParams2 = this.Wwwwwwwwwwww;
        NEADI neadi = (NEADI) t;
        if (loadAdParams2 != null) {
            neadi.loadAd(i, loadAdParams2);
        } else {
            neadi.loadAd(i);
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.Wwwwwwwwwwww = loadAdParams;
    }

    public void setMaxVideoDuration(int i) {
        this.Wwwwwwwwwwwwwwwwww = i;
        if (this.Wwwwwwwwwwwwwwwwww > 0 && this.Wwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwww) {
            GDTLogger.m3646e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f657a;
        if (t != 0) {
            ((NEADI) t).setMaxVideoDuration(this.Wwwwwwwwwwwwwwwwww);
        }
    }

    public void setMinVideoDuration(int i) {
        this.Wwwwwwwwwwwwwwwwwww = i;
        if (this.Wwwwwwwwwwwwwwwwww > 0 && this.Wwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwww) {
            GDTLogger.m3646e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f657a;
        if (t != 0) {
            ((NEADI) t).setMinVideoDuration(this.Wwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.Wwwwwwwwwwwww.setAdRewardListener(aDRewardListener);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.Wwwwwwwwwww = serverSideVerificationOptions;
        T t = this.f657a;
        if (t != 0) {
            ((NEADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.Wwwwwwwwwwwwwwww = videoOption;
        T t = this.f657a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t).setVideoOption(videoOption);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        boolean z;
        this.Wwwwwwwwwwwwww = nativeExpressADListener;
        this.Wwwwwwwwwwwww = new ADListenerAdapter(nativeExpressADListener);
        if (aDSize == null) {
            GDTLogger.m3646e("初始化错误：参数adSize不能为空");
            m3680a(ErrorCode.INIT_ERROR);
            z = true;
        } else {
            this.Wwwwwwwwwwwwwww = aDSize;
            z = false;
        }
        if (z) {
            return;
        }
        m3678a(context, str, str2);
    }
}
