package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
import me.tvspark.outline;
import okhttp3.internal.cache.DiskLruCache;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    public static final String TAG = "FragmentManager";
    public boolean mCommitted;
    public int mIndex;
    public final FragmentManager mManager;

    public BackStackRecord(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.getHost() != null ? fragmentManager.getHost().getContext().getClassLoader() : null);
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    public static boolean isFragmentPostponed(FragmentTransaction.C0354Op c0354Op) {
        Fragment fragment = c0354Op.mFragment;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public void bumpBackStackNesting(int i) {
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            String str = "Bump nesting in " + this + " by " + i;
        }
        int size = this.mOps.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.C0354Op c0354Op = this.mOps.get(i2);
            Fragment fragment = c0354Op.mFragment;
            if (fragment != null) {
                fragment.mBackStackNesting += i;
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bump nesting of ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c0354Op.mFragment);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" to ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c0354Op.mFragment.mBackStackNesting);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    public int commitInternal(boolean z) {
        if (!this.mCommitted) {
            if (FragmentManager.isLoggingEnabled(2)) {
                String str = "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                dump("  ", printWriter);
                printWriter.close();
            }
            this.mCommitted = true;
            this.mIndex = this.mAddToBackStack ? this.mManager.allocBackStackIndex() : -1;
            this.mManager.enqueueAction(this, z);
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.detach(fragment);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragment.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void doAddOp(int i, Fragment fragment, @Nullable String str, int i2) {
        super.doAddOp(i, fragment, str, i2);
        fragment.mFragmentManager = this.mManager;
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.mOps.size();
            for (int i = 0; i < size; i++) {
                FragmentTransaction.C0354Op c0354Op = this.mOps.get(i);
                switch (c0354Op.mCmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = DiskLruCache.REMOVE;
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cmd=");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c0354Op.mCmd);
                        str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(StringUtils.SPACE);
                printWriter.println(c0354Op.mFragment);
                if (z) {
                    if (c0354Op.mEnterAnim != 0 || c0354Op.mExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0354Op.mEnterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0354Op.mExitAnim));
                    }
                    if (c0354Op.mPopEnterAnim != 0 || c0354Op.mPopExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0354Op.mPopEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0354Op.mPopExitAnim));
                    }
                }
            }
        }
    }

    public void executeOps() {
        int size = this.mOps.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.C0354Op c0354Op = this.mOps.get(i);
            Fragment fragment = c0354Op.mFragment;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (c0354Op.mCmd) {
                case 1:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.addFragment(fragment);
                    break;
                case 2:
                default:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown cmd: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c0354Op.mCmd);
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                case 3:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.showFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.attachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, c0354Op.mCurrentMaxState);
                    break;
            }
            if (!this.mReorderingAllowed && c0354Op.mCmd != 1 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (this.mReorderingAllowed || FragmentManager.USE_STATE_MANAGER) {
            return;
        }
        FragmentManager fragmentManager = this.mManager;
        fragmentManager.moveToState(fragmentManager.mCurState, true);
    }

    public void executePopOps(boolean z) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.C0354Op c0354Op = this.mOps.get(size);
            Fragment fragment = c0354Op.mFragment;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (c0354Op.mCmd) {
                case 1:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.removeFragment(fragment);
                    break;
                case 2:
                default:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown cmd: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c0354Op.mCmd);
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                case 3:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.addFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.showFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(c0354Op.mEnterAnim, c0354Op.mExitAnim, c0354Op.mPopEnterAnim, c0354Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.detachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, c0354Op.mOldMaxState);
                    break;
            }
            if (!this.mReorderingAllowed && c0354Op.mCmd != 3 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (this.mReorderingAllowed || !z || FragmentManager.USE_STATE_MANAGER) {
            return;
        }
        FragmentManager fragmentManager = this.mManager;
        fragmentManager.moveToState(fragmentManager.mCurState, true);
    }

    public Fragment expandOps(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.mOps.size()) {
            FragmentTransaction.C0354Op c0354Op = this.mOps.get(i);
            int i2 = c0354Op.mCmd;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = c0354Op.mFragment;
                    int i3 = fragment3.mContainerId;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.mContainerId == i3) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.mOps.add(i, new FragmentTransaction.C0354Op(9, fragment4));
                                    i++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.C0354Op c0354Op2 = new FragmentTransaction.C0354Op(3, fragment4);
                                c0354Op2.mEnterAnim = c0354Op.mEnterAnim;
                                c0354Op2.mPopEnterAnim = c0354Op.mPopEnterAnim;
                                c0354Op2.mExitAnim = c0354Op.mExitAnim;
                                c0354Op2.mPopExitAnim = c0354Op.mPopExitAnim;
                                this.mOps.add(i, c0354Op2);
                                arrayList.remove(fragment4);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.mOps.remove(i);
                        i--;
                    } else {
                        c0354Op.mCmd = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(c0354Op.mFragment);
                    Fragment fragment5 = c0354Op.mFragment;
                    if (fragment5 == fragment2) {
                        this.mOps.add(i, new FragmentTransaction.C0354Op(9, fragment5));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.mOps.add(i, new FragmentTransaction.C0354Op(9, fragment2));
                        i++;
                        fragment2 = c0354Op.mFragment;
                    }
                }
                i++;
            }
            arrayList.add(c0354Op.mFragment);
            i++;
        }
        return fragment2;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.mName;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.hide(fragment);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragment.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public boolean interactsWith(int i) {
        int size = this.mOps.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.mOps.get(i2).mFragment;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean interactsWith(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.mOps.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.mOps.get(i4).mFragment;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    BackStackRecord backStackRecord = arrayList.get(i6);
                    int size2 = backStackRecord.mOps.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = backStackRecord.mOps.get(i7).mFragment;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public boolean isPostponed() {
        for (int i = 0; i < this.mOps.size(); i++) {
            if (isFragmentPostponed(this.mOps.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.remove(fragment);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragment.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables != null) {
            for (int i = 0; i < this.mCommitRunnables.size(); i++) {
                this.mCommitRunnables.get(i).run();
            }
            this.mCommitRunnables = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager != this.mManager) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mManager);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.setMaxLifecycle(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i = 0; i < this.mOps.size(); i++) {
            FragmentTransaction.C0354Op c0354Op = this.mOps.get(i);
            if (isFragmentPostponed(c0354Op)) {
                c0354Op.mFragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.mManager) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragment.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.show(fragment);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot show Fragment attached to a different FragmentManager. Fragment ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(fragment.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    public Fragment trackAddedFragmentsInPop(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.C0354Op c0354Op = this.mOps.get(size);
            int i = c0354Op.mCmd;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = c0354Op.mFragment;
                            break;
                        case 10:
                            c0354Op.mCurrentMaxState = c0354Op.mOldMaxState;
                            break;
                    }
                }
                arrayList.add(c0354Op.mFragment);
            }
            arrayList.remove(c0354Op.mFragment);
        }
        return fragment;
    }
}
