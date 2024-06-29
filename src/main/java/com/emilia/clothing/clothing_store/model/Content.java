package com.emilia.clothing.clothing_store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
public class Content {

        @GeneratedValue
        @Id
        Integer id;
        @NotEmpty
        String title;
        String description;
        Status status;
        Type contentType;
        LocalDateTime dateCreated;
        LocalDateTime dateUpdated;
        String url;

        public Content(Integer id, String title, String description, Status status, Type contentType, LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
                this.id = id;
                this.title = title;
                this.description = description;
                this.status = status;
                this.contentType = contentType;
                this.dateCreated = dateCreated;
                this.dateUpdated = dateUpdated;
                this.url = url;
        }

        public Content() {

        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
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

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public Type getContentType() {
                return contentType;
        }

        public void setContentType(Type contentType) {
                this.contentType = contentType;
        }

        public LocalDateTime getDateCreated() {
                return dateCreated;
        }

        public void setDateCreated(LocalDateTime dateCreated) {
                this.dateCreated = dateCreated;
        }

        public LocalDateTime getDateUpdated() {
                return dateUpdated;
        }

        public void setDateUpdated(LocalDateTime dateUpdated) {
                this.dateUpdated = dateUpdated;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }
}
