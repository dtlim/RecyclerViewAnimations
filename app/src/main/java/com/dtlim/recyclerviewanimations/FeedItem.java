package com.dtlim.recyclerviewanimations;

/**
 * Created by dale on 9/25/2017.
 */

public class FeedItem {
    private String profilePictureUrl = "";
    private String name = "";
    private String username = "";
    private String content = "";
    private String imageUrl = "";
    private String location = "";
    private String time = "";
    private boolean starred = false;

    public FeedItem(String name, String username, String content, String time) {
        this.name = name;
        this.username = username;
        this.content = content;
        this.time = time;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }
}
