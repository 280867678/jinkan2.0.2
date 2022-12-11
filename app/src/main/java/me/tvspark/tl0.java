package me.tvspark;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.LiveParcel;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.im0;
import me.tvspark.model.analyzeRule.AnalyzeRule;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class tl0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public WebSourceLiveData Wwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public Response<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public tl0(Context context, boolean z, WebSourceLiveData webSourceLiveData, String str, Response<ResponseBody> response, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = response;
        this.Wwwwwwwwwwwwwwwwwwwww = webSourceLiveData;
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        String str;
        String replace;
        ArrayList arrayList = new ArrayList();
        ParsedParcel parsedParcel = new ParsedParcel();
        try {
            str = !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww.getChartsetName()) ? new String(this.Wwwwwwwwwwwwwwwwwwwwwwww.body().bytes(), this.Wwwwwwwwwwwwwwwwwwwww.getChartsetName()) : this.Wwwwwwwwwwwwwwwwwwwwwwww.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            parsedParcel.setSuccess(false);
            parsedParcel.setObj(arrayList);
        }
        if (!TextUtils.isEmpty(str) && this.Wwwwwwwwwwwwwwwwwwwww != null) {
            AnalyzeRule analyzeRule = new AnalyzeRule();
            if (this.Wwwwwwwwwwwwwwwwwwwww.isAllGeted()) {
                List<Object> elements = analyzeRule.setContent(str).getElements(this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelList());
                if (elements != null && elements.size() > 0) {
                    for (int i = 0; i < elements.size(); i++) {
                        Object obj = elements.get(i);
                        List<Object> elements2 = analyzeRule.setContent(obj).getElements(this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildList());
                        if (elements2 != null && !elements2.isEmpty()) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < elements2.size(); i2++) {
                                Object obj2 = elements2.get(i2);
                                LiveParcel liveParcel = new LiveParcel();
                                liveParcel.setChanelName(analyzeRule.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildName()));
                                liveParcel.setChanelUrl(this.Wwwwwwwwwwwwwwwwwwwww.getChannelUrlPrefix() + analyzeRule.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildUrl()));
                                if (liveParcel.getChanelUrl().contains(".html") && !TextUtils.isEmpty(liveParcel.getChanelName())) {
                                    arrayList2.add(liveParcel);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                LiveParcel liveParcel2 = new LiveParcel();
                                liveParcel2.setChanelName(TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelName()) ? "线路" + (i + 1) : analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelName()));
                                liveParcel2.setChanelUrl(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelUrl()));
                                liveParcel2.setEpisodeList(arrayList2);
                                if (!TextUtils.isEmpty(liveParcel2.getChanelName())) {
                                    arrayList.add(liveParcel2);
                                }
                            }
                        }
                    }
                }
            } else {
                List<Object> elements3 = analyzeRule.setContent(str).getElements(this.Wwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildList() : this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelList());
                if (elements3 != null && elements3.size() > 0) {
                    for (int i3 = 0; i3 < elements3.size(); i3++) {
                        LiveParcel liveParcel3 = new LiveParcel();
                        Object obj3 = elements3.get(i3);
                        String string = analyzeRule.setContent(obj3).getString(this.Wwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildUrl() : this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelUrl());
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.Wwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildUrlPrefix() : this.Wwwwwwwwwwwwwwwwwwwww.getChannelUrlPrefix());
                        sb.append(string);
                        liveParcel3.setChanelUrl(sb.toString());
                        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildName() : this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelName())) {
                            replace = analyzeRule.setContent(obj3).getString(this.Wwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwww.getRuleChildName().replace("IPTV", "") : this.Wwwwwwwwwwwwwwwwwwwww.getRuleChannelName()).replace("IPTV", "");
                        } else if (this.Wwwwwwwwwwwwwwwwwwww) {
                            replace = "频道";
                        } else {
                            replace = "线路" + (i3 + 1);
                        }
                        liveParcel3.setChanelName(replace);
                        if (!TextUtils.isEmpty(liveParcel3.getChanelName())) {
                            arrayList.add(liveParcel3);
                        }
                    }
                }
            }
            parsedParcel.setSuccess(true);
            parsedParcel.setObj(arrayList);
            return parsedParcel;
        }
        parsedParcel.setSuccess(false);
        parsedParcel.setObj(arrayList);
        return parsedParcel;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ParsedParcel parsedParcel) {
        Object obj;
        ParsedParcel parsedParcel2 = parsedParcel;
        super.onPostExecute(parsedParcel2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            boolean isSuccess = parsedParcel2.isSuccess();
            List<LiveParcel> list = (List) parsedParcel2.getObj();
            String str = this.Wwwwwwwwwwwwwwwwwwwwww;
            im0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (im0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            try {
                if (im0.this.Wwwwwwwwwwwwwwwwwwwww.isAllGeted()) {
                    im0.this.Wwwwwwwwwwwwwwwwwwwwww.clear();
                    im0.this.Wwwwwwwwwwwwwwwwwwwwww.addAll(list);
                    if (!str.equals(im0.this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                        return;
                    }
                    im0.this.Wwwwwwwwwwwwwwwwwwwwwww = list.get(0).getChanelName();
                    ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(im0.this.Wwwwwwwwwwwwwwwwwwwwwww, im0.this.Wwwwwwwwwwwwwwwwwwwwww, list.get(0).getEpisodeList());
                } else if (isSuccess && !TextUtils.isEmpty(str)) {
                    for (int i = 0; i < im0.this.Wwwwwwwwwwwwwwwwwwwwww.size(); i++) {
                        if (im0.this.Wwwwwwwwwwwwwwwwwwwwww.get(i).getChanelName().equals(str)) {
                            im0.this.Wwwwwwwwwwwwwwwwwwwwww.get(i).setEpisodeList(list);
                            if (str.equals(im0.this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                                ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(im0.this.Wwwwwwwwwwwwwwwwwwwwwww, im0.this.Wwwwwwwwwwwwwwwwwwwwww, list);
                                return;
                            } else {
                                ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(im0.this.Wwwwwwwwwwwwwwwwwwwwww);
                                return;
                            }
                        }
                    }
                } else if (list != null && !list.isEmpty()) {
                    im0.this.Wwwwwwwwwwwwwwwwwwwwww.clear();
                    im0.this.Wwwwwwwwwwwwwwwwwwwwww.addAll(list);
                    if (!str.equals(im0.this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                        return;
                    }
                    im0.this.Wwwwwwwwwwwwwwwwwwwwwww = list.get(0).getChanelName();
                    ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(im0.this.Wwwwwwwwwwwwwwwwwwwwwww, im0.this.Wwwwwwwwwwwwwwwwwwwwww);
                    im0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, list.get(0).getChanelUrl());
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (im0.this.Wwwwwwwwwwwwwwwwwwwww.isAllGeted()) {
                    obj = im0.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                } else if (TextUtils.isEmpty(str)) {
                    obj = im0.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwww();
                    return;
                }
                ((cn0) obj).Wwwwwwwwwwwwwwwwwwww();
            }
        }
    }
}
