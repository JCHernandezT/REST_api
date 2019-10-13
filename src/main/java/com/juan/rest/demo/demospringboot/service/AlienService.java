package com.juan.rest.demo.demospringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.rest.demo.demospringboot.dao.AlienRepo;
import com.juan.rest.demo.demospringboot.model.Alien;

@Service
public class AlienService {

	Logger logger = LoggerFactory.getLogger(AlienService.class);

	@Autowired
	private AlienRepo alienRepo;

	public List<Alien> findAll() {
		logger.debug("findAll");
		Iterable<Alien> it = alienRepo.findAll();
		List<Alien> list = new ArrayList<Alien>();
		it.forEach(instance -> list.add(instance));
		logger.debug("findAll list=[{}]", list);
		return list;
	}

	public Alien findOne(int id) {
		logger.debug("findOne id=[{}]", id);
		Alien alien = new Alien();
		Optional<Alien> entity = alienRepo.findById(id);
		if (entity.isPresent()) {
			alien = entity.get();
		}
		logger.debug("findOne alien=[{}]", alien);
		return alien;
	}

	public Alien save(Alien alien) {
		logger.debug("save alien=[{}]", alien);
		Alien alienSaved = alienRepo.save(alien);
		logger.debug("save alienSaved=[{}]", alienSaved);
		return alienSaved;
	}

	public void delete(int id) {
		logger.debug("delete id=[{}]", id);
		alienRepo.deleteById(id);
		logger.debug("deleted id=[{}]", id);
	}

}
