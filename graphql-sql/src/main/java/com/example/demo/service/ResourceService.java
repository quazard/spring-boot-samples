package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
