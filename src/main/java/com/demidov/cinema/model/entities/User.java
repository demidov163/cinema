package com.demidov.cinema.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @SequenceGenerator(name = "users_id_seq" , sequenceName = "users_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @Id
    private Integer id;

    private String login;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
