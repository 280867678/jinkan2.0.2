package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import me.tvspark.outline;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMWorkDispatch {
    public static final String GENERAL_CONTENT = "content";
    public static final String GENERAL_HEADER = "header";
    public static final String KEY_EXCEPTION = "exception";
    public static final int MSG_AUTO_PROCESS = 769;
    public static final int MSG_CHECKER_TIMER = 771;
    public static final int MSG_DELAY_PROCESS = 770;
    public static final int MSG_QUIT = 784;
    public static final int MSG_SEND_EVENT = 768;
    public static HandlerThread mNetTask;
    public static C1720a mSender;
    public static Object mSenderInitLock = new Object();
    public static Handler mTaskHandler;

    public static void Quit() {
        Handler handler = mTaskHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = MSG_QUIT;
            mTaskHandler.sendMessage(obtainMessage);
        }
    }

    public static void delayProcess() {
        JSONObject buildEnvelopeWithExtHeader;
        ULog.m550d("--->>> delayProcess Enter...");
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> delayProcess Enter...");
        Context appContext = UMModuleRegister.getAppContext();
        if (appContext == null || !UMFrUtils.isOnline(appContext)) {
            return;
        }
        long maxDataSpace = UMEnvelopeBuild.maxDataSpace(appContext);
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("analytics");
        JSONObject jSONObject = null;
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(maxDataSpace);
                if (jSONObject == null) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> analyticsCB.setupReportData() return null");
                    return;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
                return;
            }
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
        JSONObject jSONObject3 = (JSONObject) jSONObject.opt("content");
        if (jSONObject2 == null || jSONObject3 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: removeCacheData ... ");
        callbackFromModuleName.removeCacheData(buildEnvelopeWithExtHeader);
    }

    public static synchronized boolean eventHasExist() {
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return false;
            }
            return mTaskHandler.hasMessages(MSG_CHECKER_TIMER);
        }
    }

    public static synchronized boolean eventHasExist(int i) {
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return false;
            }
            return mTaskHandler.hasMessages(i);
        }
    }

    public static void handleEvent(Message message) {
        int i = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i));
        if (callbackFromModuleName != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(i));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            ULog.m550d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            callbackFromModuleName.workEvent(obj, i);
        }
    }

    public static void handleQuit() {
        if (mSender == null || mNetTask == null) {
            return;
        }
        C1720a.m747c();
        ULog.m550d("--->>> handleQuit: Quit dispatch thread.");
        mNetTask.quit();
        teardown();
    }

    public static synchronized void init() {
        synchronized (UMWorkDispatch.class) {
            ULog.m550d("--->>> Dispatch: init Enter...");
            if (mNetTask == null) {
                HandlerThread handlerThread = new HandlerThread("work_thread");
                mNetTask = handlerThread;
                handlerThread.start();
                if (mTaskHandler == null) {
                    mTaskHandler = new Handler(mNetTask.getLooper()) { // from class: com.umeng.commonsdk.framework.UMWorkDispatch.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i = message.what;
                            if (i != 768) {
                                if (i == 784) {
                                    UMWorkDispatch.handleQuit();
                                    return;
                                } else if (i == 770) {
                                    UMWorkDispatch.delayProcess();
                                    return;
                                } else if (i != 771) {
                                    return;
                                }
                            }
                            UMWorkDispatch.handleEvent(message);
                        }
                    };
                }
            }
            ULog.m550d("--->>> Dispatch: init Exit...");
        }
    }

    public static void registerConnStateObserver(UMSenderStateNotify uMSenderStateNotify) {
        if (mSender != null) {
            C1720a.m751a(uMSenderStateNotify);
        }
    }

    public static synchronized void removeEvent() {
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return;
            }
            mTaskHandler.removeMessages(MSG_CHECKER_TIMER);
        }
    }

    public static synchronized void removeEvent(int i) {
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return;
            }
            mTaskHandler.removeMessages(i);
        }
    }

    public static void sendDelayProcessMsg(long j) {
        Handler handler = mTaskHandler;
        if (handler != null) {
            if (handler.hasMessages(MSG_DELAY_PROCESS)) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
            Message obtainMessage = mTaskHandler.obtainMessage();
            obtainMessage.what = MSG_DELAY_PROCESS;
            mTaskHandler.sendMessageDelayed(obtainMessage, j);
        }
    }

    public static void sendEvent(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        sendEventInternal(context, 768, i, uMLogDataProtocol, obj, 0L);
    }

    public static void sendEvent(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj, long j) {
        sendEventInternal(context, 768, i, uMLogDataProtocol, obj, j);
    }

    public static void sendEventEx(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj, long j) {
        sendEventInternal(context, MSG_CHECKER_TIMER, i, uMLogDataProtocol, obj, j);
    }

    public static void sendEventInternal(Context context, int i, int i2, UMLogDataProtocol uMLogDataProtocol, Object obj, long j) {
        if (context == null || uMLogDataProtocol == null) {
            ULog.m550d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
            return;
        }
        UMModuleRegister.registerAppContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        if (!UMModuleRegister.registerCallback(i2, uMLogDataProtocol)) {
            return;
        }
        if (mNetTask == null || mTaskHandler == null) {
            init();
        }
        try {
            if (mTaskHandler == null) {
                return;
            }
            if (UMUtils.isMainProgress(context)) {
                synchronized (mSenderInitLock) {
                    if (mSender == null) {
                        UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                        mSender = new C1720a(context, mTaskHandler);
                    }
                }
            }
            Message obtainMessage = mTaskHandler.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = obj;
            mTaskHandler.sendMessageDelayed(obtainMessage, j);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
        }
    }

    public static void teardown() {
        if (mNetTask != null) {
            mNetTask = null;
        }
        if (mTaskHandler != null) {
            mTaskHandler = null;
        }
        if (mSender != null) {
            mSender = null;
        }
    }
}
