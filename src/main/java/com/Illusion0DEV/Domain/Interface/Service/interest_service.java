package com.Illusion0DEV.Domain.Interface.Service;

import com.Illusion0DEV.Domain.Entities.tb_int_interest;
import com.Illusion0DEV.Domain.Interface.Repository.interest_repository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class interest_service {

    @Autowired
    interest_repository interest_repository;

    @Transactional
    public List<tb_int_interest> find(String interestTags){
        return interest_repository.find(interestTags);
    }

    @Transactional
    public List<tb_int_interest> find_all(){
        return interest_repository.find_all();
    }

    @Transactional
    public List<String> get_interest_list_from_string(String interest){
        return get_interest_list_from_string(interest);
    }
}
