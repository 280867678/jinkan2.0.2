package me.tvspark;

import android.content.ContentValues;
import android.content.Context;
import androidx.core.app.NotificationCompatJellybean;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.sql.CodeForSiteData;
import me.tvspark.data.sql.CoverData;
import me.tvspark.data.sql.CustomConfUrlData;
import me.tvspark.data.sql.DownPlayHistoryData;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.data.sql.SPData;
import me.tvspark.data.sql.VideoCollectData;
import me.tvspark.data.sql.VideoHistoryData;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.data.sql.WebHistoryData;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.data.sql.WebSourceTitaData;
import org.litepal.LitePal;
import org.litepal.crud.callback.CountCallback;
import org.litepal.crud.callback.FindCallback;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;

/* loaded from: classes4.dex */
public class yn0 implements sk0 {

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ SaveCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ HomeMarkData Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // org.litepal.crud.callback.CountCallback
            public void onFinish(int i) {
                Wwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSerialNumber(i);
                Wwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.saveAsync().listen(Wwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(HomeMarkData homeMarkData, SaveCallback saveCallback) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = homeMarkData;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = saveCallback;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i <= 0) {
                LitePal.countAsync(HomeMarkData.class).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            }
            SaveCallback saveCallback = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (saveCallback == null) {
                return;
            }
            saveCallback.onFinish(false);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i <= 0) {
                new DownPlayHistoryData(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, System.currentTimeMillis()).saveAsync().listen(null);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotificationCompatJellybean.KEY_TITLE, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            LitePal.updateAllAsync(DownPlayHistoryData.class, contentValues, "dirName = ?", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).listen(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements UpdateOrDeleteCallback {
        public final /* synthetic */ SaveCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(List list, SaveCallback saveCallback) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = saveCallback;
        }

        @Override // org.litepal.crud.callback.UpdateOrDeleteCallback
        public void onFinish(int i) {
            for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                ((WebSourceLiveData) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2)).clearSavedState();
            }
            LitePal.saveAllAsync(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).listen(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements UpdateOrDeleteCallback {
        public final /* synthetic */ SaveCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceTitaData webSourceTitaData, SaveCallback saveCallback) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = saveCallback;
        }

        @Override // org.litepal.crud.callback.UpdateOrDeleteCallback
        public void onFinish(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearSavedState();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.saveAsync().listen(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
        public final /* synthetic */ SaveCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SaveCallback saveCallback) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = saveCallback;
        }

        @Override // org.litepal.crud.callback.SaveCallback
        public void onFinish(boolean z) {
            SaveCallback saveCallback;
            boolean z2;
            if (z) {
                saveCallback = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z2 = true;
            } else {
                saveCallback = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z2 = false;
            }
            saveCallback.onFinish(z2);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements UpdateOrDeleteCallback {
        public final /* synthetic */ SaveCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexRecData webSourceIndexRecData, SaveCallback saveCallback) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSourceIndexRecData;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = saveCallback;
        }

        @Override // org.litepal.crud.callback.UpdateOrDeleteCallback
        public void onFinish(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearSavedState();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.saveAsync().listen(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("searchHistory", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                LitePal.updateAllAsync(SPData.class, contentValues, new String[0]).listen(null);
                return;
            }
            SPData sPData = new SPData();
            sPData.setSearchHistory(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            sPData.saveAsync().listen(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("blockWordJson", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                LitePal.updateAllAsync(SPData.class, contentValues, new String[0]).listen(null);
                return;
            }
            SPData sPData = new SPData();
            sPData.setBlockWordJson(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            sPData.saveAsync().listen(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements UpdateOrDeleteCallback {
        public final /* synthetic */ SaveCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List list, SaveCallback saveCallback) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = saveCallback;
        }

        @Override // org.litepal.crud.callback.UpdateOrDeleteCallback
        public void onFinish(int i) {
            List list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (list == null || list.isEmpty()) {
                return;
            }
            LitePal.markAsDeleted(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            LitePal.saveAllAsync(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).listen(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public static List<WebSourceLiveData> Wwwwwwwwwwwwwwwwwwwwwwww() {
        return LitePal.findAll(WebSourceLiveData.class, new long[0]);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.countAsync(SPData.class).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    public static WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwwww() {
        return (WebSourceIndexRecData) LitePal.findFirst(WebSourceIndexRecData.class);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.countAsync(SPData.class).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    public static CustomConfUrlData Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (CustomConfUrlData) LitePal.findFirst(CustomConfUrlData.class);
    }

    public static WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return (WebSourceTitaData) LitePal.where("baseUrl = ?", str).findFirst(WebSourceTitaData.class);
    }

    public static List<WebSourceSeasonData> Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return LitePal.order("serialNumber asc").find(WebSourceSeasonData.class);
    }

    public static WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return (WebSourceTitaData) LitePal.where("baseUrl = ?", str).findFirst(WebSourceTitaData.class);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<WebSourceLiveData> findMultiCallback) {
        LitePal.findAllAsync(WebSourceLiveData.class, new long[0]).listen(findMultiCallback);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        CoverData coverData = (CoverData) LitePal.where("dirName = ?", str).findFirst(CoverData.class);
        return coverData == null ? "" : coverData.getCoverUrl();
    }

    public static List<WebSourceIndexData> Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return LitePal.order("serialNumber asc").find(WebSourceIndexData.class);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<HomeMarkData> findMultiCallback) {
        LitePal.order("serialNumber asc").findAsync(HomeMarkData.class).listen(findMultiCallback);
    }

    public static List<CodeForSiteData> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return LitePal.findAll(CodeForSiteData.class, new long[0]);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.deleteAll(WebSourceTitaData.class, "baseUrl = ?", str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<WebSourceTitaData> findMultiCallback) {
        LitePal.findAllAsync(WebSourceTitaData.class, new long[0]).listen(findMultiCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LitePal.deleteAllAsync(WebSourceTitaData.class, new String[0]).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.deleteAllAsync(WebHistoryData.class, "siteUrl = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, FindCallback<WebSourceSeasonData> findCallback) {
        LitePal.where("webSourceBaseUrl = ?", str).findFirstAsync(WebSourceSeasonData.class).listen(findCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<WebSourceIndexData> findMultiCallback) {
        LitePal.order("serialNumber asc").findAsync(WebSourceIndexData.class).listen(findMultiCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LitePal.deleteAll(CustomConfUrlData.class, new String[0]);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.deleteAllAsync(VideoHistoryData.class, "detailUrl = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, CountCallback countCallback) {
        LitePal.where("url = ?", str).countAsync(HomeMarkData.class).listen(countCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, FindCallback<WebSourceTitaData> findCallback) {
        LitePal.where("baseUrl = ?", str).findFirstAsync(WebSourceTitaData.class).listen(findCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<WebHistoryData> findMultiCallback) {
        LitePal.order("timestamp desc").findAsync(WebHistoryData.class).listen(findMultiCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LitePal.deleteAllAsync(WebHistoryData.class, new String[0]).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.deleteAllAsync(DownPlayHistoryData.class, "dirName = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, CountCallback countCallback) {
        LitePal.where("url = ?", str).countAsync(VideoCollectData.class).listen(countCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, FindCallback<VideoPlayPosData> findCallback) {
        LitePal.where("episodeUrl = ?", str).findFirstAsync(VideoPlayPosData.class).listen(findCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<VideoHistoryData> findMultiCallback) {
        LitePal.order("timestamp desc").findAsync(VideoHistoryData.class).listen(findMultiCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LitePal.deleteAllAsync(VideoHistoryData.class, new String[0]).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, FindMultiCallback<WebSourceIndexData> findMultiCallback) {
        (i == 999 ? LitePal.order("serialNumber asc") : LitePal.order("serialNumber asc").limit(i).offset(i2)).findAsync(WebSourceIndexData.class).listen(findMultiCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.deleteAllAsync(CoverData.class, "dirName = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        LitePal.where("dirName = ?", str).countAsync(DownPlayHistoryData.class).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("siteName", str2);
        contentValues.put("timestamp", Long.valueOf(j));
        LitePal.updateAllAsync(WebHistoryData.class, contentValues, "siteUrl = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, CountCallback countCallback) {
        LitePal.where("episodeUrl = ?", str).countAsync(VideoPlayPosData.class).listen(countCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, FindCallback<VideoHistoryData> findCallback) {
        LitePal.where("detailUrl = ?", str).findFirstAsync(VideoHistoryData.class).listen(findCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<WebSourceLiveData> list, SaveCallback saveCallback) {
        if (list == null || list.isEmpty()) {
            return;
        }
        LitePal.deleteAllAsync(WebSourceLiveData.class, new String[0]).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(list, saveCallback));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceTitaData webSourceTitaData, SaveCallback saveCallback) {
        if (webSourceTitaData == null) {
            saveCallback.onFinish(false);
        } else {
            webSourceTitaData.saveOrUpdateAsync("baseUrl = ?", webSourceTitaData.getBaseUrl()).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(saveCallback));
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CountCallback countCallback) {
        LitePal.countAsync(WebSourceIndexData.class).listen(countCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<VideoCollectData> findMultiCallback) {
        LitePal.order("timestamp desc").findAsync(VideoCollectData.class).listen(findMultiCallback);
    }

    public static WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexRecData webSourceIndexRecData, SaveCallback saveCallback) {
        LitePal.deleteAllAsync(WebSourceIndexRecData.class, new String[0]).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexRecData, saveCallback));
        return webSourceIndexRecData;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LitePal.deleteAllAsync(VideoCollectData.class, new String[0]).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, FindMultiCallback<WebSourceTitaData> findMultiCallback) {
        (i == 999 ? LitePal.order("serialNumber asc") : LitePal.order("serialNumber asc").limit(i).offset(i2)).findAsync(WebSourceTitaData.class).listen(findMultiCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        ArrayList arrayList = new ArrayList();
        HomeMarkData homeMarkData = new HomeMarkData();
        homeMarkData.setUrl("https://m.v.qq.com");
        homeMarkData.setIconUrl("file:///android_asset/nav_site_qq.png");
        homeMarkData.setTitle("腾讯视频");
        homeMarkData.setSerialNumber(0);
        arrayList.add(homeMarkData);
        HomeMarkData homeMarkData2 = new HomeMarkData();
        homeMarkData2.setUrl("https://www.youku.com");
        homeMarkData2.setIconUrl("file:///android_asset/nav_site_youku.png");
        homeMarkData2.setTitle("优酷");
        homeMarkData2.setSerialNumber(1);
        arrayList.add(homeMarkData2);
        HomeMarkData homeMarkData3 = new HomeMarkData();
        homeMarkData3.setUrl("https://m.iqiyi.com");
        homeMarkData3.setIconUrl("file:///android_asset/nav_site_iqiyi.png");
        homeMarkData3.setTitle("爱奇艺");
        homeMarkData3.setSerialNumber(2);
        arrayList.add(homeMarkData3);
        LitePal.saveAll(arrayList);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LitePal.deleteAllAsync(VideoCollectData.class, "url = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, String str3, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("channel", Integer.valueOf(i));
        contentValues.put("lastEpisode", str2);
        contentValues.put("timestamp", Long.valueOf(j));
        contentValues.put("episodeUrl", str3);
        LitePal.updateAllAsync(VideoHistoryData.class, contentValues, "detailUrl = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        if (LitePal.where("dirName = ?", str).count(CoverData.class) <= 0) {
            new CoverData(str, str2).saveAsync().listen(null);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("coverUrl", str2);
        LitePal.updateAllAsync(CoverData.class, contentValues, "dirName = ? ", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("quitTime", Long.valueOf(j));
        contentValues.put("videoSrc", str2);
        LitePal.updateAllAsync(VideoPlayPosData.class, contentValues, "episodeUrl = ?", str).listen(null);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, SaveCallback saveCallback) {
        HomeMarkData homeMarkData = new HomeMarkData();
        homeMarkData.setTitle(str);
        homeMarkData.setUrl(str2);
        homeMarkData.setIconColor(nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        homeMarkData.setIconTxt(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", str));
        homeMarkData.setIconUrl("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, new Wwwwwwwwwwwwwwwwwwwwwwwwww(homeMarkData, saveCallback));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, HomeMarkData homeMarkData, UpdateOrDeleteCallback updateOrDeleteCallback) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", homeMarkData.getUrl());
        contentValues.put(NotificationCompatJellybean.KEY_TITLE, homeMarkData.getTitle());
        contentValues.put("iconUrl", homeMarkData.getIconUrl());
        contentValues.put("iconColor", homeMarkData.getIconColor());
        contentValues.put("iconTxt", homeMarkData.getIconTxt());
        LitePal.updateAllAsync(HomeMarkData.class, contentValues, "url = ? ", str).listen(updateOrDeleteCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, CountCallback countCallback) {
        LitePal.where("detailUrl = ?", str).countAsync(VideoHistoryData.class).listen(countCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, FindCallback<DownPlayHistoryData> findCallback) {
        LitePal.where("dirName = ?", str).findFirstAsync(DownPlayHistoryData.class).listen(findCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, UpdateOrDeleteCallback updateOrDeleteCallback) {
        LitePal.deleteAllAsync(HomeMarkData.class, "url = ?", str).listen(updateOrDeleteCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<CodeForSiteData> list) {
        if (list != null) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("site_websource_deleted_notify", false);
            LitePal.deleteAll(CodeForSiteData.class, new String[0]);
            LitePal.markAsDeleted(list);
            LitePal.saveAll(list);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<HomeMarkData> list, SaveCallback saveCallback) {
        LitePal.deleteAllAsync(HomeMarkData.class, new String[0]).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, saveCallback));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceTitaData webSourceTitaData, SaveCallback saveCallback) {
        if (webSourceTitaData == null) {
            saveCallback.onFinish(false);
        } else {
            LitePal.deleteAllAsync(WebSourceTitaData.class, "baseUrl = ?", webSourceTitaData.getBaseUrl()).listen(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceTitaData, saveCallback));
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CountCallback countCallback) {
        LitePal.countAsync(WebSourceTitaData.class).listen(countCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FindCallback<SPData> findCallback) {
        LitePal.findFirstAsync(SPData.class).listen(findCallback);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FindMultiCallback<CodeForSiteData> findMultiCallback) {
        LitePal.findAllAsync(CodeForSiteData.class, new long[0]).listen(findMultiCallback);
    }
}
