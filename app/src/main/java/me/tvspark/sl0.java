package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.gm0;
import me.tvspark.model.analyzeRule.AnalyzeRule;

/* loaded from: classes4.dex */
public class sl0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public sl0(String str, WebSourceIndexRecData webSourceIndexRecData, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = webSourceIndexRecData;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        WebSourceIndexRecData webSourceIndexRecData;
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        ParsedParcel parsedParcel = new ParsedParcel();
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww) && (webSourceIndexRecData = this.Wwwwwwwwwwwwwwwwwwwww) != null) {
            try {
                if (!TextUtils.isEmpty(webSourceIndexRecData.getHtmlRegularMore())) {
                    Matcher matcher = Pattern.compile(this.Wwwwwwwwwwwwwwwwwwwww.getHtmlRegularMore()).matcher(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    if (matcher.find()) {
                        try {
                            this.Wwwwwwwwwwwwwwwwwwwwwww = matcher.group(1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww = "";
                } else {
                    this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                }
                AnalyzeRule analyzeRule = new AnalyzeRule();
                List<Object> elements = analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwwww).getElements(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoListMore());
                if (elements != null && elements.size() > 0) {
                    for (int i = 0; i < elements.size(); i++) {
                        VideoParcel videoParcel = new VideoParcel();
                        Object obj = elements.get(i);
                        videoParcel.setTitle(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoTitleMore())));
                        String string = analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkMore());
                        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefixMore()) || !this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefixMore().contains("{id}")) {
                            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefixMore())) {
                                sb = new StringBuilder();
                                sb.append(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefixMore());
                                sb.append(string);
                            } else if (!string.startsWith("http") && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww.getBaseUrlRec())) {
                                if (string.startsWith("/")) {
                                    sb = new StringBuilder();
                                    sb.append(this.Wwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                    sb.append(string);
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(this.Wwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                    sb.append("/");
                                    sb.append(string);
                                }
                            }
                            string = sb.toString();
                        } else {
                            string = this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefixMore().replace("{id}", string);
                        }
                        videoParcel.setLink(string);
                        videoParcel.setCoverUrl(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoCoverPrefixMore() + analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoCoverMore()));
                        videoParcel.setActor(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwww.getRuleVideoActorMore()));
                        arrayList.add(videoParcel);
                    }
                }
                parsedParcel.setSuccess(true);
                parsedParcel.setObj(arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
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
            String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
            gm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (gm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ((an0) gm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parsedParcel2.isSuccess(), (List) parsedParcel2.getObj(), str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
