package org.eclipse.jetty.util.component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes5.dex */
public class FileDestroyable implements Destroyable {
    public static final Logger LOG = Log.getLogger(FileDestroyable.class);
    public final List<File> _files;

    public FileDestroyable() {
        this._files = new ArrayList();
    }

    public FileDestroyable(File file) {
        ArrayList arrayList = new ArrayList();
        this._files = arrayList;
        arrayList.add(file);
    }

    public FileDestroyable(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        this._files = arrayList;
        arrayList.add(Resource.newResource(str).getFile());
    }

    public void addFile(File file) {
        this._files.add(file);
    }

    public void addFile(String str) throws IOException {
        this._files.add(Resource.newResource(str).getFile());
    }

    public void addFiles(Collection<File> collection) {
        this._files.addAll(collection);
    }

    @Override // org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        for (File file : this._files) {
            if (file.exists()) {
                LOG.debug("Destroy {}", file);
                C3009IO.delete(file);
            }
        }
    }

    public void removeFile(File file) {
        this._files.remove(file);
    }

    public void removeFile(String str) throws IOException {
        this._files.remove(Resource.newResource(str).getFile());
    }
}
