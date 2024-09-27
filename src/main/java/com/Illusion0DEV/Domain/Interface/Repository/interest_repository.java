package com.Illusion0DEV.Domain.Interface.Repository;

import com.Illusion0DEV.Domain.Entities.tb_int_interest;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class interest_repository {

    @Autowired
    private EntityManager entity_manager;

    public List<tb_int_interest> find(String interestTags){
        Session session = entity_manager.unwrap(Session.class);

        Query query = session.createQuery("from Interest where name in :tags");
        query.setParameterList("tags",get_interest_list_from_string(interestTags));

        return query.getResultList();
    }

    public List<tb_int_interest> find_all(){

        Session session = entity_manager.unwrap(Session.class);

        Query query = session.createQuery("from Interest ");

        return query.getResultList();
    }

    private List<String> get_interest_list_from_string(String interest){
        String[] str = interest.split(",");
        List<String> interest_list = new ArrayList<>();
        for(var s : str){
            interest_list.add(s);
        }
        return interest_list;
    }

}
