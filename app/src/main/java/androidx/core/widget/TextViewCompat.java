package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    public static final int LINES = 1;
    public static final String LOG_TAG = "TextViewCompat";
    public static Field sMaxModeField;
    public static boolean sMaxModeFieldFetched;
    public static Field sMaximumField;
    public static boolean sMaximumFieldFetched;
    public static Field sMinModeField;
    public static boolean sMinModeFieldFetched;
    public static Field sMinimumField;
    public static boolean sMinimumFieldFetched;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes3.dex */
    public @interface AutoSizeTextType {
    }

    @RequiresApi(26)
    /* loaded from: classes3.dex */
    public static class OreoCallback implements ActionMode.Callback {
        public static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        public final ActionMode.Callback mCallback;
        public boolean mCanUseMenuBuilderReferences;
        public boolean mInitializedMenuBuilderReferences = false;
        public Class<?> mMenuBuilderClass;
        public Method mMenuBuilderRemoveItemAtMethod;
        public final TextView mTextView;

        public OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.mCallback = callback;
            this.mTextView = textView;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(createProcessTextIntent(), 0)) {
                if (isSupportedActivity(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean isEditable(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean isSupportedActivity(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void recomputeProcessTextMenuItems(Menu menu) {
            Context context = this.mTextView.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.mInitializedMenuBuilderReferences) {
                this.mInitializedMenuBuilderReferences = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.mMenuBuilderClass = cls;
                    this.mMenuBuilderRemoveItemAtMethod = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.mCanUseMenuBuilderReferences = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.mMenuBuilderClass = null;
                    this.mMenuBuilderRemoveItemAtMethod = null;
                    this.mCanUseMenuBuilderReferences = false;
                }
            }
            try {
                Method declaredMethod = (!this.mCanUseMenuBuilderReferences || !this.mMenuBuilderClass.isInstance(menu)) ? menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE) : this.mMenuBuilderRemoveItemAtMethod;
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> supportedActivities = getSupportedActivities(context, packageManager);
                for (int i = 0; i < supportedActivities.size(); i++) {
                    ResolveInfo resolveInfo = supportedActivities.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(createProcessTextIntentForResolveInfo(resolveInfo, this.mTextView)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mCallback.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            recomputeProcessTextMenuItems(menu);
            return this.mCallback.onPrepareActionMode(actionMode, menu);
        }
    }

    public static int getAutoSizeMaxTextSize(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeMaxTextSize();
        }
        if (!(textView instanceof AutoSizeableTextView)) {
            return -1;
        }
        return ((AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
    }

    public static int getAutoSizeMinTextSize(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeMinTextSize();
        }
        if (!(textView instanceof AutoSizeableTextView)) {
            return -1;
        }
        return ((AutoSizeableTextView) textView).getAutoSizeMinTextSize();
    }

    public static int getAutoSizeStepGranularity(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeStepGranularity();
        }
        if (!(textView instanceof AutoSizeableTextView)) {
            return -1;
        }
        return ((AutoSizeableTextView) textView).getAutoSizeStepGranularity();
    }

    @NonNull
    public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView textView) {
        return Build.VERSION.SDK_INT >= 27 ? textView.getAutoSizeTextAvailableSizes() : textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes() : new int[0];
    }

    public static int getAutoSizeTextType(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeTextType();
        }
        if (!(textView instanceof AutoSizeableTextView)) {
            return 0;
        }
        return ((AutoSizeableTextView) textView).getAutoSizeTextType();
    }

    @Nullable
    public static ColorStateList getCompoundDrawableTintList(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return textView.getCompoundDrawableTintList();
        }
        if (!(textView instanceof TintableCompoundDrawablesView)) {
            return null;
        }
        return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintList();
    }

    @Nullable
    public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return textView.getCompoundDrawableTintMode();
        }
        if (!(textView instanceof TintableCompoundDrawablesView)) {
            return null;
        }
        return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintMode();
    }

    @NonNull
    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(@NonNull TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(@NonNull TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(@NonNull TextView textView) {
        return textView.getMaxLines();
    }

    public static int getMinLines(@NonNull TextView textView) {
        return textView.getMinLines();
    }

    @RequiresApi(18)
    public static int getTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    @RequiresApi(18)
    public static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        if (textView.getLayoutDirection() == 1) {
            z = true;
        }
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return z ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    @NonNull
    public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setBreakStrategy(textView.getBreakStrategy());
            builder.setHyphenationFrequency(textView.getHyphenationFrequency());
        }
        builder.setTextDirection(getTextDirectionHeuristic(textView));
        return builder.build();
    }

    public static Field retrieveField(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException unused) {
            return field;
        }
    }

    public static int retrieveIntFromField(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            field.getName();
            return -1;
        }
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView textView, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (!(textView instanceof AutoSizeableTextView)) {
        } else {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView textView, @NonNull int[] iArr, int i) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (!(textView instanceof AutoSizeableTextView)) {
        } else {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeWithDefaults(i);
        } else if (!(textView instanceof AutoSizeableTextView)) {
        } else {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i);
        }
    }

    public static void setCompoundDrawableTintList(@NonNull TextView textView, @Nullable ColorStateList colorStateList) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (!(textView instanceof TintableCompoundDrawablesView)) {
        } else {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void setCompoundDrawableTintMode(@NonNull TextView textView, @Nullable PorterDuff.Mode mode) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (!(textView instanceof TintableCompoundDrawablesView)) {
        } else {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static void setCustomSelectionActionModeCallback(@NonNull TextView textView, @NonNull ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(textView, callback));
    }

    public static void setFirstBaselineToTopHeight(@NonNull TextView textView, @IntRange(from = 0) @AbstractC0047Px int i) {
        Preconditions.checkArgumentNonnegative(i);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i <= Math.abs(i2)) {
            return;
        }
        textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
    }

    public static void setLastBaselineToBottomHeight(@NonNull TextView textView, @IntRange(from = 0) @AbstractC0047Px int i) {
        Preconditions.checkArgumentNonnegative(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void setLineHeight(@NonNull TextView textView, @IntRange(from = 0) @AbstractC0047Px int i) {
        Preconditions.checkArgumentNonnegative(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    public static void setPrecomputedText(@NonNull TextView textView, @NonNull PrecomputedTextCompat precomputedTextCompat) {
        PrecomputedText precomputedText;
        if (Build.VERSION.SDK_INT >= 29) {
            precomputedText = precomputedTextCompat.getPrecomputedText();
        } else {
            boolean equalsWithoutTextDirection = getTextMetricsParams(textView).equalsWithoutTextDirection(precomputedTextCompat.getParams());
            precomputedText = precomputedTextCompat;
            if (!equalsWithoutTextDirection) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
        }
        textView.setText(precomputedText);
    }

    public static void setTextAppearance(@NonNull TextView textView, @StyleRes int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void setTextMetricsParams(@NonNull TextView textView, @NonNull PrecomputedTextCompat.Params params) {
        textView.setTextDirection(getTextDirection(params.getTextDirection()));
        if (Build.VERSION.SDK_INT >= 23) {
            textView.getPaint().set(params.getTextPaint());
            textView.setBreakStrategy(params.getBreakStrategy());
            textView.setHyphenationFrequency(params.getHyphenationFrequency());
            return;
        }
        float textScaleX = params.getTextPaint().getTextScaleX();
        textView.getPaint().set(params.getTextPaint());
        if (textScaleX == textView.getTextScaleX()) {
            textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
        }
        textView.setTextScaleX(textScaleX);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView textView, @NonNull ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof OreoCallback)) ? callback : new OreoCallback(callback, textView);
    }
}
