package me.tvspark.utils.cast.service.upnp;

import android.content.ContentUris;
import android.database.Cursor;
import android.provider.MediaStore;
import java.io.File;
import me.tvspark.ApplicationC1880C;
import me.tvspark.r40;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes4.dex */
public class ImageResourceServlet extends DefaultServlet {
    @Override // org.eclipse.jetty.servlet.DefaultServlet, org.eclipse.jetty.util.resource.ResourceFactory
    public Resource getResource(String str) {
        try {
            Cursor query = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww.getContentResolver().query(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.parseLong(r40.Wwwwwwwwwwwwwwwwwwwwwww(str))), null, null, null, null);
            query.moveToFirst();
            File file = new File(query.getString(query.getColumnIndexOrThrow("_data")));
            if (!file.exists()) {
                return null;
            }
            return Resource.newResource(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
