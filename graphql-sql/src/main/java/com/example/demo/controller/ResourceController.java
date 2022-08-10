package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.ResourceService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ResourceController {

  private final ResourceService resourceService;

  public ResourceController(
      final ResourceService resourceService
  ) {
    this.resourceService = resourceService;
  }

  @QueryMapping
  public List<Person> allPersons() {
    return resourceService.findAllPersons();
  }

  @QueryMapping
  public Optional<Person> person(@Argument Integer id) {
    return resourceService.findById(id);
  }

}
