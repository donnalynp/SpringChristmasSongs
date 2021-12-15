package com.qa.christmassongs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.christmassongs.domain.ChristmasSong;
import com.qa.christmassongs.service.ChristmasSongService;



@RestController
@RequestMapping("/christmasSong")
public class ChristmasSongController {

	private ChristmasSongService service;
	
	private ChristmasSongController(ChristmasSongService service) {
		this.service = service;
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<ChristmasSong> createChristmasSong(@RequestBody ChristmasSong christmassong) {
		return new ResponseEntity<ChristmasSong>(this.service.create(christmassong), HttpStatus.CREATED);
	}
	
	//Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<ChristmasSong>> readAllChristmasSongs() {
		return new ResponseEntity<List<ChristmasSong>>(this.service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<ChristmasSong> readChristmasSongById(@PathVariable long id){
		return new ResponseEntity<ChristmasSong>(this.service.getById(id), HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<ChristmasSong> updateChristmasSong(@PathVariable long id, @RequestBody ChristmasSong christmassong) {
		return new ResponseEntity<ChristmasSong>(this.service.update(id, christmassong), HttpStatus.ACCEPTED);
	}
		
	
	//Delete  
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteChristmasSong(@PathVariable long id){
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}





