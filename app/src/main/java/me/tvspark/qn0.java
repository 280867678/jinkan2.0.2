package me.tvspark;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes4.dex */
public class qn0 extends AsyncTask<Void, Void, String> implements sk0 {
    public static String Wwwwwwwwwwww = "cache_index_rank_movie";
    public static String Wwwwwwwwwwwww = "cache_index_rank_tv";
    public static String Wwwwwwwwwwwwww = "cache_index_rec";
    public static String Wwwwwwwwwwwwwww = "cache_first_homepage";
    public static String Wwwwwwwwwwwwwwww = "home_cntv";
    public static String Wwwwwwwwwwwwwwwww = "home_other_";
    public static String Wwwwwwwwwwwwwwwwww = "home_index";
    public static String Wwwwwwwwwwwwwwwwwww = "newest_index";
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);
    }

    public qn0(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwww = context;
    }

    public qn0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwww = true;
        return this;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void[] voidArr) {
        String str = "";
        try {
        } catch (Exception e) {
            e = e;
        }
        if (this.Wwwwwwwwwwwwwwwwwwww) {
            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                FileOutputStream openFileOutput = this.Wwwwwwwwwwwwwwwwwwwww.openFileOutput(this.Wwwwwwwwwwwwwwwwwwwwwww, 0);
                openFileOutput.write(this.Wwwwwwwwwwwwwwwwwwwwwwww.getBytes());
                openFileOutput.close();
            }
            return str;
        }
        FileInputStream openFileInput = this.Wwwwwwwwwwwwwwwwwwwww.openFileInput(this.Wwwwwwwwwwwwwwwwwwwwwww);
        byte[] bArr = new byte[openFileInput.available()];
        openFileInput.read(bArr);
        String str2 = new String(bArr, "UTF-8");
        try {
            openFileInput.close();
            str = str2;
        } catch (Exception e2) {
            e = e2;
            str = str2;
            e.printStackTrace();
            return str;
        }
        return str;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        String str2 = str;
        super.onPostExecute(str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        }
    }
}
