package com.just.agentweb;

import android.content.Intent;
import android.net.Uri;
import com.just.agentweb.AgentActionFragment;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Action {
    public static final transient int ACTION_CAMERA = 3;
    public static final transient int ACTION_FILE = 2;
    public static final transient int ACTION_PERMISSION = 1;
    public static final transient int ACTION_VIDEO = 4;
    public int mAction;
    public AgentActionFragment.ChooserListener mChooserListener;
    public int mFromIntention;
    public Intent mIntent;
    public AgentActionFragment.PermissionListener mPermissionListener;
    public ArrayList<String> mPermissions = new ArrayList<>();
    public AgentActionFragment.RationaleListener mRationaleListener;
    public Uri mUri;

    public static Action createPermissionsAction(String[] strArr) {
        Action action = new Action();
        action.setAction(1);
        action.setPermissions(new ArrayList<>(Arrays.asList(strArr)));
        return action;
    }

    public int getAction() {
        return this.mAction;
    }

    public AgentActionFragment.ChooserListener getChooserListener() {
        return this.mChooserListener;
    }

    public int getFromIntention() {
        return this.mFromIntention;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public AgentActionFragment.PermissionListener getPermissionListener() {
        return this.mPermissionListener;
    }

    public ArrayList<String> getPermissions() {
        return this.mPermissions;
    }

    public AgentActionFragment.RationaleListener getRationaleListener() {
        return this.mRationaleListener;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public void setChooserListener(AgentActionFragment.ChooserListener chooserListener) {
        this.mChooserListener = chooserListener;
    }

    public Action setFromIntention(int i) {
        this.mFromIntention = i;
        return this;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setPermissionListener(AgentActionFragment.PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
    }

    public void setPermissions(ArrayList<String> arrayList) {
        this.mPermissions = arrayList;
    }

    public void setPermissions(String[] strArr) {
        this.mPermissions = new ArrayList<>(Arrays.asList(strArr));
    }

    public void setRationaleListener(AgentActionFragment.RationaleListener rationaleListener) {
        this.mRationaleListener = rationaleListener;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }
}
