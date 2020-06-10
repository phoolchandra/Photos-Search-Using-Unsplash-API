package com.phool.searchfavouritephotos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLinks {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("photos")
        @Expose
        private String photos;
        @SerializedName("likes")
        @Expose
        private String likes;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }



}
