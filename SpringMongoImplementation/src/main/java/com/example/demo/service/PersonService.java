package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonMongoDB;
import com.example.demo.util.MessageResponse;
import com.example.demo.util.PersonResponse;
import com.example.demo.util.Validator;


@Service
public class PersonService {

	private final PersonMongoDB peopleRepository;
	private final Validator validator;
	private final MessageResponse messageResponse;
	private final PersonResponse personResponse;
	
	private final List<Person> people = new ArrayList<Person>();
	
	@Autowired						
	public PersonService(PersonMongoDB peopleRepository, Validator validator, MessageResponse messageResponse, PersonResponse personResponse) {
		this.peopleRepository = peopleRepository;
		this.validator = validator;
		this.messageResponse = messageResponse;
		this.personResponse = personResponse;
	}

	
	
	public PersonResponse save(Person person) {
		people.clear();
		people.add(person);
		if(validator.name(person.getName())) {
			personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mSuccess(), people);
			person.setId(UUID.randomUUID());
			peopleRepository.save(person);
		}
		else {
			personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mEmptyName(), people);
		}
		return personResponse;
	}
	
	public PersonResponse findAll(){
		List<Person> peopleObtain = peopleRepository.findAll();
		String list = "";
		for(int i = 0; i< peopleObtain.size(); i++) {	
			list += "[" + "Id:     " +  validator.nullS(peopleObtain.get(i).getId().toString())    + ", " +
					      "Name:   " +  validator.nullS(peopleObtain.get(i).getName())  		   + ", " +
					      "Email:  " +  validator.nullS(peopleObtain.get(i).getEmail()) 		   + ", " +
					      "Phone:  " +  validator.nullS(peopleObtain.get(i).getPhone())            +   
					"]";
		}
		personResponse.setPersonResponse(messageResponse.codeSuccess(), list, peopleRepository.findAll());
		return personResponse;
	}
	
	public PersonResponse findById(Person person){
		people.clear();
		if(validator.id(person.getId())) {	
			if(!peopleRepository.findById(person.getId()).isEmpty()) {
				people.add(peopleRepository.findById(person.getId()).orElse(null));
				personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mGetList(), people);
			}
			else {
				people.add(new Person(person.getId(),"-","-","-"));				
				personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mNotExist(), people);				
			}
		}
		else {
			personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mEmptyId(), people);
		}
		return personResponse;		
	}
	
/*	public PersonResponse getPersonByName(Person person){
		people.clear();
		if(validator.name(person.getName())) {	
			if(!personDao.selectPersonByName(person).isEmpty()) {
				people.add(personDao.selectPersonByName(person).orElse(null));
				personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mGetList(), people);
			}
			else {
				personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mNotExist(), people);				
			}
		}
		else {
			personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mEmptyName(), people);
		}
		return personResponse;		
	}
	*/
	
	
	public PersonResponse delete(Person person) {
		people.clear();
		people.add(person);
		if(validator.id(person.getId())) {		
			if(!peopleRepository.findById(person.getId()).isEmpty()) {
				peopleRepository.delete(person);
				personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mSuccess(), people);
			}
			else {
				personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mNotExist(), people);
			}
		}
		else {
			personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mEmptyId(), people);
		}
		return personResponse;
	}
	


	public PersonResponse deleteAll() {
		people.clear();
		peopleRepository.deleteAll();
		personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mSuccess(), people);
		return personResponse;
	}
	

	public PersonResponse update(Person newperson) {
		people.clear();
		people.add(newperson);
		if(validator.id(newperson.getId())) {		
			if(validator.name(newperson.getName())) {
				if(!peopleRepository.findById(newperson.getId()).isEmpty()) {
					peopleRepository.save(newperson);
					personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mSuccess(), people);
				}
				else {
					personResponse.setPersonResponse(messageResponse.codeSuccess(), messageResponse.mNotExist(), people);
				}
			}
			else {
				personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mEmptyName(), people);
			}
		}
		else {
			personResponse.setPersonResponse(messageResponse.codeError(), messageResponse.mEmptyId(), people);
		}
		return personResponse;
	}


	
	
	

	
	
	
}
