package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.bean.VideoIndexParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.mm0;
import me.tvspark.model.analyzeRule.AnalyzeRule;
import okhttp3.ResponseBody;
import white.whale.R;

/* loaded from: classes4.dex */
public class xl0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public WebSourceIndexData Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public ResponseBody Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public xl0(ResponseBody responseBody, String str, WebSourceIndexData webSourceIndexData, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = responseBody;
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = webSourceIndexData;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        WebSourceIndexData webSourceIndexData;
        List<Object> elements;
        int i;
        xl0 xl0Var = this;
        ArrayList arrayList = new ArrayList();
        ParsedParcel parsedParcel = new ParsedParcel();
        if ((!TextUtils.isEmpty(xl0Var.Wwwwwwwwwwwwwwwwwwwwwww) || xl0Var.Wwwwwwwwwwwwwwwwwwwwwwww != null) && (webSourceIndexData = xl0Var.Wwwwwwwwwwwwwwwwwwwww) != null) {
            try {
                if (xl0Var.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    if (!TextUtils.isEmpty(webSourceIndexData.getHtmlCharset())) {
                        xl0Var.Wwwwwwwwwwwwwwwwwwwwwww = new String(xl0Var.Wwwwwwwwwwwwwwwwwwwwwwww.bytes(), xl0Var.Wwwwwwwwwwwwwwwwwwwww.getHtmlCharset());
                    } else {
                        xl0Var.Wwwwwwwwwwwwwwwwwwwwwww = xl0Var.Wwwwwwwwwwwwwwwwwwwwwwww.string();
                    }
                }
                AnalyzeRule analyzeRule = new AnalyzeRule();
                int i2 = 4;
                String[] strArr = {xl0Var.Wwwwwwwwwwwwwwwwwwwww.getRuleIndex1List(), xl0Var.Wwwwwwwwwwwwwwwwwwwww.getRuleIndex2List(), xl0Var.Wwwwwwwwwwwwwwwwwwwww.getRuleIndex3List(), xl0Var.Wwwwwwwwwwwwwwwwwwwww.getRuleIndex4List()};
                String[] strArr2 = {"热播推荐", "精彩影视", "最新综艺", "人气动漫"};
                int[] iArr = {R.drawable.ic_home_mark_2, R.drawable.ic_home_mark_4, R.drawable.ic_home_mark_7, R.drawable.ic_home_mark_8};
                int i3 = 0;
                while (i3 < i2) {
                    if (!TextUtils.isEmpty(strArr[i3]) && (elements = analyzeRule.setContent(xl0Var.Wwwwwwwwwwwwwwwwwwwwwww).getElements(strArr[i3])) != null && elements.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        VideoIndexParcel videoIndexParcel = new VideoIndexParcel();
                        int i4 = 0;
                        while (i4 < elements.size()) {
                            VideoParcel videoParcel = new VideoParcel();
                            Object obj = elements.get(i4);
                            videoParcel.setTitle(analyzeRule.setContent(obj).getString(xl0Var.Wwwwwwwwwwwwwwwwwwwww.getRuleIndexOtherTitle()));
                            ArrayList arrayList3 = arrayList2;
                            un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoParcel.getTitle(), new wl0(this, videoParcel, analyzeRule, obj, arrayList3));
                            i4++;
                            videoIndexParcel = videoIndexParcel;
                            i3 = i3;
                            arrayList2 = arrayList3;
                            elements = elements;
                            xl0Var = this;
                        }
                        VideoIndexParcel videoIndexParcel2 = videoIndexParcel;
                        i = i3;
                        videoIndexParcel2.setColumnTitle(strArr2[i]);
                        videoIndexParcel2.setMoreIcon(iArr[i]);
                        videoIndexParcel2.setVideoList(arrayList2);
                        arrayList.add(videoIndexParcel2);
                    } else {
                        i = i3;
                    }
                    i3 = i + 1;
                    i2 = 4;
                    xl0Var = this;
                }
                parsedParcel.setSuccess(true);
                parsedParcel.setObj(arrayList);
            } catch (Exception e) {
                e.printStackTrace();
                parsedParcel.setSuccess(false);
            }
            return parsedParcel;
        }
        parsedParcel.setSuccess(false);
        parsedParcel.setObj(arrayList);
        return parsedParcel;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ParsedParcel parsedParcel) {
        ParsedParcel parsedParcel2 = parsedParcel;
        super.onPostExecute(parsedParcel2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            boolean isSuccess = parsedParcel2.isSuccess();
            List<VideoIndexParcel> list = (List) parsedParcel2.getObj();
            String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
            mm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (mm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                ((kn0) mm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isSuccess, list, str);
            } else {
                ((kn0) mm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isSuccess, list, str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }
}
