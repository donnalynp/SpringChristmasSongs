package com.qa.christmassongs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.christmassongs.domain.ChristmasSong;
import com.qa.christmassongs.repository.ChristmasSongRepo;

@Service
public class ChristmasSongService implements ServiceMethods<ChristmasSong> {

	private ChristmasSongRepo repo;
	
	//Constructor
	public ChristmasSongService(ChristmasSongRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public ChristmasSong create(ChristmasSong christmassong) {
		return this.repo.save(christmassong);
	}

	@Override
	public List<ChristmasSong> getAll() {	
		return this.repo.findAll();
	}

	@Override
	public ChristmasSong getById(long id) {
		Optional<ChristmasSong> optionalChristmasSong = this.repo.findById(id);
		if(optionalChristmasSong.isPresent()) {
			return optionalChristmasSong.get();
		}	
		return null;
	}

	@Override
	public ChristmasSong update(long id, ChristmasSong christmassong) {
		Optional<ChristmasSong> existingSong = this.repo.findById(id);
		if (existingSong.isPresent()) {
			ChristmasSong existing = existingSong.get();
			existing.setArtist(christmassong.getArtist());
			existing.setTitle(christmassong.getTitle());
			existing.setYear(christmassong.getYear());
			
			return this.repo.saveAndFlush(existing);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	
	
}
