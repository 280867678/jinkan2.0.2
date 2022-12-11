package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.EngineResultParcel;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.lm0;
import me.tvspark.model.analyzeRule.AnalyzeRule;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public class ol0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public String Wwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwww = "";
    public WebSourceIndexData Wwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public ResponseBody Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public ol0(ResponseBody responseBody, WebSourceIndexData webSourceIndexData, String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = responseBody;
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = webSourceIndexData;
        this.Wwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        ArrayList arrayList = new ArrayList();
        ParsedParcel parsedParcel = new ParsedParcel();
        WebSourceIndexData webSourceIndexData = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (webSourceIndexData == null) {
            parsedParcel.setSuccess(false);
        } else {
            try {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    if (!TextUtils.isEmpty(webSourceIndexData.getHtmlCharset())) {
                        this.Wwwwwwwwwwwwwwwwwwwww = new String(this.Wwwwwwwwwwwwwwwwwwwwwwww.bytes(), this.Wwwwwwwwwwwwwwwwwwwwww.getHtmlCharset());
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.string();
                    }
                }
                AnalyzeRule analyzeRule = new AnalyzeRule();
                List<Object> elements = analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwww).getElements(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchList());
                if (elements != null && elements.size() > 0) {
                    for (int i = 0; i < elements.size(); i++) {
                        try {
                            EngineResultParcel engineResultParcel = new EngineResultParcel();
                            Object obj = elements.get(i);
                            engineResultParcel.setTitle(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchTitle()));
                            engineResultParcel.setWebSourceData(this.Wwwwwwwwwwwwwwwwwwwwww);
                            if (!TextUtils.isEmpty(engineResultParcel.getTitle())) {
                                engineResultParcel.setNumber(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwww.getRuleSearchNumber()));
                                un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(engineResultParcel.getTitle(), new nl0(this, engineResultParcel, analyzeRule, obj, arrayList));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (arrayList.isEmpty()) {
                parsedParcel.setSuccess(false);
                if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwww)) {
                    EngineResultParcel engineResultParcel2 = new EngineResultParcel();
                    engineResultParcel2.setShowWebViewSearch(true);
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[ ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSourceSiteName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" ]");
                    engineResultParcel2.setTitle(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    engineResultParcel2.setWebSourceData(this.Wwwwwwwwwwwwwwwwwwwwww);
                    String str = this.Wwwwwwwwwwwwwwwwwwww;
                    if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww.getReqCharset())) {
                        try {
                            str = new String(this.Wwwwwwwwwwwwwwwwwwww.getBytes("UTF-8"), this.Wwwwwwwwwwwwwwwwwwwwww.getReqCharset());
                        } catch (Exception unused) {
                        }
                    } else {
                        str = this.Wwwwwwwwwwwwwwwwwwww;
                    }
                    engineResultParcel2.setLink(this.Wwwwwwwwwwwwwwwwwwwwww.getWebSearchUrl().replace("{search}", str));
                    engineResultParcel2.setParseSuccess(false);
                    arrayList.add(engineResultParcel2);
                }
            } else {
                parsedParcel.setSuccess(true);
            }
        }
        parsedParcel.setObj(arrayList);
        return parsedParcel;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ParsedParcel parsedParcel) {
        ParsedParcel parsedParcel2 = parsedParcel;
        super.onPostExecute(parsedParcel2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            parsedParcel2.isSuccess();
            List<EngineResultParcel> list = (List) parsedParcel2.getObj();
            lm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (lm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z = true;
            lm0.this.Wwwwwwwwwwwwwwwww.add(1);
            EngineResultParcel engineResultParcel = null;
            if (list != null && !list.isEmpty()) {
                engineResultParcel = list.get(0);
            }
            lm0 lm0Var = lm0.this;
            ((in0) lm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(engineResultParcel, list, lm0Var.Wwwwwwwwwwwwwwwww.size() + 1, lm0.this.Wwwwwwwwwwwwwwww);
            int size = lm0.this.Wwwwwwwwwwwwwwwww.size();
            lm0 lm0Var2 = lm0.this;
            int i = lm0Var2.Wwwwwwwwwwwwwwww;
            if (size != i) {
                return;
            }
            lm0Var2.Wwwwwwwwwwwwww += i;
            lm0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            lm0 lm0Var3 = lm0.this;
            in0 in0Var = (in0) lm0Var3.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (lm0Var3.Wwwwwwwwwwwwww < lm0Var3.Wwwwwwwwwwwww) {
                z = false;
            }
            in0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, z);
        }
    }
}
