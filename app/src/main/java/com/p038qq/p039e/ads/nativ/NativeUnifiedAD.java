package com.p038qq.p039e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.p038qq.p039e.ads.NativeAbstractAD;
import com.p038qq.p039e.comm.adevent.ADEvent;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.constants.LoadAdParams;
import com.p038qq.p039e.comm.p040pi.NUADI;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedAD */
/* loaded from: classes3.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {
    public LoadAdParams Wwwwwwwwwwww;
    public String Wwwwwwwwwwwww;
    public volatile int Wwwwwwwwwwwwww;
    public volatile int Wwwwwwwwwwwwwww;
    public List<String> Wwwwwwwwwwwwwwww;
    public List<Integer> Wwwwwwwwwwwwwwwww = new ArrayList();
    public NativeADUnifiedListener Wwwwwwwwwwwwwwwwww;
    public AdListenerAdapter Wwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedAD$AdListenerAdapter */
    /* loaded from: classes3.dex */
    public static class AdListenerAdapter implements ADListener {
        public NativeADUnifiedListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nativeADUnifiedListener;
        }

        @Override // com.p038qq.p039e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type != 101 || (num = (Integer) aDEvent.getParam(Integer.class)) == null) {
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                    return;
                }
                List<NativeUnifiedADData> list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.Wwwwwwwwwwwwwwwwww = nativeADUnifiedListener;
        this.Wwwwwwwwwwwwwwwwwww = new AdListenerAdapter(nativeADUnifiedListener);
        m3679a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.Wwwwwwwwwwwwwwwwww = nativeADUnifiedListener;
        this.Wwwwwwwwwwwwwwwwwww = new AdListenerAdapter(nativeADUnifiedListener);
        m3678a(context, str, str2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            if (!z) {
                return;
            }
            this.Wwwwwwwwwwwwwwwww.add(Integer.valueOf(i));
            return;
        }
        T t = this.f657a;
        if (t == 0) {
            return;
        }
        LoadAdParams loadAdParams = this.Wwwwwwwwwwww;
        NUADI nuadi = (NUADI) t;
        if (loadAdParams != null) {
            nuadi.loadData(i, loadAdParams);
        } else {
            nuadi.loadData(i);
        }
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public Object mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.Wwwwwwwwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.NativeAbstractAD, com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo3668a(NUADI nuadi) {
        super.mo3671a((NativeUnifiedAD) nuadi);
        nuadi.setMinVideoDuration(this.Wwwwwwwwwwwwwww);
        nuadi.setMaxVideoDuration(this.Wwwwwwwwwwwwww);
        nuadi.setVastClassName(this.Wwwwwwwwwwwww);
        List<String> list = this.Wwwwwwwwwwwwwwww;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.Wwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(num.intValue(), false);
        }
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: b */
    public void mo3667b(int i) {
        NativeADUnifiedListener nativeADUnifiedListener = this.Wwwwwwwwwwwwwwwwww;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f657a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        m3677a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        this.Wwwwwwwwwwww = loadAdParams;
        loadData(i);
    }

    public void setCategories(List<String> list) {
        this.Wwwwwwwwwwwwwwww = list;
        T t = this.f657a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.Wwwwwwwwwwwwww = i;
        if (this.Wwwwwwwwwwwwww > 0 && this.Wwwwwwwwwwwwwww > this.Wwwwwwwwwwwwww) {
            GDTLogger.m3646e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f657a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.Wwwwwwwwwwwwww);
        }
    }

    public void setMinVideoDuration(int i) {
        this.Wwwwwwwwwwwwwww = i;
        if (this.Wwwwwwwwwwwwww > 0 && this.Wwwwwwwwwwwwwww > this.Wwwwwwwwwwwwww) {
            GDTLogger.m3646e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f657a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.Wwwwwwwwwwwwwww);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.m3646e("Vast class name 不能为空");
            return;
        }
        this.Wwwwwwwwwwwww = str;
        T t = this.f657a;
        if (t == 0) {
            return;
        }
        ((NUADI) t).setVastClassName(str);
    }
}
