package com.lzf.easyfloat.utils;

import android.content.Context;
import com.lzf.easyfloat.interfaces.OnDisplayHeight;
import com.umeng.analytics.pro.C1615d;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public final class DefaultDisplayHeight implements OnDisplayHeight {
    @Override // com.lzf.easyfloat.interfaces.OnDisplayHeight
    public int getDisplayRealHeight(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        return DisplayUtils.INSTANCE.rejectedNavHeight(context);
    }
}
