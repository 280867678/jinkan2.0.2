package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import me.tvspark.data.bean.LocalInputParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.utils.SKUtils;
import org.litepal.LitePal;

/* loaded from: classes4.dex */
public class jo0 extends AsyncTask<Void, Void, Boolean> implements sk0 {
    public String Wwwwwwwwwwwwwwwwwwwww = "";
    public List<WebSourceSeasonData> Wwwwwwwwwwwwwwwwwwwwww;
    public List<WebSourceIndexData> Wwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void onFinish(boolean z);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<WebSourceSeasonData> list) {
        try {
            LitePal.deleteAll(WebSourceSeasonData.class, new String[0]);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).clearSavedState();
            }
            LitePal.saveAll(list);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<WebSourceIndexData> list) {
        try {
            LitePal.deleteAll(WebSourceIndexData.class, new String[0]);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).clearSavedState();
            }
            LitePal.saveAll(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void[] voidArr) {
        StringBuilder sb;
        boolean z = false;
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww)) {
            String str = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.Wwwwwwwwwwwwwwwwwwwww));
                sb = new StringBuilder();
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (IOException unused) {
                    }
                }
                bufferedReader.close();
            } catch (IOException unused2) {
                sb = null;
            }
            if (sb != null) {
                str = sb.toString();
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    LocalInputParcel localInputParcel = (LocalInputParcel) JSON.parseObject(str, LocalInputParcel.class);
                    List<WebSourceIndexData> list = (List) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localInputParcel.getIndex())), new go0(this), new Feature[0]);
                    if (list != null && !list.isEmpty() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list)) {
                        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cur_url_index", list.get(0).getWebSourceBaseUrl());
                    }
                    List<WebSourceSeasonData> list2 = (List) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localInputParcel.getSeason())), new ho0(this), new Feature[0]);
                    if (list2 != null && !list2.isEmpty()) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2);
                    }
                    List list3 = (List) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localInputParcel.getLive())), new io0(this), new Feature[0]);
                    if (list3 != null && !list3.isEmpty()) {
                        for (int i = 0; i < list3.size(); i++) {
                            ((WebSourceLiveData) list3.get(i)).clearSavedState();
                        }
                        LitePal.saveAll(list3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return Boolean.valueOf(z);
        }
        List<WebSourceIndexData> list4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list4 == null || list4.isEmpty()) {
            List<WebSourceSeasonData> list5 = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (list5 != null && !list5.isEmpty()) {
                z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
            }
        } else {
            z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
        return Boolean.valueOf(z);
        z = true;
        return Boolean.valueOf(z);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        Boolean bool2 = bool;
        super.onPostExecute(bool2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onFinish(bool2.booleanValue());
        }
    }
}
