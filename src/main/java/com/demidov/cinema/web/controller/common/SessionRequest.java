package com.demidov.cinema.web.controller.common;

public class SessionRequest {

    private Integer filmId;
    private Integer hallId;
    private long sessionDateTs;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public long getSessionDateTs() {
        return sessionDateTs;
    }
}
