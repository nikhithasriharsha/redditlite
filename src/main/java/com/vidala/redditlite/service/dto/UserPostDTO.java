package com.vidala.redditlite.service.dto;

import javax.annotation.Nullable;

public class UserPostDTO {

    private long id;

    private String title;

    private String description;

    private String thumbnail;

    private String imageUrl;

    @Nullable
    private long userId;

    @Nullable
    private String userName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Nullable
    public long getUserId() {
        return userId;
    }

    public void setUserId(@Nullable long userId) {
        this.userId = userId;
    }

    @Nullable
    public String getUserName() {
        return userName;
    }

    public void setUserName(@Nullable String userName) {
        this.userName = userName;
    }
}
