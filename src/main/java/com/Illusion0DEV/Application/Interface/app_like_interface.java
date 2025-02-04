package com.Illusion0DEV.Application.Interface;

import com.Illusion0DEV.Domain.Entities.tb_lks_like;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class app_like_interface {

    @Autowired
    EntityManager entity_manager;

    @Transactional
    public void like_add(tb_lks_like like){
        Session session = entity_manager.unwrap(Session.class);
        session.saveOrUpdate(like);
    }

    @Transactional
    public void like_remove(tb_lks_like like) {
        Session session = entity_manager.unwrap(Session.class);
        session.saveOrUpdate(like);
    }
}
