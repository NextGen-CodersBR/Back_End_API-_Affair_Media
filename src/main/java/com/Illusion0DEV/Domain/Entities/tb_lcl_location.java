package com.Illusion0DEV.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="tb_lcl_location")
public class tb_lcl_location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID lcl_id;

    public String lcl_name;
    public Float  lcl_gps;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    public tb_usr_user lcl_user;

    //CONSTRUCTOR
    public tb_lcl_location(){}

    //GETTERS
    public UUID get_lcl_id() {
        return lcl_id;
    }
    public String get_lcl_name() {
        return lcl_name;
    }
    public Float get_lcl_gps() {
        return lcl_gps;
    }
    public tb_usr_user get_lcl_user() {
        return lcl_user;
    }

    //SETTERS
    public void set_lcl_id(UUID lcl_id) {
        this.lcl_id = lcl_id;
    }
    public void set_lcl_name(String lcl_name) {
        this.lcl_name = lcl_name;
    }
    public void set_lcl_gps(Float lcl_gps) {
        this.lcl_gps = lcl_gps;
    }
    public void set_lcl_user(tb_usr_user lcl_user) {
        this.lcl_user = lcl_user;
    }
}
