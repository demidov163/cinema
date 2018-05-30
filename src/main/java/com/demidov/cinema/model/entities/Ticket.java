package com.demidov.cinema.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @SequenceGenerator(name = "tickets_id_seq" , sequenceName = "tickets_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_id_seq")
    private Integer id;

    private Session session;

    private Integer price;

    private Integer placeRow;

    private Integer placeColumn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "session_id")
    @ManyToOne
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPlaceRow() {
        return placeRow;
    }

    public void setPlaceRow(Integer place) {
        this.placeRow = place;
    }

    public Integer getPlaceColumn() {
        return placeColumn;
    }

    public void setPlaceColumn(Integer placeColumn) {
        this.placeColumn = placeColumn;
    }
}
