package cn.qqtheme.framework.entity;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public class FileItem extends JavaBean {
    public Drawable icon;
    public String name;
    public String path = "/";
    public long size = 0;
    public boolean isDirectory = false;

    public Drawable getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
