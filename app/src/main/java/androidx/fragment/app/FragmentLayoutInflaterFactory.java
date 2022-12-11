package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.C0298R;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public static final String TAG = "FragmentManager";
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0163  */
    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        final FragmentStateManager createOrGetFragmentStateManager;
        StringBuilder sb;
        String str2;
        View view2;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.mFragmentManager);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0298R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(C0298R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(C0298R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(C0298R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.mFragmentManager.findFragmentById(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.mFragmentManager.findFragmentByTag(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.mFragmentManager.findFragmentById(id);
        }
        if (fragment == null) {
            fragment = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.mFragmentManager;
            fragment.mFragmentManager = fragmentManager;
            fragment.mHost = fragmentManager.getHost();
            fragment.onInflate(this.mFragmentManager.getHost().getContext(), attributeSet, fragment.mSavedFragmentState);
            createOrGetFragmentStateManager = this.mFragmentManager.addFragment(fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(fragment);
                str2 = " has been inflated via the <fragment> tag: id=0x";
                sb.append(str2);
                sb.append(Integer.toHexString(resourceId));
                sb.toString();
            }
            fragment.mContainer = (ViewGroup) view;
            createOrGetFragmentStateManager.moveToExpectedState();
            createOrGetFragmentStateManager.ensureInflatedView();
            view2 = fragment.mView;
            if (view2 != null) {
                throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Fragment ", attributeValue, " did not create a view."));
            }
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view3) {
                    Fragment fragment2 = createOrGetFragmentStateManager.getFragment();
                    createOrGetFragmentStateManager.moveToExpectedState();
                    SpecialEffectsController.getOrCreateController((ViewGroup) fragment2.mView.getParent(), FragmentLayoutInflaterFactory.this.mFragmentManager).forceCompleteAllOperations();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view3) {
                }
            });
            return fragment.mView;
        } else if (fragment.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        } else {
            fragment.mInLayout = true;
            FragmentManager fragmentManager2 = this.mFragmentManager;
            fragment.mFragmentManager = fragmentManager2;
            fragment.mHost = fragmentManager2.getHost();
            fragment.onInflate(this.mFragmentManager.getHost().getContext(), attributeSet, fragment.mSavedFragmentState);
            createOrGetFragmentStateManager = this.mFragmentManager.createOrGetFragmentStateManager(fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                sb = new StringBuilder();
                sb.append("Retained Fragment ");
                sb.append(fragment);
                str2 = " has been re-attached via the <fragment> tag: id=0x";
                sb.append(str2);
                sb.append(Integer.toHexString(resourceId));
                sb.toString();
            }
            fragment.mContainer = (ViewGroup) view;
            createOrGetFragmentStateManager.moveToExpectedState();
            createOrGetFragmentStateManager.ensureInflatedView();
            view2 = fragment.mView;
            if (view2 != null) {
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
