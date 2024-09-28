package com.Illusion0DEV.Application.Interface;

import com.Illusion0DEV.Domain.Entities.tb_pht_photo;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class app_photo_interface{

    @Autowired
    EntityManager entity_manager;

    public List<tb_pht_photo> find_all(){

        Session session = entity_manager.unwrap(Session.class);

        Query query = session.createQuery("from  tb_pht_photo");

        List<tb_pht_photo> photos = query.getResultList();

        return photos;
    }

    public void add_photo(tb_pht_photo photo){
        Session session = entity_manager.unwrap(Session.class);
        session.saveOrUpdate(photo);
    }

    public void delete_photo(UUID pht_id){
        Session session=entity_manager.unwrap(Session.class);

        Query query=session.createQuery("delete from tb_pht_photo where pht_id=:pht_id");
        query.setParameter("pht_id",pht_id);
        query.executeUpdate();
    }
}
