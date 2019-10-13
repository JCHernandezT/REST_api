package com.juan.rest.demo.demospringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juan.rest.demo.demospringboot.model.Alien;

@Repository
public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
