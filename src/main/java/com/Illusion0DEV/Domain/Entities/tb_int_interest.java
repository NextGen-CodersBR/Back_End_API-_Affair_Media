package com.Illusion0DEV.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="tb_int_interest")
public class tb_int_interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID int_id;

    public String int_name;

    @JsonIgnore
    @ManyToMany(mappedBy = "usr_interest",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    public List<tb_usr_user> int_user;

    //CONSTRUCTOR
    public tb_int_interest(){}

    //GETTERS
    public UUID get_int_id() {
        return int_id;
    }
    public String get_int_name() {
        return int_name;
    }
    public List<tb_usr_user> get_int_user() {
        return int_user;
    }

    //SETTERS
    public void set_int_id(UUID int_id) {
        this.int_id = int_id;
    }
    public void set_int_name(String int_name) {
        this.int_name = int_name;
    }
    public void set_int_user(List<tb_usr_user> int_user) {
        this.int_user = int_user;
    }
}
