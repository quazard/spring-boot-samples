package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

  private final PersonRepository personRepository;

  public ResourceService(
      final PersonRepository personRepository
  ) {
    this.personRepository = personRepository;
  }

  public List<Person> findAllPersons() {
    return personRepository.findAll();
  }

  public Optional<Person> findById(Integer id){
    return personRepository.findById(id);
  }

}
