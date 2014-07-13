package fr.exemple.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.exemple.test.model.repository.TestRepository;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestRepository repository;
	

	@RequestMapping(method=RequestMethod.GET)
    public void sharedCustomMethodTest() {
    	repository.sharedCustomMethod("Hello World !");
    }
}
