package com.Illusion0DEV.Domain.Entities;

import jakarta.persistence.*;

import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_mtc_match")
public class tb_mtc_match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID mtc_id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date mtc_time;

    @OneToMany(mappedBy = "lks_match")
    public List<tb_lks_like> mtc_like;

    //CONSTRUCTOR
    public tb_mtc_match(){}

    //GETTERS
    public UUID get_mtc_id() {
        return mtc_id;
    }
    public Date get_mtc_time() {
        return mtc_time;
    }
    public List<tb_lks_like> get_mtc_like() {
        return mtc_like;
    }

    //SETTERS
    public void set_mtc_id(UUID mtc_id) {
        this.mtc_id = mtc_id;
    }
    public void set_mtc_time(Date mtc_time) {
        this.mtc_time = mtc_time;
    }
    public void set_mtc_like(List<tb_lks_like> mtc_like) {
        this.mtc_like = mtc_like;
    }
}
