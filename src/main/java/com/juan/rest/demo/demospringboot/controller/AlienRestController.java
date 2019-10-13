package com.juan.rest.demo.demospringboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.rest.demo.demospringboot.model.Alien;
import com.juan.rest.demo.demospringboot.service.AlienService;

/**
 * use http://localhost:8080/aliens/list to start.
 * 
 * @author JuanC
 */
@RestController
@RequestMapping("/aliens")
public class AlienRestController {

	Logger logger = LoggerFactory.getLogger(AlienRestController.class);

	@Autowired
	AlienService alienService;

	@GetMapping("")
	public List<Alien> getAll() {
		logger.debug("getAll");
		List<Alien> aliens = alienService.findAll();
		logger.debug("getAll aliens=[{}]", aliens);
		return aliens;
	}

	@GetMapping("/{id}")
	public Alien getOne(@PathVariable("id") int id) {
		logger.debug("getOne id=[{}]", id);
		Alien alien = alienService.findOne(id);
		logger.debug("getOne alien=[{}]", alien);
		return alien;
	}

	@PostMapping("")
	public Alien save(@RequestBody Alien alien) {
		logger.debug("save alien=[{}]", alien);
		Alien e = alienService.save(alien);
		logger.debug("save alienSaved=[{}]", e);
		return e;
	}

	@PutMapping("")
	public Alien update(@RequestBody Alien alien) {
		logger.debug("update alien=[{}]", alien);
		Alien e = alienService.save(alien);
		logger.debug("update alienUpdated=[{}]", e);
		return e;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		logger.debug("delete id=[{}]", id);
		alienService.delete(id);
		return "deleted";
	}

}
