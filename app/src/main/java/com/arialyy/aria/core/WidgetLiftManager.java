package com.arialyy.aria.core;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Message;
import android.widget.PopupWindow;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public final class WidgetLiftManager {
    public final String TAG = "WidgetLiftManager";

    private DialogInterface.OnCancelListener createCancelListener() {
        return new DialogInterface.OnCancelListener() { // from class: com.arialyy.aria.core.WidgetLiftManager.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AriaManager.getInstance().removeReceiver(dialogInterface);
            }
        };
    }

    private DialogInterface.OnDismissListener createDismissListener() {
        return new DialogInterface.OnDismissListener() { // from class: com.arialyy.aria.core.WidgetLiftManager.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AriaManager.getInstance().removeReceiver(dialogInterface);
            }
        };
    }

    private PopupWindow.OnDismissListener createPopupWindowListener(final PopupWindow popupWindow) {
        return new PopupWindow.OnDismissListener() { // from class: com.arialyy.aria.core.WidgetLiftManager.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AriaManager.getInstance().removeReceiver(popupWindow);
            }
        };
    }

    @TargetApi(11)
    public boolean handleDialogFragmentLift(Dialog dialog) {
        return handleDialogLift(dialog);
    }

    public boolean handleDialogLift(Dialog dialog) {
        if (dialog == null) {
            ALog.m4185w("WidgetLiftManager", "dialog 为空，没有设置自动销毁事件，为了防止内存泄露，请在dismiss方法中调用Aria.download(this).unRegister();来注销事件\n如果你使用的是DialogFragment，那么你需要在onDestroy()中进行销毁Aria事件操作");
            return false;
        }
        try {
            if (((Message) CommonUtil.getField(dialog.getClass(), "mDismissMessage").get(dialog)) == null) {
                dialog.setOnDismissListener(createDismissListener());
            } else if (((Message) CommonUtil.getField(dialog.getClass(), "mCancelMessage").get(dialog)) != null) {
                ALog.m4191e("WidgetLiftManager", "你已经对Dialog设置了Dismiss和cancel事件。为了防止内存泄露，请在dismiss方法中调用Aria.download(this).unRegister();来注销事件\n如果你使用的是DialogFragment，那么你需要在onDestroy()中进行销毁Aria事件操作");
                return true;
            } else {
                dialog.setOnCancelListener(createCancelListener());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean handlePopupWindowLift(PopupWindow popupWindow) {
        try {
            if (((PopupWindow.OnDismissListener) CommonUtil.getField(popupWindow.getClass(), "mOnDismissListener").get(popupWindow)) != null) {
                ALog.m4191e("WidgetLiftManager", "你已经对PopupWindow设置了Dismiss事件。为了防止内存泄露，请在dismiss方法中调用Aria.download(this).unRegister();来注销事件");
                return true;
            }
            popupWindow.setOnDismissListener(createPopupWindowListener(popupWindow));
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
