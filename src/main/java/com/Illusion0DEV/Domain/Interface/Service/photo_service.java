package com.Illusion0DEV.Domain.Interface.Service;

import com.Illusion0DEV.Domain.Entities.tb_pht_photo;
import com.Illusion0DEV.Domain.Interface.Repository.photo_repository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class photo_service {

    photo_repository photo_repository;

    @Transactional
    public List<tb_pht_photo> find_all(){
        return photo_repository.find_all();
    }

    @Transactional
    public void add(tb_pht_photo photo){
        photo_repository.add(photo);
    }

    @Transactional
    public void delete(UUID id){
        photo_repository.delete(id);
    }
}
