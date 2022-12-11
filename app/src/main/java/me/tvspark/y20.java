package me.tvspark;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArraySet;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@TargetApi(23)
/* loaded from: classes4.dex */
public final class y20 extends Fragment implements Runnable {
    public static final ArraySet<Integer> Wwwwwwwwwwwwwwwwww = new ArraySet<>();
    public int Wwwwwwwwwwwwwwwwwww;
    public v20 Wwwwwwwwwwwwwwwwwwww;
    public w20 Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w20 {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ ArrayList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.y20$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3507Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w20 {
            public C3507Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.w20
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
                if (!z || !y20.this.isAdded()) {
                    return;
                }
                int[] iArr = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()];
                Arrays.fill(iArr, 0);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                y20.this.onRequestPermissionsResult(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (String[]) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray(new String[0]), iArr);
            }

            @Override // me.tvspark.w20
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
                if (!y20.this.isAdded()) {
                    return;
                }
                int[] iArr = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()];
                for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
                    iArr[i] = "android.permission.ACCESS_BACKGROUND_LOCATION".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i)) ? -1 : 0;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                y20.this.onRequestPermissionsResult(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (String[]) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray(new String[0]), iArr);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, ArrayList arrayList, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            if (!z || !y20.this.isAdded()) {
                return;
            }
            y20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}), null, new C3507Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            if (!y20.this.isAdded()) {
                return;
            }
            int[] iArr = new int[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()];
            Arrays.fill(iArr, -1);
            y20.this.onRequestPermissionsResult(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (String[]) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray(new String[0]), iArr);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, ArrayList<String> arrayList, v20 v20Var, w20 w20Var) {
        int nextInt;
        y20 y20Var = new y20();
        Bundle bundle = new Bundle();
        do {
            nextInt = new Random().nextInt((int) Math.pow(2.0d, 8.0d));
        } while (Wwwwwwwwwwwwwwwwww.contains(Integer.valueOf(nextInt)));
        Wwwwwwwwwwwwwwwwww.add(Integer.valueOf(nextInt));
        bundle.putInt("request_code", nextInt);
        bundle.putStringArrayList("request_permissions", arrayList);
        y20Var.setArguments(bundle);
        y20Var.setRetainInstance(true);
        y20Var.Wwwwwwwwwwwwwwwwwwwwww = true;
        y20Var.Wwwwwwwwwwwwwwwwwwwww = w20Var;
        y20Var.Wwwwwwwwwwwwwwwwwwww = v20Var;
        activity.getFragmentManager().beginTransaction().add(y20Var, y20Var.toString()).commitAllowingStateLoss();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList arrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i = arguments.getInt("request_code");
        ArrayList<String> stringArrayList = arguments.getStringArrayList("request_permissions");
        if (stringArrayList == null || stringArrayList.size() == 0) {
            return;
        }
        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !stringArrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            if (stringArrayList.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (stringArrayList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
        }
        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || arrayList == null || arrayList.isEmpty()) {
            requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), getArguments().getInt("request_code"));
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, arrayList, null, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, stringArrayList, i));
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.Wwwwwwwwwwwwwwwwwwwwwww || i != arguments.getInt("request_code")) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = true;
        activity.getWindow().getDecorView().postDelayed(this, 300L);
    }

    @Override // android.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.Wwwwwwwwwwwwwwwwwww = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        try {
            activity.setRequestedOrientation(activity.getResources().getConfiguration().orientation != 2 ? Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity) ? 9 : 1 : Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity) ? 8 : 0);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Wwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.Wwwwwwwwwwwwwwwwwww != -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (activity == null || arguments == null || this.Wwwwwwwwwwwwwwwwwwwww == null || i != arguments.getInt("request_code")) {
            return;
        }
        w20 w20Var = this.Wwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = null;
        v20 v20Var = this.Wwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwww = null;
        int i2 = 0;
        while (true) {
            int i3 = -1;
            boolean z = true;
            if (i2 >= strArr.length) {
                break;
            }
            String str = strArr[i2];
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && ("android.permission.BLUETOOTH_SCAN".equals(str) || "android.permission.BLUETOOTH_CONNECT".equals(str) || "android.permission.BLUETOOTH_ADVERTISE".equals(str))) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) || "android.permission.ACTIVITY_RECOGNITION".equals(str) || "android.permission.ACCESS_MEDIA_LOCATION".equals(str))) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww() && "android.permission.ACCEPT_HANDOVER".equals(str)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() || (!"android.permission.ANSWER_PHONE_CALLS".equals(str) && !"android.permission.READ_PHONE_NUMBERS".equals(str))) {
                z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (z) {
                if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, str)) {
                    i3 = 0;
                }
                iArr[i2] = i3;
            }
            i2++;
        }
        Wwwwwwwwwwwwwwwwww.remove(Integer.valueOf(i));
        activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (iArr[i4] == 0) {
                arrayList.add(strArr[i4]);
            }
        }
        if (arrayList.size() == strArr.length) {
            if (v20Var != null) {
                v20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, w20Var, arrayList, true);
                return;
            } else {
                w20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, true);
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] == -1) {
                arrayList2.add(strArr[i5]);
            }
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, (List<String>) arrayList2);
        if (v20Var != null) {
            v20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, w20Var, arrayList2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        } else {
            w20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (v20Var != null) {
            v20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, w20Var, arrayList, false);
        } else {
            w20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, false);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            getActivity().getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            Bundle arguments = getArguments();
            Activity activity = getActivity();
            if (arguments == null || activity == null) {
                return;
            }
            boolean z = false;
            for (String str : arguments.getStringArrayList("request_permissions")) {
                if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) && !Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, str) && (!"android.permission.MANAGE_EXTERNAL_STORAGE".equals(str) || Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                    startActivityForResult(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, (List<String>) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) new String[]{str})), getArguments().getInt("request_code"));
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!isAdded()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
