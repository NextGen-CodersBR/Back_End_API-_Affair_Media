package com.Illusion0DEV.Domain.Interface.Service;

import com.Illusion0DEV.Domain.Entities.tb_lks_like;
import com.Illusion0DEV.Domain.Interface.Repository.like_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class like_service {

    @Autowired
    like_repository like_repository;

    public void like_add(tb_lks_like like_add) {
        like_repository.like_add(like_add);
    }

    public void remove_like(tb_lks_like like_remove){
        like_repository.like_remove(like_remove);
    }
}
