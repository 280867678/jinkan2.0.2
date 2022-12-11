package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public BackStackState mo4325createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public BackStackState[] mo4326newArray(int i) {
            return new BackStackState[i];
        }
    };
    public static final String TAG = "FragmentManager";
    public final int mBreadCrumbShortTitleRes;
    public final CharSequence mBreadCrumbShortTitleText;
    public final int mBreadCrumbTitleRes;
    public final CharSequence mBreadCrumbTitleText;
    public final int[] mCurrentMaxLifecycleStates;
    public final ArrayList<String> mFragmentWhos;
    public final int mIndex;
    public final String mName;
    public final int[] mOldMaxLifecycleStates;
    public final int[] mOps;
    public final boolean mReorderingAllowed;
    public final ArrayList<String> mSharedElementSourceNames;
    public final ArrayList<String> mSharedElementTargetNames;
    public final int mTransition;

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 5];
        if (backStackRecord.mAddToBackStack) {
            this.mFragmentWhos = new ArrayList<>(size);
            this.mOldMaxLifecycleStates = new int[size];
            this.mCurrentMaxLifecycleStates = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                FragmentTransaction.C0354Op c0354Op = backStackRecord.mOps.get(i);
                int i3 = i2 + 1;
                this.mOps[i2] = c0354Op.mCmd;
                ArrayList<String> arrayList = this.mFragmentWhos;
                Fragment fragment = c0354Op.mFragment;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.mOps;
                int i4 = i3 + 1;
                iArr[i3] = c0354Op.mEnterAnim;
                int i5 = i4 + 1;
                iArr[i4] = c0354Op.mExitAnim;
                int i6 = i5 + 1;
                iArr[i5] = c0354Op.mPopEnterAnim;
                iArr[i6] = c0354Op.mPopExitAnim;
                this.mOldMaxLifecycleStates[i] = c0354Op.mOldMaxState.ordinal();
                this.mCurrentMaxLifecycleStates[i] = c0354Op.mCurrentMaxState.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.mTransition = backStackRecord.mTransition;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        int i = 0;
        int i2 = 0;
        while (i < this.mOps.length) {
            FragmentTransaction.C0354Op c0354Op = new FragmentTransaction.C0354Op();
            int i3 = i + 1;
            c0354Op.mCmd = this.mOps[i];
            if (FragmentManager.isLoggingEnabled(2)) {
                String str = "Instantiate " + backStackRecord + " op #" + i2 + " base fragment #" + this.mOps[i3];
            }
            String str2 = this.mFragmentWhos.get(i2);
            c0354Op.mFragment = str2 != null ? fragmentManager.findActiveFragment(str2) : null;
            c0354Op.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i2]];
            c0354Op.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i2]];
            int[] iArr = this.mOps;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            c0354Op.mEnterAnim = i5;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            c0354Op.mExitAnim = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            c0354Op.mPopEnterAnim = i9;
            int i10 = iArr[i8];
            c0354Op.mPopExitAnim = i10;
            backStackRecord.mEnterAnim = i5;
            backStackRecord.mExitAnim = i7;
            backStackRecord.mPopEnterAnim = i9;
            backStackRecord.mPopExitAnim = i10;
            backStackRecord.addOp(c0354Op);
            i2++;
            i = i8 + 1;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
