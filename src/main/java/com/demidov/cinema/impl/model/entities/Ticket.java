package com.demidov.cinema.impl.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket implements CinemaEntity {

    @Id
    @SequenceGenerator(name = "tickets_id_seq" , sequenceName = "tickets_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_id_seq")
    private Integer id;

    @JoinColumn(name = "session_id")
    @ManyToOne(targetEntity = Session.class)
    private Session session;

    private Integer price;

    @Column(name = "place_row")
    private Integer placeRow;

    @Column(name = "place_column")
    private Integer placeColumn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
