package com.qa.christmassongs.service;

import java.util.List;

public interface ServiceMethods<T> {

	//Create
	T create(T t);
	
	//Read All
	List<T> getAll();
	
	//Read by Id
	T getById(long id);
	
	//Update
	T update(long id, T t);
	
	//Delete
	boolean delete(long id);

}
