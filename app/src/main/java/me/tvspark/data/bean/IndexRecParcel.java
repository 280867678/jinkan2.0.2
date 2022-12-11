package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class IndexRecParcel implements Serializable {
    public String titleTv = "";
    public List<String> tvTypeList = new ArrayList();
    public List<IndexRecTypeListParcel> tvTypeContentList = new ArrayList();
    public String titleMovie = "";
    public List<String> movieTypeList = new ArrayList();
    public List<IndexRecTypeListParcel> movieTypeContentList = new ArrayList();
    public String titleArt = "";
    public List<String> artTypeList = new ArrayList();
    public List<IndexRecTypeListParcel> artTypeContentList = new ArrayList();
    public String titleAnim = "";
    public List<String> animTypeList = new ArrayList();
    public List<IndexRecTypeListParcel> animTypeContentList = new ArrayList();

    public List<IndexRecTypeListParcel> getAnimTypeContentList() {
        return this.animTypeContentList;
    }

    public List<String> getAnimTypeList() {
        return this.animTypeList;
    }

    public List<IndexRecTypeListParcel> getArtTypeContentList() {
        return this.artTypeContentList;
    }

    public List<String> getArtTypeList() {
        return this.artTypeList;
    }

    public List<IndexRecTypeListParcel> getMovieTypeContentList() {
        return this.movieTypeContentList;
    }

    public List<String> getMovieTypeList() {
        return this.movieTypeList;
    }

    public String getTitleAnim() {
        return this.titleAnim;
    }

    public String getTitleArt() {
        return this.titleArt;
    }

    public String getTitleMovie() {
        return this.titleMovie;
    }

    public String getTitleTv() {
        return this.titleTv;
    }

    public List<IndexRecTypeListParcel> getTvTypeContentList() {
        return this.tvTypeContentList;
    }

    public List<String> getTvTypeList() {
        return this.tvTypeList;
    }

    public void setAnimTypeContentList(List<IndexRecTypeListParcel> list) {
        this.animTypeContentList = list;
    }

    public void setAnimTypeList(List<String> list) {
        this.animTypeList = list;
    }

    public void setArtTypeContentList(List<IndexRecTypeListParcel> list) {
        this.artTypeContentList = list;
    }

    public void setArtTypeList(List<String> list) {
        this.artTypeList = list;
    }

    public void setMovieTypeContentList(List<IndexRecTypeListParcel> list) {
        this.movieTypeContentList = list;
    }

    public void setMovieTypeList(List<String> list) {
        this.movieTypeList = list;
    }

    public void setTitleAnim(String str) {
        this.titleAnim = str;
    }

    public void setTitleArt(String str) {
        this.titleArt = str;
    }

    public void setTitleMovie(String str) {
        this.titleMovie = str;
    }

    public void setTitleTv(String str) {
        this.titleTv = str;
    }

    public void setTvTypeContentList(List<IndexRecTypeListParcel> list) {
        this.tvTypeContentList = list;
    }

    public void setTvTypeList(List<String> list) {
        this.tvTypeList = list;
    }
}
