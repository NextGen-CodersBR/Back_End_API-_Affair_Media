package com.Illusion0DEV.Domain.Interface.Service;

import com.Illusion0DEV.Domain.Entities.tb_ath_authority;
import com.Illusion0DEV.Domain.Entities.tb_lks_like;
import com.Illusion0DEV.Domain.Entities.tb_usr_user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class user_service {

    private EntityManager entity_manager;

    public void save_or_update(tb_usr_user user) {
        Session session = entity_manager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    public Optional<tb_usr_user> find_user_by_id(UUID usr_id) {
        Session session = entity_manager.unwrap(Session.class);
        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_id = :usr_id", tb_usr_user.class);
        query.setParameter("usr_id", usr_id);

        Optional<tb_usr_user> user = Optional.empty();

        try {
            user = Optional.of(query.getSingleResult());
        } catch (NoResultException nre) {
            System.out.println("No users found with ID: " + usr_id);
        }

        return user;
    }

    public tb_usr_user find_user_by_username(String usr_username) {
        Session session = entity_manager.unwrap(Session.class);
        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_username = :usr_username", tb_usr_user.class);
        query.setParameter("usr_username", usr_username);

        tb_usr_user user = null;

        try {
            user = query.getSingleResult();
        } catch (NoResultException nre) {
            System.out.println("No users found with this username");
        }

        return user;
    }

    public tb_usr_user find_user_by_email(String usr_email) {
        Session session = entity_manager.unwrap(Session.class);
        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_email = :usr_email", tb_usr_user.class);
        query.setParameter("usr_email", usr_email);

        tb_usr_user user = null;

        try {
            user = query.getSingleResult();
        } catch (NoResultException nre) {
            System.out.println("No users found with this email");
        }

        return user;
    }

    public Optional<tb_usr_user> find_user_by_password(String usr_password) {
        Session session = entity_manager.unwrap(Session.class);
        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_password = :usr_password", tb_usr_user.class);
        query.setParameter("usr_password", usr_password);

        Optional<tb_usr_user> user = Optional.empty();

        try {
            user = Optional.of(query.getSingleResult());
        } catch (NoResultException nre) {
            System.out.println("No users found with this password");
        }

        return user;
    }

    public void add_authority(tb_ath_authority authority) {
        Session session = entity_manager.unwrap(Session.class);

        try {
            session.saveOrUpdate(authority);
        } catch (Exception e) {
            System.out.println("Error adding or updating authority: " + e.getMessage());
            throw e;
        }
    }

    public tb_lks_like find_like_of_user(UUID usr_id, Long usr_user) {
        Session session=entity_manager.unwrap(Session.class);

        Query<tb_lks_like> query=session.createQuery("from tb_lks_like l where l.lks_id=:lks_id and l.lks_liked=:lks_liked");

        query.setParameter("lks_id", usr_id);
        query.setParameter("lks_user", usr_user);

        tb_lks_like like = query.getSingleResult();

        return like;
    }

    public List get_like_of_user(UUID usr_id) {
        Session session=entity_manager.unwrap(Session.class);

        Query<tb_usr_user> query=session.createQuery("select tb_lks_like .lks_user from tb_lks_like where tb_lks_like .lks_id=:lks_id");


        query.setParameter("lks_id", usr_id);

        List<tb_usr_user> like = query.getResultList();

        return like;
    }

    public Boolean exist_in_list_liked_of_current_user(Long current_user_id, Long lks_user_liked_id) {
        String jpql = "select count(l) from tb_lks_like l where l.lks_user_id= :lks_user_id and l.lks_user_liked_id= :lks_user_liked_id";
        Query query = (Query) entity_manager.createQuery(jpql);
        query.setParameter("lks_user_id", current_user_id);
        query.setParameter("lks_user_liked_id", lks_user_liked_id);

        Long result = (Long) query.getSingleResult();

        return result > 0;
    }


    public List<tb_usr_user> get_user_liked_from_user(UUID user_id) {
        String jpql = "select l.lks_user from tb_lks_like l where l.lks_user_id= :lks_user_id";
        TypedQuery<tb_usr_user> query = entity_manager.createQuery(jpql, tb_usr_user.class);
        query.setParameter("lks_user_id", user_id);

        return query.getResultList();
    }

    public List<tb_lks_like> find_list_like(UUID user_id) {
        Session session=entity_manager.unwrap(Session.class);

        Query<tb_lks_like> query=session.createQuery("from tb_lks_like l where l.lks_user_id=:lks_user_id");

        query.setParameter("lks_user_id",user_id);

        List<tb_lks_like> likes = query.getResultList();

        return likes;
    }

    public List<tb_lks_like> find_list_match(UUID user_id) {
        Session session=entity_manager.unwrap(Session.class);

        Query<tb_lks_like> query=session.createQuery("from tb_lks_like l where l.lks_user_id=:lks_user_id and l.lks_match_id!=0");

        query.setParameter("lks_user_id",user_id);

        List<tb_lks_like> likes = query.getResultList();

        return likes;
    }

    public List<tb_usr_user> find_user_male(String usr_gender) {
        Session session = entity_manager.unwrap(Session.class);

        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_gender = :usr_male", tb_usr_user.class);

        query.setParameter("usr_male", usr_gender);

        List<tb_usr_user> users = query.getResultList();

        return users;
    }

    public List<tb_usr_user> find_user_female(String usr_gender) {
        Session session = entity_manager.unwrap(Session.class);

        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_gender = :usr_female", tb_usr_user.class);

        query.setParameter("usr_female", usr_gender);

        List<tb_usr_user> users = query.getResultList();

        return users;
    }

    public List<tb_usr_user> find_user_male_this(String usr_gender, UUID user_id_gender) {
        Session session = entity_manager.unwrap(Session.class);

        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_male = :usr_gender and u.usr_id != :user_id", tb_usr_user.class);

        query.setParameter("usr_male", usr_gender);
        query.setParameter("user_id", user_id_gender);

        List<tb_usr_user> users = query.getResultList();

        return users;
    }

    public List<tb_usr_user> find_user_female_this(String usr_gender, UUID user_id_gender) {
        Session session = entity_manager.unwrap(Session.class);

        Query<tb_usr_user> query = session.createQuery("from tb_usr_user u where u.usr_gender = :usr_female and u.usr_id != :user_id", tb_usr_user.class);

        query.setParameter("usr_female", usr_gender);
        query.setParameter("user_id", user_id_gender);

        List<tb_usr_user> users = query.getResultList();

        return users;
    }

    public List<tb_usr_user> find_user_by_gender_and_age_range(String usr_gender) {
        Session session = entity_manager.unwrap(Session.class);

        String queryString = "from tb_usr_user u where u.usr_gender = :usr_gender";
        Query query = session.createQuery(queryString, tb_usr_user.class);
        query.setParameter("usr_gender", usr_gender);

        query.setFirstResult(0);
        query.setMaxResults(50);

        List<tb_usr_user> users = query.getResultList();
        return users;
    }

    public List<tb_usr_user> find_all() {

        Session session = entity_manager.unwrap(Session.class);

        Query query = session.createQuery("from tb_usr_user");

        List<tb_usr_user> users = query.getResultList();

        return users;
    }

    public List<tb_usr_user> find_all_but_this(UUID user_id) {

        Session session = entity_manager.unwrap(Session.class);

        Query query = session.createQuery("from tb_usr_user u where u.usr_id!=:user_id");

        query.setParameter("user_id",user_id);

        List<tb_usr_user> users = query.getResultList();

        return users;
    }
}

