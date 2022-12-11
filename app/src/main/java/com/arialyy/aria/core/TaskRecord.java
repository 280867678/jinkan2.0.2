package com.arialyy.aria.core;

import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.orm.annotation.Ignore;
import com.arialyy.aria.orm.annotation.NoNull;
import java.util.List;

/* loaded from: classes3.dex */
public class TaskRecord extends DbEntity {
    public String dGroupHash;
    public long fileLength;
    @NoNull
    public String fileName;
    public String filePath;
    public int threadNum;
    @Ignore
    public List<ThreadRecord> threadRecords;
    @Ignore
    @Deprecated
    public String uGroupHash;
    public boolean isGroupRecord = false;
    public boolean isBlock = false;
    public int taskType = 0;
    public long bandWidth = 0;
}
