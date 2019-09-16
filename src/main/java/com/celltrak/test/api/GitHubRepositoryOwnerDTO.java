package com.celltrak.test.api;

/**
 * Model DTO for GitHub Owner.
 * @author alexis.alvarez
 */
public class GitHubRepositoryOwnerDTO {
    private String login;
    private int id;
    private String avatar_url;
    private String url;
    private String type;
    private boolean site_admin;

    public GitHubRepositoryOwnerDTO() {
    }

    public GitHubRepositoryOwnerDTO(String login, int id, String avatar_url, String url, String type, boolean site_admin) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.url = url;
        this.type = type;
        this.site_admin = site_admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }
}
