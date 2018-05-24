package com.demidov.cinema.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Session {

    @SequenceGenerator(name = "sessions_id_seq" , sequenceName = "sessions_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessions_id_seq")
    private Integer id;

    @JoinColumn(name = "film_id")
    @ManyToOne(targetEntity = Film.class)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Integer price;

    @Id
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

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
