package com.Illusion0DEV.Domain.Interface.Repository;

import com.Illusion0DEV.Domain.Entities.tb_lks_like;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class like_repository {

    @Autowired
    EntityManager entity_manager;

    public void like_add(tb_lks_like like){
        Session session = entity_manager.unwrap(Session.class);
        session.saveOrUpdate(like);
    }

    public void like_remove(tb_lks_like like){
        Session session = entity_manager.unwrap(Session.class);
        session.saveOrUpdate(like);
    }
}
