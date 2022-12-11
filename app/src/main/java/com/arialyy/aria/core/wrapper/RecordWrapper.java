package com.arialyy.aria.core.wrapper;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.orm.AbsDbWrapper;
import com.arialyy.aria.orm.annotation.Many;
import com.arialyy.aria.orm.annotation.One;
import com.arialyy.aria.orm.annotation.Wrapper;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.ArrayList;
import java.util.List;

@Wrapper
/* loaded from: classes3.dex */
public class RecordWrapper extends AbsDbWrapper {
    @One
    public TaskRecord taskRecord;
    @Many(entityColumn = "taskKey", parentColumn = TbsReaderView.KEY_FILE_PATH)
    public List<ThreadRecord> threadRecords;

    @Override // com.arialyy.aria.orm.AbsDbWrapper
    public void handleConvert() {
        TaskRecord taskRecord;
        List<ThreadRecord> arrayList;
        List<ThreadRecord> list = this.threadRecords;
        if (list == null || list.isEmpty()) {
            taskRecord = this.taskRecord;
            arrayList = new ArrayList<>();
        } else {
            taskRecord = this.taskRecord;
            arrayList = this.threadRecords;
        }
        taskRecord.threadRecords = arrayList;
    }
}
