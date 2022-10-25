package com.kma.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "seanceId", nullable = false, referencedColumnName = "id")
    private Seance seance;

    @Column(name = "place", nullable = false)
    private int place;

    public Ticket() { }

    public Ticket(Integer number, Seance seance, int place) {
        this.number = number;
        this.seance = seance;
        this.place = place;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
