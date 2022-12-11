package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.km0;
import me.tvspark.model.analyzeRule.AnalyzeRule;

/* loaded from: classes4.dex */
public class ul0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public WebSourceIndexData Wwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public ul0(WebSourceIndexData webSourceIndexData, String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = webSourceIndexData;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        StringBuilder sb;
        StringBuilder sb2;
        ArrayList arrayList = new ArrayList();
        ParsedParcel parsedParcel = new ParsedParcel();
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwww != null) {
            try {
                AnalyzeRule analyzeRule = new AnalyzeRule();
                List<Object> elements = analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwwww).getElements(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchList());
                if (elements != null && elements.size() > 0) {
                    for (int i = 0; i < elements.size(); i++) {
                        VideoParcel videoParcel = new VideoParcel();
                        Object obj = elements.get(i);
                        videoParcel.setTitle(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchTitle()));
                        videoParcel.setLink(this.Wwwwwwwwwwwwwwwwwwwwww.getSearchLinkPrefix() + analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchLink()));
                        try {
                            if (!videoParcel.getLink().startsWith("http") && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                                if (videoParcel.getLink().startsWith("/")) {
                                    sb2 = new StringBuilder();
                                    sb2.append(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl());
                                    sb2.append(videoParcel.getLink());
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl());
                                    sb2.append("/");
                                    sb2.append(videoParcel.getLink());
                                }
                                videoParcel.setLink(sb2.toString());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        videoParcel.setCoverUrl(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww.getSearchCoverPrefix(), analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchCover())));
                        try {
                            if (!videoParcel.getCoverUrl().startsWith("http") && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                                if (videoParcel.getCoverUrl().startsWith("/")) {
                                    sb = new StringBuilder();
                                    sb.append(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl());
                                    sb.append(videoParcel.getCoverUrl());
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl());
                                    sb.append("/");
                                    sb.append(videoParcel.getCoverUrl());
                                }
                                videoParcel.setCoverUrl(sb.toString());
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        String string = analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchNumber());
                        videoParcel.setNumber(string);
                        String string2 = analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchActor());
                        if (!TextUtils.isEmpty(string)) {
                            videoParcel.setActor(string);
                        } else if (!TextUtils.isEmpty(string2)) {
                            videoParcel.setActor(string2);
                        }
                        arrayList.add(videoParcel);
                    }
                }
                parsedParcel.setSuccess(true);
                parsedParcel.setObj(arrayList);
            } catch (Exception e3) {
                e3.printStackTrace();
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
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            String str = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            km0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (km0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ((gn0) km0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parsedParcel2.isSuccess(), (List) parsedParcel2.getObj(), str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
