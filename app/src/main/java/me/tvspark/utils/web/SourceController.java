package me.tvspark.utils.web;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.util.List;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.jo0;
import me.tvspark.r40;
import me.tvspark.utils.SKUtils;
import me.tvspark.utils.web.utils.ReturnData;
import me.tvspark.yn0;
import org.litepal.crud.callback.SaveCallback;

/* loaded from: classes4.dex */
public class SourceController {
    public ReturnData getIndexSource() {
        ReturnData returnData = new ReturnData();
        List<WebSourceIndexData> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) ? returnData.setErrorMsg("获取为空") : returnData.setData(JSON.toJSONString(Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public ReturnData getLiveSource() {
        ReturnData returnData = new ReturnData();
        List<WebSourceLiveData> Wwwwwwwwwwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwww();
        return (Wwwwwwwwwwwwwwwwwwwwwwww == null || Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) ? returnData.setErrorMsg("获取为空") : returnData.setData(JSON.toJSONString(Wwwwwwwwwwwwwwwwwwwwwwww));
    }

    public ReturnData getSeasonSource() {
        ReturnData returnData = new ReturnData();
        List<WebSourceSeasonData> Wwwwwwwwwwwwwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        return (Wwwwwwwwwwwwwwwwwwwwwwwwwww == null || Wwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) ? returnData.setErrorMsg("获取为空") : returnData.setData(JSON.toJSONString(Wwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public ReturnData saveIndexSource(String str) {
        ReturnData returnData = new ReturnData();
        if (!TextUtils.isEmpty(str)) {
            List<WebSourceIndexData> parseArray = JSON.parseArray(str, WebSourceIndexData.class);
            jo0 jo0Var = new jo0();
            jo0Var.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            jo0Var.Wwwwwwwwwwwwwwwwwwwwwww = parseArray;
            jo0Var.execute(new Void[0]);
            return returnData.setData("");
        }
        return returnData;
    }

    public ReturnData saveLiveSource(String str) {
        ReturnData returnData = new ReturnData();
        if (!TextUtils.isEmpty(str)) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JSON.parseArray(str, WebSourceLiveData.class), (SaveCallback) null);
            return returnData.setData("");
        }
        return returnData;
    }

    public ReturnData saveSeasonSource(String str) {
        ReturnData returnData = new ReturnData();
        if (!TextUtils.isEmpty(str)) {
            List<WebSourceSeasonData> parseArray = JSON.parseArray(str, WebSourceSeasonData.class);
            jo0 jo0Var = new jo0();
            jo0Var.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            jo0Var.Wwwwwwwwwwwwwwwwwwwwww = parseArray;
            jo0Var.execute(new Void[0]);
            return returnData.setData("");
        }
        return returnData;
    }

    public ReturnData str2Decrypt(String str) {
        String str2;
        ReturnData returnData = new ReturnData();
        if (TextUtils.isEmpty(str)) {
            str2 = "数据为空";
        } else {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwww(str));
            if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return returnData.setData(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            str2 = "解密失败";
        }
        return returnData.setErrorMsg(str2);
    }

    public ReturnData str2Encrypt(String str) {
        String str2;
        ReturnData returnData = new ReturnData();
        if (TextUtils.isEmpty(str)) {
            str2 = "数据为空";
        } else {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return returnData.setData(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            str2 = "加密失败";
        }
        return returnData.setErrorMsg(str2);
    }
}
