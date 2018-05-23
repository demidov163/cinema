package com.demidov.cinema.model.entities;

import com.demidov.cinema.model.entities.types.PlaceMatrixType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "halls")
@TypeDefs({
    @TypeDef(
        name = "place-matrix",
        typeClass = PlaceMatrixType.class
)
})
public class Hall {
    @Id
    @SequenceGenerator(name = "halls_id_seq", sequenceName = "halls_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "halls_id_seq")
    private Integer id;

    private String name;

    private Double placecoeff;

    @Type( type = "place-matrix" )
    @Column(
        name = "places"
        //columnDefinition = "text[]"
    )
    private Place[][] places;

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

    public Double getPlacecoeff() {
        return placecoeff;
    }

    public void setPlacecoeff(Double placecoeff) {
        this.placecoeff = placecoeff;
    }

    public Place[][] getPlaces() {
        return places;
    }

    public void setPlaces(Place[][] places) {
        this.places = places;
    }
}
