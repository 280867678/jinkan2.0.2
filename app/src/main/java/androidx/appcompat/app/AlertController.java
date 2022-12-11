package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.C0049R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class AlertController {
    public ListAdapter mAdapter;
    public int mAlertDialogLayout;
    public final int mButtonIconDimen;
    public Button mButtonNegative;
    public Drawable mButtonNegativeIcon;
    public Message mButtonNegativeMessage;
    public CharSequence mButtonNegativeText;
    public Button mButtonNeutral;
    public Drawable mButtonNeutralIcon;
    public Message mButtonNeutralMessage;
    public CharSequence mButtonNeutralText;
    public int mButtonPanelSideLayout;
    public Button mButtonPositive;
    public Drawable mButtonPositiveIcon;
    public Message mButtonPositiveMessage;
    public CharSequence mButtonPositiveText;
    public final Context mContext;
    public View mCustomTitleView;
    public final AppCompatDialog mDialog;
    public Handler mHandler;
    public Drawable mIcon;
    public ImageView mIconView;
    public int mListItemLayout;
    public int mListLayout;
    public ListView mListView;
    public CharSequence mMessage;
    public TextView mMessageView;
    public int mMultiChoiceItemLayout;
    public NestedScrollView mScrollView;
    public boolean mShowTitle;
    public int mSingleChoiceItemLayout;
    public CharSequence mTitle;
    public TextView mTitleView;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public int mViewSpacingTop;
    public final Window mWindow;
    public boolean mViewSpacingSpecified = false;
    public int mIconId = 0;
    public int mCheckedItem = -1;
    public int mButtonPanelLayoutHint = 0;
    public final View.OnClickListener mButtonHandler = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            AlertController alertController = AlertController.this;
            if (view != alertController.mButtonPositive || (message2 = alertController.mButtonPositiveMessage) == null) {
                AlertController alertController2 = AlertController.this;
                if (view != alertController2.mButtonNegative || (message2 = alertController2.mButtonNegativeMessage) == null) {
                    AlertController alertController3 = AlertController.this;
                    obtain = (view != alertController3.mButtonNeutral || (message = alertController3.mButtonNeutralMessage) == null) ? null : Message.obtain(message);
                    if (obtain != null) {
                        obtain.sendToTarget();
                    }
                    AlertController alertController4 = AlertController.this;
                    alertController4.mHandler.obtainMessage(1, alertController4.mDialog).sendToTarget();
                }
            }
            obtain = Message.obtain(message2);
            if (obtain != null) {
            }
            AlertController alertController42 = AlertController.this;
            alertController42.mHandler.obtainMessage(1, alertController42.mDialog).sendToTarget();
        }
    };

    /* loaded from: classes3.dex */
    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public int mViewSpacingTop;
        public int mIconId = 0;
        public int mIconAttrId = 0;
        public boolean mViewSpacingSpecified = false;
        public int mCheckedItem = -1;
        public boolean mRecycleOnMeasure = true;
        public boolean mCancelable = true;

        /* loaded from: classes3.dex */
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void createListView(final AlertController alertController) {
            ListAdapter listAdapter;
            AdapterView.OnItemClickListener onItemClickListener;
            AdapterView.OnItemSelectedListener onItemSelectedListener;
            final RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                listAdapter = this.mCursor == null ? new ArrayAdapter<CharSequence>(this.mContext, alertController.mMultiChoiceItemLayout, 16908308, this.mItems) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null && zArr[i]) {
                            recycleListView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                } : new CursorAdapter(this.mContext, this.mCursor, false) { // from class: androidx.appcompat.app.AlertController.AlertParams.2
                    public final int mIsCheckedIndex;
                    public final int mLabelIndex;

                    {
                        Cursor cursor = getCursor();
                        this.mLabelIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                        this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                    }

                    @Override // android.widget.CursorAdapter
                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.mLabelIndex));
                        RecycleListView recycleListView2 = recycleListView;
                        int position = cursor.getPosition();
                        boolean z = true;
                        if (cursor.getInt(this.mIsCheckedIndex) != 1) {
                            z = false;
                        }
                        recycleListView2.setItemChecked(position, z);
                    }

                    @Override // android.widget.CursorAdapter
                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return AlertParams.this.mInflater.inflate(alertController.mMultiChoiceItemLayout, viewGroup, false);
                    }
                };
            } else {
                int i = this.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
                if (this.mCursor != null) {
                    listAdapter = new SimpleCursorAdapter(this.mContext, i, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
                } else {
                    listAdapter = this.mAdapter;
                    if (listAdapter == null) {
                        listAdapter = new CheckedItemAdapter(this.mContext, i, 16908308, this.mItems);
                    }
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView);
            }
            alertController.mAdapter = listAdapter;
            alertController.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener == null) {
                if (this.mOnCheckboxClickListener != null) {
                    onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                            boolean[] zArr = AlertParams.this.mCheckedItems;
                            if (zArr != null) {
                                zArr[i2] = recycleListView.isItemChecked(i2);
                            }
                            AlertParams.this.mOnCheckboxClickListener.onClick(alertController.mDialog, i2, recycleListView.isItemChecked(i2));
                        }
                    };
                }
                onItemSelectedListener = this.mOnItemSelectedListener;
                if (onItemSelectedListener != null) {
                    recycleListView.setOnItemSelectedListener(onItemSelectedListener);
                }
                if (!this.mIsSingleChoice) {
                    recycleListView.setChoiceMode(1);
                } else if (this.mIsMultiChoice) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.mListView = recycleListView;
            }
            onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AlertParams.this.mOnClickListener.onClick(alertController.mDialog, i2);
                    if (!AlertParams.this.mIsSingleChoice) {
                        alertController.mDialog.dismiss();
                    }
                }
            };
            recycleListView.setOnItemClickListener(onItemClickListener);
            onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
            }
            if (!this.mIsSingleChoice) {
            }
            alertController.mListView = recycleListView;
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i = this.mIconId;
                if (i != 0) {
                    alertController.setIcon(i);
                }
                int i2 = this.mIconAttrId;
                if (i2 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i2));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            if (this.mPositiveButtonText != null || this.mPositiveButtonIcon != null) {
                alertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
            }
            if (this.mNegativeButtonText != null || this.mNegativeButtonIcon != null) {
                alertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }
            if (this.mNeutralButtonText != null || this.mNeutralButtonIcon != null) {
                alertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                createListView(alertController);
            }
            View view2 = this.mView;
            if (view2 != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                } else {
                    alertController.setView(view2);
                    return;
                }
            }
            int i3 = this.mViewLayoutResId;
            if (i3 == 0) {
                return;
            }
            alertController.setView(i3);
        }
    }

    /* loaded from: classes3.dex */
    public static final class ButtonHandler extends Handler {
        public static final int MSG_DISMISS_DIALOG = 1;
        public WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
            } else if (i != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class RecycleListView extends ListView {
        public final int mPaddingBottomNoButtons;
        public final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(C0049R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(C0049R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
            }
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0049R.styleable.AlertDialog, C0049R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(C0049R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(C0049R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(C0049R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(C0049R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(C0049R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(C0049R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = obtainStyledAttributes.getBoolean(C0049R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = obtainStyledAttributes.getDimensionPixelSize(C0049R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    public static boolean canTextInput(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (canTextInput(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static void manageScrollIndicators(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int selectContentView() {
        int i = this.mButtonPanelSideLayout;
        return (i != 0 && this.mButtonPanelLayoutHint == 1) ? i : this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.mWindow.findViewById(C0049R.C0052id.scrollIndicatorUp);
        final View findViewById2 = this.mWindow.findViewById(C0049R.C0052id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 == null) {
                return;
            }
        } else {
            if (findViewById != null && (i & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById == null && findViewById2 == null) {
                return;
            }
            if (this.mMessage != null) {
                this.mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.appcompat.app.AlertController.2
                    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                    public void onScrollChange(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                        AlertController.manageScrollIndicators(nestedScrollView, findViewById, findViewById2);
                    }
                });
                this.mScrollView.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.manageScrollIndicators(AlertController.this.mScrollView, findViewById, findViewById2);
                    }
                });
                return;
            }
            ListView listView = this.mListView;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                        AlertController.manageScrollIndicators(absListView, findViewById, findViewById2);
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i3) {
                    }
                });
                this.mListView.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.manageScrollIndicators(AlertController.this.mListView, findViewById, findViewById2);
                    }
                });
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 == null) {
                return;
            }
        }
        viewGroup.removeView(findViewById2);
    }

    private void setupButtons(ViewGroup viewGroup) {
        boolean z;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(16908313);
        this.mButtonPositive = button2;
        button2.setOnClickListener(this.mButtonHandler);
        boolean z2 = true;
        if (!TextUtils.isEmpty(this.mButtonPositiveText) || this.mButtonPositiveIcon != null) {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            Drawable drawable = this.mButtonPositiveIcon;
            if (drawable != null) {
                int i = this.mButtonIconDimen;
                drawable.setBounds(0, 0, i, i);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonPositive.setVisibility(0);
            z = true;
        } else {
            this.mButtonPositive.setVisibility(8);
            z = false;
        }
        Button button3 = (Button) viewGroup.findViewById(16908314);
        this.mButtonNegative = button3;
        button3.setOnClickListener(this.mButtonHandler);
        if (!TextUtils.isEmpty(this.mButtonNegativeText) || this.mButtonNegativeIcon != null) {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            Drawable drawable2 = this.mButtonNegativeIcon;
            if (drawable2 != null) {
                int i2 = this.mButtonIconDimen;
                drawable2.setBounds(0, 0, i2, i2);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
            }
            this.mButtonNegative.setVisibility(0);
            z |= true;
        } else {
            this.mButtonNegative.setVisibility(8);
        }
        Button button4 = (Button) viewGroup.findViewById(16908315);
        this.mButtonNeutral = button4;
        button4.setOnClickListener(this.mButtonHandler);
        if (!TextUtils.isEmpty(this.mButtonNeutralText) || this.mButtonNeutralIcon != null) {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            Drawable drawable3 = this.mButtonNeutralIcon;
            if (drawable3 != null) {
                int i3 = this.mButtonIconDimen;
                drawable3.setBounds(0, 0, i3, i3);
                this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
            }
            this.mButtonNeutral.setVisibility(0);
            z |= true;
        } else {
            this.mButtonNeutral.setVisibility(8);
        }
        if (shouldCenterSingleButton(this.mContext)) {
            if (z) {
                button = this.mButtonPositive;
            } else if (z) {
                button = this.mButtonNegative;
            } else if (z) {
                button = this.mButtonNeutral;
            }
            centerButton(button);
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.mWindow.findViewById(C0049R.C0052id.scrollView);
        this.mScrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.mMessageView = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.mScrollView.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.mScrollView);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        View view = this.mView;
        boolean z = false;
        if (view == null) {
            view = this.mViewLayoutResId != 0 ? LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !canTextInput(view)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(C0049R.C0052id.custom);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified) {
            frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
        }
        if (this.mListView == null) {
            return;
        }
        ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            this.mWindow.findViewById(C0049R.C0052id.title_template).setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.mWindow.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.mTitle)) || !this.mShowTitle) {
            this.mWindow.findViewById(C0049R.C0052id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.mWindow.findViewById(C0049R.C0052id.alertTitle);
        this.mTitleView = textView;
        textView.setText(this.mTitle);
        int i = this.mIconId;
        if (i != 0) {
            this.mIconView.setImageResource(i);
            return;
        }
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
            return;
        }
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    private void setupView() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2 = this.mWindow.findViewById(C0049R.C0052id.parentPanel);
        View findViewById3 = findViewById2.findViewById(C0049R.C0052id.topPanel);
        View findViewById4 = findViewById2.findViewById(C0049R.C0052id.contentPanel);
        View findViewById5 = findViewById2.findViewById(C0049R.C0052id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(C0049R.C0052id.customPanel);
        setupCustomContent(viewGroup);
        View findViewById6 = viewGroup.findViewById(C0049R.C0052id.topPanel);
        View findViewById7 = viewGroup.findViewById(C0049R.C0052id.contentPanel);
        View findViewById8 = viewGroup.findViewById(C0049R.C0052id.buttonPanel);
        ViewGroup resolvePanel = resolvePanel(findViewById6, findViewById3);
        ViewGroup resolvePanel2 = resolvePanel(findViewById7, findViewById4);
        ViewGroup resolvePanel3 = resolvePanel(findViewById8, findViewById5);
        setupContent(resolvePanel2);
        setupButtons(resolvePanel3);
        setupTitle(resolvePanel);
        int i = 0;
        boolean z = viewGroup.getVisibility() != 8;
        boolean z2 = (resolvePanel == null || resolvePanel.getVisibility() == 8) ? false : true;
        boolean z3 = resolvePanel3.getVisibility() != 8;
        if (!z3 && (findViewById = resolvePanel2.findViewById(C0049R.C0052id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.mScrollView;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (this.mMessage != null || this.mListView != null) {
                view = resolvePanel.findViewById(C0049R.C0052id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View findViewById9 = resolvePanel2.findViewById(C0049R.C0052id.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        ListView listView = this.mListView;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            View view2 = this.mListView;
            if (view2 == null) {
                view2 = this.mScrollView;
            }
            if (view2 != null) {
                if (z3) {
                    i = 2;
                }
                int i2 = z2 ? 1 : 0;
                char c = z2 ? 1 : 0;
                setScrollIndicators(resolvePanel2, view2, i2 | i, 3);
            }
        }
        ListView listView2 = this.mListView;
        if (listView2 == null || (listAdapter = this.mAdapter) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i3 = this.mCheckedItem;
        if (i3 <= -1) {
            return;
        }
        listView2.setItemChecked(i3, true);
        listView2.setSelection(i3);
    }

    public static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0049R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public Button getButton(int i) {
        if (i != -3) {
            if (i == -2) {
                return this.mButtonNegative;
            }
            if (i == -1) {
                return this.mButtonPositive;
            }
            return null;
        }
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        this.mDialog.setContentView(selectContentView());
        setupView();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message;
            this.mButtonNeutralIcon = drawable;
        } else if (i == -2) {
            this.mButtonNegativeText = charSequence;
            this.mButtonNegativeMessage = message;
            this.mButtonNegativeIcon = drawable;
        } else if (i != -1) {
            throw new IllegalArgumentException("Button does not exist");
        } else {
            this.mButtonPositiveText = charSequence;
            this.mButtonPositiveMessage = message;
            this.mButtonPositiveIcon = drawable;
        }
    }

    public void setButtonPanelLayoutHint(int i) {
        this.mButtonPanelLayoutHint = i;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int i) {
        this.mIcon = null;
        this.mIconId = i;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            this.mIconView.setImageResource(this.mIconId);
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            this.mIconView.setImageDrawable(drawable);
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int i) {
        this.mView = null;
        this.mViewLayoutResId = i;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i;
        this.mViewSpacingTop = i2;
        this.mViewSpacingRight = i3;
        this.mViewSpacingBottom = i4;
    }
}
