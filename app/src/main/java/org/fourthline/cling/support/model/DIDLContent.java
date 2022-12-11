package org.fourthline.cling.support.model;

import java.util.ArrayList;
import java.util.List;
import org.fourthline.cling.support.model.container.Album;
import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.container.GenreContainer;
import org.fourthline.cling.support.model.container.MovieGenre;
import org.fourthline.cling.support.model.container.MusicAlbum;
import org.fourthline.cling.support.model.container.MusicArtist;
import org.fourthline.cling.support.model.container.MusicGenre;
import org.fourthline.cling.support.model.container.PersonContainer;
import org.fourthline.cling.support.model.container.PhotoAlbum;
import org.fourthline.cling.support.model.container.PlaylistContainer;
import org.fourthline.cling.support.model.container.StorageFolder;
import org.fourthline.cling.support.model.container.StorageSystem;
import org.fourthline.cling.support.model.container.StorageVolume;
import org.fourthline.cling.support.model.item.AudioBook;
import org.fourthline.cling.support.model.item.AudioBroadcast;
import org.fourthline.cling.support.model.item.AudioItem;
import org.fourthline.cling.support.model.item.ImageItem;
import org.fourthline.cling.support.model.item.Item;
import org.fourthline.cling.support.model.item.Movie;
import org.fourthline.cling.support.model.item.MusicTrack;
import org.fourthline.cling.support.model.item.MusicVideoClip;
import org.fourthline.cling.support.model.item.Photo;
import org.fourthline.cling.support.model.item.PlaylistItem;
import org.fourthline.cling.support.model.item.TextItem;
import org.fourthline.cling.support.model.item.VideoBroadcast;
import org.fourthline.cling.support.model.item.VideoItem;

/* loaded from: classes5.dex */
public class DIDLContent {
    public static final String DESC_WRAPPER_NAMESPACE_URI = "urn:fourthline-org:cling:support:content-directory-desc-1-0";
    public static final String NAMESPACE_URI = "urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/";
    public List<Container> containers = new ArrayList();
    public List<Item> items = new ArrayList();
    public List<DescMeta> descMetadata = new ArrayList();

    public DIDLContent addContainer(Container container) {
        getContainers().add(container);
        return this;
    }

    public DIDLContent addDescMetadata(DescMeta descMeta) {
        getDescMetadata().add(descMeta);
        return this;
    }

    public DIDLContent addItem(Item item) {
        getItems().add(item);
        return this;
    }

    public DIDLContent addObject(Object obj) {
        if (obj instanceof Item) {
            addItem((Item) obj);
        } else if (obj instanceof Container) {
            addContainer((Container) obj);
        }
        return this;
    }

    public List<Container> getContainers() {
        return this.containers;
    }

    public long getCount() {
        return this.containers.size() + this.items.size();
    }

    public List<DescMeta> getDescMetadata() {
        return this.descMetadata;
    }

    public Container getFirstContainer() {
        return getContainers().get(0);
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void replaceGenericContainerAndItems() {
        setItems(replaceGenericItems(getItems()));
        setContainers(replaceGenericContainers(getContainers()));
    }

    public List<Container> replaceGenericContainers(List<Container> list) {
        ArrayList arrayList = new ArrayList();
        for (Container container : list) {
            String value = container.getClazz().getValue();
            Container album = Album.CLASS.getValue().equals(value) ? new Album(container) : MusicAlbum.CLASS.getValue().equals(value) ? new MusicAlbum(container) : PhotoAlbum.CLASS.getValue().equals(value) ? new PhotoAlbum(container) : GenreContainer.CLASS.getValue().equals(value) ? new GenreContainer(container) : MusicGenre.CLASS.getValue().equals(value) ? new MusicGenre(container) : MovieGenre.CLASS.getValue().equals(value) ? new MovieGenre(container) : PlaylistContainer.CLASS.getValue().equals(value) ? new PlaylistContainer(container) : PersonContainer.CLASS.getValue().equals(value) ? new PersonContainer(container) : MusicArtist.CLASS.getValue().equals(value) ? new MusicArtist(container) : StorageSystem.CLASS.getValue().equals(value) ? new StorageSystem(container) : StorageVolume.CLASS.getValue().equals(value) ? new StorageVolume(container) : StorageFolder.CLASS.getValue().equals(value) ? new StorageFolder(container) : container;
            album.setItems(replaceGenericItems(container.getItems()));
            arrayList.add(album);
        }
        return arrayList;
    }

    public List<Item> replaceGenericItems(List<Item> list) {
        DIDLObject audioItem;
        ArrayList arrayList = new ArrayList();
        for (Item item : list) {
            String value = item.getClazz().getValue();
            if (AudioItem.CLASS.getValue().equals(value)) {
                audioItem = new AudioItem(item);
            } else if (MusicTrack.CLASS.getValue().equals(value)) {
                audioItem = new MusicTrack(item);
            } else if (AudioBook.CLASS.getValue().equals(value)) {
                audioItem = new AudioBook(item);
            } else if (AudioBroadcast.CLASS.getValue().equals(value)) {
                audioItem = new AudioBroadcast(item);
            } else if (VideoItem.CLASS.getValue().equals(value)) {
                audioItem = new VideoItem(item);
            } else if (Movie.CLASS.getValue().equals(value)) {
                audioItem = new Movie(item);
            } else if (VideoBroadcast.CLASS.getValue().equals(value)) {
                audioItem = new VideoBroadcast(item);
            } else if (MusicVideoClip.CLASS.getValue().equals(value)) {
                audioItem = new MusicVideoClip(item);
            } else if (ImageItem.CLASS.getValue().equals(value)) {
                audioItem = new ImageItem(item);
            } else if (Photo.CLASS.getValue().equals(value)) {
                audioItem = new Photo(item);
            } else if (PlaylistItem.CLASS.getValue().equals(value)) {
                audioItem = new PlaylistItem(item);
            } else if (TextItem.CLASS.getValue().equals(value)) {
                audioItem = new TextItem(item);
            } else {
                arrayList.add(item);
            }
            arrayList.add(audioItem);
        }
        return arrayList;
    }

    public void setContainers(List<Container> list) {
        this.containers = list;
    }

    public void setDescMetadata(List<DescMeta> list) {
        this.descMetadata = list;
    }

    public void setItems(List<Item> list) {
        this.items = list;
    }
}
