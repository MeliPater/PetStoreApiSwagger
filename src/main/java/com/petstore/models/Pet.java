package com.petstore.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;

@JsonSerialize(using = PetSerializer.class)
public class Pet {
    private Integer id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    // Flags para control de inclusión (transient para que Jackson los ignore)
    public transient boolean includeId = false;
    public transient boolean includeName = false;
    public transient boolean includeCategory = false;
    public transient boolean includePhotoUrls = false;
    public transient boolean includeTags = false;
    public transient boolean includeStatus = false;

    // Getters condicionales
    public Integer getId() {
        return includeId ? id : null;
    }

    public String getName() {
        return includeName ? name : null;
    }

    public Category getCategory() {
        return includeCategory ? category : null;
    }

    public List<String> getPhotoUrls() {
        return includePhotoUrls ? photoUrls : null;
    }

    public List<Tag> getTags() {
        return includeTags ? tags : null;
    }

    public String getStatus() {
        return includeStatus ? status : null;
    }

    // Setters normales
    public void setId(Integer id) {
        this.id = id;
        this.includeId = true;
    }

    public void setName(String name) {
        this.name = name;
        this.includeName = true;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.includeCategory = true;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        this.includePhotoUrls = true;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
        this.includeTags = true;
    }

    public void setStatus(String status) {
        this.status = status;
        this.includeStatus = true;
    }

    // Métodos para null explícito
    public void setNullId() {
        this.id = null;
        this.includeId = true;
    }

    public void setNullName() {
        this.name = null;
        this.includeName = true;
    }

    public void setNullCategory() {
        this.category = null;
        this.includeCategory = true;
    }

    public void setNullPhotoUrls() {
        this.photoUrls = null;
        this.includePhotoUrls = true;
    }

    public void setNullTags() {
        this.tags = null;
        this.includeTags = true;
    }

    public void setNullStatus() {
        this.status = null;
        this.includeStatus = true;
    }
}