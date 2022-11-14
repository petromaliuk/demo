package com.kma.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @NotNull
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    @NotBlank
    private String title;

    @Column(name = "description", nullable = false, length = 400)
    @NotBlank
    private String description;

    @Column(name = "category", nullable = false, length = 50)
    @NotBlank
    private String category;

    @Column(name = "duration", nullable = false)
    @Min(0)
    private int duration;

    public Film() { }

    public Film(Integer id, String title, String description, String category, int duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.duration = duration;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}