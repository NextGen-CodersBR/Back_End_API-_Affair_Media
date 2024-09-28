package com.Illusion0DEV.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.Nullable;

import jakarta.persistence.*;

import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_lks_likes")
public class tb_lks_like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID lks_id;

    @ManyToOne
    @JoinColumn(name = "lks_user_id", insertable = false, updatable = false)
    public tb_usr_user lks_user;

    @Column(name = "lks_user_liked_id")
    public Long lks_user_liked_id;

    @ManyToOne
    @JoinColumn(name = "lks_match_id", insertable = false, updatable = false)
    public tb_mtc_match lks_match;

    @JsonIgnore
    @Nullable
    public Long lks_liked;

    //CONSTRUCTOR
    public tb_lks_like(){}

    //GETTERS
    public UUID get_lks_id() {
        return lks_id;
    }
    public tb_usr_user get_lks_user() {
        return lks_user;
    }
    public Long get_lks_liked_user_id() {
        return lks_user_liked_id;
    }
    public tb_mtc_match get_lks_match() {
        return lks_match;
    }
    public Long get_lks_liked() {
        return lks_liked;
    }

    //SETTERS
    public void  set_lks_id(UUID lks_id) {
        this.lks_id = lks_id;
    }
    public void  set_lks_user(tb_usr_user lks_user) {
        this.lks_user = lks_user;
    }
    public void  set_lks_liked_user_id(Long lks_user_liked_id) {
        this.lks_user_liked_id = lks_user_liked_id;
    }
    public void  set_lks_match(tb_mtc_match lks_match) {
        this.lks_match = lks_match;
    }
    public void  set_lks_liked(Long lks_liked) {
        this.lks_liked = lks_liked;
    }
}
