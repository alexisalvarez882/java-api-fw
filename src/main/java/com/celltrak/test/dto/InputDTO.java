package com.celltrak.test.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Class for inputData to use in the tests.
 * @author alexis.alvarez
 */
@JsonPropertyOrder({"username", "page", "size"})
public class InputDTO {
    private String username;
    private int page;
    private int size;

    public InputDTO(String username, int page, int size) {
        this.username = username;
        this.page = page;
        this.size = size;
    }

    public InputDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
