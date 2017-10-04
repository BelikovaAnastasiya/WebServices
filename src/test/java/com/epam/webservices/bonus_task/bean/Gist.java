package com.epam.webservices.bonus_task.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Gist implements Serializable{

    private String url;
    private String forksUrl;
    private String commitsUrl;
    private String id;
    private String description;
    private boolean isPublic;
    private UserGist owner;
    private String user;
    private boolean truncated;
    private int comments;
    private String commentsUrl;
    private String htmlUrl;
    private String gitPullUrl;
    private String gitPushUrl;
    private Date createdAt;
    private Date updatedAt;
    private Map<String, File> files;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public UserGist getOwner() {
        return owner;
    }

    public void setOwner(UserGist owner) {
        this.owner = owner;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getGitPullUrl() {
        return gitPullUrl;
    }

    public void setGitPullUrl(String gitPullUrl) {
        this.gitPullUrl = gitPullUrl;
    }

    public String getGitPushUrl() {
        return gitPushUrl;
    }

    public void setGitPushUrl(String gitPushUrl) {
        this.gitPushUrl = gitPushUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public void setFiles(Map<String, File> files) {
        this.files = files;
    }

    public void setFile(String name, File file) {
        Map<String, File> files = new HashMap<String, File>();
        files.put(name, file);
        setFiles(files);
    }

    @Override
    public String toString() {
        return "Gist{" +
                "url='" + url + '\'' +
                ", forksUrl='" + forksUrl + '\'' +
                ", commitsUrl='" + commitsUrl + '\'' +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", isPublic=" + isPublic +
                ", owner=" + owner +
                ", user='" + user + '\'' +
                ", truncated=" + truncated +
                ", comments=" + comments +
                ", commentsUrl='" + commentsUrl + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", gitPullUrl='" + gitPullUrl + '\'' +
                ", gitPushUrl='" + gitPushUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", files=" + files +
                '}';
    }
}
