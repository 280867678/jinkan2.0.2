package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import me.tvspark.outline;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.util.BaseUtility;

/* loaded from: classes5.dex */
public class Connector {
    public static LitePalOpenHelper mLitePalHelper;

    public static LitePalOpenHelper buildConnection() {
        LitePalAttr litePalAttr = LitePalAttr.getInstance();
        litePalAttr.checkSelfValid();
        if (mLitePalHelper == null) {
            String dbName = litePalAttr.getDbName();
            if ("external".equalsIgnoreCase(litePalAttr.getStorage())) {
                dbName = LitePalApplication.getContext().getExternalFilesDir("") + "/databases/" + dbName;
            } else if (!UMModuleRegister.INNER.equalsIgnoreCase(litePalAttr.getStorage()) && !TextUtils.isEmpty(litePalAttr.getStorage())) {
                String replace = (Environment.getExternalStorageDirectory().getPath() + "/" + litePalAttr.getStorage()).replace("//", "/");
                if (BaseUtility.isClassAndMethodExist("androidx.core.content.ContextCompat", "checkSelfPermission") && ContextCompat.checkSelfPermission(LitePalApplication.getContext(), UMUtils.SD_PERMISSION) != 0) {
                    throw new DatabaseGenerateException(String.format(DatabaseGenerateException.EXTERNAL_STORAGE_PERMISSION_DENIED, replace));
                }
                File file = new File(replace);
                if (!file.exists()) {
                    file.mkdirs();
                }
                dbName = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replace, "/", dbName);
            }
            mLitePalHelper = new LitePalOpenHelper(dbName, litePalAttr.getVersion());
        }
        return mLitePalHelper;
    }

    public static void clearLitePalOpenHelperInstance() {
        LitePalOpenHelper litePalOpenHelper = mLitePalHelper;
        if (litePalOpenHelper != null) {
            litePalOpenHelper.getWritableDatabase().close();
            mLitePalHelper = null;
        }
    }

    public static SQLiteDatabase getDatabase() {
        return getWritableDatabase();
    }

    public static synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (Connector.class) {
            writableDatabase = buildConnection().getWritableDatabase();
        }
        return writableDatabase;
    }
}
