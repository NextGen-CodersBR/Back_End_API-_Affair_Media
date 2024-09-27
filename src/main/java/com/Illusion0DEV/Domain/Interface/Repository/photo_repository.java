package com.Illusion0DEV.Domain.Interface.Repository;

import com.Illusion0DEV.Domain.Entities.tb_pht_photo;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class photo_repository {

    @Autowired
    EntityManager entity_manager;

    public List<tb_pht_photo> find_all(){

        Session session = entity_manager.unwrap(Session.class);

        Query query = session.createQuery("from tb_pht_photo ");

        List<tb_pht_photo> photos = query.getResultList();

        return photos;
    }

    public void add(tb_pht_photo photo){
        Session session = entity_manager.unwrap(Session.class);
        session.saveOrUpdate(photo);
    }

    public void delete(UUID pht_id){
        Session session=entity_manager.unwrap(Session.class);

        Query query=session.createQuery("delete from tb_pht_photo where pht_id=:pht_id");
        query.setParameter("pht_id",pht_id);
        query.executeUpdate();
    }
}
