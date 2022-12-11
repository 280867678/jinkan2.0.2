package ru.bartwell.exfilepicker.p062ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stub.StubApp;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.tvspark.c81;
import me.tvspark.k81;
import me.tvspark.l81;
import me.tvspark.m81;
import me.tvspark.n81;
import me.tvspark.o81;
import me.tvspark.outline;
import me.tvspark.r40;
import ru.bartwell.exfilepicker.ExFilePicker$ChoiceType;
import ru.bartwell.exfilepicker.ExFilePicker$SortingType;
import ru.bartwell.exfilepicker.R$attr;
import ru.bartwell.exfilepicker.R$dimen;
import ru.bartwell.exfilepicker.R$id;
import ru.bartwell.exfilepicker.R$string;
import ru.bartwell.exfilepicker.p062ui.adapter.FilesListAdapter;
import ru.bartwell.exfilepicker.p062ui.view.FilesListToolbar;

/* renamed from: ru.bartwell.exfilepicker.ui.activity.ExFilePickerActivity */
/* loaded from: classes5.dex */
public class ExFilePickerActivity extends AppCompatActivity implements k81, Toolbar.OnMenuItemClickListener, View.OnClickListener, l81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, m81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, n81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public String Kkkkkkkkkkkkkkkkkkkkkkkk;
    public String Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public TextView Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public TextView Www;
    public TextView Wwww;
    public TextView Wwwww;
    public TextView Wwwwww;
    public LinearLayout Wwwwwww;
    public boolean Wwwwwwww;
    public boolean Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public FilesListAdapter Wwwwwwwwwww;
    public View Wwwwwwwwwwww;
    public RecyclerView Wwwwwwwwwwwww;
    public FilesListToolbar Wwwwwwwwwwwwww;
    public File Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public String[] Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public String[] Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public ExFilePicker$ChoiceType Wwwwwwwwwwwwwwwww = ExFilePicker$ChoiceType.ALL;
    @NonNull
    public ExFilePicker$SortingType Wwwwwwwwwwwwwwww = ExFilePicker$SortingType.NAME_ASC;

    /* renamed from: ru.bartwell.exfilepicker.ui.activity.ExFilePickerActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes5.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements o81<File> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExFilePickerActivity exFilePickerActivity) {
        }

        @Override // me.tvspark.o81
        public boolean check(@NonNull File file) {
            return file.isDirectory();
        }
    }

    /* renamed from: ru.bartwell.exfilepicker.ui.activity.ExFilePickerActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes5.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements o81<File> {
        public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExFilePickerActivity exFilePickerActivity, List list) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        }

        @Override // me.tvspark.o81
        public boolean check(@NonNull File file) {
            File file2 = file;
            return file2.isDirectory() || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2.getName()));
        }
    }

    static {
        StubApp.interface11(15772);
    }

    public final void Wwwwwwwwwwwwwwww() {
        l81 l81Var = new l81(this);
        l81Var.Wwwwwwwwwwwwwwwwwwwwwwww = this;
        l81Var.Wwwwwwwwwwwwwwwwwwwwwww.show();
    }

    public final void Wwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwww.getMenu().findItem(R$id.f5036ok).setVisible(this.Wwwwwwwwwwwwwwwww == ExFilePicker$ChoiceType.DIRECTORIES);
    }

    public final void Wwwwwwwwwwwwwwwwww() {
        File parentFile = this.Wwwwwwwwwwwwwww.getParentFile();
        this.Wwwwwwwwwwwwwww = parentFile;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parentFile);
    }

    @Override // me.tvspark.l81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str) {
        int i;
        if (str.length() > 0) {
            File file = new File(this.Wwwwwwwwwwwwwww, str);
            if (file.exists()) {
                i = R$string.efp__folder_already_exists;
            } else if (file.mkdir()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
                i = R$string.efp__folder_created;
            } else {
                i = R$string.efp__folder_not_created;
            }
            Toast.makeText(this, i, 0).show();
        }
    }

    @Override // me.tvspark.n81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        File file = new File(str);
        this.Wwwwwwwwwwwwwww = file;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        this.Wwwwwwwwww = z;
        this.Wwwwwwwwwwwwww.setMultiChoiceModeEnabled(z);
        this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = !z && this.Wwwwwwwww && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
        FilesListAdapter filesListAdapter = this.Wwwwwwwwwww;
        filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        if (!z) {
            filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        }
        if (filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (z) {
                filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>(filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Iterator<File> it = filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                while (it.hasNext()) {
                    if (it.next().isDirectory()) {
                        it.remove();
                    }
                }
            } else {
                filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        filesListAdapter.notifyDataSetChanged();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww.getMenu());
    }

    @Override // me.tvspark.k81
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww && !this.Wwwwwwwwww && i != -1) {
            this.Wwwwwwwwww = true;
            if (this.Wwwwwwwwwwwwwwwww != ExFilePicker$ChoiceType.FILES || !this.Wwwwwwwwwww.getItem(i).isDirectory()) {
                this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, true);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file) {
        FilesListToolbar filesListToolbar;
        String str = "/";
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww)) {
            TextView textView = this.Wwwwww;
            textView.setText(this.Wwwwwwwwwwwwwww + "");
        } else {
            String absolutePath = this.Wwwwwwwwwwwwwww.getParentFile().getAbsolutePath();
            if (!absolutePath.endsWith(str)) {
                absolutePath = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(absolutePath, str);
            }
            TextView textView2 = this.Wwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(absolutePath);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwww.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str);
            textView2.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file)) {
            filesListToolbar = this.Wwwwwwwwwwwwww;
        } else {
            filesListToolbar = this.Wwwwwwwwwwwwww;
            str = file.getName();
        }
        filesListToolbar.setTitle(str);
        this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file) && this.Wwwwwwwww;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            String absolutePath2 = file.getAbsolutePath();
            if (absolutePath2.equals(Environment.getExternalStorageDirectory().getPath() + "/Android/data") && Build.VERSION.SDK_INT >= 30) {
                listFiles = new File[]{new File(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + getPackageName())};
            }
        }
        if (listFiles != null && listFiles.length != 0) {
            this.Wwwwwwwwwwwww.setVisibility(0);
            this.Wwwwwwwwwwww.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            String[] strArr = this.Wwwwwwwwwwwwwwwwwwwwww;
            o81 wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (strArr == null || strArr.length <= 0 || this.Wwwwwwwwwwwwwwwww == ExFilePicker$ChoiceType.DIRECTORIES) ? this.Wwwwwwwwwwwwwwwww == ExFilePicker$ChoiceType.DIRECTORIES ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this) : null : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, Arrays.asList(strArr));
            List asList = Arrays.asList(listFiles);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                arrayList.addAll(asList);
            } else {
                for (Object obj : asList) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.check(obj)) {
                        arrayList.add(obj);
                    }
                }
            }
            String[] strArr2 = this.Wwwwwwwwwwwwwwwwwwwww;
            if (strArr2 != null && strArr2.length > 0 && this.Wwwwwwwwwwwwwwwww != ExFilePicker$ChoiceType.DIRECTORIES) {
                List asList2 = Arrays.asList(strArr2);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    if (!file2.isDirectory() && asList2.contains(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2.getName()))) {
                        it.remove();
                    }
                }
            }
            if (this.Wwwwwwww) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (((File) it2.next()).isHidden()) {
                        it2.remove();
                    }
                }
            }
            FilesListAdapter filesListAdapter = this.Wwwwwwwwwww;
            ExFilePicker$SortingType exFilePicker$SortingType = this.Wwwwwwwwwwwwwwww;
            filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(arrayList);
            filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePicker$SortingType);
        } else if (this.Wwwwwwwww) {
            this.Wwwwwwwwwwwww.setVisibility(0);
            this.Wwwwwwwwwwww.setVisibility(8);
            FilesListAdapter filesListAdapter2 = this.Wwwwwwwwwww;
            ArrayList arrayList2 = new ArrayList();
            ExFilePicker$SortingType exFilePicker$SortingType2 = this.Wwwwwwwwwwwwwwww;
            filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(arrayList2);
            filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePicker$SortingType2);
        } else {
            this.Wwwwwwwwwwww.setVisibility(0);
            this.Wwwwwwwwwwwww.setVisibility(8);
        }
    }

    @Override // me.tvspark.k81
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                FilesListAdapter filesListAdapter = this.Wwwwwwwwwww;
                filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                filesListAdapter.notifyDataSetChanged();
            }
            FilesListAdapter filesListAdapter2 = this.Wwwwwwwwwww;
            filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, !filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(filesListAdapter2.getItem(i).getName()));
        } else if (i == -1) {
            Wwwwwwwwwwwwwwwwww();
        } else {
            File item = this.Wwwwwwwwwww.getItem(i);
            if (!item.isDirectory()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, item.getName());
                return;
            }
            File file = new File(this.Wwwwwwwwwwwwwww, item.getName());
            this.Wwwwwwwwwwwwwww = file;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, @NonNull String str) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, new ArrayList(Collections.singletonList(str)));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, @NonNull List<String> list) {
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(absolutePath, "/");
        }
        c81 c81Var = new c81(absolutePath, list);
        Intent intent = new Intent();
        intent.putExtra("RESULT", c81Var);
        setResult(-1, intent);
        finish();
    }

    @Override // me.tvspark.m81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ExFilePicker$SortingType exFilePicker$SortingType) {
        this.Wwwwwwwwwwwwwwww = exFilePicker$SortingType;
        this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exFilePicker$SortingType);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable File file) {
        return file != null && "/".equals(file.getAbsolutePath());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        if ((r3.getFlags() & 128) == 128) goto L13;
     */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            if (keyEvent.getAction() == 1) {
                if (this.Wwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    Wwwwwwwwwwwwwwwww();
                } else {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww)) {
                        Wwwwwwwwwwwwwwwwww();
                    }
                    finish();
                }
            } else if (keyEvent.getAction() == 0) {
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        if (!this.Wwwwwwwwww) {
            finish();
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        Wwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
        FilesListAdapter filesListAdapter;
        File parentFile;
        String name;
        int itemId = menuItem.getItemId();
        if (itemId == R$id.f5036ok) {
            if (this.Wwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (this.Wwwwwwwwwwwwwwwww == ExFilePicker$ChoiceType.DIRECTORIES) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww)) {
                    parentFile = this.Wwwwwwwwwwwwwww;
                    name = "/";
                } else {
                    parentFile = this.Wwwwwwwwwwwwwww.getParentFile();
                    name = this.Wwwwwwwwwwwwwww.getName();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parentFile, name);
            }
        } else if (itemId == R$id.sort) {
            m81 m81Var = new m81(this);
            m81Var.Wwwwwwwwwwwwwwwwwwwwwww = this;
            m81Var.Wwwwwwwwwwwwwwwwwwwwwwww.show();
        } else if (itemId == R$id.storage) {
            n81 n81Var = new n81(this);
            n81Var.Wwwwwwwwwwwwwwwwwwwwwww = this;
            n81Var.Wwwwwwwwwwwwwwwwwwwwwwww.show();
        } else if (itemId == R$id.new_folder) {
            if (ContextCompat.checkSelfPermission(this, UMUtils.SD_PERMISSION) == 0) {
                Wwwwwwwwwwwwwwww();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{UMUtils.SD_PERMISSION}, 2);
            }
        } else if (itemId == R$id.select_all) {
            FilesListAdapter filesListAdapter2 = this.Wwwwwwwwwww;
            filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            for (File file : filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                filesListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(file.getName());
            }
            filesListAdapter2.notifyDataSetChanged();
        } else if (itemId == R$id.deselect) {
            FilesListAdapter filesListAdapter3 = this.Wwwwwwwwwww;
            filesListAdapter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            filesListAdapter3.notifyDataSetChanged();
        } else if (itemId == R$id.invert_selection) {
            FilesListAdapter filesListAdapter4 = this.Wwwwwwwwwww;
            if (filesListAdapter4 == null) {
                throw null;
            }
            ArrayList arrayList = new ArrayList();
            for (File file2 : filesListAdapter4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!filesListAdapter4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(file2.getName())) {
                    arrayList.add(file2.getName());
                }
            }
            filesListAdapter4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(arrayList);
            filesListAdapter4.notifyDataSetChanged();
        } else {
            boolean z = false;
            if (itemId != R$id.change_view) {
                return false;
            }
            MenuItem findItem = this.Wwwwwwwwwwwwww.getMenu().findItem(R$id.change_view);
            if (this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwww.setLayoutManager(new LinearLayoutManager(this));
                findItem.setIcon(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this, R$attr.efp__ic_action_grid));
                findItem.setTitle(R$string.efp__action_grid);
                filesListAdapter = this.Wwwwwwwwwww;
            } else {
                this.Wwwwwwwwwwwww.setLayoutManager(new GridLayoutManager(this, (int) (getResources().getDisplayMetrics().widthPixels / getResources().getDimension(R$dimen.files_grid_item_size))));
                findItem.setIcon(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this, R$attr.efp__ic_action_list));
                findItem.setTitle(R$string.efp__action_list);
                filesListAdapter = this.Wwwwwwwwwww;
                z = true;
            }
            filesListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            filesListAdapter.notifyDataSetChanged();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww.getMenu());
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("DIRECTORY_STATE", this.Wwwwwwwwwwwwwww.getAbsolutePath());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Menu menu) {
        MenuItem findItem = menu.findItem(R$id.change_view);
        if (findItem != null) {
            findItem.setIcon(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this, this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? R$attr.efp__ic_action_list : R$attr.efp__ic_action_grid));
            findItem.setTitle(this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? R$string.efp__action_list : R$string.efp__action_grid);
        }
    }
}
