package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.tvspark.data.bean.ChanelParcel;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.bean.VideoDetailParcel;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.model.analyzeRule.AnalyzeRule;
import org.jsoup.nodes.Element;

/* loaded from: classes4.dex */
public class vl0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public String Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public WebSourceSeasonData Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, VideoDetailParcel videoDetailParcel, String str);
    }

    public vl0(String str, WebSourceSeasonData webSourceSeasonData, String str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceSeasonData;
    }

    public final List<EpisodeParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj, String str2) throws Exception {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        AnalyzeRule analyzeRule = new AnalyzeRule();
        List<Object> elements = analyzeRule.setContent(obj).getElements(str2);
        if (elements != null && elements.size() > 0) {
            for (Object obj2 : elements) {
                EpisodeParcel episodeParcel = new EpisodeParcel();
                String string = analyzeRule.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeLink());
                if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeLinkPrefix())) {
                    String str3 = "<js>";
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeLinkPrefix().equals(str3)) {
                        sb = new StringBuilder();
                        sb.append(this.Wwwwwwwwwwwwwwwwwwwww);
                    } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeLinkPrefix().contains("{id}")) {
                        string = this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeLinkPrefix().replace("{id}", string);
                    } else {
                        sb = new StringBuilder();
                        str3 = this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeLinkPrefix();
                    }
                    string = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str3, string);
                }
                if (!string.startsWith("http") && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                    string = string.startsWith("/") ? co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl()) + string : co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl()) + "/" + string;
                }
                episodeParcel.setLink(string);
                String string2 = analyzeRule.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeName());
                String str4 = "";
                if (!TextUtils.isEmpty(string2)) {
                    if (!TextUtils.isEmpty(str)) {
                        string2 = string2.replace(str, str4);
                    }
                    str4 = string2.toLowerCase().replace("会员版", str4).replace("会员", str4).replace("未删减版", str4).replace("未删减", str4).replace("hdtv版", str4).replace("hdtv", str4).replace("dvd版", str4).replace("dvd", str4).replace("vip", str4).replace("更新", str4).trim().toUpperCase();
                }
                episodeParcel.setCount(str4);
                arrayList.add(episodeParcel);
            }
        }
        if (!arrayList.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwwwww.isEpisoeListReverse()) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        VideoDetailParcel videoDetailParcel = new VideoDetailParcel();
        ParsedParcel parsedParcel = new ParsedParcel();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            parsedParcel.setSuccess(false);
            parsedParcel.setObj(videoDetailParcel);
        }
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            AnalyzeRule analyzeRule = new AnalyzeRule();
            videoDetailParcel.setCoverUrl(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleSeasonCoverPrefix(), analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleSeasonCover())));
            try {
                if (!TextUtils.isEmpty(videoDetailParcel.getCoverUrl()) && !videoDetailParcel.getCoverUrl().startsWith("http") && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                    videoDetailParcel.setCoverUrl(videoDetailParcel.getCoverUrl().startsWith("/") ? this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl() + videoDetailParcel.getCoverUrl() : this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl() + "/" + videoDetailParcel.getCoverUrl());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            videoDetailParcel.setTitle(analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleSeasonTitle()));
            List<Object> elements = analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwww).getElements(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleSeasonInfoList());
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = elements.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(((Element) it.next()).text().trim());
                } catch (Exception unused) {
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add("状态：N/A");
                arrayList.add("主演：N/A");
                arrayList.add("类型：N/A");
                arrayList.add("导演：N/A");
            }
            videoDetailParcel.setTvsList(arrayList);
            videoDetailParcel.setDesc(analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleSeasonDesc()));
            List<Object> elements2 = analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwww).getElements(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleChannelList());
            ArrayList arrayList2 = new ArrayList();
            if (elements2 != null && elements2.size() > 0) {
                int i = 0;
                while (i < elements2.size()) {
                    ChanelParcel chanelParcel = new ChanelParcel();
                    StringBuilder sb = new StringBuilder();
                    sb.append("地址");
                    int i2 = i + 1;
                    sb.append(i2);
                    chanelParcel.setChanel(sb.toString());
                    chanelParcel.setEpisodeList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoDetailParcel.getTitle(), elements2.get(i), this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeList()));
                    if (chanelParcel.getEpisodeList() != null && !chanelParcel.getEpisodeList().isEmpty()) {
                        arrayList2.add(chanelParcel);
                    }
                    i = i2;
                }
            } else if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeList())) {
                ChanelParcel chanelParcel2 = new ChanelParcel();
                chanelParcel2.setChanel("选集播放");
                chanelParcel2.setEpisodeList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoDetailParcel.getTitle(), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleEpisodeList()));
                if (chanelParcel2.getEpisodeList() != null && !chanelParcel2.getEpisodeList().isEmpty()) {
                    arrayList2.add(chanelParcel2);
                }
            }
            videoDetailParcel.setChanelList(arrayList2);
            List<Object> elements3 = analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwww).getElements(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDownloadList());
            ArrayList arrayList3 = new ArrayList();
            if (elements3 != null && elements3.size() > 0) {
                for (Object obj : elements3) {
                    GenreParcel genreParcel = new GenreParcel();
                    genreParcel.setName(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDownloadName()));
                    genreParcel.setLink(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDownloadLinkPrefix() + analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDownloadLink()));
                    arrayList3.add(genreParcel);
                }
            }
            videoDetailParcel.setDownloadList(arrayList3);
            parsedParcel.setSuccess(true);
            parsedParcel.setObj(videoDetailParcel);
            return parsedParcel;
        }
        parsedParcel.setSuccess(false);
        parsedParcel.setObj(videoDetailParcel);
        return parsedParcel;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ParsedParcel parsedParcel) {
        ParsedParcel parsedParcel2 = parsedParcel;
        super.onPostExecute(parsedParcel2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parsedParcel2.isSuccess(), (VideoDetailParcel) parsedParcel2.getObj(), this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
