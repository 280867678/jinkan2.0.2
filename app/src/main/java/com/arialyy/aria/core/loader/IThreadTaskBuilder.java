package com.arialyy.aria.core.loader;

import android.os.Handler;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.task.IThreadTask;
import java.util.List;

/* loaded from: classes3.dex */
public interface IThreadTaskBuilder extends ILoaderComponent {
    List<IThreadTask> buildThreadTask(TaskRecord taskRecord, Handler handler);

    int getCreatedThreadNum();
}
