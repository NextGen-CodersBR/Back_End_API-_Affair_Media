package com.Illusion0DEV.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_pht_photo")
public class tb_pht_photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID pht_id;

    public String pht_link;

    public int pht_length_photo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pht_user_id")
    public tb_usr_user pht_user;

    @ManyToOne
    @JoinColumn(name = "lks_match_id")
    public tb_mtc_match pht_match;

    //CONSTRUCTOR
    public tb_pht_photo() {}

    //GETTERS
    public UUID get_pht_id() {
        return pht_id;
    }
    public String get_pht_link() {
        return pht_link;
    }
    public int get_pht_length_photo() {
        return pht_length_photo;
    }
    public tb_usr_user get_pht_user() {
        return pht_user;
    }
    public tb_mtc_match get_pht_match() {
        return pht_match;
    }

    //SETTERS
    public void set_pht_id(UUID pht_id) {
        this.pht_id = pht_id;
    }
    public void set_pht_link(String pht_link) {
        this.pht_link = pht_link;
    }
    public void set_pht_length_photo(int pht_length_photo) {
        this.pht_length_photo = pht_length_photo;
    }
    public void set_pht_user(tb_usr_user pht_user) {
        this.pht_user = pht_user;
    }
    public void set_pht_match(tb_mtc_match pht_match) {
        this.pht_match = pht_match;
    }
}
