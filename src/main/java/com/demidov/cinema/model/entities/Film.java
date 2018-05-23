package com.demidov.cinema.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @SequenceGenerator(name="films_id_seq", sequenceName="films_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "films_id_seq")
    private int id;

    private int duration;

    private String name;

    private int basePrice;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
}
