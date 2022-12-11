package me.tvspark.utils.cast.service.upnp;

import android.content.ContentUris;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import me.tvspark.ApplicationC1880C;
import me.tvspark.r40;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes4.dex */
public class VideoResourceServlet extends DefaultServlet {
    @Override // org.eclipse.jetty.servlet.DefaultServlet, org.eclipse.jetty.util.resource.ResourceFactory
    public Resource getResource(String str) {
        try {
            Cursor query = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww.getContentResolver().query(ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, Long.parseLong(r40.Wwwwwwwwwwwwwwwwwwwwwww(str))), null, null, null, null);
            query.moveToFirst();
            File file = new File(query.getString(query.getColumnIndexOrThrow("_data")));
            if (!file.exists()) {
                return null;
            }
            return Resource.newResource(file);
        } catch (Exception e) {
            e.printStackTrace();
            if (!TextUtils.isEmpty(str) && str.startsWith("/video")) {
                str = str.replace("/video", "");
            }
            File file2 = new File(str);
            if (!file2.exists()) {
                return null;
            }
            try {
                return Resource.newResource(file2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }
}
