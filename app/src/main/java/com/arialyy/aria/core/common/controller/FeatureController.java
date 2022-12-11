package com.arialyy.aria.core.common.controller;

import android.os.Handler;
import android.os.Looper;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.download.CheckDEntityUtil;
import com.arialyy.aria.core.download.CheckDGEntityUtil;
import com.arialyy.aria.core.download.CheckFtpDirEntityUtil;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.inf.ICheckEntityUtil;
import com.arialyy.aria.core.scheduler.TaskSchedulers;
import com.arialyy.aria.core.upload.CheckUEntityUtil;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public abstract class FeatureController {
    public static final int ACTION_ADD = 5;
    public static final int ACTION_CANCEL = 4;
    public static final int ACTION_CREATE = 1;
    public static final int ACTION_DEF = 0;
    public static final int ACTION_PRIORITY = 6;
    public static final int ACTION_RESTART = 8;
    public static final int ACTION_RESUME = 2;
    public static final int ACTION_RETRY = 7;
    public static final int ACTION_SAVE = 9;
    public static final int ACTION_STOP = 3;
    public AbsTaskWrapper mTaskWrapper;
    public boolean ignoreCheckPermissions = false;
    public int action = 0;
    public final String TAG = CommonUtil.getClassName((Class) getClass());

    public FeatureController(AbsTaskWrapper absTaskWrapper) {
        this.mTaskWrapper = absTaskWrapper;
    }

    private boolean checkEntity() {
        ICheckEntityUtil newInstance;
        AbsTaskWrapper absTaskWrapper = this.mTaskWrapper;
        if (absTaskWrapper instanceof DTaskWrapper) {
            newInstance = CheckDEntityUtil.newInstance((DTaskWrapper) absTaskWrapper, this.action);
        } else if (!(absTaskWrapper instanceof DGTaskWrapper)) {
            if (absTaskWrapper instanceof UTaskWrapper) {
                newInstance = CheckUEntityUtil.newInstance((UTaskWrapper) absTaskWrapper, this.action);
            }
            newInstance = null;
        } else if (absTaskWrapper.getRequestType() == 4) {
            newInstance = CheckFtpDirEntityUtil.newInstance((DGTaskWrapper) this.mTaskWrapper, this.action);
        } else {
            if (this.mTaskWrapper.getRequestType() == 2) {
                newInstance = CheckDGEntityUtil.newInstance((DGTaskWrapper) this.mTaskWrapper, this.action);
            }
            newInstance = null;
        }
        return newInstance != null && newInstance.checkEntity();
    }

    private boolean checkPermission() {
        String str;
        String str2;
        if (AriaConfig.getInstance().getAPP().checkCallingOrSelfPermission(UMUtils.SD_PERMISSION) != 0) {
            str = this.TAG;
            str2 = "启动失败，缺少权限：Manifest.permission.WRITE_EXTERNAL_STORAGE";
        } else if (AriaConfig.getInstance().getAPP().checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            str = this.TAG;
            str2 = "启动失败，缺少权限：Manifest.permission.INTERNET";
        } else if (AriaConfig.getInstance().getAPP().checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        } else {
            str = this.TAG;
            str2 = "启动失败，缺少权限：Manifest.permission.READ_EXTERNAL_STORAGE";
        }
        ALog.m4191e(str, str2);
        return false;
    }

    public static <T extends FeatureController> T newInstance(Class<T> cls, AbsTaskWrapper absTaskWrapper) {
        if (absTaskWrapper.mo4442getEntity().getId() != -1 || cls == ControllerType.CREATE_CONTROLLER) {
            if (absTaskWrapper.mo4442getEntity().getId() != -1 && cls != ControllerType.TASK_CONTROLLER) {
                throw new IllegalArgumentException("对于已存在的任务，只能使用\" ControllerType.TASK_CONTROLLER\"，请检查是否重复调用#create()方法");
            }
            try {
                return cls.getConstructor(AbsTaskWrapper.class).newInstance(absTaskWrapper);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        throw new IllegalArgumentException("对于不存在的任务（第一次下载），只能使用\"ControllerType.CREATE_CONTROLLER\"");
    }

    public boolean checkConfig() {
        if (this.ignoreCheckPermissions || checkPermission()) {
            boolean checkEntity = checkEntity();
            TaskSchedulers taskSchedulers = TaskSchedulers.getInstance();
            if (!checkEntity && taskSchedulers != null) {
                new Handler(Looper.getMainLooper(), taskSchedulers).obtainMessage(11, checkTaskType(), -1, null).sendToTarget();
            }
            return checkEntity;
        }
        return false;
    }

    public int checkTaskType() {
        AbsTaskWrapper absTaskWrapper = this.mTaskWrapper;
        if (absTaskWrapper instanceof DTaskWrapper) {
            return 1;
        }
        if (absTaskWrapper instanceof DGTaskWrapper) {
            return 3;
        }
        return absTaskWrapper instanceof UTaskWrapper ? 2 : 0;
    }

    public AbsEntity getEntity() {
        return this.mTaskWrapper.mo4442getEntity();
    }

    public AbsTaskWrapper getTaskWrapper() {
        return this.mTaskWrapper;
    }

    public void ignoreCheckPermissions() {
        this.ignoreCheckPermissions = true;
    }

    public void ignoreFilePathOccupy() {
        this.mTaskWrapper.setIgnoreFilePathOccupy(true);
    }

    public void setAction(int i) {
        this.action = i;
    }
}
