package com.demidov.cinema.model.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "halls")
public class Hall implements CinemaEntity {
    @Id
    @SequenceGenerator(name = "halls_id_seq", sequenceName = "halls_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "halls_id_seq")
    private Integer id;

    private String name;

    private Float placecoeff;

    @Type( type = "com.demidov.cinema.model.entities.types.IntMatrixArrayType" )
    @Column(
        name = "places",
        columnDefinition = "integer[][]"
    )

    private Integer[][] places;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPlacecoeff() {
        return placecoeff;
    }

    public void setPlacecoeff(Float placecoeff) {
        this.placecoeff = placecoeff;
    }

    public Integer[][] getPlaces() {
        return places;
    }

    public void setPlaces(Integer[][] places) {
        this.places = places;
    }
}
