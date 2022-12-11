package me.tvspark;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;
import androidx.core.app.NotificationCompatJellybean;
import com.just.agentweb.DefaultWebClient;
import com.umeng.analytics.pro.C1543ak;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.support.contentdirectory.AbstractContentDirectoryService;
import org.fourthline.cling.support.contentdirectory.ContentDirectoryErrorCode;
import org.fourthline.cling.support.contentdirectory.ContentDirectoryException;
import org.fourthline.cling.support.contentdirectory.DIDLParser;
import org.fourthline.cling.support.model.BrowseFlag;
import org.fourthline.cling.support.model.BrowseResult;
import org.fourthline.cling.support.model.DIDLContent;
import org.fourthline.cling.support.model.PersonWithRole;
import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.SortCriterion;
import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.ImageItem;
import org.fourthline.cling.support.model.item.Item;
import org.fourthline.cling.support.model.item.Movie;
import org.fourthline.cling.support.model.item.MusicTrack;
import org.seamless.util.MimeType;

/* loaded from: classes4.dex */
public class np0 extends AbstractContentDirectoryService {
    @Override // org.fourthline.cling.support.contentdirectory.AbstractContentDirectoryService
    public BrowseResult browse(String str, BrowseFlag browseFlag, String str2, long j, long j2, SortCriterion[] sortCriterionArr) throws ContentDirectoryException {
        Container container = new Container();
        container.setChildCount(0);
        if ("0".equals(str)) {
            Container container2 = new Container();
            container2.setId("10");
            container2.setParentID("0");
            container2.setClazz(uo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            container2.setTitle("Audios");
            container.addContainer(container2);
            container.setChildCount(Integer.valueOf(container.getChildCount().intValue() + 1));
            Container container3 = new Container();
            container3.setId("30");
            container3.setParentID("0");
            container3.setClazz(uo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            container3.setTitle("Images");
            container.addContainer(container3);
            container.setChildCount(Integer.valueOf(container.getChildCount().intValue() + 1));
            Container container4 = new Container();
            container4.setId("20");
            container4.setParentID("0");
            container4.setClazz(uo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            container4.setTitle("Videos");
            container.addContainer(container4);
            container.setChildCount(Integer.valueOf(container.getChildCount().intValue() + 1));
        } else {
            boolean equals = "10".equals(str);
            String str3 = "duration";
            String str4 = "artist";
            String str5 = ".";
            String str6 = "_data";
            String str7 = "_size";
            String str8 = "mime_type";
            String str9 = NotificationCompatJellybean.KEY_TITLE;
            String str10 = "_id";
            if (equals) {
                Application application = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww;
                ContentResolver contentResolver = application.getContentResolver();
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(application));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(8289);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("/");
                String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                ArrayList arrayList = new ArrayList();
                Cursor query = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", NotificationCompatJellybean.KEY_TITLE, "_data", "artist", "mime_type", "_size", "duration", "album"}, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        String valueOf = String.valueOf(query.getInt(query.getColumnIndex(str10)));
                        String string = query.getString(query.getColumnIndex(str9));
                        String string2 = query.getString(query.getColumnIndex(str4));
                        String string3 = query.getString(query.getColumnIndex(str8));
                        String str11 = str4;
                        long j3 = query.getLong(query.getColumnIndex(str7));
                        String timeString = ModelUtil.toTimeString(query.getLong(query.getColumnIndex(str3)) / 1000);
                        String str12 = str3;
                        String string4 = query.getString(query.getColumnIndex("album"));
                        String str13 = str7;
                        String string5 = query.getString(query.getColumnIndexOrThrow(str6));
                        Cursor cursor = query;
                        String substring = string5.substring(string5.lastIndexOf(File.separator));
                        arrayList.add(new MusicTrack(valueOf, "10", string, string2, string4, new PersonWithRole(string2), new Res(string3, Long.valueOf(j3), timeString, (Long) null, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "audio", string5.replace(substring, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), File.separator, valueOf, substring.substring(substring.lastIndexOf(str5))))))));
                        str4 = str11;
                        str3 = str12;
                        str7 = str13;
                        query = cursor;
                        str6 = str6;
                        str5 = str5;
                        str8 = str8;
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    container.addItem((Item) it.next());
                    container.setChildCount(Integer.valueOf(container.getChildCount().intValue() + 1));
                }
            } else {
                String str14 = str3;
                if ("30".equals(str)) {
                    Application application2 = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww;
                    ContentResolver contentResolver2 = application2.getContentResolver();
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(application2));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(8289);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("/");
                    String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                    ArrayList arrayList2 = new ArrayList();
                    String str15 = str7;
                    String str16 = str6;
                    String str17 = str8;
                    Cursor query2 = contentResolver2.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{str10, str9, str16, str17, str15}, null, null, null);
                    if (query2 != null) {
                        while (query2.moveToNext()) {
                            String valueOf2 = String.valueOf(query2.getInt(query2.getColumnIndex(str10)));
                            String string6 = query2.getString(query2.getColumnIndex(str9));
                            String string7 = query2.getString(query2.getColumnIndexOrThrow(str9));
                            String string8 = query2.getString(query2.getColumnIndex(str17));
                            long j4 = query2.getLong(query2.getColumnIndex(str15));
                            String string9 = query2.getString(query2.getColumnIndexOrThrow(str16));
                            Cursor cursor2 = query2;
                            String substring2 = string9.substring(string9.lastIndexOf(File.separator));
                            arrayList2.add(new ImageItem(valueOf2, "30", string6, string7, new Res(new MimeType(string8.substring(0, string8.indexOf(47)), string8.substring(string8.indexOf(47) + 1)), Long.valueOf(j4), outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "image", string9.replace(substring2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), File.separator, valueOf2, substring2.substring(substring2.lastIndexOf(str5))))))));
                            query2 = cursor2;
                            sb2 = sb2;
                            str15 = str15;
                            str16 = str16;
                            str17 = str17;
                        }
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        container.addItem((Item) it2.next());
                        container.setChildCount(Integer.valueOf(container.getChildCount().intValue() + 1));
                    }
                } else if ("20".equals(str)) {
                    Application application3 = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww;
                    ContentResolver contentResolver3 = application3.getContentResolver();
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(application3));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(":");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(8289);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("/");
                    String sb3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
                    ArrayList arrayList3 = new ArrayList();
                    Cursor query3 = contentResolver3.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", NotificationCompatJellybean.KEY_TITLE, "_data", "artist", "mime_type", "_size", "duration", C1543ak.f3055z}, null, null, null);
                    if (query3 != null) {
                        while (query3.moveToNext()) {
                            String valueOf3 = String.valueOf(query3.getInt(query3.getColumnIndex(str10)));
                            String string10 = query3.getString(query3.getColumnIndex(str9));
                            String string11 = query3.getString(query3.getColumnIndex(str4));
                            String string12 = query3.getString(query3.getColumnIndex(str8));
                            long j5 = query3.getLong(query3.getColumnIndex(str7));
                            String str18 = str14;
                            long j6 = query3.getLong(query3.getColumnIndex(str18)) / 1000;
                            String timeString2 = ModelUtil.toTimeString(j6);
                            String string13 = query3.getString(query3.getColumnIndex(C1543ak.f3055z));
                            String str19 = str9;
                            String string14 = query3.getString(query3.getColumnIndexOrThrow(str6));
                            Cursor cursor3 = query3;
                            String substring3 = string14.substring(string14.lastIndexOf(File.separator));
                            Res res = new Res(string12, Long.valueOf(j5), timeString2, (Long) null, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb3, "video", string14.replace(substring3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), File.separator, valueOf3, substring3.substring(substring3.lastIndexOf(str5))))));
                            res.setDuration(ModelUtil.toTimeString(j6));
                            res.setResolution(string13);
                            arrayList3.add(new Movie(valueOf3, "20", string10, string11, res));
                            str9 = str19;
                            query3 = cursor3;
                            str10 = str10;
                            str14 = str18;
                        }
                    }
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        container.addItem((Item) it3.next());
                        container.setChildCount(Integer.valueOf(container.getChildCount().intValue() + 1));
                    }
                }
            }
        }
        DIDLContent dIDLContent = new DIDLContent();
        for (Container container5 : container.getContainers()) {
            dIDLContent.addContainer(container5);
        }
        for (Item item : container.getItems()) {
            dIDLContent.addItem(item);
        }
        try {
            long intValue = container.getChildCount().intValue();
            return new BrowseResult(new DIDLParser().generate(dIDLContent), intValue, intValue);
        } catch (Exception e) {
            throw new ContentDirectoryException(ContentDirectoryErrorCode.CANNOT_PROCESS, e.toString());
        }
    }
}
