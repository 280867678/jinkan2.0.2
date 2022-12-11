package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes3.dex */
public class ActivityChooserModel extends DataSetObservable {
    public static final String ATTRIBUTE_ACTIVITY = "activity";
    public static final String ATTRIBUTE_TIME = "time";
    public static final String ATTRIBUTE_WEIGHT = "weight";
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ACTIVITY_INFLATION = 5;
    public static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    public static final String HISTORY_FILE_EXTENSION = ".xml";
    public static final int INVALID_INDEX = -1;
    public static final String TAG_HISTORICAL_RECORD = "historical-record";
    public static final String TAG_HISTORICAL_RECORDS = "historical-records";
    public OnChooseActivityListener mActivityChoserModelPolicy;
    public final Context mContext;
    public final String mHistoryFileName;
    public Intent mIntent;
    public static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    public static final Object sRegistryLock = new Object();
    public static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    public final Object mInstanceLock = new Object();
    public final List<ActivityResolveInfo> mActivities = new ArrayList();
    public final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    public ActivitySorter mActivitySorter = new DefaultSorter();
    public int mHistoryMaxSize = 50;
    public boolean mCanReadHistoricalData = true;
    public boolean mReadShareHistoryCalled = false;
    public boolean mHistoricalRecordsChanged = true;
    public boolean mReloadActivities = false;

    /* loaded from: classes3.dex */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* loaded from: classes3.dex */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[", "resolveInfo:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.resolveInfo.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; weight:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(new BigDecimal(this.weight));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes3.dex */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* loaded from: classes3.dex */
    public static final class DefaultSorter implements ActivitySorter {
        public static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        public final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.mPackageNameToActivityMap;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight = (historicalRecord.weight * f) + activityResolveInfo2.weight;
                    f *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    /* loaded from: classes3.dex */
    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return Float.floatToIntBits(this.weight) + ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[", "; activity:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.activity);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; time:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.time);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; weight:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(new BigDecimal(this.weight));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes3.dex */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* loaded from: classes3.dex */
    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        public PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006b, code lost:
            if (r14 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x009a, code lost:
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
            r14.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
            if (r14 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
            if (r14 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
            if (r14 == null) goto L13;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            try {
                FileOutputStream openFileOutput = ActivityChooserModel.this.mContext.openFileOutput((String) objArr[1], 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            try {
                                newSerializer.setOutput(openFileOutput, null);
                                newSerializer.startDocument("UTF-8", true);
                                newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                                int size = list.size();
                                for (int i = 0; i < size; i++) {
                                    HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                                    newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                                    newSerializer.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, historicalRecord.activity.flattenToString());
                                    newSerializer.attribute(null, "time", String.valueOf(historicalRecord.time));
                                    newSerializer.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(historicalRecord.weight));
                                    newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                                }
                                newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                                newSerializer.endDocument();
                                ActivityChooserModel.this.mCanReadHistoricalData = true;
                            } catch (IllegalStateException unused) {
                                String str = ActivityChooserModel.LOG_TAG;
                                String str2 = ActivityChooserModel.this.mHistoryFileName;
                                ActivityChooserModel.this.mCanReadHistoricalData = true;
                            }
                        } catch (IOException unused2) {
                            String str3 = ActivityChooserModel.LOG_TAG;
                            String str4 = ActivityChooserModel.this.mHistoryFileName;
                            ActivityChooserModel.this.mCanReadHistoricalData = true;
                        }
                    } catch (Throwable th) {
                        ActivityChooserModel.this.mCanReadHistoricalData = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IllegalArgumentException unused4) {
                    String str5 = ActivityChooserModel.LOG_TAG;
                    String str6 = ActivityChooserModel.this.mHistoryFileName;
                    ActivityChooserModel.this.mCanReadHistoricalData = true;
                }
            } catch (FileNotFoundException unused5) {
                String str7 = ActivityChooserModel.LOG_TAG;
                return null;
            }
        }
    }

    public ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str;
        } else {
            this.mHistoryFileName = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, HISTORY_FILE_EXTENSION);
        }
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        boolean add = this.mHistoricalRecords.add(historicalRecord);
        if (add) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return add;
    }

    private void ensureConsistentState() {
        boolean loadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (loadActivitiesIfNeeded) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            activityChooserModel = sDataModelRegistry.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                sDataModelRegistry.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.mActivities.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (this.mReadShareHistoryCalled) {
            if (!this.mHistoricalRecordsChanged) {
                return;
            }
            this.mHistoricalRecordsChanged = false;
            if (TextUtils.isEmpty(this.mHistoryFileName)) {
                return;
            }
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
            return;
        }
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (size <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i = 0; i < size; i++) {
            this.mHistoricalRecords.remove(0);
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
            return false;
        }
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput(this.mHistoryFileName);
            try {
                newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                }
            } catch (IOException unused) {
                if (openFileInput == null) {
                    return;
                }
            } catch (XmlPullParserException unused2) {
                if (openFileInput == null) {
                    return;
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            if (!TAG_HISTORICAL_RECORDS.equals(newPullParser.getName())) {
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            }
            List<HistoricalRecord> list = this.mHistoricalRecords;
            list.clear();
            while (true) {
                int next = newPullParser.next();
                if (next == 1) {
                    if (openFileInput == null) {
                        return;
                    }
                } else if (next != 3 && next != 4) {
                    if (!TAG_HISTORICAL_RECORD.equals(newPullParser.getName())) {
                        throw new XmlPullParserException("Share records file not well-formed.");
                    }
                    list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, ATTRIBUTE_ACTIVITY), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, ATTRIBUTE_WEIGHT))));
                }
            }
            openFileInput.close();
        } catch (FileNotFoundException | IOException unused4) {
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null || this.mIntent == null || this.mActivities.isEmpty() || this.mHistoricalRecords.isEmpty()) {
            return false;
        }
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    public Intent chooseActivity(int i) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = this.mActivities.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.mActivityChoserModelPolicy != null) {
                if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            addHistoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo getActivity(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = this.mActivities.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            List<ActivityResolveInfo> list = this.mActivities;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            if (!this.mActivities.isEmpty()) {
                return this.mActivities.get(0).resolveInfo;
            }
            return null;
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setDefaultActivity(int i) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = this.mActivities.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
            addHistoricalRecord(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f));
        }
    }

    public void setHistoryMaxSize(int i) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == i) {
                return;
            }
            this.mHistoryMaxSize = i;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            ensureConsistentState();
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
        }
    }
}
