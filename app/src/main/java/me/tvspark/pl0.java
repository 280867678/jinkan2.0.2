package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.IndexRankListParcel;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.hm0;
import me.tvspark.model.analyzeRule.AnalyzeRule;

/* loaded from: classes4.dex */
public class pl0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public pl0(String str, WebSourceIndexRecData webSourceIndexRecData, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceIndexRecData;
        this.Wwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        ParsedParcel parsedParcel = new ParsedParcel();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            parsedParcel.setSuccess(false);
            parsedParcel.setObj(arrayList);
        }
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            String str = !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRankHtmlCharset()) ? new String(this.Wwwwwwwwwwwwwwwwwwwwwww.getBytes(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getRankHtmlCharset()) : this.Wwwwwwwwwwwwwwwwwwwwwww;
            IndexRankListParcel indexRankListParcel = new IndexRankListParcel();
            indexRankListParcel.setTitleRank(this.Wwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwwwwww.getTvRankTitle() : this.Wwwwwwwwwwwwwwwwwwwwwwww.getMovieRankTitle());
            AnalyzeRule analyzeRule = new AnalyzeRule();
            List<Object> elements = analyzeRule.setContent(str).getElements(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleRankList());
            if (elements != null && elements.size() > 0) {
                for (int i = 0; i < elements.size(); i++) {
                    VideoParcel videoParcel = new VideoParcel();
                    Object obj = elements.get(i);
                    videoParcel.setTitle(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoRankTitle())));
                    videoParcel.setCoverUrl(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoRankCoverPrefix() + analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoRankCover()));
                    videoParcel.setScore(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoRankScore()));
                    videoParcel.setActor(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoRankDesc1()));
                    videoParcel.setDesc(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoRankDesc2()));
                    indexRankListParcel.getVideoList().add(videoParcel);
                }
            }
            if (indexRankListParcel.getVideoList() != null && !indexRankListParcel.getVideoList().isEmpty()) {
                arrayList.add(indexRankListParcel);
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
        ParsedParcel parsedParcel2 = parsedParcel;
        super.onPostExecute(parsedParcel2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            parsedParcel2.isSuccess();
            List list = (List) parsedParcel2.getObj();
            String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
            hm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (hm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                hm0 hm0Var = hm0.this;
                hm0Var.Wwwwwwwwwwwwwwwwwwwww++;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    if (!hm0Var.Wwwwwwwwwwwwwwwwwww.isEmpty()) {
                        hm0.this.Wwwwwwwwwwwwwwwwwww.addAll(1, list);
                    }
                    hm0.this.Wwwwwwwwwwwwwwwwwww.addAll(list);
                } else {
                    if (!hm0Var.Wwwwwwwwwwwwwwwwwww.isEmpty()) {
                        hm0.this.Wwwwwwwwwwwwwwwwwww.addAll(0, list);
                    }
                    hm0.this.Wwwwwwwwwwwwwwwwwww.addAll(list);
                }
                hm0 hm0Var2 = hm0.this;
                if (hm0Var2.Wwwwwwwwwwwwwwwwwwwww != 2) {
                    return;
                }
                ((zm0) hm0Var2.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hm0Var2.Wwwwwwwwwwwwwwwwwww);
                return;
            }
            hm0 hm0Var3 = hm0.this;
            hm0Var3.Wwwwwwwwwwwwwwwwwwww++;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                hm0Var3.Wwwwwwwwwwwwwwwwwwwwwww = str;
                if (!hm0Var3.Wwwwwwwwwwwwwwwwww.isEmpty()) {
                    hm0.this.Wwwwwwwwwwwwwwwwww.addAll(1, list);
                }
                hm0.this.Wwwwwwwwwwwwwwwwww.addAll(list);
            } else {
                hm0Var3.Wwwwwwwwwwwwwwwwwwwwww = str;
                if (!hm0Var3.Wwwwwwwwwwwwwwwwww.isEmpty()) {
                    hm0.this.Wwwwwwwwwwwwwwwwww.addAll(0, list);
                }
                hm0.this.Wwwwwwwwwwwwwwwwww.addAll(list);
            }
            hm0 hm0Var4 = hm0.this;
            if (hm0Var4.Wwwwwwwwwwwwwwwwwwww != 2) {
                return;
            }
            ((zm0) hm0Var4.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hm0Var4.Wwwwwwwwwwwwwwwwww, hm0Var4.Wwwwwwwwwwwwwwwwwwwwwww, hm0Var4.Wwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
