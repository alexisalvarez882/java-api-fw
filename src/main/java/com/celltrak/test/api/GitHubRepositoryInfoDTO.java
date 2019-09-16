package com.celltrak.test.api;

/**
 * Model DTO for GitHub response.
 * @author alexis.alvarez
 */
public class GitHubRepositoryInfoDTO {
    private int id;
    private String name;
    private String full_name;
    private String html_url;
    private String description;
    private boolean has_wiki;
    private GitHubRepositoryOwnerDTO owner;

    public GitHubRepositoryInfoDTO() {
    }

    public GitHubRepositoryInfoDTO(int id, String name, String full_name, String html_url, String description, boolean has_wiki, GitHubRepositoryOwnerDTO owner) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.html_url = html_url;
        this.description = description;
        this.has_wiki = has_wiki;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHas_wiki() {
        return has_wiki;
    }

    public void setHas_wiki(boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    public GitHubRepositoryOwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(GitHubRepositoryOwnerDTO owner) {
        this.owner = owner;
    }
}
