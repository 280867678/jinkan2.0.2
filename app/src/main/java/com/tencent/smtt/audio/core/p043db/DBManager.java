package com.tencent.smtt.audio.core.p043db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.common.utils.DBUtils;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/DBManager.class
 */
/* renamed from: com.tencent.smtt.audio.core.db.DBManager */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/DBManager.class */
public class DBManager {
    TbsAudioDBHelper helper;
    public static final String DB_NAME = "tbs_audio.db";
    private static final String TABLE_NAME = "TBS_AUDIO_LAST_LIST";
    private static final String TMP_TABLE = "TBS_AUDIO_LAST_LIST_TMP";
    private static final int DATABASE_VERSION = 1;
    private static final int DATABASE_VERSION_V2 = 2;

    public DBManager(Context context) {
        this.helper = new TbsAudioDBHelper(context);
    }

    public void updateIsValidWithId(int id, boolean isValid) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        try {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("VALID", Integer.valueOf(isValid ? 1 : 0));
                DBUtils.update(db, "TBS_AUDIO_LAST_LIST", contentValues, "ID=" + id);
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
                db.close();
            }
        } catch (Throwable th) {
            db.close();
            throw th;
        }
    }

    public void deleteAudioFromDB(int id) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        try {
            try {
                int i = DBUtils.delete(db, "TBS_AUDIO_LAST_LIST", "ID=" + id);
                AudioLog.i("deleteAudioFromDB" + id + "success!count = " + i);
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
                db.close();
            }
        } catch (Throwable th) {
            db.close();
            throw th;
        }
    }

    public void deleteAudioFromDB(String title, long time) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        try {
            try {
                int i = DBUtils.delete(db, "TBS_AUDIO_LAST_LIST", "TITLE = \"" + title + "\" AND TOTAL_TIME = " + time);
                AudioLog.i("deleteAudioFromDB" + title + "success!count = " + i);
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
                db.close();
            }
        } catch (Throwable th) {
            db.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01db A[Catch: Throwable -> 0x01e2, TryCatch #2 {Throwable -> 0x01e2, blocks: (B:40:0x01d1, B:31:0x01db), top: B:39:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<TbsAudioEntity> getLastPlayList() {
        List<TbsAudioEntity> list = Collections.synchronizedList(new ArrayList());
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = this.helper.getWritableDatabase();
            cursor = DBUtils.listAll(db, "TBS_AUDIO_LAST_LIST", "LAST_PLAY_TIME ASC");
        } catch (Throwable e) {
            try {
                e.printStackTrace();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
                if (db != null) {
                    db.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable t2) {
                        t2.printStackTrace();
                        throw th;
                    }
                }
                if (db != null) {
                    db.close();
                }
                throw th;
            }
        }
        if (cursor == null || cursor.isClosed() || !db.isOpen() || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable t3) {
                    t3.printStackTrace();
                }
            }
            if (db != null) {
                db.close();
            }
            AudioLog.i("getLastPlayListFromDB,list=" + list);
            return list;
        }
        do {
            TbsAudioEntity entity = new TbsAudioEntity();
            String artist = cursor.getString(cursor.getColumnIndex("ARTIST"));
            String originUrl = cursor.getString(cursor.getColumnIndex("ORIGIN_URL"));
            String audioSrc = cursor.getString(cursor.getColumnIndex("AUDIO_SRC"));
            String title = cursor.getString(cursor.getColumnIndex("TITLE"));
            long lastPlayTime = cursor.getLong(cursor.getColumnIndex("LAST_PLAY_TIME"));
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            boolean isValid = cursor.getInt(cursor.getColumnIndex("VALID")) == 1;
            long total = cursor.getLong(cursor.getColumnIndex("TOTAL_TIME"));
            String businessId = "";
            String coverUrl = "";
            String extmsg = "";
            String extParms = "";
            String redirectUrl = "";
            int type = 0;
            try {
                businessId = cursor.getString(cursor.getColumnIndex("BUSINESS_ID"));
                coverUrl = cursor.getString(cursor.getColumnIndex("COVER_URL"));
                extmsg = cursor.getString(cursor.getColumnIndex("EXTRA_MSG"));
                extParms = cursor.getString(cursor.getColumnIndex("EXTRA_PARMS"));
                redirectUrl = cursor.getString(cursor.getColumnIndex("REDIRECT_URL"));
                type = cursor.getInt(cursor.getColumnIndex("TYPE"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            entity.setValid(isValid);
            entity.setId(id);
            entity.setArtist(artist);
            entity.setOriginWebUrl(originUrl);
            entity.setAudioURL(audioSrc);
            entity.setTitle(title);
            entity.setLastPlayTime(lastPlayTime);
            entity.setTotalTime(total);
            entity.setBusinessID(businessId);
            entity.setCoverURL(coverUrl);
            entity.setExtraMsg(extmsg);
            entity.setExtraParm(extParms);
            entity.setRedirectUrl(redirectUrl);
            entity.setType(type);
            list.add(entity);
        } while (cursor.moveToNext());
        if (cursor != null) {
        }
        if (db != null) {
        }
        AudioLog.i("getLastPlayListFromDB,list=" + list);
        return list;
    }

    public void addAudioToLastPlayList(TbsAudioEntity entity) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        try {
            try {
                ContentValues values = new ContentValues();
                values.put("ORIGIN_URL", entity.getOriginWebUrl());
                values.put("AUDIO_SRC", entity.getAudioURL());
                values.put("TITLE", entity.getTitle());
                values.put("ARTIST", entity.getArtist());
                values.put("LAST_PLAY_TIME", Long.valueOf(entity.getLastPlayTime()));
                values.put("VALID", Integer.valueOf(entity.isValid() ? 1 : 0));
                values.put("TOTAL_TIME", Long.valueOf(entity.getTotalTime()));
                values.put("BUSINESS_ID", entity.getBusinessID());
                values.put("COVER_URL", entity.getCoverURL());
                values.put("EXTRA_MSG", entity.getCoverURL());
                values.put("EXTRA_PARMS", entity.getExtraParm());
                values.put("REDIRECT_URL", entity.getRedirectUrl());
                values.put("TYPE", Integer.valueOf(entity.getType()));
                db.insert("TBS_AUDIO_LAST_LIST", null, values);
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
                db.close();
            }
            AudioLog.i("addAudioToLastPlayList,entity=" + entity);
        } catch (Throwable th) {
            db.close();
            throw th;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/DBManager$TbsAudioDBHelper.class
 */
    /* renamed from: com.tencent.smtt.audio.core.db.DBManager$TbsAudioDBHelper */
    /* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/DBManager$TbsAudioDBHelper.class */
    public class TbsAudioDBHelper extends SQLiteOpenHelper {
        public TbsAudioDBHelper(Context context) {
            super(context, "tbs_audio.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            DBManager.this.createTable(db);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            switch (oldVersion) {
                case 1:
                    DBManager.this.upgradeTables(db, "TBS_AUDIO_LAST_LIST", "ORIGIN_URL,AUDIO_SRC,TITLE,ARTIST,LAST_PLAY_TIME,VALID,TOTAL_TIME");
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTable(SQLiteDatabase db) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(" CREATE TABLE IF NOT EXISTS").append(StringUtils.SPACE).append("TBS_AUDIO_LAST_LIST").append(" ( ID INTEGER PRIMARY KEY AUTOINCREMENT,").append(" ORIGIN_URL TEXT,").append(" AUDIO_SRC TEXT,").append(" TITLE TEXT,").append(" ARTIST TEXT,").append(" VALID INTEGER,").append(" TOTAL_TIME INTEGER,").append(" LAST_PLAY_TIME INTEGER,").append(" BUSINESS_ID TEXT,").append(" COVER_URL TEXT,").append(" EXTRA_MSG TEXT,").append(" EXTRA_PARMS TEXT,").append(" REDIRECT_URL TEXT,").append(" TYPE INTEGER );");
            DBUtils.execSQL(db, builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            DBUtils.execSQL(db, "PRAGMA default_cache_size=4096;");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void upgradeTables(SQLiteDatabase db, String tableName, String columns) {
        try {
            try {
                db.beginTransaction();
                String tempTableName = tableName + "_temp";
                String sql = "ALTER TABLE " + tableName + " RENAME TO " + tempTableName;
                DBUtils.execSQL(db, sql);
                createTable(db);
                String sql2 = "INSERT INTO " + tableName + " (" + columns + ")  SELECT " + columns + " FROM " + tempTableName;
                DBUtils.execSQL(db, sql2);
                DBUtils.execSQL(db, "DROP TABLE IF EXISTS " + tempTableName);
                db.setTransactionSuccessful();
                db.endTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
                db.endTransaction();
            } catch (Exception e2) {
                e2.printStackTrace();
                db.endTransaction();
            }
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }
}
