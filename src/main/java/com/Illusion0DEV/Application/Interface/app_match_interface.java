package com.Illusion0DEV.Application.Interface;

import com.Illusion0DEV.Domain.Entities.tb_mtc_match;
import com.Illusion0DEV.Domain.Interface.Repository.match_repository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class app_match_interface{

    @Autowired
    match_repository match_repository;

    @Transactional
    public void add_match(tb_mtc_match match){
        match_repository.add_match(match);
    }

    public void remove_match(tb_mtc_match match){
        match_repository.remove_match(match);
    }
}
