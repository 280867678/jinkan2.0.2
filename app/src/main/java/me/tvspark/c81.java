package me.tvspark;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c81 implements Parcelable {
    public static final Parcelable.Creator<c81> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int Wwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public List<String> Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<c81> {
        @Override // android.os.Parcelable.Creator
        public c81 createFromParcel(Parcel parcel) {
            return new c81(parcel, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }

        @Override // android.os.Parcelable.Creator
        public c81[] newArray(int i) {
            return new c81[i];
        }
    }

    public /* synthetic */ c81(Parcel parcel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readString();
        this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.createStringArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
    }

    public c81(@NonNull String str, @NonNull List<String> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwww = list.size();
    }

    @Nullable
    public static c81 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Intent intent) {
        if (intent != null) {
            return (c81) intent.getParcelableExtra("RESULT");
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeStringList(this.Wwwwwwwwwwwwwwwwwwwwwww);
        parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}
