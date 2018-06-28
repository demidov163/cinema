package com.demidov.cinema.impl.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film implements CinemaEntity {

    @Id
    @SequenceGenerator(name="films_id_seq", sequenceName="films_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "films_id_seq")
    private int id;

    //minutes
    @Column(name = "duration_minuts")
    private int durationMinuts;

    private String name;

    private int basePrice;

    private boolean archived;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDurationMinuts() {
        return durationMinuts;
    }

    public void setDurationMinuts(int duration) {
        this.durationMinuts = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
