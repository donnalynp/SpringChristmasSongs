package com.qa.christmassongs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.christmassongs.domain.ChristmasSong;

public interface ChristmasSongRepo extends JpaRepository<ChristmasSong, Long>{

}
