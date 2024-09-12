package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Request;

public interface RequestService {
	
	List<Request> getAllRequests();
	
	void saveRequest(Request request);
	
	Request getRequestById(long id);
	
	void deleteRequestById(long id);

}
