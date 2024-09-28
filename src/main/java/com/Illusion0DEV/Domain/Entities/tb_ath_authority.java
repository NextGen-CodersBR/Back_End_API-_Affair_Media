package com.Illusion0DEV.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="tb_ath_authority")
public class tb_ath_authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID ath_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ath_user_id")
    public tb_usr_user ath_user;

    //CONSTRUCTOR
    public tb_ath_authority(){}

    //GETTERS
    public UUID get_ath_id() {
        return ath_id;
    }
    public tb_usr_user get_ath_user() {
        return ath_user;
    }

    //SETTERS
    public void set_ath_id(UUID ath_id) {
        this.ath_id = ath_id;
    }
    public void set_ath_user(tb_usr_user ath_user) {
        this.ath_user = ath_user;
    }
}
