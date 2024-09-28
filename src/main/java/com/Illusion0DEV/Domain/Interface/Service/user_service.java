package com.Illusion0DEV.Domain.Interface.Service;

import com.Illusion0DEV.Domain.Entities.tb_ath_authority;
import com.Illusion0DEV.Domain.Entities.tb_lks_like;
import com.Illusion0DEV.Domain.Entities.tb_usr_user;
import com.Illusion0DEV.Domain.Interface.Repository.user_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class user_service {

    @Autowired
    user_repository user_repository;

    public void save_or_update(tb_usr_user user) {
        user_repository.save_or_update(user);
    }

    @Transactional
    public Optional<tb_usr_user> find_user_by_id(UUID usr_id) {
        return user_repository.find_user_by_id(usr_id);
    }

    @Transactional
    public tb_usr_user find_user_by_email(String email) {
        return user_repository.find_user_by_email(email);
    }

    @Transactional
    public Optional<tb_usr_user> find_user_by_password(String password) {
        return user_repository.find_user_by_password(password);
    }

    @Transactional
    public void add_authority(tb_ath_authority authority) {
        user_repository.add_authority(authority);
    }

    @Transactional
    public tb_usr_user find_user_by_username(String username) {
        return user_repository.find_user_by_username(username);
    }

    @Transactional
    public List<tb_usr_user> find_user_male(String gender){
        return user_repository.find_user_male(gender);
    }

    @Transactional
    public List<tb_usr_user> find_user_female(String gender){
        return user_repository.find_user_female(gender);
    }

    @Transactional
    public List<tb_usr_user> find_user_female_this(String gender, UUID user_id_gender){
        return user_repository.find_user_female_this(gender, user_id_gender);
    }

    @Transactional
    public List<tb_usr_user> find_user_male_this(String gender, UUID user_id_gender){
        return user_repository.find_user_male_this(gender, user_id_gender);
    }

    @Transactional
    public List<tb_lks_like> find_list_like(UUID user_id){
        return user_repository.find_list_like(user_id);
    }

    @Transactional
    public List<tb_lks_like> find_list_match(UUID user_id){
        return user_repository.find_list_match(user_id);
    }

    @Transactional
    public List<tb_usr_user> find_all(){
        return user_repository.find_all();
    }

    @Transactional
    public List<tb_usr_user> find_all_but_this(UUID user_id){
        return user_repository.find_all_but_this(user_id);
    }

    @Transactional
    public tb_lks_like find_like_of_user(UUID user_id, Long user_liked){
        return user_repository.find_like_of_user(user_id, user_liked);
    }

    @Transactional
    public List get_like_of_user(UUID user_id){
        return user_repository.get_like_of_user(user_id);
    }

    @Transactional
    public Boolean exist_in_list_liked_of_current_user(long current_user_id, long liked_user_id) {
        return user_repository.exist_in_list_liked_of_current_user(current_user_id, liked_user_id);
    }

    @Transactional
    public List<tb_usr_user> get_user_liked_from_user(UUID user_id) {
        return user_repository.get_user_liked_from_user(user_id);
    }

    @Transactional
    public List<tb_usr_user> find_user_by_gender_and_age_range(String gender) {
        return user_repository.find_user_by_gender_and_age_range(gender);
    }

}

