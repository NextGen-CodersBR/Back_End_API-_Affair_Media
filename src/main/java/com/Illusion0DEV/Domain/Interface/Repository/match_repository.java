package com.Illusion0DEV.Domain.Interface.Repository;

import com.Illusion0DEV.Domain.Entities.tb_mtc_match;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class match_repository {

    @Autowired
    EntityManager entity_manager;

    @Transactional
    public void add_match(tb_mtc_match match){
        Session session=entity_manager.unwrap(Session.class);
        session.saveOrUpdate(match);
    }

    public void remove_match(tb_mtc_match match){
        Session session=entity_manager.unwrap(Session.class);
        session.delete(match);
    }
}
