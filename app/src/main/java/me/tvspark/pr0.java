package me.tvspark;

import android.content.Context;
import android.os.AsyncTask;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.tvspark.data.bean.MyDownData;
import me.tvspark.view.activity.AllDownParentActivity;

/* loaded from: classes4.dex */
public class pr0 extends AsyncTask<Void, Void, List<MyDownData>> implements sk0 {
    public HashMap<String, MyDownData> Wwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public Context Wwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public pr0(Context context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.os.AsyncTask
    public List<MyDownData> doInBackground(Void[] voidArr) {
        ArrayList arrayList = new ArrayList();
        List<DownloadEntity> allCompleteTask = Aria.download(this.Wwwwwwwwwwwwwwwwwwwwwww).getAllCompleteTask();
        if (allCompleteTask != null && !allCompleteTask.isEmpty()) {
            for (int i = 0; i < allCompleteTask.size(); i++) {
                try {
                    String parent = new File(allCompleteTask.get(i).getFilePath()).getParent();
                    String name = new File(parent).getName();
                    if (!name.equals("titaSo")) {
                        MyDownData myDownData = this.Wwwwwwwwwwwwwwwwwwwwww.containsKey(name) ? this.Wwwwwwwwwwwwwwwwwwwwww.get(name) : new MyDownData();
                        myDownData.setDirPath(parent);
                        myDownData.setDirName(name);
                        myDownData.setChildFilesCount(myDownData.getChildFilesCount() + 1);
                        myDownData.getChildList().add(allCompleteTask.get(i));
                        if (!this.Wwwwwwwwwwwwwwwwwwwwww.containsKey(name)) {
                            myDownData.setCoverUrl(yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(name));
                            this.Wwwwwwwwwwwwwwwwwwwwww.put(name, myDownData);
                            arrayList.add(myDownData);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(List<MyDownData> list) {
        List<MyDownData> list2 = list;
        super.onPostExecute(list2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            AllDownParentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AllDownParentActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (list2 != null && !list2.isEmpty()) {
                AllDownParentActivity.this.Wwwwwwwwwwwwwwwww.clear();
                AllDownParentActivity.this.Wwwwwwwwwwwwwwwww.addAll(list2);
                AllDownParentActivity.this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, false);
            }
            AllDownParentActivity.this.refreshLayout.setRefreshing(false);
        }
    }
}
