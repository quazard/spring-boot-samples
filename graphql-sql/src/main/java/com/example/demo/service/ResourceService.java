package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ResourceService {

  private final PersonRepository personRepository;

  public ResourceService(
      final PersonRepository personRepository
  ) {
    this.personRepository = personRepository;
  }

  public Flux<Person> findAllPersons() {
    // Blocking IO, look for new JPA 2.2 spec
    return Flux.fromIterable(personRepository.findAll());
  }

}
