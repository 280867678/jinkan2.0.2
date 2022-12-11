package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

/* loaded from: classes3.dex */
public final class AppCompatReceiveContentHelper {
    public static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final String LOG_TAG = "ReceiveContent";

    @RequiresApi(24)
    /* loaded from: classes3.dex */
    public static final class OnDropApi24Impl {
        public static boolean onDropForTextView(@NonNull DragEvent dragEvent, @NonNull TextView textView, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ViewCompat.performReceiveContent(textView, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        public static boolean onDropForView(@NonNull DragEvent dragEvent, @NonNull View view, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
            return true;
        }
    }

    @NonNull
    public static InputConnectionCompat.OnCommitContentListener createOnCommitContentListener(@NonNull final View view) {
        return new InputConnectionCompat.OnCommitContentListener() { // from class: androidx.appcompat.widget.AppCompatReceiveContentHelper.1
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
                if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                    try {
                        inputContentInfoCompat.requestPermission();
                        InputContentInfo inputContentInfo = (InputContentInfo) inputContentInfoCompat.unwrap();
                        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                        bundle.putParcelable(AppCompatReceiveContentHelper.EXTRA_INPUT_CONTENT_INFO, inputContentInfo);
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.getDescription(), new ClipData.Item(inputContentInfoCompat.getContentUri())), 2).setLinkUri(inputContentInfoCompat.getLinkUri()).setExtras(bundle).build()) == null;
            }
        };
    }

    public static boolean maybeHandleDragEventViaPerformReceiveContent(@NonNull View view, @NonNull DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(view) != null) {
            Activity tryGetActivity = tryGetActivity(view);
            if (tryGetActivity == null) {
                String str = "Can't handle drop: no activity: view=" + view;
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    return view instanceof TextView ? OnDropApi24Impl.onDropForTextView(dragEvent, (TextView) view, tryGetActivity) : OnDropApi24Impl.onDropForView(dragEvent, view, tryGetActivity);
                }
            }
        }
        return false;
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(@NonNull TextView textView, int i) {
        int i2 = 0;
        if ((i == 16908322 || i == 16908337) && ViewCompat.getOnReceiveContentMimeTypes(textView) != null) {
            ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
            ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(primaryClip, 1);
                if (i != 16908322) {
                    i2 = 1;
                }
                ViewCompat.performReceiveContent(textView, builder.setFlags(i2).build());
            }
            return true;
        }
        return false;
    }

    @Nullable
    public static Activity tryGetActivity(@NonNull View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
