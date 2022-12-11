package com.arialyy.aria.m3u8;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.listener.BaseListener;
import com.arialyy.aria.core.listener.IDLoadListener;
import com.arialyy.aria.core.listener.ISchedulers;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DeleteM3u8Record;

/* loaded from: classes3.dex */
public final class M3U8Listener extends BaseListener<DownloadEntity, DTaskWrapper, AbsTask<DTaskWrapper>> implements IDLoadListener {
    public M3U8Listener(AbsTask<DTaskWrapper> absTask, Handler handler) {
        super(absTask, handler);
    }

    private void sendPeerStateToTarget(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString(ISchedulers.DATA_M3U8_URL, str);
        bundle.putString(ISchedulers.DATA_M3U8_PEER_PATH, str2);
        bundle.putInt(ISchedulers.DATA_M3U8_PEER_INDEX, i2);
        Message obtainMessage = this.outHandler.get().obtainMessage();
        obtainMessage.setData(bundle);
        obtainMessage.what = i;
        obtainMessage.arg1 = 210;
        obtainMessage.sendToTarget();
    }

    @Override // com.arialyy.aria.core.listener.BaseListener
    public void handleCancel() {
        if (getTask().getSchedulerType() != 4) {
            DeleteM3u8Record.getInstance().deleteRecord(this.mEntity, ((DTaskWrapper) this.mTaskWrapper).isRemoveFile(), true);
            return;
        }
        ((DownloadEntity) this.mEntity).setComplete(false);
        ((DownloadEntity) this.mEntity).setState(3);
        DeleteM3u8Record.getInstance().deleteRecord(this.mEntity, ((DTaskWrapper) this.mTaskWrapper).isRemoveFile(), false);
    }

    public void onPeerComplete(String str, String str2, int i) {
        sendPeerStateToTarget(178, str, str2, i);
    }

    public void onPeerFail(String str, String str2, int i) {
        sendPeerStateToTarget(179, str, str2, i);
    }

    public void onPeerStart(String str, String str2, int i) {
        sendPeerStateToTarget(177, str, str2, i);
    }

    @Override // com.arialyy.aria.core.listener.IDLoadListener
    public void onPostPre(long j) {
        ((DownloadEntity) this.mEntity).setFileSize(j);
        ((DownloadEntity) this.mEntity).setConvertFileSize(CommonUtil.formatFileSize(j));
        saveData(6, -1L);
        sendInState2Target(1);
    }

    @Override // com.arialyy.aria.core.listener.IDLoadListener
    public void supportBreakpoint(boolean z) {
        if (!z) {
            sendInState2Target(9);
        }
    }
}
