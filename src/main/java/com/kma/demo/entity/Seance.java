package com.kma.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "seances")
public class Seance {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "filmId", nullable = false, referencedColumnName = "id")
    private Film film;

    @Column(name = "date", nullable = false)
    private Date date;

    public Seance() { }

    public Seance(Integer id, Film film, Date date) {
        this.id = id;
        this.film = film;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
