package com.Illusion0DEV.Domain.Interface.Service;

import com.Illusion0DEV.Domain.Entities.tb_mtc_match;
import com.Illusion0DEV.Domain.Interface.Repository.match_repository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class match_service {

    @Autowired
    match_repository match_repository;

    @Transactional
    public void add(tb_mtc_match match){
        match_repository.add(match);
    }
}
