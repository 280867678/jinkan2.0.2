package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.data.bean.IndexRecDetailParcel;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.gu0;
import me.tvspark.model.analyzeRule.AnalyzeRule;

/* loaded from: classes4.dex */
public class rl0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public rl0(String str, WebSourceIndexRecData webSourceIndexRecData, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceIndexRecData;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        ParsedParcel parsedParcel = new ParsedParcel();
        IndexRecDetailParcel indexRecDetailParcel = new IndexRecDetailParcel();
        try {
            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getHtmlRegularDetail())) {
                Matcher matcher = Pattern.compile(this.Wwwwwwwwwwwwwwwwwwwwwwww.getHtmlRegularDetail()).matcher(this.Wwwwwwwwwwwwwwwwwwwwwww);
                if (matcher.find()) {
                    try {
                        this.Wwwwwwwwwwwwwwwwwwwwww = matcher.group(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwww = "";
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            parsedParcel.setSuccess(false);
            parsedParcel.setObj(indexRecDetailParcel);
        }
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            AnalyzeRule analyzeRule = new AnalyzeRule();
            indexRecDetailParcel.setYear(analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDetailYear()));
            indexRecDetailParcel.setStyle(analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDetailStyle()));
            indexRecDetailParcel.setZone(analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDetailZone()));
            indexRecDetailParcel.setStarring(analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDetailStarring()));
            indexRecDetailParcel.setDesc(analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleDetailDesc()));
            parsedParcel.setSuccess(true);
            parsedParcel.setObj(indexRecDetailParcel);
            return parsedParcel;
        }
        parsedParcel.setSuccess(false);
        parsedParcel.setObj(indexRecDetailParcel);
        return parsedParcel;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ParsedParcel parsedParcel) {
        String sb;
        TextView textView;
        TextView textView2;
        String year;
        ParsedParcel parsedParcel2 = parsedParcel;
        super.onPostExecute(parsedParcel2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            parsedParcel2.isSuccess();
            IndexRecDetailParcel indexRecDetailParcel = (IndexRecDetailParcel) parsedParcel2.getObj();
            gu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (gu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.pBar.setVisibility(8);
            gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.tvDesc.setVisibility(0);
            for (int i = 0; i < gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.length; i++) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                if (!TextUtils.isEmpty(indexRecDetailParcel.getStarring())) {
                                    textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                                    year = indexRecDetailParcel.getStarring();
                                    textView2.setText(year);
                                } else {
                                    textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                                    year = "N/A";
                                    textView2.setText(year);
                                }
                            }
                        } else if (!TextUtils.isEmpty(indexRecDetailParcel.getZone())) {
                            textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                            year = indexRecDetailParcel.getZone();
                            textView2.setText(year);
                        } else {
                            textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                            year = "N/A";
                            textView2.setText(year);
                        }
                    } else if (!TextUtils.isEmpty(indexRecDetailParcel.getStyle())) {
                        textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                        year = indexRecDetailParcel.getStyle();
                        textView2.setText(year);
                    } else {
                        textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                        year = "N/A";
                        textView2.setText(year);
                    }
                } else if (!TextUtils.isEmpty(indexRecDetailParcel.getYear())) {
                    textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                    year = indexRecDetailParcel.getYear();
                    textView2.setText(year);
                } else {
                    textView2 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww[i];
                    year = "N/A";
                    textView2.setText(year);
                }
            }
            if (TextUtils.isEmpty(indexRecDetailParcel.getDesc())) {
                textView = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.tvDesc;
                sb = "简介：暂无";
            } else {
                TextView textView3 = gu0.this.Wwwwwwwwwwwwwwwwwwwwwwww.tvDesc;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("简介：");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(indexRecDetailParcel.getDesc());
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                textView = textView3;
            }
            textView.setText(sb);
        }
    }
}
