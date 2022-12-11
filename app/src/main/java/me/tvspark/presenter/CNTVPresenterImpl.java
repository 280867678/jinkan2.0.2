package me.tvspark.presenter;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import me.tvspark.data.bean.CNTVParcel;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.pm0;
import me.tvspark.qm0;
import me.tvspark.r40;
import me.tvspark.zk0;
import okhttp3.ResponseBody;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class CNTVPresenterImpl extends zk0<qm0> implements pm0 {
    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.pm0
    public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel, int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return null;
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("https://api.cntv.cn", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36").get("https://api.cntv.cn/list/getVideoAlbumList?channelid=CHAL1460955853485115&area=&sc={type}&fc=%E7%94%B5%E8%A7%86%E5%89%A7&year=&letter=&p={page}&n=24&serviceId=tvcctv&t=json".replace("{page}", i + "").replace("{type}", genreParcel.getLink()));
    }

    @Override // me.tvspark.pm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ((qm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ArrayList<GenreParcel>() { // from class: me.tvspark.presenter.CNTVPresenterImpl.1
            {
                add(new GenreParcel("全部", ""));
                add(new GenreParcel("悬疑", "悬疑"));
                add(new GenreParcel("古装", "古装"));
                add(new GenreParcel("武侠", "武侠"));
                add(new GenreParcel("喜剧", "喜剧"));
                add(new GenreParcel("谍战", "谍战"));
                add(new GenreParcel("刑侦", "刑侦"));
                add(new GenreParcel("历史", "历史"));
                add(new GenreParcel("军旅", "军旅"));
                add(new GenreParcel("战争", "战争"));
                add(new GenreParcel("青春", "青春"));
                add(new GenreParcel("言情", "言情"));
                add(new GenreParcel("偶像", "偶像"));
                add(new GenreParcel("家庭", "家庭"));
                add(new GenreParcel("年代", "年代"));
                add(new GenreParcel("都市", "都市"));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    @Override // me.tvspark.pm0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str, int i) {
        CNTVParcel cNTVParcel;
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            try {
                cNTVParcel = (CNTVParcel) JSON.parseObject(str, CNTVParcel.class);
                z2 = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cNTVParcel == null) {
                cNTVParcel = new CNTVParcel();
            }
            if (!z) {
                ((qm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, cNTVParcel.getData().getList(), str);
                return;
            } else {
                ((qm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, cNTVParcel.getData().getList(), str, i);
                return;
            }
        }
        cNTVParcel = null;
        z2 = false;
        if (cNTVParcel == null) {
        }
        if (!z) {
        }
    }
}
