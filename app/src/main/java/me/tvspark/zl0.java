package me.tvspark;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.event.CustomWebEvent;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.utils.SKUtils;
import org.litepal.crud.callback.SaveCallback;

/* loaded from: classes4.dex */
public class zl0 extends zk0<om0> implements nm0 {

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TypeReference<List<WebSourceTitaData>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zl0 zl0Var) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TypeReference<List<String>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zl0 zl0Var) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, List list, Activity activity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
        }

        @Override // org.litepal.crud.callback.SaveCallback
        public void onFinish(boolean z) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                if (((om0) zl0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                ((om0) zl0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwww();
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "批量导入完成");
                CustomWebEvent customWebEvent = new CustomWebEvent();
                customWebEvent.setToAdd(true);
                customWebEvent.setWebSourceTitaDataList(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
                return;
            }
            zl0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0068  */
    /* JADX WARN: Type inference failed for: r6v0, types: [me.tvspark.zl0] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List] */
    @Override // me.tvspark.nm0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, String str) {
        ArrayList arrayList;
        WebSourceTitaData webSourceTitaData;
        try {
            str = str.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            try {
                webSourceTitaData = (WebSourceTitaData) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)), WebSourceTitaData.class);
                arrayList = null;
            } catch (Exception unused) {
                List<String> list = (List) JSON.parseObject(str, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this), new Feature[0]);
                arrayList = new ArrayList();
                try {
                    for (String str2 : list) {
                        arrayList.add(JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2)), WebSourceTitaData.class));
                    }
                } catch (Exception unused2) {
                    try {
                        arrayList = (List) JSON.parseObject(str, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this), new Feature[0]);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    webSourceTitaData = null;
                    if (webSourceTitaData == null) {
                    }
                    if (arrayList != null) {
                    }
                }
                webSourceTitaData = null;
                if (webSourceTitaData == null) {
                }
                if (arrayList != null) {
                    return;
                }
                return;
            }
        } catch (Exception unused3) {
            arrayList = null;
            arrayList = (List) JSON.parseObject(str, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this), new Feature[0]);
            webSourceTitaData = null;
            if (webSourceTitaData == null) {
            }
            if (arrayList != null) {
            }
        }
        if (webSourceTitaData == null && !TextUtils.isEmpty(webSourceTitaData.getName())) {
            if (!TextUtils.isEmpty(webSourceTitaData.getBaseUrl())) {
                WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(webSourceTitaData.getBaseUrl());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("存在相同网站站源【 ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwwwwwww.getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" 】，是否覆盖之前的？");
                    AlertDialog create = builder.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString()).setPositiveButton("覆盖保存", new yl0(this, webSourceTitaData, activity, Wwwwwwwwwwwwwwwwwwwwwwwwww)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
                    create.setCanceledOnTouchOutside(true);
                    create.show();
                    return;
                }
                try {
                    webSourceTitaData.save();
                    CustomWebEvent customWebEvent = new CustomWebEvent();
                    customWebEvent.setToAdd(true);
                    customWebEvent.setWebSourceTitaData(webSourceTitaData);
                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, "成功导入 " + webSourceTitaData.getName());
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, "导入失败");
        } else if (arrayList != null && !arrayList.isEmpty() && !TextUtils.isEmpty(((WebSourceTitaData) arrayList.get(0)).getName())) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, arrayList, 0);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, List<WebSourceTitaData> list, int i) {
        if (list == null || list.isEmpty()) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, "导入为空");
            return;
        }
        ((om0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("导入中，请勿退出...");
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.get(i), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, list, activity));
    }
}
