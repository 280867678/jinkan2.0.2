package com.tencent.smtt.audio.core.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.tbs.common.resources.TBSResources;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsDialogBase.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsDialogBase.class */
public class TbsDialogBase extends Dialog implements View.OnClickListener, DialogInterface {
    public static final String x5_dialog_black_text_color = "x5_dialog_black_text_color";
    public static final String x5_dialog_gray_text_color = "x5_dialog_gray_text_color";
    public static final String x5_dialog_blue_text_color = "x5_dialog_blue_text_color";
    public static final String x5_dialog_red_text_color = "x5_dialog_red_text_color";
    public static final String x5_dialog_line_color = "x5_dialog_line_color";
    public static final String x5_dialog_black_text_night_color = "x5_dialog_black_text_night_color";
    public static final String x5_dialog_gray_text_night_color = "x5_dialog_gray_text_night_color";
    public static final String x5_dialog_blue_text_night_color = "x5_dialog_blue_text_night_color";
    public static final String x5_dialog_red_text_night_color = "x5_dialog_red_text_night_color";
    public static final String x5_dialog_line_night_color = "x5_dialog_line_night_color";
    public static final String x5_dialog_width = "x5_dialog_width";
    public static final String x5_dialog_title_linespace = "x5_dialog_title_linespace";
    public static final String x5_dialog_title_magin_top = "x5_dialog_title_magin_top";
    public static final String x5_dialog_bottom_button_height = "x5_dialog_bottom_button_height";
    public static final String x5_dialog_subtitle_magin_top = "x5_dialog_subtitle_magin_top";
    public static final String x5_dialog_subtitle_magin_bottom = "x5_dialog_subtitle_magin_bottom";
    public static final String x5_dialog_prompt_edittext_magin_top = "x5_dialog_prompt_edittext_magin_top";
    public static final String x5_dialog_prompt_edittext_height = "x5_dialog_prompt_edittext_height";
    public static final String x5_dialog_prompt_edittext_magin_left = "x5_dialog_prompt_edittext_magin_left";
    public static final String x5_dialog_ssl_magin_middle = "x5_dialog_ssl_magin_middle";
    public static final String x5_dialog_ssl_cert_magin_middle = "x5_dialog_ssl_cert_magin_middle";
    public static final String x5_theme_page_inputbox_bkg_normal = "x5_theme_page_inputbox_bkg_normal";
    public static final String x5_tbs_dialog_background = "x5_tbs_dialog_backgroud";
    public static final String x5_tbs_dialog_edittext_background = "x5_tbs_dialog_edittext_background";
    public static final String x5_tbs_dialog_press_background = "x5_tbs_dialog_press_background";
    public static final String x5_tbs_dialog_press_night_background = "x5_tbs_dialog_press_night_background";
    public static final int BTN_ID_POSITIVE = 10000;
    public static final int BTN_ID_NEGATIVE = 10001;
    public static final int BTN_ID_NEUTRAL = 10002;
    public static final int TEXT_BLUE_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_blue_text_color", "color"));
    public static final int TEXT_BLACK_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_black_text_color", "color"));
    public static final int TEXT_GRAY_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_gray_text_color", "color"));
    public static final int TEXT_RED_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_red_text_color", "color"));
    public static final int LINE_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_line_color", "color"));
    public static final int TEXT_BLUE_NIGHT_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_blue_text_night_color", "color"));
    public static final int TEXT_BLACK_NIGHT_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_black_text_night_color", "color"));
    public static final int TEXT_GRAY_NIGHT_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_gray_text_night_color", "color"));
    public static final int TEXT_RED_NIGHT_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_red_text_night_color", "color"));
    public static final int LINE_NIGHT_COLOR = TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_dialog_line_night_color", "color"));
    public static final int DIALOG_WIDTH = TBSResources.getDimensionPixelSize("x5_dialog_width");
    public static final int TITLE_LINE_SPACE = TBSResources.getDimensionPixelSize("x5_dialog_title_linespace");
    public static final int MARGIN_TITLE_TOP = TBSResources.getDimensionPixelSize("x5_dialog_title_magin_top");
    public static final int MARGIN_LEFT = MARGIN_TITLE_TOP / 2;
    public static final int MARGIN_SUBTITLE_TOP = TBSResources.getDimensionPixelSize("x5_dialog_subtitle_magin_top");
    public static final int MARGIN_SUBTITLE_BOTTOM = TBSResources.getDimensionPixelSize("x5_dialog_subtitle_magin_bottom");
    public static final int MARGIN_PROMPT_EDITTEXT_TOP = TBSResources.getDimensionPixelSize("x5_dialog_prompt_edittext_magin_top");
    public static final int MARGIN_PROMPT_EDITTEXT_LEFT = TBSResources.getDimensionPixelSize("x5_dialog_prompt_edittext_magin_left");
    public static final int PROMPT_EDITTEXT_HEIGHT = TBSResources.getDimensionPixelSize("x5_dialog_prompt_edittext_height");
    public static final int BOTTOM_BUTTON_HEIGHT = TBSResources.getDimensionPixelSize("x5_dialog_bottom_button_height");
    public static final int TEXTSIZE_T2 = 14;
    public static final int TEXTSIZE_T3 = 16;
    public static final int TEXTSIZE_T4 = 18;
    public static final int TYPE_ALERT = 0;
    public static final int TYPE_PROMPT = 1;
    public static final int TYPE_CONFIRM = 2;
    public static final int TYPE_THREEBUTTON = 3;
    public static final int NIGHT_MASK_DIALOG_BACKGROUND = 1;
    public static final int NIGHT_MASK_MENU_BACKGROUND = 2;
    public static final int NIGHT_MASK_IMAGE = 3;
    public Context mContext;
    public int mDialogWidth;
    public TextView mTitleTextView;
    public TextView mSubTitleTextView;
    public LinearLayout mRoot;
    public LinearLayout mTitleArea;
    public LinearLayout mContentArea;
    public LinearLayout mCustomArea;
    public LinearLayout mButtonArea;
    public View mBottonLineView;
    public EditText mEditTextView;
    public ScrollView mContentScrollView;
    public int mType;
    public boolean mIsNight;
    public TextView mPositiveBtn = null;
    public TextView mNeutralBtn = null;
    public TextView mNegativeBtn = null;
    public DialogInterface.OnClickListener mPositiveButtonListener = null;
    public DialogInterface.OnClickListener mNegativeButtonListener = null;
    public DialogInterface.OnClickListener mNeutralButtonListener = null;

    public TbsDialogBase(Context context, int type, boolean isNight) {
        super(context);
        this.mIsNight = false;
        this.mContext = context;
        this.mType = type;
        this.mIsNight = isNight;
        init();
    }

    public void init() {
        this.mDialogWidth = DIALOG_WIDTH;
        requestWindowFeature(1);
        Window window = getWindow();
        window.setBackgroundDrawable(getImageDrawable("x5_tbs_dialog_backgroud", this.mIsNight, 1));
        setCanceledOnTouchOutside(false);
        this.mRoot = new DialogRootView(this.mContext);
        LinearLayout.LayoutParams rootParams = new LinearLayout.LayoutParams(-1, -2);
        this.mRoot.setLayoutParams(rootParams);
        this.mRoot.setOrientation(1);
        setContentView(this.mRoot);
        this.mTitleArea = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams titleAreaParams = new LinearLayout.LayoutParams(-1, -2);
        this.mTitleArea.setLayoutParams(titleAreaParams);
        this.mTitleArea.setOrientation(1);
        this.mTitleTextView = creatTextView("", this.mIsNight ? TEXT_BLACK_NIGHT_COLOR : TEXT_BLACK_COLOR, 18, MARGIN_LEFT, this.mType == 1 ? MARGIN_TITLE_TOP / 2 : MARGIN_TITLE_TOP, 17);
        this.mTitleTextView.setLineSpacing(TITLE_LINE_SPACE, 1.0f);
        this.mTitleArea.addView(this.mTitleTextView);
        this.mRoot.addView(this.mTitleArea);
        this.mCustomArea = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams customAreaParams = new LinearLayout.LayoutParams(-1, -2);
        this.mCustomArea.setLayoutParams(customAreaParams);
        this.mCustomArea.setOrientation(1);
        this.mRoot.addView(this.mCustomArea);
        this.mContentScrollView = new ScrollView(this.mContext);
        LinearLayout.LayoutParams contentScrollViewParams = new LinearLayout.LayoutParams(-1, -2);
        contentScrollViewParams.gravity = 16;
        this.mContentScrollView.setLayoutParams(contentScrollViewParams);
        this.mRoot.addView(this.mContentScrollView);
        this.mContentArea = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams contentAreaParams = new LinearLayout.LayoutParams(-1, -2);
        this.mContentArea.setLayoutParams(contentAreaParams);
        this.mContentArea.setOrientation(1);
        this.mContentScrollView.addView(this.mContentArea);
        if (this.mType == 1) {
            this.mEditTextView = creatEditTextView();
            this.mContentArea.addView(this.mEditTextView);
            this.mContentArea.setFocusable(true);
            this.mContentArea.setFocusableInTouchMode(true);
        }
        this.mButtonArea = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams buttonAreaParams = new LinearLayout.LayoutParams(-1, -2);
        this.mButtonArea.setLayoutParams(buttonAreaParams);
        this.mButtonArea.setOrientation(1);
        this.mRoot.addView(this.mButtonArea);
        this.mBottonLineView = creatLine(this.mIsNight ? LINE_NIGHT_COLOR : LINE_COLOR, false, getDefaultButtonMarginTop());
        this.mButtonArea.addView(this.mBottonLineView);
        LinearLayout buttonWrapper = new LinearLayout(this.mContext);
        if (this.mType != 3) {
            LinearLayout.LayoutParams bottomParams = new LinearLayout.LayoutParams(-1, BOTTOM_BUTTON_HEIGHT);
            buttonWrapper.setOrientation(0);
            buttonWrapper.setLayoutParams(bottomParams);
        } else {
            LinearLayout.LayoutParams bottomParams2 = new LinearLayout.LayoutParams(-1, BOTTOM_BUTTON_HEIGHT * 3);
            buttonWrapper.setOrientation(1);
            buttonWrapper.setLayoutParams(bottomParams2);
        }
        this.mButtonArea.addView(buttonWrapper);
        if (this.mType == 3) {
            this.mNeutralBtn = creatButton("", 18, this.mIsNight ? TEXT_RED_NIGHT_COLOR : TEXT_RED_COLOR, 10002);
            buttonWrapper.addView(this.mNeutralBtn);
            buttonWrapper.addView(creatLine(this.mIsNight ? LINE_NIGHT_COLOR : LINE_COLOR, false, 0));
            this.mPositiveBtn = creatButton("", 18, this.mIsNight ? TEXT_BLUE_NIGHT_COLOR : TEXT_BLUE_COLOR, 10000);
            buttonWrapper.addView(this.mPositiveBtn);
            buttonWrapper.addView(creatLine(this.mIsNight ? LINE_NIGHT_COLOR : LINE_COLOR, false, 0));
            this.mNegativeBtn = creatButton("", 18, this.mIsNight ? TEXT_BLACK_NIGHT_COLOR : TEXT_BLACK_COLOR, 10001);
            buttonWrapper.addView(this.mNegativeBtn);
            return;
        }
        if (this.mType != 0) {
            this.mNegativeBtn = creatButton("", 18, this.mIsNight ? TEXT_BLACK_NIGHT_COLOR : TEXT_BLACK_COLOR, 10001);
            buttonWrapper.addView(this.mNegativeBtn);
            buttonWrapper.addView(creatLine(this.mIsNight ? LINE_NIGHT_COLOR : LINE_COLOR, true, 0));
        }
        this.mPositiveBtn = creatButton("", 18, this.mIsNight ? TEXT_BLUE_NIGHT_COLOR : TEXT_BLUE_COLOR, 10000);
        buttonWrapper.addView(this.mPositiveBtn);
    }

    public TextView creatButton(String text, int size, int color, int id) {
        TextView button = new TextView(this.mContext);
        button.setTextSize(size);
        button.setTextColor(color);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        button.setText(text);
        button.setFocusable(true);
        button.setId(id);
        if (this.mIsNight) {
            setViewBackground(button, TBSResources.getResources().getDrawable(TBSResources.loadIdentifierResource("x5_tbs_dialog_press_night_background", "drawable")));
        } else {
            setViewBackground(button, TBSResources.getResources().getDrawable(TBSResources.loadIdentifierResource("x5_tbs_dialog_press_background", "drawable")));
        }
        button.setGravity(17);
        return button;
    }

    public View creatLine(int color, boolean isVertical, int topMargin) {
        LinearLayout.LayoutParams lineParams;
        View line = new View(this.mContext);
        if (isVertical) {
            lineParams = new LinearLayout.LayoutParams(1, -1);
        } else {
            lineParams = new LinearLayout.LayoutParams(-1, 1);
        }
        lineParams.topMargin = topMargin;
        line.setLayoutParams(lineParams);
        line.setBackgroundColor(color);
        return line;
    }

    public TextView creatTextView(CharSequence content, int textColor, int textFontSize, int marginLeft, int marginTop, int gravity) {
        TextView text = new TextView(this.mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        params.setMargins(marginLeft, marginTop, marginLeft, 0);
        text.setLayoutParams(params);
        text.setTextColor(textColor);
        text.setTextSize(textFontSize);
        text.setGravity(gravity);
        text.setText(content);
        return text;
    }

    public EditText creatEditTextView() {
        EditText editText = new EditText(this.mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, PROMPT_EDITTEXT_HEIGHT);
        params.setMargins(MARGIN_PROMPT_EDITTEXT_LEFT, MARGIN_PROMPT_EDITTEXT_TOP, MARGIN_PROMPT_EDITTEXT_LEFT, 0);
        editText.setLayoutParams(params);
        editText.setTextSize(16.0f);
        editText.setTextColor(this.mIsNight ? TEXT_BLACK_NIGHT_COLOR : TEXT_BLACK_COLOR);
        editText.setSingleLine(true);
        editText.setHorizontallyScrolling(true);
        setViewBackground(editText, getImageDrawable("x5_tbs_dialog_edittext_background", this.mIsNight, 3));
        return editText;
    }

    public void setTitleText(CharSequence text) {
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(text);
        }
    }

    public void setTitleTextGravity(int gravity) {
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setGravity(gravity);
        }
    }

    public void setTitleMargin(int topMargin, int bottomMargin) {
        if (this.mTitleTextView != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.mTitleTextView.getLayoutParams();
            params.topMargin = topMargin;
            params.bottomMargin = bottomMargin;
            this.mTitleTextView.setLayoutParams(params);
        }
    }

    public void setSubTitleText(String text) {
        if (this.mSubTitleTextView != null) {
            this.mSubTitleTextView.setText(text);
        }
    }

    public void addSubTitle(CharSequence text) {
        this.mSubTitleTextView = creatTextView(text, this.mIsNight ? TEXT_GRAY_NIGHT_COLOR : TEXT_GRAY_COLOR, 14, MARGIN_LEFT, MARGIN_SUBTITLE_TOP, 17);
        this.mContentArea.addView(this.mSubTitleTextView, 0);
        if (this.mBottonLineView != null && this.mType == 3) {
            setBottomButtonMarginTop(MARGIN_SUBTITLE_BOTTOM);
        }
    }

    public void setEditTextViewText(CharSequence text) {
        if (this.mEditTextView != null) {
            this.mEditTextView.setText(text);
            this.mEditTextView.clearFocus();
        }
    }

    public String getEditTextViewText() {
        if (this.mEditTextView != null) {
            return this.mEditTextView.getText().toString();
        }
        return null;
    }

    public void addToCustomArea(View view) {
        if (this.mCustomArea != null) {
            this.mCustomArea.addView(view);
        }
    }

    public void addToContentArea(View view) {
        if (this.mContentArea != null) {
            this.mContentArea.addView(view);
        }
    }

    public void addToContentArea(String content, int textColor, int textFontSize, int marginLeft, int marginTop, int gravity) {
        if (this.mContentArea != null) {
            this.mContentArea.addView(creatTextView(content, textColor, textFontSize, marginLeft, marginTop, gravity));
        }
    }

    public void removeContents() {
        if (this.mContentArea != null) {
            this.mContentArea.removeAllViews();
        }
    }

    public void setBottomButtonMarginTop(int margin) {
        if (this.mBottonLineView != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.mBottonLineView.getLayoutParams();
            params.topMargin = margin;
            this.mBottonLineView.setLayoutParams(params);
        }
    }

    public int getDefaultButtonMarginTop() {
        switch (this.mType) {
            case 0:
            case 2:
            case 3:
                return MARGIN_TITLE_TOP;
            case 1:
                return MARGIN_PROMPT_EDITTEXT_TOP;
            default:
                return 0;
        }
    }

    public static Drawable getImageDrawable(String name, boolean isNight, int maskType) {
        int mask;
        Drawable drawable = NinePatchUtils.createNinePatchDrawable(TBSResources.getResourceContext(), name);
        if (drawable != null && isNight) {
            switch (maskType) {
                case 1:
                case 2:
                    mask = -14012362;
                    break;
                default:
                    mask = 1879048192;
                    break;
            }
            drawable.setColorFilter(mask, PorterDuff.Mode.SRC_ATOP);
        }
        return drawable;
    }

    public static void setViewBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View button) {
        switch (button.getId()) {
            case 10000:
                if (this.mPositiveButtonListener != null) {
                    this.mPositiveButtonListener.onClick(this, -1);
                    break;
                }
                break;
            case 10001:
                if (this.mNegativeButtonListener != null) {
                    this.mNegativeButtonListener.onClick(this, -2);
                    break;
                }
                break;
            case 10002:
                if (this.mNeutralButtonListener != null) {
                    this.mNeutralButtonListener.onClick(this, -3);
                    break;
                }
                break;
        }
        if (button.getId() >= 10000 && button.getId() <= 10002) {
            dismiss();
        }
    }

    public void setButton(int id, CharSequence text, int color, DialogInterface.OnClickListener listener) {
        setButton(id, text, listener);
        switch (id) {
            case 10000:
                if (this.mPositiveBtn != null) {
                    this.mPositiveBtn.setTextColor(color);
                    return;
                }
                return;
            case 10001:
                if (this.mNegativeBtn != null) {
                    this.mNegativeBtn.setTextColor(color);
                    return;
                }
                return;
            case 10002:
                if (this.mNeutralBtn != null) {
                    this.mNeutralBtn.setTextColor(color);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setButton(int id, CharSequence text, DialogInterface.OnClickListener listener) {
        switch (id) {
            case 10000:
                if (this.mPositiveBtn != null) {
                    this.mPositiveBtn.setText(text);
                    this.mPositiveBtn.setOnClickListener(this);
                    this.mPositiveButtonListener = listener;
                    return;
                }
                return;
            case 10001:
                if (this.mNegativeBtn != null) {
                    this.mNegativeBtn.setText(text);
                    this.mNegativeBtn.setOnClickListener(this);
                    this.mNegativeButtonListener = listener;
                    return;
                }
                return;
            case 10002:
                if (this.mNeutralBtn != null) {
                    this.mNeutralBtn.setText(text);
                    this.mNeutralBtn.setOnClickListener(this);
                    this.mNeutralButtonListener = listener;
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setLayout(this.mDialogWidth, -2);
        super.show();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsDialogBase$DialogRootView.class
 */
    /* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsDialogBase$DialogRootView.class */
    public class DialogRootView extends LinearLayout {
        public DialogRootView(Context context) {
            super(context);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int measureHeight;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (TbsDialogBase.this.mTitleArea != null && TbsDialogBase.this.mCustomArea != null && TbsDialogBase.this.mContentArea != null && TbsDialogBase.this.mButtonArea != null && TbsDialogBase.this.mContentScrollView != null) {
                int rootHeight = getMeasuredHeight();
                int parentHeight = View.MeasureSpec.getSize(heightMeasureSpec);
                int childHeight = View.MeasureSpec.makeMeasureSpec(parentHeight, 0);
                TbsDialogBase.this.mTitleArea.measure(widthMeasureSpec, childHeight);
                TbsDialogBase.this.mCustomArea.measure(widthMeasureSpec, childHeight);
                TbsDialogBase.this.mContentArea.measure(widthMeasureSpec, childHeight);
                TbsDialogBase.this.mButtonArea.measure(widthMeasureSpec, childHeight);
                int totalHeight = TbsDialogBase.this.mTitleArea.getMeasuredHeight() + TbsDialogBase.this.mCustomArea.getMeasuredHeight() + TbsDialogBase.this.mContentArea.getMeasuredHeight() + TbsDialogBase.this.mButtonArea.getMeasuredHeight();
                if (totalHeight > rootHeight && totalHeight > parentHeight) {
                    measureHeight = rootHeight;
                    TbsDialogBase.this.mContentScrollView.getLayoutParams().height = ((rootHeight - TbsDialogBase.this.mTitleArea.getMeasuredHeight()) - TbsDialogBase.this.mCustomArea.getMeasuredHeight()) - TbsDialogBase.this.mButtonArea.getMeasuredHeight();
                } else {
                    measureHeight = totalHeight;
                    TbsDialogBase.this.mContentScrollView.getLayoutParams().height = -2;
                }
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(measureHeight, Integer.MIN_VALUE));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsDialogBase$Builder.class
 */
    /* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsDialogBase$Builder.class */
    public static class Builder {
        private TbsDialogBase mDialog;

        public Builder(Context context, int type, boolean isNight) {
            this.mDialog = new TbsDialogBase(context, type, isNight);
        }

        public Builder setTitle(String title) {
            this.mDialog.setTitleText(title);
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.mDialog.addSubTitle(message);
            return this;
        }

        public Builder setEditText(CharSequence message) {
            this.mDialog.setEditTextViewText(message);
            return this;
        }

        public String getEditText() {
            return this.mDialog.getEditTextViewText();
        }

        public Builder setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.mDialog.setButton(10001, text, listener);
            return this;
        }

        public Builder setNegativeButton(CharSequence text, int color, DialogInterface.OnClickListener listener) {
            this.mDialog.setButton(10001, text, color, listener);
            return this;
        }

        public Builder setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.mDialog.setButton(10000, text, listener);
            return this;
        }

        public Builder setPositiveButton(CharSequence text, int color, DialogInterface.OnClickListener listener) {
            this.mDialog.setButton(10000, text, color, listener);
            return this;
        }

        public Builder setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.mDialog.setButton(10002, text, listener);
            return this;
        }

        public Builder setNeutralButton(CharSequence text, int color, DialogInterface.OnClickListener listener) {
            this.mDialog.setButton(10002, text, color, listener);
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mDialog.setOnCancelListener(onCancelListener);
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mDialog.setOnDismissListener(onDismissListener);
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.mDialog.setCancelable(cancelable);
            return this;
        }

        public void dismiss() {
            this.mDialog.dismiss();
            this.mDialog = null;
        }

        public Builder show() {
            this.mDialog.show();
            return this;
        }

        public Builder create() {
            return this;
        }
    }
}
