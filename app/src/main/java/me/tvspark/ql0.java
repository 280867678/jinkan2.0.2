package me.tvspark;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.data.bean.IndexRecParcel;
import me.tvspark.data.bean.IndexRecTypeListParcel;
import me.tvspark.data.bean.ParsedParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.hm0;
import me.tvspark.model.analyzeRule.AnalyzeRule;

/* loaded from: classes4.dex */
public class ql0 extends AsyncTask<Void, Void, ParsedParcel> implements sk0 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public ql0(String str, WebSourceIndexRecData webSourceIndexRecData, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceIndexRecData;
    }

    @Override // android.os.AsyncTask
    public ParsedParcel doInBackground(Void[] voidArr) {
        List<String> list;
        IndexRecTypeListParcel indexRecTypeListParcel;
        List<String> list2;
        StringBuilder sb;
        String sb2;
        List<String> list3;
        IndexRecTypeListParcel indexRecTypeListParcel2;
        List<String> list4;
        StringBuilder sb3;
        String sb4;
        List<String> list5;
        IndexRecTypeListParcel indexRecTypeListParcel3;
        List<String> list6;
        StringBuilder sb5;
        String sb6;
        List<String> list7;
        IndexRecTypeListParcel indexRecTypeListParcel4;
        List<String> list8;
        StringBuilder sb7;
        String sb8;
        ParsedParcel parsedParcel = new ParsedParcel();
        IndexRecParcel indexRecParcel = new IndexRecParcel();
        try {
            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getHtmlRegularIndexRec())) {
                Matcher matcher = Pattern.compile(this.Wwwwwwwwwwwwwwwwwwwwwwww.getHtmlRegularIndexRec()).matcher(this.Wwwwwwwwwwwwwwwwwwwwwww);
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
            parsedParcel.setObj(indexRecParcel);
        }
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            indexRecParcel.setTvTypeList(this.Wwwwwwwwwwwwwwwwwwwwwwww.getTvTypeList());
            indexRecParcel.setTitleTv(this.Wwwwwwwwwwwwwwwwwwwwwwww.getTvTitle());
            List<String> ruleTvTypeContentList = this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleTvTypeContentList();
            int i = 0;
            while (i < ruleTvTypeContentList.size()) {
                AnalyzeRule analyzeRule = new AnalyzeRule();
                List<Object> elements = analyzeRule.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getElements(ruleTvTypeContentList.get(i));
                if (elements == null || elements.size() <= 0) {
                    list7 = ruleTvTypeContentList;
                    indexRecTypeListParcel4 = null;
                } else {
                    indexRecTypeListParcel4 = new IndexRecTypeListParcel();
                    int i2 = 0;
                    while (i2 < elements.size()) {
                        VideoParcel videoParcel = new VideoParcel();
                        Object obj = elements.get(i2);
                        videoParcel.setTitle(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoTitle())));
                        String string = analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLink());
                        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix()) || !this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().contains("{id}")) {
                            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix())) {
                                StringBuilder sb9 = new StringBuilder();
                                list8 = ruleTvTypeContentList;
                                sb9.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix());
                                sb9.append(string);
                                sb8 = sb9.toString();
                            } else {
                                list8 = ruleTvTypeContentList;
                                if (string.startsWith("http") || TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec())) {
                                    videoParcel.setLink(string);
                                } else {
                                    if (string.startsWith("/")) {
                                        sb7 = new StringBuilder();
                                        sb7.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb7.append(string);
                                    } else {
                                        sb7 = new StringBuilder();
                                        sb7.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb7.append("/");
                                        sb7.append(string);
                                    }
                                    sb8 = sb7.toString();
                                }
                            }
                            videoParcel.setLink(sb8);
                        } else {
                            videoParcel.setLink(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().replace("{id}", string));
                            list8 = ruleTvTypeContentList;
                        }
                        videoParcel.setCoverUrl(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCoverPrefix() + analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCover()));
                        videoParcel.setActor(analyzeRule.setContent(obj).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoActor()));
                        indexRecTypeListParcel4.getVideoList().add(videoParcel);
                        i2++;
                        ruleTvTypeContentList = list8;
                    }
                    list7 = ruleTvTypeContentList;
                }
                if (indexRecTypeListParcel4 != null) {
                    indexRecParcel.getTvTypeContentList().add(indexRecTypeListParcel4);
                }
                i++;
                ruleTvTypeContentList = list7;
            }
            indexRecParcel.setMovieTypeList(this.Wwwwwwwwwwwwwwwwwwwwwwww.getMovieTypeList());
            indexRecParcel.setTitleMovie(this.Wwwwwwwwwwwwwwwwwwwwwwww.getMovieTitle());
            List<String> ruleMovieTypeContentList = this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleMovieTypeContentList();
            int i3 = 0;
            while (i3 < ruleMovieTypeContentList.size()) {
                AnalyzeRule analyzeRule2 = new AnalyzeRule();
                List<Object> elements2 = analyzeRule2.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getElements(ruleMovieTypeContentList.get(i3));
                if (elements2 == null || elements2.size() <= 0) {
                    list5 = ruleMovieTypeContentList;
                    indexRecTypeListParcel3 = null;
                } else {
                    indexRecTypeListParcel3 = new IndexRecTypeListParcel();
                    int i4 = 0;
                    while (i4 < elements2.size()) {
                        VideoParcel videoParcel2 = new VideoParcel();
                        Object obj2 = elements2.get(i4);
                        videoParcel2.setTitle(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeRule2.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoTitle())));
                        String string2 = analyzeRule2.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLink());
                        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix()) || !this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().contains("{id}")) {
                            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix())) {
                                StringBuilder sb10 = new StringBuilder();
                                list6 = ruleMovieTypeContentList;
                                sb10.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix());
                                sb10.append(string2);
                                sb6 = sb10.toString();
                            } else {
                                list6 = ruleMovieTypeContentList;
                                if (string2.startsWith("http") || TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec())) {
                                    videoParcel2.setLink(string2);
                                } else {
                                    if (string2.startsWith("/")) {
                                        sb5 = new StringBuilder();
                                        sb5.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb5.append(string2);
                                    } else {
                                        sb5 = new StringBuilder();
                                        sb5.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb5.append("/");
                                        sb5.append(string2);
                                    }
                                    sb6 = sb5.toString();
                                }
                            }
                            videoParcel2.setLink(sb6);
                        } else {
                            videoParcel2.setLink(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().replace("{id}", string2));
                            list6 = ruleMovieTypeContentList;
                        }
                        videoParcel2.setCoverUrl(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCoverPrefix() + analyzeRule2.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCover()));
                        videoParcel2.setActor(analyzeRule2.setContent(obj2).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoActor()));
                        indexRecTypeListParcel3.getVideoList().add(videoParcel2);
                        i4++;
                        ruleMovieTypeContentList = list6;
                    }
                    list5 = ruleMovieTypeContentList;
                }
                if (indexRecTypeListParcel3 != null) {
                    indexRecParcel.getMovieTypeContentList().add(indexRecTypeListParcel3);
                }
                i3++;
                ruleMovieTypeContentList = list5;
            }
            indexRecParcel.setArtTypeList(this.Wwwwwwwwwwwwwwwwwwwwwwww.getArtTypeList());
            indexRecParcel.setTitleArt(this.Wwwwwwwwwwwwwwwwwwwwwwww.getArtTitle());
            List<String> ruleArtTypeContentList = this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleArtTypeContentList();
            int i5 = 0;
            while (i5 < ruleArtTypeContentList.size()) {
                AnalyzeRule analyzeRule3 = new AnalyzeRule();
                List<Object> elements3 = analyzeRule3.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getElements(ruleArtTypeContentList.get(i5));
                if (elements3 == null || elements3.size() <= 0) {
                    list3 = ruleArtTypeContentList;
                    indexRecTypeListParcel2 = null;
                } else {
                    indexRecTypeListParcel2 = new IndexRecTypeListParcel();
                    int i6 = 0;
                    while (i6 < elements3.size()) {
                        VideoParcel videoParcel3 = new VideoParcel();
                        Object obj3 = elements3.get(i6);
                        videoParcel3.setTitle(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeRule3.setContent(obj3).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoTitle())));
                        String string3 = analyzeRule3.setContent(obj3).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLink());
                        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix()) || !this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().contains("{id}")) {
                            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix())) {
                                StringBuilder sb11 = new StringBuilder();
                                list4 = ruleArtTypeContentList;
                                sb11.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix());
                                sb11.append(string3);
                                sb4 = sb11.toString();
                            } else {
                                list4 = ruleArtTypeContentList;
                                if (string3.startsWith("http") || TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec())) {
                                    videoParcel3.setLink(string3);
                                } else {
                                    if (string3.startsWith("/")) {
                                        sb3 = new StringBuilder();
                                        sb3.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb3.append(string3);
                                    } else {
                                        sb3 = new StringBuilder();
                                        sb3.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb3.append("/");
                                        sb3.append(string3);
                                    }
                                    sb4 = sb3.toString();
                                }
                            }
                            videoParcel3.setLink(sb4);
                        } else {
                            videoParcel3.setLink(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().replace("{id}", string3));
                            list4 = ruleArtTypeContentList;
                        }
                        videoParcel3.setCoverUrl(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCoverPrefix() + analyzeRule3.setContent(obj3).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCover()));
                        videoParcel3.setActor(analyzeRule3.setContent(obj3).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoActor()));
                        indexRecTypeListParcel2.getVideoList().add(videoParcel3);
                        i6++;
                        ruleArtTypeContentList = list4;
                    }
                    list3 = ruleArtTypeContentList;
                }
                if (indexRecTypeListParcel2 != null) {
                    indexRecParcel.getArtTypeContentList().add(indexRecTypeListParcel2);
                }
                i5++;
                ruleArtTypeContentList = list3;
            }
            indexRecParcel.setAnimTypeList(this.Wwwwwwwwwwwwwwwwwwwwwwww.getAnimTypeList());
            indexRecParcel.setTitleAnim(this.Wwwwwwwwwwwwwwwwwwwwwwww.getAnimTitle());
            List<String> ruleAnimTypeContentList = this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleAnimTypeContentList();
            int i7 = 0;
            while (i7 < ruleAnimTypeContentList.size()) {
                AnalyzeRule analyzeRule4 = new AnalyzeRule();
                List<Object> elements4 = analyzeRule4.setContent(this.Wwwwwwwwwwwwwwwwwwwwww).getElements(ruleAnimTypeContentList.get(i7));
                if (elements4 == null || elements4.size() <= 0) {
                    list = ruleAnimTypeContentList;
                    indexRecTypeListParcel = null;
                } else {
                    indexRecTypeListParcel = new IndexRecTypeListParcel();
                    int i8 = 0;
                    while (i8 < elements4.size()) {
                        VideoParcel videoParcel4 = new VideoParcel();
                        Object obj4 = elements4.get(i8);
                        videoParcel4.setTitle(un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeRule4.setContent(obj4).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoTitle())));
                        String string4 = analyzeRule4.setContent(obj4).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLink());
                        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix()) || !this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().contains("{id}")) {
                            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix())) {
                                StringBuilder sb12 = new StringBuilder();
                                list2 = ruleAnimTypeContentList;
                                sb12.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix());
                                sb12.append(string4);
                                sb2 = sb12.toString();
                            } else {
                                list2 = ruleAnimTypeContentList;
                                if (string4.startsWith("http") || TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec())) {
                                    videoParcel4.setLink(string4);
                                } else {
                                    if (string4.startsWith("/")) {
                                        sb = new StringBuilder();
                                        sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb.append(string4);
                                    } else {
                                        sb = new StringBuilder();
                                        sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBaseUrlRec());
                                        sb.append("/");
                                        sb.append(string4);
                                    }
                                    sb2 = sb.toString();
                                }
                            }
                            videoParcel4.setLink(sb2);
                        } else {
                            videoParcel4.setLink(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoLinkPrefix().replace("{id}", string4));
                            list2 = ruleAnimTypeContentList;
                        }
                        videoParcel4.setCoverUrl(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCoverPrefix() + analyzeRule4.setContent(obj4).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoCover()));
                        videoParcel4.setActor(analyzeRule4.setContent(obj4).getString(this.Wwwwwwwwwwwwwwwwwwwwwwww.getRuleVideoActor()));
                        indexRecTypeListParcel.getVideoList().add(videoParcel4);
                        i8++;
                        ruleAnimTypeContentList = list2;
                    }
                    list = ruleAnimTypeContentList;
                }
                if (indexRecTypeListParcel != null) {
                    indexRecParcel.getAnimTypeContentList().add(indexRecTypeListParcel);
                }
                i7++;
                ruleAnimTypeContentList = list;
            }
            parsedParcel.setSuccess(true);
            parsedParcel.setObj(indexRecParcel);
            return parsedParcel;
        }
        parsedParcel.setSuccess(false);
        parsedParcel.setObj(indexRecParcel);
        return parsedParcel;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ParsedParcel parsedParcel) {
        ParsedParcel parsedParcel2 = parsedParcel;
        super.onPostExecute(parsedParcel2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            boolean isSuccess = parsedParcel2.isSuccess();
            IndexRecParcel indexRecParcel = (IndexRecParcel) parsedParcel2.getObj();
            String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
            hm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (hm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            hm0 hm0Var = hm0.this;
            if (z) {
                ((zm0) hm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isSuccess, indexRecParcel, str);
            } else {
                ((zm0) hm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isSuccess, indexRecParcel, str);
            }
        }
    }
}
