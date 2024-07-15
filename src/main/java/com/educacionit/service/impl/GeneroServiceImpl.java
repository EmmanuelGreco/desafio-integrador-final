package com.educacionit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.repository.GeneroRepository;
import com.educacionit.service.GeneroService;

@Service("generoService")
public class GeneroServiceImpl implements GeneroService {

	//private static final Logger logger = LoggerFactory.getLogger(GeneroServiceImpl.class);

	@Autowired
	@Qualifier("generoRepository")
	private GeneroRepository generoRepository;
}
