package me.tvspark.presenter;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Map;
import me.tvspark.ApplicationC1880C;
import me.tvspark.data.bean.DoubanCategoryAPIParcel;
import me.tvspark.data.bean.DoubanCategoryParcel;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.data.bean.VersionParcel;
import me.tvspark.mq0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.rm0;
import me.tvspark.sm0;
import me.tvspark.utils.SKUtils;
import me.tvspark.zk0;
import okhttp3.ResponseBody;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class CategoryPresenterImpl extends zk0<sm0> implements rm0 {
    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.rm0
    public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel, GenreParcel genreParcel2, GenreParcel genreParcel3, GenreParcel genreParcel4, GenreParcel genreParcel5, int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return null;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("&start=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((i - 1) * 20);
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        String replace = genreParcel.getName().replace("全部", "");
        String replace2 = genreParcel3.getName().replace("全部", "");
        String replace3 = genreParcel2.getName().replace("全部", "");
        String replace4 = genreParcel4.getName().replace("全部", "");
        StringBuilder sb2 = new StringBuilder(replace);
        if (!TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(replace3)) {
            sb2.append("%2C");
        }
        sb2.append(replace3);
        if (!TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(replace2)) {
            sb2.append("%2C");
        }
        sb2.append(replace2);
        if (!TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(replace4)) {
            sb2.append("%2C");
        }
        sb2.append(replace4);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("https://frodo.douban.com/api/v2/movie/tag?q=");
        sb3.append((Object) sb2);
        sb3.append("&sort=");
        sb3.append(genreParcel5.getLink());
        sb3.append("&count=20");
        sb3.append(sb);
        sb3.append("&score_range=0%2C10&os_rom=miui&channel=Yingyongbao_Market&apikey=");
        VersionParcel versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww;
        sb3.append((versionParcel == null || TextUtils.isEmpty(versionParcel.getDn())) ? "0dad551ec0f84ed02907ff5c42e8ec70" : SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwww.getDn()));
        String sb4 = sb3.toString();
        Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = mq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb4, "GET", null);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            for (String str : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.keySet()) {
                sb4 = sb4 + "&" + str + "=" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(str);
            }
        }
        VersionParcel versionParcel2 = ApplicationC1880C.Wwwwwwwwwwwwwww;
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("https://frodo.douban.com", (versionParcel2 == null || TextUtils.isEmpty(versionParcel2.getDnu())) ? "api-client/1 com.douban.frodo/7.12.1(222) Android/25 product/tiffany vendor/Xiaomi model/MI 6  rom/miui8  network/wifi  platform/mobile" : SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwww.getDnu())).get(sb4);
    }

    @Override // me.tvspark.rm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ((sm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ArrayList<GenreParcel>() { // from class: me.tvspark.presenter.CategoryPresenterImpl.1
            {
                add(new GenreParcel("全部", ""));
                add(new GenreParcel("电影", "&tags=电影"));
                add(new GenreParcel("电视剧", "&tags=电视剧"));
                add(new GenreParcel("综艺", "&tags=综艺"));
                add(new GenreParcel("动漫", "&tags=动漫"));
                add(new GenreParcel("纪录片", "&tags=纪录片"));
            }
        }, new ArrayList<GenreParcel>() { // from class: me.tvspark.presenter.CategoryPresenterImpl.2
            {
                add(new GenreParcel("全部", ""));
                add(new GenreParcel("剧情", "&genres=剧情"));
                add(new GenreParcel("喜剧", "&genres=喜剧"));
                add(new GenreParcel("动作", "&genres=动作"));
                add(new GenreParcel("爱情", "&genres=爱情"));
                add(new GenreParcel("科幻", "&genres=科幻"));
                add(new GenreParcel("动画", "&genres=动画"));
                add(new GenreParcel("悬疑", "&genres=悬疑"));
                add(new GenreParcel("惊悚", "&genres=惊悚"));
                add(new GenreParcel("恐怖", "&genres=恐怖"));
                add(new GenreParcel("犯罪", "&genres=犯罪"));
                add(new GenreParcel("音乐", "&genres=音乐"));
                add(new GenreParcel("歌舞", "&genres=歌舞"));
                add(new GenreParcel("传记", "&genres=传记"));
                add(new GenreParcel("历史", "&genres=历史"));
                add(new GenreParcel("战争", "&genres=战争"));
                add(new GenreParcel("西部", "&genres=西部"));
                add(new GenreParcel("奇幻", "&genres=奇幻"));
                add(new GenreParcel("冒险", "&genres=冒险"));
                add(new GenreParcel("灾难", "&genres=灾难"));
                add(new GenreParcel("武侠", "&genres=武侠"));
            }
        }, new ArrayList<GenreParcel>() { // from class: me.tvspark.presenter.CategoryPresenterImpl.3
            {
                add(new GenreParcel("全部", ""));
                add(new GenreParcel("大陆", "&countries=中国大陆"));
                add(new GenreParcel("美国", "&countries=美国"));
                add(new GenreParcel("香港", "&countries=香港"));
                add(new GenreParcel("台湾", "&countries=台湾"));
                add(new GenreParcel("日本", "&countries=日本"));
                add(new GenreParcel("韩国", "&countries=韩国"));
                add(new GenreParcel("英国", "&countries=英国"));
                add(new GenreParcel("印度", "&countries=印度"));
                add(new GenreParcel("泰国", "&countries=泰国"));
            }
        }, new ArrayList<GenreParcel>() { // from class: me.tvspark.presenter.CategoryPresenterImpl.4
            {
                add(new GenreParcel("全部", ""));
                add(new GenreParcel("2022", "&year_range=2022%2C2022"));
                add(new GenreParcel("2021", "&year_range=2021%2C2021"));
                add(new GenreParcel("2020", "&year_range=2020%2C2020"));
                add(new GenreParcel("2019", "&year_range=2019%2C2019"));
                add(new GenreParcel("2018", "&year_range=2018%2C2018"));
                add(new GenreParcel("2010年代", "&year_range=2010%2C2019"));
                add(new GenreParcel("2000年代", "&year_range=2000%2C2009"));
                add(new GenreParcel("90年代", "&year_range=1990%2C1999"));
                add(new GenreParcel("80年代", "&year_range=1980%2C1989"));
                add(new GenreParcel("70年代", "&year_range=1970%2C1979"));
            }
        }, new ArrayList<GenreParcel>() { // from class: me.tvspark.presenter.CategoryPresenterImpl.5
            {
                add(new GenreParcel("近期热门", "U"));
                add(new GenreParcel("标记最多", ExifInterface.GPS_DIRECTION_TRUE));
                add(new GenreParcel("评分最高", ExifInterface.LATITUDE_SOUTH));
                add(new GenreParcel("最新上映", "R"));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // me.tvspark.rm0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, int i) {
        boolean z2;
        DoubanCategoryParcel doubanCategoryParcel = new DoubanCategoryParcel();
        if (!TextUtils.isEmpty(str)) {
            try {
                doubanCategoryParcel.transParcel((DoubanCategoryAPIParcel) JSON.parseObject(str, DoubanCategoryAPIParcel.class));
                z2 = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!z) {
                ((sm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, doubanCategoryParcel.getData(), str);
                return;
            } else {
                ((sm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, doubanCategoryParcel.getData(), str, i);
                return;
            }
        }
        z2 = false;
        if (!z) {
        }
    }
}
