package com.Illusion0DEV.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="tb_usr_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "usr_username"
        }),
        @UniqueConstraint(columnNames = {
                "usr_email"
        })
})
public class tb_usr_user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID usr_id;

    @NotNull
    @Size(min=2,max=20,message = "first name size must be from 2 to 20")
    public String usr_first_name;

    @NotNull
    @Size(min=2,max=20,message = "last name size must be from 2 to 20")
    public String usr_last_name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date usr_birthday;

    @NotNull
    @Size(min=2,max=30,message = "username size must be from 2 to 20")
    public String usr_username;

    @NotNull
    @Size(max=100)
    @Email
    public String usr_email;

    @NotNull
    public String usr_password;

    @Size(max = 500,message = "About is max size = 500 character")
    public String usr_about;

    public String usr_city_alive;

    public String usr_work;

    public String usr_school;

    public String usr_location_Id;

    public String usr_gender;

    public String usr_gender_filter;

    public String usr_max_distance_filter;

    public String usr_age_range_filter;

    public int usr_year_birthday;

    public boolean usr_first_login;

    public boolean usr_status;

    @JsonIgnore
    @OneToMany(mappedBy = "ath_user",fetch = FetchType.EAGER)
    private List<tb_ath_authority> usr_authoritie;

    @OneToMany(mappedBy = "pht_user")
    public List<tb_pht_photo> usr_photo;

    @OneToMany(mappedBy = "lks_user")
    public List<tb_lks_like> usr_like;

    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "user_interest",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "interest_id")}
    )
    public List<tb_int_interest> usr_interest;

    // CONSTRUCTOR
    public tb_usr_user(){}

    //GETTERS
    public UUID get_usr_id(){
        return usr_id;
    }
    public String get_usr_first_name(){
        return usr_first_name;
    }
    public String get_usr_last_name(){
        return usr_last_name;
    }
    public Date get_usr_birthday(){
        return usr_birthday;
    }
    public String get_usr_username(){
        return usr_username;
    }
    public String get_usr_email(){
        return usr_email;
    }
    public String get_usr_password(){
        return usr_password;
    }
    public String get_usr_about(){
        return usr_about;
    }
    public String get_usr_city_alive(){
        return usr_city_alive;
    }
    public String get_usr_work(){
        return usr_work;
    }
    public String get_usr_school(){
        return usr_school;
    }
    public String get_usr_location_Id(){
        return usr_location_Id;
    }
    public String get_usr_gender(){
        return usr_gender;
    }
    public String get_usr_gender_filter(){
        return usr_gender_filter;
    }
    public String get_usr_max_distance_filter(){
        return usr_max_distance_filter;
    }
    public String get_usr_age_range_filter(){
        return usr_age_range_filter;
    }
    public int get_usr_year_birthday(){
        return usr_year_birthday;
    }
    public boolean get_usr_first_login(){
        return usr_first_login;
    }
    public boolean get_usr_status(){
        return usr_status;
    }
    public List<tb_ath_authority> get_usr_authoritie(){
        return usr_authoritie;
    }
    public List<tb_pht_photo> get_usr_photo(){
        return usr_photo;
    }
    public List<tb_lks_like> get_usr_like(){
        return usr_like;
    }
    public List<tb_int_interest> get_usr_interest(){
        return usr_interest;
    }

    //SETTERS
    public void set_usr_id(UUID usr_id){
        this.usr_id = usr_id;
    }
    public void set_usr_first_name(String usr_first_name){
        this.usr_first_name = usr_first_name;
    }
    public void set_usr_last_name(String usr_last_name){
        this.usr_last_name = usr_last_name;
    }
    public void set_usr_birthday(Date usr_birthday){
        this.usr_birthday = usr_birthday;
    }
    public void set_usr_username(String usr_username){
        this.usr_username = usr_username;
    }
    public void set_usr_email(String usr_email){
        this.usr_email = usr_email;
    }
    public void set_usr_password(String usr_password){
        this.usr_password = usr_password;
    }
    public void set_usr_about(String usr_about){
        this.usr_about = usr_about;
    }
    public void set_usr_city_alive(String usr_city_alive){
        this.usr_city_alive = usr_city_alive;
    }
    public void set_usr_work(String usr_work){
        this.usr_work = usr_work;
    }
    public void set_usr_school(String usr_school){
        this.usr_school = usr_school;
    }
    public void set_usr_location_Id(String usr_location_Id){
        this.usr_location_Id = usr_location_Id;
    }
    public void set_usr_gender(String usr_gender){
        this.usr_gender = usr_gender;
    }
    public void set_usr_gender_filter(String usr_gender_filter){
        this.usr_gender_filter = usr_gender_filter;
    }
    public void set_usr_max_distance_filter(String usr_max_distance_filter){
        this.usr_max_distance_filter = usr_max_distance_filter;
    }
    public void set_usr_year_birthday(int usr_year_birthday){
        this.usr_year_birthday = usr_year_birthday;
    }
    public void set_usr_first_login(boolean usr_first_login){
        this.usr_first_login = usr_first_login;
    }
    public void set_usr_status(boolean usr_status){
        this.usr_status = usr_status;
    }
    public void set_usr_authoritie(List<tb_ath_authority> usr_authoritie){
        this.usr_authoritie = usr_authoritie;
    }
    public void set_usr_photo(List<tb_pht_photo> usr_photo){
        this.usr_photo = usr_photo;
    }
    public void set_usr_like(List<tb_lks_like> usr_like){
        this.usr_like = usr_like;
    }
    public void set_usr_interest(List<tb_int_interest> usr_interest){
        this.usr_interest = usr_interest;
    }
}
