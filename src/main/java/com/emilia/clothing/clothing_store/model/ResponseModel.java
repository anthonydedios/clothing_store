package com.emilia.clothing.clothing_store.model;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseModel {
    int code = HttpStatus.OK.value();
     List<Content> contentList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}
