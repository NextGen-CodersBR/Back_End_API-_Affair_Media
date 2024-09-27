package com.Illusion0DEV.Application.Interface;

import com.Illusion0DEV.Domain.Entities.tb_ath_authority;
import com.Illusion0DEV.Domain.Entities.tb_lks_like;
import com.Illusion0DEV.Domain.Entities.tb_usr_user;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;


public class app_user_interface {

    @Transactional
    void save_or_update(tb_usr_user user) {
        save_or_update(user);
    }

    @Transactional
    tb_usr_user find_user_by_id(UUID id){
        return find_user_by_id(id);
    }

    @Transactional
    tb_usr_user find_user_by_username(String username){
        return find_user_by_username(username);
    }

    @Transactional
    tb_usr_user find_user_by_email(String email){
        return find_user_by_email(email);
    }

    @Transactional
    tb_usr_user find_user_by_password(String password){
        return find_user_by_password(password);
    }

    @Transactional
    void add_authority(tb_ath_authority authority){
        add_authority(authority);
    }

    @Transactional
    tb_lks_like find_like_of_user(UUID user_id, Long user_liked){
        return find_like_of_user(user_id, user_liked);
    }

    @Transactional
    List<tb_lks_like> find_list_like(UUID user_id){
        return find_list_like(user_id);
    }

    @Transactional
    List<tb_lks_like> find_list_match(UUID user_id){
        return find_list_match(user_id);
    }

    @Transactional
    List get_like_of_user(UUID user_id){
        return get_like_of_user(user_id);
    }

    @Transactional
    Boolean exist_in_list_liked_of_current_user(UUID current_user_id, UUID liked_user_id){
        return exist_in_list_liked_of_current_user(current_user_id, liked_user_id);
    }

    @Transactional
    List<tb_usr_user> get_user_liked_from_user(UUID user_id){
        return get_user_liked_from_user(user_id);
    }

    @Transactional
    List<tb_usr_user> find_user_male(String user_gender){
        return find_user_male(user_gender);
    }

    @Transactional
    List<tb_usr_user> find_user_female(String user_gender){
        return find_user_female(user_gender);
    }

    @Transactional
    List<tb_usr_user> find_user_male_this(String gender,UUID user_id_gender){
        return find_user_male_this(gender,user_id_gender);
    }

    @Transactional
    List<tb_usr_user> find_user_female_this(String gender, UUID user_id_gender){
        return find_user_female_this(gender,user_id_gender);
    }

    @Transactional
    List<tb_usr_user> find_user_by_gender_and_age_range(String user_gender){
        return find_user_by_gender_and_age_range(user_gender);
    }

    @Transactional
    List<tb_usr_user> find_all(){
        return find_all();
    }

    @Transactional
    List<tb_usr_user> find_all_but_this(UUID user_id){
        return find_all_but_this(user_id);
    }
}
