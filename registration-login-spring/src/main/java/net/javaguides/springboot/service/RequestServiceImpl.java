package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Request;
import net.javaguides.springboot.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService{

	@Autowired
	private RequestRepository requestRepository;
	
	@Override
	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}

	@Override
	public void saveRequest(Request request) {
		this.requestRepository.save(request);
		
	}

	@Override
	public Request getRequestById(long id) {
		Optional<Request> optional = requestRepository.findById(id);
		Request request = null;
		if(optional.isPresent()) {
			request = optional.get();
		}else {
			throw new RuntimeException("Request not found for id ::"+id);
			
		}
		return request;
	}

	@Override
	public void deleteRequestById(long id) {
		this.requestRepository.deleteById(id);
		
	}

}
